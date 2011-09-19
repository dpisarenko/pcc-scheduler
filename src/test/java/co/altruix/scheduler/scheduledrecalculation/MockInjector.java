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

import at.silverstrike.pcc.api.persistence.Persistence;
import co.altruix.scheduler.model.MockInjectorAdapter;

import com.google.inject.Injector;

/**
 * @author DP118M
 * 
 */
final class MockInjector extends MockInjectorAdapter implements Injector {

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getInstance(Class<T> aClazz) {
        if (Persistence.class.equals(aClazz)) {
            return (T) new MockPersistence();
        } else {
            return null;
        }
    }

}
