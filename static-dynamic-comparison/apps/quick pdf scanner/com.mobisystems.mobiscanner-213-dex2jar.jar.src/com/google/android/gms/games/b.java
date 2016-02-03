package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.e;

public final class b
  extends e
  implements Game
{
  public b(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return GameEntity.a(this, paramObject);
  }
  
  public String getDescription()
  {
    return getString("game_description");
  }
  
  public String getDisplayName()
  {
    return getString("display_name");
  }
  
  public int hashCode()
  {
    return GameEntity.a(this);
  }
  
  public boolean isMuted()
  {
    return getBoolean("muted");
  }
  
  public String lY()
  {
    return getString("external_game_id");
  }
  
  public String nA()
  {
    return getString("secondary_category");
  }
  
  public String nB()
  {
    return getString("developer_name");
  }
  
  public Uri nC()
  {
    return ap("game_icon_image_uri");
  }
  
  public String nD()
  {
    return getString("game_icon_image_url");
  }
  
  public Uri nE()
  {
    return ap("game_hi_res_image_uri");
  }
  
  public String nF()
  {
    return getString("game_hi_res_image_url");
  }
  
  public Uri nG()
  {
    return ap("featured_image_uri");
  }
  
  public String nH()
  {
    return getString("featured_image_url");
  }
  
  public boolean nI()
  {
    return getBoolean("play_enabled_game");
  }
  
  public boolean nJ()
  {
    return getInteger("installed") > 0;
  }
  
  public String nK()
  {
    return getString("package_name");
  }
  
  public int nL()
  {
    return getInteger("gameplay_acl_status");
  }
  
  public int nM()
  {
    return getInteger("achievement_total_count");
  }
  
  public int nN()
  {
    return getInteger("leaderboard_count");
  }
  
  public boolean nO()
  {
    return getInteger("real_time_support") > 0;
  }
  
  public boolean nP()
  {
    return getInteger("turn_based_support") > 0;
  }
  
  public Game nQ()
  {
    return new GameEntity(this);
  }
  
  public String nz()
  {
    return getString("primary_category");
  }
  
  public String toString()
  {
    return GameEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((GameEntity)nQ()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/games/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */