package co.altruix.scheduler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.List;

import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import co.altruix.pcc.impl.cdm.DefaultImmediateSchedulingRequest;




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
			
			Persistence persistence = new DefaultPersistence();
			persistence.openSession(Persistence.HOST_LOCAL, null, null, Persistence.DB_PRODUCTION);
			List<UserData> users    = persistence.getAllusersWithAutomaticScheduling();	            
			
			for(UserData user: users){
				DefaultImmediateSchedulingRequest message = new DefaultImmediateSchedulingRequest();
				message.setUserId( user.getId() );
				
				this.requestMessage(message);
			}			
		} catch (Exception e) {
			System.out.println("Error - " + e.toString());
		}
	}
	
	private void requestMessage(DefaultImmediateSchedulingRequest message){
		Session session = null;
		javax.jms.Connection connection = null;
		try {
			final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
					"", "", "failover://tcp://localhost:61616");

			// Create a Connection
			connection = connectionFactory.createConnection();
			connection.start();

			// Create a Session
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// Create the destination (Topic or Queue)
			final Destination destination = session
					.createQueue("PCC.WEB.WORKER");

			// Create a MessageProducer from the Session to the Topic or Queue
			final MessageProducer producer = session
					.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);

			final ObjectMessage objectMessage = session
					.createObjectMessage(message);
			producer.send(objectMessage);

			// Clean up
			session.close();
			connection.close();

		} catch (final JMSException exception) {

		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (final JMSException exception) {
					
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (final JMSException exception) {
					
				}
			}
		}		
	}
	
	
}
