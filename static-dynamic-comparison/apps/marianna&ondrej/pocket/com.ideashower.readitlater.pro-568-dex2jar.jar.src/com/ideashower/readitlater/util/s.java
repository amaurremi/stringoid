package com.ideashower.readitlater.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Point;
import android.view.Display;

@TargetApi(16)
public class s
  extends q
{
  protected s(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  protected Point a(Activity paramActivity, Display paramDisplay, Point paramPoint)
  {
    paramActivity = new Point();
    paramPoint = new Point();
    paramDisplay.getCurrentSizeRange(paramActivity, paramPoint);
    return new Point(paramActivity.x, paramPoint.x);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/util/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */