package com.b.a;

class j
  extends h
{
  int d;
  
  j(float paramFloat)
  {
    this.a = paramFloat;
    this.b = Integer.TYPE;
  }
  
  j(float paramFloat, int paramInt)
  {
    this.a = paramFloat;
    this.d = paramInt;
    this.b = Integer.TYPE;
    this.c = true;
  }
  
  public Object a()
  {
    return Integer.valueOf(this.d);
  }
  
  public int e()
  {
    return this.d;
  }
  
  public j f()
  {
    j localj = new j(b(), this.d);
    localj.a(c());
    return localj;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/b/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */