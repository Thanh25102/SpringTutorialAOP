package com.buimanhthanh.springaop.dao;

import com.buimanhthanh.springaop.model.Account;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    private String name;

    public String getName() {
        System.out.println("getName");
        return name;
    }

    public void setName(String name) {
        System.out.println("setName");
        this.name = name;
    }

    public String getCode() {
        System.out.println("getCode");
        return code;
    }

    public void setCode(String code) {
        System.out.println("setCode");
        this.code = code;
    }

    private String code;

    public void addAccount(Account account,boolean check){
        System.out.println(getClass() + " : Doing my db work: adding an account ");
    }
}
