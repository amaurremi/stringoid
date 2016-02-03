package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public class bl
{
  static final bo a = new bm();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      a = new bn();
      return;
    }
  }
  
  public static int a(ViewConfiguration paramViewConfiguration)
  {
    return a.a(paramViewConfiguration);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v4/view/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */