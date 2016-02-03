package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;

class bo {
    public static Notification a(Notification paramNotification, Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2) {
        paramNotification.setLatestEventInfo(paramContext, paramCharSequence1, paramCharSequence2, paramPendingIntent1);
        paramNotification.fullScreenIntent = paramPendingIntent2;
        return paramNotification;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */