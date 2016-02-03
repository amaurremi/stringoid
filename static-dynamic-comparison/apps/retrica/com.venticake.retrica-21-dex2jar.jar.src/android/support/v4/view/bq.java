package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup;

public class bq
{
  static final bt a = new bv();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 18)
    {
      a = new bu();
      return;
    }
    if (i >= 14)
    {
      a = new bs();
      return;
    }
    if (i >= 11)
    {
      a = new br();
      return;
    }
  }
  
  public static void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    a.a(paramViewGroup, paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v4/view/bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */