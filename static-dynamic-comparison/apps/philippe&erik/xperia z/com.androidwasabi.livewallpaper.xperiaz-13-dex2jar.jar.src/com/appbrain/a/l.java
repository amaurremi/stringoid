package com.appbrain.a;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;

final class l
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  l(j paramj, Button paramButton) {}
  
  public final void onGlobalLayout()
  {
    Rect localRect = new Rect();
    if (this.a.getGlobalVisibleRect(localRect, new Point())) {
      j.a(this.b, localRect.centerX(), localRect.centerY());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */