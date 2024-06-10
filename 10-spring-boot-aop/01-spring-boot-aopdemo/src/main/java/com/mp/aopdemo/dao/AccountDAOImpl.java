package com.mp.aopdemo.dao;

import com.mp.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
    @Override
    public void addAccount(Account account, boolean vip) {
        System.out.println(getClass() + " doing database work - adding an account");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + " doWork();");
        return false;
    }
}
