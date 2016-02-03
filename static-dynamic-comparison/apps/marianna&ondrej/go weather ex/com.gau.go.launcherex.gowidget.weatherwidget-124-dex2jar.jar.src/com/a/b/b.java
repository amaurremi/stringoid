package com.a.b;

public abstract class b
  extends c
{
  public b(String paramString)
  {
    super(Integer.class, paramString);
  }
  
  public abstract void a(Object paramObject, int paramInt);
  
  public final void a(Object paramObject, Integer paramInteger)
  {
    a(paramObject, Integer.valueOf(paramInteger.intValue()));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/a/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */