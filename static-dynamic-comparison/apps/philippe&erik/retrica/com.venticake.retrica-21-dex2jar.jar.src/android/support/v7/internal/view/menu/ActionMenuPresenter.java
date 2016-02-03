package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.view.k;
import android.support.v7.b.h;
import android.support.v7.internal.view.a;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import java.util.ArrayList;

public class ActionMenuPresenter
  extends j
  implements k
{
  final g a = new g(this, null);
  int b;
  private View i;
  private boolean j;
  private boolean k;
  private int l;
  private int m;
  private int n;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r;
  private int s;
  private final SparseBooleanArray t = new SparseBooleanArray();
  private View u;
  private f v;
  private c w;
  private d x;
  
  public ActionMenuPresenter(Context paramContext)
  {
    super(paramContext, h.abc_action_menu_layout, h.abc_action_menu_item_layout);
  }
  
  private View a(MenuItem paramMenuItem)
  {
    ViewGroup localViewGroup = (ViewGroup)this.h;
    Object localObject;
    if (localViewGroup == null)
    {
      localObject = null;
      return (View)localObject;
    }
    int i2 = localViewGroup.getChildCount();
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {
        break label74;
      }
      View localView = localViewGroup.getChildAt(i1);
      if ((localView instanceof ae))
      {
        localObject = localView;
        if (((ae)localView).getItemData() == paramMenuItem) {
          break;
        }
      }
      i1 += 1;
    }
    label74:
    return null;
  }
  
  public ad a(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.a(paramViewGroup);
    ((ActionMenuView)paramViewGroup).setPresenter(this);
    return paramViewGroup;
  }
  
  public View a(s params, View paramView, ViewGroup paramViewGroup)
  {
    View localView = params.getActionView();
    if ((localView == null) || (params.n()))
    {
      localView = paramView;
      if (!(paramView instanceof ActionMenuItemView)) {
        localView = null;
      }
      localView = super.a(params, localView, paramViewGroup);
    }
    if (params.isActionViewExpanded()) {}
    for (int i1 = 8;; i1 = 0)
    {
      localView.setVisibility(i1);
      params = (ActionMenuView)paramViewGroup;
      paramView = localView.getLayoutParams();
      if (!params.checkLayoutParams(paramView)) {
        localView.setLayoutParams(params.a(paramView));
      }
      return localView;
    }
  }
  
  public void a(int paramInt)
  {
    this.n = paramInt;
    this.o = true;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.l = paramInt;
    this.p = paramBoolean;
    this.q = true;
  }
  
  public void a(Context paramContext, o paramo)
  {
    super.a(paramContext, paramo);
    paramo = paramContext.getResources();
    paramContext = a.a(paramContext);
    if (!this.k) {
      this.j = paramContext.b();
    }
    if (!this.q) {
      this.l = paramContext.c();
    }
    if (!this.o) {
      this.n = paramContext.a();
    }
    int i1 = this.l;
    if (this.j)
    {
      if (this.i == null)
      {
        this.i = new e(this, this.c);
        int i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.i.measure(i2, i2);
      }
      i1 -= this.i.getMeasuredWidth();
    }
    for (;;)
    {
      this.m = i1;
      this.s = ((int)(56.0F * paramo.getDisplayMetrics().density));
      this.u = null;
      return;
      this.i = null;
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (!this.o) {
      this.n = this.d.getResources().getInteger(android.support.v7.b.g.abc_max_action_buttons);
    }
    if (this.e != null) {
      this.e.b(true);
    }
  }
  
  public void a(o paramo, boolean paramBoolean)
  {
    c();
    super.a(paramo, paramBoolean);
  }
  
  public void a(s params, ae paramae)
  {
    paramae.a(params, 0);
    params = (ActionMenuView)this.h;
    ((ActionMenuItemView)paramae).setItemInvoker(params);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.a(null);
      return;
    }
    this.e.a(false);
  }
  
  public boolean a()
  {
    if ((this.j) && (!e()) && (this.e != null) && (this.h != null) && (this.x == null))
    {
      this.x = new d(this, new f(this, this.d, this.e, this.i, true));
      ((View)this.h).post(this.x);
      super.a(null);
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt, s params)
  {
    return params.i();
  }
  
  public boolean a(ah paramah)
  {
    if (!paramah.hasVisibleItems()) {
      return false;
    }
    for (Object localObject = paramah; ((ah)localObject).r() != this.e; localObject = (ah)((ah)localObject).r()) {}
    if (a(((ah)localObject).getItem()) == null)
    {
      if (this.i == null) {
        return false;
      }
      localObject = this.i;
    }
    this.b = paramah.getItem().getItemId();
    this.w = new c(this, paramah);
    this.w.a(null);
    super.a(paramah);
    return true;
  }
  
  public boolean a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramViewGroup.getChildAt(paramInt) == this.i) {
      return false;
    }
    return super.a(paramViewGroup, paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
  
  public boolean b()
  {
    if ((this.x != null) && (this.h != null))
    {
      ((View)this.h).removeCallbacks(this.x);
      this.x = null;
      return true;
    }
    f localf = this.v;
    if (localf != null)
    {
      localf.b();
      return true;
    }
    return false;
  }
  
  public void c(boolean paramBoolean)
  {
    int i2 = 1;
    int i3 = 0;
    super.c(paramBoolean);
    if (this.h == null) {
      return;
    }
    Object localObject;
    int i1;
    if (this.e != null)
    {
      localObject = this.e.j();
      int i4 = ((ArrayList)localObject).size();
      i1 = 0;
      while (i1 < i4)
      {
        android.support.v4.view.j localj = ((s)((ArrayList)localObject).get(i1)).m();
        if (localj != null) {
          localj.a(this);
        }
        i1 += 1;
      }
    }
    if (this.e != null)
    {
      localObject = this.e.k();
      i1 = i3;
      if (this.j)
      {
        i1 = i3;
        if (localObject != null)
        {
          i1 = ((ArrayList)localObject).size();
          if (i1 != 1) {
            break label254;
          }
          if (((s)((ArrayList)localObject).get(0)).isActionViewExpanded()) {
            break label249;
          }
          i1 = 1;
        }
      }
      label143:
      if (i1 == 0) {
        break label268;
      }
      if (this.i == null) {
        this.i = new e(this, this.c);
      }
      localObject = (ViewGroup)this.i.getParent();
      if (localObject != this.h)
      {
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(this.i);
        }
        localObject = (ActionMenuView)this.h;
        ((ActionMenuView)localObject).addView(this.i, ((ActionMenuView)localObject).b());
      }
    }
    for (;;)
    {
      ((ActionMenuView)this.h).setOverflowReserved(this.j);
      return;
      localObject = null;
      break;
      label249:
      i1 = 0;
      break label143;
      label254:
      if (i1 > 0) {}
      for (i1 = i2;; i1 = 0) {
        break;
      }
      label268:
      if ((this.i != null) && (this.i.getParent() == this.h)) {
        ((ViewGroup)this.h).removeView(this.i);
      }
    }
  }
  
  public boolean c()
  {
    return b() | d();
  }
  
  public boolean d()
  {
    if (this.w != null)
    {
      this.w.a();
      return true;
    }
    return false;
  }
  
  public boolean e()
  {
    return (this.v != null) && (this.v.c());
  }
  
  public boolean f()
  {
    return this.j;
  }
  
  public boolean g()
  {
    ArrayList localArrayList = this.e.h();
    int i9 = localArrayList.size();
    int i1 = this.n;
    int i8 = this.m;
    int i10 = View.MeasureSpec.makeMeasureSpec(0, 0);
    ViewGroup localViewGroup = (ViewGroup)this.h;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i2 = 0;
    Object localObject1;
    if (i2 < i9)
    {
      localObject1 = (s)localArrayList.get(i2);
      if (((s)localObject1).k())
      {
        i3 += 1;
        label82:
        if ((!this.r) || (!((s)localObject1).isActionViewExpanded())) {
          break label814;
        }
        i1 = 0;
      }
    }
    label304:
    label445:
    label505:
    label510:
    label549:
    label632:
    label644:
    label649:
    label772:
    label775:
    label805:
    label814:
    for (;;)
    {
      i2 += 1;
      break;
      if (((s)localObject1).j())
      {
        i4 += 1;
        break label82;
      }
      i5 = 1;
      break label82;
      i2 = i1;
      if (this.j) {
        if (i5 == 0)
        {
          i2 = i1;
          if (i3 + i4 <= i1) {}
        }
        else
        {
          i2 = i1 - 1;
        }
      }
      i2 -= i3;
      localObject1 = this.t;
      ((SparseBooleanArray)localObject1).clear();
      i1 = 0;
      if (this.p)
      {
        i1 = i8 / this.s;
        i3 = this.s;
        i4 = this.s;
      }
      for (int i6 = i8 % i3 / i1 + i4;; i6 = 0)
      {
        int i7 = 0;
        i5 = 0;
        i3 = i1;
        i1 = i2;
        i4 = i8;
        i2 = i5;
        s locals;
        Object localObject2;
        if (i7 < i9)
        {
          locals = (s)localArrayList.get(i7);
          if (locals.k())
          {
            localObject2 = a(locals, this.u, localViewGroup);
            if (this.u == null) {
              this.u = ((View)localObject2);
            }
            if (this.p)
            {
              i5 = i3 - ActionMenuView.a((View)localObject2, i6, i3, i10, 0);
              i3 = ((View)localObject2).getMeasuredWidth();
              if (i2 != 0) {
                break label805;
              }
              i2 = i3;
            }
          }
        }
        for (;;)
        {
          i8 = locals.getGroupId();
          if (i8 != 0) {
            ((SparseBooleanArray)localObject1).put(i8, true);
          }
          locals.d(true);
          i4 -= i3;
          i3 = i1;
          i1 = i4;
          for (;;)
          {
            i8 = i7 + 1;
            i7 = i3;
            i3 = i5;
            i4 = i1;
            i1 = i7;
            i7 = i8;
            break;
            ((View)localObject2).measure(i10, i10);
            i5 = i3;
            break label304;
            if (locals.j())
            {
              int i11 = locals.getGroupId();
              boolean bool = ((SparseBooleanArray)localObject1).get(i11);
              int i12;
              if (((i1 > 0) || (bool)) && (i4 > 0) && ((!this.p) || (i3 > 0)))
              {
                i12 = 1;
                if (i12 == 0) {
                  break label775;
                }
                localObject2 = a(locals, this.u, localViewGroup);
                if (this.u == null) {
                  this.u = ((View)localObject2);
                }
                if (!this.p) {
                  break label632;
                }
                i5 = ActionMenuView.a((View)localObject2, i6, i3, i10, 0);
                if (i5 != 0) {
                  break label772;
                }
                i12 = 0;
                i3 -= i5;
                i5 = ((View)localObject2).getMeasuredWidth();
                i8 = i4 - i5;
                i4 = i2;
                if (i2 == 0) {
                  i4 = i5;
                }
                if (!this.p) {
                  break label649;
                }
                if (i8 < 0) {
                  break label644;
                }
                i2 = 1;
                i12 &= i2;
                i2 = i4;
                i5 = i3;
                i4 = i8;
                i3 = i2;
                i2 = i5;
              }
              for (;;)
              {
                if ((i12 != 0) && (i11 != 0)) {
                  ((SparseBooleanArray)localObject1).put(i11, true);
                }
                for (;;)
                {
                  i5 = i1;
                  if (i12 != 0) {
                    i5 = i1 - 1;
                  }
                  locals.d(i12);
                  i1 = i4;
                  i4 = i5;
                  i5 = i2;
                  i2 = i3;
                  i3 = i4;
                  break;
                  int i13 = 0;
                  break label445;
                  ((View)localObject2).measure(i10, i10);
                  break label510;
                  i2 = 0;
                  break label549;
                  if (i8 + i4 > 0) {}
                  for (i2 = 1;; i2 = 0)
                  {
                    i13 &= i2;
                    i2 = i3;
                    i3 = i4;
                    i4 = i8;
                    break;
                  }
                  if (bool)
                  {
                    ((SparseBooleanArray)localObject1).put(i11, false);
                    i8 = 0;
                    while (i8 < i7)
                    {
                      localObject2 = (s)localArrayList.get(i8);
                      i5 = i1;
                      if (((s)localObject2).getGroupId() == i11)
                      {
                        i5 = i1;
                        if (((s)localObject2).i()) {
                          i5 = i1 + 1;
                        }
                        ((s)localObject2).d(false);
                      }
                      i8 += 1;
                      i1 = i5;
                      continue;
                      return true;
                    }
                  }
                }
                break label505;
                i5 = i2;
                i2 = i3;
                i3 = i5;
              }
            }
            i5 = i4;
            i4 = i1;
            i1 = i5;
            i5 = i3;
            i3 = i4;
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/view/menu/ActionMenuPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */