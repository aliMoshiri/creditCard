package com.creditcard.implementation;

import com.creditcard.entities.AccountEntity;
import com.creditcard.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*
 *  Created by A.Moshiri on 8/3/2020
 *  @author Ali Moshiri Amin (a.moshiri.a@gmail.com)
 */


@Service
public class AccountServiceImpl {
    @Autowired
    AccountRepository accountRepository;

    public Optional<AccountEntity> findById(Long accountId) {
        return accountRepository.findById(accountId);
    }

    public AccountEntity findByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }
}
