package com.inmobi.monetization.internal;

import com.inmobi.commons.internal.Log;
import com.inmobi.commons.network.Request;
import com.inmobi.commons.network.Response;
import com.inmobi.commons.network.abstraction.INetworkListener;
import com.inmobi.monetization.internal.configs.NetworkEventType;

class Ad$a
        implements INetworkListener {
    Ad$a(Ad paramAd) {
    }

    public void onRequestFailed(Request paramRequest, Response paramResponse) {
        if (Ad.a(this.a)) {
            if (Ad.c(this.a) != LtvpRuleProcessor.ActionsRule.ACTIONS_TO_MEDIATION) {
                break label57;
            }
            if (this.a.mAdListener != null) {
                this.a.mAdListener.onAdRequestFailed(AdErrorCode.DO_MONETIZE);
            }
        }
        for (; ; ) {
            this.a.setDownloadingNewAd(false);
            return;
            label57:
            this.a.handleError((i) paramRequest, paramResponse);
        }
    }

    public void onRequestSucceded(Request paramRequest, Response paramResponse) {
        Response localResponse;
        if (Ad.a(this.a)) {
            localResponse = this.a.getDecryptedResponse((i) paramRequest, paramResponse);
            if (localResponse != null) {
                break label90;
            }
            this.a.handleError((i) paramRequest, paramResponse);
        }
        for (; ; ) {
            long l1 = System.currentTimeMillis();
            long l2 = this.a.mFetchStartTime;
            this.a.collectMetrics(paramResponse, l1 - l2, NetworkEventType.FETCH_COMPLETE);
            this.a.setDownloadingNewAd(false);
            Ad.b(this.a).removeMessages(101);
            return;
            label90:
            Log.internal("[InMobi]-[Monetization]", "Raw Ad Response: " + localResponse.getResponseBody());
            this.a.handleResponse((i) paramRequest, localResponse);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/Ad$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */