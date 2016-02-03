package com.flurry.android;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class aj
{
  Context bE;
  private Map<String, List<AdUnit>> bF = new HashMap();
  private bw bG;
  
  private void c(String paramString, int paramInt)
  {
    try
    {
      Object localObject = (List)this.bF.get(paramString);
      FlurryAdSize localFlurryAdSize = FlurryAdSize.BANNER_BOTTOM;
      if ((localObject != null) && (((List)localObject).size() > 0) && (((AdUnit)((List)localObject).get(0)).getAdFrames().size() > 0) && (((AdFrame)((AdUnit)((List)localObject).get(0)).getAdFrames().get(0)).getAdSpaceLayout() != null)) {
        localFlurryAdSize = FlurryAdSize.a(((AdFrame)((AdUnit)((List)localObject).get(0)).getAdFrames().get(0)).getAdSpaceLayout());
      }
      for (;;)
      {
        StringBuilder localStringBuilder;
        if (c((List)localObject))
        {
          localStringBuilder = new StringBuilder().append("Starting AsyncAdTask from EnsureCacheNotEmpty size: ");
          if (localObject == null) {
            break label225;
          }
        }
        label225:
        for (localObject = Integer.toString(((List)localObject).size());; localObject = "")
        {
          localStringBuilder.append((String)localObject).append(" wait: ").append(Integer.toString(0)).toString();
          localObject = FlurryAds.getInstance();
          localObject.getClass();
          this.bG = new bw((FlurryAds)localObject, this.bE, paramString, localFlurryAdSize);
          this.bG.execute(new Void[0]);
          return;
        }
      }
    }
    finally {}
  }
  
  /* Error */
  private boolean c(List<AdUnit> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +13 -> 16
    //   6: aload_1
    //   7: invokeinterface 41 1 0
    //   12: iconst_2
    //   13: if_icmpge +34 -> 47
    //   16: aload_0
    //   17: getfield 102	com/flurry/android/aj:bG	Lcom/flurry/android/bw;
    //   20: ifnull +21 -> 41
    //   23: aload_0
    //   24: getfield 102	com/flurry/android/aj:bG	Lcom/flurry/android/bw;
    //   27: invokevirtual 114	com/flurry/android/bw:getStatus	()Landroid/os/AsyncTask$Status;
    //   30: getstatic 120	android/os/AsyncTask$Status:FINISHED	Landroid/os/AsyncTask$Status;
    //   33: invokevirtual 124	android/os/AsyncTask$Status:equals	(Ljava/lang/Object;)Z
    //   36: istore_2
    //   37: iload_2
    //   38: ifeq +9 -> 47
    //   41: iconst_1
    //   42: istore_2
    //   43: aload_0
    //   44: monitorexit
    //   45: iload_2
    //   46: ireturn
    //   47: aload_0
    //   48: getfield 102	com/flurry/android/aj:bG	Lcom/flurry/android/bw;
    //   51: ifnull +17 -> 68
    //   54: aload_0
    //   55: getfield 102	com/flurry/android/aj:bG	Lcom/flurry/android/bw;
    //   58: invokevirtual 114	com/flurry/android/bw:getStatus	()Landroid/os/AsyncTask$Status;
    //   61: getstatic 120	android/os/AsyncTask$Status:FINISHED	Landroid/os/AsyncTask$Status;
    //   64: invokevirtual 124	android/os/AsyncTask$Status:equals	(Ljava/lang/Object;)Z
    //   67: pop
    //   68: iconst_0
    //   69: istore_2
    //   70: goto -27 -> 43
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	aj
    //   0	78	1	paramList	List<AdUnit>
    //   36	34	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	16	73	finally
    //   16	37	73	finally
    //   47	68	73	finally
  }
  
  /* Error */
  final void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 20	com/flurry/android/aj:bF	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 29 2 0
    //   12: checkcast 31	java/util/List
    //   15: astore_3
    //   16: aload_3
    //   17: ifnull +36 -> 53
    //   20: iload_2
    //   21: iconst_m1
    //   22: if_icmple +13 -> 35
    //   25: iload_2
    //   26: aload_3
    //   27: invokeinterface 41 1 0
    //   32: if_icmple +30 -> 62
    //   35: aload_0
    //   36: getfield 20	com/flurry/android/aj:bF	Ljava/util/Map;
    //   39: aload_1
    //   40: new 128	java/util/ArrayList
    //   43: dup
    //   44: invokespecial 129	java/util/ArrayList:<init>	()V
    //   47: invokeinterface 133 3 0
    //   52: pop
    //   53: aload_0
    //   54: aload_1
    //   55: iconst_0
    //   56: invokespecial 135	com/flurry/android/aj:c	(Ljava/lang/String;I)V
    //   59: aload_0
    //   60: monitorexit
    //   61: return
    //   62: iload_2
    //   63: ifle -10 -> 53
    //   66: aload_3
    //   67: iconst_0
    //   68: iload_2
    //   69: invokeinterface 139 3 0
    //   74: invokeinterface 142 1 0
    //   79: aload_0
    //   80: getfield 20	com/flurry/android/aj:bF	Ljava/util/Map;
    //   83: aload_1
    //   84: aload_3
    //   85: invokeinterface 133 3 0
    //   90: pop
    //   91: goto -38 -> 53
    //   94: astore_1
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_1
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	aj
    //   0	99	1	paramString	String
    //   0	99	2	paramInt	int
    //   15	70	3	localList	List
    // Exception table:
    //   from	to	target	type
    //   2	16	94	finally
    //   25	35	94	finally
    //   35	53	94	finally
    //   53	59	94	finally
    //   66	91	94	finally
  }
  
  final List<AdUnit> b(String paramString, int paramInt)
  {
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList();
      Object localObject = (List)this.bF.get(paramString);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while ((((Iterator)localObject).hasNext()) && (localArrayList.size() <= paramInt))
        {
          AdUnit localAdUnit = (AdUnit)((Iterator)localObject).next();
          if ((bd.b(localAdUnit.getExpiration().longValue())) && (localAdUnit.getCombinable().intValue() == 1) && (localAdUnit.getAdFrames().size() > 0))
          {
            localArrayList.add(localAdUnit);
            ((Iterator)localObject).remove();
          }
        }
      }
      c(paramString, 0);
    }
    finally {}
    return localArrayList;
  }
  
  final void b(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = (List)this.bF.get(paramString1);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((AdUnit)((Iterator)localObject).next()).getGroupId().toString().equals(paramString2)) {
            ((Iterator)localObject).remove();
          }
        }
      }
      c(paramString1, 0);
    }
    finally {}
  }
  
  final void b(List<AdUnit> paramList)
  {
    synchronized (this.bF)
    {
      Iterator localIterator = paramList.iterator();
      if (localIterator.hasNext())
      {
        AdUnit localAdUnit = (AdUnit)localIterator.next();
        if (localAdUnit.getIdHash().length() > 0)
        {
          paramList = new FlurryFreqCapInfo(localAdUnit.getIdHash().toString(), localAdUnit.getServeTime().longValue(), localAdUnit.getExpirationTime().longValue(), localAdUnit.getNewCap().intValue(), localAdUnit.getPreviousCap().intValue(), localAdUnit.getPreviousCapType().intValue());
          FlurryFreqCapManager.an().a(paramList);
        }
        String str = localAdUnit.getAdSpace().toString();
        List localList = (List)this.bF.get(str);
        paramList = localList;
        if (localList == null) {
          paramList = new ArrayList();
        }
        paramList.add(localAdUnit);
        this.bF.put(str, paramList);
      }
    }
  }
  
  /* Error */
  final AdUnit h(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 20	com/flurry/android/aj:bF	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 29 2 0
    //   12: checkcast 31	java/util/List
    //   15: astore_2
    //   16: aload_2
    //   17: ifnull +72 -> 89
    //   20: aload_2
    //   21: invokeinterface 148 1 0
    //   26: astore_3
    //   27: aload_3
    //   28: invokeinterface 154 1 0
    //   33: ifeq +56 -> 89
    //   36: aload_3
    //   37: invokeinterface 158 1 0
    //   42: checkcast 46	com/flurry/android/AdUnit
    //   45: astore_2
    //   46: aload_2
    //   47: invokevirtual 162	com/flurry/android/AdUnit:getExpiration	()Ljava/lang/Long;
    //   50: invokevirtual 168	java/lang/Long:longValue	()J
    //   53: invokestatic 173	com/flurry/android/bd:b	(J)Z
    //   56: ifeq -29 -> 27
    //   59: aload_2
    //   60: invokevirtual 50	com/flurry/android/AdUnit:getAdFrames	()Ljava/util/List;
    //   63: invokeinterface 41 1 0
    //   68: ifle -41 -> 27
    //   71: aload_3
    //   72: invokeinterface 186 1 0
    //   77: aload_0
    //   78: aload_1
    //   79: iconst_0
    //   80: invokespecial 135	com/flurry/android/aj:c	(Ljava/lang/String;I)V
    //   83: aload_2
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: areturn
    //   89: aload_0
    //   90: aload_1
    //   91: iconst_0
    //   92: invokespecial 135	com/flurry/android/aj:c	(Ljava/lang/String;I)V
    //   95: aconst_null
    //   96: astore_1
    //   97: goto -12 -> 85
    //   100: astore_1
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_1
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	aj
    //   0	105	1	paramString	String
    //   15	69	2	localObject	Object
    //   26	46	3	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	16	100	finally
    //   20	27	100	finally
    //   27	83	100	finally
    //   89	95	100	finally
  }
  
  /* Error */
  final boolean i(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 20	com/flurry/android/aj:bF	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 29 2 0
    //   12: checkcast 31	java/util/List
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +57 -> 74
    //   20: aload_1
    //   21: invokeinterface 245 1 0
    //   26: ifne +48 -> 74
    //   29: aload_1
    //   30: invokeinterface 148 1 0
    //   35: astore_1
    //   36: aload_1
    //   37: invokeinterface 154 1 0
    //   42: ifeq +32 -> 74
    //   45: aload_1
    //   46: invokeinterface 158 1 0
    //   51: checkcast 46	com/flurry/android/AdUnit
    //   54: invokevirtual 162	com/flurry/android/AdUnit:getExpiration	()Ljava/lang/Long;
    //   57: invokevirtual 168	java/lang/Long:longValue	()J
    //   60: invokestatic 173	com/flurry/android/bd:b	(J)Z
    //   63: istore_2
    //   64: iload_2
    //   65: ifeq -29 -> 36
    //   68: iconst_1
    //   69: istore_2
    //   70: aload_0
    //   71: monitorexit
    //   72: iload_2
    //   73: ireturn
    //   74: iconst_0
    //   75: istore_2
    //   76: goto -6 -> 70
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	aj
    //   0	84	1	paramString	String
    //   63	13	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	16	79	finally
    //   20	36	79	finally
    //   36	64	79	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */