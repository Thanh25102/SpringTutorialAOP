package com.buimanhthanh.springaop;

import com.buimanhthanh.springaop.config.DemoConfig;
import com.buimanhthanh.springaop.dao.AccountDAO;
import com.buimanhthanh.springaop.model.Account;
import com.buimanhthanh.springaop.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.logging.Logger;

public class AroundDemoApp {

    private static Logger myLogger = Logger.getLogger(AroundDemoApp.class.getName());

    public static void main(String[] args) {
        // read java config file
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get bean form spring container
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
        myLogger.info("\n Main Fortune");
        myLogger.info("Calling getFortune");
        String data = trafficFortuneService.getFortune();
        myLogger.info("\n My Fortune is : "+data);

        myLogger.info("Finished");
        context.close();
    }
}
