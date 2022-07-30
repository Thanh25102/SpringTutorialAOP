package com.buimanhthanh.springaop;

import com.buimanhthanh.springaop.config.DemoConfig;
import com.buimanhthanh.springaop.dao.AccountDAO;
import com.buimanhthanh.springaop.dao.MemberShipDAO;
import com.buimanhthanh.springaop.model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        // read java config file
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get bean form spring container
        AccountDAO theAccountDao = context.getBean("accountDAO",AccountDAO.class);

        // call business method
//        theAccountDao.addAccount(new Account("thanh","10 "),true);
        List<Account> accounts = theAccountDao.findAccount();
        accounts.forEach(System.out::println);
        // close context
        context.close();
    }
}
