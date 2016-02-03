package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;

public final class GameBadgeRef
  extends d
  implements GameBadge
{
  GameBadgeRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return GameBadgeEntity.a(this, paramObject);
  }
  
  public String getDescription()
  {
    return getString("badge_description");
  }
  
  public Uri getIconImageUri()
  {
    return aw("badge_icon_image_uri");
  }
  
  public String getTitle()
  {
    return getString("badge_title");
  }
  
  public int getType()
  {
    return getInteger("badge_type");
  }
  
  public int hashCode()
  {
    return GameBadgeEntity.a(this);
  }
  
  public GameBadge ic()
  {
    return new GameBadgeEntity(this);
  }
  
  public String toString()
  {
    return GameBadgeEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((GameBadgeEntity)ic()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/game/GameBadgeRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */