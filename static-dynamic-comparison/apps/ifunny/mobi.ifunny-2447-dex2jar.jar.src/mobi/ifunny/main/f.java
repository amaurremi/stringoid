package mobi.ifunny.main;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesUtil;

import java.util.GregorianCalendar;

import mobi.ifunny.b.a;
import mobi.ifunny.b.e;
import mobi.ifunny.d;
import mobi.ifunny.rest.retrofit.RestService;

public abstract class f
        extends h {
    public static final String o = f.class.getSimpleName();
    private static final long p = new GregorianCalendar(2014, 2, 27).getTimeInMillis();

    private static int a(Context paramContext) {
        try {
            int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
            return i;
        } catch (PackageManager.NameNotFoundException paramContext) {
            throw new RuntimeException("Could not get package name: " + paramContext);
        }
    }

    private void b(Context paramContext, String paramString) {
        int i = a(paramContext);
        d.c(o, String.format("Storing push registration id for app version %d\n%s", new Object[]{Integer.valueOf(i), paramString}));
        paramContext = mobi.ifunny.h.a();
        paramContext.b("pref.push.version", i);
        paramContext.b("pref.push.registration_id", paramString);
        paramContext.b("pref.push.registration_id_sent", false);
    }

    private static void c(Context paramContext, String paramString) {
        Intent localIntent = new Intent(paramContext, RestService.class);
        localIntent.setAction("mobi.ifunny.app.push");
        localIntent.putExtra("app.put_push.type", "token_gcm");
        localIntent.putExtra("app.put_push.id", paramString);
        paramContext.startService(localIntent);
    }

    private boolean p() {
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (i != 0) {
            if (GooglePlayServicesUtil.isUserRecoverableError(i)) {
                GooglePlayServicesUtil.getErrorDialog(i, this, 9000).show();
            }
            for (; ; ) {
                return false;
                d.c(o, "Google play services is not available on this device");
            }
        }
        return true;
    }

    private void q() {
        d.c(o, "checkGcmRegistration");
        mobi.ifunny.h localh = mobi.ifunny.h.a();
        String str = localh.a("pref.push.registration_id", null);
        if (str == null) {
            d.c(o, "Do not have stored registration id. Registering..");
            r();
        }
        do {
            return;
            d.c(o, "Saved registration id " + str);
            if (localh.a("pref.push.version", Integer.MIN_VALUE) != a(this)) {
                break;
            }
        } while (localh.a("pref.push.registration_id_sent", false));
        d.d(o, "Registration id is not sent. Sending..");
        c(this, str);
        return;
        d.d(o, "App version changed. Registering..");
        r();
    }

    private void r() {
        new g(this).execute(new Void[]{null, null});
    }

    protected void onCreate(Bundle paramBundle) {
        boolean bool3 = false;
        bool1 = false;
        super.onCreate(paramBundle);
        if (p()) {
            q();
        }
        if (!e.a()) {
            l = mobi.ifunny.h.a().a("pref.first_launch", 0L);
            bool2 = bool3;
        }
        try {
            paramBundle = getPackageManager().getPackageInfo(getPackageName(), 0);
            if (l > 0L) {
                break label152;
            }
            bool2 = bool3;
            if (paramBundle.firstInstallTime >= p) {
            }
        } catch (PackageManager.NameNotFoundException paramBundle) {
            for (; ; ) {
                mobi.ifunny.h localh;
                continue;
                bool1 = true;
            }
        }
        boolean bool2 = bool1;
        if (l == 0L) {
            bool2 = bool1;
            localh = mobi.ifunny.h.a();
            bool2 = bool1;
            if (paramBundle.firstInstallTime >= p) {
                break label138;
            }
            bool2 = bool1;
        }
        for (long l = paramBundle.firstInstallTime; ; l = System.currentTimeMillis()) {
            bool2 = bool1;
            localh.b("pref.first_launch", l);
            bool2 = bool1;
            e.a(getApplicationContext(), this, bool2);
            return;
            label138:
            bool2 = bool1;
        }
    }

    protected void onResume() {
        super.onResume();
        e.b();
    }

    protected void onStop() {
        a.a(this);
        super.onStop();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/main/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */