package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class fn
  implements SafeParcelable
{
  public static final bv CREATOR = new bv();
  private final int a;
  private final String b;
  private final String[] c;
  private final String[] d;
  private final String[] e;
  private final String f;
  private final String g;
  private final String h;
  private final String i;
  
  fn(int paramInt, String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramArrayOfString1;
    this.d = paramArrayOfString2;
    this.e = paramArrayOfString3;
    this.f = paramString2;
    this.g = paramString3;
    this.h = paramString4;
    this.i = paramString5;
  }
  
  fn(String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.a = 1;
    this.b = paramString1;
    this.c = paramArrayOfString1;
    this.d = paramArrayOfString2;
    this.e = paramArrayOfString3;
    this.f = paramString2;
    this.g = paramString3;
    this.h = paramString4;
    this.i = paramString5;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String[] c()
  {
    return this.c;
  }
  
  public String[] d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String[] e()
  {
    return this.e;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof fn)) {}
    do
    {
      return false;
      paramObject = (fn)paramObject;
    } while ((this.a != ((fn)paramObject).a) || (!al.a(this.b, ((fn)paramObject).b)) || (!al.a(this.c, ((fn)paramObject).c)) || (!al.a(this.d, ((fn)paramObject).d)) || (!al.a(this.e, ((fn)paramObject).e)) || (!al.a(this.f, ((fn)paramObject).f)) || (!al.a(this.g, ((fn)paramObject).g)) || (!al.a(this.h, ((fn)paramObject).h)) || (!al.a(this.i, ((fn)paramObject).i)));
    return true;
  }
  
  public String f()
  {
    return this.f;
  }
  
  public String g()
  {
    return this.g;
  }
  
  public String h()
  {
    return this.h;
  }
  
  public int hashCode()
  {
    return al.a(new Object[] { Integer.valueOf(this.a), this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i });
  }
  
  public String i()
  {
    return this.i;
  }
  
  public String toString()
  {
    return al.a(this).a("versionCode", Integer.valueOf(this.a)).a("accountName", this.b).a("requestedScopes", this.c).a("visibleActivities", this.d).a("requiredFeatures", this.e).a("packageNameForAuth", this.f).a("callingPackageName", this.g).a("applicationName", this.h).a("clientId", this.i).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    bv.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/fn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */