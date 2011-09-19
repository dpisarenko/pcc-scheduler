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

package co.altruix.scheduler.impl.di;

import java.util.HashMap;
import java.util.Map;

import at.silverstrike.pcc.api.persistence.Persistence;
import at.silverstrike.pcc.impl.persistence.DefaultPersistence;

import co.altruix.pcc.api.mq.MqInfrastructureInitializerFactory;
import co.altruix.pcc.api.outgoingqueuechannel.OutgoingQueueChannelFactory;
import co.altruix.pcc.impl.mq.DefaultMqInfrastructureInitializerFactory;
import co.altruix.pcc.impl.outgoingqueuechannel.DefaultOutgoingQueueChannelFactory;
import co.altruix.scheduler.api.jobdatamapcreator.JobDataMapCreatorFactory;
import co.altruix.scheduler.impl.jobdatamapcreator.DefaultJobDataMapCreatorFactory;

import com.google.inject.AbstractModule;

/**
 * @author DP118M
 * 
 */
class InjectorModule extends AbstractModule {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    protected void configure() {
        final Map<Class, Object> interfacesByInstances =
            new HashMap<Class, Object>();

        interfacesByInstances.put(Persistence.class,
                new DefaultPersistence());
        interfacesByInstances.put(MqInfrastructureInitializerFactory.class,
                new DefaultMqInfrastructureInitializerFactory());
        interfacesByInstances.put(OutgoingQueueChannelFactory.class,
                new DefaultOutgoingQueueChannelFactory());
        interfacesByInstances.put(JobDataMapCreatorFactory.class,
                new DefaultJobDataMapCreatorFactory());

        for (final Class clazz : interfacesByInstances.keySet()) {
            final Object instance = interfacesByInstances.get(clazz);

            bind(clazz).toInstance(instance);
        }        
    }

}
