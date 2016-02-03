package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;

class bi
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v4/view/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */