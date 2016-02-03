package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ib
  implements SafeParcelable
{
  public static final ic CREATOR = new ic();
  private final HashMap<String, HashMap<String, hy.a<?, ?>>> Hl;
  private final ArrayList<ib.a> Hm;
  private final String Hn;
  private final int xM;
  
  ib(int paramInt, ArrayList<ib.a> paramArrayList, String paramString)
  {
    this.xM = paramInt;
    this.Hm = null;
    this.Hl = b(paramArrayList);
    this.Hn = ((String)hm.f(paramString));
    fT();
  }
  
  public ib(Class<? extends hy> paramClass)
  {
    this.xM = 1;
    this.Hm = null;
    this.Hl = new HashMap();
    this.Hn = paramClass.getCanonicalName();
  }
  
  private static HashMap<String, HashMap<String, hy.a<?, ?>>> b(ArrayList<ib.a> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      ib.a locala = (ib.a)paramArrayList.get(i);
      localHashMap.put(locala.className, locala.fX());
      i += 1;
    }
    return localHashMap;
  }
  
  public void a(Class<? extends hy> paramClass, HashMap<String, hy.a<?, ?>> paramHashMap)
  {
    this.Hl.put(paramClass.getCanonicalName(), paramHashMap);
  }
  
  public HashMap<String, hy.a<?, ?>> aJ(String paramString)
  {
    return (HashMap)this.Hl.get(paramString);
  }
  
  public boolean b(Class<? extends hy> paramClass)
  {
    return this.Hl.containsKey(paramClass.getCanonicalName());
  }
  
  public int describeContents()
  {
    ic localic = CREATOR;
    return 0;
  }
  
  public void fT()
  {
    Iterator localIterator1 = this.Hl.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localObject = (HashMap)this.Hl.get(localObject);
      Iterator localIterator2 = ((HashMap)localObject).keySet().iterator();
      while (localIterator2.hasNext()) {
        ((hy.a)((HashMap)localObject).get((String)localIterator2.next())).a(this);
      }
    }
  }
  
  public void fU()
  {
    Iterator localIterator1 = this.Hl.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str1 = (String)localIterator1.next();
      HashMap localHashMap1 = (HashMap)this.Hl.get(str1);
      HashMap localHashMap2 = new HashMap();
      Iterator localIterator2 = localHashMap1.keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str2 = (String)localIterator2.next();
        localHashMap2.put(str2, ((hy.a)localHashMap1.get(str2)).fJ());
      }
      this.Hl.put(str1, localHashMap2);
    }
  }
  
  ArrayList<ib.a> fV()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Hl.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new ib.a(str, (HashMap)this.Hl.get(str)));
    }
    return localArrayList;
  }
  
  public String fW()
  {
    return this.Hn;
  }
  
  int getVersionCode()
  {
    return this.xM;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator1 = this.Hl.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localStringBuilder.append((String)localObject).append(":\n");
      localObject = (HashMap)this.Hl.get(localObject);
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
    ic localic = CREATOR;
    ic.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */