package com.mopub.nativeads;

import android.content.Context;
import com.mopub.common.BaseUrlGenerator;
import com.mopub.common.ClientMetadata;

class PositioningUrlGenerator
        extends BaseUrlGenerator {
    private static final String POSITIONING_API_VERSION = "1";
    private String mAdUnitId;
    private final Context mContext;

    public PositioningUrlGenerator(Context paramContext) {
        this.mContext = paramContext;
    }

    private void setAdUnitId(String paramString) {
        addParam("id", paramString);
    }

    private void setSdkVersion(String paramString) {
        addParam("nsv", paramString);
    }

    public String generateUrlString(String paramString) {
        initUrlString(paramString, "/m/pos");
        setAdUnitId(this.mAdUnitId);
        setApiVersion("1");
        paramString = ClientMetadata.getInstance(this.mContext);
        setSdkVersion(paramString.getSdkVersion());
        setDeviceInfo(new String[]{paramString.getDeviceManufacturer(), paramString.getDeviceModel(), paramString.getDeviceProduct()});
        setUdid(paramString.getUdid());
        setAppVersion(paramString.getAppVersion());
        return getFinalUrlString();
    }

    public PositioningUrlGenerator withAdUnitId(String paramString) {
        this.mAdUnitId = paramString;
        return this;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/PositioningUrlGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */