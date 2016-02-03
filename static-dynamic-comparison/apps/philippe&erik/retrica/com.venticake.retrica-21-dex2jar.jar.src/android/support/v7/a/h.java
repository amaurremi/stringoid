package android.support.v7.a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.b.c;
import android.support.v7.b.d;
import android.support.v7.b.j;
import android.support.v7.b.k;
import android.support.v7.internal.view.menu.ac;
import android.support.v7.internal.view.menu.ad;
import android.support.v7.internal.view.menu.af;
import android.support.v7.internal.view.menu.o;
import android.support.v7.internal.view.menu.p;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;

class h
  extends g
  implements ac, p
{
  private static final int[] d = { c.homeAsUpIndicator };
  private ActionBarView e;
  private android.support.v7.internal.view.menu.m f;
  private o g;
  private android.support.v7.c.a h;
  private boolean i;
  private CharSequence j;
  private boolean k;
  private boolean l;
  private boolean m;
  private final Runnable n = new Runnable()
  {
    public void run()
    {
      o localo = h.a(h.this);
      if ((h.this.a.a(0, localo)) && (h.this.a.a(0, null, localo))) {
        h.a(h.this, localo);
      }
      for (;;)
      {
        h.a(h.this, false);
        return;
        h.a(h.this, null);
      }
    }
  };
  
  h(f paramf)
  {
    super(paramf);
  }
  
  private ad a(Context paramContext, ac paramac)
  {
    if (this.g == null) {
      return null;
    }
    if (this.f == null)
    {
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(k.Theme);
      int i1 = localTypedArray.getResourceId(4, j.Theme_AppCompat_CompactMenu);
      localTypedArray.recycle();
      this.f = new android.support.v7.internal.view.menu.m(android.support.v7.b.h.abc_list_menu_item_layout, i1);
      this.f.a(paramac);
      this.g.a(this.f);
    }
    for (;;)
    {
      return this.f.a(new FrameLayout(paramContext));
      this.f.c(false);
    }
  }
  
  private void b(o paramo, boolean paramBoolean)
  {
    if ((this.e != null) && (this.e.e()))
    {
      if ((!this.e.d()) || (!paramBoolean))
      {
        if (this.e.getVisibility() == 0) {
          this.e.a();
        }
        return;
      }
      this.e.c();
      return;
    }
    paramo.close();
  }
  
  private void c(o paramo)
  {
    if (paramo == this.g) {}
    do
    {
      return;
      if (this.g != null) {
        this.g.b(this.f);
      }
      this.g = paramo;
      if ((paramo != null) && (this.f != null)) {
        paramo.a(this.f);
      }
    } while (this.e == null);
    this.e.a(paramo, this);
  }
  
  private o l()
  {
    o localo = new o(j());
    localo.a(this);
    return localo;
  }
  
  public a a()
  {
    k();
    return new m(this.a, this.a);
  }
  
  public void a(int paramInt)
  {
    k();
    if (this.b)
    {
      ViewGroup localViewGroup = (ViewGroup)this.a.findViewById(16908290);
      localViewGroup.removeAllViews();
      this.a.getLayoutInflater().inflate(paramInt, localViewGroup);
    }
    for (;;)
    {
      this.a.h();
      return;
      this.a.a(paramInt);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if ((this.b) && (this.i)) {
      ((m)b()).a(paramConfiguration);
    }
  }
  
  public void a(o paramo)
  {
    b(paramo, true);
  }
  
  public void a(o paramo, boolean paramBoolean)
  {
    this.a.closeOptionsMenu();
  }
  
  public void a(View paramView)
  {
    k();
    if (this.b)
    {
      ViewGroup localViewGroup = (ViewGroup)this.a.findViewById(16908290);
      localViewGroup.removeAllViews();
      localViewGroup.addView(paramView);
    }
    for (;;)
    {
      this.a.h();
      return;
      this.a.a(paramView);
    }
  }
  
  public void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    k();
    if (this.b)
    {
      ViewGroup localViewGroup = (ViewGroup)this.a.findViewById(16908290);
      localViewGroup.removeAllViews();
      localViewGroup.addView(paramView, paramLayoutParams);
    }
    for (;;)
    {
      this.a.h();
      return;
      this.a.a(paramView, paramLayoutParams);
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (this.e != null)
    {
      this.e.setWindowTitle(paramCharSequence);
      return;
    }
    this.j = paramCharSequence;
  }
  
  public boolean a(int paramInt, Menu paramMenu)
  {
    if (paramInt != 0) {
      return this.a.a(paramInt, paramMenu);
    }
    return false;
  }
  
  public boolean a(int paramInt, MenuItem paramMenuItem)
  {
    MenuItem localMenuItem = paramMenuItem;
    if (paramInt == 0) {
      localMenuItem = af.a(paramMenuItem);
    }
    return this.a.a(paramInt, localMenuItem);
  }
  
  public boolean a(int paramInt, View paramView, Menu paramMenu)
  {
    if (paramInt != 0) {
      return this.a.a(paramInt, paramView, paramMenu);
    }
    return false;
  }
  
  public boolean a(o paramo, MenuItem paramMenuItem)
  {
    return this.a.onMenuItemSelected(0, paramMenuItem);
  }
  
  public View b(int paramInt)
  {
    Object localObject1 = null;
    if (paramInt == 0)
    {
      boolean bool1 = true;
      boolean bool2 = true;
      o localo = this.g;
      Object localObject2 = localo;
      if (this.h == null)
      {
        localObject1 = localo;
        if (localo == null)
        {
          localObject1 = l();
          c((o)localObject1);
          ((o)localObject1).f();
          bool2 = this.a.a(0, (Menu)localObject1);
        }
        localObject2 = localObject1;
        bool1 = bool2;
        if (bool2)
        {
          ((o)localObject1).f();
          bool1 = this.a.a(0, null, (Menu)localObject1);
          localObject2 = localObject1;
        }
      }
      if (bool1)
      {
        localObject1 = (View)a(this.a, this);
        ((o)localObject2).g();
      }
    }
    else
    {
      return (View)localObject1;
    }
    c(null);
    return null;
  }
  
  public void b(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    k();
    if (this.b) {
      ((ViewGroup)this.a.findViewById(16908290)).addView(paramView, paramLayoutParams);
    }
    for (;;)
    {
      this.a.h();
      return;
      this.a.a(paramView, paramLayoutParams);
    }
  }
  
  public boolean b(o paramo)
  {
    return false;
  }
  
  public void d()
  {
    m localm = (m)b();
    if (localm != null) {
      localm.c(false);
    }
  }
  
  public void e()
  {
    m localm = (m)b();
    if (localm != null) {
      localm.c(true);
    }
  }
  
  public void f()
  {
    if (!this.m)
    {
      this.m = true;
      this.a.getWindow().getDecorView().post(this.n);
    }
  }
  
  public boolean g()
  {
    if (this.h != null)
    {
      this.h.a();
      return true;
    }
    if ((this.e != null) && (this.e.i()))
    {
      this.e.j();
      return true;
    }
    return false;
  }
  
  public void h() {}
  
  final void k()
  {
    boolean bool2;
    boolean bool1;
    if ((this.b) && (!this.i))
    {
      if (!this.c) {
        break label252;
      }
      this.a.a(android.support.v7.b.h.abc_action_bar_decor_overlay);
      this.e = ((ActionBarView)this.a.findViewById(android.support.v7.b.f.action_bar));
      this.e.setWindowCallback(this.a);
      if (this.k) {
        this.e.f();
      }
      if (this.l) {
        this.e.g();
      }
      bool2 = "splitActionBarWhenNarrow".equals(i());
      if (!bool2) {
        break label265;
      }
      bool1 = this.a.getResources().getBoolean(d.abc_split_action_bar_is_narrow);
    }
    for (;;)
    {
      Object localObject = (ActionBarContainer)this.a.findViewById(android.support.v7.b.f.split_action_bar);
      if (localObject != null)
      {
        this.e.setSplitView((ActionBarContainer)localObject);
        this.e.setSplitActionBar(bool1);
        this.e.setSplitWhenNarrow(bool2);
        ActionBarContextView localActionBarContextView = (ActionBarContextView)this.a.findViewById(android.support.v7.b.f.action_context_bar);
        localActionBarContextView.setSplitView((ActionBarContainer)localObject);
        localActionBarContextView.setSplitActionBar(bool1);
        localActionBarContextView.setSplitWhenNarrow(bool2);
      }
      this.a.findViewById(16908290).setId(-1);
      this.a.findViewById(android.support.v7.b.f.action_bar_activity_content).setId(16908290);
      if (this.j != null)
      {
        this.e.setWindowTitle(this.j);
        this.j = null;
      }
      this.i = true;
      f();
      return;
      label252:
      this.a.a(android.support.v7.b.h.abc_action_bar_decor);
      break;
      label265:
      localObject = this.a.obtainStyledAttributes(k.ActionBarWindow);
      bool1 = ((TypedArray)localObject).getBoolean(2, false);
      ((TypedArray)localObject).recycle();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */