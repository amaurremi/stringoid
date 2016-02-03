package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public final class bo {
    private final ds a = new ds();
    private final at b;
    private com.google.android.gms.ads.a c;
    private bc d;
    private com.google.android.gms.ads.e[] e;
    private String f;
    private String g;
    private ViewGroup h;
    private com.google.android.gms.ads.a.a i;
    private com.google.android.gms.ads.c.b j;
    private com.google.android.gms.ads.c.d k;
    private com.google.android.gms.ads.a.e l;

    public bo(ViewGroup paramViewGroup) {
        this(paramViewGroup, null, false, at.a());
    }

    bo(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean, at paramat) {
        this(paramViewGroup, paramAttributeSet, paramBoolean, paramat, null);
    }

    bo(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean, at paramat, bc parambc) {
        this.h = paramViewGroup;
        this.b = paramat;
        if (paramAttributeSet != null) {
            paramat = paramViewGroup.getContext();
            try {
                paramAttributeSet = new ax(paramat, paramAttributeSet);
                this.e = paramAttributeSet.a(paramBoolean);
                this.f = paramAttributeSet.a();
                if (paramViewGroup.isInEditMode()) {
                    mv.a(paramViewGroup, new ay(paramat, this.e[0]), "Ads by Google");
                    return;
                }
            } catch (IllegalArgumentException paramAttributeSet) {
                mv.a(paramViewGroup, new ay(paramat, com.google.android.gms.ads.e.a), paramAttributeSet.getMessage(), paramAttributeSet.getMessage());
                return;
            }
        }
        this.d = parambc;
    }

    private void k() {
        try {
            com.google.android.gms.b.a locala = this.d.c();
            if (locala == null) {
                return;
            }
            this.h.addView((View) com.google.android.gms.b.d.a(locala));
            return;
        } catch (RemoteException localRemoteException) {
            mx.d("Failed to get an ad frame.", localRemoteException);
        }
    }

    private void l() {
        if (((this.e == null) || (this.f == null)) && (this.d == null)) {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        Context localContext = this.h.getContext();
        this.d = ar.a(localContext, new ay(localContext, this.e), this.f, this.a);
        if (this.c != null) {
            this.d.a(new aq(this.c));
        }
        if (this.i != null) {
            this.d.a(new aw(this.i));
        }
        if (this.j != null) {
            this.d.a(new hn(this.j));
        }
        if (this.k != null) {
            this.d.a(new hr(this.k), this.g);
        }
        if (this.l != null) {
            this.d.a(new ie(this.l, (com.google.android.gms.ads.a.b) this.h));
        }
        k();
    }

    public void a() {
        try {
            if (this.d != null) {
                this.d.d();
            }
            return;
        } catch (RemoteException localRemoteException) {
            mx.d("Failed to destroy AdView.", localRemoteException);
        }
    }

    public void a(com.google.android.gms.ads.a.a parama) {
        try {
            this.i = parama;
            bc localbc;
            if (this.d != null) {
                localbc = this.d;
                if (parama == null) {
                    break label38;
                }
            }
            label38:
            for (parama = new aw(parama); ; parama = null) {
                localbc.a(parama);
                return;
            }
            return;
        } catch (RemoteException parama) {
            mx.d("Failed to set the AppEventListener.", parama);
        }
    }

    public void a(com.google.android.gms.ads.a parama) {
        try {
            this.c = parama;
            bc localbc;
            if (this.d != null) {
                localbc = this.d;
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

    public void a(com.google.android.gms.ads.c.b paramb) {
        if (this.k != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.j = paramb;
            bc localbc;
            if (this.d != null) {
                localbc = this.d;
                if (paramb == null) {
                    break label55;
                }
            }
            label55:
            for (paramb = new hn(paramb); ; paramb = null) {
                localbc.a(paramb);
                return;
            }
            return;
        } catch (RemoteException paramb) {
            mx.d("Failed to set the InAppPurchaseListener.", paramb);
        }
    }

    public void a(bm parambm) {
        try {
            if (this.d == null) {
                l();
            }
            if (this.d.a(this.b.a(this.h.getContext(), parambm))) {
                this.a.a(parambm.i());
            }
            return;
        } catch (RemoteException parambm) {
            mx.d("Failed to load ad.", parambm);
        }
    }

    public void a(String paramString) {
        if (this.f != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.f = paramString;
    }

    public void a(com.google.android.gms.ads.e... paramVarArgs) {
        if (this.e != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        b(paramVarArgs);
    }

    public com.google.android.gms.ads.a b() {
        return this.c;
    }

    public void b(com.google.android.gms.ads.e... paramVarArgs) {
        this.e = paramVarArgs;
        try {
            if (this.d != null) {
                this.d.a(new ay(this.h.getContext(), this.e));
            }
            this.h.requestLayout();
            return;
        } catch (RemoteException paramVarArgs) {
            for (; ; ) {
                mx.d("Failed to set the ad size.", paramVarArgs);
            }
        }
    }

    public com.google.android.gms.ads.e c() {
        try {
            if (this.d != null) {
                com.google.android.gms.ads.e locale = this.d.k().a();
                return locale;
            }
        } catch (RemoteException localRemoteException) {
            mx.d("Failed to get the current AdSize.", localRemoteException);
            if (this.e != null) {
                return this.e[0];
            }
        }
        return null;
    }

    public com.google.android.gms.ads.e[] d() {
        return this.e;
    }

    public String e() {
        return this.f;
    }

    public com.google.android.gms.ads.a.a f() {
        return this.i;
    }

    public com.google.android.gms.ads.c.b g() {
        return this.j;
    }

    public void h() {
        try {
            if (this.d != null) {
                this.d.f();
            }
            return;
        } catch (RemoteException localRemoteException) {
            mx.d("Failed to call pause.", localRemoteException);
        }
    }

    public void i() {
        try {
            if (this.d != null) {
                this.d.g();
            }
            return;
        } catch (RemoteException localRemoteException) {
            mx.d("Failed to call resume.", localRemoteException);
        }
    }

    public String j() {
        try {
            if (this.d != null) {
                String str = this.d.l();
                return str;
            }
        } catch (RemoteException localRemoteException) {
            mx.d("Failed to get the mediation adapter class name.", localRemoteException);
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */