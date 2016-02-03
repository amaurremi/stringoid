package com.flurry.sdk;

import java.util.HashMap;

public final class y {
    private static final String a = y.class.getSimpleName();
    private static y b;
    private HashMap<String, x> c = new HashMap();

    public static y a() {
        if (b == null) {
            b = new y();
        }
        return b;
    }

    public x a(String paramString) {
        try {
            try {
                if (this.c.containsKey(paramString)) {
                    paramString = (x) this.c.get(paramString);
                    return paramString;
                }
                return null;
            } finally {
            }
            return null;
        } catch (Exception paramString) {
            paramString.printStackTrace();
        }
    }

    public void a(x paramx) {
        for (; ; ) {
            try {
                if (paramx.b().length() == 0) {
                    return;
                }
                try {
                    if (this.c.containsKey(paramx.b())) {
                        this.c.remove(paramx.b());
                        if (paramx.e() != -1) {
                            this.c.put(paramx.b(), paramx);
                        }
                        return;
                    }
                } finally {
                }
                this.c.put(paramx.b(), paramx);
            } catch (Exception paramx) {
                paramx.printStackTrace();
                return;
            }
        }
    }

    public boolean a(long paramLong) {
        return paramLong <= System.currentTimeMillis();
    }

    public HashMap<String, x> b() {
        return this.c;
    }

    public void b(String paramString) {
        try {
            try {
                if (this.c.containsKey(paramString)) {
                    this.c.remove(paramString);
                }
                return;
            } finally {
            }
            return;
        } catch (Exception paramString) {
            paramString.printStackTrace();
        }
    }

    /* Error */
    public java.util.List<x> c() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: new 83	java/util/ArrayList
        //   5: dup
        //   6: invokespecial 84	java/util/ArrayList:<init>	()V
        //   9: astore_1
        //   10: aload_0
        //   11: invokevirtual 86	com/flurry/sdk/y:b	()Ljava/util/HashMap;
        //   14: invokevirtual 90	java/util/HashMap:values	()Ljava/util/Collection;
        //   17: invokeinterface 96 1 0
        //   22: astore_2
        //   23: aload_2
        //   24: invokeinterface 102 1 0
        //   29: ifeq +37 -> 66
        //   32: aload_1
        //   33: aload_2
        //   34: invokeinterface 106 1 0
        //   39: checkcast 47	com/flurry/sdk/x
        //   42: invokevirtual 109	com/flurry/sdk/x:a	()Lcom/flurry/sdk/x;
        //   45: invokeinterface 114 2 0
        //   50: pop
        //   51: goto -28 -> 23
        //   54: astore_1
        //   55: aload_0
        //   56: monitorexit
        //   57: aload_1
        //   58: athrow
        //   59: astore_1
        //   60: aload_1
        //   61: invokevirtual 50	java/lang/Exception:printStackTrace	()V
        //   64: aconst_null
        //   65: areturn
        //   66: aload_0
        //   67: monitorexit
        //   68: aload_1
        //   69: areturn
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	70	0	this	y
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
    public void d() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: invokevirtual 118	com/flurry/sdk/y:c	()Ljava/util/List;
        //   6: invokeinterface 119 1 0
        //   11: astore_1
        //   12: aload_1
        //   13: invokeinterface 102 1 0
        //   18: ifeq +98 -> 116
        //   21: aload_1
        //   22: invokeinterface 106 1 0
        //   27: checkcast 47	com/flurry/sdk/x
        //   30: astore_2
        //   31: aload_0
        //   32: aload_2
        //   33: invokevirtual 122	com/flurry/sdk/x:h	()J
        //   36: invokevirtual 124	com/flurry/sdk/y:a	(J)Z
        //   39: ifeq -27 -> 12
        //   42: iconst_3
        //   43: getstatic 21	com/flurry/sdk/y:a	Ljava/lang/String;
        //   46: new 126	java/lang/StringBuilder
        //   49: dup
        //   50: invokespecial 127	java/lang/StringBuilder:<init>	()V
        //   53: ldc -127
        //   55: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   58: aload_2
        //   59: invokevirtual 53	com/flurry/sdk/x:b	()Ljava/lang/String;
        //   62: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   65: ldc -121
        //   67: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   70: aload_2
        //   71: invokevirtual 122	com/flurry/sdk/x:h	()J
        //   74: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   77: ldc -116
        //   79: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   82: invokestatic 76	java/lang/System:currentTimeMillis	()J
        //   85: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   88: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   91: invokestatic 148	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   94: aload_0
        //   95: aload_2
        //   96: invokevirtual 53	com/flurry/sdk/x:b	()Ljava/lang/String;
        //   99: invokevirtual 150	com/flurry/sdk/y:b	(Ljava/lang/String;)V
        //   102: goto -90 -> 12
        //   105: astore_1
        //   106: aload_0
        //   107: monitorexit
        //   108: aload_1
        //   109: athrow
        //   110: astore_1
        //   111: aload_1
        //   112: invokevirtual 50	java/lang/Exception:printStackTrace	()V
        //   115: return
        //   116: aload_0
        //   117: monitorexit
        //   118: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	119	0	this	y
        //   11	11	1	localIterator	java.util.Iterator
        //   105	4	1	localObject	Object
        //   110	2	1	localException	Exception
        //   30	66	2	localx	x
        // Exception table:
        //   from	to	target	type
        //   2	12	105	finally
        //   12	102	105	finally
        //   106	108	105	finally
        //   116	118	105	finally
        //   0	2	110	java/lang/Exception
        //   108	110	110	java/lang/Exception
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */