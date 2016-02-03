package com.ideashower.readitlater.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;

@TargetApi(13)
public class r
  extends q
{
  protected r(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  protected Point a(Activity paramActivity, Display paramDisplay, Point paramPoint)
  {
    int i = 0;
    Point localPoint1 = new Point();
    a(paramDisplay, localPoint1);
    Point localPoint2 = new Point();
    if ((localPoint1.x == paramPoint.x) || (localPoint1.x == paramPoint.y))
    {
      localPoint1.x = paramPoint.x;
      localPoint2.x = paramPoint.y;
      paramPoint.x = localPoint1.x;
      paramPoint.y = localPoint2.x;
      if (j.a(false))
      {
        if (!"KFOT".equalsIgnoreCase(Build.MODEL)) {
          break label274;
        }
        i = 60;
      }
    }
    for (;;)
    {
      if (paramPoint.x <= paramPoint.y) {
        break label321;
      }
      paramPoint.x -= i;
      return paramPoint;
      int j = paramActivity.getRequestedOrientation();
      if (localPoint1.x == localPoint1.y)
      {
        localPoint2.x = localPoint1.y;
        localPoint2.x = localPoint1.y;
      }
      for (;;)
      {
        paramActivity.setRequestedOrientation(j);
        break;
        if (localPoint1.x > localPoint1.y)
        {
          paramActivity.setRequestedOrientation(1);
          a(paramDisplay, localPoint2);
          if (localPoint1.equals(localPoint2))
          {
            paramActivity.setRequestedOrientation(0);
            a(paramDisplay, localPoint2);
          }
        }
        else
        {
          paramActivity.setRequestedOrientation(0);
          a(paramDisplay, localPoint2);
          if (localPoint1.equals(localPoint2))
          {
            paramActivity.setRequestedOrientation(1);
            a(paramDisplay, localPoint2);
          }
        }
      }
      label274:
      if ("KFTT".equalsIgnoreCase(Build.MODEL)) {
        i = 78;
      } else if (("KFJWI".equalsIgnoreCase(Build.MODEL)) || ("KFJWA".equalsIgnoreCase(Build.MODEL))) {
        i = 90;
      }
    }
    label321:
    paramPoint.y -= i;
    return paramPoint;
  }
  
  protected Point a(Display paramDisplay, Point paramPoint)
  {
    paramDisplay.getSize(paramPoint);
    return paramPoint;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/util/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */