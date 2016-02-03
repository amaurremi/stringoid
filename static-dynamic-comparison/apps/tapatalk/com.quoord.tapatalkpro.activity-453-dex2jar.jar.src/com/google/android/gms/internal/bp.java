package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.MediationServerParameters;

import java.util.Map;

public final class bp
        extends bq.a {
    private Map<Class<? extends com.google.android.gms.ads.mediation.NetworkExtras>, com.google.android.gms.ads.mediation.NetworkExtras> nB;
    private Map<Class<? extends com.google.android.gms.ads.mediation.MediationAdapter>, Bundle> nC;

    private <NETWORK_EXTRAS extends com.google.ads.mediation.NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> br n(String paramString)
            throws RemoteException {
        try {
            Object localObject = Class.forName(paramString, false, bp.class.getClassLoader());
            if (com.google.ads.mediation.MediationAdapter.class.isAssignableFrom((Class) localObject)) {
                localObject = (com.google.ads.mediation.MediationAdapter) ((Class) localObject).newInstance();
                return new bw((com.google.ads.mediation.MediationAdapter) localObject, (com.google.ads.mediation.NetworkExtras) this.nB.get(((com.google.ads.mediation.MediationAdapter) localObject).getAdditionalParametersType()));
            }
            if (com.google.android.gms.ads.mediation.MediationAdapter.class.isAssignableFrom((Class) localObject)) {
                return new bu((com.google.android.gms.ads.mediation.MediationAdapter) ((Class) localObject).newInstance(), (Bundle) this.nC.get(localObject));
            }
            dw.z("Could not instantiate mediation adapter: " + paramString + " (not a valid adapter).");
            throw new RemoteException();
        } catch (Throwable localThrowable) {
            dw.z("Could not instantiate mediation adapter: " + paramString + ". " + localThrowable.getMessage());
            throw new RemoteException();
        }
    }

    public void c(Map<Class<? extends com.google.android.gms.ads.mediation.NetworkExtras>, com.google.android.gms.ads.mediation.NetworkExtras> paramMap) {
        this.nB = paramMap;
    }

    public void d(Map<Class<? extends com.google.android.gms.ads.mediation.MediationAdapter>, Bundle> paramMap) {
        this.nC = paramMap;
    }

    public br m(String paramString)
            throws RemoteException {
        return n(paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */