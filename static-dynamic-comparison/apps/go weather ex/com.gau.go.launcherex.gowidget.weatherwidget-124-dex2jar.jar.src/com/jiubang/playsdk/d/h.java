package com.jiubang.playsdk.d;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.ListView;

public class h
  extends ListView
{
  private b a;
  
  public h(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(b paramb)
  {
    this.a = paramb;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (this.a.b()))
    {
      this.a.a();
      return true;
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      if ((paramMotionEvent.getX() > getLeft()) && (paramMotionEvent.getX() < getRight()) && (paramMotionEvent.getY() > getTop()) && (paramMotionEvent.getY() < getBottom())) {
        return super.onTouchEvent(paramMotionEvent);
      }
      if ((paramMotionEvent.getAction() == 1) && (this.a != null) && (this.a.b())) {
        this.a.a();
      }
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent) {}
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/d/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */