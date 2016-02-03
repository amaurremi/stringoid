package com.flurry.android;

import java.util.HashMap;

public class FlurryFreqCapManager
{
  private static FlurryFreqCapManager eC;
  private HashMap<String, FlurryFreqCapInfo> eD = new HashMap();
  
  static FlurryFreqCapManager an()
  {
    if (eC == null) {
      eC = new FlurryFreqCapManager();
    }
    return eC;
  }
  
  static boolean d(long paramLong)
  {
    return paramLong <= System.currentTimeMillis();
  }
  
  final void a(FlurryFreqCapInfo paramFlurryFreqCapInfo)
  {
    for (;;)
    {
      try
      {
        if (paramFlurryFreqCapInfo.getIdHash().length() == 0) {
          return;
        }
        try
        {
          if (this.eD.containsKey(paramFlurryFreqCapInfo.getIdHash()))
          {
            this.eD.remove(paramFlurryFreqCapInfo.getIdHash());
            if (paramFlurryFreqCapInfo.getNewCap() != -1) {
              this.eD.put(paramFlurryFreqCapInfo.getIdHash(), paramFlurryFreqCapInfo);
            }
            return;
          }
        }
        finally {}
        this.eD.put(paramFlurryFreqCapInfo.getIdHash(), paramFlurryFreqCapInfo);
      }
      catch (Exception paramFlurryFreqCapInfo)
      {
        paramFlurryFreqCapInfo.printStackTrace();
        return;
      }
    }
  }
  
  /* Error */
  final java.util.List<FlurryFreqCapInfo> ao()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 70	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 71	java/util/ArrayList:<init>	()V
    //   9: astore_1
    //   10: aload_0
    //   11: invokevirtual 75	com/flurry/android/FlurryFreqCapManager:getFreqCapInfoMap	()Ljava/util/HashMap;
    //   14: invokevirtual 79	java/util/HashMap:values	()Ljava/util/Collection;
    //   17: invokeinterface 85 1 0
    //   22: astore_2
    //   23: aload_2
    //   24: invokeinterface 91 1 0
    //   29: ifeq +37 -> 66
    //   32: aload_1
    //   33: aload_2
    //   34: invokeinterface 95 1 0
    //   39: checkcast 38	com/flurry/android/FlurryFreqCapInfo
    //   42: invokevirtual 99	com/flurry/android/FlurryFreqCapInfo:getCopy	()Lcom/flurry/android/FlurryFreqCapInfo;
    //   45: invokeinterface 104 2 0
    //   50: pop
    //   51: goto -28 -> 23
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    //   59: astore_1
    //   60: aload_1
    //   61: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   64: aconst_null
    //   65: areturn
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	FlurryFreqCapManager
    //   9	24	1	localArrayList	java.util.ArrayList
    //   54	4	1	localObject	Object
    //   59	10	1	localException	Exception
    //   22	12	2	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   2	23	54	finally
    //   23	51	54	finally
    //   55	57	54	finally
    //   66	68	54	finally
    //   0	2	59	java/lang/Exception
    //   57	59	59	java/lang/Exception
  }
  
  /* Error */
  final void ap()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 109	com/flurry/android/FlurryFreqCapManager:ao	()Ljava/util/List;
    //   6: invokeinterface 110 1 0
    //   11: astore_1
    //   12: aload_1
    //   13: invokeinterface 91 1 0
    //   18: ifeq +91 -> 109
    //   21: aload_1
    //   22: invokeinterface 95 1 0
    //   27: checkcast 38	com/flurry/android/FlurryFreqCapInfo
    //   30: astore_2
    //   31: aload_2
    //   32: invokevirtual 113	com/flurry/android/FlurryFreqCapInfo:getExpirationTime	()J
    //   35: invokestatic 115	com/flurry/android/FlurryFreqCapManager:d	(J)Z
    //   38: ifeq -26 -> 12
    //   41: new 117	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   48: ldc 120
    //   50: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_2
    //   54: invokevirtual 42	com/flurry/android/FlurryFreqCapInfo:getIdHash	()Ljava/lang/String;
    //   57: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc 126
    //   62: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_2
    //   66: invokevirtual 113	com/flurry/android/FlurryFreqCapInfo:getExpirationTime	()J
    //   69: invokevirtual 129	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   72: ldc -125
    //   74: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokestatic 32	java/lang/System:currentTimeMillis	()J
    //   80: invokevirtual 129	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   83: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: pop
    //   87: aload_0
    //   88: aload_2
    //   89: invokevirtual 42	com/flurry/android/FlurryFreqCapInfo:getIdHash	()Ljava/lang/String;
    //   92: invokevirtual 138	com/flurry/android/FlurryFreqCapManager:z	(Ljava/lang/String;)V
    //   95: goto -83 -> 12
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    //   103: astore_1
    //   104: aload_1
    //   105: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   108: return
    //   109: aload_0
    //   110: monitorexit
    //   111: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	FlurryFreqCapManager
    //   11	11	1	localIterator	java.util.Iterator
    //   98	4	1	localObject	Object
    //   103	2	1	localException	Exception
    //   30	59	2	localFlurryFreqCapInfo	FlurryFreqCapInfo
    // Exception table:
    //   from	to	target	type
    //   2	12	98	finally
    //   12	95	98	finally
    //   99	101	98	finally
    //   109	111	98	finally
    //   0	2	103	java/lang/Exception
    //   101	103	103	java/lang/Exception
  }
  
  public HashMap<String, FlurryFreqCapInfo> getFreqCapInfoMap()
  {
    return this.eD;
  }
  
  final FlurryFreqCapInfo y(String paramString)
  {
    try
    {
      try
      {
        if (this.eD.containsKey(paramString))
        {
          paramString = (FlurryFreqCapInfo)this.eD.get(paramString);
          return paramString;
        }
        return null;
      }
      finally {}
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  final void z(String paramString)
  {
    try
    {
      try
      {
        if (this.eD.containsKey(paramString)) {
          this.eD.remove(paramString);
        }
        return;
      }
      finally {}
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/FlurryFreqCapManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */