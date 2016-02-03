package com.vungle.publisher;

import java.util.concurrent.atomic.AtomicInteger;

public class cm
{
  public final int a = 1;
  public final AtomicInteger b = new AtomicInteger();
  private int c = Integer.MIN_VALUE;
  private int d = 2;
  
  public final int a()
  {
    return this.b.get() >>> this.a;
  }
  
  public final int a(int paramInt1, int paramInt2)
  {
    return b(paramInt1 << this.a, paramInt2);
  }
  
  public final void a(int paramInt)
  {
    int j = this.c;
    int i = j;
    if (j == Integer.MIN_VALUE)
    {
      i = (1 << 32 - this.a) - 1;
      this.c = i;
    }
    if ((i & paramInt) != paramInt) {
      throw new IllegalArgumentException("value has out of range bits set: " + paramInt + " (max bits: " + (32 - this.a) + ")");
    }
  }
  
  final int b(int paramInt1, int paramInt2)
  {
    return c() & paramInt2 | paramInt1;
  }
  
  public final void b()
  {
    if (this.a <= 0) {
      throw new IllegalArgumentException("index exceeds bit array size: 0(size: " + this.a + ")");
    }
  }
  
  public final int c()
  {
    int j = this.d;
    int i = j;
    if (j == 2)
    {
      i = (1 << this.a) - 1;
      this.d = i;
    }
    return i;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */