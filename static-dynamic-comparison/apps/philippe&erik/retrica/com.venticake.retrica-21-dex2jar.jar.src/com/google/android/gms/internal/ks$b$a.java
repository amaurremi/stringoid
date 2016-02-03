package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.model.people.Person.Cover.CoverInfo;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ks$b$a
  extends hy
  implements SafeParcelable, Person.Cover.CoverInfo
{
  public static final kw CREATOR = new kw();
  private static final HashMap<String, hy.a<?, ?>> acr = new HashMap();
  private final Set<Integer> acs;
  private int adO;
  private int adP;
  private final int xM;
  
  static
  {
    acr.put("leftImageOffset", hy.a.g("leftImageOffset", 2));
    acr.put("topImageOffset", hy.a.g("topImageOffset", 3));
  }
  
  public ks$b$a()
  {
    this.xM = 1;
    this.acs = new HashSet();
  }
  
  ks$b$a(Set<Integer> paramSet, int paramInt1, int paramInt2, int paramInt3)
  {
    this.acs = paramSet;
    this.xM = paramInt1;
    this.adO = paramInt2;
    this.adP = paramInt3;
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
      return Integer.valueOf(this.adO);
    }
    return Integer.valueOf(this.adP);
  }
  
  public int describeContents()
  {
    kw localkw = CREATOR;
    return 0;
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
    Iterator localIterator = acr.values().iterator();
    while (localIterator.hasNext())
    {
      hy.a locala = (hy.a)localIterator.next();
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
  
  public HashMap<String, hy.a<?, ?>> fG()
  {
    return acr;
  }
  
  public int getLeftImageOffset()
  {
    return this.adO;
  }
  
  public int getTopImageOffset()
  {
    return this.adP;
  }
  
  int getVersionCode()
  {
    return this.xM;
  }
  
  public boolean hasLeftImageOffset()
  {
    return this.acs.contains(Integer.valueOf(2));
  }
  
  public boolean hasTopImageOffset()
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
  
  public a kR()
  {
    return this;
  }
  
  Set<Integer> kk()
  {
    return this.acs;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    kw localkw = CREATOR;
    kw.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ks$b$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */