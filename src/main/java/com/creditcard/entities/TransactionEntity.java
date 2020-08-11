package com.creditcard.entities;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/*
 *  Created by A.Moshiri on 8/3/2020
 *  @author Ali Moshiri Amin (a.moshiri.a@gmail.com)
 */

@Entity
@Table(name = TransactionEntity.TABLE_NAME,schema = "creditcards")
@Data
public class TransactionEntity extends AuditEntity<String>{
    public static final String TABLE_NAME = "TRANSACTION_TABLE";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "STATUS", length = 4)
    @NotNull
    private Long status;

    @Column(name = "CARD_NUMBER", precision = 20)
    @NotNull
    private String cardNumber;

    @Column(name = "AMOUNT", precision = 18)
    @NotNull
    private Long amount;

    @Column(name ="description")
    private String description;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date createDate;

    @Column(name ="IS_DEPOSIT")
    private boolean isDeposit;


}
