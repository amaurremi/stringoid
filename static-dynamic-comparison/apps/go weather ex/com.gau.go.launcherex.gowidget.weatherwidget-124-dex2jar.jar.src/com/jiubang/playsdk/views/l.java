package com.jiubang.playsdk.views;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.widget.Scroller;

@TargetApi(11)
final class l
{
  static
  {
    if (Build.VERSION.SDK_INT < 11) {
      throw new RuntimeException("Should not get to HoneycombPlus class unless sdk is >= 11!");
    }
  }
  
  public static void a(Scroller paramScroller, float paramFloat)
  {
    if (paramScroller != null) {
      paramScroller.setFriction(paramFloat);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */