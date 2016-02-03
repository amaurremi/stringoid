package com.go.weatherex.themestore;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.gau.go.launcherex.goweather.goplay.q;
import java.util.List;

public class j
  extends com.go.weatherex.framework.fragment.a
  implements AdapterView.OnItemClickListener
{
  private int a;
  private ListView b;
  private g c;
  private View d;
  private final aa e = new k(this);
  
  public static j a(Activity paramActivity, int paramInt)
  {
    j localj = new j();
    localj.b(paramActivity);
    paramActivity = new Bundle();
    paramActivity.putInt("theme_type", paramInt);
    localj.setArguments(paramActivity);
    return localj;
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("mode undefined:" + paramInt);
    case 2: 
      this.b.setVisibility(0);
      this.d.setVisibility(8);
      return;
    }
    this.b.setVisibility(8);
    this.d.setVisibility(0);
  }
  
  private void b()
  {
    if (isDetached()) {
      return;
    }
    List localList = u.b(this.a);
    if (this.c != null) {
      this.c.e();
    }
    this.c = new g(getActivity(), localList, this.b);
    this.b.setAdapter(this.c);
  }
  
  private void b(Bundle paramBundle)
  {
    this.a = paramBundle.getInt("theme_type", 1);
  }
  
  private void c()
  {
    if (this.c != null)
    {
      List localList = u.b(this.a);
      this.c.a(localList);
    }
  }
  
  protected void f()
  {
    super.f();
    if (isDetached()) {}
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    b(getArguments());
    if (u.g())
    {
      a(2);
      b();
      return;
    }
    a(1);
    u.h();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903162, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.c != null) {
      this.c.e();
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    u.b(this.e);
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (com.jiubang.playsdk.a.a)this.c.getItem(paramInt);
    if (paramAdapterView != null) {
      u.f().g(getActivity(), paramAdapterView);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.b = ((ListView)c(2131231539));
    this.d = c(2131231538);
    this.b.setOnItemClickListener(this);
    u.a(this.e);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/themestore/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */