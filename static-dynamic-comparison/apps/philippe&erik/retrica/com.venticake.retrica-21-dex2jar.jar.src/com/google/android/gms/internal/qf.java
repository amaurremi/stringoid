package com.google.android.gms.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.MaskedWallet;

final class qf
  extends qe
{
  private final int b;
  
  public qf(lr paramlr, int paramInt)
  {
    super(null);
    this.b = paramInt;
  }
  
  public void a(int paramInt, FullWallet paramFullWallet, Bundle paramBundle)
  {
    Object localObject = null;
    if (paramBundle != null) {
      localObject = (PendingIntent)paramBundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
    }
    paramBundle = new ConnectionResult(paramInt, (PendingIntent)localObject);
    if (paramBundle.hasResolution()) {
      try
      {
        paramBundle.startResolutionForResult(lr.b(this.a), this.b);
        return;
      }
      catch (IntentSender.SendIntentException paramFullWallet)
      {
        Log.w("WalletClientImpl", "Exception starting pending intent", paramFullWallet);
        return;
      }
    }
    localObject = new Intent();
    int i;
    if (paramBundle.isSuccess())
    {
      i = -1;
      ((Intent)localObject).putExtra("com.google.android.gms.wallet.EXTRA_FULL_WALLET", paramFullWallet);
      paramFullWallet = lr.b(this.a).createPendingResult(this.b, (Intent)localObject, 1073741824);
      if (paramFullWallet == null) {
        Log.w("WalletClientImpl", "Null pending result returned for onFullWalletLoaded");
      }
    }
    else
    {
      if (paramInt == 408) {}
      for (i = 0;; i = 1)
      {
        ((Intent)localObject).putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", paramInt);
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
    Object localObject = null;
    if (paramBundle != null) {
      localObject = (PendingIntent)paramBundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
    }
    paramBundle = new ConnectionResult(paramInt, (PendingIntent)localObject);
    if (paramBundle.hasResolution()) {
      try
      {
        paramBundle.startResolutionForResult(lr.b(this.a), this.b);
        return;
      }
      catch (IntentSender.SendIntentException paramMaskedWallet)
      {
        Log.w("WalletClientImpl", "Exception starting pending intent", paramMaskedWallet);
        return;
      }
    }
    localObject = new Intent();
    int i;
    if (paramBundle.isSuccess())
    {
      i = -1;
      ((Intent)localObject).putExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET", paramMaskedWallet);
      paramMaskedWallet = lr.b(this.a).createPendingResult(this.b, (Intent)localObject, 1073741824);
      if (paramMaskedWallet == null) {
        Log.w("WalletClientImpl", "Null pending result returned for onMaskedWalletLoaded");
      }
    }
    else
    {
      if (paramInt == 408) {}
      for (i = 0;; i = 1)
      {
        ((Intent)localObject).putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", paramInt);
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
    paramBundle = lr.b(this.a).createPendingResult(this.b, paramBundle, 1073741824);
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
  
  public void i(int paramInt, Bundle paramBundle)
  {
    hm.b(paramBundle, "Bundle should not be null");
    paramBundle = new ConnectionResult(paramInt, (PendingIntent)paramBundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT"));
    if (paramBundle.hasResolution()) {
      try
      {
        paramBundle.startResolutionForResult(lr.b(this.a), this.b);
        return;
      }
      catch (IntentSender.SendIntentException paramBundle)
      {
        Log.w("WalletClientImpl", "Exception starting pending intent", paramBundle);
        return;
      }
    }
    Log.e("WalletClientImpl", "Create Wallet Objects confirmation UI will not be shown connection result: " + paramBundle);
    paramBundle = new Intent();
    paramBundle.putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", 413);
    paramBundle = lr.b(this.a).createPendingResult(this.b, paramBundle, 1073741824);
    if (paramBundle == null)
    {
      Log.w("WalletClientImpl", "Null pending result returned for onWalletObjectsCreated");
      return;
    }
    try
    {
      paramBundle.send(1);
      return;
    }
    catch (PendingIntent.CanceledException paramBundle)
    {
      Log.w("WalletClientImpl", "Exception setting pending result", paramBundle);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/qf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */