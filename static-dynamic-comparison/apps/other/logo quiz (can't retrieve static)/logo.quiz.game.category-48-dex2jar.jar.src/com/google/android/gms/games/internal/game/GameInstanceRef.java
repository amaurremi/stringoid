package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.games.internal.constants.PlatformType;

public final class GameInstanceRef
  extends d
  implements GameInstance
{
  GameInstanceRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public String getApplicationId()
  {
    return getString("external_game_id");
  }
  
  public String getDisplayName()
  {
    return getString("instance_display_name");
  }
  
  public String getPackageName()
  {
    return getString("package_name");
  }
  
  public boolean lb()
  {
    return getInteger("real_time_support") > 0;
  }
  
  public boolean lc()
  {
    return getInteger("turn_based_support") > 0;
  }
  
  public int ld()
  {
    return getInteger("platform_type");
  }
  
  public boolean le()
  {
    return getInteger("piracy_check") > 0;
  }
  
  public boolean lf()
  {
    return getInteger("installed") > 0;
  }
  
  public String toString()
  {
    return m.h(this).a("ApplicationId", getApplicationId()).a("DisplayName", getDisplayName()).a("SupportsRealTime", Boolean.valueOf(lb())).a("SupportsTurnBased", Boolean.valueOf(lc())).a("PlatformType", PlatformType.dH(ld())).a("PackageName", getPackageName()).a("PiracyCheckEnabled", Boolean.valueOf(le())).a("Installed", Boolean.valueOf(lf())).toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/internal/game/GameInstanceRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */