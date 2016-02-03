package com.gau.go.launcherex.gowidget.weather.viewframe.viewholder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import java.util.ArrayList;
import java.util.Iterator;

public class ScrollViewEx
  extends ScrollView
{
  private a a;
  private boolean b = false;
  private ArrayList c = new ArrayList();
  
  public ScrollViewEx(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ScrollViewEx(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ScrollViewEx(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {}
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    Rect localRect = new Rect();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      ((View)localIterator.next()).getGlobalVisibleRect(localRect);
      if (localRect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
        return true;
      }
    }
    return false;
  }
  
  public void a(View paramView)
  {
    if (paramView != null) {
      this.c.add(paramView);
    }
  }
  
  public void b(View paramView)
  {
    if (paramView != null) {
      this.c.remove(paramView);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.a != null) {
      this.a.a(this, paramCanvas);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (a(paramMotionEvent)) {}
    while ((!super.onInterceptTouchEvent(paramMotionEvent)) || (this.b)) {
      return false;
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (a(paramMotionEvent)) {}
    while ((!super.onTouchEvent(paramMotionEvent)) || (this.b)) {
      return false;
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/viewframe/viewholder/ScrollViewEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */