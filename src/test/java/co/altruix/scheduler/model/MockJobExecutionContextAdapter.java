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

package co.altruix.scheduler.model;

import java.util.Date;

import org.quartz.Calendar;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.Scheduler;
import org.quartz.Trigger;

/**
 * @author DP118M
 *
 */
public abstract class MockJobExecutionContextAdapter implements JobExecutionContext  {

    @Override
    public Object get(Object arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Calendar getCalendar() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Date getFireTime() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JobDetail getJobDetail() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Job getJobInstance() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getJobRunTime() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public JobDataMap getMergedJobDataMap() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Date getNextFireTime() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Date getPreviousFireTime() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getRefireCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Object getResult() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Date getScheduledFireTime() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Scheduler getScheduler() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Trigger getTrigger() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isRecovering() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void put(Object arg0, Object arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setResult(Object arg0) {
        // TODO Auto-generated method stub
        
    }

}
