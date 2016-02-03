package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.e;

public final class d
  extends e
  implements Player
{
  public d(com.google.android.gms.common.data.d paramd, int paramInt)
  {
    super(paramd, paramInt);
  }
  
  public String b()
  {
    return d("external_player_id");
  }
  
  public String c()
  {
    return d("profile_name");
  }
  
  public Uri d()
  {
    return e("profile_icon_image_uri");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Uri e()
  {
    return e("profile_hi_res_image_uri");
  }
  
  public boolean equals(Object paramObject)
  {
    return PlayerEntity.a(this, paramObject);
  }
  
  public long f()
  {
    return a("last_updated");
  }
  
  public Player g()
  {
    return new PlayerEntity(this);
  }
  
  public int hashCode()
  {
    return PlayerEntity.a(this);
  }
  
  public String toString()
  {
    return PlayerEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((PlayerEntity)g()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/games/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */