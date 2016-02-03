package com.mopub.mobileads;

import com.mopub.common.BaseUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.GpsHelper;

class MoPubConversionTracker$ConversionUrlGenerator
        extends BaseUrlGenerator {
    private MoPubConversionTracker$ConversionUrlGenerator(MoPubConversionTracker paramMoPubConversionTracker) {
    }

    private void setPackageId(String paramString) {
        addParam("id", paramString);
    }

    public String generateUrlString(String paramString) {
        initUrlString(paramString, "/m/open");
        setApiVersion("6");
        setPackageId(MoPubConversionTracker.access$000(this.this$0));
        paramString = ClientMetadata.getInstance(MoPubConversionTracker.access$100(this.this$0));
        setUdid(paramString.getUdid());
        setDoNotTrack(GpsHelper.isLimitAdTrackingEnabled(MoPubConversionTracker.access$100(this.this$0)));
        setAppVersion(paramString.getAppVersion());
        return getFinalUrlString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MoPubConversionTracker$ConversionUrlGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */