package android.support.v4.view;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;

public class p
{
  static final i bD = new a();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 19)
    {
      bD = new h();
      return;
    }
    if (i >= 17)
    {
      bD = new g();
      return;
    }
    if (i >= 16)
    {
      bD = new f();
      return;
    }
    if (i >= 14)
    {
      bD = new e();
      return;
    }
    if (i >= 11)
    {
      bD = new d();
      return;
    }
    if (i >= 9)
    {
      bD = new c();
      return;
    }
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    bD.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void a(View paramView, int paramInt, Paint paramPaint)
  {
    bD.a(paramView, paramInt, paramPaint);
  }
  
  public static void a(View paramView, Paint paramPaint)
  {
    bD.a(paramView, paramPaint);
  }
  
  public static void a(View paramView, a parama)
  {
    bD.a(paramView, parama);
  }
  
  public static void a(View paramView, Runnable paramRunnable)
  {
    bD.a(paramView, paramRunnable);
  }
  
  public static boolean a(View paramView, int paramInt)
  {
    return bD.a(paramView, paramInt);
  }
  
  public static void b(View paramView, int paramInt)
  {
    bD.b(paramView, paramInt);
  }
  
  public static int c(View paramView)
  {
    return bD.c(paramView);
  }
  
  public static void d(View paramView)
  {
    bD.d(paramView);
  }
  
  public static int e(View paramView)
  {
    return bD.e(paramView);
  }
  
  public static int f(View paramView)
  {
    return bD.f(paramView);
  }
  
  public static int g(View paramView)
  {
    return bD.g(paramView);
  }
  
  public static ViewParent h(View paramView)
  {
    return bD.h(paramView);
  }
  
  public static boolean i(View paramView)
  {
    return bD.i(paramView);
  }
  
  static class a
    implements p.i
  {
    long A()
    {
      return 10L;
    }
    
    public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramView.postInvalidateDelayed(A(), paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void a(View paramView, int paramInt, Paint paramPaint) {}
    
    public void a(View paramView, Paint paramPaint) {}
    
    public void a(View paramView, a parama) {}
    
    public void a(View paramView, Runnable paramRunnable)
    {
      paramView.postDelayed(paramRunnable, A());
    }
    
    public boolean a(View paramView, int paramInt)
    {
      return false;
    }
    
    public void b(View paramView, int paramInt) {}
    
    public int c(View paramView)
    {
      return 2;
    }
    
    public void d(View paramView)
    {
      paramView.postInvalidateDelayed(A());
    }
    
    public int e(View paramView)
    {
      return 0;
    }
    
    public int f(View paramView)
    {
      return 0;
    }
    
    public int g(View paramView)
    {
      return 0;
    }
    
    public ViewParent h(View paramView)
    {
      return paramView.getParent();
    }
    
    public boolean i(View paramView)
    {
      boolean bool2 = false;
      paramView = paramView.getBackground();
      boolean bool1 = bool2;
      if (paramView != null)
      {
        bool1 = bool2;
        if (paramView.getOpacity() == -1) {
          bool1 = true;
        }
      }
      return bool1;
    }
  }
  
  static class b
    extends p.a
  {
    public boolean i(View paramView)
    {
      return q.i(paramView);
    }
  }
  
  static class c
    extends p.b
  {
    public int c(View paramView)
    {
      return r.c(paramView);
    }
  }
  
  static class d
    extends p.c
  {
    long A()
    {
      return s.A();
    }
    
    public void a(View paramView, int paramInt, Paint paramPaint)
    {
      s.a(paramView, paramInt, paramPaint);
    }
    
    public void a(View paramView, Paint paramPaint)
    {
      a(paramView, f(paramView), paramPaint);
      paramView.invalidate();
    }
    
    public int f(View paramView)
    {
      return s.f(paramView);
    }
  }
  
  static class e
    extends p.d
  {
    public void a(View paramView, a parama)
    {
      t.b(paramView, parama.u());
    }
    
    public boolean a(View paramView, int paramInt)
    {
      return t.a(paramView, paramInt);
    }
  }
  
  static class f
    extends p.e
  {
    public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      u.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void a(View paramView, Runnable paramRunnable)
    {
      u.a(paramView, paramRunnable);
    }
    
    public void b(View paramView, int paramInt)
    {
      u.b(paramView, paramInt);
    }
    
    public void d(View paramView)
    {
      u.d(paramView);
    }
    
    public int e(View paramView)
    {
      return u.e(paramView);
    }
    
    public ViewParent h(View paramView)
    {
      return u.h(paramView);
    }
  }
  
  static class g
    extends p.f
  {
    public void a(View paramView, Paint paramPaint)
    {
      v.a(paramView, paramPaint);
    }
    
    public int g(View paramView)
    {
      return v.g(paramView);
    }
  }
  
  static class h
    extends p.g
  {}
  
  static abstract interface i
  {
    public abstract void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void a(View paramView, int paramInt, Paint paramPaint);
    
    public abstract void a(View paramView, Paint paramPaint);
    
    public abstract void a(View paramView, a parama);
    
    public abstract void a(View paramView, Runnable paramRunnable);
    
    public abstract boolean a(View paramView, int paramInt);
    
    public abstract void b(View paramView, int paramInt);
    
    public abstract int c(View paramView);
    
    public abstract void d(View paramView);
    
    public abstract int e(View paramView);
    
    public abstract int f(View paramView);
    
    public abstract int g(View paramView);
    
    public abstract ViewParent h(View paramView);
    
    public abstract boolean i(View paramView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/view/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */