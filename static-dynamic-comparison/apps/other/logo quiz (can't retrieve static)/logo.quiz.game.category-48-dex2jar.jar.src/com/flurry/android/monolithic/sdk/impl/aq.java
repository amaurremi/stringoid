package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public final class aq
{
  private static final String a = aq.class.getSimpleName();
  private Map<String, cl> b = new HashMap();
  private Map<String, Stack<WeakReference<an>>> c = new HashMap();
  private final ScheduledExecutorService d = Executors.newSingleThreadScheduledExecutor();
  
  private void a(String paramString, an paraman)
  {
    Stack localStack2 = (Stack)this.c.get(paramString);
    Stack localStack1 = localStack2;
    if (localStack2 == null)
    {
      localStack1 = new Stack();
      this.c.put(paramString, localStack1);
    }
    localStack1.push(new WeakReference(paraman));
  }
  
  /* Error */
  public an a(com.flurry.android.impl.ads.FlurryAdModule paramFlurryAdModule, Context paramContext, android.view.ViewGroup paramViewGroup, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload 4
    //   5: invokevirtual 68	com/flurry/android/monolithic/sdk/impl/aq:a	(Ljava/lang/String;)Lcom/flurry/android/monolithic/sdk/impl/an;
    //   8: astore 6
    //   10: aload 6
    //   12: ifnull +26 -> 38
    //   15: aload 6
    //   17: invokevirtual 74	com/flurry/android/monolithic/sdk/impl/an:getContext	()Landroid/content/Context;
    //   20: aload_2
    //   21: invokevirtual 78	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   24: istore 5
    //   26: iload 5
    //   28: ifeq +10 -> 38
    //   31: aload 6
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: areturn
    //   38: new 70	com/flurry/android/monolithic/sdk/impl/an
    //   41: dup
    //   42: aload_1
    //   43: aload_2
    //   44: aload 4
    //   46: aload_3
    //   47: aload_0
    //   48: getfield 42	com/flurry/android/monolithic/sdk/impl/aq:d	Ljava/util/concurrent/ScheduledExecutorService;
    //   51: invokespecial 81	com/flurry/android/monolithic/sdk/impl/an:<init>	(Lcom/flurry/android/impl/ads/FlurryAdModule;Landroid/content/Context;Ljava/lang/String;Landroid/view/ViewGroup;Ljava/util/concurrent/ScheduledExecutorService;)V
    //   54: astore_1
    //   55: aload_0
    //   56: aload 4
    //   58: aload_1
    //   59: invokespecial 83	com/flurry/android/monolithic/sdk/impl/aq:a	(Ljava/lang/String;Lcom/flurry/android/monolithic/sdk/impl/an;)V
    //   62: goto -28 -> 34
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	aq
    //   0	70	1	paramFlurryAdModule	com.flurry.android.impl.ads.FlurryAdModule
    //   0	70	2	paramContext	Context
    //   0	70	3	paramViewGroup	android.view.ViewGroup
    //   0	70	4	paramString	String
    //   24	3	5	bool	boolean
    //   8	24	6	localan	an
    // Exception table:
    //   from	to	target	type
    //   2	10	65	finally
    //   15	26	65	finally
    //   38	62	65	finally
  }
  
  /* Error */
  public an a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 34	com/flurry/android/monolithic/sdk/impl/aq:c	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 86 2 0
    //   12: ifeq +47 -> 59
    //   15: aload_0
    //   16: getfield 34	com/flurry/android/monolithic/sdk/impl/aq:c	Ljava/util/Map;
    //   19: aload_1
    //   20: invokeinterface 49 2 0
    //   25: checkcast 51	java/util/Stack
    //   28: astore_1
    //   29: aload_1
    //   30: invokevirtual 90	java/util/Stack:size	()I
    //   33: ifle +21 -> 54
    //   36: aload_1
    //   37: invokevirtual 94	java/util/Stack:peek	()Ljava/lang/Object;
    //   40: checkcast 58	java/lang/ref/WeakReference
    //   43: invokevirtual 96	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   46: checkcast 70	com/flurry/android/monolithic/sdk/impl/an
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: areturn
    //   54: aconst_null
    //   55: astore_1
    //   56: goto -6 -> 50
    //   59: aconst_null
    //   60: astore_1
    //   61: goto -11 -> 50
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	aq
    //   0	69	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	50	64	finally
  }
  
  public List<an> a(Context paramContext)
  {
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList();
      Iterator localIterator1 = this.c.values().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((Stack)localIterator1.next()).iterator();
        while (localIterator2.hasNext())
        {
          an localan = (an)((WeakReference)localIterator2.next()).get();
          if ((localan != null) && ((paramContext == null) || (paramContext == localan.getContext()))) {
            localArrayList.add(localan);
          }
        }
      }
    }
    finally {}
    return localArrayList;
  }
  
  public void a(an paraman)
  {
    if (paraman == null) {}
    for (;;)
    {
      return;
      try
      {
        String str = paraman.getAdSpace();
        Stack localStack = (Stack)this.c.get(str);
        if (localStack == null) {
          continue;
        }
        Iterator localIterator = localStack.iterator();
        while (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if (paraman == localWeakReference.get()) {
            if (localStack.remove(localWeakReference)) {
              ja.a(3, a, "removed banner holder for adSpaceName: " + paraman.getAdSpace());
            }
          }
        }
        if (localStack.size() != 0) {
          continue;
        }
        this.c.remove(str);
      }
      finally {}
    }
  }
  
  public void a(String paramString, cl paramcl)
  {
    try
    {
      this.b.put(paramString, paramcl);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public cl b(String paramString)
  {
    try
    {
      paramString = (cl)this.b.remove(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void c(String paramString)
  {
    try
    {
      this.b.remove(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean d(String paramString)
  {
    try
    {
      boolean bool = this.b.containsKey(paramString);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */