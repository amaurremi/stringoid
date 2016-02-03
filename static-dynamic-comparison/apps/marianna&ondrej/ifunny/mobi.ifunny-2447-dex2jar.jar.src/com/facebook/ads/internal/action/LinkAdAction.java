package com.facebook.ads.internal.action;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

public class LinkAdAction
        implements AdAction {
    private static final String TAG = LinkAdAction.class.getSimpleName();
    private final Context context;
    private final Uri uri;

    public LinkAdAction(Context paramContext, Uri paramUri) {
        this.context = paramContext;
        this.uri = paramUri;
    }

    public void execute() {
        Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(this.uri.getQueryParameter("link")));
        try {
            this.context.startActivity(localIntent);
            return;
        } catch (Exception localException) {
            Log.d(TAG, "Failed to open market url: " + this.uri.toString(), localException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/internal/action/LinkAdAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */