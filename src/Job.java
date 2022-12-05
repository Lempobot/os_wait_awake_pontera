public class Job {

    final private long MINIMUM_WAIT_TIME_FOR_JOB = 0;
    public void sleep(long ms)  {
        if(ms < MINIMUM_WAIT_TIME_FOR_JOB){ //Waiting time can't be negative.
            ms = MINIMUM_WAIT_TIME_FOR_JOB;
        }
        OS.sleep(this, ms);
    }

}