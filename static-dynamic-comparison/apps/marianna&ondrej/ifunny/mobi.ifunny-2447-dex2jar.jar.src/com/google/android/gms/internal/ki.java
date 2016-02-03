package com.google.android.gms.internal;

import android.content.Context;

import java.util.concurrent.Future;

@ii
public class ki
        extends lo {
    private final jo a;
    private final fk b;
    private final ld c;
    private final kk d;
    private final Object e = new Object();
    private Future<lc> f;

    public ki(Context paramContext, te paramte, s params, ld paramld, jo paramjo) {
        this(paramld, paramjo, new kk(paramContext, paramte, params, new ml(), paramld));
    }

    ki(ld paramld, jo paramjo, kk paramkk) {
        this.c = paramld;
        this.b = paramld.b;
        this.a = paramjo;
        this.d = paramkk;
    }

    private lc a(int paramInt) {
        return new lc(this.c.a.c, null, null, paramInt, null, null, this.b.l, this.b.k, this.c.a.i, false, null, null, null, null, null, this.b.i, this.c.d, this.b.g, this.c.f, this.b.n, this.b.o, this.c.h, null);
    }

    /* Error */
    public void a() {
        // Byte code:
        //   0: aload_0
        //   1: getfield 40	com/google/android/gms/internal/ki:e	Ljava/lang/Object;
        //   4: astore_2
        //   5: aload_2
        //   6: monitorenter
        //   7: aload_0
        //   8: aload_0
        //   9: getfield 51	com/google/android/gms/internal/ki:d	Lcom/google/android/gms/internal/kk;
        //   12: invokestatic 113	com/google/android/gms/internal/ls:a	(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
        //   15: putfield 115	com/google/android/gms/internal/ki:f	Ljava/util/concurrent/Future;
        //   18: aload_2
        //   19: monitorexit
        //   20: aload_0
        //   21: getfield 115	com/google/android/gms/internal/ki:f	Ljava/util/concurrent/Future;
        //   24: ldc2_w 116
        //   27: getstatic 123	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
        //   30: invokeinterface 129 4 0
        //   35: checkcast 55	com/google/android/gms/internal/lc
        //   38: astore_2
        //   39: bipush -2
        //   41: istore_1
        //   42: aload_2
        //   43: ifnull +62 -> 105
        //   46: getstatic 134	com/google/android/gms/internal/mv:a	Landroid/os/Handler;
        //   49: new 136	com/google/android/gms/internal/kj
        //   52: dup
        //   53: aload_0
        //   54: aload_2
        //   55: invokespecial 139	com/google/android/gms/internal/kj:<init>	(Lcom/google/android/gms/internal/ki;Lcom/google/android/gms/internal/lc;)V
        //   58: invokevirtual 145	android/os/Handler:post	(Ljava/lang/Runnable;)Z
        //   61: pop
        //   62: return
        //   63: astore_3
        //   64: aload_2
        //   65: monitorexit
        //   66: aload_3
        //   67: athrow
        //   68: astore_2
        //   69: ldc -109
        //   71: invokestatic 152	com/google/android/gms/internal/mx:e	(Ljava/lang/String;)V
        //   74: iconst_2
        //   75: istore_1
        //   76: aconst_null
        //   77: astore_2
        //   78: goto -36 -> 42
        //   81: astore_2
        //   82: iconst_0
        //   83: istore_1
        //   84: aconst_null
        //   85: astore_2
        //   86: goto -44 -> 42
        //   89: astore_2
        //   90: aconst_null
        //   91: astore_2
        //   92: iconst_m1
        //   93: istore_1
        //   94: goto -52 -> 42
        //   97: astore_2
        //   98: aconst_null
        //   99: astore_2
        //   100: iconst_m1
        //   101: istore_1
        //   102: goto -60 -> 42
        //   105: aload_0
        //   106: iload_1
        //   107: invokespecial 154	com/google/android/gms/internal/ki:a	(I)Lcom/google/android/gms/internal/lc;
        //   110: astore_2
        //   111: goto -65 -> 46
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	114	0	this	ki
        //   41	66	1	i	int
        //   68	1	2	localTimeoutException	java.util.concurrent.TimeoutException
        //   77	1	2	localObject2	Object
        //   81	1	2	localExecutionException	java.util.concurrent.ExecutionException
        //   85	1	2	localObject3	Object
        //   89	1	2	localInterruptedException	InterruptedException
        //   91	1	2	localObject4	Object
        //   97	1	2	localCancellationException	java.util.concurrent.CancellationException
        //   99	12	2	locallc	lc
        //   63	4	3	localObject5	Object
        // Exception table:
        //   from	to	target	type
        //   7	20	63	finally
        //   64	66	63	finally
        //   0	7	68	java/util/concurrent/TimeoutException
        //   20	39	68	java/util/concurrent/TimeoutException
        //   66	68	68	java/util/concurrent/TimeoutException
        //   0	7	81	java/util/concurrent/ExecutionException
        //   20	39	81	java/util/concurrent/ExecutionException
        //   66	68	81	java/util/concurrent/ExecutionException
        //   0	7	89	java/lang/InterruptedException
        //   20	39	89	java/lang/InterruptedException
        //   66	68	89	java/lang/InterruptedException
        //   0	7	97	java/util/concurrent/CancellationException
        //   20	39	97	java/util/concurrent/CancellationException
        //   66	68	97	java/util/concurrent/CancellationException
    }

    public void b() {
        synchronized (this.e) {
            if (this.f != null) {
                this.f.cancel(true);
            }
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ki.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */