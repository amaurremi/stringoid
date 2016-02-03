package uk.co.senab.photoview.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

@TargetApi(8)
public class c
  extends b
{
  protected final ScaleGestureDetector f = new ScaleGestureDetector(paramContext, new d(this));
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean a()
  {
    return this.f.isInProgress();
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    this.f.onTouchEvent(paramMotionEvent);
    return super.c(paramMotionEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/uk/co/senab/photoview/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */