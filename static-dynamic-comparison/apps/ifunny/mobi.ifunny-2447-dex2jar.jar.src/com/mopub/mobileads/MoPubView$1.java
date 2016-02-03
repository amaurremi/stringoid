package com.mopub.mobileads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.mopub.common.util.Visibility;

class MoPubView$1
        extends BroadcastReceiver {
    MoPubView$1(MoPubView paramMoPubView) {
    }

    public void onReceive(Context paramContext, Intent paramIntent) {
        if ((!Visibility.isScreenVisible(MoPubView.access$000(this.this$0))) || (paramIntent == null)) {
        }
        do {
            return;
            paramContext = paramIntent.getAction();
            if ("android.intent.action.USER_PRESENT".equals(paramContext)) {
                MoPubView.access$100(this.this$0, 0);
                return;
            }
        } while (!"android.intent.action.SCREEN_OFF".equals(paramContext));
        MoPubView.access$100(this.this$0, 8);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MoPubView$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */