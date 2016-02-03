package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class fx
  implements SafeParcelable, ga.b<String, Integer>
{
  public static final fy CREATOR = new fy();
  private final HashMap<String, Integer> DT;
  private final HashMap<Integer, String> DU;
  private final ArrayList<a> DV;
  private final int xH;
  
  public fx()
  {
    this.xH = 1;
    this.DT = new HashMap();
    this.DU = new HashMap();
    this.DV = null;
  }
  
  fx(int paramInt, ArrayList<a> paramArrayList)
  {
    this.xH = paramInt;
    this.DT = new HashMap();
    this.DU = new HashMap();
    this.DV = null;
    a(paramArrayList);
  }
  
  private void a(ArrayList<a> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      a locala = (a)paramArrayList.next();
      f(locala.DW, locala.DX);
    }
  }
  
  public String a(Integer paramInteger)
  {
    String str = (String)this.DU.get(paramInteger);
    paramInteger = str;
    if (str == null)
    {
      paramInteger = str;
      if (this.DT.containsKey("gms_unknown")) {
        paramInteger = "gms_unknown";
      }
    }
    return paramInteger;
  }
  
  public int describeContents()
  {
    fy localfy = CREATOR;
    return 0;
  }
  
  ArrayList<a> eV()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.DT.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new a(str, ((Integer)this.DT.get(str)).intValue()));
    }
    return localArrayList;
  }
  
  public int eW()
  {
    return 7;
  }
  
  public int eX()
  {
    return 0;
  }
  
  public fx f(String paramString, int paramInt)
  {
    this.DT.put(paramString, Integer.valueOf(paramInt));
    this.DU.put(Integer.valueOf(paramInt), paramString);
    return this;
  }
  
  int getVersionCode()
  {
    return this.xH;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    fy localfy = CREATOR;
    fy.a(this, paramParcel, paramInt);
  }
  
  public static final class a
    implements SafeParcelable
  {
    public static final fz CREATOR = new fz();
    final String DW;
    final int DX;
    final int versionCode;
    
    a(int paramInt1, String paramString, int paramInt2)
    {
      this.versionCode = paramInt1;
      this.DW = paramString;
      this.DX = paramInt2;
    }
    
    a(String paramString, int paramInt)
    {
      this.versionCode = 1;
      this.DW = paramString;
      this.DX = paramInt;
    }
    
    public int describeContents()
    {
      fz localfz = CREATOR;
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      fz localfz = CREATOR;
      fz.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/fx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */