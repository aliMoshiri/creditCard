package com.creditcard.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*
 *  Created by A.Moshiri on 8/3/2020
 *  @author Ali Moshiri Amin (a.moshiri.a@gmail.com)
 */

@Entity
@Table(name = CardEntity.TABLE_NAME,schema = "creditcards")
@Data
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

}
