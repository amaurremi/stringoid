package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class nv
  extends jj
  implements Moment
{
  public static final nw CREATOR = new nw();
  private static final HashMap<String, ji.a<?, ?>> alQ = new HashMap();
  String BL;
  final int BR;
  final Set<Integer> alR;
  String amE;
  nt amM;
  nt amN;
  String uO;
  
  static
  {
    alQ.put("id", ji.a.l("id", 2));
    alQ.put("result", ji.a.a("result", 4, nt.class));
    alQ.put("startDate", ji.a.l("startDate", 5));
    alQ.put("target", ji.a.a("target", 6, nt.class));
    alQ.put("type", ji.a.l("type", 7));
  }
  
  public nv()
  {
    this.BR = 1;
    this.alR = new HashSet();
  }
  
  nv(Set<Integer> paramSet, int paramInt, String paramString1, nt paramnt1, String paramString2, nt paramnt2, String paramString3)
  {
    this.alR = paramSet;
    this.BR = paramInt;
    this.BL = paramString1;
    this.amM = paramnt1;
    this.amE = paramString2;
    this.amN = paramnt2;
    this.uO = paramString3;
  }
  
  public nv(Set<Integer> paramSet, String paramString1, nt paramnt1, String paramString2, nt paramnt2, String paramString3)
  {
    this.alR = paramSet;
    this.BR = 1;
    this.BL = paramString1;
    this.amM = paramnt1;
    this.amE = paramString2;
    this.amN = paramnt2;
    this.uO = paramString3;
  }
  
  protected boolean a(ji.a parama)
  {
    return this.alR.contains(Integer.valueOf(parama.hm()));
  }
  
  protected Object b(ji.a parama)
  {
    switch (parama.hm())
    {
    case 3: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.hm());
    case 2: 
      return this.BL;
    case 4: 
      return this.amM;
    case 5: 
      return this.amE;
    case 6: 
      return this.amN;
    }
    return this.uO;
  }
  
  public int describeContents()
  {
    nw localnw = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof nv)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (nv)paramObject;
    Iterator localIterator = alQ.values().iterator();
    while (localIterator.hasNext())
    {
      ji.a locala = (ji.a)localIterator.next();
      if (a(locala))
      {
        if (((nv)paramObject).a(locala))
        {
          if (!b(locala).equals(((nv)paramObject).b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((nv)paramObject).a(locala)) {
        return false;
      }
    }
    return true;
  }
  
  public String getId()
  {
    return this.BL;
  }
  
  public ItemScope getResult()
  {
    return this.amM;
  }
  
  public String getStartDate()
  {
    return this.amE;
  }
  
  public ItemScope getTarget()
  {
    return this.amN;
  }
  
  public String getType()
  {
    return this.uO;
  }
  
  public boolean hasId()
  {
    return this.alR.contains(Integer.valueOf(2));
  }
  
  public boolean hasResult()
  {
    return this.alR.contains(Integer.valueOf(4));
  }
  
  public boolean hasStartDate()
  {
    return this.alR.contains(Integer.valueOf(5));
  }
  
  public boolean hasTarget()
  {
    return this.alR.contains(Integer.valueOf(6));
  }
  
  public boolean hasType()
  {
    return this.alR.contains(Integer.valueOf(7));
  }
  
  public int hashCode()
  {
    Iterator localIterator = alQ.values().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      ji.a locala = (ji.a)localIterator.next();
      if (!a(locala)) {
        break label68;
      }
      int j = locala.hm();
      i = b(locala).hashCode() + (i + j);
    }
    label68:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public HashMap<String, ji.a<?, ?>> hf()
  {
    return alQ;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public nv nq()
  {
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    nw localnw = CREATOR;
    nw.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/nv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */