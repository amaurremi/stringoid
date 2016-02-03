package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.b.a.b.f;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class fv$c
  extends dw
  implements f, SafeParcelable
{
  public static final cf CREATOR = new cf();
  private static final HashMap a = new HashMap();
  private final Set b;
  private final int c;
  private String d;
  
  static
  {
    a.put("url", dw.a.d("url", 2));
  }
  
  public fv$c()
  {
    this.c = 1;
    this.b = new HashSet();
  }
  
  public fv$c(String paramString)
  {
    this.b = new HashSet();
    this.c = 1;
    this.d = paramString;
    this.b.add(Integer.valueOf(2));
  }
  
  fv$c(Set paramSet, int paramInt, String paramString)
  {
    this.b = paramSet;
    this.c = paramInt;
    this.d = paramString;
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
    }
    return this.d;
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
    cf localcf = CREATOR;
    return 0;
  }
  
  Set e()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof c)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (c)paramObject;
    Iterator localIterator = a.values().iterator();
    while (localIterator.hasNext())
    {
      dw.a locala = (dw.a)localIterator.next();
      if (a(locala))
      {
        if (((c)paramObject).a(locala))
        {
          if (!b(locala).equals(((c)paramObject).b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((c)paramObject).a(locala)) {
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
  
  public boolean h()
  {
    return this.b.contains(Integer.valueOf(2));
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
  
  public c i()
  {
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    cf localcf = CREATOR;
    cf.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/fv$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */