package android.support.v4.view;

import android.graphics.Paint;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;

public class ag
{
  static final ap a = new ah();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 19)
    {
      a = new ao();
      return;
    }
    if (i >= 17)
    {
      a = new an();
      return;
    }
    if (i >= 16)
    {
      a = new am();
      return;
    }
    if (i >= 14)
    {
      a = new al();
      return;
    }
    if (i >= 11)
    {
      a = new ak();
      return;
    }
    if (i >= 9)
    {
      a = new aj();
      return;
    }
  }
  
  public static int a(View paramView)
  {
    return a.a(paramView);
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void a(View paramView, int paramInt, Paint paramPaint)
  {
    a.a(paramView, paramInt, paramPaint);
  }
  
  public static void a(View paramView, Paint paramPaint)
  {
    a.a(paramView, paramPaint);
  }
  
  public static void a(View paramView, a parama)
  {
    a.a(paramView, parama);
  }
  
  public static void a(View paramView, Runnable paramRunnable)
  {
    a.a(paramView, paramRunnable);
  }
  
  public static boolean a(View paramView, int paramInt)
  {
    return a.a(paramView, paramInt);
  }
  
  public static void b(View paramView)
  {
    a.b(paramView);
  }
  
  public static void b(View paramView, int paramInt)
  {
    a.b(paramView, paramInt);
  }
  
  public static int c(View paramView)
  {
    return a.c(paramView);
  }
  
  public static int d(View paramView)
  {
    return a.d(paramView);
  }
  
  public static int e(View paramView)
  {
    return a.e(paramView);
  }
  
  public static ViewParent f(View paramView)
  {
    return a.f(paramView);
  }
  
  public static boolean g(View paramView)
  {
    return a.g(paramView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/view/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */