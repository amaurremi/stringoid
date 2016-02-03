package com.ideashower.readitlater.views.toolbars;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.activity.f;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.util.e;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.util.z;
import com.ideashower.readitlater.views.RainbowBar;
import com.ideashower.readitlater.views.ResizeDetectLinearLayout;
import com.ideashower.readitlater.views.p;
import com.pocket.i.a.n;
import com.pocket.p.d;
import com.pocket.widget.ShadowView;
import com.pocket.widget.ai;
import com.pocket.widget.navigation.r;
import java.util.Locale;
import org.apache.a.c.k;

public class StyledToolbar
  extends ResizeDetectLinearLayout
{
  public static final int a = g.b(2131361817);
  public static final int b = g.b(2131361818);
  public static final int c = g.b(2131361819);
  public static final int d = g.b(2131361823);
  public static final int e = g.b(2131361822);
  public static final int f = g.b(2131361821);
  public static final int g = g.b(2131361820);
  public static final int[] h = { 2130772087 };
  public static final int[] i = { 2130772089 };
  public static final int[] j = { 2130772090 };
  public static final int[] k = { 2130772088 };
  public static final int[] l = { 2130772091 };
  public static final int[] m = { 2130772092 };
  public static final int[] n = { 2130772093 };
  public static final int o = g.c().getResources().getDimensionPixelSize(2131296396);
  private Paint A;
  private Rect B;
  private Drawable C;
  private ShadowView D;
  private boolean E = true;
  private com.pocket.widget.navigation.o F;
  private f G;
  private int H = 0;
  private ColorStateList I;
  private ColorStateList J;
  private ColorStateList K;
  private ColorStateList L;
  private ColorStateList M;
  private ColorStateList N;
  private boolean O = true;
  private com.pocket.i.a.i P;
  private Locale Q;
  private int R;
  protected int p;
  protected int q;
  protected boolean r = false;
  private boolean s;
  private boolean t;
  private boolean u = false;
  private Paint v;
  private Paint w;
  private Paint x;
  private LinearGradient y;
  private Paint z;
  
  public StyledToolbar(Context paramContext)
  {
    super(paramContext);
    this.q = 1;
    this.p = a;
    this.r = true;
    a();
  }
  
  public StyledToolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, com.ideashower.readitlater.b.StyledToolbar);
    setIsRainbowified(paramContext.getBoolean(4, false));
    a(paramContext.getBoolean(2, false), null);
    setTitle(paramContext.getString(1));
    a(paramContext.getInt(0, a), false);
    setIsTopToolbar(paramContext.getBoolean(3, false));
    this.R = paramContext.getResourceId(5, 0);
    paramContext.recycle();
    a();
  }
  
  public static int a(View paramView)
  {
    for (;;)
    {
      if ((paramView instanceof b)) {
        return ((b)paramView).getStyle();
      }
      if ((paramView instanceof StyledToolbar)) {
        return ((StyledToolbar)paramView).getStyle();
      }
      if ((!(paramView.getParent() instanceof View)) || (paramView.getParent() == paramView)) {
        break;
      }
      paramView = (View)paramView.getParent();
    }
    return 0;
  }
  
  public static boolean a(ViewGroup paramViewGroup)
  {
    return ((paramViewGroup instanceof AbsoluteLayout)) || ((paramViewGroup instanceof RelativeLayout)) || ((paramViewGroup instanceof FrameLayout));
  }
  
  public static int[] a(int paramInt)
  {
    if (paramInt == b) {
      return i;
    }
    if (paramInt == d) {
      return j;
    }
    if (paramInt == e) {
      return k;
    }
    if (paramInt == f) {
      return l;
    }
    if (paramInt == g) {
      return m;
    }
    return h;
  }
  
  public static int[] a(View paramView, int[] paramArrayOfInt)
  {
    int i1 = a(paramView);
    if (i1 != 0) {
      View.mergeDrawableStates(paramArrayOfInt, a(i1));
    }
    return paramArrayOfInt;
  }
  
  private static Paint g()
  {
    return new Paint();
  }
  
  private void h()
  {
    int i2 = Math.min(2, getChildCount());
    int i1 = 0;
    for (;;)
    {
      if (i1 < i2)
      {
        View localView = getChildAt(i1);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
        if ((localLayoutParams.width == 0) && (localLayoutParams.weight == 1.0F) && (com.ideashower.readitlater.objects.i.b(0.0F, j.a(1.0F) + 1, localLayoutParams.height))) {
          removeView(localView);
        }
      }
      else
      {
        return;
      }
      i1 += 1;
    }
  }
  
  protected void a()
  {
    Resources localResources = getResources();
    this.Q = Locale.getDefault();
    this.I = localResources.getColorStateList(2131165811);
    this.J = localResources.getColorStateList(2131165819);
    this.K = localResources.getColorStateList(2131165818);
    this.L = localResources.getColorStateList(2131165821);
    this.M = localResources.getColorStateList(2131165823);
    this.N = localResources.getColorStateList(2131165820);
    setWillNotDraw(false);
    setClickable(true);
    this.H = m.a(this);
    this.A = g();
    this.v = g();
    this.v.setStrokeWidth(0.0F);
    this.w = g();
    this.x = g();
    this.z = g();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    int i1;
    if ((paramInt == b) || (paramInt == c)) {
      i1 = 3;
    }
    for (;;)
    {
      int i2 = paramInt;
      if (paramInt == c) {
        i2 = b;
      }
      this.p = i2;
      if (!this.t) {
        setShadowStyle(i1);
      }
      z.a(this, i2);
      refreshDrawableState();
      return;
      if (paramInt == d) {
        i1 = 1;
      } else {
        i1 = 2;
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramBoolean) {
        str = org.apache.a.c.f.a.b(paramString);
      }
    }
    if (!k.a(str)) {
      b(true).a(str);
    }
    while (this.F == null) {
      return;
    }
    this.F.a(null);
  }
  
  protected void a(boolean paramBoolean)
  {
    com.pocket.widget.navigation.o localo = b(true);
    localo.a(r.a);
    if (paramBoolean)
    {
      localo.a(new p(2130837637, getContext()));
      localo.b(new p(2130837697, getContext()));
    }
    for (;;)
    {
      localo.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (StyledToolbar.a(StyledToolbar.this) == null)
          {
            ((Activity)StyledToolbar.this.getContext()).finish();
            return;
          }
          StyledToolbar.a(StyledToolbar.this).O();
        }
      });
      return;
      localo.a(getResources().getDrawable(2130837804));
      localo.a(2130837803);
    }
  }
  
  public void a(boolean paramBoolean, f paramf)
  {
    a(paramBoolean, paramf, false);
  }
  
  public void a(boolean paramBoolean1, f paramf, boolean paramBoolean2)
  {
    this.G = paramf;
    if (paramBoolean1) {
      a(paramBoolean2);
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramView instanceof b)) {
      ((b)paramView).setStyle(this.p);
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public com.pocket.widget.navigation.o b(boolean paramBoolean)
  {
    if ((this.F == null) && (paramBoolean))
    {
      h();
      ai localai = new ai(getContext());
      localai.setOrientation(0);
      addView(localai, 0, new LinearLayout.LayoutParams(0, -1, 1.0F));
      this.F = new com.pocket.widget.navigation.o(getContext());
      this.F.setId(1000);
      localai.addView(this.F, new LinearLayout.LayoutParams(-2, -1));
    }
    return this.F;
  }
  
  public void b()
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if ((this.D == null) && (!a(localViewGroup))) {
      return;
    }
    label56:
    int i1;
    label86:
    int i2;
    label117:
    Object localObject;
    if ((this.q == 2) && (this.r))
    {
      this.C = new n(getResources(), this);
      if ((this.C != null) && ((this.D == null) || (this.E)))
      {
        if (this.D != null) {
          break label238;
        }
        i1 = 1;
        if (i1 != 0) {
          this.D = new ShadowView(getContext());
        }
        if (!this.r) {
          break label243;
        }
        i2 = getBottom();
        if (!(localViewGroup instanceof AbsoluteLayout)) {
          break label259;
        }
        localObject = new AbsoluteLayout.LayoutParams(-1, -2, 0, i2);
        this.D.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    for (;;)
    {
      if (i1 != 0) {
        localViewGroup.addView(this.D, localViewGroup.indexOfChild(this) + 1);
      }
      if (this.D == null) {
        break;
      }
      this.D.setDrawable(this.C);
      if (this.C == null) {
        break label375;
      }
      this.D.setVisibility(0);
      return;
      if (this.q == 3)
      {
        this.C = new com.pocket.i.a.o(getResources(), this);
        break label56;
      }
      this.C = null;
      break label56;
      label238:
      i1 = 0;
      break label86;
      label243:
      i2 = getTop() - this.C.getIntrinsicHeight();
      break label117;
      label259:
      if ((localViewGroup instanceof RelativeLayout))
      {
        localObject = new RelativeLayout.LayoutParams(-1, -2);
        if (this.r)
        {
          i2 = 3;
          label288:
          if (!this.r) {
            break label323;
          }
        }
        label323:
        for (int i3 = 2131230742;; i3 = 2131230751)
        {
          ((RelativeLayout.LayoutParams)localObject).addRule(i2, i3);
          this.D.setLayoutParams((ViewGroup.LayoutParams)localObject);
          break;
          i2 = 2;
          break label288;
        }
      }
      if ((localViewGroup instanceof FrameLayout))
      {
        localObject = new FrameLayout.LayoutParams(-1, -2);
        ((FrameLayout.LayoutParams)localObject).gravity = 48;
        ((FrameLayout.LayoutParams)localObject).topMargin = i2;
        this.D.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    label375:
    this.D.setVisibility(8);
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.t = paramBoolean;
    }
    this.q = paramInt;
    b();
  }
  
  public void c(boolean paramBoolean)
  {
    a(this.p, paramBoolean);
  }
  
  public boolean c()
  {
    return this.r;
  }
  
  public void d()
  {
    this.P.a();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.P != null) {
      this.P.setState(getDrawableState());
    }
  }
  
  public void e()
  {
    this.P.b();
  }
  
  public boolean f()
  {
    return this.u;
  }
  
  public ShadowView getShadowView()
  {
    return this.D;
  }
  
  public int getStyle()
  {
    return this.p;
  }
  
  public int[] getStyleState()
  {
    return a(this.p);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.R != 0) {
      setShadowView((ShadowView)getRootView().findViewById(this.R));
    }
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 4);
    mergeDrawableStates(arrayOfInt, m.b(this));
    mergeDrawableStates(arrayOfInt, getStyleState());
    if (this.r) {
      mergeDrawableStates(arrayOfInt, n);
    }
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int[] arrayOfInt = getDrawableState();
    int i1;
    int i3;
    label32:
    int i4;
    label49:
    int i5;
    label66:
    int i6;
    label76:
    int i9;
    int i2;
    label152:
    int i7;
    label172:
    label187:
    label197:
    int i8;
    if (this.u)
    {
      i1 = 0;
      if ((!this.u) && (this.O)) {
        break label483;
      }
      i3 = 0;
      if ((!this.u) && (this.O)) {
        break label498;
      }
      i4 = 0;
      if ((!this.u) && (this.O)) {
        break label513;
      }
      i5 = 0;
      if (!this.u) {
        break label528;
      }
      i6 = 0;
      this.I.getColorForState(arrayOfInt, 0);
      i9 = getHeight();
      if (i1 != 0)
      {
        this.A.setColor(i1);
        paramCanvas.drawRect(0.0F, 0, getWidth(), i9, this.A);
      }
      if (i6 != 0)
      {
        if ((this.y == null) || (this.s))
        {
          if (this.v == null) {
            break label543;
          }
          i2 = 1;
          i7 = j.a(5.0F);
          if (!this.r) {
            break label548;
          }
          i1 = i9 - i2;
          if (!this.r) {
            break label555;
          }
          i2 = i9 - i2 - i7;
          if (!this.r) {
            break label565;
          }
          i7 = i2;
          int i10 = getWidth();
          if (!this.r) {
            break label571;
          }
          i8 = i1;
          label213:
          this.B = new Rect(0, i7, i10, i8);
          this.z.setDither(true);
          i7 = Color.argb(0, Color.red(i6), Color.green(i6), Color.blue(i6));
          this.y = new LinearGradient(0.0F, i1, 0.0F, i2, i6, i7, Shader.TileMode.CLAMP);
          this.z.setShader(this.y);
        }
        paramCanvas.drawRect(this.B, this.z);
      }
      if (i5 != 0)
      {
        this.x.setColor(i5);
        if (!this.r) {
          break label577;
        }
        d.b(paramCanvas, 0.0F, i9 - 1, getWidth(), 0.0F, this.x);
      }
      label349:
      if ((i3 != 0) && ((this.C == null) || (!(this.C instanceof com.pocket.i.a.o))))
      {
        this.v.setColor(i3);
        if (!this.r) {
          break label597;
        }
        d.b(paramCanvas, 0.0F, i9, getWidth(), 0.0F, this.v);
      }
      label405:
      if (i4 != 0)
      {
        this.w.setColor(i4);
        if (!this.r) {
          break label617;
        }
        d.a(paramCanvas, 0.0F, 0, getWidth(), 0.0F, this.w);
      }
    }
    for (;;)
    {
      if (this.P != null) {
        this.P.draw(paramCanvas);
      }
      this.s = false;
      super.onDraw(paramCanvas);
      return;
      i1 = this.M.getColorForState(arrayOfInt, 0);
      break;
      label483:
      i3 = this.K.getColorForState(arrayOfInt, 0);
      break label32;
      label498:
      i4 = this.L.getColorForState(arrayOfInt, 0);
      break label49;
      label513:
      i5 = this.J.getColorForState(arrayOfInt, 0);
      break label66;
      label528:
      i6 = this.N.getColorForState(arrayOfInt, 0);
      break label76;
      label543:
      i2 = 0;
      break label152;
      label548:
      i1 = 0 + i2;
      break label172;
      label555:
      i2 = i2 + 0 + i7;
      break label187;
      label565:
      i7 = i1;
      break label197;
      label571:
      i8 = i2;
      break label213;
      label577:
      d.a(paramCanvas, 0.0F, 1, getWidth(), 0.0F, this.x);
      break label349;
      label597:
      d.a(paramCanvas, 0.0F, 0, getWidth(), 0.0F, this.v);
      break label405;
      label617:
      d.b(paramCanvas, 0.0F, i9, getWidth(), 0.0F, this.w);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((com.ideashower.readitlater.util.a.d()) && (getVisibility() != 0)) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (this.P != null)) {
      this.P.setBounds(0, 0, getWidth(), getPaddingTop() - 1);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.s = true;
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    b();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((com.ideashower.readitlater.util.a.d()) && (getVisibility() != 0)) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void refreshDrawableState()
  {
    int i1 = m.a(this);
    if (this.H != i1)
    {
      this.H = i1;
      c(true);
    }
    invalidate();
    super.refreshDrawableState();
    if (this.P != null) {
      this.P.setState(getDrawableState());
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      if ((localView instanceof StyledIconButton)) {
        ((StyledIconButton)localView).setEnabled(paramBoolean);
      }
      i1 += 1;
    }
  }
  
  public void setHighlightsEnabled(boolean paramBoolean)
  {
    this.O = paramBoolean;
    invalidate();
  }
  
  public void setIsRainbowified(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.P != null)) {
      return;
    }
    int i2;
    if (paramBoolean)
    {
      this.P = new com.pocket.i.a.i(this);
      this.P.a(true);
      this.P.setState(getDrawableState());
      i2 = getPaddingLeft();
      if (!paramBoolean) {
        break label107;
      }
    }
    label107:
    for (int i1 = RainbowBar.a;; i1 = 0)
    {
      setPadding(i2, i1, getPaddingRight(), getPaddingBottom());
      requestLayout();
      invalidate();
      return;
      if (this.P != null) {
        this.P.setCallback(null);
      }
      this.P = null;
      break;
    }
  }
  
  public void setIsTopToolbar(boolean paramBoolean)
  {
    this.r = paramBoolean;
    a(this.p, false);
  }
  
  public void setIsTransparent(boolean paramBoolean)
  {
    this.u = paramBoolean;
    a(this.p, false);
  }
  
  public void setShadowStyle(int paramInt)
  {
    b(paramInt, false);
  }
  
  public void setShadowView(ShadowView paramShadowView)
  {
    if (this.D != null) {
      e.a("shadow already set");
    }
    this.D = paramShadowView;
    this.E = false;
    b();
  }
  
  public void setShadowVisibility(boolean paramBoolean)
  {
    ShadowView localShadowView;
    if (this.D != null)
    {
      localShadowView = this.D;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i1 = 0;; i1 = 8)
    {
      localShadowView.setVisibility(i1);
      return;
    }
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(getResources().getString(paramInt));
  }
  
  public void setTitle(String paramString)
  {
    if (this.Q == null) {
      this.Q = Locale.getDefault();
    }
    a(paramString, this.Q.getLanguage().equals(Locale.ENGLISH.getLanguage()));
  }
  
  public void setVisibility(int paramInt)
  {
    if (this.D != null) {
      this.D.setVisibility(paramInt);
    }
    super.setVisibility(paramInt);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    if ((paramDrawable == this.P) && (this.P != null)) {
      return true;
    }
    return super.verifyDrawable(paramDrawable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/toolbars/StyledToolbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */