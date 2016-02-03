package com.go.weatherex.setting;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.billing.BillingActivity;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.d.f;
import com.gau.go.launcherex.gowidget.weather.globalview.t;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.util.r;
import java.util.ArrayList;
import java.util.Iterator;

public class z
  extends com.go.weatherex.framework.fragment.a
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private TextView a;
  private View b;
  private View c;
  private TextView d;
  private ArrayList e;
  private View f;
  private TextView g;
  private ArrayList h;
  private View i;
  private TextView j;
  private ArrayList k;
  private View l;
  private TextView m;
  private ArrayList n;
  private View o;
  private TextView p;
  private ArrayList q;
  private View r;
  private View s;
  private CheckBox t;
  private int u;
  private BroadcastReceiver v;
  private e w;
  private f x;
  private t y;
  
  private void a(int paramInt)
  {
    Intent localIntent = new Intent(getActivity(), BillingActivity.class);
    localIntent.putExtra("recommend_type", paramInt);
    localIntent.putExtra("recommend_enterance", 4);
    startActivity(localIntent);
  }
  
  private void c()
  {
    boolean bool = this.x.b();
    Object localObject1 = this.w.a();
    int i1 = ((q)localObject1).g;
    Object localObject2 = this.e.iterator();
    com.gau.go.launcherex.gowidget.weather.globalview.a locala;
    while (((Iterator)localObject2).hasNext())
    {
      locala = (com.gau.go.launcherex.gowidget.weather.globalview.a)((Iterator)localObject2).next();
      if (i1 == ((Integer)locala.c).intValue())
      {
        locala.b = true;
        this.d.setText(locala.a);
      }
    }
    i1 = ((q)localObject1).q;
    localObject2 = this.h.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      locala = (com.gau.go.launcherex.gowidget.weather.globalview.a)((Iterator)localObject2).next();
      if (i1 == ((Integer)locala.c).intValue())
      {
        locala.b = true;
        this.g.setText(locala.a);
      }
    }
    i1 = ((q)localObject1).A;
    localObject2 = this.k.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      locala = (com.gau.go.launcherex.gowidget.weather.globalview.a)((Iterator)localObject2).next();
      if (i1 == ((Integer)locala.c).intValue())
      {
        locala.b = true;
        this.j.setText(locala.a);
      }
    }
    i1 = ((q)localObject1).B;
    localObject2 = this.n.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      locala = (com.gau.go.launcherex.gowidget.weather.globalview.a)((Iterator)localObject2).next();
      if (i1 == ((Integer)locala.c).intValue())
      {
        locala.b = true;
        this.m.setText(locala.a);
      }
    }
    this.u = ((q)localObject1).r;
    if (this.t != null)
    {
      if (!bool) {
        break label421;
      }
      this.t.setEnabled(true);
      this.t.setClickable(true);
      localObject2 = this.t;
      if (this.u != 1) {
        break label416;
      }
      bool = true;
      ((CheckBox)localObject2).setChecked(bool);
    }
    for (;;)
    {
      i1 = ((q)localObject1).k;
      localObject1 = this.q.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.gau.go.launcherex.gowidget.weather.globalview.a)((Iterator)localObject1).next();
        if (i1 == ((Integer)((com.gau.go.launcherex.gowidget.weather.globalview.a)localObject2).c).intValue())
        {
          ((com.gau.go.launcherex.gowidget.weather.globalview.a)localObject2).b = true;
          this.p.setText(((com.gau.go.launcherex.gowidget.weather.globalview.a)localObject2).a);
        }
      }
      return;
      label416:
      bool = false;
      break;
      label421:
      this.t.setChecked(false);
      this.t.setEnabled(false);
      this.t.setClickable(false);
    }
  }
  
  private void d()
  {
    t localt = n();
    localt.b(2131166110);
    localt.a(this.e);
    localt.c(0);
    localt.a(new aa(this));
    localt.a();
  }
  
  private void j()
  {
    t localt = n();
    localt.b(2131166111);
    localt.a(this.h);
    localt.c(4);
    localt.a(new ab(this));
    localt.a();
  }
  
  private void k()
  {
    t localt = n();
    localt.b(2131166158);
    localt.a(this.k);
    localt.c(0);
    localt.a(new ac(this));
    localt.a();
  }
  
  private void l()
  {
    int i1 = 4;
    t localt = n();
    localt.b(2131166159);
    localt.a(this.n);
    if (this.n.size() > 4) {}
    for (;;)
    {
      localt.c(i1);
      localt.a(new ad(this));
      localt.a();
      return;
      i1 = 0;
    }
  }
  
  private void m()
  {
    t localt = n();
    localt.b(2131166120);
    localt.a(this.q);
    localt.c(0);
    localt.a(new ae(this));
    localt.a();
  }
  
  private t n()
  {
    if (this.y == null) {
      this.y = new t(getActivity());
    }
    return this.y;
  }
  
  protected boolean a()
  {
    return super.a();
  }
  
  public void b()
  {
    a(this.a, 4, true);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = com.gau.go.launcherex.gowidget.weather.c.c.a(getActivity().getApplicationContext());
    this.w = paramBundle.f();
    this.x = paramBundle.e();
    this.a = ((TextView)c(2131231145));
    this.a.setText(2131166106);
    this.b = c(2131231196);
    this.b.setOnClickListener(this);
    this.h = new ArrayList();
    paramBundle = com.gau.go.launcherex.gowidget.weather.util.c.d(getActivity());
    Object localObject = getResources().getIntArray(2131558444);
    int i1 = 0;
    while (i1 < paramBundle.length)
    {
      com.gau.go.launcherex.gowidget.weather.globalview.a locala = new com.gau.go.launcherex.gowidget.weather.globalview.a();
      locala.b = false;
      locala.a = paramBundle[i1];
      locala.c = Integer.valueOf(localObject[i1]);
      this.h.add(locala);
      i1 += 1;
    }
    paramBundle = com.gau.go.launcherex.gowidget.weather.util.c.e(getActivity());
    this.e = new ArrayList(paramBundle.length);
    i1 = 0;
    while (i1 < paramBundle.length)
    {
      localObject = new com.gau.go.launcherex.gowidget.weather.globalview.a();
      ((com.gau.go.launcherex.gowidget.weather.globalview.a)localObject).b = false;
      ((com.gau.go.launcherex.gowidget.weather.globalview.a)localObject).a = paramBundle[i1];
      ((com.gau.go.launcherex.gowidget.weather.globalview.a)localObject).c = Integer.valueOf(new int[] { 1, 2 }[i1]);
      this.e.add(localObject);
      i1 += 1;
    }
    this.k = new ArrayList();
    paramBundle = com.gau.go.launcherex.gowidget.weather.util.c.f(getActivity());
    i1 = 0;
    while (i1 < paramBundle.length)
    {
      localObject = new com.gau.go.launcherex.gowidget.weather.globalview.a();
      ((com.gau.go.launcherex.gowidget.weather.globalview.a)localObject).b = false;
      ((com.gau.go.launcherex.gowidget.weather.globalview.a)localObject).a = paramBundle[i1];
      ((com.gau.go.launcherex.gowidget.weather.globalview.a)localObject).c = Integer.valueOf(new int[] { 1, 2 }[i1]);
      this.k.add(localObject);
      i1 += 1;
    }
    this.n = new ArrayList();
    paramBundle = com.gau.go.launcherex.gowidget.weather.util.c.g(getActivity());
    i1 = 0;
    while (i1 < paramBundle.length)
    {
      localObject = new com.gau.go.launcherex.gowidget.weather.globalview.a();
      ((com.gau.go.launcherex.gowidget.weather.globalview.a)localObject).b = false;
      ((com.gau.go.launcherex.gowidget.weather.globalview.a)localObject).a = paramBundle[i1];
      ((com.gau.go.launcherex.gowidget.weather.globalview.a)localObject).c = Integer.valueOf(new int[] { 1, 2, 3, 4, 5, 6 }[i1]);
      this.n.add(localObject);
      i1 += 1;
    }
    this.q = new ArrayList();
    paramBundle = new int[3];
    Bundle tmp449_448 = paramBundle;
    tmp449_448[0] = 1;
    Bundle tmp453_449 = tmp449_448;
    tmp453_449[1] = 2;
    Bundle tmp457_453 = tmp453_449;
    tmp457_453[2] = 3;
    tmp457_453;
    i1 = 0;
    while (i1 < paramBundle.length)
    {
      localObject = new com.gau.go.launcherex.gowidget.weather.globalview.a();
      ((com.gau.go.launcherex.gowidget.weather.globalview.a)localObject).b = false;
      ((com.gau.go.launcherex.gowidget.weather.globalview.a)localObject).a = r.a(paramBundle[i1]);
      ((com.gau.go.launcherex.gowidget.weather.globalview.a)localObject).c = Integer.valueOf(paramBundle[i1]);
      this.q.add(localObject);
      i1 += 1;
    }
    this.c = c(2131231417);
    this.c.setOnClickListener(this);
    this.d = ((TextView)c(2131231419));
    this.f = c(2131231420);
    this.f.setOnClickListener(this);
    this.g = ((TextView)c(2131231421));
    this.i = c(2131231422);
    this.i.setOnClickListener(this);
    this.j = ((TextView)c(2131231423));
    this.l = c(2131231424);
    this.l.setOnClickListener(this);
    this.m = ((TextView)c(2131231425));
    this.r = c(2131231428);
    this.t = ((CheckBox)c(2131231430));
    this.s = c(2131231429);
    this.r.setOnClickListener(this);
    this.t.setOnCheckedChangeListener(this);
    if (this.x.b())
    {
      this.s.setVisibility(8);
      this.t.setVisibility(0);
      this.t.setEnabled(true);
      this.t.setClickable(true);
    }
    for (;;)
    {
      this.o = c(2131231426);
      this.o.setOnClickListener(this);
      this.p = ((TextView)c(2131231427));
      c();
      this.v = new af(this, null);
      paramBundle = new IntentFilter("com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE");
      getActivity().registerReceiver(this.v, paramBundle);
      b();
      return;
      this.s.setVisibility(0);
      this.t.setVisibility(8);
      this.t.setEnabled(false);
      this.t.setClickable(false);
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.equals(this.t)) {
      if (!paramBoolean) {
        break label54;
      }
    }
    label54:
    for (int i1 = 1;; i1 = 0)
    {
      if (this.u != i1)
      {
        this.u = i1;
        this.w.a(WeatherContentProvider.g, "setting_key", "world_clock", "setting_value", this.u);
      }
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.b)) {
      h();
    }
    do
    {
      return;
      if (paramView.equals(this.c))
      {
        d();
        return;
      }
      if (paramView.equals(this.f))
      {
        j();
        return;
      }
      if (paramView.equals(this.i))
      {
        k();
        return;
      }
      if (paramView.equals(this.l))
      {
        l();
        return;
      }
      if (paramView.equals(this.r))
      {
        if (!this.x.b())
        {
          a(3);
          return;
        }
        this.t.toggle();
        return;
      }
    } while (!paramView.equals(this.o));
    m();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903152, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.v != null)
    {
      getActivity().unregisterReceiver(this.v);
      this.v = null;
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */