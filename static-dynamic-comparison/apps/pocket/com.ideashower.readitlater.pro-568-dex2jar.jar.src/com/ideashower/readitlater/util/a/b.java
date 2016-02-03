package com.ideashower.readitlater.util.a;

import android.graphics.Bitmap;

public class b
{
  private final Bitmap a;
  private final String b;
  private int c;
  private int d;
  
  public b(Bitmap paramBitmap, String paramString)
  {
    if (paramBitmap == null) {
      throw new IllegalArgumentException("Bitmap can not be null");
    }
    this.b = paramString;
    this.a = paramBitmap;
    this.c = 0;
    this.d = 0;
  }
  
  private void d()
  {
    if ((this.d <= 0) && (this.c <= 0) && (c()) && (!this.a.isRecycled())) {
      this.a.recycle();
    }
  }
  
  void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (this.d += 1;; this.d -= 1)
    {
      d();
      return;
    }
  }
  
  public boolean a()
  {
    return this.c > 0;
  }
  
  public Bitmap b()
  {
    return this.a;
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (this.c += 1;; this.c -= 1)
    {
      d();
      return;
    }
  }
  
  public boolean c()
  {
    return !this.a.isRecycled();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/util/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */