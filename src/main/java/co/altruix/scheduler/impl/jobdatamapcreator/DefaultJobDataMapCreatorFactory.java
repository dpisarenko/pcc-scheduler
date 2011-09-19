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

import co.altruix.scheduler.api.jobdatamapcreator.JobDataMapCreator;
import co.altruix.scheduler.api.jobdatamapcreator.JobDataMapCreatorFactory;

/**
 * @author DP118M
 *
 */
public class DefaultJobDataMapCreatorFactory implements
        JobDataMapCreatorFactory {

    @Override
    public JobDataMapCreator create() {
        return new DefaultJobDataMapCreator();
    }

}
