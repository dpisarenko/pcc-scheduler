package co.altruix.scheduler.impl.scheduledrecalculation;

import java.util.List;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.altruix.commons.api.di.PccException;

import com.google.inject.Injector;

import co.altruix.pcc.api.outgoingqueuechannel.OutgoingQueueChannel;
import co.altruix.pcc.impl.cdm.DefaultImmediateSchedulingRequest;
import co.altruix.scheduler.api.scheduledrecalculation.ScheduledRecalculationJob;

import at.silverstrike.pcc.api.model.UserData;
import at.silverstrike.pcc.api.persistence.Persistence;

public class DefaultScheduledRecalculationJob implements Job {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(DefaultScheduledRecalculationJob.class);

    public DefaultScheduledRecalculationJob() {
    }

    public void execute(final JobExecutionContext aContext) {
        final JobDataMap jobDataMap = aContext.getMergedJobDataMap();
        final Injector injector =
                (Injector) jobDataMap
                        .get(ScheduledRecalculationJob.INJECTOR);
        final Persistence persistence =
                injector.getInstance(Persistence.class);
        final OutgoingQueueChannel channel =
                (OutgoingQueueChannel) jobDataMap
                        .get(ScheduledRecalculationJob.CHANNEL);
        final Session session =
                (Session) jobDataMap
                        .get(ScheduledRecalculationJob.SESSION);

        final List<UserData> users = persistence
                .getAllusersWithAutomaticScheduling();
        if (users != null) {
            for (final UserData curUser : users) {
                final DefaultImmediateSchedulingRequest message =
                        new DefaultImmediateSchedulingRequest();
                message.setUserId(curUser.getId());

                try {
                    final ObjectMessage objectMessage =
                            session.createObjectMessage(message);
                    channel.send(objectMessage);
                } catch (final JMSException exception) {
                    LOGGER.error("", exception);
                } catch (final PccException exception) {
                    LOGGER.error("", exception);
                }
            }
        }
    }
}
