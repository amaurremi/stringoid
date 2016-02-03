package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;

public final class at {
    private AdListener lF;
    private AppEventListener lV;
    private AdSize[] lW;
    private String lX;
    private final bp ml = new bp();
    private final aj mm;
    private ap mn;
    private ViewGroup mo;
    private InAppPurchaseListener mp;

    public at(ViewGroup paramViewGroup) {
        this(paramViewGroup, null, false, aj.az());
    }

    public at(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean) {
        this(paramViewGroup, paramAttributeSet, paramBoolean, aj.az());
    }

    at(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean, aj paramaj) {
        this.mo = paramViewGroup;
        this.mm = paramaj;
        if (paramAttributeSet != null) {
            paramaj = paramViewGroup.getContext();
        }
        try {
            paramAttributeSet = new an(paramaj, paramAttributeSet);
            this.lW = paramAttributeSet.e(paramBoolean);
            this.lX = paramAttributeSet.getAdUnitId();
            if (paramViewGroup.isInEditMode()) {
                dv.a(paramViewGroup, new ak(paramaj, this.lW[0]), "Ads by Google");
            }
            return;
        } catch (IllegalArgumentException paramAttributeSet) {
            dv.a(paramViewGroup, new ak(paramaj, AdSize.BANNER), paramAttributeSet.getMessage(), paramAttributeSet.getMessage());
        }
    }

    private void aF() {
        try {
            d locald = this.mn.Q();
            if (locald == null) {
                return;
            }
            this.mo.addView((View) e.d(locald));
            return;
        } catch (RemoteException localRemoteException) {
            dw.c("Failed to get an ad frame.", localRemoteException);
        }
    }

    private void aG()
            throws RemoteException {
        if (((this.lW == null) || (this.lX == null)) && (this.mn == null)) {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        Context localContext = this.mo.getContext();
        this.mn = ag.a(localContext, new ak(localContext, this.lW), this.lX, this.ml);
        if (this.lF != null) {
            this.mn.a(new af(this.lF));
        }
        if (this.lV != null) {
            this.mn.a(new am(this.lV));
        }
        if (this.mp != null) {
            this.mn.a(new cp(this.mp));
        }
        aF();
    }

    public void a(as paramas) {
        try {
            if (this.mn == null) {
                aG();
            }
            if (this.mn.a(this.mm.a(this.mo.getContext(), paramas))) {
                this.ml.c(paramas.aC());
                this.ml.d(paramas.aD());
            }
            return;
        } catch (RemoteException paramas) {
            dw.c("Failed to load ad.", paramas);
        }
    }

    public void a(AdSize... paramVarArgs) {
        this.lW = paramVarArgs;
        try {
            if (this.mn != null) {
                this.mn.a(new ak(this.mo.getContext(), this.lW));
            }
            this.mo.requestLayout();
            return;
        } catch (RemoteException paramVarArgs) {
            for (; ; ) {
                dw.c("Failed to set the ad size.", paramVarArgs);
            }
        }
    }

    public void destroy() {
        try {
            if (this.mn != null) {
                this.mn.destroy();
            }
            return;
        } catch (RemoteException localRemoteException) {
            dw.c("Failed to destroy AdView.", localRemoteException);
        }
    }

    public AdListener getAdListener() {
        return this.lF;
    }

    public AdSize getAdSize() {
        try {
            if (this.mn != null) {
                AdSize localAdSize = this.mn.R().aA();
                return localAdSize;
            }
        } catch (RemoteException localRemoteException) {
            dw.c("Failed to get the current AdSize.", localRemoteException);
            if (this.lW != null) {
                return this.lW[0];
            }
        }
        return null;
    }

    public AdSize[] getAdSizes() {
        return this.lW;
    }

    public String getAdUnitId() {
        return this.lX;
    }

    public AppEventListener getAppEventListener() {
        return this.lV;
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.mp;
    }

    public void pause() {
        try {
            if (this.mn != null) {
                this.mn.pause();
            }
            return;
        } catch (RemoteException localRemoteException) {
            dw.c("Failed to call pause.", localRemoteException);
        }
    }

    public void recordManualImpression() {
        try {
            this.mn.ac();
            return;
        } catch (RemoteException localRemoteException) {
            dw.c("Failed to record impression.", localRemoteException);
        }
    }

    public void resume() {
        try {
            if (this.mn != null) {
                this.mn.resume();
            }
            return;
        } catch (RemoteException localRemoteException) {
            dw.c("Failed to call resume.", localRemoteException);
        }
    }

    public void setAdListener(AdListener paramAdListener) {
        try {
            this.lF = paramAdListener;
            ap localap;
            if (this.mn != null) {
                localap = this.mn;
                if (paramAdListener == null) {
                    break label38;
                }
            }
            label38:
            for (paramAdListener = new af(paramAdListener); ; paramAdListener = null) {
                localap.a(paramAdListener);
                return;
            }
            return;
        } catch (RemoteException paramAdListener) {
            dw.c("Failed to set the AdListener.", paramAdListener);
        }
    }

    public void setAdSizes(AdSize... paramVarArgs) {
        if (this.lW != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        a(paramVarArgs);
    }

    public void setAdUnitId(String paramString) {
        if (this.lX != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.lX = paramString;
    }

    public void setAppEventListener(AppEventListener paramAppEventListener) {
        try {
            this.lV = paramAppEventListener;
            ap localap;
            if (this.mn != null) {
                localap = this.mn;
                if (paramAppEventListener == null) {
                    break label38;
                }
            }
            label38:
            for (paramAppEventListener = new am(paramAppEventListener); ; paramAppEventListener = null) {
                localap.a(paramAppEventListener);
                return;
            }
            return;
        } catch (RemoteException paramAppEventListener) {
            dw.c("Failed to set the AppEventListener.", paramAppEventListener);
        }
    }

    public void setInAppPurchaseListener(InAppPurchaseListener paramInAppPurchaseListener) {
        try {
            this.mp = paramInAppPurchaseListener;
            ap localap;
            if (this.mn != null) {
                localap = this.mn;
                if (paramInAppPurchaseListener == null) {
                    break label38;
                }
            }
            label38:
            for (paramInAppPurchaseListener = new cp(paramInAppPurchaseListener); ; paramInAppPurchaseListener = null) {
                localap.a(paramInAppPurchaseListener);
                return;
            }
            return;
        } catch (RemoteException paramInAppPurchaseListener) {
            dw.c("Failed to set the InAppPurchaseListener.", paramInAppPurchaseListener);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */