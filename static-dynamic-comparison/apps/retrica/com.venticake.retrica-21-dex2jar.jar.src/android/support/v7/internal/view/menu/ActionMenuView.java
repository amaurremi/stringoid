package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.b.c;
import android.support.v7.b.k;
import android.support.v7.internal.widget.LinearLayoutICS;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView
  extends LinearLayoutICS
  implements ad, q
{
  private o a;
  private boolean b;
  private ActionMenuPresenter c;
  private boolean d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  
  public ActionMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBaselineAligned(false);
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    this.f = ((int)(56.0F * f1));
    this.g = ((int)(f1 * 4.0F));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, k.ActionBar, c.actionBarStyle, 0);
    this.i = paramContext.getDimensionPixelSize(1, 0);
    paramContext.recycle();
  }
  
  static int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool2 = false;
    i locali = (i)paramView.getLayoutParams();
    int j = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt3) - paramInt4, View.MeasureSpec.getMode(paramInt3));
    ActionMenuItemView localActionMenuItemView;
    if ((paramView instanceof ActionMenuItemView))
    {
      localActionMenuItemView = (ActionMenuItemView)paramView;
      if ((localActionMenuItemView == null) || (!localActionMenuItemView.b())) {
        break label184;
      }
      paramInt4 = 1;
      label57:
      if ((paramInt2 <= 0) || ((paramInt4 != 0) && (paramInt2 < 2))) {
        break label190;
      }
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 * paramInt2, Integer.MIN_VALUE), j);
      int k = paramView.getMeasuredWidth();
      paramInt3 = k / paramInt1;
      paramInt2 = paramInt3;
      if (k % paramInt1 != 0) {
        paramInt2 = paramInt3 + 1;
      }
      paramInt3 = paramInt2;
      if (paramInt4 != 0)
      {
        paramInt3 = paramInt2;
        if (paramInt2 >= 2) {}
      }
    }
    label184:
    label190:
    for (paramInt3 = 2;; paramInt3 = 0)
    {
      boolean bool1 = bool2;
      if (!locali.a)
      {
        bool1 = bool2;
        if (paramInt4 != 0) {
          bool1 = true;
        }
      }
      locali.d = bool1;
      locali.b = paramInt3;
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 * paramInt1, 1073741824), j);
      return paramInt3;
      localActionMenuItemView = null;
      break;
      paramInt4 = 0;
      break label57;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i9 = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int i8 = View.MeasureSpec.getSize(paramInt2);
    paramInt2 = getPaddingLeft();
    int j = getPaddingRight();
    int i6 = getPaddingTop() + getPaddingBottom();
    if (i9 == 1073741824) {}
    int i10;
    for (int i4 = View.MeasureSpec.makeMeasureSpec(i8 - i6, 1073741824);; i4 = View.MeasureSpec.makeMeasureSpec(Math.min(this.i, i8 - i6), Integer.MIN_VALUE))
    {
      i10 = paramInt1 - (j + paramInt2);
      paramInt1 = i10 / this.f;
      paramInt2 = this.f;
      if (paramInt1 != 0) {
        break;
      }
      setMeasuredDimension(i10, 0);
      return;
    }
    int i11 = this.f + i10 % paramInt2 / paramInt1;
    j = 0;
    int i2 = 0;
    int i1 = 0;
    int i3 = 0;
    int n = 0;
    long l1 = 0L;
    int i12 = getChildCount();
    int m = 0;
    Object localObject;
    int k;
    boolean bool;
    i locali;
    label303:
    label320:
    int i7;
    for (;;)
    {
      if (m < i12)
      {
        localObject = getChildAt(m);
        if (((View)localObject).getVisibility() == 8)
        {
          paramInt2 = i2;
          k = paramInt1;
          paramInt1 = i3;
          m += 1;
          i3 = paramInt1;
          paramInt1 = k;
          i2 = paramInt2;
        }
        else
        {
          bool = localObject instanceof ActionMenuItemView;
          i3 += 1;
          if (bool) {
            ((View)localObject).setPadding(this.g, 0, this.g, 0);
          }
          locali = (i)((View)localObject).getLayoutParams();
          locali.f = false;
          locali.c = 0;
          locali.b = 0;
          locali.d = false;
          locali.leftMargin = 0;
          locali.rightMargin = 0;
          if ((bool) && (((ActionMenuItemView)localObject).b()))
          {
            bool = true;
            locali.e = bool;
            if (!locali.a) {
              break label431;
            }
            paramInt2 = 1;
            i7 = a((View)localObject, i11, paramInt2, i4, i6);
            i2 = Math.max(i2, i7);
            if (!locali.d) {
              break label1271;
            }
          }
        }
      }
    }
    label431:
    label477:
    label514:
    label541:
    label600:
    label626:
    label773:
    label803:
    label818:
    label961:
    label1208:
    label1214:
    label1223:
    label1226:
    label1237:
    label1271:
    for (paramInt2 = i1 + 1;; paramInt2 = i1)
    {
      if (locali.a) {}
      for (k = 1;; k = n)
      {
        int i5 = paramInt1 - i7;
        j = Math.max(j, ((View)localObject).getMeasuredHeight());
        if (i7 == 1)
        {
          long l2 = 1 << m;
          paramInt1 = i3;
          i1 = paramInt2;
          l1 = l2 | l1;
          paramInt2 = i2;
          n = k;
          k = i5;
          break;
          bool = false;
          break label303;
          paramInt2 = paramInt1;
          break label320;
          if ((n != 0) && (i3 == 2))
          {
            i5 = 1;
            k = 0;
            m = paramInt1;
            if ((i1 <= 0) || (m <= 0)) {
              break label1237;
            }
            paramInt1 = Integer.MAX_VALUE;
            l2 = 0L;
            paramInt2 = 0;
            i6 = 0;
            if (i6 >= i12) {
              break label600;
            }
            localObject = (i)getChildAt(i6).getLayoutParams();
            if (((i)localObject).d) {
              break label541;
            }
            i7 = paramInt2;
            paramInt2 = paramInt1;
            paramInt1 = i7;
          }
          for (;;)
          {
            i7 = i6 + 1;
            i6 = paramInt2;
            paramInt2 = paramInt1;
            paramInt1 = i6;
            i6 = i7;
            break label477;
            i5 = 0;
            break;
            if (((i)localObject).b < paramInt1)
            {
              paramInt2 = ((i)localObject).b;
              l2 = 1 << i6;
              paramInt1 = 1;
            }
            else
            {
              if (((i)localObject).b != paramInt1) {
                break label1226;
              }
              l2 |= 1 << i6;
              i7 = paramInt2 + 1;
              paramInt2 = paramInt1;
              paramInt1 = i7;
            }
          }
          l1 |= l2;
          if (paramInt2 > m) {}
          for (;;)
          {
            float f2;
            float f1;
            if ((n == 0) && (i3 == 1))
            {
              paramInt1 = 1;
              if ((m <= 0) || (l1 == 0L) || ((m >= i3 - 1) && (paramInt1 == 0) && (i2 <= 1))) {
                break label1214;
              }
              float f3 = Long.bitCount(l1);
              f2 = f3;
              if (paramInt1 != 0) {
                break label1208;
              }
              f1 = f3;
              if ((1L & l1) != 0L)
              {
                f1 = f3;
                if (!((i)getChildAt(0).getLayoutParams()).e) {
                  f1 = f3 - 0.5F;
                }
              }
              f2 = f1;
              if ((1 << i12 - 1 & l1) == 0L) {
                break label1208;
              }
              f2 = f1;
              if (((i)getChildAt(i12 - 1).getLayoutParams()).e) {
                break label1208;
              }
              f1 -= 0.5F;
              if (f1 <= 0.0F) {
                break label961;
              }
              paramInt2 = (int)(m * i11 / f1);
              m = 0;
              paramInt1 = k;
              k = m;
              for (;;)
              {
                if (k < i12) {
                  if ((1 << k & l1) == 0L)
                  {
                    k += 1;
                    continue;
                    k = 0;
                    paramInt2 = m;
                    if (k < i12)
                    {
                      localObject = getChildAt(k);
                      locali = (i)((View)localObject).getLayoutParams();
                      if ((1 << k & l2) == 0L)
                      {
                        if (locali.b != paramInt1 + 1) {
                          break label1223;
                        }
                        l1 |= 1 << k;
                      }
                    }
                  }
                }
              }
            }
            for (;;)
            {
              k += 1;
              break label818;
              if ((i5 != 0) && (locali.e) && (paramInt2 == 1)) {
                ((View)localObject).setPadding(this.g + i11, 0, this.g, 0);
              }
              locali.b += 1;
              locali.f = true;
              paramInt2 -= 1;
              continue;
              k = 1;
              m = paramInt2;
              break;
              paramInt1 = 0;
              break label626;
              paramInt2 = 0;
              break label773;
              localObject = getChildAt(k);
              locali = (i)((View)localObject).getLayoutParams();
              if ((localObject instanceof ActionMenuItemView))
              {
                locali.c = paramInt2;
                locali.f = true;
                if ((k == 0) && (!locali.e)) {
                  locali.leftMargin = (-paramInt2 / 2);
                }
                paramInt1 = 1;
                break label803;
              }
              if (locali.a)
              {
                locali.c = paramInt2;
                locali.f = true;
                locali.rightMargin = (-paramInt2 / 2);
                paramInt1 = 1;
                break label803;
              }
              if (k != 0) {
                locali.leftMargin = (paramInt2 / 2);
              }
              if (k != i12 - 1) {
                locali.rightMargin = (paramInt2 / 2);
              }
              break label803;
              for (paramInt2 = 0;; paramInt2 = m)
              {
                if (paramInt1 != 0)
                {
                  paramInt1 = 0;
                  if (paramInt1 < i12)
                  {
                    localObject = getChildAt(paramInt1);
                    locali = (i)((View)localObject).getLayoutParams();
                    if (!locali.f) {}
                    for (;;)
                    {
                      paramInt1 += 1;
                      break;
                      k = locali.b;
                      ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(locali.c + k * i11, 1073741824), i4);
                    }
                  }
                }
                if (i9 != 1073741824) {}
                for (;;)
                {
                  setMeasuredDimension(i10, j);
                  this.h = (paramInt2 * i11);
                  return;
                  j = i8;
                }
                f1 = f2;
                break;
                paramInt1 = k;
              }
            }
            i7 = paramInt1;
            paramInt1 = paramInt2;
            paramInt2 = i7;
            break label514;
          }
        }
        i1 = paramInt2;
        paramInt2 = i2;
        i2 = i5;
        paramInt1 = i3;
        n = k;
        k = i2;
        break;
      }
    }
  }
  
  protected i a()
  {
    i locali = new i(-2, -2);
    locali.gravity = 16;
    return locali;
  }
  
  public i a(AttributeSet paramAttributeSet)
  {
    return new i(getContext(), paramAttributeSet);
  }
  
  protected i a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof i))
    {
      paramLayoutParams = new i((i)paramLayoutParams);
      if (paramLayoutParams.gravity <= 0) {
        paramLayoutParams.gravity = 16;
      }
      return paramLayoutParams;
    }
    return a();
  }
  
  public void a(o paramo)
  {
    this.a = paramo;
  }
  
  protected boolean a(int paramInt)
  {
    View localView1 = getChildAt(paramInt - 1);
    View localView2 = getChildAt(paramInt);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt < getChildCount())
    {
      bool1 = bool2;
      if ((localView1 instanceof h)) {
        bool1 = false | ((h)localView1).d();
      }
    }
    if ((paramInt > 0) && ((localView2 instanceof h))) {
      return ((h)localView2).c() | bool1;
    }
    return bool1;
  }
  
  public boolean a(s params)
  {
    return this.a.a(params, 0);
  }
  
  public i b()
  {
    i locali = a();
    locali.a = true;
    return locali;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (paramLayoutParams != null) && ((paramLayoutParams instanceof i));
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }
  
  public int getWindowAnimations()
  {
    return 0;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      super.onConfigurationChanged(paramConfiguration);
    }
    this.c.c(false);
    if ((this.c != null) && (this.c.e()))
    {
      this.c.b();
      this.c.a();
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.c.c();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.d)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    int i3 = getChildCount();
    int i2 = (paramInt2 + paramInt4) / 2;
    int i4 = getSupportDividerWidth();
    paramInt4 = 0;
    paramInt2 = 0;
    int k = paramInt3 - paramInt1 - getPaddingRight() - getPaddingLeft();
    int j = 0;
    int m = 0;
    View localView;
    i locali;
    if (m < i3)
    {
      localView = getChildAt(m);
      int n;
      int i1;
      if (localView.getVisibility() == 8)
      {
        n = j;
        i1 = k;
        k = paramInt4;
        j = paramInt2;
        paramInt4 = i1;
        paramInt2 = n;
      }
      for (;;)
      {
        i1 = m + 1;
        m = k;
        n = j;
        j = paramInt2;
        k = paramInt4;
        paramInt2 = n;
        paramInt4 = m;
        m = i1;
        break;
        locali = (i)localView.getLayoutParams();
        if (locali.a)
        {
          n = localView.getMeasuredWidth();
          j = n;
          if (a(m)) {
            j = n + i4;
          }
          n = localView.getMeasuredHeight();
          i1 = getWidth() - getPaddingRight() - locali.rightMargin;
          int i5 = i2 - n / 2;
          localView.layout(i1 - j, i5, i1, n + i5);
          n = k - j;
          i1 = 1;
          j = paramInt2;
          k = paramInt4;
          paramInt2 = i1;
          paramInt4 = n;
        }
        else
        {
          i1 = localView.getMeasuredWidth() + locali.leftMargin + locali.rightMargin;
          n = paramInt4 + i1;
          paramInt4 = n;
          if (a(m)) {
            paramInt4 = n + i4;
          }
          n = k - i1;
          i1 = paramInt2 + 1;
          k = paramInt4;
          paramInt2 = j;
          paramInt4 = n;
          j = i1;
        }
      }
    }
    if ((i3 == 1) && (j == 0))
    {
      localView = getChildAt(0);
      paramInt2 = localView.getMeasuredWidth();
      paramInt4 = localView.getMeasuredHeight();
      paramInt1 = (paramInt3 - paramInt1) / 2 - paramInt2 / 2;
      paramInt3 = i2 - paramInt4 / 2;
      localView.layout(paramInt1, paramInt3, paramInt2 + paramInt1, paramInt4 + paramInt3);
      return;
    }
    if (j != 0)
    {
      paramInt1 = 0;
      label423:
      paramInt1 = paramInt2 - paramInt1;
      if (paramInt1 <= 0) {
        break label503;
      }
      paramInt1 = k / paramInt1;
      label436:
      paramInt3 = Math.max(0, paramInt1);
      paramInt1 = getPaddingLeft();
      paramInt2 = 0;
      label450:
      if (paramInt2 < i3)
      {
        localView = getChildAt(paramInt2);
        locali = (i)localView.getLayoutParams();
        if (localView.getVisibility() == 8) {
          break label573;
        }
        if (!locali.a) {
          break label508;
        }
      }
    }
    label503:
    label508:
    label573:
    for (;;)
    {
      paramInt2 += 1;
      break label450;
      break;
      paramInt1 = 1;
      break label423;
      paramInt1 = 0;
      break label436;
      paramInt1 += locali.leftMargin;
      paramInt4 = localView.getMeasuredWidth();
      j = localView.getMeasuredHeight();
      k = i2 - j / 2;
      localView.layout(paramInt1, k, paramInt1 + paramInt4, j + k);
      paramInt1 = locali.rightMargin + paramInt4 + paramInt3 + paramInt1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool2 = this.d;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.d = bool1;
      if (bool2 != this.d) {
        this.e = 0;
      }
      j = View.MeasureSpec.getMode(paramInt1);
      if ((this.d) && (this.a != null) && (j != this.e))
      {
        this.e = j;
        this.a.b(true);
      }
      if (!this.d) {
        break;
      }
      a(paramInt1, paramInt2);
      return;
    }
    int k = getChildCount();
    int j = 0;
    while (j < k)
    {
      i locali = (i)getChildAt(j).getLayoutParams();
      locali.rightMargin = 0;
      locali.leftMargin = 0;
      j += 1;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setOverflowReserved(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setPresenter(ActionMenuPresenter paramActionMenuPresenter)
  {
    this.c = paramActionMenuPresenter;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/view/menu/ActionMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */