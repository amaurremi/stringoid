package com.flurry.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import com.flurry.android.AdCreative;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;

import java.util.ArrayList;
import java.util.List;

public class bq
        extends bg {
    protected aj a(Context paramContext, FlurryAdModule paramFlurryAdModule, e parame, AdUnit paramAdUnit, Bundle paramBundle) {
        if ((paramContext == null) || (paramFlurryAdModule == null) || (parame == null) || (paramAdUnit == null) || (paramBundle == null)) {
            return null;
        }
        return new br(paramContext, paramFlurryAdModule, parame, paramAdUnit, paramBundle);
    }

    protected i a(Context paramContext, FlurryAdModule paramFlurryAdModule, e parame, AdCreative paramAdCreative, Bundle paramBundle) {
        if ((paramContext == null) || (paramFlurryAdModule == null) || (parame == null) || (paramAdCreative == null) || (paramBundle == null)) {
            return null;
        }
        return new bp(paramContext, paramFlurryAdModule, parame, paramAdCreative, paramBundle);
    }

    protected String f() {
        return "AdMob";
    }

    protected List<bc> g() {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new bc("GooglePlayServicesSdk", "4.0.+", "com.google.android.gms.ads.InterstitialAd"));
        return localArrayList;
    }

    @TargetApi(13)
    protected List<ActivityInfo> j() {
        ArrayList localArrayList = new ArrayList();
        ActivityInfo localActivityInfo = new ActivityInfo();
        localActivityInfo.name = "com.google.android.gms.ads.AdActivity";
        localActivityInfo.configChanges = 4016;
        localArrayList.add(localActivityInfo);
        return localArrayList;
    }

    protected List<bc> k() {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new bc("GooglePlayServicesSdk", "4.0.+", "com.google.android.gms.ads.AdView"));
        return localArrayList;
    }

    protected List<String> n() {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("com.flurry.gms.ads.MY_AD_UNIT_ID");
        return localArrayList;
    }

    protected List<String> o() {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("android.permission.INTERNET");
        localArrayList.add("android.permission.ACCESS_NETWORK_STATE");
        return localArrayList;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */