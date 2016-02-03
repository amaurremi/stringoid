package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.mobileads.MoPubView;

public class MoPubViewFactory {
    protected static MoPubViewFactory a = new MoPubViewFactory();

    public static MoPubView create(Context paramContext) {
        return a.a(paramContext);
    }

    @Deprecated
    public static void setInstance(MoPubViewFactory paramMoPubViewFactory) {
        a = paramMoPubViewFactory;
    }

    protected MoPubView a(Context paramContext) {
        return new MoPubView(paramContext);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/factories/MoPubViewFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */