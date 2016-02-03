package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class dt
  implements SafeParcelable, as
{
  public static final aq CREATOR = new aq();
  private final int a;
  private final HashMap b;
  private final HashMap c;
  private final ArrayList d;
  
  public dt()
  {
    this.a = 1;
    this.b = new HashMap();
    this.c = new HashMap();
    this.d = null;
  }
  
  dt(int paramInt, ArrayList paramArrayList)
  {
    this.a = paramInt;
    this.b = new HashMap();
    this.c = new HashMap();
    this.d = null;
    a(paramArrayList);
  }
  
  private void a(ArrayList paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      dt.a locala = (dt.a)paramArrayList.next();
      a(locala.b, locala.c);
    }
  }
  
  int a()
  {
    return this.a;
  }
  
  public dt a(String paramString, int paramInt)
  {
    this.b.put(paramString, Integer.valueOf(paramInt));
    this.c.put(Integer.valueOf(paramInt), paramString);
    return this;
  }
  
  public String a(Integer paramInteger)
  {
    String str = (String)this.c.get(paramInteger);
    paramInteger = str;
    if (str == null)
    {
      paramInteger = str;
      if (this.b.containsKey("gms_unknown")) {
        paramInteger = "gms_unknown";
      }
    }
    return paramInteger;
  }
  
  ArrayList b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new dt.a(str, ((Integer)this.b.get(str)).intValue()));
    }
    return localArrayList;
  }
  
  public int c()
  {
    return 7;
  }
  
  public int d()
  {
    return 0;
  }
  
  public int describeContents()
  {
    aq localaq = CREATOR;
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    aq localaq = CREATOR;
    aq.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/dt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */