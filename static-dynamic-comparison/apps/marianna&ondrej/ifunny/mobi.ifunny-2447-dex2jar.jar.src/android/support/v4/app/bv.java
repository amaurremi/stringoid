package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;

import java.util.HashSet;
import java.util.Set;

public class bv {
    private static final int a;
    private static final Object b = new Object();
    private static String c;
    private static Set<String> d = new HashSet();
    private static final Object g = new Object();
    private static cd h;
    private static final bx i;
    private final Context e;
    private final NotificationManager f;

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            i = new ca();
        }
        for (; ; ) {
            a = i.a();
            return;
            if (Build.VERSION.SDK_INT >= 5) {
                i = new bz();
            } else {
                i = new by();
            }
        }
    }

    private bv(Context paramContext) {
        this.e = paramContext;
        this.f = ((NotificationManager) this.e.getSystemService("notification"));
    }

    public static bv a(Context paramContext) {
        return new bv(paramContext);
    }

    private void a(cf paramcf) {
        synchronized (g) {
            if (h == null) {
                h = new cd(this.e.getApplicationContext());
            }
            h.a(paramcf);
            return;
        }
    }

    private static boolean a(Notification paramNotification) {
        paramNotification = ar.a(paramNotification);
        return (paramNotification != null) && (paramNotification.getBoolean("android.support.useSideChannel"));
    }

    public static Set<String> b(Context paramContext) {
        paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "enabled_notification_listeners");
        HashSet localHashSet;
        if ((paramContext != null) && (!paramContext.equals(c))) {
            ???=paramContext.split(":");
            localHashSet = new HashSet( ???.length);
            int k =???.length;
            int j = 0;
            while (j < k) {
                ComponentName localComponentName = ComponentName.unflattenFromString( ???[j]);
                if (localComponentName != null) {
                    localHashSet.add(localComponentName.getPackageName());
                }
                j += 1;
            }
        }
        synchronized (b) {
            d = localHashSet;
            c = paramContext;
            return d;
        }
    }

    public void a(int paramInt) {
        a(null, paramInt);
    }

    public void a(int paramInt, Notification paramNotification) {
        a(null, paramInt, paramNotification);
    }

    public void a(String paramString, int paramInt) {
        i.a(this.f, paramString, paramInt);
        a(new bw(this.e.getPackageName(), paramInt, paramString));
    }

    public void a(String paramString, int paramInt, Notification paramNotification) {
        if (a(paramNotification)) {
            a(new cb(this.e.getPackageName(), paramInt, paramString, paramNotification));
            return;
        }
        i.a(this.f, paramString, paramInt, paramNotification);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */