package com.flurry.android.monolithic.sdk.impl;

import android.util.Pair;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class bz
{
  private final Map<Pair<String, Integer>, List<AdUnit>> a = new HashMap();
  private List<ca> b = new LinkedList();
  
  /* Error */
  public List<AdUnit> a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 32	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   7: invokestatic 38	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   10: astore_1
    //   11: aload_0
    //   12: getfield 19	com/flurry/android/monolithic/sdk/impl/bz:a	Ljava/util/Map;
    //   15: aload_1
    //   16: invokeinterface 44 2 0
    //   21: checkcast 46	java/util/List
    //   24: astore_1
    //   25: aload_1
    //   26: ifnonnull +9 -> 35
    //   29: aconst_null
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: areturn
    //   35: new 48	java/util/ArrayList
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 51	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   43: astore_1
    //   44: goto -13 -> 31
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	bz
    //   0	52	1	paramString	String
    //   0	52	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   2	25	47	finally
    //   35	44	47	finally
  }
  
  public void a(ca paramca)
  {
    try
    {
      this.b.add(paramca);
      return;
    }
    finally
    {
      paramca = finally;
      throw paramca;
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      Pair localPair;
      List localList;
      try
      {
        localPair = Pair.create(paramString, Integer.valueOf(paramInt1));
        localList = (List)this.a.get(localPair);
        if (localList == null) {
          return;
        }
        if ((paramInt2 <= -1) || (paramInt2 > localList.size()))
        {
          this.a.remove(localPair);
          c(paramString, paramInt1);
          continue;
        }
        if (paramInt2 <= 0) {
          continue;
        }
      }
      finally {}
      localList.subList(0, paramInt2).clear();
      this.a.put(localPair, localList);
    }
  }
  
  public void a(String paramString, int paramInt, AdUnit paramAdUnit)
  {
    if (paramAdUnit == null) {}
    for (;;)
    {
      return;
      try
      {
        Pair localPair = Pair.create(paramString, Integer.valueOf(paramInt));
        List localList = (List)this.a.get(localPair);
        Object localObject = localList;
        if (localList == null) {
          localObject = new ArrayList();
        }
        ((List)localObject).add(paramAdUnit);
        this.a.put(localPair, localObject);
        c(paramString, paramInt);
      }
      finally {}
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    for (;;)
    {
      try
      {
        Object localObject = Pair.create(paramString1, Integer.valueOf(paramInt));
        localObject = (List)this.a.get(localObject);
        if (localObject == null) {
          return;
        }
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          if (((AdUnit)((Iterator)localObject).next()).f().toString().equals(paramString2)) {
            ((Iterator)localObject).remove();
          }
        }
        else {
          c(paramString1, paramInt);
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public int b(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 32	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   7: invokestatic 38	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   10: astore_1
    //   11: aload_0
    //   12: getfield 19	com/flurry/android/monolithic/sdk/impl/bz:a	Ljava/util/Map;
    //   15: aload_1
    //   16: invokeinterface 44 2 0
    //   21: checkcast 46	java/util/List
    //   24: astore_1
    //   25: aload_1
    //   26: ifnonnull +9 -> 35
    //   29: iconst_0
    //   30: istore_2
    //   31: aload_0
    //   32: monitorexit
    //   33: iload_2
    //   34: ireturn
    //   35: aload_1
    //   36: invokeinterface 63 1 0
    //   41: istore_2
    //   42: goto -11 -> 31
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	bz
    //   0	50	1	paramString	String
    //   0	50	2	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   2	25	45	finally
    //   35	42	45	finally
  }
  
  /* Error */
  public boolean b(String paramString, int paramInt, AdUnit paramAdUnit)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: iload_2
    //   4: invokestatic 32	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   7: invokestatic 38	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   10: astore 6
    //   12: aload_0
    //   13: getfield 19	com/flurry/android/monolithic/sdk/impl/bz:a	Ljava/util/Map;
    //   16: aload 6
    //   18: invokeinterface 44 2 0
    //   23: checkcast 46	java/util/List
    //   26: astore 6
    //   28: aload 6
    //   30: ifnonnull +11 -> 41
    //   33: iconst_0
    //   34: istore 4
    //   36: aload_0
    //   37: monitorexit
    //   38: iload 4
    //   40: ireturn
    //   41: aload 6
    //   43: aload_3
    //   44: invokeinterface 119 2 0
    //   49: istore 5
    //   51: iload 5
    //   53: istore 4
    //   55: iload 5
    //   57: ifeq -21 -> 36
    //   60: aload_0
    //   61: aload_1
    //   62: iload_2
    //   63: invokevirtual 70	com/flurry/android/monolithic/sdk/impl/bz:c	(Ljava/lang/String;I)V
    //   66: iload 5
    //   68: istore 4
    //   70: goto -34 -> 36
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	bz
    //   0	78	1	paramString	String
    //   0	78	2	paramInt	int
    //   0	78	3	paramAdUnit	AdUnit
    //   34	35	4	bool1	boolean
    //   49	18	5	bool2	boolean
    //   10	32	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	28	73	finally
    //   41	51	73	finally
    //   60	66	73	finally
  }
  
  void c(String paramString, int paramInt)
  {
    Object localObject = Pair.create(paramString, Integer.valueOf(paramInt));
    localObject = (List)this.a.get(localObject);
    if (localObject == null) {}
    for (int i = 0;; i = ((List)localObject).size())
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        ca localca = (ca)localIterator.next();
        if (localca != null) {
          localca.a(paramString, paramInt, i, (List)localObject);
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */