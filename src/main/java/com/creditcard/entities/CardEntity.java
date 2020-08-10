package com.creditcard.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*
 *  Created by A.Moshiri on 8/3/2020
 *  @author Ali Moshiri Amin (a.moshiri.a@gmail.com)
 */

@Entity
@Table(name = CardEntity.TABLE_NAME,schema = "creditcards")
public class CardEntity extends AuditEntity<String>{

    public static final String TABLE_NAME = "CARD_TABLE";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID", nullable = false)
    private AccountEntity account;

    @Column(name = "CARD_NUMBER", precision = 19)
    @NotNull
    private String cardNumber;

    @Column(name = "PASSWORD", length = 6)
    @NotNull
    private String password;

    @Column(name = "SECOND_PASSWORD", precision = 10)
    private String secondPassword;

    @Column(name = "CVV2", precision = 3)
    @NotNull
    private String cvv2;

    @Column(name = "EXPIRE_MONTH", precision = 2)
    @NotNull
    private String expireMonth;

    @Column(name = "EXPIRE_YEAR", precision = 2)
    @NotNull
    private String expireYear;

    @Column(name ="IS_ACTIVE")
    private boolean isActive;

    @Column(name = "STATUS", length = 4)
    @NotNull
    private Long status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecondPassword() {
        return secondPassword;
    }

    public void setSecondPassword(String secondPassword) {
        this.secondPassword = secondPassword;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public String getExpireMonth() {
        return expireMonth;
    }

    public void setExpireMonth(String expireMonth) {
        this.expireMonth = expireMonth;
    }

    public String getExpireYear() {
        return expireYear;
    }

    public void setExpireYear(String expireYear) {
        this.expireYear = expireYear;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}
