package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class ey
  implements SafeParcelable, fb.b<String, Integer>
{
  public static final dj HI = new dj();
  private final HashMap<String, Integer> HJ;
  private final HashMap<Integer, String> HK;
  private final ArrayList<a> HL;
  private final int qh;
  
  public ey()
  {
    this.qh = 1;
    this.HJ = new HashMap();
    this.HK = new HashMap();
    this.HL = null;
  }
  
  ey(int paramInt, ArrayList<a> paramArrayList)
  {
    this.qh = paramInt;
    this.HJ = new HashMap();
    this.HK = new HashMap();
    this.HL = null;
    a(paramArrayList);
  }
  
  private void a(ArrayList<a> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      a locala = (a)paramArrayList.next();
      d(locala.HN, locala.HO);
    }
  }
  
  public String b(Integer paramInteger)
  {
    String str = (String)this.HK.get(paramInteger);
    paramInteger = str;
    if (str == null)
    {
      paramInteger = str;
      if (this.HJ.containsKey("gms_unknown")) {
        paramInteger = "gms_unknown";
      }
    }
    return paramInteger;
  }
  
  public ey d(String paramString, int paramInt)
  {
    this.HJ.put(paramString, Integer.valueOf(paramInt));
    this.HK.put(Integer.valueOf(paramInt), paramString);
    return this;
  }
  
  public int describeContents()
  {
    dj localdj = HI;
    return 0;
  }
  
  int lX()
  {
    return this.qh;
  }
  
  ArrayList<a> qB()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.HJ.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new a(str, ((Integer)this.HJ.get(str)).intValue()));
    }
    return localArrayList;
  }
  
  public int qC()
  {
    return 7;
  }
  
  public int qD()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    dj localdj = HI;
    dj.a(this, paramParcel, paramInt);
  }
  
  public static final class a
    implements SafeParcelable
  {
    public static final dl HM = new dl();
    final String HN;
    final int HO;
    final int versionCode;
    
    a(int paramInt1, String paramString, int paramInt2)
    {
      this.versionCode = paramInt1;
      this.HN = paramString;
      this.HO = paramInt2;
    }
    
    a(String paramString, int paramInt)
    {
      this.versionCode = 1;
      this.HN = paramString;
      this.HO = paramInt;
    }
    
    public int describeContents()
    {
      dl localdl = HM;
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      dl localdl = HM;
      dl.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/ey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */