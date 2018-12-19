package com.finastra.cpq.finastraCPQ.deserializedjsonresponseobjects.sfsalesordersassociatedtoabillinggroup;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class SFSalesOrdersAssociatedToABillingGroup {


    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    private Integer totalSize;

    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    private boolean done;

    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    private SFSingleSalesOrderDetailsJsonResponse[] records;
}
