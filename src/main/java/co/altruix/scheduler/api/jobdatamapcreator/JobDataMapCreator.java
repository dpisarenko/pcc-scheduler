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

package co.altruix.scheduler.api.jobdatamapcreator;

import javax.jms.Session;

import org.quartz.JobDataMap;

import co.altruix.pcc.api.outgoingqueuechannel.OutgoingQueueChannel;

import com.google.inject.Injector;

import ru.altruix.commons.api.conventions.SingleActivityModule;

/**
 * @author DP118M
 *
 */
public interface JobDataMapCreator extends SingleActivityModule {
    void setInjector(final Injector aInjector);
    void setChannel(final OutgoingQueueChannel aChannel);
    void setSession(final Session aSession);
    JobDataMap getJobDataMap();
}
