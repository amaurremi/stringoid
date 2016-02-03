package com.go.weatherex.themestore;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.gau.go.launcherex.goweather.goplay.q;
import com.jiubang.playsdk.e.d;
import com.jiubang.playsdk.e.e;
import java.util.List;

public class n
  extends com.go.weatherex.framework.fragment.a
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  private int a;
  private ListView b;
  private l c;
  private View d;
  private TextView e;
  private TextView f;
  private View g;
  private View h;
  private d i;
  private final aa j = new o(this);
  
  public static n a(Activity paramActivity, int paramInt)
  {
    n localn = new n();
    localn.b(paramActivity);
    paramActivity = new Bundle();
    paramActivity.putInt("theme_type", paramInt);
    localn.setArguments(paramActivity);
    return localn;
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("mode undefined:" + paramInt);
    case 3: 
      this.b.setVisibility(0);
      this.h.setVisibility(8);
      this.g.setVisibility(8);
      return;
    case 2: 
      this.b.setVisibility(8);
      this.h.setVisibility(8);
      this.g.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
    this.h.setVisibility(0);
    this.g.setVisibility(8);
  }
  
  private void b()
  {
    if (isDetached()) {
      return;
    }
    this.i = u.a(this.a);
    List localList = u.a(this.i);
    if (localList.size() > 0)
    {
      this.c = new l(getActivity(), localList, this.b);
      this.c.a(u.f().b(getActivity()));
      this.b.setAdapter(this.c);
      return;
    }
    a(2);
  }
  
  private void b(Bundle paramBundle)
  {
    this.a = paramBundle.getInt("theme_type", 1);
  }
  
  private void c()
  {
    if (this.c != null)
    {
      this.i = u.a(this.a);
      List localList = u.a(this.i);
      this.c.a(localList);
    }
  }
  
  private void d()
  {
    this.f.setText(getString(2131166445));
    this.e.setText(getString(2131166063));
  }
  
  protected void f()
  {
    super.f();
    if (isDetached()) {
      return;
    }
    d();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    b(getArguments());
    if (u.a())
    {
      a(3);
      b();
    }
    for (;;)
    {
      d();
      return;
      a(1);
      u.b();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.f)) {
      u.b();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903163, paramViewGroup, false);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    u.b(this.j);
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt == this.c.b() - 1) {
      if ((this.i != null) && (!TextUtils.isEmpty(this.i.l())))
      {
        paramInt = com.jiubang.playsdk.g.a.a(this.i.l());
        u.e().a(getActivity(), paramInt, this.i.a());
      }
    }
    do
    {
      return;
      paramAdapterView = (e)this.c.getItem(paramInt);
    } while ((paramAdapterView == null) || (this.i == null));
    u.e().a(getActivity(), paramAdapterView, this.i.a());
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.b = ((ListView)c(2131231539));
    this.h = c(2131231538);
    this.d = this.h.findViewById(2131231795);
    this.g = c(2131231541);
    this.e = ((TextView)this.g.findViewById(2131231956));
    this.f = ((TextView)this.g.findViewById(2131231957));
    this.b.setOnItemClickListener(this);
    this.f.setOnClickListener(this);
    u.a(this.j);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/themestore/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */