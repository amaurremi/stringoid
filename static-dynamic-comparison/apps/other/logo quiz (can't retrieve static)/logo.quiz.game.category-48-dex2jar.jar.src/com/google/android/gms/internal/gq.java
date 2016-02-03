package com.google.android.gms.internal;

import android.content.Context;

@ez
public final class gq
  extends gg
{
  private final Context mContext;
  private final String mv;
  private final String uR;
  private String vW = null;
  
  public gq(Context paramContext, String paramString1, String paramString2)
  {
    this.mContext = paramContext;
    this.mv = paramString1;
    this.uR = paramString2;
  }
  
  public gq(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.mContext = paramContext;
    this.mv = paramString1;
    this.uR = paramString2;
    this.vW = paramString3;
  }
  
  /* Error */
  public void cp()
  {
    // Byte code:
    //   0: new 33	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   7: ldc 36
    //   9: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12: aload_0
    //   13: getfield 24	com/google/android/gms/internal/gq:uR	Ljava/lang/String;
    //   16: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 50	com/google/android/gms/internal/gs:V	(Ljava/lang/String;)V
    //   25: new 52	java/net/URL
    //   28: dup
    //   29: aload_0
    //   30: getfield 24	com/google/android/gms/internal/gq:uR	Ljava/lang/String;
    //   33: invokespecial 54	java/net/URL:<init>	(Ljava/lang/String;)V
    //   36: invokevirtual 58	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   39: checkcast 60	java/net/HttpURLConnection
    //   42: astore_2
    //   43: aload_0
    //   44: getfield 18	com/google/android/gms/internal/gq:vW	Ljava/lang/String;
    //   47: ifnonnull +74 -> 121
    //   50: aload_0
    //   51: getfield 20	com/google/android/gms/internal/gq:mContext	Landroid/content/Context;
    //   54: aload_0
    //   55: getfield 22	com/google/android/gms/internal/gq:mv	Ljava/lang/String;
    //   58: iconst_1
    //   59: aload_2
    //   60: invokestatic 66	com/google/android/gms/internal/gj:a	(Landroid/content/Context;Ljava/lang/String;ZLjava/net/HttpURLConnection;)V
    //   63: aload_2
    //   64: invokevirtual 70	java/net/HttpURLConnection:getResponseCode	()I
    //   67: istore_1
    //   68: iload_1
    //   69: sipush 200
    //   72: if_icmplt +10 -> 82
    //   75: iload_1
    //   76: sipush 300
    //   79: if_icmplt +37 -> 116
    //   82: new 33	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   89: ldc 72
    //   91: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: iload_1
    //   95: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   98: ldc 77
    //   100: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_0
    //   104: getfield 24	com/google/android/gms/internal/gq:uR	Ljava/lang/String;
    //   107: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 80	com/google/android/gms/internal/gs:W	(Ljava/lang/String;)V
    //   116: aload_2
    //   117: invokevirtual 83	java/net/HttpURLConnection:disconnect	()V
    //   120: return
    //   121: aload_0
    //   122: getfield 20	com/google/android/gms/internal/gq:mContext	Landroid/content/Context;
    //   125: aload_0
    //   126: getfield 22	com/google/android/gms/internal/gq:mv	Ljava/lang/String;
    //   129: iconst_1
    //   130: aload_2
    //   131: aload_0
    //   132: getfield 18	com/google/android/gms/internal/gq:vW	Ljava/lang/String;
    //   135: invokestatic 86	com/google/android/gms/internal/gj:a	(Landroid/content/Context;Ljava/lang/String;ZLjava/net/HttpURLConnection;Ljava/lang/String;)V
    //   138: goto -75 -> 63
    //   141: astore_3
    //   142: aload_2
    //   143: invokevirtual 83	java/net/HttpURLConnection:disconnect	()V
    //   146: aload_3
    //   147: athrow
    //   148: astore_2
    //   149: new 33	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   156: ldc 88
    //   158: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_0
    //   162: getfield 24	com/google/android/gms/internal/gq:uR	Ljava/lang/String;
    //   165: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: ldc 90
    //   170: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload_2
    //   174: invokevirtual 93	java/lang/IndexOutOfBoundsException:getMessage	()Ljava/lang/String;
    //   177: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 80	com/google/android/gms/internal/gs:W	(Ljava/lang/String;)V
    //   186: return
    //   187: astore_2
    //   188: new 33	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   195: ldc 95
    //   197: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload_0
    //   201: getfield 24	com/google/android/gms/internal/gq:uR	Ljava/lang/String;
    //   204: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: ldc 90
    //   209: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload_2
    //   213: invokevirtual 96	java/io/IOException:getMessage	()Ljava/lang/String;
    //   216: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 80	com/google/android/gms/internal/gs:W	(Ljava/lang/String;)V
    //   225: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	this	gq
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
  
  public void onStop() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/gq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */