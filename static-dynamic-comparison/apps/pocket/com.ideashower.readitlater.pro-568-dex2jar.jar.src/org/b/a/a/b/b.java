package org.b.a.a.b;

public abstract class b
{
  protected int[] a;
  protected float b;
  protected boolean c;
  private int d;
  private int e;
  
  public b()
  {
    b();
  }
  
  public float a()
  {
    float f1;
    if ((this.e <= 0) || (this.d <= 4)) {
      f1 = 0.01F;
    }
    float f2;
    do
    {
      return f1;
      if (this.e == this.d) {
        break;
      }
      f2 = this.d / (this.e - this.d) * this.b;
      f1 = f2;
    } while (f2 < 0.99F);
    return 0.99F;
  }
  
  protected abstract int a(byte[] paramArrayOfByte, int paramInt);
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = -1;
    if (paramInt2 == 2) {
      i = a(paramArrayOfByte, paramInt1);
    }
    if (i >= 0)
    {
      this.e += 1;
      if ((i < this.a.length) && (512 > this.a[i])) {
        this.d += 1;
      }
    }
  }
  
  public void b()
  {
    this.c = false;
    this.e = 0;
    this.d = 0;
  }
  
  public boolean c()
  {
    return this.e > 1024;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/b/a/a/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */