package co.altruix.scheduler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.Properties;

import javax.jms.Session;

import org.apache.commons.io.IOUtils;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.altruix.commons.api.di.PccException;

import at.silverstrike.pcc.api.persistence.Persistence;
import co.altruix.pcc.api.mq.MqInfrastructureInitializer;
import co.altruix.pcc.api.mq.MqInfrastructureInitializerFactory;
import co.altruix.scheduler.impl.di.DefaultPccSchedulerInjectorFactory;

import com.google.inject.Injector;

public final class PccSchedulerApp {
    private static final String CONFIG_FILE = "conf.properties";
    private static final Logger LOGGER = LoggerFactory
            .getLogger(PccSchedulerApp.class);

    public void run() {
        try {
            final Properties config = readConfig();

            final Injector injector = initDependencyInjector();

            final Persistence persistence =
                    injector.getInstance(Persistence.class);
            persistence.openSession(Persistence.HOST_LOCAL, null, null,
                    Persistence.DB_PRODUCTION);

            
            final String brokerUrl = config.getProperty("brokerUrl");
            final String username = config.getProperty("username");
            final String password = config.getProperty("password");

//            final MqInfrastructureInitializer mqInitializer =
//                    initMq(injector, brokerUrl, username, password);

//            final Session session = mqInitializer.getSession();

            
            
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();

            Scheduler scheduler = schedulerFactory.getScheduler();

            long ctime = System.currentTimeMillis();

//            JobDetail jobDetail =
//                    new JobDetail("jobDetail-s1", "jobDetailGroup-s1",
//                            SimpleQuartzJob.class);
//            SimpleTrigger simpleTrigger =
//                    new SimpleTrigger("simpleTrigger", "triggerGroup-s1");
//
//            simpleTrigger.setStartTime(new Date(ctime));
//
//            simpleTrigger.setRepeatInterval(10000);
//
//            simpleTrigger.setRepeatCount(-1);
//
//            scheduler.scheduleJob(jobDetail, simpleTrigger);
//
//            scheduler.start();

        } catch (final SchedulerException exception) {

        }
    }
    private MqInfrastructureInitializer initMq(final Injector aInjector,
            final String aBrokerUrl, final String aUsername,
            final String aPassword)
            throws PccException {
        final MqInfrastructureInitializerFactory factory =
                aInjector.getInstance(MqInfrastructureInitializerFactory.class);
        final MqInfrastructureInitializer mqInitializer = factory.create();

        mqInitializer.setUsername(aUsername);
        mqInitializer.setPassword(aPassword);
        mqInitializer.setBrokerUrl(aBrokerUrl);
        mqInitializer.run();
        return mqInitializer;
    }

    private Properties readConfig() {
        final Properties config = new Properties();

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File(CONFIG_FILE));
            config.load(fileInputStream);
        } catch (final IOException exception) {
            LOGGER.error("", exception);
        } finally {
            IOUtils.closeQuietly(fileInputStream);
        }
        return config;
    }

    private Injector initDependencyInjector() {
        final DefaultPccSchedulerInjectorFactory injectorFactory =
                new DefaultPccSchedulerInjectorFactory();
        final Injector injector = injectorFactory.createInjector();
        return injector;
    }

    public static void main(String[] args) {
        final PccSchedulerApp app = new PccSchedulerApp();
        app.run();
    }
}
