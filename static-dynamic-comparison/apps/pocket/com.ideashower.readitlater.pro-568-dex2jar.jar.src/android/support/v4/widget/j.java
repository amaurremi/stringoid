package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;

public class j
{
  static final k b = new l();
  Object a;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 14)
    {
      b = new n();
      return;
    }
    if (i >= 9)
    {
      b = new m();
      return;
    }
  }
  
  j(Context paramContext, Interpolator paramInterpolator)
  {
    this.a = b.a(paramContext, paramInterpolator);
  }
  
  public static j a(Context paramContext, Interpolator paramInterpolator)
  {
    return new j(paramContext, paramInterpolator);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    b.a(this.a, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public boolean a()
  {
    return b.a(this.a);
  }
  
  public int b()
  {
    return b.b(this.a);
  }
  
  public int c()
  {
    return b.c(this.a);
  }
  
  public int d()
  {
    return b.f(this.a);
  }
  
  public int e()
  {
    return b.g(this.a);
  }
  
  public boolean f()
  {
    return b.d(this.a);
  }
  
  public void g()
  {
    b.e(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/widget/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */