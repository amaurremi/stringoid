package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

class h
{
  public static Object a(i parami)
  {
    new View.AccessibilityDelegate()
    {
      public boolean dispatchPopulateAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        return h.this.a(paramAnonymousView, paramAnonymousAccessibilityEvent);
      }
      
      public AccessibilityNodeProvider getAccessibilityNodeProvider(View paramAnonymousView)
      {
        return (AccessibilityNodeProvider)h.this.a(paramAnonymousView);
      }
      
      public void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        h.this.b(paramAnonymousView, paramAnonymousAccessibilityEvent);
      }
      
      public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
      {
        h.this.a(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
      }
      
      public void onPopulateAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        h.this.c(paramAnonymousView, paramAnonymousAccessibilityEvent);
      }
      
      public boolean onRequestSendAccessibilityEvent(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        return h.this.a(paramAnonymousViewGroup, paramAnonymousView, paramAnonymousAccessibilityEvent);
      }
      
      public boolean performAccessibilityAction(View paramAnonymousView, int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        return h.this.a(paramAnonymousView, paramAnonymousInt, paramAnonymousBundle);
      }
      
      public void sendAccessibilityEvent(View paramAnonymousView, int paramAnonymousInt)
      {
        h.this.a(paramAnonymousView, paramAnonymousInt);
      }
      
      public void sendAccessibilityEventUnchecked(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        h.this.d(paramAnonymousView, paramAnonymousAccessibilityEvent);
      }
    };
  }
  
  public static Object a(Object paramObject, View paramView)
  {
    return ((View.AccessibilityDelegate)paramObject).getAccessibilityNodeProvider(paramView);
  }
  
  public static boolean a(Object paramObject, View paramView, int paramInt, Bundle paramBundle)
  {
    return ((View.AccessibilityDelegate)paramObject).performAccessibilityAction(paramView, paramInt, paramBundle);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v4/view/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */