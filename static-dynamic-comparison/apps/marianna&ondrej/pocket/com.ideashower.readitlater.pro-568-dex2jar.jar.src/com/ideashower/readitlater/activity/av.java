package com.ideashower.readitlater.activity;

import com.ideashower.readitlater.db.operation.action.af;
import com.ideashower.readitlater.e.o;
import com.ideashower.readitlater.e.v;
import com.ideashower.readitlater.reader.ReaderWebView;
import com.ideashower.readitlater.reader.f;
import java.util.concurrent.atomic.AtomicInteger;

class av
{
  private boolean b = false;
  private float c;
  private float d;
  private float e;
  private int f;
  private float g;
  private float h;
  
  private av(ReaderFragment paramReaderFragment) {}
  
  private void a(int paramInt)
  {
    if (paramInt > 0)
    {
      paramInt = (int)Math.round(g() * (paramInt / 100.0D));
      this.a.Y.scrollTo(1, paramInt);
      this.a.Y.scrollTo(1, paramInt);
    }
  }
  
  private void a(o paramo, v paramv)
  {
    v localv = paramo.d(paramv.a());
    if ((localv != null) && (localv.d() == paramv.d()) && (paramo.B() == paramv.e())) {
      return;
    }
    new af(paramv, paramo).j();
  }
  
  private int b(int paramInt)
  {
    return (int)Math.round(paramInt / g() * 100.0D);
  }
  
  private boolean d()
  {
    if ((!this.b) && (ReaderFragment.c(this.a).l()) && (this.a.Y.getContentHeight() > 0) && (!ReaderFragment.s(this.a)))
    {
      this.a.ac = this.a.Y.getScale();
      e();
      if (com.ideashower.readitlater.util.a.j())
      {
        this.a.Y.setOnPictureUpdatedCallback(new Runnable()
        {
          public void run()
          {
            av.this.a.Y.setContentVisible(true);
          }
        });
        return true;
      }
      this.a.Y.setContentVisible(true);
      return true;
    }
    return false;
  }
  
  private void e()
  {
    this.b = true;
    v localv;
    if ((ReaderFragment.c(this.a).b() != null) && (ReaderFragment.c(this.a).b().D()))
    {
      localv = ReaderFragment.c(this.a).b().d(ReaderFragment.t(this.a).get());
      if (localv != null)
      {
        if (ReaderFragment.t(this.a).get() != 1) {
          break label131;
        }
        this.a.Y.scrollTo(0, 0);
        new com.pocket.webkit.a("article", "scrollToNodeIndex").a(localv.b()).a(localv.c()).a(localv.d()).a(this.a.Y);
      }
    }
    label131:
    while (localv.e() <= 1) {
      return;
    }
    a(localv.e());
  }
  
  private double f()
  {
    if (this.a.Y.getScale() < 1.0F) {
      return 100.0D / (this.a.Y.getScale() * 100.0F);
    }
    return 1.0D;
  }
  
  private int g()
  {
    int j = (int)Math.round(this.a.Y.getContentHeight() / f() - this.a.Y.getHeight());
    int i = j;
    if (j < 0) {
      i = 0;
    }
    return i;
  }
  
  private void h()
  {
    if ((ReaderFragment.c(this.a).b() != null) && (ReaderFragment.c(this.a).l())) {
      a();
    }
  }
  
  private int i()
  {
    int i;
    if (this.a.Y.getScrollY() * f() > 150.0D)
    {
      i = b(this.a.Y.getScrollY());
      if (i >= 5) {}
    }
    else
    {
      return 0;
    }
    return i;
  }
  
  private int j()
  {
    int j = (int)Math.round(this.a.Y.getScrollY() * f());
    int i = j;
    if (j < 150) {
      i = 0;
    }
    return i;
  }
  
  public void a()
  {
    float f1;
    int i;
    if (ReaderFragment.t(this.a).get() == 1) {
      if (this.e < 0.0F)
      {
        f1 = 0.0F;
        this.e = f1;
        float f2 = (this.e + this.d) / this.c;
        f1 = f2;
        if (f2 > 1.0F) {
          f1 = 1.0F;
        }
        int j = (int)(f1 * 100.0F);
        i = j;
        if (this.e < 150.0F)
        {
          i = j;
          if (j <= 5)
          {
            this.f = 0;
            this.g = 0.0F;
            i = 0;
          }
        }
      }
    }
    for (;;)
    {
      a(ReaderFragment.c(this.a).b(), new v(ReaderFragment.t(this.a).get(), (int)this.g, (int)this.h, this.f, i, System.currentTimeMillis() / 1000L));
      return;
      f1 = this.e;
      break;
      i = i();
      this.f = j();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramFloat1;
    this.d = paramFloat2;
    this.e = paramFloat3;
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
  }
  
  protected void b()
  {
    this.b = false;
    this.c = 0.0F;
    this.d = 0.0F;
    this.e = 0.0F;
    this.f = 0;
    this.g = 0.0F;
    this.h = 0.0F;
  }
  
  public int c()
  {
    return this.f;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */