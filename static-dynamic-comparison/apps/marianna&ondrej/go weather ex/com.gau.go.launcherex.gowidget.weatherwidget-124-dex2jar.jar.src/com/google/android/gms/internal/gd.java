package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class gd
  implements SafeParcelable
{
  public static final ge CREATOR = new ge();
  private final HashMap<String, HashMap<String, ga.a<?, ?>>> Ei;
  private final ArrayList<a> Ej;
  private final String Ek;
  private final int xH;
  
  gd(int paramInt, ArrayList<a> paramArrayList, String paramString)
  {
    this.xH = paramInt;
    this.Ej = null;
    this.Ei = b(paramArrayList);
    this.Ek = ((String)fq.f(paramString));
    fl();
  }
  
  public gd(Class<? extends ga> paramClass)
  {
    this.xH = 1;
    this.Ej = null;
    this.Ei = new HashMap();
    this.Ek = paramClass.getCanonicalName();
  }
  
  private static HashMap<String, HashMap<String, ga.a<?, ?>>> b(ArrayList<a> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      a locala = (a)paramArrayList.get(i);
      localHashMap.put(locala.className, locala.fp());
      i += 1;
    }
    return localHashMap;
  }
  
  public void a(Class<? extends ga> paramClass, HashMap<String, ga.a<?, ?>> paramHashMap)
  {
    this.Ei.put(paramClass.getCanonicalName(), paramHashMap);
  }
  
  public HashMap<String, ga.a<?, ?>> au(String paramString)
  {
    return (HashMap)this.Ei.get(paramString);
  }
  
  public boolean b(Class<? extends ga> paramClass)
  {
    return this.Ei.containsKey(paramClass.getCanonicalName());
  }
  
  public int describeContents()
  {
    ge localge = CREATOR;
    return 0;
  }
  
  public void fl()
  {
    Iterator localIterator1 = this.Ei.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localObject = (HashMap)this.Ei.get(localObject);
      Iterator localIterator2 = ((HashMap)localObject).keySet().iterator();
      while (localIterator2.hasNext()) {
        ((ga.a)((HashMap)localObject).get((String)localIterator2.next())).a(this);
      }
    }
  }
  
  public void fm()
  {
    Iterator localIterator1 = this.Ei.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str1 = (String)localIterator1.next();
      HashMap localHashMap1 = (HashMap)this.Ei.get(str1);
      HashMap localHashMap2 = new HashMap();
      Iterator localIterator2 = localHashMap1.keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str2 = (String)localIterator2.next();
        localHashMap2.put(str2, ((ga.a)localHashMap1.get(str2)).fb());
      }
      this.Ei.put(str1, localHashMap2);
    }
  }
  
  ArrayList<a> fn()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Ei.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new a(str, (HashMap)this.Ei.get(str)));
    }
    return localArrayList;
  }
  
  public String fo()
  {
    return this.Ek;
  }
  
  int getVersionCode()
  {
    return this.xH;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator1 = this.Ei.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localStringBuilder.append((String)localObject).append(":\n");
      localObject = (HashMap)this.Ei.get(localObject);
      Iterator localIterator2 = ((HashMap)localObject).keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        localStringBuilder.append("  ").append(str).append(": ");
        localStringBuilder.append(((HashMap)localObject).get(str));
      }
    }
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ge localge = CREATOR;
    ge.a(this, paramParcel, paramInt);
  }
  
  public static class a
    implements SafeParcelable
  {
    public static final gf CREATOR = new gf();
    final ArrayList<gd.b> El;
    final String className;
    final int versionCode;
    
    a(int paramInt, String paramString, ArrayList<gd.b> paramArrayList)
    {
      this.versionCode = paramInt;
      this.className = paramString;
      this.El = paramArrayList;
    }
    
    a(String paramString, HashMap<String, ga.a<?, ?>> paramHashMap)
    {
      this.versionCode = 1;
      this.className = paramString;
      this.El = b(paramHashMap);
    }
    
    private static ArrayList<gd.b> b(HashMap<String, ga.a<?, ?>> paramHashMap)
    {
      if (paramHashMap == null) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localArrayList.add(new gd.b(str, (ga.a)paramHashMap.get(str)));
      }
      return localArrayList;
    }
    
    public int describeContents()
    {
      gf localgf = CREATOR;
      return 0;
    }
    
    HashMap<String, ga.a<?, ?>> fp()
    {
      HashMap localHashMap = new HashMap();
      int j = this.El.size();
      int i = 0;
      while (i < j)
      {
        gd.b localb = (gd.b)this.El.get(i);
        localHashMap.put(localb.eM, localb.Em);
        i += 1;
      }
      return localHashMap;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      gf localgf = CREATOR;
      gf.a(this, paramParcel, paramInt);
    }
  }
  
  public static class b
    implements SafeParcelable
  {
    public static final gc CREATOR = new gc();
    final ga.a<?, ?> Em;
    final String eM;
    final int versionCode;
    
    b(int paramInt, String paramString, ga.a<?, ?> parama)
    {
      this.versionCode = paramInt;
      this.eM = paramString;
      this.Em = parama;
    }
    
    b(String paramString, ga.a<?, ?> parama)
    {
      this.versionCode = 1;
      this.eM = paramString;
      this.Em = parama;
    }
    
    public int describeContents()
    {
      gc localgc = CREATOR;
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      gc localgc = CREATOR;
      gc.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/gd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */