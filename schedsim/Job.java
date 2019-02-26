/*
This class holds one 'job' for the simulation.  Each job exists in some
CPU queue (ready, blocked, running, and several others).  The scheduler's
duty is to move jobs from queue to queue as the simulation proceeds.
 */

public class Job
{
    // The following pointers are used to form the doubly-linked list in the
    // queue.  There is also a pointer to the queue that currently holds
    // the job.
    private Job _next;
    private Job _prev;
    private Queue _queue;

    // Jobs have ID numbers for debugging
    private int _id;

    // The estimated time to complete this job
    private int _estimatedLength;

    // How much 'compute time' has gone toward this job
    private int _computeTime;

    // The priority of this job.  For multiple queue scheduling, this will
    // change over time, so the _curPriority is the current, changing priority.
    private int _priority;
    private int _curPriority;

    // This job may have a list of times where it becomes blocked for I/O.
    // This is an array of integers: when the computeTime matches one
    // of these values, the job becomes blocked.
    private int[] _blockTimes;

    // Is this job done?
    private boolean _done;

    // At what time did this job start?
    private int _startTime;

    // At what time did this job complete?
    private int _endTime;

    // If this job is blocked for I/O, how much time is left in the block?
    // If this job is not blocked, the value will be 0.
    private int _block;

    // For the cases where we have the 'answer', at what time did the 'answer'
    // end this job?
    private int _answerEndTime;

    // Create a new Job
    public Job(int ID, int curTime, int length, int numBlocks, int priority, int answerEndTime)
    {
        _id = ID;
        _next = null;
        _prev = null;
        _queue = null;
        _estimatedLength = length;
        _computeTime = 0;
        _priority = priority;
        _curPriority = priority;
        if (numBlocks == 0)
        {
            _blockTimes = new int[1];
            _blockTimes[0] = -1;
        }
        else
        {
            _blockTimes = new int[numBlocks];
            int i;
            for (i = 0; i < numBlocks; i++)
            {
                _blockTimes[i] = -1;
            }
        }
        _done = false;
        _startTime = curTime;
        _endTime = -1;
        _answerEndTime = answerEndTime;
        _block = 0;
    }

    public Job(int ID, int curTime, int length, String blocks, int priority, int answerEndTime)
    {
        _id = ID;
        _next = null;
        _prev = null;
        _queue = null;
        _estimatedLength = length;
        _computeTime = 0;
        _priority = priority;
        _curPriority = priority;
        _done = false;
        _startTime = curTime;
        _endTime = -1;
        _answerEndTime = answerEndTime;
        _block = 0;
        int numBlocks = 1;
        int len = blocks.length();
        for (int i = 0 ; i < len; i++)
        {
            char ch = blocks.charAt(i);
            if (ch == ',')
            {
                numBlocks++;
            }
        }
        _blockTimes = new int[numBlocks];
        numBlocks = 0;
        int time = 0;
        for (int i = 0; i < len; i++)
        {
            char ch = blocks.charAt(i);
            if (ch == ',')
            {
                _blockTimes[numBlocks++] = time;
                time = 0;
            }
            else if (ch >= '0' && ch <= '9')
            {
                time = 10 * time + ch - '0';
            }
        }
        _blockTimes[numBlocks++] = time;
    }

    // Set one of the block times for this Job.  Find an unset slot (its value is -1) and
    // place this value there.
    public void setBlock(int time)
    {
        int len = _blockTimes.length;
        int i;
        for (i = 0 ; i < len; i++)
        {
            if (_blockTimes[i] < 0)
            {
                _blockTimes[i] = time;
                return;
            }
        }
        _blockTimes[0] = time;
    }

    // Remove the job from its current queue
    public void dequeue()
    {
        // If this job has a _prev value, there is a job before
        // this one in the queue.  Hence, we will tell that job
        // to point around us.  If there is NO job before this one,
        // this must be the first job in the queue, in which case
        // we will tell the queue to use the next job as the first.
        if (_prev != null)
        {
            _prev._next = _next;
        }
        else if (_queue != null)
        {
            _queue.setFirst(_next);
        }

        // In a similar way we update the _next, either pointing
        // around this job or changing the queue's last job pointer.
        if (_next != null)
        {
            _next._prev = _prev;
        }
        else if (_queue != null)
        {
            _queue.setLast(_prev);
        }

        // Now clear the three pointers for this job: the job is
        // no longer a part of that queue.
        _prev = null;
        _next = null;
        _queue = null;
    }

    // Add the job to the start of a queue
    public void enqueueStart(Queue queue)
    {
        // If already in a queue, remove it
        if (_queue != null)
        {
            dequeue();
        }

        // Grab the first job in the queue.  If there is one, have it point
        // back to this new job.  If there is NOT a job currently in the
        // queue, this becomes the queue's LAST job (it will also become the
        // queue's FIRST job, but that's in a few lines).
        _next = queue.first();
        if (_next != null)
        {
            _next._prev = this;
        }
        else
        {
            queue.setLast(this);
        }

        // Since this will be the first job in the queue, the _prev pointer
        // will be null.  Also point to the queue, and have this job be the
        // queue's first job.
        _prev = null;
        _queue = queue;
        queue.setFirst(this);
    }

    // Add the job to the end of a queue
    public void enqueueEnd(Queue queue)
    {
        // If already in a queue, remove it
        if (_queue != null)
        {
            dequeue();
        }

        // Grab the last job in the queue.  If there is one, have it point
        // forward to this new job.  If there is NOT a job currently in the
        // queue, this becomes the queue's FIRST job (it will also become the
        // queue's LAST job, but that's in a few lines).
        _prev = queue.last();
        if (_prev != null)
        {
            _prev._next = this;
        }
        else
        {
            queue.setFirst(this);
        }

        // Since this will be the last job in the queue, the _next pointer
        // will be null.  Also point to the queue, and have this job be the
        // queue's last job.
        _next = null;
        _queue = queue;
        queue.setLast(this);
    }

    ///// Getters and Setters /////
    public int id() { return _id; }
    public Job next() { return _next; }
    public Job prev() { return _prev; }
    public int estimatedLength() { return _estimatedLength; }
    public int timeLeft() { return _estimatedLength - _computeTime; }
    public int priority() { return _priority; }
    public int curPriority() { return _curPriority; }
    public void decPriority() { _curPriority--; }
    public boolean done() { return _done; }
    public int startTime() { return _startTime; }
    public int endTime() { return _endTime; }
    public int answerEndTime() { return _answerEndTime; }
    public void setEndTime(int time) { _endTime = time; }
    public int computeTime() { return _computeTime; }
    public int elapsedTime() { return _endTime - _startTime; }
    public int answerElapsedTime() { return _answerEndTime - _startTime; }
    public boolean blocked() { return _block > 0; }

    ///// These should only be called by the 'engine' /////

    // This is called if the job is currently the running job.  It
    // increments the compute time, checks to see if the job is done
    // running, and checks to see if the job should be blocked.
    public void computeOneCycle(int curTime)
    {
        // TBD: Print an error message if we are done -- we should not still be
        // in the processor!

        // TBD: Print an error message if we are blocked -- we should be in the
        // blocked queue!

        _computeTime++;

        // See if we are done
        if (_computeTime >= _estimatedLength)
        {
            _done = true;
            _endTime = curTime;
        }

        // See if we should block
        int len = _blockTimes.length;
        int i;
        for (i = 0 ; i < len; i++)
        {
            if (_blockTimes[i] == _computeTime)
            {
                _block += 5;   // Block for a period of time
                break;
            }
        }
    }

    // This is called if the job is in the CPU's blocked queue.  It
    // decrements the block counter.  When this counter gets to 0, the
    // CPU will move this from the blocked queue to the unblocked queue.
    public void decrementBlock()
    {
        if (_block > 0)
        {
            _block--;
        }
    }

    // Print the information about this job.
    public void printAnswer()
    {
        System.out.print("cpu.addJob(" + _id + ", " + _startTime + ", " + _estimatedLength + ", \"");
        int len = _blockTimes.length;
        if (len > 0)
        {
            for (int i = 0 ; i < len; i++)
            {
                if (i > 0)
                {
                    System.out.print(",");
                }
                System.out.print("" + _blockTimes[i]);
            }
        }
        System.out.println("\", " + _priority + ", " + _endTime + ");");
    }
}
