package com.chartboost.sdk;

import android.app.Activity;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.Model.a;
import com.chartboost.sdk.Model.a.b;
import com.chartboost.sdk.Model.a.c;
import com.chartboost.sdk.impl.o;
import com.chartboost.sdk.impl.o.a;
import com.chartboost.sdk.impl.o.b;
import com.chartboost.sdk.impl.p;
import com.chartboost.sdk.impl.t;
import org.json.JSONObject;

final class b
{
  private static b e;
  protected boolean a = false;
  private Chartboost b;
  private CBPreferences c;
  private t d = null;
  
  private b(Chartboost paramChartboost)
  {
    this.b = paramChartboost;
    this.c = CBPreferences.getInstance();
  }
  
  protected static b a(Chartboost paramChartboost)
  {
    if (e == null) {
      e = new b(paramChartboost);
    }
    return e;
  }
  
  private void d()
  {
    Activity localActivity = this.b.c();
    if ((localActivity != null) && ((localActivity instanceof CBImpressionActivity)))
    {
      this.b.d();
      localActivity.finish();
    }
  }
  
  private void d(a parama)
  {
    if ((this.d != null) && (this.d.h() != parama)) {
      parama.a(CBError.CBImpressionError.IMPRESSION_ALREADY_VISIBLE);
    }
    Object localObject1;
    label93:
    label98:
    do
    {
      do
      {
        return;
        int i;
        Activity localActivity;
        if (parama.c != a.b.c)
        {
          i = 1;
          parama.c = a.b.c;
          localActivity = this.b.c();
          if (localActivity != null) {
            break label93;
          }
        }
        Object localObject2;
        for (localObject1 = CBError.CBImpressionError.NO_HOST_ACTIVITY;; localObject1 = null)
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = parama.d();
          }
          if (localObject2 == null) {
            break label98;
          }
          parama.a((CBError.CBImpressionError)localObject2);
          return;
          i = 0;
          break;
        }
        if (this.d == null)
        {
          this.d = new t(localActivity, parama);
          localActivity.addContentView(this.d, new FrameLayout.LayoutParams(-1, -1));
        }
        this.d.a();
        parama.h = this.d;
        if (i != 0)
        {
          this.d.e().a();
          localObject1 = o.b.a;
          if (parama.d == a.c.b) {
            localObject1 = o.b.c;
          }
          localObject2 = o.b.a(parama.a.optInt("animation"));
          if (localObject2 != null) {
            localObject1 = localObject2;
          }
          if (this.c.getAnimationsOff()) {
            localObject1 = o.b.f;
          }
          parama.g();
          o.a((o.b)localObject1, parama, new o.a()
          {
            public void a(a paramAnonymousa)
            {
              paramAnonymousa.h();
            }
          });
        }
        localObject1 = this.c.getDelegate();
      } while (localObject1 == null);
      if (parama.d == a.c.a)
      {
        ((ChartboostDelegate)localObject1).didShowInterstitial(parama.e);
        return;
      }
    } while (parama.d != a.c.b);
    ((ChartboostDelegate)localObject1).didShowMoreApps();
  }
  
  private void e(a parama)
  {
    Activity localActivity = this.b.c();
    if (localActivity == null)
    {
      CBLogging.c(this, "No host activity to display loading view");
      return;
    }
    if (this.d == null)
    {
      this.d = new t(localActivity, parama);
      localActivity.addContentView(this.d, new FrameLayout.LayoutParams(-1, -1));
    }
    this.d.b();
  }
  
  protected void a(a parama)
  {
    switch (3.a[parama.c.ordinal()])
    {
    default: 
      d(parama);
      return;
    }
    e(parama);
  }
  
  public void a(final a parama, final boolean paramBoolean)
  {
    Runnable local2 = new Runnable()
    {
      public void run()
      {
        if (!paramBoolean) {
          b.this.a = true;
        }
        parama.c = a.b.e;
        Object localObject = o.b.a;
        if (parama.d == a.c.b) {
          localObject = o.b.c;
        }
        o.b localb = o.b.a(parama.a.optInt("animation"));
        if (localb != null) {
          localObject = localb;
        }
        if (b.a(b.this).getAnimationsOff()) {
          localObject = o.b.f;
        }
        o.b((o.b)localObject, parama, new o.a()
        {
          public void a(final a paramAnonymous2a)
          {
            b.this.a = false;
            if (paramAnonymous2a.c != a.b.f) {
              b.b(b.this).c.post(new Runnable()
              {
                public void run()
                {
                  b.this.c(paramAnonymous2a);
                }
              });
            }
            paramAnonymous2a.f();
          }
        });
      }
    };
    if (parama.k)
    {
      parama.b(local2);
      return;
    }
    local2.run();
  }
  
  public void a(boolean paramBoolean)
  {
    if (a())
    {
      this.d.c();
      if ((paramBoolean) && (this.d != null) && (this.d.h() != null)) {
        c(this.d.h());
      }
    }
  }
  
  public boolean a()
  {
    return (this.d != null) && (this.d.g());
  }
  
  public void b(a parama)
  {
    if (a()) {
      a(false);
    }
    parama.c();
    try
    {
      ((ViewGroup)this.d.getParent()).removeView(this.d);
      this.d = null;
      return;
    }
    catch (Exception parama)
    {
      for (;;)
      {
        CBLogging.b("CBViewController", "Exception removing impression silently", parama);
      }
    }
  }
  
  protected boolean b()
  {
    return this.d != null;
  }
  
  public t c()
  {
    return this.d;
  }
  
  public void c(a parama)
  {
    parama.c = a.b.g;
    if (this.d == null) {
      if (this.c.getImpressionsUseActivities()) {
        d();
      }
    }
    for (;;)
    {
      return;
      try
      {
        ((ViewGroup)this.d.getParent()).removeView(this.d);
        parama.b();
        this.d = null;
        this.a = false;
        if (!this.c.getImpressionsUseActivities()) {
          continue;
        }
        d();
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          CBLogging.b("CBViewController", "Exception removing impression ", localException);
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */