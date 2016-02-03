package com.go.weatherex.c;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;

class d
  implements View.OnTouchListener
{
  d(a parama) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView.equals(a.c(this.a)))
    {
      a.b(this.a);
      if (paramMotionEvent.getAction() == 2)
      {
        a.d(this.a);
        a.a(this.a).clearFocus();
      }
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */