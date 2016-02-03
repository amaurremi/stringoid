package com.a.a;

class p
  extends o
{
  float d;
  
  p(float paramFloat)
  {
    this.a = paramFloat;
    this.b = Float.TYPE;
  }
  
  p(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.d = paramFloat2;
    this.b = Float.TYPE;
    this.c = true;
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject != null) && (paramObject.getClass() == Float.class))
    {
      this.d = ((Float)paramObject).floatValue();
      this.c = true;
    }
  }
  
  public Object b()
  {
    return Float.valueOf(this.d);
  }
  
  public float f()
  {
    return this.d;
  }
  
  public p g()
  {
    p localp = new p(c(), this.d);
    localp.a(d());
    return localp;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/a/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */