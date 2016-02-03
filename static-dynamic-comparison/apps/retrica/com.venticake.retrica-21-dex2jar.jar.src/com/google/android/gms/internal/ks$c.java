package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.model.people.Person.Image;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ks$c
  extends hy
  implements SafeParcelable, Person.Image
{
  public static final ky CREATOR = new ky();
  private static final HashMap<String, hy.a<?, ?>> acr = new HashMap();
  private final Set<Integer> acs;
  private String qY;
  private final int xM;
  
  static
  {
    acr.put("url", hy.a.j("url", 2));
  }
  
  public ks$c()
  {
    this.xM = 1;
    this.acs = new HashSet();
  }
  
  public ks$c(String paramString)
  {
    this.acs = new HashSet();
    this.xM = 1;
    this.qY = paramString;
    this.acs.add(Integer.valueOf(2));
  }
  
  ks$c(Set<Integer> paramSet, int paramInt, String paramString)
  {
    this.acs = paramSet;
    this.xM = paramInt;
    this.qY = paramString;
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
    }
    return this.qY;
  }
  
  public int describeContents()
  {
    ky localky = CREATOR;
    return 0;
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
    Iterator localIterator = acr.values().iterator();
    while (localIterator.hasNext())
    {
      hy.a locala = (hy.a)localIterator.next();
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
  
  public HashMap<String, hy.a<?, ?>> fG()
  {
    return acr;
  }
  
  public String getUrl()
  {
    return this.qY;
  }
  
  int getVersionCode()
  {
    return this.xM;
  }
  
  public boolean hasUrl()
  {
    return this.acs.contains(Integer.valueOf(2));
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
  
  public c kT()
  {
    return this;
  }
  
  Set<Integer> kk()
  {
    return this.acs;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ky localky = CREATOR;
    ky.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ks$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */