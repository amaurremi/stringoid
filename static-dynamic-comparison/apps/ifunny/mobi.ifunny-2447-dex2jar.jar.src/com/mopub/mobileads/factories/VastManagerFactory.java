package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.mobileads.util.vast.VastManager;

public class VastManagerFactory {
    protected static VastManagerFactory a = new VastManagerFactory();

    public static VastManager create(Context paramContext) {
        return a.internalCreate(paramContext);
    }

    @Deprecated
    public static void setInstance(VastManagerFactory paramVastManagerFactory) {
        a = paramVastManagerFactory;
    }

    public VastManager internalCreate(Context paramContext) {
        return new VastManager(paramContext);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/factories/VastManagerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */