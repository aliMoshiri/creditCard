package com.creditcard.entities;

import com.creditcard.util.ConstantUtil;
import lombok.Data;

import javax.persistence.*;

/*
 *  Created by A.Moshiri on 8/3/2020
 *  @author Ali Moshiri Amin (a.moshiri.a@gmail.com)
 */

@Entity
@Table(name = UserEntity.TABLE_NAME, schema = "creditcards")
@Data
public class UserEntity extends AuditEntity<String>{

    public static final String TABLE_NAME = "USER_TABLE";


    public static final String SEQUENCE_TABLE_NAME = ConstantUtil.CommonFields.CREDIT_CARDS_SCHEMA + "." + TABLE_NAME;
    public static final String SEQUENCE_NAME_MAIN = SEQUENCE_TABLE_NAME + "_SEQ";
    public static final String SEQUENCE_NAME_GENERATOR = SEQUENCE_TABLE_NAME + "_SEQUENCE";

    @Id
    @SequenceGenerator(name = SEQUENCE_NAME_GENERATOR, sequenceName = SEQUENCE_NAME_MAIN, initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME_GENERATOR)
    private Long id;

    @Column(name = "USER_NAME", unique = true)
    private String userName;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "NATIONAL_ID", unique = true)
    private String nationalId;


    @Column(name = "MOBILE_NO", unique = true)
    private String mobileNo;

    @Column(name = "IS_ACTIVE")
    private boolean isActive;

    public Long getId() {
        return id;
    }
}
