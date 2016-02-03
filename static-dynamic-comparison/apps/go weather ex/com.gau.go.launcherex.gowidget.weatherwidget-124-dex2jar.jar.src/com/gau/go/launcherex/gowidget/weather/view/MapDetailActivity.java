package com.gau.go.launcherex.gowidget.weather.view;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.gau.go.launcherex.goweather.a.a.d;
import com.gau.go.launcherex.gowidget.billing.BillingActivity;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.language.GoWeatherExFragmentActivity;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.d.f;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.TileProvider;
import com.jiubang.core.b.a;

public class MapDetailActivity
  extends GoWeatherExFragmentActivity
  implements View.OnClickListener, GoogleMap.OnCameraChangeListener
{
  private GoogleMap a;
  private ViewGroup b;
  private ImageView c;
  private ak d;
  private ak e;
  private View f;
  private View g;
  private TextView h;
  private TileOverlay i;
  private TileProvider j;
  private TileOverlayOptions k;
  private TileOverlay l;
  private TileProvider m;
  private TileOverlayOptions n;
  private LatLng o;
  private int p = 0;
  private boolean q = false;
  private boolean r = false;
  private boolean s = false;
  private boolean t;
  private com.gau.go.launcherex.goweather.a.b u;
  private BroadcastReceiver v = new aj(this);
  
  private void a(int paramInt)
  {
    int i1 = this.p;
    if (this.p != paramInt)
    {
      this.p = paramInt;
      switch (this.p)
      {
      default: 
        throw new IllegalArgumentException("viewState is illegal");
      case 1: 
        this.c.setSelected(true);
        this.d.b(false);
        this.e.b(false);
        b(4);
        if (this.i != null) {
          this.i.remove();
        }
        if (this.l != null) {
          this.l.remove();
        }
        break;
      }
    }
    for (;;)
    {
      if (i1 != 0) {
        f();
      }
      return;
      this.c.setSelected(false);
      this.d.b(true);
      this.e.b(false);
      b(0);
      if (this.l != null) {
        this.l.remove();
      }
      if (this.j == null)
      {
        this.j = new com.gau.go.launcherex.goweather.a.a.c();
        this.k = new TileOverlayOptions().tileProvider(this.j);
      }
      this.i = this.a.addTileOverlay(this.k);
      y.a("maps_tab_radar", getApplicationContext());
      continue;
      this.c.setSelected(false);
      this.d.b(false);
      this.e.b(true);
      b(4);
      if (this.i != null) {
        this.i.remove();
      }
      if (this.m == null)
      {
        this.m = new d();
        this.n = new TileOverlayOptions().tileProvider(this.m);
      }
      this.l = this.a.addTileOverlay(this.n);
      y.a("map_tab_satellite", getApplicationContext());
    }
  }
  
  private void a(Intent paramIntent)
  {
    boolean bool2 = true;
    if (paramIntent == null) {
      return;
    }
    this.t = GoWidgetApplication.b(getApplicationContext()).b();
    this.q = paramIntent.getBooleanExtra("has_radar_data", false);
    this.r = paramIntent.getBooleanExtra("has_satellite_data", false);
    Object localObject = GoWidgetApplication.c(getApplicationContext()).a();
    if (this.t) {}
    for (int i1 = ((SharedPreferences)localObject).getInt("key_maps_select_type", 1);; i1 = 1)
    {
      int i2;
      if ((i1 == 2) && (!this.q))
      {
        i2 = 1;
        a(i2);
        if (!this.q) {
          break label250;
        }
        this.d.a(0);
        label108:
        if (!this.r) {
          break label262;
        }
        this.e.a(0);
        label123:
        localObject = this.e;
        if (this.t) {
          break label274;
        }
        bool1 = true;
        label139:
        ((ak)localObject).a(bool1);
        localObject = this.d;
        if (this.t) {
          break label280;
        }
      }
      label250:
      label262:
      label274:
      label280:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        ((ak)localObject).a(bool1);
        localObject = paramIntent.getStringExtra("city_name");
        this.h.setText((CharSequence)localObject);
        this.o = new LatLng(paramIntent.getDoubleExtra("city_latitude", 0.0D), paramIntent.getDoubleExtra("city_longitude", 0.0D));
        this.a.moveCamera(CameraUpdateFactory.newLatLngZoom(this.o, 7.0F));
        return;
        i2 = i1;
        if (i1 != 3) {
          break;
        }
        i2 = i1;
        if (this.r) {
          break;
        }
        i2 = 1;
        break;
        this.d.a(8);
        break label108;
        this.e.a(8);
        break label123;
        bool1 = false;
        break label139;
      }
    }
  }
  
  public static void a(Intent paramIntent, String paramString, double paramDouble1, double paramDouble2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramIntent.putExtra("city_name", paramString);
    paramIntent.putExtra("city_latitude", paramDouble1);
    paramIntent.putExtra("city_longitude", paramDouble2);
    paramIntent.putExtra("has_radar_data", paramBoolean1);
    paramIntent.putExtra("has_satellite_data", paramBoolean2);
  }
  
  private boolean a(CameraPosition paramCameraPosition)
  {
    if (paramCameraPosition.zoom > 8.5F) {}
    for (boolean bool = true;; bool = false)
    {
      this.s = bool;
      return this.s;
    }
  }
  
  private void b()
  {
    if ((!this.q) && (!this.r))
    {
      c(4);
      b(4);
    }
    do
    {
      return;
      c(0);
    } while (this.p != 2);
    b(0);
  }
  
  private void b(int paramInt)
  {
    if (this.g.getVisibility() == paramInt) {
      return;
    }
    this.g.setVisibility(paramInt);
    this.u.a(this.g, paramInt);
  }
  
  private void c(int paramInt)
  {
    if (this.b.getVisibility() == paramInt) {
      return;
    }
    this.b.setVisibility(paramInt);
    this.u.b(this.b, paramInt);
  }
  
  private boolean c()
  {
    this.a = ((SupportMapFragment)getSupportFragmentManager().findFragmentById(2131230863)).getMap();
    return this.a != null;
  }
  
  private void d()
  {
    UiSettings localUiSettings = this.a.getUiSettings();
    localUiSettings.setZoomControlsEnabled(false);
    localUiSettings.setMyLocationButtonEnabled(false);
    localUiSettings.setAllGesturesEnabled(true);
    localUiSettings.setRotateGesturesEnabled(true);
    localUiSettings.setTiltGesturesEnabled(false);
    localUiSettings.setCompassEnabled(true);
    this.a.setMapType(4);
    int i1 = b_().getDimensionPixelSize(2131427555);
    this.a.setPadding(0, i1 + 10, 0, 0);
    this.a.setOnCameraChangeListener(this);
  }
  
  private void e()
  {
    Intent localIntent = new Intent(this, BillingActivity.class);
    localIntent.putExtra("recommend_type", 5);
    localIntent.putExtra("recommend_enterance", 13);
    startActivity(localIntent);
  }
  
  private void f()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("key_maps_select_type", Integer.valueOf(this.p));
    getContentResolver().update(WeatherContentProvider.o, localContentValues, null, null);
  }
  
  public void a(com.gau.go.launcherex.gowidget.language.b paramb)
  {
    super.a(paramb);
    switch (this.p)
    {
    default: 
      throw new IllegalArgumentException("viewState is illegal");
    }
  }
  
  public void onCameraChange(CameraPosition paramCameraPosition)
  {
    com.gtp.a.a.b.c.a("MapDetailActivity", "onCameraChange: " + paramCameraPosition.toString() + ", time: " + System.currentTimeMillis());
    if (a(paramCameraPosition))
    {
      c(4);
      b(4);
      return;
    }
    b();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.c)) {
      a(1);
    }
    do
    {
      return;
      if (paramView.equals(this.d.a))
      {
        if (this.t)
        {
          a(2);
          return;
        }
        e();
        return;
      }
      if (paramView.equals(this.e.a))
      {
        if (this.t)
        {
          a(3);
          return;
        }
        e();
        return;
      }
    } while (!paramView.equals(this.f));
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.u = new com.gau.go.launcherex.goweather.a.b(this);
    setContentView(2130903231);
    this.b = ((ViewGroup)findViewById(2131231128));
    this.b.setVisibility(8);
    this.c = ((ImageView)findViewById(2131231130));
    this.d = new ak(this, null);
    this.d.a = this.b.findViewById(2131231134);
    this.d.b = ((ImageView)this.b.findViewById(2131231135));
    this.d.c = ((ImageView)this.b.findViewById(2131231136));
    this.e = new ak(this, null);
    this.e.a = this.b.findViewById(2131231131);
    this.e.b = ((ImageView)this.b.findViewById(2131231132));
    this.e.c = ((ImageView)this.b.findViewById(2131231133));
    this.f = findViewById(2131231196);
    this.g = findViewById(2131231710);
    this.h = ((TextView)findViewById(2131231145));
    this.f.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.a(this);
    this.e.a(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.gau.go.launcherex.gowidget.weatherwidget.goweather.ACTION_UPDATE_DATA");
    paramBundle.addAction("com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE");
    registerReceiver(this.v, paramBundle);
    if (c())
    {
      d();
      a(getIntent());
    }
    for (;;)
    {
      y.a("maps_tab_map_detail", getApplicationContext());
      return;
      finish();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.v);
    if (this.l != null)
    {
      this.l.clearTileCache();
      this.l.remove();
    }
    if (this.i != null)
    {
      this.i.clearTileCache();
      this.i.remove();
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    a(paramIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/MapDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */