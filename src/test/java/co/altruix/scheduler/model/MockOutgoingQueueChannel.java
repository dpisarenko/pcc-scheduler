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

import javax.jms.Message;
import javax.jms.Session;

import ru.altruix.commons.api.di.PccException;
import co.altruix.pcc.api.outgoingqueuechannel.OutgoingQueueChannel;

/**
 * @author DP118M
 *
 */
public final class MockOutgoingQueueChannel implements OutgoingQueueChannel {

    @Override
    public Session getSession() {
        return null;
    }

    @Override
    public void send(final Message aMessage) throws PccException {
    }

    @Override
    public void init() throws PccException {
    }

    @Override
    public void close() throws PccException {
    }

    @Override
    public void setSession(final Session aSession) {
    }

    @Override
    public void setQueueName(String aQueueName) {
    }

    @Override
    public void setChannelName(String aChannelName) {
    }

    @Override
    public String getChannelName() {
        return null;
    }
}
