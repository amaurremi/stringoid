package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class f
{
  static final a dL = new b();
  Object dK;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 14)
    {
      dL = new d();
      return;
    }
    if (i >= 9)
    {
      dL = new c();
      return;
    }
  }
  
  f(Context paramContext, Interpolator paramInterpolator)
  {
    this.dK = dL.b(paramContext, paramInterpolator);
  }
  
  public static f a(Context paramContext, Interpolator paramInterpolator)
  {
    return new f(paramContext, paramInterpolator);
  }
  
  public void abortAnimation()
  {
    dL.E(this.dK);
  }
  
  public boolean computeScrollOffset()
  {
    return dL.D(this.dK);
  }
  
  public int getCurrX()
  {
    return dL.B(this.dK);
  }
  
  public int getCurrY()
  {
    return dL.C(this.dK);
  }
  
  public int getFinalX()
  {
    return dL.F(this.dK);
  }
  
  public int getFinalY()
  {
    return dL.G(this.dK);
  }
  
  public boolean isFinished()
  {
    return dL.y(this.dK);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    dL.a(this.dK, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  static abstract interface a
  {
    public abstract int B(Object paramObject);
    
    public abstract int C(Object paramObject);
    
    public abstract boolean D(Object paramObject);
    
    public abstract void E(Object paramObject);
    
    public abstract int F(Object paramObject);
    
    public abstract int G(Object paramObject);
    
    public abstract void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
    
    public abstract Object b(Context paramContext, Interpolator paramInterpolator);
    
    public abstract boolean y(Object paramObject);
  }
  
  static class b
    implements f.a
  {
    public int B(Object paramObject)
    {
      return ((Scroller)paramObject).getCurrX();
    }
    
    public int C(Object paramObject)
    {
      return ((Scroller)paramObject).getCurrY();
    }
    
    public boolean D(Object paramObject)
    {
      return ((Scroller)paramObject).computeScrollOffset();
    }
    
    public void E(Object paramObject)
    {
      ((Scroller)paramObject).abortAnimation();
    }
    
    public int F(Object paramObject)
    {
      return ((Scroller)paramObject).getFinalX();
    }
    
    public int G(Object paramObject)
    {
      return ((Scroller)paramObject).getFinalY();
    }
    
    public void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      ((Scroller)paramObject).startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    
    public Object b(Context paramContext, Interpolator paramInterpolator)
    {
      if (paramInterpolator != null) {
        return new Scroller(paramContext, paramInterpolator);
      }
      return new Scroller(paramContext);
    }
    
    public boolean y(Object paramObject)
    {
      return ((Scroller)paramObject).isFinished();
    }
  }
  
  static class c
    implements f.a
  {
    public int B(Object paramObject)
    {
      return g.B(paramObject);
    }
    
    public int C(Object paramObject)
    {
      return g.C(paramObject);
    }
    
    public boolean D(Object paramObject)
    {
      return g.D(paramObject);
    }
    
    public void E(Object paramObject)
    {
      g.E(paramObject);
    }
    
    public int F(Object paramObject)
    {
      return g.F(paramObject);
    }
    
    public int G(Object paramObject)
    {
      return g.G(paramObject);
    }
    
    public void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      g.a(paramObject, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    
    public Object b(Context paramContext, Interpolator paramInterpolator)
    {
      return g.b(paramContext, paramInterpolator);
    }
    
    public boolean y(Object paramObject)
    {
      return g.y(paramObject);
    }
  }
  
  static class d
    extends f.c
  {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/widget/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */