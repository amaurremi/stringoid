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

public final class kp
  extends hy
  implements SafeParcelable, Moment
{
  public static final kq CREATOR = new kq();
  private static final HashMap<String, hy.a<?, ?>> acr = new HashMap();
  private final Set<Integer> acs;
  private String adf;
  private kn adn;
  private kn ado;
  private String qX;
  private String xG;
  private final int xM;
  
  static
  {
    acr.put("id", hy.a.j("id", 2));
    acr.put("result", hy.a.a("result", 4, kn.class));
    acr.put("startDate", hy.a.j("startDate", 5));
    acr.put("target", hy.a.a("target", 6, kn.class));
    acr.put("type", hy.a.j("type", 7));
  }
  
  public kp()
  {
    this.xM = 1;
    this.acs = new HashSet();
  }
  
  kp(Set<Integer> paramSet, int paramInt, String paramString1, kn paramkn1, String paramString2, kn paramkn2, String paramString3)
  {
    this.acs = paramSet;
    this.xM = paramInt;
    this.xG = paramString1;
    this.adn = paramkn1;
    this.adf = paramString2;
    this.ado = paramkn2;
    this.qX = paramString3;
  }
  
  public kp(Set<Integer> paramSet, String paramString1, kn paramkn1, String paramString2, kn paramkn2, String paramString3)
  {
    this.acs = paramSet;
    this.xM = 1;
    this.xG = paramString1;
    this.adn = paramkn1;
    this.adf = paramString2;
    this.ado = paramkn2;
    this.qX = paramString3;
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
    case 3: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.fN());
    case 2: 
      return this.xG;
    case 4: 
      return this.adn;
    case 5: 
      return this.adf;
    case 6: 
      return this.ado;
    }
    return this.qX;
  }
  
  public int describeContents()
  {
    kq localkq = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof kp)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (kp)paramObject;
    Iterator localIterator = acr.values().iterator();
    while (localIterator.hasNext())
    {
      hy.a locala = (hy.a)localIterator.next();
      if (a(locala))
      {
        if (((kp)paramObject).a(locala))
        {
          if (!b(locala).equals(((kp)paramObject).b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((kp)paramObject).a(locala)) {
        return false;
      }
    }
    return true;
  }
  
  public HashMap<String, hy.a<?, ?>> fG()
  {
    return acr;
  }
  
  public String getId()
  {
    return this.xG;
  }
  
  public ItemScope getResult()
  {
    return this.adn;
  }
  
  public String getStartDate()
  {
    return this.adf;
  }
  
  public ItemScope getTarget()
  {
    return this.ado;
  }
  
  public String getType()
  {
    return this.qX;
  }
  
  int getVersionCode()
  {
    return this.xM;
  }
  
  public boolean hasId()
  {
    return this.acs.contains(Integer.valueOf(2));
  }
  
  public boolean hasResult()
  {
    return this.acs.contains(Integer.valueOf(4));
  }
  
  public boolean hasStartDate()
  {
    return this.acs.contains(Integer.valueOf(5));
  }
  
  public boolean hasTarget()
  {
    return this.acs.contains(Integer.valueOf(6));
  }
  
  public boolean hasType()
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
  
  kn kB()
  {
    return this.adn;
  }
  
  kn kC()
  {
    return this.ado;
  }
  
  public kp kD()
  {
    return this;
  }
  
  Set<Integer> kk()
  {
    return this.acs;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    kq localkq = CREATOR;
    kq.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/kp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */