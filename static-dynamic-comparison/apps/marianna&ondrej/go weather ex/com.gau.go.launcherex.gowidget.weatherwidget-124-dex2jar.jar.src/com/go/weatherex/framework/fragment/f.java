package com.go.weatherex.framework.fragment;

import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class f
{
  a a;
  
  public f(a parama)
  {
    this.a = parama;
  }
  
  private LayoutInflater a()
  {
    if (this.a.getActivity() == null) {
      throw new IllegalStateException("Fragment " + this.a + " not attached to Activity");
    }
    return this.a.getActivity().getLayoutInflater();
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = a().inflate(paramInt, paramViewGroup);
    this.a.a(paramViewGroup);
    return paramViewGroup;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    paramViewGroup = a().inflate(paramInt, paramViewGroup, paramBoolean);
    this.a.a(paramViewGroup);
    return paramViewGroup;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/framework/fragment/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */