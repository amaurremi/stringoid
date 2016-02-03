package com.gau.go.launcherex.gowidget.scriptengine.parser;

public class ad
  extends d
{
  private int h;
  private int i;
  private int j;
  private int k;
  private float l;
  private float m;
  private float n;
  private float o;
  private boolean p = true;
  private boolean q = true;
  private int r;
  
  public ad(int paramInt)
  {
    super(paramInt);
  }
  
  public void a(float paramFloat)
  {
    this.l = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public boolean a()
  {
    return this.p;
  }
  
  public void b(float paramFloat)
  {
    this.m = paramFloat;
  }
  
  public void b(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public boolean b()
  {
    return this.q;
  }
  
  public void d(float paramFloat)
  {
    this.n = paramFloat;
  }
  
  public void e(float paramFloat)
  {
    this.o = paramFloat;
  }
  
  public void h(int paramInt)
  {
    this.j = paramInt;
  }
  
  public float i()
  {
    return this.l;
  }
  
  public void i(int paramInt)
  {
    this.k = paramInt;
  }
  
  public float j()
  {
    return this.m;
  }
  
  public void j(int paramInt)
  {
    this.r = paramInt;
  }
  
  public float k()
  {
    return this.n;
  }
  
  public float l()
  {
    return this.o;
  }
  
  public int m()
  {
    return this.h;
  }
  
  public int n()
  {
    return this.i;
  }
  
  public int o()
  {
    return this.j;
  }
  
  public int p()
  {
    return this.k;
  }
  
  public int q()
  {
    return this.r;
  }
  
  public String toString()
  {
    return "TranslateBehavior " + super.toString() + ", fromXDelta = " + this.l + ", toXDelta = " + this.m + ", fromYDelta = " + this.n + ", toYDelta = " + this.o + ", outScreenX = " + this.p + ", outScreenY = " + this.q + "\n";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/scriptengine/parser/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */