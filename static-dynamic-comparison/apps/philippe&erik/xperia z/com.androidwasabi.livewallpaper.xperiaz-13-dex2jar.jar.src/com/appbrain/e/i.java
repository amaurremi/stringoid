package com.appbrain.e;

public final class i
  extends com.appbrain.b.l
  implements j
{
  private int a;
  private k b = k.f();
  
  private i f()
  {
    return new i().a(g());
  }
  
  private h g()
  {
    int i = 1;
    h localh = new h('\000');
    if ((this.a & 0x1) == 1) {}
    for (;;)
    {
      h.a(localh, this.b);
      h.a(localh, i);
      return localh;
      i = 0;
    }
  }
  
  public final i a(h paramh)
  {
    if (paramh == h.f()) {}
    while (!paramh.g()) {
      return this;
    }
    paramh = paramh.h();
    if (((this.a & 0x1) == 1) && (this.b != k.f())) {}
    for (this.b = k.a(this.b).a(paramh).d();; this.b = paramh)
    {
      this.a |= 0x1;
      return this;
    }
  }
  
  public final boolean e()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/e/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */