package com.a.a;

class q
  extends o
{
  int d;
  
  q(float paramFloat)
  {
    this.a = paramFloat;
    this.b = Integer.TYPE;
  }
  
  q(float paramFloat, int paramInt)
  {
    this.a = paramFloat;
    this.d = paramInt;
    this.b = Integer.TYPE;
    this.c = true;
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject != null) && (paramObject.getClass() == Integer.class))
    {
      this.d = ((Integer)paramObject).intValue();
      this.c = true;
    }
  }
  
  public Object b()
  {
    return Integer.valueOf(this.d);
  }
  
  public int f()
  {
    return this.d;
  }
  
  public q g()
  {
    q localq = new q(c(), this.d);
    localq.a(d());
    return localq;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/a/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */