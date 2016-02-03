package android.support.v4.view;

import android.os.Build.VERSION;

public class r
{
  static final s a = new t();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      a = new u();
      return;
    }
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return a.a(paramInt1, paramInt2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v4/view/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */