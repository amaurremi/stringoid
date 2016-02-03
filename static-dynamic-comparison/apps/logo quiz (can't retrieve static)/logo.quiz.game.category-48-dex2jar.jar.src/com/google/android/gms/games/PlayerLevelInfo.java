package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class PlayerLevelInfo
  implements SafeParcelable
{
  public static final PlayerLevelInfoCreator CREATOR = new PlayerLevelInfoCreator();
  private final int BR;
  private final long VJ;
  private final long VK;
  private final PlayerLevel VL;
  private final PlayerLevel VM;
  
  PlayerLevelInfo(int paramInt, long paramLong1, long paramLong2, PlayerLevel paramPlayerLevel1, PlayerLevel paramPlayerLevel2)
  {
    if (paramLong1 != -1L) {}
    for (boolean bool = true;; bool = false)
    {
      n.I(bool);
      n.i(paramPlayerLevel1);
      n.i(paramPlayerLevel2);
      this.BR = paramInt;
      this.VJ = paramLong1;
      this.VK = paramLong2;
      this.VL = paramPlayerLevel1;
      this.VM = paramPlayerLevel2;
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
      if ((!m.equal(Long.valueOf(this.VJ), Long.valueOf(((PlayerLevelInfo)paramObject).VJ))) || (!m.equal(Long.valueOf(this.VK), Long.valueOf(((PlayerLevelInfo)paramObject).VK))) || (!m.equal(this.VL, ((PlayerLevelInfo)paramObject).VL))) {
        break;
      }
      bool1 = bool2;
    } while (m.equal(this.VM, ((PlayerLevelInfo)paramObject).VM));
    return false;
  }
  
  public PlayerLevel getCurrentLevel()
  {
    return this.VL;
  }
  
  public long getCurrentXpTotal()
  {
    return this.VJ;
  }
  
  public long getLastLevelUpTimestamp()
  {
    return this.VK;
  }
  
  public PlayerLevel getNextLevel()
  {
    return this.VM;
  }
  
  public int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return m.hashCode(new Object[] { Long.valueOf(this.VJ), Long.valueOf(this.VK), this.VL, this.VM });
  }
  
  public boolean isMaxLevel()
  {
    return this.VL.equals(this.VM);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    PlayerLevelInfoCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/PlayerLevelInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */