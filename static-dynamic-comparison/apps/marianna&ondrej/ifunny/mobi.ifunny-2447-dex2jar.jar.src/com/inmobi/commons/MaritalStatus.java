package com.inmobi.commons;

public enum MaritalStatus {
    static {
        RELATIONSHIP = new MaritalStatus("RELATIONSHIP", 1);
        ENGAGED = new MaritalStatus("ENGAGED", 2);
    }

    private MaritalStatus() {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/MaritalStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */