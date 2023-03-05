package com.hx.inter;

public class IsolationException extends Throwable {
    public IsolationException(Object propertyIllegal, ReflectiveOperationException e) {
        super(propertyIllegal.toString());
    }

    public IsolationException(Object regionInvalid) {
        super(regionInvalid.toString());
    }
}
