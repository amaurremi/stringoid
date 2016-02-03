package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.KeyEvent;

public class w
{
  static final aa a = new x();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      a = new z();
      return;
    }
  }
  
  public static boolean a(KeyEvent paramKeyEvent)
  {
    return a.b(paramKeyEvent.getMetaState());
  }
  
  public static boolean a(KeyEvent paramKeyEvent, int paramInt)
  {
    return a.a(paramKeyEvent.getMetaState(), paramInt);
  }
  
  public static void b(KeyEvent paramKeyEvent)
  {
    a.a(paramKeyEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v4/view/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */