package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.b.c;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;

public class ListPopupWindow
{
  private boolean A;
  int a = Integer.MAX_VALUE;
  private Context b;
  private PopupWindow c;
  private ListAdapter d;
  private s e;
  private int f = -2;
  private int g = -2;
  private int h;
  private int i;
  private boolean j;
  private boolean k = false;
  private boolean l = false;
  private View m;
  private int n = 0;
  private DataSetObserver o;
  private View p;
  private Drawable q;
  private AdapterView.OnItemClickListener r;
  private AdapterView.OnItemSelectedListener s;
  private final x t = new x(this, null);
  private final w u = new w(this, null);
  private final v v = new v(this, null);
  private final t w = new t(this, null);
  private Runnable x;
  private Handler y = new Handler();
  private Rect z = new Rect();
  
  public ListPopupWindow(Context paramContext)
  {
    this(paramContext, null, c.listPopupWindowStyle);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this.b = paramContext;
    this.c = new PopupWindow(paramContext, paramAttributeSet, paramInt);
    this.c.setInputMethodMode(1);
    paramContext = this.b.getResources().getConfiguration().locale;
  }
  
  private void i()
  {
    if (this.m != null)
    {
      ViewParent localViewParent = this.m.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.m);
      }
    }
  }
  
  private int j()
  {
    boolean bool2 = true;
    Object localObject2;
    boolean bool1;
    Object localObject1;
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    label252:
    int i1;
    int i2;
    if (this.e == null)
    {
      localObject2 = this.b;
      this.x = new Runnable()
      {
        public void run()
        {
          View localView = ListPopupWindow.this.b();
          if ((localView != null) && (localView.getWindowToken() != null)) {
            ListPopupWindow.this.c();
          }
        }
      };
      if (!this.A)
      {
        bool1 = true;
        this.e = new s((Context)localObject2, bool1);
        if (this.q != null) {
          this.e.setSelector(this.q);
        }
        this.e.setAdapter(this.d);
        this.e.setOnItemClickListener(this.r);
        this.e.setFocusable(true);
        this.e.setFocusableInTouchMode(true);
        this.e.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
          public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            if (paramAnonymousInt != -1)
            {
              paramAnonymousAdapterView = ListPopupWindow.a(ListPopupWindow.this);
              if (paramAnonymousAdapterView != null) {
                s.a(paramAnonymousAdapterView, false);
              }
            }
          }
          
          public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
        });
        this.e.setOnScrollListener(this.v);
        if (this.s != null) {
          this.e.setOnItemSelectedListener(this.s);
        }
        localObject1 = this.e;
        localView = this.m;
        if (localView == null) {
          break label697;
        }
        localObject2 = new LinearLayout((Context)localObject2);
        ((LinearLayout)localObject2).setOrientation(1);
        localLayoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        switch (this.n)
        {
        default: 
          Log.e("ListPopupWindow", "Invalid hint position " + this.n);
          localView.measure(View.MeasureSpec.makeMeasureSpec(this.g, Integer.MIN_VALUE), 0);
          localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
          i1 = localView.getMeasuredHeight();
          i2 = ((LinearLayout.LayoutParams)localObject1).topMargin;
          i1 = ((LinearLayout.LayoutParams)localObject1).bottomMargin + (i1 + i2);
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      this.c.setContentView((View)localObject1);
      for (;;)
      {
        label312:
        localObject1 = this.c.getBackground();
        if (localObject1 != null)
        {
          ((Drawable)localObject1).getPadding(this.z);
          i2 = this.z.top + this.z.bottom;
          if (this.j) {
            break label689;
          }
          this.i = (-this.z.top);
        }
        label371:
        label542:
        label689:
        for (;;)
        {
          if (this.c.getInputMethodMode() == 2) {}
          int i4;
          for (bool1 = bool2;; bool1 = false)
          {
            i4 = a(b(), this.i, bool1);
            if ((!this.k) && (this.f != -1)) {
              break label542;
            }
            return i4 + i2;
            bool1 = false;
            break;
            ((LinearLayout)localObject2).addView((View)localObject1, localLayoutParams);
            ((LinearLayout)localObject2).addView(localView);
            break label252;
            ((LinearLayout)localObject2).addView(localView);
            ((LinearLayout)localObject2).addView((View)localObject1, localLayoutParams);
            break label252;
            localObject1 = (ViewGroup)this.c.getContentView();
            localObject1 = this.m;
            if (localObject1 == null) {
              break label692;
            }
            localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
            i1 = ((View)localObject1).getMeasuredHeight();
            i2 = ((LinearLayout.LayoutParams)localObject2).topMargin;
            i1 = ((LinearLayout.LayoutParams)localObject2).bottomMargin + (i1 + i2);
            break label312;
            this.z.setEmpty();
            i2 = 0;
            break label371;
          }
          int i3;
          switch (this.g)
          {
          default: 
            i3 = View.MeasureSpec.makeMeasureSpec(this.g, 1073741824);
          }
          for (;;)
          {
            i4 = this.e.a(i3, 0, -1, i4 - i1, -1);
            i3 = i1;
            if (i4 > 0) {
              i3 = i1 + i2;
            }
            return i4 + i3;
            i3 = View.MeasureSpec.makeMeasureSpec(this.b.getResources().getDisplayMetrics().widthPixels - (this.z.left + this.z.right), Integer.MIN_VALUE);
            continue;
            i3 = View.MeasureSpec.makeMeasureSpec(this.b.getResources().getDisplayMetrics().widthPixels - (this.z.left + this.z.right), 1073741824);
          }
        }
        label692:
        i1 = 0;
      }
      label697:
      i1 = 0;
    }
  }
  
  public int a(View paramView, int paramInt, boolean paramBoolean)
  {
    Rect localRect = new Rect();
    paramView.getWindowVisibleDisplayFrame(localRect);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i1 = localRect.bottom;
    if (paramBoolean) {
      i1 = paramView.getContext().getResources().getDisplayMetrics().heightPixels;
    }
    i1 = Math.max(i1 - (arrayOfInt[1] + paramView.getHeight()) - paramInt, arrayOfInt[1] - localRect.top + paramInt);
    paramInt = i1;
    if (this.c.getBackground() != null)
    {
      this.c.getBackground().getPadding(this.z);
      paramInt = i1 - (this.z.top + this.z.bottom);
    }
    return paramInt;
  }
  
  public Drawable a()
  {
    return this.c.getBackground();
  }
  
  public void a(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void a(Drawable paramDrawable)
  {
    this.c.setBackgroundDrawable(paramDrawable);
  }
  
  public void a(View paramView)
  {
    this.p = paramView;
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.r = paramOnItemClickListener;
  }
  
  public void a(ListAdapter paramListAdapter)
  {
    if (this.o == null) {
      this.o = new u(this, null);
    }
    for (;;)
    {
      this.d = paramListAdapter;
      if (this.d != null) {
        paramListAdapter.registerDataSetObserver(this.o);
      }
      if (this.e != null) {
        this.e.setAdapter(this.d);
      }
      return;
      if (this.d != null) {
        this.d.unregisterDataSetObserver(this.o);
      }
    }
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.c.setOnDismissListener(paramOnDismissListener);
  }
  
  public void a(boolean paramBoolean)
  {
    this.A = true;
    this.c.setFocusable(paramBoolean);
  }
  
  public View b()
  {
    return this.p;
  }
  
  public void b(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void c()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    int i3 = -1;
    int i2 = j();
    boolean bool3 = g();
    int i1;
    label52:
    PopupWindow localPopupWindow;
    if (this.c.isShowing())
    {
      if (this.g == -1)
      {
        i1 = -1;
        if (this.f != -1) {
          break label207;
        }
        if (!bool3) {
          break label166;
        }
        if (!bool3) {
          break label176;
        }
        localPopupWindow = this.c;
        if (this.g != -1) {
          break label171;
        }
        label71:
        localPopupWindow.setWindowLayoutMode(i3, 0);
      }
      for (;;)
      {
        localPopupWindow = this.c;
        bool1 = bool2;
        if (!this.l)
        {
          bool1 = bool2;
          if (!this.k) {
            bool1 = true;
          }
        }
        localPopupWindow.setOutsideTouchable(bool1);
        this.c.update(b(), this.h, this.i, i1, i2);
        return;
        if (this.g == -2)
        {
          i1 = b().getWidth();
          break;
        }
        i1 = this.g;
        break;
        label166:
        i2 = -1;
        break label52;
        label171:
        i3 = 0;
        break label71;
        label176:
        localPopupWindow = this.c;
        if (this.g == -1) {}
        for (i3 = -1;; i3 = 0)
        {
          localPopupWindow.setWindowLayoutMode(i3, -1);
          break;
        }
        label207:
        if (this.f != -2) {
          i2 = this.f;
        }
      }
    }
    if (this.g == -1)
    {
      i1 = -1;
      label234:
      if (this.f != -1) {
        break label403;
      }
      i2 = -1;
      label244:
      this.c.setWindowLayoutMode(i1, i2);
      localPopupWindow = this.c;
      if ((this.l) || (this.k)) {
        break label441;
      }
    }
    for (;;)
    {
      localPopupWindow.setOutsideTouchable(bool1);
      this.c.setTouchInterceptor(this.u);
      this.c.showAsDropDown(b(), this.h, this.i);
      this.e.setSelection(-1);
      if ((!this.A) || (this.e.isInTouchMode())) {
        e();
      }
      if (this.A) {
        break;
      }
      this.y.post(this.w);
      return;
      if (this.g == -2)
      {
        this.c.setWidth(b().getWidth());
        i1 = 0;
        break label234;
      }
      this.c.setWidth(this.g);
      i1 = 0;
      break label234;
      label403:
      if (this.f == -2)
      {
        this.c.setHeight(i2);
        i2 = 0;
        break label244;
      }
      this.c.setHeight(this.f);
      i2 = 0;
      break label244;
      label441:
      bool1 = false;
    }
  }
  
  public void c(int paramInt)
  {
    this.i = paramInt;
    this.j = true;
  }
  
  public void d()
  {
    this.c.dismiss();
    i();
    this.c.setContentView(null);
    this.e = null;
    this.y.removeCallbacks(this.t);
  }
  
  public void d(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void e()
  {
    s locals = this.e;
    if (locals != null)
    {
      s.a(locals, true);
      locals.requestLayout();
    }
  }
  
  public void e(int paramInt)
  {
    Drawable localDrawable = this.c.getBackground();
    if (localDrawable != null)
    {
      localDrawable.getPadding(this.z);
      this.g = (this.z.left + this.z.right + paramInt);
      return;
    }
    d(paramInt);
  }
  
  public void f(int paramInt)
  {
    this.c.setInputMethodMode(paramInt);
  }
  
  public boolean f()
  {
    return this.c.isShowing();
  }
  
  public void g(int paramInt)
  {
    s locals = this.e;
    if ((f()) && (locals != null))
    {
      s.a(locals, false);
      locals.setSelection(paramInt);
      if (locals.getChoiceMode() != 0) {
        locals.setItemChecked(paramInt, true);
      }
    }
  }
  
  public boolean g()
  {
    return this.c.getInputMethodMode() == 2;
  }
  
  public ListView h()
  {
    return this.e;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/widget/ListPopupWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */