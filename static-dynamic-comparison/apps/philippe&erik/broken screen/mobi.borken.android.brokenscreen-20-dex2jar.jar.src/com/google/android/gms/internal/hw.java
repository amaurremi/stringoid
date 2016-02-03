package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class hw
  implements SafeParcelable, hz.b<String, Integer>
{
  public static final hx CREATOR = new hx();
  private final HashMap<String, Integer> GT;
  private final HashMap<Integer, String> GU;
  private final ArrayList<a> GV;
  private final int xJ;
  
  public hw()
  {
    this.xJ = 1;
    this.GT = new HashMap();
    this.GU = new HashMap();
    this.GV = null;
  }
  
  hw(int paramInt, ArrayList<a> paramArrayList)
  {
    this.xJ = paramInt;
    this.GT = new HashMap();
    this.GU = new HashMap();
    this.GV = null;
    a(paramArrayList);
  }
  
  private void a(ArrayList<a> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      a locala = (a)paramArrayList.next();
      f(locala.GW, locala.GX);
    }
  }
  
  public String a(Integer paramInteger)
  {
    String str = (String)this.GU.get(paramInteger);
    paramInteger = str;
    if (str == null)
    {
      paramInteger = str;
      if (this.GT.containsKey("gms_unknown")) {
        paramInteger = "gms_unknown";
      }
    }
    return paramInteger;
  }
  
  public int describeContents()
  {
    hx localhx = CREATOR;
    return 0;
  }
  
  public hw f(String paramString, int paramInt)
  {
    this.GT.put(paramString, Integer.valueOf(paramInt));
    this.GU.put(Integer.valueOf(paramInt), paramString);
    return this;
  }
  
  public int fA()
  {
    return 0;
  }
  
  ArrayList<a> fy()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.GT.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new a(str, ((Integer)this.GT.get(str)).intValue()));
    }
    return localArrayList;
  }
  
  public int fz()
  {
    return 7;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    hx localhx = CREATOR;
    hx.a(this, paramParcel, paramInt);
  }
  
  public static final class a
    implements SafeParcelable
  {
    public static final hy CREATOR = new hy();
    final String GW;
    final int GX;
    final int versionCode;
    
    a(int paramInt1, String paramString, int paramInt2)
    {
      this.versionCode = paramInt1;
      this.GW = paramString;
      this.GX = paramInt2;
    }
    
    a(String paramString, int paramInt)
    {
      this.versionCode = 1;
      this.GW = paramString;
      this.GX = paramInt;
    }
    
    public int describeContents()
    {
      hy localhy = CREATOR;
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      hy localhy = CREATOR;
      hy.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/hw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */