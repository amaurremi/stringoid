package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class kq
  extends hz
  implements SafeParcelable, Moment
{
  public static final kr CREATOR = new kr();
  private static final HashMap<String, hz.a<?, ?>> aco = new HashMap();
  private final Set<Integer> acp;
  private String adc;
  private ko adk;
  private ko adl;
  private String qU;
  private String xD;
  private final int xJ;
  
  static
  {
    aco.put("id", hz.a.j("id", 2));
    aco.put("result", hz.a.a("result", 4, ko.class));
    aco.put("startDate", hz.a.j("startDate", 5));
    aco.put("target", hz.a.a("target", 6, ko.class));
    aco.put("type", hz.a.j("type", 7));
  }
  
  public kq()
  {
    this.xJ = 1;
    this.acp = new HashSet();
  }
  
  kq(Set<Integer> paramSet, int paramInt, String paramString1, ko paramko1, String paramString2, ko paramko2, String paramString3)
  {
    this.acp = paramSet;
    this.xJ = paramInt;
    this.xD = paramString1;
    this.adk = paramko1;
    this.adc = paramString2;
    this.adl = paramko2;
    this.qU = paramString3;
  }
  
  public kq(Set<Integer> paramSet, String paramString1, ko paramko1, String paramString2, ko paramko2, String paramString3)
  {
    this.acp = paramSet;
    this.xJ = 1;
    this.xD = paramString1;
    this.adk = paramko1;
    this.adc = paramString2;
    this.adl = paramko2;
    this.qU = paramString3;
  }
  
  protected boolean a(hz.a parama)
  {
    return this.acp.contains(Integer.valueOf(parama.fI()));
  }
  
  protected Object aF(String paramString)
  {
    return null;
  }
  
  protected boolean aG(String paramString)
  {
    return false;
  }
  
  protected Object b(hz.a parama)
  {
    switch (parama.fI())
    {
    case 3: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.fI());
    case 2: 
      return this.xD;
    case 4: 
      return this.adk;
    case 5: 
      return this.adc;
    case 6: 
      return this.adl;
    }
    return this.qU;
  }
  
  public int describeContents()
  {
    kr localkr = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof kq)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (kq)paramObject;
    Iterator localIterator = aco.values().iterator();
    while (localIterator.hasNext())
    {
      hz.a locala = (hz.a)localIterator.next();
      if (a(locala))
      {
        if (((kq)paramObject).a(locala))
        {
          if (!b(locala).equals(((kq)paramObject).b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((kq)paramObject).a(locala)) {
        return false;
      }
    }
    return true;
  }
  
  public HashMap<String, hz.a<?, ?>> fB()
  {
    return aco;
  }
  
  public String getId()
  {
    return this.xD;
  }
  
  public ItemScope getResult()
  {
    return this.adk;
  }
  
  public String getStartDate()
  {
    return this.adc;
  }
  
  public ItemScope getTarget()
  {
    return this.adl;
  }
  
  public String getType()
  {
    return this.qU;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public boolean hasId()
  {
    return this.acp.contains(Integer.valueOf(2));
  }
  
  public boolean hasResult()
  {
    return this.acp.contains(Integer.valueOf(4));
  }
  
  public boolean hasStartDate()
  {
    return this.acp.contains(Integer.valueOf(5));
  }
  
  public boolean hasTarget()
  {
    return this.acp.contains(Integer.valueOf(6));
  }
  
  public boolean hasType()
  {
    return this.acp.contains(Integer.valueOf(7));
  }
  
  public int hashCode()
  {
    Iterator localIterator = aco.values().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      hz.a locala = (hz.a)localIterator.next();
      if (!a(locala)) {
        break label68;
      }
      int j = locala.fI();
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
  
  Set<Integer> kf()
  {
    return this.acp;
  }
  
  ko kw()
  {
    return this.adk;
  }
  
  ko kx()
  {
    return this.adl;
  }
  
  public kq ky()
  {
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    kr localkr = CREATOR;
    kr.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/kq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */