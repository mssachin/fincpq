package com.finastra.cpq.finastraCPQ.deserializedjsonresponseobjects.sfsubscriptionsassociatedtoabillinggroup;

import com.finastra.cpq.finastraCPQ.deserializedjsonresponseobjects.commondeserializedobjects.SFObjectResponseAttributes;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class SFSingleSubscriptionDetailsJsonResponse {

    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    private SFObjectResponseAttributes SFObjectResponseAttributes;

    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    private String nextBillingDate;

    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    private String nextSOGenerationDate;

    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    private String recurringNSItem;

    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    private String recurringSalesOrderType;


}
