package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;

public final class MostRecentGameInfoRef
  extends d
  implements MostRecentGameInfo
{
  private final PlayerColumnNames VN;
  
  public MostRecentGameInfoRef(DataHolder paramDataHolder, int paramInt, PlayerColumnNames paramPlayerColumnNames)
  {
    super(paramDataHolder, paramInt);
    this.VN = paramPlayerColumnNames;
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
  
  public String ln()
  {
    return getString(this.VN.aba);
  }
  
  public String lo()
  {
    return getString(this.VN.abb);
  }
  
  public long lp()
  {
    return getLong(this.VN.abc);
  }
  
  public Uri lq()
  {
    return aR(this.VN.abd);
  }
  
  public Uri lr()
  {
    return aR(this.VN.abe);
  }
  
  public Uri ls()
  {
    return aR(this.VN.abf);
  }
  
  public MostRecentGameInfo lt()
  {
    return new MostRecentGameInfoEntity(this);
  }
  
  public String toString()
  {
    return MostRecentGameInfoEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((MostRecentGameInfoEntity)lt()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/internal/player/MostRecentGameInfoRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */