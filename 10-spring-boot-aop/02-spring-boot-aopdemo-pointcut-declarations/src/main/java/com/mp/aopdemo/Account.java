package com.mp.aopdemo;

public class Account {
    private String name;
    private String level;

    public Account() { }

    public Account(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("name='").append(name).append('\'');
        sb.append(", level='").append(level).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
