package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.b.a.b;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public class ad
{
  static final ah a = new ae();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 14)
    {
      a = new ag();
      return;
    }
    if (i >= 11)
    {
      a = new af();
      return;
    }
  }
  
  public static MenuItem a(MenuItem paramMenuItem, j paramj)
  {
    if ((paramMenuItem instanceof b)) {
      return ((b)paramMenuItem).a(paramj);
    }
    Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
    return paramMenuItem;
  }
  
  public static MenuItem a(MenuItem paramMenuItem, View paramView)
  {
    if ((paramMenuItem instanceof b)) {
      return ((b)paramMenuItem).setActionView(paramView);
    }
    return a.a(paramMenuItem, paramView);
  }
  
  public static void a(MenuItem paramMenuItem, int paramInt)
  {
    if ((paramMenuItem instanceof b))
    {
      ((b)paramMenuItem).setShowAsAction(paramInt);
      return;
    }
    a.a(paramMenuItem, paramInt);
  }
  
  public static MenuItem b(MenuItem paramMenuItem, int paramInt)
  {
    if ((paramMenuItem instanceof b)) {
      return ((b)paramMenuItem).setActionView(paramInt);
    }
    return a.b(paramMenuItem, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v4/view/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */