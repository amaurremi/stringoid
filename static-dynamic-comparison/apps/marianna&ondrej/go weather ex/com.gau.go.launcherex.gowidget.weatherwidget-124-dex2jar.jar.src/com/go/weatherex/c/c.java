package com.go.weatherex.c;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.gau.go.launcherex.gowidget.weather.viewframe.viewholder.ScrollViewEx;

class c
  implements View.OnTouchListener
{
  c(a parama) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView.equals(a.a(this.a)))
    {
      a.b(this.a);
      if (paramMotionEvent.getAction() != 1) {
        break label52;
      }
      a.c(this.a).requestDisallowInterceptTouchEvent(false);
      a.a(this.a).clearFocus();
    }
    label52:
    while (!a.a(this.a).isFocused()) {
      return false;
    }
    a.c(this.a).requestDisallowInterceptTouchEvent(true);
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */