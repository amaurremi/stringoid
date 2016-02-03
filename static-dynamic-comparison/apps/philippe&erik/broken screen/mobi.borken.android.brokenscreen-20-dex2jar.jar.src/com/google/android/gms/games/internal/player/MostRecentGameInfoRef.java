package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;

public final class MostRecentGameInfoRef
  extends d
  implements MostRecentGameInfo
{
  private final PlayerColumnNames Nd;
  
  public MostRecentGameInfoRef(DataHolder paramDataHolder, int paramInt, PlayerColumnNames paramPlayerColumnNames)
  {
    super(paramDataHolder, paramInt);
    this.Nd = paramPlayerColumnNames;
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
  
  public String ik()
  {
    return getString(this.Nd.Sd);
  }
  
  public String il()
  {
    return getString(this.Nd.Se);
  }
  
  public long im()
  {
    return getLong(this.Nd.Sf);
  }
  
  public Uri in()
  {
    return aw(this.Nd.Sg);
  }
  
  public Uri io()
  {
    return aw(this.Nd.Sh);
  }
  
  public Uri ip()
  {
    return aw(this.Nd.Si);
  }
  
  public MostRecentGameInfo iq()
  {
    return new MostRecentGameInfoEntity(this);
  }
  
  public String toString()
  {
    return MostRecentGameInfoEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((MostRecentGameInfoEntity)iq()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/internal/player/MostRecentGameInfoRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */