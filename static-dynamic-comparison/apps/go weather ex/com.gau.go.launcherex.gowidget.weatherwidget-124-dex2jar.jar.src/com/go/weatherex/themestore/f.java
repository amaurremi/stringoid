package com.go.weatherex.themestore;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.go.weatherex.framework.fragment.a;

public class f
  extends a
{
  private int a;
  private int b;
  private n c;
  private j d;
  
  public static f a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    f localf = new f();
    localf.b(paramActivity);
    paramActivity = new Bundle();
    paramActivity.putInt("theme_tab", paramInt1);
    paramActivity.putInt("theme_type", paramInt2);
    localf.setArguments(paramActivity);
    return localf;
  }
  
  private void b()
  {
    FragmentTransaction localFragmentTransaction = getChildFragmentManager().beginTransaction();
    localFragmentTransaction.setCustomAnimations(2130968588, 2130968589, 2130968588, 2130968589);
    switch (this.b)
    {
    }
    for (;;)
    {
      localFragmentTransaction.commit();
      return;
      localFragmentTransaction.show(this.c);
      localFragmentTransaction.hide(this.d);
      continue;
      localFragmentTransaction.show(this.d);
      localFragmentTransaction.hide(this.c);
    }
  }
  
  private void b(Bundle paramBundle)
  {
    this.a = paramBundle.getInt("theme_type", 1);
    this.b = paramBundle.getInt("theme_tab", 1);
  }
  
  protected void b(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.b = ((Integer)paramObject).intValue();
    b();
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
    this.c = n.a(getActivity(), this.a);
    this.d = j.a(getActivity(), this.a);
    paramBundle = getChildFragmentManager().beginTransaction();
    paramBundle.add(2131231542, this.c);
    paramBundle.add(2131231542, this.d);
    paramBundle.commit();
    b();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(new int[] { 4 });
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903164, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/themestore/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */