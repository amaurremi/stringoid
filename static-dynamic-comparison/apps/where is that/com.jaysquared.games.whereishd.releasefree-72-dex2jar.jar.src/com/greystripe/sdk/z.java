package com.greystripe.sdk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

abstract class z
  extends RelativeLayout
{
  private c a;
  
  public z(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public z(Context paramContext, c paramc)
  {
    this(paramContext, null, 0);
    this.a = paramc;
    addView(paramc.j());
  }
  
  protected final void a()
  {
    removeView(this.a.j());
    this.a = null;
  }
  
  protected final void a(c paramc)
  {
    if (this.a != null) {
      return;
    }
    addView(paramc.j());
    this.a = paramc;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */