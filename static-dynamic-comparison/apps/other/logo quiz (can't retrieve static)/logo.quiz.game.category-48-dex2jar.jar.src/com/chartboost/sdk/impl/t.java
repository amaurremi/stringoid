package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.chartboost.sdk.CBPreferences;
import com.chartboost.sdk.Libraries.CBOrientation;
import com.chartboost.sdk.Libraries.CBOrientation.Difference;
import com.chartboost.sdk.Model.a;

public final class t
  extends RelativeLayout
{
  private a a;
  private p b;
  private p c;
  private s d;
  private OrientationEventListener e;
  private CBOrientation.Difference f = null;
  private a g = null;
  
  public t(Context paramContext, final a parama)
  {
    super(paramContext);
    this.g = parama;
    this.b = new p(paramContext);
    addView(this.b, new RelativeLayout.LayoutParams(-1, -1));
    this.c = new p(paramContext);
    addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
    this.c.setVisibility(8);
    parama = CBPreferences.getInstance();
    if ((parama.getOrientation() != null) && (parama.getOrientation() != CBOrientation.UNSPECIFIED))
    {
      this.f = parama.getForcedOrientationDifference();
      this.e = new OrientationEventListener(paramContext, 1)
      {
        public void onOrientationChanged(int paramAnonymousInt)
        {
          CBOrientation.Difference localDifference = parama.getForcedOrientationDifference();
          if (t.a(t.this) == localDifference) {
            return;
          }
          t.a(t.this, localDifference);
          if (t.b(t.this) != null) {
            t.b(t.this).a();
          }
          if ((t.c(t.this) != null) && (t.c(t.this).getVisibility() == 0)) {
            t.c(t.this).a();
          }
          t.this.invalidate();
        }
      };
      this.e.enable();
    }
    setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
  }
  
  public void a()
  {
    if (this.a == null)
    {
      this.a = this.g.e();
      addView(this.a.b(), new RelativeLayout.LayoutParams(-1, -1));
    }
    c();
  }
  
  public void b()
  {
    int i;
    if (!this.g.j)
    {
      i = 1;
      this.g.j = true;
      if (this.d != null) {
        break label107;
      }
      this.d = new s(getContext());
      this.d.setVisibility(8);
      addView(this.d, new RelativeLayout.LayoutParams(-1, -1));
    }
    for (;;)
    {
      if (!g())
      {
        this.d.setVisibility(0);
        if (i != 0)
        {
          e().a();
          o.a(this.d);
        }
      }
      return;
      i = 0;
      break;
      label107:
      this.c.bringToFront();
      this.c.setVisibility(0);
      this.c.a();
      o.b(this.b);
      this.d.bringToFront();
      this.d.a();
    }
  }
  
  public void c()
  {
    if (this.d != null)
    {
      this.d.clearAnimation();
      this.d.setVisibility(8);
    }
  }
  
  public void d()
  {
    if (this.e != null)
    {
      this.e.disable();
      this.e = null;
    }
  }
  
  public p e()
  {
    return this.b;
  }
  
  public View f()
  {
    if (this.a == null) {
      return null;
    }
    return this.a.b();
  }
  
  public boolean g()
  {
    return (this.d != null) && (this.d.getVisibility() == 0);
  }
  
  public a h()
  {
    return this.g;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract View b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */