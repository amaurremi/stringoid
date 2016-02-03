package com.vungle.sdk;

import android.content.Context;

final class x
  extends ag
{
  b a;
  
  public x(Context paramContext, String paramString, Object paramObject)
    throws v.a
  {
    super(paramContext, paramString, paramObject);
    this.a = ((b)paramObject);
  }
  
  protected final void a(Context paramContext)
  {
    paramContext = new p(paramContext);
    this.c = paramContext.a;
    this.b = paramContext.b;
  }
  
  protected final ag.a d()
  {
    return new a((byte)0);
  }
  
  protected final void e()
  {
    this.a.a();
  }
  
  private final class a
    extends ag.a
  {
    private a()
    {
      super();
    }
    
    public final boolean a(String paramString1, String paramString2)
    {
      if (paramString1.equalsIgnoreCase("close"))
      {
        x.this.a.b();
        return true;
      }
      if (paramString1.equalsIgnoreCase("watch"))
      {
        x.this.a.a();
        return true;
      }
      if (paramString1.equalsIgnoreCase("download"))
      {
        x.this.a.c();
        return true;
      }
      if (paramString1.equalsIgnoreCase("custom"))
      {
        x.this.a.a(paramString2);
        return true;
      }
      return false;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a();
    
    public abstract void a(String paramString);
    
    public abstract void b();
    
    public abstract void c();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */