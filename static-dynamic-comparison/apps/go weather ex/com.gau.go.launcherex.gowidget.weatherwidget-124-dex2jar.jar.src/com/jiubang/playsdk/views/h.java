package com.jiubang.playsdk.views;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class h
  implements View.OnTouchListener
{
  h(HorizontalListView paramHorizontalListView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return HorizontalListView.a(this.a).onTouchEvent(paramMotionEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */