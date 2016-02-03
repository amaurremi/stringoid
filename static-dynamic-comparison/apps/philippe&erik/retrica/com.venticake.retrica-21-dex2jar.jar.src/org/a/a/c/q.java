package org.a.a.c;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import org.a.a.c;
import org.a.a.d;
import org.a.a.j;

public final class q
  extends c
  implements Serializable
{
  private static HashMap<d, q> a;
  private final d b;
  private final j c;
  
  private q(d paramd, j paramj)
  {
    if ((paramd == null) || (paramj == null)) {
      throw new IllegalArgumentException();
    }
    this.b = paramd;
    this.c = paramj;
  }
  
  /* Error */
  public static q a(d paramd, j paramj)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 29	org/a/a/c/q:a	Ljava/util/HashMap;
    //   6: ifnonnull +47 -> 53
    //   9: new 31	java/util/HashMap
    //   12: dup
    //   13: bipush 7
    //   15: invokespecial 34	java/util/HashMap:<init>	(I)V
    //   18: putstatic 29	org/a/a/c/q:a	Ljava/util/HashMap;
    //   21: aconst_null
    //   22: astore_2
    //   23: aload_2
    //   24: astore_3
    //   25: aload_2
    //   26: ifnonnull +22 -> 48
    //   29: new 2	org/a/a/c/q
    //   32: dup
    //   33: aload_0
    //   34: aload_1
    //   35: invokespecial 36	org/a/a/c/q:<init>	(Lorg/a/a/d;Lorg/a/a/j;)V
    //   38: astore_3
    //   39: getstatic 29	org/a/a/c/q:a	Ljava/util/HashMap;
    //   42: aload_0
    //   43: aload_3
    //   44: invokevirtual 40	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   47: pop
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_3
    //   52: areturn
    //   53: getstatic 29	org/a/a/c/q:a	Ljava/util/HashMap;
    //   56: aload_0
    //   57: invokevirtual 44	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   60: checkcast 2	org/a/a/c/q
    //   63: astore_3
    //   64: aload_3
    //   65: astore_2
    //   66: aload_3
    //   67: ifnull -44 -> 23
    //   70: aload_3
    //   71: invokevirtual 48	org/a/a/c/q:d	()Lorg/a/a/j;
    //   74: astore 4
    //   76: aload_3
    //   77: astore_2
    //   78: aload 4
    //   80: aload_1
    //   81: if_acmpeq -58 -> 23
    //   84: aconst_null
    //   85: astore_2
    //   86: goto -63 -> 23
    //   89: astore_0
    //   90: ldc 2
    //   92: monitorexit
    //   93: aload_0
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramd	d
    //   0	95	1	paramj	j
    //   22	64	2	localObject1	Object
    //   24	53	3	localObject2	Object
    //   74	5	4	localj	j
    // Exception table:
    //   from	to	target	type
    //   3	21	89	finally
    //   29	48	89	finally
    //   53	64	89	finally
    //   70	76	89	finally
  }
  
  private UnsupportedOperationException i()
  {
    return new UnsupportedOperationException(this.b + " field is unsupported");
  }
  
  public int a(long paramLong)
  {
    throw i();
  }
  
  public int a(Locale paramLocale)
  {
    throw i();
  }
  
  public long a(long paramLong, int paramInt)
  {
    return d().a(paramLong, paramInt);
  }
  
  public long a(long paramLong1, long paramLong2)
  {
    return d().a(paramLong1, paramLong2);
  }
  
  public long a(long paramLong, String paramString, Locale paramLocale)
  {
    throw i();
  }
  
  public String a(int paramInt, Locale paramLocale)
  {
    throw i();
  }
  
  public String a(long paramLong, Locale paramLocale)
  {
    throw i();
  }
  
  public d a()
  {
    return this.b;
  }
  
  public long b(long paramLong, int paramInt)
  {
    throw i();
  }
  
  public String b()
  {
    return this.b.x();
  }
  
  public String b(int paramInt, Locale paramLocale)
  {
    throw i();
  }
  
  public String b(long paramLong, Locale paramLocale)
  {
    throw i();
  }
  
  public boolean b(long paramLong)
  {
    throw i();
  }
  
  public int c(long paramLong)
  {
    throw i();
  }
  
  public boolean c()
  {
    return false;
  }
  
  public long d(long paramLong)
  {
    throw i();
  }
  
  public j d()
  {
    return this.c;
  }
  
  public long e(long paramLong)
  {
    throw i();
  }
  
  public j e()
  {
    return null;
  }
  
  public long f(long paramLong)
  {
    throw i();
  }
  
  public j f()
  {
    return null;
  }
  
  public int g()
  {
    throw i();
  }
  
  public long g(long paramLong)
  {
    throw i();
  }
  
  public int h()
  {
    throw i();
  }
  
  public long h(long paramLong)
  {
    throw i();
  }
  
  public long i(long paramLong)
  {
    throw i();
  }
  
  public String toString()
  {
    return "UnsupportedDateTimeField";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/a/a/c/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */