package android.support.v7.internal.widget;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.b.a.b;
import android.support.v7.b.f;
import android.support.v7.b.h;
import android.support.v7.b.i;
import android.support.v7.b.k;
import android.support.v7.internal.view.menu.ActionMenuPresenter;
import android.support.v7.internal.view.menu.ActionMenuView;
import android.support.v7.internal.view.menu.o;
import android.support.v7.internal.view.menu.s;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window.Callback;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class ActionBarView
  extends a
{
  private ProgressBarICS A;
  private int B;
  private int C;
  private int D;
  private int E;
  private int F;
  private int G;
  private boolean H;
  private boolean I;
  private boolean J;
  private boolean K;
  private o L;
  private ActionBarContextView M;
  private android.support.v7.internal.view.menu.a N;
  private SpinnerAdapter O;
  private android.support.v7.a.d P;
  private Runnable Q;
  private c R;
  private final p S = new p()
  {
    public void a(l<?> paramAnonymousl) {}
    
    public void a(l<?> paramAnonymousl, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      if (ActionBarView.a(ActionBarView.this) != null) {
        ActionBarView.a(ActionBarView.this).a(paramAnonymousInt, paramAnonymousLong);
      }
    }
  };
  private final View.OnClickListener T = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      paramAnonymousView = ActionBarView.b(ActionBarView.this).b;
      if (paramAnonymousView != null) {
        paramAnonymousView.collapseActionView();
      }
    }
  };
  private final View.OnClickListener U = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      ActionBarView.this.h.onMenuItemSelected(0, ActionBarView.c(ActionBarView.this));
    }
  };
  View g;
  Window.Callback h;
  private int i;
  private int j = -1;
  private CharSequence k;
  private CharSequence l;
  private Drawable m;
  private Drawable n;
  private Context o;
  private ActionBarView.HomeView p;
  private ActionBarView.HomeView q;
  private LinearLayout r;
  private TextView s;
  private TextView t;
  private View u;
  private ac v;
  private LinearLayout w;
  private ScrollingTabContainerView x;
  private View y;
  private ProgressBarICS z;
  
  public ActionBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.o = paramContext;
    setBackgroundResource(0);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, k.ActionBar, android.support.v7.b.c.actionBarStyle, 0);
    Object localObject = paramContext.getApplicationInfo();
    PackageManager localPackageManager = paramContext.getPackageManager();
    this.i = paramAttributeSet.getInt(2, 0);
    this.k = paramAttributeSet.getText(0);
    this.l = paramAttributeSet.getText(4);
    this.n = paramAttributeSet.getDrawable(8);
    if ((this.n != null) || (Build.VERSION.SDK_INT < 9) || ((paramContext instanceof Activity))) {}
    try
    {
      this.n = localPackageManager.getActivityLogo(((Activity)paramContext).getComponentName());
      if (this.n == null) {
        this.n = ((ApplicationInfo)localObject).loadLogo(localPackageManager);
      }
      this.m = paramAttributeSet.getDrawable(7);
      if (this.m == null) {
        if (!(paramContext instanceof Activity)) {}
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException1)
    {
      try
      {
        this.m = localPackageManager.getActivityIcon(((Activity)paramContext).getComponentName());
        if (this.m == null) {
          this.m = ((ApplicationInfo)localObject).loadIcon(localPackageManager);
        }
        localObject = LayoutInflater.from(paramContext);
        int i1 = paramAttributeSet.getResourceId(14, h.abc_action_bar_home);
        this.p = ((ActionBarView.HomeView)((LayoutInflater)localObject).inflate(i1, this, false));
        this.q = ((ActionBarView.HomeView)((LayoutInflater)localObject).inflate(i1, this, false));
        this.q.a(true);
        this.q.setOnClickListener(this.T);
        this.q.setContentDescription(getResources().getText(i.abc_action_bar_up_description));
        this.D = paramAttributeSet.getResourceId(5, 0);
        this.E = paramAttributeSet.getResourceId(6, 0);
        this.F = paramAttributeSet.getResourceId(15, 0);
        this.G = paramAttributeSet.getResourceId(16, 0);
        this.B = paramAttributeSet.getDimensionPixelOffset(17, 0);
        this.C = paramAttributeSet.getDimensionPixelOffset(18, 0);
        setDisplayOptions(paramAttributeSet.getInt(3, 0));
        i1 = paramAttributeSet.getResourceId(13, 0);
        if (i1 != 0)
        {
          this.y = ((LayoutInflater)localObject).inflate(i1, this, false);
          this.i = 0;
          setDisplayOptions(this.j | 0x10);
        }
        this.f = paramAttributeSet.getLayoutDimension(1, 0);
        paramAttributeSet.recycle();
        this.N = new android.support.v7.internal.view.menu.a(paramContext, 0, 16908332, 0, 0, this.k);
        this.p.setOnClickListener(this.U);
        this.p.setClickable(true);
        this.p.setFocusable(true);
        return;
        localNameNotFoundException1 = localNameNotFoundException1;
        Log.e("ActionBarView", "Activity component name not found!", localNameNotFoundException1);
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException2)
      {
        for (;;)
        {
          Log.e("ActionBarView", "Activity component name not found!", localNameNotFoundException2);
        }
      }
    }
  }
  
  private void a(o paramo)
  {
    if (paramo != null)
    {
      paramo.a(this.b);
      paramo.a(this.R);
    }
    for (;;)
    {
      this.b.c(true);
      this.R.c(true);
      return;
      this.b.a(this.o, null);
      this.R.a(this.o, null);
    }
  }
  
  private void l()
  {
    boolean bool = true;
    int i2;
    int i3;
    label201:
    Object localObject;
    int i1;
    if (this.r == null)
    {
      this.r = ((LinearLayout)LayoutInflater.from(getContext()).inflate(h.abc_action_bar_title_item, this, false));
      this.s = ((TextView)this.r.findViewById(f.action_bar_title));
      this.t = ((TextView)this.r.findViewById(f.action_bar_subtitle));
      this.u = this.r.findViewById(f.up);
      this.r.setOnClickListener(this.U);
      if (this.D != 0) {
        this.s.setTextAppearance(this.o, this.D);
      }
      if (this.k != null) {
        this.s.setText(this.k);
      }
      if (this.E != 0) {
        this.t.setTextAppearance(this.o, this.E);
      }
      if (this.l != null)
      {
        this.t.setText(this.l);
        this.t.setVisibility(0);
      }
      if ((this.j & 0x4) == 0) {
        break label289;
      }
      i2 = 1;
      if ((this.j & 0x2) == 0) {
        break label294;
      }
      i3 = 1;
      localObject = this.u;
      if (i3 != 0) {
        break label304;
      }
      if (i2 == 0) {
        break label299;
      }
      i1 = 0;
      label217:
      ((View)localObject).setVisibility(i1);
      localObject = this.r;
      if ((i2 == 0) || (i3 != 0)) {
        break label310;
      }
    }
    for (;;)
    {
      ((LinearLayout)localObject).setEnabled(bool);
      addView(this.r);
      if ((this.g != null) || ((TextUtils.isEmpty(this.k)) && (TextUtils.isEmpty(this.l)))) {
        this.r.setVisibility(8);
      }
      return;
      label289:
      i2 = 0;
      break;
      label294:
      i3 = 0;
      break label201;
      label299:
      i1 = 4;
      break label217;
      label304:
      i1 = 8;
      break label217;
      label310:
      bool = false;
    }
  }
  
  private void setTitleImpl(CharSequence paramCharSequence)
  {
    int i2 = 0;
    this.k = paramCharSequence;
    LinearLayout localLinearLayout;
    if (this.s != null)
    {
      this.s.setText(paramCharSequence);
      if ((this.g != null) || ((this.j & 0x8) == 0) || ((TextUtils.isEmpty(this.k)) && (TextUtils.isEmpty(this.l)))) {
        break label96;
      }
      i1 = 1;
      localLinearLayout = this.r;
      if (i1 == 0) {
        break label101;
      }
    }
    label96:
    label101:
    for (int i1 = i2;; i1 = 8)
    {
      localLinearLayout.setVisibility(i1);
      if (this.N != null) {
        this.N.setTitle(paramCharSequence);
      }
      return;
      i1 = 0;
      break;
    }
  }
  
  public void a(android.support.v4.b.a.a parama, android.support.v7.internal.view.menu.ac paramac)
  {
    if (parama == this.L) {
      return;
    }
    if (this.L != null)
    {
      this.L.b(this.b);
      this.L.b(this.R);
    }
    Object localObject = (o)parama;
    this.L = ((o)localObject);
    if (this.a != null)
    {
      parama = (ViewGroup)this.a.getParent();
      if (parama != null) {
        parama.removeView(this.a);
      }
    }
    if (this.b == null)
    {
      this.b = new ActionMenuPresenter(this.o);
      this.b.a(paramac);
      this.b.b(f.action_menu_presenter);
      this.R = new c(this, null);
    }
    paramac = new ViewGroup.LayoutParams(-2, -1);
    if (!this.d)
    {
      this.b.b(getResources().getBoolean(android.support.v7.b.d.abc_action_bar_expanded_action_views_exclusive));
      a((o)localObject);
      parama = (ActionMenuView)this.b.a(this);
      parama.a((o)localObject);
      localObject = (ViewGroup)parama.getParent();
      if ((localObject != null) && (localObject != this)) {
        ((ViewGroup)localObject).removeView(parama);
      }
      addView(parama, paramac);
    }
    for (;;)
    {
      this.a = parama;
      return;
      this.b.b(false);
      this.b.a(getContext().getResources().getDisplayMetrics().widthPixels, true);
      this.b.a(Integer.MAX_VALUE);
      paramac.width = -1;
      a((o)localObject);
      parama = (ActionMenuView)this.b.a(this);
      if (this.c != null)
      {
        localObject = (ViewGroup)parama.getParent();
        if ((localObject != null) && (localObject != this.c)) {
          ((ViewGroup)localObject).removeView(parama);
        }
        parama.setVisibility(getAnimatedVisibility());
        this.c.addView(parama, paramac);
      }
      else
      {
        parama.setLayoutParams(paramac);
      }
    }
  }
  
  public void f()
  {
    this.z = new ProgressBarICS(this.o, null, 0, this.F);
    this.z.setId(f.progress_horizontal);
    this.z.setMax(10000);
    this.z.setVisibility(8);
    addView(this.z);
  }
  
  public void g()
  {
    this.A = new ProgressBarICS(this.o, null, 0, this.G);
    this.A.setId(f.progress_circular);
    this.A.setVisibility(8);
    addView(this.A);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new android.support.v7.a.c(19);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new android.support.v7.a.c(getContext(), paramAttributeSet);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    ViewGroup.LayoutParams localLayoutParams = paramLayoutParams;
    if (paramLayoutParams == null) {
      localLayoutParams = generateDefaultLayoutParams();
    }
    return localLayoutParams;
  }
  
  public View getCustomNavigationView()
  {
    return this.y;
  }
  
  public int getDisplayOptions()
  {
    return this.j;
  }
  
  public SpinnerAdapter getDropdownAdapter()
  {
    return this.O;
  }
  
  public int getDropdownSelectedPosition()
  {
    return this.v.f();
  }
  
  public int getNavigationMode()
  {
    return this.i;
  }
  
  public CharSequence getSubtitle()
  {
    return this.l;
  }
  
  public CharSequence getTitle()
  {
    return this.k;
  }
  
  public boolean h()
  {
    return this.d;
  }
  
  public boolean i()
  {
    return (this.R != null) && (this.R.b != null);
  }
  
  public void j()
  {
    if (this.R == null) {}
    for (s locals = null;; locals = this.R.b)
    {
      if (locals != null) {
        locals.collapseActionView();
      }
      return;
    }
  }
  
  public boolean k()
  {
    return this.K;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.s = null;
    this.t = null;
    this.u = null;
    if ((this.r != null) && (this.r.getParent() == this)) {
      removeView(this.r);
    }
    this.r = null;
    if ((this.j & 0x8) != 0) {
      l();
    }
    if ((this.x != null) && (this.I))
    {
      paramConfiguration = this.x.getLayoutParams();
      if (paramConfiguration != null)
      {
        paramConfiguration.width = -2;
        paramConfiguration.height = -1;
      }
      this.x.setAllowCollapse(true);
    }
    if (this.z != null)
    {
      removeView(this.z);
      f();
    }
    if (this.A != null)
    {
      removeView(this.A);
      g();
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.Q);
    if (this.b != null)
    {
      this.b.b();
      this.b.d();
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    addView(this.p);
    if ((this.y != null) && ((this.j & 0x10) != 0))
    {
      ViewParent localViewParent = this.y.getParent();
      if (localViewParent != this)
      {
        if ((localViewParent instanceof ViewGroup)) {
          ((ViewGroup)localViewParent).removeView(this.y);
        }
        addView(this.y);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = getPaddingLeft();
    int i3 = getPaddingTop();
    int i4 = paramInt4 - paramInt2 - getPaddingTop() - getPaddingBottom();
    if (i4 <= 0) {
      return;
    }
    Object localObject1;
    if (this.g != null)
    {
      localObject1 = this.q;
      label47:
      if (((ActionBarView.HomeView)localObject1).getVisibility() == 8) {
        break label898;
      }
      paramInt2 = ((ActionBarView.HomeView)localObject1).a();
    }
    label127:
    label187:
    label190:
    label307:
    label334:
    label346:
    label427:
    label466:
    label608:
    label747:
    label753:
    label874:
    label877:
    label889:
    label898:
    for (paramInt4 = b((View)localObject1, i1 + paramInt2, i3, i4) + paramInt2 + i1;; paramInt4 = i1)
    {
      i1 = paramInt4;
      int i2;
      if (this.g == null)
      {
        if ((this.r == null) || (this.r.getVisibility() == 8) || ((this.j & 0x8) == 0)) {
          break label608;
        }
        i2 = 1;
        paramInt2 = paramInt4;
        if (i2 != 0) {
          paramInt2 = paramInt4 + b(this.r, paramInt4, i3, i4);
        }
      }
      switch (this.i)
      {
      default: 
        i1 = paramInt2;
        paramInt2 = i1;
        paramInt3 = paramInt3 - paramInt1 - getPaddingRight();
        paramInt1 = paramInt3;
        if (this.a != null)
        {
          paramInt1 = paramInt3;
          if (this.a.getParent() == this)
          {
            c(this.a, paramInt3, i3, i4);
            paramInt1 = paramInt3 - this.a.getMeasuredWidth();
          }
        }
        if ((this.A != null) && (this.A.getVisibility() != 8))
        {
          c(this.A, paramInt1, i3, i4);
          paramInt1 -= this.A.getMeasuredWidth();
        }
        break;
      }
      for (;;)
      {
        if (this.g != null) {
          localObject1 = this.g;
        }
        for (;;)
        {
          Object localObject2;
          if (localObject1 != null)
          {
            localObject2 = ((View)localObject1).getLayoutParams();
            if (!(localObject2 instanceof android.support.v7.a.c)) {
              break label747;
            }
            localObject2 = (android.support.v7.a.c)localObject2;
            if (localObject2 == null) {
              break label753;
            }
            paramInt3 = ((android.support.v7.a.c)localObject2).a;
            i3 = ((View)localObject1).getMeasuredWidth();
            if (localObject2 == null) {
              break label877;
            }
            i4 = ((android.support.v7.a.c)localObject2).leftMargin;
            i2 = ((android.support.v7.a.c)localObject2).rightMargin;
            i1 = ((android.support.v7.a.c)localObject2).topMargin;
            paramInt4 = ((android.support.v7.a.c)localObject2).bottomMargin;
            i2 = paramInt1 - i2;
            paramInt2 += i4;
          }
          for (;;)
          {
            paramInt1 = paramInt3 & 0x7;
            if (paramInt1 == 1)
            {
              i4 = (getWidth() - i3) / 2;
              if (i4 < paramInt2) {
                paramInt1 = 3;
              }
            }
            for (;;)
            {
              switch (paramInt1)
              {
              case 2: 
              case 4: 
              default: 
                paramInt1 = 0;
                paramInt2 = paramInt3 & 0x70;
                if (paramInt3 == -1) {
                  paramInt2 = 16;
                }
                paramInt3 = 0;
                switch (paramInt2)
                {
                default: 
                  paramInt2 = paramInt3;
                }
                break;
              }
              for (;;)
              {
                paramInt3 = ((View)localObject1).getMeasuredWidth();
                ((View)localObject1).layout(paramInt1, paramInt2, paramInt1 + paramInt3, ((View)localObject1).getMeasuredHeight() + paramInt2);
                if (this.z == null) {
                  break;
                }
                this.z.bringToFront();
                paramInt1 = this.z.getMeasuredHeight() / 2;
                this.z.layout(this.B, -paramInt1, this.B + this.z.getMeasuredWidth(), paramInt1);
                return;
                localObject1 = this.p;
                break label47;
                i2 = 0;
                break label127;
                break label190;
                i1 = paramInt2;
                if (this.w == null) {
                  break label187;
                }
                paramInt4 = paramInt2;
                if (i2 != 0) {
                  paramInt4 = paramInt2 + this.C;
                }
                paramInt2 = paramInt4 + (b(this.w, paramInt4, i3, i4) + this.C);
                break label190;
                i1 = paramInt2;
                if (this.x == null) {
                  break label187;
                }
                paramInt4 = paramInt2;
                if (i2 != 0) {
                  paramInt4 = paramInt2 + this.C;
                }
                paramInt2 = paramInt4 + (b(this.x, paramInt4, i3, i4) + this.C);
                break label190;
                if (((this.j & 0x10) == 0) || (this.y == null)) {
                  break label889;
                }
                localObject1 = this.y;
                break label307;
                localObject2 = null;
                break label334;
                paramInt3 = 19;
                break label346;
                if (i4 + i3 <= i2) {
                  break label427;
                }
                paramInt1 = 5;
                break label427;
                if (paramInt3 != -1) {
                  break label874;
                }
                paramInt1 = 3;
                break label427;
                paramInt1 = (getWidth() - i3) / 2;
                break label466;
                paramInt1 = paramInt2;
                break label466;
                paramInt1 = i2 - i3;
                break label466;
                paramInt2 = getPaddingTop();
                paramInt2 = (getHeight() - getPaddingBottom() - paramInt2 - ((View)localObject1).getMeasuredHeight()) / 2;
                continue;
                paramInt2 = getPaddingTop() + i1;
                continue;
                paramInt2 = getHeight() - getPaddingBottom() - ((View)localObject1).getMeasuredHeight() - paramInt4;
              }
            }
            i1 = 0;
            paramInt4 = 0;
            i2 = paramInt1;
          }
          localObject1 = null;
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i9 = getChildCount();
    int i2;
    int i1;
    Object localObject1;
    int i3;
    if (this.J)
    {
      i2 = 0;
      i1 = 0;
      while (i1 < i9)
      {
        localObject1 = getChildAt(i1);
        i3 = i2;
        if (((View)localObject1).getVisibility() != 8) {
          if (localObject1 == this.a)
          {
            i3 = i2;
            if (this.a.getChildCount() == 0) {}
          }
          else
          {
            i3 = i2 + 1;
          }
        }
        i1 += 1;
        i2 = i3;
      }
      if (i2 == 0)
      {
        setMeasuredDimension(0, 0);
        this.K = true;
        return;
      }
    }
    this.K = false;
    if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"MATCH_PARENT\" (or fill_parent)");
    }
    if (View.MeasureSpec.getMode(paramInt2) != Integer.MIN_VALUE) {
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
    }
    int i10 = View.MeasureSpec.getSize(paramInt1);
    label226:
    int i11;
    int i8;
    int i5;
    int i4;
    label289:
    Object localObject2;
    if (this.f > 0)
    {
      i3 = this.f;
      i11 = getPaddingTop() + getPaddingBottom();
      paramInt1 = getPaddingLeft();
      paramInt2 = getPaddingRight();
      i8 = i3 - i11;
      i5 = View.MeasureSpec.makeMeasureSpec(i8, Integer.MIN_VALUE);
      paramInt2 = i10 - paramInt1 - paramInt2;
      i4 = paramInt2 / 2;
      if (this.g == null) {
        break label902;
      }
      localObject1 = this.q;
      if (((ActionBarView.HomeView)localObject1).getVisibility() == 8) {
        break label1303;
      }
      localObject2 = ((ActionBarView.HomeView)localObject1).getLayoutParams();
      if (((ViewGroup.LayoutParams)localObject2).width >= 0) {
        break label911;
      }
      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, Integer.MIN_VALUE);
      label322:
      ((ActionBarView.HomeView)localObject1).measure(paramInt1, View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
      paramInt1 = ((ActionBarView.HomeView)localObject1).getMeasuredWidth();
      paramInt1 = ((ActionBarView.HomeView)localObject1).a() + paramInt1;
      paramInt2 = Math.max(0, paramInt2 - paramInt1);
    }
    label517:
    label552:
    label571:
    label604:
    label654:
    label704:
    label723:
    label746:
    label861:
    label902:
    label911:
    label1148:
    label1154:
    label1178:
    label1186:
    label1192:
    label1287:
    label1290:
    label1297:
    label1303:
    for (paramInt1 = Math.max(0, paramInt2 - paramInt1);; paramInt1 = i4)
    {
      i2 = paramInt2;
      i1 = i4;
      if (this.a != null)
      {
        i2 = paramInt2;
        i1 = i4;
        if (this.a.getParent() == this)
        {
          i2 = a(this.a, paramInt2, i5, 0);
          i1 = Math.max(0, i4 - this.a.getMeasuredWidth());
        }
      }
      paramInt2 = i2;
      i4 = i1;
      if (this.A != null)
      {
        paramInt2 = i2;
        i4 = i1;
        if (this.A.getVisibility() != 8)
        {
          paramInt2 = a(this.A, i2, i5, 0);
          i4 = Math.max(0, i1 - this.A.getMeasuredWidth());
        }
      }
      if ((this.r != null) && (this.r.getVisibility() != 8) && ((this.j & 0x8) != 0))
      {
        i2 = 1;
        if (this.g == null) {}
        switch (this.i)
        {
        default: 
          i1 = paramInt1;
          paramInt1 = paramInt2;
          paramInt2 = i1;
          if (this.g != null) {
            localObject1 = this.g;
          }
          break;
        }
      }
      for (;;)
      {
        i1 = paramInt1;
        ViewGroup.LayoutParams localLayoutParams;
        int i6;
        int i7;
        int i12;
        if (localObject1 != null)
        {
          localLayoutParams = generateLayoutParams(((View)localObject1).getLayoutParams());
          if (!(localLayoutParams instanceof android.support.v7.a.c)) {
            break label1148;
          }
          localObject2 = (android.support.v7.a.c)localLayoutParams;
          i5 = 0;
          i6 = 0;
          if (localObject2 != null)
          {
            i1 = ((android.support.v7.a.c)localObject2).leftMargin;
            i5 = ((android.support.v7.a.c)localObject2).rightMargin + i1;
            i6 = ((android.support.v7.a.c)localObject2).topMargin + ((android.support.v7.a.c)localObject2).bottomMargin;
          }
          if (this.f > 0) {
            break label1154;
          }
          i1 = Integer.MIN_VALUE;
          i7 = i8;
          if (localLayoutParams.height >= 0) {
            i7 = Math.min(localLayoutParams.height, i8);
          }
          i12 = Math.max(0, i7 - i6);
          if (localLayoutParams.width == -2) {
            break label1178;
          }
          i6 = 1073741824;
          if (localLayoutParams.width < 0) {
            break label1186;
          }
          i7 = Math.min(localLayoutParams.width, paramInt1);
          i8 = Math.max(0, i7 - i5);
          if (localObject2 == null) {
            break label1192;
          }
          i7 = ((android.support.v7.a.c)localObject2).a;
          if (((i7 & 0x7) != 1) || (localLayoutParams.width != -1)) {
            break label1290;
          }
        }
        for (i4 = Math.min(paramInt2, i4) * 2;; i4 = i8)
        {
          ((View)localObject1).measure(View.MeasureSpec.makeMeasureSpec(i4, i6), View.MeasureSpec.makeMeasureSpec(i12, i1));
          i1 = paramInt1 - (((View)localObject1).getMeasuredWidth() + i5);
          if ((this.g == null) && (i2 != 0))
          {
            a(this.r, i1, View.MeasureSpec.makeMeasureSpec(this.f, 1073741824), 0);
            Math.max(0, paramInt2 - this.r.getMeasuredWidth());
          }
          if (this.f <= 0)
          {
            paramInt1 = 0;
            paramInt2 = 0;
            if (paramInt2 < i9)
            {
              i1 = getChildAt(paramInt2).getMeasuredHeight() + i11;
              if (i1 <= paramInt1) {
                break label1287;
              }
              paramInt1 = i1;
            }
          }
          for (;;)
          {
            paramInt2 += 1;
            break label861;
            i3 = View.MeasureSpec.getSize(paramInt2);
            break label226;
            localObject1 = this.p;
            break label289;
            paramInt1 = View.MeasureSpec.makeMeasureSpec(((ViewGroup.LayoutParams)localObject2).width, 1073741824);
            break label322;
            i2 = 0;
            break label517;
            if (this.w == null) {
              break label552;
            }
            if (i2 != 0) {}
            for (i1 = this.C * 2;; i1 = this.C)
            {
              paramInt2 = Math.max(0, paramInt2 - i1);
              i1 = Math.max(0, paramInt1 - i1);
              this.w.measure(View.MeasureSpec.makeMeasureSpec(paramInt2, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
              i5 = this.w.getMeasuredWidth();
              paramInt1 = Math.max(0, paramInt2 - i5);
              paramInt2 = Math.max(0, i1 - i5);
              break;
            }
            if (this.x == null) {
              break label552;
            }
            if (i2 != 0) {}
            for (i1 = this.C * 2;; i1 = this.C)
            {
              paramInt2 = Math.max(0, paramInt2 - i1);
              i1 = Math.max(0, paramInt1 - i1);
              this.x.measure(View.MeasureSpec.makeMeasureSpec(paramInt2, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
              i5 = this.x.getMeasuredWidth();
              paramInt1 = Math.max(0, paramInt2 - i5);
              paramInt2 = Math.max(0, i1 - i5);
              break;
            }
            if (((this.j & 0x10) == 0) || (this.y == null)) {
              break label1297;
            }
            localObject1 = this.y;
            break label571;
            localObject2 = null;
            break label604;
            if (localLayoutParams.height != -2)
            {
              i1 = 1073741824;
              break label654;
            }
            i1 = Integer.MIN_VALUE;
            break label654;
            i6 = Integer.MIN_VALUE;
            break label704;
            i7 = paramInt1;
            break label723;
            i7 = 19;
            break label746;
            setMeasuredDimension(i10, paramInt1);
            for (;;)
            {
              if (this.M != null) {
                this.M.setContentHeight(getMeasuredHeight());
              }
              if ((this.z == null) || (this.z.getVisibility() == 8)) {
                break;
              }
              this.z.measure(View.MeasureSpec.makeMeasureSpec(i10 - this.B * 2, 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), Integer.MIN_VALUE));
              return;
              setMeasuredDimension(i10, i3);
            }
          }
        }
        localObject1 = null;
      }
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (ActionBarView.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if ((paramParcelable.a != 0) && (this.R != null) && (this.L != null))
    {
      b localb = (b)this.L.findItem(paramParcelable.a);
      if (localb != null) {
        localb.expandActionView();
      }
    }
    if (paramParcelable.b) {
      b();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    ActionBarView.SavedState localSavedState = new ActionBarView.SavedState(super.onSaveInstanceState());
    if ((this.R != null) && (this.R.b != null)) {
      localSavedState.a = this.R.b.getItemId();
    }
    localSavedState.b = d();
    return localSavedState;
  }
  
  public void setCallback(android.support.v7.a.d paramd)
  {
    this.P = paramd;
  }
  
  public void setCollapsable(boolean paramBoolean)
  {
    this.J = paramBoolean;
  }
  
  public void setContextView(ActionBarContextView paramActionBarContextView)
  {
    this.M = paramActionBarContextView;
  }
  
  public void setCustomNavigationView(View paramView)
  {
    if ((this.j & 0x10) != 0) {}
    for (int i1 = 1;; i1 = 0)
    {
      if ((this.y != null) && (i1 != 0)) {
        removeView(this.y);
      }
      this.y = paramView;
      if ((this.y != null) && (i1 != 0)) {
        addView(this.y);
      }
      return;
    }
  }
  
  public void setDisplayOptions(int paramInt)
  {
    int i5 = 8;
    int i2 = -1;
    boolean bool2 = true;
    int i3;
    label38:
    int i1;
    label52:
    boolean bool1;
    label75:
    label115:
    Object localObject;
    label131:
    label156:
    int i4;
    if (this.j == -1)
    {
      this.j = paramInt;
      if ((i2 & 0x1F) == 0) {
        break label369;
      }
      if ((paramInt & 0x2) == 0) {
        break label298;
      }
      i3 = 1;
      if ((i3 == 0) || (this.g != null)) {
        break label304;
      }
      i1 = 0;
      this.p.setVisibility(i1);
      if ((i2 & 0x4) != 0)
      {
        if ((paramInt & 0x4) == 0) {
          break label310;
        }
        bool1 = true;
        this.p.a(bool1);
        if (bool1) {
          setHomeButtonEnabled(true);
        }
      }
      if ((i2 & 0x1) != 0)
      {
        if ((this.n == null) || ((paramInt & 0x1) == 0)) {
          break label316;
        }
        i1 = 1;
        ActionBarView.HomeView localHomeView = this.p;
        if (i1 == 0) {
          break label321;
        }
        localObject = this.n;
        localHomeView.a((Drawable)localObject);
      }
      if ((i2 & 0x8) != 0)
      {
        if ((paramInt & 0x8) == 0) {
          break label330;
        }
        l();
      }
      if ((this.r != null) && ((i2 & 0x6) != 0))
      {
        if ((this.j & 0x4) == 0) {
          break label341;
        }
        i4 = 1;
        label182:
        localObject = this.u;
        i1 = i5;
        if (i3 == 0)
        {
          if (i4 == 0) {
            break label347;
          }
          i1 = 0;
        }
        label203:
        ((View)localObject).setVisibility(i1);
        localObject = this.r;
        if ((i3 != 0) || (i4 == 0)) {
          break label352;
        }
        bool1 = bool2;
        label229:
        ((LinearLayout)localObject).setEnabled(bool1);
      }
      if (((i2 & 0x10) != 0) && (this.y != null))
      {
        if ((paramInt & 0x10) == 0) {
          break label358;
        }
        addView(this.y);
      }
      label265:
      requestLayout();
    }
    for (;;)
    {
      if (this.p.isEnabled()) {
        break label376;
      }
      this.p.setContentDescription(null);
      return;
      i2 = this.j ^ paramInt;
      break;
      label298:
      i3 = 0;
      break label38;
      label304:
      i1 = 8;
      break label52;
      label310:
      bool1 = false;
      break label75;
      label316:
      i1 = 0;
      break label115;
      label321:
      localObject = this.m;
      break label131;
      label330:
      removeView(this.r);
      break label156;
      label341:
      i4 = 0;
      break label182;
      label347:
      i1 = 4;
      break label203;
      label352:
      bool1 = false;
      break label229;
      label358:
      removeView(this.y);
      break label265;
      label369:
      invalidate();
    }
    label376:
    if ((paramInt & 0x4) != 0)
    {
      this.p.setContentDescription(this.o.getResources().getText(i.abc_action_bar_up_description));
      return;
    }
    this.p.setContentDescription(this.o.getResources().getText(i.abc_action_bar_home_description));
  }
  
  public void setDropdownAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    this.O = paramSpinnerAdapter;
    if (this.v != null) {
      this.v.a(paramSpinnerAdapter);
    }
  }
  
  public void setDropdownSelectedPosition(int paramInt)
  {
    this.v.a(paramInt);
  }
  
  public void setEmbeddedTabView(ScrollingTabContainerView paramScrollingTabContainerView)
  {
    if (this.x != null) {
      removeView(this.x);
    }
    this.x = paramScrollingTabContainerView;
    if (paramScrollingTabContainerView != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.I = bool;
      if ((this.I) && (this.i == 2))
      {
        addView(this.x);
        ViewGroup.LayoutParams localLayoutParams = this.x.getLayoutParams();
        localLayoutParams.width = -2;
        localLayoutParams.height = -1;
        paramScrollingTabContainerView.setAllowCollapse(true);
      }
      return;
    }
  }
  
  public void setHomeAsUpIndicator(int paramInt)
  {
    this.p.a(paramInt);
  }
  
  public void setHomeAsUpIndicator(Drawable paramDrawable)
  {
    this.p.b(paramDrawable);
  }
  
  public void setHomeButtonEnabled(boolean paramBoolean)
  {
    this.p.setEnabled(paramBoolean);
    this.p.setFocusable(paramBoolean);
    if (!paramBoolean)
    {
      this.p.setContentDescription(null);
      return;
    }
    if ((this.j & 0x4) != 0)
    {
      this.p.setContentDescription(this.o.getResources().getText(i.abc_action_bar_up_description));
      return;
    }
    this.p.setContentDescription(this.o.getResources().getText(i.abc_action_bar_home_description));
  }
  
  public void setIcon(int paramInt)
  {
    setIcon(this.o.getResources().getDrawable(paramInt));
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.m = paramDrawable;
    if ((paramDrawable != null) && (((this.j & 0x1) == 0) || (this.n == null))) {
      this.p.a(paramDrawable);
    }
    if (this.g != null) {
      this.q.a(this.m.getConstantState().newDrawable(getResources()));
    }
  }
  
  public void setLogo(int paramInt)
  {
    setLogo(this.o.getResources().getDrawable(paramInt));
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    this.n = paramDrawable;
    if ((paramDrawable != null) && ((this.j & 0x1) != 0)) {
      this.p.a(paramDrawable);
    }
  }
  
  public void setNavigationMode(int paramInt)
  {
    int i1 = this.i;
    if (paramInt != i1) {
      switch (i1)
      {
      default: 
        switch (paramInt)
        {
        }
        break;
      }
    }
    for (;;)
    {
      this.i = paramInt;
      requestLayout();
      return;
      if (this.w == null) {
        break;
      }
      removeView(this.w);
      break;
      if ((this.x == null) || (!this.I)) {
        break;
      }
      removeView(this.x);
      break;
      if (this.v == null)
      {
        this.v = new ac(this.o, null, android.support.v7.b.c.actionDropDownStyle);
        this.w = ((LinearLayout)LayoutInflater.from(this.o).inflate(h.abc_action_bar_view_list_nav_layout, null));
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
        localLayoutParams.gravity = 17;
        this.w.addView(this.v, localLayoutParams);
      }
      if (this.v.d() != this.O) {
        this.v.a(this.O);
      }
      this.v.a(this.S);
      addView(this.w);
      continue;
      if ((this.x != null) && (this.I)) {
        addView(this.x);
      }
    }
  }
  
  public void setSplitActionBar(boolean paramBoolean)
  {
    int i1;
    if (this.d != paramBoolean)
    {
      Object localObject;
      if (this.a != null)
      {
        localObject = (ViewGroup)this.a.getParent();
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(this.a);
        }
        if (!paramBoolean) {
          break label135;
        }
        if (this.c != null) {
          this.c.addView(this.a);
        }
        this.a.getLayoutParams().width = -1;
        this.a.requestLayout();
      }
      if (this.c != null)
      {
        localObject = this.c;
        if (!paramBoolean) {
          break label158;
        }
        i1 = 0;
        label96:
        ((ActionBarContainer)localObject).setVisibility(i1);
      }
      if (this.b != null)
      {
        if (paramBoolean) {
          break label164;
        }
        this.b.b(getResources().getBoolean(android.support.v7.b.d.abc_action_bar_expanded_action_views_exclusive));
      }
    }
    for (;;)
    {
      super.setSplitActionBar(paramBoolean);
      return;
      label135:
      addView(this.a);
      this.a.getLayoutParams().width = -2;
      break;
      label158:
      i1 = 8;
      break label96;
      label164:
      this.b.b(false);
      this.b.a(getContext().getResources().getDisplayMetrics().widthPixels, true);
      this.b.a(Integer.MAX_VALUE);
    }
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    int i2 = 0;
    this.l = paramCharSequence;
    if (this.t != null)
    {
      this.t.setText(paramCharSequence);
      TextView localTextView = this.t;
      if (paramCharSequence == null) {
        break label96;
      }
      i1 = 0;
      localTextView.setVisibility(i1);
      if ((this.g != null) || ((this.j & 0x8) == 0) || ((TextUtils.isEmpty(this.k)) && (TextUtils.isEmpty(this.l)))) {
        break label102;
      }
      i1 = 1;
      label79:
      paramCharSequence = this.r;
      if (i1 == 0) {
        break label107;
      }
    }
    label96:
    label102:
    label107:
    for (int i1 = i2;; i1 = 8)
    {
      paramCharSequence.setVisibility(i1);
      return;
      i1 = 8;
      break;
      i1 = 0;
      break label79;
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.H = true;
    setTitleImpl(paramCharSequence);
  }
  
  public void setWindowCallback(Window.Callback paramCallback)
  {
    this.h = paramCallback;
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    if (!this.H) {
      setTitleImpl(paramCharSequence);
    }
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/widget/ActionBarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */