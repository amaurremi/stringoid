package com.google.ads.mediation.admob;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.b;
import com.google.android.gms.ads.b.a;
import com.google.android.gms.ads.b.c;
import com.google.android.gms.ads.g;
import com.google.android.gms.internal.mv;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public final class AdMobAdapter
        implements c, com.google.android.gms.ads.b.e {
    private com.google.android.gms.ads.f i;
    private g j;

    static b a(Context paramContext, a parama, Bundle paramBundle1, Bundle paramBundle2) {
        com.google.android.gms.ads.d locald = new com.google.android.gms.ads.d();
        Object localObject = parama.a();
        if (localObject != null) {
            locald.a((Date) localObject);
        }
        int k = parama.b();
        if (k != 0) {
            locald.a(k);
        }
        localObject = parama.c();
        if (localObject != null) {
            localObject = ((Set) localObject).iterator();
            while (((Iterator) localObject).hasNext()) {
                locald.a((String) ((Iterator) localObject).next());
            }
        }
        localObject = parama.d();
        if (localObject != null) {
            locald.a((Location) localObject);
        }
        if (parama.e()) {
            locald.b(mv.a(paramContext));
        }
        boolean bool;
        if (paramBundle2.getInt("tagForChildDirectedTreatment") != -1) {
            if (paramBundle2.getInt("tagForChildDirectedTreatment") == 1) {
                bool = true;
                locald.a(bool);
            }
        } else {
            if (paramBundle1 == null) {
                break label248;
            }
        }
        for (; ; ) {
            paramBundle1.putInt("gw", 1);
            paramBundle1.putString("mad_hac", paramBundle2.getString("mad_hac"));
            if (!TextUtils.isEmpty(paramBundle2.getString("adJson"))) {
                paramBundle1.putString("_ad", paramBundle2.getString("adJson"));
            }
            paramBundle1.putBoolean("_noRefresh", true);
            locald.a(AdMobAdapter.class, paramBundle1);
            return locald.a();
            bool = false;
            break;
            label248:
            paramBundle1 = new Bundle();
        }
    }

    public View getBannerView() {
        return this.i;
    }

    public void onDestroy() {
        if (this.i != null) {
            this.i.a();
            this.i = null;
        }
        if (this.j != null) {
            this.j = null;
        }
    }

    public void onPause() {
        if (this.i != null) {
            this.i.b();
        }
    }

    public void onResume() {
        if (this.i != null) {
            this.i.c();
        }
    }

    public void requestBannerAd(Context paramContext, com.google.android.gms.ads.b.d paramd, Bundle paramBundle1, com.google.android.gms.ads.e parame, a parama, Bundle paramBundle2) {
        this.i = new com.google.android.gms.ads.f(paramContext);
        this.i.setAdSize(new com.google.android.gms.ads.e(parame.b(), parame.a()));
        this.i.setAdUnitId(paramBundle1.getString("pubid"));
        this.i.setAdListener(new AdMobAdapter.a(this, paramd));
        this.i.a(a(paramContext, parama, paramBundle2, paramBundle1));
    }

    public void requestInterstitialAd(Context paramContext, com.google.android.gms.ads.b.f paramf, Bundle paramBundle1, a parama, Bundle paramBundle2) {
        this.j = new g(paramContext);
        this.j.a(paramBundle1.getString("pubid"));
        this.j.a(new AdMobAdapter.b(this, paramf));
        this.j.a(a(paramContext, parama, paramBundle2, paramBundle1));
    }

    public void showInterstitial() {
        this.j.a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/ads/mediation/admob/AdMobAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */