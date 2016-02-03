package com.go.weatherex.setting;

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
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.globalview.t;
import com.gau.go.launcherex.gowidget.weather.model.q;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.view.VerticalStretchLayout;
import java.util.ArrayList;

public class ay
  extends com.go.weatherex.framework.fragment.a
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private t A;
  public int a;
  public int b;
  public int c;
  public int d;
  private e e;
  private TextView f;
  private View g;
  private View h;
  private CheckBox i;
  private TextView j;
  private TextView k;
  private View l;
  private CheckBox m;
  private View n;
  private CheckBox o;
  private View p;
  private TextView q;
  private TextView r;
  private VerticalStretchLayout s;
  private String[] t;
  private int[] u;
  private int v;
  private int w;
  private int x;
  private int y;
  private ba z;
  
  private void a(int paramInt1, int paramInt2, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i2 = 0;
    paramArrayOfInt = new ArrayList();
    int i3 = paramArrayOfString.length;
    int i1 = 0;
    if (i1 < i3)
    {
      com.gau.go.launcherex.gowidget.weather.globalview.a locala = new com.gau.go.launcherex.gowidget.weather.globalview.a();
      locala.a = paramArrayOfString[i1].toString();
      locala.c = Integer.valueOf(i1);
      if (paramInt2 == i1) {}
      for (boolean bool = true;; bool = false)
      {
        locala.b = bool;
        paramArrayOfInt.add(locala);
        i1 += 1;
        break;
      }
    }
    paramArrayOfString = d();
    paramArrayOfString.b(paramInt1);
    paramArrayOfString.a(paramArrayOfInt);
    paramInt1 = i2;
    if (i3 > 4) {
      paramInt1 = 4;
    }
    paramArrayOfString.c(paramInt1);
    paramArrayOfString.a(new az(this));
    paramArrayOfString.a();
  }
  
  private void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      a(false);
      this.i.setEnabled(false);
      this.e.b(1, false);
      j();
      return;
    }
    this.e.b(0, false);
    this.i.setEnabled(true);
  }
  
  private void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.h.setClickable(false);
      this.j.setText(2131166132);
      this.k.setTextColor(this.w);
      return;
    }
    this.h.setClickable(true);
    this.j.setText(2131166133);
    this.k.setTextColor(this.v);
  }
  
  private void b(boolean paramBoolean)
  {
    this.p.setClickable(paramBoolean);
    if (paramBoolean)
    {
      this.q.setTextColor(this.v);
      this.r.setTextColor(this.v);
      this.q.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.x, 0);
      return;
    }
    this.q.setTextColor(this.w);
    this.r.setTextColor(this.w);
    this.q.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.y, 0);
  }
  
  private void c()
  {
    int i1 = 0;
    boolean bool2 = true;
    q localq = this.e.a();
    this.b = localq.a;
    CheckBox localCheckBox = this.m;
    boolean bool1;
    label73:
    label98:
    label130:
    int i2;
    if (this.b == 1)
    {
      bool1 = true;
      localCheckBox.setChecked(bool1);
      b(this.m.isChecked());
      if (!this.m.isChecked()) {
        break label188;
      }
      this.s.b();
      this.c = localq.b;
      localCheckBox = this.i;
      if (this.c != 1) {
        break label198;
      }
      bool1 = true;
      localCheckBox.setChecked(bool1);
      this.d = localq.c;
      localCheckBox = this.o;
      if (this.d != 1) {
        break label203;
      }
      bool1 = bool2;
      localCheckBox.setChecked(bool1);
      this.a = localq.e;
      i2 = this.u.length;
    }
    for (;;)
    {
      if (i1 < i2)
      {
        if (this.a == this.u[i1]) {
          this.q.setText(this.t[i1]);
        }
      }
      else
      {
        return;
        bool1 = false;
        break;
        label188:
        this.s.a();
        break label73;
        label198:
        bool1 = false;
        break label98;
        label203:
        bool1 = false;
        break label130;
      }
      i1 += 1;
    }
  }
  
  private t d()
  {
    if (this.A == null) {
      this.A = new t(getActivity());
    }
    return this.A;
  }
  
  private void j()
  {
    Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService");
    localIntent.putExtra("notify_request", 20);
    getActivity().startService(localIntent);
  }
  
  protected boolean a()
  {
    return super.a();
  }
  
  public void b()
  {
    a(this.f, 4, true);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.e = com.gau.go.launcherex.gowidget.weather.c.c.a(getActivity().getApplicationContext()).f();
    this.v = getResources().getColor(2131361899);
    this.w = getResources().getColor(2131361901);
    this.x = 2130838496;
    this.y = 2130838496;
    this.f = ((TextView)c(2131231145));
    this.f.setText(2131166106);
    this.g = c(2131231196);
    this.g.setOnClickListener(this);
    this.l = c(2131231439);
    this.l.setOnClickListener(this);
    this.m = ((CheckBox)c(2131231440));
    this.m.setOnCheckedChangeListener(this);
    this.h = c(2131231433);
    this.k = ((TextView)c(2131231434));
    this.j = ((TextView)c(2131231435));
    this.h.setOnClickListener(this);
    this.i = ((CheckBox)c(2131231436));
    this.i.setOnCheckedChangeListener(this);
    this.n = c(2131231437);
    this.n.setOnClickListener(this);
    this.o = ((CheckBox)c(2131231438));
    this.o.setOnCheckedChangeListener(this);
    this.t = com.gau.go.launcherex.gowidget.weather.util.c.a(getActivity());
    this.u = getResources().getIntArray(2131558438);
    this.p = c(2131231442);
    this.p.setOnClickListener(this);
    this.q = ((TextView)c(2131231444));
    this.r = ((TextView)c(2131231443));
    this.s = ((VerticalStretchLayout)c(2131231441));
    this.z = new ba(this, null);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LOCATION");
    paramBundle.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LOCATION_FAILED");
    getActivity().registerReceiver(this.z, paramBundle);
    c();
    b();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i2 = 1;
    int i3 = 1;
    int i1 = 1;
    if (paramCompoundButton.equals(this.i)) {
      if (paramBoolean) {
        if (this.c != i1)
        {
          this.c = i1;
          a(Boolean.valueOf(paramBoolean));
        }
      }
    }
    for (;;)
    {
      return;
      i1 = 0;
      break;
      if (paramCompoundButton.equals(this.m))
      {
        if (paramBoolean) {}
        for (i1 = i2; this.b != i1; i1 = 0)
        {
          this.b = i1;
          b(paramBoolean);
          this.e.a(WeatherContentProvider.g, "setting_key", "autoUpdate", "setting_value", this.b);
          if (!paramBoolean) {
            break label126;
          }
          this.s.d();
          return;
        }
        continue;
        label126:
        this.s.c();
      }
      else if (paramCompoundButton.equals(this.o))
      {
        if (paramBoolean) {}
        for (i1 = i3; this.d != i1; i1 = 0)
        {
          this.d = i1;
          this.e.a(WeatherContentProvider.g, "setting_key", "launch_refresh", "setting_value", this.d);
          return;
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.g)) {
      h();
    }
    for (;;)
    {
      return;
      if (paramView.equals(this.l))
      {
        this.m.toggle();
        return;
      }
      if (paramView.equals(this.h))
      {
        this.i.toggle();
        return;
      }
      if (paramView.equals(this.n))
      {
        this.o.toggle();
        return;
      }
      if (paramView.equals(this.p))
      {
        int i2 = this.u.length;
        int i1 = 0;
        while (i1 < i2)
        {
          if (this.a == this.u[i1])
          {
            a(2131166138, i1, this.t, this.u);
            return;
          }
          i1 += 1;
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903154, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    getActivity().unregisterReceiver(this.z);
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */