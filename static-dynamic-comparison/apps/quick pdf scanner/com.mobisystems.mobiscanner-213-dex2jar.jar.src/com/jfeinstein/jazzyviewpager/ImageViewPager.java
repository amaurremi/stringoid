package com.jfeinstein.jazzyviewpager;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.a.b;
import android.support.v4.view.a.h;
import android.support.v4.view.g;
import android.support.v4.view.j;
import android.support.v4.view.l;
import android.support.v4.view.n;
import android.support.v4.view.p;
import android.support.v4.view.w;
import android.support.v4.widget.c;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ImageViewPager
  extends ViewGroup
{
  private static final i alA = new i();
  private static final int[] bG = { 16842931 };
  private static final Comparator<b> bI = new Comparator()
  {
    public int a(ImageViewPager.b paramAnonymousb1, ImageViewPager.b paramAnonymousb2)
    {
      return paramAnonymousb1.position - paramAnonymousb2.position;
    }
  };
  private static final Interpolator bJ = new Interpolator()
  {
    public float getInterpolation(float paramAnonymousFloat)
    {
      paramAnonymousFloat -= 1.0F;
      return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
    }
  };
  private VelocityTracker aO;
  private final b alu = new b();
  private h alv;
  private f alw;
  private f alx;
  private e aly;
  private g alz;
  private int bH;
  private l bL;
  private int bM;
  private int bN = -1;
  private Parcelable bO = null;
  private ClassLoader bP = null;
  private Scroller bQ;
  private int bS;
  private Drawable bT;
  private int bU;
  private int bV;
  private float bW = -3.4028235E38F;
  private float bX = Float.MAX_VALUE;
  private int bY;
  private int bZ;
  private float bg;
  private float bh;
  private int bi;
  private int bz = 0;
  private ArrayList<View> cA;
  private final Runnable cC = new Runnable()
  {
    public void run()
    {
      ImageViewPager.a(ImageViewPager.this, 0);
      ImageViewPager.this.H();
    }
  };
  private boolean ca;
  private boolean cb;
  private int cc = 1;
  private boolean cd;
  private boolean ce;
  private int cf;
  private int cg;
  private float ch;
  private float ci;
  private int cj = -1;
  private int ck;
  private int cl;
  private int cm;
  private int cn;
  private boolean co;
  private c cp;
  private c cq;
  private boolean cr = true;
  private boolean cs = false;
  private boolean ct;
  private int cu;
  private int cz;
  private boolean mInLayout;
  private final ArrayList<b> mItems = new ArrayList();
  private final Rect mTempRect = new Rect();
  
  public ImageViewPager(Context paramContext)
  {
    super(paramContext);
    B();
  }
  
  public ImageViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    B();
  }
  
  private void C()
  {
    int j;
    for (int i = 0; i < getChildCount(); i = j + 1)
    {
      j = i;
      if (!((c)getChildAt(i).getLayoutParams()).cI)
      {
        removeViewAt(i);
        j = i - 1;
      }
    }
  }
  
  private b Cv()
  {
    int i = E();
    float f1;
    float f2;
    label36:
    float f4;
    float f3;
    int k;
    int j;
    Object localObject1;
    label53:
    Object localObject2;
    b localb;
    if (i > 0)
    {
      f1 = getScrollX() / i;
      if (i <= 0) {
        break label214;
      }
      f2 = this.bS / i;
      f4 = 0.0F;
      f3 = 0.0F;
      k = -1;
      i = 0;
      j = 1;
      localObject1 = null;
      localObject2 = localObject1;
      if (i < this.mItems.size())
      {
        localb = (b)this.mItems.get(i);
        if ((j != 0) || (localb.position == k + 1)) {
          break label249;
        }
        localb = this.alu;
        localb.cH = (f4 + f3 + f2);
        localb.position = (k + 1);
        localb.cG = this.bL.getPageWidth(localb.position);
        i -= 1;
      }
    }
    label214:
    label219:
    label249:
    for (;;)
    {
      f3 = localb.cH;
      f4 = localb.cG;
      if (j == 0)
      {
        localObject2 = localObject1;
        if (f1 < f3) {}
      }
      else
      {
        if ((f1 >= f4 + f3 + f2) && (i != this.mItems.size() - 1)) {
          break label219;
        }
        localObject2 = localb;
      }
      return (b)localObject2;
      f1 = 0.0F;
      break;
      f2 = 0.0F;
      break label36;
      k = localb.position;
      f4 = localb.cG;
      j = 0;
      i += 1;
      localObject1 = localb;
      break label53;
    }
  }
  
  private int E()
  {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private void I()
  {
    if (this.cz != 0)
    {
      if (this.cA == null) {
        this.cA = new ArrayList();
      }
      for (;;)
      {
        int j = getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = getChildAt(i);
          this.cA.add(localView);
          i += 1;
        }
        this.cA.clear();
      }
      Collections.sort(this.cA, alA);
    }
  }
  
  private void K()
  {
    this.cd = false;
    this.ce = false;
    if (this.aO != null)
    {
      this.aO.recycle();
      this.aO = null;
    }
  }
  
  private int a(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if ((Math.abs(paramInt3) > this.cm) && (Math.abs(paramInt2) > this.ck))
    {
      if (paramInt2 > 0) {}
      for (;;)
      {
        paramInt2 = paramInt1;
        if (this.mItems.size() > 0)
        {
          b localb1 = (b)this.mItems.get(0);
          b localb2 = (b)this.mItems.get(this.mItems.size() - 1);
          paramInt2 = Math.max(localb1.position, Math.min(paramInt1, localb2.position));
        }
        return paramInt2;
        paramInt1 += 1;
      }
    }
    if (paramInt1 >= this.bM) {}
    for (float f = 0.4F;; f = 0.6F)
    {
      paramInt1 = (int)(f + (paramInt1 + paramFloat));
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
  
  private void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    b localb = fC(paramInt1);
    float f;
    if (localb != null) {
      f = E();
    }
    for (int i = (int)(Math.max(this.bW, Math.min(localb.cH, this.bX)) * f);; i = 0)
    {
      if (paramBoolean1)
      {
        a(i, 0, paramInt2);
        if ((paramBoolean2) && (this.alw != null)) {
          this.alw.g(paramInt1);
        }
        if ((paramBoolean2) && (this.alx != null)) {
          this.alx.g(paramInt1);
        }
        return;
      }
      if ((paramBoolean2) && (this.alw != null)) {
        this.alw.g(paramInt1);
      }
      if ((paramBoolean2) && (this.alx != null)) {
        this.alx.g(paramInt1);
      }
      a(false);
      scrollTo(i, 0);
      n(i);
      return;
    }
  }
  
  private void a(b paramb1, int paramInt, b paramb2)
  {
    int m = this.bL.getCount();
    int i = E();
    float f2;
    if (i > 0)
    {
      f2 = this.bS / i;
      if (paramb2 == null) {
        break label409;
      }
      i = paramb2.position;
      if (i < paramb1.position)
      {
        f1 = paramb2.cH + paramb2.cG + f2;
        i += 1;
        j = 0;
      }
    }
    else
    {
      for (;;)
      {
        if ((i > paramb1.position) || (j >= this.mItems.size())) {
          break label409;
        }
        for (paramb2 = (b)this.mItems.get(j);; paramb2 = (b)this.mItems.get(j))
        {
          k = i;
          f3 = f1;
          if (i <= paramb2.position) {
            break;
          }
          k = i;
          f3 = f1;
          if (j >= this.mItems.size() - 1) {
            break;
          }
          j += 1;
        }
        f2 = 0.0F;
        break;
        while (k < paramb2.position)
        {
          f3 += this.bL.getPageWidth(k) + f2;
          k += 1;
        }
        paramb2.cH = f3;
        f1 = f3 + (paramb2.cG + f2);
        i = k + 1;
      }
    }
    if (i > paramb1.position)
    {
      j = this.mItems.size() - 1;
      f1 = paramb2.cH;
      i -= 1;
      while ((i >= paramb1.position) && (j >= 0))
      {
        for (paramb2 = (b)this.mItems.get(j);; paramb2 = (b)this.mItems.get(j))
        {
          k = i;
          f3 = f1;
          if (i >= paramb2.position) {
            break;
          }
          k = i;
          f3 = f1;
          if (j <= 0) {
            break;
          }
          j -= 1;
        }
        while (k > paramb2.position)
        {
          f3 -= this.bL.getPageWidth(k) + f2;
          k -= 1;
        }
        f1 = f3 - (paramb2.cG + f2);
        paramb2.cH = f1;
        i = k - 1;
      }
    }
    label409:
    int k = this.mItems.size();
    float f3 = paramb1.cH;
    i = paramb1.position - 1;
    if (paramb1.position == 0)
    {
      f1 = paramb1.cH;
      this.bW = f1;
      if (paramb1.position != m - 1) {
        break label550;
      }
      f1 = paramb1.cH + paramb1.cG - 1.0F;
      label475:
      this.bX = f1;
      j = paramInt - 1;
      f1 = f3;
    }
    for (;;)
    {
      if (j < 0) {
        break label603;
      }
      paramb2 = (b)this.mItems.get(j);
      for (;;)
      {
        if (i > paramb2.position)
        {
          f1 -= this.bL.getPageWidth(i) + f2;
          i -= 1;
          continue;
          f1 = -3.4028235E38F;
          break;
          label550:
          f1 = Float.MAX_VALUE;
          break label475;
        }
      }
      f1 -= paramb2.cG + f2;
      paramb2.cH = f1;
      if (paramb2.position == 0) {
        this.bW = f1;
      }
      i -= 1;
      j -= 1;
    }
    label603:
    float f1 = paramb1.cH + paramb1.cG + f2;
    int j = paramb1.position + 1;
    i = paramInt + 1;
    paramInt = j;
    while (i < k)
    {
      paramb1 = (b)this.mItems.get(i);
      while (paramInt < paramb1.position)
      {
        f1 = this.bL.getPageWidth(paramInt) + f2 + f1;
        paramInt += 1;
      }
      if (paramb1.position == m - 1) {
        this.bX = (paramb1.cG + f1 - 1.0F);
      }
      paramb1.cH = f1;
      f1 += paramb1.cG + f2;
      paramInt += 1;
      i += 1;
    }
    this.cs = false;
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.bz == 2) {}
    int j;
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        setScrollingCacheEnabled(false);
        this.bQ.abortAnimation();
        j = getScrollX();
        k = getScrollY();
        int m = this.bQ.getCurrX();
        int n = this.bQ.getCurrY();
        if ((j != m) || (k != n)) {
          scrollTo(m, n);
        }
      }
      this.cb = false;
      int k = 0;
      j = i;
      i = k;
      while (i < this.mItems.size())
      {
        b localb = (b)this.mItems.get(i);
        if (localb.cF)
        {
          localb.cF = false;
          j = 1;
        }
        i += 1;
      }
    }
    if (j != 0)
    {
      if (paramBoolean) {
        p.a(this, this.cC);
      }
    }
    else {
      return;
    }
    this.cC.run();
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return ((paramFloat1 < this.cg) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getWidth() - this.cg) && (paramFloat2 < 0.0F));
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 > 0) && (!this.mItems.isEmpty()))
    {
      int i = getPaddingLeft();
      int j = getPaddingRight();
      int k = getPaddingLeft();
      int m = getPaddingRight();
      f = getScrollX() / (paramInt2 - k - m + paramInt4);
      paramInt2 = (int)((paramInt1 - i - j + paramInt3) * f);
      scrollTo(paramInt2, getScrollY());
      if (!this.bQ.isFinished())
      {
        paramInt3 = this.bQ.getDuration();
        paramInt4 = this.bQ.timePassed();
        localb = fC(this.bM);
        this.bQ.startScroll(paramInt2, 0, (int)(localb.cH * paramInt1), 0, paramInt3 - paramInt4);
      }
      return;
    }
    b localb = fC(this.bM);
    if (localb != null) {}
    for (float f = Math.min(localb.cH, this.bX);; f = 0.0F)
    {
      paramInt1 = (int)(f * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (paramInt1 == getScrollX()) {
        break;
      }
      a(false);
      scrollTo(paramInt1, getScrollY());
      return;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    int k = getChildCount();
    int i = 0;
    if (i < k)
    {
      if (paramBoolean) {}
      for (int j = 2;; j = 0)
      {
        p.a(getChildAt(i), j, null);
        i += 1;
        break;
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
  
  private boolean c(float paramFloat)
  {
    int j = 1;
    boolean bool2 = false;
    boolean bool1 = false;
    float f1 = this.ch;
    this.ch = paramFloat;
    float f2 = getScrollX() + (f1 - paramFloat);
    int k = E();
    paramFloat = k * this.bW;
    f1 = k;
    float f3 = this.bX;
    b localb1 = (b)this.mItems.get(0);
    b localb2 = (b)this.mItems.get(this.mItems.size() - 1);
    if (localb1.position != 0) {
      paramFloat = localb1.cH * k;
    }
    for (int i = 0;; i = 1)
    {
      if (localb2.position != this.bL.getCount() - 1)
      {
        f1 = localb2.cH * k;
        j = 0;
      }
      for (;;)
      {
        if (f2 < paramFloat)
        {
          f1 = paramFloat;
          if (i != 0)
          {
            bool1 = this.cp.d(Math.abs(paramFloat - f2) / k);
            f1 = paramFloat;
          }
        }
        for (;;)
        {
          this.ch += f1 - (int)f1;
          scrollTo((int)f1, getScrollY());
          n((int)f1);
          return bool1;
          if (f2 > f1)
          {
            bool1 = bool2;
            if (j != 0) {
              bool1 = this.cq.d(Math.abs(f2 - f1) / k);
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
  
  private void d(MotionEvent paramMotionEvent)
  {
    int i = j.b(paramMotionEvent);
    if (j.b(paramMotionEvent, i) == this.cj) {
      if (i != 0) {
        break label56;
      }
    }
    label56:
    for (i = 1;; i = 0)
    {
      this.ch = j.c(paramMotionEvent, i);
      this.cj = j.b(paramMotionEvent, i);
      if (this.aO != null) {
        this.aO.clear();
      }
      return;
    }
  }
  
  private void i(int paramInt)
  {
    if (this.bz == paramInt) {
      return;
    }
    this.bz = paramInt;
    if (this.alz != null) {
      if (paramInt == 0) {
        break label50;
      }
    }
    label50:
    for (boolean bool = true;; bool = false)
    {
      b(bool);
      if (this.alw == null) {
        break;
      }
      this.alw.h(paramInt);
      return;
    }
  }
  
  private boolean n(int paramInt)
  {
    boolean bool = false;
    if (this.mItems.size() == 0)
    {
      this.ct = false;
      a(0, 0.0F, 0);
      if (!this.ct) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
    }
    else
    {
      b localb = Cv();
      int j = E();
      int k = this.bS;
      float f = this.bS / j;
      int i = localb.position;
      f = (paramInt / j - localb.cH) / (localb.cG + f);
      paramInt = (int)((k + j) * f);
      this.ct = false;
      a(i, f, paramInt);
      if (!this.ct) {
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      }
      bool = true;
    }
    return bool;
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.ca != paramBoolean) {
      this.ca = paramBoolean;
    }
  }
  
  void B()
  {
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context localContext = getContext();
    this.bQ = new Scroller(localContext, bJ);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
    float f = localContext.getResources().getDisplayMetrics().density;
    this.bi = w.a(localViewConfiguration);
    this.ck = ((int)(400.0F * f));
    this.cl = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.cp = new c(localContext);
    this.cq = new c(localContext);
    this.cm = ((int)(25.0F * f));
    this.cn = ((int)(2.0F * f));
    this.cf = ((int)(0.0F * f));
    p.a(this, new d());
    if (p.e(this) == 0) {
      p.b(this, 1);
    }
  }
  
  public int Cu()
  {
    return this.bS;
  }
  
  public l D()
  {
    return this.bL;
  }
  
  b E(int paramInt1, int paramInt2)
  {
    b localb = new b();
    localb.position = paramInt1;
    localb.cE = this.bL.instantiateItem(this, paramInt1);
    localb.cG = this.bL.getPageWidth(paramInt1);
    if ((paramInt2 < 0) || (paramInt2 >= this.mItems.size()))
    {
      this.mItems.add(localb);
      return localb;
    }
    this.mItems.add(paramInt2, localb);
    return localb;
  }
  
  public int F()
  {
    return this.bM;
  }
  
  void G()
  {
    int i2 = this.bL.getCount();
    this.bH = i2;
    int i;
    int j;
    int k;
    int n;
    int m;
    label67:
    Object localObject;
    int i1;
    if ((this.mItems.size() < this.cc * 2 + 1) && (this.mItems.size() < i2))
    {
      i = 1;
      j = this.bM;
      k = 0;
      n = 0;
      m = i;
      i = j;
      j = k;
      k = n;
      if (k >= this.mItems.size()) {
        break label299;
      }
      localObject = (b)this.mItems.get(k);
      n = this.bL.getItemPosition(((b)localObject).cE);
      if (n != -1) {
        break label157;
      }
      n = k;
      i1 = j;
      k = m;
      j = i;
      i = i1;
      m = n;
    }
    for (;;)
    {
      n = k;
      i1 = j;
      k = m + 1;
      j = i;
      i = i1;
      m = n;
      break label67;
      i = 0;
      break;
      label157:
      if (n == -2)
      {
        this.mItems.remove(k);
        m = k - 1;
        k = j;
        if (j == 0)
        {
          this.bL.startUpdate(this);
          k = 1;
        }
        this.bL.destroyItem(this, ((b)localObject).position, ((b)localObject).cE);
        if (this.bM == ((b)localObject).position)
        {
          j = Math.max(0, Math.min(this.bM, i2 - 1));
          i = k;
          k = 1;
        }
      }
      else
      {
        if (((b)localObject).position != n)
        {
          if (((b)localObject).position == this.bM) {
            i = n;
          }
          ((b)localObject).position = n;
          n = i;
          i1 = 1;
          m = k;
          i = j;
          j = n;
          k = i1;
          continue;
          label299:
          if (j != 0) {
            this.bL.finishUpdate(this);
          }
          Collections.sort(this.mItems, bI);
          if (m != 0)
          {
            k = getChildCount();
            j = 0;
            while (j < k)
            {
              localObject = (c)getChildAt(j).getLayoutParams();
              if (!((c)localObject).cI) {
                ((c)localObject).cG = 0.0F;
              }
              j += 1;
            }
            a(i, false, true);
            requestLayout();
          }
          return;
        }
        n = i;
        i1 = m;
        m = k;
        i = j;
        j = n;
        k = i1;
        continue;
      }
      j = i;
      n = 1;
      i = k;
      k = n;
    }
  }
  
  void H()
  {
    l(this.bM);
  }
  
  boolean L()
  {
    if (this.bM > 0)
    {
      a(this.bM - 1, true);
      return true;
    }
    return false;
  }
  
  b M(View paramView)
  {
    int i = 0;
    while (i < this.mItems.size())
    {
      b localb = (b)this.mItems.get(i);
      if (this.bL.isViewFromObject(paramView, localb.cE)) {
        return localb;
      }
      i += 1;
    }
    return null;
  }
  
  boolean M()
  {
    if ((this.bL != null) && (this.bM < this.bL.getCount() - 1))
    {
      a(this.bM + 1, true);
      return true;
    }
    return false;
  }
  
  b N(View paramView)
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
    return M(paramView);
  }
  
  protected void a(int paramInt1, float paramFloat, int paramInt2)
  {
    int i;
    View localView;
    if (this.cu > 0)
    {
      int i1 = getScrollX();
      i = getPaddingLeft();
      int j = getPaddingRight();
      int i2 = getWidth();
      int i3 = getChildCount();
      int n = 0;
      while (n < i3)
      {
        localView = getChildAt(n);
        c localc = (c)localView.getLayoutParams();
        int m;
        int k;
        if (!localc.cI)
        {
          m = i;
          k = j;
          n += 1;
          i = m;
          j = k;
        }
        else
        {
          switch (localc.gravity & 0x7)
          {
          case 2: 
          case 4: 
          default: 
            k = i;
            m = j;
            j = i;
            i = m;
          }
          for (;;)
          {
            int i4 = k + i1 - localView.getLeft();
            k = i;
            m = j;
            if (i4 == 0) {
              break;
            }
            localView.offsetLeftAndRight(i4);
            k = i;
            m = j;
            break;
            k = localView.getWidth();
            m = k + i;
            k = i;
            i = j;
            j = m;
            continue;
            k = Math.max((i2 - localView.getMeasuredWidth()) / 2, i);
            m = i;
            i = j;
            j = m;
            continue;
            k = i2 - j - localView.getMeasuredWidth();
            i4 = localView.getMeasuredWidth();
            m = i;
            i = j + i4;
            j = m;
          }
        }
      }
    }
    if (this.alw != null) {
      this.alw.a(paramInt1, paramFloat, paramInt2);
    }
    if (this.alx != null) {
      this.alx.a(paramInt1, paramFloat, paramInt2);
    }
    if (this.alz != null)
    {
      paramInt2 = getScrollX();
      i = getChildCount();
      paramInt1 = 0;
      if (paramInt1 < i)
      {
        localView = getChildAt(paramInt1);
        if (((c)localView.getLayoutParams()).cI) {}
        for (;;)
        {
          paramInt1 += 1;
          break;
          paramFloat = (localView.getLeft() - paramInt2) / E();
          this.alz.a(localView, paramFloat);
        }
      }
    }
    this.ct = true;
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (getChildCount() == 0)
    {
      setScrollingCacheEnabled(false);
      return;
    }
    int i = getScrollX();
    int j = getScrollY();
    int k = paramInt1 - i;
    paramInt2 -= j;
    if ((k == 0) && (paramInt2 == 0))
    {
      a(false);
      H();
      i(0);
      return;
    }
    setScrollingCacheEnabled(true);
    i(2);
    paramInt1 = E();
    int m = paramInt1 / 2;
    float f3 = Math.min(1.0F, Math.abs(k) * 1.0F / paramInt1);
    float f1 = m;
    float f2 = m;
    f3 = b(f3);
    paramInt3 = Math.abs(paramInt3);
    if (paramInt3 > 0) {}
    for (paramInt1 = Math.round(1000.0F * Math.abs((f2 * f3 + f1) / paramInt3)) * 4;; paramInt1 = (int)((Math.abs(k) / (f1 * f2 + this.bS) + 1.0F) * 100.0F))
    {
      paramInt1 = Math.min(paramInt1, 600);
      this.bQ.startScroll(i, j, k, paramInt2, paramInt1);
      p.d(this);
      return;
      f1 = paramInt1;
      f2 = this.bL.getPageWidth(this.bM);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.cb = false;
    a(paramInt, paramBoolean, false);
  }
  
  void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    boolean bool = false;
    if ((this.bL == null) || (this.bL.getCount() <= 0))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    if ((!paramBoolean2) && (this.bM == paramInt1) && (this.mItems.size() != 0))
    {
      setScrollingCacheEnabled(false);
      return;
    }
    int i;
    if (paramInt1 < 0) {
      i = 0;
    }
    for (;;)
    {
      paramInt1 = this.cc;
      if ((i <= this.bM + paramInt1) && (i >= this.bM - paramInt1)) {
        break;
      }
      paramInt1 = 0;
      while (paramInt1 < this.mItems.size())
      {
        ((b)this.mItems.get(paramInt1)).cF = true;
        paramInt1 += 1;
      }
      i = paramInt1;
      if (paramInt1 >= this.bL.getCount()) {
        i = this.bL.getCount() - 1;
      }
    }
    paramBoolean2 = bool;
    if (this.bM != i) {
      paramBoolean2 = true;
    }
    if (this.cr)
    {
      this.bM = i;
      if ((paramBoolean2) && (this.alw != null)) {
        this.alw.g(i);
      }
      if ((paramBoolean2) && (this.alx != null)) {
        this.alx.g(i);
      }
      requestLayout();
      return;
    }
    l(i);
    a(i, paramBoolean1, paramInt2, paramBoolean2);
  }
  
  public void a(l paraml)
  {
    if (this.bL != null)
    {
      this.bL.unregisterDataSetObserver(this.alv);
      this.bL.startUpdate(this);
      int i = 0;
      while (i < this.mItems.size())
      {
        localObject = (b)this.mItems.get(i);
        this.bL.destroyItem(this, ((b)localObject).position, ((b)localObject).cE);
        i += 1;
      }
      this.bL.finishUpdate(this);
      this.mItems.clear();
      C();
      this.bM = 0;
      scrollTo(0, 0);
    }
    Object localObject = this.bL;
    this.bL = paraml;
    this.bH = 0;
    boolean bool;
    if (this.bL != null)
    {
      if (this.alv == null) {
        this.alv = new h(null);
      }
      this.bL.registerDataSetObserver(this.alv);
      this.cb = false;
      bool = this.cr;
      this.cr = true;
      this.bH = this.bL.getCount();
      if (this.bN < 0) {
        break label260;
      }
      this.bL.restoreState(this.bO, this.bP);
      a(this.bN, false, true);
      this.bN = -1;
      this.bO = null;
      this.bP = null;
    }
    for (;;)
    {
      if ((this.aly != null) && (localObject != paraml)) {
        this.aly.b((l)localObject, paraml);
      }
      return;
      label260:
      if (!bool) {
        H();
      } else {
        requestLayout();
      }
    }
  }
  
  public void a(f paramf)
  {
    this.alw = paramf;
  }
  
  protected boolean a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = paramView.getScrollX();
      int k = paramView.getScrollY();
      i = localViewGroup.getChildCount() - 1;
      if (i >= 0)
      {
        localView = localViewGroup.getChildAt(i);
        if ((paramInt2 + j < localView.getLeft()) || (paramInt2 + j >= localView.getRight()) || (paramInt3 + k < localView.getTop()) || (paramInt3 + k >= localView.getBottom()) || (!a(localView, true, paramInt1, paramInt2 + j - localView.getLeft(), paramInt3 + k - localView.getTop()))) {}
      }
    }
    while ((paramBoolean) && (p.a(paramView, -paramInt1)))
    {
      View localView;
      return true;
      i -= 1;
      break;
    }
    return false;
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    int j = paramArrayList.size();
    int k = getDescendantFocusability();
    if (k != 393216)
    {
      int i = 0;
      while (i < getChildCount())
      {
        View localView = getChildAt(i);
        if (localView.getVisibility() == 0)
        {
          b localb = M(localView);
          if ((localb != null) && (localb.position == this.bM)) {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
        i += 1;
      }
    }
    if (((k == 262144) && (j != paramArrayList.size())) || (!isFocusable())) {}
    while ((((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())) || (paramArrayList == null)) {
      return;
    }
    paramArrayList.add(this);
  }
  
  public void addTouchables(ArrayList<View> paramArrayList)
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        b localb = M(localView);
        if ((localb != null) && (localb.position == this.bM)) {
          localView.addTouchables(paramArrayList);
        }
      }
      i += 1;
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!checkLayoutParams(paramLayoutParams)) {
      paramLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    for (;;)
    {
      c localc = (c)paramLayoutParams;
      localc.cI |= paramView instanceof a;
      if (this.mInLayout)
      {
        if ((localc != null) && (localc.cI)) {
          throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        localc.cJ = true;
        addViewInLayout(paramView, paramInt, paramLayoutParams);
        return;
      }
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    }
  }
  
  public boolean arrowScroll(int paramInt)
  {
    View localView = findFocus();
    Object localObject;
    int j;
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
      i = a(this.mTempRect, localView).left;
      j = a(this.mTempRect, (View)localObject).left;
      if ((localObject != null) && (i >= j))
      {
        bool = L();
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
    for (int i = 1;; i = 0)
    {
      if (i == 0)
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
          i = a(this.mTempRect, localView).left;
          j = a(this.mTempRect, (View)localObject).left;
          if ((localObject != null) && (i <= j))
          {
            bool = M();
            break label89;
          }
          bool = localView.requestFocus();
          break label89;
          if ((paramInt == 17) || (paramInt == 1))
          {
            bool = L();
            break label89;
          }
          if ((paramInt == 66) || (paramInt == 2))
          {
            bool = M();
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
  
  float b(float paramFloat)
  {
    return (float)Math.sin((float)((paramFloat - 0.5F) * 0.4712389167638204D));
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (this.bL == null) {}
    int i;
    int j;
    do
    {
      return false;
      i = E();
      j = getScrollX();
      if (paramInt < 0)
      {
        if (j > (int)(i * this.bW)) {}
        for (;;)
        {
          return bool1;
          bool1 = false;
        }
      }
    } while (paramInt <= 0);
    if (j < (int)(i * this.bX)) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof c)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    if ((!this.bQ.isFinished()) && (this.bQ.computeScrollOffset()))
    {
      int i = getScrollX();
      int j = getScrollY();
      int k = this.bQ.getCurrX();
      int m = this.bQ.getCurrY();
      if ((i != k) || (j != m))
      {
        scrollTo(k, m);
        if (!n(k))
        {
          this.bQ.abortAnimation();
          scrollTo(0, m);
        }
      }
      p.d(this);
      return;
    }
    a(true);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (executeKeyEvent(paramKeyEvent));
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
    int j = getChildCount();
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        b localb = M(localView);
        if ((localb != null) && (localb.position == this.bM) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
          return true;
        }
      }
      i += 1;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int k = 0;
    int i = 0;
    int m = p.c(this);
    boolean bool;
    if ((m == 0) || ((m == 1) && (this.bL != null) && (this.bL.getCount() > 1)))
    {
      int j;
      if (!this.cp.isFinished())
      {
        k = paramCanvas.save();
        i = getHeight() - getPaddingTop() - getPaddingBottom();
        m = getWidth();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(-i + getPaddingTop(), this.bW * m);
        this.cp.setSize(i, m);
        j = false | this.cp.draw(paramCanvas);
        paramCanvas.restoreToCount(k);
      }
      k = j;
      if (!this.cq.isFinished())
      {
        m = paramCanvas.save();
        k = getWidth();
        int n = getHeight();
        int i1 = getPaddingTop();
        int i2 = getPaddingBottom();
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-getPaddingTop(), -(this.bX + 1.0F) * k);
        this.cq.setSize(n - i1 - i2, k);
        bool = j | this.cq.draw(paramCanvas);
        paramCanvas.restoreToCount(m);
      }
    }
    for (;;)
    {
      if (bool) {
        p.d(this);
      }
      return;
      this.cp.finish();
      this.cq.finish();
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.bT;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  public boolean executeKeyEvent(KeyEvent paramKeyEvent)
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
        return arrowScroll(17);
        return arrowScroll(66);
      } while (Build.VERSION.SDK_INT < 11);
      if (g.a(paramKeyEvent)) {
        return arrowScroll(2);
      }
    } while (!g.a(paramKeyEvent, 1));
    return arrowScroll(1);
  }
  
  public void fB(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 1)
    {
      Log.w("ViewPager", "Requested offscreen page limit " + paramInt + " too small; defaulting to " + 1);
      i = 1;
    }
    if (i != this.cc)
    {
      this.cc = i;
      H();
    }
  }
  
  b fC(int paramInt)
  {
    int i = 0;
    while (i < this.mItems.size())
    {
      b localb = (b)this.mItems.get(i);
      if (localb.position == paramInt) {
        return localb;
      }
      i += 1;
    }
    return null;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new c();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new c(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return generateDefaultLayoutParams();
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (this.cz == 2) {
      i = paramInt1 - 1 - paramInt2;
    }
    return ((c)((View)this.cA.get(i)).getLayoutParams()).cK;
  }
  
  public void j(int paramInt)
  {
    this.cb = false;
    if (!this.cr) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramInt, bool, false);
      return;
    }
  }
  
  public void k(int paramInt)
  {
    int i = this.bS;
    this.bS = paramInt;
    int j = getWidth();
    b(j, j, paramInt, i);
    requestLayout();
  }
  
  void l(int paramInt)
  {
    int i;
    Object localObject2;
    if (this.bM != paramInt) {
      if (this.bM < paramInt)
      {
        i = 66;
        localObject2 = fC(this.bM);
        this.bM = paramInt;
      }
    }
    for (int j = i;; j = 2)
    {
      if (this.bL == null) {
        I();
      }
      do
      {
        return;
        i = 17;
        break;
        if (this.cb)
        {
          I();
          return;
        }
      } while (getWindowToken() == null);
      this.bL.startUpdate(this);
      paramInt = this.cc;
      int i3 = Math.max(0, this.bM - paramInt);
      int i1 = this.bL.getCount();
      int i2 = Math.min(i1 - 1, paramInt + this.bM);
      Object localObject1;
      if (i1 != this.bH) {
        try
        {
          String str = getResources().getResourceName(getId());
          throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.bH + ", found: " + i1 + " Pager id: " + str + " Pager class: " + getClass() + " Problematic adapter: " + this.bL.getClass());
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
      if (paramInt < this.mItems.size())
      {
        localObject1 = (b)this.mItems.get(paramInt);
        if (((b)localObject1).position >= this.bM) {
          if (((b)localObject1).position != this.bM) {
            break label1273;
          }
        }
      }
      for (;;)
      {
        if ((localObject1 == null) && (i1 > 0)) {}
        for (Object localObject3 = E(this.bM, paramInt);; localObject3 = localObject1)
        {
          int n;
          label344:
          int i4;
          label357:
          float f3;
          int m;
          int k;
          Object localObject4;
          float f1;
          if (localObject3 != null)
          {
            n = paramInt - 1;
            if (n < 0) {
              break label640;
            }
            localObject1 = (b)this.mItems.get(n);
            i4 = E();
            if (i4 > 0) {
              break label646;
            }
            f2 = 0.0F;
            i = this.bM;
            f3 = 0.0F;
            m = i - 1;
            k = paramInt;
            localObject4 = localObject1;
            if (m >= 0)
            {
              if ((f3 < f2) || (m >= i3)) {
                break label801;
              }
              if (localObject4 != null) {
                break label667;
              }
            }
            f1 = ((b)localObject3).cG;
            paramInt = k + 1;
            if (f1 < 2.0F)
            {
              if (paramInt >= this.mItems.size()) {
                break label921;
              }
              localObject1 = (b)this.mItems.get(paramInt);
              label444:
              if (i4 > 0) {
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
          for (float f2 = 0.0F;; f2 = getPaddingRight() / i4 + 2.0F)
          {
            i = this.bM;
            i += 1;
            if (i < i1)
            {
              if ((f1 < f2) || (i <= i2)) {
                break label1023;
              }
              if (localObject1 != null) {
                break label942;
              }
            }
            a((b)localObject3, k, (b)localObject2);
            localObject2 = this.bL;
            paramInt = this.bM;
            if (localObject3 == null) {
              break label1145;
            }
            localObject1 = ((b)localObject3).cE;
            ((l)localObject2).setPrimaryItem(this, paramInt, localObject1);
            this.bL.finishUpdate(this);
            i = getChildCount();
            paramInt = 0;
            while (paramInt < i)
            {
              localObject2 = getChildAt(paramInt);
              localObject1 = (c)((View)localObject2).getLayoutParams();
              ((c)localObject1).cK = paramInt;
              if ((!((c)localObject1).cI) && (((c)localObject1).cG == 0.0F))
              {
                localObject2 = M((View)localObject2);
                if (localObject2 != null)
                {
                  ((c)localObject1).cG = ((b)localObject2).cG;
                  ((c)localObject1).position = ((b)localObject2).position;
                }
              }
              paramInt += 1;
            }
            paramInt += 1;
            break;
            localObject1 = null;
            break label344;
            f2 = 2.0F - ((b)localObject3).cG + getPaddingLeft() / i4;
            break label357;
            localObject1 = localObject4;
            paramInt = n;
            f1 = f3;
            i = k;
            if (m == ((b)localObject4).position)
            {
              localObject1 = localObject4;
              paramInt = n;
              f1 = f3;
              i = k;
              if (!((b)localObject4).cF)
              {
                this.mItems.remove(n);
                this.bL.destroyItem(this, m, ((b)localObject4).cE);
                paramInt = n - 1;
                i = k - 1;
                if (paramInt < 0) {
                  break label792;
                }
                localObject1 = (b)this.mItems.get(paramInt);
                f1 = f3;
              }
            }
            for (;;)
            {
              m -= 1;
              localObject4 = localObject1;
              n = paramInt;
              f3 = f1;
              k = i;
              break;
              localObject1 = null;
              f1 = f3;
              continue;
              if ((localObject4 != null) && (m == ((b)localObject4).position))
              {
                f1 = f3 + ((b)localObject4).cG;
                paramInt = n - 1;
                if (paramInt >= 0)
                {
                  localObject1 = (b)this.mItems.get(paramInt);
                  i = k;
                }
                else
                {
                  localObject1 = null;
                  i = k;
                }
              }
              else
              {
                f1 = f3 + E(m, n + 1).cG;
                i = k + 1;
                if (n >= 0)
                {
                  localObject1 = (b)this.mItems.get(n);
                  paramInt = n;
                }
                else
                {
                  localObject1 = null;
                  paramInt = n;
                }
              }
            }
            localObject1 = null;
            break label444;
          }
          label942:
          if ((i == ((b)localObject1).position) && (!((b)localObject1).cF))
          {
            this.mItems.remove(paramInt);
            this.bL.destroyItem(this, i, ((b)localObject1).cE);
            if (paramInt < this.mItems.size()) {
              localObject1 = (b)this.mItems.get(paramInt);
            }
          }
          for (;;)
          {
            i += 1;
            break label463;
            localObject1 = null;
            continue;
            label1023:
            if ((localObject1 != null) && (i == ((b)localObject1).position))
            {
              f3 = ((b)localObject1).cG;
              paramInt += 1;
              if (paramInt < this.mItems.size()) {}
              for (localObject1 = (b)this.mItems.get(paramInt);; localObject1 = null)
              {
                f1 += f3;
                break;
              }
            }
            localObject1 = E(i, paramInt);
            paramInt += 1;
            f3 = ((b)localObject1).cG;
            if (paramInt < this.mItems.size()) {}
            for (localObject1 = (b)this.mItems.get(paramInt);; localObject1 = null)
            {
              f1 += f3;
              break;
            }
            label1145:
            localObject1 = null;
            break label521;
            I();
            if (!hasFocus()) {
              break;
            }
            localObject1 = findFocus();
            if (localObject1 != null) {}
            for (localObject1 = N((View)localObject1);; localObject1 = null)
            {
              if ((localObject1 != null) && (((b)localObject1).position == this.bM)) {
                break label1261;
              }
              paramInt = 0;
              for (;;)
              {
                if (paramInt >= getChildCount()) {
                  break label1255;
                }
                localObject1 = getChildAt(paramInt);
                localObject2 = M((View)localObject1);
                if ((localObject2 != null) && (((b)localObject2).position == this.bM) && (((View)localObject1).requestFocus(j))) {
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
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.cr = true;
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.cC);
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int k;
    int m;
    float f3;
    Object localObject;
    float f1;
    int n;
    int i;
    int i1;
    int j;
    if ((this.bS > 0) && (this.bT != null) && (this.mItems.size() > 0) && (this.bL != null))
    {
      k = getScrollX();
      m = getWidth();
      f3 = this.bS / m;
      localObject = (b)this.mItems.get(0);
      f1 = ((b)localObject).cH;
      n = this.mItems.size();
      i = ((b)localObject).position;
      i1 = ((b)this.mItems.get(n - 1)).position;
      j = 0;
    }
    for (;;)
    {
      float f2;
      if (i < i1)
      {
        while ((i > ((b)localObject).position) && (j < n))
        {
          localObject = this.mItems;
          j += 1;
          localObject = (b)((ArrayList)localObject).get(j);
        }
        if (i != ((b)localObject).position) {
          break label271;
        }
        f2 = (((b)localObject).cH + ((b)localObject).cG) * m;
      }
      label271:
      float f4;
      for (f1 = ((b)localObject).cH + ((b)localObject).cG + f3;; f1 += f4 + f3)
      {
        if (this.bS + f2 > k)
        {
          this.bT.setBounds((int)f2, this.bU, (int)(this.bS + f2 + 0.5F), this.bV);
          this.bT.draw(paramCanvas);
        }
        if (f2 <= k + m) {
          break;
        }
        return;
        f4 = this.bL.getPageWidth(i);
        f2 = (f1 + f4) * m;
      }
      i += 1;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((i == 3) || (i == 1))
    {
      this.cd = false;
      this.ce = false;
      this.cj = -1;
      if (this.aO != null)
      {
        this.aO.recycle();
        this.aO = null;
      }
    }
    do
    {
      return false;
      if (i == 0) {
        break;
      }
      if (this.cd) {
        return true;
      }
    } while (this.ce);
    switch (i)
    {
    }
    for (;;)
    {
      if (this.aO == null) {
        this.aO = VelocityTracker.obtain();
      }
      this.aO.addMovement(paramMotionEvent);
      return this.cd;
      i = this.cj;
      if (i != -1)
      {
        i = j.a(paramMotionEvent, i);
        float f2 = j.c(paramMotionEvent, i);
        float f1 = f2 - this.ch;
        float f4 = Math.abs(f1);
        float f3 = j.d(paramMotionEvent, i);
        float f5 = Math.abs(f3 - this.bh);
        if ((f1 != 0.0F) && (!a(this.ch, f1)) && (a(this, false, (int)f1, (int)f2, (int)f3)))
        {
          this.ch = f2;
          this.ci = f3;
          this.ce = true;
          return false;
        }
        if ((f4 > this.bi) && (0.5F * f4 > f5))
        {
          this.cd = true;
          c(true);
          i(1);
          if (f1 > 0.0F)
          {
            f1 = this.bg + this.bi;
            label310:
            this.ch = f1;
            this.ci = f3;
            setScrollingCacheEnabled(true);
          }
        }
        while ((this.cd) && (c(f2)))
        {
          p.d(this);
          break;
          f1 = this.bg - this.bi;
          break label310;
          if (f5 > this.bi) {
            this.ce = true;
          }
        }
        f1 = paramMotionEvent.getX();
        this.bg = f1;
        this.ch = f1;
        f1 = paramMotionEvent.getY();
        this.bh = f1;
        this.ci = f1;
        this.cj = j.b(paramMotionEvent, 0);
        this.ce = false;
        this.bQ.computeScrollOffset();
        if ((this.bz == 2) && (Math.abs(this.bQ.getFinalX() - this.bQ.getCurrX()) > this.cn))
        {
          this.bQ.abortAnimation();
          this.cb = false;
          H();
          this.cd = true;
          c(true);
          i(1);
        }
        else
        {
          a(false);
          this.cd = false;
          continue;
          d(paramMotionEvent);
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = getChildCount();
    int i3 = paramInt3 - paramInt1;
    int i2 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    int i = getPaddingRight();
    paramInt3 = getPaddingBottom();
    int i4 = getScrollX();
    int j = 0;
    int m = 0;
    View localView;
    c localc;
    int i5;
    int k;
    label154:
    int n;
    if (m < i1)
    {
      localView = getChildAt(m);
      if (localView.getVisibility() == 8) {
        break label671;
      }
      localc = (c)localView.getLayoutParams();
      if (!localc.cI) {
        break label671;
      }
      paramInt4 = localc.gravity;
      i5 = localc.gravity;
      switch (paramInt4 & 0x7)
      {
      case 2: 
      case 4: 
      default: 
        paramInt4 = paramInt2;
        k = paramInt2;
        switch (i5 & 0x70)
        {
        default: 
          n = paramInt1;
          paramInt2 = paramInt1;
          paramInt1 = paramInt3;
          paramInt3 = n;
          label204:
          paramInt4 += i4;
          localView.layout(paramInt4, paramInt3, localView.getMeasuredWidth() + paramInt4, localView.getMeasuredHeight() + paramInt3);
          j += 1;
          paramInt4 = i;
          paramInt3 = k;
          i = paramInt1;
          paramInt1 = j;
        }
        break;
      }
    }
    for (;;)
    {
      m += 1;
      k = paramInt3;
      j = paramInt1;
      paramInt1 = paramInt2;
      paramInt3 = i;
      i = paramInt4;
      paramInt2 = k;
      break;
      k = localView.getMeasuredWidth();
      paramInt4 = paramInt2;
      k += paramInt2;
      break label154;
      paramInt4 = Math.max((i3 - localView.getMeasuredWidth()) / 2, paramInt2);
      k = paramInt2;
      break label154;
      k = localView.getMeasuredWidth();
      paramInt4 = i + localView.getMeasuredWidth();
      n = i3 - i - k;
      i = paramInt4;
      k = paramInt2;
      paramInt4 = n;
      break label154;
      n = localView.getMeasuredHeight();
      paramInt2 = paramInt3;
      n += paramInt1;
      paramInt3 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = n;
      break label204;
      n = Math.max((i2 - localView.getMeasuredHeight()) / 2, paramInt1);
      paramInt2 = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = n;
      break label204;
      n = i2 - paramInt3 - localView.getMeasuredHeight();
      i5 = localView.getMeasuredHeight();
      paramInt2 = paramInt1;
      paramInt1 = paramInt3 + i5;
      paramInt3 = n;
      break label204;
      i = i3 - paramInt2 - i;
      paramInt4 = 0;
      while (paramInt4 < i1)
      {
        localView = getChildAt(paramInt4);
        if (localView.getVisibility() != 8)
        {
          localc = (c)localView.getLayoutParams();
          if (!localc.cI)
          {
            b localb = M(localView);
            if (localb != null)
            {
              float f = i;
              k = (int)(localb.cH * f) + paramInt2;
              if (localc.cJ)
              {
                localc.cJ = false;
                f = i;
                localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localc.cG * f), 1073741824), View.MeasureSpec.makeMeasureSpec(i2 - paramInt1 - paramInt3, 1073741824));
              }
              localView.layout(k, paramInt1, localView.getMeasuredWidth() + k, localView.getMeasuredHeight() + paramInt1);
            }
          }
        }
        paramInt4 += 1;
      }
      this.bU = paramInt1;
      this.bV = (i2 - paramInt3);
      this.cu = j;
      if (this.cr) {
        a(this.bM, false, 0, false);
      }
      this.cr = false;
      return;
      label671:
      paramInt4 = j;
      j = paramInt1;
      k = paramInt2;
      paramInt1 = paramInt4;
      paramInt4 = i;
      i = paramInt3;
      paramInt2 = j;
      paramInt3 = k;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredWidth();
    this.cg = Math.min(paramInt1 / 10, this.cf);
    paramInt1 = paramInt1 - getPaddingLeft() - getPaddingRight();
    paramInt2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int i4 = getChildCount();
    int k = 0;
    View localView;
    int i;
    int j;
    c localc;
    int m;
    int i1;
    label183:
    int n;
    if (k < i4)
    {
      localView = getChildAt(k);
      i = paramInt1;
      j = paramInt2;
      if (localView.getVisibility() != 8)
      {
        localc = (c)localView.getLayoutParams();
        i = paramInt1;
        j = paramInt2;
        if (localc != null)
        {
          i = paramInt1;
          j = paramInt2;
          if (localc.cI)
          {
            i = localc.gravity & 0x7;
            m = localc.gravity & 0x70;
            i1 = Integer.MIN_VALUE;
            j = Integer.MIN_VALUE;
            if ((m != 48) && (m != 80)) {
              break label333;
            }
            m = 1;
            if ((i != 3) && (i != 5)) {
              break label339;
            }
            n = 1;
            label198:
            if (m == 0) {
              break label345;
            }
            i = 1073741824;
            label208:
            if (localc.width == -2) {
              break label528;
            }
            i1 = 1073741824;
            if (localc.width == -1) {
              break label522;
            }
            i = localc.width;
          }
        }
      }
    }
    for (;;)
    {
      int i3;
      if (localc.height != -2)
      {
        i2 = 1073741824;
        j = i2;
        if (localc.height != -1)
        {
          i3 = localc.height;
          j = i2;
        }
      }
      for (int i2 = i3;; i2 = paramInt2)
      {
        localView.measure(View.MeasureSpec.makeMeasureSpec(i, i1), View.MeasureSpec.makeMeasureSpec(i2, j));
        if (m != 0)
        {
          j = paramInt2 - localView.getMeasuredHeight();
          i = paramInt1;
        }
        for (;;)
        {
          k += 1;
          paramInt1 = i;
          paramInt2 = j;
          break;
          label333:
          m = 0;
          break label183;
          label339:
          n = 0;
          break label198;
          label345:
          i = i1;
          if (n == 0) {
            break label208;
          }
          j = 1073741824;
          i = i1;
          break label208;
          i = paramInt1;
          j = paramInt2;
          if (n != 0)
          {
            i = paramInt1 - localView.getMeasuredWidth();
            j = paramInt2;
          }
        }
        this.bY = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
        this.bZ = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
        this.mInLayout = true;
        H();
        this.mInLayout = false;
        i = getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          localView = getChildAt(paramInt2);
          if (localView.getVisibility() != 8)
          {
            localc = (c)localView.getLayoutParams();
            if ((localc == null) || (!localc.cI))
            {
              float f = paramInt1;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localc.cG * f), 1073741824), this.bZ);
            }
          }
          paramInt2 += 1;
        }
        return;
      }
      label522:
      i = paramInt1;
      continue;
      label528:
      i1 = i;
      i = paramInt1;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int k = -1;
    int j = getChildCount();
    int i;
    if ((paramInt & 0x2) != 0)
    {
      k = 1;
      i = 0;
    }
    while (i != j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        b localb = M(localView);
        if ((localb != null) && (localb.position == this.bM) && (localView.requestFocus(paramInt, paramRect)))
        {
          return true;
          i = j - 1;
          j = -1;
          continue;
        }
      }
      i += k;
    }
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (this.bL != null)
    {
      this.bL.restoreState(paramParcelable.cL, paramParcelable.cM);
      a(paramParcelable.position, false, true);
      return;
    }
    this.bN = paramParcelable.position;
    this.bO = paramParcelable.cL;
    this.bP = paramParcelable.cM;
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.position = this.bM;
    if (this.bL != null) {
      localSavedState.cL = this.bL.saveState();
    }
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      b(paramInt1, paramInt3, this.bS, this.bS);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = 0;
    if (this.co) {
      return true;
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    if ((this.bL == null) || (this.bL.getCount() == 0)) {
      return false;
    }
    if (this.aO == null) {
      this.aO = VelocityTracker.obtain();
    }
    this.aO.addMovement(paramMotionEvent);
    int i = m;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      i = m;
    }
    for (;;)
    {
      if (i != 0) {
        p.d(this);
      }
      return true;
      this.bQ.abortAnimation();
      this.cb = false;
      H();
      float f1 = paramMotionEvent.getX();
      this.bg = f1;
      this.ch = f1;
      f1 = paramMotionEvent.getY();
      this.bh = f1;
      this.ci = f1;
      this.cj = j.b(paramMotionEvent, 0);
      i = m;
      continue;
      float f2;
      if (!this.cd)
      {
        i = j.a(paramMotionEvent, this.cj);
        f1 = j.c(paramMotionEvent, i);
        float f3 = Math.abs(f1 - this.ch);
        f2 = j.d(paramMotionEvent, i);
        float f4 = Math.abs(f2 - this.ci);
        if ((f3 > this.bi) && (f3 > f4))
        {
          this.cd = true;
          c(true);
          if (f1 - this.bg <= 0.0F) {
            break label378;
          }
        }
      }
      Object localObject;
      label378:
      for (f1 = this.bg + this.bi;; f1 = this.bg - this.bi)
      {
        this.ch = f1;
        this.ci = f2;
        i(1);
        setScrollingCacheEnabled(true);
        localObject = getParent();
        if (localObject != null) {
          ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
        }
        i = m;
        if (!this.cd) {
          break;
        }
        bool1 = false | c(j.c(paramMotionEvent, j.a(paramMotionEvent, this.cj)));
        break;
      }
      boolean bool1 = m;
      if (this.cd)
      {
        localObject = this.aO;
        ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.cl);
        int j = (int)n.a((VelocityTracker)localObject, this.cj);
        this.cb = true;
        m = E();
        int n = getScrollX();
        localObject = Cv();
        a(a(((b)localObject).position, (n / m - ((b)localObject).cH) / ((b)localObject).cG, j, (int)(j.c(paramMotionEvent, j.a(paramMotionEvent, this.cj)) - this.bg)), true, true, j);
        this.cj = -1;
        K();
        boolean bool3 = this.cp.ad();
        boolean bool2 = this.cq.ad() | bool3;
        continue;
        bool2 = m;
        if (this.cd)
        {
          a(this.bM, true, 0, false);
          this.cj = -1;
          K();
          bool3 = this.cp.ad();
          bool2 = this.cq.ad() | bool3;
          continue;
          int k = j.b(paramMotionEvent);
          this.ch = j.c(paramMotionEvent, k);
          this.cj = j.b(paramMotionEvent, k);
          k = m;
          continue;
          d(paramMotionEvent);
          this.ch = j.c(paramMotionEvent, j.a(paramMotionEvent, this.cj));
          k = m;
        }
      }
    }
  }
  
  public void removeView(View paramView)
  {
    if (this.mInLayout)
    {
      removeViewInLayout(paramView);
      return;
    }
    super.removeView(paramView);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.bT);
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = android.support.v4.a.a.a(new b()
    {
      public ImageViewPager.SavedState b(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new ImageViewPager.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }
      
      public ImageViewPager.SavedState[] fD(int paramAnonymousInt)
      {
        return new ImageViewPager.SavedState[paramAnonymousInt];
      }
    });
    Parcelable cL;
    ClassLoader cM;
    int position;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super();
      ClassLoader localClassLoader = paramClassLoader;
      if (paramClassLoader == null) {
        localClassLoader = getClass().getClassLoader();
      }
      this.position = paramParcel.readInt();
      this.cL = paramParcel.readParcelable(localClassLoader);
      this.cM = localClassLoader;
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.position);
      paramParcel.writeParcelable(this.cL, paramInt);
    }
  }
  
  static abstract interface a {}
  
  static class b
  {
    Object cE;
    boolean cF;
    float cG;
    float cH;
    int position;
  }
  
  public static class c
    extends ViewGroup.LayoutParams
  {
    float cG = 0.0F;
    public boolean cI;
    boolean cJ;
    int cK;
    public int gravity;
    int position;
    
    public c()
    {
      super(-1);
    }
    
    public c(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ImageViewPager.N());
      this.gravity = paramContext.getInteger(0, 48);
      paramContext.recycle();
    }
  }
  
  class d
    extends android.support.v4.view.a
  {
    d() {}
    
    private boolean O()
    {
      return (ImageViewPager.a(ImageViewPager.this) != null) && (ImageViewPager.a(ImageViewPager.this).getCount() > 1);
    }
    
    public void a(View paramView, android.support.v4.view.a.a parama)
    {
      super.a(paramView, parama);
      parama.setClassName(ImageViewPager.class.getName());
      parama.setScrollable(O());
      if (ImageViewPager.this.canScrollHorizontally(1)) {
        parama.addAction(4096);
      }
      if (ImageViewPager.this.canScrollHorizontally(-1)) {
        parama.addAction(8192);
      }
    }
    
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(ImageViewPager.class.getName());
      paramView = h.R();
      paramView.setScrollable(O());
      if ((paramAccessibilityEvent.getEventType() == 4096) && (ImageViewPager.a(ImageViewPager.this) != null))
      {
        paramView.setItemCount(ImageViewPager.a(ImageViewPager.this).getCount());
        paramView.setFromIndex(ImageViewPager.b(ImageViewPager.this));
        paramView.setToIndex(ImageViewPager.b(ImageViewPager.this));
      }
    }
    
    public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
        return true;
      }
      switch (paramInt)
      {
      default: 
        return false;
      case 4096: 
        if (ImageViewPager.this.canScrollHorizontally(1))
        {
          ImageViewPager.this.j(ImageViewPager.b(ImageViewPager.this) + 1);
          return true;
        }
        return false;
      }
      if (ImageViewPager.this.canScrollHorizontally(-1))
      {
        ImageViewPager.this.j(ImageViewPager.b(ImageViewPager.this) - 1);
        return true;
      }
      return false;
    }
  }
  
  static abstract interface e
  {
    public abstract void b(l paraml1, l paraml2);
  }
  
  public static abstract interface f
  {
    public abstract void a(int paramInt1, float paramFloat, int paramInt2);
    
    public abstract void g(int paramInt);
    
    public abstract void h(int paramInt);
  }
  
  public static abstract interface g
  {
    public abstract void a(View paramView, float paramFloat);
  }
  
  private class h
    extends DataSetObserver
  {
    private h() {}
    
    public void onChanged()
    {
      ImageViewPager.this.G();
    }
    
    public void onInvalidated()
    {
      ImageViewPager.this.G();
    }
  }
  
  static class i
    implements Comparator<View>
  {
    public int a(View paramView1, View paramView2)
    {
      paramView1 = (ImageViewPager.c)paramView1.getLayoutParams();
      paramView2 = (ImageViewPager.c)paramView2.getLayoutParams();
      if (paramView1.cI != paramView2.cI)
      {
        if (paramView1.cI) {
          return 1;
        }
        return -1;
      }
      return paramView1.position - paramView2.position;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/jfeinstein/jazzyviewpager/ImageViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */