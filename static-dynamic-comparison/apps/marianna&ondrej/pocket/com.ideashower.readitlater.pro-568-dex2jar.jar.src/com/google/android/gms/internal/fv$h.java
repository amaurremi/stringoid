package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.b.a.b.j;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class fv$h
  extends dw
  implements j, SafeParcelable
{
  public static final cj CREATOR = new cj();
  private static final HashMap a = new HashMap();
  private final Set b;
  private final int c;
  private String d;
  private final int e = 4;
  private int f;
  private String g;
  
  static
  {
    a.put("label", dw.a.d("label", 5));
    a.put("type", dw.a.a("type", 6, new dt().a("home", 0).a("work", 1).a("blog", 2).a("profile", 3).a("other", 4).a("otherProfile", 5).a("contributor", 6).a("website", 7), false));
    a.put("value", dw.a.d("value", 4));
  }
  
  public fv$h()
  {
    this.c = 2;
    this.b = new HashSet();
  }
  
  fv$h(Set paramSet, int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3)
  {
    this.b = paramSet;
    this.c = paramInt1;
    this.d = paramString1;
    this.f = paramInt2;
    this.g = paramString2;
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
    case 5: 
      return this.d;
    case 6: 
      return Integer.valueOf(this.f);
    }
    return this.g;
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
    cj localcj = CREATOR;
    return 0;
  }
  
  Set e()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof h)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (h)paramObject;
    Iterator localIterator = a.values().iterator();
    while (localIterator.hasNext())
    {
      dw.a locala = (dw.a)localIterator.next();
      if (a(locala))
      {
        if (((h)paramObject).a(locala))
        {
          if (!b(locala).equals(((h)paramObject).b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((h)paramObject).a(locala)) {
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
  
  @Deprecated
  public int h()
  {
    return 4;
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
  
  public String j()
  {
    return this.g;
  }
  
  public h k()
  {
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    cj localcj = CREATOR;
    cj.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/fv$h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */