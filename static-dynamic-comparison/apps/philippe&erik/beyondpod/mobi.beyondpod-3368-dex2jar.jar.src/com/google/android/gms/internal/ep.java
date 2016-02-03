package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class ep
  implements SafeParcelable, es.b<String, Integer>
{
  public static final eq CREATOR = new eq();
  private final int kg;
  private final HashMap<String, Integer> qd;
  private final HashMap<Integer, String> qe;
  private final ArrayList<a> qf;
  
  public ep()
  {
    this.kg = 1;
    this.qd = new HashMap();
    this.qe = new HashMap();
    this.qf = null;
  }
  
  ep(int paramInt, ArrayList<a> paramArrayList)
  {
    this.kg = paramInt;
    this.qd = new HashMap();
    this.qe = new HashMap();
    this.qf = null;
    a(paramArrayList);
  }
  
  private void a(ArrayList<a> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      a locala = (a)paramArrayList.next();
      c(locala.qg, locala.qh);
    }
  }
  
  public String a(Integer paramInteger)
  {
    String str = (String)this.qe.get(paramInteger);
    paramInteger = str;
    if (str == null)
    {
      paramInteger = str;
      if (this.qd.containsKey("gms_unknown")) {
        paramInteger = "gms_unknown";
      }
    }
    return paramInteger;
  }
  
  public ep c(String paramString, int paramInt)
  {
    this.qd.put(paramString, Integer.valueOf(paramInt));
    this.qe.put(Integer.valueOf(paramInt), paramString);
    return this;
  }
  
  ArrayList<a> cg()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.qd.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new a(str, ((Integer)this.qd.get(str)).intValue()));
    }
    return localArrayList;
  }
  
  public int ch()
  {
    return 7;
  }
  
  public int ci()
  {
    return 0;
  }
  
  public int describeContents()
  {
    eq localeq = CREATOR;
    return 0;
  }
  
  int getVersionCode()
  {
    return this.kg;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    eq localeq = CREATOR;
    eq.a(this, paramParcel, paramInt);
  }
  
  public static final class a
    implements SafeParcelable
  {
    public static final er CREATOR = new er();
    final String qg;
    final int qh;
    final int versionCode;
    
    a(int paramInt1, String paramString, int paramInt2)
    {
      this.versionCode = paramInt1;
      this.qg = paramString;
      this.qh = paramInt2;
    }
    
    a(String paramString, int paramInt)
    {
      this.versionCode = 1;
      this.qg = paramString;
      this.qh = paramInt;
    }
    
    public int describeContents()
    {
      er localer = CREATOR;
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      er localer = CREATOR;
      er.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/ep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */