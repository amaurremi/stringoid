package mobi.beyondpod.ui.core.pulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import mobi.beyondpod.ui.core.pulltorefresh.internal.EmptyViewMethodAccessor;

public abstract class PullToRefreshAdapterViewBase<T extends AbsListView>
  extends PullToRefreshBase<T>
  implements AbsListView.OnScrollListener
{
  private View emptyView;
  private int lastSavedFirstVisibleItem = -1;
  private PullToRefreshBase.OnLastItemVisibleListener onLastItemVisibleListener;
  private AbsListView.OnScrollListener onScrollListener;
  private FrameLayout refreshableViewHolder;
  
  public PullToRefreshAdapterViewBase(Context paramContext)
  {
    super(paramContext);
    ((AbsListView)this.refreshableView).setOnScrollListener(this);
  }
  
  public PullToRefreshAdapterViewBase(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    ((AbsListView)this.refreshableView).setOnScrollListener(this);
  }
  
  public PullToRefreshAdapterViewBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ((AbsListView)this.refreshableView).setOnScrollListener(this);
  }
  
  private boolean isFirstItemVisible()
  {
    if (((AbsListView)this.refreshableView).getCount() == 0) {
      return true;
    }
    if (((AbsListView)this.refreshableView).getFirstVisiblePosition() == 0)
    {
      View localView = ((AbsListView)this.refreshableView).getChildAt(0);
      if (localView != null) {
        return localView.getTop() >= ((AbsListView)this.refreshableView).getTop();
      }
    }
    return false;
  }
  
  private boolean isLastItemVisible()
  {
    int j = ((AbsListView)this.refreshableView).getCount();
    int i = ((AbsListView)this.refreshableView).getLastVisiblePosition();
    if (j == 0) {
      return true;
    }
    if (i == j - 1)
    {
      j = ((AbsListView)this.refreshableView).getFirstVisiblePosition();
      View localView = ((AbsListView)this.refreshableView).getChildAt(i - j);
      if (localView != null) {
        return localView.getBottom() <= ((AbsListView)this.refreshableView).getBottom();
      }
    }
    return false;
  }
  
  protected void addRefreshableView(Context paramContext, T paramT)
  {
    this.refreshableViewHolder = new FrameLayout(paramContext);
    this.refreshableViewHolder.addView(paramT, -1, -1);
    addView(this.refreshableViewHolder, new LinearLayout.LayoutParams(-1, 0, 1.0F));
  }
  
  public abstract ContextMenu.ContextMenuInfo getContextMenuInfo();
  
  protected boolean isReadyForPullDown()
  {
    return isFirstItemVisible();
  }
  
  protected boolean isReadyForPullUp()
  {
    return isLastItemVisible();
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.onLastItemVisibleListener != null) && (paramInt2 > 0) && (paramInt1 + paramInt2 == paramInt3) && (paramInt1 != this.lastSavedFirstVisibleItem))
    {
      this.lastSavedFirstVisibleItem = paramInt1;
      this.onLastItemVisibleListener.onLastItemVisible();
    }
    if (this.onScrollListener != null) {
      this.onScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.onScrollListener != null) {
      this.onScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public final void setEmptyView(View paramView)
  {
    if (this.emptyView != null) {
      this.refreshableViewHolder.removeView(this.emptyView);
    }
    if (paramView != null)
    {
      ViewParent localViewParent = paramView.getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
        ((ViewGroup)localViewParent).removeView(paramView);
      }
      this.refreshableViewHolder.addView(paramView, -1, -1);
    }
    if ((this.refreshableView instanceof EmptyViewMethodAccessor))
    {
      ((EmptyViewMethodAccessor)this.refreshableView).setEmptyViewInternal(paramView);
      return;
    }
    ((AbsListView)this.refreshableView).setEmptyView(paramView);
  }
  
  public final void setOnLastItemVisibleListener(PullToRefreshBase.OnLastItemVisibleListener paramOnLastItemVisibleListener)
  {
    this.onLastItemVisibleListener = paramOnLastItemVisibleListener;
  }
  
  public final void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.onScrollListener = paramOnScrollListener;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/pulltorefresh/PullToRefreshAdapterViewBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */