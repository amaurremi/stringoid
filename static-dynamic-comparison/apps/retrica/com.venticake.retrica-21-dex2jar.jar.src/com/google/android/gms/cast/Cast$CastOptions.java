package com.google.android.gms.cast;

import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;

public final class Cast$CastOptions
  implements Api.ApiOptions.HasOptions
{
  final CastDevice Aa;
  final Cast.Listener Ab;
  private final int Ac;
  
  private Cast$CastOptions(Cast.CastOptions.Builder paramBuilder)
  {
    this.Aa = paramBuilder.Ad;
    this.Ab = paramBuilder.Ae;
    this.Ac = Cast.CastOptions.Builder.a(paramBuilder);
  }
  
  public static Cast.CastOptions.Builder builder(CastDevice paramCastDevice, Cast.Listener paramListener)
  {
    return new Cast.CastOptions.Builder(paramCastDevice, paramListener, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/cast/Cast$CastOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */