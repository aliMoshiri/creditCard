package com.creditcard.implementation;

import com.creditcard.entities.AccountEntity;
import com.creditcard.entities.CardEntity;
import com.creditcard.entities.UserEntity;
import com.creditcard.model.CardModel;
import com.creditcard.model.NotifyModel;
import com.creditcard.model.TransactionModel;
import com.creditcard.model.TransferModel;
import com.creditcard.repository.CardRepository;
import com.creditcard.service.CardService;
import com.creditcard.util.ConstantUtil;
import com.creditcard.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 *  Created by A.Moshiri on 8/2/2020
 *  @author Ali Moshiri Amin (a.moshiri.a@gmail.com)
 */

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    AccountServiceImpl accountService;

    @Autowired
    PaymentProviderServiceImpl paymentProviderService;

    @Autowired
    TransactionServiceImpl transactionService;

    @Autowired
    UserServiceImpl userService;

    @Override
    public CardModel addCard(CardModel cardModel) {
        try {
            CardEntity cardEntity = (CardEntity) Utility.modelAndEntityConverter(cardModel, CardEntity.class.getName());
            if (cardEntity != null) {
                AccountEntity accountEntity = accountService.findByAccountNumber(cardModel.getAccountNumber());
                if (accountEntity!=null) {
                    cardEntity.setAccount(accountEntity);
                    CardEntity insertCardEntity = cardRepository.save(cardEntity);
                    cardModel.setId(insertCardEntity.getId());
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return cardModel;
    }

    @Override
    public boolean removeCard(String cardNumber) {
        boolean completeOperation = false;
        try {
            CardEntity loadedCardEntity = cardRepository.findByCardNumber(cardNumber);
            if (loadedCardEntity != null) {
                loadedCardEntity.setActive(false);
                cardRepository.save(loadedCardEntity);
                completeOperation = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return completeOperation;
    }

    @Override
    public List<CardModel> findByUserNationalId(String userNationalId) {
        List<CardEntity> loadedCardEntities = cardRepository.findByUserNationalId(userNationalId);
        if (!CollectionUtils.isEmpty(loadedCardEntities)) {
            List<CardModel> cardModelList = new ArrayList<>();
            loadedCardEntities.stream().forEach(cardEntity -> cardModelList.add(buildCardModelByCardEntity(cardEntity)));
            return cardModelList;
        }

        return null;
    }

    @Override
    public boolean transfer(TransferModel transferModel) {

        boolean isTransferred= false;
        ResponseEntity<String> stringResponseEntity = paymentProviderService.payAmount(transferModel);

        if(stringResponseEntity!=null ){
            if ( HttpStatus.OK.equals(stringResponseEntity.getStatusCode())) {
                updateDataBase(transferModel,ConstantUtil.OperationStatus.SUCCESSFUL);
                try {
                    sendNotification(transferModel);
                    isTransferred = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                updateDataBase(transferModel,ConstantUtil.OperationStatus.UNSUCCESSFUL);
            }
        }
        return  isTransferred;
    }

    private void sendNotification(TransferModel transferModel) {
        NotifyProviderImpl notifyProvider = new NotifyProviderImpl();
        NotifyModel notifyModel = new NotifyModel();
        StringBuilder msg = new StringBuilder();
        msg.append(transferModel.getSource()).append("###").append(transferModel.getTarget());
        notifyModel.setMsg(msg.toString());
        UserEntity sourceUserEntity = userService.findByCardNumber(transferModel.getSource());
        notifyProvider.setNotifyProvider(new SmsNotifyProviderImpl());
        notifyModel.setTarget(sourceUserEntity.getMobileNo());
        notifyProvider.notify(notifyModel);
    }

    @Transactional
    void updateDataBase(TransferModel transferModel, Long status) {
        TransactionModel sourceTransaction = new TransactionModel();
        sourceTransaction.setCardNumber(transferModel.getSource());
        sourceTransaction.setActive(true);
        sourceTransaction.setAmount(transferModel.getAmount());
        sourceTransaction.setCreateDate(new Date());
        sourceTransaction.setDeposit(false);
        sourceTransaction.setStatus(status);
        transactionService.save(sourceTransaction);

        if (ConstantUtil.OperationStatus.SUCCESSFUL.equals(status)) {
            TransactionModel destinationTransaction = sourceTransaction;
            destinationTransaction.setCardNumber(transferModel.getTarget());
            destinationTransaction.setDeposit(true);
            transactionService.save(destinationTransaction);
        }
        return;
    }

    private CardModel buildCardModelByCardEntity(CardEntity cardEntity) {
        CardModel cardModel = new CardModel();
        if (cardEntity != null) {
            try {
                cardModel = (CardModel) Utility.modelAndEntityConverter(cardEntity, CardModel.class.getName());
                if (cardEntity.getAccount() != null) {
                    cardModel.setAccountId(cardEntity.getAccount().getId());
                    cardModel.setAccountNumber(cardEntity.getAccount().getAccountNumber());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cardModel;
    }

}
