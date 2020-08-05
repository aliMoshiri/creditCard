package com.creditcard.repository;

import com.creditcard.entities.TransactionEntity;
import org.springframework.data.repository.CrudRepository;

/*
 *  Created by A.Moshiri on 8/4/2020
 *  @author Ali Moshiri Amin (a.moshiri.a@gmail.com)
 */


public interface TransactionRepository extends CrudRepository<TransactionEntity , Long> {
}
