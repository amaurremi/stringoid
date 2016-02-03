package com.mopub.mobileads;

import android.content.Context;
import android.location.Location;
import com.mopub.common.AdUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.LocationService;
import com.mopub.common.MoPub;
import com.mopub.common.util.DateAndTime;
import com.mopub.mobileads.util.Mraids;

public class WebViewAdUrlGenerator
        extends AdUrlGenerator {
    public WebViewAdUrlGenerator(Context paramContext) {
        super(paramContext);
    }

    private boolean detectIsMraidSupported() {
        try {
            Class.forName("com.mopub.mobileads.MraidView");
            return true;
        } catch (ClassNotFoundException localClassNotFoundException) {
        }
        return false;
    }

    public String generateUrlString(String paramString) {
        initUrlString(paramString, "/m/ad");
        ClientMetadata localClientMetadata = ClientMetadata.getInstance(this.mContext);
        setApiVersion("6");
        setAdUnitId(this.mAdUnitId);
        setSdkVersion(localClientMetadata.getSdkVersion());
        setDeviceInfo(new String[]{localClientMetadata.getDeviceManufacturer(), localClientMetadata.getDeviceModel(), localClientMetadata.getDeviceProduct()});
        setUdid(localClientMetadata.getUdid());
        setDoNotTrack(localClientMetadata.getDoNoTrack());
        setKeywords(this.mKeywords);
        Location localLocation = this.mLocation;
        paramString = localLocation;
        if (localLocation == null) {
            paramString = LocationService.getLastKnownLocation(this.mContext, MoPub.getLocationPrecision(), MoPub.getLocationAwareness());
        }
        setLocation(paramString);
        setTimezone(DateAndTime.getTimeZoneOffsetString());
        setOrientation(localClientMetadata.getOrientationString());
        setDensity(localClientMetadata.getDensity());
        setMraidFlag(detectIsMraidSupported());
        paramString = localClientMetadata.getNetworkOperator();
        setMccCode(paramString);
        setMncCode(paramString);
        setIsoCountryCode(localClientMetadata.getIsoCountryCode());
        setCarrierName(localClientMetadata.getNetworkOperatorName());
        setNetworkType(localClientMetadata.getActiveNetworkType());
        setAppVersion(localClientMetadata.getAppVersion());
        setExternalStoragePermission(Mraids.isStorePictureSupported(this.mContext));
        setTwitterAppInstalledFlag();
        return getFinalUrlString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/WebViewAdUrlGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */