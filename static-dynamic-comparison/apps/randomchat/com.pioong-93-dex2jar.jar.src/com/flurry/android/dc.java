package com.flurry.android;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

final class dc
{
  private Map<String, bf> fj = new HashMap();
  private Map<String, WeakReference<ac>> fk = new HashMap();
  
  /* Error */
  final ac A(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 22	com/flurry/android/dc:fk	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 30 2 0
    //   12: ifeq +27 -> 39
    //   15: aload_0
    //   16: getfield 22	com/flurry/android/dc:fk	Ljava/util/Map;
    //   19: aload_1
    //   20: invokeinterface 34 2 0
    //   25: checkcast 36	java/lang/ref/WeakReference
    //   28: invokevirtual 39	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   31: checkcast 41	com/flurry/android/ac
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: areturn
    //   39: aconst_null
    //   40: astore_1
    //   41: goto -6 -> 35
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	dc
    //   0	49	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	35	44	finally
  }
  
  final void B(String paramString)
  {
    try
    {
      this.fk.remove(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  final ac a(FlurryAds paramFlurryAds, android.content.Context paramContext, android.view.ViewGroup paramViewGroup, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 22	com/flurry/android/dc:fk	Ljava/util/Map;
    //   6: aload 4
    //   8: invokeinterface 34 2 0
    //   13: checkcast 36	java/lang/ref/WeakReference
    //   16: astore 7
    //   18: aload 7
    //   20: ifnonnull +45 -> 65
    //   23: new 41	com/flurry/android/ac
    //   26: dup
    //   27: aload_1
    //   28: aload_2
    //   29: aload 4
    //   31: aload_3
    //   32: invokespecial 51	com/flurry/android/ac:<init>	(Lcom/flurry/android/FlurryAds;Landroid/content/Context;Ljava/lang/String;Landroid/view/ViewGroup;)V
    //   35: astore 5
    //   37: new 36	java/lang/ref/WeakReference
    //   40: dup
    //   41: aload 5
    //   43: invokespecial 54	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   46: astore_1
    //   47: aload_0
    //   48: getfield 22	com/flurry/android/dc:fk	Ljava/util/Map;
    //   51: aload 4
    //   53: aload_1
    //   54: invokeinterface 58 3 0
    //   59: pop
    //   60: aload_0
    //   61: monitorexit
    //   62: aload 5
    //   64: areturn
    //   65: aload 7
    //   67: invokevirtual 39	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   70: checkcast 41	com/flurry/android/ac
    //   73: astore 6
    //   75: aload 6
    //   77: ifnull +16 -> 93
    //   80: aload 6
    //   82: astore 5
    //   84: aload_2
    //   85: aload 6
    //   87: invokevirtual 62	com/flurry/android/ac:getContext	()Landroid/content/Context;
    //   90: if_acmpeq -30 -> 60
    //   93: new 41	com/flurry/android/ac
    //   96: dup
    //   97: aload_1
    //   98: aload_2
    //   99: aload 4
    //   101: aload_3
    //   102: invokespecial 51	com/flurry/android/ac:<init>	(Lcom/flurry/android/FlurryAds;Landroid/content/Context;Ljava/lang/String;Landroid/view/ViewGroup;)V
    //   105: astore 5
    //   107: aload 7
    //   109: invokevirtual 65	java/lang/ref/WeakReference:clear	()V
    //   112: new 36	java/lang/ref/WeakReference
    //   115: dup
    //   116: aload 5
    //   118: invokespecial 54	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   121: astore_1
    //   122: aload_0
    //   123: getfield 22	com/flurry/android/dc:fk	Ljava/util/Map;
    //   126: aload 4
    //   128: aload_1
    //   129: invokeinterface 58 3 0
    //   134: pop
    //   135: goto -75 -> 60
    //   138: astore_1
    //   139: aload_0
    //   140: monitorexit
    //   141: aload_1
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	dc
    //   0	143	1	paramFlurryAds	FlurryAds
    //   0	143	2	paramContext	android.content.Context
    //   0	143	3	paramViewGroup	android.view.ViewGroup
    //   0	143	4	paramString	String
    //   35	82	5	localObject	Object
    //   73	13	6	localac	ac
    //   16	92	7	localWeakReference	WeakReference
    // Exception table:
    //   from	to	target	type
    //   2	18	138	finally
    //   23	60	138	finally
    //   65	75	138	finally
    //   84	93	138	finally
    //   93	135	138	finally
  }
  
  final void a(String paramString, bf parambf)
  {
    try
    {
      this.fj.put(paramString, parambf);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  final bf n(String paramString)
  {
    try
    {
      paramString = (bf)this.fj.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  final void o(String paramString)
  {
    try
    {
      this.fj.remove(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/dc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */