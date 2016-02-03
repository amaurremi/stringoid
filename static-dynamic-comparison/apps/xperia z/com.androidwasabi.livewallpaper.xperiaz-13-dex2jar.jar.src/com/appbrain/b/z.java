package com.appbrain.b;

final class z
  implements e
{
  int a;
  private final y c;
  private e d;
  
  private z(x paramx)
  {
    this.c = new y(paramx, (byte)0);
    this.d = this.c.a().a();
    this.a = paramx.b();
  }
  
  public final byte a()
  {
    if (!this.d.hasNext()) {
      this.d = this.c.a().a();
    }
    this.a -= 1;
    return this.d.a();
  }
  
  public final boolean hasNext()
  {
    return this.a > 0;
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/b/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */