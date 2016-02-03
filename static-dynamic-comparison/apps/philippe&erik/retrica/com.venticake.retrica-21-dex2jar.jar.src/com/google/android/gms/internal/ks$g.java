package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.model.people.Person.PlacesLived;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ks$g
  extends hy
  implements SafeParcelable, Person.PlacesLived
{
  public static final lb CREATOR = new lb();
  private static final HashMap<String, hy.a<?, ?>> acr = new HashMap();
  private final Set<Integer> acs;
  private boolean adW;
  private String mValue;
  private final int xM;
  
  static
  {
    acr.put("primary", hy.a.i("primary", 2));
    acr.put("value", hy.a.j("value", 3));
  }
  
  public ks$g()
  {
    this.xM = 1;
    this.acs = new HashSet();
  }
  
  ks$g(Set<Integer> paramSet, int paramInt, boolean paramBoolean, String paramString)
  {
    this.acs = paramSet;
    this.xM = paramInt;
    this.adW = paramBoolean;
    this.mValue = paramString;
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
    case 2: 
      return Boolean.valueOf(this.adW);
    }
    return this.mValue;
  }
  
  public int describeContents()
  {
    lb locallb = CREATOR;
    return 0;
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
    Iterator localIterator = acr.values().iterator();
    while (localIterator.hasNext())
    {
      hy.a locala = (hy.a)localIterator.next();
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
  
  public HashMap<String, hy.a<?, ?>> fG()
  {
    return acr;
  }
  
  public String getValue()
  {
    return this.mValue;
  }
  
  int getVersionCode()
  {
    return this.xM;
  }
  
  public boolean hasPrimary()
  {
    return this.acs.contains(Integer.valueOf(2));
  }
  
  public boolean hasValue()
  {
    return this.acs.contains(Integer.valueOf(3));
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
  
  public boolean isPrimary()
  {
    return this.adW;
  }
  
  public g kW()
  {
    return this;
  }
  
  Set<Integer> kk()
  {
    return this.acs;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    lb locallb = CREATOR;
    lb.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ks$g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */