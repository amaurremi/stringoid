package com.facebook.ads.internal.action;

import android.content.Context;
import android.net.Uri;

public class AdActionFactory {
    private static final String AD_ACTION_APP_AD = "store";
    private static final String AD_ACTION_LINK_AD = "open_link";

    public static AdAction getAdAction(Context paramContext, Uri paramUri) {
        String str = paramUri.getAuthority();
        if ("store".equals(str)) {
            return new AppAdAction(paramContext, paramUri);
        }
        if ("open_link".equals(str)) {
            return new LinkAdAction(paramContext, paramUri);
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/internal/action/AdActionFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */