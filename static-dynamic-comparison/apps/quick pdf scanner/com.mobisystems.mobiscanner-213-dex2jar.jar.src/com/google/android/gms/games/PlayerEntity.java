package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.cq;
import com.google.android.gms.internal.cz;
import com.google.android.gms.internal.cz.a;
import com.google.android.gms.internal.fy;

public final class PlayerEntity
  extends fy
  implements Player
{
  public static final Parcelable.Creator<PlayerEntity> CREATOR = new a();
  private final int qh;
  private final long vA;
  private final String vc;
  private final Uri vh;
  private final Uri vi;
  private final String vt;
  private final String vu;
  private final String vx;
  private final long vy;
  private final int vz;
  
  PlayerEntity(int paramInt1, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2, long paramLong1, int paramInt2, long paramLong2, String paramString3, String paramString4)
  {
    this.qh = paramInt1;
    this.vx = paramString1;
    this.vc = paramString2;
    this.vh = paramUri1;
    this.vt = paramString3;
    this.vi = paramUri2;
    this.vu = paramString4;
    this.vy = paramLong1;
    this.vz = paramInt2;
    this.vA = paramLong2;
  }
  
  public PlayerEntity(Player paramPlayer)
  {
    this.qh = 4;
    this.vx = paramPlayer.nS();
    this.vc = paramPlayer.getDisplayName();
    this.vh = paramPlayer.nC();
    this.vt = paramPlayer.nD();
    this.vi = paramPlayer.nE();
    this.vu = paramPlayer.nF();
    this.vy = paramPlayer.nT();
    this.vz = paramPlayer.nV();
    this.vA = paramPlayer.nU();
    cq.K(this.vx);
    cq.K(this.vc);
    if (this.vy > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      cq.G(bool);
      return;
    }
  }
  
  static int a(Player paramPlayer)
  {
    return cz.hashCode(new Object[] { paramPlayer.nS(), paramPlayer.getDisplayName(), paramPlayer.nC(), paramPlayer.nE(), Long.valueOf(paramPlayer.nT()) });
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
      if ((!cz.b(((Player)paramObject).nS(), paramPlayer.nS())) || (!cz.b(((Player)paramObject).getDisplayName(), paramPlayer.getDisplayName())) || (!cz.b(((Player)paramObject).nC(), paramPlayer.nC())) || (!cz.b(((Player)paramObject).nE(), paramPlayer.nE()))) {
        break;
      }
      bool1 = bool2;
    } while (cz.b(Long.valueOf(((Player)paramObject).nT()), Long.valueOf(paramPlayer.nT())));
    return false;
  }
  
  static String b(Player paramPlayer)
  {
    return cz.M(paramPlayer).a("PlayerId", paramPlayer.nS()).a("DisplayName", paramPlayer.getDisplayName()).a("IconImageUri", paramPlayer.nC()).a("IconImageUrl", paramPlayer.nD()).a("HiResImageUri", paramPlayer.nE()).a("HiResImageUrl", paramPlayer.nF()).a("RetrievedTimestamp", Long.valueOf(paramPlayer.nT())).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public String getDisplayName()
  {
    return this.vc;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public int lX()
  {
    return this.qh;
  }
  
  public Uri nC()
  {
    return this.vh;
  }
  
  public String nD()
  {
    return this.vt;
  }
  
  public Uri nE()
  {
    return this.vi;
  }
  
  public String nF()
  {
    return this.vu;
  }
  
  public String nS()
  {
    return this.vx;
  }
  
  public long nT()
  {
    return this.vy;
  }
  
  public long nU()
  {
    return this.vA;
  }
  
  public int nV()
  {
    return this.vz;
  }
  
  public Player nW()
  {
    return this;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Object localObject2 = null;
    if (!qp())
    {
      c.a(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.vx);
    paramParcel.writeString(this.vc);
    if (this.vh == null)
    {
      localObject1 = null;
      paramParcel.writeString((String)localObject1);
      if (this.vi != null) {
        break label82;
      }
    }
    label82:
    for (Object localObject1 = localObject2;; localObject1 = this.vi.toString())
    {
      paramParcel.writeString((String)localObject1);
      paramParcel.writeLong(this.vy);
      return;
      localObject1 = this.vh.toString();
      break;
    }
  }
  
  static final class a
    extends c
  {
    public PlayerEntity X(Parcel paramParcel)
    {
      if ((PlayerEntity.a(PlayerEntity.nR())) || (PlayerEntity.aw(PlayerEntity.class.getCanonicalName()))) {
        return super.X(paramParcel);
      }
      String str1 = paramParcel.readString();
      String str2 = paramParcel.readString();
      Object localObject1 = paramParcel.readString();
      Object localObject2 = paramParcel.readString();
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject2 != null) {
          break label93;
        }
      }
      label93:
      for (localObject2 = null;; localObject2 = Uri.parse((String)localObject2))
      {
        return new PlayerEntity(4, str1, str2, (Uri)localObject1, (Uri)localObject2, paramParcel.readLong(), -1, -1L, null, null);
        localObject1 = Uri.parse((String)localObject1);
        break;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/games/PlayerEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */