package com.google.android.gms.wallet.fragment;

public final class WalletFragmentOptions$Builder
{
  private WalletFragmentOptions$Builder(WalletFragmentOptions paramWalletFragmentOptions) {}
  
  public WalletFragmentOptions build()
  {
    return this.akD;
  }
  
  public Builder setEnvironment(int paramInt)
  {
    WalletFragmentOptions.a(this.akD, paramInt);
    return this;
  }
  
  public Builder setFragmentStyle(int paramInt)
  {
    WalletFragmentOptions.a(this.akD, new WalletFragmentStyle().setStyleResourceId(paramInt));
    return this;
  }
  
  public Builder setFragmentStyle(WalletFragmentStyle paramWalletFragmentStyle)
  {
    WalletFragmentOptions.a(this.akD, paramWalletFragmentStyle);
    return this;
  }
  
  public Builder setMode(int paramInt)
  {
    WalletFragmentOptions.c(this.akD, paramInt);
    return this;
  }
  
  public Builder setTheme(int paramInt)
  {
    WalletFragmentOptions.b(this.akD, paramInt);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/fragment/WalletFragmentOptions$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */