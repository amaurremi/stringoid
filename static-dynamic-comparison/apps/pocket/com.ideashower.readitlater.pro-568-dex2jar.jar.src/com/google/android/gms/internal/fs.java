package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.b.a.a.b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class fs
  extends dw
  implements b, SafeParcelable
{
  public static final by CREATOR = new by();
  private static final HashMap a = new HashMap();
  private final Set b;
  private final int c;
  private String d;
  private fq e;
  private String f;
  private fq g;
  private String h;
  
  static
  {
    a.put("id", dw.a.d("id", 2));
    a.put("result", dw.a.a("result", 4, fq.class));
    a.put("startDate", dw.a.d("startDate", 5));
    a.put("target", dw.a.a("target", 6, fq.class));
    a.put("type", dw.a.d("type", 7));
  }
  
  public fs()
  {
    this.c = 1;
    this.b = new HashSet();
  }
  
  fs(Set paramSet, int paramInt, String paramString1, fq paramfq1, String paramString2, fq paramfq2, String paramString3)
  {
    this.b = paramSet;
    this.c = paramInt;
    this.d = paramString1;
    this.e = paramfq1;
    this.f = paramString2;
    this.g = paramfq2;
    this.h = paramString3;
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
    case 3: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.g());
    case 2: 
      return this.d;
    case 4: 
      return this.e;
    case 5: 
      return this.f;
    case 6: 
      return this.g;
    }
    return this.h;
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
    by localby = CREATOR;
    return 0;
  }
  
  Set e()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof fs)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (fs)paramObject;
    Iterator localIterator = a.values().iterator();
    while (localIterator.hasNext())
    {
      dw.a locala = (dw.a)localIterator.next();
      if (a(locala))
      {
        if (((fs)paramObject).a(locala))
        {
          if (!b(locala).equals(((fs)paramObject).b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((fs)paramObject).a(locala)) {
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
  
  fq h()
  {
    return this.e;
  }
  
  public int hashCode()
  {
    Iterator localIterator = a.values().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      dw.a locala = (dw.a)localIterator.next();
      if (!a(locala)) {
        break label68;
      }
      int j = locala.g();
      i = b(locala).hashCode() + (i + j);
    }
    label68:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public String i()
  {
    return this.f;
  }
  
  fq j()
  {
    return this.g;
  }
  
  public String k()
  {
    return this.h;
  }
  
  public fs l()
  {
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    by localby = CREATOR;
    by.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/fs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */