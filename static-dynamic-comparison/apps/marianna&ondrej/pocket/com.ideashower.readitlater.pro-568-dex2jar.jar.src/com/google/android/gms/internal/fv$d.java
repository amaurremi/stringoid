package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.b.a.b.g;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class fv$d
  extends dw
  implements g, SafeParcelable
{
  public static final cg CREATOR = new cg();
  private static final HashMap a = new HashMap();
  private final Set b;
  private final int c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  
  static
  {
    a.put("familyName", dw.a.d("familyName", 2));
    a.put("formatted", dw.a.d("formatted", 3));
    a.put("givenName", dw.a.d("givenName", 4));
    a.put("honorificPrefix", dw.a.d("honorificPrefix", 5));
    a.put("honorificSuffix", dw.a.d("honorificSuffix", 6));
    a.put("middleName", dw.a.d("middleName", 7));
  }
  
  public fv$d()
  {
    this.c = 1;
    this.b = new HashSet();
  }
  
  fv$d(Set paramSet, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.b = paramSet;
    this.c = paramInt;
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramString3;
    this.g = paramString4;
    this.h = paramString5;
    this.i = paramString6;
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
      return this.h;
    }
    return this.i;
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
    cg localcg = CREATOR;
    return 0;
  }
  
  Set e()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof d)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (d)paramObject;
    Iterator localIterator = a.values().iterator();
    while (localIterator.hasNext())
    {
      dw.a locala = (dw.a)localIterator.next();
      if (a(locala))
      {
        if (((d)paramObject).a(locala))
        {
          if (!b(locala).equals(((d)paramObject).b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((d)paramObject).a(locala)) {
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
  
  public String h()
  {
    return this.e;
  }
  
  public int hashCode()
  {
    Iterator localIterator = a.values().iterator();
    int j = 0;
    if (localIterator.hasNext())
    {
      dw.a locala = (dw.a)localIterator.next();
      if (!a(locala)) {
        break label68;
      }
      int k = locala.g();
      j = b(locala).hashCode() + (j + k);
    }
    label68:
    for (;;)
    {
      break;
      return j;
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
  
  public String k()
  {
    return this.h;
  }
  
  public String l()
  {
    return this.i;
  }
  
  public d m()
  {
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    cg localcg = CREATOR;
    cg.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/fv$d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */