package com.go.weatherex.f;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.d.h;
import com.gau.go.launcherex.gowidget.weather.model.RequestBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.model.b;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.go.weatherex.framework.fragment.a;
import com.gtp.a.a.c.d;
import com.jiubang.goweather.c.m;
import com.jiubang.goweather.c.q;
import com.jiubang.goweather.c.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class t
  extends a
  implements View.OnClickListener, View.OnFocusChangeListener, AbsListView.OnScrollListener, AdapterView.OnItemClickListener, TextView.OnEditorActionListener
{
  private final y A = new y(this);
  private View a;
  private TextView b;
  private ViewGroup c;
  private SparseArray d;
  private View e;
  private ProgressBar f;
  private View g;
  private EditText h;
  private ViewGroup i;
  private n j;
  private View k;
  private GridView l;
  private aa m;
  private List n;
  private List o;
  private List p;
  private m q;
  private ac r;
  private ab s;
  private q t = null;
  private boolean u;
  private boolean v = false;
  private int w;
  private h x;
  private Activity y;
  private TextWatcher z = new w(this);
  
  private void a(int paramInt)
  {
    if (this.w == paramInt) {
      return;
    }
    this.w = paramInt;
    switch (this.w)
    {
    default: 
      throw new IllegalArgumentException("illegal state!");
    case 1: 
      this.e.setVisibility(0);
      this.j.a(8);
      this.j.b();
      return;
    }
    this.e.setVisibility(8);
    this.j.a(0);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.q.a(paramInt1, paramInt2, paramInt3, new v(this, paramInt1, paramInt2));
  }
  
  private void a(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramInt2 > 0) {}
    switch (paramInt1)
    {
    default: 
      return;
    case 3: 
      paramObject = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LIVE_WALLPAPER_SETTINGS_CHANGE");
      l().sendBroadcast((Intent)paramObject);
      paramObject = new ContentValues();
      ((ContentValues)paramObject).put("setting_value", Integer.valueOf(1));
      this.s.a(-1, null, WeatherContentProvider.g, (ContentValues)paramObject, "setting_key=?", new String[] { "key_live_wallpaper_city_flag" });
      return;
    }
    paramObject = (b)paramObject;
    f localf = f.a(l());
    localf.a((b)paramObject, localf.c().size(), 0);
    this.v = false;
    b((b)paramObject);
    Toast.makeText(this.y, this.y.getString(2131165764, new Object[] { ((b)paramObject).b() }), 0).show();
    h();
  }
  
  private void a(int paramInt, Object paramObject, Cursor paramCursor)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramObject = (b)paramObject;
      if ((paramObject == null) || (paramCursor == null)) {
        break;
      }
    }
    for (;;)
    {
      try
      {
        if (paramCursor.getCount() <= 0) {
          break label732;
        }
        this.v = false;
        paramInt = 1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        this.v = false;
        paramCursor.close();
        paramInt = 0;
        continue;
      }
      finally
      {
        paramCursor.close();
      }
      if ((this.v) && (paramInt == 0))
      {
        paramCursor = new ContentValues();
        paramCursor.put("cityId", ((b)paramObject).a());
        paramCursor.put("oldCityId", ((b)paramObject).a());
        paramCursor.put("cityName", ((b)paramObject).b());
        paramCursor.put("state", ((b)paramObject).d());
        paramCursor.put("country", ((b)paramObject).c());
        paramCursor.put("tz_offset", Integer.valueOf(((b)paramObject).e()));
        paramCursor.put("latitude", Float.valueOf(-10000.0F));
        paramCursor.put("longitude", Float.valueOf(-10000.0F));
        paramCursor.put("hasRadar", Integer.valueOf(((b)paramObject).i()));
        paramCursor.put("hasSatellite", Integer.valueOf(((b)paramObject).k()));
        paramCursor.put("myLocation", Integer.valueOf(1));
        paramCursor.put("city_my_location", Integer.valueOf(1));
        paramCursor.put("windDirection", "--");
        paramCursor.put("windStrength", "--");
        paramCursor.put("windType", Integer.valueOf(1));
        paramCursor.put("sunrise", "--");
        paramCursor.put("sunset", "--");
        paramCursor.put("type", Integer.valueOf(1));
        paramCursor.put("nowDesp", "--");
        paramCursor.put("sequence", Integer.valueOf(f.a(l()).c().size()));
        paramCursor.put("pop", Integer.valueOf(55536));
        paramCursor.put("feelslikeValue", Float.valueOf(-10000.0F));
        paramCursor.put("barometerValue", Float.valueOf(-10000.0F));
        paramCursor.put("dewpointValue", Float.valueOf(-10000.0F));
        paramCursor.put("highTempValue", Float.valueOf(-10000.0F));
        paramCursor.put("lowTempValue", Float.valueOf(-10000.0F));
        paramCursor.put("windStrengthValue", Float.valueOf(-10000.0F));
        paramCursor.put("nowTempValue", Float.valueOf(-10000.0F));
        paramCursor.put("timestamp", Integer.valueOf(55536));
        paramCursor.put("uvIndexValue", Float.valueOf(-10000.0F));
        paramCursor.put("humidityValue", Float.valueOf(-10000.0F));
        paramCursor.put("visibilityValue", Float.valueOf(-10000.0F));
        paramCursor.put("updateTime", Integer.valueOf(55536));
        this.s.a(0, paramObject, WeatherContentProvider.a, paramCursor);
        return;
      }
      paramCursor = (WeatherBean)f.a(l()).c().get(((b)paramObject).a());
      if (paramCursor != null)
      {
        if (paramCursor.e() == 2)
        {
          paramCursor = new ContentValues();
          paramCursor.put("city_my_location", Integer.valueOf(3));
          this.s.a(4, paramObject, WeatherContentProvider.a, paramCursor, "cityId=?", new String[] { ((b)paramObject).a() });
          return;
        }
        Toast.makeText(this.y, 2131165707, 0).show();
        this.v = false;
        return;
      }
      this.v = false;
      return;
      this.v = false;
      return;
      if (paramCursor == null) {
        break;
      }
      try
      {
        if ((paramCursor.moveToFirst()) && ("--".equals(paramCursor.getString(0))))
        {
          paramObject = (String)paramObject;
          ContentValues localContentValues = new ContentValues();
          localContentValues.put("setting_value", (String)paramObject);
          this.s.a(3, null, WeatherContentProvider.g, localContentValues, "setting_key=?", new String[] { "key_live_wallpaper_city_id" });
        }
        paramCursor.close();
        return;
      }
      catch (SQLException paramObject)
      {
        for (;;) {}
      }
      label732:
      paramInt = 0;
    }
  }
  
  private void a(int paramInt, Object paramObject, Uri paramUri)
  {
    h();
    this.A.postDelayed(new u(this, paramObject), 500L);
  }
  
  private void a(b paramb)
  {
    if (!this.v)
    {
      this.v = true;
      ab localab = this.s;
      Uri localUri = WeatherContentProvider.a;
      String str = paramb.a();
      localab.a(1, paramb, localUri, new String[] { "cityId" }, "cityId=?", new String[] { str }, null);
    }
  }
  
  private void a(String paramString)
  {
    this.s.a(2, paramString, WeatherContentProvider.g, new String[] { "setting_value" }, "setting_key=?", new String[] { "key_live_wallpaper_city_id" }, "_id");
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (!this.u)
    {
      com.gau.go.launcherex.gowidget.weather.globalview.y localy = new com.gau.go.launcherex.gowidget.weather.globalview.y(this.y);
      localy.c(2131165699);
      localy.a(paramString1);
      localy.b(paramString2);
      localy.a();
    }
  }
  
  private void a(List paramList)
  {
    a(paramList, null);
  }
  
  private void a(List paramList, String paramString)
  {
    this.p = paramList;
    this.l.setAdapter(this.m);
  }
  
  private View b(int paramInt)
  {
    View localView2 = (View)this.d.get(paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = new z(this).a;
      this.d.put(paramInt, localView1);
    }
    return localView1;
  }
  
  private void b()
  {
    if (getArguments() != null) {}
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt2)
    {
    default: 
      return;
    case 1: 
      if ((paramInt3 == 6) || (paramInt3 == 7))
      {
        a(paramInt2, 2, 10);
        return;
      }
      a(paramInt2, 2, 10);
      return;
    case 2: 
      if ((paramInt3 == 2) || (paramInt3 == 1))
      {
        a(paramInt2, 3, 30);
        return;
      }
      a(paramInt2, 3, 30);
      return;
    }
    this.r.sendEmptyMessage(5);
  }
  
  private void b(b paramb)
  {
    Object localObject = new RequestBean();
    ((RequestBean)localObject).a(paramb.a(), paramb.b(), 0L);
    paramb = new ArrayList();
    paramb.add(localObject);
    localObject = new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService");
    ((Intent)localObject).putExtra("notify_request", 21);
    ((Intent)localObject).putParcelableArrayListExtra("req_arg", paramb);
    this.y.startService((Intent)localObject);
  }
  
  private void b(String paramString)
  {
    int i1 = this.c.getChildCount();
    String str = paramString;
    if (i1 > 0) {
      str = " > " + paramString;
    }
    paramString = b(i1);
    z localz = (z)paramString.getTag();
    localz.b.setText(str);
    if (i1 == 0) {
      localz.b.setOnClickListener(new x(this, i1));
    }
    this.c.addView(paramString);
  }
  
  private void c()
  {
    this.b.setText(this.y.getString(2131165680));
    this.h.setHint(this.y.getString(2131165681));
  }
  
  private void d()
  {
    this.n.clear();
    j();
    a(this.n);
  }
  
  private void j()
  {
    if (this.n.size() == 0)
    {
      String[] arrayOfString = this.y.getResources().getStringArray(2131558426);
      int i1 = 0;
      while (i1 < arrayOfString.length)
      {
        b localb = new b(null, arrayOfString[i1], null, null, null, null);
        this.n.add(localb);
        i1 += 1;
      }
    }
  }
  
  private void k()
  {
    ((InputMethodManager)this.y.getSystemService("input_method")).hideSoftInputFromWindow(this.h.getWindowToken(), 0);
  }
  
  private Context l()
  {
    return this.y.getApplicationContext();
  }
  
  private void m()
  {
    if (!d.b(l()))
    {
      Toast.makeText(this.y, 2131165727, 0).show();
      return;
    }
    String str = this.h.getText().toString();
    if ((str == null) || (str.length() == 0))
    {
      Toast.makeText(this.y, 2131165681, 0).show();
      return;
    }
    k();
    this.j.a(str);
  }
  
  private boolean n()
  {
    k();
    switch (this.w)
    {
    }
    while (f.a(this.y.getApplicationContext()).c().isEmpty())
    {
      this.y.finish();
      return true;
      if (this.p.equals(this.o))
      {
        q();
        a(this.n);
        return true;
        a(1);
        return true;
      }
    }
    return false;
  }
  
  private void o()
  {
    this.f.setVisibility(8);
    this.g.setVisibility(0);
  }
  
  private void p()
  {
    a(0, 1, 15);
  }
  
  private void q()
  {
    if (this.c.getChildCount() > 1) {
      this.c.removeViewAt(this.c.getChildCount() - 1);
    }
  }
  
  protected boolean a()
  {
    return n();
  }
  
  public void h()
  {
    ((a)getParentFragment()).h();
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.y = paramActivity;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.a)) {
      if (!n()) {
        h();
      }
    }
    do
    {
      return;
      if (paramView.equals(this.g))
      {
        this.g.setVisibility(8);
        this.f.setVisibility(0);
        p();
        return;
      }
    } while (!paramView.equals(this.k));
    this.h.setText("");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903139, paramViewGroup, false);
  }
  
  public void onDestroyView()
  {
    this.u = true;
    if (this.q != null) {
      this.q.b();
    }
    if (this.t != null) {
      this.t.a();
    }
    super.onDestroyView();
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (((paramInt == 3) || (paramInt == 6) || (paramInt == 0)) && (paramTextView.equals(this.h)))
    {
      m();
      return true;
    }
    return false;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramView.equals(this.h))
    {
      if (paramBoolean) {
        this.h.setHint("");
      }
    }
    else {
      return;
    }
    this.h.setHint(this.y.getString(2131165681));
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (((paramAdapterView instanceof GridView)) && (this.p != null) && (paramInt >= 0) && (paramInt < this.p.size()))
    {
      paramAdapterView = (b)this.p.get(paramInt);
      if (!this.p.equals(this.n)) {
        break label156;
      }
      r.a(this.y, paramAdapterView.b(), 2131099678, this.o);
      this.m.a(paramView.getLeft(), paramView.getTop());
      this.m.b(paramView.getWidth(), paramView.getHeight());
      this.m.e = true;
      a(this.o);
      b(paramAdapterView.b() + " ");
    }
    label156:
    while (!this.p.equals(this.o)) {
      return;
    }
    a(paramAdapterView);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (1 == paramInt)
    {
      this.m.e = false;
      k();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.d = new SparseArray();
    this.x = new h();
    this.x.a(500L);
    this.a = c(2131231196);
    this.a.setOnClickListener(this);
    this.b = ((TextView)c(2131231145));
    this.g = c(2131231889);
    this.g.setOnClickListener(this);
    this.f = ((ProgressBar)c(2131231890));
    this.h = ((EditText)c(2131231337));
    this.h.addTextChangedListener(this.z);
    this.h.setOnFocusChangeListener(this);
    this.h.setOnEditorActionListener(this);
    this.k = c(2131231338);
    this.k.setOnClickListener(this);
    this.k.setVisibility(8);
    this.e = c(2131231342);
    this.l = ((GridView)c(2131231344));
    ViewCompat.setLayerType(this.l, 1, null);
    this.m = new aa(this, null);
    this.l.setAdapter(this.m);
    this.l.setOnItemClickListener(this);
    this.l.setOnScrollListener(this);
    this.c = ((ViewGroup)c(2131231343));
    this.i = ((ViewGroup)c(2131231339));
    this.j = new n(this.y, this, this.A, true);
    this.i.addView(this.j.a());
    this.n = new ArrayList();
    this.o = new ArrayList();
    d();
    this.q = new m(this.y);
    this.r = new ac(this);
    this.s = new ab(this.y.getContentResolver(), this);
    a(1);
    b(this.y.getString(2131165683));
    b();
    c();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/f/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */