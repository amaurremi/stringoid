package org.apache.a.c.a;

public class a
{
  private static volatile b a = b.a;
  private final StringBuffer b;
  private final Object c;
  private final b d;
  
  public a(Object paramObject, b paramb)
  {
    this(paramObject, paramb, null);
  }
  
  public a(Object paramObject, b paramb, StringBuffer paramStringBuffer)
  {
    b localb = paramb;
    if (paramb == null) {
      localb = a();
    }
    paramb = paramStringBuffer;
    if (paramStringBuffer == null) {
      paramb = new StringBuffer(512);
    }
    this.b = paramb;
    this.d = localb;
    this.c = paramObject;
    localb.a(paramb, paramObject);
  }
  
  public static b a()
  {
    return a;
  }
  
  public a a(Object paramObject)
  {
    this.d.a(this.b, null, paramObject, null);
    return this;
  }
  
  public Object b()
  {
    return this.c;
  }
  
  public StringBuffer c()
  {
    return this.b;
  }
  
  public b d()
  {
    return this.d;
  }
  
  public String toString()
  {
    if (b() == null) {
      c().append(d().c());
    }
    for (;;)
    {
      return c().toString();
      this.d.b(c(), b());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/apache/a/c/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */