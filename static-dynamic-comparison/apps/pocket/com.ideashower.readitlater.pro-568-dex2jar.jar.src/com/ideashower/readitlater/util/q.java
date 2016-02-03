package com.ideashower.readitlater.util;

import android.app.Activity;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.ideashower.readitlater.h.a;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.h.l;

public class q
{
  public static q a;
  private static boolean d = false;
  protected final int b;
  protected final int c;
  
  protected q(Activity paramActivity)
  {
    int j = i.a(a.bc);
    int k = i.a(a.bd);
    if (d) {
      j = 0;
    }
    for (;;)
    {
      paramActivity = a(a(paramActivity, paramActivity.getWindowManager().getDefaultDisplay(), new Point(j, i)));
      this.b = paramActivity.x;
      this.c = paramActivity.y;
      if ((j != this.b) || (i != this.c)) {
        i.b().a(a.bc, paramActivity.x).a(a.bd, paramActivity.y).a();
      }
      return;
      i = k;
    }
  }
  
  private Point a(Point paramPoint)
  {
    if (paramPoint.x > paramPoint.y) {
      return new Point(paramPoint.y, paramPoint.x);
    }
    return new Point(paramPoint.x, paramPoint.y);
  }
  
  public static void a()
  {
    i.b().a(a.bc, 0).a(a.bd, 0).a();
  }
  
  public static void a(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 13) {
      b(paramActivity);
    }
  }
  
  public static q b(Activity paramActivity)
  {
    if (a == null) {
      a = c(paramActivity);
    }
    return a;
  }
  
  private static q c(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return new s(paramActivity);
    }
    if (Build.VERSION.SDK_INT >= 13) {
      return new r(paramActivity);
    }
    return new q(paramActivity);
  }
  
  public int a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return this.b;
    }
    return (int)j.a(this.b);
  }
  
  protected Point a(Activity paramActivity, Display paramDisplay, Point paramPoint)
  {
    return new Point(paramDisplay.getWidth(), paramDisplay.getHeight());
  }
  
  public int b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return this.c;
    }
    return (int)j.a(this.c);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/util/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */