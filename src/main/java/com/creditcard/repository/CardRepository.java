package com.creditcard.repository;

import com.creditcard.entities.CardEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/*
 *  Created by A.Moshiri on 8/2/2020
 *  @author Ali Moshiri Amin (a.moshiri.a@gmail.com)
 */


public interface CardRepository extends CrudRepository<CardEntity, Long> {

    @Query(value = "select card from CardEntity card  where card.account.user.nationalId=:nationalId ")
    List<CardEntity> findByUserNationalId(@Param("nationalId") String nationalId);

    List<CardEntity> findByAccount(Long accountNumber);

    CardEntity findByCardNumber(String cardNumber);

    CardEntity findByCardNumberAndIsActive( String cardNumber , boolean isActive);
}
