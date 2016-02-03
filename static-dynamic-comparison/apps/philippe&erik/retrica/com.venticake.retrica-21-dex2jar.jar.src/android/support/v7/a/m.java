package android.support.v7.a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.os.Handler;
import android.support.v7.app.ActionBar.OnMenuVisibilityListener;
import android.support.v7.app.ActionBarImplBase.TabImpl;
import android.support.v7.b.c;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarOverlayLayout;
import android.support.v7.internal.widget.ActionBarView;
import android.support.v7.internal.widget.ScrollingTabContainerView;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;

class m
  extends a
{
  final Handler a = new Handler();
  private Context b;
  private Context c;
  private f d;
  private ActionBarOverlayLayout e;
  private ActionBarContainer f;
  private ViewGroup g;
  private ActionBarView h;
  private ActionBarContextView i;
  private ActionBarContainer j;
  private ScrollingTabContainerView k;
  private ArrayList<ActionBarImplBase.TabImpl> l = new ArrayList();
  private int m = -1;
  private boolean n;
  private ArrayList<ActionBar.OnMenuVisibilityListener> o = new ArrayList();
  private int p;
  private boolean q;
  private int r = 0;
  private boolean s;
  private boolean t;
  private boolean u;
  private boolean v = true;
  private boolean w;
  private b x;
  
  public m(f paramf, b paramb)
  {
    this.d = paramf;
    this.b = paramf;
    this.x = paramb;
    a(this.d);
  }
  
  private void a(f paramf)
  {
    boolean bool = false;
    this.e = ((ActionBarOverlayLayout)paramf.findViewById(android.support.v7.b.f.action_bar_overlay_layout));
    if (this.e != null) {
      this.e.setActionBar(this);
    }
    this.h = ((ActionBarView)paramf.findViewById(android.support.v7.b.f.action_bar));
    this.i = ((ActionBarContextView)paramf.findViewById(android.support.v7.b.f.action_context_bar));
    this.f = ((ActionBarContainer)paramf.findViewById(android.support.v7.b.f.action_bar_container));
    this.g = ((ViewGroup)paramf.findViewById(android.support.v7.b.f.top_action_bar));
    if (this.g == null) {
      this.g = this.f;
    }
    this.j = ((ActionBarContainer)paramf.findViewById(android.support.v7.b.f.split_action_bar));
    if ((this.h == null) || (this.i == null) || (this.f == null)) {
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
    }
    this.h.setContextView(this.i);
    if (this.h.h())
    {
      i1 = 1;
      this.p = i1;
      if ((this.h.getDisplayOptions() & 0x4) == 0) {
        break label277;
      }
    }
    label277:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0) {
        this.n = true;
      }
      paramf = android.support.v7.internal.view.a.a(this.b);
      if ((paramf.f()) || (i1 != 0)) {
        bool = true;
      }
      b(bool);
      f(paramf.d());
      a(this.d.getTitle());
      return;
      i1 = 0;
      break;
    }
  }
  
  private static boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean3) {}
    while ((!paramBoolean1) && (!paramBoolean2)) {
      return true;
    }
    return false;
  }
  
  private void f(boolean paramBoolean)
  {
    boolean bool = true;
    this.q = paramBoolean;
    int i1;
    label43:
    label62:
    ActionBarView localActionBarView;
    if (!this.q)
    {
      this.h.setEmbeddedTabView(null);
      this.f.setTabContainer(this.k);
      if (c() != 2) {
        break label110;
      }
      i1 = 1;
      if (this.k != null)
      {
        if (i1 == 0) {
          break label115;
        }
        this.k.setVisibility(0);
      }
      localActionBarView = this.h;
      if ((this.q) || (i1 == 0)) {
        break label127;
      }
    }
    label110:
    label115:
    label127:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localActionBarView.setCollapsable(paramBoolean);
      return;
      this.f.setTabContainer(null);
      this.h.setEmbeddedTabView(this.k);
      break;
      i1 = 0;
      break label43;
      this.k.setVisibility(8);
      break label62;
    }
  }
  
  private void g(boolean paramBoolean)
  {
    if (a(this.s, this.t, this.u)) {
      if (!this.v)
      {
        this.v = true;
        d(paramBoolean);
      }
    }
    while (!this.v) {
      return;
    }
    this.v = false;
    e(paramBoolean);
  }
  
  public int a()
  {
    return this.h.getDisplayOptions();
  }
  
  public void a(int paramInt)
  {
    this.h.setIcon(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i1 = this.h.getDisplayOptions();
    if ((paramInt2 & 0x4) != 0) {
      this.n = true;
    }
    this.h.setDisplayOptions(i1 & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public void a(Configuration paramConfiguration)
  {
    f(android.support.v7.internal.view.a.a(this.b).d());
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.h.setTitle(paramCharSequence);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 4;; i1 = 0)
    {
      a(i1, 4);
      return;
    }
  }
  
  public Context b()
  {
    int i1;
    if (this.c == null)
    {
      TypedValue localTypedValue = new TypedValue();
      this.b.getTheme().resolveAttribute(c.actionBarWidgetTheme, localTypedValue, true);
      i1 = localTypedValue.resourceId;
      if (i1 == 0) {
        break label61;
      }
    }
    label61:
    for (this.c = new ContextThemeWrapper(this.b, i1);; this.c = this.b) {
      return this.c;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.h.setHomeButtonEnabled(paramBoolean);
  }
  
  public int c()
  {
    return this.h.getNavigationMode();
  }
  
  public void c(boolean paramBoolean)
  {
    this.w = paramBoolean;
    if (!paramBoolean)
    {
      this.g.clearAnimation();
      if (this.j != null) {
        this.j.clearAnimation();
      }
    }
  }
  
  void d()
  {
    if (!this.u)
    {
      this.u = true;
      g(false);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.g.clearAnimation();
    if (this.g.getVisibility() == 0) {
      return;
    }
    if ((f()) || (paramBoolean)) {}
    for (int i1 = 1;; i1 = 0)
    {
      Animation localAnimation;
      if (i1 != 0)
      {
        localAnimation = AnimationUtils.loadAnimation(this.b, android.support.v7.b.b.abc_slide_in_top);
        this.g.startAnimation(localAnimation);
      }
      this.g.setVisibility(0);
      if ((this.j == null) || (this.j.getVisibility() == 0)) {
        break;
      }
      if (i1 != 0)
      {
        localAnimation = AnimationUtils.loadAnimation(this.b, android.support.v7.b.b.abc_slide_in_bottom);
        this.j.startAnimation(localAnimation);
      }
      this.j.setVisibility(0);
      return;
    }
  }
  
  void e()
  {
    if (this.u)
    {
      this.u = false;
      g(false);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.g.clearAnimation();
    if (this.g.getVisibility() == 8) {
      return;
    }
    if ((f()) || (paramBoolean)) {}
    for (int i1 = 1;; i1 = 0)
    {
      Animation localAnimation;
      if (i1 != 0)
      {
        localAnimation = AnimationUtils.loadAnimation(this.b, android.support.v7.b.b.abc_slide_out_top);
        this.g.startAnimation(localAnimation);
      }
      this.g.setVisibility(8);
      if ((this.j == null) || (this.j.getVisibility() == 8)) {
        break;
      }
      if (i1 != 0)
      {
        localAnimation = AnimationUtils.loadAnimation(this.b, android.support.v7.b.b.abc_slide_out_bottom);
        this.j.startAnimation(localAnimation);
      }
      this.j.setVisibility(8);
      return;
    }
  }
  
  boolean f()
  {
    return this.w;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */