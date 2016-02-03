package com.b.a;

class i
  extends h
{
  float d;
  
  i(float paramFloat)
  {
    this.a = paramFloat;
    this.b = Float.TYPE;
  }
  
  i(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.d = paramFloat2;
    this.b = Float.TYPE;
    this.c = true;
  }
  
  public Object a()
  {
    return Float.valueOf(this.d);
  }
  
  public float e()
  {
    return this.d;
  }
  
  public i f()
  {
    i locali = new i(b(), this.d);
    locali.a(c());
    return locali;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/b/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */