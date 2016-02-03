package android.support.v4.app;

import android.app.Notification;

class bc
        extends bb {
    public Notification a(aw paramaw) {
        Notification localNotification = paramaw.w;
        localNotification.setLatestEventInfo(paramaw.a, paramaw.b, paramaw.c, paramaw.d);
        localNotification = bo.a(localNotification, paramaw.a, paramaw.b, paramaw.c, paramaw.d, paramaw.e);
        if (paramaw.j > 0) {
            localNotification.flags |= 0x80;
        }
        return localNotification;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */