package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public class w
{
  static final c bE = new a();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      bE = new b();
      return;
    }
  }
  
  public static int a(ViewConfiguration paramViewConfiguration)
  {
    return bE.a(paramViewConfiguration);
  }
  
  static class a
    implements w.c
  {
    public int a(ViewConfiguration paramViewConfiguration)
    {
      return paramViewConfiguration.getScaledTouchSlop();
    }
  }
  
  static class b
    implements w.c
  {
    public int a(ViewConfiguration paramViewConfiguration)
    {
      return x.a(paramViewConfiguration);
    }
  }
  
  static abstract interface c
  {
    public abstract int a(ViewConfiguration paramViewConfiguration);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/view/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */