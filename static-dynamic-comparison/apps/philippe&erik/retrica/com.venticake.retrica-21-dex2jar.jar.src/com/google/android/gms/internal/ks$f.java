package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.model.people.Person.Organizations;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ks$f
  extends hy
  implements SafeParcelable, Person.Organizations
{
  public static final la CREATOR = new la();
  private static final HashMap<String, hy.a<?, ?>> acr = new HashMap();
  private int AT;
  private String HY;
  private String Mp;
  private String acP;
  private final Set<Integer> acs;
  private String adU;
  private String adV;
  private boolean adW;
  private String adf;
  private String mName;
  private final int xM;
  
  static
  {
    acr.put("department", hy.a.j("department", 2));
    acr.put("description", hy.a.j("description", 3));
    acr.put("endDate", hy.a.j("endDate", 4));
    acr.put("location", hy.a.j("location", 5));
    acr.put("name", hy.a.j("name", 6));
    acr.put("primary", hy.a.i("primary", 7));
    acr.put("startDate", hy.a.j("startDate", 8));
    acr.put("title", hy.a.j("title", 9));
    acr.put("type", hy.a.a("type", 10, new hv().f("work", 0).f("school", 1), false));
  }
  
  public ks$f()
  {
    this.xM = 1;
    this.acs = new HashSet();
  }
  
  ks$f(Set<Integer> paramSet, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, String paramString6, String paramString7, int paramInt2)
  {
    this.acs = paramSet;
    this.xM = paramInt1;
    this.adU = paramString1;
    this.Mp = paramString2;
    this.acP = paramString3;
    this.adV = paramString4;
    this.mName = paramString5;
    this.adW = paramBoolean;
    this.adf = paramString6;
    this.HY = paramString7;
    this.AT = paramInt2;
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
      return this.adU;
    case 3: 
      return this.Mp;
    case 4: 
      return this.acP;
    case 5: 
      return this.adV;
    case 6: 
      return this.mName;
    case 7: 
      return Boolean.valueOf(this.adW);
    case 8: 
      return this.adf;
    case 9: 
      return this.HY;
    }
    return Integer.valueOf(this.AT);
  }
  
  public int describeContents()
  {
    la localla = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof f)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (f)paramObject;
    Iterator localIterator = acr.values().iterator();
    while (localIterator.hasNext())
    {
      hy.a locala = (hy.a)localIterator.next();
      if (a(locala))
      {
        if (((f)paramObject).a(locala))
        {
          if (!b(locala).equals(((f)paramObject).b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((f)paramObject).a(locala)) {
        return false;
      }
    }
    return true;
  }
  
  public HashMap<String, hy.a<?, ?>> fG()
  {
    return acr;
  }
  
  public String getDepartment()
  {
    return this.adU;
  }
  
  public String getDescription()
  {
    return this.Mp;
  }
  
  public String getEndDate()
  {
    return this.acP;
  }
  
  public String getLocation()
  {
    return this.adV;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getStartDate()
  {
    return this.adf;
  }
  
  public String getTitle()
  {
    return this.HY;
  }
  
  public int getType()
  {
    return this.AT;
  }
  
  int getVersionCode()
  {
    return this.xM;
  }
  
  public boolean hasDepartment()
  {
    return this.acs.contains(Integer.valueOf(2));
  }
  
  public boolean hasDescription()
  {
    return this.acs.contains(Integer.valueOf(3));
  }
  
  public boolean hasEndDate()
  {
    return this.acs.contains(Integer.valueOf(4));
  }
  
  public boolean hasLocation()
  {
    return this.acs.contains(Integer.valueOf(5));
  }
  
  public boolean hasName()
  {
    return this.acs.contains(Integer.valueOf(6));
  }
  
  public boolean hasPrimary()
  {
    return this.acs.contains(Integer.valueOf(7));
  }
  
  public boolean hasStartDate()
  {
    return this.acs.contains(Integer.valueOf(8));
  }
  
  public boolean hasTitle()
  {
    return this.acs.contains(Integer.valueOf(9));
  }
  
  public boolean hasType()
  {
    return this.acs.contains(Integer.valueOf(10));
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
  
  public f kV()
  {
    return this;
  }
  
  Set<Integer> kk()
  {
    return this.acs;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    la localla = CREATOR;
    la.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ks$f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */