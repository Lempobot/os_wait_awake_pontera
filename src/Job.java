public class Job {

    // Add additional functions and data members as you find fit

    // A function for sleep which called by a job
    public void sleep(long ms)  {
        OS.sleep(this, ms);
    }

}