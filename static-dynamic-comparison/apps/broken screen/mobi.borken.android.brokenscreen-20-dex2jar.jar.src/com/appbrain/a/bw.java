package com.appbrain.a;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;

final class bw
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bw(bu parambu, Button paramButton) {}
  
  public final void onGlobalLayout()
  {
    Rect localRect = new Rect();
    if (this.a.getGlobalVisibleRect(localRect, new Point())) {
      bu.a(this.b, localRect.centerX(), localRect.centerY());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */