package com.google.android.gms.wallet;

import java.util.Locale;

public final class Wallet$WalletOptions$Builder
{
  private int akb = 0;
  private int mTheme = 0;
  
  public Wallet.WalletOptions build()
  {
    return new Wallet.WalletOptions(this, null);
  }
  
  public Builder setEnvironment(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 2) || (paramInt == 1))
    {
      this.akb = paramInt;
      return this;
    }
    throw new IllegalArgumentException(String.format(Locale.US, "Invalid environment value %d", new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public Builder setTheme(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 1))
    {
      this.mTheme = paramInt;
      return this;
    }
    throw new IllegalArgumentException(String.format(Locale.US, "Invalid theme value %d", new Object[] { Integer.valueOf(paramInt) }));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/Wallet$WalletOptions$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */