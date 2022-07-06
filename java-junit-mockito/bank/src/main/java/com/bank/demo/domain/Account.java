package com.bank.demo.domain;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private boolean isActive;
    private Integer availableLimit;
    private List<Transaction> historyTransaction;

    public Account() {
        this(false, 0, new ArrayList<>());
    }

    public Account(boolean active) {
        this(active, 0, new ArrayList<>());
    }

    public Account(Integer availableLimit) {
        this(false, availableLimit, new ArrayList<>());
    }

    public Account(List<Transaction> historyTransaction) {
        this(false, 0, historyTransaction);
    }

    public Account(boolean active, Integer availableLimit, List<Transaction> historyTransaction) {
        this.isActive = active;
        this.availableLimit = availableLimit;
        this.historyTransaction = historyTransaction;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public Integer getAvailableLimit() {
        return availableLimit;
    }

    public void setAvailableLimit(Integer availableLimit) {
        this.availableLimit = availableLimit;
    }

    public List<Transaction> getHistoryTransaction() {
        return historyTransaction;
    }

    public void setHistoryTransaction(List<Transaction> historyTransaction) {
        this.historyTransaction = historyTransaction;
    }
}
