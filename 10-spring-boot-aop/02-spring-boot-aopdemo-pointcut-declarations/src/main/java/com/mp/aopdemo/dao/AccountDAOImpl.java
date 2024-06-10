package com.mp.aopdemo.dao;

import com.mp.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {
    private String name;
    private String serviceCode;
    @Override
    public void addAccount(Account account, boolean vip) {
        System.out.println(getClass() + " doing database work - adding an account");
    }
    @Override
    public boolean doWork() {
        System.out.println(getClass() + " doWork();");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + " getName();");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " setName();");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " getServiceCode();");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " setServiceCode();");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false); // don't throw exception
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {
        if (tripWire) {
            throw new RuntimeException("throwing RuntimeException!");
        } else {
            List<Account> accounts = new ArrayList<>();
            accounts.add(new Account("John", "Gold"));
            accounts.add(new Account("Thomas", "Silver"));
            accounts.add(new Account("Greg", "Platinum"));

            return accounts;
        }
    }
}
