package com.creditcard.repository;

import com.creditcard.entities.AccountEntity;
import org.springframework.data.repository.CrudRepository;

/*
 *  Created by A.Moshiri on 8/2/2020
 *  @author Ali Moshiri Amin (a.moshiri.a@gmail.com)
 */


public interface AccountRepository extends CrudRepository<AccountEntity , Long> {
    AccountEntity findByAccountNumber(String accountNumber);
}
