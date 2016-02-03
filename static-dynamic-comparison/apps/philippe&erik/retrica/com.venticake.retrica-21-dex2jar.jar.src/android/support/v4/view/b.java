package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class b
  extends e
{
  public Object a()
  {
    return f.a();
  }
  
  public Object a(final a parama)
  {
    f.a(new g()
    {
      public void a(View paramAnonymousView, int paramAnonymousInt)
      {
        parama.a(paramAnonymousView, paramAnonymousInt);
      }
      
      public void a(View paramAnonymousView, Object paramAnonymousObject)
      {
        parama.a(paramAnonymousView, new android.support.v4.view.a.a(paramAnonymousObject));
      }
      
      public boolean a(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        return parama.b(paramAnonymousView, paramAnonymousAccessibilityEvent);
      }
      
      public boolean a(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        return parama.a(paramAnonymousViewGroup, paramAnonymousView, paramAnonymousAccessibilityEvent);
      }
      
      public void b(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        parama.d(paramAnonymousView, paramAnonymousAccessibilityEvent);
      }
      
      public void c(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        parama.c(paramAnonymousView, paramAnonymousAccessibilityEvent);
      }
      
      public void d(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        parama.a(paramAnonymousView, paramAnonymousAccessibilityEvent);
      }
    });
  }
  
  public void a(Object paramObject, View paramView, int paramInt)
  {
    f.a(paramObject, paramView, paramInt);
  }
  
  public void a(Object paramObject, View paramView, android.support.v4.view.a.a parama)
  {
    f.a(paramObject, paramView, parama.a());
  }
  
  public boolean a(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return f.a(paramObject, paramView, paramAccessibilityEvent);
  }
  
  public boolean a(Object paramObject, ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return f.a(paramObject, paramViewGroup, paramView, paramAccessibilityEvent);
  }
  
  public void b(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    f.b(paramObject, paramView, paramAccessibilityEvent);
  }
  
  public void c(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    f.c(paramObject, paramView, paramAccessibilityEvent);
  }
  
  public void d(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    f.d(paramObject, paramView, paramAccessibilityEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v4/view/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */