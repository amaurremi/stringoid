package com.google.android.gms.wallet;

import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;

public final class Wallet$WalletOptions
  implements Api.ApiOptions.HasOptions
{
  public final int environment;
  public final int theme;
  
  private Wallet$WalletOptions()
  {
    this(new Wallet.WalletOptions.Builder());
  }
  
  private Wallet$WalletOptions(Wallet.WalletOptions.Builder paramBuilder)
  {
    this.environment = Wallet.WalletOptions.Builder.a(paramBuilder);
    this.theme = Wallet.WalletOptions.Builder.b(paramBuilder);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/Wallet$WalletOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */