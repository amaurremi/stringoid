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

public class c
{
  public static final Object Ws = new Object();
  static final String[] Wt = "gtm.lifetime".toString().split("\\.");
  private static final Pattern Wu = Pattern.compile("(\\d+)\\s*([smhd]?)");
  private final CountDownLatch WA;
  private final ConcurrentHashMap<b, Integer> Wv;
  private final Map<String, Object> Ww;
  private final ReentrantLock Wx;
  private final LinkedList<Map<String, Object>> Wy;
  private final c Wz;
  
  c()
  {
    this(new c()
    {
      public void a(c.c.a paramAnonymousa)
      {
        paramAnonymousa.e(new ArrayList());
      }
      
      public void a(List<c.a> paramAnonymousList, long paramAnonymousLong) {}
    });
  }
  
  c(c paramc)
  {
    this.Wz = paramc;
    this.Wv = new ConcurrentHashMap();
    this.Ww = new HashMap();
    this.Wx = new ReentrantLock();
    this.Wy = new LinkedList();
    this.WA = new CountDownLatch(1);
    vF();
  }
  
  private void D(Map<String, Object> paramMap)
  {
    this.Wx.lock();
    try
    {
      this.Wy.offer(paramMap);
      if (this.Wx.getHoldCount() == 1) {
        vG();
      }
      E(paramMap);
      return;
    }
    finally
    {
      this.Wx.unlock();
    }
  }
  
  private void E(Map<String, Object> paramMap)
  {
    Long localLong = F(paramMap);
    if (localLong == null) {
      return;
    }
    paramMap = H(paramMap);
    paramMap.remove("gtm.lifetime");
    this.Wz.a(paramMap, localLong.longValue());
  }
  
  private Long F(Map<String, Object> paramMap)
  {
    paramMap = G(paramMap);
    if (paramMap == null) {
      return null;
    }
    return bm(paramMap.toString());
  }
  
  private Object G(Map<String, Object> paramMap)
  {
    String[] arrayOfString = Wt;
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
  
  private List<a> H(Map<String, Object> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    a(paramMap, "", localArrayList);
    return localArrayList;
  }
  
  private void I(Map<String, Object> paramMap)
  {
    synchronized (this.Ww)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        a(b(str, paramMap.get(str)), this.Ww);
      }
    }
    J(paramMap);
  }
  
  private void J(Map<String, Object> paramMap)
  {
    Iterator localIterator = this.Wv.keySet().iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).K(paramMap);
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
  
  static Long bm(String paramString)
  {
    Object localObject = Wu.matcher(paramString);
    if (!((Matcher)localObject).matches())
    {
      j.aa("unknown _lifetime: " + paramString);
      return null;
    }
    long l;
    try
    {
      l = Long.parseLong(((Matcher)localObject).group(1));
      if (l <= 0L)
      {
        j.aa("non-positive _lifetime: " + paramString);
        return null;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        j.D("illegal number in _lifetime value: " + paramString);
        l = 0L;
      }
      localObject = ((Matcher)localObject).group(2);
      if (((String)localObject).length() == 0) {
        return Long.valueOf(l);
      }
      switch (((String)localObject).charAt(0))
      {
      default: 
        j.D("unknown units in _lifetime: " + paramString);
        return null;
      }
    }
    return Long.valueOf(l * 1000L);
    return Long.valueOf(l * 1000L * 60L);
    return Long.valueOf(l * 1000L * 60L * 60L);
    return Long.valueOf(l * 1000L * 60L * 60L * 24L);
  }
  
  private void vF()
  {
    this.Wz.a(new c.c.a()
    {
      public void e(List<c.a> paramAnonymousList)
      {
        paramAnonymousList = paramAnonymousList.iterator();
        while (paramAnonymousList.hasNext())
        {
          c.a locala = (c.a)paramAnonymousList.next();
          c.a(c.this, c.this.b(locala.WC, locala.WD));
        }
        c.a(c.this).countDown();
      }
    });
  }
  
  private void vG()
  {
    int i = 0;
    for (;;)
    {
      Map localMap = (Map)this.Wy.poll();
      if (localMap != null)
      {
        I(localMap);
        i += 1;
        if (i > 500)
        {
          this.Wy.clear();
          throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
        }
      }
      else
      {
        return;
      }
    }
  }
  
  public void C(Map<String, Object> paramMap)
  {
    try
    {
      this.WA.await();
      D(paramMap);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        j.D("DataLayer.push: unexpected InterruptedException");
      }
    }
  }
  
  void a(b paramb)
  {
    this.Wv.put(paramb, Integer.valueOf(0));
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
        else if (localObject != Ws)
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
  
  Map<String, Object> b(String paramString, Object paramObject)
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
  
  static final class a
  {
    public final String WC;
    public final Object WD;
    
    a(String paramString, Object paramObject)
    {
      this.WC = paramString;
      this.WD = paramObject;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof a)) {}
      do
      {
        return false;
        paramObject = (a)paramObject;
      } while ((!this.WC.equals(((a)paramObject).WC)) || (!this.WD.equals(((a)paramObject).WD)));
      return true;
    }
    
    public int hashCode()
    {
      return Arrays.hashCode(new Integer[] { Integer.valueOf(this.WC.hashCode()), Integer.valueOf(this.WD.hashCode()) });
    }
    
    public String toString()
    {
      return "Key: " + this.WC + " value: " + this.WD.toString();
    }
  }
  
  static abstract interface b
  {
    public abstract void K(Map<String, Object> paramMap);
  }
  
  static abstract interface c
  {
    public abstract void a(a parama);
    
    public abstract void a(List<c.a> paramList, long paramLong);
    
    public static abstract interface a
    {
      public abstract void e(List<c.a> paramList);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/tagmanager/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */