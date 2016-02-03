package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.b.c;
import android.support.v7.b.e;
import android.support.v7.b.h;
import android.support.v7.internal.widget.ListPopupWindow;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;

public class z
  implements ab, View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  static final int b = h.abc_popup_menu_item_layout;
  private Context a;
  boolean c;
  private LayoutInflater d;
  private ListPopupWindow e;
  private o f;
  private int g;
  private View h;
  private boolean i;
  private ViewTreeObserver j;
  private aa k;
  private ac l;
  private ViewGroup m;
  
  public z(Context paramContext, o paramo, View paramView, boolean paramBoolean)
  {
    this.a = paramContext;
    this.d = LayoutInflater.from(paramContext);
    this.f = paramo;
    this.i = paramBoolean;
    paramContext = paramContext.getResources();
    this.g = Math.max(paramContext.getDisplayMetrics().widthPixels / 2, paramContext.getDimensionPixelSize(e.abc_config_prefDialogWidth));
    this.h = paramView;
    paramo.a(this);
  }
  
  private int a(ListAdapter paramListAdapter)
  {
    int i4 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i5 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i6 = paramListAdapter.getCount();
    int i1 = 0;
    int n = 0;
    View localView = null;
    int i2 = 0;
    if (i1 < i6)
    {
      int i3 = paramListAdapter.getItemViewType(i1);
      if (i3 == n) {
        break label127;
      }
      localView = null;
      n = i3;
    }
    label127:
    for (;;)
    {
      if (this.m == null) {
        this.m = new FrameLayout(this.a);
      }
      localView = paramListAdapter.getView(i1, localView, this.m);
      localView.measure(i4, i5);
      i2 = Math.max(i2, localView.getMeasuredWidth());
      i1 += 1;
      break;
      return i2;
    }
  }
  
  public void a(Context paramContext, o paramo) {}
  
  public void a(ac paramac)
  {
    this.l = paramac;
  }
  
  public void a(o paramo, boolean paramBoolean)
  {
    if (paramo != this.f) {}
    do
    {
      return;
      b();
    } while (this.l == null);
    this.l.a(paramo, paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean a()
  {
    int n = 0;
    this.e = new ListPopupWindow(this.a, null, c.popupMenuStyle);
    this.e.a(this);
    this.e.a(this);
    this.k = new aa(this, this.f);
    this.e.a(this.k);
    this.e.a(true);
    View localView = this.h;
    if (localView != null)
    {
      if (this.j == null) {
        n = 1;
      }
      this.j = localView.getViewTreeObserver();
      if (n != 0) {
        this.j.addOnGlobalLayoutListener(this);
      }
      this.e.a(localView);
      this.e.e(Math.min(a(this.k), this.g));
      this.e.f(2);
      this.e.c();
      this.e.h().setOnKeyListener(this);
      return true;
    }
    return false;
  }
  
  public boolean a(ah paramah)
  {
    z localz;
    int n;
    if (paramah.hasVisibleItems())
    {
      localz = new z(this.a, paramah, this.h, false);
      localz.a(this.l);
      int i1 = paramah.size();
      n = 0;
      if (n >= i1) {
        break label121;
      }
      MenuItem localMenuItem = paramah.getItem(n);
      if ((!localMenuItem.isVisible()) || (localMenuItem.getIcon() == null)) {}
    }
    label121:
    for (boolean bool = true;; bool = false)
    {
      localz.a(bool);
      if (localz.a())
      {
        if (this.l != null) {
          this.l.b(paramah);
        }
        return true;
        n += 1;
        break;
      }
      return false;
    }
  }
  
  public boolean a(o paramo, s params)
  {
    return false;
  }
  
  public void b()
  {
    if (c()) {
      this.e.d();
    }
  }
  
  public boolean b(o paramo, s params)
  {
    return false;
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.k != null) {
      this.k.notifyDataSetChanged();
    }
  }
  
  public boolean c()
  {
    return (this.e != null) && (this.e.f());
  }
  
  public boolean g()
  {
    return false;
  }
  
  public void onDismiss()
  {
    this.e = null;
    this.f.close();
    if (this.j != null)
    {
      if (!this.j.isAlive()) {
        this.j = this.h.getViewTreeObserver();
      }
      this.j.removeGlobalOnLayoutListener(this);
      this.j = null;
    }
  }
  
  public void onGlobalLayout()
  {
    if (c())
    {
      View localView = this.h;
      if ((localView != null) && (localView.isShown())) {
        break label28;
      }
      b();
    }
    label28:
    while (!c()) {
      return;
    }
    this.e.c();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.k;
    aa.a(paramAdapterView).a(paramAdapterView.a(paramInt), 0);
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      b();
      return true;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/view/menu/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */