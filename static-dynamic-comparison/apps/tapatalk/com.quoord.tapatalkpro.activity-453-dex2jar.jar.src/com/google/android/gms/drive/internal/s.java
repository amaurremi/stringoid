package com.google.android.gms.drive.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.DriveEvent.Listener;
import com.google.android.gms.internal.fq;

public class s<C extends DriveEvent>
        extends w.a {
    private final int ES;
    private final a<C> FA;
    private final DriveEvent.Listener<C> Fz;

    public s(Looper paramLooper, int paramInt, DriveEvent.Listener<C> paramListener) {
        this.ES = paramInt;
        this.Fz = paramListener;
        this.FA = new a(paramLooper, null);
    }

    public void a(OnEventResponse paramOnEventResponse)
            throws RemoteException {
        if (this.ES == paramOnEventResponse.getEventType()) {
        }
        for (boolean bool = true; ; bool = false) {
            fq.x(bool);
            switch (paramOnEventResponse.getEventType()) {
                default:
                    Log.w("EventCallback", "Unexpected event type:" + paramOnEventResponse.getEventType());
                    return;
            }
        }
        this.FA.a(this.Fz, paramOnEventResponse.fL());
        return;
        this.FA.a(this.Fz, paramOnEventResponse.fM());
    }

    private static class a<E extends DriveEvent>
            extends Handler {
        private a(Looper paramLooper) {
            super();
        }

        public void a(DriveEvent.Listener<E> paramListener, E paramE) {
            sendMessage(obtainMessage(1, new Pair(paramListener, paramE)));
        }

        public void handleMessage(Message paramMessage) {
            switch (paramMessage.what) {
                default:
                    Log.wtf("EventCallback", "Don't know how to handle this event");
                    return;
            }
            paramMessage = (Pair) paramMessage.obj;
            ((DriveEvent.Listener) paramMessage.first).onEvent((DriveEvent) paramMessage.second);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/internal/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */