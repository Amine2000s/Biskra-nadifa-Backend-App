package com.chabiamin.restapidatabase.controller;

import com.chabiamin.restapidatabase.model.SmsRequest;
import com.chabiamin.restapidatabase.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sms")
public class smsController {

    private final VerificationService verificationservice;

    @Autowired
    public smsController(VerificationService  verificationServicee) {
        this.verificationservice = verificationServicee;
    }


    @GetMapping("/verification")
    public void sendSms(){

        SmsRequest smsrequest = new SmsRequest("+21377157757","Hello ! Your Biskra nadifa verification message is 556633");


        verificationservice.SendSmsVerification(smsrequest);

    }
}
