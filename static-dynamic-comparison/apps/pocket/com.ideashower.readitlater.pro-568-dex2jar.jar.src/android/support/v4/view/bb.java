package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup;

public class bb
{
  static final be a = new bg();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 18)
    {
      a = new bf();
      return;
    }
    if (i >= 14)
    {
      a = new bd();
      return;
    }
    if (i >= 11)
    {
      a = new bc();
      return;
    }
  }
  
  public static void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    a.a(paramViewGroup, paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/view/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */