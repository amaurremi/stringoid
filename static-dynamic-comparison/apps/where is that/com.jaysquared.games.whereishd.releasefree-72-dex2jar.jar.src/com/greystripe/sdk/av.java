package com.greystripe.sdk;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.widget.FrameLayout;
import android.widget.ImageButton;

final class av
  implements Runnable
{
  av(at paramat, ImageButton paramImageButton) {}
  
  public final void run()
  {
    Rect localRect = new Rect();
    this.a.getHitRect(localRect);
    localRect.right += 15;
    localRect.bottom += 15;
    at.a(this.b).setTouchDelegate(new TouchDelegate(localRect, this.a));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */