package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup;

public class y
{
  static final c bF = new e();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 18)
    {
      bF = new d();
      return;
    }
    if (i >= 14)
    {
      bF = new b();
      return;
    }
    if (i >= 11)
    {
      bF = new a();
      return;
    }
  }
  
  public static void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    bF.a(paramViewGroup, paramBoolean);
  }
  
  static class a
    extends y.e
  {
    public void a(ViewGroup paramViewGroup, boolean paramBoolean)
    {
      z.a(paramViewGroup, paramBoolean);
    }
  }
  
  static class b
    extends y.a
  {}
  
  static abstract interface c
  {
    public abstract void a(ViewGroup paramViewGroup, boolean paramBoolean);
  }
  
  static class d
    extends y.b
  {}
  
  static class e
    implements y.c
  {
    public void a(ViewGroup paramViewGroup, boolean paramBoolean) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/view/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */