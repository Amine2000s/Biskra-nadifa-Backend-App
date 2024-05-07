package com.chabiamin.restapidatabase.service;

import com.chabiamin.restapidatabase.model.SmsRequest;

public interface SmsSender {

    void sendSms(SmsRequest smsRequest);


}
