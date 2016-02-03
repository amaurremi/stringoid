package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ev
  implements SafeParcelable
{
  public static final ew CREATOR = new ew();
  private final int kg;
  private final HashMap<String, HashMap<String, es.a<?, ?>>> qs;
  private final ArrayList<a> qt;
  private final String qu;
  
  ev(int paramInt, ArrayList<a> paramArrayList, String paramString)
  {
    this.kg = paramInt;
    this.qt = null;
    this.qs = b(paramArrayList);
    this.qu = ((String)eg.f(paramString));
    cw();
  }
  
  public ev(Class<? extends es> paramClass)
  {
    this.kg = 1;
    this.qt = null;
    this.qs = new HashMap();
    this.qu = paramClass.getCanonicalName();
  }
  
  private static HashMap<String, HashMap<String, es.a<?, ?>>> b(ArrayList<a> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      a locala = (a)paramArrayList.get(i);
      localHashMap.put(locala.className, locala.cA());
      i += 1;
    }
    return localHashMap;
  }
  
  public HashMap<String, es.a<?, ?>> Z(String paramString)
  {
    return (HashMap)this.qs.get(paramString);
  }
  
  public void a(Class<? extends es> paramClass, HashMap<String, es.a<?, ?>> paramHashMap)
  {
    this.qs.put(paramClass.getCanonicalName(), paramHashMap);
  }
  
  public boolean b(Class<? extends es> paramClass)
  {
    return this.qs.containsKey(paramClass.getCanonicalName());
  }
  
  public void cw()
  {
    Iterator localIterator1 = this.qs.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localObject = (HashMap)this.qs.get(localObject);
      Iterator localIterator2 = ((HashMap)localObject).keySet().iterator();
      while (localIterator2.hasNext()) {
        ((es.a)((HashMap)localObject).get((String)localIterator2.next())).a(this);
      }
    }
  }
  
  public void cx()
  {
    Iterator localIterator1 = this.qs.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str1 = (String)localIterator1.next();
      HashMap localHashMap1 = (HashMap)this.qs.get(str1);
      HashMap localHashMap2 = new HashMap();
      Iterator localIterator2 = localHashMap1.keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str2 = (String)localIterator2.next();
        localHashMap2.put(str2, ((es.a)localHashMap1.get(str2)).cm());
      }
      this.qs.put(str1, localHashMap2);
    }
  }
  
  ArrayList<a> cy()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.qs.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new a(str, (HashMap)this.qs.get(str)));
    }
    return localArrayList;
  }
  
  public String cz()
  {
    return this.qu;
  }
  
  public int describeContents()
  {
    ew localew = CREATOR;
    return 0;
  }
  
  int getVersionCode()
  {
    return this.kg;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator1 = this.qs.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localStringBuilder.append((String)localObject).append(":\n");
      localObject = (HashMap)this.qs.get(localObject);
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
    ew localew = CREATOR;
    ew.a(this, paramParcel, paramInt);
  }
  
  public static class a
    implements SafeParcelable
  {
    public static final ex CREATOR = new ex();
    final String className;
    final ArrayList<ev.b> qv;
    final int versionCode;
    
    a(int paramInt, String paramString, ArrayList<ev.b> paramArrayList)
    {
      this.versionCode = paramInt;
      this.className = paramString;
      this.qv = paramArrayList;
    }
    
    a(String paramString, HashMap<String, es.a<?, ?>> paramHashMap)
    {
      this.versionCode = 1;
      this.className = paramString;
      this.qv = b(paramHashMap);
    }
    
    private static ArrayList<ev.b> b(HashMap<String, es.a<?, ?>> paramHashMap)
    {
      if (paramHashMap == null) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localArrayList.add(new ev.b(str, (es.a)paramHashMap.get(str)));
      }
      return localArrayList;
    }
    
    HashMap<String, es.a<?, ?>> cA()
    {
      HashMap localHashMap = new HashMap();
      int j = this.qv.size();
      int i = 0;
      while (i < j)
      {
        ev.b localb = (ev.b)this.qv.get(i);
        localHashMap.put(localb.qw, localb.qx);
        i += 1;
      }
      return localHashMap;
    }
    
    public int describeContents()
    {
      ex localex = CREATOR;
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      ex localex = CREATOR;
      ex.a(this, paramParcel, paramInt);
    }
  }
  
  public static class b
    implements SafeParcelable
  {
    public static final eu CREATOR = new eu();
    final String qw;
    final es.a<?, ?> qx;
    final int versionCode;
    
    b(int paramInt, String paramString, es.a<?, ?> parama)
    {
      this.versionCode = paramInt;
      this.qw = paramString;
      this.qx = parama;
    }
    
    b(String paramString, es.a<?, ?> parama)
    {
      this.versionCode = 1;
      this.qw = paramString;
      this.qx = parama;
    }
    
    public int describeContents()
    {
      eu localeu = CREATOR;
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      eu localeu = CREATOR;
      eu.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/ev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */