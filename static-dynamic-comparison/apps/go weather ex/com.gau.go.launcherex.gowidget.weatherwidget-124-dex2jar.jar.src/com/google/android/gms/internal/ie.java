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

public final class ie
  extends ga
  implements SafeParcelable, Moment
{
  public static final if CREATOR = new if();
  private static final HashMap<String, ga.a<?, ?>> UI = new HashMap();
  private String Rd;
  private final Set<Integer> UJ;
  private ic VE;
  private ic VF;
  private String Vw;
  private String wp;
  private final int xH;
  
  static
  {
    UI.put("id", ga.a.j("id", 2));
    UI.put("result", ga.a.a("result", 4, ic.class));
    UI.put("startDate", ga.a.j("startDate", 5));
    UI.put("target", ga.a.a("target", 6, ic.class));
    UI.put("type", ga.a.j("type", 7));
  }
  
  public ie()
  {
    this.xH = 1;
    this.UJ = new HashSet();
  }
  
  ie(Set<Integer> paramSet, int paramInt, String paramString1, ic paramic1, String paramString2, ic paramic2, String paramString3)
  {
    this.UJ = paramSet;
    this.xH = paramInt;
    this.wp = paramString1;
    this.VE = paramic1;
    this.Vw = paramString2;
    this.VF = paramic2;
    this.Rd = paramString3;
  }
  
  public ie(Set<Integer> paramSet, String paramString1, ic paramic1, String paramString2, ic paramic2, String paramString3)
  {
    this.UJ = paramSet;
    this.xH = 1;
    this.wp = paramString1;
    this.VE = paramic1;
    this.Vw = paramString2;
    this.VF = paramic2;
    this.Rd = paramString3;
  }
  
  protected boolean a(ga.a parama)
  {
    return this.UJ.contains(Integer.valueOf(parama.ff()));
  }
  
  protected Object aq(String paramString)
  {
    return null;
  }
  
  protected boolean ar(String paramString)
  {
    return false;
  }
  
  protected Object b(ga.a parama)
  {
    switch (parama.ff())
    {
    case 3: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.ff());
    case 2: 
      return this.wp;
    case 4: 
      return this.VE;
    case 5: 
      return this.Vw;
    case 6: 
      return this.VF;
    }
    return this.Rd;
  }
  
  public int describeContents()
  {
    if localif = CREATOR;
    return 0;
  }
  
  public HashMap<String, ga.a<?, ?>> eY()
  {
    return UI;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ie)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (ie)paramObject;
    Iterator localIterator = UI.values().iterator();
    while (localIterator.hasNext())
    {
      ga.a locala = (ga.a)localIterator.next();
      if (a(locala))
      {
        if (((ie)paramObject).a(locala))
        {
          if (!b(locala).equals(((ie)paramObject).b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((ie)paramObject).a(locala)) {
        return false;
      }
    }
    return true;
  }
  
  public String getId()
  {
    return this.wp;
  }
  
  public ItemScope getResult()
  {
    return this.VE;
  }
  
  public String getStartDate()
  {
    return this.Vw;
  }
  
  public ItemScope getTarget()
  {
    return this.VF;
  }
  
  public String getType()
  {
    return this.Rd;
  }
  
  int getVersionCode()
  {
    return this.xH;
  }
  
  public boolean hasId()
  {
    return this.UJ.contains(Integer.valueOf(2));
  }
  
  public boolean hasResult()
  {
    return this.UJ.contains(Integer.valueOf(4));
  }
  
  public boolean hasStartDate()
  {
    return this.UJ.contains(Integer.valueOf(5));
  }
  
  public boolean hasTarget()
  {
    return this.UJ.contains(Integer.valueOf(6));
  }
  
  public boolean hasType()
  {
    return this.UJ.contains(Integer.valueOf(7));
  }
  
  public int hashCode()
  {
    Iterator localIterator = UI.values().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      ga.a locala = (ga.a)localIterator.next();
      if (!a(locala)) {
        break label68;
      }
      int j = locala.ff();
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
  
  Set<Integer> ja()
  {
    return this.UJ;
  }
  
  ic jr()
  {
    return this.VE;
  }
  
  ic js()
  {
    return this.VF;
  }
  
  public ie jt()
  {
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if localif = CREATOR;
    if.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/ie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */