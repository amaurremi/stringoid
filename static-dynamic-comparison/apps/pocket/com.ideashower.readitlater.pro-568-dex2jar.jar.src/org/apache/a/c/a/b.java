package org.apache.a.c.a;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.WeakHashMap;

public abstract class b
  implements Serializable
{
  public static final b a = new c();
  public static final b b = new d();
  public static final b c = new e();
  public static final b d = new f();
  public static final b e = new g();
  private static final ThreadLocal f = new ThreadLocal();
  private boolean g = true;
  private boolean h = true;
  private boolean i = false;
  private boolean j = true;
  private String k = "[";
  private String l = "]";
  private String m = "=";
  private boolean n = false;
  private boolean o = false;
  private String p = ",";
  private String q = "{";
  private String r = ",";
  private boolean s = true;
  private String t = "}";
  private boolean u = true;
  private String v = "<null>";
  private String w = "<size=";
  private String x = ">";
  private String y = "<";
  private String z = ">";
  
  static Map a()
  {
    return (Map)f.get();
  }
  
  static boolean a(Object paramObject)
  {
    Map localMap = a();
    return (localMap != null) && (localMap.containsKey(paramObject));
  }
  
  static void b(Object paramObject)
  {
    if (paramObject != null)
    {
      if (a() == null) {
        f.set(new WeakHashMap());
      }
      a().put(paramObject, null);
    }
  }
  
  static void c(Object paramObject)
  {
    if (paramObject != null)
    {
      Map localMap = a();
      if (localMap != null)
      {
        localMap.remove(paramObject);
        if (localMap.isEmpty()) {
          f.remove();
        }
      }
    }
  }
  
  protected String a(Class paramClass)
  {
    return org.apache.a.c.c.a(paramClass);
  }
  
  protected void a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.k = str;
  }
  
  protected void a(StringBuffer paramStringBuffer)
  {
    int i2 = 0;
    int i3 = paramStringBuffer.length();
    int i4 = this.p.length();
    if ((i3 > 0) && (i4 > 0) && (i3 >= i4))
    {
      i1 = 0;
      if (i1 >= i4) {
        break label91;
      }
      if (paramStringBuffer.charAt(i3 - 1 - i1) == this.p.charAt(i4 - 1 - i1)) {
        break label84;
      }
    }
    label84:
    label91:
    for (int i1 = i2;; i1 = 1)
    {
      if (i1 != 0) {
        paramStringBuffer.setLength(i3 - i4);
      }
      return;
      i1 += 1;
      break;
    }
  }
  
  public void a(StringBuffer paramStringBuffer, Object paramObject)
  {
    if (paramObject != null)
    {
      c(paramStringBuffer, paramObject);
      d(paramStringBuffer, paramObject);
      b(paramStringBuffer);
      if (this.n) {
        d(paramStringBuffer);
      }
    }
  }
  
  protected void a(StringBuffer paramStringBuffer, String paramString)
  {
    paramStringBuffer.append(this.v);
  }
  
  protected void a(StringBuffer paramStringBuffer, String paramString, byte paramByte)
  {
    paramStringBuffer.append(paramByte);
  }
  
  protected void a(StringBuffer paramStringBuffer, String paramString, char paramChar)
  {
    paramStringBuffer.append(paramChar);
  }
  
  protected void a(StringBuffer paramStringBuffer, String paramString, double paramDouble)
  {
    paramStringBuffer.append(paramDouble);
  }
  
  protected void a(StringBuffer paramStringBuffer, String paramString, float paramFloat)
  {
    paramStringBuffer.append(paramFloat);
  }
  
  protected void a(StringBuffer paramStringBuffer, String paramString, int paramInt)
  {
    paramStringBuffer.append(paramInt);
  }
  
  protected void a(StringBuffer paramStringBuffer, String paramString, long paramLong)
  {
    paramStringBuffer.append(paramLong);
  }
  
  protected void a(StringBuffer paramStringBuffer, String paramString, Object paramObject)
  {
    org.apache.a.c.e.a(paramStringBuffer, paramObject);
  }
  
  public void a(StringBuffer paramStringBuffer, String paramString, Object paramObject, Boolean paramBoolean)
  {
    b(paramStringBuffer, paramString);
    if (paramObject == null) {
      a(paramStringBuffer, paramString);
    }
    for (;;)
    {
      c(paramStringBuffer, paramString);
      return;
      a(paramStringBuffer, paramString, paramObject, a(paramBoolean));
    }
  }
  
  protected void a(StringBuffer paramStringBuffer, String paramString, Object paramObject, boolean paramBoolean)
  {
    if ((a(paramObject)) && (!(paramObject instanceof Number)) && (!(paramObject instanceof Boolean)) && (!(paramObject instanceof Character)))
    {
      a(paramStringBuffer, paramString, paramObject);
      return;
    }
    b(paramObject);
    for (;;)
    {
      try
      {
        if ((paramObject instanceof Collection))
        {
          if (paramBoolean)
          {
            a(paramStringBuffer, paramString, (Collection)paramObject);
            return;
          }
          b(paramStringBuffer, paramString, ((Collection)paramObject).size());
          continue;
        }
        if (!(paramObject instanceof Map)) {
          break label135;
        }
      }
      finally
      {
        c(paramObject);
      }
      if (paramBoolean)
      {
        a(paramStringBuffer, paramString, (Map)paramObject);
      }
      else
      {
        b(paramStringBuffer, paramString, ((Map)paramObject).size());
        continue;
        label135:
        if ((paramObject instanceof long[]))
        {
          if (paramBoolean) {
            a(paramStringBuffer, paramString, (long[])paramObject);
          } else {
            b(paramStringBuffer, paramString, (long[])paramObject);
          }
        }
        else if ((paramObject instanceof int[]))
        {
          if (paramBoolean) {
            a(paramStringBuffer, paramString, (int[])paramObject);
          } else {
            b(paramStringBuffer, paramString, (int[])paramObject);
          }
        }
        else if ((paramObject instanceof short[]))
        {
          if (paramBoolean) {
            a(paramStringBuffer, paramString, (short[])paramObject);
          } else {
            b(paramStringBuffer, paramString, (short[])paramObject);
          }
        }
        else if ((paramObject instanceof byte[]))
        {
          if (paramBoolean) {
            a(paramStringBuffer, paramString, (byte[])paramObject);
          } else {
            b(paramStringBuffer, paramString, (byte[])paramObject);
          }
        }
        else if ((paramObject instanceof char[]))
        {
          if (paramBoolean) {
            a(paramStringBuffer, paramString, (char[])paramObject);
          } else {
            b(paramStringBuffer, paramString, (char[])paramObject);
          }
        }
        else if ((paramObject instanceof double[]))
        {
          if (paramBoolean) {
            a(paramStringBuffer, paramString, (double[])paramObject);
          } else {
            b(paramStringBuffer, paramString, (double[])paramObject);
          }
        }
        else if ((paramObject instanceof float[]))
        {
          if (paramBoolean) {
            a(paramStringBuffer, paramString, (float[])paramObject);
          } else {
            b(paramStringBuffer, paramString, (float[])paramObject);
          }
        }
        else if ((paramObject instanceof boolean[]))
        {
          if (paramBoolean) {
            a(paramStringBuffer, paramString, (boolean[])paramObject);
          } else {
            b(paramStringBuffer, paramString, (boolean[])paramObject);
          }
        }
        else if (paramObject.getClass().isArray())
        {
          if (paramBoolean) {
            a(paramStringBuffer, paramString, (Object[])paramObject);
          } else {
            b(paramStringBuffer, paramString, (Object[])paramObject);
          }
        }
        else if (paramBoolean) {
          b(paramStringBuffer, paramString, paramObject);
        } else {
          c(paramStringBuffer, paramString, paramObject);
        }
      }
    }
  }
  
  protected void a(StringBuffer paramStringBuffer, String paramString, Collection paramCollection)
  {
    paramStringBuffer.append(paramCollection);
  }
  
  protected void a(StringBuffer paramStringBuffer, String paramString, Map paramMap)
  {
    paramStringBuffer.append(paramMap);
  }
  
  protected void a(StringBuffer paramStringBuffer, String paramString, short paramShort)
  {
    paramStringBuffer.append(paramShort);
  }
  
  protected void a(StringBuffer paramStringBuffer, String paramString, boolean paramBoolean)
  {
    paramStringBuffer.append(paramBoolean);
  }
  
  protected void a(StringBuffer paramStringBuffer, String paramString, byte[] paramArrayOfByte)
  {
    paramStringBuffer.append(this.q);
    int i1 = 0;
    while (i1 < paramArrayOfByte.length)
    {
      if (i1 > 0) {
        paramStringBuffer.append(this.r);
      }
      a(paramStringBuffer, paramString, paramArrayOfByte[i1]);
      i1 += 1;
    }
    paramStringBuffer.append(this.t);
  }
  
  protected void a(StringBuffer paramStringBuffer, String paramString, char[] paramArrayOfChar)
  {
    paramStringBuffer.append(this.q);
    int i1 = 0;
    while (i1 < paramArrayOfChar.length)
    {
      if (i1 > 0) {
        paramStringBuffer.append(this.r);
      }
      a(paramStringBuffer, paramString, paramArrayOfChar[i1]);
      i1 += 1;
    }
    paramStringBuffer.append(this.t);
  }
  
  protected void a(StringBuffer paramStringBuffer, String paramString, double[] paramArrayOfDouble)
  {
    paramStringBuffer.append(this.q);
    int i1 = 0;
    while (i1 < paramArrayOfDouble.length)
    {
      if (i1 > 0) {
        paramStringBuffer.append(this.r);
      }
      a(paramStringBuffer, paramString, paramArrayOfDouble[i1]);
      i1 += 1;
    }
    paramStringBuffer.append(this.t);
  }
  
  protected void a(StringBuffer paramStringBuffer, String paramString, float[] paramArrayOfFloat)
  {
    paramStringBuffer.append(this.q);
    int i1 = 0;
    while (i1 < paramArrayOfFloat.length)
    {
      if (i1 > 0) {
        paramStringBuffer.append(this.r);
      }
      a(paramStringBuffer, paramString, paramArrayOfFloat[i1]);
      i1 += 1;
    }
    paramStringBuffer.append(this.t);
  }
  
  protected void a(StringBuffer paramStringBuffer, String paramString, int[] paramArrayOfInt)
  {
    paramStringBuffer.append(this.q);
    int i1 = 0;
    while (i1 < paramArrayOfInt.length)
    {
      if (i1 > 0) {
        paramStringBuffer.append(this.r);
      }
      a(paramStringBuffer, paramString, paramArrayOfInt[i1]);
      i1 += 1;
    }
    paramStringBuffer.append(this.t);
  }
  
  protected void a(StringBuffer paramStringBuffer, String paramString, long[] paramArrayOfLong)
  {
    paramStringBuffer.append(this.q);
    int i1 = 0;
    while (i1 < paramArrayOfLong.length)
    {
      if (i1 > 0) {
        paramStringBuffer.append(this.r);
      }
      a(paramStringBuffer, paramString, paramArrayOfLong[i1]);
      i1 += 1;
    }
    paramStringBuffer.append(this.t);
  }
  
  protected void a(StringBuffer paramStringBuffer, String paramString, Object[] paramArrayOfObject)
  {
    paramStringBuffer.append(this.q);
    int i1 = 0;
    if (i1 < paramArrayOfObject.length)
    {
      Object localObject = paramArrayOfObject[i1];
      if (i1 > 0) {
        paramStringBuffer.append(this.r);
      }
      if (localObject == null) {
        a(paramStringBuffer, paramString);
      }
      for (;;)
      {
        i1 += 1;
        break;
        a(paramStringBuffer, paramString, localObject, this.s);
      }
    }
    paramStringBuffer.append(this.t);
  }
  
  protected void a(StringBuffer paramStringBuffer, String paramString, short[] paramArrayOfShort)
  {
    paramStringBuffer.append(this.q);
    int i1 = 0;
    while (i1 < paramArrayOfShort.length)
    {
      if (i1 > 0) {
        paramStringBuffer.append(this.r);
      }
      a(paramStringBuffer, paramString, paramArrayOfShort[i1]);
      i1 += 1;
    }
    paramStringBuffer.append(this.t);
  }
  
  protected void a(StringBuffer paramStringBuffer, String paramString, boolean[] paramArrayOfBoolean)
  {
    paramStringBuffer.append(this.q);
    int i1 = 0;
    while (i1 < paramArrayOfBoolean.length)
    {
      if (i1 > 0) {
        paramStringBuffer.append(this.r);
      }
      a(paramStringBuffer, paramString, paramArrayOfBoolean[i1]);
      i1 += 1;
    }
    paramStringBuffer.append(this.t);
  }
  
  protected void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  protected boolean a(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return this.u;
    }
    return paramBoolean.booleanValue();
  }
  
  protected void b(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.l = str;
  }
  
  protected void b(StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append(this.k);
  }
  
  public void b(StringBuffer paramStringBuffer, Object paramObject)
  {
    if (!this.o) {
      a(paramStringBuffer);
    }
    c(paramStringBuffer);
    c(paramObject);
  }
  
  protected void b(StringBuffer paramStringBuffer, String paramString)
  {
    if ((this.g) && (paramString != null))
    {
      paramStringBuffer.append(paramString);
      paramStringBuffer.append(this.m);
    }
  }
  
  protected void b(StringBuffer paramStringBuffer, String paramString, int paramInt)
  {
    paramStringBuffer.append(this.w);
    paramStringBuffer.append(paramInt);
    paramStringBuffer.append(this.x);
  }
  
  protected void b(StringBuffer paramStringBuffer, String paramString, Object paramObject)
  {
    paramStringBuffer.append(paramObject);
  }
  
  protected void b(StringBuffer paramStringBuffer, String paramString, byte[] paramArrayOfByte)
  {
    b(paramStringBuffer, paramString, paramArrayOfByte.length);
  }
  
  protected void b(StringBuffer paramStringBuffer, String paramString, char[] paramArrayOfChar)
  {
    b(paramStringBuffer, paramString, paramArrayOfChar.length);
  }
  
  protected void b(StringBuffer paramStringBuffer, String paramString, double[] paramArrayOfDouble)
  {
    b(paramStringBuffer, paramString, paramArrayOfDouble.length);
  }
  
  protected void b(StringBuffer paramStringBuffer, String paramString, float[] paramArrayOfFloat)
  {
    b(paramStringBuffer, paramString, paramArrayOfFloat.length);
  }
  
  protected void b(StringBuffer paramStringBuffer, String paramString, int[] paramArrayOfInt)
  {
    b(paramStringBuffer, paramString, paramArrayOfInt.length);
  }
  
  protected void b(StringBuffer paramStringBuffer, String paramString, long[] paramArrayOfLong)
  {
    b(paramStringBuffer, paramString, paramArrayOfLong.length);
  }
  
  protected void b(StringBuffer paramStringBuffer, String paramString, Object[] paramArrayOfObject)
  {
    b(paramStringBuffer, paramString, paramArrayOfObject.length);
  }
  
  protected void b(StringBuffer paramStringBuffer, String paramString, short[] paramArrayOfShort)
  {
    b(paramStringBuffer, paramString, paramArrayOfShort.length);
  }
  
  protected void b(StringBuffer paramStringBuffer, String paramString, boolean[] paramArrayOfBoolean)
  {
    b(paramStringBuffer, paramString, paramArrayOfBoolean.length);
  }
  
  protected void b(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  protected boolean b()
  {
    return this.j;
  }
  
  protected String c()
  {
    return this.v;
  }
  
  protected void c(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.p = str;
  }
  
  protected void c(StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append(this.l);
  }
  
  protected void c(StringBuffer paramStringBuffer, Object paramObject)
  {
    if ((this.h) && (paramObject != null))
    {
      b(paramObject);
      if (this.i) {
        paramStringBuffer.append(a(paramObject.getClass()));
      }
    }
    else
    {
      return;
    }
    paramStringBuffer.append(paramObject.getClass().getName());
  }
  
  protected void c(StringBuffer paramStringBuffer, String paramString)
  {
    d(paramStringBuffer);
  }
  
  protected void c(StringBuffer paramStringBuffer, String paramString, Object paramObject)
  {
    paramStringBuffer.append(this.y);
    paramStringBuffer.append(a(paramObject.getClass()));
    paramStringBuffer.append(this.z);
  }
  
  protected void c(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  protected void d(StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append(this.p);
  }
  
  protected void d(StringBuffer paramStringBuffer, Object paramObject)
  {
    if ((b()) && (paramObject != null))
    {
      b(paramObject);
      paramStringBuffer.append('@');
      paramStringBuffer.append(Integer.toHexString(System.identityHashCode(paramObject)));
    }
  }
  
  protected void d(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  protected void e(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/a/c/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */