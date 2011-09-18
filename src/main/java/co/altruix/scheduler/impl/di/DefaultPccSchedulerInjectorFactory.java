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

import com.google.inject.Guice;
import com.google.inject.Injector;

import co.altruix.scheduler.api.di.PccSchedulerInjectorFactory;

/**
 * @author DP118M
 *
 */
public class DefaultPccSchedulerInjectorFactory implements
        PccSchedulerInjectorFactory {

    @Override
    public Injector createInjector() {
        final InjectorModule injectorModule = new InjectorModule();
        final Injector injector = Guice.createInjector(injectorModule);

        return injector;

    }

}
