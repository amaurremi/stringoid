package com.google.android.gms.cast;

import com.google.android.gms.internal.hm;

public final class Cast$CastOptions$Builder
{
  CastDevice Ad;
  Cast.Listener Ae;
  private int Af;
  
  private Cast$CastOptions$Builder(CastDevice paramCastDevice, Cast.Listener paramListener)
  {
    hm.b(paramCastDevice, "CastDevice parameter cannot be null");
    hm.b(paramListener, "CastListener parameter cannot be null");
    this.Ad = paramCastDevice;
    this.Ae = paramListener;
    this.Af = 0;
  }
  
  public Cast.CastOptions build()
  {
    return new Cast.CastOptions(this, null);
  }
  
  public Builder setVerboseLoggingEnabled(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.Af |= 0x1;
      return this;
    }
    this.Af &= 0xFFFFFFFE;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/cast/Cast$CastOptions$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */