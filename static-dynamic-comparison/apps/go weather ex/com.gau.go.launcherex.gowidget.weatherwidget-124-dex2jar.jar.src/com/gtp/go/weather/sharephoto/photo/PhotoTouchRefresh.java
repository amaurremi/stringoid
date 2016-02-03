package com.gtp.go.weather.sharephoto.photo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class PhotoTouchRefresh
  extends FrameLayout
{
  private an a;
  
  public PhotoTouchRefresh(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public PhotoTouchRefresh(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public PhotoTouchRefresh(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {}
  
  protected void a(an paraman)
  {
    this.a = paraman;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a != null) {
      return this.a.a(paramMotionEvent);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a != null) {
      return this.a.b(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/photo/PhotoTouchRefresh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */