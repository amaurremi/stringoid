package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

class g
{
  public static int B(Object paramObject)
  {
    return ((OverScroller)paramObject).getCurrX();
  }
  
  public static int C(Object paramObject)
  {
    return ((OverScroller)paramObject).getCurrY();
  }
  
  public static boolean D(Object paramObject)
  {
    return ((OverScroller)paramObject).computeScrollOffset();
  }
  
  public static void E(Object paramObject)
  {
    ((OverScroller)paramObject).abortAnimation();
  }
  
  public static int F(Object paramObject)
  {
    return ((OverScroller)paramObject).getFinalX();
  }
  
  public static int G(Object paramObject)
  {
    return ((OverScroller)paramObject).getFinalY();
  }
  
  public static void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ((OverScroller)paramObject).startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public static Object b(Context paramContext, Interpolator paramInterpolator)
  {
    if (paramInterpolator != null) {
      return new OverScroller(paramContext, paramInterpolator);
    }
    return new OverScroller(paramContext);
  }
  
  public static boolean y(Object paramObject)
  {
    return ((OverScroller)paramObject).isFinished();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/widget/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */