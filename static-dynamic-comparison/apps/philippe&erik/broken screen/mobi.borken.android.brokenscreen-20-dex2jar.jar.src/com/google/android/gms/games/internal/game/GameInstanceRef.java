package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.internal.constants.PlatformType;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;

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
  
  public boolean hY()
  {
    return getInteger("real_time_support") > 0;
  }
  
  public boolean hZ()
  {
    return getInteger("turn_based_support") > 0;
  }
  
  public int ia()
  {
    return getInteger("platform_type");
  }
  
  public boolean ib()
  {
    return getInteger("piracy_check") > 0;
  }
  
  public boolean ic()
  {
    return getInteger("installed") > 0;
  }
  
  public String toString()
  {
    return hl.e(this).a("ApplicationId", getApplicationId()).a("DisplayName", getDisplayName()).a("SupportsRealTime", Boolean.valueOf(hY())).a("SupportsTurnBased", Boolean.valueOf(hZ())).a("PlatformType", PlatformType.cm(ia())).a("PackageName", getPackageName()).a("PiracyCheckEnabled", Boolean.valueOf(ib())).a("Installed", Boolean.valueOf(ic())).toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/internal/game/GameInstanceRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */