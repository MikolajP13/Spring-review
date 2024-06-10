package com.mp.aopdemo.dao;

import com.mp.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account account, boolean vip);
    boolean doWork();
}
