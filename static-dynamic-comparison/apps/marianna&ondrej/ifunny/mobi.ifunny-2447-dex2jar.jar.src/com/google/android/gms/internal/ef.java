package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.b.c;
import com.google.android.gms.ads.b.d;
import com.google.android.gms.ads.b.e;
import com.google.android.gms.ads.b.f;
import com.google.android.gms.common.internal.ag;

@ii
public final class ef
        implements d, f {
    private final ea a;

    public ef(ea paramea) {
        this.a = paramea;
    }

    public void a(c paramc) {
        ag.b("onAdLoaded must be called on the main UI thread.");
        mx.a("Adapter called onAdLoaded.");
        try {
            this.a.e();
            return;
        } catch (RemoteException paramc) {
            mx.d("Could not call onAdLoaded.", paramc);
        }
    }

    public void a(c paramc, int paramInt) {
        ag.b("onAdFailedToLoad must be called on the main UI thread.");
        mx.a("Adapter called onAdFailedToLoad with error. " + paramInt);
        try {
            this.a.a(paramInt);
            return;
        } catch (RemoteException paramc) {
            mx.d("Could not call onAdFailedToLoad.", paramc);
        }
    }

    public void a(e parame) {
        ag.b("onAdLoaded must be called on the main UI thread.");
        mx.a("Adapter called onAdLoaded.");
        try {
            this.a.e();
            return;
        } catch (RemoteException parame) {
            mx.d("Could not call onAdLoaded.", parame);
        }
    }

    public void a(e parame, int paramInt) {
        ag.b("onAdFailedToLoad must be called on the main UI thread.");
        mx.a("Adapter called onAdFailedToLoad with error " + paramInt + ".");
        try {
            this.a.a(paramInt);
            return;
        } catch (RemoteException parame) {
            mx.d("Could not call onAdFailedToLoad.", parame);
        }
    }

    public void b(c paramc) {
        ag.b("onAdOpened must be called on the main UI thread.");
        mx.a("Adapter called onAdOpened.");
        try {
            this.a.d();
            return;
        } catch (RemoteException paramc) {
            mx.d("Could not call onAdOpened.", paramc);
        }
    }

    public void b(e parame) {
        ag.b("onAdOpened must be called on the main UI thread.");
        mx.a("Adapter called onAdOpened.");
        try {
            this.a.d();
            return;
        } catch (RemoteException parame) {
            mx.d("Could not call onAdOpened.", parame);
        }
    }

    public void c(c paramc) {
        ag.b("onAdClosed must be called on the main UI thread.");
        mx.a("Adapter called onAdClosed.");
        try {
            this.a.b();
            return;
        } catch (RemoteException paramc) {
            mx.d("Could not call onAdClosed.", paramc);
        }
    }

    public void c(e parame) {
        ag.b("onAdClosed must be called on the main UI thread.");
        mx.a("Adapter called onAdClosed.");
        try {
            this.a.b();
            return;
        } catch (RemoteException parame) {
            mx.d("Could not call onAdClosed.", parame);
        }
    }

    public void d(c paramc) {
        ag.b("onAdLeftApplication must be called on the main UI thread.");
        mx.a("Adapter called onAdLeftApplication.");
        try {
            this.a.c();
            return;
        } catch (RemoteException paramc) {
            mx.d("Could not call onAdLeftApplication.", paramc);
        }
    }

    public void d(e parame) {
        ag.b("onAdLeftApplication must be called on the main UI thread.");
        mx.a("Adapter called onAdLeftApplication.");
        try {
            this.a.c();
            return;
        } catch (RemoteException parame) {
            mx.d("Could not call onAdLeftApplication.", parame);
        }
    }

    public void e(c paramc) {
        ag.b("onAdClicked must be called on the main UI thread.");
        mx.a("Adapter called onAdClicked.");
        try {
            this.a.a();
            return;
        } catch (RemoteException paramc) {
            mx.d("Could not call onAdClicked.", paramc);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */