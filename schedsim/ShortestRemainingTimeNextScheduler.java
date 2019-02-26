public class ShortestRemainingTimeNextScheduler extends Scheduler
{
    public ShortestRemainingTimeNextScheduler(Processor theCPU)
    {
        super(theCPU);
    }

    public String algName() { return "Shortest Remaining Time Next Scheduler"; }

    // This function does the scheduling work!
    public void tick()
    {
      Job job;
        
        // If there were any jobs that used to be blocked, but no longer are,
        // move them from the unblockedQueue to the end of the readyQueue.
        //If job in readyQueue has less timeLeft than current job, replace
        Job currentJob = cpu.currentJob.first();
        for (job = cpu.unblockedQueue.first(); job != null; job = cpu.unblockedQueue.first()){
            if ((currentJob != null) && (job.timeLeft() < currentJob.timeLeft())) {
                currentJob.enqueueEnd(cpu.readyQueue);
                job.enqueueStart(cpu.currentJob);
                currentJob = job;
            } else {
                job.enqueueEnd(cpu.readyQueue);
            }
        }

        // If there are any new jobs being added to the processor, move them
        // from the newJobQueue to the end of the readyQueue.
        for (job = cpu.newJobQueue.first(); job != null; job = cpu.newJobQueue.first()){
            if ((currentJob != null) && (job.timeLeft() < currentJob.timeLeft())) {
                currentJob.enqueueEnd(cpu.readyQueue);
                job.enqueueStart(cpu.currentJob);
                currentJob = job;
            } else {
                job.enqueueEnd(cpu.readyQueue);
            }
        }

        // Check the job in the cpu (if any).  If it is done, move it to the done queue,
        // and if it is blocked, move it to the blocked queue.
        job = cpu.currentJob.first();
        if (job != null){
            if (job.done()){
                job.enqueueEnd(cpu.doneQueue);
            }
            else if (job.blocked()){
                job.enqueueEnd(cpu.blockedQueue);
            }
        }

        // If the CPU is ready for a new job, start that job
        if (cpu.currentJob.empty()){
            Job checkJob;
            job = cpu.readyQueue.first();
            if (job != null){
                checkJob = job.next();
                while (checkJob != null) {
                    if (job.timeLeft() > checkJob.timeLeft()) {
                        job = checkJob;
                    }
                    checkJob = checkJob.next();
                }
                job.enqueueStart(cpu.currentJob);
            }
        }
    }

    public void testCase1(Processor cpu)
    {
        cpu.addJob(1, 1, 50, "10,20,30,40", 1, 138);
        cpu.addJob(2, 1, 30, "7,15,22", 3, 83);
        cpu.addJob(3, 1, 20, "6,14", 2, 31);
        cpu.addJob(4, 1, 20, "6,14", 3, 50);
    }

    public void testCase2(Processor cpu)
    {
        cpu.addJob(1, 0, 30, "9,18,27", 4, 59);
        cpu.addJob(2, 1, 20, "3,6,9,12,15", 5, 46);
        cpu.addJob(3, 2, 30, "5,10,15,20,25", 2, 187);
        cpu.addJob(4, 21, 21, "20", 4, 78);
        cpu.addJob(5, 42, 29, "28", 3, 204);
        cpu.addJob(6, 71, 18, "5,10,15", 3, 106);
        cpu.addJob(7, 89, 13, "4,8,12", 4, 124);
        cpu.addJob(8, 102, 19, "4,8,12,16", 2, 148);
        cpu.addJob(9, 121, 19, "9,18", 1, 162);
        cpu.addJob(10, 140, 26, "6,12,18,24", 1, 245);
    }
}
