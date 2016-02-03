package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;
import com.a.a.a;
import com.a.a.an;
import com.a.a.au;
import com.a.a.b;
import com.gtp.a.a.b.c;

public class VerticalStretchLayout
  extends FrameLayout
  implements ViewTreeObserver.OnPreDrawListener, au, b
{
  private int a = -1;
  private int b = -2;
  private an c;
  private boolean d = true;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  
  public VerticalStretchLayout(Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  public VerticalStretchLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e();
  }
  
  public VerticalStretchLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
  }
  
  private void e()
  {
    if (getVisibility() != 8) {}
    for (boolean bool = true;; bool = false)
    {
      this.d = bool;
      getViewTreeObserver().addOnPreDrawListener(this);
      return;
    }
  }
  
  public void a()
  {
    this.d = false;
    if ((this.c != null) && (this.c.e())) {
      this.c.b();
    }
    setVisibility(8);
  }
  
  public void a(a parama)
  {
    this.e = true;
    this.g = false;
    setVisibility(0);
  }
  
  public void a(an paraman)
  {
    int i = ((Integer)paraman.l()).intValue();
    paraman = getLayoutParams();
    paraman.height = i;
    setLayoutParams(paraman);
    scrollTo(0, this.a - i);
  }
  
  public void b()
  {
    this.d = true;
    if ((this.c != null) && (this.c.e())) {
      this.c.b();
    }
    setVisibility(0);
  }
  
  public void b(a parama) {}
  
  public void c()
  {
    this.d = false;
    this.f = true;
    setVisibility(0);
    requestLayout();
  }
  
  public void c(a parama)
  {
    this.e = false;
    if (!this.g)
    {
      parama = getLayoutParams();
      parama.height = this.b;
      setLayoutParams(parama);
      scrollTo(0, 0);
      if (!this.d) {
        setVisibility(8);
      }
    }
    else
    {
      return;
    }
    setVisibility(0);
  }
  
  public void d()
  {
    this.d = true;
    this.f = true;
    setVisibility(0);
    requestLayout();
  }
  
  public void d(a parama)
  {
    this.g = true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onPreDraw()
  {
    boolean bool;
    if (!this.f)
    {
      bool = true;
      if (this.f)
      {
        this.f = false;
        if (!this.e)
        {
          this.b = getLayoutParams().height;
          this.a = getHeight();
          c.a("VerticalStretchLayout", "onPreDraw->mLayoutHeight: " + this.a);
        }
        if ((this.c == null) || (!this.c.e())) {
          break label258;
        }
        this.c.b();
      }
    }
    label116:
    label258:
    for (int i = 1;; i = 0)
    {
      long l;
      if (this.d) {
        if (i != 0)
        {
          i = getHeight();
          l = ((this.a - i) / 0.5F);
        }
      }
      for (this.c = an.b(new int[] { i, this.a });; this.c = an.b(new int[] { i, 1 }))
      {
        c.a("VerticalStretchLayout", "onPreDraw->duration: " + l);
        l = Math.min(l, 400L);
        this.c.c(l);
        this.c.a(this);
        this.c.a(this);
        this.c.a();
        return bool;
        bool = false;
        break;
        i = 1;
        break label116;
        i = getHeight();
        l = (i / 0.5F);
      }
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/VerticalStretchLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */