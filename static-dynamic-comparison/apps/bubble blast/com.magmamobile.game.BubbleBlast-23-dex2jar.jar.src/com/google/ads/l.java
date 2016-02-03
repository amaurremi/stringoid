package com.google.ads;

import com.google.ads.internal.c;
import com.google.ads.util.i;
import com.google.ads.util.i.b;
import com.google.ads.util.i.c;

public final class l
  extends i
{
  public final i.b<n> a;
  public final i.c<c> b;
  public final i.c<Boolean> c = new i.c(this, "disableNativeScroll", Boolean.valueOf(false));
  
  public l(n paramn)
  {
    this.a = new i.b(this, "slotState", paramn);
    this.b = new i.c(this, "adLoader", new c(this));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/ads/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */