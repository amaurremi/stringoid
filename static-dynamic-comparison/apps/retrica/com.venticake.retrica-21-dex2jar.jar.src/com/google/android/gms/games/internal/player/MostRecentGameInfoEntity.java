package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hk.a;

public final class MostRecentGameInfoEntity
  implements SafeParcelable, MostRecentGameInfo
{
  public static final MostRecentGameInfoEntityCreator CREATOR = new MostRecentGameInfoEntityCreator();
  private final String RI;
  private final String RJ;
  private final long RK;
  private final Uri RL;
  private final Uri RM;
  private final Uri RN;
  private final int xM;
  
  MostRecentGameInfoEntity(int paramInt, String paramString1, String paramString2, long paramLong, Uri paramUri1, Uri paramUri2, Uri paramUri3)
  {
    this.xM = paramInt;
    this.RI = paramString1;
    this.RJ = paramString2;
    this.RK = paramLong;
    this.RL = paramUri1;
    this.RM = paramUri2;
    this.RN = paramUri3;
  }
  
  public MostRecentGameInfoEntity(MostRecentGameInfo paramMostRecentGameInfo)
  {
    this.xM = 2;
    this.RI = paramMostRecentGameInfo.ip();
    this.RJ = paramMostRecentGameInfo.iq();
    this.RK = paramMostRecentGameInfo.ir();
    this.RL = paramMostRecentGameInfo.is();
    this.RM = paramMostRecentGameInfo.it();
    this.RN = paramMostRecentGameInfo.iu();
  }
  
  static int a(MostRecentGameInfo paramMostRecentGameInfo)
  {
    return hk.hashCode(new Object[] { paramMostRecentGameInfo.ip(), paramMostRecentGameInfo.iq(), Long.valueOf(paramMostRecentGameInfo.ir()), paramMostRecentGameInfo.is(), paramMostRecentGameInfo.it(), paramMostRecentGameInfo.iu() });
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
      if ((!hk.equal(((MostRecentGameInfo)paramObject).ip(), paramMostRecentGameInfo.ip())) || (!hk.equal(((MostRecentGameInfo)paramObject).iq(), paramMostRecentGameInfo.iq())) || (!hk.equal(Long.valueOf(((MostRecentGameInfo)paramObject).ir()), Long.valueOf(paramMostRecentGameInfo.ir()))) || (!hk.equal(((MostRecentGameInfo)paramObject).is(), paramMostRecentGameInfo.is())) || (!hk.equal(((MostRecentGameInfo)paramObject).it(), paramMostRecentGameInfo.it()))) {
        break;
      }
      bool1 = bool2;
    } while (hk.equal(((MostRecentGameInfo)paramObject).iu(), paramMostRecentGameInfo.iu()));
    return false;
  }
  
  static String b(MostRecentGameInfo paramMostRecentGameInfo)
  {
    return hk.e(paramMostRecentGameInfo).a("GameId", paramMostRecentGameInfo.ip()).a("GameName", paramMostRecentGameInfo.iq()).a("ActivityTimestampMillis", Long.valueOf(paramMostRecentGameInfo.ir())).a("GameIconUri", paramMostRecentGameInfo.is()).a("GameHiResUri", paramMostRecentGameInfo.it()).a("GameFeaturedUri", paramMostRecentGameInfo.iu()).toString();
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
    return this.xM;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public String ip()
  {
    return this.RI;
  }
  
  public String iq()
  {
    return this.RJ;
  }
  
  public long ir()
  {
    return this.RK;
  }
  
  public Uri is()
  {
    return this.RL;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public Uri it()
  {
    return this.RM;
  }
  
  public Uri iu()
  {
    return this.RN;
  }
  
  public MostRecentGameInfo iv()
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/player/MostRecentGameInfoEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */