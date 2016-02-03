package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.m.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class MostRecentGameInfoEntity
  implements SafeParcelable, MostRecentGameInfo
{
  public static final MostRecentGameInfoEntityCreator CREATOR = new MostRecentGameInfoEntityCreator();
  private final int BR;
  private final String aaB;
  private final String aaC;
  private final long aaD;
  private final Uri aaE;
  private final Uri aaF;
  private final Uri aaG;
  
  MostRecentGameInfoEntity(int paramInt, String paramString1, String paramString2, long paramLong, Uri paramUri1, Uri paramUri2, Uri paramUri3)
  {
    this.BR = paramInt;
    this.aaB = paramString1;
    this.aaC = paramString2;
    this.aaD = paramLong;
    this.aaE = paramUri1;
    this.aaF = paramUri2;
    this.aaG = paramUri3;
  }
  
  public MostRecentGameInfoEntity(MostRecentGameInfo paramMostRecentGameInfo)
  {
    this.BR = 2;
    this.aaB = paramMostRecentGameInfo.ln();
    this.aaC = paramMostRecentGameInfo.lo();
    this.aaD = paramMostRecentGameInfo.lp();
    this.aaE = paramMostRecentGameInfo.lq();
    this.aaF = paramMostRecentGameInfo.lr();
    this.aaG = paramMostRecentGameInfo.ls();
  }
  
  static int a(MostRecentGameInfo paramMostRecentGameInfo)
  {
    return m.hashCode(new Object[] { paramMostRecentGameInfo.ln(), paramMostRecentGameInfo.lo(), Long.valueOf(paramMostRecentGameInfo.lp()), paramMostRecentGameInfo.lq(), paramMostRecentGameInfo.lr(), paramMostRecentGameInfo.ls() });
  }
  
  static boolean a(MostRecentGameInfo paramMostRecentGameInfo, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof MostRecentGameInfo)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramMostRecentGameInfo == paramObject);
      paramObject = (MostRecentGameInfo)paramObject;
      if ((!m.equal(((MostRecentGameInfo)paramObject).ln(), paramMostRecentGameInfo.ln())) || (!m.equal(((MostRecentGameInfo)paramObject).lo(), paramMostRecentGameInfo.lo())) || (!m.equal(Long.valueOf(((MostRecentGameInfo)paramObject).lp()), Long.valueOf(paramMostRecentGameInfo.lp()))) || (!m.equal(((MostRecentGameInfo)paramObject).lq(), paramMostRecentGameInfo.lq())) || (!m.equal(((MostRecentGameInfo)paramObject).lr(), paramMostRecentGameInfo.lr()))) {
        break;
      }
      bool1 = bool2;
    } while (m.equal(((MostRecentGameInfo)paramObject).ls(), paramMostRecentGameInfo.ls()));
    return false;
  }
  
  static String b(MostRecentGameInfo paramMostRecentGameInfo)
  {
    return m.h(paramMostRecentGameInfo).a("GameId", paramMostRecentGameInfo.ln()).a("GameName", paramMostRecentGameInfo.lo()).a("ActivityTimestampMillis", Long.valueOf(paramMostRecentGameInfo.lp())).a("GameIconUri", paramMostRecentGameInfo.lq()).a("GameHiResUri", paramMostRecentGameInfo.lr()).a("GameFeaturedUri", paramMostRecentGameInfo.ls()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public int getVersionCode()
  {
    return this.BR;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String ln()
  {
    return this.aaB;
  }
  
  public String lo()
  {
    return this.aaC;
  }
  
  public long lp()
  {
    return this.aaD;
  }
  
  public Uri lq()
  {
    return this.aaE;
  }
  
  public Uri lr()
  {
    return this.aaF;
  }
  
  public Uri ls()
  {
    return this.aaG;
  }
  
  public MostRecentGameInfo lt()
  {
    return this;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    MostRecentGameInfoEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/internal/player/MostRecentGameInfoEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */