package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.b.a;
import com.google.android.gms.b.d;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONObject;

@ii
public final class eg<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters>
        extends dy {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> a;
    private final NETWORK_EXTRAS b;

    public eg(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> paramMediationAdapter, NETWORK_EXTRAS paramNETWORK_EXTRAS) {
        this.a = paramMediationAdapter;
        this.b = paramNETWORK_EXTRAS;
    }

    private SERVER_PARAMETERS a(String paramString1, int paramInt, String paramString2) {
        if (paramString1 != null) {
            try {
                localObject = new JSONObject(paramString1);
                paramString2 = new HashMap(((JSONObject) localObject).length());
                Iterator localIterator = ((JSONObject) localObject).keys();
                for (; ; ) {
                    paramString1 = paramString2;
                    if (!localIterator.hasNext()) {
                        break;
                    }
                    paramString1 = (String) localIterator.next();
                    paramString2.put(paramString1, ((JSONObject) localObject).getString(paramString1));
                }
                paramString1 = new HashMap(0);
            } catch (Throwable paramString1) {
                mx.d("Could not get MediationServerParameters.", paramString1);
                throw new RemoteException();
            }
        }
        Object localObject = this.a.getServerParametersType();
        paramString2 = null;
        if (localObject != null) {
            paramString2 = (MediationServerParameters) ((Class) localObject).newInstance();
            paramString2.load(paramString1);
        }
        return paramString2;
    }

    public a a() {
        if (!(this.a instanceof MediationBannerAdapter)) {
            mx.e("MediationAdapter is not a MediationBannerAdapter: " + this.a.getClass().getCanonicalName());
            throw new RemoteException();
        }
        try {
            a locala = d.a(((MediationBannerAdapter) this.a).getBannerView());
            return locala;
        } catch (Throwable localThrowable) {
            mx.d("Could not get banner view from adapter.", localThrowable);
            throw new RemoteException();
        }
    }

    public void a(a parama, av paramav, String paramString, ea paramea) {
        a(parama, paramav, paramString, null, paramea);
    }

    public void a(a parama, av paramav, String paramString1, String paramString2, ea paramea) {
        if (!(this.a instanceof MediationInterstitialAdapter)) {
            mx.e("MediationAdapter is not a MediationInterstitialAdapter: " + this.a.getClass().getCanonicalName());
            throw new RemoteException();
        }
        mx.a("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.a).requestInterstitialAd(new eh(paramea), (Activity) d.a(parama), a(paramString1, paramav.g, paramString2), et.a(paramav), this.b);
            return;
        } catch (Throwable parama) {
            mx.d("Could not request interstitial ad from adapter.", parama);
            throw new RemoteException();
        }
    }

    public void a(a parama, ay paramay, av paramav, String paramString, ea paramea) {
        a(parama, paramay, paramav, paramString, null, paramea);
    }

    public void a(a parama, ay paramay, av paramav, String paramString1, String paramString2, ea paramea) {
        if (!(this.a instanceof MediationBannerAdapter)) {
            mx.e("MediationAdapter is not a MediationBannerAdapter: " + this.a.getClass().getCanonicalName());
            throw new RemoteException();
        }
        mx.a("Requesting banner ad from adapter.");
        try {
            ((MediationBannerAdapter) this.a).requestBannerAd(new eh(paramea), (Activity) d.a(parama), a(paramString1, paramav.g, paramString2), et.a(paramay), et.a(paramav), this.b);
            return;
        } catch (Throwable parama) {
            mx.d("Could not request banner ad from adapter.", parama);
            throw new RemoteException();
        }
    }

    public void b() {
        if (!(this.a instanceof MediationInterstitialAdapter)) {
            mx.e("MediationAdapter is not a MediationInterstitialAdapter: " + this.a.getClass().getCanonicalName());
            throw new RemoteException();
        }
        mx.a("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.a).showInterstitial();
            return;
        } catch (Throwable localThrowable) {
            mx.d("Could not show interstitial from adapter.", localThrowable);
            throw new RemoteException();
        }
    }

    public void c() {
        try {
            this.a.destroy();
            return;
        } catch (Throwable localThrowable) {
            mx.d("Could not destroy adapter.", localThrowable);
            throw new RemoteException();
        }
    }

    public void d() {
        throw new RemoteException();
    }

    public void e() {
        throw new RemoteException();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/eg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */