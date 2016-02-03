package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.b.a.b.h;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class fv$f
  extends dw
  implements h, SafeParcelable
{
  public static final ch CREATOR = new ch();
  private static final HashMap a = new HashMap();
  private final Set b;
  private final int c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private boolean i;
  private String j;
  private String k;
  private int l;
  
  static
  {
    a.put("department", dw.a.d("department", 2));
    a.put("description", dw.a.d("description", 3));
    a.put("endDate", dw.a.d("endDate", 4));
    a.put("location", dw.a.d("location", 5));
    a.put("name", dw.a.d("name", 6));
    a.put("primary", dw.a.c("primary", 7));
    a.put("startDate", dw.a.d("startDate", 8));
    a.put("title", dw.a.d("title", 9));
    a.put("type", dw.a.a("type", 10, new dt().a("work", 0).a("school", 1), false));
  }
  
  public fv$f()
  {
    this.c = 1;
    this.b = new HashSet();
  }
  
  fv$f(Set paramSet, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, String paramString6, String paramString7, int paramInt2)
  {
    this.b = paramSet;
    this.c = paramInt1;
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramString3;
    this.g = paramString4;
    this.h = paramString5;
    this.i = paramBoolean;
    this.j = paramString6;
    this.k = paramString7;
    this.l = paramInt2;
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
    case 7: 
      return Boolean.valueOf(this.i);
    case 8: 
      return this.j;
    case 9: 
      return this.k;
    }
    return Integer.valueOf(this.l);
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
    ch localch = CREATOR;
    return 0;
  }
  
  Set e()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof f)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (f)paramObject;
    Iterator localIterator = a.values().iterator();
    while (localIterator.hasNext())
    {
      dw.a locala = (dw.a)localIterator.next();
      if (a(locala))
      {
        if (((f)paramObject).a(locala))
        {
          if (!b(locala).equals(((f)paramObject).b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((f)paramObject).a(locala)) {
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
    int m = 0;
    if (localIterator.hasNext())
    {
      dw.a locala = (dw.a)localIterator.next();
      if (!a(locala)) {
        break label68;
      }
      int n = locala.g();
      m = b(locala).hashCode() + (m + n);
    }
    label68:
    for (;;)
    {
      break;
      return m;
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
  
  public boolean l()
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
  
  public f p()
  {
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ch localch = CREATOR;
    ch.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/fv$f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */