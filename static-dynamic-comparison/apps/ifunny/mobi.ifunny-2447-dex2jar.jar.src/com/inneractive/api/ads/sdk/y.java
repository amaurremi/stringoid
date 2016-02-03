package com.inneractive.api.ads.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.util.Map;

final class y
        extends p {
    y(Map paramMap, IAmraidWebView paramIAmraidWebView) {
        super(paramMap, paramIAmraidWebView);
    }

    private static boolean a(Context paramContext, Intent paramIntent, String paramString) {
        try {
            paramContext.startActivity(paramIntent);
            return true;
        } catch (Exception paramContext) {
            if (paramString == null) {
            }
        }
        for (; ; ) {
            InneractiveAdView.Log.v("Inneractive_verbose", paramString);
            return false;
            paramString = "Failed to start intent!";
        }
    }

    final void a() {
        if (this.b.getListener() != null) {
            this.b.getListener().onClicked();
        }
        Object localObject2 = b("url");
        if (localObject2 == null) {
            this.b.fireErrorEvent(IAmraidActionFactory.MraidJavascriptCommand.d, "Url can not be null.");
        }
        do {
            return;
            InneractiveAdView.Log.d("Inneractive_debug", "Show Internal Browser For Url: " + (String) localObject2);
            if (localObject2 != null) {
                localObject1 = localObject2;
                if (!"".equals(localObject2)) {
                }
            } else {
                localObject1 = "about:blank";
            }
            localObject2 = new Intent(this.b.getContext(), InneractiveInternalBrowserActivity.class);
            ((Intent) localObject2).putExtra("extra_url", (String) localObject1);
            ((Intent) localObject2).addFlags(268435456);
        }
        while (a(this.b.getContext(), (Intent) localObject2, "Could not handle intent action. . Perhaps you forgot to declare com.inneractive.ads.api.sdk.InneractiveInternalBrowserActivity in your Android manifest file."));
        Object localObject1 = new Intent("android.intent.action.VIEW", Uri.parse("about:blank"));
        ((Intent) localObject1).setFlags(268435456);
        a(this.b.getContext(), (Intent) localObject1, null);
    }

    protected final boolean a(IAmraidWebView.MraidPlacementType paramMraidPlacementType) {
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */