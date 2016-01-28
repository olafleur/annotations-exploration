package com.olivierlafleur.guicetest;

import com.google.inject.AbstractModule;

public class BillingModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(TransactionLog.class).to(DatabaseLog.class);

        bind(CreditCardProcessor.class).to(PaypalProcessor.class);
    }
}
