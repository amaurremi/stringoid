package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;

public final class MostRecentGameInfoEntity
  implements SafeParcelable, MostRecentGameInfo
{
  public static final MostRecentGameInfoEntityCreator CREATOR = new MostRecentGameInfoEntityCreator();
  private final String RF;
  private final String RG;
  private final long RH;
  private final Uri RI;
  private final Uri RJ;
  private final Uri RK;
  private final int xJ;
  
  MostRecentGameInfoEntity(int paramInt, String paramString1, String paramString2, long paramLong, Uri paramUri1, Uri paramUri2, Uri paramUri3)
  {
    this.xJ = paramInt;
    this.RF = paramString1;
    this.RG = paramString2;
    this.RH = paramLong;
    this.RI = paramUri1;
    this.RJ = paramUri2;
    this.RK = paramUri3;
  }
  
  public MostRecentGameInfoEntity(MostRecentGameInfo paramMostRecentGameInfo)
  {
    this.xJ = 2;
    this.RF = paramMostRecentGameInfo.ik();
    this.RG = paramMostRecentGameInfo.il();
    this.RH = paramMostRecentGameInfo.im();
    this.RI = paramMostRecentGameInfo.in();
    this.RJ = paramMostRecentGameInfo.io();
    this.RK = paramMostRecentGameInfo.ip();
  }
  
  static int a(MostRecentGameInfo paramMostRecentGameInfo)
  {
    return hl.hashCode(new Object[] { paramMostRecentGameInfo.ik(), paramMostRecentGameInfo.il(), Long.valueOf(paramMostRecentGameInfo.im()), paramMostRecentGameInfo.in(), paramMostRecentGameInfo.io(), paramMostRecentGameInfo.ip() });
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
      if ((!hl.equal(((MostRecentGameInfo)paramObject).ik(), paramMostRecentGameInfo.ik())) || (!hl.equal(((MostRecentGameInfo)paramObject).il(), paramMostRecentGameInfo.il())) || (!hl.equal(Long.valueOf(((MostRecentGameInfo)paramObject).im()), Long.valueOf(paramMostRecentGameInfo.im()))) || (!hl.equal(((MostRecentGameInfo)paramObject).in(), paramMostRecentGameInfo.in())) || (!hl.equal(((MostRecentGameInfo)paramObject).io(), paramMostRecentGameInfo.io()))) {
        break;
      }
      bool1 = bool2;
    } while (hl.equal(((MostRecentGameInfo)paramObject).ip(), paramMostRecentGameInfo.ip()));
    return false;
  }
  
  static String b(MostRecentGameInfo paramMostRecentGameInfo)
  {
    return hl.e(paramMostRecentGameInfo).a("GameId", paramMostRecentGameInfo.ik()).a("GameName", paramMostRecentGameInfo.il()).a("ActivityTimestampMillis", Long.valueOf(paramMostRecentGameInfo.im())).a("GameIconUri", paramMostRecentGameInfo.in()).a("GameHiResUri", paramMostRecentGameInfo.io()).a("GameFeaturedUri", paramMostRecentGameInfo.ip()).toString();
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
    return this.xJ;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public String ik()
  {
    return this.RF;
  }
  
  public String il()
  {
    return this.RG;
  }
  
  public long im()
  {
    return this.RH;
  }
  
  public Uri in()
  {
    return this.RI;
  }
  
  public Uri io()
  {
    return this.RJ;
  }
  
  public Uri ip()
  {
    return this.RK;
  }
  
  public MostRecentGameInfo iq()
  {
    return this;
  }
  
  public boolean isDataValid()
  {
    return true;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/internal/player/MostRecentGameInfoEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */