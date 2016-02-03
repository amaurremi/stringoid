package com.everimaging.fotorsdk.store;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

public class h {
    public static String a = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyHn6gtNzcldeTk0m1Bb/xKQS9xTTr3H6CXUiithZWT6XoN8RkVE03nhR91wHCo2FQ7JZLg8TlZkRTG1LxousVpCC9NspnLueptz36wRX3TjjtlSM5Bl2yqNLYLYMtexhV6sPuTICa9DQPkcBW06N52rla13QXY9TPUDqYizZSEwxOZFkqEg/aC38/NkRO85Q3aILyrQ5p9UUPLwbYvkIGTXfi33q9K5Ndxyx4QIXW+u9y13sYp7H0S7WHTaOvcTcZFHM3P7DfgwIKy/Ejjo74v/uuRUb3gDLVX2HzqlWesjNXHWFY3bQ2w1wl1jiVoVVTzSvW/2FMJENDiXzBRzaXQIDAQAB";
    private static final String b = h.class.getSimpleName();
    private static final FotorLoggerFactory.c c = FotorLoggerFactory.a(b, FotorLoggerFactory.LoggerType.CONSOLE);
    private static boolean d = false;
    private static a e = new a(null);

    public static final String a() {
        return a;
    }

    public static void a(Activity paramActivity) {
        c.a().a(paramActivity);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        paramActivity.registerReceiver(e, localIntentFilter);
    }

    public static final void a(Context paramContext) {
        if (!d) {
            com.everimaging.fotorsdk.store.utils.c.a(null, paramContext, true);
            d = true;
        }
    }

    public static void b(Activity paramActivity) {
        c.a().b(paramActivity);
        paramActivity.unregisterReceiver(e);
    }

    private static class a
            extends BroadcastReceiver {
        public void onReceive(Context paramContext, Intent paramIntent) {
            h.b().c(new Object[]{"ConnectivityChangedReceiver->onReceive:" + paramIntent});
            if (!com.everimaging.fotorsdk.store.utils.c.a()) {
                paramIntent = (ConnectivityManager) paramContext.getSystemService("connectivity");
                if (paramIntent == null) {
                    break label79;
                }
                paramIntent = paramIntent.getActiveNetworkInfo();
                if (paramIntent == null) {
                    break label79;
                }
            }
            label79:
            for (boolean bool = paramIntent.isConnected(); ; bool = false) {
                if (bool) {
                    com.everimaging.fotorsdk.store.utils.c.a(null, paramContext, true);
                }
                return;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/store/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */