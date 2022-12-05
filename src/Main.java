import java.util.Random;


// Main to test the code.
public class Main {
    public static void main(String[] args) {

        Job[] jobs = {new Job(), new Job(), new Job()};

        try {
            for(Job job:jobs) {
                job.sleep(Math.abs(new Random().nextLong() / 1000000000));
            }
        }
        catch (Exception e){
            System.out.println("Must be integer");
        }

       // try {
       //     jobs[0].sleep(-5);
       //     jobs[1].sleep(1);
       //     jobs[2].sleep(7);
       // }catch (Exception e){
        //
       // }

        System.out.println(jobs[0] + "," + jobs[1] + "," + jobs[2]);
        System.out.println(OS.getSleepingJobs());
        OS.awake();
        for(JobAndTimePair pair: OS.getRunningJobs()){
            System.out.println(pair.getJob() + "," + pair.getTime());
        }
    }
}