package com.mopub.nativeads;

import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.AdUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.LocationService;
import com.mopub.common.MoPub;
import com.mopub.common.util.DateAndTime;
import com.mopub.common.util.Strings;

class NativeUrlGenerator
        extends AdUrlGenerator {
    private String mDesiredAssets;
    private String mSequenceNumber;

    NativeUrlGenerator(Context paramContext) {
        super(paramContext);
    }

    private void setDesiredAssets() {
        if ((this.mDesiredAssets != null) && (!Strings.isEmpty(this.mDesiredAssets))) {
            addParam("assets", this.mDesiredAssets);
        }
    }

    private void setSequenceNumber() {
        if (!TextUtils.isEmpty(this.mSequenceNumber)) {
            addParam("MAGIC_NO", this.mSequenceNumber);
        }
    }

    public String generateUrlString(String paramString) {
        initUrlString(paramString, "/m/ad");
        setAdUnitId(this.mAdUnitId);
        setKeywords(this.mKeywords);
        Object localObject = this.mLocation;
        paramString = (String) localObject;
        if (localObject == null) {
            paramString = LocationService.getLastKnownLocation(this.mContext, MoPub.getLocationPrecision(), MoPub.getLocationAwareness());
        }
        setLocation(paramString);
        paramString = ClientMetadata.getInstance(this.mContext);
        setSdkVersion(paramString.getSdkVersion());
        setDeviceInfo(new String[]{paramString.getDeviceManufacturer(), paramString.getDeviceModel(), paramString.getDeviceProduct()});
        setUdid(paramString.getUdid());
        setDoNotTrack(paramString.getDoNoTrack());
        setTimezone(DateAndTime.getTimeZoneOffsetString());
        setOrientation(paramString.getOrientationString());
        setDensity(paramString.getDensity());
        localObject = paramString.getNetworkOperator();
        setMccCode((String) localObject);
        setMncCode((String) localObject);
        setIsoCountryCode(paramString.getIsoCountryCode());
        setCarrierName(paramString.getNetworkOperatorName());
        setNetworkType(paramString.getActiveNetworkType());
        setAppVersion(paramString.getAppVersion());
        setTwitterAppInstalledFlag();
        setDesiredAssets();
        setSequenceNumber();
        return getFinalUrlString();
    }

    protected void setSdkVersion(String paramString) {
        addParam("nsv", paramString);
    }

    public NativeUrlGenerator withAdUnitId(String paramString) {
        this.mAdUnitId = paramString;
        return this;
    }

    NativeUrlGenerator withRequest(RequestParameters paramRequestParameters) {
        if (paramRequestParameters != null) {
            this.mKeywords = paramRequestParameters.getKeywords();
            this.mLocation = paramRequestParameters.getLocation();
            this.mDesiredAssets = paramRequestParameters.getDesiredAssets();
        }
        return this;
    }

    NativeUrlGenerator withSequenceNumber(int paramInt) {
        this.mSequenceNumber = String.valueOf(paramInt);
        return this;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/NativeUrlGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */