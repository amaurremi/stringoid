package com.badlogic.gdx.math;

public class a
{
  protected static final g[] a;
  protected static final float[] b;
  public final c[] c = new c[6];
  public final g[] d = { new g(), new g(), new g(), new g(), new g(), new g(), new g(), new g() };
  protected final float[] e = new float[24];
  
  static
  {
    int i = 0;
    a = new g[] { new g(-1.0F, -1.0F, -1.0F), new g(1.0F, -1.0F, -1.0F), new g(1.0F, 1.0F, -1.0F), new g(-1.0F, 1.0F, -1.0F), new g(-1.0F, -1.0F, 1.0F), new g(1.0F, -1.0F, 1.0F), new g(1.0F, 1.0F, 1.0F), new g(-1.0F, 1.0F, 1.0F) };
    b = new float[24];
    g[] arrayOfg = a;
    int k = arrayOfg.length;
    int j = 0;
    while (i < k)
    {
      g localg = arrayOfg[i];
      float[] arrayOfFloat = b;
      int m = j + 1;
      arrayOfFloat[j] = localg.a;
      arrayOfFloat = b;
      int n = m + 1;
      arrayOfFloat[m] = localg.b;
      arrayOfFloat = b;
      j = n + 1;
      arrayOfFloat[n] = localg.c;
      i += 1;
    }
  }
  
  public a()
  {
    while (i < 6)
    {
      this.c[i] = new c(new g(), 0.0F);
      i += 1;
    }
  }
  
  public void a(Matrix4 paramMatrix4)
  {
    System.arraycopy(b, 0, this.e, 0, b.length);
    Matrix4.prj(paramMatrix4.b, this.e, 0, 8, 3);
    int j = 0;
    int i = 0;
    while (i < 8)
    {
      paramMatrix4 = this.d[i];
      float[] arrayOfFloat = this.e;
      int k = j + 1;
      paramMatrix4.a = arrayOfFloat[j];
      arrayOfFloat = this.e;
      int m = k + 1;
      paramMatrix4.b = arrayOfFloat[k];
      arrayOfFloat = this.e;
      j = m + 1;
      paramMatrix4.c = arrayOfFloat[m];
      i += 1;
    }
    this.c[0].a(this.d[1], this.d[0], this.d[2]);
    this.c[1].a(this.d[4], this.d[5], this.d[7]);
    this.c[2].a(this.d[0], this.d[4], this.d[3]);
    this.c[3].a(this.d[5], this.d[1], this.d[6]);
    this.c[4].a(this.d[2], this.d[3], this.d[6]);
    this.c[5].a(this.d[4], this.d[0], this.d[1]);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/math/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */