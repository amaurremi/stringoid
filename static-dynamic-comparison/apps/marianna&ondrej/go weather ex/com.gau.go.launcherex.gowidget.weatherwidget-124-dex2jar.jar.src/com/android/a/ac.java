package com.android.a;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

class ac
{
  public static final boolean a = ab.b;
  private final List b = new ArrayList();
  private boolean c = false;
  
  private long a()
  {
    if (this.b.size() == 0) {
      return 0L;
    }
    long l = ((ad)this.b.get(0)).c;
    return ((ad)this.b.get(this.b.size() - 1)).c - l;
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 28	com/android/a/ac:c	Z
    //   7: aload_0
    //   8: invokespecial 47	com/android/a/ac:a	()J
    //   11: lstore 4
    //   13: lload 4
    //   15: lconst_0
    //   16: lcmp
    //   17: ifgt +6 -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 26	com/android/a/ac:b	Ljava/util/List;
    //   27: iconst_0
    //   28: invokeinterface 39 2 0
    //   33: checkcast 41	com/android/a/ad
    //   36: getfield 44	com/android/a/ad:c	J
    //   39: lstore_2
    //   40: ldc 49
    //   42: iconst_2
    //   43: anewarray 4	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: lload 4
    //   50: invokestatic 55	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   53: aastore
    //   54: dup
    //   55: iconst_1
    //   56: aload_1
    //   57: aastore
    //   58: invokestatic 58	com/android/a/ab:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: aload_0
    //   62: getfield 26	com/android/a/ac:b	Ljava/util/List;
    //   65: invokeinterface 62 1 0
    //   70: astore_1
    //   71: aload_1
    //   72: invokeinterface 68 1 0
    //   77: ifeq -57 -> 20
    //   80: aload_1
    //   81: invokeinterface 72 1 0
    //   86: checkcast 41	com/android/a/ad
    //   89: astore 6
    //   91: aload 6
    //   93: getfield 44	com/android/a/ad:c	J
    //   96: lstore 4
    //   98: ldc 74
    //   100: iconst_3
    //   101: anewarray 4	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: lload 4
    //   108: lload_2
    //   109: lsub
    //   110: invokestatic 55	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   113: aastore
    //   114: dup
    //   115: iconst_1
    //   116: aload 6
    //   118: getfield 76	com/android/a/ad:b	J
    //   121: invokestatic 55	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   124: aastore
    //   125: dup
    //   126: iconst_2
    //   127: aload 6
    //   129: getfield 79	com/android/a/ad:a	Ljava/lang/String;
    //   132: aastore
    //   133: invokestatic 58	com/android/a/ab:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   136: lload 4
    //   138: lstore_2
    //   139: goto -68 -> 71
    //   142: astore_1
    //   143: aload_0
    //   144: monitorexit
    //   145: aload_1
    //   146: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	ac
    //   0	147	1	paramString	String
    //   39	100	2	l1	long
    //   11	126	4	l2	long
    //   89	39	6	localad	ad
    // Exception table:
    //   from	to	target	type
    //   2	13	142	finally
    //   23	71	142	finally
    //   71	136	142	finally
  }
  
  public void a(String paramString, long paramLong)
  {
    try
    {
      if (this.c) {
        throw new IllegalStateException("Marker added to finished log");
      }
    }
    finally {}
    this.b.add(new ad(paramString, paramLong, SystemClock.elapsedRealtime()));
  }
  
  protected void finalize()
  {
    if (!this.c)
    {
      a("Request on the loose");
      ab.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/android/a/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */