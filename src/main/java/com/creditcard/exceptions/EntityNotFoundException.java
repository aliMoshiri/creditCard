package com.creditcard.exceptions;

/*
 *  Created by A.Moshiri on 8/2/2020
 *  @author Ali Moshiri Amin (a.moshiri.a@gmail.com)
 */


public class EntityNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 6934744629594572993L;

    public EntityNotFoundException(String id) {
        super("could not find entity '" + id + "'.");
    }
}