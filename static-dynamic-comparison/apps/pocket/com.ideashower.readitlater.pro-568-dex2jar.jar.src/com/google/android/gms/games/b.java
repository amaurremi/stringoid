package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.e;

public final class b
  extends e
  implements Game
{
  public String b()
  {
    return d("external_game_id");
  }
  
  public String c()
  {
    return d("display_name");
  }
  
  public String d()
  {
    return d("primary_category");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return d("secondary_category");
  }
  
  public boolean equals(Object paramObject)
  {
    return GameEntity.a(this, paramObject);
  }
  
  public String f()
  {
    return d("game_description");
  }
  
  public String g()
  {
    return d("developer_name");
  }
  
  public Uri h()
  {
    return e("game_icon_image_uri");
  }
  
  public int hashCode()
  {
    return GameEntity.a(this);
  }
  
  public Uri i()
  {
    return e("game_hi_res_image_uri");
  }
  
  public Uri j()
  {
    return e("featured_image_uri");
  }
  
  public boolean k()
  {
    return c("play_enabled_game");
  }
  
  public boolean l()
  {
    return b("installed") > 0;
  }
  
  public String m()
  {
    return d("package_name");
  }
  
  public int n()
  {
    return b("gameplay_acl_status");
  }
  
  public int o()
  {
    return b("achievement_total_count");
  }
  
  public int p()
  {
    return b("leaderboard_count");
  }
  
  public Game q()
  {
    return new GameEntity(this);
  }
  
  public String toString()
  {
    return GameEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((GameEntity)q()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/games/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */