package com.mopub.common;

import android.content.Context;
import android.location.Location;
import com.mopub.common.util.IntentUtils;

public abstract class AdUrlGenerator
        extends BaseUrlGenerator {
    private static AdUrlGenerator.TwitterAppInstalledStatus sTwitterAppInstalledStatus = AdUrlGenerator.TwitterAppInstalledStatus.UNKNOWN;
    protected String mAdUnitId;
    protected Context mContext;
    protected String mKeywords;
    protected Location mLocation;

    public AdUrlGenerator(Context paramContext) {
        this.mContext = paramContext;
    }

    private void addParam(String paramString, ClientMetadata.MoPubNetworkType paramMoPubNetworkType) {
        addParam(paramString, paramMoPubNetworkType.toString());
    }

    private int mncPortionLength(String paramString) {
        return Math.min(3, paramString.length());
    }

    @Deprecated
    public static void setTwitterAppInstalledStatus(AdUrlGenerator.TwitterAppInstalledStatus paramTwitterAppInstalledStatus) {
        sTwitterAppInstalledStatus = paramTwitterAppInstalledStatus;
    }

    public AdUrlGenerator.TwitterAppInstalledStatus getTwitterAppInstallStatus() {
        if (IntentUtils.canHandleTwitterUrl(this.mContext)) {
            return AdUrlGenerator.TwitterAppInstalledStatus.INSTALLED;
        }
        return AdUrlGenerator.TwitterAppInstalledStatus.NOT_INSTALLED;
    }

    protected void setAdUnitId(String paramString) {
        addParam("id", paramString);
    }

    protected void setCarrierName(String paramString) {
        addParam("cn", paramString);
    }

    protected void setDensity(float paramFloat) {
        addParam("sc_a", "" + paramFloat);
    }

    protected void setIsoCountryCode(String paramString) {
        addParam("iso", paramString);
    }

    protected void setKeywords(String paramString) {
        addParam("q", paramString);
    }

    protected void setLocation(Location paramLocation) {
        if (paramLocation != null) {
            addParam("ll", paramLocation.getLatitude() + "," + paramLocation.getLongitude());
            addParam("lla", "" + (int) paramLocation.getAccuracy());
        }
    }

    protected void setMccCode(String paramString) {
        if (paramString == null) {
        }
        for (paramString = ""; ; paramString = paramString.substring(0, mncPortionLength(paramString))) {
            addParam("mcc", paramString);
            return;
        }
    }

    protected void setMncCode(String paramString) {
        if (paramString == null) {
        }
        for (paramString = ""; ; paramString = paramString.substring(mncPortionLength(paramString))) {
            addParam("mnc", paramString);
            return;
        }
    }

    protected void setMraidFlag(boolean paramBoolean) {
        if (paramBoolean) {
            addParam("mr", "1");
        }
    }

    protected void setNetworkType(ClientMetadata.MoPubNetworkType paramMoPubNetworkType) {
        addParam("ct", paramMoPubNetworkType);
    }

    protected void setOrientation(String paramString) {
        addParam("o", paramString);
    }

    protected void setSdkVersion(String paramString) {
        addParam("nv", paramString);
    }

    protected void setTimezone(String paramString) {
        addParam("z", paramString);
    }

    protected void setTwitterAppInstalledFlag() {
        if (sTwitterAppInstalledStatus == AdUrlGenerator.TwitterAppInstalledStatus.UNKNOWN) {
            sTwitterAppInstalledStatus = getTwitterAppInstallStatus();
        }
        if (sTwitterAppInstalledStatus == AdUrlGenerator.TwitterAppInstalledStatus.INSTALLED) {
            addParam("ts", "1");
        }
    }

    public AdUrlGenerator withAdUnitId(String paramString) {
        this.mAdUnitId = paramString;
        return this;
    }

    @Deprecated
    public AdUrlGenerator withFacebookSupported(boolean paramBoolean) {
        return this;
    }

    public AdUrlGenerator withKeywords(String paramString) {
        this.mKeywords = paramString;
        return this;
    }

    public AdUrlGenerator withLocation(Location paramLocation) {
        this.mLocation = paramLocation;
        return this;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/AdUrlGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */