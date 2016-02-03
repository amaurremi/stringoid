package com.google.android.gms.internal;

import android.content.Context;

@ii
public final class mu
        extends lo {
    private final String a;
    private final Context b;
    private final String c;
    private String d = null;

    public mu(Context paramContext, String paramString1, String paramString2) {
        this.b = paramContext;
        this.a = paramString1;
        this.c = paramString2;
    }

    public mu(Context paramContext, String paramString1, String paramString2, String paramString3) {
        this.b = paramContext;
        this.a = paramString1;
        this.c = paramString2;
        this.d = paramString3;
    }

    /* Error */
    public void a() {
        // Byte code:
        //   0: new 32	java/lang/StringBuilder
        //   3: dup
        //   4: invokespecial 33	java/lang/StringBuilder:<init>	()V
        //   7: ldc 35
        //   9: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   12: aload_0
        //   13: getfield 24	com/google/android/gms/internal/mu:c	Ljava/lang/String;
        //   16: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   19: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   22: invokestatic 48	com/google/android/gms/internal/mx:d	(Ljava/lang/String;)V
        //   25: new 50	java/net/URL
        //   28: dup
        //   29: aload_0
        //   30: getfield 24	com/google/android/gms/internal/mu:c	Ljava/lang/String;
        //   33: invokespecial 52	java/net/URL:<init>	(Ljava/lang/String;)V
        //   36: invokevirtual 56	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   39: checkcast 58	java/net/HttpURLConnection
        //   42: astore_2
        //   43: aload_0
        //   44: getfield 18	com/google/android/gms/internal/mu:d	Ljava/lang/String;
        //   47: ifnonnull +74 -> 121
        //   50: aload_0
        //   51: getfield 20	com/google/android/gms/internal/mu:b	Landroid/content/Context;
        //   54: aload_0
        //   55: getfield 22	com/google/android/gms/internal/mu:a	Ljava/lang/String;
        //   58: iconst_1
        //   59: aload_2
        //   60: invokestatic 63	com/google/android/gms/internal/lw:a	(Landroid/content/Context;Ljava/lang/String;ZLjava/net/HttpURLConnection;)V
        //   63: aload_2
        //   64: invokevirtual 67	java/net/HttpURLConnection:getResponseCode	()I
        //   67: istore_1
        //   68: iload_1
        //   69: sipush 200
        //   72: if_icmplt +10 -> 82
        //   75: iload_1
        //   76: sipush 300
        //   79: if_icmplt +37 -> 116
        //   82: new 32	java/lang/StringBuilder
        //   85: dup
        //   86: invokespecial 33	java/lang/StringBuilder:<init>	()V
        //   89: ldc 69
        //   91: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   94: iload_1
        //   95: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   98: ldc 74
        //   100: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   103: aload_0
        //   104: getfield 24	com/google/android/gms/internal/mu:c	Ljava/lang/String;
        //   107: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   110: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   113: invokestatic 77	com/google/android/gms/internal/mx:e	(Ljava/lang/String;)V
        //   116: aload_2
        //   117: invokevirtual 80	java/net/HttpURLConnection:disconnect	()V
        //   120: return
        //   121: aload_0
        //   122: getfield 20	com/google/android/gms/internal/mu:b	Landroid/content/Context;
        //   125: aload_0
        //   126: getfield 22	com/google/android/gms/internal/mu:a	Ljava/lang/String;
        //   129: iconst_1
        //   130: aload_2
        //   131: aload_0
        //   132: getfield 18	com/google/android/gms/internal/mu:d	Ljava/lang/String;
        //   135: invokestatic 83	com/google/android/gms/internal/lw:a	(Landroid/content/Context;Ljava/lang/String;ZLjava/net/HttpURLConnection;Ljava/lang/String;)V
        //   138: goto -75 -> 63
        //   141: astore_3
        //   142: aload_2
        //   143: invokevirtual 80	java/net/HttpURLConnection:disconnect	()V
        //   146: aload_3
        //   147: athrow
        //   148: astore_2
        //   149: new 32	java/lang/StringBuilder
        //   152: dup
        //   153: invokespecial 33	java/lang/StringBuilder:<init>	()V
        //   156: ldc 85
        //   158: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   161: aload_0
        //   162: getfield 24	com/google/android/gms/internal/mu:c	Ljava/lang/String;
        //   165: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   168: ldc 87
        //   170: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   173: aload_2
        //   174: invokevirtual 90	java/lang/IndexOutOfBoundsException:getMessage	()Ljava/lang/String;
        //   177: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   180: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   183: invokestatic 77	com/google/android/gms/internal/mx:e	(Ljava/lang/String;)V
        //   186: return
        //   187: astore_2
        //   188: new 32	java/lang/StringBuilder
        //   191: dup
        //   192: invokespecial 33	java/lang/StringBuilder:<init>	()V
        //   195: ldc 92
        //   197: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   200: aload_0
        //   201: getfield 24	com/google/android/gms/internal/mu:c	Ljava/lang/String;
        //   204: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   207: ldc 87
        //   209: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   212: aload_2
        //   213: invokevirtual 93	java/io/IOException:getMessage	()Ljava/lang/String;
        //   216: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   219: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   222: invokestatic 77	com/google/android/gms/internal/mx:e	(Ljava/lang/String;)V
        //   225: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	226	0	this	mu
        //   67	28	1	i	int
        //   42	101	2	localHttpURLConnection	java.net.HttpURLConnection
        //   148	26	2	localIndexOutOfBoundsException	IndexOutOfBoundsException
        //   187	26	2	localIOException	java.io.IOException
        //   141	6	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   43	63	141	finally
        //   63	68	141	finally
        //   82	116	141	finally
        //   121	138	141	finally
        //   0	43	148	java/lang/IndexOutOfBoundsException
        //   116	120	148	java/lang/IndexOutOfBoundsException
        //   142	148	148	java/lang/IndexOutOfBoundsException
        //   0	43	187	java/io/IOException
        //   116	120	187	java/io/IOException
        //   142	148	187	java/io/IOException
    }

    public void b() {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/mu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */