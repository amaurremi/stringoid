package com.google.android.gms.tagmanager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataLayer
{
  public static final String EVENT_KEY = "event";
  public static final Object OBJECT_NOT_PRESENT = new Object();
  static final String[] aeV = "gtm.lifetime".toString().split("\\.");
  private static final Pattern aeW = Pattern.compile("(\\d+)\\s*([smhd]?)");
  private final ConcurrentHashMap<b, Integer> aeX;
  private final Map<String, Object> aeY;
  private final ReentrantLock aeZ;
  private final LinkedList<Map<String, Object>> afa;
  private final c afb;
  private final CountDownLatch afc;
  
  DataLayer()
  {
    this(new c()
    {
      public void a(DataLayer.c.a paramAnonymousa)
      {
        paramAnonymousa.d(new ArrayList());
      }
      
      public void a(List<DataLayer.a> paramAnonymousList, long paramAnonymousLong) {}
      
      public void bP(String paramAnonymousString) {}
    });
  }
  
  DataLayer(c paramc)
  {
    this.afb = paramc;
    this.aeX = new ConcurrentHashMap();
    this.aeY = new HashMap();
    this.aeZ = new ReentrantLock();
    this.afa = new LinkedList();
    this.afc = new CountDownLatch(1);
    lt();
  }
  
  private void A(Map<String, Object> paramMap)
  {
    Long localLong = B(paramMap);
    if (localLong == null) {
      return;
    }
    paramMap = D(paramMap);
    paramMap.remove("gtm.lifetime");
    this.afb.a(paramMap, localLong.longValue());
  }
  
  private Long B(Map<String, Object> paramMap)
  {
    paramMap = C(paramMap);
    if (paramMap == null) {
      return null;
    }
    return bO(paramMap.toString());
  }
  
  private Object C(Map<String, Object> paramMap)
  {
    String[] arrayOfString = aeV;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      Object localObject = paramMap;
      if (i < j)
      {
        localObject = arrayOfString[i];
        if (!(paramMap instanceof Map)) {
          localObject = null;
        }
      }
      else
      {
        return localObject;
      }
      paramMap = ((Map)paramMap).get(localObject);
      i += 1;
    }
  }
  
  private List<a> D(Map<String, Object> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    a(paramMap, "", localArrayList);
    return localArrayList;
  }
  
  private void E(Map<String, Object> paramMap)
  {
    synchronized (this.aeY)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        a(c(str, paramMap.get(str)), this.aeY);
      }
    }
    F(paramMap);
  }
  
  private void F(Map<String, Object> paramMap)
  {
    Iterator localIterator = this.aeX.keySet().iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).x(paramMap);
    }
  }
  
  private void a(Map<String, Object> paramMap, String paramString, Collection<a> paramCollection)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder().append(paramString);
      if (paramString.length() == 0) {}
      for (paramMap = "";; paramMap = ".")
      {
        paramMap = paramMap + (String)localEntry.getKey();
        if (!(localEntry.getValue() instanceof Map)) {
          break label119;
        }
        a((Map)localEntry.getValue(), paramMap, paramCollection);
        break;
      }
      label119:
      if (!paramMap.equals("gtm.lifetime")) {
        paramCollection.add(new a(paramMap, localEntry.getValue()));
      }
    }
  }
  
  static Long bO(String paramString)
  {
    Object localObject = aeW.matcher(paramString);
    if (!((Matcher)localObject).matches())
    {
      bh.B("unknown _lifetime: " + paramString);
      return null;
    }
    long l;
    try
    {
      l = Long.parseLong(((Matcher)localObject).group(1));
      if (l <= 0L)
      {
        bh.B("non-positive _lifetime: " + paramString);
        return null;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        bh.D("illegal number in _lifetime value: " + paramString);
        l = 0L;
      }
      localObject = ((Matcher)localObject).group(2);
      if (((String)localObject).length() == 0) {
        return Long.valueOf(l);
      }
      switch (((String)localObject).charAt(0))
      {
      default: 
        bh.D("unknown units in _lifetime: " + paramString);
        return null;
      }
    }
    return Long.valueOf(l * 1000L);
    return Long.valueOf(l * 1000L * 60L);
    return Long.valueOf(l * 1000L * 60L * 60L);
    return Long.valueOf(l * 1000L * 60L * 60L * 24L);
  }
  
  public static List<Object> listOf(Object... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramVarArgs.length)
    {
      localArrayList.add(paramVarArgs[i]);
      i += 1;
    }
    return localArrayList;
  }
  
  private void lt()
  {
    this.afb.a(new DataLayer.c.a()
    {
      public void d(List<DataLayer.a> paramAnonymousList)
      {
        paramAnonymousList = paramAnonymousList.iterator();
        while (paramAnonymousList.hasNext())
        {
          DataLayer.a locala = (DataLayer.a)paramAnonymousList.next();
          DataLayer.a(DataLayer.this, DataLayer.this.c(locala.JI, locala.afe));
        }
        DataLayer.a(DataLayer.this).countDown();
      }
    });
  }
  
  private void lu()
  {
    int i = 0;
    for (;;)
    {
      Map localMap = (Map)this.afa.poll();
      if (localMap != null)
      {
        E(localMap);
        i += 1;
        if (i > 500)
        {
          this.afa.clear();
          throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
        }
      }
      else
      {
        return;
      }
    }
  }
  
  public static Map<String, Object> mapOf(Object... paramVarArgs)
  {
    if (paramVarArgs.length % 2 != 0) {
      throw new IllegalArgumentException("expected even number of key-value pairs");
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramVarArgs.length)
    {
      if (!(paramVarArgs[i] instanceof String)) {
        throw new IllegalArgumentException("key is not a string: " + paramVarArgs[i]);
      }
      localHashMap.put((String)paramVarArgs[i], paramVarArgs[(i + 1)]);
      i += 2;
    }
    return localHashMap;
  }
  
  private void z(Map<String, Object> paramMap)
  {
    this.aeZ.lock();
    try
    {
      this.afa.offer(paramMap);
      if (this.aeZ.getHoldCount() == 1) {
        lu();
      }
      A(paramMap);
      return;
    }
    finally
    {
      this.aeZ.unlock();
    }
  }
  
  void a(b paramb)
  {
    this.aeX.put(paramb, Integer.valueOf(0));
  }
  
  void a(List<Object> paramList1, List<Object> paramList2)
  {
    while (paramList2.size() < paramList1.size()) {
      paramList2.add(null);
    }
    int i = 0;
    if (i < paramList1.size())
    {
      Object localObject = paramList1.get(i);
      if ((localObject instanceof List))
      {
        if (!(paramList2.get(i) instanceof List)) {
          paramList2.set(i, new ArrayList());
        }
        a((List)localObject, (List)paramList2.get(i));
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof Map))
        {
          if (!(paramList2.get(i) instanceof Map)) {
            paramList2.set(i, new HashMap());
          }
          a((Map)localObject, (Map)paramList2.get(i));
        }
        else if (localObject != OBJECT_NOT_PRESENT)
        {
          paramList2.set(i, localObject);
        }
      }
    }
  }
  
  void a(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    Iterator localIterator = paramMap1.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramMap1.get(str);
      if ((localObject instanceof List))
      {
        if (!(paramMap2.get(str) instanceof List)) {
          paramMap2.put(str, new ArrayList());
        }
        a((List)localObject, (List)paramMap2.get(str));
      }
      else if ((localObject instanceof Map))
      {
        if (!(paramMap2.get(str) instanceof Map)) {
          paramMap2.put(str, new HashMap());
        }
        a((Map)localObject, (Map)paramMap2.get(str));
      }
      else
      {
        paramMap2.put(str, localObject);
      }
    }
  }
  
  void bN(String paramString)
  {
    push(paramString, null);
    this.afb.bP(paramString);
  }
  
  Map<String, Object> c(String paramString, Object paramObject)
  {
    HashMap localHashMap1 = new HashMap();
    String[] arrayOfString = paramString.toString().split("\\.");
    int i = 0;
    HashMap localHashMap2;
    for (paramString = localHashMap1; i < arrayOfString.length - 1; paramString = localHashMap2)
    {
      localHashMap2 = new HashMap();
      paramString.put(arrayOfString[i], localHashMap2);
      i += 1;
    }
    paramString.put(arrayOfString[(arrayOfString.length - 1)], paramObject);
    return localHashMap1;
  }
  
  public Object get(String paramString)
  {
    for (;;)
    {
      int i;
      synchronized (this.aeY)
      {
        Map localMap1 = this.aeY;
        String[] arrayOfString = paramString.split("\\.");
        int j = arrayOfString.length;
        paramString = localMap1;
        i = 0;
        if (i < j)
        {
          localMap1 = arrayOfString[i];
          if (!(paramString instanceof Map)) {
            return null;
          }
          paramString = ((Map)paramString).get(localMap1);
          if (paramString == null) {
            return null;
          }
        }
        else
        {
          return paramString;
        }
      }
      i += 1;
    }
  }
  
  public void push(String paramString, Object paramObject)
  {
    push(c(paramString, paramObject));
  }
  
  public void push(Map<String, Object> paramMap)
  {
    try
    {
      this.afc.await();
      z(paramMap);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        bh.D("DataLayer.push: unexpected InterruptedException");
      }
    }
  }
  
  public void pushEvent(String paramString, Map<String, Object> paramMap)
  {
    paramMap = new HashMap(paramMap);
    paramMap.put("event", paramString);
    push(paramMap);
  }
  
  static final class a
  {
    public final String JI;
    public final Object afe;
    
    a(String paramString, Object paramObject)
    {
      this.JI = paramString;
      this.afe = paramObject;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof a)) {}
      do
      {
        return false;
        paramObject = (a)paramObject;
      } while ((!this.JI.equals(((a)paramObject).JI)) || (!this.afe.equals(((a)paramObject).afe)));
      return true;
    }
    
    public int hashCode()
    {
      return Arrays.hashCode(new Integer[] { Integer.valueOf(this.JI.hashCode()), Integer.valueOf(this.afe.hashCode()) });
    }
    
    public String toString()
    {
      return "Key: " + this.JI + " value: " + this.afe.toString();
    }
  }
  
  static abstract interface b
  {
    public abstract void x(Map<String, Object> paramMap);
  }
  
  static abstract interface c
  {
    public abstract void a(a parama);
    
    public abstract void a(List<DataLayer.a> paramList, long paramLong);
    
    public abstract void bP(String paramString);
    
    public static abstract interface a
    {
      public abstract void d(List<DataLayer.a> paramList);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/DataLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */