package com.buimanhthanh.springaop.dao;

import org.springframework.stereotype.Component;

@Component
public class MemberShipDAO {
    public void addAccount(){
        System.out.println("member ship " + getClass());
    }
}
