package com.vungle.publisher;

import android.os.Handler;
import android.os.Looper;

final class dk
  extends Handler
{
  final dn a;
  boolean b;
  private final int c;
  private final di d;
  
  dk(di paramdi, Looper paramLooper)
  {
    super(paramLooper);
    this.d = paramdi;
    this.c = 10;
    this.a = new dn();
  }
  
  /* Error */
  public final void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: invokestatic 37	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore_2
    //   4: aload_0
    //   5: getfield 28	com/vungle/publisher/dk:a	Lcom/vungle/publisher/dn;
    //   8: invokevirtual 40	com/vungle/publisher/dn:a	()Lcom/vungle/publisher/dm;
    //   11: astore 4
    //   13: aload 4
    //   15: astore_1
    //   16: aload 4
    //   18: ifnonnull +32 -> 50
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 28	com/vungle/publisher/dk:a	Lcom/vungle/publisher/dn;
    //   27: invokevirtual 40	com/vungle/publisher/dn:a	()Lcom/vungle/publisher/dm;
    //   30: astore_1
    //   31: aload_1
    //   32: ifnonnull +16 -> 48
    //   35: aload_0
    //   36: iconst_0
    //   37: putfield 42	com/vungle/publisher/dk:b	Z
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_0
    //   43: iconst_0
    //   44: putfield 42	com/vungle/publisher/dk:b	Z
    //   47: return
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_0
    //   51: getfield 19	com/vungle/publisher/dk:d	Lcom/vungle/publisher/di;
    //   54: aload_1
    //   55: invokevirtual 47	com/vungle/publisher/di:a	(Lcom/vungle/publisher/dm;)V
    //   58: invokestatic 37	android/os/SystemClock:uptimeMillis	()J
    //   61: lload_2
    //   62: lsub
    //   63: aload_0
    //   64: getfield 21	com/vungle/publisher/dk:c	I
    //   67: i2l
    //   68: lcmp
    //   69: iflt -65 -> 4
    //   72: aload_0
    //   73: aload_0
    //   74: invokevirtual 51	com/vungle/publisher/dk:obtainMessage	()Landroid/os/Message;
    //   77: invokevirtual 55	com/vungle/publisher/dk:sendMessage	(Landroid/os/Message;)Z
    //   80: ifne +26 -> 106
    //   83: new 57	com/vungle/publisher/dj
    //   86: dup
    //   87: ldc 59
    //   89: invokespecial 62	com/vungle/publisher/dj:<init>	(Ljava/lang/String;)V
    //   92: athrow
    //   93: astore_1
    //   94: aload_0
    //   95: iconst_0
    //   96: putfield 42	com/vungle/publisher/dk:b	Z
    //   99: aload_1
    //   100: athrow
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: aload_0
    //   107: iconst_1
    //   108: putfield 42	com/vungle/publisher/dk:b	Z
    //   111: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	dk
    //   0	112	1	paramMessage	android.os.Message
    //   3	59	2	l	long
    //   11	6	4	localdm	dm
    // Exception table:
    //   from	to	target	type
    //   0	4	93	finally
    //   4	13	93	finally
    //   21	23	93	finally
    //   48	50	93	finally
    //   50	93	93	finally
    //   102	106	93	finally
    //   23	31	101	finally
    //   35	42	101	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/dk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */