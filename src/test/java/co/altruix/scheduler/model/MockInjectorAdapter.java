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

import java.util.List;
import java.util.Map;

import com.google.inject.Binding;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.MembersInjector;
import com.google.inject.Module;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;

/**
 * @author DP118M
 *
 */
public abstract class MockInjectorAdapter implements Injector  {

    @Override
    public Injector createChildInjector(Iterable<? extends Module> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Injector createChildInjector(Module... arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> List<Binding<T>> findBindingsByType(TypeLiteral<T> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> Binding<T> getBinding(Key<T> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> Binding<T> getBinding(Class<T> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<Key<?>, Binding<?>> getBindings() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T getInstance(Key<T> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T getInstance(Class<T> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> MembersInjector<T> getMembersInjector(TypeLiteral<T> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> MembersInjector<T> getMembersInjector(Class<T> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Injector getParent() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> Provider<T> getProvider(Key<T> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> Provider<T> getProvider(Class<T> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void injectMembers(Object arg0) {
        // TODO Auto-generated method stub
    
    }

}
