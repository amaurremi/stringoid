package com.google.android.gms.games;

import com.google.android.gms.common.api.Api.ApiOptions.Optional;

public final class Games$GamesOptions
  implements Api.ApiOptions.Optional
{
  final boolean MM;
  final boolean MN;
  final int MO;
  final boolean MP;
  final int MQ;
  final String MR;
  
  private Games$GamesOptions()
  {
    this.MM = false;
    this.MN = true;
    this.MO = 17;
    this.MP = false;
    this.MQ = 4368;
    this.MR = null;
  }
  
  private Games$GamesOptions(Games.GamesOptions.Builder paramBuilder)
  {
    this.MM = paramBuilder.MM;
    this.MN = paramBuilder.MN;
    this.MO = paramBuilder.MO;
    this.MP = paramBuilder.MP;
    this.MQ = paramBuilder.MQ;
    this.MR = paramBuilder.MR;
  }
  
  public static Games.GamesOptions.Builder builder()
  {
    return new Games.GamesOptions.Builder(null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/Games$GamesOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */