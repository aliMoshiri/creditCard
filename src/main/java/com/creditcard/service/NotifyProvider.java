package com.creditcard.service;

import com.creditcard.model.NotifyModel;
import org.springframework.http.ResponseEntity;

/*
 *  Created by A.Moshiri on 8/4/2020
 *  @author Ali Moshiri Amin (a.moshiri.a@gmail.com)
 */


public interface NotifyProvider {
     ResponseEntity<String> notify(NotifyModel notifyModel);
}
