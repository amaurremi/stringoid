package com.ideashower.readitlater.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebView.PictureListener;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.ideashower.readitlater.a.ax;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.util.c;
import com.ideashower.readitlater.util.d;
import com.pocket.p.z;
import com.pocket.widget.ThemedView;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class BaseWebView
  extends com.c.a.a.a.a
  implements WebView.PictureListener, t
{
  private static Method C;
  private static Method D;
  private ab A;
  private Runnable B;
  private ProgressBar a;
  private boolean b = false;
  protected g c;
  protected f d;
  protected ba e;
  protected e f;
  protected boolean g = false;
  private ProgressBar i;
  private boolean j = false;
  private RelativeLayout k;
  private boolean l;
  private boolean m = false;
  private b n;
  private h o;
  private View p;
  private float q;
  private float r;
  private ay s;
  private w t;
  private AlphaAnimation u;
  private Runnable v;
  private ThemedView w;
  private boolean x;
  private final ArrayList y = new ArrayList();
  private final ArrayList z = new ArrayList();
  
  public BaseWebView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public BaseWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public BaseWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.replace("'", "\\'").replace("\n", " ");
  }
  
  public static String c(String paramString)
  {
    if (paramString == null) {
      return "''";
    }
    return "'" + b(paramString) + "'";
  }
  
  private void d()
  {
    if (getContentHeight() > 0)
    {
      if (!this.g)
      {
        this.g = true;
        if (this.f != null) {
          this.f.a();
        }
      }
      if (this.f != null) {
        this.f.b();
      }
    }
    for (;;)
    {
      setOnPictureUpdatedCallback(this.B);
      return;
      if (getContentHeight() <= 0) {
        this.g = false;
      }
    }
  }
  
  public int a(float paramFloat)
  {
    return (int)(j() * paramFloat);
  }
  
  public int a(int paramInt)
  {
    return Math.round(paramInt / j());
  }
  
  public void a(View paramView)
  {
    if (this.k == null)
    {
      this.k = new RelativeLayout(getContext());
      this.k.setLayoutParams(getLayoutParams());
      ViewGroup localViewGroup = (ViewGroup)getParent();
      localViewGroup.addView(this.k);
      localViewGroup.removeView(this);
      this.k.addView(this, new RelativeLayout.LayoutParams(-1, -1));
    }
    this.k.addView(paramView);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    a(paramView, new AbsoluteLayout.LayoutParams(paramInt1, paramInt2, paramInt3, paramInt4), paramInt5);
  }
  
  public void a(View paramView, AbsoluteLayout.LayoutParams paramLayoutParams, int paramInt)
  {
    paramView.setLayoutParams(paramLayoutParams);
    if (paramInt >= 0)
    {
      addView(paramView, paramInt);
      return;
    }
    addView(paramView, getChildCount());
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    int i2 = 0;
    int i3;
    if (paramView != null)
    {
      i3 = paramView.getVisibility();
      if (!paramBoolean) {
        break label26;
      }
    }
    label26:
    for (int i1 = 0; i3 == i1; i1 = 8) {
      return;
    }
    if (paramBoolean) {}
    for (i1 = i2;; i1 = 8)
    {
      paramView.setVisibility(i1);
      return;
    }
  }
  
  @Deprecated
  public void a(final String paramString)
  {
    if (!com.ideashower.readitlater.a.g.q())
    {
      com.ideashower.readitlater.a.g.a(new Runnable()
      {
        public void run()
        {
          BaseWebView.this.a(paramString);
        }
      });
      return;
    }
    loadUrl("javascript: ".concat(paramString));
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, final boolean paramBoolean2)
  {
    int i1;
    if (paramBoolean1)
    {
      if (this.t == null)
      {
        this.t = new w(getContext());
        this.t.setScaleType(ImageView.ScaleType.CENTER);
        this.t.setClickable(true);
        this.t.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        a(this.t);
      }
      this.t.setVisibility(8);
      Bitmap localBitmap1 = null;
      setDrawingCacheEnabled(true);
      Bitmap localBitmap2 = getDrawingCache();
      if (localBitmap2 != null) {
        localBitmap1 = Bitmap.createBitmap(localBitmap2);
      }
      setDrawingCacheEnabled(false);
      if (localBitmap1 == null) {
        return;
      }
      this.t.setImageBitmap(localBitmap1);
      this.t.bringToFront();
      this.t.setVisibility(0);
      i1 = 0;
    }
    for (;;)
    {
      this.x = paramBoolean1;
      if (i1 == 0) {
        break;
      }
      invalidate();
      return;
      if (this.t != null)
      {
        this.v = new Runnable()
        {
          public void run()
          {
            if (paramBoolean2)
            {
              if (BaseWebView.b(BaseWebView.this) == null)
              {
                BaseWebView.a(BaseWebView.this, new AlphaAnimation(1.0F, 0.0F));
                BaseWebView.b(BaseWebView.this).setDuration(120L);
                BaseWebView.b(BaseWebView.this).setAnimationListener(new Animation.AnimationListener()
                {
                  public void onAnimationEnd(Animation paramAnonymous2Animation)
                  {
                    BaseWebView.c(BaseWebView.this).setVisibility(8);
                    BaseWebView.c(BaseWebView.this).setImageBitmap(null);
                  }
                  
                  public void onAnimationRepeat(Animation paramAnonymous2Animation) {}
                  
                  public void onAnimationStart(Animation paramAnonymous2Animation) {}
                });
              }
              BaseWebView.c(BaseWebView.this).startAnimation(BaseWebView.b(BaseWebView.this));
              return;
            }
            BaseWebView.c(BaseWebView.this).setVisibility(8);
          }
        };
        i1 = 1;
      }
      else
      {
        i1 = 0;
      }
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  protected void b()
  {
    WebSettings localWebSettings = getSettings();
    z.a(localWebSettings, true);
    localWebSettings.setJavaScriptEnabled(true);
    if (com.ideashower.readitlater.util.a.l()) {
      c.a(localWebSettings);
    }
    if (com.ideashower.readitlater.util.a.b()) {
      d.a(this);
    }
    setScrollBarStyle(0);
    c();
    this.e = ba.a(this);
    ax.a(this);
    if (com.ideashower.readitlater.util.a.o()) {
      setPictureListener(this);
    }
    m();
    this.A = new ab(this, ViewConfiguration.get(getContext()).getScaledTouchSlop());
  }
  
  public void b(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.y.add(paramView);
    }
    for (;;)
    {
      invalidate();
      return;
      this.y.remove(paramView);
    }
  }
  
  public void c()
  {
    setBackgroundColor(m.c(getContext()));
  }
  
  public void c(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.z.add(paramView);
    }
    for (;;)
    {
      invalidate();
      return;
      this.z.remove(paramView);
    }
  }
  
  protected int computeVerticalScrollExtent()
  {
    if (this.c != null) {
      this.c.a();
    }
    return super.computeVerticalScrollExtent();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (!this.x) {
      super.draw(paramCanvas);
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    if (this.y.contains(paramView)) {
      paramView.offsetLeftAndRight(getScrollX() - paramView.getLeft());
    }
    if (this.z.contains(paramView)) {
      paramView.offsetTopAndBottom(getScrollY() - paramView.getTop());
    }
    if (paramView == this.n) {
      this.n.offsetTopAndBottom(getScrollY() + getVisibleTitleHeightCompat() - this.n.getTop());
    }
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  public boolean g()
  {
    return this.g;
  }
  
  public float getLastDownX()
  {
    return this.r;
  }
  
  public float getLastDownY()
  {
    return this.q;
  }
  
  public int getMaxContentScrollY()
  {
    return a(getContentHeight()) - getHeight();
  }
  
  public int getProgress()
  {
    if (this.n == null) {
      return super.getProgress();
    }
    return this.n.getProgress();
  }
  
  public String getSelectedText()
  {
    Object localObject = null;
    try
    {
      String str = z.a(this);
      localObject = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        com.ideashower.readitlater.util.e.a(localThrowable, true);
      }
    }
    if (localObject != null) {
      n();
    }
    return (String)localObject;
  }
  
  public boolean h()
  {
    return this.A.b();
  }
  
  public void i()
  {
    if (this.n == null) {
      return;
    }
    this.n.invalidate();
  }
  
  public void invalidate()
  {
    super.invalidate();
    if (com.ideashower.readitlater.util.a.n()) {
      d();
    }
  }
  
  public float j()
  {
    return 100.0F / (getScale() * 100.0F);
  }
  
  public void k()
  {
    try
    {
      if (C == null) {
        C = WebView.class.getMethod("onPause", new Class[0]);
      }
      C.invoke(this, (Object[])null);
      return;
    }
    catch (Exception localException)
    {
      com.ideashower.readitlater.util.e.a(localException, true);
    }
  }
  
  public void l()
  {
    try
    {
      if (D == null) {
        D = WebView.class.getMethod("onResume", new Class[0]);
      }
      D.invoke(this, (Object[])null);
      return;
    }
    catch (Exception localException)
    {
      com.ideashower.readitlater.util.e.a(localException, true);
    }
  }
  
  public void m()
  {
    m.a(this);
  }
  
  public void n()
  {
    if (com.ideashower.readitlater.util.a.a())
    {
      bb.a(this);
      return;
    }
    loadUrl("javascript:");
    invalidate();
  }
  
  public boolean o()
  {
    return this.A.c();
  }
  
  @SuppressLint({"WrongCall"})
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.A.a();
    if (this.v != null)
    {
      this.v.run();
      this.v = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (((paramInt == 23) || (paramInt == 66)) && (this.d != null)) {
      this.d.b();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onNewPicture(WebView paramWebView, Picture paramPicture)
  {
    d();
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.A.a(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.s != null) {
      this.s.b();
    }
    if (this.d != null) {
      this.d.a();
    }
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.e.a();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.c != null) {
      this.c.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent == null) {
      return false;
    }
    this.A.a(paramMotionEvent);
    if (this.d != null)
    {
      this.d.a();
      this.d.b();
    }
    if (this.s != null) {
      this.s.a(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        return super.onTouchEvent(paramMotionEvent);
        this.r = paramMotionEvent.getX();
        this.q = paramMotionEvent.getY();
      }
    } while (!this.l);
    return true;
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    int i1 = paramInt2;
    if (paramInt2 < 0) {
      i1 = 0;
    }
    super.scrollTo(paramInt1, i1);
  }
  
  public void setContainerFrame(RelativeLayout paramRelativeLayout)
  {
    this.k = paramRelativeLayout;
  }
  
  public void setContentVisible(boolean paramBoolean)
  {
    int i1 = 0;
    if (this.w == null)
    {
      this.w = new ThemedView(getContext());
      this.w.setBackgroundResource(2130837763);
      a(this.w, -1, -1, 0, 0, 0);
      c(this.w, true);
      b(this.w, true);
    }
    if (!paramBoolean) {
      this.w.requestLayout();
    }
    ThemedView localThemedView = this.w;
    if (!paramBoolean) {}
    for (;;)
    {
      localThemedView.setVisibility(i1);
      return;
      i1 = 8;
    }
  }
  
  public void setOnContentDisplayedListener(e parame)
  {
    this.f = parame;
  }
  
  public void setOnInteractionListener(f paramf)
  {
    this.d = paramf;
  }
  
  public void setOnPictureUpdatedCallback(Runnable paramRunnable)
  {
    Handler localHandler = getHandler();
    if (localHandler == null) {}
    do
    {
      return;
      if (this.B != null) {
        localHandler.removeCallbacks(this.B);
      }
      this.B = paramRunnable;
    } while (paramRunnable == null);
    localHandler.postDelayed(paramRunnable, 333L);
  }
  
  public void setOnResizeListener(g paramg)
  {
    this.c = paramg;
  }
  
  public void setOnScrollListener(ac paramac)
  {
    this.A.a(paramac);
  }
  
  public void setProgress(int paramInt)
  {
    if (this.n == null) {
      return;
    }
    this.n.setProgress(paramInt);
  }
  
  public void setProgressBarVisibility(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.n == null))
    {
      int i1 = (int)getResources().getDimension(2131296399);
      this.n = new b(getContext());
      AbsoluteLayout.LayoutParams localLayoutParams = new AbsoluteLayout.LayoutParams(-1, i1, 0, 0);
      this.n.setLayoutParams(localLayoutParams);
      this.n.setMinimumHeight(i1);
      b(this.n, true);
      addView(this.n);
    }
    a(this.n, paramBoolean);
  }
  
  public void setSpinnerBlocked(boolean paramBoolean)
  {
    boolean bool2 = true;
    this.m = paramBoolean;
    ProgressBar localProgressBar = this.a;
    boolean bool1;
    if ((!paramBoolean) && (this.b))
    {
      bool1 = true;
      a(localProgressBar, bool1);
      localProgressBar = this.i;
      if ((paramBoolean) || (!this.j)) {
        break label65;
      }
    }
    label65:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      a(localProgressBar, paramBoolean);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void setTouchBlocker(h paramh)
  {
    this.o = paramh;
    Object localObject;
    if (this.p == null)
    {
      this.p = new View(getContext());
      localObject = new ViewGroup.LayoutParams(-1, -1);
      this.p.setLayoutParams((ViewGroup.LayoutParams)localObject);
      addView(this.p);
    }
    View localView = this.p;
    if (paramh != null)
    {
      localObject = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (!BaseWebView.a(BaseWebView.this).a()) {
            BaseWebView.this.setTouchBlocker(null);
          }
        }
      };
      localView.setOnClickListener((View.OnClickListener)localObject);
      localObject = this.p;
      if (paramh != null) {
        break label101;
      }
    }
    label101:
    for (int i1 = 8;; i1 = 0)
    {
      ((View)localObject).setVisibility(i1);
      return;
      localObject = null;
      break;
    }
  }
  
  public void setTouchToWebInterface(ay paramay)
  {
    this.s = paramay;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/BaseWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */