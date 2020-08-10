package com.creditcard.implementation;
/*
 *  Created by  a.moshiri on 8/10/2020
 *  @author Ali Moshiri Amin (a.moshiri@navaco.ir)
 */

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Ali Moshiri");
    }
}
