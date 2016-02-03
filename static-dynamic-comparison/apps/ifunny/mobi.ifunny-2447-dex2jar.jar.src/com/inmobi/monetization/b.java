package com.inmobi.monetization;

import android.os.Handler;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.AdErrorCode;
import com.inmobi.monetization.internal.IMAdListener;
import com.inmobi.monetization.internal.NativeAd;
import com.inmobi.monetization.internal.NativeAdObject;

import java.util.Map;

class b
        implements IMAdListener {
    b(IMNative paramIMNative) {
    }

    public void onAdInteraction(Map<String, String> paramMap) {
    }

    public void onAdRequestFailed(AdErrorCode paramAdErrorCode) {
        try {
            this.a.a.getHandler().post(new b.a(this, paramAdErrorCode));
            return;
        } catch (Exception paramAdErrorCode) {
            Log.debug("[InMobi]-[Monetization]", "Failed to give callback");
        }
    }

    public void onAdRequestSucceeded() {
        try {
            NativeAdObject localNativeAdObject = this.a.a.getNativeAdObject();
            IMNative.a(this.a, localNativeAdObject.getPubContent());
            IMNative.b(this.a, localNativeAdObject.getContextCode());
            IMNative.c(this.a, localNativeAdObject.getNameSpace());
            this.a.a.getHandler().post(new b.b(this));
            return;
        } catch (Exception localException) {
            Log.debug("[InMobi]-[Monetization]", "Failed to give callback");
        }
    }

    public void onDismissAdScreen() {
    }

    public void onIncentCompleted(Map<Object, Object> paramMap) {
    }

    public void onLeaveApplication() {
    }

    public void onShowAdScreen() {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */