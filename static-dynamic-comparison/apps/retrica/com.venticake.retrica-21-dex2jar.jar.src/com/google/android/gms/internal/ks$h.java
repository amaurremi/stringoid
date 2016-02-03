package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.model.people.Person.Urls;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ks$h
  extends hy
  implements SafeParcelable, Person.Urls
{
  public static final lc CREATOR = new lc();
  private static final HashMap<String, hy.a<?, ?>> acr = new HashMap();
  private int AT;
  private final Set<Integer> acs;
  private String adX;
  private final int adY = 4;
  private String mValue;
  private final int xM;
  
  static
  {
    acr.put("label", hy.a.j("label", 5));
    acr.put("type", hy.a.a("type", 6, new hv().f("home", 0).f("work", 1).f("blog", 2).f("profile", 3).f("other", 4).f("otherProfile", 5).f("contributor", 6).f("website", 7), false));
    acr.put("value", hy.a.j("value", 4));
  }
  
  public ks$h()
  {
    this.xM = 2;
    this.acs = new HashSet();
  }
  
  ks$h(Set<Integer> paramSet, int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3)
  {
    this.acs = paramSet;
    this.xM = paramInt1;
    this.adX = paramString1;
    this.AT = paramInt2;
    this.mValue = paramString2;
  }
  
  protected boolean a(hy.a parama)
  {
    return this.acs.contains(Integer.valueOf(parama.fN()));
  }
  
  protected Object aF(String paramString)
  {
    return null;
  }
  
  protected boolean aG(String paramString)
  {
    return false;
  }
  
  protected Object b(hy.a parama)
  {
    switch (parama.fN())
    {
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.fN());
    case 5: 
      return this.adX;
    case 6: 
      return Integer.valueOf(this.AT);
    }
    return this.mValue;
  }
  
  public int describeContents()
  {
    lc locallc = CREATOR;
    return 0;
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
    Iterator localIterator = acr.values().iterator();
    while (localIterator.hasNext())
    {
      hy.a locala = (hy.a)localIterator.next();
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
  
  public HashMap<String, hy.a<?, ?>> fG()
  {
    return acr;
  }
  
  public String getLabel()
  {
    return this.adX;
  }
  
  public int getType()
  {
    return this.AT;
  }
  
  public String getValue()
  {
    return this.mValue;
  }
  
  int getVersionCode()
  {
    return this.xM;
  }
  
  public boolean hasLabel()
  {
    return this.acs.contains(Integer.valueOf(5));
  }
  
  public boolean hasType()
  {
    return this.acs.contains(Integer.valueOf(6));
  }
  
  public boolean hasValue()
  {
    return this.acs.contains(Integer.valueOf(4));
  }
  
  public int hashCode()
  {
    Iterator localIterator = acr.values().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      hy.a locala = (hy.a)localIterator.next();
      if (!a(locala)) {
        break label68;
      }
      int j = locala.fN();
      i = b(locala).hashCode() + (i + j);
    }
    label68:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  @Deprecated
  public int kX()
  {
    return 4;
  }
  
  public h kY()
  {
    return this;
  }
  
  Set<Integer> kk()
  {
    return this.acs;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    lc locallc = CREATOR;
    lc.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ks$h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */