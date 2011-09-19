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

import java.util.LinkedList;
import java.util.List;

import at.silverstrike.pcc.api.model.UserData;
import at.silverstrike.pcc.impl.mockpersistence.MockPersistenceAdapter;

/**
 * @author DP118M
 *
 */
final class MockPersistence extends MockPersistenceAdapter {

    @Override
    public List<UserData> getAllusersWithAutomaticScheduling() {
        return new LinkedList<UserData>();
    }

}
