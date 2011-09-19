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

package co.altruix.scheduler.di;

import junit.framework.Assert;

import org.junit.Test;

import ru.altruix.commons.api.di.InjectorFactory;
import at.silverstrike.pcc.api.persistence.Persistence;
import co.altruix.pcc.api.mq.MqInfrastructureInitializerFactory;
import co.altruix.pcc.api.outgoingqueuechannel.OutgoingQueueChannelFactory;
import co.altruix.scheduler.api.jobdatamapcreator.JobDataMapCreatorFactory;
import co.altruix.scheduler.impl.di.DefaultPccSchedulerInjectorFactory;

import com.google.inject.ConfigurationException;
import com.google.inject.Injector;

/**
 * @author DP118M
 *
 */
public class TestPccSchedulerInjectorFactory {
    @Test
    public void test() {
        final InjectorFactory injectorFactory =
                new DefaultPccSchedulerInjectorFactory();
        final Injector injector = injectorFactory.createInjector();

        Assert.assertNotNull(injector);

        try {
            injector.getInstance(Persistence.class);
            injector.getInstance(MqInfrastructureInitializerFactory.class);
            injector.getInstance(OutgoingQueueChannelFactory.class);
            injector.getInstance(JobDataMapCreatorFactory.class);
        } catch (final ConfigurationException exception) {
            Assert.fail(exception.getMessage());
        }
    }
}
