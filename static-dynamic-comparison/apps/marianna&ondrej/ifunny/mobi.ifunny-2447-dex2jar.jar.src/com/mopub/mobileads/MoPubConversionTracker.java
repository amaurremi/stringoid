package com.mopub.mobileads;

import android.content.Context;
import android.content.SharedPreferences;
import com.mopub.common.GpsHelper;
import com.mopub.common.SharedPreferencesHelper;
import com.mopub.common.logging.MoPubLog;

public class MoPubConversionTracker {
    private static final String TRACK_HANDLER = "/m/open";
    private static final String TRACK_HOST = "ads.mopub.com";
    private Context mContext;
    private MoPubConversionTracker.ConversionTrackerGpsHelperListener mConversionTrackerGpsHelperListener = new MoPubConversionTracker.ConversionTrackerGpsHelperListener(this);
    private String mIsTrackedKey;
    private String mPackageName;
    private SharedPreferences mSharedPreferences;

    private boolean isAlreadyTracked() {
        return this.mSharedPreferences.getBoolean(this.mIsTrackedKey, false);
    }

    public void reportAppOpen(Context paramContext) {
        if (paramContext == null) {
            return;
        }
        this.mContext = paramContext;
        this.mPackageName = this.mContext.getPackageName();
        this.mIsTrackedKey = (this.mPackageName + " tracked");
        this.mSharedPreferences = SharedPreferencesHelper.getSharedPreferences(this.mContext);
        if (!isAlreadyTracked()) {
            GpsHelper.asyncFetchAdvertisingInfo(this.mContext, this.mConversionTrackerGpsHelperListener);
            return;
        }
        MoPubLog.d("Conversion already tracked");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MoPubConversionTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */