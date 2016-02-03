package com.jiubang.playsdk.views;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.widget.Scroller;

@TargetApi(14)
final class m
{
  static
  {
    if (Build.VERSION.SDK_INT < 14) {
      throw new RuntimeException("Should not get to IceCreamSandwichPlus class unless sdk is >= 14!");
    }
  }
  
  public static float a(Scroller paramScroller)
  {
    return paramScroller.getCurrVelocity();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */