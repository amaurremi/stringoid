package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.al;
import com.google.android.gms.internal.am;
import com.google.android.gms.internal.en;
import com.google.android.gms.internal.q;

public final class PlayerEntity
  extends en
  implements Player
{
  public static final Parcelable.Creator CREATOR = new c();
  private final int a;
  private final String b;
  private final String c;
  private final Uri d;
  private final Uri e;
  private final long f;
  
  PlayerEntity(int paramInt, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2, long paramLong)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramUri1;
    this.e = paramUri2;
    this.f = paramLong;
  }
  
  public PlayerEntity(Player paramPlayer)
  {
    this.a = 1;
    this.b = paramPlayer.b();
    this.c = paramPlayer.c();
    this.d = paramPlayer.d();
    this.e = paramPlayer.e();
    this.f = paramPlayer.f();
    q.a(this.b);
    q.a(this.c);
    if (this.f > 0L) {}
    for (;;)
    {
      q.a(bool);
      return;
      bool = false;
    }
  }
  
  static int a(Player paramPlayer)
  {
    return al.a(new Object[] { paramPlayer.b(), paramPlayer.c(), paramPlayer.d(), paramPlayer.e(), Long.valueOf(paramPlayer.f()) });
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
      if ((!al.a(((Player)paramObject).b(), paramPlayer.b())) || (!al.a(((Player)paramObject).c(), paramPlayer.c())) || (!al.a(((Player)paramObject).d(), paramPlayer.d())) || (!al.a(((Player)paramObject).e(), paramPlayer.e()))) {
        break;
      }
      bool1 = bool2;
    } while (al.a(Long.valueOf(((Player)paramObject).f()), Long.valueOf(paramPlayer.f())));
    return false;
  }
  
  static String b(Player paramPlayer)
  {
    return al.a(paramPlayer).a("PlayerId", paramPlayer.b()).a("DisplayName", paramPlayer.c()).a("IconImageUri", paramPlayer.d()).a("HiResImageUri", paramPlayer.e()).a("RetrievedTimestamp", Long.valueOf(paramPlayer.f())).toString();
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public Uri d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Uri e()
  {
    return this.e;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public long f()
  {
    return this.f;
  }
  
  public int g()
  {
    return this.a;
  }
  
  public Player h()
  {
    return this;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Object localObject2 = null;
    if (!v())
    {
      f.a(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    if (this.d == null)
    {
      localObject1 = null;
      paramParcel.writeString((String)localObject1);
      if (this.e != null) {
        break label82;
      }
    }
    label82:
    for (Object localObject1 = localObject2;; localObject1 = this.e.toString())
    {
      paramParcel.writeString((String)localObject1);
      paramParcel.writeLong(this.f);
      return;
      localObject1 = this.d.toString();
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/games/PlayerEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */