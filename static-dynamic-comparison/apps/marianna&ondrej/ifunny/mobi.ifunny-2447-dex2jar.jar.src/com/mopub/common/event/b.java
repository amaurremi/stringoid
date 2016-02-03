package com.mopub.common.event;

import android.os.Handler.Callback;
import android.os.Message;

import java.util.Iterator;

class b
        implements Handler.Callback {
    b(MoPubEvents.EventDispatcher paramEventDispatcher) {
    }

    public boolean handleMessage(Message paramMessage) {
        Iterator localIterator;
        if ((paramMessage.obj instanceof TimedEvent)) {
            paramMessage = (TimedEvent) paramMessage.obj;
            localIterator = MoPubEvents.EventDispatcher.a(this.a).iterator();
            while (localIterator.hasNext()) {
                ((EventRecorder) localIterator.next()).recordTimedEvent(paramMessage);
            }
        }
        if ((paramMessage.obj instanceof Event)) {
            paramMessage = (Event) paramMessage.obj;
            localIterator = MoPubEvents.EventDispatcher.a(this.a).iterator();
            while (localIterator.hasNext()) {
                ((EventRecorder) localIterator.next()).recordEvent(paramMessage);
            }
        }
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/event/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */