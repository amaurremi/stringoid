package mobi.beyondpod.ui.views.base;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

public class WorkspaceViewManagerPager
  extends ViewPager
{
  private boolean _AllowVibrate = true;
  private int _CurrentPageIndex = -1;
  boolean _IsPageSwitching = false;
  ViewPager.OnPageChangeListener _PageChangeListener = new ViewPager.OnPageChangeListener()
  {
    public void onPageScrollStateChanged(int paramAnonymousInt)
    {
      boolean bool = true;
      WorkspaceViewManagerPager localWorkspaceViewManagerPager = WorkspaceViewManagerPager.this;
      if (paramAnonymousInt == 1) {}
      for (;;)
      {
        localWorkspaceViewManagerPager._IsPageSwitching = bool;
        return;
        bool = false;
      }
    }
    
    public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
    {
      if ((WorkspaceViewManagerPager.this._AllowVibrate) && (WorkspaceViewManagerPager.this._IsPageSwitching) && (paramAnonymousFloat == 0.0F) && (paramAnonymousInt2 == 0)) {
        WorkspaceViewManagerPager.this._AllowVibrate = false;
      }
    }
    
    public void onPageSelected(int paramAnonymousInt)
    {
      if (WorkspaceViewManagerPager.this._CurrentPageIndex >= 0) {}
      for (IView localIView1 = (IView)WorkspaceViewManagerPager.this._PagerAdapter.Items.get(WorkspaceViewManagerPager.this._CurrentPageIndex);; localIView1 = null)
      {
        IView localIView2 = (IView)WorkspaceViewManagerPager.this._PagerAdapter.Items.get(paramAnonymousInt);
        localIView2.OnBeforeActivate();
        if (localIView1 != null) {
          localIView1.OnAfterDeactivate(true);
        }
        localIView2.OnAfterActivate();
        WorkspaceViewManagerPager.this._CurrentPageIndex = paramAnonymousInt;
        return;
      }
    }
  };
  private WorkspacePagerAdapter _PagerAdapter;
  
  public WorkspaceViewManagerPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initWorkspace();
  }
  
  public void addPage(View paramView)
  {
    if (this._PagerAdapter == null)
    {
      this._PagerAdapter = new WorkspacePagerAdapter();
      this._PagerAdapter.addPage(paramView);
      setAdapter(this._PagerAdapter);
      this._PageChangeListener.onPageSelected(0);
      return;
    }
    this._PagerAdapter.addPage(paramView);
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    super.dispatchRestoreInstanceState(paramSparseArray);
    if (this._PagerAdapter != null) {
      this._PagerAdapter.dispatchRestoreInstanceState(paramSparseArray);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this._AllowVibrate = true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public View getCurrentView()
  {
    if ((this._PagerAdapter == null) || (this._PagerAdapter.Items.size() == 0)) {
      return null;
    }
    return (View)this._PagerAdapter.Items.get(getCurrentItem());
  }
  
  public void initWorkspace()
  {
    setBackgroundResource(2130838130);
    setPageMargin(20);
    setOnPageChangeListener(this._PageChangeListener);
  }
  
  public void removePage(View paramView)
  {
    if (this._PagerAdapter != null) {
      this._PagerAdapter.removePage(paramView);
    }
  }
  
  public void setCurrentView(View paramView)
  {
    int i = this._PagerAdapter.Items.indexOf(paramView);
    if ((i >= 0) && (i < this._PagerAdapter.getCount())) {
      setCurrentItem(i, true);
    }
  }
  
  private class WorkspacePagerAdapter
    extends PagerAdapter
  {
    ArrayList<View> Items = new ArrayList(3);
    
    public WorkspacePagerAdapter() {}
    
    public void addPage(View paramView)
    {
      this.Items.add(paramView);
      notifyDataSetChanged();
    }
    
    public void destroyItem(View paramView, int paramInt, Object paramObject)
    {
      ((ViewPager)paramView).removeView((View)paramObject);
    }
    
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
    {
      Iterator localIterator = this.Items.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return;
        }
        ((View)localIterator.next()).restoreHierarchyState(paramSparseArray);
      }
    }
    
    public void finishUpdate(View paramView) {}
    
    public int getCount()
    {
      return this.Items.size();
    }
    
    public Object instantiateItem(View paramView, int paramInt)
    {
      View localView = (View)this.Items.get(paramInt);
      ((ViewPager)paramView).addView((View)this.Items.get(paramInt));
      return localView;
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == (View)paramObject;
    }
    
    public void removePage(View paramView)
    {
      this.Items.remove(paramView);
      notifyDataSetChanged();
    }
    
    public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader) {}
    
    public Parcelable saveState()
    {
      return null;
    }
    
    public void startUpdate(View paramView) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/base/WorkspaceViewManagerPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */