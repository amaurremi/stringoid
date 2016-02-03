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

public abstract class i
  extends h
{
  private static Method jS;
  private static Method jT;
  private static Method jU;
  private static Method jV;
  private static Method jW;
  private static Method jX;
  private static Method jY;
  private static Method jZ;
  private static String ka;
  private static o kb;
  static boolean kc = false;
  private static long startTime = 0L;
  
  protected i(Context paramContext, m paramm, qg paramqg)
  {
    super(paramContext, paramm, paramqg);
  }
  
  static String a(Context paramContext, m paramm)
  {
    if (jV == null) {
      throw new ow();
    }
    try
    {
      paramContext = (ByteBuffer)jV.invoke(null, new Object[] { paramContext });
      if (paramContext == null) {
        throw new ow();
      }
    }
    catch (IllegalAccessException paramContext)
    {
      throw new ow(paramContext);
      paramContext = paramm.a(paramContext.array(), true);
      return paramContext;
    }
    catch (InvocationTargetException paramContext)
    {
      throw new ow(paramContext);
    }
  }
  
  static ArrayList<Long> a(MotionEvent paramMotionEvent, DisplayMetrics paramDisplayMetrics)
  {
    if ((jW == null) || (paramMotionEvent == null)) {
      throw new ow();
    }
    try
    {
      paramMotionEvent = (ArrayList)jW.invoke(null, new Object[] { paramMotionEvent, paramDisplayMetrics });
      return paramMotionEvent;
    }
    catch (IllegalAccessException paramMotionEvent)
    {
      throw new ow(paramMotionEvent);
    }
    catch (InvocationTargetException paramMotionEvent)
    {
      throw new ow(paramMotionEvent);
    }
  }
  
  /* Error */
  protected static void a(String paramString, Context paramContext, m paramm)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 27	com/google/android/gms/internal/i:kc	Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifne +36 -> 44
    //   11: new 78	com/google/android/gms/internal/o
    //   14: dup
    //   15: aload_2
    //   16: aconst_null
    //   17: invokespecial 81	com/google/android/gms/internal/o:<init>	(Lcom/google/android/gms/internal/m;Ljava/security/SecureRandom;)V
    //   20: putstatic 83	com/google/android/gms/internal/i:kb	Lcom/google/android/gms/internal/o;
    //   23: aload_0
    //   24: putstatic 85	com/google/android/gms/internal/i:ka	Ljava/lang/String;
    //   27: aload_1
    //   28: invokestatic 89	com/google/android/gms/internal/i:h	(Landroid/content/Context;)V
    //   31: invokestatic 93	com/google/android/gms/internal/i:w	()Ljava/lang/Long;
    //   34: invokevirtual 99	java/lang/Long:longValue	()J
    //   37: putstatic 25	com/google/android/gms/internal/i:startTime	J
    //   40: iconst_1
    //   41: putstatic 27	com/google/android/gms/internal/i:kc	Z
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
    //   0	62	2	paramm	m
    //   6	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	48	finally
    //   11	44	48	finally
    //   11	44	54	java/lang/UnsupportedOperationException
    //   11	44	58	com/google/android/gms/internal/ow
  }
  
  static String b(Context paramContext, m paramm)
  {
    if (jY == null) {
      throw new ow();
    }
    try
    {
      paramContext = (ByteBuffer)jY.invoke(null, new Object[] { paramContext });
      if (paramContext == null) {
        throw new ow();
      }
    }
    catch (IllegalAccessException paramContext)
    {
      throw new ow(paramContext);
      paramContext = paramm.a(paramContext.array(), true);
      return paramContext;
    }
    catch (InvocationTargetException paramContext)
    {
      throw new ow(paramContext);
    }
  }
  
  private static String b(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      paramArrayOfByte = new String(kb.c(paramArrayOfByte, paramString), "UTF-8");
      return paramArrayOfByte;
    }
    catch (o.a paramArrayOfByte)
    {
      throw new ow(paramArrayOfByte);
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new ow(paramArrayOfByte);
    }
  }
  
  static String f(Context paramContext)
  {
    if (jX == null) {
      throw new ow();
    }
    try
    {
      paramContext = (String)jX.invoke(null, new Object[] { paramContext });
      if (paramContext == null) {
        throw new ow();
      }
    }
    catch (IllegalAccessException paramContext)
    {
      throw new ow(paramContext);
    }
    catch (InvocationTargetException paramContext)
    {
      throw new ow(paramContext);
    }
    return paramContext;
  }
  
  static ArrayList<Long> g(Context paramContext)
  {
    if (jZ == null) {
      throw new ow();
    }
    try
    {
      paramContext = (ArrayList)jZ.invoke(null, new Object[] { paramContext });
      if ((paramContext == null) || (paramContext.size() != 2)) {
        throw new ow();
      }
    }
    catch (IllegalAccessException paramContext)
    {
      throw new ow(paramContext);
    }
    catch (InvocationTargetException paramContext)
    {
      throw new ow(paramContext);
    }
    return paramContext;
  }
  
  private static void h(Context paramContext)
  {
    try
    {
      localObject1 = kb.b(q.getKey());
      localObject2 = kb.c((byte[])localObject1, q.B());
      localFile2 = paramContext.getCacheDir();
      localFile1 = localFile2;
      if (localFile2 == null)
      {
        localFile2 = paramContext.getDir("dex", 0);
        localFile1 = localFile2;
        if (localFile2 == null) {
          throw new ow();
        }
      }
    }
    catch (FileNotFoundException paramContext)
    {
      Object localObject1;
      Object localObject2;
      File localFile1;
      throw new ow(paramContext);
      File localFile2 = File.createTempFile("ads", ".jar", localFile1);
      Object localObject3 = new FileOutputStream(localFile2);
      ((FileOutputStream)localObject3).write((byte[])localObject2, 0, localObject2.length);
      ((FileOutputStream)localObject3).close();
      try
      {
        Object localObject4 = new DexClassLoader(localFile2.getAbsolutePath(), localFile1.getAbsolutePath(), null, paramContext.getClassLoader());
        paramContext = ((DexClassLoader)localObject4).loadClass(b((byte[])localObject1, q.C()));
        localObject2 = ((DexClassLoader)localObject4).loadClass(b((byte[])localObject1, q.O()));
        localObject3 = ((DexClassLoader)localObject4).loadClass(b((byte[])localObject1, q.I()));
        Class localClass1 = ((DexClassLoader)localObject4).loadClass(b((byte[])localObject1, q.G()));
        Class localClass2 = ((DexClassLoader)localObject4).loadClass(b((byte[])localObject1, q.Q()));
        Class localClass3 = ((DexClassLoader)localObject4).loadClass(b((byte[])localObject1, q.E()));
        Class localClass4 = ((DexClassLoader)localObject4).loadClass(b((byte[])localObject1, q.M()));
        localObject4 = ((DexClassLoader)localObject4).loadClass(b((byte[])localObject1, q.K()));
        jS = paramContext.getMethod(b((byte[])localObject1, q.D()), new Class[0]);
        jT = ((Class)localObject2).getMethod(b((byte[])localObject1, q.P()), new Class[0]);
        jU = ((Class)localObject3).getMethod(b((byte[])localObject1, q.J()), new Class[0]);
        jV = localClass1.getMethod(b((byte[])localObject1, q.H()), new Class[] { Context.class });
        jW = localClass2.getMethod(b((byte[])localObject1, q.R()), new Class[] { MotionEvent.class, DisplayMetrics.class });
        jX = localClass3.getMethod(b((byte[])localObject1, q.F()), new Class[] { Context.class });
        jY = localClass4.getMethod(b((byte[])localObject1, q.N()), new Class[] { Context.class });
        jZ = ((Class)localObject4).getMethod(b((byte[])localObject1, q.L()), new Class[] { Context.class });
        return;
      }
      finally
      {
        localObject1 = localFile2.getName();
        localFile2.delete();
        new File(localFile1, ((String)localObject1).replace(".jar", ".dex")).delete();
      }
    }
    catch (IOException paramContext)
    {
      throw new ow(paramContext);
    }
    catch (ClassNotFoundException paramContext)
    {
      throw new ow(paramContext);
    }
    catch (o.a paramContext)
    {
      throw new ow(paramContext);
    }
    catch (NoSuchMethodException paramContext)
    {
      throw new ow(paramContext);
    }
    catch (NullPointerException paramContext)
    {
      throw new ow(paramContext);
    }
  }
  
  static String v()
  {
    if (ka == null) {
      throw new ow();
    }
    return ka;
  }
  
  static Long w()
  {
    if (jS == null) {
      throw new ow();
    }
    try
    {
      Long localLong = (Long)jS.invoke(null, new Object[0]);
      return localLong;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new ow(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new ow(localInvocationTargetException);
    }
  }
  
  static String x()
  {
    if (jU == null) {
      throw new ow();
    }
    try
    {
      String str = (String)jU.invoke(null, new Object[0]);
      return str;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new ow(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new ow(localInvocationTargetException);
    }
  }
  
  static Long y()
  {
    if (jT == null) {
      throw new ow();
    }
    try
    {
      Long localLong = (Long)jT.invoke(null, new Object[0]);
      return localLong;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new ow(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new ow(localInvocationTargetException);
    }
  }
  
  /* Error */
  protected void c(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: invokestatic 289	com/google/android/gms/internal/i:x	()Ljava/lang/String;
    //   5: invokevirtual 292	com/google/android/gms/internal/i:a	(ILjava/lang/String;)V
    //   8: aload_0
    //   9: iconst_2
    //   10: invokestatic 294	com/google/android/gms/internal/i:v	()Ljava/lang/String;
    //   13: invokevirtual 292	com/google/android/gms/internal/i:a	(ILjava/lang/String;)V
    //   16: aload_0
    //   17: bipush 25
    //   19: invokestatic 93	com/google/android/gms/internal/i:w	()Ljava/lang/Long;
    //   22: invokevirtual 99	java/lang/Long:longValue	()J
    //   25: invokevirtual 297	com/google/android/gms/internal/i:a	(IJ)V
    //   28: aload_1
    //   29: invokestatic 299	com/google/android/gms/internal/i:g	(Landroid/content/Context;)Ljava/util/ArrayList;
    //   32: astore_1
    //   33: aload_0
    //   34: bipush 31
    //   36: aload_1
    //   37: iconst_0
    //   38: invokevirtual 303	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   41: checkcast 95	java/lang/Long
    //   44: invokevirtual 99	java/lang/Long:longValue	()J
    //   47: invokevirtual 297	com/google/android/gms/internal/i:a	(IJ)V
    //   50: aload_0
    //   51: bipush 32
    //   53: aload_1
    //   54: iconst_1
    //   55: invokevirtual 303	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   58: checkcast 95	java/lang/Long
    //   61: invokevirtual 99	java/lang/Long:longValue	()J
    //   64: invokevirtual 297	com/google/android/gms/internal/i:a	(IJ)V
    //   67: aload_0
    //   68: bipush 33
    //   70: invokestatic 305	com/google/android/gms/internal/i:y	()Ljava/lang/Long;
    //   73: invokevirtual 99	java/lang/Long:longValue	()J
    //   76: invokevirtual 297	com/google/android/gms/internal/i:a	(IJ)V
    //   79: return
    //   80: astore_1
    //   81: return
    //   82: astore_1
    //   83: return
    //   84: astore_1
    //   85: goto -18 -> 67
    //   88: astore_2
    //   89: goto -61 -> 28
    //   92: astore_2
    //   93: goto -77 -> 16
    //   96: astore_2
    //   97: goto -89 -> 8
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	i
    //   0	100	1	paramContext	Context
    //   88	1	2	localow1	ow
    //   92	1	2	localow2	ow
    //   96	1	2	localow3	ow
    // Exception table:
    //   from	to	target	type
    //   0	8	80	java/io/IOException
    //   8	16	80	java/io/IOException
    //   16	28	80	java/io/IOException
    //   28	67	80	java/io/IOException
    //   67	79	80	java/io/IOException
    //   67	79	82	com/google/android/gms/internal/ow
    //   28	67	84	com/google/android/gms/internal/ow
    //   16	28	88	com/google/android/gms/internal/ow
    //   8	16	92	com/google/android/gms/internal/ow
    //   0	8	96	com/google/android/gms/internal/ow
  }
  
  /* Error */
  protected void e(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_2
    //   2: invokestatic 294	com/google/android/gms/internal/i:v	()Ljava/lang/String;
    //   5: invokevirtual 292	com/google/android/gms/internal/i:a	(ILjava/lang/String;)V
    //   8: aload_0
    //   9: iconst_1
    //   10: invokestatic 289	com/google/android/gms/internal/i:x	()Ljava/lang/String;
    //   13: invokevirtual 292	com/google/android/gms/internal/i:a	(ILjava/lang/String;)V
    //   16: invokestatic 93	com/google/android/gms/internal/i:w	()Ljava/lang/Long;
    //   19: invokevirtual 99	java/lang/Long:longValue	()J
    //   22: lstore_2
    //   23: aload_0
    //   24: bipush 25
    //   26: lload_2
    //   27: invokevirtual 297	com/google/android/gms/internal/i:a	(IJ)V
    //   30: getstatic 25	com/google/android/gms/internal/i:startTime	J
    //   33: lconst_0
    //   34: lcmp
    //   35: ifeq +23 -> 58
    //   38: aload_0
    //   39: bipush 17
    //   41: lload_2
    //   42: getstatic 25	com/google/android/gms/internal/i:startTime	J
    //   45: lsub
    //   46: invokevirtual 297	com/google/android/gms/internal/i:a	(IJ)V
    //   49: aload_0
    //   50: bipush 23
    //   52: getstatic 25	com/google/android/gms/internal/i:startTime	J
    //   55: invokevirtual 297	com/google/android/gms/internal/i:a	(IJ)V
    //   58: aload_0
    //   59: getfield 310	com/google/android/gms/internal/i:jO	Landroid/view/MotionEvent;
    //   62: aload_0
    //   63: getfield 314	com/google/android/gms/internal/i:jP	Landroid/util/DisplayMetrics;
    //   66: invokestatic 316	com/google/android/gms/internal/i:a	(Landroid/view/MotionEvent;Landroid/util/DisplayMetrics;)Ljava/util/ArrayList;
    //   69: astore 4
    //   71: aload_0
    //   72: bipush 14
    //   74: aload 4
    //   76: iconst_0
    //   77: invokevirtual 303	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   80: checkcast 95	java/lang/Long
    //   83: invokevirtual 99	java/lang/Long:longValue	()J
    //   86: invokevirtual 297	com/google/android/gms/internal/i:a	(IJ)V
    //   89: aload_0
    //   90: bipush 15
    //   92: aload 4
    //   94: iconst_1
    //   95: invokevirtual 303	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   98: checkcast 95	java/lang/Long
    //   101: invokevirtual 99	java/lang/Long:longValue	()J
    //   104: invokevirtual 297	com/google/android/gms/internal/i:a	(IJ)V
    //   107: aload 4
    //   109: invokevirtual 130	java/util/ArrayList:size	()I
    //   112: iconst_3
    //   113: if_icmplt +21 -> 134
    //   116: aload_0
    //   117: bipush 16
    //   119: aload 4
    //   121: iconst_2
    //   122: invokevirtual 303	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   125: checkcast 95	java/lang/Long
    //   128: invokevirtual 99	java/lang/Long:longValue	()J
    //   131: invokevirtual 297	com/google/android/gms/internal/i:a	(IJ)V
    //   134: aload_0
    //   135: bipush 27
    //   137: aload_1
    //   138: aload_0
    //   139: getfield 320	com/google/android/gms/internal/i:jQ	Lcom/google/android/gms/internal/m;
    //   142: invokestatic 322	com/google/android/gms/internal/i:a	(Landroid/content/Context;Lcom/google/android/gms/internal/m;)Ljava/lang/String;
    //   145: invokevirtual 292	com/google/android/gms/internal/i:a	(ILjava/lang/String;)V
    //   148: aload_0
    //   149: bipush 29
    //   151: aload_1
    //   152: aload_0
    //   153: getfield 320	com/google/android/gms/internal/i:jQ	Lcom/google/android/gms/internal/m;
    //   156: invokestatic 324	com/google/android/gms/internal/i:b	(Landroid/content/Context;Lcom/google/android/gms/internal/m;)Ljava/lang/String;
    //   159: invokevirtual 292	com/google/android/gms/internal/i:a	(ILjava/lang/String;)V
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
    //   0	192	0	this	i
    //   0	192	1	paramContext	Context
    //   22	20	2	l	long
    //   69	51	4	localArrayList	ArrayList
    //   167	1	4	localow1	ow
    //   172	1	4	localow2	ow
    //   177	1	4	localow3	ow
    //   182	1	4	localow4	ow
    //   187	1	4	localow5	ow
    // Exception table:
    //   from	to	target	type
    //   0	8	163	java/io/IOException
    //   8	16	163	java/io/IOException
    //   16	58	163	java/io/IOException
    //   58	134	163	java/io/IOException
    //   134	148	163	java/io/IOException
    //   148	162	163	java/io/IOException
    //   148	162	165	com/google/android/gms/internal/ow
    //   134	148	167	com/google/android/gms/internal/ow
    //   58	134	172	com/google/android/gms/internal/ow
    //   16	58	177	com/google/android/gms/internal/ow
    //   8	16	182	com/google/android/gms/internal/ow
    //   0	8	187	com/google/android/gms/internal/ow
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */