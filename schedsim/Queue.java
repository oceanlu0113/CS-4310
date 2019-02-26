/*
This implements a fairly simple Queue.  These are usually first-in, first-out,
although there are routines to support priority or shortest-job mechanisms, which
pull jobs from the middle of the queue.

Note that these queues are different from the traditional queue:  The next pointers
are actually in the job class, and the job points to the queue which contains the
job.  This means that a job can only be in one queue at a time (which is exactly
what we want for our simulation).  For a traditional queue, there would not be the
pointers in the object, and the queue would have a sub-structure used for forming
the lists.  This would also allow a job to exist in multiple queues, and by using
templates, the Queue class could be used for any type of data.  However, these
features are not important for our example, and we really do want jobs to only be
in a single queue.

Consequently, the job has a dequeue function, which pulls the job out of its existing
queue (along with priority and size related versions), and it has functions for
placing the job into a queue.  Actually, the routine for placing a job into a queue
will also remove the job from its existing queue if necessary.

The routine here for pulling the job from the queue allows any job to be pulled from
the queue.  It doesn't have to be the first or last job, it can be any job.
 */

public class Queue
{
    private Job _firstJob;
    private Job _lastJob;

    public Queue()
    {
        _firstJob = null;
        _lastJob = null;
    }

    // Getters:
    public Job first() { return _firstJob; }
    public Job last() { return _lastJob; }
    public boolean empty() { return _firstJob == null; }

    // Setters -- these should only be called by the Job
    public void setFirst(Job job) { _firstJob = job; }
    public void setLast(Job job) { _lastJob = job; }

    // This scans the queue looking for the job with the highest priority,
    // which is returned.  If there are multiple jobs with the highest
    // priority, the routine returns the one that is nearest the start of
    // the list.  This routine may return null, indicating that there are
    // no jobs in the queue.
    public Job highestPriorityJob()
    {
      if (_firstJob == null)
      {
        return null;
      }
      Job best = null;
      int bestPriority = -999;
      for (Job job = _firstJob; job != null; job = job.next())
      {
          int curPriority = job.priority();
          if (best == null || curPriority > bestPriority)
          {
              best = job;
              bestPriority = curPriority;
          }
      }
      return best;
    }

    // This scans the queue, looking for the job with the smallest
    // remaining execution time.  If there are multiple jobs with
    // the smallest time, the routine returns the job closest to the
    // start of the queue.  The routine may return null, which
    // indicates that there are no jobs left in the queue.
    public Job shortestJob()
    {
      if (_firstJob == null)
      {
        return null;
      }
      Job best = null;
      int bestLength = 9999999;
      for (Job job = _firstJob; job != null; job = job.next())
      {
          int curLen = job.timeLeft();
          if (best == null || curLen < bestLength)
          {
              best = job;
              bestLength = curLen;
          }
      }
      return best;
    }
}
