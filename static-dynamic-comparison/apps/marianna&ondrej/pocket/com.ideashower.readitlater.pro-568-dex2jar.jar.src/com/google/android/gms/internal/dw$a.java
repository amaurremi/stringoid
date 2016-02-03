package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.HashMap;

public class dw$a
  implements SafeParcelable
{
  public static final at CREATOR = new at();
  protected final int a;
  protected final boolean b;
  protected final int c;
  protected final boolean d;
  protected final String e;
  protected final int f;
  protected final Class g;
  protected final String h;
  private final int i;
  private dz j;
  private as k;
  
  dw$a(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, int paramInt4, String paramString2, dr paramdr)
  {
    this.i = paramInt1;
    this.a = paramInt2;
    this.b = paramBoolean1;
    this.c = paramInt3;
    this.d = paramBoolean2;
    this.e = paramString1;
    this.f = paramInt4;
    if (paramString2 == null) {
      this.g = null;
    }
    for (this.h = null; paramdr == null; this.h = paramString2)
    {
      this.k = null;
      return;
      this.g = ec.class;
    }
    this.k = paramdr.c();
  }
  
  protected dw$a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString, int paramInt3, Class paramClass, as paramas)
  {
    this.i = 1;
    this.a = paramInt1;
    this.b = paramBoolean1;
    this.c = paramInt2;
    this.d = paramBoolean2;
    this.e = paramString;
    this.f = paramInt3;
    this.g = paramClass;
    if (paramClass == null) {}
    for (this.h = null;; this.h = paramClass.getCanonicalName())
    {
      this.k = paramas;
      return;
    }
  }
  
  public static a a(String paramString, int paramInt)
  {
    return new a(0, false, 0, false, paramString, paramInt, null, null);
  }
  
  public static a a(String paramString, int paramInt, as paramas, boolean paramBoolean)
  {
    return new a(paramas.c(), paramBoolean, paramas.d(), false, paramString, paramInt, null, paramas);
  }
  
  public static a a(String paramString, int paramInt, Class paramClass)
  {
    return new a(11, false, 11, false, paramString, paramInt, paramClass, null);
  }
  
  public static a b(String paramString, int paramInt)
  {
    return new a(4, false, 4, false, paramString, paramInt, null, null);
  }
  
  public static a b(String paramString, int paramInt, Class paramClass)
  {
    return new a(11, true, 11, true, paramString, paramInt, paramClass, null);
  }
  
  public static a c(String paramString, int paramInt)
  {
    return new a(6, false, 6, false, paramString, paramInt, null, null);
  }
  
  public static a d(String paramString, int paramInt)
  {
    return new a(7, false, 7, false, paramString, paramInt, null, null);
  }
  
  public static a e(String paramString, int paramInt)
  {
    return new a(7, true, 7, true, paramString, paramInt, null, null);
  }
  
  public int a()
  {
    return this.i;
  }
  
  public Object a(Object paramObject)
  {
    return this.k.a(paramObject);
  }
  
  public void a(dz paramdz)
  {
    this.j = paramdz;
  }
  
  public int b()
  {
    return this.a;
  }
  
  public boolean c()
  {
    return this.b;
  }
  
  public int d()
  {
    return this.c;
  }
  
  public int describeContents()
  {
    at localat = CREATOR;
    return 0;
  }
  
  public boolean e()
  {
    return this.d;
  }
  
  public String f()
  {
    return this.e;
  }
  
  public int g()
  {
    return this.f;
  }
  
  public Class h()
  {
    return this.g;
  }
  
  String i()
  {
    if (this.h == null) {
      return null;
    }
    return this.h;
  }
  
  public boolean j()
  {
    return this.k != null;
  }
  
  dr k()
  {
    if (this.k == null) {
      return null;
    }
    return dr.a(this.k);
  }
  
  public HashMap l()
  {
    an.a(this.h);
    an.a(this.j);
    return this.j.a(this.h);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("Field\n");
    localStringBuilder1.append("            versionCode=").append(this.i).append('\n');
    localStringBuilder1.append("                 typeIn=").append(this.a).append('\n');
    localStringBuilder1.append("            typeInArray=").append(this.b).append('\n');
    localStringBuilder1.append("                typeOut=").append(this.c).append('\n');
    localStringBuilder1.append("           typeOutArray=").append(this.d).append('\n');
    localStringBuilder1.append("        outputFieldName=").append(this.e).append('\n');
    localStringBuilder1.append("      safeParcelFieldId=").append(this.f).append('\n');
    localStringBuilder1.append("       concreteTypeName=").append(i()).append('\n');
    if (h() != null) {
      localStringBuilder1.append("     concreteType.class=").append(h().getCanonicalName()).append('\n');
    }
    StringBuilder localStringBuilder2 = localStringBuilder1.append("          converterName=");
    if (this.k == null) {}
    for (String str = "null";; str = this.k.getClass().getCanonicalName())
    {
      localStringBuilder2.append(str).append('\n');
      return localStringBuilder1.toString();
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    at localat = CREATOR;
    at.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/dw$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */