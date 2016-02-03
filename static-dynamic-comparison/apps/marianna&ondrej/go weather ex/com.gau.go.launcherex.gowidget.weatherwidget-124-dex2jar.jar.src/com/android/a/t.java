package com.android.a;

public class t
{
  public final Object a;
  public final c b;
  public final aa c;
  public boolean d = false;
  
  private t(aa paramaa)
  {
    this.a = null;
    this.b = null;
    this.c = paramaa;
  }
  
  private t(Object paramObject, c paramc)
  {
    this.a = paramObject;
    this.b = paramc;
    this.c = null;
  }
  
  public static t a(aa paramaa)
  {
    return new t(paramaa);
  }
  
  public static t a(Object paramObject, c paramc)
  {
    return new t(paramObject, paramc);
  }
  
  public boolean a()
  {
    return this.c == null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/android/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */