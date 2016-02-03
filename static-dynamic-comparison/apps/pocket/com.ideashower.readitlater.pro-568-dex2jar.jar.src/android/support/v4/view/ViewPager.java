package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.widget.e;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ViewPager
  extends ViewGroup
{
  private static final int[] a = { 16842931 };
  private static final bq af = new bq();
  private static final Comparator c = new Comparator()
  {
    public int a(bj paramAnonymousbj1, bj paramAnonymousbj2)
    {
      return paramAnonymousbj1.b - paramAnonymousbj2.b;
    }
  };
  private static final Interpolator d = new Interpolator()
  {
    public float getInterpolation(float paramAnonymousFloat)
    {
      paramAnonymousFloat -= 1.0F;
      return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
    }
  };
  private boolean A;
  private boolean B;
  private int C;
  private int D;
  private int E;
  private float F;
  private float G;
  private float H;
  private float I;
  private int J = -1;
  private VelocityTracker K;
  private int L;
  private int M;
  private int N;
  private int O;
  private boolean P;
  private e Q;
  private e R;
  private boolean S = true;
  private boolean T = false;
  private boolean U;
  private int V;
  private bn W;
  private bn Z;
  private bm aa;
  private bo ab;
  private Method ac;
  private int ad;
  private ArrayList ae;
  private final Runnable ag = new Runnable()
  {
    public void run()
    {
      ViewPager.a(ViewPager.this, 0);
      ViewPager.this.c();
    }
  };
  private int ah = 0;
  private int b;
  private final ArrayList e = new ArrayList();
  private final bj f = new bj();
  private final Rect g = new Rect();
  private aa h;
  private int i;
  private int j = -1;
  private Parcelable k = null;
  private ClassLoader l = null;
  private Scroller m;
  private bp n;
  private int o;
  private Drawable p;
  private int q;
  private int r;
  private float s = -3.4028235E38F;
  private float t = Float.MAX_VALUE;
  private int u;
  private int v;
  private boolean w;
  private boolean x;
  private boolean y;
  private int z = 1;
  
  public ViewPager(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private int a(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if ((Math.abs(paramInt3) > this.N) && (Math.abs(paramInt2) > this.L))
    {
      if (paramInt2 > 0) {}
      for (;;)
      {
        paramInt2 = paramInt1;
        if (this.e.size() > 0)
        {
          bj localbj1 = (bj)this.e.get(0);
          bj localbj2 = (bj)this.e.get(this.e.size() - 1);
          paramInt2 = Math.max(localbj1.b, Math.min(paramInt1, localbj2.b));
        }
        return paramInt2;
        paramInt1 += 1;
      }
    }
    if (paramInt1 >= this.i) {}
    for (float f1 = 0.4F;; f1 = 0.6F)
    {
      paramInt1 = (int)(f1 + (paramInt1 + paramFloat));
      break;
    }
  }
  
  private Rect a(Rect paramRect, View paramView)
  {
    if (paramRect == null) {
      paramRect = new Rect();
    }
    for (;;)
    {
      if (paramView == null)
      {
        paramRect.set(0, 0, 0, 0);
        return paramRect;
      }
      paramRect.left = paramView.getLeft();
      paramRect.right = paramView.getRight();
      paramRect.top = paramView.getTop();
      paramRect.bottom = paramView.getBottom();
      for (paramView = paramView.getParent(); ((paramView instanceof ViewGroup)) && (paramView != this); paramView = paramView.getParent())
      {
        paramView = (ViewGroup)paramView;
        paramRect.left += paramView.getLeft();
        paramRect.right += paramView.getRight();
        paramRect.top += paramView.getTop();
        paramRect.bottom += paramView.getBottom();
      }
      return paramRect;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 > 0) && (!this.e.isEmpty()))
    {
      int i1 = getPaddingLeft();
      int i2 = getPaddingRight();
      int i3 = getPaddingLeft();
      int i4 = getPaddingRight();
      f1 = getScrollX() / (paramInt2 - i3 - i4 + paramInt4);
      paramInt2 = (int)((paramInt1 - i1 - i2 + paramInt3) * f1);
      scrollTo(paramInt2, getScrollY());
      if (!this.m.isFinished())
      {
        paramInt3 = this.m.getDuration();
        paramInt4 = this.m.timePassed();
        localbj = b(this.i);
        this.m.startScroll(paramInt2, 0, (int)(localbj.e * paramInt1), 0, paramInt3 - paramInt4);
      }
      return;
    }
    bj localbj = b(this.i);
    if (localbj != null) {}
    for (float f1 = Math.min(localbj.e, this.t);; f1 = 0.0F)
    {
      paramInt1 = (int)(f1 * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (paramInt1 == getScrollX()) {
        break;
      }
      a(false);
      scrollTo(paramInt1, getScrollY());
      return;
    }
  }
  
  private void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    bj localbj = b(paramInt1);
    float f1;
    if (localbj != null) {
      f1 = getClientWidth();
    }
    for (int i1 = (int)(Math.max(this.s, Math.min(localbj.e, this.t)) * f1);; i1 = 0)
    {
      if (paramBoolean1)
      {
        a(i1, 0, paramInt2);
        if ((paramBoolean2) && (this.W != null)) {
          this.W.a(paramInt1);
        }
        if ((paramBoolean2) && (this.Z != null)) {
          this.Z.a(paramInt1);
        }
        return;
      }
      if ((paramBoolean2) && (this.W != null)) {
        this.W.a(paramInt1);
      }
      if ((paramBoolean2) && (this.Z != null)) {
        this.Z.a(paramInt1);
      }
      a(false);
      scrollTo(i1, 0);
      d(i1);
      return;
    }
  }
  
  private void a(bj parambj1, int paramInt, bj parambj2)
  {
    int i4 = this.h.a();
    int i1 = getClientWidth();
    float f2;
    if (i1 > 0)
    {
      f2 = this.o / i1;
      if (parambj2 == null) {
        break label409;
      }
      i1 = parambj2.b;
      if (i1 < parambj1.b)
      {
        f1 = parambj2.e + parambj2.d + f2;
        i1 += 1;
        i2 = 0;
      }
    }
    else
    {
      for (;;)
      {
        if ((i1 > parambj1.b) || (i2 >= this.e.size())) {
          break label409;
        }
        for (parambj2 = (bj)this.e.get(i2);; parambj2 = (bj)this.e.get(i2))
        {
          i3 = i1;
          f3 = f1;
          if (i1 <= parambj2.b) {
            break;
          }
          i3 = i1;
          f3 = f1;
          if (i2 >= this.e.size() - 1) {
            break;
          }
          i2 += 1;
        }
        f2 = 0.0F;
        break;
        while (i3 < parambj2.b)
        {
          f3 += this.h.a(i3) + f2;
          i3 += 1;
        }
        parambj2.e = f3;
        f1 = f3 + (parambj2.d + f2);
        i1 = i3 + 1;
      }
    }
    if (i1 > parambj1.b)
    {
      i2 = this.e.size() - 1;
      f1 = parambj2.e;
      i1 -= 1;
      while ((i1 >= parambj1.b) && (i2 >= 0))
      {
        for (parambj2 = (bj)this.e.get(i2);; parambj2 = (bj)this.e.get(i2))
        {
          i3 = i1;
          f3 = f1;
          if (i1 >= parambj2.b) {
            break;
          }
          i3 = i1;
          f3 = f1;
          if (i2 <= 0) {
            break;
          }
          i2 -= 1;
        }
        while (i3 > parambj2.b)
        {
          f3 -= this.h.a(i3) + f2;
          i3 -= 1;
        }
        f1 = f3 - (parambj2.d + f2);
        parambj2.e = f1;
        i1 = i3 - 1;
      }
    }
    label409:
    int i3 = this.e.size();
    float f3 = parambj1.e;
    i1 = parambj1.b - 1;
    if (parambj1.b == 0)
    {
      f1 = parambj1.e;
      this.s = f1;
      if (parambj1.b != i4 - 1) {
        break label550;
      }
      f1 = parambj1.e + parambj1.d - 1.0F;
      label475:
      this.t = f1;
      i2 = paramInt - 1;
      f1 = f3;
    }
    for (;;)
    {
      if (i2 < 0) {
        break label603;
      }
      parambj2 = (bj)this.e.get(i2);
      for (;;)
      {
        if (i1 > parambj2.b)
        {
          f1 -= this.h.a(i1) + f2;
          i1 -= 1;
          continue;
          f1 = -3.4028235E38F;
          break;
          label550:
          f1 = Float.MAX_VALUE;
          break label475;
        }
      }
      f1 -= parambj2.d + f2;
      parambj2.e = f1;
      if (parambj2.b == 0) {
        this.s = f1;
      }
      i1 -= 1;
      i2 -= 1;
    }
    label603:
    float f1 = parambj1.e + parambj1.d + f2;
    int i2 = parambj1.b + 1;
    i1 = paramInt + 1;
    paramInt = i2;
    while (i1 < i3)
    {
      parambj1 = (bj)this.e.get(i1);
      while (paramInt < parambj1.b)
      {
        f1 = this.h.a(paramInt) + f2 + f1;
        paramInt += 1;
      }
      if (parambj1.b == i4 - 1) {
        this.t = (parambj1.d + f1 - 1.0F);
      }
      parambj1.e = f1;
      f1 += parambj1.d + f2;
      paramInt += 1;
      i1 += 1;
    }
    this.T = false;
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = v.b(paramMotionEvent);
    if (v.b(paramMotionEvent, i1) == this.J) {
      if (i1 != 0) {
        break label56;
      }
    }
    label56:
    for (i1 = 1;; i1 = 0)
    {
      this.F = v.c(paramMotionEvent, i1);
      this.J = v.b(paramMotionEvent, i1);
      if (this.K != null) {
        this.K.clear();
      }
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.ah == 2) {}
    int i2;
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        setScrollingCacheEnabled(false);
        this.m.abortAnimation();
        i2 = getScrollX();
        i3 = getScrollY();
        int i4 = this.m.getCurrX();
        int i5 = this.m.getCurrY();
        if ((i2 != i4) || (i3 != i5)) {
          scrollTo(i4, i5);
        }
      }
      this.y = false;
      int i3 = 0;
      i2 = i1;
      i1 = i3;
      while (i1 < this.e.size())
      {
        bj localbj = (bj)this.e.get(i1);
        if (localbj.c)
        {
          localbj.c = false;
          i2 = 1;
        }
        i1 += 1;
      }
    }
    if (i2 != 0)
    {
      if (paramBoolean) {
        ag.a(this, this.ag);
      }
    }
    else {
      return;
    }
    this.ag.run();
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return ((paramFloat1 < this.D) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getWidth() - this.D) && (paramFloat2 < 0.0F));
  }
  
  private void b(boolean paramBoolean)
  {
    int i3 = getChildCount();
    int i1 = 0;
    if (i1 < i3)
    {
      if (paramBoolean) {}
      for (int i2 = 2;; i2 = 0)
      {
        ag.a(getChildAt(i1), i2, null);
        i1 += 1;
        break;
      }
    }
  }
  
  private boolean b(float paramFloat)
  {
    int i2 = 1;
    boolean bool2 = false;
    boolean bool1 = false;
    float f1 = this.F;
    this.F = paramFloat;
    float f2 = getScrollX() + (f1 - paramFloat);
    int i3 = getClientWidth();
    paramFloat = i3 * this.s;
    f1 = i3;
    float f3 = this.t;
    bj localbj1 = (bj)this.e.get(0);
    bj localbj2 = (bj)this.e.get(this.e.size() - 1);
    if (localbj1.b != 0) {
      paramFloat = localbj1.e * i3;
    }
    for (int i1 = 0;; i1 = 1)
    {
      if (localbj2.b != this.h.a() - 1)
      {
        f1 = localbj2.e * i3;
        i2 = 0;
      }
      for (;;)
      {
        if (f2 < paramFloat)
        {
          f1 = paramFloat;
          if (i1 != 0)
          {
            bool1 = this.Q.a(Math.abs(paramFloat - f2) / i3);
            f1 = paramFloat;
          }
        }
        for (;;)
        {
          this.F += f1 - (int)f1;
          scrollTo((int)f1, getScrollY());
          d((int)f1);
          return bool1;
          if (f2 > f1)
          {
            bool1 = bool2;
            if (i2 != 0) {
              bool1 = this.R.a(Math.abs(f2 - f1) / i3);
            }
          }
          else
          {
            f1 = f2;
          }
        }
        f1 *= f3;
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  private boolean d(int paramInt)
  {
    boolean bool = false;
    if (this.e.size() == 0)
    {
      this.U = false;
      a(0, 0.0F, 0);
      if (!this.U) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
    }
    else
    {
      bj localbj = i();
      int i2 = getClientWidth();
      int i3 = this.o;
      float f1 = this.o / i2;
      int i1 = localbj.b;
      f1 = (paramInt / i2 - localbj.e) / (localbj.d + f1);
      paramInt = (int)((i3 + i2) * f1);
      this.U = false;
      a(i1, f1, paramInt);
      if (!this.U) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
      bool = true;
    }
    return bool;
  }
  
  private void g()
  {
    int i2;
    for (int i1 = 0; i1 < getChildCount(); i1 = i2 + 1)
    {
      i2 = i1;
      if (!((bk)getChildAt(i1).getLayoutParams()).a)
      {
        removeViewAt(i1);
        i2 = i1 - 1;
      }
    }
  }
  
  private int getClientWidth()
  {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private void h()
  {
    if (this.ad != 0)
    {
      if (this.ae == null) {
        this.ae = new ArrayList();
      }
      for (;;)
      {
        int i2 = getChildCount();
        int i1 = 0;
        while (i1 < i2)
        {
          View localView = getChildAt(i1);
          this.ae.add(localView);
          i1 += 1;
        }
        this.ae.clear();
      }
      Collections.sort(this.ae, af);
    }
  }
  
  private bj i()
  {
    int i1 = getClientWidth();
    float f1;
    float f2;
    label36:
    float f4;
    float f3;
    int i3;
    int i2;
    Object localObject1;
    label53:
    Object localObject2;
    bj localbj;
    if (i1 > 0)
    {
      f1 = getScrollX() / i1;
      if (i1 <= 0) {
        break label214;
      }
      f2 = this.o / i1;
      f4 = 0.0F;
      f3 = 0.0F;
      i3 = -1;
      i1 = 0;
      i2 = 1;
      localObject1 = null;
      localObject2 = localObject1;
      if (i1 < this.e.size())
      {
        localbj = (bj)this.e.get(i1);
        if ((i2 != 0) || (localbj.b == i3 + 1)) {
          break label249;
        }
        localbj = this.f;
        localbj.e = (f4 + f3 + f2);
        localbj.b = (i3 + 1);
        localbj.d = this.h.a(localbj.b);
        i1 -= 1;
      }
    }
    label214:
    label219:
    label249:
    for (;;)
    {
      f3 = localbj.e;
      f4 = localbj.d;
      if (i2 == 0)
      {
        localObject2 = localObject1;
        if (f1 < f3) {}
      }
      else
      {
        if ((f1 >= f4 + f3 + f2) && (i1 != this.e.size() - 1)) {
          break label219;
        }
        localObject2 = localbj;
      }
      return (bj)localObject2;
      f1 = 0.0F;
      break;
      f2 = 0.0F;
      break label36;
      i3 = localbj.b;
      f4 = localbj.d;
      i2 = 0;
      i1 += 1;
      localObject1 = localbj;
      break label53;
    }
  }
  
  private void j()
  {
    this.A = false;
    this.B = false;
    if (this.K != null)
    {
      this.K.recycle();
      this.K = null;
    }
  }
  
  private void setScrollState(int paramInt)
  {
    if (this.ah == paramInt) {
      return;
    }
    this.ah = paramInt;
    if (this.ab != null) {
      if (paramInt == 0) {
        break label50;
      }
    }
    label50:
    for (boolean bool = true;; bool = false)
    {
      b(bool);
      if (this.W == null) {
        break;
      }
      this.W.b(paramInt);
      return;
    }
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.x != paramBoolean) {
      this.x = paramBoolean;
    }
  }
  
  float a(float paramFloat)
  {
    return (float)Math.sin((float)((paramFloat - 0.5F) * 0.4712389167638204D));
  }
  
  bj a(int paramInt1, int paramInt2)
  {
    bj localbj = new bj();
    localbj.b = paramInt1;
    localbj.a = this.h.a(this, paramInt1);
    localbj.d = this.h.a(paramInt1);
    if ((paramInt2 < 0) || (paramInt2 >= this.e.size()))
    {
      this.e.add(localbj);
      return localbj;
    }
    this.e.add(paramInt2, localbj);
    return localbj;
  }
  
  bj a(View paramView)
  {
    int i1 = 0;
    while (i1 < this.e.size())
    {
      bj localbj = (bj)this.e.get(i1);
      if (this.h.a(paramView, localbj.a)) {
        return localbj;
      }
      i1 += 1;
    }
    return null;
  }
  
  void a()
  {
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context localContext = getContext();
    this.m = new Scroller(localContext, d);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
    float f1 = localContext.getResources().getDisplayMetrics().density;
    this.E = aw.a(localViewConfiguration);
    this.L = ((int)(400.0F * f1));
    this.M = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.Q = new e(localContext);
    this.R = new e(localContext);
    this.N = ((int)(25.0F * f1));
    this.O = ((int)(2.0F * f1));
    this.C = ((int)(16.0F * f1));
    ag.a(this, new bl(this));
    if (ag.c(this) == 0) {
      ag.b(this, 1);
    }
  }
  
  void a(int paramInt)
  {
    int i1;
    Object localObject2;
    if (this.i != paramInt) {
      if (this.i < paramInt)
      {
        i1 = 66;
        localObject2 = b(this.i);
        this.i = paramInt;
      }
    }
    for (int i2 = i1;; i2 = 2)
    {
      if (this.h == null) {
        h();
      }
      do
      {
        return;
        i1 = 17;
        break;
        if (this.y)
        {
          h();
          return;
        }
      } while (getWindowToken() == null);
      this.h.a(this);
      paramInt = this.z;
      int i8 = Math.max(0, this.i - paramInt);
      int i6 = this.h.a();
      int i7 = Math.min(i6 - 1, paramInt + this.i);
      Object localObject1;
      if (i6 != this.b) {
        try
        {
          String str = getResources().getResourceName(getId());
          throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.b + ", found: " + i6 + " Pager id: " + str + " Pager class: " + getClass() + " Problematic adapter: " + this.h.getClass());
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          for (;;)
          {
            localObject1 = Integer.toHexString(getId());
          }
        }
      }
      paramInt = 0;
      if (paramInt < this.e.size())
      {
        localObject1 = (bj)this.e.get(paramInt);
        if (((bj)localObject1).b >= this.i) {
          if (((bj)localObject1).b != this.i) {
            break label1273;
          }
        }
      }
      for (;;)
      {
        if ((localObject1 == null) && (i6 > 0)) {}
        for (Object localObject3 = a(this.i, paramInt);; localObject3 = localObject1)
        {
          int i5;
          label344:
          int i9;
          label357:
          float f3;
          int i4;
          int i3;
          Object localObject4;
          float f1;
          if (localObject3 != null)
          {
            i5 = paramInt - 1;
            if (i5 < 0) {
              break label640;
            }
            localObject1 = (bj)this.e.get(i5);
            i9 = getClientWidth();
            if (i9 > 0) {
              break label646;
            }
            f2 = 0.0F;
            i1 = this.i;
            f3 = 0.0F;
            i4 = i1 - 1;
            i3 = paramInt;
            localObject4 = localObject1;
            if (i4 >= 0)
            {
              if ((f3 < f2) || (i4 >= i8)) {
                break label801;
              }
              if (localObject4 != null) {
                break label667;
              }
            }
            f1 = ((bj)localObject3).d;
            paramInt = i3 + 1;
            if (f1 < 2.0F)
            {
              if (paramInt >= this.e.size()) {
                break label921;
              }
              localObject1 = (bj)this.e.get(paramInt);
              label444:
              if (i9 > 0) {
                break label927;
              }
            }
          }
          label463:
          label521:
          label640:
          label646:
          label667:
          label792:
          label801:
          label921:
          label927:
          for (float f2 = 0.0F;; f2 = getPaddingRight() / i9 + 2.0F)
          {
            i1 = this.i;
            i1 += 1;
            if (i1 < i6)
            {
              if ((f1 < f2) || (i1 <= i7)) {
                break label1023;
              }
              if (localObject1 != null) {
                break label942;
              }
            }
            a((bj)localObject3, i3, (bj)localObject2);
            localObject2 = this.h;
            paramInt = this.i;
            if (localObject3 == null) {
              break label1145;
            }
            localObject1 = ((bj)localObject3).a;
            ((aa)localObject2).b(this, paramInt, localObject1);
            this.h.b(this);
            i1 = getChildCount();
            paramInt = 0;
            while (paramInt < i1)
            {
              localObject2 = getChildAt(paramInt);
              localObject1 = (bk)((View)localObject2).getLayoutParams();
              ((bk)localObject1).f = paramInt;
              if ((!((bk)localObject1).a) && (((bk)localObject1).c == 0.0F))
              {
                localObject2 = a((View)localObject2);
                if (localObject2 != null)
                {
                  ((bk)localObject1).c = ((bj)localObject2).d;
                  ((bk)localObject1).e = ((bj)localObject2).b;
                }
              }
              paramInt += 1;
            }
            paramInt += 1;
            break;
            localObject1 = null;
            break label344;
            f2 = 2.0F - ((bj)localObject3).d + getPaddingLeft() / i9;
            break label357;
            localObject1 = localObject4;
            paramInt = i5;
            f1 = f3;
            i1 = i3;
            if (i4 == ((bj)localObject4).b)
            {
              localObject1 = localObject4;
              paramInt = i5;
              f1 = f3;
              i1 = i3;
              if (!((bj)localObject4).c)
              {
                this.e.remove(i5);
                this.h.a(this, i4, ((bj)localObject4).a);
                paramInt = i5 - 1;
                i1 = i3 - 1;
                if (paramInt < 0) {
                  break label792;
                }
                localObject1 = (bj)this.e.get(paramInt);
                f1 = f3;
              }
            }
            for (;;)
            {
              i4 -= 1;
              localObject4 = localObject1;
              i5 = paramInt;
              f3 = f1;
              i3 = i1;
              break;
              localObject1 = null;
              f1 = f3;
              continue;
              if ((localObject4 != null) && (i4 == ((bj)localObject4).b))
              {
                f1 = f3 + ((bj)localObject4).d;
                paramInt = i5 - 1;
                if (paramInt >= 0)
                {
                  localObject1 = (bj)this.e.get(paramInt);
                  i1 = i3;
                }
                else
                {
                  localObject1 = null;
                  i1 = i3;
                }
              }
              else
              {
                f1 = f3 + a(i4, i5 + 1).d;
                i1 = i3 + 1;
                if (i5 >= 0)
                {
                  localObject1 = (bj)this.e.get(i5);
                  paramInt = i5;
                }
                else
                {
                  localObject1 = null;
                  paramInt = i5;
                }
              }
            }
            localObject1 = null;
            break label444;
          }
          label942:
          if ((i1 == ((bj)localObject1).b) && (!((bj)localObject1).c))
          {
            this.e.remove(paramInt);
            this.h.a(this, i1, ((bj)localObject1).a);
            if (paramInt < this.e.size()) {
              localObject1 = (bj)this.e.get(paramInt);
            }
          }
          for (;;)
          {
            i1 += 1;
            break label463;
            localObject1 = null;
            continue;
            label1023:
            if ((localObject1 != null) && (i1 == ((bj)localObject1).b))
            {
              f3 = ((bj)localObject1).d;
              paramInt += 1;
              if (paramInt < this.e.size()) {}
              for (localObject1 = (bj)this.e.get(paramInt);; localObject1 = null)
              {
                f1 += f3;
                break;
              }
            }
            localObject1 = a(i1, paramInt);
            paramInt += 1;
            f3 = ((bj)localObject1).d;
            if (paramInt < this.e.size()) {}
            for (localObject1 = (bj)this.e.get(paramInt);; localObject1 = null)
            {
              f1 += f3;
              break;
            }
            label1145:
            localObject1 = null;
            break label521;
            h();
            if (!hasFocus()) {
              break;
            }
            localObject1 = findFocus();
            if (localObject1 != null) {}
            for (localObject1 = b((View)localObject1);; localObject1 = null)
            {
              if ((localObject1 != null) && (((bj)localObject1).b == this.i)) {
                break label1261;
              }
              paramInt = 0;
              for (;;)
              {
                if (paramInt >= getChildCount()) {
                  break label1255;
                }
                localObject1 = getChildAt(paramInt);
                localObject2 = a((View)localObject1);
                if ((localObject2 != null) && (((bj)localObject2).b == this.i) && (((View)localObject1).requestFocus(i2))) {
                  break;
                }
                paramInt += 1;
              }
              label1255:
              break;
            }
            label1261:
            break;
          }
        }
        label1273:
        localObject1 = null;
      }
      localObject2 = null;
    }
  }
  
  protected void a(int paramInt1, float paramFloat, int paramInt2)
  {
    int i1;
    View localView;
    if (this.V > 0)
    {
      int i6 = getScrollX();
      i1 = getPaddingLeft();
      int i2 = getPaddingRight();
      int i7 = getWidth();
      int i8 = getChildCount();
      int i5 = 0;
      while (i5 < i8)
      {
        localView = getChildAt(i5);
        bk localbk = (bk)localView.getLayoutParams();
        int i4;
        int i3;
        if (!localbk.a)
        {
          i4 = i1;
          i3 = i2;
          i5 += 1;
          i1 = i4;
          i2 = i3;
        }
        else
        {
          switch (localbk.b & 0x7)
          {
          case 2: 
          case 4: 
          default: 
            i3 = i1;
            i4 = i2;
            i2 = i1;
            i1 = i4;
          }
          for (;;)
          {
            int i9 = i3 + i6 - localView.getLeft();
            i3 = i1;
            i4 = i2;
            if (i9 == 0) {
              break;
            }
            localView.offsetLeftAndRight(i9);
            i3 = i1;
            i4 = i2;
            break;
            i3 = localView.getWidth();
            i4 = i3 + i1;
            i3 = i1;
            i1 = i2;
            i2 = i4;
            continue;
            i3 = Math.max((i7 - localView.getMeasuredWidth()) / 2, i1);
            i4 = i1;
            i1 = i2;
            i2 = i4;
            continue;
            i3 = i7 - i2 - localView.getMeasuredWidth();
            i9 = localView.getMeasuredWidth();
            i4 = i1;
            i1 = i2 + i9;
            i2 = i4;
          }
        }
      }
    }
    if (this.W != null) {
      this.W.a(paramInt1, paramFloat, paramInt2);
    }
    if (this.Z != null) {
      this.Z.a(paramInt1, paramFloat, paramInt2);
    }
    if (this.ab != null)
    {
      paramInt2 = getScrollX();
      i1 = getChildCount();
      paramInt1 = 0;
      if (paramInt1 < i1)
      {
        localView = getChildAt(paramInt1);
        if (((bk)localView.getLayoutParams()).a) {}
        for (;;)
        {
          paramInt1 += 1;
          break;
          paramFloat = (localView.getLeft() - paramInt2) / getClientWidth();
          this.ab.a(localView, paramFloat);
        }
      }
    }
    this.U = true;
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (getChildCount() == 0)
    {
      setScrollingCacheEnabled(false);
      return;
    }
    int i1 = getScrollX();
    int i2 = getScrollY();
    int i3 = paramInt1 - i1;
    paramInt2 -= i2;
    if ((i3 == 0) && (paramInt2 == 0))
    {
      a(false);
      c();
      setScrollState(0);
      return;
    }
    setScrollingCacheEnabled(true);
    setScrollState(2);
    paramInt1 = getClientWidth();
    int i4 = paramInt1 / 2;
    float f3 = Math.min(1.0F, Math.abs(i3) * 1.0F / paramInt1);
    float f1 = i4;
    float f2 = i4;
    f3 = a(f3);
    paramInt3 = Math.abs(paramInt3);
    if (paramInt3 > 0) {}
    for (paramInt1 = Math.round(1000.0F * Math.abs((f2 * f3 + f1) / paramInt3)) * 4;; paramInt1 = (int)((Math.abs(i3) / (f1 * f2 + this.o) + 1.0F) * 100.0F))
    {
      paramInt1 = Math.min(paramInt1, 600);
      this.m.startScroll(i1, i2, i3, paramInt2, paramInt1);
      ag.b(this);
      return;
      f1 = paramInt1;
      f2 = this.h.a(this.i);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.y = false;
    a(paramInt, paramBoolean, false);
  }
  
  void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    boolean bool = false;
    if ((this.h == null) || (this.h.a() <= 0))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    if ((!paramBoolean2) && (this.i == paramInt1) && (this.e.size() != 0))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    int i1;
    if (paramInt1 < 0) {
      i1 = 0;
    }
    for (;;)
    {
      paramInt1 = this.z;
      if ((i1 <= this.i + paramInt1) && (i1 >= this.i - paramInt1)) {
        break;
      }
      paramInt1 = 0;
      while (paramInt1 < this.e.size())
      {
        ((bj)this.e.get(paramInt1)).c = true;
        paramInt1 += 1;
      }
      i1 = paramInt1;
      if (paramInt1 >= this.h.a()) {
        i1 = this.h.a() - 1;
      }
    }
    paramBoolean2 = bool;
    if (this.i != i1) {
      paramBoolean2 = true;
    }
    if (this.S)
    {
      this.i = i1;
      if ((paramBoolean2) && (this.W != null)) {
        this.W.a(i1);
      }
      if ((paramBoolean2) && (this.Z != null)) {
        this.Z.a(i1);
      }
      requestLayout();
      return;
    }
    a(i1);
    a(i1, paramBoolean1, paramInt2, paramBoolean2);
  }
  
  public boolean a(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0) {
      switch (paramKeyEvent.getKeyCode())
      {
      }
    }
    do
    {
      do
      {
        return false;
        return c(17);
        return c(66);
      } while (Build.VERSION.SDK_INT < 11);
      if (o.a(paramKeyEvent)) {
        return c(2);
      }
    } while (!o.a(paramKeyEvent, 1));
    return c(1);
  }
  
  protected boolean a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1;
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i2 = paramView.getScrollX();
      int i3 = paramView.getScrollY();
      i1 = localViewGroup.getChildCount() - 1;
      if (i1 >= 0)
      {
        localView = localViewGroup.getChildAt(i1);
        if ((paramInt2 + i2 < localView.getLeft()) || (paramInt2 + i2 >= localView.getRight()) || (paramInt3 + i3 < localView.getTop()) || (paramInt3 + i3 >= localView.getBottom()) || (!a(localView, true, paramInt1, paramInt2 + i2 - localView.getLeft(), paramInt3 + i3 - localView.getTop()))) {}
      }
    }
    while ((paramBoolean) && (ag.a(paramView, -paramInt1)))
    {
      View localView;
      return true;
      i1 -= 1;
      break;
    }
    return false;
  }
  
  public void addFocusables(ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    int i2 = paramArrayList.size();
    int i3 = getDescendantFocusability();
    if (i3 != 393216)
    {
      int i1 = 0;
      while (i1 < getChildCount())
      {
        View localView = getChildAt(i1);
        if (localView.getVisibility() == 0)
        {
          bj localbj = a(localView);
          if ((localbj != null) && (localbj.b == this.i)) {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
        i1 += 1;
      }
    }
    if (((i3 == 262144) && (i2 != paramArrayList.size())) || (!isFocusable())) {}
    while ((((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())) || (paramArrayList == null)) {
      return;
    }
    paramArrayList.add(this);
  }
  
  public void addTouchables(ArrayList paramArrayList)
  {
    int i1 = 0;
    while (i1 < getChildCount())
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        bj localbj = a(localView);
        if ((localbj != null) && (localbj.b == this.i)) {
          localView.addTouchables(paramArrayList);
        }
      }
      i1 += 1;
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!checkLayoutParams(paramLayoutParams)) {
      paramLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    for (;;)
    {
      bk localbk = (bk)paramLayoutParams;
      localbk.a |= paramView instanceof bi;
      if (this.w)
      {
        if ((localbk != null) && (localbk.a)) {
          throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        localbk.d = true;
        addViewInLayout(paramView, paramInt, paramLayoutParams);
        return;
      }
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    }
  }
  
  bj b(int paramInt)
  {
    int i1 = 0;
    while (i1 < this.e.size())
    {
      bj localbj = (bj)this.e.get(i1);
      if (localbj.b == paramInt) {
        return localbj;
      }
      i1 += 1;
    }
    return null;
  }
  
  bj b(View paramView)
  {
    for (;;)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent == this) {
        break;
      }
      if ((localViewParent == null) || (!(localViewParent instanceof View))) {
        return null;
      }
      paramView = (View)localViewParent;
    }
    return a(paramView);
  }
  
  void b()
  {
    int i7 = this.h.a();
    this.b = i7;
    int i1;
    int i2;
    int i3;
    int i5;
    int i4;
    label67:
    Object localObject;
    int i6;
    if ((this.e.size() < this.z * 2 + 1) && (this.e.size() < i7))
    {
      i1 = 1;
      i2 = this.i;
      i3 = 0;
      i5 = 0;
      i4 = i1;
      i1 = i2;
      i2 = i3;
      i3 = i5;
      if (i3 >= this.e.size()) {
        break label299;
      }
      localObject = (bj)this.e.get(i3);
      i5 = this.h.a(((bj)localObject).a);
      if (i5 != -1) {
        break label157;
      }
      i5 = i3;
      i6 = i2;
      i3 = i4;
      i2 = i1;
      i1 = i6;
      i4 = i5;
    }
    for (;;)
    {
      i5 = i3;
      i6 = i2;
      i3 = i4 + 1;
      i2 = i1;
      i1 = i6;
      i4 = i5;
      break label67;
      i1 = 0;
      break;
      label157:
      if (i5 == -2)
      {
        this.e.remove(i3);
        i4 = i3 - 1;
        i3 = i2;
        if (i2 == 0)
        {
          this.h.a(this);
          i3 = 1;
        }
        this.h.a(this, ((bj)localObject).b, ((bj)localObject).a);
        if (this.i == ((bj)localObject).b)
        {
          i2 = Math.max(0, Math.min(this.i, i7 - 1));
          i1 = i3;
          i3 = 1;
        }
      }
      else
      {
        if (((bj)localObject).b != i5)
        {
          if (((bj)localObject).b == this.i) {
            i1 = i5;
          }
          ((bj)localObject).b = i5;
          i5 = i1;
          i6 = 1;
          i4 = i3;
          i1 = i2;
          i2 = i5;
          i3 = i6;
          continue;
          label299:
          if (i2 != 0) {
            this.h.b(this);
          }
          Collections.sort(this.e, c);
          if (i4 != 0)
          {
            i3 = getChildCount();
            i2 = 0;
            while (i2 < i3)
            {
              localObject = (bk)getChildAt(i2).getLayoutParams();
              if (!((bk)localObject).a) {
                ((bk)localObject).c = 0.0F;
              }
              i2 += 1;
            }
            a(i1, false, true);
            requestLayout();
          }
          return;
        }
        i5 = i1;
        i6 = i4;
        i4 = i3;
        i1 = i2;
        i2 = i5;
        i3 = i6;
        continue;
      }
      i2 = i1;
      i5 = 1;
      i1 = i3;
      i3 = i5;
    }
  }
  
  void c()
  {
    a(this.i);
  }
  
  public boolean c(int paramInt)
  {
    View localView = findFocus();
    Object localObject;
    int i2;
    boolean bool;
    if (localView == this)
    {
      localObject = null;
      localView = FocusFinder.getInstance().findNextFocus(this, (View)localObject, paramInt);
      if ((localView == null) || (localView == localObject)) {
        break label329;
      }
      if (paramInt != 17) {
        break label266;
      }
      i1 = a(this.g, localView).left;
      i2 = a(this.g, (View)localObject).left;
      if ((localObject != null) && (i1 >= i2))
      {
        bool = d();
        label89:
        if (bool) {
          playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
        }
        return bool;
      }
    }
    else
    {
      if (localView == null) {
        break label375;
      }
      localObject = localView.getParent();
      if (!(localObject instanceof ViewGroup)) {
        break label382;
      }
      if (localObject != this) {}
    }
    label266:
    label329:
    label375:
    label382:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localView.getClass().getSimpleName());
        localObject = localView.getParent();
        for (;;)
        {
          if ((localObject instanceof ViewGroup))
          {
            localStringBuilder.append(" => ").append(localObject.getClass().getSimpleName());
            localObject = ((ViewParent)localObject).getParent();
            continue;
            localObject = ((ViewParent)localObject).getParent();
            break;
          }
        }
        Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + localStringBuilder.toString());
        localObject = null;
        break;
        bool = localView.requestFocus();
        break label89;
        if (paramInt == 66)
        {
          i1 = a(this.g, localView).left;
          i2 = a(this.g, (View)localObject).left;
          if ((localObject != null) && (i1 <= i2))
          {
            bool = e();
            break label89;
          }
          bool = localView.requestFocus();
          break label89;
          if ((paramInt == 17) || (paramInt == 1))
          {
            bool = d();
            break label89;
          }
          if ((paramInt == 66) || (paramInt == 2))
          {
            bool = e();
            break label89;
          }
        }
        bool = false;
        break label89;
      }
      localObject = localView;
      break;
    }
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (this.h == null) {}
    int i1;
    int i2;
    do
    {
      return false;
      i1 = getClientWidth();
      i2 = getScrollX();
      if (paramInt < 0)
      {
        if (i2 > (int)(i1 * this.s)) {}
        for (;;)
        {
          return bool1;
          bool1 = false;
        }
      }
    } while (paramInt <= 0);
    if (i2 < (int)(i1 * this.t)) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof bk)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    if ((!this.m.isFinished()) && (this.m.computeScrollOffset()))
    {
      int i1 = getScrollX();
      int i2 = getScrollY();
      int i3 = this.m.getCurrX();
      int i4 = this.m.getCurrY();
      if ((i1 != i3) || (i2 != i4))
      {
        scrollTo(i3, i4);
        if (!d(i3))
        {
          this.m.abortAnimation();
          scrollTo(0, i4);
        }
      }
      ag.b(this);
      return;
    }
    a(true);
  }
  
  boolean d()
  {
    if (this.i > 0)
    {
      a(this.i - 1, true);
      return true;
    }
    return false;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (a(paramKeyEvent));
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramAccessibilityEvent.getEventType() == 4096)
    {
      bool1 = super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
      return bool1;
    }
    int i2 = getChildCount();
    int i1 = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i1 >= i2) {
        break;
      }
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        bj localbj = a(localView);
        if ((localbj != null) && (localbj.b == this.i) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
          return true;
        }
      }
      i1 += 1;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i3 = 0;
    int i1 = 0;
    int i4 = ag.a(this);
    boolean bool;
    if ((i4 == 0) || ((i4 == 1) && (this.h != null) && (this.h.a() > 1)))
    {
      int i2;
      if (!this.Q.a())
      {
        i3 = paramCanvas.save();
        i1 = getHeight() - getPaddingTop() - getPaddingBottom();
        i4 = getWidth();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(-i1 + getPaddingTop(), this.s * i4);
        this.Q.a(i1, i4);
        i2 = false | this.Q.a(paramCanvas);
        paramCanvas.restoreToCount(i3);
      }
      i3 = i2;
      if (!this.R.a())
      {
        i4 = paramCanvas.save();
        i3 = getWidth();
        int i5 = getHeight();
        int i6 = getPaddingTop();
        int i7 = getPaddingBottom();
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-getPaddingTop(), -(this.t + 1.0F) * i3);
        this.R.a(i5 - i6 - i7, i3);
        bool = i2 | this.R.a(paramCanvas);
        paramCanvas.restoreToCount(i4);
      }
    }
    for (;;)
    {
      if (bool) {
        ag.b(this);
      }
      return;
      this.Q.b();
      this.R.b();
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.p;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  boolean e()
  {
    if ((this.h != null) && (this.i < this.h.a() - 1))
    {
      a(this.i + 1, true);
      return true;
    }
    return false;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new bk();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new bk(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return generateDefaultLayoutParams();
  }
  
  public aa getAdapter()
  {
    return this.h;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i1 = paramInt2;
    if (this.ad == 2) {
      i1 = paramInt1 - 1 - paramInt2;
    }
    return ((bk)((View)this.ae.get(i1)).getLayoutParams()).f;
  }
  
  public int getCurrentItem()
  {
    return this.i;
  }
  
  public int getOffscreenPageLimit()
  {
    return this.z;
  }
  
  public int getPageMargin()
  {
    return this.o;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.S = true;
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.ag);
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i3;
    int i4;
    float f3;
    Object localObject;
    float f1;
    int i5;
    int i1;
    int i6;
    int i2;
    if ((this.o > 0) && (this.p != null) && (this.e.size() > 0) && (this.h != null))
    {
      i3 = getScrollX();
      i4 = getWidth();
      f3 = this.o / i4;
      localObject = (bj)this.e.get(0);
      f1 = ((bj)localObject).e;
      i5 = this.e.size();
      i1 = ((bj)localObject).b;
      i6 = ((bj)this.e.get(i5 - 1)).b;
      i2 = 0;
    }
    for (;;)
    {
      float f2;
      if (i1 < i6)
      {
        while ((i1 > ((bj)localObject).b) && (i2 < i5))
        {
          localObject = this.e;
          i2 += 1;
          localObject = (bj)((ArrayList)localObject).get(i2);
        }
        if (i1 != ((bj)localObject).b) {
          break label271;
        }
        f2 = (((bj)localObject).e + ((bj)localObject).d) * i4;
      }
      label271:
      float f4;
      for (f1 = ((bj)localObject).e + ((bj)localObject).d + f3;; f1 += f4 + f3)
      {
        if (this.o + f2 > i3)
        {
          this.p.setBounds((int)f2, this.q, (int)(this.o + f2 + 0.5F), this.r);
          this.p.draw(paramCanvas);
        }
        if (f2 <= i3 + i4) {
          break;
        }
        return;
        f4 = this.h.a(i1);
        f2 = (f1 + f4) * i4;
      }
      i1 += 1;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if ((i1 == 3) || (i1 == 1))
    {
      this.A = false;
      this.B = false;
      this.J = -1;
      if (this.K != null)
      {
        this.K.recycle();
        this.K = null;
      }
    }
    do
    {
      return false;
      if (i1 == 0) {
        break;
      }
      if (this.A) {
        return true;
      }
    } while (this.B);
    switch (i1)
    {
    }
    for (;;)
    {
      if (this.K == null) {
        this.K = VelocityTracker.obtain();
      }
      this.K.addMovement(paramMotionEvent);
      return this.A;
      i1 = this.J;
      if (i1 != -1)
      {
        i1 = v.a(paramMotionEvent, i1);
        float f2 = v.c(paramMotionEvent, i1);
        float f1 = f2 - this.F;
        float f4 = Math.abs(f1);
        float f3 = v.d(paramMotionEvent, i1);
        float f5 = Math.abs(f3 - this.I);
        if ((f1 != 0.0F) && (!a(this.F, f1)) && (a(this, false, (int)f1, (int)f2, (int)f3)))
        {
          this.F = f2;
          this.G = f3;
          this.B = true;
          return false;
        }
        if ((f4 > this.E) && (0.5F * f4 > f5))
        {
          this.A = true;
          c(true);
          setScrollState(1);
          if (f1 > 0.0F)
          {
            f1 = this.H + this.E;
            label310:
            this.F = f1;
            this.G = f3;
            setScrollingCacheEnabled(true);
          }
        }
        while ((this.A) && (b(f2)))
        {
          ag.b(this);
          break;
          f1 = this.H - this.E;
          break label310;
          if (f5 > this.E) {
            this.B = true;
          }
        }
        f1 = paramMotionEvent.getX();
        this.H = f1;
        this.F = f1;
        f1 = paramMotionEvent.getY();
        this.I = f1;
        this.G = f1;
        this.J = v.b(paramMotionEvent, 0);
        this.B = false;
        this.m.computeScrollOffset();
        if ((this.ah == 2) && (Math.abs(this.m.getFinalX() - this.m.getCurrX()) > this.O))
        {
          this.m.abortAnimation();
          this.y = false;
          c();
          this.A = true;
          c(true);
          setScrollState(1);
        }
        else
        {
          a(false);
          this.A = false;
          continue;
          a(paramMotionEvent);
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i6 = getChildCount();
    int i8 = paramInt3 - paramInt1;
    int i7 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    int i1 = getPaddingRight();
    paramInt3 = getPaddingBottom();
    int i9 = getScrollX();
    int i2 = 0;
    int i4 = 0;
    View localView;
    bk localbk;
    int i10;
    int i3;
    label154:
    int i5;
    if (i4 < i6)
    {
      localView = getChildAt(i4);
      if (localView.getVisibility() == 8) {
        break label671;
      }
      localbk = (bk)localView.getLayoutParams();
      if (!localbk.a) {
        break label671;
      }
      paramInt4 = localbk.b;
      i10 = localbk.b;
      switch (paramInt4 & 0x7)
      {
      case 2: 
      case 4: 
      default: 
        paramInt4 = paramInt2;
        i3 = paramInt2;
        switch (i10 & 0x70)
        {
        default: 
          i5 = paramInt1;
          paramInt2 = paramInt1;
          paramInt1 = paramInt3;
          paramInt3 = i5;
          label204:
          paramInt4 += i9;
          localView.layout(paramInt4, paramInt3, localView.getMeasuredWidth() + paramInt4, localView.getMeasuredHeight() + paramInt3);
          i2 += 1;
          paramInt4 = i1;
          paramInt3 = i3;
          i1 = paramInt1;
          paramInt1 = i2;
        }
        break;
      }
    }
    for (;;)
    {
      i4 += 1;
      i3 = paramInt3;
      i2 = paramInt1;
      paramInt1 = paramInt2;
      paramInt3 = i1;
      i1 = paramInt4;
      paramInt2 = i3;
      break;
      i3 = localView.getMeasuredWidth();
      paramInt4 = paramInt2;
      i3 += paramInt2;
      break label154;
      paramInt4 = Math.max((i8 - localView.getMeasuredWidth()) / 2, paramInt2);
      i3 = paramInt2;
      break label154;
      i3 = localView.getMeasuredWidth();
      paramInt4 = i1 + localView.getMeasuredWidth();
      i5 = i8 - i1 - i3;
      i1 = paramInt4;
      i3 = paramInt2;
      paramInt4 = i5;
      break label154;
      i5 = localView.getMeasuredHeight();
      paramInt2 = paramInt3;
      i5 += paramInt1;
      paramInt3 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = i5;
      break label204;
      i5 = Math.max((i7 - localView.getMeasuredHeight()) / 2, paramInt1);
      paramInt2 = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = i5;
      break label204;
      i5 = i7 - paramInt3 - localView.getMeasuredHeight();
      i10 = localView.getMeasuredHeight();
      paramInt2 = paramInt1;
      paramInt1 = paramInt3 + i10;
      paramInt3 = i5;
      break label204;
      i1 = i8 - paramInt2 - i1;
      paramInt4 = 0;
      while (paramInt4 < i6)
      {
        localView = getChildAt(paramInt4);
        if (localView.getVisibility() != 8)
        {
          localbk = (bk)localView.getLayoutParams();
          if (!localbk.a)
          {
            bj localbj = a(localView);
            if (localbj != null)
            {
              float f1 = i1;
              i3 = (int)(localbj.e * f1) + paramInt2;
              if (localbk.d)
              {
                localbk.d = false;
                f1 = i1;
                localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localbk.c * f1), 1073741824), View.MeasureSpec.makeMeasureSpec(i7 - paramInt1 - paramInt3, 1073741824));
              }
              localView.layout(i3, paramInt1, localView.getMeasuredWidth() + i3, localView.getMeasuredHeight() + paramInt1);
            }
          }
        }
        paramInt4 += 1;
      }
      this.q = paramInt1;
      this.r = (i7 - paramInt3);
      this.V = i2;
      if (this.S) {
        a(this.i, false, 0, false);
      }
      this.S = false;
      return;
      label671:
      paramInt4 = i2;
      i2 = paramInt1;
      i3 = paramInt2;
      paramInt1 = paramInt4;
      paramInt4 = i1;
      i1 = paramInt3;
      paramInt2 = i2;
      paramInt3 = i3;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredWidth();
    this.D = Math.min(paramInt1 / 10, this.C);
    paramInt1 = paramInt1 - getPaddingLeft() - getPaddingRight();
    paramInt2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int i9 = getChildCount();
    int i3 = 0;
    View localView;
    int i1;
    int i2;
    bk localbk;
    int i4;
    int i6;
    label183:
    int i5;
    if (i3 < i9)
    {
      localView = getChildAt(i3);
      i1 = paramInt1;
      i2 = paramInt2;
      if (localView.getVisibility() != 8)
      {
        localbk = (bk)localView.getLayoutParams();
        i1 = paramInt1;
        i2 = paramInt2;
        if (localbk != null)
        {
          i1 = paramInt1;
          i2 = paramInt2;
          if (localbk.a)
          {
            i1 = localbk.b & 0x7;
            i4 = localbk.b & 0x70;
            i6 = Integer.MIN_VALUE;
            i2 = Integer.MIN_VALUE;
            if ((i4 != 48) && (i4 != 80)) {
              break label333;
            }
            i4 = 1;
            if ((i1 != 3) && (i1 != 5)) {
              break label339;
            }
            i5 = 1;
            label198:
            if (i4 == 0) {
              break label345;
            }
            i1 = 1073741824;
            label208:
            if (localbk.width == -2) {
              break label528;
            }
            i6 = 1073741824;
            if (localbk.width == -1) {
              break label522;
            }
            i1 = localbk.width;
          }
        }
      }
    }
    for (;;)
    {
      int i8;
      if (localbk.height != -2)
      {
        i7 = 1073741824;
        i2 = i7;
        if (localbk.height != -1)
        {
          i8 = localbk.height;
          i2 = i7;
        }
      }
      for (int i7 = i8;; i7 = paramInt2)
      {
        localView.measure(View.MeasureSpec.makeMeasureSpec(i1, i6), View.MeasureSpec.makeMeasureSpec(i7, i2));
        if (i4 != 0)
        {
          i2 = paramInt2 - localView.getMeasuredHeight();
          i1 = paramInt1;
        }
        for (;;)
        {
          i3 += 1;
          paramInt1 = i1;
          paramInt2 = i2;
          break;
          label333:
          i4 = 0;
          break label183;
          label339:
          i5 = 0;
          break label198;
          label345:
          i1 = i6;
          if (i5 == 0) {
            break label208;
          }
          i2 = 1073741824;
          i1 = i6;
          break label208;
          i1 = paramInt1;
          i2 = paramInt2;
          if (i5 != 0)
          {
            i1 = paramInt1 - localView.getMeasuredWidth();
            i2 = paramInt2;
          }
        }
        this.u = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
        this.v = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
        this.w = true;
        c();
        this.w = false;
        i1 = getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i1)
        {
          localView = getChildAt(paramInt2);
          if (localView.getVisibility() != 8)
          {
            localbk = (bk)localView.getLayoutParams();
            if ((localbk == null) || (!localbk.a))
            {
              float f1 = paramInt1;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localbk.c * f1), 1073741824), this.v);
            }
          }
          paramInt2 += 1;
        }
        return;
      }
      label522:
      i1 = paramInt1;
      continue;
      label528:
      i6 = i1;
      i1 = paramInt1;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i3 = -1;
    int i2 = getChildCount();
    int i1;
    if ((paramInt & 0x2) != 0)
    {
      i3 = 1;
      i1 = 0;
    }
    while (i1 != i2)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        bj localbj = a(localView);
        if ((localbj != null) && (localbj.b == this.i) && (localView.requestFocus(paramInt, paramRect)))
        {
          return true;
          i1 = i2 - 1;
          i2 = -1;
          continue;
        }
      }
      i1 += i3;
    }
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof ViewPager.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (ViewPager.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (this.h != null)
    {
      this.h.a(paramParcelable.b, paramParcelable.c);
      a(paramParcelable.a, false, true);
      return;
    }
    this.j = paramParcelable.a;
    this.k = paramParcelable.b;
    this.l = paramParcelable.c;
  }
  
  public Parcelable onSaveInstanceState()
  {
    ViewPager.SavedState localSavedState = new ViewPager.SavedState(super.onSaveInstanceState());
    localSavedState.a = this.i;
    if (this.h != null) {
      localSavedState.b = this.h.b();
    }
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      a(paramInt1, paramInt3, this.o, this.o);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i4 = 0;
    if (this.P) {
      return true;
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    if ((this.h == null) || (this.h.a() == 0)) {
      return false;
    }
    if (this.K == null) {
      this.K = VelocityTracker.obtain();
    }
    this.K.addMovement(paramMotionEvent);
    int i1 = i4;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      i1 = i4;
    }
    for (;;)
    {
      if (i1 != 0) {
        ag.b(this);
      }
      return true;
      this.m.abortAnimation();
      this.y = false;
      c();
      float f1 = paramMotionEvent.getX();
      this.H = f1;
      this.F = f1;
      f1 = paramMotionEvent.getY();
      this.I = f1;
      this.G = f1;
      this.J = v.b(paramMotionEvent, 0);
      i1 = i4;
      continue;
      float f2;
      if (!this.A)
      {
        i1 = v.a(paramMotionEvent, this.J);
        f1 = v.c(paramMotionEvent, i1);
        float f3 = Math.abs(f1 - this.F);
        f2 = v.d(paramMotionEvent, i1);
        float f4 = Math.abs(f2 - this.G);
        if ((f3 > this.E) && (f3 > f4))
        {
          this.A = true;
          c(true);
          if (f1 - this.H <= 0.0F) {
            break label378;
          }
        }
      }
      Object localObject;
      label378:
      for (f1 = this.H + this.E;; f1 = this.H - this.E)
      {
        this.F = f1;
        this.G = f2;
        setScrollState(1);
        setScrollingCacheEnabled(true);
        localObject = getParent();
        if (localObject != null) {
          ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
        }
        i1 = i4;
        if (!this.A) {
          break;
        }
        bool1 = false | b(v.c(paramMotionEvent, v.a(paramMotionEvent, this.J)));
        break;
      }
      boolean bool1 = i4;
      if (this.A)
      {
        localObject = this.K;
        ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.M);
        int i2 = (int)ab.a((VelocityTracker)localObject, this.J);
        this.y = true;
        i4 = getClientWidth();
        int i5 = getScrollX();
        localObject = i();
        a(a(((bj)localObject).b, (i5 / i4 - ((bj)localObject).e) / ((bj)localObject).d, i2, (int)(v.c(paramMotionEvent, v.a(paramMotionEvent, this.J)) - this.H)), true, true, i2);
        this.J = -1;
        j();
        boolean bool3 = this.Q.c();
        boolean bool2 = this.R.c() | bool3;
        continue;
        bool2 = i4;
        if (this.A)
        {
          a(this.i, true, 0, false);
          this.J = -1;
          j();
          bool3 = this.Q.c();
          bool2 = this.R.c() | bool3;
          continue;
          int i3 = v.b(paramMotionEvent);
          this.F = v.c(paramMotionEvent, i3);
          this.J = v.b(paramMotionEvent, i3);
          i3 = i4;
          continue;
          a(paramMotionEvent);
          this.F = v.c(paramMotionEvent, v.a(paramMotionEvent, this.J));
          i3 = i4;
        }
      }
    }
  }
  
  public void removeView(View paramView)
  {
    if (this.w)
    {
      removeViewInLayout(paramView);
      return;
    }
    super.removeView(paramView);
  }
  
  public void setAdapter(aa paramaa)
  {
    if (this.h != null)
    {
      this.h.b(this.n);
      this.h.a(this);
      int i1 = 0;
      while (i1 < this.e.size())
      {
        localObject = (bj)this.e.get(i1);
        this.h.a(this, ((bj)localObject).b, ((bj)localObject).a);
        i1 += 1;
      }
      this.h.b(this);
      this.e.clear();
      g();
      this.i = 0;
      scrollTo(0, 0);
    }
    Object localObject = this.h;
    this.h = paramaa;
    this.b = 0;
    boolean bool;
    if (this.h != null)
    {
      if (this.n == null) {
        this.n = new bp(this, null);
      }
      this.h.a(this.n);
      this.y = false;
      bool = this.S;
      this.S = true;
      this.b = this.h.a();
      if (this.j < 0) {
        break label260;
      }
      this.h.a(this.k, this.l);
      a(this.j, false, true);
      this.j = -1;
      this.k = null;
      this.l = null;
    }
    for (;;)
    {
      if ((this.aa != null) && (localObject != paramaa)) {
        this.aa.a((aa)localObject, paramaa);
      }
      return;
      label260:
      if (!bool) {
        c();
      } else {
        requestLayout();
      }
    }
  }
  
  void setChildrenDrawingOrderEnabledCompat(boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT < 7) || (this.ac == null)) {}
    try
    {
      this.ac = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] { Boolean.TYPE });
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        try
        {
          this.ac.invoke(this, new Object[] { Boolean.valueOf(paramBoolean) });
          return;
        }
        catch (Exception localException)
        {
          Log.e("ViewPager", "Error changing children drawing order", localException);
        }
        localNoSuchMethodException = localNoSuchMethodException;
        Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", localNoSuchMethodException);
      }
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.y = false;
    if (!this.S) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramInt, bool, false);
      return;
    }
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 1)
    {
      Log.w("ViewPager", "Requested offscreen page limit " + paramInt + " too small; defaulting to " + 1);
      i1 = 1;
    }
    if (i1 != this.z)
    {
      this.z = i1;
      c();
    }
  }
  
  void setOnAdapterChangeListener(bm parambm)
  {
    this.aa = parambm;
  }
  
  public void setOnPageChangeListener(bn parambn)
  {
    this.W = parambn;
  }
  
  public void setPageMargin(int paramInt)
  {
    int i1 = this.o;
    this.o = paramInt;
    int i2 = getWidth();
    a(i2, i2, paramInt, i1);
    requestLayout();
  }
  
  public void setPageMarginDrawable(int paramInt)
  {
    setPageMarginDrawable(getContext().getResources().getDrawable(paramInt));
  }
  
  public void setPageMarginDrawable(Drawable paramDrawable)
  {
    this.p = paramDrawable;
    if (paramDrawable != null) {
      refreshDrawableState();
    }
    if (paramDrawable == null) {}
    for (boolean bool = true;; bool = false)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.p);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/view/ViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */