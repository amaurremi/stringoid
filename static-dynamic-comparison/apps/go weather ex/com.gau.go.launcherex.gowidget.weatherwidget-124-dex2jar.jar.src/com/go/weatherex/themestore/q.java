package com.go.weatherex.themestore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.gau.go.launcherex.goweather.goplay.n;
import com.gau.go.launcherex.gowidget.billing.BillingActivity;
import com.gau.go.launcherex.gowidget.d.h;
import com.gau.go.launcherex.gowidget.weather.util.k;
import com.go.weatherex.setting.PersonalizeSettingsActivity;

public class q
  extends com.go.weatherex.framework.fragment.a
  implements ViewPager.OnPageChangeListener, View.OnClickListener, c
{
  private TextView a;
  private TextView b;
  private ae c;
  private a d;
  private ViewPager e;
  private s f;
  private View g;
  private ViewGroup h;
  private int[] i;
  private int j = -1;
  private final h k = new h();
  private final aa l = new r(this);
  
  private int a(int paramInt)
  {
    int m = 0;
    while (m < this.i.length)
    {
      if (paramInt == this.i[m]) {
        return m;
      }
      m += 1;
    }
    return 0;
  }
  
  private void b(int paramInt)
  {
    this.e.setCurrentItem(paramInt, true);
  }
  
  private String[] b()
  {
    String[] arrayOfString = new String[this.i.length];
    int m = 0;
    if (m < arrayOfString.length)
    {
      switch (this.i[m])
      {
      }
      for (;;)
      {
        m += 1;
        break;
        arrayOfString[m] = getString(2131166403);
        continue;
        arrayOfString[m] = getString(2131166404);
        continue;
        arrayOfString[m] = getString(2131166405);
      }
    }
    return arrayOfString;
  }
  
  private void c()
  {
    this.c.b.setText(getString(2131166442));
    this.a.setText(getString(2131166443));
    this.b.setText(getString(2131166444));
  }
  
  private void d()
  {
    if (isDetached()) {}
    while (!u.f().b(getActivity())) {
      return;
    }
    View localView = u.f().a(getActivity(), null);
    this.h.addView(localView, 0);
  }
  
  private void d(int paramInt)
  {
    if (this.j == paramInt) {
      return;
    }
    this.j = paramInt;
    if (this.j == 1)
    {
      this.a.setSelected(true);
      this.b.setSelected(false);
      a(4, Integer.valueOf(this.j));
      return;
    }
    if (this.j == 2)
    {
      this.a.setSelected(false);
      this.b.setSelected(true);
      a(4, Integer.valueOf(this.j));
      return;
    }
    throw new IllegalArgumentException("tab id is undefined: " + paramInt);
  }
  
  public void a(View paramView, int paramInt)
  {
    b(paramInt);
  }
  
  protected void b(int paramInt, Object paramObject) {}
  
  protected void f()
  {
    super.f();
    if (isDetached()) {
      return;
    }
    c();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    int m;
    if ((k.a(getActivity())) || (com.gau.go.launcherex.gowidget.weather.globaltheme.view.a.c.a(getActivity())))
    {
      m = 1;
      if (m == 0) {
        break label177;
      }
    }
    label177:
    for (this.i = new int[] { 1, 3, 2 };; this.i = new int[] { 1, 3 })
    {
      this.d.a(b());
      a(this.d.e(), 2, true);
      this.f = new s(this, getChildFragmentManager());
      this.e.setOffscreenPageLimit(this.i.length);
      d(u.c().c);
      c();
      this.g.setVisibility(0);
      this.d.a(0);
      this.e.setVisibility(0);
      this.e.setAdapter(this.f);
      b(a(u.c().d));
      u.b();
      u.h();
      return;
      m = 0;
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.b)) {
      d(2);
    }
    do
    {
      do
      {
        return;
        if (paramView.equals(this.a))
        {
          d(1);
          return;
        }
        if (paramView.equals(this.c.a))
        {
          a(5, null);
          return;
        }
        if (!paramView.equals(this.c.c)) {
          break;
        }
      } while (this.k.a(hashCode()));
      paramView = new Intent(getActivity(), BillingActivity.class);
      paramView.putExtra("recommend_type", 6);
      startActivity(paramView);
      n.a(getActivity().getApplicationContext()).a();
      return;
    } while ((!paramView.equals(this.c.d)) || (this.k.a(hashCode())));
    startActivity(PersonalizeSettingsActivity.a(getActivity(), u.c().b));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903161, paramViewGroup, false);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    u.b(this.l);
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.d.onPageScrollStateChanged(paramInt);
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    this.d.onPageScrolled(paramInt1, paramFloat, paramInt2);
  }
  
  public void onPageSelected(int paramInt)
  {
    this.d.onPageSelected(paramInt);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.d = new a(getActivity(), c(2131231533));
    this.d.a(this);
    this.c = new ae(getActivity(), c(2131231144));
    a(this.c.b, 4, true);
    this.c.g.setVisibility(8);
    this.c.c.setImageResource(2130838872);
    this.c.d.setImageResource(2130837715);
    this.a = ((TextView)c(2131231535));
    this.b = ((TextView)c(2131231536));
    this.e = ((ViewPager)c(2131231532));
    this.g = c(2131231534);
    this.h = ((ViewGroup)c(2131231375));
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.a.setOnClickListener(this);
    this.c.c.setOnClickListener(this);
    this.c.d.setOnClickListener(this);
    this.e.setOnPageChangeListener(this);
    u.a(this.l);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/themestore/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */