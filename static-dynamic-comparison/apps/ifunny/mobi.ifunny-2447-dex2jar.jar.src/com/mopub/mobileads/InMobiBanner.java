package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.InMobi.LOG_LEVEL;
import com.inmobi.monetization.IMBanner;
import com.inmobi.monetization.IMBannerListener;
import com.inmobi.monetization.IMErrorCode;
import com.mopub.common.util.Views;

import java.util.HashMap;
import java.util.Map;

import mobi.ifunny.d;
import mobi.ifunny.f.a;

public class InMobiBanner
        extends CustomEventBanner
        implements IMBannerListener {
    private static boolean isAppInitialized = false;
    private IMBanner iMBanner;
    private CustomEventBanner.CustomEventBannerListener mBannerListener;

    protected void loadBanner(Context paramContext, CustomEventBanner.CustomEventBannerListener paramCustomEventBannerListener, Map<String, Object> paramMap, Map<String, String> paramMap1) {
        this.mBannerListener = paramCustomEventBannerListener;
        paramMap = (String) paramMap1.get("pub_id");
        if (TextUtils.isEmpty(paramMap)) {
            d.e("MoPub", "InMobi pub id is not set");
            paramCustomEventBannerListener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        d.c("MoPub", "InMobi pub id " + paramMap);
        if ((paramContext instanceof Activity)) {
        }
        for (paramCustomEventBannerListener = (Activity) paramContext; ; paramCustomEventBannerListener = null) {
            if (paramCustomEventBannerListener == null) {
                this.mBannerListener.onBannerFailed(null);
                return;
            }
            if (!isAppInitialized) {
                InMobi.initialize(paramCustomEventBannerListener, paramMap);
                isAppInitialized = true;
            }
            this.iMBanner = new IMBanner(paramCustomEventBannerListener, paramMap, a.b(paramContext));
            paramContext = new HashMap();
            paramContext.put("tp", "c_mopub");
            paramContext.put("tp-ver", "3.0.0");
            this.iMBanner.setRequestParams(paramContext);
            InMobi.setLogLevel(InMobi.LOG_LEVEL.VERBOSE);
            this.iMBanner.setIMBannerListener(this);
            this.iMBanner.setRefreshInterval(-1);
            this.iMBanner.loadBanner();
            return;
        }
    }

    public void onBannerInteraction(IMBanner paramIMBanner, Map<String, String> paramMap) {
        this.mBannerListener.onBannerClicked();
    }

    public void onBannerRequestFailed(IMBanner paramIMBanner, IMErrorCode paramIMErrorCode) {
        if (paramIMErrorCode == IMErrorCode.INTERNAL_ERROR) {
            this.mBannerListener.onBannerFailed(MoPubErrorCode.INTERNAL_ERROR);
            return;
        }
        if (paramIMErrorCode == IMErrorCode.INVALID_REQUEST) {
            this.mBannerListener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        if (paramIMErrorCode == IMErrorCode.NETWORK_ERROR) {
            this.mBannerListener.onBannerFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
            return;
        }
        if (paramIMErrorCode == IMErrorCode.NO_FILL) {
            this.mBannerListener.onBannerFailed(MoPubErrorCode.NO_FILL);
            return;
        }
        this.mBannerListener.onBannerFailed(MoPubErrorCode.UNSPECIFIED);
    }

    public void onBannerRequestSucceeded(IMBanner paramIMBanner) {
        if (this.iMBanner != null) {
            this.mBannerListener.onBannerLoaded(paramIMBanner);
            return;
        }
        this.mBannerListener.onBannerFailed(null);
    }

    public void onDismissBannerScreen(IMBanner paramIMBanner) {
        this.mBannerListener.onBannerCollapsed();
    }

    public void onInvalidate() {
        if (this.iMBanner != null) {
            this.iMBanner.setIMBannerListener(null);
            Views.removeFromParent(this.iMBanner);
            this.iMBanner.destroy();
        }
    }

    public void onLeaveApplication(IMBanner paramIMBanner) {
    }

    public void onShowBannerScreen(IMBanner paramIMBanner) {
        this.mBannerListener.onBannerExpanded();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/InMobiBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */