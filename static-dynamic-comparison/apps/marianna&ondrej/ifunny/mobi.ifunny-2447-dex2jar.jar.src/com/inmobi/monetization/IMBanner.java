package com.inmobi.monetization;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.inmobi.commons.AnimationType;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.ThinICE;
import com.inmobi.monetization.internal.AdErrorCode;
import com.inmobi.monetization.internal.BannerAd;
import com.inmobi.monetization.internal.IMAdListener;
import com.inmobi.monetization.internal.configs.ConfigParams;
import com.inmobi.monetization.internal.configs.Initializer;
import com.inmobi.monetization.internal.imai.RequestResponseManager;

import java.util.HashMap;
import java.util.Map;

public final class IMBanner
        extends RelativeLayout {
    public static final int INMOBI_AD_UNIT_120X600 = 13;
    public static final int INMOBI_AD_UNIT_300X250 = 10;
    public static final int INMOBI_AD_UNIT_320X48 = 9;
    public static final int INMOBI_AD_UNIT_320X50 = 15;
    public static final int INMOBI_AD_UNIT_468X60 = 12;
    public static final int INMOBI_AD_UNIT_728X90 = 11;
    public static final int REFRESH_INTERVAL_MINIMUM = 0;
    public static final int REFRESH_INTERVAL_OFF = -1;
    IMAdListener a = new c(this);
    private BannerAd b;
    private IMBannerListener c;
    private boolean d = true;
    private Activity e;
    private String f = null;
    private long g = -1L;
    private int h = 15;

    public IMBanner(Activity paramActivity, long paramLong) {
        super(paramActivity);
        this.e = paramActivity;
        this.g = paramLong;
        a();
    }

    public IMBanner(Activity paramActivity, String paramString, int paramInt) {
        super(paramActivity);
        this.f = paramString;
        this.h = paramInt;
        this.e = paramActivity;
        a();
    }

    public IMBanner(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        this.e = ((Activity) paramContext);
        try {
            this.g = Long.parseLong(paramAttributeSet.getAttributeValue(null, "slotId"));
            a();
            return;
        } catch (Exception paramContext) {
        }
        try {
            this.h = Integer.parseInt(paramAttributeSet.getAttributeValue(null, "adSize"));
            try {
                this.f = paramAttributeSet.getAttributeValue(null, "appId");
                a();
                return;
            } catch (Exception paramContext) {
                for (; ; ) {
                }
            }
        } catch (Exception paramContext) {
            for (; ; ) {
            }
        }
    }

    private void a() {
        if (this.g > 0L) {
        }
        for (this.b = new BannerAd(this.e, this, this.g, 15); ; this.b = new BannerAd(this.e, this, this.f, this.h)) {
            this.b.setAdListener(this.a);
            setRefreshInterval(Initializer.getConfigParams().getDefaultRefreshRate());
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
            addView(this.b.getView(), localLayoutParams);
            return;
        }
    }

    private void a(int paramInt, AdErrorCode paramAdErrorCode, Map<?, ?> paramMap) {
        if (!this.d) {
            Log.debug("[InMobi]-[Monetization]", "Banner not sending callback because the view is not added to any window.");
        }
        while (this.c == null) {
            return;
        }
        this.e.runOnUiThread(new IMBanner.a(this, paramInt, paramAdErrorCode, paramMap));
    }

    @Deprecated
    public void destroy() {
    }

    public void disableHardwareAcceleration() {
        if (this.b != null) {
            this.b.disableHardwareAcceleration();
        }
    }

    public void loadBanner() {
        if (this.b != null) {
            this.b.loadAd();
            removeAllViews();
            localObject = new RelativeLayout.LayoutParams(-1, -1);
            addView(this.b.getView(), (ViewGroup.LayoutParams) localObject);
            return;
        }
        Object localObject = IMErrorCode.INVALID_REQUEST;
        ((IMErrorCode) localObject).setMessage("Banner Ad instance not created with valid paramters");
        this.c.onBannerRequestFailed(this, (IMErrorCode) localObject);
        Log.verbose("[InMobi]-[Monetization]", "Banner Ad instance not created with valid paramters");
    }

    protected void onAttachedToWindow() {
        Log.debug("[InMobi]-[Monetization]", "onAttachedToWindow");
        this.d = true;
    }

    protected void onDetachedFromWindow() {
        this.d = false;
        super.onDetachedFromWindow();
    }

    protected final void onWindowVisibilityChanged(int paramInt) {
        if (paramInt == 0) {
        }
        for (; ; ) {
            try {
                ThinICE.start(this.e);
                if (this.b != null) {
                    this.b.refreshAd();
                }
                RequestResponseManager localRequestResponseManager = new RequestResponseManager();
                localRequestResponseManager.init();
                localRequestResponseManager.processClick(this.e.getApplicationContext(), null);
                return;
            } catch (Exception localException) {
                Log.internal("[InMobi]-[Monetization]", "Cannot start ice. Activity is null");
                continue;
            }
            if (this.b != null) {
                this.b.stopRefresh();
            }
        }
    }

    public void setAdSize(int paramInt) {
        if (this.b != null) {
            this.b.setAdSize(paramInt);
        }
    }

    public void setAnimationType(AnimationType paramAnimationType) {
        if (this.b != null) {
            this.b.setAnimation(paramAnimationType);
        }
    }

    public void setAppId(String paramString) {
        if (this.b != null) {
            this.b.setAppId(paramString);
        }
    }

    public void setIMBannerListener(IMBannerListener paramIMBannerListener) {
        this.c = paramIMBannerListener;
    }

    public void setKeywords(String paramString) {
        if ((paramString == null) || ("".equals(paramString.trim()))) {
            Log.debug("[InMobi]-[Monetization]", "Keywords cannot be null or blank.");
        }
        while (this.b == null) {
            return;
        }
        this.b.setKeywords(paramString);
    }

    @Deprecated
    public void setRefTagParam(String paramString1, String paramString2) {
        if ((paramString1 == null) || (paramString2 == null)) {
            Log.debug("[InMobi]-[Monetization]", "Key or Value cannot be null");
        }
        HashMap localHashMap;
        do {
            return;
            if ((paramString1.trim().equals("")) || (paramString2.trim().equals(""))) {
                Log.debug("[InMobi]-[Monetization]", "Key or Value cannot be empty");
                return;
            }
            localHashMap = new HashMap();
            localHashMap.put(paramString1, paramString2);
        } while (this.b == null);
        this.b.setRequestParams(localHashMap);
    }

    public void setRefreshInterval(int paramInt) {
        if (this.b != null) {
            this.b.setRefreshInterval(paramInt);
        }
    }

    public void setRequestParams(Map<String, String> paramMap) {
        if ((paramMap == null) || (paramMap.isEmpty())) {
            Log.debug("[InMobi]-[Monetization]", "Request params cannot be null or empty.");
        }
        while (this.b == null) {
            return;
        }
        this.b.setRequestParams(paramMap);
    }

    public void setSlotId(long paramLong) {
        if (this.b != null) {
            this.b.setSlotId(paramLong);
        }
    }

    public void stopLoading() {
        if (this.b != null) {
            this.b.stopLoading();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/IMBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */