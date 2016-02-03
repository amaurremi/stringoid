package com.inmobi.commons.internal;

public enum Log$INTERNAL_LOG_LEVEL {
    private final int a;

    static {
        NONE = new INTERNAL_LOG_LEVEL("NONE", 1, 0);
        DEBUG = new INTERNAL_LOG_LEVEL("DEBUG", 2, 1);
        VERBOSE = new INTERNAL_LOG_LEVEL("VERBOSE", 3, 2);
    }

    private Log$INTERNAL_LOG_LEVEL(int paramInt) {
        this.a = paramInt;
    }

    public int getValue() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/internal/Log$INTERNAL_LOG_LEVEL.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */