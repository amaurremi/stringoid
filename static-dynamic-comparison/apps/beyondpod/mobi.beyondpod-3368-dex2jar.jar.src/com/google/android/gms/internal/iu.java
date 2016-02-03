package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;

public class iu
  extends dw<is>
{
  private final int Hi;
  private final Activity gs;
  private final String jG;
  private final int mTheme;
  
  @Deprecated
  public iu(Activity paramActivity, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener, int paramInt1, String paramString, int paramInt2)
  {
    this(paramActivity, new dw.c(paramConnectionCallbacks), new dw.g(paramOnConnectionFailedListener), paramInt1, paramString, paramInt2);
  }
  
  public iu(Activity paramActivity, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, int paramInt1, String paramString, int paramInt2)
  {
    super(paramActivity, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
    this.gs = paramActivity;
    this.Hi = paramInt1;
    this.jG = paramString;
    this.mTheme = paramInt2;
  }
  
  private Bundle fT()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", this.Hi);
    localBundle.putString("androidPackageName", this.gs.getPackageName());
    if (!TextUtils.isEmpty(this.jG)) {
      localBundle.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(this.jG, "com.google"));
    }
    localBundle.putInt("com.google.android.gms.wallet.EXTRA_THEME", this.mTheme);
    return localBundle;
  }
  
  protected void a(ec paramec, dw.e parame)
    throws RemoteException
  {
    paramec.a(parame, 4242000);
  }
  
  protected is aB(IBinder paramIBinder)
  {
    return is.a.az(paramIBinder);
  }
  
  protected String am()
  {
    return "com.google.android.gms.wallet.service.BIND";
  }
  
  protected String an()
  {
    return "com.google.android.gms.wallet.internal.IOwService";
  }
  
  public void changeMaskedWallet(String paramString1, String paramString2, int paramInt)
  {
    Bundle localBundle = fT();
    a locala = new a(paramInt);
    try
    {
      ((is)bQ()).a(paramString1, paramString2, localBundle, locala);
      return;
    }
    catch (RemoteException paramString1)
    {
      Log.e("WalletClientImpl", "RemoteException changing masked wallet", paramString1);
      locala.a(8, null, null);
    }
  }
  
  public void checkForPreAuthorization(int paramInt)
  {
    Bundle localBundle = fT();
    a locala = new a(paramInt);
    try
    {
      ((is)bQ()).a(localBundle, locala);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("WalletClientImpl", "RemoteException during checkForPreAuthorization", localRemoteException);
      locala.a(8, false, null);
    }
  }
  
  public void loadFullWallet(FullWalletRequest paramFullWalletRequest, int paramInt)
  {
    a locala = new a(paramInt);
    Bundle localBundle = fT();
    try
    {
      ((is)bQ()).a(paramFullWalletRequest, localBundle, locala);
      return;
    }
    catch (RemoteException paramFullWalletRequest)
    {
      Log.e("WalletClientImpl", "RemoteException getting full wallet", paramFullWalletRequest);
      locala.a(8, null, null);
    }
  }
  
  public void loadMaskedWallet(MaskedWalletRequest paramMaskedWalletRequest, int paramInt)
  {
    Bundle localBundle = fT();
    a locala = new a(paramInt);
    try
    {
      ((is)bQ()).a(paramMaskedWalletRequest, localBundle, locala);
      return;
    }
    catch (RemoteException paramMaskedWalletRequest)
    {
      Log.e("WalletClientImpl", "RemoteException getting masked wallet", paramMaskedWalletRequest);
      locala.a(8, null, null);
    }
  }
  
  public void notifyTransactionStatus(NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest)
  {
    Bundle localBundle = fT();
    try
    {
      ((is)bQ()).a(paramNotifyTransactionStatusRequest, localBundle);
      return;
    }
    catch (RemoteException paramNotifyTransactionStatusRequest) {}
  }
  
  final class a
    extends it.a
  {
    private final int oZ;
    
    public a(int paramInt)
    {
      this.oZ = paramInt;
    }
    
    public void a(int paramInt, FullWallet paramFullWallet, Bundle paramBundle)
    {
      PendingIntent localPendingIntent = null;
      if (paramBundle != null) {
        localPendingIntent = (PendingIntent)paramBundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
      }
      paramBundle = new ConnectionResult(paramInt, localPendingIntent);
      if (paramBundle.hasResolution()) {
        try
        {
          paramBundle.startResolutionForResult(iu.b(iu.this), this.oZ);
          return;
        }
        catch (IntentSender.SendIntentException paramFullWallet)
        {
          Log.w("WalletClientImpl", "Exception starting pending intent", paramFullWallet);
          return;
        }
      }
      int i;
      if (paramBundle.isSuccess())
      {
        i = -1;
        paramBundle = new Intent();
        paramBundle.putExtra("com.google.android.gms.wallet.EXTRA_FULL_WALLET", paramFullWallet);
        paramFullWallet = paramBundle;
        paramFullWallet = iu.b(iu.this).createPendingResult(this.oZ, paramFullWallet, 1073741824);
        if (paramFullWallet == null) {
          Log.w("WalletClientImpl", "Null pending result returned for onFullWalletLoaded");
        }
      }
      else
      {
        if (paramInt == 408) {}
        for (i = 0;; i = 1)
        {
          paramFullWallet = new Intent();
          paramFullWallet.putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", paramInt);
          break;
        }
      }
      try
      {
        paramFullWallet.send(i);
        return;
      }
      catch (PendingIntent.CanceledException paramFullWallet)
      {
        Log.w("WalletClientImpl", "Exception setting pending result", paramFullWallet);
      }
    }
    
    public void a(int paramInt, MaskedWallet paramMaskedWallet, Bundle paramBundle)
    {
      PendingIntent localPendingIntent = null;
      if (paramBundle != null) {
        localPendingIntent = (PendingIntent)paramBundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
      }
      paramBundle = new ConnectionResult(paramInt, localPendingIntent);
      if (paramBundle.hasResolution()) {
        try
        {
          paramBundle.startResolutionForResult(iu.b(iu.this), this.oZ);
          return;
        }
        catch (IntentSender.SendIntentException paramMaskedWallet)
        {
          Log.w("WalletClientImpl", "Exception starting pending intent", paramMaskedWallet);
          return;
        }
      }
      int i;
      if (paramBundle.isSuccess())
      {
        i = -1;
        paramBundle = new Intent();
        paramBundle.putExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET", paramMaskedWallet);
        paramMaskedWallet = paramBundle;
        paramMaskedWallet = iu.b(iu.this).createPendingResult(this.oZ, paramMaskedWallet, 1073741824);
        if (paramMaskedWallet == null) {
          Log.w("WalletClientImpl", "Null pending result returned for onMaskedWalletLoaded");
        }
      }
      else
      {
        if (paramInt == 408) {}
        for (i = 0;; i = 1)
        {
          paramMaskedWallet = new Intent();
          paramMaskedWallet.putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", paramInt);
          break;
        }
      }
      try
      {
        paramMaskedWallet.send(i);
        return;
      }
      catch (PendingIntent.CanceledException paramMaskedWallet)
      {
        Log.w("WalletClientImpl", "Exception setting pending result", paramMaskedWallet);
      }
    }
    
    public void a(int paramInt, boolean paramBoolean, Bundle paramBundle)
    {
      paramBundle = new Intent();
      paramBundle.putExtra("com.google.android.gm.wallet.EXTRA_IS_USER_PREAUTHORIZED", paramBoolean);
      paramBundle = iu.b(iu.this).createPendingResult(this.oZ, paramBundle, 1073741824);
      if (paramBundle == null)
      {
        Log.w("WalletClientImpl", "Null pending result returned for onPreAuthorizationDetermined");
        return;
      }
      try
      {
        paramBundle.send(-1);
        return;
      }
      catch (PendingIntent.CanceledException paramBundle)
      {
        Log.w("WalletClientImpl", "Exception setting pending result", paramBundle);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/iu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */