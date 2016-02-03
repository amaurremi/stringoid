package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.b.a.b.i;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class fv$g
  extends dw
  implements i, SafeParcelable
{
  public static final ci CREATOR = new ci();
  private static final HashMap a = new HashMap();
  private final Set b;
  private final int c;
  private boolean d;
  private String e;
  
  static
  {
    a.put("primary", dw.a.c("primary", 2));
    a.put("value", dw.a.d("value", 3));
  }
  
  public fv$g()
  {
    this.c = 1;
    this.b = new HashSet();
  }
  
  fv$g(Set paramSet, int paramInt, boolean paramBoolean, String paramString)
  {
    this.b = paramSet;
    this.c = paramInt;
    this.d = paramBoolean;
    this.e = paramString;
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
      return Boolean.valueOf(this.d);
    }
    return this.e;
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
    ci localci = CREATOR;
    return 0;
  }
  
  Set e()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof g)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (g)paramObject;
    Iterator localIterator = a.values().iterator();
    while (localIterator.hasNext())
    {
      dw.a locala = (dw.a)localIterator.next();
      if (a(locala))
      {
        if (((g)paramObject).a(locala))
        {
          if (!b(locala).equals(((g)paramObject).b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((g)paramObject).a(locala)) {
        return false;
      }
    }
    return true;
  }
  
  int f()
  {
    return this.c;
  }
  
  public boolean g()
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
  
  public g i()
  {
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ci localci = CREATOR;
    ci.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/fv$g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */