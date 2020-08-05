package com.creditcard;

import com.creditcard.entities.AccountEntity;
import com.creditcard.entities.CardEntity;
import com.creditcard.entities.UserEntity;
import com.creditcard.repository.AccountRepository;
import com.creditcard.repository.CardRepository;
import com.creditcard.repository.UserRepository;
import com.creditcard.util.ConstantUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.List;

/*
 *  Created by A.Moshiri on 8/1/2020
 *  @author Ali Moshiri Amin (a.moshiri.a@gmail.com)
 */

@SpringBootApplication(exclude = {
        SecurityAutoConfiguration.class
})
@EnableJpaRepositories("com.creditcard.repository")
@ComponentScan({"com"})
@EntityScan({"com"})
public class CreditCardApplication {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(CreditCardApplication.class, args);
    }


    @PostConstruct
    public void init() {
        List<UserEntity> allUser = (List<UserEntity>) userRepository.findAll();
        if (CollectionUtils.isEmpty(allUser)) {

            UserEntity aliMoshiri = new UserEntity();
            aliMoshiri.setFirstName("ali");
            aliMoshiri.setLastName("moshiri");
            aliMoshiri.setActive(true);
            aliMoshiri.setNationalId("1234567890");
            aliMoshiri.setMobileNO("09123456789");
            aliMoshiri.setUserName("aliMoshiri");

            UserEntity insertedAliMoshiri = userRepository.save(aliMoshiri);

            UserEntity aliAmini = new UserEntity();
            aliAmini.setFirstName("ali");
            aliAmini.setLastName("amini");
            aliAmini.setActive(true);
            aliAmini.setNationalId("1122334455");
            aliAmini.setMobileNO("09213456789");

            UserEntity insertedAliAmini = userRepository.save(aliAmini);

            AccountEntity aliMoshiriFirstAccountEntity = new AccountEntity();
            aliMoshiriFirstAccountEntity.setAccountNumber("11111111");
            aliMoshiriFirstAccountEntity.setAmount(100000000L);
            aliMoshiriFirstAccountEntity.setActive(true);
            aliMoshiriFirstAccountEntity.setStatus(ConstantUtil.OperationStatus.SUCCESSFUL);
            aliMoshiriFirstAccountEntity.setUser(insertedAliMoshiri);

            AccountEntity insertedAliMoshiriFirstAccount = accountRepository.save(aliMoshiriFirstAccountEntity);

            AccountEntity aliMoshiriSecondAccountEntity = new AccountEntity();
            aliMoshiriSecondAccountEntity.setAccountNumber("22222222");
            aliMoshiriSecondAccountEntity.setAmount(10000L);
            aliMoshiriSecondAccountEntity.setActive(true);
            aliMoshiriSecondAccountEntity.setStatus(ConstantUtil.OperationStatus.SUCCESSFUL);
            aliMoshiriSecondAccountEntity.setUser(insertedAliMoshiri);

            AccountEntity insertedAliMoshiriSecondAccount = accountRepository.save(aliMoshiriSecondAccountEntity);

            AccountEntity aliAminiFirstAccountEntity = new AccountEntity();
            aliAminiFirstAccountEntity.setAccountNumber("33333333");
            aliAminiFirstAccountEntity.setActive(true);
            aliAminiFirstAccountEntity.setAmount(200000000L);
            aliAminiFirstAccountEntity.setStatus(ConstantUtil.OperationStatus.SUCCESSFUL);
            aliAminiFirstAccountEntity.setUser(insertedAliAmini);

            AccountEntity insertedAliAminiFirstAccount = accountRepository.save(aliAminiFirstAccountEntity);

            AccountEntity aliAminiSecondAccountEntity = new AccountEntity();
            aliAminiSecondAccountEntity.setAccountNumber("44444444");
            aliAminiSecondAccountEntity.setActive(true);
            aliAminiSecondAccountEntity.setAmount(200000L);
            aliAminiSecondAccountEntity.setStatus(ConstantUtil.OperationStatus.SUCCESSFUL);
            aliAminiSecondAccountEntity.setUser(insertedAliAmini);

            AccountEntity insertedAliAminiSecondAccount = accountRepository.save(aliAminiSecondAccountEntity);

            CardEntity aliMoshiriFirstCard = new CardEntity();
            aliMoshiriFirstCard.setAccount(insertedAliMoshiriFirstAccount);
            aliMoshiriFirstCard.setActive(true);
            aliMoshiriFirstCard.setCardNumber("5022-2910-2218-9999");
            aliMoshiriFirstCard.setCvv2("999");
            aliMoshiriFirstCard.setExpireMonth("09");
            aliMoshiriFirstCard.setExpireYear("99");
            aliMoshiriFirstCard.setPassword("9999");
            aliMoshiriFirstCard.setSecondPassword("99999999");
            aliMoshiriFirstCard.setStatus(ConstantUtil.OperationStatus.SUCCESSFUL);

            CardEntity insertedAliMoshiriFirstCard = cardRepository.save(aliMoshiriFirstCard);

            CardEntity aliMoshiriSecondCard = new CardEntity();
            aliMoshiriSecondCard.setAccount(insertedAliMoshiriSecondAccount);
            aliMoshiriSecondCard.setActive(true);
            aliMoshiriSecondCard.setCardNumber("5022-2910-2218-8888");
            aliMoshiriSecondCard.setCvv2("888");
            aliMoshiriSecondCard.setExpireMonth("08");
            aliMoshiriSecondCard.setExpireYear("98");
            aliMoshiriSecondCard.setPassword("8888");
            aliMoshiriSecondCard.setSecondPassword("88888888");
            aliMoshiriSecondCard.setStatus(ConstantUtil.OperationStatus.SUCCESSFUL);

            CardEntity insertedAliMoshiriSecondCard = cardRepository.save(aliMoshiriSecondCard);

            CardEntity aliAminiFirstCard = new CardEntity();
            aliAminiFirstCard.setAccount(insertedAliAminiFirstAccount);
            aliAminiFirstCard.setActive(true);
            aliAminiFirstCard.setCardNumber("6037-2910-2218-7777");
            aliAminiFirstCard.setCvv2("777");
            aliAminiFirstCard.setExpireMonth("07");
            aliAminiFirstCard.setExpireYear("99");
            aliAminiFirstCard.setPassword("7777");
            aliAminiFirstCard.setSecondPassword("77777777");
            aliAminiFirstCard.setStatus(ConstantUtil.OperationStatus.SUCCESSFUL);

            CardEntity insertedAliAminiFirstCard = cardRepository.save(aliAminiFirstCard);

            CardEntity aliAminiSecondCard = new CardEntity();
            aliAminiSecondCard.setAccount(insertedAliAminiSecondAccount);
            aliAminiSecondCard.setActive(true);
            aliAminiSecondCard.setCardNumber("5022-2910-2216-6666");
            aliAminiSecondCard.setCvv2("666");
            aliAminiSecondCard.setExpireMonth("06");
            aliAminiSecondCard.setExpireYear("98");
            aliAminiSecondCard.setPassword("6666");
            aliAminiSecondCard.setSecondPassword("66666666");
            aliAminiSecondCard.setStatus(ConstantUtil.OperationStatus.SUCCESSFUL);

            CardEntity insertedAliAminiSecondCard = cardRepository.save(aliAminiSecondCard);
        }

    }
}
