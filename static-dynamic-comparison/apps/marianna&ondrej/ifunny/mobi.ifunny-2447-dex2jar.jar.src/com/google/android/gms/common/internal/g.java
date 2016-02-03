package com.google.android.gms.common.internal;

import java.util.ArrayList;

public abstract class g<TListener> {
    private TListener b;
    private boolean c;

    public g(TListener paramTListener) {
        Object localObject;
        this.b = localObject;
        this.c = false;
    }

    protected abstract void a();

    protected abstract void a(TListener paramTListener);

    /* Error */
    public void b() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 21	com/google/android/gms/common/internal/g:b	Ljava/lang/Object;
        //   6: astore_1
        //   7: aload_0
        //   8: getfield 23	com/google/android/gms/common/internal/g:c	Z
        //   11: ifeq +33 -> 44
        //   14: ldc 31
        //   16: new 33	java/lang/StringBuilder
        //   19: dup
        //   20: invokespecial 34	java/lang/StringBuilder:<init>	()V
        //   23: ldc 36
        //   25: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   28: aload_0
        //   29: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   32: ldc 45
        //   34: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   37: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   40: invokestatic 55	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
        //   43: pop
        //   44: aload_0
        //   45: monitorexit
        //   46: aload_1
        //   47: ifnull +34 -> 81
        //   50: aload_0
        //   51: aload_1
        //   52: invokevirtual 57	com/google/android/gms/common/internal/g:a	(Ljava/lang/Object;)V
        //   55: aload_0
        //   56: monitorenter
        //   57: aload_0
        //   58: iconst_1
        //   59: putfield 23	com/google/android/gms/common/internal/g:c	Z
        //   62: aload_0
        //   63: monitorexit
        //   64: aload_0
        //   65: invokevirtual 59	com/google/android/gms/common/internal/g:c	()V
        //   68: return
        //   69: astore_1
        //   70: aload_0
        //   71: monitorexit
        //   72: aload_1
        //   73: athrow
        //   74: astore_1
        //   75: aload_0
        //   76: invokevirtual 61	com/google/android/gms/common/internal/g:a	()V
        //   79: aload_1
        //   80: athrow
        //   81: aload_0
        //   82: invokevirtual 61	com/google/android/gms/common/internal/g:a	()V
        //   85: goto -30 -> 55
        //   88: astore_1
        //   89: aload_0
        //   90: monitorexit
        //   91: aload_1
        //   92: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	93	0	this	g
        //   6	46	1	localObject1	Object
        //   69	4	1	localObject2	Object
        //   74	6	1	localRuntimeException	RuntimeException
        //   88	4	1	localObject3	Object
        // Exception table:
        //   from	to	target	type
        //   2	44	69	finally
        //   44	46	69	finally
        //   70	72	69	finally
        //   50	55	74	java/lang/RuntimeException
        //   57	64	88	finally
        //   89	91	88	finally
    }

    public void c() {
        d();
        synchronized (e.b(this.a)) {
            e.b(this.a).remove(this);
            return;
        }
    }

    public void d() {
        try {
            this.b = null;
            return;
        } finally {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/internal/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */