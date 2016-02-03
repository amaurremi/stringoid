package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.b.b;
import com.google.android.gms.ads.b.b.a;
import com.google.android.gms.ads.b.g;

import java.util.Map;

@ii
public final class ds
        extends du {
    private Map<Class<? extends g>, g> a;

    private <NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> dx c(String paramString) {
        try {
            Object localObject = Class.forName(paramString, false, ds.class.getClassLoader());
            if (MediationAdapter.class.isAssignableFrom((Class) localObject)) {
                localObject = (MediationAdapter) ((Class) localObject).newInstance();
                return new eg((MediationAdapter) localObject, (NetworkExtras) this.a.get(((MediationAdapter) localObject).getAdditionalParametersType()));
            }
            if (b.class.isAssignableFrom((Class) localObject)) {
                return new ee((b) ((Class) localObject).newInstance());
            }
            mx.e("Could not instantiate mediation adapter: " + paramString + " (not a valid adapter).");
            throw new RemoteException();
        } catch (Throwable localThrowable) {
            mx.e("Could not instantiate mediation adapter: " + paramString + ". " + localThrowable.getMessage());
            throw new RemoteException();
        }
    }

    public dx a(String paramString) {
        return c(paramString);
    }

    public void a(Map<Class<? extends g>, g> paramMap) {
        this.a = paramMap;
    }

    public boolean b(String paramString) {
        try {
            boolean bool = a.class.isAssignableFrom(Class.forName(paramString, false, ds.class.getClassLoader()));
            return bool;
        } catch (Throwable localThrowable) {
            mx.e("Could not load custom event implementation class: " + paramString + ", assuming old implementation.");
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */