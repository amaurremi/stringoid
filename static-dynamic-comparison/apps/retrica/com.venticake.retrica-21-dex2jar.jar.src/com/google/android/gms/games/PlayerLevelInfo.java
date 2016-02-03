package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hm;

public final class PlayerLevelInfo
  implements SafeParcelable
{
  public static final PlayerLevelInfoCreator CREATOR = new PlayerLevelInfoCreator();
  private final long Nc;
  private final long Nd;
  private final PlayerLevel Ne;
  private final PlayerLevel Nf;
  private final int xM;
  
  PlayerLevelInfo(int paramInt, long paramLong1, long paramLong2, PlayerLevel paramPlayerLevel1, PlayerLevel paramPlayerLevel2)
  {
    if (paramLong1 != -1L) {}
    for (boolean bool = true;; bool = false)
    {
      hm.A(bool);
      hm.f(paramPlayerLevel1);
      hm.f(paramPlayerLevel2);
      this.xM = paramInt;
      this.Nc = paramLong1;
      this.Nd = paramLong2;
      this.Ne = paramPlayerLevel1;
      this.Nf = paramPlayerLevel2;
      return;
    }
  }
  
  public PlayerLevelInfo(long paramLong1, long paramLong2, PlayerLevel paramPlayerLevel1, PlayerLevel paramPlayerLevel2)
  {
    this(1, paramLong1, paramLong2, paramPlayerLevel1, paramPlayerLevel2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof PlayerLevelInfo)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == this);
      paramObject = (PlayerLevelInfo)paramObject;
      if ((!hk.equal(Long.valueOf(this.Nc), Long.valueOf(((PlayerLevelInfo)paramObject).Nc))) || (!hk.equal(Long.valueOf(this.Nd), Long.valueOf(((PlayerLevelInfo)paramObject).Nd))) || (!hk.equal(this.Ne, ((PlayerLevelInfo)paramObject).Ne))) {
        break;
      }
      bool1 = bool2;
    } while (hk.equal(this.Nf, ((PlayerLevelInfo)paramObject).Nf));
    return false;
  }
  
  public PlayerLevel getCurrentLevel()
  {
    return this.Ne;
  }
  
  public long getCurrentXpTotal()
  {
    return this.Nc;
  }
  
  public long getLastLevelUpTimestamp()
  {
    return this.Nd;
  }
  
  public PlayerLevel getNextLevel()
  {
    return this.Nf;
  }
  
  public int getVersionCode()
  {
    return this.xM;
  }
  
  public int hashCode()
  {
    return hk.hashCode(new Object[] { Long.valueOf(this.Nc), Long.valueOf(this.Nd), this.Ne, this.Nf });
  }
  
  public boolean isMaxLevel()
  {
    return this.Ne.equals(this.Nf);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    PlayerLevelInfoCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/PlayerLevelInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */