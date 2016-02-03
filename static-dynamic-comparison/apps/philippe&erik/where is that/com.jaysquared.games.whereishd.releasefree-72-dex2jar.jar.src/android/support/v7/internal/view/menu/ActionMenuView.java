package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.widget.LinearLayoutICS;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout.LayoutParams;

public class ActionMenuView
  extends LinearLayoutICS
  implements MenuBuilder.ItemInvoker, MenuView
{
  static final int GENERATED_ITEM_PADDING = 4;
  static final int MIN_CELL_SIZE = 56;
  private static final String TAG = "ActionMenuView";
  private boolean mFormatItems;
  private int mFormatItemsWidth;
  private int mGeneratedItemPadding;
  private int mMaxItemHeight;
  private int mMeasuredExtraWidth;
  private MenuBuilder mMenu;
  private int mMinCellSize;
  private ActionMenuPresenter mPresenter;
  private boolean mReserveOverflow;
  
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
    this.mGeneratedItemPadding = ((int)(4.0F * f));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
    this.mMaxItemHeight = paramContext.getDimensionPixelSize(0, 0);
    paramContext.recycle();
  }
  
  static int measureChildForCells(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int j = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt3) - paramInt4, View.MeasureSpec.getMode(paramInt3));
    ActionMenuItemView localActionMenuItemView;
    if ((paramView instanceof ActionMenuItemView))
    {
      localActionMenuItemView = (ActionMenuItemView)paramView;
      if ((localActionMenuItemView == null) || (!localActionMenuItemView.hasText())) {
        break label182;
      }
      paramInt4 = 1;
      label54:
      int i = 0;
      paramInt3 = i;
      if (paramInt2 > 0) {
        if (paramInt4 != 0)
        {
          paramInt3 = i;
          if (paramInt2 < 2) {}
        }
        else
        {
          paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 * paramInt2, Integer.MIN_VALUE), j);
          i = paramView.getMeasuredWidth();
          paramInt3 = i / paramInt1;
          paramInt2 = paramInt3;
          if (i % paramInt1 != 0) {
            paramInt2 = paramInt3 + 1;
          }
          paramInt3 = paramInt2;
          if (paramInt4 != 0)
          {
            paramInt3 = paramInt2;
            if (paramInt2 < 2) {
              paramInt3 = 2;
            }
          }
        }
      }
      if ((localLayoutParams.isOverflowButton) || (paramInt4 == 0)) {
        break label188;
      }
    }
    label182:
    label188:
    for (boolean bool = true;; bool = false)
    {
      localLayoutParams.expandable = bool;
      localLayoutParams.cellsUsed = paramInt3;
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 * paramInt1, 1073741824), j);
      return paramInt3;
      localActionMenuItemView = null;
      break;
      paramInt4 = 0;
      break label54;
    }
  }
  
  private void onMeasureExactFormat(int paramInt1, int paramInt2)
  {
    int i9 = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int i8 = View.MeasureSpec.getSize(paramInt2);
    paramInt2 = getPaddingLeft();
    int i = getPaddingRight();
    int i13 = getPaddingTop() + getPaddingBottom();
    if (i9 == 1073741824) {}
    int i10;
    for (int n = View.MeasureSpec.makeMeasureSpec(i8 - i13, 1073741824);; n = View.MeasureSpec.makeMeasureSpec(Math.min(this.mMaxItemHeight, i8 - i13), Integer.MIN_VALUE))
    {
      i10 = paramInt1 - (paramInt2 + i);
      paramInt2 = i10 / this.mMinCellSize;
      paramInt1 = this.mMinCellSize;
      if (paramInt2 != 0) {
        break;
      }
      setMeasuredDimension(i10, 0);
      return;
    }
    int i11 = this.mMinCellSize + i10 % paramInt1 / paramInt2;
    i = 0;
    int i1 = 0;
    int k = 0;
    int i2 = 0;
    int j = 0;
    long l1 = 0L;
    int i12 = getChildCount();
    int m = 0;
    Object localObject;
    long l2;
    int i3;
    int i4;
    LayoutParams localLayoutParams;
    label301:
    int i5;
    int i6;
    int i7;
    while (m < i12)
    {
      localObject = getChildAt(m);
      if (((View)localObject).getVisibility() == 8)
      {
        l2 = l1;
        i3 = j;
        m += 1;
        j = i3;
        l1 = l2;
      }
      else
      {
        boolean bool = localObject instanceof ActionMenuItemView;
        i4 = i2 + 1;
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
            break label459;
          }
        }
        label459:
        for (paramInt1 = 1;; paramInt1 = paramInt2)
        {
          int i14 = measureChildForCells((View)localObject, i11, paramInt1, n, i13);
          i5 = Math.max(i1, i14);
          paramInt1 = k;
          if (localLayoutParams.expandable) {
            paramInt1 = k + 1;
          }
          if (localLayoutParams.isOverflowButton) {
            j = 1;
          }
          i6 = paramInt2 - i14;
          i7 = Math.max(i, ((View)localObject).getMeasuredHeight());
          paramInt2 = i6;
          k = paramInt1;
          i3 = j;
          i1 = i5;
          i = i7;
          l2 = l1;
          i2 = i4;
          if (i14 != 1) {
            break;
          }
          l2 = l1 | 1 << m;
          paramInt2 = i6;
          k = paramInt1;
          i3 = j;
          i1 = i5;
          i = i7;
          i2 = i4;
          break;
          bool = false;
          break label301;
        }
      }
    }
    long l3;
    if ((j != 0) && (i2 == 2))
    {
      i3 = 1;
      paramInt1 = 0;
      l2 = l1;
      if (k <= 0) {
        break label670;
      }
      l2 = l1;
      if (paramInt2 <= 0) {
        break label670;
      }
      i4 = Integer.MAX_VALUE;
      l3 = 0L;
      i7 = 0;
      i5 = 0;
      label510:
      if (i5 >= i12) {
        break label653;
      }
      localObject = (LayoutParams)getChildAt(i5).getLayoutParams();
      if (((LayoutParams)localObject).expandable) {
        break label578;
      }
      m = i7;
      l2 = l3;
      i6 = i4;
    }
    for (;;)
    {
      i5 += 1;
      i4 = i6;
      l3 = l2;
      i7 = m;
      break label510;
      i3 = 0;
      break;
      label578:
      if (((LayoutParams)localObject).cellsUsed < i4)
      {
        i6 = ((LayoutParams)localObject).cellsUsed;
        l2 = 1 << i5;
        m = 1;
      }
      else
      {
        i6 = i4;
        l2 = l3;
        m = i7;
        if (((LayoutParams)localObject).cellsUsed == i4)
        {
          l2 = l3 | 1 << i5;
          m = i7 + 1;
          i6 = i4;
        }
      }
    }
    label653:
    l1 |= l3;
    if (i7 > paramInt2)
    {
      l2 = l1;
      label670:
      if ((j != 0) || (i2 != 1)) {
        break label1041;
      }
      m = 1;
      label684:
      j = paramInt2;
      k = paramInt1;
      if (paramInt2 <= 0) {
        break label1201;
      }
      j = paramInt2;
      k = paramInt1;
      if (l2 == 0L) {
        break label1201;
      }
      if ((paramInt2 >= i2 - 1) && (m == 0))
      {
        j = paramInt2;
        k = paramInt1;
        if (i1 <= 1) {
          break label1201;
        }
      }
      float f3 = Long.bitCount(l2);
      float f2 = f3;
      if (m == 0)
      {
        float f1 = f3;
        if ((1L & l2) != 0L)
        {
          f1 = f3;
          if (!((LayoutParams)getChildAt(0).getLayoutParams()).preventEdgeOffset) {
            f1 = f3 - 0.5F;
          }
        }
        f2 = f1;
        if ((1 << i12 - 1 & l2) != 0L)
        {
          f2 = f1;
          if (!((LayoutParams)getChildAt(i12 - 1).getLayoutParams()).preventEdgeOffset) {
            f2 = f1 - 0.5F;
          }
        }
      }
      if (f2 <= 0.0F) {
        break label1047;
      }
      j = (int)(paramInt2 * i11 / f2);
      label852:
      k = 0;
      label855:
      if (k >= i12) {
        break label1195;
      }
      if ((1 << k & l2) != 0L) {
        break label1053;
      }
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      k += 1;
      paramInt1 = paramInt2;
      break label855;
      paramInt1 = 0;
      if (paramInt1 < i12)
      {
        localObject = getChildAt(paramInt1);
        localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
        if ((1 << paramInt1 & l3) == 0L)
        {
          m = paramInt2;
          l2 = l1;
          if (localLayoutParams.cellsUsed == i4 + 1)
          {
            l2 = l1 | 1 << paramInt1;
            m = paramInt2;
          }
        }
        for (;;)
        {
          paramInt1 += 1;
          paramInt2 = m;
          l1 = l2;
          break;
          if ((i3 != 0) && (localLayoutParams.preventEdgeOffset) && (paramInt2 == 1)) {
            ((View)localObject).setPadding(this.mGeneratedItemPadding + i11, 0, this.mGeneratedItemPadding, 0);
          }
          localLayoutParams.cellsUsed += 1;
          localLayoutParams.expanded = true;
          m = paramInt2 - 1;
          l2 = l1;
        }
      }
      paramInt1 = 1;
      break;
      label1041:
      m = 0;
      break label684;
      label1047:
      j = 0;
      break label852;
      label1053:
      localObject = getChildAt(k);
      localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
      if ((localObject instanceof ActionMenuItemView))
      {
        localLayoutParams.extraPixels = j;
        localLayoutParams.expanded = true;
        if ((k == 0) && (!localLayoutParams.preventEdgeOffset)) {
          localLayoutParams.leftMargin = (-j / 2);
        }
        paramInt2 = 1;
      }
      else if (localLayoutParams.isOverflowButton)
      {
        localLayoutParams.extraPixels = j;
        localLayoutParams.expanded = true;
        localLayoutParams.rightMargin = (-j / 2);
        paramInt2 = 1;
      }
      else
      {
        if (k != 0) {
          localLayoutParams.leftMargin = (j / 2);
        }
        paramInt2 = paramInt1;
        if (k != i12 - 1)
        {
          localLayoutParams.rightMargin = (j / 2);
          paramInt2 = paramInt1;
        }
      }
    }
    label1195:
    j = 0;
    k = paramInt1;
    label1201:
    if (k != 0)
    {
      paramInt1 = 0;
      if (paramInt1 < i12)
      {
        localObject = getChildAt(paramInt1);
        localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
        if (!localLayoutParams.expanded) {}
        for (;;)
        {
          paramInt1 += 1;
          break;
          ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(localLayoutParams.cellsUsed * i11 + localLayoutParams.extraPixels, 1073741824), n);
        }
      }
    }
    paramInt1 = i8;
    if (i9 != 1073741824) {
      paramInt1 = i;
    }
    setMeasuredDimension(i10, paramInt1);
    this.mMeasuredExtraWidth = (j * i11);
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
  
  protected boolean hasSupportDividerBeforeChildAt(int paramInt)
  {
    View localView1 = getChildAt(paramInt - 1);
    View localView2 = getChildAt(paramInt);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt < getChildCount())
    {
      bool1 = bool2;
      if ((localView1 instanceof ActionMenuChildView)) {
        bool1 = false | ((ActionMenuChildView)localView1).needsDividerAfter();
      }
    }
    bool2 = bool1;
    if (paramInt > 0)
    {
      bool2 = bool1;
      if ((localView2 instanceof ActionMenuChildView)) {
        bool2 = bool1 | ((ActionMenuChildView)localView2).needsDividerBefore();
      }
    }
    return bool2;
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
    if (Build.VERSION.SDK_INT >= 8) {
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
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.mFormatItems)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    int i1 = getChildCount();
    int n = (paramInt2 + paramInt4) / 2;
    int i2 = getSupportDividerWidth();
    int j = 0;
    paramInt4 = 0;
    paramInt2 = paramInt3 - paramInt1 - getPaddingRight() - getPaddingLeft();
    int k = 0;
    int i = 0;
    View localView;
    LayoutParams localLayoutParams;
    if (i < i1)
    {
      localView = getChildAt(i);
      if (localView.getVisibility() == 8) {}
      for (;;)
      {
        i += 1;
        break;
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        int m;
        if (localLayoutParams.isOverflowButton)
        {
          m = localView.getMeasuredWidth();
          k = m;
          if (hasSupportDividerBeforeChildAt(i)) {
            k = m + i2;
          }
          m = localView.getMeasuredHeight();
          int i3 = getWidth() - getPaddingRight() - localLayoutParams.rightMargin;
          int i4 = n - m / 2;
          localView.layout(i3 - k, i4, i3, i4 + m);
          paramInt2 -= k;
          k = 1;
        }
        else
        {
          m = localView.getMeasuredWidth() + localLayoutParams.leftMargin + localLayoutParams.rightMargin;
          j += m;
          m = paramInt2 - m;
          paramInt2 = j;
          if (hasSupportDividerBeforeChildAt(i)) {
            paramInt2 = j + i2;
          }
          paramInt4 += 1;
          j = paramInt2;
          paramInt2 = m;
        }
      }
    }
    if ((i1 == 1) && (k == 0))
    {
      localView = getChildAt(0);
      paramInt2 = localView.getMeasuredWidth();
      paramInt4 = localView.getMeasuredHeight();
      paramInt1 = (paramInt3 - paramInt1) / 2 - paramInt2 / 2;
      paramInt3 = n - paramInt4 / 2;
      localView.layout(paramInt1, paramInt3, paramInt1 + paramInt2, paramInt3 + paramInt4);
      return;
    }
    if (k != 0)
    {
      paramInt1 = 0;
      label348:
      paramInt1 = paramInt4 - paramInt1;
      if (paramInt1 <= 0) {
        break label437;
      }
      paramInt1 = paramInt2 / paramInt1;
      label361:
      paramInt4 = Math.max(0, paramInt1);
      paramInt2 = getPaddingLeft();
      paramInt1 = 0;
      label375:
      if (paramInt1 < i1)
      {
        localView = getChildAt(paramInt1);
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        paramInt3 = paramInt2;
        if (localView.getVisibility() != 8) {
          if (!localLayoutParams.isOverflowButton) {
            break label442;
          }
        }
      }
    }
    for (paramInt3 = paramInt2;; paramInt3 = paramInt2 + (localLayoutParams.rightMargin + paramInt3 + paramInt4))
    {
      paramInt1 += 1;
      paramInt2 = paramInt3;
      break label375;
      break;
      paramInt1 = 1;
      break label348;
      label437:
      paramInt1 = 0;
      break label361;
      label442:
      paramInt2 += localLayoutParams.leftMargin;
      paramInt3 = localView.getMeasuredWidth();
      i = localView.getMeasuredHeight();
      j = n - i / 2;
      localView.layout(paramInt2, j, paramInt2 + paramInt3, j + i);
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
      i = View.MeasureSpec.getMode(paramInt1);
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
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      LayoutParams localLayoutParams = (LayoutParams)getChildAt(i).getLayoutParams();
      localLayoutParams.rightMargin = 0;
      localLayoutParams.leftMargin = 0;
      i += 1;
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
    @ViewDebug.ExportedProperty
    public int cellsUsed;
    @ViewDebug.ExportedProperty
    public boolean expandable;
    public boolean expanded;
    @ViewDebug.ExportedProperty
    public int extraPixels;
    @ViewDebug.ExportedProperty
    public boolean isOverflowButton;
    @ViewDebug.ExportedProperty
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/android/support/v7/internal/view/menu/ActionMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */