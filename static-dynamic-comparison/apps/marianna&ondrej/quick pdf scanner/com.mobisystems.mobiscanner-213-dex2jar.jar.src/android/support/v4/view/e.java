package android.support.v4.view;

import android.os.Build.VERSION;

public class e
{
  static final a aR = new b();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      aR = new c();
      return;
    }
  }
  
  public static int getAbsoluteGravity(int paramInt1, int paramInt2)
  {
    return aR.getAbsoluteGravity(paramInt1, paramInt2);
  }
  
  static abstract interface a
  {
    public abstract int getAbsoluteGravity(int paramInt1, int paramInt2);
  }
  
  static class b
    implements e.a
  {
    public int getAbsoluteGravity(int paramInt1, int paramInt2)
    {
      return 0xFF7FFFFF & paramInt1;
    }
  }
  
  static class c
    implements e.a
  {
    public int getAbsoluteGravity(int paramInt1, int paramInt2)
    {
      return f.getAbsoluteGravity(paramInt1, paramInt2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/view/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */