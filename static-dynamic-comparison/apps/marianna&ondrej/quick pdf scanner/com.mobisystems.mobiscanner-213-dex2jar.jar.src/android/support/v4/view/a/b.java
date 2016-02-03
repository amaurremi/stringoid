package android.support.v4.view.a;

import android.graphics.Rect;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

class b
{
  public static void a(Object paramObject, int paramInt)
  {
    ((AccessibilityNodeInfo)paramObject).addAction(paramInt);
  }
  
  public static void a(Object paramObject, Rect paramRect)
  {
    ((AccessibilityNodeInfo)paramObject).getBoundsInParent(paramRect);
  }
  
  public static void a(Object paramObject, CharSequence paramCharSequence)
  {
    ((AccessibilityNodeInfo)paramObject).setClassName(paramCharSequence);
  }
  
  public static void a(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setClickable(paramBoolean);
  }
  
  public static void b(Object paramObject, Rect paramRect)
  {
    ((AccessibilityNodeInfo)paramObject).getBoundsInScreen(paramRect);
  }
  
  public static void b(Object paramObject, CharSequence paramCharSequence)
  {
    ((AccessibilityNodeInfo)paramObject).setContentDescription(paramCharSequence);
  }
  
  public static void b(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setEnabled(paramBoolean);
  }
  
  public static void c(Object paramObject, Rect paramRect)
  {
    ((AccessibilityNodeInfo)paramObject).setBoundsInParent(paramRect);
  }
  
  public static void c(Object paramObject, View paramView)
  {
    ((AccessibilityNodeInfo)paramObject).addChild(paramView);
  }
  
  public static void c(Object paramObject, CharSequence paramCharSequence)
  {
    ((AccessibilityNodeInfo)paramObject).setPackageName(paramCharSequence);
  }
  
  public static void c(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setFocusable(paramBoolean);
  }
  
  public static Object d(Object paramObject)
  {
    return AccessibilityNodeInfo.obtain((AccessibilityNodeInfo)paramObject);
  }
  
  public static void d(Object paramObject, Rect paramRect)
  {
    ((AccessibilityNodeInfo)paramObject).setBoundsInScreen(paramRect);
  }
  
  public static void d(Object paramObject, View paramView)
  {
    ((AccessibilityNodeInfo)paramObject).setParent(paramView);
  }
  
  public static void d(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setFocused(paramBoolean);
  }
  
  public static int e(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getActions();
  }
  
  public static void e(Object paramObject, View paramView)
  {
    ((AccessibilityNodeInfo)paramObject).setSource(paramView);
  }
  
  public static void e(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setLongClickable(paramBoolean);
  }
  
  public static CharSequence f(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getClassName();
  }
  
  public static void f(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setScrollable(paramBoolean);
  }
  
  public static CharSequence g(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getContentDescription();
  }
  
  public static void g(Object paramObject, boolean paramBoolean)
  {
    ((AccessibilityNodeInfo)paramObject).setSelected(paramBoolean);
  }
  
  public static CharSequence h(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getPackageName();
  }
  
  public static CharSequence i(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).getText();
  }
  
  public static boolean j(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isCheckable();
  }
  
  public static boolean k(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isChecked();
  }
  
  public static boolean l(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isClickable();
  }
  
  public static boolean m(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isEnabled();
  }
  
  public static boolean n(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isFocusable();
  }
  
  public static boolean o(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isFocused();
  }
  
  public static boolean p(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isLongClickable();
  }
  
  public static boolean q(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isPassword();
  }
  
  public static boolean r(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isScrollable();
  }
  
  public static boolean s(Object paramObject)
  {
    return ((AccessibilityNodeInfo)paramObject).isSelected();
  }
  
  public static void t(Object paramObject)
  {
    ((AccessibilityNodeInfo)paramObject).recycle();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/view/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */