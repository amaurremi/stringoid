package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.a.e;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class a
{
  private static final b aj;
  private static final Object ak;
  final Object al = aj.a(this);
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16) {
      aj = new c();
    }
    for (;;)
    {
      ak = aj.v();
      return;
      if (Build.VERSION.SDK_INT >= 14) {
        aj = new a();
      } else {
        aj = new d();
      }
    }
  }
  
  public e a(View paramView)
  {
    return aj.a(ak, paramView);
  }
  
  public void a(View paramView, android.support.v4.view.a.a parama)
  {
    aj.a(ak, paramView, parama);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return aj.a(ak, paramView, paramAccessibilityEvent);
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    aj.b(ak, paramView, paramAccessibilityEvent);
  }
  
  public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    aj.c(ak, paramView, paramAccessibilityEvent);
  }
  
  public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return aj.a(ak, paramViewGroup, paramView, paramAccessibilityEvent);
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    return aj.a(ak, paramView, paramInt, paramBundle);
  }
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    aj.a(ak, paramView, paramInt);
  }
  
  public void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    aj.d(ak, paramView, paramAccessibilityEvent);
  }
  
  Object u()
  {
    return this.al;
  }
  
  static class a
    extends a.d
  {
    public Object a(final a parama)
    {
      b.a(new b.a()
      {
        public void a(View paramAnonymousView, Object paramAnonymousObject)
        {
          parama.a(paramAnonymousView, new android.support.v4.view.a.a(paramAnonymousObject));
        }
        
        public boolean dispatchPopulateAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          return parama.dispatchPopulateAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          parama.onInitializeAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public void onPopulateAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          parama.onPopulateAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public boolean onRequestSendAccessibilityEvent(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          return parama.onRequestSendAccessibilityEvent(paramAnonymousViewGroup, paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public void sendAccessibilityEvent(View paramAnonymousView, int paramAnonymousInt)
        {
          parama.sendAccessibilityEvent(paramAnonymousView, paramAnonymousInt);
        }
        
        public void sendAccessibilityEventUnchecked(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          parama.sendAccessibilityEventUnchecked(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
      });
    }
    
    public void a(Object paramObject, View paramView, int paramInt)
    {
      b.a(paramObject, paramView, paramInt);
    }
    
    public void a(Object paramObject, View paramView, android.support.v4.view.a.a parama)
    {
      b.a(paramObject, paramView, parama.P());
    }
    
    public boolean a(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      return b.a(paramObject, paramView, paramAccessibilityEvent);
    }
    
    public boolean a(Object paramObject, ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      return b.a(paramObject, paramViewGroup, paramView, paramAccessibilityEvent);
    }
    
    public void b(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      b.b(paramObject, paramView, paramAccessibilityEvent);
    }
    
    public void c(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      b.c(paramObject, paramView, paramAccessibilityEvent);
    }
    
    public void d(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      b.d(paramObject, paramView, paramAccessibilityEvent);
    }
    
    public Object v()
    {
      return b.w();
    }
  }
  
  static abstract interface b
  {
    public abstract e a(Object paramObject, View paramView);
    
    public abstract Object a(a parama);
    
    public abstract void a(Object paramObject, View paramView, int paramInt);
    
    public abstract void a(Object paramObject, View paramView, android.support.v4.view.a.a parama);
    
    public abstract boolean a(Object paramObject, View paramView, int paramInt, Bundle paramBundle);
    
    public abstract boolean a(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent);
    
    public abstract boolean a(Object paramObject, ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent);
    
    public abstract void b(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent);
    
    public abstract void c(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent);
    
    public abstract void d(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent);
    
    public abstract Object v();
  }
  
  static class c
    extends a.a
  {
    public e a(Object paramObject, View paramView)
    {
      paramObject = c.b(paramObject, paramView);
      if (paramObject != null) {
        return new e(paramObject);
      }
      return null;
    }
    
    public Object a(final a parama)
    {
      c.a(new c.a()
      {
        public void a(View paramAnonymousView, Object paramAnonymousObject)
        {
          parama.a(paramAnonymousView, new android.support.v4.view.a.a(paramAnonymousObject));
        }
        
        public Object b(View paramAnonymousView)
        {
          paramAnonymousView = parama.a(paramAnonymousView);
          if (paramAnonymousView != null) {
            return paramAnonymousView.Q();
          }
          return null;
        }
        
        public boolean dispatchPopulateAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          return parama.dispatchPopulateAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          parama.onInitializeAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public void onPopulateAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          parama.onPopulateAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public boolean onRequestSendAccessibilityEvent(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          return parama.onRequestSendAccessibilityEvent(paramAnonymousViewGroup, paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
        
        public boolean performAccessibilityAction(View paramAnonymousView, int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          return parama.performAccessibilityAction(paramAnonymousView, paramAnonymousInt, paramAnonymousBundle);
        }
        
        public void sendAccessibilityEvent(View paramAnonymousView, int paramAnonymousInt)
        {
          parama.sendAccessibilityEvent(paramAnonymousView, paramAnonymousInt);
        }
        
        public void sendAccessibilityEventUnchecked(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
        {
          parama.sendAccessibilityEventUnchecked(paramAnonymousView, paramAnonymousAccessibilityEvent);
        }
      });
    }
    
    public boolean a(Object paramObject, View paramView, int paramInt, Bundle paramBundle)
    {
      return c.a(paramObject, paramView, paramInt, paramBundle);
    }
  }
  
  static class d
    implements a.b
  {
    public e a(Object paramObject, View paramView)
    {
      return null;
    }
    
    public Object a(a parama)
    {
      return null;
    }
    
    public void a(Object paramObject, View paramView, int paramInt) {}
    
    public void a(Object paramObject, View paramView, android.support.v4.view.a.a parama) {}
    
    public boolean a(Object paramObject, View paramView, int paramInt, Bundle paramBundle)
    {
      return false;
    }
    
    public boolean a(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      return false;
    }
    
    public boolean a(Object paramObject, ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      return true;
    }
    
    public void b(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent) {}
    
    public void c(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent) {}
    
    public void d(Object paramObject, View paramView, AccessibilityEvent paramAccessibilityEvent) {}
    
    public Object v()
    {
      return null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/view/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */