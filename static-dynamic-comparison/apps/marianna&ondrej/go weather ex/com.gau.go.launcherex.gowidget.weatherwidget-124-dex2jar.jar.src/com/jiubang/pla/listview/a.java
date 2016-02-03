package com.jiubang.pla.listview;

import android.widget.ListAdapter;
import com.jiubang.pla.internal.PLA_AbsListView;
import com.jiubang.pla.internal.e;

class a
  implements e
{
  private int c = 0;
  
  a(MultiColumnListView paramMultiColumnListView, d paramd) {}
  
  public void a(PLA_AbsListView paramPLA_AbsListView, int paramInt)
  {
    int i = this.b.z().getCount();
    if ((paramInt == 0) && (this.c == i - 1) && (MultiColumnListView.a(this.b)))
    {
      this.a.g();
      MultiColumnListView.a(this.b, false);
    }
  }
  
  public void a(PLA_AbsListView paramPLA_AbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = (paramInt1 + paramInt2 - 1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/pla/listview/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */