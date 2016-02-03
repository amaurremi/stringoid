package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchase;

public class cq
        implements InAppPurchase {
    private final cn oF;

    public cq(cn paramcn) {
        this.oF = paramcn;
    }

    public String getProductId() {
        try {
            String str = this.oF.getProductId();
            return str;
        } catch (RemoteException localRemoteException) {
            dw.c("Could not forward getProductId to InAppPurchase", localRemoteException);
        }
        return null;
    }

    public void recordPlayBillingResolution(int paramInt) {
        try {
            this.oF.recordPlayBillingResolution(paramInt);
            return;
        } catch (RemoteException localRemoteException) {
            dw.c("Could not forward recordPlayBillingResolution to InAppPurchase", localRemoteException);
        }
    }

    public void recordResolution(int paramInt) {
        try {
            this.oF.recordResolution(paramInt);
            return;
        } catch (RemoteException localRemoteException) {
            dw.c("Could not forward recordResolution to InAppPurchase", localRemoteException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */