package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.mobileads.AdViewController;
import com.mopub.mobileads.MoPubView;

public class AdViewControllerFactory {
    protected static AdViewControllerFactory a = new AdViewControllerFactory();

    public static AdViewController create(Context paramContext, MoPubView paramMoPubView) {
        return a.a(paramContext, paramMoPubView);
    }

    @Deprecated
    public static void setInstance(AdViewControllerFactory paramAdViewControllerFactory) {
        a = paramAdViewControllerFactory;
    }

    protected AdViewController a(Context paramContext, MoPubView paramMoPubView) {
        return new AdViewController(paramContext, paramMoPubView);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/factories/AdViewControllerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */