package com.everimaging.fotorsdk;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.utils.CountlyUtils;
import com.everimaging.fotorsdk.utils.DeviceUtils;
import com.everimaging.fotorsdk.utils.PackageManagerUtils;

public abstract class b
        extends FragmentActivity {
    private static final String a = b.class.getSimpleName();
    private static final FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);
    private int c;

    private void a(int paramInt) {
        Intent localIntent = new Intent("com.everimaging.fotorsdk.LifecycleChanged");
        localIntent.putExtra("extra_lifecycle_type", paramInt);
        sendBroadcast(localIntent);
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        super.onConfigurationChanged(paramConfiguration);
        b.c(new Object[]{"onConfigurationChanged:" + paramConfiguration});
        if (this.c != paramConfiguration.orientation) {
            DeviceUtils.init(this);
        }
        this.c = paramConfiguration.orientation;
    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        DeviceUtils.init(this);
        Object localObject = null;
        paramBundle = (Bundle) localObject;
        if (getIntent() != null) {
            paramBundle = (Bundle) localObject;
            if (getIntent().getExtras() != null) {
                paramBundle = (Bundle) localObject;
                if (getIntent().getExtras().containsKey("extra_fotor_auth_asset_name")) {
                    paramBundle = getIntent().getExtras().getString("extra_fotor_auth_asset_name");
                }
            }
        }
        FotorSDKInitiator.a(this, paramBundle);
        paramBundle = com.everimaging.fotorsdk.preference.a.a(this);
        b.c(new Object[]{"pre sdk version :" + paramBundle});
        if (!"1.0.6".equals(paramBundle)) {
            Log.d("FotorBaseActivity", "upgrade fotor sdk version");
        }
        for (paramBundle = getPackageName(); ; paramBundle = (Bundle) localObject) {
            try {
                localObject = PackageManagerUtils.getApplicationInfo(this);
                localObject = getPackageManager().getApplicationLabel((ApplicationInfo) localObject);
                if (localObject != null) {
                    break label218;
                }
                localObject = getPackageName();
                paramBundle = (Bundle) localObject;
            } catch (Exception localException) {
                label218:
                for (; ; ) {
                }
            }
            b.c(new Object[]{"app name is :" + paramBundle});
            a.a("APP_INFO", "AppName", paramBundle);
            com.everimaging.fotorsdk.preference.a.a(this, "1.0.6");
            if (!DeviceUtils.isTablet(this)) {
                setRequestedOrientation(1);
            }
            c.a = this;
            return;
            localObject = localObject.toString();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        c.a = null;
    }

    protected void onPause() {
        super.onPause();
        a(4);
    }

    protected void onResume() {
        super.onResume();
        a(3);
    }

    protected void onStart() {
        super.onStart();
        this.c = getResources().getConfiguration().orientation;
        CountlyUtils.startCountly();
        a(2);
    }

    protected void onStop() {
        super.onStop();
        CountlyUtils.stopCountly();
        a(5);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */