package com.buimanhthanh.springaop.dao;

import com.buimanhthanh.springaop.model.Account;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public List<Account> findAccount(boolean tripWire){
        if(tripWire){
            throw  new RuntimeException("Loi~ ne` fix di :>");
        }
        return List.of(new Account("thanh1","1"),new Account("thanh2","2"),new Account("thanh3","3"));
    }
    @Override
    public String toString() {
        return "AccountDAO{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
