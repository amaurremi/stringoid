package com.greystripe.sdk;

final class p
  implements ag
{
  private p(c paramc) {}
  
  public final void a()
  {
    if (c.f(this.a)) {}
    do
    {
      do
      {
        return;
        bd.b("AdModel#onFetchSucceeded", new Object[0]);
        c.a(this.a, true);
        if (c.g(this.a))
        {
          c.h(this.a);
          return;
        }
        if (!c.i(this.a)) {
          break;
        }
        c.h(this.a);
      } while (!c.j(this.a));
      bd.b("ondisplaywascalled", new Object[0]);
      c.k(this.a);
      return;
    } while (c.j(this.a));
    c.l(this.a);
  }
  
  public final void a(GSAdErrorCode paramGSAdErrorCode)
  {
    if (paramGSAdErrorCode == GSAdErrorCode.INVALID_APPLICATION_IDENTIFIER) {
      bd.e("onFetchFailed: " + paramGSAdErrorCode, new Object[0]);
    }
    for (;;)
    {
      c.a(this.a, false);
      c.c(this.a);
      c.d(this.a);
      c.e(this.a);
      this.a.a(paramGSAdErrorCode);
      return;
      bd.b("onFetchFailed: " + paramGSAdErrorCode, new Object[0]);
    }
  }
  
  public final void b()
  {
    c.k(this.a);
  }
  
  public final void c()
  {
    this.a.a();
  }
  
  public final void d()
  {
    c.e(this.a);
    this.a.b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */