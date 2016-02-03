package com.go.weatherex.home.current;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.gau.go.launcherex.goweather.a.a.d;
import com.gau.go.launcherex.gowidget.billing.BillingActivity;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.statistics.r;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.w;
import com.gau.go.launcherex.gowidget.weather.view.MapDetailActivity;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.TileProvider;
import java.util.List;

public class j
  extends x
  implements SharedPreferences.OnSharedPreferenceChangeListener, View.OnClickListener, GoogleMap.OnCameraChangeListener, GoogleMap.OnMapClickListener
{
  private View b;
  private ViewGroup c;
  private ImageView d;
  private l e;
  private l f;
  private MapView g;
  private GoogleMap h;
  private int i = 0;
  private boolean j;
  private TileOverlay k;
  private TileProvider l;
  private TileOverlayOptions m;
  private TileOverlay n;
  private TileProvider o;
  private TileOverlayOptions p;
  private boolean q = false;
  private boolean r = false;
  private WeatherBean s;
  private String t;
  private SharedPreferences u;
  private TextView v;
  private View w;
  private Context x = this.a.getActivity();
  private TextView y;
  
  public j(com.go.weatherex.framework.fragment.a parama, int paramInt)
  {
    super(parama, paramInt);
    this.b = parama.i().a(2130903083, null);
    this.b.setClickable(true);
    this.y = ((TextView)f(2131231145));
    this.a.a(this.y, 4, true);
    this.c = ((ViewGroup)f(2131231128));
    this.c.setVisibility(4);
    this.d = ((ImageView)f(2131231130));
    this.e = new l(this, null);
    this.e.a = this.c.findViewById(2131231134);
    this.e.b = ((ImageView)this.c.findViewById(2131231135));
    this.e.c = ((ImageView)this.c.findViewById(2131231136));
    this.f = new l(this, null);
    this.f.a = this.c.findViewById(2131231131);
    this.f.b = ((ImageView)this.c.findViewById(2131231132));
    this.f.c = ((ImageView)this.c.findViewById(2131231133));
    this.w = f(2131231127);
    this.w.setVisibility(4);
    this.v = ((TextView)f(2131231137));
    this.v.setVisibility(8);
    this.g = ((MapView)f(2131231126));
    this.u = GoWidgetApplication.c(n()).a();
    this.u.registerOnSharedPreferenceChangeListener(this);
    s();
  }
  
  private void b(String paramString)
  {
    boolean bool2 = true;
    this.s = com.gau.go.launcherex.gowidget.weather.util.f.a(n()).a(paramString);
    if (this.s != null)
    {
      if (this.s.k.y() != 1) {
        break label67;
      }
      bool1 = true;
      this.r = bool1;
      if (this.s.k.x() != 1) {
        break label72;
      }
    }
    label67:
    label72:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.q = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  private void c(String paramString)
  {
    r.a(n()).a(new com.gau.go.launcherex.gowidget.statistics.a.a(93, paramString));
  }
  
  private View f(int paramInt)
  {
    return this.b.findViewById(paramInt);
  }
  
  private void g(int paramInt)
  {
    int i1 = this.i;
    if (this.i != paramInt)
    {
      this.i = paramInt;
      switch (this.i)
      {
      default: 
        throw new IllegalArgumentException("viewState is illegal");
      case 1: 
        this.d.setSelected(true);
        this.e.b(false);
        this.f.b(false);
        if (this.k != null) {
          this.k.remove();
        }
        if (this.n != null) {
          this.n.remove();
        }
        break;
      }
    }
    for (;;)
    {
      if (i1 != 0) {
        p();
      }
      return;
      this.d.setSelected(false);
      this.e.b(true);
      this.f.b(false);
      if (this.n != null) {
        this.n.remove();
      }
      if (this.l == null)
      {
        this.l = new com.gau.go.launcherex.goweather.a.a.c();
        this.m = new TileOverlayOptions().tileProvider(this.l);
      }
      this.k = this.h.addTileOverlay(this.m);
      continue;
      this.d.setSelected(false);
      this.e.b(false);
      this.f.b(true);
      if (this.k != null) {
        this.k.remove();
      }
      if (this.o == null)
      {
        this.o = new d();
        this.p = new TileOverlayOptions().tileProvider(this.o);
      }
      this.n = this.h.addTileOverlay(this.p);
    }
  }
  
  private void m()
  {
    this.h = this.g.getMap();
    UiSettings localUiSettings = this.h.getUiSettings();
    localUiSettings.setZoomControlsEnabled(false);
    localUiSettings.setMyLocationButtonEnabled(false);
    localUiSettings.setAllGesturesEnabled(false);
    localUiSettings.setRotateGesturesEnabled(false);
    localUiSettings.setTiltGesturesEnabled(false);
    localUiSettings.setCompassEnabled(false);
    this.h.setMapType(4);
    this.h.setOnCameraChangeListener(this);
    this.h.setOnMapClickListener(this);
  }
  
  private Context n()
  {
    return this.x.getApplicationContext();
  }
  
  private void o()
  {
    if (this.s == null) {
      return;
    }
    if (this.q)
    {
      this.e.a(0);
      if (!this.r) {
        break label67;
      }
      this.f.a(0);
    }
    for (;;)
    {
      this.g.post(new k(this));
      return;
      this.e.a(8);
      break;
      label67:
      this.f.a(8);
    }
  }
  
  private void p()
  {
    SharedPreferences.Editor localEditor = GoWidgetApplication.c(n()).a().edit();
    localEditor.putInt("key_maps_select_type", this.i);
    localEditor.commit();
  }
  
  private void q()
  {
    Intent localIntent = new Intent(this.a.getActivity(), BillingActivity.class);
    localIntent.putExtra("recommend_type", 5);
    localIntent.putExtra("recommend_enterance", 13);
    this.a.startActivity(localIntent);
  }
  
  private void r()
  {
    boolean bool2 = true;
    if (this.s == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("cityId", this.s.c());
    NowBean localNowBean = this.s.k;
    Intent localIntent = new Intent(this.a.getActivity(), MapDetailActivity.class);
    String str = this.s.d();
    double d1 = localNowBean.w();
    double d2 = localNowBean.v();
    boolean bool1;
    if (localNowBean.x() == 1)
    {
      bool1 = true;
      if (localNowBean.y() != 1) {
        break label154;
      }
    }
    for (;;)
    {
      MapDetailActivity.a(localIntent, str, d1, d2, bool1, bool2);
      localIntent.putExtras(localBundle);
      this.a.getActivity().startActivity(localIntent);
      c("c000_radio");
      return;
      bool1 = false;
      break;
      label154:
      bool2 = false;
    }
  }
  
  private void s()
  {
    this.y.setText(this.x.getString(2131165961));
  }
  
  public void a(String paramString)
  {
    boolean bool2 = false;
    int i2 = 1;
    if (!GoWidgetApplication.a)
    {
      this.v.setVisibility(0);
      this.v.setText(2131165995);
      return;
    }
    this.t = paramString;
    this.d.setOnClickListener(this);
    this.e.a(this);
    this.f.a(this);
    this.g.onCreate(null);
    this.g.onResume();
    m();
    this.w.setVisibility(0);
    b(paramString);
    this.j = GoWidgetApplication.b(n()).b();
    paramString = this.f;
    boolean bool1;
    if (!this.j)
    {
      bool1 = true;
      paramString.a(bool1);
      paramString = this.e;
      bool1 = bool2;
      if (!this.j) {
        bool1 = true;
      }
      paramString.a(bool1);
      if (!this.j) {
        break label217;
      }
    }
    label217:
    for (int i1 = this.u.getInt("key_maps_select_type", 1);; i1 = 1)
    {
      if ((i1 == 2) && (!this.q)) {}
      for (;;)
      {
        g(i2);
        o();
        return;
        bool1 = false;
        break;
        if ((i1 != 3) || (this.r)) {
          i2 = i1;
        }
      }
    }
  }
  
  public void a(List paramList, w paramw)
  {
    if (paramw.a == 1)
    {
      b(this.t);
      o();
    }
  }
  
  public void c()
  {
    boolean bool2 = true;
    this.j = GoWidgetApplication.b(n()).b();
    l locall = this.f;
    if (!this.j)
    {
      bool1 = true;
      locall.a(bool1);
      locall = this.e;
      if (this.j) {
        break label60;
      }
    }
    label60:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locall.a(bool1);
      return;
      bool1 = false;
      break;
    }
  }
  
  public View f()
  {
    return this.b;
  }
  
  public void g() {}
  
  public void h()
  {
    s();
  }
  
  public void i()
  {
    com.gtp.a.a.b.c.a("BriefCardMap", "destroy");
    if (this.n != null)
    {
      this.n.clearTileCache();
      this.n.remove();
    }
    if (this.k != null)
    {
      this.k.clearTileCache();
      this.k.remove();
    }
    this.g.onDestroy();
    this.u.unregisterOnSharedPreferenceChangeListener(this);
  }
  
  public void j()
  {
    super.j();
    com.gtp.a.a.b.c.a("BriefCardMap", "onResume");
    this.g.onResume();
  }
  
  public void k()
  {
    super.k();
    com.gtp.a.a.b.c.a("BriefCardMap", "onPause");
    this.g.onPause();
  }
  
  public void onCameraChange(CameraPosition paramCameraPosition)
  {
    if (this.c.getVisibility() != 0) {
      this.c.setVisibility(0);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.d)) {
      g(1);
    }
    do
    {
      return;
      if (paramView.equals(this.e.a))
      {
        if (this.j)
        {
          g(2);
          return;
        }
        q();
        return;
      }
    } while (!paramView.equals(this.f.a));
    if (this.j)
    {
      g(3);
      return;
    }
    q();
  }
  
  public void onMapClick(LatLng paramLatLng)
  {
    r();
    l();
  }
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    if (paramString.equals("key_maps_select_type")) {
      g(paramSharedPreferences.getInt("key_maps_select_type", this.i));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/current/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */