package co.altruix.scheduler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;



import at.silverstrike.pcc.api.model.UserData;
import at.silverstrike.pcc.api.persistence.Persistence;
import at.silverstrike.pcc.impl.persistence.DefaultPersistence;



public class SimpleQuartzJob implements Job {

	public SimpleQuartzJob() {
	}

	public void execute(JobExecutionContext context) {
		try {
			System.out.println("In SimpleQuartzJob - executing its JOB at "
					+ new Date() + " by " + context.getTrigger().getName());

			
			Persistence perstience = new DefaultPersistence();
			
			
		} catch (Exception e) {
			System.out.println("Error - " + e.toString());
		}
	}
}
