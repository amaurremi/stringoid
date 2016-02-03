package com.mopub.common.event;

import com.mopub.common.ClientMetadata;

import java.util.concurrent.TimeUnit;

public class TimedEvent
        extends BaseEvent {
    public static final int SC_NOT_RELEVANT = 0;
    public static final int SC_NO_RESPONSE = -1;
    private final long a = System.nanoTime();
    private e b = e.WAITING;
    private final d c;
    private long d;
    private int e;

    TimedEvent(BaseEvent.Type paramType, String paramString, ClientMetadata paramClientMetadata, d paramd) {
        super(paramType, paramString, paramClientMetadata);
        this.c = paramd;
    }

    public void cancel() {
        try {
            if (this.b == e.WAITING) {
                this.b = e.CANCELLED;
                if (this.c != null) {
                    this.c.onCancelled(this);
                }
            }
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public final long getDurationMillis() {
        try {
            long l = this.d;
            return l;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public final int getHttpStatusCode() {
        try {
            int i = this.e;
            return i;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public void stop(int paramInt) {
        try {
            if (this.b == e.WAITING) {
                this.b = e.STOPPED;
                this.e = paramInt;
                long l = System.nanoTime();
                this.d = TimeUnit.MILLISECONDS.convert(l - this.a, TimeUnit.NANOSECONDS);
                if (this.c != null) {
                    this.c.onStopped(this);
                }
            }
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/event/TimedEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */