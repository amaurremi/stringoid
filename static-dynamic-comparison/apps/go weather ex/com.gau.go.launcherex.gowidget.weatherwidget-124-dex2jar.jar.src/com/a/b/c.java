package com.a.b;

public abstract class c
{
  private final String a;
  private final Class b;
  
  public c(Class paramClass, String paramString)
  {
    this.a = paramString;
    this.b = paramClass;
  }
  
  public abstract Object a(Object paramObject);
  
  public String a()
  {
    return this.a;
  }
  
  public void a(Object paramObject1, Object paramObject2)
  {
    throw new UnsupportedOperationException("Property " + a() + " is read-only");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/a/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */