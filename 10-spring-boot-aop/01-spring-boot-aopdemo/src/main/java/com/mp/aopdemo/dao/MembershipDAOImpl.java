package com.mp.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public void addAccount() {
        System.out.println(getClass() + " doing database work - adding a membership account");
    }

    @Override
    public boolean addSillyMember() {
        System.out.println(getClass() + " doing database work - adding a silly membership account");
        return false;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + " goToSleep();");
    }
}
