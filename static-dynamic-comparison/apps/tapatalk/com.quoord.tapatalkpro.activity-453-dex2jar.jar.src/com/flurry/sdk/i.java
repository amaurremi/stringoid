package com.flurry.sdk;

import android.content.Context;
import android.widget.RelativeLayout;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v10.AdSpaceLayout;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;

import java.util.List;
import java.util.Map;

public abstract class i
        extends RelativeLayout {
    private static final String a = i.class.getSimpleName();
    private FlurryAdModule b;
    private e c;
    private AdUnit d;
    private int e;

    protected i(Context paramContext) {
        super(paramContext);
    }

    public i(Context paramContext, FlurryAdModule paramFlurryAdModule, e parame) {
        super(paramContext);
        this.b = paramFlurryAdModule;
        this.c = parame;
    }

    boolean g() {
        return !((AdFrame) this.d.d().get(this.e)).e().e().toString().equals("takeover");
    }

    public int getAdFrameIndex() {
        return this.e;
    }

    public e getAdLog() {
        return this.c;
    }

    public AdUnit getAdUnit() {
        return this.d;
    }

    public FlurryAdModule getPlatformModule() {
        return this.b;
    }

    public abstract void initLayout();

    public void onDestroy() {
    }

    public void onEvent(String paramString, Map<String, String> paramMap) {
        eo.a(3, a, "AppSpotBannerView.onEvent " + paramString);
        if (this.d != null) {
            this.b.a(new q(paramString, paramMap, getContext(), this.d, this.c, this.e), this.b.a(), 0);
            return;
        }
        eo.a(3, a, "fAdUnit == null");
    }

    public void setAdFrameIndex(int paramInt) {
        this.e = paramInt;
    }

    public void setAdLog(e parame) {
        this.c = parame;
    }

    public void setAdUnit(AdUnit paramAdUnit) {
        this.d = paramAdUnit;
    }

    public void setPlatformModule(FlurryAdModule paramFlurryAdModule) {
        this.b = paramFlurryAdModule;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */