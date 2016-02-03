package com.inneractive.api.ads.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

final class IAmraidWebViewController$b
        extends BroadcastReceiver {
    private Context mContext;
    private int mLastRotation;

    IAmraidWebViewController$b(IAmraidWebViewController paramIAmraidWebViewController) {
    }

    private boolean isRegistered() {
        return this.mContext != null;
    }

    public final void onReceive(Context paramContext, Intent paramIntent) {
        if (!isRegistered()) {
        }
        int i;
        do {
            do {
                return;
            } while (!"android.intent.action.CONFIGURATION_CHANGED".equals(paramIntent.getAction()));
            i = IAmraidWebViewController.access$700(this.this$0);
        } while (i == this.mLastRotation);
        this.mLastRotation = i;
        IAmraidWebViewController.access$800(this.this$0, this.mLastRotation);
    }

    final void register(Context paramContext) {
        this.mContext = paramContext;
        paramContext.registerReceiver(this, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
    }

    final void unregister() {
        if (this.mContext != null) {
            this.mContext.unregisterReceiver(this);
            this.mContext = null;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAmraidWebViewController$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */