package com.flurry.android.monolithic.sdk.impl;

import com.flurry.android.impl.ads.avro.protocol.v6.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v6.AdSpaceLayout;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ad
{
  private static final String a = ad.class.getSimpleName();
  private bz b = new bz();
  private cb c = new cb();
  private int d = 0;
  private final Map<String, Integer> e = new HashMap();
  
  public ad()
  {
    this.b.a(this.c);
  }
  
  public List<AdUnit> a(String paramString, int paramInt1, int paramInt2)
  {
    label294:
    label299:
    for (;;)
    {
      Object localObject2;
      try
      {
        int i = je.f();
        localObject2 = this.b.a(paramString, i);
        Object localObject1 = localObject2;
        paramInt1 = i;
        if (b((List)localObject2))
        {
          ja.a(3, a, "no valid ad units in cache for current orientation for " + paramString);
          if (i == 1)
          {
            paramInt1 = 2;
            localObject1 = this.b.a(paramString, paramInt1);
            if ((!b((List)localObject1)) && (a((AdUnit)((List)localObject1).get(0)))) {
              break label299;
            }
            ja.a(3, a, "no valid ad units in cache for other orientation for " + paramString);
            break label299;
          }
        }
        else
        {
          localObject2 = new ArrayList();
          if (localObject1 == null) {
            break label294;
          }
          localObject1 = ((List)localObject1).iterator();
          if ((!((Iterator)localObject1).hasNext()) || (((List)localObject2).size() > paramInt2)) {
            break label294;
          }
          AdUnit localAdUnit = (AdUnit)((Iterator)localObject1).next();
          if ((!je.a(localAdUnit.c().longValue())) || (localAdUnit.e().intValue() != 1) || (localAdUnit.d().size() <= 0)) {
            continue;
          }
          ((List)localObject2).add(localAdUnit);
          boolean bool = this.b.b(paramString, paramInt1, localAdUnit);
          ja.a(3, a, "Ad unit was removed = " + bool);
          continue;
        }
        paramInt1 = 1;
      }
      finally {}
      continue;
      return (List<AdUnit>)localObject2;
    }
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (paramString.length() > 0)
      {
        int i = je.f();
        this.d = this.b.b(paramString, i);
        this.e.put(paramString, Integer.valueOf(this.d));
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      int i = je.f();
      this.b.a(paramString, i, paramInt);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      int i = je.f();
      this.b.a(paramString1, i, paramString2);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(List<AdUnit> paramList)
  {
    try
    {
      int i = je.f();
      ja.a(3, a, "putting " + paramList.size() + " orientation: " + i);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        AdUnit localAdUnit = (AdUnit)paramList.next();
        if (localAdUnit.g().length() > 0)
        {
          localObject = new cd(localAdUnit.g().toString(), localAdUnit.h().longValue(), localAdUnit.l().longValue(), localAdUnit.i().intValue(), localAdUnit.j().intValue(), localAdUnit.k().intValue());
          ce.a().a((cd)localObject);
        }
        Object localObject = localAdUnit.b().toString();
        this.b.a((String)localObject, i, localAdUnit);
      }
    }
    finally {}
  }
  
  public boolean a(AdUnit paramAdUnit)
  {
    return ((AdFrame)paramAdUnit.d().get(0)).e().e().equals("takeover");
  }
  
  public int b(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = (Integer)this.e.get(paramString);
        if (paramString != null)
        {
          i = paramString.intValue();
          return i;
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  public boolean b(List<AdUnit> paramList)
  {
    return (paramList == null) || (paramList.size() == 0) || (((AdUnit)paramList.get(0)).d().size() == 0) || (((AdFrame)((AdUnit)paramList.get(0)).d().get(0)).e() == null);
  }
  
  public AdUnit c(String paramString)
  {
    int i = 1;
    for (;;)
    {
      Object localObject1;
      try
      {
        int j = je.f();
        localObject1 = this.b.a(paramString, j);
        Object localObject2;
        if (b((List)localObject1))
        {
          ja.a(3, a, "no valid ad units in cache for current orientation for " + paramString);
          if (j == 1) {
            i = 2;
          }
          localObject2 = this.b.a(paramString, i);
          if (!b((List)localObject2))
          {
            localObject1 = localObject2;
            if (a((AdUnit)((List)localObject2).get(0))) {}
          }
          else
          {
            ja.a(3, a, "no valid ad units in cache for other orientation for " + paramString);
            paramString = null;
            return paramString;
          }
        }
        else
        {
          i = j;
        }
        if (!b((List)localObject1))
        {
          Iterator localIterator = ((List)localObject1).iterator();
          if (localIterator.hasNext())
          {
            localObject2 = (AdUnit)localIterator.next();
            if ((!je.a(((AdUnit)localObject2).c().longValue())) || (((AdUnit)localObject2).d().size() <= 0)) {
              continue;
            }
            boolean bool = this.b.b(paramString, i, (AdUnit)localObject2);
            ja.a(3, a, "found valid ad unit for " + paramString);
            ja.a(3, a, "Ad unit was removed = = " + bool);
            paramString = (String)localObject2;
            continue;
          }
        }
        ja.a(3, a, "no valid ad units for " + paramString);
      }
      finally {}
      this.c.a(paramString, (List)localObject1);
      paramString = null;
    }
  }
  
  /* Error */
  public boolean d(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 56	com/flurry/android/monolithic/sdk/impl/je:f	()I
    //   5: istore_2
    //   6: aload_0
    //   7: getfield 46	com/flurry/android/monolithic/sdk/impl/ad:b	Lcom/flurry/android/monolithic/sdk/impl/bz;
    //   10: aload_1
    //   11: iload_2
    //   12: invokevirtual 59	com/flurry/android/monolithic/sdk/impl/bz:a	(Ljava/lang/String;I)Ljava/util/List;
    //   15: astore_1
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 62	com/flurry/android/monolithic/sdk/impl/ad:b	(Ljava/util/List;)Z
    //   21: ifne +48 -> 69
    //   24: aload_1
    //   25: invokeinterface 99 1 0
    //   30: astore_1
    //   31: aload_1
    //   32: invokeinterface 105 1 0
    //   37: ifeq +32 -> 69
    //   40: aload_1
    //   41: invokeinterface 112 1 0
    //   46: checkcast 87	com/flurry/android/impl/ads/avro/protocol/v6/AdUnit
    //   49: invokevirtual 115	com/flurry/android/impl/ads/avro/protocol/v6/AdUnit:c	()Ljava/lang/Long;
    //   52: invokevirtual 121	java/lang/Long:longValue	()J
    //   55: invokestatic 124	com/flurry/android/monolithic/sdk/impl/je:a	(J)Z
    //   58: istore_3
    //   59: iload_3
    //   60: ifeq -29 -> 31
    //   63: iconst_1
    //   64: istore_3
    //   65: aload_0
    //   66: monitorexit
    //   67: iload_3
    //   68: ireturn
    //   69: iconst_0
    //   70: istore_3
    //   71: goto -6 -> 65
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	ad
    //   0	79	1	paramString	String
    //   5	7	2	i	int
    //   58	13	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	31	74	finally
    //   31	59	74	finally
  }
  
  public int e(String paramString)
  {
    try
    {
      int i = je.f();
      i = this.b.b(paramString, i);
      return i;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */