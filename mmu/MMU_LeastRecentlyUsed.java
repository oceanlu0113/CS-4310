package mmu;

public class MMU_LeastRecentlyUsed extends MMU {

    // This is a parallel array to the inverse page table: we only need as
    // many entries as physical pages.  This stores the 'count' at the last
    // time this page was referenced.
    public int[] lastRefCount;

    // This is the 'timer', it gets incremented on each reference.
    private int counter;

    MMU_LeastRecentlyUsed(Tester theTester, int addrBits, int pageSize, int numPages) {
        super(theTester, addrBits, pageSize, numPages);
        counter = 1;
        lastRefCount = new int[numPhysicalPages];
    }

    public String algName() {
        return "Least Recently Used";
    }

    public int accessMemory(int virtualAddress, AccessType type) {
        counter++;
        // Get the index of the page, which are the upper bits of the virtual address
        int virtualIndex = virtualAddress >> pageBits;

        // The page index (which is the part that bypasses the mmu) are the
        // lower bits:
        int pageIndex = virtualAddress - (virtualIndex << pageBits);

        // If this page is NOT swapped in, we will need to swap it in
        if (presentBits[virtualIndex] == false) {
            tester.pageFault();

            int bestIndex = 0;
            int bestCount = lastRefCount[0];
            for (int i = 1; i < numPhysicalPages; i++) {
                if (lastRefCount[i] < bestCount) {
                    bestCount = lastRefCount[i];
                    bestIndex = i;
                }
            }

            // We will need to load the data into physical memory.  Since
            // this is the FIFO algorithm, we will simply overwrite the
            // page at the current index.
            // Before we load data into this location, check to make sure
            // that any old data that is dirty is written out.
            if (inversePresent[bestIndex]) {
                int oldVirtual = inverseTable[bestIndex];
                if (dirtyBits[oldVirtual]) {
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

            // Now move the fifo ahead
            bestIndex++;
            if (bestIndex >= numPhysicalPages) {
                bestIndex = 0;
            }
        }

        // At this point, the page should be swapped in.  We now return the
        // physical address.  However, if we are doing a WRITE operation,
        // we must first set the dirty bit.
        if (type == AccessType.WRITE) {
            dirtyBits[virtualIndex] = true;
        }
        lastRefCount[pageTable[virtualIndex]] = counter;
        return (pageTable[virtualIndex] << pageBits) + pageIndex;
    }
}
