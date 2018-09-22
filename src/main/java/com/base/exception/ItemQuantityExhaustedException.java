package com.base.exception;

public class ItemQuantityExhaustedException extends RuntimeException
{
    public ItemQuantityExhaustedException(String message){
        super(message);
    }
}
