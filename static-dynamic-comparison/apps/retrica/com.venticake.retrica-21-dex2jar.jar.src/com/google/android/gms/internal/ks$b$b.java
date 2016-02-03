package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ks$b$b
  extends hy
  implements SafeParcelable, Person.Cover.CoverPhoto
{
  public static final kx CREATOR = new kx();
  private static final HashMap<String, hy.a<?, ?>> acr = new HashMap();
  private final Set<Integer> acs;
  private int ku;
  private int kv;
  private String qY;
  private final int xM;
  
  static
  {
    acr.put("height", hy.a.g("height", 2));
    acr.put("url", hy.a.j("url", 3));
    acr.put("width", hy.a.g("width", 4));
  }
  
  public ks$b$b()
  {
    this.xM = 1;
    this.acs = new HashSet();
  }
  
  ks$b$b(Set<Integer> paramSet, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    this.acs = paramSet;
    this.xM = paramInt1;
    this.kv = paramInt2;
    this.qY = paramString;
    this.ku = paramInt3;
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
      return Integer.valueOf(this.kv);
    case 3: 
      return this.qY;
    }
    return Integer.valueOf(this.ku);
  }
  
  public int describeContents()
  {
    kx localkx = CREATOR;
    return 0;
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
    Iterator localIterator = acr.values().iterator();
    while (localIterator.hasNext())
    {
      hy.a locala = (hy.a)localIterator.next();
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
  
  public HashMap<String, hy.a<?, ?>> fG()
  {
    return acr;
  }
  
  public int getHeight()
  {
    return this.kv;
  }
  
  public String getUrl()
  {
    return this.qY;
  }
  
  int getVersionCode()
  {
    return this.xM;
  }
  
  public int getWidth()
  {
    return this.ku;
  }
  
  public boolean hasHeight()
  {
    return this.acs.contains(Integer.valueOf(2));
  }
  
  public boolean hasUrl()
  {
    return this.acs.contains(Integer.valueOf(3));
  }
  
  public boolean hasWidth()
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
  
  public b kS()
  {
    return this;
  }
  
  Set<Integer> kk()
  {
    return this.acs;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    kx localkx = CREATOR;
    kx.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ks$b$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */