package com.amazon.device.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

import java.io.IOException;

class GooglePlayServicesAdapter {
    private static final String LOG_TAG = GooglePlayServicesAdapter.class.getSimpleName();

    protected AdvertisingIdClient createAdvertisingIdClient() {
        return new AdvertisingIdClient();
    }

    public GooglePlayServices.AdvertisingInfo getAdvertisingIdentifierInfo() {
        Object localObject = InternalAdRegistration.getInstance().getApplicationContext();
        try {
            localObject = AdvertisingIdClient.getAdvertisingIdInfo((Context) localObject);
            Log.v(LOG_TAG, "The Google Play Services Advertising Identifier was successfully retrieved.");
            String str = ((AdvertisingIdClient.Info) localObject).getId();
            boolean bool = ((AdvertisingIdClient.Info) localObject).isLimitAdTrackingEnabled();
            return new GooglePlayServices.AdvertisingInfo().setAdvertisingIdentifier(str).setLimitAdTrackingEnabled(bool);
        } catch (IllegalStateException localIllegalStateException) {
            Log.e(LOG_TAG, "The Google Play Services Advertising Id API was called from a non-background thread.");
            return new GooglePlayServices.AdvertisingInfo();
        } catch (IOException localIOException) {
            Log.e(LOG_TAG, "Retrieving the Google Play Services Advertising Identifier caused an IOException.");
            return new GooglePlayServices.AdvertisingInfo();
        } catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException) {
            Log.v(LOG_TAG, "Retrieving the Google Play Services Advertising Identifier caused a GooglePlayServicesNotAvailableException.");
            return GooglePlayServices.AdvertisingInfo.createNotAvailable();
        } catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException) {
            Log.v(LOG_TAG, "Retrieving the Google Play Services Advertising Identifier caused a GooglePlayServicesRepairableException.");
        }
        return new GooglePlayServices.AdvertisingInfo();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/GooglePlayServicesAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */