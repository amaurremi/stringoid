package com.go.weatherex.sidebar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.billing.BillingActivity;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.statistics.r;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.go.weatherex.city.EditCityScrollComponent;
import com.go.weatherex.city.j;
import com.go.weatherex.home.ArrowIcon;
import com.go.weatherex.setting.m;
import com.gtp.go.weather.sharephoto.photo.PhotoActivity;
import java.util.ArrayList;
import java.util.Iterator;

public class b
  extends com.go.weatherex.framework.fragment.a
  implements View.OnClickListener, j
{
  private EditCityScrollComponent a;
  private ArrowIcon b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private SidebarGoAdView h;
  private TextView i;
  private final d j = new d(this, null);
  private com.gau.go.launcherex.gowidget.weather.util.f k;
  private long l = 0L;
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramContext, BillingActivity.class);
    localIntent.putExtra("recommend_type", paramInt1);
    localIntent.putExtra("recommend_enterance", paramInt2);
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
  }
  
  private void a(String paramString)
  {
    paramString = new com.gau.go.launcherex.gowidget.statistics.a.a(93, paramString);
    paramString.d("2");
    r.a(getActivity().getApplicationContext()).a(paramString);
  }
  
  private void b()
  {
    if (GoWidgetApplication.b(getActivity().getApplicationContext()).b())
    {
      this.c.setVisibility(8);
      return;
    }
    this.c.setVisibility(0);
  }
  
  public void a(int paramInt, com.go.weatherex.city.a parama)
  {
    a(10, parama.a);
    a(12, parama.a, 0L, true);
    a(7, Boolean.valueOf(true));
  }
  
  protected boolean a()
  {
    if (this.a.b())
    {
      this.a.a(false);
      return true;
    }
    return super.a();
  }
  
  public void b(int paramInt, com.go.weatherex.city.a parama)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(parama.a);
    this.k.a(localArrayList);
  }
  
  protected void b(int paramInt, Object paramObject)
  {
    super.b(paramInt, paramObject);
    if ((paramInt == 1) && (this.h != null)) {
      this.h.c();
    }
    while (paramInt != 5) {
      return;
    }
    this.a.f();
  }
  
  protected void f()
  {
    super.f();
    if (getActivity() != null)
    {
      this.c.setText(getString(2131165986));
      this.i.setText(getString(2131165990));
      this.d.setText(getString(2131165991));
      this.f.setText(getString(2131165993));
      this.e.setText(getString(2131165992));
      this.g.setText(getString(2131166363));
    }
    this.a.a();
    this.h.b();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.b = ((ArrowIcon)c(2131231519));
    this.b.a(true);
    this.a = ((EditCityScrollComponent)c(2131231511));
    this.a.b("2");
    this.a.a(this);
    this.a.a(this);
    this.c = ((TextView)c(2131231514));
    this.d = ((TextView)c(2131231516));
    this.i = ((TextView)c(2131231513));
    this.e = ((TextView)c(2131231518));
    this.f = ((TextView)c(2131231517));
    this.g = ((TextView)c(2131231515));
    this.h = ((SidebarGoAdView)c(2131231512));
    this.h.a(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    paramBundle = this.k.d().iterator();
    while (paramBundle.hasNext())
    {
      WeatherBean localWeatherBean = (WeatherBean)paramBundle.next();
      this.a.a(localWeatherBean);
    }
    b();
    a(this.i, 4, true);
  }
  
  public void onClick(View paramView)
  {
    long l1 = SystemClock.currentThreadTimeMillis();
    if (l1 - this.l < 300L) {}
    do
    {
      return;
      this.l = l1;
      if (this.a.b()) {
        this.a.a(false);
      }
      com.go.weatherex.framework.fragment.a locala = (com.go.weatherex.framework.fragment.a)getParentFragment();
      if (paramView.equals(this.b))
      {
        a(7, Boolean.valueOf(true));
        return;
      }
      if (paramView.equals(this.d))
      {
        a("c000_fucsetting");
        locala.a(m.class, null);
        return;
      }
      if (paramView.equals(this.e))
      {
        a("c000_qa");
        locala.a(com.go.weatherex.c.a.class, null);
        return;
      }
      if (paramView.equals(this.f))
      {
        a("c000_msgc");
        locala.a(com.go.weatherex.e.a.class, null);
        return;
      }
      if (paramView.equals(this.g))
      {
        startActivity(new Intent(getActivity(), PhotoActivity.class));
        getActivity().overridePendingTransition(2130968578, 2130968580);
        paramView = new com.gau.go.launcherex.gowidget.statistics.a.a(117, "g001");
        paramView.c("2");
        r.a(getActivity().getApplicationContext()).a(paramView);
        r.a(getActivity().getApplicationContext()).a(new com.gau.go.launcherex.gowidget.statistics.a.a(93, "c000_sharepic"));
        return;
      }
    } while (!paramView.equals(this.c));
    a(getActivity().getApplicationContext(), 2, 11);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.k = com.gau.go.launcherex.gowidget.weather.util.f.a(getActivity());
    a(new int[] { 1, 5 });
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903158, paramViewGroup, false);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    b(this.j);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a(this.j);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/sidebar/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */