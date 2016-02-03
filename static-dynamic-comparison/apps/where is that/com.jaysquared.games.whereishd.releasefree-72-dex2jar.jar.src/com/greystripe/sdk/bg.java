package com.greystripe.sdk;

import android.content.Context;

final class bg
  extends ai
{
  private static boolean d = false;
  
  public bg(Context paramContext)
  {
    super(paramContext);
    a("s", "mb");
  }
  
  final void a()
  {
    d = true;
  }
  
  final void b()
  {
    d = false;
  }
  
  final void c() {}
  
  protected final void h()
  {
    if (d)
    {
      a(GSAdErrorCode.FETCH_LIMIT_EXCEEDED);
      return;
    }
    super.h();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */