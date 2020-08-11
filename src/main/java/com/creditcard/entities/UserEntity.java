package com.creditcard.entities;

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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
