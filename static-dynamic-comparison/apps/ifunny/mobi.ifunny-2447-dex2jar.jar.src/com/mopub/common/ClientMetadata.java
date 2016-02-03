package com.mopub.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Utils;

public class ClientMetadata {
    private static volatile ClientMetadata a;
    private String b;
    private String c;
    private String d;
    private String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final Context k;
    private final ConnectivityManager l;

    private ClientMetadata(Context paramContext) {
        this.k = paramContext.getApplicationContext();
        this.l = ((ConnectivityManager) this.k.getSystemService("connectivity"));
        this.f = Build.MANUFACTURER;
        this.g = Build.MODEL;
        this.h = Build.PRODUCT;
        this.i = "3.0.0";
        this.j = a(this.k);
        paramContext = (TelephonyManager) this.k.getSystemService("phone");
        this.b = paramContext.getNetworkOperator();
        if ((paramContext.getPhoneType() == 2) && (paramContext.getSimState() == 5)) {
            this.b = paramContext.getSimOperator();
        }
        this.c = paramContext.getNetworkCountryIso();
        try {
            this.d = paramContext.getNetworkOperatorName();
            this.e = b(this.k);
            return;
        } catch (SecurityException paramContext) {
            for (; ; ) {
                this.d = null;
            }
        }
    }

    private static String a(Context paramContext) {
        try {
            String str = paramContext.getPackageName();
            paramContext = paramContext.getPackageManager().getPackageInfo(str, 0).versionName;
            return paramContext;
        } catch (Exception paramContext) {
            MoPubLog.d("Failed to retrieve PackageInfo#versionName.");
        }
        return null;
    }

    private static String b(Context paramContext) {
        String str = GpsHelper.b(paramContext);
        if (str != null) {
            return "ifa:" + str;
        }
        paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
        if (paramContext == null) {
        }
        for (paramContext = ""; ; paramContext = Utils.sha1(paramContext)) {
            return "sha:" + paramContext;
        }
    }

    @VisibleForTesting
    public static void clearForTesting() {
        try {
            a = null;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public static ClientMetadata getInstance() {
        ClientMetadata localClientMetadata1 = a;
        if (localClientMetadata1 == null) {
            try {
                localClientMetadata1 = a;
                return localClientMetadata1;
            } finally {
            }
        }
        return localClientMetadata2;
    }

    public static ClientMetadata getInstance(Context paramContext) {
        Object localObject = a;
        if (localObject == null) {
            try {
                ClientMetadata localClientMetadata = a;
                localObject = localClientMetadata;
                if (localClientMetadata == null) {
                    localObject = new ClientMetadata(paramContext);
                    a = (ClientMetadata) localObject;
                }
                return (ClientMetadata) localObject;
            } finally {
            }
        }
        return (ClientMetadata) localObject;
    }

    public ClientMetadata.MoPubNetworkType getActiveNetworkType() {
        int n = -1;
        int m = n;
        if (this.k.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
            NetworkInfo localNetworkInfo = this.l.getActiveNetworkInfo();
            m = n;
            if (localNetworkInfo != null) {
                m = localNetworkInfo.getType();
            }
        }
        return ClientMetadata.MoPubNetworkType.a(m);
    }

    public String getAppVersion() {
        return this.j;
    }

    public float getDensity() {
        return this.k.getResources().getDisplayMetrics().density;
    }

    public String getDeviceManufacturer() {
        return this.f;
    }

    public String getDeviceModel() {
        return this.g;
    }

    public String getDeviceProduct() {
        return this.h;
    }

    public boolean getDoNoTrack() {
        return GpsHelper.isLimitAdTrackingEnabled(this.k);
    }

    public String getIsoCountryCode() {
        return this.c;
    }

    public String getNetworkOperator() {
        return this.b;
    }

    public String getNetworkOperatorName() {
        return this.d;
    }

    public String getOrientationString() {
        int m = this.k.getResources().getConfiguration().orientation;
        String str = "u";
        if (m == 1) {
            str = "p";
        }
        do {
            return str;
            if (m == 2) {
                return "l";
            }
        } while (m != 3);
        return "s";
    }

    public String getSdkVersion() {
        return this.i;
    }

    public String getUdid() {
        return this.e;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/ClientMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */