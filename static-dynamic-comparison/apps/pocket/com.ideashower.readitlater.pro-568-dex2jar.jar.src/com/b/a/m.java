package com.b.a;

class m
  extends l
{
  e h;
  float i;
  
  public m(String paramString, float... paramVarArgs)
  {
    super(paramString, null);
    a(paramVarArgs);
  }
  
  void a(float paramFloat)
  {
    this.i = this.h.b(paramFloat);
  }
  
  public void a(float... paramVarArgs)
  {
    super.a(paramVarArgs);
    this.h = ((e)this.e);
  }
  
  Object d()
  {
    return Float.valueOf(this.i);
  }
  
  public m e()
  {
    m localm = (m)super.a();
    localm.h = ((e)localm.e);
    return localm;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/b/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */