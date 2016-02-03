package com.pocket.widget.navigation;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.ideashower.readitlater.a.g;

public class b
{
  protected boolean a;
  private final android.support.v4.app.f b;
  private final View c;
  private final ViewGroup d;
  private final e e;
  private View f;
  private c g;
  private final ImageView h;
  private final Drawable i;
  private final ImageView j;
  private final Drawable k;
  private final int l;
  private d m;
  private final Runnable n;
  private boolean o = false;
  private m p;
  
  public b(android.support.v4.app.f paramf, View paramView, f paramf1, e parame)
  {
    this.l = ((int)paramf.getResources().getDimension(2131296292));
    this.b = paramf;
    this.c = paramView.findViewById(2131231025);
    this.d = ((ViewGroup)paramView.findViewById(2131231024));
    int i1 = paramf.getResources().getDimensionPixelSize(2131296290);
    this.i = v.b(i1);
    this.h = ((ImageView)paramView.findViewById(2131231026));
    this.h.setImageDrawable(this.i);
    this.k = v.b(i1);
    this.j = ((ImageView)paramView.findViewById(2131231027));
    this.j.setImageDrawable(this.k);
    this.n = new Runnable()
    {
      public void run()
      {
        b.a(b.this, null);
        b.this.a = false;
        b.a(b.this, null);
        b.b(b.this).removeView(b.a(b.this));
        b.a(b.this, null);
        b.a(b.this, 8);
        com.b.c.a.d(b.c(b.this), 0.0F);
        com.b.c.a.d(b.d(b.this), 0.0F);
        if (com.ideashower.readitlater.util.a.h())
        {
          b.c(b.this).clearAnimation();
          b.d(b.this).clearAnimation();
        }
        if (b.e(b.this) != null)
        {
          b.e(b.this).a();
          b.e(b.this).b();
        }
      }
    };
    paramf1.a(new android.support.v4.widget.c()
    {
      private void a(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        int i = (int)(b.b(b.this).getWidth() * paramAnonymousFloat1 * (1.0F - paramAnonymousFloat2));
        com.b.c.a.d(b.c(b.this), i);
        com.b.c.a.d(b.d(b.this), i);
      }
      
      public void a(int paramAnonymousInt)
      {
        if ((paramAnonymousInt == 1) && (b.this.a)) {
          g.o().removeCallbacks(b.f(b.this));
        }
        while ((paramAnonymousInt != 0) || (b.g(b.this)) || (!b.this.a)) {
          return;
        }
        g.o().removeCallbacks(b.f(b.this));
        g.o().postDelayed(b.f(b.this), 1000L);
      }
      
      public void a(View paramAnonymousView)
      {
        b.a(b.this, true);
      }
      
      public void a(View paramAnonymousView, float paramAnonymousFloat)
      {
        if (b.a(b.this) != null)
        {
          if (b.h(b.this) == c.a) {
            a(0.42F, paramAnonymousFloat);
          }
        }
        else {
          return;
        }
        a(0.9F, paramAnonymousFloat);
      }
      
      public void b(View paramAnonymousView)
      {
        b.a(b.this, false);
        if ((b.h(b.this) != c.a) && (b.a(b.this) != null))
        {
          g.o().removeCallbacks(b.f(b.this));
          if (b.h(b.this) == c.c) {
            b.f(b.this).run();
          }
        }
        else
        {
          return;
        }
        b.a(b.this, c.b);
        b.this.a = true;
        g.o().postDelayed(b.f(b.this), 1000L);
      }
    });
    this.e = parame;
  }
  
  private void a(int paramInt)
  {
    this.d.setVisibility(paramInt);
    this.h.setVisibility(paramInt);
  }
  
  public m a()
  {
    return this.p;
  }
  
  public void a(View paramView, m paramm, d paramd)
  {
    this.p = paramm;
    int i1;
    if (this.f != null)
    {
      i1 = 1;
      if (i1 != 0)
      {
        if (this.m != null) {
          this.m.b();
        }
        this.d.removeView(this.f);
      }
      this.m = paramd;
      this.f = paramView;
      this.d.addView(paramView, new RelativeLayout.LayoutParams(-1, -1));
      if (i1 == 0) {
        break label137;
      }
      com.b.c.a.a(paramView, 0.0F);
      com.b.c.a.f(paramView, 0.0F);
      com.b.c.c.a(paramView).k(1.0F).a(new DecelerateInterpolator()).a(333L).a(new com.pocket.b.b()
      {
        public void a(com.b.a.a paramAnonymousa) {}
      });
    }
    for (;;)
    {
      a(0);
      return;
      i1 = 0;
      break;
      label137:
      com.b.c.a.a(paramView, 1.0F);
      com.b.c.a.f(paramView, -this.l);
      com.b.c.c.a(paramView).a(0.0F).a(new DecelerateInterpolator()).a(333L).a(new com.pocket.b.b()
      {
        public void a(com.b.a.a paramAnonymousa) {}
      });
      com.b.c.a.d(this.j, -this.l);
      com.b.c.c.a(this.j).e(0.0F).a(new DecelerateInterpolator()).a(333L);
      com.b.c.a.a(this.j, 0.0F);
      com.b.c.c.a(this.j).k(1.0F).a(new AccelerateInterpolator()).a(333L).a(new com.pocket.b.b()
      {
        public void a(com.b.a.a paramAnonymousa) {}
      });
    }
  }
  
  public void b()
  {
    this.g = c.a;
    this.e.d();
  }
  
  public void c()
  {
    this.g = c.c;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/widget/navigation/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */