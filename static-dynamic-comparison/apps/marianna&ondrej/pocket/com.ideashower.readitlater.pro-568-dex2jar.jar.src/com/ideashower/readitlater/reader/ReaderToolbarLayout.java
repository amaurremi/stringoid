package com.ideashower.readitlater.reader;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.b.c.c;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.util.e;
import com.ideashower.readitlater.util.z;
import com.ideashower.readitlater.views.ResizeDetectRelativeLayout;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.pocket.b.b;

public class ReaderToolbarLayout
  extends ResizeDetectRelativeLayout
{
  private static final String a = (String)null;
  private static final Interpolator b = new DecelerateInterpolator();
  private static final boolean c = com.ideashower.readitlater.util.a.h();
  private static final boolean d = com.ideashower.readitlater.util.a.i();
  private boolean A;
  private boolean B;
  private int C;
  private boolean D;
  private s E;
  private boolean F;
  private boolean G;
  private int H;
  private final Runnable e = new Runnable()
  {
    public void run()
    {
      ReaderToolbarLayout.a(ReaderToolbarLayout.this);
    }
  };
  private final Runnable f = new Runnable()
  {
    public void run()
    {
      ReaderToolbarLayout.a(ReaderToolbarLayout.this, true, true, true);
    }
  };
  private final Runnable g = new Runnable()
  {
    public void run()
    {
      ReaderToolbarLayout.a(ReaderToolbarLayout.this, false);
    }
  };
  private final Rect h = new Rect();
  private final Rect i = new Rect();
  private final Rect j = new Rect();
  private View k;
  private View l;
  private g m;
  private ReaderWebView n;
  private View o;
  private boolean p;
  private boolean q;
  private Runnable r;
  private p s;
  private boolean t;
  private boolean u;
  private r v;
  private q w;
  private int x;
  private boolean y;
  private boolean z;
  
  public ReaderToolbarLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ReaderToolbarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReaderToolbarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(boolean paramBoolean, long paramLong)
  {
    c localc1 = b(paramBoolean, paramLong);
    c localc2 = c(paramBoolean, paramLong);
    d(paramBoolean, paramLong);
    this.s = new p(this, paramBoolean, new c[] { localc1, localc2 }, null);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((this.p == paramBoolean1) && (!paramBoolean3)) {}
    do
    {
      do
      {
        return;
      } while ((this.w != null) && (!this.w.ax()) && (paramBoolean1));
      if (this.s == null) {
        break;
      }
    } while ((p.a(this.s) == paramBoolean1) && (!paramBoolean3));
    this.r = null;
    this.s.a();
    this.s = null;
    this.p = paramBoolean1;
    if (paramBoolean1) {
      this.D = true;
    }
    if (this.v != null) {
      this.v.a(paramBoolean1);
    }
    if (!paramBoolean1) {}
    for (paramBoolean3 = true;; paramBoolean3 = false)
    {
      setSystemUiVisible(paramBoolean3);
      if ((!paramBoolean1) || (!c) || ((!this.n.h()) && (!this.n.o()))) {
        break;
      }
      this.t = true;
      return;
    }
    b(paramBoolean1);
    long l1 = 350L;
    if ((!paramBoolean1) && (this.l.getHeight() == 0)) {
      l1 = 1L;
    }
    for (;;)
    {
      a(paramBoolean1, l1);
      return;
      if (!paramBoolean2) {
        l1 = 1L;
      }
    }
  }
  
  private c b(final boolean paramBoolean, long paramLong)
  {
    if (paramBoolean) {}
    for (float f1 = -this.C;; f1 = this.i.top + this.H)
    {
      if (paramLong <= 1L) {
        com.b.c.a.g(this.l, f1);
      }
      c.a(this.l).c(f1).a(paramLong).a(b).a(new b()
      {
        public void a(com.b.a.a paramAnonymousa)
        {
          if (a()) {
            return;
          }
          ReaderToolbarLayout.b(ReaderToolbarLayout.this, paramBoolean);
        }
        
        public void d(com.b.a.a paramAnonymousa)
        {
          super.d(paramAnonymousa);
        }
      });
    }
  }
  
  private void b(boolean paramBoolean)
  {
    z.c(this.l, true);
    if (!paramBoolean)
    {
      h();
      return;
    }
    if (c)
    {
      this.n.post(this.e);
      return;
    }
    g();
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.h.setEmpty();
    Rect localRect = this.h;
    localRect.left += this.i.left;
    localRect = this.h;
    localRect.right += this.i.right;
    this.z = paramBoolean1;
    this.A = paramBoolean2;
    this.B = paramBoolean3;
    if (this.F)
    {
      if (paramBoolean1)
      {
        localRect = this.h;
        localRect.top += this.i.top;
        localRect = this.h;
        localRect.bottom += this.i.bottom;
      }
      if (paramBoolean2)
      {
        localRect = this.h;
        localRect.top += this.C;
      }
      if (paramBoolean3)
      {
        localRect = this.h;
        localRect.bottom += getResources().getDimensionPixelSize(2131296395);
      }
    }
    z.a(this.k, this.h);
  }
  
  private c c(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean) {}
    for (float f1 = 0.0F;; f1 = this.i.top + this.H)
    {
      if (paramLong <= 1L) {
        com.b.c.a.g(this.o, f1);
      }
      return c.a(this.o).c(f1).a(paramLong).a(b);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      j();
      return;
    }
    if (c)
    {
      if ((!this.n.h()) && (!this.n.o())) {}
    }
    else {
      while (this.n.o())
      {
        this.r = new Runnable()
        {
          public void run()
          {
            ReaderToolbarLayout.d(ReaderToolbarLayout.this);
          }
        };
        return;
      }
    }
    i();
  }
  
  private void d(boolean paramBoolean, long paramLong)
  {
    if (this.m != null)
    {
      this.m.setVisibility(0);
      if (paramBoolean) {
        this.u = false;
      }
      g localg = this.m;
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localg.a(paramBoolean, paramLong, b, false);
        return;
      }
    }
    this.u = false;
  }
  
  private void e()
  {
    a(false, false, true);
  }
  
  private void f()
  {
    if ((this.p) && (d))
    {
      Handler localHandler = ((ViewGroup)getParent()).getHandler();
      if (localHandler != null) {
        localHandler.postDelayed(this.g, 2000L);
      }
    }
  }
  
  private void g()
  {
    b(false, false, false);
    if (this.F)
    {
      this.q = true;
      this.n.scrollTo(this.n.getScrollX(), this.n.getScrollY() - this.C - this.i.top);
      this.q = false;
    }
  }
  
  private void h()
  {
    if ((this.m != null) && (this.D)) {
      this.m.l();
    }
    b(false, false, false);
  }
  
  private void i()
  {
    this.s = null;
    this.l.setVisibility(0);
    b(true, true, this.u);
    if (this.F)
    {
      this.q = true;
      this.n.scrollTo(this.n.getScrollX(), this.n.getScrollY() + this.C + this.i.top);
      this.q = false;
    }
  }
  
  private void j()
  {
    this.s = null;
    this.l.setVisibility(8);
  }
  
  @TargetApi(14)
  private void setSystemUiVisible(boolean paramBoolean)
  {
    if (!d) {
      return;
    }
    int i1 = 1792;
    if (!paramBoolean)
    {
      i2 = 1797;
      i1 = i2;
      if (this.i.left == 0)
      {
        i1 = i2;
        if (this.i.right == 0)
        {
          i1 = i2;
          if (com.ideashower.readitlater.util.a.r()) {
            i1 = 3847;
          }
        }
      }
    }
    if (i1 == getSystemUiVisibility()) {}
    for (int i2 = 1;; i2 = 0)
    {
      if (((i2 != 0) || (paramBoolean)) && (getHandler() != null))
      {
        Handler localHandler = getHandler();
        if (localHandler != null) {
          localHandler.removeCallbacks(this.g);
        }
      }
      setSystemUiVisibility(i1);
      return;
    }
  }
  
  private void setSystemWindowInsets(Rect paramRect)
  {
    if (!d)
    {
      e.b("This isn't supported. Did you mean to invoke this?");
      return;
    }
    this.i.set(paramRect);
    b(this.z, this.A, this.B);
    if (this.m != null)
    {
      this.m.setBottomSystemWindowInset(paramRect.bottom);
      z.c(this.m, paramRect.left);
      z.d(this.m, paramRect.right);
    }
    z.c(this.l, paramRect.left);
    z.d(this.l, paramRect.right);
    if (!this.p) {}
    for (boolean bool = true;; bool = false)
    {
      setSystemUiVisible(bool);
      if ((this.E == null) || ((this.j.top == getLayoutInsetTop()) && (this.j.bottom != getLayoutInsetBottom()))) {
        break;
      }
      this.j.top = getLayoutInsetTop();
      this.j.bottom = getLayoutInsetBottom();
      this.E.a();
      return;
    }
  }
  
  public void a()
  {
    f();
  }
  
  public void a(g paramg)
  {
    this.m = paramg;
    this.C = getResources().getDimensionPixelSize(2131296395);
    addView(paramg);
    paramg.m();
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.p) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, paramBoolean);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramBoolean1, paramBoolean2, false);
  }
  
  public boolean b()
  {
    return this.p;
  }
  
  public void c()
  {
    if (this.r != null)
    {
      this.n.post(this.r);
      this.r = null;
    }
    while (!this.t) {
      return;
    }
    this.t = false;
    if (c)
    {
      this.n.post(this.f);
      return;
    }
    a(true, true, true);
  }
  
  public boolean d()
  {
    return this.q;
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    if (!d) {
      return super.fitSystemWindows(paramRect);
    }
    setSystemWindowInsets(paramRect);
    return true;
  }
  
  public View getContent()
  {
    return this.k;
  }
  
  public int getContentHeight()
  {
    return getHeight() - this.i.bottom - this.i.top;
  }
  
  public int getLayoutInsetBottom()
  {
    int i2 = this.i.bottom;
    if (this.m.b()) {}
    for (int i1 = getResources().getDimensionPixelSize(2131296395);; i1 = 0) {
      return i1 + i2;
    }
  }
  
  public int getLayoutInsetTop()
  {
    return this.i.top + getResources().getDimensionPixelSize(2131296395);
  }
  
  public Rect getSystemInsets()
  {
    return this.i;
  }
  
  @SuppressLint({"NewApi"})
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (d) {
      ((Activity)getContext()).getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
      {
        public void onSystemUiVisibilityChange(int paramAnonymousInt)
        {
          int i = ReaderToolbarLayout.b(ReaderToolbarLayout.this);
          ReaderToolbarLayout.a(ReaderToolbarLayout.this, paramAnonymousInt);
          if ((((i ^ paramAnonymousInt) & 0x1) != 0) && ((paramAnonymousInt & 0x1) == 0)) {
            ReaderToolbarLayout.c(ReaderToolbarLayout.this);
          }
        }
      });
    }
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 2);
    mergeDrawableStates(arrayOfInt, m.b(this));
    StyledToolbar.a(this, arrayOfInt);
    return arrayOfInt;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.k = findViewById(2131230730);
    this.l = findViewById(2131230870);
    this.n = ((ReaderWebView)findViewById(2131230866));
    this.o = findViewById(2131230872);
    setSystemUiVisible(true);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.y)
    {
      this.y = true;
      e();
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a(this.p, false, true);
  }
  
  public void setAutoLayoutEnabled(boolean paramBoolean)
  {
    if (this.F == paramBoolean) {
      return;
    }
    this.F = paramBoolean;
    a(this.p, false, true);
  }
  
  public void setContextualActionBarVisible(boolean paramBoolean)
  {
    if ((this.G == paramBoolean) || (com.ideashower.readitlater.util.a.d())) {}
    do
    {
      return;
      this.G = paramBoolean;
    } while (!com.ideashower.readitlater.util.a.q());
    int i1;
    if (paramBoolean)
    {
      i1 = -this.i.top;
      this.H = i1;
    }
    for (;;)
    {
      try
      {
        ViewGroup localViewGroup = (ViewGroup)getRootView();
        if (!paramBoolean) {
          continue;
        }
        i1 = this.i.top;
        z.a(localViewGroup, i1);
      }
      catch (Throwable localThrowable)
      {
        e.a(localThrowable, true);
        continue;
      }
      a(this.p, false, true);
      return;
      i1 = 0;
      break;
      i1 = 0;
    }
  }
  
  public void setEnabler(q paramq)
  {
    this.w = paramq;
  }
  
  public void setFullscreenListener(r paramr)
  {
    this.v = paramr;
  }
  
  public void setOnLayoutInsetsChangedListener(s params)
  {
    this.E = params;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/reader/ReaderToolbarLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */