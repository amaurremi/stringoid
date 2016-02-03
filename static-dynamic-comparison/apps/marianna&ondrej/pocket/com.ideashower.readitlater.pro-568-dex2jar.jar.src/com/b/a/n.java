package com.b.a;

class n
  extends l
{
  g h;
  int i;
  
  public n(String paramString, int... paramVarArgs)
  {
    super(paramString, null);
    a(paramVarArgs);
  }
  
  void a(float paramFloat)
  {
    this.i = this.h.b(paramFloat);
  }
  
  public void a(int... paramVarArgs)
  {
    super.a(paramVarArgs);
    this.h = ((g)this.e);
  }
  
  Object d()
  {
    return Integer.valueOf(this.i);
  }
  
  public n e()
  {
    n localn = (n)super.a();
    localn.h = ((g)localn.e);
    return localn;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/b/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */