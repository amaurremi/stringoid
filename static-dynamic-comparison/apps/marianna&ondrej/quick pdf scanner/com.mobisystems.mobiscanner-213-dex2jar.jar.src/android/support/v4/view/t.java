package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;

class t
{
  public static boolean a(View paramView, int paramInt)
  {
    return paramView.canScrollHorizontally(paramInt);
  }
  
  public static void b(View paramView, Object paramObject)
  {
    paramView.setAccessibilityDelegate((View.AccessibilityDelegate)paramObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/view/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */