package android.support.v4.widget;

import android.view.View;
import android.widget.ListView;

public class ListViewAutoScrollHelper
  extends AutoScrollHelper
{
  private final ListView mTarget;
  
  public ListViewAutoScrollHelper(ListView paramListView)
  {
    super(paramListView);
    this.mTarget = paramListView;
  }
  
  public boolean canTargetScrollHorizontally(int paramInt)
  {
    return false;
  }
  
  public boolean canTargetScrollVertically(int paramInt)
  {
    ListView localListView = this.mTarget;
    int i = localListView.getCount();
    int j = localListView.getChildCount();
    int k = localListView.getFirstVisiblePosition();
    if (paramInt > 0)
    {
      if ((k + j < i) || (localListView.getChildAt(j - 1).getBottom() > localListView.getHeight())) {}
    }
    else {
      while ((paramInt >= 0) || ((k <= 0) && (localListView.getChildAt(0).getTop() >= 0))) {
        return false;
      }
    }
    return true;
  }
  
  public void scrollTargetBy(int paramInt1, int paramInt2)
  {
    ListView localListView = this.mTarget;
    paramInt1 = localListView.getFirstVisiblePosition();
    if (paramInt1 == -1) {}
    View localView;
    do
    {
      return;
      localView = localListView.getChildAt(0);
    } while (localView == null);
    localListView.setSelectionFromTop(paramInt1, localView.getTop() - paramInt2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/android/support/v4/widget/ListViewAutoScrollHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */