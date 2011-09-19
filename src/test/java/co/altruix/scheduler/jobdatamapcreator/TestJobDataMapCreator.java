/**
 * This file is part of Project Control Center (PCC).
 * 
 * PCC (Project Control Center) project is intellectual property of 
 * Dmitri Anatol'evich Pisarenko.
 * 
 * Copyright 2010, 2011 Dmitri Anatol'evich Pisarenko
 * All rights reserved
 *
 **/

package co.altruix.scheduler.jobdatamapcreator;

import javax.jms.Session;

import junit.framework.Assert;

import org.junit.Test;
import org.quartz.JobDataMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.altruix.commons.api.di.PccException;

import com.google.inject.Injector;

import co.altruix.pcc.api.outgoingqueuechannel.OutgoingQueueChannel;
import co.altruix.scheduler.api.jobdatamapcreator.JobDataMapCreator;
import co.altruix.scheduler.api.jobdatamapcreator.JobDataMapCreatorFactory;
import co.altruix.scheduler.api.scheduledrecalculation.ScheduledRecalculationJob;
import co.altruix.scheduler.impl.di.DefaultPccSchedulerInjectorFactory;
import co.altruix.scheduler.impl.jobdatamapcreator.DefaultJobDataMapCreatorFactory;
import co.altruix.scheduler.model.MockOutgoingQueueChannel;
import co.altruix.scheduler.model.MockSession;

/**
 * @author DP118M
 *
 */
public class TestJobDataMapCreator {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestJobDataMapCreator.class);

    @Test
    public void test() {
        final JobDataMapCreatorFactory factory = new DefaultJobDataMapCreatorFactory();
        final JobDataMapCreator objectUnderTest = factory.create();
        final Injector injector = initDependencyInjector();
        final OutgoingQueueChannel channel = new MockOutgoingQueueChannel();
        final Session session = new MockSession();
        
        objectUnderTest.setInjector(injector);
        objectUnderTest.setChannel(channel);
        objectUnderTest.setSession(session);
        try {
            objectUnderTest.run();
        } catch (final PccException exception) {
            LOGGER.error("", exception);
            Assert.fail(exception.getMessage());
        }
        
        final JobDataMap jobDataMap = objectUnderTest.getJobDataMap();
        
        Assert.assertSame(injector, jobDataMap.get(ScheduledRecalculationJob.INJECTOR));
        Assert.assertSame(channel, jobDataMap.get(ScheduledRecalculationJob.CHANNEL));
        Assert.assertSame(session, jobDataMap.get(ScheduledRecalculationJob.SESSION));
    }
    
    private Injector initDependencyInjector() {
        final DefaultPccSchedulerInjectorFactory injectorFactory =
                new DefaultPccSchedulerInjectorFactory();
        final Injector injector = injectorFactory.createInjector();
        return injector;
    }

}
