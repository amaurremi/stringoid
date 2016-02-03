package com.jiubang.playsdk.views;

import android.database.DataSetObserver;

class i
  extends DataSetObserver
{
  i(HorizontalListView paramHorizontalListView) {}
  
  public void onChanged()
  {
    HorizontalListView.a(this.a, true);
    HorizontalListView.b(this.a, false);
    HorizontalListView.b(this.a);
    this.a.invalidate();
    this.a.requestLayout();
  }
  
  public void onInvalidated()
  {
    HorizontalListView.b(this.a, false);
    HorizontalListView.b(this.a);
    HorizontalListView.c(this.a);
    this.a.invalidate();
    this.a.requestLayout();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */