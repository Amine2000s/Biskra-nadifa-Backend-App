package com.chabiamin.restapidatabase.controller;

import com.chabiamin.restapidatabase.model.SmsRequest;
import com.chabiamin.restapidatabase.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
public class smsController {

    private final VerificationService verificationservice;

    @Autowired
    public smsController(VerificationService  verificationServicee) {
        this.verificationservice = verificationServicee;
    }


    @PostMapping("/verification")
    public void sendSms(@RequestBody SmsRequest smsrequest){

        verificationservice.SendSmsVerification(smsrequest);

    }
}
