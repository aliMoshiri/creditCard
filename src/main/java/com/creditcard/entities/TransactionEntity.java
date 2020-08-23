package com.creditcard.entities;

import com.creditcard.util.ConstantUtil;
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


    public static final String SEQUENCE_TABLE_NAME = ConstantUtil.CommonFields.CREDIT_CARDS_SCHEMA + "." + TABLE_NAME;
    public static final String SEQUENCE_NAME_MAIN = SEQUENCE_TABLE_NAME + "_SEQ";
    public static final String SEQUENCE_NAME_GENERATOR = SEQUENCE_TABLE_NAME + "_SEQUENCE";

    @Id
    @SequenceGenerator(name = SEQUENCE_NAME_GENERATOR, sequenceName = SEQUENCE_NAME_MAIN, initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME_GENERATOR)
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
