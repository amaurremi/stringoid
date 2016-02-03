package com.jiubang.pla.internal;

import android.view.View;
import android.widget.ListAdapter;

class f
  extends j
  implements Runnable
{
  View a;
  int b;
  
  private f(PLA_AbsListView paramPLA_AbsListView)
  {
    super(paramPLA_AbsListView, null);
  }
  
  public void run()
  {
    if (this.c.L) {}
    ListAdapter localListAdapter;
    int i;
    do
    {
      return;
      localListAdapter = this.c.c;
      i = this.b;
    } while ((localListAdapter == null) || (this.c.M <= 0) || (i == -1) || (i >= localListAdapter.getCount()) || (!b()));
    this.c.b(this.a, i, localListAdapter.getItemId(i));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/pla/internal/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */