package com.appflood.b;

import com.appflood.e.j;
import com.appflood.e.k;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public final class a
{
  public ArrayList<b> a = new ArrayList(4);
  public ThreadPoolExecutor b = (ThreadPoolExecutor)Executors.newFixedThreadPool(4);
  private LinkedList<b> c = new LinkedList();
  
  private boolean a(URL paramURL)
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      boolean bool;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        bool = k.a(((b)localIterator.next()).a(), paramURL);
      } while (!bool);
      return true;
    }
    catch (Throwable paramURL)
    {
      j.b(paramURL, "Failed in existInWorker");
      return false;
    }
    finally {}
  }
  
  /* Error */
  final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/appflood/b/a:b	Ljava/util/concurrent/ThreadPoolExecutor;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 21	com/appflood/b/a:c	Ljava/util/LinkedList;
    //   14: invokevirtual 76	java/util/LinkedList:isEmpty	()Z
    //   17: istore_2
    //   18: iload_2
    //   19: ifne +279 -> 298
    //   22: aconst_null
    //   23: astore_3
    //   24: aload_3
    //   25: astore 4
    //   27: aload_3
    //   28: astore 5
    //   30: aload_0
    //   31: getfield 28	com/appflood/b/a:a	Ljava/util/ArrayList;
    //   34: invokevirtual 80	java/util/ArrayList:size	()I
    //   37: iconst_4
    //   38: if_icmpge +265 -> 303
    //   41: aload_3
    //   42: astore 4
    //   44: aload_3
    //   45: astore 5
    //   47: aload_0
    //   48: getfield 21	com/appflood/b/a:c	Ljava/util/LinkedList;
    //   51: invokevirtual 76	java/util/LinkedList:isEmpty	()Z
    //   54: ifne +249 -> 303
    //   57: iconst_0
    //   58: istore_1
    //   59: aload_3
    //   60: astore 4
    //   62: iload_1
    //   63: aload_0
    //   64: getfield 21	com/appflood/b/a:c	Ljava/util/LinkedList;
    //   67: invokevirtual 81	java/util/LinkedList:size	()I
    //   70: if_icmpge +222 -> 292
    //   73: aload_3
    //   74: astore 4
    //   76: aload_0
    //   77: getfield 21	com/appflood/b/a:c	Ljava/util/LinkedList;
    //   80: iload_1
    //   81: invokevirtual 85	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   84: checkcast 58	com/appflood/b/b
    //   87: astore 6
    //   89: aload_3
    //   90: astore 4
    //   92: aload 6
    //   94: getfield 88	com/appflood/b/b:a	Z
    //   97: ifeq +18 -> 115
    //   100: aload_3
    //   101: astore 4
    //   103: aload_0
    //   104: aload 6
    //   106: invokevirtual 61	com/appflood/b/b:a	()Ljava/net/URL;
    //   109: invokespecial 90	com/appflood/b/a:a	(Ljava/net/URL;)Z
    //   112: ifne +132 -> 244
    //   115: aload_3
    //   116: astore 4
    //   118: aload_0
    //   119: getfield 21	com/appflood/b/a:c	Ljava/util/LinkedList;
    //   122: iload_1
    //   123: invokevirtual 93	java/util/LinkedList:remove	(I)Ljava/lang/Object;
    //   126: pop
    //   127: aload_3
    //   128: astore 5
    //   130: aload 6
    //   132: ifnull +171 -> 303
    //   135: aload_3
    //   136: astore 4
    //   138: aload 6
    //   140: getfield 88	com/appflood/b/b:a	Z
    //   143: ifeq +108 -> 251
    //   146: aload_3
    //   147: astore 4
    //   149: aload 6
    //   151: invokevirtual 96	com/appflood/b/b:e	()Z
    //   154: ifeq +97 -> 251
    //   157: aload_3
    //   158: astore 5
    //   160: aload_3
    //   161: ifnonnull +15 -> 176
    //   164: aload_3
    //   165: astore 4
    //   167: new 98	java/util/Vector
    //   170: dup
    //   171: invokespecial 99	java/util/Vector:<init>	()V
    //   174: astore 5
    //   176: aload 5
    //   178: astore 4
    //   180: aload 5
    //   182: aload 6
    //   184: invokevirtual 103	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   187: pop
    //   188: aload 5
    //   190: astore_3
    //   191: goto -167 -> 24
    //   194: astore_3
    //   195: aload_3
    //   196: ldc 105
    //   198: invokestatic 73	com/appflood/e/j:b	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   201: aload 4
    //   203: astore 5
    //   205: goto +98 -> 303
    //   208: aload_0
    //   209: monitorexit
    //   210: aload_3
    //   211: ifnull -204 -> 7
    //   214: aload_3
    //   215: invokevirtual 106	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   218: astore_3
    //   219: aload_3
    //   220: invokeinterface 52 1 0
    //   225: ifeq -218 -> 7
    //   228: aload_3
    //   229: invokeinterface 56 1 0
    //   234: checkcast 58	com/appflood/b/b
    //   237: iconst_0
    //   238: invokevirtual 109	com/appflood/b/b:a	(Z)V
    //   241: goto -22 -> 219
    //   244: iload_1
    //   245: iconst_1
    //   246: iadd
    //   247: istore_1
    //   248: goto -189 -> 59
    //   251: aload_3
    //   252: astore 4
    //   254: aload_0
    //   255: getfield 28	com/appflood/b/a:a	Ljava/util/ArrayList;
    //   258: aload 6
    //   260: invokevirtual 110	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   263: pop
    //   264: aload_3
    //   265: astore 4
    //   267: aload_0
    //   268: getfield 38	com/appflood/b/a:b	Ljava/util/concurrent/ThreadPoolExecutor;
    //   271: aload 6
    //   273: invokevirtual 114	java/util/concurrent/ThreadPoolExecutor:submit	(Ljava/lang/Runnable;)Ljava/util/concurrent/Future;
    //   276: pop
    //   277: goto -253 -> 24
    //   280: astore_3
    //   281: aload_0
    //   282: monitorexit
    //   283: aload_3
    //   284: athrow
    //   285: astore_3
    //   286: aconst_null
    //   287: astore 4
    //   289: goto -94 -> 195
    //   292: aconst_null
    //   293: astore 6
    //   295: goto -168 -> 127
    //   298: aconst_null
    //   299: astore_3
    //   300: goto -92 -> 208
    //   303: aload 5
    //   305: astore_3
    //   306: goto -98 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	a
    //   58	190	1	i	int
    //   17	2	2	bool	boolean
    //   23	168	3	localObject1	Object
    //   194	21	3	localThrowable1	Throwable
    //   218	47	3	localIterator	Iterator
    //   280	4	3	localObject2	Object
    //   285	1	3	localThrowable2	Throwable
    //   299	7	3	localObject3	Object
    //   25	263	4	localObject4	Object
    //   28	276	5	localObject5	Object
    //   87	207	6	localb	b
    // Exception table:
    //   from	to	target	type
    //   30	41	194	java/lang/Throwable
    //   47	57	194	java/lang/Throwable
    //   62	73	194	java/lang/Throwable
    //   76	89	194	java/lang/Throwable
    //   92	100	194	java/lang/Throwable
    //   103	115	194	java/lang/Throwable
    //   118	127	194	java/lang/Throwable
    //   138	146	194	java/lang/Throwable
    //   149	157	194	java/lang/Throwable
    //   167	176	194	java/lang/Throwable
    //   180	188	194	java/lang/Throwable
    //   254	264	194	java/lang/Throwable
    //   267	277	194	java/lang/Throwable
    //   10	18	280	finally
    //   30	41	280	finally
    //   47	57	280	finally
    //   62	73	280	finally
    //   76	89	280	finally
    //   92	100	280	finally
    //   103	115	280	finally
    //   118	127	280	finally
    //   138	146	280	finally
    //   149	157	280	finally
    //   167	176	280	finally
    //   180	188	280	finally
    //   195	201	280	finally
    //   208	210	280	finally
    //   254	264	280	finally
    //   267	277	280	finally
    //   10	18	285	java/lang/Throwable
  }
  
  /* Error */
  protected final void a(b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 28	com/appflood/b/a:a	Ljava/util/ArrayList;
    //   6: aload_1
    //   7: invokevirtual 117	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_0
    //   14: invokevirtual 119	com/appflood/b/a:a	()V
    //   17: return
    //   18: astore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_1
    //   22: athrow
    //   23: astore_1
    //   24: goto -13 -> 11
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	a
    //   0	27	1	paramb	b
    // Exception table:
    //   from	to	target	type
    //   2	11	18	finally
    //   11	13	18	finally
    //   2	11	23	java/lang/Throwable
  }
  
  protected final void b(b paramb)
  {
    if ((paramb.a) && (paramb.e()))
    {
      paramb.a(false);
      return;
    }
    try
    {
      this.c.add(paramb);
      a();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        j.a(localThrowable, "Failed to appendRequest: " + paramb);
      }
    }
    finally {}
  }
  
  protected final void c(b paramb)
  {
    if ((paramb.a) && (paramb.e()))
    {
      paramb.a(false);
      return;
    }
    try
    {
      this.c.addFirst(paramb);
      a();
      return;
    }
    catch (Throwable paramb)
    {
      for (;;)
      {
        paramb.printStackTrace();
      }
    }
    finally {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */