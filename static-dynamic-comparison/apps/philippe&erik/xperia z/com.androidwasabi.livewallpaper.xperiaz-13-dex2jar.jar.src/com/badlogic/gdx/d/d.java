package com.badlogic.gdx.d;

class d
{
  int a = 10;
  float b;
  float c;
  float d;
  float e;
  long f;
  int g;
  float[] h = new float[this.a];
  float[] i = new float[this.a];
  long[] j = new long[this.a];
  
  private float a(float[] paramArrayOfFloat, int paramInt)
  {
    int k = Math.min(this.a, paramInt);
    float f1 = 0.0F;
    paramInt = 0;
    while (paramInt < k)
    {
      f1 += paramArrayOfFloat[paramInt];
      paramInt += 1;
    }
    return f1 / k;
  }
  
  private long a(long[] paramArrayOfLong, int paramInt)
  {
    int k = Math.min(this.a, paramInt);
    paramInt = 0;
    long l = 0L;
    while (paramInt < k)
    {
      l += paramArrayOfLong[paramInt];
      paramInt += 1;
    }
    if (k == 0) {
      return 0L;
    }
    return l / k;
  }
  
  public float a()
  {
    float f1 = a(this.h, this.g);
    float f2 = (float)a(this.j, this.g) / 1.0E9F;
    if (f2 == 0.0F) {
      return 0.0F;
    }
    return f1 / f2;
  }
  
  public void a(float paramFloat1, float paramFloat2, long paramLong)
  {
    int k = 0;
    this.b = paramFloat1;
    this.c = paramFloat2;
    this.d = 0.0F;
    this.e = 0.0F;
    this.g = 0;
    while (k < this.a)
    {
      this.h[k] = 0.0F;
      this.i[k] = 0.0F;
      this.j[k] = 0L;
      k += 1;
    }
    this.f = paramLong;
  }
  
  public float b()
  {
    float f1 = a(this.i, this.g);
    float f2 = (float)a(this.j, this.g) / 1.0E9F;
    if (f2 == 0.0F) {
      return 0.0F;
    }
    return f1 / f2;
  }
  
  public void b(float paramFloat1, float paramFloat2, long paramLong)
  {
    this.d = (paramFloat1 - this.b);
    this.e = (paramFloat2 - this.c);
    this.b = paramFloat1;
    this.c = paramFloat2;
    long l = this.f;
    this.f = paramLong;
    int k = this.g % this.a;
    this.h[k] = this.d;
    this.i[k] = this.e;
    this.j[k] = (paramLong - l);
    this.g += 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */