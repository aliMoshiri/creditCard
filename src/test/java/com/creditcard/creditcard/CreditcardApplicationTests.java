package com.creditcard.creditcard;

import com.creditcard.entities.AccountEntity;
import com.creditcard.entities.CardEntity;
import com.creditcard.entities.UserEntity;
import com.creditcard.repository.AccountRepository;
import com.creditcard.repository.CardRepository;
import com.creditcard.repository.UserRepository;
import com.creditcard.util.ConstantUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class CreditCardApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    AccountRepository accountRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void findByCardNumber() {
        CardEntity loadedCardEntity = cardRepository.findByCardNumber("5022-2910-2218-9999");
        Assert.assertEquals("999", loadedCardEntity.getCvv2());
        Assert.assertEquals("09", loadedCardEntity.getExpireMonth());
        Assert.assertEquals("99", loadedCardEntity.getExpireYear());
        Assert.assertEquals("9999", loadedCardEntity.getPassword());
        Assert.assertEquals("99999999", loadedCardEntity.getSecondPassword());

    }

    @Test
    public void testRegister() {

        CardEntity loadedCardEntityForDelete = cardRepository.findByCardNumber("5022-2910-2218-1111");
        AccountEntity loadedAccountEntityForDelete = accountRepository.findByAccountNumber("88888888");
        UserEntity loadedUserEntityForDelete = userRepository.findByNationalId("1112223331");

        if (loadedCardEntityForDelete!=null) {
            cardRepository.delete(loadedCardEntityForDelete);
        }

        if (loadedAccountEntityForDelete!=null) {
            accountRepository.delete(loadedAccountEntityForDelete);
        }
        if (loadedUserEntityForDelete!=null) {
            userRepository.deleteById(loadedUserEntityForDelete.getId());
        }

        UserEntity aliMoshiri = new UserEntity();
        aliMoshiri.setFirstName("aliForTest");
        aliMoshiri.setLastName("moshiriForTest");
        aliMoshiri.setActive(true);
        aliMoshiri.setNationalId("1112223331");
        aliMoshiri.setMobileNo("09123455555");
        aliMoshiri.setUserName("aliMoshiriForTest");

        UserEntity insertedAliMoshiri = userRepository.save(aliMoshiri);

        AccountEntity aliMoshiriAccountEntity = new AccountEntity();
        aliMoshiriAccountEntity.setAccountNumber("88888888");
        aliMoshiriAccountEntity.setAmount(100000000L);
        aliMoshiriAccountEntity.setActive(true);
        aliMoshiriAccountEntity.setStatus(ConstantUtil.OperationStatus.SUCCESSFUL);
        aliMoshiriAccountEntity.setUser(insertedAliMoshiri);
        AccountEntity insertedAliMoshiriAccount = accountRepository.save(aliMoshiriAccountEntity);
        CardEntity aliMoshiriCard = new CardEntity();
        aliMoshiriCard.setAccount(insertedAliMoshiriAccount);
        aliMoshiriCard.setActive(true);
        aliMoshiriCard.setCardNumber("5022-2910-2218-1111");
        aliMoshiriCard.setCvv2("111");
        aliMoshiriCard.setExpireMonth("01");
        aliMoshiriCard.setExpireYear("99");
        aliMoshiriCard.setPassword("1111");
        aliMoshiriCard.setSecondPassword("11111111");
        aliMoshiriCard.setStatus(ConstantUtil.OperationStatus.SUCCESSFUL);
        CardEntity insertedAliMoshiriCard = cardRepository.save(aliMoshiriCard);

        Assert.assertNotNull(aliMoshiri);
        Assert.assertNotNull(aliMoshiri.getId());
        Assert.assertNotNull(insertedAliMoshiriAccount);
        Assert.assertNotNull(insertedAliMoshiriAccount.getId());
        Assert.assertNotNull(insertedAliMoshiriCard);
        Assert.assertNotNull(insertedAliMoshiriCard.getId());

        Optional<CardEntity> loadedCardOptional = cardRepository.findById(insertedAliMoshiriCard.getId());
        CardEntity loadedCardEntity = null;
        if (loadedCardOptional.isPresent()) {
            loadedCardEntity = loadedCardOptional.get();
            Assert.assertEquals("5022-2910-2218-1111", loadedCardEntity.getCardNumber());
            Assert.assertEquals("111", loadedCardEntity.getCvv2());
            Assert.assertEquals("1111", loadedCardEntity.getPassword());
        }

        Optional<AccountEntity> loadedAccountOptional = accountRepository.findById(insertedAliMoshiriAccount.getId());
        AccountEntity loadedAccountEntity =null;
        if (loadedAccountOptional.isPresent()) {
            loadedAccountEntity = loadedAccountOptional.get();
            Assert.assertEquals("88888888", loadedAccountEntity.getAccountNumber());
        }

        UserEntity loadedUserEntity = userRepository.findByNationalId(aliMoshiri.getNationalId());
        if (loadedUserEntity != null) {
            Assert.assertEquals("1112223331", loadedUserEntity.getNationalId());
            Assert.assertEquals("09123455555", loadedUserEntity.getMobileNo());
            Assert.assertEquals("1112223331", loadedUserEntity.getNationalId());
        }

        cardRepository.deleteById(loadedCardEntity.getId());
        accountRepository.deleteById(loadedAccountEntity.getId());
        userRepository.deleteById(loadedUserEntity.getId());

        return;
    }

    @Test
    public void remove(){
        CardEntity loadedCardEntity = cardRepository.findByCardNumberAndIsActive("5022-2910-2218-9999",true);
        Assert.assertNotNull(loadedCardEntity);
        loadedCardEntity.setActive(false);
        cardRepository.save(loadedCardEntity);
        CardEntity deActiveCart = cardRepository.findByCardNumberAndIsActive(loadedCardEntity.getCardNumber(),true);
        Assert.assertNull(deActiveCart);
        loadedCardEntity.setActive(true);
        CardEntity activeCart = cardRepository.findByCardNumberAndIsActive(loadedCardEntity.getCardNumber(),true);
        Assert.assertNotNull(activeCart);

    }

    public static void main(String[] args) {
        CreditCardApplicationTests creditCardApplicationTests = new CreditCardApplicationTests();
        creditCardApplicationTests.findByCardNumber();
        creditCardApplicationTests.testRegister();
        creditCardApplicationTests.remove();
    }


}

