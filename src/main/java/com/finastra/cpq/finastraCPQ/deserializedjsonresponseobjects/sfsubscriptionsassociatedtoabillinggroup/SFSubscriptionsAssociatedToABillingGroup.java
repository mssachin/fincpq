package com.finastra.cpq.finastraCPQ.deserializedjsonresponseobjects.sfsubscriptionsassociatedtoabillinggroup;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class SFSubscriptionsAssociatedToABillingGroup {

    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    private Integer totalSize;

    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    private boolean done;

    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    private SFSingleSubscriptionDetailsJsonResponse[] records;


}
