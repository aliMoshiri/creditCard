package com.creditcard.repository;

import com.creditcard.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/*
 *  Created by A.Moshiri on 8/3/2020
 *  @author Ali Moshiri Amin (a.moshiri.a@gmail.com)
 */


public interface UserRepository extends CrudRepository<UserEntity , Long> {
    @Query(value = "select card.account.user from CardEntity card  where card.cardNumber=:cardNumber ")
    UserEntity findByCardNumber(@Param("cardNumber") String cardNumber);

    UserEntity findByNationalId(@Param("cardNumber") String nationalId);

}
