package com.gtp.go.weather.sharephoto.takephoto;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;
import com.gau.go.launcherex.gowidget.weather.c.c;
import com.gau.go.launcherex.gowidget.weather.globalview.n;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.gau.go.launcherex.gowidget.weather.view.al;
import com.gtp.go.weather.sharephoto.UserPhotosActivity;
import com.gtp.go.weather.sharephoto.a.h;
import com.gtp.go.weather.sharephoto.b.e;
import com.gtp.go.weather.sharephoto.b.o;
import com.gtp.go.weather.sharephoto.c.l;
import com.jiubang.core.b.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PublishPhotoActivity
  extends GoWeatherEXActivity
  implements View.OnClickListener, View.OnFocusChangeListener, h
{
  private View a;
  private View b;
  private EditText c;
  private TextView d;
  private TextView e;
  private ImageView f;
  private View g;
  private n h;
  private ImageView i;
  private s j;
  private WeatherBean k;
  private List l;
  private String m;
  private boolean n = false;
  private al o;
  private SharedPreferences p;
  private final TextWatcher q = new v(this);
  private final com.gau.go.launcherex.gowidget.weather.service.a.g r = new w(this);
  
  public static Intent a(Context paramContext, s params)
  {
    paramContext = new Intent(paramContext, PublishPhotoActivity.class);
    r.a = params;
    return paramContext;
  }
  
  private void a()
  {
    Object localObject2 = this.c.getText().toString();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = this.p.edit();
    ((SharedPreferences.Editor)localObject2).putString("key_publish_photo_description", (String)localObject1);
    if (this.k != null) {
      ((SharedPreferences.Editor)localObject2).putString("key_publish_photo_city_id", this.k.c());
    }
    ((SharedPreferences.Editor)localObject2).commit();
  }
  
  private boolean b()
  {
    return true;
  }
  
  private void f()
  {
    if (this.n) {
      return;
    }
    this.n = true;
    i();
    com.gtp.go.weather.sharephoto.c.b localb = new com.gtp.go.weather.sharephoto.c.b(this);
    Object localObject = localb.c();
    if (this.k != null)
    {
      localb.b(this.k.c());
      ((e)localObject).c(this.k.d());
    }
    localb.c(this.c.getText().toString());
    localb.a(this.m);
    localObject = this.j.f();
    if (localObject != null) {
      ((ao)localObject).a(this.k);
    }
    localb.a(this.j);
    localObject = m.b();
    localb.a(((q)localObject).c());
    if ((((q)localObject).b() != null) && (((q)localObject).b().c().equals(localb.d()))) {
      localb.a(((q)localObject).a());
    }
    l.a(localb);
  }
  
  private void g()
  {
    int i1 = 5;
    Object localObject = e().getDisplayMetrics();
    int i4 = (int)(0.0F * ((DisplayMetrics)localObject).density);
    View localView;
    int i3;
    int i2;
    if (this.h == null)
    {
      localView = getLayoutInflater().inflate(2130903295, null);
      x localx = new x(this);
      ((ListView)localView.findViewById(2131231939)).setAdapter(localx);
      i3 = this.i.getHeight();
      i2 = localx.getCount();
      i3 = (int)(i3 / ((45.0F + 0.6F) * ((DisplayMetrics)localObject).density));
      if (i3 <= 5) {
        break label237;
      }
    }
    for (;;)
    {
      if (i1 > i2) {
        i1 = i2;
      }
      for (;;)
      {
        this.h = new n(this, localView, -1, (int)(i1 * (45.0F + 0.6F) * ((DisplayMetrics)localObject).density + 2.5F));
        this.h.a(new t(this));
        localObject = new int[2];
        this.g.getLocationInWindow((int[])localObject);
        this.h.a(this.g, -localObject[0], i4);
        this.f.setImageResource(2130838488);
        localObject = getCurrentFocus();
        if (localObject != null) {
          ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(((View)localObject).getWindowToken(), 2);
        }
        return;
      }
      label237:
      i1 = i3;
    }
  }
  
  private List h()
  {
    ArrayList localArrayList = new ArrayList();
    WeatherBean localWeatherBean1 = m.b().b();
    if (localWeatherBean1 != null) {
      localArrayList.add(localWeatherBean1);
    }
    Iterator localIterator = c.a(getApplicationContext()).h().d().iterator();
    while (localIterator.hasNext())
    {
      WeatherBean localWeatherBean2 = (WeatherBean)localIterator.next();
      if ((localWeatherBean1 == null) || (!localWeatherBean2.c().equals(localWeatherBean1.c()))) {
        localArrayList.add(localWeatherBean2);
      }
    }
    return localArrayList;
  }
  
  private void i()
  {
    if (!isFinishing())
    {
      if (this.o == null) {
        break label32;
      }
      if (!this.o.isShowing()) {
        this.o.show();
      }
    }
    return;
    label32:
    this.o = al.a(this);
    this.o.setCanceledOnTouchOutside(false);
    this.o.setOnKeyListener(new u(this));
    this.o.a(getString(2131166311));
    this.o.show();
  }
  
  private void j()
  {
    if ((!isFinishing()) && (this.o != null) && (this.o.isShowing()))
    {
      this.o.dismiss();
      this.o = null;
    }
  }
  
  private void k()
  {
    this.c.setText("");
  }
  
  private void l()
  {
    startActivity(new Intent(this, UserPhotosActivity.class));
  }
  
  public void a(WeatherBean paramWeatherBean)
  {
    this.k = paramWeatherBean;
    this.e.setText(paramWeatherBean.d());
  }
  
  public void a(o paramo)
  {
    this.m = paramo.a();
  }
  
  public void onBackPressed()
  {
    try
    {
      super.onBackPressed();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      finish();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.a)) {
      finish();
    }
    do
    {
      do
      {
        return;
        if (!paramView.equals(this.b)) {
          break;
        }
        if (!com.gau.go.launcherex.gowidget.d.g.a(getApplicationContext()))
        {
          Toast.makeText(this, getText(2131165656), 0).show();
          return;
        }
      } while (!b());
      f();
      return;
      if (paramView.equals(this.g))
      {
        g();
        return;
      }
    } while (!paramView.equals(this.d));
    k();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.j = r.a;
    if ((this.j == null) || (!this.j.h()))
    {
      finish();
      return;
    }
    paramBundle = com.gtp.go.weather.sharephoto.a.g.a(getApplicationContext());
    paramBundle.a(this);
    if (paramBundle.a()) {
      this.m = paramBundle.b().a();
    }
    l.a(this.r);
    setContentView(2130903294);
    this.a = findViewById(2131230796);
    this.b = findViewById(2131231933);
    this.c = ((EditText)findViewById(2131231934));
    this.d = ((TextView)findViewById(2131231935));
    this.e = ((TextView)findViewById(2131231937));
    this.f = ((ImageView)findViewById(2131231360));
    this.g = findViewById(2131231936);
    this.i = ((ImageView)findViewById(2131231938));
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.c.addTextChangedListener(this.q);
    this.c.setOnFocusChangeListener(this);
    this.c.clearFocus();
    this.p = GoWidgetApplication.c(getApplicationContext()).a();
    paramBundle = this.p.getString("key_publish_photo_description", "");
    if (!TextUtils.isEmpty(paramBundle))
    {
      this.c.setText(paramBundle);
      paramBundle = this.c.getText();
      if ((paramBundle instanceof Spannable)) {
        Selection.setSelection((Spannable)paramBundle, paramBundle.length());
      }
    }
    paramBundle = this.p.getString("key_publish_photo_city_id", "");
    if (TextUtils.isEmpty(paramBundle)) {
      paramBundle = this.j.g();
    }
    for (;;)
    {
      this.l = h();
      WeatherBean localWeatherBean1;
      WeatherBean localWeatherBean2;
      if (this.l.size() > 0)
      {
        localWeatherBean1 = (WeatherBean)this.l.get(0);
        Iterator localIterator = this.l.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localWeatherBean2 = (WeatherBean)localIterator.next();
        } while (!localWeatherBean2.c().equals(paramBundle));
      }
      for (paramBundle = localWeatherBean2;; paramBundle = localWeatherBean1)
      {
        a(paramBundle);
        return;
        this.e.setVisibility(4);
        return;
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    l.b(this.r);
    com.gtp.go.weather.sharephoto.a.g.a(getApplicationContext()).b(this);
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramView.equals(this.c))
    {
      if (paramBoolean) {
        this.c.setHint("");
      }
    }
    else {
      return;
    }
    this.c.setHint(2131166310);
  }
  
  protected void onStop()
  {
    super.onStop();
    a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/PublishPhotoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */