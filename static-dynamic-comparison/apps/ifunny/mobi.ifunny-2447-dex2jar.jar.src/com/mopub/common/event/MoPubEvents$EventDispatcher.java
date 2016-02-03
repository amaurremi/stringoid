package com.mopub.common.event;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.mopub.common.VisibleForTesting;

@VisibleForTesting
public class MoPubEvents$EventDispatcher
        implements d {
    @VisibleForTesting
    Handler.Callback a;
    private final Iterable<EventRecorder> b;
    private final HandlerThread c;
    private final Handler d;

    @VisibleForTesting
    MoPubEvents$EventDispatcher(Iterable<EventRecorder> paramIterable, HandlerThread paramHandlerThread) {
        this.b = paramIterable;
        this.a = new b(this);
        this.c = paramHandlerThread;
        this.c.start();
        this.d = new Handler(this.c.getLooper(), this.a);
    }

    private void a(BaseEvent paramBaseEvent) {
        Message.obtain(this.d, 0, paramBaseEvent).sendToTarget();
    }

    public void onCancelled(TimedEvent paramTimedEvent) {
    }

    public void onStopped(TimedEvent paramTimedEvent) {
        a(paramTimedEvent);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/event/MoPubEvents$EventDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */