package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

class s
{
  static long A()
  {
    return ValueAnimator.getFrameDelay();
  }
  
  public static void a(View paramView, int paramInt, Paint paramPaint)
  {
    paramView.setLayerType(paramInt, paramPaint);
  }
  
  public static int f(View paramView)
  {
    return paramView.getLayerType();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/view/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */