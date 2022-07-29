package com.buimanhthanh.springaop;

import com.buimanhthanh.springaop.config.DemoConfig;
import com.buimanhthanh.springaop.dao.AccountDAO;
import com.buimanhthanh.springaop.dao.MemberShipDAO;
import com.buimanhthanh.springaop.model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApplication {
    public static void main(String[] args) {
        // read java config file
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get bean form spring container
        AccountDAO theAccountDao = context.getBean("accountDAO",AccountDAO.class);
        MemberShipDAO theMemberShipDao = context.getBean("memberShipDAO",MemberShipDAO.class);

        // call business method
        theAccountDao.addAccount(new Account("thanh","10 "));
        theMemberShipDao.addAccount();

        // close context
        context.close();
    }
}