package com.creditcard.implementation;

import com.creditcard.model.TransferModel;
import com.creditcard.service.PaymentProviderService;
import com.creditcard.util.ConstantUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/*
 *  Created by A.Moshiri on 8/4/2020
 *  @author Ali Moshiri Amin (a.moshiri.a@gmail.com)
 */


@Service
public class PaymentProviderServiceImpl implements PaymentProviderService {

    private  RestTemplate restTemplate;

    private static final String PAYMENT_PROVIDER_1_API  = "https://first-payment-provider/payments/transfer";
    private static final String PAYMENT_PROVIDER_2_API = "https://second-payment-provider/cards/pay";

    @Override
    public ResponseEntity<String> pay(TransferModel transferModel) {
        HttpEntity<TransferModel> entity = new HttpEntity<>(transferModel);
        ResponseEntity<String> response = restTemplate.exchange(PAYMENT_PROVIDER_1_API, HttpMethod.POST, entity, String.class);
        return  response;
    }

    @Override
    public ResponseEntity<String> transfer(TransferModel transferModel) {
        HttpEntity<TransferModel> entity = new HttpEntity<>(transferModel);
        ResponseEntity<String> response = restTemplate.exchange(PAYMENT_PROVIDER_2_API, HttpMethod.POST, entity, String.class);
        return  response;
    }

    @Override
    public ResponseEntity<String> payAmount(TransferModel transferModel) {
        if (transferModel != null && transferModel.getSource() != null) {
            if (ConstantUtil.CommonFields.SHAHR_BANK.equals(transferModel.getSource().substring(0, 4))) {
                StringBuilder cardExpireTime = new StringBuilder(transferModel.getExpireYear()).append(transferModel.getExpireMonth());
                transferModel.setCardExpire(cardExpireTime.toString());
                return pay(transferModel);
            } else {
                transferModel.setPin2(transferModel.getPin());
                StringBuilder cardExpireTime = new StringBuilder(transferModel.getExpireYear()).append("/").append(transferModel.getExpireMonth());
                transferModel.setCardExpire(cardExpireTime.toString());
                return transfer(transferModel);
            }
        }
        return null;
    }
}
