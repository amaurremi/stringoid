package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.a.c;
import com.google.android.gms.ads.a.f;
import com.google.android.gms.ads.c.b;
import com.google.android.gms.ads.c.d;

public class bp {
    private final ds a = new ds();
    private final Context b;
    private final at c;
    private com.google.android.gms.ads.a d;
    private bc e;
    private String f;
    private String g;
    private com.google.android.gms.ads.a.a h;
    private d i;
    private b j;
    private c k;
    private f l;

    public bp(Context paramContext) {
        this(paramContext, at.a(), null);
    }

    public bp(Context paramContext, at paramat, c paramc) {
        this.b = paramContext;
        this.c = paramat;
        this.k = paramc;
    }

    private void b(String paramString) {
        if (this.f == null) {
            c(paramString);
        }
        this.e = ar.a(this.b, new ay(), this.f, this.a);
        if (this.d != null) {
            this.e.a(new aq(this.d));
        }
        if (this.h != null) {
            this.e.a(new aw(this.h));
        }
        if (this.j != null) {
            this.e.a(new hn(this.j));
        }
        if (this.i != null) {
            this.e.a(new hr(this.i), this.g);
        }
        if (this.l != null) {
            this.e.a(new if (this.l,this.k));
        }
    }

    private void c(String paramString) {
        if (this.e == null) {
            throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + paramString + " is called.");
        }
    }

    public void a() {
        try {
            c("show");
            this.e.h();
            return;
        } catch (RemoteException localRemoteException) {
            mx.d("Failed to show interstitial.", localRemoteException);
        }
    }

    public void a(com.google.android.gms.ads.a parama) {
        try {
            this.d = parama;
            bc localbc;
            if (this.e != null) {
                localbc = this.e;
                if (parama == null) {
                    break label38;
                }
            }
            label38:
            for (parama = new aq(parama); ; parama = null) {
                localbc.a(parama);
                return;
            }
            return;
        } catch (RemoteException parama) {
            mx.d("Failed to set the AdListener.", parama);
        }
    }

    public void a(bm parambm) {
        try {
            if (this.e == null) {
                b("loadAd");
            }
            if (this.e.a(this.c.a(this.b, parambm))) {
                this.a.a(parambm.i());
            }
            return;
        } catch (RemoteException parambm) {
            mx.d("Failed to load ad.", parambm);
        }
    }

    public void a(String paramString) {
        if (this.f != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.f = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */