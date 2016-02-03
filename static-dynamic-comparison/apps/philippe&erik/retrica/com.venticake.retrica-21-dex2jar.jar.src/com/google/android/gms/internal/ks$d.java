package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.model.people.Person.Name;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ks$d
  extends hy
  implements SafeParcelable, Person.Name
{
  public static final kz CREATOR = new kz();
  private static final HashMap<String, hy.a<?, ?>> acr = new HashMap();
  private String acQ;
  private String acT;
  private final Set<Integer> acs;
  private String adQ;
  private String adR;
  private String adS;
  private String adT;
  private final int xM;
  
  static
  {
    acr.put("familyName", hy.a.j("familyName", 2));
    acr.put("formatted", hy.a.j("formatted", 3));
    acr.put("givenName", hy.a.j("givenName", 4));
    acr.put("honorificPrefix", hy.a.j("honorificPrefix", 5));
    acr.put("honorificSuffix", hy.a.j("honorificSuffix", 6));
    acr.put("middleName", hy.a.j("middleName", 7));
  }
  
  public ks$d()
  {
    this.xM = 1;
    this.acs = new HashSet();
  }
  
  ks$d(Set<Integer> paramSet, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.acs = paramSet;
    this.xM = paramInt;
    this.acQ = paramString1;
    this.adQ = paramString2;
    this.acT = paramString3;
    this.adR = paramString4;
    this.adS = paramString5;
    this.adT = paramString6;
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
      return this.acQ;
    case 3: 
      return this.adQ;
    case 4: 
      return this.acT;
    case 5: 
      return this.adR;
    case 6: 
      return this.adS;
    }
    return this.adT;
  }
  
  public int describeContents()
  {
    kz localkz = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof d)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (d)paramObject;
    Iterator localIterator = acr.values().iterator();
    while (localIterator.hasNext())
    {
      hy.a locala = (hy.a)localIterator.next();
      if (a(locala))
      {
        if (((d)paramObject).a(locala))
        {
          if (!b(locala).equals(((d)paramObject).b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((d)paramObject).a(locala)) {
        return false;
      }
    }
    return true;
  }
  
  public HashMap<String, hy.a<?, ?>> fG()
  {
    return acr;
  }
  
  public String getFamilyName()
  {
    return this.acQ;
  }
  
  public String getFormatted()
  {
    return this.adQ;
  }
  
  public String getGivenName()
  {
    return this.acT;
  }
  
  public String getHonorificPrefix()
  {
    return this.adR;
  }
  
  public String getHonorificSuffix()
  {
    return this.adS;
  }
  
  public String getMiddleName()
  {
    return this.adT;
  }
  
  int getVersionCode()
  {
    return this.xM;
  }
  
  public boolean hasFamilyName()
  {
    return this.acs.contains(Integer.valueOf(2));
  }
  
  public boolean hasFormatted()
  {
    return this.acs.contains(Integer.valueOf(3));
  }
  
  public boolean hasGivenName()
  {
    return this.acs.contains(Integer.valueOf(4));
  }
  
  public boolean hasHonorificPrefix()
  {
    return this.acs.contains(Integer.valueOf(5));
  }
  
  public boolean hasHonorificSuffix()
  {
    return this.acs.contains(Integer.valueOf(6));
  }
  
  public boolean hasMiddleName()
  {
    return this.acs.contains(Integer.valueOf(7));
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
  
  public d kU()
  {
    return this;
  }
  
  Set<Integer> kk()
  {
    return this.acs;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    kz localkz = CREATOR;
    kz.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ks$d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */