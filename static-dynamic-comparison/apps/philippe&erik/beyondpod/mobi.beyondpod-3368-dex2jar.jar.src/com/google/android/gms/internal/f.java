package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public abstract class f
  extends e
{
  private static Method dA;
  private static Method dB;
  private static Method dC;
  private static Method dD;
  private static String dE;
  private static l dF;
  static boolean dG = false;
  private static Method dy;
  private static Method dz;
  private static long startTime = 0L;
  
  protected f(Context paramContext, j paramj, k paramk)
  {
    super(paramContext, paramj, paramk);
  }
  
  static String a(Context paramContext, j paramj)
    throws f.a
  {
    if (dA == null) {
      throw new a();
    }
    try
    {
      paramContext = (ByteBuffer)dA.invoke(null, new Object[] { paramContext });
      if (paramContext == null) {
        throw new a();
      }
    }
    catch (IllegalAccessException paramContext)
    {
      throw new a(paramContext);
      paramContext = paramj.a(paramContext.array(), true);
      return paramContext;
    }
    catch (InvocationTargetException paramContext)
    {
      throw new a(paramContext);
    }
  }
  
  static ArrayList<Long> a(MotionEvent paramMotionEvent, DisplayMetrics paramDisplayMetrics)
    throws f.a
  {
    if ((dB == null) || (paramMotionEvent == null)) {
      throw new a();
    }
    try
    {
      paramMotionEvent = (ArrayList)dB.invoke(null, new Object[] { paramMotionEvent, paramDisplayMetrics });
      return paramMotionEvent;
    }
    catch (IllegalAccessException paramMotionEvent)
    {
      throw new a(paramMotionEvent);
    }
    catch (InvocationTargetException paramMotionEvent)
    {
      throw new a(paramMotionEvent);
    }
  }
  
  /* Error */
  protected static void a(String paramString, Context paramContext, j paramj)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 28	com/google/android/gms/internal/f:dG	Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifne +36 -> 44
    //   11: new 77	com/google/android/gms/internal/l
    //   14: dup
    //   15: aload_2
    //   16: aconst_null
    //   17: invokespecial 80	com/google/android/gms/internal/l:<init>	(Lcom/google/android/gms/internal/j;Ljava/security/SecureRandom;)V
    //   20: putstatic 82	com/google/android/gms/internal/f:dF	Lcom/google/android/gms/internal/l;
    //   23: aload_0
    //   24: putstatic 84	com/google/android/gms/internal/f:dE	Ljava/lang/String;
    //   27: aload_1
    //   28: invokestatic 88	com/google/android/gms/internal/f:e	(Landroid/content/Context;)V
    //   31: invokestatic 91	com/google/android/gms/internal/f:e	()Ljava/lang/Long;
    //   34: invokevirtual 97	java/lang/Long:longValue	()J
    //   37: putstatic 26	com/google/android/gms/internal/f:startTime	J
    //   40: iconst_1
    //   41: putstatic 28	com/google/android/gms/internal/f:dG	Z
    //   44: ldc 2
    //   46: monitorexit
    //   47: return
    //   48: astore_0
    //   49: ldc 2
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    //   54: astore_0
    //   55: goto -11 -> 44
    //   58: astore_0
    //   59: goto -15 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	paramString	String
    //   0	62	1	paramContext	Context
    //   0	62	2	paramj	j
    //   6	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	48	finally
    //   11	44	48	finally
    //   11	44	54	java/lang/UnsupportedOperationException
    //   11	44	58	com/google/android/gms/internal/f$a
  }
  
  static String b(Context paramContext, j paramj)
    throws f.a
  {
    if (dD == null) {
      throw new a();
    }
    try
    {
      paramContext = (ByteBuffer)dD.invoke(null, new Object[] { paramContext });
      if (paramContext == null) {
        throw new a();
      }
    }
    catch (IllegalAccessException paramContext)
    {
      throw new a(paramContext);
      paramContext = paramj.a(paramContext.array(), true);
      return paramContext;
    }
    catch (InvocationTargetException paramContext)
    {
      throw new a(paramContext);
    }
  }
  
  private static String b(byte[] paramArrayOfByte, String paramString)
    throws f.a
  {
    try
    {
      paramArrayOfByte = new String(dF.c(paramArrayOfByte, paramString), "UTF-8");
      return paramArrayOfByte;
    }
    catch (l.a paramArrayOfByte)
    {
      throw new a(paramArrayOfByte);
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new a(paramArrayOfByte);
    }
  }
  
  static String d()
    throws f.a
  {
    if (dE == null) {
      throw new a();
    }
    return dE;
  }
  
  static String d(Context paramContext)
    throws f.a
  {
    if (dC == null) {
      throw new a();
    }
    try
    {
      paramContext = (String)dC.invoke(null, new Object[] { paramContext });
      if (paramContext == null) {
        throw new a();
      }
    }
    catch (IllegalAccessException paramContext)
    {
      throw new a(paramContext);
    }
    catch (InvocationTargetException paramContext)
    {
      throw new a(paramContext);
    }
    return paramContext;
  }
  
  static Long e()
    throws f.a
  {
    if (dy == null) {
      throw new a();
    }
    try
    {
      Long localLong = (Long)dy.invoke(null, new Object[0]);
      return localLong;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new a(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new a(localInvocationTargetException);
    }
  }
  
  private static void e(Context paramContext)
    throws f.a
  {
    try
    {
      arrayOfByte = dF.d(n.getKey());
      localObject1 = dF.c(arrayOfByte, n.i());
      localFile2 = paramContext.getCacheDir();
      localFile1 = localFile2;
      if (localFile2 == null)
      {
        localFile2 = paramContext.getDir("dex", 0);
        localFile1 = localFile2;
        if (localFile2 == null) {
          throw new a();
        }
      }
    }
    catch (FileNotFoundException paramContext)
    {
      byte[] arrayOfByte;
      File localFile1;
      throw new a(paramContext);
      File localFile2 = File.createTempFile("ads", ".jar", localFile1);
      Object localObject2 = new FileOutputStream(localFile2);
      ((FileOutputStream)localObject2).write((byte[])localObject1, 0, localObject1.length);
      ((FileOutputStream)localObject2).close();
      Object localObject3 = new DexClassLoader(localFile2.getAbsolutePath(), localFile1.getAbsolutePath(), null, paramContext.getClassLoader());
      paramContext = ((DexClassLoader)localObject3).loadClass(b(arrayOfByte, n.j()));
      Object localObject1 = ((DexClassLoader)localObject3).loadClass(b(arrayOfByte, n.p()));
      localObject2 = ((DexClassLoader)localObject3).loadClass(b(arrayOfByte, n.n()));
      Class localClass1 = ((DexClassLoader)localObject3).loadClass(b(arrayOfByte, n.t()));
      Class localClass2 = ((DexClassLoader)localObject3).loadClass(b(arrayOfByte, n.l()));
      localObject3 = ((DexClassLoader)localObject3).loadClass(b(arrayOfByte, n.r()));
      dy = paramContext.getMethod(b(arrayOfByte, n.k()), new Class[0]);
      dz = ((Class)localObject1).getMethod(b(arrayOfByte, n.q()), new Class[0]);
      dA = ((Class)localObject2).getMethod(b(arrayOfByte, n.o()), new Class[] { Context.class });
      dB = localClass1.getMethod(b(arrayOfByte, n.u()), new Class[] { MotionEvent.class, DisplayMetrics.class });
      dC = localClass2.getMethod(b(arrayOfByte, n.m()), new Class[] { Context.class });
      dD = ((Class)localObject3).getMethod(b(arrayOfByte, n.s()), new Class[] { Context.class });
      paramContext = localFile2.getName();
      localFile2.delete();
      new File(localFile1, paramContext.replace(".jar", ".dex")).delete();
      return;
    }
    catch (IOException paramContext)
    {
      throw new a(paramContext);
    }
    catch (ClassNotFoundException paramContext)
    {
      throw new a(paramContext);
    }
    catch (l.a paramContext)
    {
      throw new a(paramContext);
    }
    catch (NoSuchMethodException paramContext)
    {
      throw new a(paramContext);
    }
    catch (NullPointerException paramContext)
    {
      throw new a(paramContext);
    }
  }
  
  static String f()
    throws f.a
  {
    if (dz == null) {
      throw new a();
    }
    try
    {
      String str = (String)dz.invoke(null, new Object[0]);
      return str;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new a(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new a(localInvocationTargetException);
    }
  }
  
  /* Error */
  protected void b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: invokestatic 263	com/google/android/gms/internal/f:f	()Ljava/lang/String;
    //   5: invokevirtual 266	com/google/android/gms/internal/f:a	(ILjava/lang/String;)V
    //   8: aload_0
    //   9: iconst_2
    //   10: invokestatic 268	com/google/android/gms/internal/f:d	()Ljava/lang/String;
    //   13: invokevirtual 266	com/google/android/gms/internal/f:a	(ILjava/lang/String;)V
    //   16: aload_0
    //   17: bipush 25
    //   19: invokestatic 91	com/google/android/gms/internal/f:e	()Ljava/lang/Long;
    //   22: invokevirtual 97	java/lang/Long:longValue	()J
    //   25: invokevirtual 271	com/google/android/gms/internal/f:a	(IJ)V
    //   28: aload_0
    //   29: bipush 24
    //   31: aload_1
    //   32: invokestatic 273	com/google/android/gms/internal/f:d	(Landroid/content/Context;)Ljava/lang/String;
    //   35: invokevirtual 266	com/google/android/gms/internal/f:a	(ILjava/lang/String;)V
    //   38: return
    //   39: astore_1
    //   40: return
    //   41: astore_1
    //   42: return
    //   43: astore_2
    //   44: goto -16 -> 28
    //   47: astore_2
    //   48: goto -32 -> 16
    //   51: astore_2
    //   52: goto -44 -> 8
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	f
    //   0	55	1	paramContext	Context
    //   43	1	2	locala1	a
    //   47	1	2	locala2	a
    //   51	1	2	locala3	a
    // Exception table:
    //   from	to	target	type
    //   0	8	39	java/io/IOException
    //   8	16	39	java/io/IOException
    //   16	28	39	java/io/IOException
    //   28	38	39	java/io/IOException
    //   28	38	41	com/google/android/gms/internal/f$a
    //   16	28	43	com/google/android/gms/internal/f$a
    //   8	16	47	com/google/android/gms/internal/f$a
    //   0	8	51	com/google/android/gms/internal/f$a
  }
  
  /* Error */
  protected void c(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_2
    //   2: invokestatic 268	com/google/android/gms/internal/f:d	()Ljava/lang/String;
    //   5: invokevirtual 266	com/google/android/gms/internal/f:a	(ILjava/lang/String;)V
    //   8: aload_0
    //   9: iconst_1
    //   10: invokestatic 263	com/google/android/gms/internal/f:f	()Ljava/lang/String;
    //   13: invokevirtual 266	com/google/android/gms/internal/f:a	(ILjava/lang/String;)V
    //   16: invokestatic 91	com/google/android/gms/internal/f:e	()Ljava/lang/Long;
    //   19: invokevirtual 97	java/lang/Long:longValue	()J
    //   22: lstore_2
    //   23: aload_0
    //   24: bipush 25
    //   26: lload_2
    //   27: invokevirtual 271	com/google/android/gms/internal/f:a	(IJ)V
    //   30: getstatic 26	com/google/android/gms/internal/f:startTime	J
    //   33: lconst_0
    //   34: lcmp
    //   35: ifeq +23 -> 58
    //   38: aload_0
    //   39: bipush 17
    //   41: lload_2
    //   42: getstatic 26	com/google/android/gms/internal/f:startTime	J
    //   45: lsub
    //   46: invokevirtual 271	com/google/android/gms/internal/f:a	(IJ)V
    //   49: aload_0
    //   50: bipush 23
    //   52: getstatic 26	com/google/android/gms/internal/f:startTime	J
    //   55: invokevirtual 271	com/google/android/gms/internal/f:a	(IJ)V
    //   58: aload_0
    //   59: getfield 277	com/google/android/gms/internal/f:du	Landroid/view/MotionEvent;
    //   62: aload_0
    //   63: getfield 281	com/google/android/gms/internal/f:dv	Landroid/util/DisplayMetrics;
    //   66: invokestatic 283	com/google/android/gms/internal/f:a	(Landroid/view/MotionEvent;Landroid/util/DisplayMetrics;)Ljava/util/ArrayList;
    //   69: astore 4
    //   71: aload_0
    //   72: bipush 14
    //   74: aload 4
    //   76: iconst_0
    //   77: invokevirtual 287	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   80: checkcast 93	java/lang/Long
    //   83: invokevirtual 97	java/lang/Long:longValue	()J
    //   86: invokevirtual 271	com/google/android/gms/internal/f:a	(IJ)V
    //   89: aload_0
    //   90: bipush 15
    //   92: aload 4
    //   94: iconst_1
    //   95: invokevirtual 287	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   98: checkcast 93	java/lang/Long
    //   101: invokevirtual 97	java/lang/Long:longValue	()J
    //   104: invokevirtual 271	com/google/android/gms/internal/f:a	(IJ)V
    //   107: aload 4
    //   109: invokevirtual 291	java/util/ArrayList:size	()I
    //   112: iconst_3
    //   113: if_icmplt +21 -> 134
    //   116: aload_0
    //   117: bipush 16
    //   119: aload 4
    //   121: iconst_2
    //   122: invokevirtual 287	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   125: checkcast 93	java/lang/Long
    //   128: invokevirtual 97	java/lang/Long:longValue	()J
    //   131: invokevirtual 271	com/google/android/gms/internal/f:a	(IJ)V
    //   134: aload_0
    //   135: bipush 27
    //   137: aload_1
    //   138: aload_0
    //   139: getfield 295	com/google/android/gms/internal/f:dw	Lcom/google/android/gms/internal/j;
    //   142: invokestatic 297	com/google/android/gms/internal/f:a	(Landroid/content/Context;Lcom/google/android/gms/internal/j;)Ljava/lang/String;
    //   145: invokevirtual 266	com/google/android/gms/internal/f:a	(ILjava/lang/String;)V
    //   148: aload_0
    //   149: bipush 29
    //   151: aload_1
    //   152: aload_0
    //   153: getfield 295	com/google/android/gms/internal/f:dw	Lcom/google/android/gms/internal/j;
    //   156: invokestatic 299	com/google/android/gms/internal/f:b	(Landroid/content/Context;Lcom/google/android/gms/internal/j;)Ljava/lang/String;
    //   159: invokevirtual 266	com/google/android/gms/internal/f:a	(ILjava/lang/String;)V
    //   162: return
    //   163: astore_1
    //   164: return
    //   165: astore_1
    //   166: return
    //   167: astore 4
    //   169: goto -21 -> 148
    //   172: astore 4
    //   174: goto -40 -> 134
    //   177: astore 4
    //   179: goto -121 -> 58
    //   182: astore 4
    //   184: goto -168 -> 16
    //   187: astore 4
    //   189: goto -181 -> 8
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	f
    //   0	192	1	paramContext	Context
    //   22	20	2	l	long
    //   69	51	4	localArrayList	ArrayList
    //   167	1	4	locala1	a
    //   172	1	4	locala2	a
    //   177	1	4	locala3	a
    //   182	1	4	locala4	a
    //   187	1	4	locala5	a
    // Exception table:
    //   from	to	target	type
    //   0	8	163	java/io/IOException
    //   8	16	163	java/io/IOException
    //   16	58	163	java/io/IOException
    //   58	134	163	java/io/IOException
    //   134	148	163	java/io/IOException
    //   148	162	163	java/io/IOException
    //   148	162	165	com/google/android/gms/internal/f$a
    //   134	148	167	com/google/android/gms/internal/f$a
    //   58	134	172	com/google/android/gms/internal/f$a
    //   16	58	177	com/google/android/gms/internal/f$a
    //   8	16	182	com/google/android/gms/internal/f$a
    //   0	8	187	com/google/android/gms/internal/f$a
  }
  
  static class a
    extends Exception
  {
    public a() {}
    
    public a(Throwable paramThrowable)
    {
      super();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */