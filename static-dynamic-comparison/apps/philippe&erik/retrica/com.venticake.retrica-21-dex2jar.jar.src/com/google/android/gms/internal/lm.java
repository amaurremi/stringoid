package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.d;

public abstract interface lm
  extends IInterface
{
  public abstract void a(Bundle paramBundle, lp paramlp);
  
  public abstract void a(lg paramlg, Bundle paramBundle, lp paramlp);
  
  public abstract void a(FullWalletRequest paramFullWalletRequest, Bundle paramBundle, lp paramlp);
  
  public abstract void a(MaskedWalletRequest paramMaskedWalletRequest, Bundle paramBundle, lo paramlo);
  
  public abstract void a(MaskedWalletRequest paramMaskedWalletRequest, Bundle paramBundle, lp paramlp);
  
  public abstract void a(NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest, Bundle paramBundle);
  
  public abstract void a(d paramd, Bundle paramBundle, lp paramlp);
  
  public abstract void a(String paramString1, String paramString2, Bundle paramBundle, lp paramlp);
  
  public abstract void o(Bundle paramBundle);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/lm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */