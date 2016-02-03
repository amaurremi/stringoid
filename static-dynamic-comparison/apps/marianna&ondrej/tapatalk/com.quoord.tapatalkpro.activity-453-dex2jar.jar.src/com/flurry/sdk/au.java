package com.flurry.sdk;

import android.util.Pair;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.android.impl.ads.avro.protocol.v10.ScreenOrientationType;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class au {
    private static final String a = au.class.getSimpleName();
    private final ds<Pair<String, ScreenOrientationType>, AdUnit> b = new ds();

    /* Error */
    public List<AdUnit> a(String paramString, ScreenOrientationType paramScreenOrientationType) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_1
        //   3: aload_2
        //   4: invokestatic 35	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
        //   7: astore_1
        //   8: aload_0
        //   9: getfield 28	com/flurry/sdk/au:b	Lcom/flurry/sdk/ds;
        //   12: aload_1
        //   13: invokevirtual 38	com/flurry/sdk/ds:a	(Ljava/lang/Object;)Ljava/util/List;
        //   16: astore_1
        //   17: aload_1
        //   18: ifnonnull +9 -> 27
        //   21: aconst_null
        //   22: astore_1
        //   23: aload_0
        //   24: monitorexit
        //   25: aload_1
        //   26: areturn
        //   27: new 40	java/util/ArrayList
        //   30: dup
        //   31: aload_1
        //   32: invokespecial 43	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
        //   35: astore_1
        //   36: goto -13 -> 23
        //   39: astore_1
        //   40: aload_0
        //   41: monitorexit
        //   42: aload_1
        //   43: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	44	0	this	au
        //   0	44	1	paramString	String
        //   0	44	2	paramScreenOrientationType	ScreenOrientationType
        // Exception table:
        //   from	to	target	type
        //   2	17	39	finally
        //   27	36	39	finally
    }

    public void a() {
        try {
            HashSet localHashSet = new HashSet();
            Iterator localIterator = this.b.c().iterator();
            while (localIterator.hasNext()) {
                localHashSet.add(((Pair) localIterator.next()).first);
            }
            this.b.a();
        } finally {
        }
    }

    public void a(String paramString) {
        try {
            Pair localPair = Pair.create(paramString, ScreenOrientationType.a);
            this.b.b(localPair);
            paramString = Pair.create(paramString, ScreenOrientationType.b);
            this.b.b(paramString);
            return;
        } finally {
            paramString =finally;
            throw paramString;
        }
    }

    public void a(String paramString, ScreenOrientationType paramScreenOrientationType, int paramInt) {
        for (; ; ) {
            try {
                paramString = Pair.create(paramString, paramScreenOrientationType);
                paramScreenOrientationType = this.b.a(paramString);
                if (paramScreenOrientationType == null) {
                    return;
                }
                if ((paramInt <= -1) || (paramInt > paramScreenOrientationType.size())) {
                    this.b.b(paramString);
                    continue;
                }
                if (paramInt <= 0) {
                    continue;
                }
            } finally {
            }
            paramScreenOrientationType.subList(0, paramInt).clear();
        }
    }

    /* Error */
    public void a(String paramString1, ScreenOrientationType paramScreenOrientationType, String paramString2) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_1
        //   3: aload_2
        //   4: invokestatic 35	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
        //   7: astore_1
        //   8: aload_0
        //   9: getfield 28	com/flurry/sdk/au:b	Lcom/flurry/sdk/ds;
        //   12: aload_1
        //   13: invokevirtual 38	com/flurry/sdk/ds:a	(Ljava/lang/Object;)Ljava/util/List;
        //   16: astore_1
        //   17: aload_1
        //   18: ifnonnull +6 -> 24
        //   21: aload_0
        //   22: monitorexit
        //   23: return
        //   24: aload_1
        //   25: invokeinterface 104 1 0
        //   30: astore_1
        //   31: aload_1
        //   32: invokeinterface 64 1 0
        //   37: ifeq -16 -> 21
        //   40: aload_1
        //   41: invokeinterface 68 1 0
        //   46: checkcast 106	com/flurry/android/impl/ads/avro/protocol/v10/AdUnit
        //   49: invokevirtual 110	com/flurry/android/impl/ads/avro/protocol/v10/AdUnit:f	()Ljava/lang/CharSequence;
        //   52: invokevirtual 113	java/lang/Object:toString	()Ljava/lang/String;
        //   55: aload_3
        //   56: invokevirtual 118	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   59: ifeq -28 -> 31
        //   62: aload_1
        //   63: invokeinterface 121 1 0
        //   68: goto -37 -> 31
        //   71: astore_1
        //   72: aload_0
        //   73: monitorexit
        //   74: aload_1
        //   75: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	76	0	this	au
        //   0	76	1	paramString1	String
        //   0	76	2	paramScreenOrientationType	ScreenOrientationType
        //   0	76	3	paramString2	String
        // Exception table:
        //   from	to	target	type
        //   2	17	71	finally
        //   24	31	71	finally
        //   31	68	71	finally
    }

    /* Error */
    public void a(String paramString, List<AdUnit> paramList) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_2
        //   3: ifnonnull +6 -> 9
        //   6: aload_0
        //   7: monitorexit
        //   8: return
        //   9: iconst_3
        //   10: getstatic 19	com/flurry/sdk/au:a	Ljava/lang/String;
        //   13: new 124	java/lang/StringBuilder
        //   16: dup
        //   17: invokespecial 125	java/lang/StringBuilder:<init>	()V
        //   20: ldc 127
        //   22: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   25: aload_2
        //   26: invokeinterface 95 1 0
        //   31: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   34: ldc -120
        //   36: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   39: aload_1
        //   40: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   43: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   46: invokestatic 142	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   49: aload_2
        //   50: invokeinterface 104 1 0
        //   55: astore_2
        //   56: aload_2
        //   57: invokeinterface 64 1 0
        //   62: ifeq -56 -> 6
        //   65: aload_2
        //   66: invokeinterface 68 1 0
        //   71: checkcast 106	com/flurry/android/impl/ads/avro/protocol/v10/AdUnit
        //   74: astore_3
        //   75: aload_1
        //   76: aload_3
        //   77: invokevirtual 146	com/flurry/android/impl/ads/avro/protocol/v10/AdUnit:u	()Lcom/flurry/android/impl/ads/avro/protocol/v10/ScreenOrientationType;
        //   80: invokestatic 35	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
        //   83: astore 4
        //   85: aload_0
        //   86: getfield 28	com/flurry/sdk/au:b	Lcom/flurry/sdk/ds;
        //   89: aload 4
        //   91: aload_3
        //   92: invokevirtual 149	com/flurry/sdk/ds:a	(Ljava/lang/Object;Ljava/lang/Object;)V
        //   95: goto -39 -> 56
        //   98: astore_1
        //   99: aload_0
        //   100: monitorexit
        //   101: aload_1
        //   102: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	103	0	this	au
        //   0	103	1	paramString	String
        //   0	103	2	paramList	List<AdUnit>
        //   74	18	3	localAdUnit	AdUnit
        //   83	7	4	localPair	Pair
        // Exception table:
        //   from	to	target	type
        //   9	56	98	finally
        //   56	95	98	finally
    }

    public boolean a(String paramString, ScreenOrientationType paramScreenOrientationType, AdUnit paramAdUnit) {
        boolean bool = false;
        if (paramAdUnit == null) {
        }
        for (; ; ) {
            return bool;
            try {
                paramString = Pair.create(paramString, paramScreenOrientationType);
                paramString = this.b.a(paramString);
                if (paramString == null) {
                    continue;
                }
                bool = paramString.remove(paramAdUnit);
            } finally {
            }
        }
    }

    public boolean a(String paramString, ScreenOrientationType paramScreenOrientationType, List<AdUnit> paramList) {
        boolean bool = false;
        if (paramList == null) {
        }
        for (; ; ) {
            return bool;
            try {
                paramString = Pair.create(paramString, paramScreenOrientationType);
                paramString = this.b.a(paramString);
                if (paramString == null) {
                    continue;
                }
                bool = paramString.removeAll(paramList);
            } finally {
            }
        }
    }

    /* Error */
    public int b(String paramString, ScreenOrientationType paramScreenOrientationType) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_1
        //   3: aload_2
        //   4: invokestatic 35	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
        //   7: astore_1
        //   8: aload_0
        //   9: getfield 28	com/flurry/sdk/au:b	Lcom/flurry/sdk/ds;
        //   12: aload_1
        //   13: invokevirtual 38	com/flurry/sdk/ds:a	(Ljava/lang/Object;)Ljava/util/List;
        //   16: astore_1
        //   17: aload_1
        //   18: ifnonnull +9 -> 27
        //   21: iconst_0
        //   22: istore_3
        //   23: aload_0
        //   24: monitorexit
        //   25: iload_3
        //   26: ireturn
        //   27: aload_1
        //   28: invokeinterface 95 1 0
        //   33: istore_3
        //   34: goto -11 -> 23
        //   37: astore_1
        //   38: aload_0
        //   39: monitorexit
        //   40: aload_1
        //   41: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	42	0	this	au
        //   0	42	1	paramString	String
        //   0	42	2	paramScreenOrientationType	ScreenOrientationType
        //   22	12	3	i	int
        // Exception table:
        //   from	to	target	type
        //   2	17	37	finally
        //   27	34	37	finally
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */