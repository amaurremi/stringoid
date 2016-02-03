package com.appbrain.a;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.os.Looper;
import com.appbrain.e.j.i;
import java.util.List;

public class u
{
  private static final String a = u.class.getName();
  private static final Handler b = new Handler(Looper.getMainLooper());
  private static List c;
  private static boolean d;
  
  private static Drawable a(int paramInt1, int paramInt2)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    ColorDrawable localColorDrawable = new ColorDrawable(paramInt2);
    localStateListDrawable.addState(new int[] { 16842919 }, localColorDrawable);
    localColorDrawable = new ColorDrawable(paramInt1);
    localStateListDrawable.addState(new int[0], localColorDrawable);
    return localStateListDrawable;
  }
  
  static void a(Activity paramActivity, j.i parami)
  {
    boolean bool = d;
    Handler localHandler = b;
    paramActivity = new v(paramActivity, parami, bool);
    if (bool) {}
    for (long l = 200L;; l = 0L)
    {
      localHandler.postDelayed(paramActivity, l);
      return;
    }
  }
  
  private static final class a
  {
    private int a;
    private int b;
    private int c;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */