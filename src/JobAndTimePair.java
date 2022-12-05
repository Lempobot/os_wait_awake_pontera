public class JobAndTimePair<Job, Long> implements Comparable{
    private Job job;
    private long time;

    public JobAndTimePair(Job job, long time) {
        this.job = job;
        this.time = time;
    }


    public Job getJob()	{
        return job;
    }
    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public int compareTo(Object o) {
        JobAndTimePair pair = (JobAndTimePair) o;
        if (this.time > pair.time)
            return 1;
        else if (this.time < pair.time)
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "JobAndTimePair{" +
                "job=" + job +
                ", time=" + time +
                '}';
    }
}

