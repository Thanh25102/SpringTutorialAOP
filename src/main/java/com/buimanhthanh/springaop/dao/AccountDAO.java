package com.buimanhthanh.springaop.dao;

import com.buimanhthanh.springaop.model.Account;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    public void addAccount(Account account){
        System.out.println(getClass() + " : Doing my db work: adding an account ");
    }
}
