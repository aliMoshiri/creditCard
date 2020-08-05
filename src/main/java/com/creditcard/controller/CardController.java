package com.creditcard.controller;

import com.creditcard.implementation.CardServiceImpl;
import com.creditcard.model.CardModel;
import com.creditcard.model.TransferModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 *  Created by A.Moshiri on 8/3/2020
 *  @author Ali Moshiri Amin (a.moshiri.a@gmail.com)
 */

@RestController
public class CardController {

    @Autowired
    CardServiceImpl cardService;

    @PostMapping(value = "/addCard")
    @ResponseStatus(HttpStatus.OK)
    public CardModel addCard(@RequestBody CardModel cardModel) {
        if (cardModel != null) {
            try {
                return cardService.addCard(cardModel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    @GetMapping(value = "/removeCard")
    @ResponseStatus(HttpStatus.OK)
    public boolean removeCard(@RequestParam String cardNumber) {
        if (cardNumber != null) {
            try {
                return cardService.removeCard(cardNumber);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    @PostMapping(value = "/transfer")
    @ResponseStatus(HttpStatus.OK)
    public boolean transfer(@RequestBody TransferModel transferModel) {
        if (transferModel !=null) {
            try {
                return cardService.transfer(transferModel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    @GetMapping(value = "/findCards")
    @ResponseStatus(HttpStatus.OK)
    public List<CardModel> findCards(@RequestParam String userNationalId) {
        if (userNationalId != null) {
            try {
                return cardService.findByUserNationalId(userNationalId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
