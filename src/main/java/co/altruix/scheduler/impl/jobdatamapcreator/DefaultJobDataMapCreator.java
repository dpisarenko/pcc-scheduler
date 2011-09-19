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

package co.altruix.scheduler.impl.jobdatamapcreator;

import javax.jms.Session;

import org.quartz.JobDataMap;

import ru.altruix.commons.api.di.PccException;

import com.google.inject.Injector;

import co.altruix.pcc.api.outgoingqueuechannel.OutgoingQueueChannel;
import co.altruix.scheduler.api.jobdatamapcreator.JobDataMapCreator;
import co.altruix.scheduler.api.scheduledrecalculation.ScheduledRecalculationJob;

/**
 * @author DP118M
 *
 */
final class DefaultJobDataMapCreator implements JobDataMapCreator {
    private Injector injector;
    private OutgoingQueueChannel channel;
    private Session session;
    private JobDataMap jobDataMap;
    
    public JobDataMap getJobDataMap() {
        return jobDataMap;
    }
    public void setInjector(final Injector aInjector) {
        this.injector = aInjector;
    }
    public void setChannel(final OutgoingQueueChannel aChannel) {
        this.channel = aChannel;
    }
    public void setSession(final Session aSession) {
        this.session = aSession;
    }
    @Override
    public void run() throws PccException {
        this.jobDataMap = new JobDataMap();
        
        jobDataMap.put(ScheduledRecalculationJob.INJECTOR, injector);
        jobDataMap.put(ScheduledRecalculationJob.CHANNEL, channel);
        jobDataMap.put(ScheduledRecalculationJob.SESSION, session);
    }
}
