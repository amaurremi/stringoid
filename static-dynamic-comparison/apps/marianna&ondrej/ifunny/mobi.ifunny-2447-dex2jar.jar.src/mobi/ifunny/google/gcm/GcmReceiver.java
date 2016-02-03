package mobi.ifunny.google.gcm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.a.aa;
import mobi.ifunny.d;

public class GcmReceiver
        extends aa {
    private static final String a = GcmReceiver.class.getSimpleName();

    public void onReceive(Context paramContext, Intent paramIntent) {
        d.c(a, "onReceive " + paramIntent);
        a(paramContext, paramIntent.setComponent(new ComponentName(paramContext.getPackageName(), GcmService.class.getName())));
        setResultCode(-1);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/google/gcm/GcmReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */