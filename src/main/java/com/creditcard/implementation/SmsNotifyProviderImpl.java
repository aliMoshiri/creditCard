package com.creditcard.implementation;

import com.creditcard.model.NotifyModel;
import com.creditcard.service.NotifyProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/*
 *  Created by A.Moshiri on 8/4/2020
 *  @author Ali Moshiri Amin (a.moshiri.a@gmail.com)
 */


public class SmsNotifyProviderImpl implements NotifyProvider {

    private static final String SMS_PROVIDER  = "https://sms-provider/messages/send-sms";


    @Autowired
    RestTemplate restTemplate;

    @Override
    public ResponseEntity<String> notify(NotifyModel notifyModel) {
        HttpEntity<NotifyModel> entity = new HttpEntity<>(notifyModel);
        ResponseEntity<String> response = restTemplate.exchange(SMS_PROVIDER, HttpMethod.POST, entity, String.class);
        return  response;

    }

}
