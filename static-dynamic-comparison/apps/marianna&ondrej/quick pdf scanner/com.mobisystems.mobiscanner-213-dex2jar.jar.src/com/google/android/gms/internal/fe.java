package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class fe
  implements SafeParcelable
{
  public static final do LO = new do();
  private final HashMap<String, HashMap<String, fb.a<?, ?>>> LP;
  private final ArrayList<a> LQ;
  private final String LR;
  private final int qh;
  
  fe(int paramInt, ArrayList<a> paramArrayList, String paramString)
  {
    this.qh = paramInt;
    this.LQ = null;
    this.LP = b(paramArrayList);
    this.LR = ((String)dc.N(paramString));
    qQ();
  }
  
  private static HashMap<String, HashMap<String, fb.a<?, ?>>> b(ArrayList<a> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      a locala = (a)paramArrayList.get(i);
      localHashMap.put(locala.className, locala.qT());
      i += 1;
    }
    return localHashMap;
  }
  
  public HashMap<String, fb.a<?, ?>> aT(String paramString)
  {
    return (HashMap)this.LP.get(paramString);
  }
  
  public int describeContents()
  {
    do localdo = LO;
    return 0;
  }
  
  int lX()
  {
    return this.qh;
  }
  
  public void qQ()
  {
    Iterator localIterator1 = this.LP.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localObject = (HashMap)this.LP.get(localObject);
      Iterator localIterator2 = ((HashMap)localObject).keySet().iterator();
      while (localIterator2.hasNext()) {
        ((fb.a)((HashMap)localObject).get((String)localIterator2.next())).a(this);
      }
    }
  }
  
  ArrayList<a> qR()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.LP.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new a(str, (HashMap)this.LP.get(str)));
    }
    return localArrayList;
  }
  
  public String qS()
  {
    return this.LR;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator1 = this.LP.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localStringBuilder.append((String)localObject).append(":\n");
      localObject = (HashMap)this.LP.get(localObject);
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
    do localdo = LO;
    do.a(this, paramParcel, paramInt);
  }
  
  public static class a
    implements SafeParcelable
  {
    public static final dp LS = new dp();
    final ArrayList<fe.b> LT;
    final String className;
    final int versionCode;
    
    a(int paramInt, String paramString, ArrayList<fe.b> paramArrayList)
    {
      this.versionCode = paramInt;
      this.className = paramString;
      this.LT = paramArrayList;
    }
    
    a(String paramString, HashMap<String, fb.a<?, ?>> paramHashMap)
    {
      this.versionCode = 1;
      this.className = paramString;
      this.LT = a(paramHashMap);
    }
    
    private static ArrayList<fe.b> a(HashMap<String, fb.a<?, ?>> paramHashMap)
    {
      if (paramHashMap == null) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localArrayList.add(new fe.b(str, (fb.a)paramHashMap.get(str)));
      }
      return localArrayList;
    }
    
    public int describeContents()
    {
      dp localdp = LS;
      return 0;
    }
    
    HashMap<String, fb.a<?, ?>> qT()
    {
      HashMap localHashMap = new HashMap();
      int j = this.LT.size();
      int i = 0;
      while (i < j)
      {
        fe.b localb = (fe.b)this.LT.get(i);
        localHashMap.put(localb.LW, localb.LX);
        i += 1;
      }
      return localHashMap;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      dp localdp = LS;
      dp.a(this, paramParcel, paramInt);
    }
  }
  
  public static class b
    implements SafeParcelable
  {
    public static final dn LV = new dn();
    final String LW;
    final fb.a<?, ?> LX;
    final int versionCode;
    
    b(int paramInt, String paramString, fb.a<?, ?> parama)
    {
      this.versionCode = paramInt;
      this.LW = paramString;
      this.LX = parama;
    }
    
    b(String paramString, fb.a<?, ?> parama)
    {
      this.versionCode = 1;
      this.LW = paramString;
      this.LX = parama;
    }
    
    public int describeContents()
    {
      dn localdn = LV;
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      dn localdn = LV;
      dn.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/fe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */