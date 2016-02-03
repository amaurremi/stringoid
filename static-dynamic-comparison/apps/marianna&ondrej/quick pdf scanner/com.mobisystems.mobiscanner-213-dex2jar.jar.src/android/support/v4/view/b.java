package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

class b
{
  public static Object a(a parama)
  {
    new View.AccessibilityDelegate()
    {
      public boolean dispatchPopulateAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        return this.ap.dispatchPopulateAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
      }
      
      public void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        this.ap.onInitializeAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
      }
      
      public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
      {
        this.ap.a(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
      }
      
      public void onPopulateAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        this.ap.onPopulateAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
      }
      
      public boolean onRequestSendAccessibilityEvent(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        return this.ap.onRequestSendAccessibilityEvent(paramAnonymousViewGroup, paramAnonymousView, paramAnonymousAccessibilityEvent);
      }
      
      public void sendAccessibilityEvent(View paramAnonymousView, int paramAnonymousInt)
      {
        this.ap.sendAccessibilityEvent(paramAnonymousView, paramAnonymousInt);
      }
      
      public void sendAccessibilityEventUnchecked(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        this.ap.sendAccessibilityEventUnchecked(paramAnonymousView, paramAnonymousAccessibilityEvent);
      }
    };
  }
  
  public static void a(Object paramObject, View paramView, int paramInt)
  {
    ((View.AccessibilityDelegate)paramObject).sendAccessibilityEvent(paramView, paramInt);
  }
  
  public static void a(Object paramObject1, View paramView, Object paramObject2)
  {
    ((View.AccessibilityDelegate)paramObject1).onInitializeAccessibilityNodeInfo(paramView, (AccessibilityNodeInfo)paramObject2);
  }
  
  public static boolean a(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return ((View.AccessibilityDelegate)paramObject).dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public static boolean a(Object paramObject, ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return ((View.AccessibilityDelegate)paramObject).onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
  }
  
  public static void b(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    ((View.AccessibilityDelegate)paramObject).onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public static void c(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    ((View.AccessibilityDelegate)paramObject).onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public static void d(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    ((View.AccessibilityDelegate)paramObject).sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
  }
  
  public static Object w()
  {
    return new View.AccessibilityDelegate();
  }
  
  public static abstract interface a
  {
    public abstract void a(View paramView, Object paramObject);
    
    public abstract boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent);
    
    public abstract void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent);
    
    public abstract void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent);
    
    public abstract boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent);
    
    public abstract void sendAccessibilityEvent(View paramView, int paramInt);
    
    public abstract void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/view/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */