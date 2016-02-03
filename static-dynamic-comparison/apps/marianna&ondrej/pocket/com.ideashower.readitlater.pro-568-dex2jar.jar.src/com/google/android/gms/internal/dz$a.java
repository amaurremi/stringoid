package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class dz$a
  implements SafeParcelable
{
  public static final aw CREATOR = new aw();
  final int a;
  final String b;
  final ArrayList c;
  
  dz$a(int paramInt, String paramString, ArrayList paramArrayList)
  {
    this.a = paramInt;
    this.b = paramString;
    this.c = paramArrayList;
  }
  
  dz$a(String paramString, HashMap paramHashMap)
  {
    this.a = 1;
    this.b = paramString;
    this.c = a(paramHashMap);
  }
  
  private static ArrayList a(HashMap paramHashMap)
  {
    if (paramHashMap == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new dz.b(str, (dw.a)paramHashMap.get(str)));
    }
    return localArrayList;
  }
  
  HashMap a()
  {
    HashMap localHashMap = new HashMap();
    int j = this.c.size();
    int i = 0;
    while (i < j)
    {
      dz.b localb = (dz.b)this.c.get(i);
      localHashMap.put(localb.b, localb.c);
      i += 1;
    }
    return localHashMap;
  }
  
  public int describeContents()
  {
    aw localaw = CREATOR;
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    aw localaw = CREATOR;
    aw.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/dz$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */