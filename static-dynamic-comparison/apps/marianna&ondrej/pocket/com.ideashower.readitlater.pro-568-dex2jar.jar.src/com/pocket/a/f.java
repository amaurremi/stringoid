package com.pocket.a;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.util.z;
import com.pocket.widget.ViewPagerIndicator;

class f
{
  private final ViewPagerIndicator b;
  private final ViewPagerIndicator c;
  private boolean d = false;
  private boolean e = false;
  
  private f(a parama)
  {
    this.b = ((ViewPagerIndicator)parama.c(2131230811));
    a(this.b);
    this.c = ((ViewPagerIndicator)parama.c(2131230831));
    a(this.c);
    c();
  }
  
  private void a(ViewPagerIndicator paramViewPagerIndicator)
  {
    paramViewPagerIndicator.a();
    paramViewPagerIndicator.a(a.g(this.a).a(), a.a(this.a).getCurrentItem(), a.a(this.a).getCurrentItem());
  }
  
  private void c()
  {
    if ((this.a.n().getConfiguration().orientation == 2) && (j.f())) {}
    for (boolean bool = true;; bool = false)
    {
      this.e = bool;
      d();
      return;
    }
  }
  
  private void d()
  {
    boolean bool2 = true;
    ViewPagerIndicator localViewPagerIndicator = this.b;
    if ((this.d) && (!this.e))
    {
      bool1 = true;
      z.c(localViewPagerIndicator, bool1);
      localViewPagerIndicator = this.c;
      if ((!this.d) || (!this.e)) {
        break label60;
      }
    }
    label60:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      z.c(localViewPagerIndicator, bool1);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a()
  {
    this.d = true;
    d();
  }
  
  public void a(int paramInt, float paramFloat)
  {
    if (paramInt == 0) {}
    for (paramFloat = a.aa().getInterpolation(paramFloat);; paramFloat = 1.0F)
    {
      com.b.c.a.a(this.b, paramFloat);
      com.b.c.a.a(this.c, paramFloat);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.b.a(paramInt1, paramInt2, paramInt3);
    this.c.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void b()
  {
    this.d = false;
    d();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */