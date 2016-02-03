package com.vungle.sdk;

import android.content.Context;
import android.widget.ViewFlipper;

final class m
  extends ViewFlipper
{
  public m(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void onDetachedFromWindow()
  {
    try
    {
      super.onDetachedFromWindow();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      stopFlipping();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */