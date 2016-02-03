package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class jf
  implements SafeParcelable, ji.b<String, Integer>
{
  public static final jg CREATOR = new jg();
  private final int BR;
  private final HashMap<String, Integer> Ml;
  private final HashMap<Integer, String> Mm;
  private final ArrayList<a> Mn;
  
  public jf()
  {
    this.BR = 1;
    this.Ml = new HashMap();
    this.Mm = new HashMap();
    this.Mn = null;
  }
  
  jf(int paramInt, ArrayList<a> paramArrayList)
  {
    this.BR = paramInt;
    this.Ml = new HashMap();
    this.Mm = new HashMap();
    this.Mn = null;
    b(paramArrayList);
  }
  
  private void b(ArrayList<a> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      a locala = (a)paramArrayList.next();
      h(locala.Mo, locala.Mp);
    }
  }
  
  public String a(Integer paramInteger)
  {
    String str = (String)this.Mm.get(paramInteger);
    paramInteger = str;
    if (str == null)
    {
      paramInteger = str;
      if (this.Ml.containsKey("gms_unknown")) {
        paramInteger = "gms_unknown";
      }
    }
    return paramInteger;
  }
  
  public int describeContents()
  {
    jg localjg = CREATOR;
    return 0;
  }
  
  int getVersionCode()
  {
    return this.BR;
  }
  
  public jf h(String paramString, int paramInt)
  {
    this.Ml.put(paramString, Integer.valueOf(paramInt));
    this.Mm.put(Integer.valueOf(paramInt), paramString);
    return this;
  }
  
  ArrayList<a> hc()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Ml.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new a(str, ((Integer)this.Ml.get(str)).intValue()));
    }
    return localArrayList;
  }
  
  public int hd()
  {
    return 7;
  }
  
  public int he()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    jg localjg = CREATOR;
    jg.a(this, paramParcel, paramInt);
  }
  
  public static final class a
    implements SafeParcelable
  {
    public static final jh CREATOR = new jh();
    final String Mo;
    final int Mp;
    final int versionCode;
    
    a(int paramInt1, String paramString, int paramInt2)
    {
      this.versionCode = paramInt1;
      this.Mo = paramString;
      this.Mp = paramInt2;
    }
    
    a(String paramString, int paramInt)
    {
      this.versionCode = 1;
      this.Mo = paramString;
      this.Mp = paramInt;
    }
    
    public int describeContents()
    {
      jh localjh = CREATOR;
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      jh localjh = CREATOR;
      jh.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/jf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */