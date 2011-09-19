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

import junit.framework.Assert;

import org.junit.Test;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.altruix.scheduler.impl.scheduledrecalculation.DefaultScheduledRecalculationJob;

/**
 * @author DP118M
 * 
 */
public class TestDefaultScheduledRecalculationJob {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(TestDefaultScheduledRecalculationJob.class);

    @Test
    public void testOnNullPointerException() {
        final DefaultScheduledRecalculationJob objectUnderTest =
                new DefaultScheduledRecalculationJob();
        final JobExecutionContext context = new MockJobExecutionContext();

        try {
            objectUnderTest.execute(context);
        } catch (final NullPointerException exception) {
            LOGGER.error("", exception);
            Assert.fail(exception.getMessage());
        }
    }
}
