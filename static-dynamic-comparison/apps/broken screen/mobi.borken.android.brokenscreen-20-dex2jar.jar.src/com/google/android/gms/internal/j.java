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

public abstract class j
  extends i
{
  private static Method jS;
  private static Method jT;
  private static Method jU;
  private static Method jV;
  private static Method jW;
  private static Method jX;
  private static String jY;
  private static p jZ;
  static boolean ka = false;
  private static long startTime = 0L;
  
  protected j(Context paramContext, n paramn, o paramo)
  {
    super(paramContext, paramn, paramo);
  }
  
  static String a(Context paramContext, n paramn)
    throws j.a
  {
    if (jU == null) {
      throw new a();
    }
    try
    {
      paramContext = (ByteBuffer)jU.invoke(null, new Object[] { paramContext });
      if (paramContext == null) {
        throw new a();
      }
    }
    catch (IllegalAccessException paramContext)
    {
      throw new a(paramContext);
      paramContext = paramn.a(paramContext.array(), true);
      return paramContext;
    }
    catch (InvocationTargetException paramContext)
    {
      throw new a(paramContext);
    }
  }
  
  static ArrayList<Long> a(MotionEvent paramMotionEvent, DisplayMetrics paramDisplayMetrics)
    throws j.a
  {
    if ((jV == null) || (paramMotionEvent == null)) {
      throw new a();
    }
    try
    {
      paramMotionEvent = (ArrayList)jV.invoke(null, new Object[] { paramMotionEvent, paramDisplayMetrics });
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
  protected static void a(String paramString, Context paramContext, n paramn)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 28	com/google/android/gms/internal/j:ka	Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifne +36 -> 44
    //   11: new 77	com/google/android/gms/internal/p
    //   14: dup
    //   15: aload_2
    //   16: aconst_null
    //   17: invokespecial 80	com/google/android/gms/internal/p:<init>	(Lcom/google/android/gms/internal/n;Ljava/security/SecureRandom;)V
    //   20: putstatic 82	com/google/android/gms/internal/j:jZ	Lcom/google/android/gms/internal/p;
    //   23: aload_0
    //   24: putstatic 84	com/google/android/gms/internal/j:jY	Ljava/lang/String;
    //   27: aload_1
    //   28: invokestatic 88	com/google/android/gms/internal/j:e	(Landroid/content/Context;)V
    //   31: invokestatic 92	com/google/android/gms/internal/j:w	()Ljava/lang/Long;
    //   34: invokevirtual 98	java/lang/Long:longValue	()J
    //   37: putstatic 26	com/google/android/gms/internal/j:startTime	J
    //   40: iconst_1
    //   41: putstatic 28	com/google/android/gms/internal/j:ka	Z
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
    //   0	62	2	paramn	n
    //   6	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	48	finally
    //   11	44	48	finally
    //   11	44	54	java/lang/UnsupportedOperationException
    //   11	44	58	com/google/android/gms/internal/j$a
  }
  
  static String b(Context paramContext, n paramn)
    throws j.a
  {
    if (jX == null) {
      throw new a();
    }
    try
    {
      paramContext = (ByteBuffer)jX.invoke(null, new Object[] { paramContext });
      if (paramContext == null) {
        throw new a();
      }
    }
    catch (IllegalAccessException paramContext)
    {
      throw new a(paramContext);
      paramContext = paramn.a(paramContext.array(), true);
      return paramContext;
    }
    catch (InvocationTargetException paramContext)
    {
      throw new a(paramContext);
    }
  }
  
  private static String b(byte[] paramArrayOfByte, String paramString)
    throws j.a
  {
    try
    {
      paramArrayOfByte = new String(jZ.c(paramArrayOfByte, paramString), "UTF-8");
      return paramArrayOfByte;
    }
    catch (p.a paramArrayOfByte)
    {
      throw new a(paramArrayOfByte);
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new a(paramArrayOfByte);
    }
  }
  
  static String d(Context paramContext)
    throws j.a
  {
    if (jW == null) {
      throw new a();
    }
    try
    {
      paramContext = (String)jW.invoke(null, new Object[] { paramContext });
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
  
  private static void e(Context paramContext)
    throws j.a
  {
    try
    {
      arrayOfByte = jZ.b(r.getKey());
      localObject1 = jZ.c(arrayOfByte, r.A());
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
      paramContext = ((DexClassLoader)localObject3).loadClass(b(arrayOfByte, r.B()));
      Object localObject1 = ((DexClassLoader)localObject3).loadClass(b(arrayOfByte, r.H()));
      localObject2 = ((DexClassLoader)localObject3).loadClass(b(arrayOfByte, r.F()));
      Class localClass1 = ((DexClassLoader)localObject3).loadClass(b(arrayOfByte, r.L()));
      Class localClass2 = ((DexClassLoader)localObject3).loadClass(b(arrayOfByte, r.D()));
      localObject3 = ((DexClassLoader)localObject3).loadClass(b(arrayOfByte, r.J()));
      jS = paramContext.getMethod(b(arrayOfByte, r.C()), new Class[0]);
      jT = ((Class)localObject1).getMethod(b(arrayOfByte, r.I()), new Class[0]);
      jU = ((Class)localObject2).getMethod(b(arrayOfByte, r.G()), new Class[] { Context.class });
      jV = localClass1.getMethod(b(arrayOfByte, r.M()), new Class[] { MotionEvent.class, DisplayMetrics.class });
      jW = localClass2.getMethod(b(arrayOfByte, r.E()), new Class[] { Context.class });
      jX = ((Class)localObject3).getMethod(b(arrayOfByte, r.K()), new Class[] { Context.class });
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
    catch (p.a paramContext)
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
  
  static String v()
    throws j.a
  {
    if (jY == null) {
      throw new a();
    }
    return jY;
  }
  
  static Long w()
    throws j.a
  {
    if (jS == null) {
      throw new a();
    }
    try
    {
      Long localLong = (Long)jS.invoke(null, new Object[0]);
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
  
  static String x()
    throws j.a
  {
    if (jT == null) {
      throw new a();
    }
    try
    {
      String str = (String)jT.invoke(null, new Object[0]);
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
    //   2: invokestatic 264	com/google/android/gms/internal/j:x	()Ljava/lang/String;
    //   5: invokevirtual 267	com/google/android/gms/internal/j:a	(ILjava/lang/String;)V
    //   8: aload_0
    //   9: iconst_2
    //   10: invokestatic 269	com/google/android/gms/internal/j:v	()Ljava/lang/String;
    //   13: invokevirtual 267	com/google/android/gms/internal/j:a	(ILjava/lang/String;)V
    //   16: aload_0
    //   17: bipush 25
    //   19: invokestatic 92	com/google/android/gms/internal/j:w	()Ljava/lang/Long;
    //   22: invokevirtual 98	java/lang/Long:longValue	()J
    //   25: invokevirtual 272	com/google/android/gms/internal/j:a	(IJ)V
    //   28: aload_0
    //   29: bipush 24
    //   31: aload_1
    //   32: invokestatic 274	com/google/android/gms/internal/j:d	(Landroid/content/Context;)Ljava/lang/String;
    //   35: invokevirtual 267	com/google/android/gms/internal/j:a	(ILjava/lang/String;)V
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
    //   0	55	0	this	j
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
    //   28	38	41	com/google/android/gms/internal/j$a
    //   16	28	43	com/google/android/gms/internal/j$a
    //   8	16	47	com/google/android/gms/internal/j$a
    //   0	8	51	com/google/android/gms/internal/j$a
  }
  
  /* Error */
  protected void c(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_2
    //   2: invokestatic 269	com/google/android/gms/internal/j:v	()Ljava/lang/String;
    //   5: invokevirtual 267	com/google/android/gms/internal/j:a	(ILjava/lang/String;)V
    //   8: aload_0
    //   9: iconst_1
    //   10: invokestatic 264	com/google/android/gms/internal/j:x	()Ljava/lang/String;
    //   13: invokevirtual 267	com/google/android/gms/internal/j:a	(ILjava/lang/String;)V
    //   16: invokestatic 92	com/google/android/gms/internal/j:w	()Ljava/lang/Long;
    //   19: invokevirtual 98	java/lang/Long:longValue	()J
    //   22: lstore_2
    //   23: aload_0
    //   24: bipush 25
    //   26: lload_2
    //   27: invokevirtual 272	com/google/android/gms/internal/j:a	(IJ)V
    //   30: getstatic 26	com/google/android/gms/internal/j:startTime	J
    //   33: lconst_0
    //   34: lcmp
    //   35: ifeq +23 -> 58
    //   38: aload_0
    //   39: bipush 17
    //   41: lload_2
    //   42: getstatic 26	com/google/android/gms/internal/j:startTime	J
    //   45: lsub
    //   46: invokevirtual 272	com/google/android/gms/internal/j:a	(IJ)V
    //   49: aload_0
    //   50: bipush 23
    //   52: getstatic 26	com/google/android/gms/internal/j:startTime	J
    //   55: invokevirtual 272	com/google/android/gms/internal/j:a	(IJ)V
    //   58: aload_0
    //   59: getfield 278	com/google/android/gms/internal/j:jO	Landroid/view/MotionEvent;
    //   62: aload_0
    //   63: getfield 282	com/google/android/gms/internal/j:jP	Landroid/util/DisplayMetrics;
    //   66: invokestatic 284	com/google/android/gms/internal/j:a	(Landroid/view/MotionEvent;Landroid/util/DisplayMetrics;)Ljava/util/ArrayList;
    //   69: astore 4
    //   71: aload_0
    //   72: bipush 14
    //   74: aload 4
    //   76: iconst_0
    //   77: invokevirtual 288	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   80: checkcast 94	java/lang/Long
    //   83: invokevirtual 98	java/lang/Long:longValue	()J
    //   86: invokevirtual 272	com/google/android/gms/internal/j:a	(IJ)V
    //   89: aload_0
    //   90: bipush 15
    //   92: aload 4
    //   94: iconst_1
    //   95: invokevirtual 288	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   98: checkcast 94	java/lang/Long
    //   101: invokevirtual 98	java/lang/Long:longValue	()J
    //   104: invokevirtual 272	com/google/android/gms/internal/j:a	(IJ)V
    //   107: aload 4
    //   109: invokevirtual 292	java/util/ArrayList:size	()I
    //   112: iconst_3
    //   113: if_icmplt +21 -> 134
    //   116: aload_0
    //   117: bipush 16
    //   119: aload 4
    //   121: iconst_2
    //   122: invokevirtual 288	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   125: checkcast 94	java/lang/Long
    //   128: invokevirtual 98	java/lang/Long:longValue	()J
    //   131: invokevirtual 272	com/google/android/gms/internal/j:a	(IJ)V
    //   134: aload_0
    //   135: bipush 27
    //   137: aload_1
    //   138: aload_0
    //   139: getfield 296	com/google/android/gms/internal/j:jQ	Lcom/google/android/gms/internal/n;
    //   142: invokestatic 298	com/google/android/gms/internal/j:a	(Landroid/content/Context;Lcom/google/android/gms/internal/n;)Ljava/lang/String;
    //   145: invokevirtual 267	com/google/android/gms/internal/j:a	(ILjava/lang/String;)V
    //   148: aload_0
    //   149: bipush 29
    //   151: aload_1
    //   152: aload_0
    //   153: getfield 296	com/google/android/gms/internal/j:jQ	Lcom/google/android/gms/internal/n;
    //   156: invokestatic 300	com/google/android/gms/internal/j:b	(Landroid/content/Context;Lcom/google/android/gms/internal/n;)Ljava/lang/String;
    //   159: invokevirtual 267	com/google/android/gms/internal/j:a	(ILjava/lang/String;)V
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
    //   0	192	0	this	j
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
    //   148	162	165	com/google/android/gms/internal/j$a
    //   134	148	167	com/google/android/gms/internal/j$a
    //   58	134	172	com/google/android/gms/internal/j$a
    //   16	58	177	com/google/android/gms/internal/j$a
    //   8	16	182	com/google/android/gms/internal/j$a
    //   0	8	187	com/google/android/gms/internal/j$a
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */