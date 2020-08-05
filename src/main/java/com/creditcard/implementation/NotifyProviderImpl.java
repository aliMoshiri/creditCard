package com.creditcard.implementation;

import com.creditcard.model.NotifyModel;
import com.creditcard.service.NotifyProvider;

/*
 *  Created by A.Moshiri on 8/4/2020
 *  @author Ali Moshiri Amin (a.moshiri.a@gmail.com)
 */


public class NotifyProviderImpl {
private NotifyProvider notifyProvider;

    public NotifyProvider getNotifyProvider() {
        return notifyProvider;
    }

    public void setNotifyProvider(NotifyProvider notifyProvider) {
        this.notifyProvider = notifyProvider;
    }

    public void notify(NotifyModel notifyModel){
        notifyProvider.notify(notifyModel);
    }
}
