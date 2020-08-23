package com.creditcard.entities;

import com.creditcard.util.ConstantUtil;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*
 *  Created by A.Moshiri on 8/3/2020
 *  @author Ali Moshiri Amin (a.moshiri.a@gmail.com)
 */

@Entity
@Table(name = AccountEntity.TABLE_NAME, schema = "creditcards")
@Data
public class AccountEntity extends AuditEntity<String>{
    public static final String TABLE_NAME = "ACCOUNT_TABLE";
    public static final String SEQUENCE_TABLE_NAME = ConstantUtil.CommonFields.CREDIT_CARDS_SCHEMA + "." + TABLE_NAME;
    public static final String SEQUENCE_NAME_MAIN = SEQUENCE_TABLE_NAME + "_SEQ";
    public static final String SEQUENCE_NAME_GENERATOR = SEQUENCE_TABLE_NAME + "_SEQUENCE";

    @Id
    @SequenceGenerator(name = SEQUENCE_NAME_GENERATOR, sequenceName = SEQUENCE_NAME_MAIN, initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME_GENERATOR)
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

}
