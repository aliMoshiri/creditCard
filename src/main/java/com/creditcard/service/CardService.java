package com.creditcard.service;


import com.creditcard.model.CardModel;
import com.creditcard.model.TransferModel;

import java.util.List;

/*
 *  Created by A.Moshiri on 8/2/2020
 *  @author Ali Moshiri Amin (a.moshiri.a@gmail.com)
 */


public interface CardService {

    CardModel addCard(CardModel cardModel);

    boolean removeCard(Long cardId);

    List<CardModel> findByUserNationalId(String userNationalId);

    boolean transfer(TransferModel transferModel);
}
