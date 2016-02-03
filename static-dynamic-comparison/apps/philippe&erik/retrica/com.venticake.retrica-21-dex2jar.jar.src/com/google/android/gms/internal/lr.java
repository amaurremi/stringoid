package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;

public class lr
  extends hb<lm>
{
  private final int akb;
  private final int mTheme;
  private final Activity og;
  private final String yQ;
  
  public lr(Activity paramActivity, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, int paramInt1, String paramString, int paramInt2)
  {
    super(paramActivity, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
    this.og = paramActivity;
    this.akb = paramInt1;
    this.yQ = paramString;
    this.mTheme = paramInt2;
  }
  
  public static Bundle a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", paramInt1);
    localBundle.putString("androidPackageName", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localBundle.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(paramString2, "com.google"));
    }
    localBundle.putInt("com.google.android.gms.wallet.EXTRA_THEME", paramInt2);
    return localBundle;
  }
  
  private Bundle ni()
  {
    return a(this.akb, this.og.getPackageName(), this.yQ, this.mTheme);
  }
  
  protected void a(hi paramhi, hb.e parame)
  {
    paramhi.a(parame, 5089000);
  }
  
  public void a(FullWalletRequest paramFullWalletRequest, int paramInt)
  {
    qf localqf = new qf(this, paramInt);
    Bundle localBundle = ni();
    try
    {
      ((lm)ft()).a(paramFullWalletRequest, localBundle, localqf);
      return;
    }
    catch (RemoteException paramFullWalletRequest)
    {
      Log.e("WalletClientImpl", "RemoteException getting full wallet", paramFullWalletRequest);
      localqf.a(8, null, Bundle.EMPTY);
    }
  }
  
  public void a(MaskedWalletRequest paramMaskedWalletRequest, int paramInt)
  {
    Bundle localBundle = ni();
    qf localqf = new qf(this, paramInt);
    try
    {
      ((lm)ft()).a(paramMaskedWalletRequest, localBundle, localqf);
      return;
    }
    catch (RemoteException paramMaskedWalletRequest)
    {
      Log.e("WalletClientImpl", "RemoteException getting masked wallet", paramMaskedWalletRequest);
      localqf.a(8, null, Bundle.EMPTY);
    }
  }
  
  public void a(NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest)
  {
    Bundle localBundle = ni();
    try
    {
      ((lm)ft()).a(paramNotifyTransactionStatusRequest, localBundle);
      return;
    }
    catch (RemoteException paramNotifyTransactionStatusRequest) {}
  }
  
  protected lm bu(IBinder paramIBinder)
  {
    return lm.a.bq(paramIBinder);
  }
  
  protected String bu()
  {
    return "com.google.android.gms.wallet.service.BIND";
  }
  
  protected String bv()
  {
    return "com.google.android.gms.wallet.internal.IOwService";
  }
  
  public void d(String paramString1, String paramString2, int paramInt)
  {
    Bundle localBundle = ni();
    qf localqf = new qf(this, paramInt);
    try
    {
      ((lm)ft()).a(paramString1, paramString2, localBundle, localqf);
      return;
    }
    catch (RemoteException paramString1)
    {
      Log.e("WalletClientImpl", "RemoteException changing masked wallet", paramString1);
      localqf.a(8, null, Bundle.EMPTY);
    }
  }
  
  public void dQ(int paramInt)
  {
    Bundle localBundle = ni();
    qf localqf = new qf(this, paramInt);
    try
    {
      ((lm)ft()).a(localBundle, localqf);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("WalletClientImpl", "RemoteException during checkForPreAuthorization", localRemoteException);
      localqf.a(8, false, Bundle.EMPTY);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/lr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */