package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;

public final class MostRecentGameInfoRef
  extends d
  implements MostRecentGameInfo
{
  private final PlayerColumnNames Ng;
  
  public MostRecentGameInfoRef(DataHolder paramDataHolder, int paramInt, PlayerColumnNames paramPlayerColumnNames)
  {
    super(paramDataHolder, paramInt);
    this.Ng = paramPlayerColumnNames;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return MostRecentGameInfoEntity.a(this, paramObject);
  }
  
  public int hashCode()
  {
    return MostRecentGameInfoEntity.a(this);
  }
  
  public String ip()
  {
    return getString(this.Ng.Sg);
  }
  
  public String iq()
  {
    return getString(this.Ng.Sh);
  }
  
  public long ir()
  {
    return getLong(this.Ng.Si);
  }
  
  public Uri is()
  {
    return aw(this.Ng.Sj);
  }
  
  public Uri it()
  {
    return aw(this.Ng.Sk);
  }
  
  public Uri iu()
  {
    return aw(this.Ng.Sl);
  }
  
  public MostRecentGameInfo iv()
  {
    return new MostRecentGameInfoEntity(this);
  }
  
  public String toString()
  {
    return MostRecentGameInfoEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((MostRecentGameInfoEntity)iv()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/player/MostRecentGameInfoRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */