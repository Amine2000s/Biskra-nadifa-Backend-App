package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.config.twilioConfig;
import com.chabiamin.restapidatabase.model.SmsRequest;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio")
public class TwilioSmsService implements SmsSender{


    private final twilioConfig twilioconfig ;

    @Autowired
    public TwilioSmsService(twilioConfig twilioconfig) {
        this.twilioconfig = twilioconfig;
    }


    @Override
    public void sendSms(SmsRequest smsRequest) {

        PhoneNumber to =new PhoneNumber(smsRequest.getPhoneNumber());
        PhoneNumber from =new PhoneNumber(twilioconfig.getPhoneNumber());
        String message = smsRequest.getMessage() ;

        MessageCreator creator = Message.creator(to,from,message);
        creator.create();


    }
}
