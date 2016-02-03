package android.support.v4.app;

import android.os.Build.VERSION;

public class t
{
  private static final z a = new aa();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      a = new ae();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      a = new ad();
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      a = new ac();
      return;
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      a = new ab();
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/app/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */