package com.mopub.mobileads.factories;

import com.mopub.mobileads.AdFetcher;
import com.mopub.mobileads.AdViewController;

public class AdFetcherFactory {
    protected static AdFetcherFactory a = new AdFetcherFactory();

    public static AdFetcher create(AdViewController paramAdViewController, String paramString) {
        return a.a(paramAdViewController, paramString);
    }

    @Deprecated
    public static void setInstance(AdFetcherFactory paramAdFetcherFactory) {
        a = paramAdFetcherFactory;
    }

    protected AdFetcher a(AdViewController paramAdViewController, String paramString) {
        return new AdFetcher(paramAdViewController, paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/factories/AdFetcherFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */