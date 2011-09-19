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

package co.altruix.scheduler.scheduledrecalculation;

import org.quartz.JobDataMap;
import co.altruix.scheduler.api.scheduledrecalculation.ScheduledRecalculationJob;
import co.altruix.scheduler.model.MockJobExecutionContextAdapter;
import co.altruix.scheduler.model.MockOutgoingQueueChannel;
import co.altruix.scheduler.model.MockSession;

/**
 * @author DP118M
 * 
 */
final class MockJobExecutionContext extends MockJobExecutionContextAdapter {

    @Override
    public JobDataMap getMergedJobDataMap() {
        final JobDataMap returnValue = new JobDataMap();
        returnValue.put(ScheduledRecalculationJob.INJECTOR, new MockInjector());
        returnValue.put(ScheduledRecalculationJob.CHANNEL,
                new MockOutgoingQueueChannel());
        returnValue.put(ScheduledRecalculationJob.SESSION, new MockSession());
        return returnValue;
    }

}
