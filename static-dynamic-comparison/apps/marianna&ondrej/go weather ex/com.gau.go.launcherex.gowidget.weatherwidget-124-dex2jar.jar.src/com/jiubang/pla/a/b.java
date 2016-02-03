package com.jiubang.pla.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class b
  extends a
{
  public b(LayoutInflater paramLayoutInflater, c paramc)
  {
    super(paramLayoutInflater, paramc);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = this.a.get(paramInt);
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.c.a(this.b, localObject);
    }
    this.c.a(paramViewGroup, paramInt, localObject);
    return paramViewGroup;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/pla/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */