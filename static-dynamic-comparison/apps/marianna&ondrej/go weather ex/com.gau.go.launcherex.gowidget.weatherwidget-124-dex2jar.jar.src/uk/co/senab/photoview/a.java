package uk.co.senab.photoview;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;

public class a
{
  public static int a(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      return c(paramInt);
    }
    return b(paramInt);
  }
  
  public static void a(View paramView, Runnable paramRunnable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      b(paramView, paramRunnable);
      return;
    }
    paramView.postDelayed(paramRunnable, 16L);
  }
  
  @TargetApi(5)
  private static int b(int paramInt)
  {
    return (0xFF00 & paramInt) >> 8;
  }
  
  @TargetApi(16)
  private static void b(View paramView, Runnable paramRunnable)
  {
    paramView.postOnAnimation(paramRunnable);
  }
  
  @TargetApi(11)
  private static int c(int paramInt)
  {
    return (0xFF00 & paramInt) >> 8;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/uk/co/senab/photoview/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */