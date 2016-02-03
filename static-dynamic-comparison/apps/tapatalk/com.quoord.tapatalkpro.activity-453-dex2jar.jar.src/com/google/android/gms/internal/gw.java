package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.identity.intents.UserAddressRequest;

public class gw
        extends ff<gy> {
    private a NA;
    private final int mTheme;
    private Activity nS;
    private final String wG;

    public gw(Activity paramActivity, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, int paramInt) {
        super(paramActivity, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
        this.wG = paramString;
        this.nS = paramActivity;
        this.mTheme = paramInt;
    }

    protected gy R(IBinder paramIBinder) {
        return gy.a.T(paramIBinder);
    }

    public void a(UserAddressRequest paramUserAddressRequest, int paramInt) {
        hO();
        this.NA = new a(paramInt, this.nS);
        try {
            Bundle localBundle = new Bundle();
            localBundle.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", getContext().getPackageName());
            if (!TextUtils.isEmpty(this.wG)) {
                localBundle.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(this.wG, "com.google"));
            }
            localBundle.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", this.mTheme);
            hN().a(this.NA, paramUserAddressRequest, localBundle);
            return;
        } catch (RemoteException paramUserAddressRequest) {
            Log.e("AddressClientImpl", "Exception requesting user address", paramUserAddressRequest);
            paramUserAddressRequest = new Bundle();
            paramUserAddressRequest.putInt("com.google.android.gms.identity.intents.EXTRA_ERROR_CODE", 555);
            this.NA.d(1, paramUserAddressRequest);
        }
    }

    protected void a(fm paramfm, ff.e parame)
            throws RemoteException {
        paramfm.d(parame, 4452000, getContext().getPackageName());
    }

    protected String bg() {
        return "com.google.android.gms.identity.service.BIND";
    }

    protected String bh() {
        return "com.google.android.gms.identity.intents.internal.IAddressService";
    }

    public void disconnect() {
        super.disconnect();
        if (this.NA != null) {
            a.a(this.NA, null);
            this.NA = null;
        }
    }

    protected gy hN() {
        return (gy) super.eM();
    }

    protected void hO() {
        super.bT();
    }

    public static final class a
            extends gx.a {
        private final int CV;
        private Activity nS;

        public a(int paramInt, Activity paramActivity) {
            this.CV = paramInt;
            this.nS = paramActivity;
        }

        private void setActivity(Activity paramActivity) {
            this.nS = paramActivity;
        }

        public void d(int paramInt, Bundle paramBundle) {
            Object localObject;
            if (paramInt == 1) {
                localObject = new Intent();
                ((Intent) localObject).putExtras(paramBundle);
                paramBundle = this.nS.createPendingResult(this.CV, (Intent) localObject, 1073741824);
                if (paramBundle != null) {
                }
            }
            for (; ; ) {
                return;
                try {
                    paramBundle.send(1);
                    return;
                } catch (PendingIntent.CanceledException paramBundle) {
                    Log.w("AddressClientImpl", "Exception settng pending result", paramBundle);
                    return;
                }
                localObject = null;
                if (paramBundle != null) {
                    localObject = (PendingIntent) paramBundle.getParcelable("com.google.android.gms.identity.intents.EXTRA_PENDING_INTENT");
                }
                paramBundle = new ConnectionResult(paramInt, (PendingIntent) localObject);
                if (paramBundle.hasResolution()) {
                    try {
                        paramBundle.startResolutionForResult(this.nS, this.CV);
                        return;
                    } catch (IntentSender.SendIntentException paramBundle) {
                        Log.w("AddressClientImpl", "Exception starting pending intent", paramBundle);
                        return;
                    }
                }
                try {
                    paramBundle = this.nS.createPendingResult(this.CV, new Intent(), 1073741824);
                    if (paramBundle != null) {
                        paramBundle.send(1);
                        return;
                    }
                } catch (PendingIntent.CanceledException paramBundle) {
                    Log.w("AddressClientImpl", "Exception setting pending result", paramBundle);
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/gw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */