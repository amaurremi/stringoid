package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.b.a.b.c;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class fv$b
  extends dw
  implements c, SafeParcelable
{
  public static final cc CREATOR = new cc();
  private static final HashMap a = new HashMap();
  private final Set b;
  private final int c;
  private fv.b.a d;
  private fv.b.b e;
  private int f;
  
  static
  {
    a.put("coverInfo", dw.a.a("coverInfo", 2, fv.b.a.class));
    a.put("coverPhoto", dw.a.a("coverPhoto", 3, fv.b.b.class));
    a.put("layout", dw.a.a("layout", 4, new dt().a("banner", 0), false));
  }
  
  public fv$b()
  {
    this.c = 1;
    this.b = new HashSet();
  }
  
  fv$b(Set paramSet, int paramInt1, fv.b.a parama, fv.b.b paramb, int paramInt2)
  {
    this.b = paramSet;
    this.c = paramInt1;
    this.d = parama;
    this.e = paramb;
    this.f = paramInt2;
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
    }
    return Integer.valueOf(this.f);
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
    cc localcc = CREATOR;
    return 0;
  }
  
  Set e()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof b)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (b)paramObject;
    Iterator localIterator = a.values().iterator();
    while (localIterator.hasNext())
    {
      dw.a locala = (dw.a)localIterator.next();
      if (a(locala))
      {
        if (((b)paramObject).a(locala))
        {
          if (!b(locala).equals(((b)paramObject).b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((b)paramObject).a(locala)) {
        return false;
      }
    }
    return true;
  }
  
  int f()
  {
    return this.c;
  }
  
  fv.b.a g()
  {
    return this.d;
  }
  
  fv.b.b h()
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
  
  public int i()
  {
    return this.f;
  }
  
  public b j()
  {
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    cc localcc = CREATOR;
    cc.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/fv$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */