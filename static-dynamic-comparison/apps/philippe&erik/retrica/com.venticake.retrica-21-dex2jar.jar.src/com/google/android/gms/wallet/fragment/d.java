package com.google.android.gms.wallet.fragment;

import android.os.Bundle;
import com.google.android.gms.internal.ll.a;

class d
  extends ll.a
{
  private SupportWalletFragment.OnStateChangedListener a;
  private final SupportWalletFragment b;
  
  d(SupportWalletFragment paramSupportWalletFragment)
  {
    this.b = paramSupportWalletFragment;
  }
  
  public void a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (this.a != null) {
      this.a.onStateChanged(this.b, paramInt1, paramInt2, paramBundle);
    }
  }
  
  public void a(SupportWalletFragment.OnStateChangedListener paramOnStateChangedListener)
  {
    this.a = paramOnStateChangedListener;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/fragment/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */