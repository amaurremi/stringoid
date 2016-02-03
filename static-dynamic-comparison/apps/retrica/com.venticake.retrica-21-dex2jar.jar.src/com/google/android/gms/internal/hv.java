package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class hv
  implements SafeParcelable, hy.b<String, Integer>
{
  public static final hw CREATOR = new hw();
  private final HashMap<String, Integer> GW;
  private final HashMap<Integer, String> GX;
  private final ArrayList<hv.a> GY;
  private final int xM;
  
  public hv()
  {
    this.xM = 1;
    this.GW = new HashMap();
    this.GX = new HashMap();
    this.GY = null;
  }
  
  hv(int paramInt, ArrayList<hv.a> paramArrayList)
  {
    this.xM = paramInt;
    this.GW = new HashMap();
    this.GX = new HashMap();
    this.GY = null;
    a(paramArrayList);
  }
  
  private void a(ArrayList<hv.a> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      hv.a locala = (hv.a)paramArrayList.next();
      f(locala.GZ, locala.Ha);
    }
  }
  
  public String a(Integer paramInteger)
  {
    String str = (String)this.GX.get(paramInteger);
    paramInteger = str;
    if (str == null)
    {
      paramInteger = str;
      if (this.GW.containsKey("gms_unknown")) {
        paramInteger = "gms_unknown";
      }
    }
    return paramInteger;
  }
  
  public int describeContents()
  {
    hw localhw = CREATOR;
    return 0;
  }
  
  public hv f(String paramString, int paramInt)
  {
    this.GW.put(paramString, Integer.valueOf(paramInt));
    this.GX.put(Integer.valueOf(paramInt), paramString);
    return this;
  }
  
  ArrayList<hv.a> fD()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.GW.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new hv.a(str, ((Integer)this.GW.get(str)).intValue()));
    }
    return localArrayList;
  }
  
  public int fE()
  {
    return 7;
  }
  
  public int fF()
  {
    return 0;
  }
  
  int getVersionCode()
  {
    return this.xM;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    hw localhw = CREATOR;
    hw.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/hv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */