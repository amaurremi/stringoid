package com.go.weatherex.sidebar;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import com.gau.go.launcherex.gowidget.statistics.r;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.go.weatherex.viewex.d;

public class e
  extends com.go.weatherex.framework.fragment.a
  implements a
{
  private SidebarDrawerLayout a;
  private com.go.weatherex.viewex.c b;
  private d c;
  private com.go.weatherex.viewex.c d;
  private d e;
  private boolean f = false;
  
  public static Bundle a(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("cityId", paramString);
    localBundle.putInt("detail_goto", paramInt);
    return localBundle;
  }
  
  private void a(String paramString)
  {
    paramString = new com.gau.go.launcherex.gowidget.statistics.a.a(93, paramString);
    paramString.d("1");
    r.a(getActivity().getApplicationContext()).a(paramString);
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      View localView = c(2131231511).findViewById(2131231198);
      Rect localRect = new Rect();
      localView.getGlobalVisibleRect(localRect);
      this.a.a(localRect);
      return;
    }
    this.a.a(null);
  }
  
  public void a(float paramFloat)
  {
    com.gtp.a.a.b.c.a("SidebarDrawerFragment", "onSidebarSliding:" + paramFloat);
    float f1 = paramFloat;
    if (this.f) {
      f1 = paramFloat * paramFloat;
    }
    a(3, Float.valueOf(f1));
    this.c.a(f1);
    this.e.a(1.0F - f1);
  }
  
  public void a(com.go.weatherex.viewex.c paramc)
  {
    this.b = paramc;
    paramc = AnimationUtils.loadAnimation(getActivity(), 2130968595);
    this.c = new d(this.b, paramc);
  }
  
  public void a(boolean paramBoolean)
  {
    com.gtp.a.a.b.c.a("SidebarDrawerFragment", "onSidebarIdle");
    a(6, Boolean.valueOf(paramBoolean));
    a(13, Boolean.valueOf(paramBoolean));
    this.f = false;
    this.c.a(false);
    this.e.a(false);
    this.a.b(false);
    if (paramBoolean) {
      this.d.setVisibility(4);
    }
    for (;;)
    {
      d(paramBoolean);
      return;
      this.b.setVisibility(4);
    }
  }
  
  protected void b(int paramInt, Object paramObject)
  {
    super.b(paramInt, paramObject);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      b(((Boolean)paramObject).booleanValue());
      return;
      c(((Boolean)paramObject).booleanValue());
      return;
      if (((Boolean)paramObject).booleanValue()) {}
      for (paramInt = 1; paramInt != this.a.b(3); paramInt = 0)
      {
        this.a.b(paramInt, 3);
        return;
      }
    }
  }
  
  public void b(com.go.weatherex.viewex.c paramc)
  {
    this.d = paramc;
    this.e = new d(this.d, AnimationUtils.loadAnimation(getActivity(), 2130968592));
  }
  
  public void b(boolean paramBoolean)
  {
    this.f = true;
    this.a.f(3);
  }
  
  public void c(boolean paramBoolean)
  {
    this.a.g(3);
  }
  
  public void c_()
  {
    com.gtp.a.a.b.c.a("SidebarDrawerFragment", "onSidebarStartOpen");
    a(1, null);
    this.a.b(true);
    this.c.a(true);
    this.c.a(0.0F);
    this.e.a(true);
    this.e.a(1.0F);
    this.d.setVisibility(0);
    this.b.setVisibility(0);
  }
  
  public void d_()
  {
    com.gtp.a.a.b.c.a("SidebarDrawerFragment", "onSidebarStartClose");
    a(2, null);
    this.a.b(true);
    this.c.a(true);
    this.c.a(1.0F);
    this.e.a(true);
    this.e.a(0.0F);
    this.d.setVisibility(0);
    this.b.setVisibility(0);
    d(false);
  }
  
  public void e_()
  {
    com.gtp.a.a.b.c.a("SidebarDrawerFragment", "onSidebarOpened");
    a(4, null);
    y.a("key_home_open_sidebar", getActivity());
    a("ent_wp");
  }
  
  public void f_()
  {
    com.gtp.a.a.b.c.a("SidebarDrawerFragment", "onSidebarClosed");
    a(5, null);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = getArguments();
    a(com.go.weatherex.home.c.class, com.go.weatherex.home.c.a(paramBundle.getString("cityId"), paramBundle.getInt("detail_goto", -1)));
    a(b.class, null);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(new int[] { 8, 7, 15 });
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903159, paramViewGroup, false);
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    a(16, Boolean.valueOf(paramBoolean));
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.a = ((SidebarDrawerLayout)c(2131231520));
    this.a.i(0);
    this.a.a(0);
    this.a.a(2130839086, 3);
    this.a.a(2130839086, 5);
    this.a.a(this);
    this.a.setFocusableInTouchMode(false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/sidebar/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */