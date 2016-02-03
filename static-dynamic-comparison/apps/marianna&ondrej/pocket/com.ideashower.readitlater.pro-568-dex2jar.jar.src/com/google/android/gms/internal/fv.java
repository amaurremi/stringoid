package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.b.a.b.a;
import com.google.android.gms.b.a.b.f;
import com.google.android.gms.b.a.b.g;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class fv
  extends dw
  implements a, SafeParcelable
{
  public static final ca CREATOR = new ca();
  private static final HashMap a = new HashMap();
  private boolean A;
  private final Set b;
  private final int c;
  private String d;
  private fv.a e;
  private String f;
  private String g;
  private int h;
  private fv.b i;
  private String j;
  private String k;
  private int l;
  private String m;
  private fv.c n;
  private boolean o;
  private String p;
  private fv.d q;
  private String r;
  private int s;
  private List t;
  private List u;
  private int v;
  private int w;
  private String x;
  private String y;
  private List z;
  
  static
  {
    a.put("aboutMe", dw.a.d("aboutMe", 2));
    a.put("ageRange", dw.a.a("ageRange", 3, fv.a.class));
    a.put("birthday", dw.a.d("birthday", 4));
    a.put("braggingRights", dw.a.d("braggingRights", 5));
    a.put("circledByCount", dw.a.a("circledByCount", 6));
    a.put("cover", dw.a.a("cover", 7, fv.b.class));
    a.put("currentLocation", dw.a.d("currentLocation", 8));
    a.put("displayName", dw.a.d("displayName", 9));
    a.put("gender", dw.a.a("gender", 12, new dt().a("male", 0).a("female", 1).a("other", 2), false));
    a.put("id", dw.a.d("id", 14));
    a.put("image", dw.a.a("image", 15, fv.c.class));
    a.put("isPlusUser", dw.a.c("isPlusUser", 16));
    a.put("language", dw.a.d("language", 18));
    a.put("name", dw.a.a("name", 19, fv.d.class));
    a.put("nickname", dw.a.d("nickname", 20));
    a.put("objectType", dw.a.a("objectType", 21, new dt().a("person", 0).a("page", 1), false));
    a.put("organizations", dw.a.b("organizations", 22, fv.f.class));
    a.put("placesLived", dw.a.b("placesLived", 23, fv.g.class));
    a.put("plusOneCount", dw.a.a("plusOneCount", 24));
    a.put("relationshipStatus", dw.a.a("relationshipStatus", 25, new dt().a("single", 0).a("in_a_relationship", 1).a("engaged", 2).a("married", 3).a("its_complicated", 4).a("open_relationship", 5).a("widowed", 6).a("in_domestic_partnership", 7).a("in_civil_union", 8), false));
    a.put("tagline", dw.a.d("tagline", 26));
    a.put("url", dw.a.d("url", 27));
    a.put("urls", dw.a.b("urls", 28, fv.h.class));
    a.put("verified", dw.a.c("verified", 29));
  }
  
  public fv()
  {
    this.c = 2;
    this.b = new HashSet();
  }
  
  public fv(String paramString1, String paramString2, fv.c paramc, int paramInt, String paramString3)
  {
    this.c = 2;
    this.b = new HashSet();
    this.k = paramString1;
    this.b.add(Integer.valueOf(9));
    this.m = paramString2;
    this.b.add(Integer.valueOf(14));
    this.n = paramc;
    this.b.add(Integer.valueOf(15));
    this.s = paramInt;
    this.b.add(Integer.valueOf(21));
    this.y = paramString3;
    this.b.add(Integer.valueOf(27));
  }
  
  fv(Set paramSet, int paramInt1, String paramString1, fv.a parama, String paramString2, String paramString3, int paramInt2, fv.b paramb, String paramString4, String paramString5, int paramInt3, String paramString6, fv.c paramc, boolean paramBoolean1, String paramString7, fv.d paramd, String paramString8, int paramInt4, List paramList1, List paramList2, int paramInt5, int paramInt6, String paramString9, String paramString10, List paramList3, boolean paramBoolean2)
  {
    this.b = paramSet;
    this.c = paramInt1;
    this.d = paramString1;
    this.e = parama;
    this.f = paramString2;
    this.g = paramString3;
    this.h = paramInt2;
    this.i = paramb;
    this.j = paramString4;
    this.k = paramString5;
    this.l = paramInt3;
    this.m = paramString6;
    this.n = paramc;
    this.o = paramBoolean1;
    this.p = paramString7;
    this.q = paramd;
    this.r = paramString8;
    this.s = paramInt4;
    this.t = paramList1;
    this.u = paramList2;
    this.v = paramInt5;
    this.w = paramInt6;
    this.x = paramString9;
    this.y = paramString10;
    this.z = paramList3;
    this.A = paramBoolean2;
  }
  
  public static fv a(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    paramArrayOfByte = CREATOR.a(localParcel);
    localParcel.recycle();
    return paramArrayOfByte;
  }
  
  public int A()
  {
    return this.v;
  }
  
  public int B()
  {
    return this.w;
  }
  
  public String C()
  {
    return this.x;
  }
  
  public String D()
  {
    return this.y;
  }
  
  List E()
  {
    return this.z;
  }
  
  public boolean F()
  {
    return this.A;
  }
  
  public fv G()
  {
    return this;
  }
  
  protected Object a(String paramString)
  {
    return null;
  }
  
  protected boolean a(dw.a parama)
  {
    return this.b.contains(Integer.valueOf(parama.g()));
  }
  
  protected Object b(dw.a parama)
  {
    switch (parama.g())
    {
    case 10: 
    case 11: 
    case 13: 
    case 17: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.g());
    case 2: 
      return this.d;
    case 3: 
      return this.e;
    case 4: 
      return this.f;
    case 5: 
      return this.g;
    case 6: 
      return Integer.valueOf(this.h);
    case 7: 
      return this.i;
    case 8: 
      return this.j;
    case 9: 
      return this.k;
    case 12: 
      return Integer.valueOf(this.l);
    case 14: 
      return this.m;
    case 15: 
      return this.n;
    case 16: 
      return Boolean.valueOf(this.o);
    case 18: 
      return this.p;
    case 19: 
      return this.q;
    case 20: 
      return this.r;
    case 21: 
      return Integer.valueOf(this.s);
    case 22: 
      return this.t;
    case 23: 
      return this.u;
    case 24: 
      return Integer.valueOf(this.v);
    case 25: 
      return Integer.valueOf(this.w);
    case 26: 
      return this.x;
    case 27: 
      return this.y;
    case 28: 
      return this.z;
    }
    return Boolean.valueOf(this.A);
  }
  
  public HashMap b()
  {
    return a;
  }
  
  protected boolean b(String paramString)
  {
    return false;
  }
  
  public int describeContents()
  {
    ca localca = CREATOR;
    return 0;
  }
  
  Set e()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof fv)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (fv)paramObject;
    Iterator localIterator = a.values().iterator();
    while (localIterator.hasNext())
    {
      dw.a locala = (dw.a)localIterator.next();
      if (a(locala))
      {
        if (((fv)paramObject).a(locala))
        {
          if (!b(locala).equals(((fv)paramObject).b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((fv)paramObject).a(locala)) {
        return false;
      }
    }
    return true;
  }
  
  int f()
  {
    return this.c;
  }
  
  public String g()
  {
    return this.d;
  }
  
  fv.a h()
  {
    return this.e;
  }
  
  public int hashCode()
  {
    Iterator localIterator = a.values().iterator();
    int i1 = 0;
    if (localIterator.hasNext())
    {
      dw.a locala = (dw.a)localIterator.next();
      if (!a(locala)) {
        break label68;
      }
      int i2 = locala.g();
      i1 = b(locala).hashCode() + (i1 + i2);
    }
    label68:
    for (;;)
    {
      break;
      return i1;
    }
  }
  
  public String i()
  {
    return this.f;
  }
  
  public String j()
  {
    return this.g;
  }
  
  public int k()
  {
    return this.h;
  }
  
  fv.b l()
  {
    return this.i;
  }
  
  public String m()
  {
    return this.j;
  }
  
  public String n()
  {
    return this.k;
  }
  
  public int o()
  {
    return this.l;
  }
  
  public String p()
  {
    return this.m;
  }
  
  public f q()
  {
    return this.n;
  }
  
  fv.c r()
  {
    return this.n;
  }
  
  public boolean s()
  {
    return this.o;
  }
  
  public String t()
  {
    return this.p;
  }
  
  public g u()
  {
    return this.q;
  }
  
  fv.d v()
  {
    return this.q;
  }
  
  public String w()
  {
    return this.r;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ca localca = CREATOR;
    ca.a(this, paramParcel, paramInt);
  }
  
  public int x()
  {
    return this.s;
  }
  
  List y()
  {
    return this.t;
  }
  
  List z()
  {
    return this.u;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/fv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */