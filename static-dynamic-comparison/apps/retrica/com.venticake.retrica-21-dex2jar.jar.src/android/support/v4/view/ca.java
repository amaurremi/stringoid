package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.a.t;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

class ca
  extends a
{
  ca(ViewPager paramViewPager) {}
  
  private boolean b()
  {
    return (ViewPager.a(this.b) != null) && (ViewPager.a(this.b).getCount() > 1);
  }
  
  public void a(View paramView, android.support.v4.view.a.a parama)
  {
    super.a(paramView, parama);
    parama.b(ViewPager.class.getName());
    parama.i(b());
    if (this.b.canScrollHorizontally(1)) {
      parama.a(4096);
    }
    if (this.b.canScrollHorizontally(-1)) {
      parama.a(8192);
    }
  }
  
  public boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    if (super.a(paramView, paramInt, paramBundle)) {
      return true;
    }
    switch (paramInt)
    {
    default: 
      return false;
    case 4096: 
      if (this.b.canScrollHorizontally(1))
      {
        this.b.setCurrentItem(ViewPager.b(this.b) + 1);
        return true;
      }
      return false;
    }
    if (this.b.canScrollHorizontally(-1))
    {
      this.b.setCurrentItem(ViewPager.b(this.b) - 1);
      return true;
    }
    return false;
  }
  
  public void d(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.d(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(ViewPager.class.getName());
    paramView = t.a();
    paramView.a(b());
    if ((paramAccessibilityEvent.getEventType() == 4096) && (ViewPager.a(this.b) != null))
    {
      paramView.a(ViewPager.a(this.b).getCount());
      paramView.b(ViewPager.b(this.b));
      paramView.c(ViewPager.b(this.b));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v4/view/ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */