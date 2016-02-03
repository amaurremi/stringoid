package uk.co.senab.photoview;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnLongClickListener;

class c
  extends GestureDetector.SimpleOnGestureListener
{
  c(b paramb) {}
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (b.a(this.a) != null) {
      b.a(this.a).onLongClick(this.a.c());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/uk/co/senab/photoview/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */