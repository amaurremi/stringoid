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

public final class id
  extends es
  implements SafeParcelable, Moment
{
  public static final ie CREATOR = new ie();
  private static final HashMap<String, es.a<?, ?>> Ep = new HashMap();
  private String AI;
  private final Set<Integer> Eq;
  private String Fe;
  private ib Fm;
  private ib Fn;
  private final int kg;
  private String uS;
  
  static
  {
    Ep.put("id", es.a.g("id", 2));
    Ep.put("result", es.a.a("result", 4, ib.class));
    Ep.put("startDate", es.a.g("startDate", 5));
    Ep.put("target", es.a.a("target", 6, ib.class));
    Ep.put("type", es.a.g("type", 7));
  }
  
  public id()
  {
    this.kg = 1;
    this.Eq = new HashSet();
  }
  
  id(Set<Integer> paramSet, int paramInt, String paramString1, ib paramib1, String paramString2, ib paramib2, String paramString3)
  {
    this.Eq = paramSet;
    this.kg = paramInt;
    this.uS = paramString1;
    this.Fm = paramib1;
    this.Fe = paramString2;
    this.Fn = paramib2;
    this.AI = paramString3;
  }
  
  public id(Set<Integer> paramSet, String paramString1, ib paramib1, String paramString2, ib paramib2, String paramString3)
  {
    this.Eq = paramSet;
    this.kg = 1;
    this.uS = paramString1;
    this.Fm = paramib1;
    this.Fe = paramString2;
    this.Fn = paramib2;
    this.AI = paramString3;
  }
  
  protected Object V(String paramString)
  {
    return null;
  }
  
  protected boolean W(String paramString)
  {
    return false;
  }
  
  protected boolean a(es.a parama)
  {
    return this.Eq.contains(Integer.valueOf(parama.cq()));
  }
  
  protected Object b(es.a parama)
  {
    switch (parama.cq())
    {
    case 3: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.cq());
    case 2: 
      return this.uS;
    case 4: 
      return this.Fm;
    case 5: 
      return this.Fe;
    case 6: 
      return this.Fn;
    }
    return this.AI;
  }
  
  public HashMap<String, es.a<?, ?>> cj()
  {
    return Ep;
  }
  
  public int describeContents()
  {
    ie localie = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof id)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (id)paramObject;
    Iterator localIterator = Ep.values().iterator();
    while (localIterator.hasNext())
    {
      es.a locala = (es.a)localIterator.next();
      if (a(locala))
      {
        if (((id)paramObject).a(locala))
        {
          if (!b(locala).equals(((id)paramObject).b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((id)paramObject).a(locala)) {
        return false;
      }
    }
    return true;
  }
  
  Set<Integer> fa()
  {
    return this.Eq;
  }
  
  ib fr()
  {
    return this.Fm;
  }
  
  ib fs()
  {
    return this.Fn;
  }
  
  public id ft()
  {
    return this;
  }
  
  public String getId()
  {
    return this.uS;
  }
  
  public ItemScope getResult()
  {
    return this.Fm;
  }
  
  public String getStartDate()
  {
    return this.Fe;
  }
  
  public ItemScope getTarget()
  {
    return this.Fn;
  }
  
  public String getType()
  {
    return this.AI;
  }
  
  int getVersionCode()
  {
    return this.kg;
  }
  
  public boolean hasId()
  {
    return this.Eq.contains(Integer.valueOf(2));
  }
  
  public boolean hasResult()
  {
    return this.Eq.contains(Integer.valueOf(4));
  }
  
  public boolean hasStartDate()
  {
    return this.Eq.contains(Integer.valueOf(5));
  }
  
  public boolean hasTarget()
  {
    return this.Eq.contains(Integer.valueOf(6));
  }
  
  public boolean hasType()
  {
    return this.Eq.contains(Integer.valueOf(7));
  }
  
  public int hashCode()
  {
    Iterator localIterator = Ep.values().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      es.a locala = (es.a)localIterator.next();
      if (!a(locala)) {
        break label68;
      }
      int j = locala.cq();
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
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ie localie = CREATOR;
    ie.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/id.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */