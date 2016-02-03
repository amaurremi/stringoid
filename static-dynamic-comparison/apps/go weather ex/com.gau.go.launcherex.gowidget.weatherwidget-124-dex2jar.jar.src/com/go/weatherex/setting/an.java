package com.go.weatherex.setting;

import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentValues;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.globalview.i;
import com.gau.go.launcherex.gowidget.weather.globalview.t;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.view.VerticalStretchLayout;
import com.gtp.a.a.b.c;
import java.util.ArrayList;

public class an
  extends com.go.weatherex.framework.fragment.a
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private TextView A;
  private aw B;
  private ax C;
  private ax D;
  private au E;
  private av F;
  private String G = "--";
  private int H = -1;
  private final int[] I = { 2131166193, 2131166195, 2131166194 };
  private final int[] J = { 2131166197, 2131166198, 2131166199 };
  private final int[] K = { 2131166201, 2131166202, 2131166203 };
  private final int[] L = { 2131166208, 2131166207, 2131166206 };
  private long M;
  private t N;
  private i O;
  private Activity P;
  private LayoutInflater a;
  private TextView b;
  private View c;
  private int d;
  private int e;
  private int f;
  private int g;
  private View h;
  private TextView i;
  private TextView j;
  private View k;
  private CheckBox l;
  private TextView m;
  private View n;
  private CheckBox o;
  private TextView p;
  private VerticalStretchLayout q;
  private TextView r;
  private View s;
  private TextView t;
  private TextView u;
  private View v;
  private TextView w;
  private TextView x;
  private View y;
  private TextView z;
  
  private void a(Cursor paramCursor)
  {
    av[] arrayOfav = new av[paramCursor.getCount()];
    int i3 = paramCursor.getColumnCount();
    paramCursor.moveToFirst();
    int i1 = 0;
    Object localObject2 = null;
    int i2;
    Object localObject1;
    do
    {
      arrayOfav[i1] = new av(this, null);
      i2 = 0;
      if (i2 < i3)
      {
        localObject1 = paramCursor.getColumnName(i2);
        if ("cityName".equals(localObject1)) {
          arrayOfav[i1].a = paramCursor.getString(i2);
        }
        for (;;)
        {
          i2 += 1;
          break;
          if ("cityId".equals(localObject1)) {
            arrayOfav[i1].b = paramCursor.getString(i2);
          } else if ("city_my_location".equals(localObject1)) {
            arrayOfav[i1].c = paramCursor.getInt(i2);
          }
        }
      }
      if (!arrayOfav[i1].b.equals(this.G)) {
        break;
      }
      if ((this.H == arrayOfav[i1].c) || ((this.H != 1) && (arrayOfav[i1].c != 1)))
      {
        arrayOfav[i1].d = true;
        this.F = arrayOfav[i1];
      }
      localObject1 = localObject2;
      if (arrayOfav[i1].c == 3)
      {
        localObject2 = new av(this, null);
        ((av)localObject2).b = arrayOfav[i1].b;
        ((av)localObject2).a = arrayOfav[i1].a;
        ((av)localObject2).c = 1;
        arrayOfav[i1].c = 2;
        localObject1 = localObject2;
        if (((av)localObject2).b.equals(this.G))
        {
          localObject1 = localObject2;
          if (((av)localObject2).c == this.H)
          {
            ((av)localObject2).d = true;
            this.F = ((av)localObject2);
            localObject1 = localObject2;
          }
        }
      }
      i1 += 1;
      localObject2 = localObject1;
    } while (paramCursor.moveToNext());
    if (localObject1 != null)
    {
      i2 = arrayOfav.length;
      paramCursor = new av[i2 + 1];
      i1 = 0;
      label362:
      if (i1 <= i2)
      {
        if (i1 < i2) {
          paramCursor[i1] = arrayOfav[i1];
        }
        for (;;)
        {
          i1 += 1;
          break label362;
          arrayOfav[i1].d = false;
          break;
          if (i1 == i2) {
            paramCursor[i1] = localObject1;
          }
        }
      }
      this.E = new au(this, paramCursor);
      if ((this.F == null) && (arrayOfav[0] != null))
      {
        paramCursor = arrayOfav[0];
        paramCursor.d = true;
        this.F = paramCursor;
      }
      if (this.F == null) {
        break label496;
      }
      this.i.setText(this.F.a());
    }
    for (;;)
    {
      a(true);
      return;
      this.E = new au(this, arrayOfav);
      break;
      label496:
      this.i.setText("--");
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.h.setEnabled(paramBoolean);
    this.i.setEnabled(paramBoolean);
    this.j.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      this.j.setTextColor(this.d);
      this.i.setTextColor(this.d);
      this.i.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.f, 0);
      return;
    }
    this.j.setTextColor(this.e);
    this.i.setTextColor(this.e);
    this.i.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.g, 0);
  }
  
  private void b()
  {
    this.B.a(2, null, WeatherContentProvider.a, new String[] { "cityName", "cityId", "city_my_location" }, null, null, "sequence");
  }
  
  private void b(boolean paramBoolean)
  {
    this.k.setEnabled(paramBoolean);
    this.l.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      this.m.setTextColor(this.d);
      return;
    }
    this.m.setTextColor(this.e);
  }
  
  private void c()
  {
    int i2 = 0;
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.E.b();
    int i3 = localObject.length;
    int i1 = 0;
    if (i1 < i3)
    {
      com.gau.go.launcherex.gowidget.weather.globalview.a locala = new com.gau.go.launcherex.gowidget.weather.globalview.a();
      locala.a = localObject[i1].toString();
      locala.c = Integer.valueOf(i1);
      if (this.E.c() == i1) {}
      for (boolean bool = true;; bool = false)
      {
        locala.b = bool;
        localArrayList.add(locala);
        i1 += 1;
        break;
      }
    }
    localObject = d();
    ((t)localObject).b(2131166189);
    ((t)localObject).a(localArrayList);
    i1 = i2;
    if (i3 > 4) {
      i1 = 4;
    }
    ((t)localObject).c(i1);
    ((t)localObject).a(new ao(this));
    ((t)localObject).a();
  }
  
  private void c(boolean paramBoolean)
  {
    this.n.setEnabled(paramBoolean);
    this.o.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      this.p.setTextColor(this.d);
      return;
    }
    this.p.setTextColor(this.e);
  }
  
  private t d()
  {
    if (this.N == null) {
      this.N = new t(getActivity());
    }
    return this.N;
  }
  
  private void d(boolean paramBoolean)
  {
    this.r.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      this.r.setTextColor(this.d);
      this.r.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.f, 0);
      return;
    }
    this.r.setTextColor(this.e);
    this.r.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.g, 0);
  }
  
  private void e(boolean paramBoolean)
  {
    this.s.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      this.t.setTextColor(this.d);
      this.u.setTextColor(this.d);
      this.u.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.f, 0);
      return;
    }
    this.t.setTextColor(this.e);
    this.u.setTextColor(this.e);
    this.u.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.g, 0);
  }
  
  private void f(boolean paramBoolean)
  {
    this.v.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      this.x.setTextColor(this.d);
      this.w.setTextColor(this.d);
      this.w.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.f, 0);
      return;
    }
    this.x.setTextColor(this.e);
    this.w.setTextColor(this.e);
    this.w.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.g, 0);
  }
  
  private void g(boolean paramBoolean)
  {
    this.y.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      this.A.setTextColor(this.d);
      this.z.setTextColor(this.d);
      this.z.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.f, 0);
      return;
    }
    this.A.setTextColor(this.e);
    this.z.setTextColor(this.e);
    this.z.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.g, 0);
  }
  
  private i j()
  {
    if (this.O == null) {
      this.O = new i(getActivity());
    }
    return this.O;
  }
  
  private void k()
  {
    this.B.a(1, null, WeatherContentProvider.g, new String[] { "setting_value" }, "setting_key=?", new String[] { "key_live_wallpaper_city_id" }, "_id");
  }
  
  private void l()
  {
    SparseArray localSparseArray = new SparseArray();
    localSparseArray.append(3, "key_live_wallpaper_dynamic_effect_on");
    localSparseArray.append(5, "key_live_wallpaper_weather_info_description_on");
    localSparseArray.append(6, "key_live_wallpaper_weather_info_wind_on");
    localSparseArray.append(7, "key_live_wallpaper_weather_info_hight_low_temperature_on");
    localSparseArray.append(8, "key_live_wallpaper_weather_info_position");
    localSparseArray.append(9, "key_live_wallpaper_weather_info_show_moment");
    localSparseArray.append(16, "key_live_wallpaper_weather_info_font_size");
    localSparseArray.append(4, "key_live_wallpaper_show_weather_info_on");
    localSparseArray.append(18, "key_live_wallpaper_city_flag");
    int i2 = localSparseArray.size();
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = localSparseArray.keyAt(i1);
      String str = (String)localSparseArray.valueAt(i1);
      this.B.a(i3, null, WeatherContentProvider.g, new String[] { "setting_value" }, "setting_key=?", new String[] { str }, "_id");
      i1 += 1;
    }
  }
  
  private void m()
  {
    ArrayList localArrayList = new ArrayList();
    int i2 = this.I.length;
    int i1 = 0;
    if (i1 < i2)
    {
      localObject = new at(this, null);
      ((at)localObject).a = this.I[i1];
      label76:
      com.gau.go.launcherex.gowidget.weather.globalview.a locala;
      switch (this.I[i1])
      {
      default: 
        locala = new com.gau.go.launcherex.gowidget.weather.globalview.a();
        locala.c = localObject;
        locala.a = getString(((at)localObject).a);
        if (((at)localObject).c != 1) {
          break;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        locala.b = bool;
        localArrayList.add(locala);
        i1 += 1;
        break;
        ((at)localObject).c = this.D.c;
        break label76;
        ((at)localObject).c = this.D.d;
        break label76;
        ((at)localObject).c = this.D.e;
        break label76;
      }
    }
    Object localObject = j();
    ((i)localObject).a(2131166192);
    ((i)localObject).a(localArrayList);
    ((i)localObject).a(new ap(this));
    ((i)localObject).a();
  }
  
  private void n()
  {
    int i2 = 4;
    ArrayList localArrayList = new ArrayList();
    int i3 = this.J.length;
    int i1 = 0;
    if (i1 < i3)
    {
      localObject = new at(this, null);
      ((at)localObject).a = this.J[i1];
      switch (this.J[i1])
      {
      }
      for (;;)
      {
        com.gau.go.launcherex.gowidget.weather.globalview.a locala = new com.gau.go.launcherex.gowidget.weather.globalview.a();
        locala.c = localObject;
        locala.a = getString(((at)localObject).a);
        locala.b = ((at)localObject).b;
        localArrayList.add(locala);
        i1 += 1;
        break;
        ((at)localObject).c = 1;
        if (this.D.f == ((at)localObject).c)
        {
          ((at)localObject).b = true;
          continue;
          ((at)localObject).c = 2;
          if (this.D.f == ((at)localObject).c)
          {
            ((at)localObject).b = true;
            continue;
            ((at)localObject).c = 3;
            if (this.D.f == ((at)localObject).c) {
              ((at)localObject).b = true;
            }
          }
        }
      }
    }
    Object localObject = d();
    ((t)localObject).b(2131166196);
    ((t)localObject).a(localArrayList);
    if (i3 > 4) {}
    for (i1 = i2;; i1 = 0)
    {
      ((t)localObject).c(i1);
      ((t)localObject).a(new aq(this));
      ((t)localObject).a();
      return;
    }
  }
  
  private void o()
  {
    int i2 = 4;
    ArrayList localArrayList = new ArrayList();
    int i3 = this.K.length;
    int i1 = 0;
    if (i1 < i3)
    {
      localObject = new at(this, null);
      ((at)localObject).a = this.K[i1];
      switch (this.K[i1])
      {
      }
      for (;;)
      {
        com.gau.go.launcherex.gowidget.weather.globalview.a locala = new com.gau.go.launcherex.gowidget.weather.globalview.a();
        locala.c = localObject;
        locala.a = getString(((at)localObject).a);
        locala.b = ((at)localObject).b;
        localArrayList.add(locala);
        i1 += 1;
        break;
        ((at)localObject).c = 1;
        if (this.D.g == ((at)localObject).c)
        {
          ((at)localObject).b = true;
          continue;
          ((at)localObject).c = 2;
          if (this.D.g == ((at)localObject).c)
          {
            ((at)localObject).b = true;
            continue;
            ((at)localObject).c = 3;
            if (this.D.g == ((at)localObject).c) {
              ((at)localObject).b = true;
            }
          }
        }
      }
    }
    Object localObject = d();
    ((t)localObject).b(2131166200);
    ((t)localObject).a(localArrayList);
    if (i3 > 4) {}
    for (i1 = i2;; i1 = 0)
    {
      ((t)localObject).c(i1);
      ((t)localObject).a(new ar(this));
      ((t)localObject).a();
      return;
    }
  }
  
  private void p()
  {
    int i2 = 4;
    ArrayList localArrayList = new ArrayList();
    int i3 = this.L.length;
    int i1 = 0;
    if (i1 < i3)
    {
      localObject = new at(this, null);
      ((at)localObject).a = this.L[i1];
      switch (this.L[i1])
      {
      }
      for (;;)
      {
        com.gau.go.launcherex.gowidget.weather.globalview.a locala = new com.gau.go.launcherex.gowidget.weather.globalview.a();
        locala.c = localObject;
        locala.a = getString(((at)localObject).a);
        locala.b = ((at)localObject).b;
        localArrayList.add(locala);
        i1 += 1;
        break;
        ((at)localObject).c = 1;
        if (this.D.h == ((at)localObject).c)
        {
          ((at)localObject).b = true;
          continue;
          ((at)localObject).c = 2;
          if (this.D.h == ((at)localObject).c)
          {
            ((at)localObject).b = true;
            continue;
            ((at)localObject).c = 3;
            if (this.D.h == ((at)localObject).c) {
              ((at)localObject).b = true;
            }
          }
        }
      }
    }
    Object localObject = d();
    ((t)localObject).b(2131166205);
    ((t)localObject).a(localArrayList);
    if (i3 > 4) {}
    for (i1 = i2;; i1 = 0)
    {
      ((t)localObject).c(i1);
      ((t)localObject).a(new as(this));
      ((t)localObject).a();
      return;
    }
  }
  
  private void q()
  {
    this.M = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    if ((this.F != null) && ((!this.G.equals(this.F.b)) || (this.H != this.F.c))) {
      if (this.F.b != null) {
        break label965;
      }
    }
    label965:
    for (Object localObject = "--";; localObject = this.F.b)
    {
      this.G = ((String)localObject);
      localObject = new ContentValues();
      ((ContentValues)localObject).put("setting_value", this.F.b);
      localArrayList.add(ContentProviderOperation.newUpdate(WeatherContentProvider.g).withValues((ContentValues)localObject).withSelection("setting_key=?", new String[] { "key_live_wallpaper_city_id" }).build());
      ((ContentValues)localObject).clear();
      ((ContentValues)localObject).put("setting_value", Integer.valueOf(this.F.c));
      localArrayList.add(ContentProviderOperation.newUpdate(WeatherContentProvider.g).withValues((ContentValues)localObject).withSelection("setting_key=?", new String[] { "key_live_wallpaper_city_flag" }).build());
      if (this.D.a != this.C.a)
      {
        this.C.a = this.D.a;
        localObject = new ContentValues();
        ((ContentValues)localObject).put("setting_value", Integer.valueOf(this.D.a));
        localArrayList.add(ContentProviderOperation.newUpdate(WeatherContentProvider.g).withValues((ContentValues)localObject).withSelection("setting_key=?", new String[] { "key_live_wallpaper_dynamic_effect_on" }).build());
      }
      if (this.D.b != this.C.b)
      {
        this.C.b = this.D.b;
        localObject = new ContentValues();
        ((ContentValues)localObject).put("setting_value", Integer.valueOf(this.D.b));
        localArrayList.add(ContentProviderOperation.newUpdate(WeatherContentProvider.g).withValues((ContentValues)localObject).withSelection("setting_key=?", new String[] { "key_live_wallpaper_show_weather_info_on" }).build());
      }
      if (this.D.c != this.C.c)
      {
        this.C.c = this.D.c;
        localObject = new ContentValues();
        ((ContentValues)localObject).put("setting_value", Integer.valueOf(this.D.c));
        localArrayList.add(ContentProviderOperation.newUpdate(WeatherContentProvider.g).withValues((ContentValues)localObject).withSelection("setting_key=?", new String[] { "key_live_wallpaper_weather_info_description_on" }).build());
      }
      if (this.D.e != this.C.e)
      {
        this.C.e = this.D.e;
        localObject = new ContentValues();
        ((ContentValues)localObject).put("setting_value", Integer.valueOf(this.D.e));
        localArrayList.add(ContentProviderOperation.newUpdate(WeatherContentProvider.g).withValues((ContentValues)localObject).withSelection("setting_key=?", new String[] { "key_live_wallpaper_weather_info_hight_low_temperature_on" }).build());
      }
      if (this.D.d != this.C.d)
      {
        this.C.d = this.D.d;
        localObject = new ContentValues();
        ((ContentValues)localObject).put("setting_value", Integer.valueOf(this.D.d));
        localArrayList.add(ContentProviderOperation.newUpdate(WeatherContentProvider.g).withValues((ContentValues)localObject).withSelection("setting_key=?", new String[] { "key_live_wallpaper_weather_info_wind_on" }).build());
      }
      if (this.D.f != this.C.f)
      {
        this.C.f = this.D.f;
        localObject = new ContentValues();
        ((ContentValues)localObject).put("setting_value", Integer.valueOf(this.D.f));
        localArrayList.add(ContentProviderOperation.newUpdate(WeatherContentProvider.g).withValues((ContentValues)localObject).withSelection("setting_key=?", new String[] { "key_live_wallpaper_weather_info_position" }).build());
      }
      if (this.D.g != this.C.g)
      {
        this.C.g = this.D.g;
        localObject = new ContentValues();
        ((ContentValues)localObject).put("setting_value", Integer.valueOf(this.D.g));
        localArrayList.add(ContentProviderOperation.newUpdate(WeatherContentProvider.g).withValues((ContentValues)localObject).withSelection("setting_key=?", new String[] { "key_live_wallpaper_weather_info_show_moment" }).build());
      }
      if (this.D.h != this.C.h)
      {
        this.C.h = this.D.h;
        localObject = new ContentValues();
        ((ContentValues)localObject).put("setting_value", Integer.valueOf(this.D.h));
        localArrayList.add(ContentProviderOperation.newUpdate(WeatherContentProvider.g).withValues((ContentValues)localObject).withSelection("setting_key=?", new String[] { "key_live_wallpaper_weather_info_font_size" }).build());
      }
      this.M = (System.currentTimeMillis() - this.M);
      c.a("LJL", "mTime:" + this.M);
      this.M = System.currentTimeMillis();
      this.B.a(17, null, "com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider", localArrayList);
      return;
    }
  }
  
  protected boolean a()
  {
    return super.a();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.B = new aw(this, getActivity().getContentResolver());
    this.a = getActivity().getLayoutInflater();
    this.C = new ax(this, null);
    this.D = new ax(this, null);
    this.d = getResources().getColor(2131361899);
    this.e = getResources().getColor(2131361901);
    this.f = 2130838496;
    this.g = 2130838496;
    this.b = ((TextView)c(2131231145));
    this.b.setText(2131166106);
    this.c = c(2131231196);
    this.h = c(2131231398);
    this.i = ((TextView)this.h.findViewById(2131231208));
    this.j = ((TextView)this.h.findViewById(2131231399));
    this.k = c(2131231400);
    this.l = ((CheckBox)this.k.findViewById(2131231402));
    this.m = ((TextView)this.k.findViewById(2131231401));
    this.n = c(2131231403);
    this.o = ((CheckBox)this.n.findViewById(2131231405));
    this.p = ((TextView)this.n.findViewById(2131231404));
    this.q = ((VerticalStretchLayout)c(2131231406));
    this.r = ((TextView)c(2131231407));
    this.s = c(2131231408);
    this.u = ((TextView)this.s.findViewById(2131231410));
    this.t = ((TextView)this.s.findViewById(2131231409));
    this.v = c(2131231411);
    this.w = ((TextView)this.v.findViewById(2131231413));
    this.x = ((TextView)this.v.findViewById(2131231412));
    this.y = c(2131231414);
    this.A = ((TextView)this.y.findViewById(2131231415));
    this.z = ((TextView)this.y.findViewById(2131231416));
    this.c.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.l.setOnCheckedChangeListener(this);
    this.n.setOnClickListener(this);
    this.o.setOnCheckedChangeListener(this);
    this.r.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.y.setOnClickListener(this);
    a(false);
    b(false);
    c(false);
    d(false);
    e(false);
    f(false);
    g(false);
    k();
    l();
    b();
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.P = paramActivity;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i2 = 1;
    int i1 = 1;
    if (paramCompoundButton.equals(this.l))
    {
      paramCompoundButton = this.D;
      if (this.l.isChecked()) {
        paramCompoundButton.a = i1;
      }
    }
    for (;;)
    {
      return;
      i1 = 0;
      break;
      if (paramCompoundButton.equals(this.o))
      {
        if (this.o.isChecked()) {}
        for (i1 = i2; this.D.b != i1; i1 = 0)
        {
          this.D.b = i1;
          paramBoolean = this.o.isChecked();
          d(paramBoolean);
          e(paramBoolean);
          f(paramBoolean);
          g(paramBoolean);
          if (!paramBoolean) {
            break label130;
          }
          this.q.d();
          return;
        }
      }
    }
    label130:
    this.q.c();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.c)) {
      h();
    }
    do
    {
      return;
      if (paramView.equals(this.h))
      {
        c();
        return;
      }
      if (paramView.equals(this.k))
      {
        this.l.toggle();
        return;
      }
      if (paramView.equals(this.n))
      {
        this.o.toggle();
        return;
      }
      if (paramView.equals(this.r))
      {
        m();
        return;
      }
      if (paramView.equals(this.s))
      {
        n();
        return;
      }
      if (paramView.equals(this.v))
      {
        o();
        return;
      }
    } while (!paramView.equals(this.y));
    p();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903151, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    if (getActivity().isFinishing()) {
      q();
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStop()
  {
    super.onStop();
    q();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */