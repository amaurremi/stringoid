package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.a.k;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class d
  extends b
{
  public k a(Object paramObject, View paramView)
  {
    paramObject = h.a(paramObject, paramView);
    if (paramObject != null) {
      return new k(paramObject);
    }
    return null;
  }
  
  public Object a(final a parama)
  {
    h.a(new i()
    {
      public Object a(View paramAnonymousView)
      {
        paramAnonymousView = parama.a(paramAnonymousView);
        if (paramAnonymousView != null) {
          return paramAnonymousView.a();
        }
        return null;
      }
      
      public void a(View paramAnonymousView, int paramAnonymousInt)
      {
        parama.a(paramAnonymousView, paramAnonymousInt);
      }
      
      public void a(View paramAnonymousView, Object paramAnonymousObject)
      {
        parama.a(paramAnonymousView, new android.support.v4.view.a.a(paramAnonymousObject));
      }
      
      public boolean a(View paramAnonymousView, int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        return parama.a(paramAnonymousView, paramAnonymousInt, paramAnonymousBundle);
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
  
  public boolean a(Object paramObject, View paramView, int paramInt, Bundle paramBundle)
  {
    return h.a(paramObject, paramView, paramInt, paramBundle);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/view/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */