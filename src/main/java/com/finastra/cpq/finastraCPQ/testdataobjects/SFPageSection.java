package com.finastra.cpq.finastraCPQ.testdataobjects;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class SFPageSection implements Comparable<SFPageSection> {

    @Getter
    @Setter
    private String columnName;

    @Getter
    @Setter
    private boolean isHelpTextPresent;

    @Getter
    @Setter
    private boolean isFieldEditable;

    @Getter
    @Setter
    private Integer rowNumber;

    @Getter
    @Setter
    private Integer columnNumber;


    @Override
    public int compareTo(SFPageSection o) {
        Integer sumOfThisRowAndColumnIndex = this.rowNumber + this.columnNumber;
        Integer sumOfComparedToObjectRowAndColumnIndex = o.getRowNumber() + o.getColumnNumber();
        return sumOfThisRowAndColumnIndex - sumOfComparedToObjectRowAndColumnIndex;
    }
}
