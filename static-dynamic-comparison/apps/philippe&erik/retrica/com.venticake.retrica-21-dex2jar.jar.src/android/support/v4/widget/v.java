package android.support.v4.widget;

import android.graphics.Rect;
import android.support.v4.view.av;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class v
  extends android.support.v4.view.a
{
  private final Rect c = new Rect();
  
  v(SlidingPaneLayout paramSlidingPaneLayout) {}
  
  private void a(android.support.v4.view.a.a parama1, android.support.v4.view.a.a parama2)
  {
    Rect localRect = this.c;
    parama2.a(localRect);
    parama1.b(localRect);
    parama2.c(localRect);
    parama1.d(localRect);
    parama1.c(parama2.h());
    parama1.a(parama2.p());
    parama1.b(parama2.q());
    parama1.c(parama2.s());
    parama1.h(parama2.m());
    parama1.f(parama2.k());
    parama1.a(parama2.f());
    parama1.b(parama2.g());
    parama1.d(parama2.i());
    parama1.e(parama2.j());
    parama1.g(parama2.l());
    parama1.a(parama2.b());
    parama1.b(parama2.c());
  }
  
  public void a(View paramView, android.support.v4.view.a.a parama)
  {
    android.support.v4.view.a.a locala = android.support.v4.view.a.a.a(parama);
    super.a(paramView, locala);
    a(parama, locala);
    locala.t();
    parama.b(SlidingPaneLayout.class.getName());
    parama.a(paramView);
    paramView = av.f(paramView);
    if ((paramView instanceof View)) {
      parama.c((View)paramView);
    }
    int j = this.b.getChildCount();
    int i = 0;
    while (i < j)
    {
      paramView = this.b.getChildAt(i);
      if ((!b(paramView)) && (paramView.getVisibility() == 0))
      {
        av.b(paramView, 1);
        parama.b(paramView);
      }
      i += 1;
    }
  }
  
  public boolean a(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    if (!b(paramView)) {
      return super.a(paramViewGroup, paramView, paramAccessibilityEvent);
    }
    return false;
  }
  
  public boolean b(View paramView)
  {
    return this.b.e(paramView);
  }
  
  public void d(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.d(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v4/widget/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */