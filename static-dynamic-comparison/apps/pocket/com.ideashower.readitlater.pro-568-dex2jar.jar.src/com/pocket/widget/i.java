package com.pocket.widget;

import android.graphics.Rect;
import android.support.v4.view.ag;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class i
  extends android.support.v4.view.a
{
  private final Rect c = new Rect();
  
  i(DrawerLayoutNoMinMargin paramDrawerLayoutNoMinMargin) {}
  
  private void a(android.support.v4.view.a.a parama1, android.support.v4.view.a.a parama2)
  {
    Rect localRect = this.c;
    parama2.a(localRect);
    parama1.b(localRect);
    parama2.c(localRect);
    parama1.d(localRect);
    parama1.c(parama2.g());
    parama1.a(parama2.o());
    parama1.b(parama2.p());
    parama1.c(parama2.r());
    parama1.h(parama2.l());
    parama1.f(parama2.j());
    parama1.a(parama2.e());
    parama1.b(parama2.f());
    parama1.d(parama2.h());
    parama1.e(parama2.i());
    parama1.g(parama2.k());
    parama1.a(parama2.b());
  }
  
  public void a(View paramView, android.support.v4.view.a.a parama)
  {
    android.support.v4.view.a.a locala = android.support.v4.view.a.a.a(parama);
    super.a(paramView, locala);
    parama.a(paramView);
    paramView = ag.f(paramView);
    if ((paramView instanceof View)) {
      parama.c((View)paramView);
    }
    a(parama, locala);
    locala.s();
    int j = this.b.getChildCount();
    int i = 0;
    while (i < j)
    {
      paramView = this.b.getChildAt(i);
      if (!b(paramView)) {
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
    View localView = this.b.a();
    return (localView != null) && (localView != paramView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */