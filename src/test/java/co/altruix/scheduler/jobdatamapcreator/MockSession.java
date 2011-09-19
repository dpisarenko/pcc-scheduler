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

import java.io.Serializable;

import javax.jms.BytesMessage;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.StreamMessage;
import javax.jms.TemporaryQueue;
import javax.jms.TemporaryTopic;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;

/**
 * @author DP118M
 *
 */
final class MockSession implements Session {

    @Override
    public void close() throws JMSException {
    }

    @Override
    public void commit() throws JMSException {
    }

    @Override
    public QueueBrowser createBrowser(final Queue aQueue) throws JMSException {
        return null;
    }

    @Override
    public QueueBrowser createBrowser(final Queue aQueue, final String aString)
            throws JMSException {
        return null;
    }

    @Override
    public BytesMessage createBytesMessage() throws JMSException {
        return null;
    }

    @Override
    public MessageConsumer createConsumer(final Destination aDest) throws JMSException {
        return null;
    }

    @Override
    public MessageConsumer createConsumer(final Destination aArg1, final String aArg2)
            throws JMSException {
        return null;
    }

    @Override
    public MessageConsumer createConsumer(Destination arg0, String arg1,
            boolean arg2) throws JMSException {
        return null;
    }

    @Override
    public TopicSubscriber createDurableSubscriber(Topic arg0, String arg1)
            throws JMSException {
        return null;
    }

    @Override
    public TopicSubscriber createDurableSubscriber(Topic arg0, String arg1,
            String arg2, boolean arg3) throws JMSException {
        return null;
    }

    @Override
    public MapMessage createMapMessage() throws JMSException {
        return null;
    }

    @Override
    public Message createMessage() throws JMSException {
        return null;
    }

    @Override
    public ObjectMessage createObjectMessage() throws JMSException {
        return null;
    }

    @Override
    public ObjectMessage createObjectMessage(Serializable arg0)
            throws JMSException {
        return null;
    }

    @Override
    public MessageProducer createProducer(Destination arg0) throws JMSException {
        return null;
    }

    @Override
    public Queue createQueue(String arg0) throws JMSException {
        return null;
    }

    @Override
    public StreamMessage createStreamMessage() throws JMSException {
        return null;
    }

    @Override
    public TemporaryQueue createTemporaryQueue() throws JMSException {
        return null;
    }

    @Override
    public TemporaryTopic createTemporaryTopic() throws JMSException {
        return null;
    }

    @Override
    public TextMessage createTextMessage() throws JMSException {
        return null;
    }

    @Override
    public TextMessage createTextMessage(String arg0) throws JMSException {
        return null;
    }

    @Override
    public Topic createTopic(String arg0) throws JMSException {
        return null;
    }

    @Override
    public int getAcknowledgeMode() throws JMSException {
        return 0;
    }

    @Override
    public MessageListener getMessageListener() throws JMSException {
        return null;
    }

    @Override
    public boolean getTransacted() throws JMSException {
        return false;
    }

    @Override
    public void recover() throws JMSException {
    }

    @Override
    public void rollback() throws JMSException {
    }

    @Override
    public void run() {
    }

    @Override
    public void setMessageListener(MessageListener arg0) throws JMSException {
    }

    @Override
    public void unsubscribe(String arg0) throws JMSException {

    }

}
