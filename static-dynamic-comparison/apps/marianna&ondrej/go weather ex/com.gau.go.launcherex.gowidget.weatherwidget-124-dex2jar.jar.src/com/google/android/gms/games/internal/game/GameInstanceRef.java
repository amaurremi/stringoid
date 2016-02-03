package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.b;
import com.google.android.gms.games.internal.constants.PlatformType;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fo.a;

public final class GameInstanceRef
  extends b
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
  
  public boolean hi()
  {
    return getInteger("real_time_support") > 0;
  }
  
  public boolean hj()
  {
    return getInteger("turn_based_support") > 0;
  }
  
  public int hk()
  {
    return getInteger("platform_type");
  }
  
  public boolean hl()
  {
    return getInteger("piracy_check") > 0;
  }
  
  public boolean hm()
  {
    return getInteger("installed") > 0;
  }
  
  public String toString()
  {
    return fo.e(this).a("ApplicationId", getApplicationId()).a("DisplayName", getDisplayName()).a("SupportsRealTime", Boolean.valueOf(hi())).a("SupportsTurnBased", Boolean.valueOf(hj())).a("PlatformType", PlatformType.bd(hk())).a("PackageName", getPackageName()).a("PiracyCheckEnabled", Boolean.valueOf(hl())).a("Installed", Boolean.valueOf(hm())).toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/games/internal/game/GameInstanceRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */