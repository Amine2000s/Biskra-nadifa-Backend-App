package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.config.twilioConfig;
import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class twilioInitalizer {

    private static Logger LOGGER = LoggerFactory.getLogger(twilioInitalizer.class);
    twilioConfig twilioConfig ;

    @Autowired
    public twilioInitalizer(com.chabiamin.restapidatabase.config.twilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;

        Twilio.init(twilioConfig.getAccountSid(),twilioConfig.getAuthToken());


        LOGGER.info("twilio Initialized with sid {}",twilioConfig.getAccountSid());
    }






}
