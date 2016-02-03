package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.ee.a;
import com.google.android.gms.internal.fc;
import com.google.android.gms.internal.fm;

public final class PlayerEntity
  extends fm
  implements Player
{
  public static final Parcelable.Creator<PlayerEntity> CREATOR = new a();
  private final int kg;
  private final String qa;
  private final Uri sL;
  private final Uri sM;
  private final String tC;
  private final long tD;
  private final int tE;
  private final long tF;
  
  PlayerEntity(int paramInt1, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2, long paramLong1, int paramInt2, long paramLong2)
  {
    this.kg = paramInt1;
    this.tC = paramString1;
    this.qa = paramString2;
    this.sL = paramUri1;
    this.sM = paramUri2;
    this.tD = paramLong1;
    this.tE = paramInt2;
    this.tF = paramLong2;
  }
  
  public PlayerEntity(Player paramPlayer)
  {
    this.kg = 3;
    this.tC = paramPlayer.getPlayerId();
    this.qa = paramPlayer.getDisplayName();
    this.sL = paramPlayer.getIconImageUri();
    this.sM = paramPlayer.getHiResImageUri();
    this.tD = paramPlayer.getRetrievedTimestamp();
    this.tE = paramPlayer.db();
    this.tF = paramPlayer.getLastPlayedWithTimestamp();
    ds.d(this.tC);
    ds.d(this.qa);
    if (this.tD > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      ds.p(bool);
      return;
    }
  }
  
  static int a(Player paramPlayer)
  {
    return ee.hashCode(new Object[] { paramPlayer.getPlayerId(), paramPlayer.getDisplayName(), paramPlayer.getIconImageUri(), paramPlayer.getHiResImageUri(), Long.valueOf(paramPlayer.getRetrievedTimestamp()) });
  }
  
  static boolean a(Player paramPlayer, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof Player)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramPlayer == paramObject);
      paramObject = (Player)paramObject;
      if ((!ee.equal(((Player)paramObject).getPlayerId(), paramPlayer.getPlayerId())) || (!ee.equal(((Player)paramObject).getDisplayName(), paramPlayer.getDisplayName())) || (!ee.equal(((Player)paramObject).getIconImageUri(), paramPlayer.getIconImageUri())) || (!ee.equal(((Player)paramObject).getHiResImageUri(), paramPlayer.getHiResImageUri()))) {
        break;
      }
      bool1 = bool2;
    } while (ee.equal(Long.valueOf(((Player)paramObject).getRetrievedTimestamp()), Long.valueOf(paramPlayer.getRetrievedTimestamp())));
    return false;
  }
  
  static String b(Player paramPlayer)
  {
    return ee.e(paramPlayer).a("PlayerId", paramPlayer.getPlayerId()).a("DisplayName", paramPlayer.getDisplayName()).a("IconImageUri", paramPlayer.getIconImageUri()).a("HiResImageUri", paramPlayer.getHiResImageUri()).a("RetrievedTimestamp", Long.valueOf(paramPlayer.getRetrievedTimestamp())).toString();
  }
  
  public int db()
  {
    return this.tE;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public Player freeze()
  {
    return this;
  }
  
  public String getDisplayName()
  {
    return this.qa;
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    fc.b(this.qa, paramCharArrayBuffer);
  }
  
  public Uri getHiResImageUri()
  {
    return this.sM;
  }
  
  public Uri getIconImageUri()
  {
    return this.sL;
  }
  
  public long getLastPlayedWithTimestamp()
  {
    return this.tF;
  }
  
  public String getPlayerId()
  {
    return this.tC;
  }
  
  public long getRetrievedTimestamp()
  {
    return this.tD;
  }
  
  public int getVersionCode()
  {
    return this.kg;
  }
  
  public boolean hasHiResImage()
  {
    return getHiResImageUri() != null;
  }
  
  public boolean hasIconImage()
  {
    return getIconImageUri() != null;
  }
  
  public int hashCode()
  {
    return a(this);
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
    Object localObject2 = null;
    if (!bN())
    {
      c.a(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.tC);
    paramParcel.writeString(this.qa);
    if (this.sL == null)
    {
      localObject1 = null;
      paramParcel.writeString((String)localObject1);
      if (this.sM != null) {
        break label82;
      }
    }
    label82:
    for (Object localObject1 = localObject2;; localObject1 = this.sM.toString())
    {
      paramParcel.writeString((String)localObject1);
      paramParcel.writeLong(this.tD);
      return;
      localObject1 = this.sL.toString();
      break;
    }
  }
  
  static final class a
    extends c
  {
    public PlayerEntity Z(Parcel paramParcel)
    {
      Uri localUri = null;
      if ((PlayerEntity.b(PlayerEntity.da())) || (PlayerEntity.ad(PlayerEntity.class.getCanonicalName()))) {
        return super.Z(paramParcel);
      }
      String str1 = paramParcel.readString();
      String str2 = paramParcel.readString();
      Object localObject = paramParcel.readString();
      String str3 = paramParcel.readString();
      if (localObject == null)
      {
        localObject = null;
        if (str3 != null) {
          break label93;
        }
      }
      for (;;)
      {
        return new PlayerEntity(3, str1, str2, (Uri)localObject, localUri, paramParcel.readLong(), -1, -1L);
        localObject = Uri.parse((String)localObject);
        break;
        label93:
        localUri = Uri.parse(str3);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/games/PlayerEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */