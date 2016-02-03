package com.inmobi.monetization.internal;

import android.os.Handler;
import android.os.Message;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.configs.NetworkEventType;

import java.lang.ref.WeakReference;

import org.json.JSONException;
import org.json.JSONObject;

class Ad$c
        extends Handler {
    private final WeakReference<Ad> a;

    public Ad$c(Ad paramAd) {
        this.a = new WeakReference(paramAd);
    }

    public void handleMessage(Message paramMessage) {
        Ad localAd = (Ad) this.a.get();
        if (localAd == null) {
        }
        for (; ; ) {
            return;
            switch (paramMessage.what) {
                default:
                    return;
            }
            long l1 = System.currentTimeMillis();
            long l2 = localAd.mFetchStartTime;
            paramMessage = new JSONObject();
            try {
                paramMessage.put("t", l1 - l2);
                paramMessage.put("m", 1);
                Ad.a(localAd, paramMessage, NetworkEventType.CONNECT_ERROR);
                localAd.setDownloadingNewAd(false);
                if (localAd.mAdListener == null) {
                    continue;
                }
                localAd.mAdListener.onAdRequestFailed(AdErrorCode.NETWORK_ERROR);
                return;
            } catch (JSONException paramMessage) {
                for (; ; ) {
                    Log.internal("[InMobi]-[Monetization]", "Error creating metric logs for error at " + System.currentTimeMillis());
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/Ad$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */