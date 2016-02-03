package com.appflood.e;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public final class g
  implements View.OnTouchListener
{
  public g(Drawable[] paramArrayOfDrawable) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
      paramView.setBackgroundDrawable(this.a[0]);
    }
    while (paramMotionEvent.getAction() != 0) {
      return false;
    }
    paramView.setBackgroundDrawable(this.a[1]);
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/e/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */