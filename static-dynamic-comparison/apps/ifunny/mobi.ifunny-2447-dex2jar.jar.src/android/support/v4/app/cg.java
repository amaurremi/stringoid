package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;

class cg {
    static void a(NotificationManager paramNotificationManager, String paramString, int paramInt) {
        paramNotificationManager.cancel(paramString, paramInt);
    }

    public static void a(NotificationManager paramNotificationManager, String paramString, int paramInt, Notification paramNotification) {
        paramNotificationManager.notify(paramString, paramInt, paramNotification);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */