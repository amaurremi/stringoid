package com.flurry.sdk;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class dq {
    private Map<String, Object> a = new HashMap();
    private Map<String, List<a>> b = new HashMap();

    private boolean a(Object paramObject1, Object paramObject2) {
        return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
    }

    private void b(String paramString, Object paramObject) {
        if (this.b.get(paramString) != null) {
            Iterator localIterator = ((List) this.b.get(paramString)).iterator();
            while (localIterator.hasNext()) {
                ((a) localIterator.next()).a(paramString, paramObject);
            }
        }
    }

    public Object a(String paramString) {
        try {
            paramString = this.a.get(paramString);
            return paramString;
        } finally {
            paramString =finally;
            throw paramString;
        }
    }

    /* Error */
    public void a(String paramString, a parama) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_1
        //   3: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   6: istore_3
        //   7: iload_3
        //   8: ifeq +6 -> 14
        //   11: aload_0
        //   12: monitorexit
        //   13: return
        //   14: aload_2
        //   15: ifnull -4 -> 11
        //   18: aload_0
        //   19: getfield 22	com/flurry/sdk/dq:b	Ljava/util/Map;
        //   22: aload_1
        //   23: invokeinterface 35 2 0
        //   28: checkcast 37	java/util/List
        //   31: astore 5
        //   33: aload 5
        //   35: astore 4
        //   37: aload 5
        //   39: ifnonnull +12 -> 51
        //   42: new 63	java/util/LinkedList
        //   45: dup
        //   46: invokespecial 64	java/util/LinkedList:<init>	()V
        //   49: astore 4
        //   51: aload 4
        //   53: aload_2
        //   54: invokeinterface 67 2 0
        //   59: pop
        //   60: aload_0
        //   61: getfield 22	com/flurry/sdk/dq:b	Ljava/util/Map;
        //   64: aload_1
        //   65: aload 4
        //   67: invokeinterface 71 3 0
        //   72: pop
        //   73: goto -62 -> 11
        //   76: astore_1
        //   77: aload_0
        //   78: monitorexit
        //   79: aload_1
        //   80: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	81	0	this	dq
        //   0	81	1	paramString	String
        //   0	81	2	parama	a
        //   6	2	3	bool	boolean
        //   35	31	4	localObject	Object
        //   31	7	5	localList	List
        // Exception table:
        //   from	to	target	type
        //   2	7	76	finally
        //   18	33	76	finally
        //   42	51	76	finally
        //   51	73	76	finally
    }

    public void a(String paramString, Object paramObject) {
        for (; ; ) {
            try {
                boolean bool = TextUtils.isEmpty(paramString);
                if (bool) {
                    return;
                }
                if (!a(paramObject, this.a.get(paramString))) {
                    if (paramObject == null) {
                        this.a.remove(paramString);
                        b(paramString, paramObject);
                    } else {
                        this.a.put(paramString, paramObject);
                    }
                }
            } finally {
            }
        }
    }

    /* Error */
    public boolean b(String paramString, a parama) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_1
        //   3: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   6: istore_3
        //   7: iload_3
        //   8: ifeq +9 -> 17
        //   11: iconst_0
        //   12: istore_3
        //   13: aload_0
        //   14: monitorexit
        //   15: iload_3
        //   16: ireturn
        //   17: aload_2
        //   18: ifnonnull +8 -> 26
        //   21: iconst_0
        //   22: istore_3
        //   23: goto -10 -> 13
        //   26: aload_0
        //   27: getfield 22	com/flurry/sdk/dq:b	Ljava/util/Map;
        //   30: aload_1
        //   31: invokeinterface 35 2 0
        //   36: checkcast 37	java/util/List
        //   39: astore_1
        //   40: aload_1
        //   41: ifnonnull +8 -> 49
        //   44: iconst_0
        //   45: istore_3
        //   46: goto -33 -> 13
        //   49: aload_1
        //   50: aload_2
        //   51: invokeinterface 81 2 0
        //   56: istore_3
        //   57: goto -44 -> 13
        //   60: astore_1
        //   61: aload_0
        //   62: monitorexit
        //   63: aload_1
        //   64: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	65	0	this	dq
        //   0	65	1	paramString	String
        //   0	65	2	parama	a
        //   6	51	3	bool	boolean
        // Exception table:
        //   from	to	target	type
        //   2	7	60	finally
        //   26	40	60	finally
        //   49	57	60	finally
    }

    public static abstract interface a {
        public abstract void a(String paramString, Object paramObject);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/dq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */