package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public class aw
{
  static final az a = new ax();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      a = new ay();
      return;
    }
  }
  
  public static int a(ViewConfiguration paramViewConfiguration)
  {
    return a.a(paramViewConfiguration);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/view/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */