package com.jiubang.playsdk.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.jiubang.playsdk.f;

public class ActionBarBackLayout
  extends RelativeLayout
{
  private RelativeLayout a;
  
  public ActionBarBackLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ActionBarBackLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((RelativeLayout)findViewById(f.a));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a != null)
    {
      if (paramMotionEvent.getAction() != 0) {
        break label28;
      }
      this.a.setPressed(true);
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      label28:
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 7)) {
        this.a.setPressed(false);
      } else if (paramMotionEvent.getAction() != 2) {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/ActionBarBackLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */