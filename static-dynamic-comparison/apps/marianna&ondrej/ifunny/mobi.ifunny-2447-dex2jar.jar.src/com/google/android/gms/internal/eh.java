package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

@ii
public final class eh<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters>
        implements MediationBannerListener, MediationInterstitialListener {
    private final ea a;

    public eh(ea paramea) {
        this.a = paramea;
    }

    public void onClick(MediationBannerAdapter<?, ?> paramMediationBannerAdapter) {
        mx.a("Adapter called onClick.");
        if (!mv.b()) {
            mx.e("onClick must be called on the main UI thread.");
            mv.a.post(new ei(this));
            return;
        }
        try {
            this.a.a();
            return;
        } catch (RemoteException paramMediationBannerAdapter) {
            mx.d("Could not call onAdClicked.", paramMediationBannerAdapter);
        }
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> paramMediationBannerAdapter) {
        mx.a("Adapter called onDismissScreen.");
        if (!mv.b()) {
            mx.e("onDismissScreen must be called on the main UI thread.");
            mv.a.post(new en(this));
            return;
        }
        try {
            this.a.b();
            return;
        } catch (RemoteException paramMediationBannerAdapter) {
            mx.d("Could not call onAdClosed.", paramMediationBannerAdapter);
        }
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter) {
        mx.a("Adapter called onDismissScreen.");
        if (!mv.b()) {
            mx.e("onDismissScreen must be called on the main UI thread.");
            mv.a.post(new es(this));
            return;
        }
        try {
            this.a.b();
            return;
        } catch (RemoteException paramMediationInterstitialAdapter) {
            mx.d("Could not call onAdClosed.", paramMediationInterstitialAdapter);
        }
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> paramMediationBannerAdapter, AdRequest.ErrorCode paramErrorCode) {
        mx.a("Adapter called onFailedToReceiveAd with error. " + paramErrorCode);
        if (!mv.b()) {
            mx.e("onFailedToReceiveAd must be called on the main UI thread.");
            mv.a.post(new eo(this, paramErrorCode));
            return;
        }
        try {
            this.a.a(et.a(paramErrorCode));
            return;
        } catch (RemoteException paramMediationBannerAdapter) {
            mx.d("Could not call onAdFailedToLoad.", paramMediationBannerAdapter);
        }
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter, AdRequest.ErrorCode paramErrorCode) {
        mx.a("Adapter called onFailedToReceiveAd with error " + paramErrorCode + ".");
        if (!mv.b()) {
            mx.e("onFailedToReceiveAd must be called on the main UI thread.");
            mv.a.post(new ej(this, paramErrorCode));
            return;
        }
        try {
            this.a.a(et.a(paramErrorCode));
            return;
        } catch (RemoteException paramMediationInterstitialAdapter) {
            mx.d("Could not call onAdFailedToLoad.", paramMediationInterstitialAdapter);
        }
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> paramMediationBannerAdapter) {
        mx.a("Adapter called onLeaveApplication.");
        if (!mv.b()) {
            mx.e("onLeaveApplication must be called on the main UI thread.");
            mv.a.post(new ep(this));
            return;
        }
        try {
            this.a.c();
            return;
        } catch (RemoteException paramMediationBannerAdapter) {
            mx.d("Could not call onAdLeftApplication.", paramMediationBannerAdapter);
        }
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter) {
        mx.a("Adapter called onLeaveApplication.");
        if (!mv.b()) {
            mx.e("onLeaveApplication must be called on the main UI thread.");
            mv.a.post(new ek(this));
            return;
        }
        try {
            this.a.c();
            return;
        } catch (RemoteException paramMediationInterstitialAdapter) {
            mx.d("Could not call onAdLeftApplication.", paramMediationInterstitialAdapter);
        }
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> paramMediationBannerAdapter) {
        mx.a("Adapter called onPresentScreen.");
        if (!mv.b()) {
            mx.e("onPresentScreen must be called on the main UI thread.");
            mv.a.post(new eq(this));
            return;
        }
        try {
            this.a.d();
            return;
        } catch (RemoteException paramMediationBannerAdapter) {
            mx.d("Could not call onAdOpened.", paramMediationBannerAdapter);
        }
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter) {
        mx.a("Adapter called onPresentScreen.");
        if (!mv.b()) {
            mx.e("onPresentScreen must be called on the main UI thread.");
            mv.a.post(new el(this));
            return;
        }
        try {
            this.a.d();
            return;
        } catch (RemoteException paramMediationInterstitialAdapter) {
            mx.d("Could not call onAdOpened.", paramMediationInterstitialAdapter);
        }
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> paramMediationBannerAdapter) {
        mx.a("Adapter called onReceivedAd.");
        if (!mv.b()) {
            mx.e("onReceivedAd must be called on the main UI thread.");
            mv.a.post(new er(this));
            return;
        }
        try {
            this.a.e();
            return;
        } catch (RemoteException paramMediationBannerAdapter) {
            mx.d("Could not call onAdLoaded.", paramMediationBannerAdapter);
        }
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter) {
        mx.a("Adapter called onReceivedAd.");
        if (!mv.b()) {
            mx.e("onReceivedAd must be called on the main UI thread.");
            mv.a.post(new em(this));
            return;
        }
        try {
            this.a.e();
            return;
        } catch (RemoteException paramMediationInterstitialAdapter) {
            mx.d("Could not call onAdLoaded.", paramMediationInterstitialAdapter);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/eh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */