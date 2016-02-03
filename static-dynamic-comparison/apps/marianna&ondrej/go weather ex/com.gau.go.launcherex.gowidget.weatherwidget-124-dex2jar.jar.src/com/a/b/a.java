package com.a.b;

public abstract class a
  extends c
{
  public a(String paramString)
  {
    super(Float.class, paramString);
  }
  
  public abstract void a(Object paramObject, float paramFloat);
  
  public final void a(Object paramObject, Float paramFloat)
  {
    a(paramObject, paramFloat.floatValue());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/a/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */