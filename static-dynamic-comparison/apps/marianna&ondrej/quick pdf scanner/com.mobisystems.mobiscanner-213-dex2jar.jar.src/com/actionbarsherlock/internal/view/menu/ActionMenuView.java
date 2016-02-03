package com.actionbarsherlock.internal.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout.LayoutParams;
import com.actionbarsherlock.internal.widget.IcsLinearLayout;

public class ActionMenuView
  extends IcsLinearLayout
  implements MenuBuilder.ItemInvoker, MenuView
{
  static final int GENERATED_ITEM_PADDING = 4;
  private static final boolean IS_FROYO;
  static final int MIN_CELL_SIZE = 56;
  private boolean mFirst = true;
  private boolean mFormatItems;
  private int mFormatItemsWidth;
  private int mGeneratedItemPadding;
  private MenuBuilder mMenu;
  private int mMinCellSize;
  private ActionMenuPresenter mPresenter;
  private boolean mReserveOverflow;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 8) {}
    for (boolean bool = true;; bool = false)
    {
      IS_FROYO = bool;
      return;
    }
  }
  
  public ActionMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBaselineAligned(false);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.mMinCellSize = ((int)(56.0F * f));
    this.mGeneratedItemPadding = ((int)(f * 4.0F));
  }
  
  static int measureChildForCells(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool2 = false;
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    paramInt3 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt3) - paramInt4, View.MeasureSpec.getMode(paramInt3));
    if (paramInt2 > 0)
    {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 * paramInt2, Integer.MIN_VALUE), paramInt3);
      paramInt4 = paramView.getMeasuredWidth();
      paramInt2 = paramInt4 / paramInt1;
      if (paramInt4 % paramInt1 != 0) {
        paramInt2 += 1;
      }
    }
    for (;;)
    {
      if ((paramView instanceof ActionMenuItemView)) {}
      for (ActionMenuItemView localActionMenuItemView = (ActionMenuItemView)paramView;; localActionMenuItemView = null)
      {
        boolean bool1 = bool2;
        if (!localLayoutParams.isOverflowButton)
        {
          bool1 = bool2;
          if (localActionMenuItemView != null)
          {
            bool1 = bool2;
            if (localActionMenuItemView.hasText()) {
              bool1 = true;
            }
          }
        }
        localLayoutParams.expandable = bool1;
        localLayoutParams.cellsUsed = paramInt2;
        paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt2 * paramInt1, 1073741824), paramInt3);
        return paramInt2;
      }
      continue;
      paramInt2 = 0;
    }
  }
  
  private void onMeasureExactFormat(int paramInt1, int paramInt2)
  {
    int i7 = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int i6 = View.MeasureSpec.getSize(paramInt2);
    int i = getPaddingLeft();
    int j = getPaddingRight();
    int i11 = getPaddingTop() + getPaddingBottom();
    int i8 = paramInt1 - (i + j);
    paramInt1 = i8 / this.mMinCellSize;
    i = this.mMinCellSize;
    if (paramInt1 == 0)
    {
      setMeasuredDimension(i8, 0);
      return;
    }
    int i9 = this.mMinCellSize + i8 % i / paramInt1;
    i = 0;
    int k = 0;
    int n = 0;
    int i1 = 0;
    int m = 0;
    long l1 = 0L;
    int i10 = getChildCount();
    int i2 = 0;
    Object localObject;
    boolean bool;
    LayoutParams localLayoutParams;
    label276:
    label294:
    int i12;
    int i3;
    for (;;)
    {
      if (i2 < i10)
      {
        localObject = getChildAt(i2);
        if (((View)localObject).getVisibility() == 8)
        {
          j = i;
          i = k;
          k = paramInt1;
          paramInt1 = i1;
          i2 += 1;
          i1 = paramInt1;
          paramInt1 = k;
          k = i;
          i = j;
        }
        else
        {
          bool = localObject instanceof ActionMenuItemView;
          i1 += 1;
          if (bool) {
            ((View)localObject).setPadding(this.mGeneratedItemPadding, 0, this.mGeneratedItemPadding, 0);
          }
          localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
          localLayoutParams.expanded = false;
          localLayoutParams.extraPixels = 0;
          localLayoutParams.cellsUsed = 0;
          localLayoutParams.expandable = false;
          localLayoutParams.leftMargin = 0;
          localLayoutParams.rightMargin = 0;
          if ((bool) && (((ActionMenuItemView)localObject).hasText()))
          {
            bool = true;
            localLayoutParams.preventEdgeOffset = bool;
            if (!localLayoutParams.isOverflowButton) {
              break label412;
            }
            j = 1;
            i12 = measureChildForCells((View)localObject, i9, j, paramInt2, i11);
            i3 = Math.max(k, i12);
            if (!localLayoutParams.expandable) {
              break label1262;
            }
          }
        }
      }
    }
    label412:
    label459:
    label496:
    label523:
    label582:
    label608:
    label739:
    label755:
    label788:
    label803:
    label946:
    label1083:
    label1087:
    label1198:
    label1204:
    label1207:
    label1218:
    label1262:
    for (j = n + 1;; j = n)
    {
      if (localLayoutParams.isOverflowButton) {}
      for (k = 1;; k = m)
      {
        int i5 = paramInt1 - i12;
        int i4 = Math.max(i, ((View)localObject).getMeasuredHeight());
        if (i12 == 1)
        {
          long l2 = 1 << i2;
          l1 = l2 | l1;
          i = i3;
          paramInt1 = i1;
          n = j;
          m = k;
          j = i4;
          k = i5;
          break;
          bool = false;
          break label276;
          j = paramInt1;
          break label294;
          if ((m != 0) && (i1 == 2))
          {
            i3 = 1;
            j = 0;
            i2 = paramInt1;
            if ((n <= 0) || (i2 <= 0)) {
              break label1218;
            }
            paramInt1 = Integer.MAX_VALUE;
            l2 = 0L;
            paramInt2 = 0;
            i4 = 0;
            if (i4 >= i10) {
              break label582;
            }
            localObject = (LayoutParams)getChildAt(i4).getLayoutParams();
            if (((LayoutParams)localObject).expandable) {
              break label523;
            }
            i5 = paramInt2;
            paramInt2 = paramInt1;
            paramInt1 = i5;
          }
          for (;;)
          {
            i5 = i4 + 1;
            i4 = paramInt2;
            paramInt2 = paramInt1;
            paramInt1 = i4;
            i4 = i5;
            break label459;
            i3 = 0;
            break;
            if (((LayoutParams)localObject).cellsUsed < paramInt1)
            {
              paramInt2 = ((LayoutParams)localObject).cellsUsed;
              l2 = 1 << i4;
              paramInt1 = 1;
            }
            else
            {
              if (((LayoutParams)localObject).cellsUsed != paramInt1) {
                break label1207;
              }
              l2 |= 1 << i4;
              i5 = paramInt2 + 1;
              paramInt2 = paramInt1;
              paramInt1 = i5;
            }
          }
          l1 |= l2;
          if (paramInt2 > i2) {}
          for (;;)
          {
            float f2;
            float f1;
            if ((m == 0) && (i1 == 1))
            {
              paramInt1 = 1;
              if ((i2 <= 0) || (l1 == 0L) || ((i2 >= i1 - 1) && (paramInt1 == 0) && (k <= 1))) {
                break label1083;
              }
              float f3 = Long.bitCount(l1);
              f2 = f3;
              if (paramInt1 != 0) {
                break label1198;
              }
              f1 = f3;
              if ((1L & l1) != 0L)
              {
                f1 = f3;
                if (!((LayoutParams)getChildAt(0).getLayoutParams()).preventEdgeOffset) {
                  f1 = f3 - 0.5F;
                }
              }
              f2 = f1;
              if ((1 << i10 - 1 & l1) == 0L) {
                break label1198;
              }
              f2 = f1;
              if (((LayoutParams)getChildAt(i10 - 1).getLayoutParams()).preventEdgeOffset) {
                break label1198;
              }
              f1 -= 0.5F;
              if (f1 <= 0.0F) {
                break label946;
              }
              paramInt2 = (int)(i2 * i9 / f1);
              k = 0;
              paramInt1 = j;
              j = k;
              for (;;)
              {
                k = paramInt1;
                if (j >= i10) {
                  break label1087;
                }
                if ((1 << j & l1) != 0L) {
                  break;
                }
                j += 1;
              }
              j = 0;
              paramInt2 = i2;
              if (j < i10)
              {
                localObject = getChildAt(j);
                localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
                if ((1 << j & l2) == 0L)
                {
                  if (localLayoutParams.cellsUsed != paramInt1 + 1) {
                    break label1204;
                  }
                  l1 |= 1 << j;
                }
              }
            }
            for (;;)
            {
              j += 1;
              break label803;
              if ((i3 != 0) && (localLayoutParams.preventEdgeOffset) && (paramInt2 == 1)) {
                ((View)localObject).setPadding(this.mGeneratedItemPadding + i9, 0, this.mGeneratedItemPadding, 0);
              }
              localLayoutParams.cellsUsed += 1;
              localLayoutParams.expanded = true;
              paramInt2 -= 1;
              continue;
              j = 1;
              i2 = paramInt2;
              break;
              paramInt1 = 0;
              break label608;
              paramInt2 = 0;
              break label755;
              localObject = getChildAt(j);
              localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
              if ((localObject instanceof ActionMenuItemView))
              {
                localLayoutParams.extraPixels = paramInt2;
                localLayoutParams.expanded = true;
                if ((j == 0) && (!localLayoutParams.preventEdgeOffset)) {
                  localLayoutParams.leftMargin = (-paramInt2 / 2);
                }
                paramInt1 = 1;
                break label788;
              }
              if (localLayoutParams.isOverflowButton)
              {
                localLayoutParams.extraPixels = paramInt2;
                localLayoutParams.expanded = true;
                localLayoutParams.rightMargin = (-paramInt2 / 2);
                paramInt1 = 1;
                break label788;
              }
              if (j != 0) {
                localLayoutParams.leftMargin = (paramInt2 / 2);
              }
              if (j != i10 - 1) {
                localLayoutParams.rightMargin = (paramInt2 / 2);
              }
              break label788;
              k = j;
              if (k != 0)
              {
                paramInt2 = View.MeasureSpec.makeMeasureSpec(i6 - i11, i7);
                paramInt1 = 0;
                if (paramInt1 < i10)
                {
                  localObject = getChildAt(paramInt1);
                  localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
                  if (!localLayoutParams.expanded) {}
                  for (;;)
                  {
                    paramInt1 += 1;
                    break;
                    j = localLayoutParams.cellsUsed;
                    ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(localLayoutParams.extraPixels + j * i9, 1073741824), paramInt2);
                  }
                }
              }
              if (i7 != 1073741824) {}
              for (;;)
              {
                setMeasuredDimension(i8, i);
                return;
                i = i6;
              }
              f1 = f2;
              break label739;
            }
            i5 = paramInt1;
            paramInt1 = paramInt2;
            paramInt2 = i5;
            break label496;
          }
        }
        paramInt1 = i1;
        i = i3;
        i1 = i4;
        i3 = i5;
        n = j;
        m = k;
        j = i1;
        k = i3;
        break;
      }
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (paramLayoutParams != null) && ((paramLayoutParams instanceof LayoutParams));
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }
  
  protected LayoutParams generateDefaultLayoutParams()
  {
    LayoutParams localLayoutParams = new LayoutParams(-2, -2);
    localLayoutParams.gravity = 16;
    return localLayoutParams;
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LayoutParams))
    {
      paramLayoutParams = new LayoutParams((LayoutParams)paramLayoutParams);
      if (paramLayoutParams.gravity <= 0) {
        paramLayoutParams.gravity = 16;
      }
      return paramLayoutParams;
    }
    return generateDefaultLayoutParams();
  }
  
  public LayoutParams generateOverflowButtonLayoutParams()
  {
    LayoutParams localLayoutParams = generateDefaultLayoutParams();
    localLayoutParams.isOverflowButton = true;
    return localLayoutParams;
  }
  
  public int getWindowAnimations()
  {
    return 0;
  }
  
  protected boolean hasDividerBeforeChildAt(int paramInt)
  {
    boolean bool2 = false;
    if (paramInt == 0) {
      return false;
    }
    View localView1 = getChildAt(paramInt - 1);
    View localView2 = getChildAt(paramInt);
    boolean bool1 = bool2;
    if (paramInt < getChildCount())
    {
      bool1 = bool2;
      if ((localView1 instanceof ActionMenuChildView)) {
        bool1 = false | ((ActionMenuChildView)localView1).needsDividerAfter();
      }
    }
    if ((paramInt > 0) && ((localView2 instanceof ActionMenuChildView))) {
      return ((ActionMenuChildView)localView2).needsDividerBefore() | bool1;
    }
    return bool1;
  }
  
  public void initialize(MenuBuilder paramMenuBuilder)
  {
    this.mMenu = paramMenuBuilder;
  }
  
  public boolean invokeItem(MenuItemImpl paramMenuItemImpl)
  {
    return this.mMenu.performItemAction(paramMenuItemImpl, 0);
  }
  
  public boolean isExpandedFormat()
  {
    return this.mFormatItems;
  }
  
  public boolean isOverflowReserved()
  {
    return this.mReserveOverflow;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (IS_FROYO) {
      super.onConfigurationChanged(paramConfiguration);
    }
    this.mPresenter.updateMenuView(false);
    if ((this.mPresenter != null) && (this.mPresenter.isOverflowMenuShowing()))
    {
      this.mPresenter.hideOverflowMenu();
      this.mPresenter.showOverflowMenu();
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mPresenter.dismissPopupMenus();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((!IS_FROYO) && (this.mFirst))
    {
      this.mFirst = false;
      requestLayout();
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.mFormatItems)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    int n = getChildCount();
    int m = (paramInt2 + paramInt4) / 2;
    paramInt2 = 0;
    int i = paramInt3 - paramInt1 - getPaddingRight() - getPaddingLeft();
    paramInt4 = 0;
    int j = 0;
    View localView;
    LayoutParams localLayoutParams;
    if (j < n)
    {
      localView = getChildAt(j);
      int k;
      if (localView.getVisibility() == 8)
      {
        k = paramInt4;
        paramInt4 = i;
        i = paramInt2;
        paramInt2 = k;
      }
      for (;;)
      {
        k = j + 1;
        j = i;
        i = paramInt4;
        paramInt4 = paramInt2;
        paramInt2 = j;
        j = k;
        break;
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        int i1;
        int i2;
        if (localLayoutParams.isOverflowButton)
        {
          k = localView.getMeasuredWidth();
          paramInt4 = k;
          if (hasDividerBeforeChildAt(j)) {
            paramInt4 = k + 0;
          }
          k = localView.getMeasuredHeight();
          i1 = getWidth() - getPaddingRight() - localLayoutParams.rightMargin;
          i2 = m - k / 2;
          localView.layout(i1 - paramInt4, i2, i1, k + i2);
          paramInt4 = i - paramInt4;
          k = 1;
          i = paramInt2;
          paramInt2 = k;
        }
        else
        {
          i1 = localView.getMeasuredWidth();
          i2 = localLayoutParams.leftMargin;
          int i3 = localLayoutParams.rightMargin;
          k = paramInt2 + 1;
          i -= i3 + (i1 + i2);
          paramInt2 = paramInt4;
          paramInt4 = i;
          i = k;
        }
      }
    }
    if ((n == 1) && (paramInt4 == 0))
    {
      localView = getChildAt(0);
      paramInt2 = localView.getMeasuredWidth();
      paramInt4 = localView.getMeasuredHeight();
      paramInt1 = (paramInt3 - paramInt1) / 2 - paramInt2 / 2;
      paramInt3 = m - paramInt4 / 2;
      localView.layout(paramInt1, paramInt3, paramInt2 + paramInt1, paramInt4 + paramInt3);
      return;
    }
    if (paramInt4 != 0)
    {
      paramInt1 = 0;
      label366:
      paramInt1 = paramInt2 - paramInt1;
      if (paramInt1 <= 0) {
        break label446;
      }
      paramInt1 = i / paramInt1;
      label379:
      paramInt3 = Math.max(0, paramInt1);
      paramInt1 = getPaddingLeft();
      paramInt2 = 0;
      label393:
      if (paramInt2 < n)
      {
        localView = getChildAt(paramInt2);
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (localView.getVisibility() == 8) {
          break label516;
        }
        if (!localLayoutParams.isOverflowButton) {
          break label451;
        }
      }
    }
    label446:
    label451:
    label516:
    for (;;)
    {
      paramInt2 += 1;
      break label393;
      break;
      paramInt1 = 1;
      break label366;
      paramInt1 = 0;
      break label379;
      paramInt1 += localLayoutParams.leftMargin;
      paramInt4 = localView.getMeasuredWidth();
      i = localView.getMeasuredHeight();
      j = m - i / 2;
      localView.layout(paramInt1, j, paramInt1 + paramInt4, i + j);
      paramInt1 = localLayoutParams.rightMargin + paramInt4 + paramInt3 + paramInt1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool2 = this.mFormatItems;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.mFormatItems = bool1;
      if (bool2 != this.mFormatItems) {
        this.mFormatItemsWidth = 0;
      }
      int i = View.MeasureSpec.getMode(paramInt1);
      if ((this.mFormatItems) && (this.mMenu != null) && (i != this.mFormatItemsWidth))
      {
        this.mFormatItemsWidth = i;
        this.mMenu.onItemsChanged(true);
      }
      if (!this.mFormatItems) {
        break;
      }
      onMeasureExactFormat(paramInt1, paramInt2);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setOverflowReserved(boolean paramBoolean)
  {
    this.mReserveOverflow = paramBoolean;
  }
  
  public void setPresenter(ActionMenuPresenter paramActionMenuPresenter)
  {
    this.mPresenter = paramActionMenuPresenter;
  }
  
  public static abstract interface ActionMenuChildView
  {
    public abstract boolean needsDividerAfter();
    
    public abstract boolean needsDividerBefore();
  }
  
  public static class LayoutParams
    extends LinearLayout.LayoutParams
  {
    public int cellsUsed;
    public boolean expandable;
    public boolean expanded;
    public int extraPixels;
    public boolean isOverflowButton;
    public boolean preventEdgeOffset;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      this.isOverflowButton = false;
    }
    
    public LayoutParams(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      super(paramInt2);
      this.isOverflowButton = paramBoolean;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.isOverflowButton = paramLayoutParams.isOverflowButton;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/actionbarsherlock/internal/view/menu/ActionMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */