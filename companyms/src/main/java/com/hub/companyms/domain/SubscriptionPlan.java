package com.hub.companyms.domain;

import lombok.Getter;

@Getter
public enum SubscriptionPlan {

    FREE("free"),
    BASIC("basic"),
    PRO("pro");

    private final String subscription;

    SubscriptionPlan(String subscription) {
        this.subscription = subscription;
    }

    @Override
    public String toString() {
        return subscription;
    }

}


