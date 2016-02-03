package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.b.a.b.b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class fv$a
  extends dw
  implements b, SafeParcelable
{
  public static final cb CREATOR = new cb();
  private static final HashMap a = new HashMap();
  private final Set b;
  private final int c;
  private int d;
  private int e;
  
  static
  {
    a.put("max", dw.a.a("max", 2));
    a.put("min", dw.a.a("min", 3));
  }
  
  public fv$a()
  {
    this.c = 1;
    this.b = new HashSet();
  }
  
  fv$a(Set paramSet, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramSet;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
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
      return Integer.valueOf(this.d);
    }
    return Integer.valueOf(this.e);
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
    cb localcb = CREATOR;
    return 0;
  }
  
  Set e()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof a)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (a)paramObject;
    Iterator localIterator = a.values().iterator();
    while (localIterator.hasNext())
    {
      dw.a locala = (dw.a)localIterator.next();
      if (a(locala))
      {
        if (((a)paramObject).a(locala))
        {
          if (!b(locala).equals(((a)paramObject).b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((a)paramObject).a(locala)) {
        return false;
      }
    }
    return true;
  }
  
  int f()
  {
    return this.c;
  }
  
  public int g()
  {
    return this.d;
  }
  
  public int h()
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
  
  public a i()
  {
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    cb localcb = CREATOR;
    cb.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/fv$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */