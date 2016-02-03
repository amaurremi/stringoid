package com.admob.android.ads;

import java.lang.ref.WeakReference;

final class a
  extends Thread
{
  private WeakReference<AdView> a;
  
  public a(AdView paramAdView)
  {
    this.a = new WeakReference(paramAdView);
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	com/admob/android/ads/a:a	Ljava/lang/ref/WeakReference;
    //   4: invokevirtual 27	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   7: checkcast 29	com/admob/android/ads/AdView
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull +71 -> 83
    //   15: aload_2
    //   16: invokevirtual 33	com/admob/android/ads/AdView:getContext	()Landroid/content/Context;
    //   19: astore_3
    //   20: new 35	com/admob/android/ads/g
    //   23: dup
    //   24: aconst_null
    //   25: aload_3
    //   26: aload_2
    //   27: invokespecial 38	com/admob/android/ads/g:<init>	(Lcom/admob/android/ads/d;Landroid/content/Context;Lcom/admob/android/ads/AdView;)V
    //   30: astore 4
    //   32: aload_2
    //   33: invokevirtual 42	com/admob/android/ads/AdView:getMeasuredWidth	()I
    //   36: i2f
    //   37: invokestatic 46	com/admob/android/ads/g:c	()F
    //   40: fdiv
    //   41: f2i
    //   42: istore_1
    //   43: iload_1
    //   44: i2f
    //   45: ldc 47
    //   47: fcmpg
    //   48: ifgt +36 -> 84
    //   51: ldc 49
    //   53: iconst_3
    //   54: invokestatic 55	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   57: ifeq +11 -> 68
    //   60: ldc 49
    //   62: ldc 57
    //   64: invokestatic 61	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   67: pop
    //   68: aload_2
    //   69: invokestatic 63	com/admob/android/ads/AdView:c	(Lcom/admob/android/ads/AdView;)V
    //   72: aload_2
    //   73: iconst_0
    //   74: invokestatic 66	com/admob/android/ads/AdView:a	(Lcom/admob/android/ads/AdView;Z)Z
    //   77: pop
    //   78: aload_2
    //   79: iconst_1
    //   80: invokestatic 70	com/admob/android/ads/AdView:b	(Lcom/admob/android/ads/AdView;Z)V
    //   83: return
    //   84: aload_2
    //   85: invokestatic 73	com/admob/android/ads/AdView:d	(Lcom/admob/android/ads/AdView;)Lcom/admob/android/ads/d$a;
    //   88: aload_3
    //   89: aload_2
    //   90: invokestatic 77	com/admob/android/ads/AdView:e	(Lcom/admob/android/ads/AdView;)Ljava/lang/String;
    //   93: aload_2
    //   94: invokestatic 80	com/admob/android/ads/AdView:f	(Lcom/admob/android/ads/AdView;)Ljava/lang/String;
    //   97: aload_2
    //   98: invokevirtual 83	com/admob/android/ads/AdView:getPrimaryTextColor	()I
    //   101: aload_2
    //   102: invokevirtual 86	com/admob/android/ads/AdView:getSecondaryTextColor	()I
    //   105: aload_2
    //   106: invokevirtual 89	com/admob/android/ads/AdView:getBackgroundColor	()I
    //   109: aload 4
    //   111: iload_1
    //   112: invokestatic 94	com/admob/android/ads/u:a	(Lcom/admob/android/ads/d$a;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;IIILcom/admob/android/ads/g;I)Lcom/admob/android/ads/d;
    //   115: ifnonnull -43 -> 72
    //   118: aload_2
    //   119: invokestatic 63	com/admob/android/ads/AdView:c	(Lcom/admob/android/ads/AdView;)V
    //   122: goto -50 -> 72
    //   125: astore_3
    //   126: ldc 49
    //   128: ldc 96
    //   130: aload_3
    //   131: invokestatic 99	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   134: pop
    //   135: aload_2
    //   136: invokestatic 63	com/admob/android/ads/AdView:c	(Lcom/admob/android/ads/AdView;)V
    //   139: aload_2
    //   140: iconst_0
    //   141: invokestatic 66	com/admob/android/ads/AdView:a	(Lcom/admob/android/ads/AdView;Z)Z
    //   144: pop
    //   145: aload_2
    //   146: iconst_1
    //   147: invokestatic 70	com/admob/android/ads/AdView:b	(Lcom/admob/android/ads/AdView;Z)V
    //   150: return
    //   151: astore_3
    //   152: aload_2
    //   153: iconst_0
    //   154: invokestatic 66	com/admob/android/ads/AdView:a	(Lcom/admob/android/ads/AdView;Z)Z
    //   157: pop
    //   158: aload_2
    //   159: iconst_1
    //   160: invokestatic 70	com/admob/android/ads/AdView:b	(Lcom/admob/android/ads/AdView;Z)V
    //   163: aload_3
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	a
    //   42	70	1	i	int
    //   10	149	2	localAdView	AdView
    //   19	70	3	localContext	android.content.Context
    //   125	6	3	localException	Exception
    //   151	13	3	localObject	Object
    //   30	80	4	localg	g
    // Exception table:
    //   from	to	target	type
    //   15	43	125	java/lang/Exception
    //   51	68	125	java/lang/Exception
    //   68	72	125	java/lang/Exception
    //   84	122	125	java/lang/Exception
    //   15	43	151	finally
    //   51	68	151	finally
    //   68	72	151	finally
    //   84	122	151	finally
    //   126	139	151	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/hangman/com.games.HangManGame-14-dex2jar.jar!/com/admob/android/ads/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */