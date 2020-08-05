package com.creditcard.implementation;

import com.creditcard.entities.TransactionEntity;
import com.creditcard.model.TransactionModel;
import com.creditcard.repository.TransactionRepository;
import com.creditcard.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 *  Created by A.Moshiri on 8/3/2020
 *  @author Ali Moshiri Amin (a.moshiri.a@gmail.com)
 */


@Service
public class TransactionServiceImpl {

    @Autowired
    TransactionRepository transactionRepository;


    public void save(TransactionModel transactionModel) {
        try {
            TransactionEntity transactionEntity = (TransactionEntity) Utility.modelAndEntityConverter(transactionModel, TransactionEntity.class.getName());
            save(transactionEntity);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return;
    }


    public void save(TransactionEntity transactionEntity) {
       transactionRepository.save(transactionEntity);
       return;
    }
}
