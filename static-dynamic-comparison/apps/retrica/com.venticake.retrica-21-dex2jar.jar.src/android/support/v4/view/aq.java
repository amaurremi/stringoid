package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

public class aq
{
  static final at a = new ar();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      a = new as();
      return;
    }
  }
  
  public static float a(VelocityTracker paramVelocityTracker, int paramInt)
  {
    return a.a(paramVelocityTracker, paramInt);
  }
  
  public static float b(VelocityTracker paramVelocityTracker, int paramInt)
  {
    return a.b(paramVelocityTracker, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v4/view/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */