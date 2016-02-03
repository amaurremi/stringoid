package mobi.beyondpod.ui.core.pulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.FrameLayout;
import mobi.beyondpod.ui.core.pulltorefresh.internal.EmptyViewMethodAccessor;
import mobi.beyondpod.ui.core.pulltorefresh.internal.LoadingLayout;
import mobi.beyondpod.ui.views.base.ListViewScaleEx;

public class PullToRefreshListView
  extends PullToRefreshAdapterViewBase<ListViewScaleEx>
{
  private LoadingLayout footerLoadingView;
  private LoadingLayout headerLoadingView;
  
  public PullToRefreshListView(Context paramContext)
  {
    super(paramContext);
    setDisableScrollingWhileRefreshing(false);
  }
  
  public PullToRefreshListView(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    setDisableScrollingWhileRefreshing(false);
  }
  
  public PullToRefreshListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setDisableScrollingWhileRefreshing(false);
  }
  
  protected final ListViewScaleEx createRefreshableView(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramAttributeSet = new InternalListView(paramContext, paramAttributeSet);
    int i = getMode();
    String str1 = paramContext.getString(2131297148);
    String str2 = paramContext.getString(2131297150);
    String str3 = paramContext.getString(2131297149);
    FrameLayout localFrameLayout;
    if ((i == 1) || (i == 3))
    {
      localFrameLayout = new FrameLayout(paramContext);
      this.headerLoadingView = new LoadingLayout(paramContext, 1, str3, str1, str2);
      localFrameLayout.addView(this.headerLoadingView, -1, -2);
      this.headerLoadingView.setVisibility(8);
      paramAttributeSet.addHeaderView(localFrameLayout);
    }
    if ((i == 2) || (i == 3))
    {
      localFrameLayout = new FrameLayout(paramContext);
      this.footerLoadingView = new LoadingLayout(paramContext, 2, str3, str1, str2);
      localFrameLayout.addView(this.footerLoadingView, -1, -2);
      this.footerLoadingView.setVisibility(8);
      paramAttributeSet.addFooterView(localFrameLayout);
    }
    paramAttributeSet.setId(16908298);
    return paramAttributeSet;
  }
  
  public ContextMenu.ContextMenuInfo getContextMenuInfo()
  {
    return ((InternalListView)getRefreshableView()).getContextMenuInfo();
  }
  
  protected void resetHeader()
  {
    int i = getHeaderHeight();
    LoadingLayout localLoadingLayout2;
    LoadingLayout localLoadingLayout1;
    switch (getCurrentMode())
    {
    default: 
      localLoadingLayout2 = getHeaderLayout();
      localLoadingLayout1 = this.headerLoadingView;
      i *= -1;
    }
    for (boolean bool = isReadyForPullDown();; bool = isReadyForPullUp())
    {
      localLoadingLayout2.setVisibility(0);
      if (bool) {
        setHeaderScroll(i);
      }
      localLoadingLayout1.setVisibility(8);
      super.resetHeader();
      return;
      localLoadingLayout2 = getFooterLayout();
      localLoadingLayout1 = this.footerLoadingView;
    }
  }
  
  public void setPullLabel(String paramString)
  {
    super.setPullLabel(paramString);
    if (this.headerLoadingView != null) {
      this.headerLoadingView.setPullLabel(paramString);
    }
    if (this.footerLoadingView != null) {
      this.footerLoadingView.setPullLabel(paramString);
    }
  }
  
  protected void setRefreshingInternal(boolean paramBoolean)
  {
    super.setRefreshingInternal(false);
    LoadingLayout localLoadingLayout2;
    LoadingLayout localLoadingLayout1;
    int j;
    switch (getCurrentMode())
    {
    default: 
      localLoadingLayout2 = getHeaderLayout();
      localLoadingLayout1 = this.headerLoadingView;
      j = 0;
    }
    for (int i = getScrollY() + getHeaderHeight();; i = getScrollY() - getHeaderHeight())
    {
      if (paramBoolean) {
        setHeaderScroll(i);
      }
      localLoadingLayout2.setVisibility(4);
      localLoadingLayout1.setVisibility(0);
      localLoadingLayout1.refreshing();
      if (paramBoolean)
      {
        ((ListViewScaleEx)this.refreshableView).setSelection(j);
        smoothScrollTo(0);
      }
      return;
      localLoadingLayout2 = getFooterLayout();
      localLoadingLayout1 = this.footerLoadingView;
      j = ((ListViewScaleEx)this.refreshableView).getCount() - 1;
    }
  }
  
  public void setRefreshingLabel(String paramString)
  {
    super.setRefreshingLabel(paramString);
    if (this.headerLoadingView != null) {
      this.headerLoadingView.setRefreshingLabel(paramString);
    }
    if (this.footerLoadingView != null) {
      this.footerLoadingView.setRefreshingLabel(paramString);
    }
  }
  
  public void setReleaseLabel(String paramString)
  {
    super.setReleaseLabel(paramString);
    if (this.headerLoadingView != null) {
      this.headerLoadingView.setReleaseLabel(paramString);
    }
    if (this.footerLoadingView != null) {
      this.footerLoadingView.setReleaseLabel(paramString);
    }
  }
  
  class InternalListView
    extends ListViewScaleEx
    implements EmptyViewMethodAccessor
  {
    public InternalListView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public ContextMenu.ContextMenuInfo getContextMenuInfo()
    {
      return super.getContextMenuInfo();
    }
    
    public void setEmptyView(View paramView)
    {
      PullToRefreshListView.this.setEmptyView(paramView);
    }
    
    public void setEmptyViewInternal(View paramView)
    {
      super.setEmptyView(paramView);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/pulltorefresh/PullToRefreshListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */