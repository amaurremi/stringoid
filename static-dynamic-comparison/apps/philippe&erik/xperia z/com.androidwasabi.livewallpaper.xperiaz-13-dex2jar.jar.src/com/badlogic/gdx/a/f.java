package com.badlogic.gdx.a;

import com.badlogic.gdx.utils.h;
import com.badlogic.gdx.utils.j;
import com.badlogic.gdx.utils.k;
import com.badlogic.gdx.utils.l;
import com.badlogic.gdx.utils.m;
import com.badlogic.gdx.utils.n;
import com.badlogic.gdx.utils.u;
import java.util.Iterator;
import java.util.Stack;

public class f
  implements com.badlogic.gdx.utils.d
{
  final k<Class, k<String, g>> a;
  final k<String, Class> b;
  final k<String, com.badlogic.gdx.utils.a<String>> c;
  final k<Class, k<String, com.badlogic.gdx.a.a.a>> d;
  final com.badlogic.gdx.utils.a<a> e;
  final com.badlogic.gdx.utils.a.a f;
  Stack<e> g;
  b h;
  int i;
  int j;
  h k;
  
  private void a(a parama)
  {
    com.badlogic.gdx.a.a.a locala = a(parama.b, parama.a);
    if (locala == null) {
      throw new com.badlogic.gdx.utils.f("No loader for type: " + com.badlogic.gdx.utils.b.b.a(parama.b));
    }
    this.g.push(new e(this, parama, locala, this.f));
  }
  
  /* Error */
  private void a(String paramString, a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 87	com/badlogic/gdx/a/f:c	Lcom/badlogic/gdx/utils/k;
    //   6: aload_1
    //   7: invokevirtual 91	com/badlogic/gdx/utils/k:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 93	com/badlogic/gdx/utils/a
    //   13: astore 4
    //   15: aload 4
    //   17: astore_3
    //   18: aload 4
    //   20: ifnonnull +21 -> 41
    //   23: new 93	com/badlogic/gdx/utils/a
    //   26: dup
    //   27: invokespecial 94	com/badlogic/gdx/utils/a:<init>	()V
    //   30: astore_3
    //   31: aload_0
    //   32: getfield 87	com/badlogic/gdx/a/f:c	Lcom/badlogic/gdx/utils/k;
    //   35: aload_1
    //   36: aload_3
    //   37: invokevirtual 97	com/badlogic/gdx/utils/k:a	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   40: pop
    //   41: aload_3
    //   42: aload_2
    //   43: getfield 39	com/badlogic/gdx/a/a:a	Ljava/lang/String;
    //   46: invokevirtual 100	com/badlogic/gdx/utils/a:a	(Ljava/lang/Object;)V
    //   49: aload_0
    //   50: aload_2
    //   51: getfield 39	com/badlogic/gdx/a/a:a	Ljava/lang/String;
    //   54: invokevirtual 103	com/badlogic/gdx/a/f:b	(Ljava/lang/String;)Z
    //   57: ifeq +79 -> 136
    //   60: aload_0
    //   61: getfield 105	com/badlogic/gdx/a/f:k	Lcom/badlogic/gdx/utils/h;
    //   64: new 46	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   71: ldc 107
    //   73: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_2
    //   77: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokevirtual 114	com/badlogic/gdx/utils/h:a	(Ljava/lang/String;)V
    //   86: aload_0
    //   87: getfield 116	com/badlogic/gdx/a/f:b	Lcom/badlogic/gdx/utils/k;
    //   90: aload_2
    //   91: getfield 39	com/badlogic/gdx/a/a:a	Ljava/lang/String;
    //   94: invokevirtual 91	com/badlogic/gdx/utils/k:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   97: checkcast 118	java/lang/Class
    //   100: astore_1
    //   101: aload_0
    //   102: getfield 120	com/badlogic/gdx/a/f:a	Lcom/badlogic/gdx/utils/k;
    //   105: aload_1
    //   106: invokevirtual 91	com/badlogic/gdx/utils/k:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   109: checkcast 89	com/badlogic/gdx/utils/k
    //   112: aload_2
    //   113: getfield 39	com/badlogic/gdx/a/a:a	Ljava/lang/String;
    //   116: invokevirtual 91	com/badlogic/gdx/utils/k:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   119: checkcast 122	com/badlogic/gdx/a/g
    //   122: invokevirtual 124	com/badlogic/gdx/a/g:a	()V
    //   125: aload_0
    //   126: aload_2
    //   127: getfield 39	com/badlogic/gdx/a/a:a	Ljava/lang/String;
    //   130: invokespecial 126	com/badlogic/gdx/a/f:d	(Ljava/lang/String;)V
    //   133: aload_0
    //   134: monitorexit
    //   135: return
    //   136: aload_0
    //   137: getfield 105	com/badlogic/gdx/a/f:k	Lcom/badlogic/gdx/utils/h;
    //   140: new 46	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   147: ldc -128
    //   149: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_2
    //   153: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokevirtual 130	com/badlogic/gdx/utils/h:b	(Ljava/lang/String;)V
    //   162: aload_0
    //   163: aload_2
    //   164: invokespecial 132	com/badlogic/gdx/a/f:a	(Lcom/badlogic/gdx/a/a;)V
    //   167: goto -34 -> 133
    //   170: astore_1
    //   171: aload_0
    //   172: monitorexit
    //   173: aload_1
    //   174: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	f
    //   0	175	1	paramString	String
    //   0	175	2	parama	a
    //   17	25	3	locala1	com.badlogic.gdx.utils.a
    //   13	6	4	locala2	com.badlogic.gdx.utils.a
    // Exception table:
    //   from	to	target	type
    //   2	15	170	finally
    //   23	41	170	finally
    //   41	133	170	finally
    //   136	167	170	finally
  }
  
  private void a(Throwable paramThrowable)
  {
    this.k.a("Error loading asset.", paramThrowable);
    if (this.g.isEmpty()) {
      throw new com.badlogic.gdx.utils.f(paramThrowable);
    }
    Object localObject = (e)this.g.pop();
    a locala = ((e)localObject).b;
    if ((((e)localObject).g) && (((e)localObject).h != null))
    {
      localObject = ((e)localObject).h.iterator();
      while (((Iterator)localObject).hasNext()) {
        a(((a)((Iterator)localObject).next()).a);
      }
    }
    this.g.clear();
    if (this.h != null)
    {
      this.h.a(locala, paramThrowable);
      return;
    }
    throw new com.badlogic.gdx.utils.f(paramThrowable);
  }
  
  private void d(String paramString)
  {
    paramString = (com.badlogic.gdx.utils.a)this.c.a(paramString);
    if (paramString == null) {}
    for (;;)
    {
      return;
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        String str = (String)paramString.next();
        Class localClass = (Class)this.b.a(str);
        ((g)((k)this.a.a(localClass)).a(str)).a();
        d(str);
      }
    }
  }
  
  private void e()
  {
    a locala = (a)this.e.b(0);
    if (b(locala.a))
    {
      this.k.a("Already loaded: " + locala);
      Class localClass = (Class)this.b.a(locala.a);
      ((g)((k)this.a.a(localClass)).a(locala.a)).a();
      d(locala.a);
      this.i += 1;
      return;
    }
    this.k.b("Loading: " + locala);
    a(locala);
  }
  
  private boolean f()
  {
    e locale = (e)this.g.peek();
    if (locale.b())
    {
      a(locale.b.a, locale.b.b, locale.c());
      if (this.g.size() == 1) {
        this.i += 1;
      }
      this.g.pop();
      if (locale.m) {
        a(locale.b.a);
      }
      for (;;)
      {
        return true;
        if ((locale.b.c != null) && (locale.b.c.a != null)) {
          locale.b.c.a.a(this, locale.b.a, locale.b.b);
        }
        long l = u.a();
        this.k.a("Loaded: " + (float)(l - locale.e) / 1000000.0F + "ms " + locale.b);
      }
    }
    return false;
  }
  
  public <T> com.badlogic.gdx.a.a.a a(Class<T> paramClass, String paramString)
  {
    Object localObject2 = null;
    Iterator localIterator = null;
    paramClass = (k)this.d.a(paramClass);
    Object localObject1 = localIterator;
    if (paramClass != null)
    {
      if (paramClass.a >= 1) {
        break label41;
      }
      localObject1 = localIterator;
    }
    label41:
    int m;
    do
    {
      return (com.badlogic.gdx.a.a.a)localObject1;
      if (paramString == null) {
        return (com.badlogic.gdx.a.a.a)paramClass.a("");
      }
      m = -1;
      localIterator = paramClass.b().iterator();
      paramClass = (Class<T>)localObject2;
      localObject1 = paramClass;
    } while (!localIterator.hasNext());
    localObject1 = (m)localIterator.next();
    if ((((String)((m)localObject1).a).length() > m) && (paramString.endsWith((String)((m)localObject1).a)))
    {
      paramClass = (com.badlogic.gdx.a.a.a)((m)localObject1).b;
      m = ((String)((m)localObject1).a).length();
    }
    for (;;)
    {
      break;
    }
  }
  
  /* Error */
  public <T> String a(T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 120	com/badlogic/gdx/a/f:a	Lcom/badlogic/gdx/utils/k;
    //   6: invokevirtual 271	com/badlogic/gdx/utils/k:c	()Lcom/badlogic/gdx/utils/n;
    //   9: invokevirtual 274	com/badlogic/gdx/utils/n:iterator	()Ljava/util/Iterator;
    //   12: astore 5
    //   14: aload 5
    //   16: invokeinterface 165 1 0
    //   21: ifeq +103 -> 124
    //   24: aload 5
    //   26: invokeinterface 168 1 0
    //   31: checkcast 118	java/lang/Class
    //   34: astore_3
    //   35: aload_0
    //   36: getfield 120	com/badlogic/gdx/a/f:a	Lcom/badlogic/gdx/utils/k;
    //   39: aload_3
    //   40: invokevirtual 91	com/badlogic/gdx/utils/k:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   43: checkcast 89	com/badlogic/gdx/utils/k
    //   46: astore 6
    //   48: aload 6
    //   50: invokevirtual 271	com/badlogic/gdx/utils/k:c	()Lcom/badlogic/gdx/utils/n;
    //   53: invokevirtual 274	com/badlogic/gdx/utils/n:iterator	()Ljava/util/Iterator;
    //   56: astore 7
    //   58: aload 7
    //   60: invokeinterface 165 1 0
    //   65: ifeq -51 -> 14
    //   68: aload 7
    //   70: invokeinterface 168 1 0
    //   75: checkcast 181	java/lang/String
    //   78: astore 4
    //   80: aload 6
    //   82: aload 4
    //   84: invokevirtual 91	com/badlogic/gdx/utils/k:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   87: checkcast 122	com/badlogic/gdx/a/g
    //   90: ldc 4
    //   92: invokevirtual 277	com/badlogic/gdx/a/g:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   95: astore 8
    //   97: aload 4
    //   99: astore_3
    //   100: aload 8
    //   102: aload_1
    //   103: if_acmpeq +17 -> 120
    //   106: aload_1
    //   107: aload 8
    //   109: invokevirtual 281	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   112: istore_2
    //   113: iload_2
    //   114: ifeq -56 -> 58
    //   117: aload 4
    //   119: astore_3
    //   120: aload_0
    //   121: monitorexit
    //   122: aload_3
    //   123: areturn
    //   124: aconst_null
    //   125: astore_3
    //   126: goto -6 -> 120
    //   129: astore_1
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	f
    //   0	134	1	paramT	T
    //   112	2	2	bool	boolean
    //   34	92	3	localObject1	Object
    //   78	40	4	str	String
    //   12	13	5	localIterator1	Iterator
    //   46	35	6	localk	k
    //   56	13	7	localIterator2	Iterator
    //   95	13	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	129	finally
    //   14	58	129	finally
    //   58	97	129	finally
    //   106	113	129	finally
  }
  
  public void a(String paramString)
  {
    for (int m = 0;; m = -1) {
      for (;;)
      {
        try
        {
          if (m >= this.e.b) {
            break;
          }
          if (((a)this.e.a(m)).a.equals(paramString))
          {
            if (m != -1)
            {
              this.e.b(m);
              this.k.a("Unload (from queue): " + paramString);
            }
          }
          else
          {
            m += 1;
            continue;
          }
          if (this.g.size() > 0)
          {
            localObject1 = (e)this.g.firstElement();
            if (((e)localObject1).b.a.equals(paramString))
            {
              ((e)localObject1).m = true;
              this.k.a("Unload (from tasks): " + paramString);
              continue;
            }
          }
          localObject2 = (Class)this.b.a(paramString);
        }
        finally {}
        Object localObject2;
        if (localObject2 == null) {
          throw new com.badlogic.gdx.utils.f("Asset not loaded: " + paramString);
        }
        Object localObject1 = (g)((k)this.a.a(localObject2)).a(paramString);
        ((g)localObject1).b();
        if (((g)localObject1).c() <= 0)
        {
          this.k.a("Unload (dispose): " + paramString);
          if ((((g)localObject1).a(Object.class) instanceof com.badlogic.gdx.utils.d)) {
            ((com.badlogic.gdx.utils.d)((g)localObject1).a(Object.class)).c();
          }
          this.b.b(paramString);
          ((k)this.a.a(localObject2)).b(paramString);
        }
        for (;;)
        {
          localObject2 = (com.badlogic.gdx.utils.a)this.c.a(paramString);
          if (localObject2 == null) {
            break;
          }
          localObject2 = ((com.badlogic.gdx.utils.a)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            a((String)((Iterator)localObject2).next());
          }
          this.k.a("Unload (decrement): " + paramString);
        }
        if (((g)localObject1).c() <= 0) {
          this.c.b(paramString);
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Class localClass;
    try
    {
      localClass = (Class)this.b.a(paramString);
      if (localClass == null) {
        throw new com.badlogic.gdx.utils.f("Asset not loaded: " + paramString);
      }
    }
    finally {}
    ((g)((k)this.a.a(localClass)).a(paramString)).a(paramInt);
  }
  
  void a(String paramString, com.badlogic.gdx.utils.a<a> parama)
  {
    try
    {
      parama = parama.iterator();
      while (parama.hasNext()) {
        a(paramString, (a)parama.next());
      }
    }
    finally {}
  }
  
  public <T> void a(String paramString, Class<T> paramClass, c<T> paramc)
  {
    int i1 = 0;
    try
    {
      if (a(paramClass, paramString) == null) {
        throw new com.badlogic.gdx.utils.f("No loader for type: " + com.badlogic.gdx.utils.b.b.a(paramClass));
      }
    }
    finally {}
    int n;
    int m;
    Object localObject;
    if (this.e.b == 0)
    {
      this.i = 0;
      this.j = 0;
      break label454;
      n = i1;
      if (m < this.e.b)
      {
        localObject = (a)this.e.a(m);
        if ((!((a)localObject).a.equals(paramString)) || (((a)localObject).b.equals(paramClass))) {
          break label460;
        }
        throw new com.badlogic.gdx.utils.f("Asset with name '" + paramString + "' already in preload queue, but has different type (expected: " + com.badlogic.gdx.utils.b.b.a(paramClass) + ", found: " + com.badlogic.gdx.utils.b.b.a(((a)localObject).b) + ")");
      }
    }
    for (;;)
    {
      if (n < this.g.size())
      {
        localObject = ((e)this.g.get(n)).b;
        if ((((a)localObject).a.equals(paramString)) && (!((a)localObject).b.equals(paramClass))) {
          throw new com.badlogic.gdx.utils.f("Asset with name '" + paramString + "' already in task list, but has different type (expected: " + com.badlogic.gdx.utils.b.b.a(paramClass) + ", found: " + com.badlogic.gdx.utils.b.b.a(((a)localObject).b) + ")");
        }
      }
      else
      {
        localObject = (Class)this.b.a(paramString);
        if ((localObject != null) && (!localObject.equals(paramClass))) {
          throw new com.badlogic.gdx.utils.f("Asset with name '" + paramString + "' already loaded, but has different type (expected: " + com.badlogic.gdx.utils.b.b.a(paramClass) + ", found: " + com.badlogic.gdx.utils.b.b.a((Class)localObject) + ")");
        }
        this.j += 1;
        paramString = new a(paramString, paramClass, paramc);
        this.e.a(paramString);
        this.k.a("Queued: " + paramString);
        return;
        label454:
        m = 0;
        break;
        label460:
        m += 1;
        break;
      }
      n += 1;
    }
  }
  
  protected <T> void a(String paramString, Class<T> paramClass, T paramT)
  {
    this.b.a(paramString, paramClass);
    k localk2 = (k)this.a.a(paramClass);
    k localk1 = localk2;
    if (localk2 == null)
    {
      localk1 = new k();
      this.a.a(paramClass, localk1);
    }
    localk1.a(paramString, new g(paramT));
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 70	com/badlogic/gdx/a/f:g	Ljava/util/Stack;
    //   8: invokevirtual 206	java/util/Stack:size	()I
    //   11: ifne +68 -> 79
    //   14: aload_0
    //   15: getfield 183	com/badlogic/gdx/a/f:e	Lcom/badlogic/gdx/utils/a;
    //   18: getfield 284	com/badlogic/gdx/utils/a:b	I
    //   21: ifeq +46 -> 67
    //   24: aload_0
    //   25: getfield 70	com/badlogic/gdx/a/f:g	Ljava/util/Stack;
    //   28: invokevirtual 206	java/util/Stack:size	()I
    //   31: ifne +36 -> 67
    //   34: aload_0
    //   35: invokespecial 347	com/badlogic/gdx/a/f:e	()V
    //   38: goto -24 -> 14
    //   41: astore 4
    //   43: aload_0
    //   44: aload 4
    //   46: invokespecial 349	com/badlogic/gdx/a/f:a	(Ljava/lang/Throwable;)V
    //   49: aload_0
    //   50: getfield 183	com/badlogic/gdx/a/f:e	Lcom/badlogic/gdx/utils/a;
    //   53: getfield 284	com/badlogic/gdx/utils/a:b	I
    //   56: istore_1
    //   57: iload_1
    //   58: ifne +57 -> 115
    //   61: iload_3
    //   62: istore_2
    //   63: aload_0
    //   64: monitorexit
    //   65: iload_2
    //   66: ireturn
    //   67: iload_3
    //   68: istore_2
    //   69: aload_0
    //   70: getfield 70	com/badlogic/gdx/a/f:g	Ljava/util/Stack;
    //   73: invokevirtual 206	java/util/Stack:size	()I
    //   76: ifeq -13 -> 63
    //   79: aload_0
    //   80: invokespecial 351	com/badlogic/gdx/a/f:f	()Z
    //   83: ifeq +27 -> 110
    //   86: aload_0
    //   87: getfield 183	com/badlogic/gdx/a/f:e	Lcom/badlogic/gdx/utils/a;
    //   90: getfield 284	com/badlogic/gdx/utils/a:b	I
    //   93: ifne +17 -> 110
    //   96: aload_0
    //   97: getfield 70	com/badlogic/gdx/a/f:g	Ljava/util/Stack;
    //   100: invokevirtual 206	java/util/Stack:size	()I
    //   103: istore_1
    //   104: iload_3
    //   105: istore_2
    //   106: iload_1
    //   107: ifeq -44 -> 63
    //   110: iconst_0
    //   111: istore_2
    //   112: goto -49 -> 63
    //   115: iconst_0
    //   116: istore_2
    //   117: goto -54 -> 63
    //   120: astore 4
    //   122: aload_0
    //   123: monitorexit
    //   124: aload 4
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	f
    //   56	51	1	m	int
    //   62	55	2	bool1	boolean
    //   1	104	3	bool2	boolean
    //   41	4	4	localThrowable	Throwable
    //   120	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	14	41	java/lang/Throwable
    //   14	38	41	java/lang/Throwable
    //   69	79	41	java/lang/Throwable
    //   79	104	41	java/lang/Throwable
    //   4	14	120	finally
    //   14	38	120	finally
    //   43	57	120	finally
    //   69	79	120	finally
    //   79	104	120	finally
  }
  
  public void b()
  {
    this.k.a("Waiting for loading to complete...");
    while (!a()) {
      com.badlogic.gdx.utils.a.e.a();
    }
    this.k.a("Loading complete.");
  }
  
  public boolean b(String paramString)
  {
    boolean bool;
    if (paramString == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        bool = this.b.d(paramString);
      }
      finally {}
    }
  }
  
  public int c(String paramString)
  {
    Class localClass;
    try
    {
      localClass = (Class)this.b.a(paramString);
      if (localClass == null) {
        throw new com.badlogic.gdx.utils.f("Asset not loaded: " + paramString);
      }
    }
    finally {}
    int m = ((g)((k)this.a.a(localClass)).a(paramString)).c();
    return m;
  }
  
  public void c()
  {
    try
    {
      this.k.a("Disposing.");
      d();
      this.f.c();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void d()
  {
    for (;;)
    {
      Object localObject3;
      try
      {
        this.e.b();
        if (!a()) {
          continue;
        }
        j localj = new j();
        if (this.b.a <= 0) {
          break;
        }
        localj.a();
        localObject2 = this.b.c().a();
        localObject3 = ((com.badlogic.gdx.utils.a)localObject2).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localj.a((String)((Iterator)localObject3).next(), 0);
          continue;
        }
        localObject3 = ((com.badlogic.gdx.utils.a)localObject2).iterator();
      }
      finally {}
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = (String)((Iterator)localObject3).next();
        localObject4 = (com.badlogic.gdx.utils.a)this.c.a(localObject4);
        if (localObject4 != null)
        {
          localObject4 = ((com.badlogic.gdx.utils.a)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            String str = (String)((Iterator)localObject4).next();
            ((j)localObject1).a(str, ((j)localObject1).b(str, 0) + 1);
          }
        }
      }
      Object localObject2 = ((com.badlogic.gdx.utils.a)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        if (((j)localObject1).b(localObject3, 0) == 0) {
          a((String)localObject3);
        }
      }
    }
    this.a.a();
    this.b.a();
    this.c.a();
    this.i = 0;
    this.j = 0;
    this.e.b();
    this.g.clear();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */