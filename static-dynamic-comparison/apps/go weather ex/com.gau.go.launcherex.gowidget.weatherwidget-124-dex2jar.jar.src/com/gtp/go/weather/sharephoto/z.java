package com.gtp.go.weather.sharephoto;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;

class z
  implements AbsListView.OnScrollListener
{
  private int b = 0;
  
  z(UserPhotosActivity paramUserPhotosActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = (paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    int i = ((ListAdapter)paramAbsListView.getAdapter()).getCount();
    if (i == 0) {}
    while ((paramInt != 0) || (i - 1 != this.b) || (UserPhotosActivity.a(this.a))) {
      return;
    }
    UserPhotosActivity.a(this.a, true);
    UserPhotosActivity.b(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */