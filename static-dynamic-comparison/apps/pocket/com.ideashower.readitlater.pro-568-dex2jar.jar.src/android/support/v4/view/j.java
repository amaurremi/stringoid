package android.support.v4.view;

import android.os.Build.VERSION;

public class j
{
  static final k a = new l();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      a = new m();
      return;
    }
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return a.a(paramInt1, paramInt2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/view/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */