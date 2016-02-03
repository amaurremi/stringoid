package android.support.v4.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;

class cn {
    static RemoteInput[] a(cp[] paramArrayOfcp) {
        if (paramArrayOfcp == null) {
            return null;
        }
        RemoteInput[] arrayOfRemoteInput = new RemoteInput[paramArrayOfcp.length];
        int i = 0;
        while (i < paramArrayOfcp.length) {
            cp localcp = paramArrayOfcp[i];
            arrayOfRemoteInput[i] = new RemoteInput.Builder(localcp.a()).setLabel(localcp.b()).setChoices(localcp.c()).setAllowFreeFormInput(localcp.d()).addExtras(localcp.e()).build();
            i += 1;
        }
        return arrayOfRemoteInput;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */