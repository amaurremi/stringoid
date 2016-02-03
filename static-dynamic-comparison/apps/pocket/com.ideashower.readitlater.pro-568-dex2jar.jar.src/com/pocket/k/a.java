package com.pocket.k;

public abstract class a
{
  protected boolean a;
  
  public a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public abstract int a();
  
  public abstract int a(int paramInt1, int paramInt2);
  
  public abstract int a(int paramInt1, int paramInt2, float paramFloat);
  
  public abstract float b(int paramInt1, int paramInt2);
  
  public abstract int b();
  
  public abstract int b(int paramInt1, int paramInt2, float paramFloat);
  
  protected int c(int paramInt1, int paramInt2)
  {
    int k = 1;
    int j = 1;
    int i = paramInt2;
    if (paramInt1 < paramInt2)
    {
      i = paramInt2;
      if (!this.a) {
        i = paramInt1;
      }
    }
    paramInt2 = k;
    if (i < 1) {
      return j;
    }
    for (;;)
    {
      j = paramInt2;
      if (paramInt1 / 2 < i) {
        break;
      }
      paramInt1 /= 2;
      paramInt2 *= 2;
    }
  }
  
  public abstract String c();
  
  protected float d(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < paramInt2) && (!this.a)) {
      return 1.0F;
    }
    return paramInt2 / paramInt1;
  }
  
  public abstract String d();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/k/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */