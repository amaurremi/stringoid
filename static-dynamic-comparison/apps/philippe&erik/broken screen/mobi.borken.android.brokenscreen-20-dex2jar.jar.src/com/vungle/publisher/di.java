package com.vungle.publisher;

import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class di
{
  static ExecutorService a = ;
  public static String b = "Event";
  private static final Map<Class<?>, List<Class<?>>> d = new HashMap();
  public String c = "onEvent";
  private final Map<Class<?>, CopyOnWriteArrayList<dr>> e = new HashMap();
  private final Map<Object, List<Class<?>>> f = new HashMap();
  private final Map<Class<?>, Object> g = new ConcurrentHashMap();
  private final ThreadLocal<a> h = new ThreadLocal() {};
  private final dk i = new dk(this, Looper.getMainLooper());
  private final dh j = new dh(this);
  private final dg k = new dg(this);
  private final dq l = new dq();
  private boolean m;
  private boolean n = true;
  
  private void a(dr paramdr, Object paramObject)
    throws Error
  {
    try
    {
      paramdr.b.a.invoke(paramdr.a, new Object[] { paramObject });
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Throwable localThrowable = localInvocationTargetException.getCause();
      if ((paramObject instanceof do))
      {
        Log.e(b, "SubscriberExceptionEvent subscriber " + paramdr.a.getClass() + " threw an exception", localThrowable);
        paramdr = (do)paramObject;
        Log.e(b, "Initial event " + paramdr.c + " caused exception in " + paramdr.d, paramdr.b);
        return;
      }
      if (this.n) {
        Log.e(b, "Could not dispatch event: " + paramObject.getClass() + " to subscribing class " + paramdr.a.getClass(), localThrowable);
      }
      b(new do(this, localThrowable, paramObject, paramdr.a));
      return;
    }
    catch (IllegalAccessException paramdr)
    {
      throw new IllegalStateException("Unexpected exception", paramdr);
    }
  }
  
  private void a(dr paramdr, Object paramObject, boolean paramBoolean)
  {
    switch (2.a[paramdr.b.b.ordinal()])
    {
    default: 
      throw new IllegalStateException("Unknown thread mode: " + paramdr.b.b);
    case 1: 
      a(paramdr, paramObject);
      return;
    case 2: 
      if (paramBoolean)
      {
        a(paramdr, paramObject);
        return;
      }
      localObject = this.i;
      paramdr = dm.a(paramdr, paramObject);
      try
      {
        ((dk)localObject).a.a(paramdr);
        if (!((dk)localObject).b)
        {
          ((dk)localObject).b = true;
          if (!((dk)localObject).sendMessage(((dk)localObject).obtainMessage())) {
            throw new dj("Could not send handler message");
          }
        }
      }
      finally {}
      return;
    case 3: 
      if (paramBoolean)
      {
        localObject = this.j;
        paramdr = dm.a(paramdr, paramObject);
        try
        {
          ((dh)localObject).a.a(paramdr);
          if (!((dh)localObject).b)
          {
            ((dh)localObject).b = true;
            a.execute((Runnable)localObject);
          }
          return;
        }
        finally {}
      }
      a(paramdr, paramObject);
      return;
    }
    Object localObject = this.k;
    paramdr = dm.a(paramdr, paramObject);
    ((dg)localObject).a.a(paramdr);
    a.execute((Runnable)localObject);
  }
  
  private static void a(List<Class<?>> paramList, Class<?>[] paramArrayOfClass)
  {
    int i2 = paramArrayOfClass.length;
    int i1 = 0;
    while (i1 < i2)
    {
      Class<?> localClass = paramArrayOfClass[i1];
      if (!paramList.contains(localClass))
      {
        paramList.add(localClass);
        a(paramList, localClass.getInterfaces());
      }
      i1 += 1;
    }
  }
  
  private static List<Class<?>> b(Class<?> paramClass)
  {
    synchronized (d)
    {
      Object localObject2 = (List)d.get(paramClass);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = new ArrayList();
        for (localObject1 = paramClass; localObject1 != null; localObject1 = ((Class)localObject1).getSuperclass())
        {
          ((List)localObject2).add(localObject1);
          a((List)localObject2, ((Class)localObject1).getInterfaces());
        }
        d.put(paramClass, localObject2);
        localObject1 = localObject2;
      }
      return (List<Class<?>>)localObject1;
    }
  }
  
  public final <T> T a(Class<T> paramClass)
  {
    synchronized (this.g)
    {
      paramClass = paramClass.cast(this.g.remove(paramClass));
      return paramClass;
    }
  }
  
  final void a(dm paramdm)
  {
    Object localObject = paramdm.a;
    dr localdr = paramdm.b;
    dm.a(paramdm);
    if (localdr.d) {
      a(localdr, localObject);
    }
  }
  
  public final void a(Object paramObject)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = (List)this.f.get(paramObject);
        int i2;
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (Class)((Iterator)localObject1).next();
            localObject2 = (List)this.e.get(localObject2);
            if (localObject2 == null) {
              continue;
            }
            int i1 = ((List)localObject2).size();
            i2 = 0;
            if (i2 >= i1) {
              continue;
            }
            dr localdr = (dr)((List)localObject2).get(i2);
            if (localdr.a == paramObject)
            {
              localdr.d = false;
              ((List)localObject2).remove(i2);
              i2 -= 1;
              i1 -= 1;
            }
          }
          else
          {
            this.f.remove(paramObject);
          }
        }
        else
        {
          Log.w(b, "Subscriber to unregister was not registered before: " + paramObject.getClass());
          continue;
        }
        i2 += 1;
      }
      finally {}
    }
  }
  
  /* Error */
  public final void a(Object paramObject, String arg2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 107	com/vungle/publisher/di:l	Lcom/vungle/publisher/dq;
    //   6: astore 7
    //   8: aload_1
    //   9: invokevirtual 152	java/lang/Object:getClass	()Ljava/lang/Class;
    //   12: aload_2
    //   13: invokestatic 339	com/vungle/publisher/dq:a	(Ljava/lang/Class;Ljava/lang/String;)Ljava/util/List;
    //   16: invokeinterface 311 1 0
    //   21: astore 8
    //   23: aload 8
    //   25: invokeinterface 317 1 0
    //   30: ifeq +327 -> 357
    //   33: aload 8
    //   35: invokeinterface 321 1 0
    //   40: checkcast 123	com/vungle/publisher/dp
    //   43: astore 7
    //   45: aload_0
    //   46: iconst_1
    //   47: putfield 341	com/vungle/publisher/di:m	Z
    //   50: aload 7
    //   52: getfield 344	com/vungle/publisher/dp:c	Ljava/lang/Class;
    //   55: astore 9
    //   57: aload_0
    //   58: getfield 72	com/vungle/publisher/di:e	Ljava/util/Map;
    //   61: aload 9
    //   63: invokeinterface 281 2 0
    //   68: checkcast 346	java/util/concurrent/CopyOnWriteArrayList
    //   71: astore_2
    //   72: new 118	com/vungle/publisher/dr
    //   75: dup
    //   76: aload_1
    //   77: aload 7
    //   79: invokespecial 349	com/vungle/publisher/dr:<init>	(Ljava/lang/Object;Lcom/vungle/publisher/dp;)V
    //   82: astore 10
    //   84: aload_2
    //   85: ifnonnull +188 -> 273
    //   88: new 346	java/util/concurrent/CopyOnWriteArrayList
    //   91: dup
    //   92: invokespecial 350	java/util/concurrent/CopyOnWriteArrayList:<init>	()V
    //   95: astore_2
    //   96: aload_0
    //   97: getfield 72	com/vungle/publisher/di:e	Ljava/util/Map;
    //   100: aload 9
    //   102: aload_2
    //   103: invokeinterface 291 3 0
    //   108: pop
    //   109: aload_2
    //   110: invokevirtual 351	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   113: istore 5
    //   115: iconst_0
    //   116: istore 4
    //   118: iload 4
    //   120: iload 5
    //   122: if_icmpgt +38 -> 160
    //   125: iload 4
    //   127: iload 5
    //   129: if_icmpeq +23 -> 152
    //   132: aload 10
    //   134: getfield 354	com/vungle/publisher/dr:c	I
    //   137: aload_2
    //   138: iload 4
    //   140: invokevirtual 355	java/util/concurrent/CopyOnWriteArrayList:get	(I)Ljava/lang/Object;
    //   143: checkcast 118	com/vungle/publisher/dr
    //   146: getfield 354	com/vungle/publisher/dr:c	I
    //   149: if_icmple +214 -> 363
    //   152: aload_2
    //   153: iload 4
    //   155: aload 10
    //   157: invokevirtual 358	java/util/concurrent/CopyOnWriteArrayList:add	(ILjava/lang/Object;)V
    //   160: aload_0
    //   161: getfield 74	com/vungle/publisher/di:f	Ljava/util/Map;
    //   164: aload_1
    //   165: invokeinterface 281 2 0
    //   170: checkcast 257	java/util/List
    //   173: astore 7
    //   175: aload 7
    //   177: astore_2
    //   178: aload 7
    //   180: ifnonnull +23 -> 203
    //   183: new 283	java/util/ArrayList
    //   186: dup
    //   187: invokespecial 284	java/util/ArrayList:<init>	()V
    //   190: astore_2
    //   191: aload_0
    //   192: getfield 74	com/vungle/publisher/di:f	Ljava/util/Map;
    //   195: aload_1
    //   196: aload_2
    //   197: invokeinterface 291 3 0
    //   202: pop
    //   203: aload_2
    //   204: aload 9
    //   206: invokeinterface 264 2 0
    //   211: pop
    //   212: iload_3
    //   213: ifeq -190 -> 23
    //   216: aload_0
    //   217: getfield 79	com/vungle/publisher/di:g	Ljava/util/Map;
    //   220: astore_2
    //   221: aload_2
    //   222: monitorenter
    //   223: aload_0
    //   224: getfield 79	com/vungle/publisher/di:g	Ljava/util/Map;
    //   227: aload 9
    //   229: invokeinterface 281 2 0
    //   234: astore 7
    //   236: aload_2
    //   237: monitorexit
    //   238: aload 7
    //   240: ifnull -217 -> 23
    //   243: invokestatic 87	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   246: invokestatic 361	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   249: if_acmpne +102 -> 351
    //   252: iconst_1
    //   253: istore 6
    //   255: aload_0
    //   256: aload 10
    //   258: aload 7
    //   260: iload 6
    //   262: invokespecial 363	com/vungle/publisher/di:a	(Lcom/vungle/publisher/dr;Ljava/lang/Object;Z)V
    //   265: goto -242 -> 23
    //   268: astore_1
    //   269: aload_0
    //   270: monitorexit
    //   271: aload_1
    //   272: athrow
    //   273: aload_2
    //   274: invokevirtual 364	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   277: astore 7
    //   279: aload 7
    //   281: invokeinterface 317 1 0
    //   286: ifeq +74 -> 360
    //   289: aload 7
    //   291: invokeinterface 321 1 0
    //   296: checkcast 118	com/vungle/publisher/dr
    //   299: aload 10
    //   301: invokevirtual 367	com/vungle/publisher/dr:equals	(Ljava/lang/Object;)Z
    //   304: ifeq -25 -> 279
    //   307: new 242	com/vungle/publisher/dj
    //   310: dup
    //   311: new 143	java/lang/StringBuilder
    //   314: dup
    //   315: ldc_w 369
    //   318: invokespecial 148	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   321: aload_1
    //   322: invokevirtual 152	java/lang/Object:getClass	()Ljava/lang/Class;
    //   325: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   328: ldc_w 371
    //   331: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: aload 9
    //   336: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokespecial 245	com/vungle/publisher/dj:<init>	(Ljava/lang/String;)V
    //   345: athrow
    //   346: astore_1
    //   347: aload_2
    //   348: monitorexit
    //   349: aload_1
    //   350: athrow
    //   351: iconst_0
    //   352: istore 6
    //   354: goto -99 -> 255
    //   357: aload_0
    //   358: monitorexit
    //   359: return
    //   360: goto -251 -> 109
    //   363: iload 4
    //   365: iconst_1
    //   366: iadd
    //   367: istore 4
    //   369: goto -251 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	this	di
    //   0	372	1	paramObject	Object
    //   0	372	3	paramBoolean	boolean
    //   116	252	4	i1	int
    //   113	17	5	i2	int
    //   253	100	6	bool	boolean
    //   6	284	7	localObject	Object
    //   21	13	8	localIterator	Iterator
    //   55	280	9	localClass	Class
    //   82	218	10	localdr	dr
    // Exception table:
    //   from	to	target	type
    //   2	23	268	finally
    //   23	84	268	finally
    //   88	109	268	finally
    //   109	115	268	finally
    //   132	152	268	finally
    //   152	160	268	finally
    //   160	175	268	finally
    //   183	203	268	finally
    //   203	212	268	finally
    //   216	223	268	finally
    //   243	252	268	finally
    //   255	265	268	finally
    //   273	279	268	finally
    //   279	346	268	finally
    //   347	351	268	finally
    //   223	238	346	finally
  }
  
  /* Error */
  public final void b(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 66	com/vungle/publisher/di:h	Ljava/lang/ThreadLocal;
    //   4: invokevirtual 375	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   7: checkcast 10	com/vungle/publisher/di$a
    //   10: astore 6
    //   12: aload 6
    //   14: getfield 378	com/vungle/publisher/di$a:a	Ljava/util/List;
    //   17: astore 7
    //   19: aload 7
    //   21: aload_1
    //   22: invokeinterface 264 2 0
    //   27: pop
    //   28: aload 6
    //   30: getfield 379	com/vungle/publisher/di$a:b	Z
    //   33: ifeq +4 -> 37
    //   36: return
    //   37: invokestatic 87	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   40: invokestatic 361	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   43: if_acmpne +38 -> 81
    //   46: iconst_1
    //   47: istore 5
    //   49: aload 6
    //   51: iload 5
    //   53: putfield 381	com/vungle/publisher/di$a:c	Z
    //   56: aload 6
    //   58: iconst_1
    //   59: putfield 379	com/vungle/publisher/di$a:b	Z
    //   62: aload 6
    //   64: getfield 383	com/vungle/publisher/di$a:f	Z
    //   67: ifeq +77 -> 144
    //   70: new 242	com/vungle/publisher/dj
    //   73: dup
    //   74: ldc_w 385
    //   77: invokespecial 245	com/vungle/publisher/dj:<init>	(Ljava/lang/String;)V
    //   80: athrow
    //   81: iconst_0
    //   82: istore 5
    //   84: goto -35 -> 49
    //   87: iload_2
    //   88: ifne +56 -> 144
    //   91: getstatic 52	com/vungle/publisher/di:b	Ljava/lang/String;
    //   94: new 143	java/lang/StringBuilder
    //   97: dup
    //   98: ldc_w 387
    //   101: invokespecial 148	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   104: aload 8
    //   106: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 389	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   115: pop
    //   116: aload 8
    //   118: ldc_w 391
    //   121: if_acmpeq +23 -> 144
    //   124: aload 8
    //   126: ldc -115
    //   128: if_acmpeq +16 -> 144
    //   131: aload_0
    //   132: new 391	com/vungle/publisher/dl
    //   135: dup
    //   136: aload_0
    //   137: aload_1
    //   138: invokespecial 394	com/vungle/publisher/dl:<init>	(Lcom/vungle/publisher/di;Ljava/lang/Object;)V
    //   141: invokevirtual 191	com/vungle/publisher/di:b	(Ljava/lang/Object;)V
    //   144: aload 7
    //   146: invokeinterface 397 1 0
    //   151: ifne +218 -> 369
    //   154: aload 7
    //   156: iconst_0
    //   157: invokeinterface 329 2 0
    //   162: astore_1
    //   163: aload_1
    //   164: invokevirtual 152	java/lang/Object:getClass	()Ljava/lang/Class;
    //   167: astore 8
    //   169: aload 8
    //   171: invokestatic 399	com/vungle/publisher/di:b	(Ljava/lang/Class;)Ljava/util/List;
    //   174: astore 9
    //   176: aload 9
    //   178: invokeinterface 324 1 0
    //   183: istore 4
    //   185: iconst_0
    //   186: istore_3
    //   187: iconst_0
    //   188: istore_2
    //   189: iload_3
    //   190: iload 4
    //   192: if_icmpge -105 -> 87
    //   195: aload 9
    //   197: iload_3
    //   198: invokeinterface 327 2 0
    //   203: checkcast 266	java/lang/Class
    //   206: astore 10
    //   208: aload_0
    //   209: monitorenter
    //   210: aload_0
    //   211: getfield 72	com/vungle/publisher/di:e	Ljava/util/Map;
    //   214: aload 10
    //   216: invokeinterface 281 2 0
    //   221: checkcast 346	java/util/concurrent/CopyOnWriteArrayList
    //   224: astore 10
    //   226: aload_0
    //   227: monitorexit
    //   228: aload 10
    //   230: ifnull +152 -> 382
    //   233: aload 10
    //   235: invokevirtual 400	java/util/concurrent/CopyOnWriteArrayList:isEmpty	()Z
    //   238: ifne +144 -> 382
    //   241: aload 10
    //   243: invokevirtual 364	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   246: astore 10
    //   248: aload 10
    //   250: invokeinterface 317 1 0
    //   255: ifeq +130 -> 385
    //   258: aload 10
    //   260: invokeinterface 321 1 0
    //   265: checkcast 118	com/vungle/publisher/dr
    //   268: astore 11
    //   270: aload 6
    //   272: aload_1
    //   273: putfield 402	com/vungle/publisher/di$a:e	Ljava/lang/Object;
    //   276: aload 6
    //   278: aload 11
    //   280: putfield 404	com/vungle/publisher/di$a:d	Lcom/vungle/publisher/dr;
    //   283: aload_0
    //   284: aload 11
    //   286: aload_1
    //   287: aload 6
    //   289: getfield 381	com/vungle/publisher/di$a:c	Z
    //   292: invokespecial 363	com/vungle/publisher/di:a	(Lcom/vungle/publisher/dr;Ljava/lang/Object;Z)V
    //   295: aload 6
    //   297: getfield 383	com/vungle/publisher/di$a:f	Z
    //   300: istore 5
    //   302: aload 6
    //   304: aconst_null
    //   305: putfield 402	com/vungle/publisher/di$a:e	Ljava/lang/Object;
    //   308: aload 6
    //   310: aconst_null
    //   311: putfield 404	com/vungle/publisher/di$a:d	Lcom/vungle/publisher/dr;
    //   314: aload 6
    //   316: iconst_0
    //   317: putfield 383	com/vungle/publisher/di$a:f	Z
    //   320: iload 5
    //   322: ifeq -74 -> 248
    //   325: goto +60 -> 385
    //   328: astore_1
    //   329: aload_0
    //   330: monitorexit
    //   331: aload_1
    //   332: athrow
    //   333: astore_1
    //   334: aload 6
    //   336: iconst_0
    //   337: putfield 379	com/vungle/publisher/di$a:b	Z
    //   340: aload 6
    //   342: iconst_0
    //   343: putfield 381	com/vungle/publisher/di$a:c	Z
    //   346: aload_1
    //   347: athrow
    //   348: astore_1
    //   349: aload 6
    //   351: aconst_null
    //   352: putfield 402	com/vungle/publisher/di$a:e	Ljava/lang/Object;
    //   355: aload 6
    //   357: aconst_null
    //   358: putfield 404	com/vungle/publisher/di$a:d	Lcom/vungle/publisher/dr;
    //   361: aload 6
    //   363: iconst_0
    //   364: putfield 383	com/vungle/publisher/di$a:f	Z
    //   367: aload_1
    //   368: athrow
    //   369: aload 6
    //   371: iconst_0
    //   372: putfield 379	com/vungle/publisher/di$a:b	Z
    //   375: aload 6
    //   377: iconst_0
    //   378: putfield 381	com/vungle/publisher/di$a:c	Z
    //   381: return
    //   382: goto +5 -> 387
    //   385: iconst_1
    //   386: istore_2
    //   387: iload_3
    //   388: iconst_1
    //   389: iadd
    //   390: istore_3
    //   391: goto -202 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	394	0	this	di
    //   0	394	1	paramObject	Object
    //   87	300	2	i1	int
    //   186	205	3	i2	int
    //   183	10	4	i3	int
    //   47	274	5	bool	boolean
    //   10	366	6	locala	a
    //   17	138	7	localList1	List
    //   104	66	8	localObject1	Object
    //   174	22	9	localList2	List
    //   206	53	10	localObject2	Object
    //   268	17	11	localdr	dr
    // Exception table:
    //   from	to	target	type
    //   210	228	328	finally
    //   91	116	333	finally
    //   131	144	333	finally
    //   144	185	333	finally
    //   195	210	333	finally
    //   233	248	333	finally
    //   248	283	333	finally
    //   302	320	333	finally
    //   329	333	333	finally
    //   349	369	333	finally
    //   283	302	348	finally
  }
  
  public final void c(Object paramObject)
  {
    synchronized (this.g)
    {
      this.g.put(paramObject.getClass(), paramObject);
      b(paramObject);
      return;
    }
  }
  
  static final class a
  {
    List<Object> a = new ArrayList();
    boolean b;
    boolean c;
    dr d;
    Object e;
    boolean f;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/di.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */