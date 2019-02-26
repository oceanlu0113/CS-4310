package mmu;

public class MMU_ApproximateLRU extends MMU {

    // This is a parallel array to the inverse page table: we only need as
    // many entries as physical pages.  This stores the 'R' bits, a 6-bit field.
    public int[] RBits;

    MMU_ApproximateLRU(Tester theTester, int addrBits, int pageSize, int numPages) {
        super(theTester, addrBits, pageSize, numPages);
        RBits = new int[numPhysicalPages];
    }

    public String algName() {
        return "Approximate LRU";
    }

    public int accessMemory(int virtualAddress, AccessType type) {
        // Get the index of the page, which are the upper bits of the virtual address
        int virtualIndex = virtualAddress >> pageBits;

        // The page index (which is the part that bypasses the mmu) are the
        // lower bits:
        int pageIndex = virtualAddress - (virtualIndex << pageBits);

        // If this page is NOT swapped in, we will need to swap it in
        if (!presentBits[virtualIndex])
        {
            tester.pageFault();
            int bestIndex = 0;
            int bestValue = RBits[0];
            for(int i = 1; i< numPhysicalPages; i++)
            {
                if(RBits[i]< bestValue)
                {
                    bestValue =RBits[i];
                    bestIndex = i;
                }
            }
            // We will need to load the data into physical memory.  Since
            // this is the FIFO algorithm, we will simply overwrite the
            // page at the current index.

            // Before we load data into this location, check to make sure
            // that any old data that is dirty is written out.
            if (inversePresent[bestIndex])
            {
                int oldVirtual = inverseTable[bestIndex];
                if (dirtyBits[oldVirtual])
                {
                    // The old page was dirty, so we have to write it out.
                    tester.flushPage(oldVirtual, bestIndex);
                    dirtyBits[oldVirtual] = false;
                }
                pageTable[oldVirtual] = 0;
                presentBits[oldVirtual] = false;
            }

            // Read the new data in
            tester.fillPage(virtualIndex, bestIndex);

            // Link the tables
            pageTable[virtualIndex] = bestIndex;
            presentBits[virtualIndex] = true;
            dirtyBits[virtualIndex] = false;
            inverseTable[bestIndex] = virtualIndex;
            inversePresent[bestIndex] = true;
            RBits[bestIndex] = 0;
            // Now move the fifo ahead

        }

        // At this point, the page should be swapped in.  We now return the
        // physical address.  However, if we are doing a WRITE operation,
        // we must first set the dirty bit.
        if (type == AccessType.WRITE)
        {
            dirtyBits[virtualIndex] = true;
        }
        RBits[pageTable[virtualIndex]] |= 32 ;
        return (pageTable[virtualIndex] << pageBits) + pageIndex;
    }

    // This routine is called to clear the 'R' bits.  This actually shifts all the
    // RBits right by 1
    public void clearRBits() {
        for (int i = 0; i < numPhysicalPages; i++) {
            RBits[i] >>= 1;
        }
    }
}
