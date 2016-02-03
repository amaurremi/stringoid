package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;

public class j
{
  static final c aT = new a();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 5)
    {
      aT = new b();
      return;
    }
  }
  
  public static int a(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getAction() & 0xFF;
  }
  
  public static int a(MotionEvent paramMotionEvent, int paramInt)
  {
    return aT.a(paramMotionEvent, paramInt);
  }
  
  public static int b(MotionEvent paramMotionEvent)
  {
    return (paramMotionEvent.getAction() & 0xFF00) >> 8;
  }
  
  public static int b(MotionEvent paramMotionEvent, int paramInt)
  {
    return aT.b(paramMotionEvent, paramInt);
  }
  
  public static float c(MotionEvent paramMotionEvent, int paramInt)
  {
    return aT.c(paramMotionEvent, paramInt);
  }
  
  public static int c(MotionEvent paramMotionEvent)
  {
    return aT.c(paramMotionEvent);
  }
  
  public static float d(MotionEvent paramMotionEvent, int paramInt)
  {
    return aT.d(paramMotionEvent, paramInt);
  }
  
  static class a
    implements j.c
  {
    public int a(MotionEvent paramMotionEvent, int paramInt)
    {
      if (paramInt == 0) {
        return 0;
      }
      return -1;
    }
    
    public int b(MotionEvent paramMotionEvent, int paramInt)
    {
      if (paramInt == 0) {
        return 0;
      }
      throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }
    
    public float c(MotionEvent paramMotionEvent, int paramInt)
    {
      if (paramInt == 0) {
        return paramMotionEvent.getX();
      }
      throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }
    
    public int c(MotionEvent paramMotionEvent)
    {
      return 1;
    }
    
    public float d(MotionEvent paramMotionEvent, int paramInt)
    {
      if (paramInt == 0) {
        return paramMotionEvent.getY();
      }
      throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }
  }
  
  static class b
    implements j.c
  {
    public int a(MotionEvent paramMotionEvent, int paramInt)
    {
      return k.a(paramMotionEvent, paramInt);
    }
    
    public int b(MotionEvent paramMotionEvent, int paramInt)
    {
      return k.b(paramMotionEvent, paramInt);
    }
    
    public float c(MotionEvent paramMotionEvent, int paramInt)
    {
      return k.c(paramMotionEvent, paramInt);
    }
    
    public int c(MotionEvent paramMotionEvent)
    {
      return k.c(paramMotionEvent);
    }
    
    public float d(MotionEvent paramMotionEvent, int paramInt)
    {
      return k.d(paramMotionEvent, paramInt);
    }
  }
  
  static abstract interface c
  {
    public abstract int a(MotionEvent paramMotionEvent, int paramInt);
    
    public abstract int b(MotionEvent paramMotionEvent, int paramInt);
    
    public abstract float c(MotionEvent paramMotionEvent, int paramInt);
    
    public abstract int c(MotionEvent paramMotionEvent);
    
    public abstract float d(MotionEvent paramMotionEvent, int paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/view/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */