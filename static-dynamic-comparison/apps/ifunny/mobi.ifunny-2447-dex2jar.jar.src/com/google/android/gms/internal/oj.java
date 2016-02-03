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

public abstract class oj
        extends nq {
    static boolean d = false;
    private static Method e;
    private static Method f;
    private static Method g;
    private static Method h;
    private static Method i;
    private static Method j;
    private static Method k;
    private static Method l;
    private static Method m;
    private static String n;
    private static String o;
    private static String p;
    private static long q = 0L;
    private static rx r;

    protected oj(Context paramContext, qy paramqy, rk paramrk) {
        super(paramContext, paramqy, paramrk);
    }

    static String a() {
        if (n == null) {
            throw new ok();
        }
        return n;
    }

    static String a(Context paramContext, qy paramqy) {
        if (o != null) {
            return o;
        }
        if (h == null) {
            throw new ok();
        }
        try {
            paramContext = (ByteBuffer) h.invoke(null, new Object[]{paramContext});
            if (paramContext == null) {
                throw new ok();
            }
        } catch (IllegalAccessException paramContext) {
            throw new ok(paramContext);
            o = paramqy.a(paramContext.array(), true);
            paramContext = o;
            return paramContext;
        } catch (InvocationTargetException paramContext) {
            throw new ok(paramContext);
        }
    }

    static ArrayList<Long> a(MotionEvent paramMotionEvent, DisplayMetrics paramDisplayMetrics) {
        if ((i == null) || (paramMotionEvent == null)) {
            throw new ok();
        }
        try {
            paramMotionEvent = (ArrayList) i.invoke(null, new Object[]{paramMotionEvent, paramDisplayMetrics});
            return paramMotionEvent;
        } catch (IllegalAccessException paramMotionEvent) {
            throw new ok(paramMotionEvent);
        } catch (InvocationTargetException paramMotionEvent) {
            throw new ok(paramMotionEvent);
        }
    }

    /* Error */
    protected static void a(String paramString, Context paramContext, qy paramqy) {
        // Byte code:
        //   0: ldc 2
        //   2: monitorenter
        //   3: getstatic 30	com/google/android/gms/internal/oj:d	Z
        //   6: istore_3
        //   7: iload_3
        //   8: ifne +36 -> 44
        //   11: new 86	com/google/android/gms/internal/rx
        //   14: dup
        //   15: aload_2
        //   16: aconst_null
        //   17: invokespecial 89	com/google/android/gms/internal/rx:<init>	(Lcom/google/android/gms/internal/qy;Ljava/security/SecureRandom;)V
        //   20: putstatic 91	com/google/android/gms/internal/oj:r	Lcom/google/android/gms/internal/rx;
        //   23: aload_0
        //   24: putstatic 39	com/google/android/gms/internal/oj:n	Ljava/lang/String;
        //   27: aload_1
        //   28: invokestatic 94	com/google/android/gms/internal/oj:g	(Landroid/content/Context;)V
        //   31: invokestatic 98	com/google/android/gms/internal/oj:b	()Ljava/lang/Long;
        //   34: invokevirtual 104	java/lang/Long:longValue	()J
        //   37: putstatic 28	com/google/android/gms/internal/oj:q	J
        //   40: iconst_1
        //   41: putstatic 30	com/google/android/gms/internal/oj:d	Z
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
        //   0	62	2	paramqy	qy
        //   6	2	3	bool	boolean
        // Exception table:
        //   from	to	target	type
        //   3	7	48	finally
        //   11	44	48	finally
        //   11	44	54	java/lang/UnsupportedOperationException
        //   11	44	58	com/google/android/gms/internal/ok
    }

    static Long b() {
        if (e == null) {
            throw new ok();
        }
        try {
            Long localLong = (Long) e.invoke(null, new Object[0]);
            return localLong;
        } catch (IllegalAccessException localIllegalAccessException) {
            throw new ok(localIllegalAccessException);
        } catch (InvocationTargetException localInvocationTargetException) {
            throw new ok(localInvocationTargetException);
        }
    }

    static String b(Context paramContext, qy paramqy) {
        if (p != null) {
            return p;
        }
        if (k == null) {
            throw new ok();
        }
        try {
            paramContext = (ByteBuffer) k.invoke(null, new Object[]{paramContext});
            if (paramContext == null) {
                throw new ok();
            }
        } catch (IllegalAccessException paramContext) {
            throw new ok(paramContext);
            p = paramqy.a(paramContext.array(), true);
            paramContext = p;
            return paramContext;
        } catch (InvocationTargetException paramContext) {
            throw new ok(paramContext);
        }
    }

    private static String b(byte[] paramArrayOfByte, String paramString) {
        try {
            paramArrayOfByte = new String(r.a(paramArrayOfByte, paramString), "UTF-8");
            return paramArrayOfByte;
        } catch (ry paramArrayOfByte) {
            throw new ok(paramArrayOfByte);
        } catch (UnsupportedEncodingException paramArrayOfByte) {
            throw new ok(paramArrayOfByte);
        }
    }

    static String c() {
        if (g == null) {
            throw new ok();
        }
        try {
            String str = (String) g.invoke(null, new Object[0]);
            return str;
        } catch (IllegalAccessException localIllegalAccessException) {
            throw new ok(localIllegalAccessException);
        } catch (InvocationTargetException localInvocationTargetException) {
            throw new ok(localInvocationTargetException);
        }
    }

    static Long d() {
        if (f == null) {
            throw new ok();
        }
        try {
            Long localLong = (Long) f.invoke(null, new Object[0]);
            return localLong;
        } catch (IllegalAccessException localIllegalAccessException) {
            throw new ok(localIllegalAccessException);
        } catch (InvocationTargetException localInvocationTargetException) {
            throw new ok(localInvocationTargetException);
        }
    }

    static String d(Context paramContext) {
        if (j == null) {
            throw new ok();
        }
        try {
            paramContext = (String) j.invoke(null, new Object[]{paramContext});
            if (paramContext == null) {
                throw new ok();
            }
        } catch (IllegalAccessException paramContext) {
            throw new ok(paramContext);
        } catch (InvocationTargetException paramContext) {
            throw new ok(paramContext);
        }
        return paramContext;
    }

    static ArrayList<Long> e(Context paramContext) {
        if (l == null) {
            throw new ok();
        }
        try {
            paramContext = (ArrayList) l.invoke(null, new Object[]{paramContext});
            if ((paramContext == null) || (paramContext.size() != 2)) {
                throw new ok();
            }
        } catch (IllegalAccessException paramContext) {
            throw new ok(paramContext);
        } catch (InvocationTargetException paramContext) {
            throw new ok(paramContext);
        }
        return paramContext;
    }

    static int[] f(Context paramContext) {
        if (m == null) {
            throw new ok();
        }
        try {
            paramContext = (int[]) m.invoke(null, new Object[]{paramContext});
            return paramContext;
        } catch (IllegalAccessException paramContext) {
            throw new ok(paramContext);
        } catch (InvocationTargetException paramContext) {
            throw new ok(paramContext);
        }
    }

    private static void g(Context paramContext) {
        try {
            localObject1 = r.a(sw.a());
            localObject2 = r.a((byte[]) localObject1, sw.b());
            localFile2 = paramContext.getCacheDir();
            localFile1 = localFile2;
            if (localFile2 == null) {
                localFile2 = paramContext.getDir("dex", 0);
                localFile1 = localFile2;
                if (localFile2 == null) {
                    throw new ok();
                }
            }
        } catch (FileNotFoundException paramContext) {
            Object localObject1;
            Object localObject2;
            File localFile1;
            throw new ok(paramContext);
            File localFile2 = File.createTempFile("ads", ".jar", localFile1);
            Object localObject3 = new FileOutputStream(localFile2);
            ((FileOutputStream) localObject3).write((byte[]) localObject2, 0, localObject2.length);
            ((FileOutputStream) localObject3).close();
            try {
                Object localObject4 = new DexClassLoader(localFile2.getAbsolutePath(), localFile1.getAbsolutePath(), null, paramContext.getClassLoader());
                paramContext = ((DexClassLoader) localObject4).loadClass(b((byte[]) localObject1, sw.e()));
                localObject2 = ((DexClassLoader) localObject4).loadClass(b((byte[]) localObject1, sw.q()));
                localObject3 = ((DexClassLoader) localObject4).loadClass(b((byte[]) localObject1, sw.k()));
                Class localClass1 = ((DexClassLoader) localObject4).loadClass(b((byte[]) localObject1, sw.i()));
                Class localClass2 = ((DexClassLoader) localObject4).loadClass(b((byte[]) localObject1, sw.s()));
                Class localClass3 = ((DexClassLoader) localObject4).loadClass(b((byte[]) localObject1, sw.g()));
                Class localClass4 = ((DexClassLoader) localObject4).loadClass(b((byte[]) localObject1, sw.o()));
                Class localClass5 = ((DexClassLoader) localObject4).loadClass(b((byte[]) localObject1, sw.m()));
                localObject4 = ((DexClassLoader) localObject4).loadClass(b((byte[]) localObject1, sw.c()));
                e = paramContext.getMethod(b((byte[]) localObject1, sw.f()), new Class[0]);
                f = ((Class) localObject2).getMethod(b((byte[]) localObject1, sw.r()), new Class[0]);
                g = ((Class) localObject3).getMethod(b((byte[]) localObject1, sw.l()), new Class[0]);
                h = localClass1.getMethod(b((byte[]) localObject1, sw.j()), new Class[]{Context.class});
                i = localClass2.getMethod(b((byte[]) localObject1, sw.t()), new Class[]{MotionEvent.class, DisplayMetrics.class});
                j = localClass3.getMethod(b((byte[]) localObject1, sw.h()), new Class[]{Context.class});
                k = localClass4.getMethod(b((byte[]) localObject1, sw.p()), new Class[]{Context.class});
                l = localClass5.getMethod(b((byte[]) localObject1, sw.n()), new Class[]{Context.class});
                m = ((Class) localObject4).getMethod(b((byte[]) localObject1, sw.d()), new Class[]{Context.class});
                return;
            } finally {
                localObject1 = localFile2.getName();
                localFile2.delete();
                new File(localFile1, ((String) localObject1).replace(".jar", ".dex")).delete();
            }
        } catch (IOException paramContext) {
            throw new ok(paramContext);
        } catch (ClassNotFoundException paramContext) {
            throw new ok(paramContext);
        } catch (ry paramContext) {
            throw new ok(paramContext);
        } catch (NoSuchMethodException paramContext) {
            throw new ok(paramContext);
        } catch (NullPointerException paramContext) {
            throw new ok(paramContext);
        }
    }

    /* Error */
    protected void b(Context paramContext) {
        // Byte code:
        //   0: aload_0
        //   1: iconst_1
        //   2: invokestatic 282	com/google/android/gms/internal/oj:c	()Ljava/lang/String;
        //   5: invokevirtual 285	com/google/android/gms/internal/oj:a	(ILjava/lang/String;)V
        //   8: aload_0
        //   9: iconst_2
        //   10: invokestatic 286	com/google/android/gms/internal/oj:a	()Ljava/lang/String;
        //   13: invokevirtual 285	com/google/android/gms/internal/oj:a	(ILjava/lang/String;)V
        //   16: invokestatic 98	com/google/android/gms/internal/oj:b	()Ljava/lang/Long;
        //   19: invokevirtual 104	java/lang/Long:longValue	()J
        //   22: lstore_2
        //   23: aload_0
        //   24: bipush 25
        //   26: lload_2
        //   27: invokevirtual 289	com/google/android/gms/internal/oj:a	(IJ)V
        //   30: getstatic 28	com/google/android/gms/internal/oj:q	J
        //   33: lconst_0
        //   34: lcmp
        //   35: ifeq +23 -> 58
        //   38: aload_0
        //   39: bipush 17
        //   41: lload_2
        //   42: getstatic 28	com/google/android/gms/internal/oj:q	J
        //   45: lsub
        //   46: invokevirtual 289	com/google/android/gms/internal/oj:a	(IJ)V
        //   49: aload_0
        //   50: bipush 23
        //   52: getstatic 28	com/google/android/gms/internal/oj:q	J
        //   55: invokevirtual 289	com/google/android/gms/internal/oj:a	(IJ)V
        //   58: aload_1
        //   59: invokestatic 291	com/google/android/gms/internal/oj:e	(Landroid/content/Context;)Ljava/util/ArrayList;
        //   62: astore 4
        //   64: aload_0
        //   65: bipush 31
        //   67: aload 4
        //   69: iconst_0
        //   70: invokevirtual 295	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   73: checkcast 100	java/lang/Long
        //   76: invokevirtual 104	java/lang/Long:longValue	()J
        //   79: invokevirtual 289	com/google/android/gms/internal/oj:a	(IJ)V
        //   82: aload_0
        //   83: bipush 32
        //   85: aload 4
        //   87: iconst_1
        //   88: invokevirtual 295	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   91: checkcast 100	java/lang/Long
        //   94: invokevirtual 104	java/lang/Long:longValue	()J
        //   97: invokevirtual 289	com/google/android/gms/internal/oj:a	(IJ)V
        //   100: aload_0
        //   101: bipush 33
        //   103: invokestatic 297	com/google/android/gms/internal/oj:d	()Ljava/lang/Long;
        //   106: invokevirtual 104	java/lang/Long:longValue	()J
        //   109: invokevirtual 289	com/google/android/gms/internal/oj:a	(IJ)V
        //   112: aload_0
        //   113: bipush 27
        //   115: aload_1
        //   116: aload_0
        //   117: getfield 300	com/google/android/gms/internal/oj:c	Lcom/google/android/gms/internal/qy;
        //   120: invokestatic 302	com/google/android/gms/internal/oj:a	(Landroid/content/Context;Lcom/google/android/gms/internal/qy;)Ljava/lang/String;
        //   123: invokevirtual 285	com/google/android/gms/internal/oj:a	(ILjava/lang/String;)V
        //   126: aload_0
        //   127: bipush 29
        //   129: aload_1
        //   130: aload_0
        //   131: getfield 300	com/google/android/gms/internal/oj:c	Lcom/google/android/gms/internal/qy;
        //   134: invokestatic 304	com/google/android/gms/internal/oj:b	(Landroid/content/Context;Lcom/google/android/gms/internal/qy;)Ljava/lang/String;
        //   137: invokevirtual 285	com/google/android/gms/internal/oj:a	(ILjava/lang/String;)V
        //   140: aload_1
        //   141: invokestatic 306	com/google/android/gms/internal/oj:f	(Landroid/content/Context;)[I
        //   144: astore_1
        //   145: aload_0
        //   146: iconst_5
        //   147: aload_1
        //   148: iconst_0
        //   149: iaload
        //   150: i2l
        //   151: invokevirtual 289	com/google/android/gms/internal/oj:a	(IJ)V
        //   154: aload_0
        //   155: bipush 6
        //   157: aload_1
        //   158: iconst_1
        //   159: iaload
        //   160: i2l
        //   161: invokevirtual 289	com/google/android/gms/internal/oj:a	(IJ)V
        //   164: return
        //   165: astore_1
        //   166: return
        //   167: astore_1
        //   168: return
        //   169: astore 4
        //   171: goto -31 -> 140
        //   174: astore 4
        //   176: goto -50 -> 126
        //   179: astore 4
        //   181: goto -69 -> 112
        //   184: astore 4
        //   186: goto -86 -> 100
        //   189: astore 4
        //   191: goto -133 -> 58
        //   194: astore 4
        //   196: goto -180 -> 16
        //   199: astore 4
        //   201: goto -193 -> 8
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	204	0	this	oj
        //   0	204	1	paramContext	Context
        //   22	20	2	l1	long
        //   62	24	4	localArrayList	ArrayList
        //   169	1	4	localok1	ok
        //   174	1	4	localok2	ok
        //   179	1	4	localok3	ok
        //   184	1	4	localok4	ok
        //   189	1	4	localok5	ok
        //   194	1	4	localok6	ok
        //   199	1	4	localok7	ok
        // Exception table:
        //   from	to	target	type
        //   0	8	165	java/io/IOException
        //   8	16	165	java/io/IOException
        //   16	58	165	java/io/IOException
        //   58	100	165	java/io/IOException
        //   100	112	165	java/io/IOException
        //   112	126	165	java/io/IOException
        //   126	140	165	java/io/IOException
        //   140	164	165	java/io/IOException
        //   140	164	167	com/google/android/gms/internal/ok
        //   126	140	169	com/google/android/gms/internal/ok
        //   112	126	174	com/google/android/gms/internal/ok
        //   100	112	179	com/google/android/gms/internal/ok
        //   58	100	184	com/google/android/gms/internal/ok
        //   16	58	189	com/google/android/gms/internal/ok
        //   8	16	194	com/google/android/gms/internal/ok
        //   0	8	199	com/google/android/gms/internal/ok
    }

    /* Error */
    protected void c(Context paramContext) {
        // Byte code:
        //   0: aload_0
        //   1: iconst_2
        //   2: invokestatic 286	com/google/android/gms/internal/oj:a	()Ljava/lang/String;
        //   5: invokevirtual 285	com/google/android/gms/internal/oj:a	(ILjava/lang/String;)V
        //   8: aload_0
        //   9: iconst_1
        //   10: invokestatic 282	com/google/android/gms/internal/oj:c	()Ljava/lang/String;
        //   13: invokevirtual 285	com/google/android/gms/internal/oj:a	(ILjava/lang/String;)V
        //   16: aload_0
        //   17: bipush 25
        //   19: invokestatic 98	com/google/android/gms/internal/oj:b	()Ljava/lang/Long;
        //   22: invokevirtual 104	java/lang/Long:longValue	()J
        //   25: invokevirtual 289	com/google/android/gms/internal/oj:a	(IJ)V
        //   28: aload_0
        //   29: getfield 309	com/google/android/gms/internal/oj:a	Landroid/view/MotionEvent;
        //   32: aload_0
        //   33: getfield 312	com/google/android/gms/internal/oj:b	Landroid/util/DisplayMetrics;
        //   36: invokestatic 314	com/google/android/gms/internal/oj:a	(Landroid/view/MotionEvent;Landroid/util/DisplayMetrics;)Ljava/util/ArrayList;
        //   39: astore_1
        //   40: aload_0
        //   41: bipush 14
        //   43: aload_1
        //   44: iconst_0
        //   45: invokevirtual 295	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   48: checkcast 100	java/lang/Long
        //   51: invokevirtual 104	java/lang/Long:longValue	()J
        //   54: invokevirtual 289	com/google/android/gms/internal/oj:a	(IJ)V
        //   57: aload_0
        //   58: bipush 15
        //   60: aload_1
        //   61: iconst_1
        //   62: invokevirtual 295	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   65: checkcast 100	java/lang/Long
        //   68: invokevirtual 104	java/lang/Long:longValue	()J
        //   71: invokevirtual 289	com/google/android/gms/internal/oj:a	(IJ)V
        //   74: aload_1
        //   75: invokevirtual 140	java/util/ArrayList:size	()I
        //   78: iconst_3
        //   79: if_icmplt +20 -> 99
        //   82: aload_0
        //   83: bipush 16
        //   85: aload_1
        //   86: iconst_2
        //   87: invokevirtual 295	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   90: checkcast 100	java/lang/Long
        //   93: invokevirtual 104	java/lang/Long:longValue	()J
        //   96: invokevirtual 289	com/google/android/gms/internal/oj:a	(IJ)V
        //   99: return
        //   100: astore_1
        //   101: return
        //   102: astore_1
        //   103: return
        //   104: astore_1
        //   105: goto -77 -> 28
        //   108: astore_1
        //   109: goto -93 -> 16
        //   112: astore_1
        //   113: goto -105 -> 8
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	116	0	this	oj
        //   0	116	1	paramContext	Context
        // Exception table:
        //   from	to	target	type
        //   0	8	100	java/io/IOException
        //   8	16	100	java/io/IOException
        //   16	28	100	java/io/IOException
        //   28	99	100	java/io/IOException
        //   28	99	102	com/google/android/gms/internal/ok
        //   16	28	104	com/google/android/gms/internal/ok
        //   8	16	108	com/google/android/gms/internal/ok
        //   0	8	112	com/google/android/gms/internal/ok
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/oj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */