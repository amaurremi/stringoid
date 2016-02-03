package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
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
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;

public class jg
        extends ff<jb> {
    private final int acq;
    private final int mTheme;
    private final Activity nS;
    private final String wG;

    public jg(Activity paramActivity, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, int paramInt1, String paramString, int paramInt2) {
        super(paramActivity, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
        this.nS = paramActivity;
        this.acq = paramInt1;
        this.wG = paramString;
        this.mTheme = paramInt2;
    }

    public static Bundle a(int paramInt1, String paramString1, String paramString2, int paramInt2) {
        Bundle localBundle = new Bundle();
        localBundle.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", paramInt1);
        localBundle.putString("androidPackageName", paramString1);
        if (!TextUtils.isEmpty(paramString2)) {
            localBundle.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(paramString2, "com.google"));
        }
        localBundle.putInt("com.google.android.gms.wallet.EXTRA_THEME", paramInt2);
        return localBundle;
    }

    private Bundle lX() {
        return a(this.acq, this.nS.getPackageName(), this.wG, this.mTheme);
    }

    protected void a(fm paramfm, ff.e parame)
            throws RemoteException {
        paramfm.a(parame, 4452000);
    }

    public void a(FullWalletRequest paramFullWalletRequest, int paramInt) {
        b localb = new b(paramInt);
        Bundle localBundle = lX();
        try {
            ((jb) eM()).a(paramFullWalletRequest, localBundle, localb);
            return;
        } catch (RemoteException paramFullWalletRequest) {
            Log.e("WalletClientImpl", "RemoteException getting full wallet", paramFullWalletRequest);
            localb.a(8, null, Bundle.EMPTY);
        }
    }

    public void a(MaskedWalletRequest paramMaskedWalletRequest, int paramInt) {
        Bundle localBundle = lX();
        b localb = new b(paramInt);
        try {
            ((jb) eM()).a(paramMaskedWalletRequest, localBundle, localb);
            return;
        } catch (RemoteException paramMaskedWalletRequest) {
            Log.e("WalletClientImpl", "RemoteException getting masked wallet", paramMaskedWalletRequest);
            localb.a(8, null, Bundle.EMPTY);
        }
    }

    public void a(NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest) {
        Bundle localBundle = lX();
        try {
            ((jb) eM()).a(paramNotifyTransactionStatusRequest, localBundle);
            return;
        } catch (RemoteException paramNotifyTransactionStatusRequest) {
        }
    }

    protected jb aY(IBinder paramIBinder) {
        return jb.a.aU(paramIBinder);
    }

    protected String bg() {
        return "com.google.android.gms.wallet.service.BIND";
    }

    protected String bh() {
        return "com.google.android.gms.wallet.internal.IOwService";
    }

    public void cD(int paramInt) {
        Bundle localBundle = lX();
        b localb = new b(paramInt);
        try {
            ((jb) eM()).a(localBundle, localb);
            return;
        } catch (RemoteException localRemoteException) {
            Log.e("WalletClientImpl", "RemoteException during checkForPreAuthorization", localRemoteException);
            localb.a(8, false, Bundle.EMPTY);
        }
    }

    public void d(String paramString1, String paramString2, int paramInt) {
        Bundle localBundle = lX();
        b localb = new b(paramInt);
        try {
            ((jb) eM()).a(paramString1, paramString2, localBundle, localb);
            return;
        } catch (RemoteException paramString1) {
            Log.e("WalletClientImpl", "RemoteException changing masked wallet", paramString1);
            localb.a(8, null, Bundle.EMPTY);
        }
    }

    private static class a
            extends je.a {
        public void a(int paramInt, FullWallet paramFullWallet, Bundle paramBundle) {
        }

        public void a(int paramInt, MaskedWallet paramMaskedWallet, Bundle paramBundle) {
        }

        public void a(int paramInt, boolean paramBoolean, Bundle paramBundle) {
        }

        public void a(Status paramStatus, ix paramix, Bundle paramBundle) {
        }

        public void f(int paramInt, Bundle paramBundle) {
        }
    }

    final class b
            extends jg.a {
        private final int CV;

        public b(int paramInt) {
            super();
            this.CV = paramInt;
        }

        public void a(int paramInt, FullWallet paramFullWallet, Bundle paramBundle) {
            Object localObject = null;
            if (paramBundle != null) {
                localObject = (PendingIntent) paramBundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            paramBundle = new ConnectionResult(paramInt, (PendingIntent) localObject);
            if (paramBundle.hasResolution()) {
                try {
                    paramBundle.startResolutionForResult(jg.b(jg.this), this.CV);
                    return;
                } catch (IntentSender.SendIntentException paramFullWallet) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", paramFullWallet);
                    return;
                }
            }
            localObject = new Intent();
            int i;
            if (paramBundle.isSuccess()) {
                i = -1;
                ((Intent) localObject).putExtra("com.google.android.gms.wallet.EXTRA_FULL_WALLET", paramFullWallet);
                paramFullWallet = jg.b(jg.this).createPendingResult(this.CV, (Intent) localObject, 1073741824);
                if (paramFullWallet == null) {
                    Log.w("WalletClientImpl", "Null pending result returned for onFullWalletLoaded");
                }
            } else {
                if (paramInt == 408) {
                }
                for (i = 0; ; i = 1) {
                    ((Intent) localObject).putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", paramInt);
                    break;
                }
            }
            try {
                paramFullWallet.send(i);
                return;
            } catch (PendingIntent.CanceledException paramFullWallet) {
                Log.w("WalletClientImpl", "Exception setting pending result", paramFullWallet);
            }
        }

        public void a(int paramInt, MaskedWallet paramMaskedWallet, Bundle paramBundle) {
            Object localObject = null;
            if (paramBundle != null) {
                localObject = (PendingIntent) paramBundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            paramBundle = new ConnectionResult(paramInt, (PendingIntent) localObject);
            if (paramBundle.hasResolution()) {
                try {
                    paramBundle.startResolutionForResult(jg.b(jg.this), this.CV);
                    return;
                } catch (IntentSender.SendIntentException paramMaskedWallet) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", paramMaskedWallet);
                    return;
                }
            }
            localObject = new Intent();
            int i;
            if (paramBundle.isSuccess()) {
                i = -1;
                ((Intent) localObject).putExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET", paramMaskedWallet);
                paramMaskedWallet = jg.b(jg.this).createPendingResult(this.CV, (Intent) localObject, 1073741824);
                if (paramMaskedWallet == null) {
                    Log.w("WalletClientImpl", "Null pending result returned for onMaskedWalletLoaded");
                }
            } else {
                if (paramInt == 408) {
                }
                for (i = 0; ; i = 1) {
                    ((Intent) localObject).putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", paramInt);
                    break;
                }
            }
            try {
                paramMaskedWallet.send(i);
                return;
            } catch (PendingIntent.CanceledException paramMaskedWallet) {
                Log.w("WalletClientImpl", "Exception setting pending result", paramMaskedWallet);
            }
        }

        public void a(int paramInt, boolean paramBoolean, Bundle paramBundle) {
            paramBundle = new Intent();
            paramBundle.putExtra("com.google.android.gm.wallet.EXTRA_IS_USER_PREAUTHORIZED", paramBoolean);
            paramBundle = jg.b(jg.this).createPendingResult(this.CV, paramBundle, 1073741824);
            if (paramBundle == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onPreAuthorizationDetermined");
                return;
            }
            try {
                paramBundle.send(-1);
                return;
            } catch (PendingIntent.CanceledException paramBundle) {
                Log.w("WalletClientImpl", "Exception setting pending result", paramBundle);
            }
        }

        public void f(int paramInt, Bundle paramBundle) {
            fq.b(paramBundle, "Bundle should not be null");
            paramBundle = new ConnectionResult(paramInt, (PendingIntent) paramBundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT"));
            if (paramBundle.hasResolution()) {
                try {
                    paramBundle.startResolutionForResult(jg.b(jg.this), this.CV);
                    return;
                } catch (IntentSender.SendIntentException paramBundle) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", paramBundle);
                    return;
                }
            }
            Log.e("WalletClientImpl", "Create Wallet Objects confirmation UI will not be shown connection result: " + paramBundle);
            paramBundle = new Intent();
            paramBundle.putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", 413);
            paramBundle = jg.b(jg.this).createPendingResult(this.CV, paramBundle, 1073741824);
            if (paramBundle == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onWalletObjectsCreated");
                return;
            }
            try {
                paramBundle.send(1);
                return;
            } catch (PendingIntent.CanceledException paramBundle) {
                Log.w("WalletClientImpl", "Exception setting pending result", paramBundle);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/jg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */