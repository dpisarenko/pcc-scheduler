package co.altruix.scheduler;

import java.sql.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
     throws SchedulerException
    {

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();

        Scheduler scheduler = schedulerFactory.getScheduler();
        

        long ctime = System.currentTimeMillis(); 

        JobDetail jobDetail = 
        	new JobDetail("jobDetail-s1", "jobDetailGroup-s1", SimpleQuartzJob.class);

        SimpleTrigger simpleTrigger = 
        	new SimpleTrigger("simpleTrigger", "triggerGroup-s1");
  
        simpleTrigger.setStartTime(new Date(ctime));
       
        simpleTrigger.setRepeatInterval(10000);

        simpleTrigger.setRepeatCount(100);

        scheduler.scheduleJob(jobDetail, simpleTrigger);

        scheduler.start();
    }
}
