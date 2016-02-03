package com.jiubang.a.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class d
  extends a
{
  public d(BaseAdapter paramBaseAdapter)
  {
    super(paramBaseAdapter);
  }
  
  public com.a.a.a[] a(ViewGroup paramViewGroup, View paramView)
  {
    return new com.a.a.a[] { b(paramViewGroup, paramView) };
  }
  
  protected abstract com.a.a.a b(ViewGroup paramViewGroup, View paramView);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */