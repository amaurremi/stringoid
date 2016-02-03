package android.support.v4.app;

import android.os.Bundle;

class cr {
    static Bundle a(cp paramcp) {
        Bundle localBundle = new Bundle();
        localBundle.putString("resultKey", paramcp.a());
        localBundle.putCharSequence("label", paramcp.b());
        localBundle.putCharSequenceArray("choices", paramcp.c());
        localBundle.putBoolean("allowFreeFormInput", paramcp.d());
        localBundle.putBundle("extras", paramcp.e());
        return localBundle;
    }

    static Bundle[] a(cp[] paramArrayOfcp) {
        if (paramArrayOfcp == null) {
            return null;
        }
        Bundle[] arrayOfBundle = new Bundle[paramArrayOfcp.length];
        int i = 0;
        while (i < paramArrayOfcp.length) {
            arrayOfBundle[i] = a(paramArrayOfcp[i]);
            i += 1;
        }
        return arrayOfBundle;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/cr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */