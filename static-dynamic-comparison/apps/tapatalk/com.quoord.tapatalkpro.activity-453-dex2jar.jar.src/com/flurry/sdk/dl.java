package com.flurry.sdk;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public class dl {
    private static final String a = dl.class.getSimpleName();
    private static dl b;
    private final Map<String, dj> c = new HashMap();
    private final Map<Context, dj> d = new WeakHashMap();
    private final Object e = new Object();
    private dj f;

    public static dl a() {
        try {
            if (b == null) {
                b = new dl();
            }
            dl localdl = b;
            return localdl;
        } finally {
        }
    }

    /* Error */
    public void a(Context paramContext) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 41	com/flurry/sdk/dl:d	Ljava/util/Map;
        //   6: aload_1
        //   7: invokeinterface 54 2 0
        //   12: checkcast 56	com/flurry/sdk/dj
        //   15: astore_2
        //   16: aload_2
        //   17: ifnonnull +31 -> 48
        //   20: getstatic 27	com/flurry/sdk/dl:a	Ljava/lang/String;
        //   23: new 58	java/lang/StringBuilder
        //   26: dup
        //   27: invokespecial 59	java/lang/StringBuilder:<init>	()V
        //   30: ldc 61
        //   32: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   35: aload_1
        //   36: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   39: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   42: invokestatic 76	com/flurry/sdk/eo:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   45: aload_0
        //   46: monitorexit
        //   47: return
        //   48: aload_2
        //   49: aload_1
        //   50: invokevirtual 78	com/flurry/sdk/dj:c	(Landroid/content/Context;)V
        //   53: goto -8 -> 45
        //   56: astore_1
        //   57: aload_0
        //   58: monitorexit
        //   59: aload_1
        //   60: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	61	0	this	dl
        //   0	61	1	paramContext	Context
        //   15	34	2	localdj	dj
        // Exception table:
        //   from	to	target	type
        //   2	16	56	finally
        //   20	45	56	finally
        //   48	53	56	finally
    }

    public void a(Context paramContext, String paramString) {
        for (; ; ) {
            dj localdj;
            try {
                do.a(paramContext);
                ev.a().b();
                dz.a().b();
                localdj = (dj) this.d.get(paramContext);
                if (localdj != null) {
                    eo.d(a, "Session already started with context: " + paramContext + " count:" + localdj.g());
                    return;
                }
                if (this.c.containsKey(paramString)) {
                    paramString = (dj) this.c.get(paramString);
                    this.d.put(paramContext, paramString);
                    a(paramString);
                    paramString.b(paramContext);
                    continue;
                }
                localdj = new dj(paramString);
            } finally {
            }
            this.c.put(paramString, localdj);
            localdj.a(paramContext);
            paramString = localdj;
        }
    }

    public void a(dj paramdj) {
        synchronized (this.e) {
            this.f = paramdj;
            return;
        }
    }

    /* Error */
    public void a(String paramString) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 36	com/flurry/sdk/dl:c	Ljava/util/Map;
        //   6: aload_1
        //   7: invokeinterface 114 2 0
        //   12: ifne +16 -> 28
        //   15: bipush 6
        //   17: getstatic 27	com/flurry/sdk/dl:a	Ljava/lang/String;
        //   20: ldc -125
        //   22: invokestatic 134	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
        //   25: aload_0
        //   26: monitorexit
        //   27: return
        //   28: aload_0
        //   29: invokevirtual 137	com/flurry/sdk/dl:c	()Lcom/flurry/sdk/dj;
        //   32: astore_2
        //   33: aload_2
        //   34: ifnull +19 -> 53
        //   37: aload_2
        //   38: invokevirtual 140	com/flurry/sdk/dj:j	()Ljava/lang/String;
        //   41: aload_1
        //   42: invokestatic 146	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
        //   45: ifeq +8 -> 53
        //   48: aload_0
        //   49: aconst_null
        //   50: invokevirtual 121	com/flurry/sdk/dl:a	(Lcom/flurry/sdk/dj;)V
        //   53: aload_0
        //   54: getfield 36	com/flurry/sdk/dl:c	Ljava/util/Map;
        //   57: aload_1
        //   58: invokeinterface 54 2 0
        //   63: pop
        //   64: goto -39 -> 25
        //   67: astore_1
        //   68: aload_0
        //   69: monitorexit
        //   70: aload_1
        //   71: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	72	0	this	dl
        //   0	72	1	paramString	String
        //   32	6	2	localdj	dj
        // Exception table:
        //   from	to	target	type
        //   2	25	67	finally
        //   28	33	67	finally
        //   37	53	67	finally
        //   53	64	67	finally
    }

    public int b() {
        try {
            int i = this.d.size();
            return i;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public dj c() {
        synchronized (this.e) {
            dj localdj = this.f;
            return localdj;
        }
    }

    public void d() {
        try {
            Iterator localIterator1 = this.d.entrySet().iterator();
            while (localIterator1.hasNext()) {
                Map.Entry localEntry = (Map.Entry) localIterator1.next();
                ((dj) localEntry.getValue()).c((Context) localEntry.getKey());
            }
            this.d.clear();
        } finally {
        }
        Iterator localIterator2 = new ArrayList(this.c.values()).iterator();
        while (localIterator2.hasNext()) {
            ((dj) localIterator2.next()).c();
        }
        this.c.clear();
        a(null);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/dl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */