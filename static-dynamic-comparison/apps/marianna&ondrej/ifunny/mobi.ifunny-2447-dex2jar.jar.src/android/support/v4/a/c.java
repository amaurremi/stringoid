package android.support.v4.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;

public class c {
    public static boolean a(Context paramContext, Intent[] paramArrayOfIntent, Bundle paramBundle) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 16) {
            e.a(paramContext, paramArrayOfIntent, paramBundle);
            return true;
        }
        if (i >= 11) {
            d.a(paramContext, paramArrayOfIntent);
            return true;
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */