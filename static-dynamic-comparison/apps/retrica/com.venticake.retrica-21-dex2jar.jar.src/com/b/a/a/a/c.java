package com.b.a.a.a;

public class c
  extends Exception
{
  h a;
  
  public c(int paramInt, String paramString)
  {
    this(new h(paramInt, paramString));
  }
  
  public c(int paramInt, String paramString, Exception paramException)
  {
    this(new h(paramInt, paramString), paramException);
  }
  
  public c(h paramh)
  {
    this(paramh, null);
  }
  
  public c(h paramh, Exception paramException)
  {
    super(paramh.b(), paramException);
    this.a = paramh;
  }
  
  public h a()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/b/a/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */