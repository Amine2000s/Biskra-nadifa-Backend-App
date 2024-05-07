package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.SmsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class VerificationService {

    private final SmsSender Smssender ;

@Autowired
    public VerificationService(@Qualifier("twilio") SmsSender Smssenderr) {
        this.Smssender = Smssenderr;
    }


    public void SendSmsVerification(SmsRequest smsrequest){

        Smssender.sendSms(smsrequest);
    }
}
