package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.hn;

public final class PlayerLevel
  implements SafeParcelable
{
  public static final PlayerLevelCreator CREATOR = new PlayerLevelCreator();
  private final int MW;
  private final long MX;
  private final long MY;
  private final int xJ;
  
  PlayerLevel(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if (paramLong1 >= 0L)
    {
      bool1 = true;
      hn.a(bool1, "Min XP must be positive!");
      if (paramLong2 <= paramLong1) {
        break label69;
      }
    }
    label69:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      hn.a(bool1, "Max XP must be more than min XP!");
      this.xJ = paramInt1;
      this.MW = paramInt2;
      this.MX = paramLong1;
      this.MY = paramLong2;
      return;
      bool1 = false;
      break;
    }
  }
  
  public PlayerLevel(int paramInt, long paramLong1, long paramLong2)
  {
    this(1, paramInt, paramLong1, paramLong2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof PlayerLevel)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this == paramObject);
      paramObject = (PlayerLevel)paramObject;
      if ((!hl.equal(Integer.valueOf(((PlayerLevel)paramObject).getLevelNumber()), Integer.valueOf(getLevelNumber()))) || (!hl.equal(Long.valueOf(((PlayerLevel)paramObject).getMinXp()), Long.valueOf(getMinXp())))) {
        break;
      }
      bool1 = bool2;
    } while (hl.equal(Long.valueOf(((PlayerLevel)paramObject).getMaxXp()), Long.valueOf(getMaxXp())));
    return false;
  }
  
  public int getLevelNumber()
  {
    return this.MW;
  }
  
  public long getMaxXp()
  {
    return this.MY;
  }
  
  public long getMinXp()
  {
    return this.MX;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    return hl.hashCode(new Object[] { Integer.valueOf(this.MW), Long.valueOf(this.MX), Long.valueOf(this.MY) });
  }
  
  public String toString()
  {
    return hl.e(this).a("LevelNumber", Integer.valueOf(getLevelNumber())).a("MinXp", Long.valueOf(getMinXp())).a("MaxXp", Long.valueOf(getMaxXp())).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    PlayerLevelCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/PlayerLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */