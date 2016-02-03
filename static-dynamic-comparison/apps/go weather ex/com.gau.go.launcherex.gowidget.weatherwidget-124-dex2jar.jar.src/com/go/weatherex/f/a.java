package com.go.weatherex.f;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.d.h;
import com.gau.go.launcherex.gowidget.weather.globalview.y;
import com.gau.go.launcherex.gowidget.weather.model.RequestBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.jiubang.goweather.c.m;
import com.jiubang.goweather.c.q;
import java.util.ArrayList;
import java.util.Map;

public class a
  extends com.go.weatherex.framework.fragment.a
  implements View.OnClickListener, View.OnFocusChangeListener, TextView.OnEditorActionListener
{
  private int a;
  private h b;
  private View c;
  private TextView d;
  private ViewGroup e;
  private ImageView f;
  private EditText g;
  private View h;
  private j i;
  private n j;
  private int k = 0;
  private ProgressBar l;
  private m m;
  private g n;
  private f o;
  private boolean p = false;
  private q q = null;
  private boolean r = false;
  private Activity s;
  private TextWatcher t = new d(this);
  private final e u = new e(this);
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.m.a(paramInt1, paramInt2, paramInt3, new b(this, paramInt1, paramInt2));
  }
  
  private void a(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramInt2 > 0) {}
    switch (paramInt1)
    {
    default: 
      return;
    case 7: 
      paramObject = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_LIVE_WALLPAPER_SETTINGS_CHANGE");
      n().sendBroadcast((Intent)paramObject);
      paramObject = new ContentValues();
      ((ContentValues)paramObject).put("setting_value", Integer.valueOf(1));
      this.o.a(-1, null, WeatherContentProvider.g, (ContentValues)paramObject, "setting_key=?", new String[] { "key_live_wallpaper_city_flag" });
      return;
    }
    paramObject = (com.gau.go.launcherex.gowidget.weather.model.b)paramObject;
    com.gau.go.launcherex.gowidget.weather.util.f localf = com.gau.go.launcherex.gowidget.weather.util.f.a(n());
    localf.a((com.gau.go.launcherex.gowidget.weather.model.b)paramObject, localf.c().size(), 0);
    this.r = false;
    b((com.gau.go.launcherex.gowidget.weather.model.b)paramObject);
    Toast.makeText(this.s, this.s.getString(2131165764, new Object[] { ((com.gau.go.launcherex.gowidget.weather.model.b)paramObject).b() }), 0).show();
    h();
  }
  
  private void a(int paramInt, Object paramObject, Cursor paramCursor)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 5: 
      paramObject = (com.gau.go.launcherex.gowidget.weather.model.b)paramObject;
      if (paramCursor == null) {
        break;
      }
    }
    for (;;)
    {
      try
      {
        if (paramCursor.getCount() <= 0) {
          break label712;
        }
        this.r = false;
        paramInt = 1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        this.r = false;
        paramCursor.close();
        paramInt = 0;
        continue;
      }
      finally
      {
        paramCursor.close();
      }
      if ((this.r) && (paramInt == 0))
      {
        paramCursor = new ContentValues();
        paramCursor.put("cityId", ((com.gau.go.launcherex.gowidget.weather.model.b)paramObject).a());
        paramCursor.put("oldCityId", ((com.gau.go.launcherex.gowidget.weather.model.b)paramObject).a());
        paramCursor.put("cityName", ((com.gau.go.launcherex.gowidget.weather.model.b)paramObject).b());
        paramCursor.put("state", ((com.gau.go.launcherex.gowidget.weather.model.b)paramObject).d());
        paramCursor.put("country", ((com.gau.go.launcherex.gowidget.weather.model.b)paramObject).c());
        paramCursor.put("tz_offset", Integer.valueOf(((com.gau.go.launcherex.gowidget.weather.model.b)paramObject).e()));
        paramCursor.put("latitude", Float.valueOf(-10000.0F));
        paramCursor.put("longitude", Float.valueOf(-10000.0F));
        paramCursor.put("hasRadar", Integer.valueOf(((com.gau.go.launcherex.gowidget.weather.model.b)paramObject).i()));
        paramCursor.put("hasSatellite", Integer.valueOf(((com.gau.go.launcherex.gowidget.weather.model.b)paramObject).k()));
        paramCursor.put("myLocation", Integer.valueOf(1));
        paramCursor.put("city_my_location", Integer.valueOf(1));
        paramCursor.put("windDirection", "--");
        paramCursor.put("windStrength", "--");
        paramCursor.put("windType", Integer.valueOf(1));
        paramCursor.put("sunrise", "--");
        paramCursor.put("sunset", "--");
        paramCursor.put("type", Integer.valueOf(1));
        paramCursor.put("nowDesp", "--");
        paramCursor.put("sequence", Integer.valueOf(com.gau.go.launcherex.gowidget.weather.util.f.a(n()).c().size()));
        paramCursor.put("pop", Integer.valueOf(55536));
        paramCursor.put("cityType", Integer.valueOf(2));
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
        this.o.a(0, paramObject, WeatherContentProvider.a, paramCursor);
        return;
      }
      paramCursor = (WeatherBean)com.gau.go.launcherex.gowidget.weather.util.f.a(n()).c().get(((com.gau.go.launcherex.gowidget.weather.model.b)paramObject).a());
      if (paramCursor != null)
      {
        if (paramCursor.e() == 2)
        {
          paramCursor = new ContentValues();
          paramCursor.put("city_my_location", Integer.valueOf(3));
          this.o.a(8, paramObject, WeatherContentProvider.a, paramCursor, "cityId=?", new String[] { ((com.gau.go.launcherex.gowidget.weather.model.b)paramObject).a() });
          return;
        }
        Toast.makeText(this.s, 2131165707, 0).show();
        this.r = false;
        return;
      }
      this.r = false;
      return;
      this.r = false;
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
          this.o.a(7, null, WeatherContentProvider.g, localContentValues, "setting_key=?", new String[] { "key_live_wallpaper_city_id" });
        }
        paramCursor.close();
        return;
      }
      catch (SQLException paramObject)
      {
        for (;;) {}
      }
      label712:
      paramInt = 0;
    }
  }
  
  private void a(int paramInt, Object paramObject, Uri paramUri)
  {
    h();
    this.u.postDelayed(new c(this, paramObject), 500L);
  }
  
  private void a(String paramString)
  {
    this.o.a(6, paramString, WeatherContentProvider.g, new String[] { "setting_value" }, "setting_key=?", new String[] { "key_live_wallpaper_city_id" }, "_id");
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (!this.p)
    {
      y localy = new y(this.s);
      localy.c(2131165699);
      localy.a(paramString1);
      localy.b(paramString2);
      localy.a();
    }
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
    this.n.sendEmptyMessage(5);
  }
  
  private void b(com.gau.go.launcherex.gowidget.weather.model.b paramb)
  {
    Object localObject = new RequestBean();
    ((RequestBean)localObject).a(paramb.a(), paramb.b(), 0L);
    paramb = new ArrayList();
    paramb.add(localObject);
    localObject = new Intent("com.gau.go.launcherex.gowidget.weather.service.NotifyService");
    ((Intent)localObject).putExtra("notify_request", 21);
    ((Intent)localObject).putParcelableArrayListExtra("req_arg", paramb);
    this.s.startService((Intent)localObject);
  }
  
  private void c()
  {
    this.l.setVisibility(8);
    this.f.setVisibility(0);
  }
  
  private void d()
  {
    if (getArguments() != null) {}
  }
  
  private void j()
  {
    this.d.setText(this.s.getString(2131165680));
    this.g.setHint(this.s.getString(2131165681));
  }
  
  private boolean k()
  {
    boolean bool = false;
    l();
    if (this.a != 1)
    {
      a(1);
      bool = true;
    }
    if ((!bool) && (com.gau.go.launcherex.gowidget.weather.util.f.a(n()).c().isEmpty()))
    {
      this.s.finish();
      return true;
    }
    return bool;
  }
  
  private void l()
  {
    ((InputMethodManager)this.s.getSystemService("input_method")).hideSoftInputFromWindow(this.g.getWindowToken(), 0);
  }
  
  private void m()
  {
    this.i.a(0);
  }
  
  private Context n()
  {
    return this.s.getApplicationContext();
  }
  
  private void o()
  {
    if (!com.gtp.a.a.c.d.b(n()))
    {
      Toast.makeText(this.s, 2131165727, 0).show();
      return;
    }
    String str = this.g.getText().toString();
    if ((str == null) || (str.length() == 0))
    {
      Toast.makeText(this.s, 2131165681, 0).show();
      return;
    }
    l();
    this.j.a(str);
  }
  
  public void a(int paramInt)
  {
    if (this.a == paramInt) {
      return;
    }
    this.a = paramInt;
    switch (this.a)
    {
    default: 
      throw new IllegalArgumentException("illegal state!");
    case 1: 
      this.j.a(8);
      this.j.b();
      m();
      return;
    }
    this.i.a(8);
    this.j.a(0);
  }
  
  public void a(com.gau.go.launcherex.gowidget.weather.model.b paramb)
  {
    if (!this.r)
    {
      this.r = true;
      f localf = this.o;
      Uri localUri = WeatherContentProvider.a;
      String str = paramb.a();
      localf.a(5, paramb, localUri, new String[] { "cityId" }, "cityId=?", new String[] { str }, null);
    }
  }
  
  protected boolean a()
  {
    return k();
  }
  
  public void b()
  {
    a(0, 1, 15);
  }
  
  public void h()
  {
    ((com.go.weatherex.framework.fragment.a)getParentFragment()).h();
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.s = paramActivity;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.c)) {
      if (!k()) {
        h();
      }
    }
    do
    {
      return;
      if (paramView.equals(this.f))
      {
        this.f.setVisibility(8);
        this.l.setVisibility(0);
        b();
        return;
      }
    } while (!paramView.equals(this.h));
    this.g.setText("");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903137, paramViewGroup, false);
  }
  
  public void onDestroyView()
  {
    this.p = true;
    if (this.m != null) {
      this.m.b();
    }
    if (this.q != null) {
      this.q.a();
    }
    super.onDestroyView();
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (((paramInt == 3) || (paramInt == 6) || (paramInt == 0)) && (paramTextView.equals(this.g)))
    {
      if (paramInt == 0)
      {
        this.k += 1;
        if (this.k == Integer.MAX_VALUE) {
          this.k = 0;
        }
      }
      if ((this.k % 2 == 0) && (this.k != 0)) {
        return true;
      }
      o();
      return true;
    }
    return false;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramView.equals(this.g))
    {
      if (paramBoolean) {
        this.g.setHint("");
      }
    }
    else {
      return;
    }
    this.g.setHint(this.s.getString(2131165681));
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.b = new h();
    this.b.a(500L);
    this.c = c(2131231196);
    this.c.setOnClickListener(this);
    this.d = ((TextView)c(2131231145));
    this.f = ((ImageView)c(2131231889));
    this.f.setOnClickListener(this);
    this.l = ((ProgressBar)c(2131231890));
    this.g = ((EditText)c(2131231337));
    this.g.setOnEditorActionListener(this);
    this.g.setOnFocusChangeListener(this);
    this.g.addTextChangedListener(this.t);
    this.h = c(2131231338);
    this.h.setOnClickListener(this);
    this.h.setVisibility(8);
    this.e = ((ViewGroup)c(2131231339));
    this.i = new j(this.s, this, this.u);
    this.e.addView(this.i.a());
    this.j = new n(this.s, this, this.u, false);
    this.e.addView(this.j.a());
    this.m = new m(this.s);
    this.n = new g(this);
    this.o = new f(this.s.getContentResolver(), this);
    d();
    a(1);
    j();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */