package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.al;
import com.google.android.gms.internal.am;
import com.google.android.gms.internal.en;

public final class GameEntity
  extends en
  implements Game
{
  public static final Parcelable.Creator CREATOR = new a();
  private final int a;
  private final String b;
  private final String c;
  private final String d;
  private final String e;
  private final String f;
  private final String g;
  private final Uri h;
  private final Uri i;
  private final Uri j;
  private final boolean k;
  private final boolean l;
  private final String m;
  private final int n;
  private final int o;
  private final int p;
  
  GameEntity(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Uri paramUri1, Uri paramUri2, Uri paramUri3, boolean paramBoolean1, boolean paramBoolean2, String paramString7, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramString5;
    this.g = paramString6;
    this.h = paramUri1;
    this.i = paramUri2;
    this.j = paramUri3;
    this.k = paramBoolean1;
    this.l = paramBoolean2;
    this.m = paramString7;
    this.n = paramInt2;
    this.o = paramInt3;
    this.p = paramInt4;
  }
  
  public GameEntity(Game paramGame)
  {
    this.a = 1;
    this.b = paramGame.b();
    this.d = paramGame.d();
    this.e = paramGame.e();
    this.f = paramGame.f();
    this.g = paramGame.g();
    this.c = paramGame.c();
    this.h = paramGame.h();
    this.i = paramGame.i();
    this.j = paramGame.j();
    this.k = paramGame.k();
    this.l = paramGame.l();
    this.m = paramGame.m();
    this.n = paramGame.n();
    this.o = paramGame.o();
    this.p = paramGame.p();
  }
  
  static int a(Game paramGame)
  {
    return al.a(new Object[] { paramGame.b(), paramGame.c(), paramGame.d(), paramGame.e(), paramGame.f(), paramGame.g(), paramGame.h(), paramGame.i(), paramGame.j(), Boolean.valueOf(paramGame.k()), Boolean.valueOf(paramGame.l()), paramGame.m(), Integer.valueOf(paramGame.n()), Integer.valueOf(paramGame.o()), Integer.valueOf(paramGame.p()) });
  }
  
  static boolean a(Game paramGame, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof Game)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramGame == paramObject);
      paramObject = (Game)paramObject;
      if ((!al.a(((Game)paramObject).b(), paramGame.b())) || (!al.a(((Game)paramObject).c(), paramGame.c())) || (!al.a(((Game)paramObject).d(), paramGame.d())) || (!al.a(((Game)paramObject).e(), paramGame.e())) || (!al.a(((Game)paramObject).f(), paramGame.f())) || (!al.a(((Game)paramObject).g(), paramGame.g())) || (!al.a(((Game)paramObject).h(), paramGame.h())) || (!al.a(((Game)paramObject).i(), paramGame.i())) || (!al.a(((Game)paramObject).j(), paramGame.j())) || (!al.a(Boolean.valueOf(((Game)paramObject).k()), Boolean.valueOf(paramGame.k()))) || (!al.a(Boolean.valueOf(((Game)paramObject).l()), Boolean.valueOf(paramGame.l()))) || (!al.a(((Game)paramObject).m(), paramGame.m())) || (!al.a(Integer.valueOf(((Game)paramObject).n()), Integer.valueOf(paramGame.n()))) || (!al.a(Integer.valueOf(((Game)paramObject).o()), Integer.valueOf(paramGame.o())))) {
        break;
      }
      bool1 = bool2;
    } while (al.a(Integer.valueOf(((Game)paramObject).p()), Integer.valueOf(paramGame.p())));
    return false;
  }
  
  static String b(Game paramGame)
  {
    return al.a(paramGame).a("ApplicationId", paramGame.b()).a("DisplayName", paramGame.c()).a("PrimaryCategory", paramGame.d()).a("SecondaryCategory", paramGame.e()).a("Description", paramGame.f()).a("DeveloperName", paramGame.g()).a("IconImageUri", paramGame.h()).a("HiResImageUri", paramGame.i()).a("FeaturedImageUri", paramGame.j()).a("PlayEnabledGame", Boolean.valueOf(paramGame.k())).a("InstanceInstalled", Boolean.valueOf(paramGame.l())).a("InstancePackageName", paramGame.m()).a("GameplayAclStatus", Integer.valueOf(paramGame.n())).a("AchievementTotalCount", Integer.valueOf(paramGame.o())).a("LeaderboardCount", Integer.valueOf(paramGame.p())).toString();
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public String f()
  {
    return this.f;
  }
  
  public String g()
  {
    return this.g;
  }
  
  public Uri h()
  {
    return this.h;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public Uri i()
  {
    return this.i;
  }
  
  public Uri j()
  {
    return this.j;
  }
  
  public boolean k()
  {
    return this.k;
  }
  
  public boolean l()
  {
    return this.l;
  }
  
  public String m()
  {
    return this.m;
  }
  
  public int n()
  {
    return this.n;
  }
  
  public int o()
  {
    return this.o;
  }
  
  public int p()
  {
    return this.p;
  }
  
  public int q()
  {
    return this.a;
  }
  
  public Game r()
  {
    return this;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = 1;
    Object localObject2 = null;
    if (!v())
    {
      e.a(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    Object localObject1;
    if (this.h == null)
    {
      localObject1 = null;
      paramParcel.writeString((String)localObject1);
      if (this.i != null) {
        break label189;
      }
      localObject1 = null;
      label93:
      paramParcel.writeString((String)localObject1);
      if (this.j != null) {
        break label201;
      }
      localObject1 = localObject2;
      label110:
      paramParcel.writeString((String)localObject1);
      if (!this.k) {
        break label213;
      }
      paramInt = 1;
      label125:
      paramParcel.writeInt(paramInt);
      if (!this.l) {
        break label218;
      }
    }
    label189:
    label201:
    label213:
    label218:
    for (paramInt = i1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.m);
      paramParcel.writeInt(this.n);
      paramParcel.writeInt(this.o);
      paramParcel.writeInt(this.p);
      return;
      localObject1 = this.h.toString();
      break;
      localObject1 = this.i.toString();
      break label93;
      localObject1 = this.j.toString();
      break label110;
      paramInt = 0;
      break label125;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/games/GameEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */