package com.cydeo.enums;

import lombok.Getter;

@Getter
public enum Status
    {
    OPEN("open"), IN_PROGRESS("in progress"), COMPLETE("complete");

    private final String value;

    Status(String value)
        {
        this.value = value;
        }
    }
