package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ic
  implements SafeParcelable
{
  public static final id CREATOR = new id();
  private final HashMap<String, HashMap<String, hz.a<?, ?>>> Hi;
  private final ArrayList<a> Hj;
  private final String Hk;
  private final int xJ;
  
  ic(int paramInt, ArrayList<a> paramArrayList, String paramString)
  {
    this.xJ = paramInt;
    this.Hj = null;
    this.Hi = b(paramArrayList);
    this.Hk = ((String)hn.f(paramString));
    fO();
  }
  
  public ic(Class<? extends hz> paramClass)
  {
    this.xJ = 1;
    this.Hj = null;
    this.Hi = new HashMap();
    this.Hk = paramClass.getCanonicalName();
  }
  
  private static HashMap<String, HashMap<String, hz.a<?, ?>>> b(ArrayList<a> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      a locala = (a)paramArrayList.get(i);
      localHashMap.put(locala.className, locala.fS());
      i += 1;
    }
    return localHashMap;
  }
  
  public void a(Class<? extends hz> paramClass, HashMap<String, hz.a<?, ?>> paramHashMap)
  {
    this.Hi.put(paramClass.getCanonicalName(), paramHashMap);
  }
  
  public HashMap<String, hz.a<?, ?>> aJ(String paramString)
  {
    return (HashMap)this.Hi.get(paramString);
  }
  
  public boolean b(Class<? extends hz> paramClass)
  {
    return this.Hi.containsKey(paramClass.getCanonicalName());
  }
  
  public int describeContents()
  {
    id localid = CREATOR;
    return 0;
  }
  
  public void fO()
  {
    Iterator localIterator1 = this.Hi.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localObject = (HashMap)this.Hi.get(localObject);
      Iterator localIterator2 = ((HashMap)localObject).keySet().iterator();
      while (localIterator2.hasNext()) {
        ((hz.a)((HashMap)localObject).get((String)localIterator2.next())).a(this);
      }
    }
  }
  
  public void fP()
  {
    Iterator localIterator1 = this.Hi.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str1 = (String)localIterator1.next();
      HashMap localHashMap1 = (HashMap)this.Hi.get(str1);
      HashMap localHashMap2 = new HashMap();
      Iterator localIterator2 = localHashMap1.keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str2 = (String)localIterator2.next();
        localHashMap2.put(str2, ((hz.a)localHashMap1.get(str2)).fE());
      }
      this.Hi.put(str1, localHashMap2);
    }
  }
  
  ArrayList<a> fQ()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Hi.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new a(str, (HashMap)this.Hi.get(str)));
    }
    return localArrayList;
  }
  
  public String fR()
  {
    return this.Hk;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator1 = this.Hi.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localStringBuilder.append((String)localObject).append(":\n");
      localObject = (HashMap)this.Hi.get(localObject);
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
    id localid = CREATOR;
    id.a(this, paramParcel, paramInt);
  }
  
  public static class a
    implements SafeParcelable
  {
    public static final ie CREATOR = new ie();
    final ArrayList<ic.b> Hl;
    final String className;
    final int versionCode;
    
    a(int paramInt, String paramString, ArrayList<ic.b> paramArrayList)
    {
      this.versionCode = paramInt;
      this.className = paramString;
      this.Hl = paramArrayList;
    }
    
    a(String paramString, HashMap<String, hz.a<?, ?>> paramHashMap)
    {
      this.versionCode = 1;
      this.className = paramString;
      this.Hl = a(paramHashMap);
    }
    
    private static ArrayList<ic.b> a(HashMap<String, hz.a<?, ?>> paramHashMap)
    {
      if (paramHashMap == null) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localArrayList.add(new ic.b(str, (hz.a)paramHashMap.get(str)));
      }
      return localArrayList;
    }
    
    public int describeContents()
    {
      ie localie = CREATOR;
      return 0;
    }
    
    HashMap<String, hz.a<?, ?>> fS()
    {
      HashMap localHashMap = new HashMap();
      int j = this.Hl.size();
      int i = 0;
      while (i < j)
      {
        ic.b localb = (ic.b)this.Hl.get(i);
        localHashMap.put(localb.eM, localb.Hm);
        i += 1;
      }
      return localHashMap;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      ie localie = CREATOR;
      ie.a(this, paramParcel, paramInt);
    }
  }
  
  public static class b
    implements SafeParcelable
  {
    public static final ib CREATOR = new ib();
    final hz.a<?, ?> Hm;
    final String eM;
    final int versionCode;
    
    b(int paramInt, String paramString, hz.a<?, ?> parama)
    {
      this.versionCode = paramInt;
      this.eM = paramString;
      this.Hm = parama;
    }
    
    b(String paramString, hz.a<?, ?> parama)
    {
      this.versionCode = 1;
      this.eM = paramString;
      this.Hm = parama;
    }
    
    public int describeContents()
    {
      ib localib = CREATOR;
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      ib localib = CREATOR;
      ib.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */