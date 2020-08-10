package com.creditcard.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*
 *  Created by A.Moshiri on 8/3/2020
 *  @author Ali Moshiri Amin (a.moshiri.a@gmail.com)
 */

@Entity
@Table(name = AccountEntity.TABLE_NAME, schema = "creditcards")

public class AccountEntity extends AuditEntity<String>{
    public static final String TABLE_NAME = "ACCOUNT_TABLE";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "id", nullable = false)
    private UserEntity user;

    @Column(name = "ACCOUNT_NUMBER", precision = 8,unique = true)
    @NotNull
    private String accountNumber;

    @Column(name = "AMOUNT", precision = 18)
    @NotNull
    private Long amount;

    @Column(name = "STATUS", length = 4)
    @Version
    private Long status;

    @Column(name = "IS_ACTIVE")
    private boolean isActive;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

}
