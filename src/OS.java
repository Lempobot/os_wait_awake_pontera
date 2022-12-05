import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;


public class OS {

    private static final long MINIMUM_TIME_TO_WAIT = 1;
    private static final long JOB_WAKES_UP_ON_MILISECONDS = 0;
    private static PriorityQueue<JobAndTimePair> sleepingJobs = new PriorityQueue<JobAndTimePair>();
    private static List<JobAndTimePair> runningJobs = new LinkedList<JobAndTimePair>();

    public static PriorityQueue<JobAndTimePair> getSleepingJobs() {
        return sleepingJobs;
    }

    public static List<JobAndTimePair> getRunningJobs() {
        return runningJobs;
    }

    /**
     * Should put the job in the 'sleepingJobs' data structure.
     * @param job
     * @param milliSeconds
     */
    public static void sleep(Job job, long milliSeconds) {
        JobAndTimePair<Job, Long> priorityQueueElement = new JobAndTimePair<>(job, milliSeconds);
        sleepingJobs.add(priorityQueueElement);
    }

    /**
     * Should move the jobs from 'sleepingJobs' to 'runningJobs' when the time to sleep is up.
     */
    public static void awake() {
        wasteJobSleepTime();
    }

    private static void wasteJobSleepTime() {
        if(sleepingJobs.isEmpty()){
            System.out.println("No more sleeping jobs");
        }
        else {
            iterateOverPriorityQueue();
            awake();
        }
    }

    private static void iterateOverPriorityQueue(){
        Iterator<JobAndTimePair> priorityQueueIterator = sleepingJobs.iterator();
        long timeToRemoveFromSleep = sleepingJobs.peek().getTime();
        while(priorityQueueIterator.hasNext()){
            JobAndTimePair pair = priorityQueueIterator.next();
            if(pair.getTime() == JOB_WAKES_UP_ON_MILISECONDS){
                runningJobs.add(sleepingJobs.peek());
                priorityQueueIterator.remove();
            }
            else{
                pair.setTime(pair.getTime() - Math.max(timeToRemoveFromSleep, MINIMUM_TIME_TO_WAIT));
            }
        }
    }
}
