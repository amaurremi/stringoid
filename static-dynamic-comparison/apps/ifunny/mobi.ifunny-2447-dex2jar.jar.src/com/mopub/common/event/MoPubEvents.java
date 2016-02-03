package com.mopub.common.event;

import android.os.HandlerThread;
import com.mopub.common.ClientMetadata;
import com.mopub.common.VisibleForTesting;

import java.util.ArrayList;

public class MoPubEvents {
    private static volatile MoPubEvents.EventDispatcher a;

    private static MoPubEvents.EventDispatcher a() {
        Object localObject = a;
        if (localObject == null) {
            try {
                MoPubEvents.EventDispatcher localEventDispatcher2 = a;
                localObject = localEventDispatcher2;
                if (localEventDispatcher2 == null) {
                    localObject = new ArrayList();
                    ((ArrayList) localObject).add(new c(null));
                    localObject = new MoPubEvents.EventDispatcher((Iterable) localObject, new HandlerThread("mopub_event_queue"));
                    a = (MoPubEvents.EventDispatcher) localObject;
                }
                return (MoPubEvents.EventDispatcher) localObject;
            } finally {
            }
        }
        return localEventDispatcher1;
    }

    public static void event(BaseEvent.Type paramType, String paramString) {
        MoPubEvents.EventDispatcher.a(a(), new Event(paramType, paramString, ClientMetadata.getInstance()));
    }

    @VisibleForTesting
    public static void setEventDispatcher(MoPubEvents.EventDispatcher paramEventDispatcher) {
        a = paramEventDispatcher;
    }

    public static TimedEvent timedEvent(BaseEvent.Type paramType, String paramString) {
        MoPubEvents.EventDispatcher localEventDispatcher = a();
        return new TimedEvent(paramType, paramString, ClientMetadata.getInstance(), localEventDispatcher);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/event/MoPubEvents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */