package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

class u
{
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.postInvalidate(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void a(View paramView, Runnable paramRunnable)
  {
    paramView.postOnAnimation(paramRunnable);
  }
  
  public static void b(View paramView, int paramInt)
  {
    paramView.setImportantForAccessibility(paramInt);
  }
  
  public static void d(View paramView)
  {
    paramView.postInvalidateOnAnimation();
  }
  
  public static int e(View paramView)
  {
    return paramView.getImportantForAccessibility();
  }
  
  public static ViewParent h(View paramView)
  {
    return paramView.getParentForAccessibility();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/view/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */