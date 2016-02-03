package android.support.v4.app;

import android.app.Notification;
import android.os.Bundle;
import android.os.Parcelable;

import java.util.ArrayList;

class bb
        implements az {
    public Notification a(aw paramaw) {
        Notification localNotification = paramaw.w;
        localNotification.setLatestEventInfo(paramaw.a, paramaw.b, paramaw.c, paramaw.d);
        if (paramaw.j > 0) {
            localNotification.flags |= 0x80;
        }
        return localNotification;
    }

    public Bundle a(Notification paramNotification) {
        return null;
    }

    public ArrayList<Parcelable> a(as[] paramArrayOfas) {
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */