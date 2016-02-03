package com.google.ads;

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

public class ak
  extends aj
{
  static boolean c = false;
  private static Method d = null;
  private static Method e = null;
  private static Method f = null;
  private static Method g = null;
  private static Method h = null;
  private static String i = null;
  private static long j = 0L;
  
  protected ak(Context paramContext)
  {
    super(paramContext);
  }
  
  public static ak a(String paramString, Context paramContext)
  {
    b(paramString, paramContext);
    return new ak(paramContext);
  }
  
  static String a()
    throws ak.a
  {
    if (i == null) {
      throw new a();
    }
    return i;
  }
  
  static ArrayList<Long> a(MotionEvent paramMotionEvent, DisplayMetrics paramDisplayMetrics)
    throws ak.a
  {
    if ((g == null) || (paramMotionEvent == null)) {
      throw new a();
    }
    try
    {
      paramMotionEvent = (ArrayList)g.invoke(null, new Object[] { paramMotionEvent, paramDisplayMetrics });
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
  
  static Long b()
    throws ak.a
  {
    if (d == null) {
      throw new a();
    }
    try
    {
      Long localLong = (Long)d.invoke(null, new Object[0]);
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
  
  private static String b(byte[] paramArrayOfByte, String paramString)
    throws ak.a
  {
    try
    {
      paramArrayOfByte = new String(an.a(paramArrayOfByte, paramString), "UTF-8");
      return paramArrayOfByte;
    }
    catch (an.a paramArrayOfByte)
    {
      throw new a(paramArrayOfByte);
    }
    catch (ap paramArrayOfByte)
    {
      throw new a(paramArrayOfByte);
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new a(paramArrayOfByte);
    }
  }
  
  /* Error */
  protected static void b(String paramString, Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 37	com/google/ads/ak:c	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +24 -> 32
    //   11: aload_0
    //   12: putstatic 33	com/google/ads/ak:i	Ljava/lang/String;
    //   15: aload_1
    //   16: invokestatic 98	com/google/ads/ak:f	(Landroid/content/Context;)V
    //   19: invokestatic 100	com/google/ads/ak:b	()Ljava/lang/Long;
    //   22: invokevirtual 104	java/lang/Long:longValue	()J
    //   25: putstatic 35	com/google/ads/ak:j	J
    //   28: iconst_1
    //   29: putstatic 37	com/google/ads/ak:c	Z
    //   32: ldc 2
    //   34: monitorexit
    //   35: return
    //   36: astore_0
    //   37: ldc 2
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    //   42: astore_0
    //   43: goto -11 -> 32
    //   46: astore_0
    //   47: goto -15 -> 32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	paramString	String
    //   0	50	1	paramContext	Context
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	36	finally
    //   11	32	36	finally
    //   11	32	42	java/lang/UnsupportedOperationException
    //   11	32	46	com/google/ads/ak$a
  }
  
  static String c()
    throws ak.a
  {
    if (e == null) {
      throw new a();
    }
    try
    {
      String str = (String)e.invoke(null, new Object[0]);
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
  
  static String d(Context paramContext)
    throws ak.a
  {
    if (h == null) {
      throw new a();
    }
    try
    {
      paramContext = (String)h.invoke(null, new Object[] { paramContext });
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
  
  static String e(Context paramContext)
    throws ak.a
  {
    if (f == null) {
      throw new a();
    }
    try
    {
      paramContext = (ByteBuffer)f.invoke(null, new Object[] { paramContext });
      if (paramContext == null) {
        throw new a();
      }
    }
    catch (IllegalAccessException paramContext)
    {
      throw new a(paramContext);
      paramContext = aq.a(paramContext.array(), false);
      return paramContext;
    }
    catch (InvocationTargetException paramContext)
    {
      throw new a(paramContext);
    }
  }
  
  private static void f(Context paramContext)
    throws ak.a
  {
    try
    {
      arrayOfByte = an.a(ao.a());
      localObject1 = an.a(arrayOfByte, ao.b());
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
    catch (ap paramContext)
    {
      byte[] arrayOfByte;
      File localFile1;
      throw new a(paramContext);
      File localFile2 = File.createTempFile("ads", ".jar", localFile1);
      Object localObject2 = new FileOutputStream(localFile2);
      ((FileOutputStream)localObject2).write((byte[])localObject1, 0, localObject1.length);
      ((FileOutputStream)localObject2).close();
      Object localObject3 = new DexClassLoader(localFile2.getAbsolutePath(), localFile1.getAbsolutePath(), null, paramContext.getClassLoader());
      paramContext = ((DexClassLoader)localObject3).loadClass(b(arrayOfByte, ao.c()));
      Object localObject1 = ((DexClassLoader)localObject3).loadClass(b(arrayOfByte, ao.i()));
      localObject2 = ((DexClassLoader)localObject3).loadClass(b(arrayOfByte, ao.g()));
      Class localClass = ((DexClassLoader)localObject3).loadClass(b(arrayOfByte, ao.k()));
      localObject3 = ((DexClassLoader)localObject3).loadClass(b(arrayOfByte, ao.e()));
      d = paramContext.getMethod(b(arrayOfByte, ao.d()), new Class[0]);
      e = ((Class)localObject1).getMethod(b(arrayOfByte, ao.j()), new Class[0]);
      f = ((Class)localObject2).getMethod(b(arrayOfByte, ao.h()), new Class[] { Context.class });
      g = localClass.getMethod(b(arrayOfByte, ao.l()), new Class[] { MotionEvent.class, DisplayMetrics.class });
      h = ((Class)localObject3).getMethod(b(arrayOfByte, ao.f()), new Class[] { Context.class });
      paramContext = localFile2.getName();
      localFile2.delete();
      new File(localFile1, paramContext.replace(".jar", ".dex")).delete();
      return;
    }
    catch (FileNotFoundException paramContext)
    {
      throw new a(paramContext);
    }
    catch (IOException paramContext)
    {
      throw new a(paramContext);
    }
    catch (ClassNotFoundException paramContext)
    {
      throw new a(paramContext);
    }
    catch (an.a paramContext)
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
  
  /* Error */
  protected void b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: invokestatic 236	com/google/ads/ak:c	()Ljava/lang/String;
    //   5: invokevirtual 239	com/google/ads/ak:a	(ILjava/lang/String;)V
    //   8: aload_0
    //   9: iconst_2
    //   10: invokestatic 240	com/google/ads/ak:a	()Ljava/lang/String;
    //   13: invokevirtual 239	com/google/ads/ak:a	(ILjava/lang/String;)V
    //   16: aload_0
    //   17: bipush 25
    //   19: invokestatic 100	com/google/ads/ak:b	()Ljava/lang/Long;
    //   22: invokevirtual 104	java/lang/Long:longValue	()J
    //   25: invokevirtual 243	com/google/ads/ak:a	(IJ)V
    //   28: aload_0
    //   29: bipush 24
    //   31: aload_1
    //   32: invokestatic 245	com/google/ads/ak:d	(Landroid/content/Context;)Ljava/lang/String;
    //   35: invokevirtual 239	com/google/ads/ak:a	(ILjava/lang/String;)V
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
    //   0	55	0	this	ak
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
    //   28	38	41	com/google/ads/ak$a
    //   16	28	43	com/google/ads/ak$a
    //   8	16	47	com/google/ads/ak$a
    //   0	8	51	com/google/ads/ak$a
  }
  
  /* Error */
  protected void c(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_2
    //   2: invokestatic 240	com/google/ads/ak:a	()Ljava/lang/String;
    //   5: invokevirtual 239	com/google/ads/ak:a	(ILjava/lang/String;)V
    //   8: aload_0
    //   9: iconst_1
    //   10: invokestatic 236	com/google/ads/ak:c	()Ljava/lang/String;
    //   13: invokevirtual 239	com/google/ads/ak:a	(ILjava/lang/String;)V
    //   16: invokestatic 100	com/google/ads/ak:b	()Ljava/lang/Long;
    //   19: invokevirtual 104	java/lang/Long:longValue	()J
    //   22: lstore_2
    //   23: aload_0
    //   24: bipush 25
    //   26: lload_2
    //   27: invokevirtual 243	com/google/ads/ak:a	(IJ)V
    //   30: getstatic 35	com/google/ads/ak:j	J
    //   33: lconst_0
    //   34: lcmp
    //   35: ifeq +23 -> 58
    //   38: aload_0
    //   39: bipush 17
    //   41: lload_2
    //   42: getstatic 35	com/google/ads/ak:j	J
    //   45: lsub
    //   46: invokevirtual 243	com/google/ads/ak:a	(IJ)V
    //   49: aload_0
    //   50: bipush 23
    //   52: getstatic 35	com/google/ads/ak:j	J
    //   55: invokevirtual 243	com/google/ads/ak:a	(IJ)V
    //   58: aload_0
    //   59: getfield 248	com/google/ads/ak:a	Landroid/view/MotionEvent;
    //   62: aload_0
    //   63: getfield 251	com/google/ads/ak:b	Landroid/util/DisplayMetrics;
    //   66: invokestatic 253	com/google/ads/ak:a	(Landroid/view/MotionEvent;Landroid/util/DisplayMetrics;)Ljava/util/ArrayList;
    //   69: astore 4
    //   71: aload_0
    //   72: bipush 14
    //   74: aload 4
    //   76: iconst_0
    //   77: invokevirtual 257	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   80: checkcast 75	java/lang/Long
    //   83: invokevirtual 104	java/lang/Long:longValue	()J
    //   86: invokevirtual 243	com/google/ads/ak:a	(IJ)V
    //   89: aload_0
    //   90: bipush 15
    //   92: aload 4
    //   94: iconst_1
    //   95: invokevirtual 257	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   98: checkcast 75	java/lang/Long
    //   101: invokevirtual 104	java/lang/Long:longValue	()J
    //   104: invokevirtual 243	com/google/ads/ak:a	(IJ)V
    //   107: aload 4
    //   109: invokevirtual 261	java/util/ArrayList:size	()I
    //   112: iconst_3
    //   113: if_icmplt +21 -> 134
    //   116: aload_0
    //   117: bipush 16
    //   119: aload 4
    //   121: iconst_2
    //   122: invokevirtual 257	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   125: checkcast 75	java/lang/Long
    //   128: invokevirtual 104	java/lang/Long:longValue	()J
    //   131: invokevirtual 243	com/google/ads/ak:a	(IJ)V
    //   134: aload_0
    //   135: bipush 27
    //   137: aload_1
    //   138: invokestatic 263	com/google/ads/ak:e	(Landroid/content/Context;)Ljava/lang/String;
    //   141: invokevirtual 239	com/google/ads/ak:a	(ILjava/lang/String;)V
    //   144: return
    //   145: astore_1
    //   146: return
    //   147: astore_1
    //   148: return
    //   149: astore 4
    //   151: goto -17 -> 134
    //   154: astore 4
    //   156: goto -98 -> 58
    //   159: astore 4
    //   161: goto -145 -> 16
    //   164: astore 4
    //   166: goto -158 -> 8
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	ak
    //   0	169	1	paramContext	Context
    //   22	20	2	l	long
    //   69	51	4	localArrayList	ArrayList
    //   149	1	4	locala1	a
    //   154	1	4	locala2	a
    //   159	1	4	locala3	a
    //   164	1	4	locala4	a
    // Exception table:
    //   from	to	target	type
    //   0	8	145	java/io/IOException
    //   8	16	145	java/io/IOException
    //   16	58	145	java/io/IOException
    //   58	134	145	java/io/IOException
    //   134	144	145	java/io/IOException
    //   134	144	147	com/google/ads/ak$a
    //   58	134	149	com/google/ads/ak$a
    //   16	58	154	com/google/ads/ak$a
    //   8	16	159	com/google/ads/ak$a
    //   0	8	164	com/google/ads/ak$a
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/google/ads/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */