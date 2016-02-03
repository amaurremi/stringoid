package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;

class at
{
  public static void a(View paramView, Object paramObject)
  {
    paramView.setAccessibilityDelegate((View.AccessibilityDelegate)paramObject);
  }
  
  public static boolean a(View paramView, int paramInt)
  {
    return paramView.canScrollHorizontally(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/view/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */