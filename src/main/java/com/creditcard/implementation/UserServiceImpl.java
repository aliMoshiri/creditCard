package com.creditcard.implementation;

import com.creditcard.entities.UserEntity;
import com.creditcard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 *  Created by A.Moshiri on 8/2/2020
 *  @author Ali Moshiri Amin (a.moshiri.a@gmail.com)
 */


@Service
public class UserServiceImpl {

    @Autowired
    UserRepository userRepository;

    public UserEntity findByCardNumber(String cardNumber) {
        return userRepository.findByCardNumber(cardNumber);
    }
}
