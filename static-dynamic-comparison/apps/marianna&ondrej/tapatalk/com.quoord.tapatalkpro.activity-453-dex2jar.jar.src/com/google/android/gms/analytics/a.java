package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

import java.io.IOException;

class a
        implements m {
    private static Object sf = new Object();
    private static a sg;
    private Context mContext;
    private AdvertisingIdClient.Info sh;
    private long si;

    a(Context paramContext) {
        this.mContext = paramContext;
    }

    private AdvertisingIdClient.Info bQ() {
        try {
            AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.mContext);
            return localInfo;
        } catch (IllegalStateException localIllegalStateException) {
            aa.z("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
            return null;
        } catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException) {
            aa.z("GooglePlayServicesRepairableException getting Ad Id Info");
            return null;
        } catch (IOException localIOException) {
            aa.z("IOException getting Ad Id Info");
            return null;
        } catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException) {
            aa.z("GooglePlayServicesNotAvailableException getting Ad Id Info");
            return null;
        } catch (Exception localException) {
            aa.z("Unknown exception. Could not get the ad Id.");
        }
        return null;
    }

    public static m m(Context paramContext) {
        if (sg == null) {
        }
        synchronized (sf) {
            if (sg == null) {
                sg = new a(paramContext);
            }
            return sg;
        }
    }

    public String getValue(String paramString) {
        long l = System.currentTimeMillis();
        if (l - this.si > 1000L) {
            this.sh = bQ();
            this.si = l;
        }
        if (this.sh != null) {
            if ("&adid".equals(paramString)) {
                return this.sh.getId();
            }
            if ("&ate".equals(paramString)) {
                if (this.sh.isLimitAdTrackingEnabled()) {
                    return "0";
                }
                return "1";
            }
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/analytics/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */