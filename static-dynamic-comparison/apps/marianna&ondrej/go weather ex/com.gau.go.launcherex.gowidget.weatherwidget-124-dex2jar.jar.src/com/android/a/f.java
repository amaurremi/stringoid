package com.android.a;

public class f
  implements x
{
  private int a;
  private int b;
  private final int c;
  private final float d;
  
  public f()
  {
    this(2500, 1, 1.0F);
  }
  
  public f(int paramInt1, int paramInt2, float paramFloat)
  {
    this.a = paramInt1;
    this.c = paramInt2;
    this.d = paramFloat;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(aa paramaa)
  {
    this.b += 1;
    this.a = ((int)(this.a + this.a * this.d));
    if (!c()) {
      throw paramaa;
    }
  }
  
  public int b()
  {
    return this.b;
  }
  
  protected boolean c()
  {
    return this.b <= this.c;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/android/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */