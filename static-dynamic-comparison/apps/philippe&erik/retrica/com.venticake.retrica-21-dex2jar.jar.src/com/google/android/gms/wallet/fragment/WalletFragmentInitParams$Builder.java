package com.google.android.gms.wallet.fragment;

import com.google.android.gms.internal.hm;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragmentInitParams$Builder
{
  private WalletFragmentInitParams$Builder(WalletFragmentInitParams paramWalletFragmentInitParams) {}
  
  public WalletFragmentInitParams build()
  {
    boolean bool2 = true;
    if (((WalletFragmentInitParams.a(this.akB) != null) && (WalletFragmentInitParams.b(this.akB) == null)) || ((WalletFragmentInitParams.a(this.akB) == null) && (WalletFragmentInitParams.b(this.akB) != null)))
    {
      bool1 = true;
      hm.a(bool1, "Exactly one of MaskedWallet or MaskedWalletRequest is required");
      if (WalletFragmentInitParams.c(this.akB) < 0) {
        break label78;
      }
    }
    label78:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      hm.a(bool1, "masked wallet request code is required and must be non-negative");
      return this.akB;
      bool1 = false;
      break;
    }
  }
  
  public Builder setAccountName(String paramString)
  {
    WalletFragmentInitParams.a(this.akB, paramString);
    return this;
  }
  
  public Builder setMaskedWallet(MaskedWallet paramMaskedWallet)
  {
    WalletFragmentInitParams.a(this.akB, paramMaskedWallet);
    return this;
  }
  
  public Builder setMaskedWalletRequest(MaskedWalletRequest paramMaskedWalletRequest)
  {
    WalletFragmentInitParams.a(this.akB, paramMaskedWalletRequest);
    return this;
  }
  
  public Builder setMaskedWalletRequestCode(int paramInt)
  {
    WalletFragmentInitParams.a(this.akB, paramInt);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/fragment/WalletFragmentInitParams$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */