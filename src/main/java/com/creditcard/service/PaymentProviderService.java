package com.creditcard.service;

import com.creditcard.model.TransferModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/*
 *  Created by A.Moshiri on 8/4/2020
 *  @author Ali Moshiri Amin (a.moshiri.a@gmail.com)
 */


public interface PaymentProviderService {
    ResponseEntity<String> pay(TransferModel transferModel);

    ResponseEntity<String> transfer(TransferModel transferModel);

    ResponseEntity<String> payAmount(TransferModel transferModel);
}
