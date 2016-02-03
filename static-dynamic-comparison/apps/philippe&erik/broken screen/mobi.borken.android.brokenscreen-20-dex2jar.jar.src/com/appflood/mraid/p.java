package com.appflood.mraid;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.appflood.AFListActivity.1;
import com.appflood.c.d;
import com.appflood.e.j;
import java.util.ArrayList;

public final class p
  extends b
{
  boolean a;
  boolean b = false;
  Handler c = new Handler();
  protected float d;
  protected int e = -1;
  protected int f = -1;
  private t g = t.d;
  private final m h;
  private final r i;
  private final o j;
  private AFBannerWebView k;
  private FrameLayout l;
  private Runnable m = new Runnable()
  {
    public final void run()
    {
      boolean bool = p.this.e();
      if (p.this.a != bool)
      {
        p.this.a = bool;
        p.this.a().a(A.a(p.this.a));
      }
      p.a(p.this, (int)(p.this.a().getWidth() / p.this.d), (int)(p.this.a().getHeight() / p.this.d));
      if (!p.this.b) {
        p.this.c.postDelayed(this, 3000L);
      }
    }
  };
  private final int n;
  private BroadcastReceiver o = new BroadcastReceiver()
  {
    private int a;
    
    public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getAction().equals("android.intent.action.CONFIGURATION_CHANGED"))
      {
        int i = p.a(p.this);
        if (i != this.a)
        {
          this.a = i;
          paramAnonymousContext = p.this;
          i = this.a;
          p.b(paramAnonymousContext);
        }
      }
    }
  };
  private ImageView p;
  private boolean q = true;
  private int r = -1;
  private int s = -1;
  private int t = -1;
  private int u;
  private FrameLayout v;
  private FrameLayout w;
  private RelativeLayout x;
  private RelativeLayout y;
  private RelativeLayout z;
  
  public p(AFBannerWebView paramAFBannerWebView, m paramm, r paramr, o paramo)
  {
    super(paramAFBannerWebView);
    this.h = paramm;
    this.i = paramr;
    this.j = paramo;
    paramAFBannerWebView = super.a().getContext();
    if ((paramAFBannerWebView instanceof Activity)) {}
    for (int i1 = ((Activity)paramAFBannerWebView).getRequestedOrientation();; i1 = -1)
    {
      this.n = i1;
      this.w = new FrameLayout(super.a().getContext());
      this.y = new RelativeLayout(super.a().getContext());
      this.v = new FrameLayout(super.a().getContext());
      this.g = t.a;
      f();
      this.c.removeCallbacks(this.m);
      this.c.post(this.m);
      super.a().getContext().registerReceiver(this.o, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
      return;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    ViewGroup localViewGroup1;
    if (paramBoolean)
    {
      this.z.removeAllViews();
      this.l.removeView(this.z);
      localViewGroup1 = (ViewGroup)this.v.getParent();
      if (localViewGroup1 != this.x) {
        break label135;
      }
      ViewGroup localViewGroup2 = (ViewGroup)localViewGroup1.getParent();
      if (localViewGroup2 != null) {
        localViewGroup2.setVisibility(0);
      }
      label58:
      localViewGroup1.addView(super.a(), this.u, this.v.getLayoutParams());
      localViewGroup1.removeView(this.v);
      if (this.q) {
        break label143;
      }
    }
    label135:
    label143:
    for (paramBoolean = true;; paramBoolean = false)
    {
      a(paramBoolean, t.b);
      localViewGroup1.invalidate();
      return;
      this.w.removeAllViewsInLayout();
      this.y.removeAllViewsInLayout();
      this.l.removeView(this.y);
      break;
      localViewGroup1.setVisibility(0);
      break label58;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = super.a().getContext();
    try
    {
      localObject = (Activity)localObject;
      if (paramBoolean) {}
      for (int i1 = ((Activity)localObject).getResources().getConfiguration().orientation;; i1 = this.n)
      {
        ((Activity)localObject).setRequestedOrientation(i1);
        return;
      }
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      Log.d("MraidDisplayController", "Unable to modify device orientation.");
    }
  }
  
  private void f()
  {
    Context localContext = super.a().getContext();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)localContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.d = localDisplayMetrics.density;
    int i1 = localDisplayMetrics.widthPixels;
    int i2 = localDisplayMetrics.heightPixels;
    this.e = ((int)(i1 * (160.0D / localDisplayMetrics.densityDpi)));
    this.f = ((int)(i2 * (160.0D / localDisplayMetrics.densityDpi)));
    this.r = ((int)((i2 - AFListActivity.1.a(localContext)) * (160.0D / localDisplayMetrics.densityDpi)));
  }
  
  private void g()
  {
    int i2 = 0;
    ViewGroup localViewGroup = (ViewGroup)super.a().getParent();
    Object localObject = super.a();
    if (localViewGroup == null) {
      return;
    }
    int i1;
    if (localViewGroup == this.x)
    {
      i1 = 1;
      localObject = this.x;
      localViewGroup = (ViewGroup)localViewGroup.getParent();
    }
    for (;;)
    {
      int i3 = localViewGroup.getChildCount();
      while ((i2 < i3) && (localViewGroup.getChildAt(i2) != localObject)) {
        i2 += 1;
      }
      this.u = i2;
      if ((this.v != null) && (this.v.getParent() != null)) {
        ((ViewGroup)this.v.getParent()).removeView(this.v);
      }
      localViewGroup.addView(this.v, i2, ((View)localObject).getLayoutParams());
      ((ViewGroup)super.a().getParent()).removeView(super.a());
      if (i1 != 0) {
        localViewGroup.removeView((View)localObject);
      }
      localViewGroup.setVisibility(4);
      return;
      i1 = 0;
    }
  }
  
  protected final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (this.i == r.b) {
      return;
    }
    this.l = ((FrameLayout)super.a().getRootView().findViewById(16908290));
    g();
    this.z = new RelativeLayout(super.a().getContext());
    int i2 = paramInt1;
    int i3 = paramInt2;
    if (!paramBoolean)
    {
      int i1 = paramInt1;
      if (paramInt3 + paramInt1 > this.e) {
        i1 = this.e - paramInt3;
      }
      i2 = i1;
      i3 = paramInt2;
      if (paramInt2 + paramInt4 > this.r)
      {
        i3 = this.r - paramInt4;
        i2 = i1;
      }
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams((int)(i2 * this.d), (int)(i3 * this.d));
    localLayoutParams.leftMargin = ((int)(paramInt3 * this.d));
    localLayoutParams.topMargin = ((int)(paramInt4 * this.d));
    localLayoutParams.gravity = 51;
    new StringBuilder("llllllllll left ").append(localLayoutParams.leftMargin).append(" right ").append(localLayoutParams.topMargin).append("  ").append(this.l).append(" mrootw ").append(this.l.getWidth()).toString();
    j.a();
    this.z.addView(super.a(), new ViewGroup.LayoutParams(-1, -1));
    this.l.addView(this.z, localLayoutParams);
    this.g = t.e;
    super.a().a(z.a(this.g));
  }
  
  protected final void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.h == m.b) {
      return;
    }
    new StringBuilder(" url = ").append(paramString).toString();
    j.a();
    if ((paramString != null) && (!URLUtil.isValidUrl(paramString)))
    {
      super.a().a("expand", "URL passed to expand() was invalid.");
      return;
    }
    if (this.g == t.e) {
      b(true);
    }
    this.l = ((FrameLayout)super.a().getRootView().findViewById(16908290));
    a(paramBoolean1);
    c(paramBoolean2);
    g();
    AFBannerWebView localAFBannerWebView = super.a();
    if (!j.a(paramString))
    {
      this.k = new AFBannerWebView(super.a().getContext(), m.b, r.a, o.c, q.a);
      this.k.a(new a());
      this.k.loadUrl(paramString);
      localAFBannerWebView = this.k;
    }
    int i1 = (int)(paramInt1 * this.d);
    int i2 = (int)(paramInt2 * this.d);
    paramInt2 = AFListActivity.1.a(super.a().getContext(), 45);
    paramInt1 = i1;
    if (i1 < paramInt2) {
      paramInt1 = paramInt2;
    }
    if (i2 < paramInt2) {}
    for (;;)
    {
      paramString = new View(super.a().getContext());
      paramString.setBackgroundColor(0);
      paramString.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
      });
      this.y.addView(paramString, new RelativeLayout.LayoutParams(-1, -1));
      this.w.addView(localAFBannerWebView, new RelativeLayout.LayoutParams(-1, -1));
      paramString = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
      paramString.addRule(13);
      this.y.addView(this.w, paramString);
      this.l.addView(this.y, new RelativeLayout.LayoutParams(-1, -1));
      if ((this.j == o.a) || ((!this.q) && (this.j != o.b))) {
        a(true, t.c);
      }
      this.g = t.c;
      super.a().a(z.a(this.g));
      super.a().e();
      return;
      paramInt2 = i2;
    }
  }
  
  protected final void a(boolean paramBoolean)
  {
    new StringBuilder("useCustomClose ").append(paramBoolean).append(" state ").append(this.g).toString();
    j.a();
    if ((paramBoolean != this.q) && (this.g == t.b)) {
      if (paramBoolean) {
        break label80;
      }
    }
    label80:
    for (boolean bool = true;; bool = false)
    {
      a(bool, t.b);
      this.q = paramBoolean;
      super.a().h();
      return;
    }
  }
  
  protected final void a(boolean paramBoolean, t paramt)
  {
    new StringBuilder("setNativeCloseButtonEnabled enable ").append(paramBoolean).append(" state ").append(paramt).toString();
    j.a();
    Object localObject;
    int i1;
    if (paramBoolean)
    {
      if (this.p == null)
      {
        localObject = new StateListDrawable();
        ((StateListDrawable)localObject).addState(new int[] { -16842919 }, null);
        ((StateListDrawable)localObject).addState(new int[] { 16842919 }, null);
        this.p = new ImageButton(super.a().getContext());
        this.p.setBackgroundColor(0);
        this.p.setScaleType(ImageView.ScaleType.FIT_CENTER);
        new com.appflood.b.b(d.z + "mraid_button_close.png", (byte)0).a(this.p);
        this.p.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            p.this.d();
          }
        });
      }
      if (this.p.getParent() != null) {
        ((ViewGroup)this.p.getParent()).removeView(this.p);
      }
      i1 = AFListActivity.1.a(super.a().getContext(), 45);
      if (paramt == t.c)
      {
        paramt = new FrameLayout.LayoutParams(i1, i1, 5);
        this.w.addView(this.p, paramt);
      }
    }
    for (;;)
    {
      super.a().h();
      return;
      if ((paramt == t.b) || (paramt == t.e))
      {
        localObject = new RelativeLayout.LayoutParams(i1, i1);
        ((RelativeLayout.LayoutParams)localObject).addRule(11);
        ((RelativeLayout.LayoutParams)localObject).addRule(10);
        if (this.x == null)
        {
          this.x = new RelativeLayout(super.a().getContext());
          label312:
          RelativeLayout localRelativeLayout = (RelativeLayout)super.a().getParent();
          if (localRelativeLayout != null)
          {
            localRelativeLayout.addView(this.x, super.a().getLayoutParams());
            localRelativeLayout.removeView(super.a());
          }
          this.x.addView(super.a(), new RelativeLayout.LayoutParams(-1, -1));
          if (paramt != t.b) {
            break label463;
          }
        }
        label463:
        for (paramt = this.x;; paramt = this.z)
        {
          new StringBuilder(" container ").append(paramt).append(" mDefaultLayout ").append(this.x).toString();
          j.a();
          paramt.addView(this.p, (ViewGroup.LayoutParams)localObject);
          break;
          if (this.x.getParent() == null) {
            break label312;
          }
          ((ViewGroup)this.x.getParent()).removeView(this.x);
          break label312;
        }
        if (this.p != null)
        {
          if (this.p.getParent() != null) {
            ((ViewGroup)this.p.getParent()).removeView(this.p);
          }
          if ((paramt == t.b) && (super.a().getParent() == this.x))
          {
            paramt = (RelativeLayout.LayoutParams)this.x.getLayoutParams();
            localObject = (RelativeLayout)this.x.getParent();
            this.x.removeView(super.a());
            if (localObject != null)
            {
              ((RelativeLayout)localObject).removeView(this.x);
              ((RelativeLayout)localObject).addView(super.a(), paramt);
            }
          }
        }
      }
    }
  }
  
  public final void b()
  {
    this.c.removeCallbacks(this.m);
    try
    {
      super.a().getContext().unregisterReceiver(this.o);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (localIllegalArgumentException.getMessage().contains("Receiver not registered")) {}
      throw localIllegalArgumentException;
    }
  }
  
  public final void c()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(x.a(this.e, this.f));
    localArrayList.add(A.a(this.a));
    super.a().a(localArrayList);
    this.g = t.b;
    a(false);
    super.a().a(z.a(this.g));
    super.a().a(this.e, this.r);
    super.a().l();
  }
  
  protected final void d()
  {
    if (this.g == t.b)
    {
      super.a().setVisibility(4);
      this.g = t.d;
      localObject = (ViewGroup)super.a().getParent();
      if (localObject != null)
      {
        if (localObject == this.x)
        {
          ((ViewGroup)((ViewGroup)localObject).getParent()).setVisibility(4);
          ((ViewGroup)((ViewGroup)localObject).getParent()).removeAllViews();
        }
        ((ViewGroup)localObject).setVisibility(4);
      }
      super.a().a(z.a(this.g));
      b();
      this.b = true;
      if (super.a().a() != null) {
        super.a().a().onClose();
      }
    }
    while ((this.g != t.e) && (this.g != t.c))
    {
      Object localObject;
      if (super.a().f() != null)
      {
        localObject = super.a().f();
        super.a();
        t localt = this.g;
        ((a)localObject).a();
      }
      return;
    }
    if (this.g == t.e) {}
    for (boolean bool = true;; bool = false)
    {
      b(bool);
      c(false);
      this.g = t.b;
      super.a().a(z.a(this.g));
      break;
    }
  }
  
  protected final boolean e()
  {
    return (super.a().hasWindowFocus()) && (super.a().getVisibility() == 0);
  }
  
  public final class a
  {
    a() {}
    
    public final void a()
    {
      p.this.d();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/mraid/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */