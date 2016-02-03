package com.facebook;

import java.io.Serializable;

class FacebookTimeSpentData$SerializationProxyV1
        implements Serializable {
    private static final long serialVersionUID = 6L;
    private final int interruptionCount;
    private final long lastResumeTime;
    private final long lastSuspendTime;
    private final long millisecondsSpentInSession;

    FacebookTimeSpentData$SerializationProxyV1(long paramLong1, long paramLong2, long paramLong3, int paramInt) {
        this.lastResumeTime = paramLong1;
        this.lastSuspendTime = paramLong2;
        this.millisecondsSpentInSession = paramLong3;
        this.interruptionCount = paramInt;
    }

    private Object readResolve() {
        return new FacebookTimeSpentData(this.lastResumeTime, this.lastSuspendTime, this.millisecondsSpentInSession, this.interruptionCount, null);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/FacebookTimeSpentData$SerializationProxyV1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */