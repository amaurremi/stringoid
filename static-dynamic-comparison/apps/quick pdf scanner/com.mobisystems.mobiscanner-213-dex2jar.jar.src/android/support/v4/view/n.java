package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

public class n
{
  static final c bC = new a();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      bC = new b();
      return;
    }
  }
  
  public static float a(VelocityTracker paramVelocityTracker, int paramInt)
  {
    return bC.a(paramVelocityTracker, paramInt);
  }
  
  public static float b(VelocityTracker paramVelocityTracker, int paramInt)
  {
    return bC.b(paramVelocityTracker, paramInt);
  }
  
  static class a
    implements n.c
  {
    public float a(VelocityTracker paramVelocityTracker, int paramInt)
    {
      return paramVelocityTracker.getXVelocity();
    }
    
    public float b(VelocityTracker paramVelocityTracker, int paramInt)
    {
      return paramVelocityTracker.getYVelocity();
    }
  }
  
  static class b
    implements n.c
  {
    public float a(VelocityTracker paramVelocityTracker, int paramInt)
    {
      return o.a(paramVelocityTracker, paramInt);
    }
    
    public float b(VelocityTracker paramVelocityTracker, int paramInt)
    {
      return o.b(paramVelocityTracker, paramInt);
    }
  }
  
  static abstract interface c
  {
    public abstract float a(VelocityTracker paramVelocityTracker, int paramInt);
    
    public abstract float b(VelocityTracker paramVelocityTracker, int paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/view/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */