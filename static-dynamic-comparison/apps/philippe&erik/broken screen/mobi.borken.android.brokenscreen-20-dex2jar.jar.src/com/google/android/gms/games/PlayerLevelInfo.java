package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hn;

public final class PlayerLevelInfo
  implements SafeParcelable
{
  public static final PlayerLevelInfoCreator CREATOR = new PlayerLevelInfoCreator();
  private final long MZ;
  private final long Na;
  private final PlayerLevel Nb;
  private final PlayerLevel Nc;
  private final int xJ;
  
  PlayerLevelInfo(int paramInt, long paramLong1, long paramLong2, PlayerLevel paramPlayerLevel1, PlayerLevel paramPlayerLevel2)
  {
    if (paramLong1 != -1L) {}
    for (boolean bool = true;; bool = false)
    {
      hn.A(bool);
      hn.f(paramPlayerLevel1);
      hn.f(paramPlayerLevel2);
      this.xJ = paramInt;
      this.MZ = paramLong1;
      this.Na = paramLong2;
      this.Nb = paramPlayerLevel1;
      this.Nc = paramPlayerLevel2;
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
      if ((!hl.equal(Long.valueOf(this.MZ), Long.valueOf(((PlayerLevelInfo)paramObject).MZ))) || (!hl.equal(Long.valueOf(this.Na), Long.valueOf(((PlayerLevelInfo)paramObject).Na))) || (!hl.equal(this.Nb, ((PlayerLevelInfo)paramObject).Nb))) {
        break;
      }
      bool1 = bool2;
    } while (hl.equal(this.Nc, ((PlayerLevelInfo)paramObject).Nc));
    return false;
  }
  
  public PlayerLevel getCurrentLevel()
  {
    return this.Nb;
  }
  
  public long getCurrentXpTotal()
  {
    return this.MZ;
  }
  
  public long getLastLevelUpTimestamp()
  {
    return this.Na;
  }
  
  public PlayerLevel getNextLevel()
  {
    return this.Nc;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    return hl.hashCode(new Object[] { Long.valueOf(this.MZ), Long.valueOf(this.Na), this.Nb, this.Nc });
  }
  
  public boolean isMaxLevel()
  {
    return this.Nb.equals(this.Nc);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    PlayerLevelInfoCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/PlayerLevelInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */