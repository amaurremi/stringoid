package com.gtp.go.weather.sharephoto.takephoto;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.service.a.g;
import com.gtp.go.weather.sharephoto.c.l;
import com.jiubang.ggheart.apps.desks.diy.filter.core.FilterParameter;
import com.jiubang.ggheart.apps.desks.diy.filter.core.FilterParameterBuidler;
import com.jiubang.ggheart.apps.desks.diy.filter.core.FilterService;
import java.io.File;

public class EditPhotoActivity
  extends GoWeatherEXActivity
  implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener, ag, i
{
  private View a;
  private View b;
  private View c;
  private View d;
  private PhotoPreview e;
  private WatermarkPreview f;
  private PreviewLayout g;
  private File h;
  private int i = 1;
  private String j;
  private String k;
  private d l;
  private ad m;
  private Bitmap n;
  private volatile int o = -1;
  private volatile int p;
  private volatile int q = 0;
  private c r;
  private final FilterParameter s = FilterParameterBuidler.createFilterParameter(0);
  private FilterParameter t = this.s;
  private FilterService u;
  private boolean v = false;
  private boolean w = false;
  private final g x = new b(this);
  
  public static Intent a(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    paramContext = new Intent(paramContext, EditPhotoActivity.class);
    paramContext.putExtra("intent_key_way_to_get_photo", paramInt);
    paramContext.putExtra("intent_key_get_photo_app_package_name", paramString1);
    paramContext.putExtra("intent_key_get_photo_activity_class_name", paramString2);
    return paramContext;
  }
  
  private void a()
  {
    Intent localIntent = getIntent();
    this.i = localIntent.getIntExtra("intent_key_way_to_get_photo", 1);
    this.j = localIntent.getStringExtra("intent_key_get_photo_app_package_name");
    this.k = localIntent.getStringExtra("intent_key_get_photo_activity_class_name");
    this.u = FilterService.getService(getApplicationContext());
    m.a(getApplicationContext());
    setContentView(2130903283);
    getWindow().setFormat(-3);
    getWindow().clearFlags(134217728);
    this.a = findViewById(2131230796);
    this.b = findViewById(2131231902);
    this.c = findViewById(2131231909);
    this.d = findViewById(2131231908);
    this.g = ((PreviewLayout)findViewById(2131231670));
    this.e = this.g.a();
    this.f = this.g.b();
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setVisibility(0);
    f();
    l.a(this.x);
    this.h = ab.a(this);
    if (!this.h.exists())
    {
      m();
      return;
    }
    b();
  }
  
  private void a(s params)
  {
    startActivity(PublishPhotoActivity.a(this, params));
  }
  
  private void b()
  {
    this.v = true;
    this.q = ab.a(this.h.getAbsolutePath());
    com.gtp.a.a.b.c.a("EditPhotoActivity", "mPhotoAngle: " + this.q);
    this.l.a(g());
    this.l.a();
    this.e.getViewTreeObserver().addOnGlobalLayoutListener(this);
    this.e.requestLayout();
    SharedPreferences.Editor localEditor = GoWidgetApplication.c(getApplicationContext()).a().edit();
    localEditor.remove("key_publish_photo_description");
    localEditor.remove("key_publish_photo_city_id");
    localEditor.commit();
  }
  
  private void b(FilterParameter paramFilterParameter)
  {
    if (paramFilterParameter.getTypeId() == this.s.getTypeId()) {}
    for (this.t = this.s;; this.t = FilterParameterBuidler.createFilterParameter(paramFilterParameter.getTypeId()))
    {
      this.t.mSrcBitmap = this.n;
      if (this.r != null) {
        this.r.cancel(true);
      }
      this.r = new c(this, null);
      this.r.execute(new FilterParameter[] { this.t });
      return;
    }
  }
  
  private void f()
  {
    j();
    if (this.l == null)
    {
      this.l = new d(this, findViewById(2131231905), this.u);
      this.l.a(this);
      this.l.a(g());
      this.l.c(0);
    }
    this.d.setSelected(true);
    this.l.b(0);
  }
  
  private Bitmap g()
  {
    if (this.v)
    {
      int i1 = (int)(46.0F * e().getDisplayMetrics().density);
      return ab.a(ab.a(i1, i1, this.h), this.q);
    }
    return null;
  }
  
  private void h()
  {
    if (this.l != null)
    {
      this.d.setSelected(false);
      this.l.b(4);
    }
  }
  
  private void i()
  {
    h();
    if (this.m == null)
    {
      this.m = new ad(this, ((ViewStub)findViewById(2131231906)).inflate());
      this.m.a(this);
      this.m.c(1);
    }
    this.m.b(0);
    this.c.setSelected(true);
  }
  
  private void j()
  {
    if (this.m != null)
    {
      this.c.setSelected(false);
      this.m.b(4);
    }
  }
  
  private void k()
  {
    if (this.n == null) {
      return;
    }
    s locals = new s();
    locals.a(this.h.getAbsolutePath());
    locals.d(this.t.getTypeId());
    locals.a(this.f.a());
    locals.a(this.q);
    locals.b(this.f.getHeight());
    locals.c(this.f.getWidth());
    WeatherBean localWeatherBean = m.b().b();
    if (localWeatherBean != null) {
      locals.b(localWeatherBean.c());
    }
    a(locals);
  }
  
  private void l()
  {
    if ((this.g.getWidth() == 0) || (this.g.getHeight() == 0)) {
      return;
    }
    this.o = this.g.getWidth();
    this.p = this.g.getHeight();
    if ((this.p > 800) || (this.o > 800))
    {
      int i1 = com.gtp.a.a.c.a.a();
      com.gtp.a.a.b.c.a("EditPhotoActivity", "deviceLevel: " + i1);
      float f1 = (4 - i1) * 0.15F + 0.35F;
      this.o = ((int)(this.o * f1));
      this.p = ((int)(f1 * this.p));
    }
    b(this.l.b());
    this.e.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
  
  private void m()
  {
    this.v = false;
    switch (this.i)
    {
    default: 
      throw new IllegalStateException("some thing unexpected happen...");
    case 1: 
      n();
      return;
    }
    o();
  }
  
  private void n()
  {
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    localIntent.setType("image/*");
    localIntent.putExtra("output", Uri.fromFile(this.h));
    localIntent.setComponent(new ComponentName(this.j, this.k));
    if (localIntent.resolveActivity(getPackageManager()) != null) {
      startActivityForResult(localIntent, 101);
    }
  }
  
  private void o()
  {
    Intent localIntent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    localIntent.setType("image/*");
    localIntent.setComponent(new ComponentName(this.j, this.k));
    if (localIntent.resolveActivity(getPackageManager()) != null) {
      startActivityForResult(localIntent, 102);
    }
  }
  
  public void a(int paramInt)
  {
    this.f.a(paramInt);
  }
  
  public void a(FilterParameter paramFilterParameter)
  {
    if (this.v) {
      b(paramFilterParameter);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    com.gtp.a.a.b.c.a("EditPhotoActivity", "onActivityResult" + hashCode());
    switch (paramInt1)
    {
    default: 
      return;
    case 101: 
      if ((paramInt2 == -1) && (this.h.exists()))
      {
        b();
        return;
      }
      if (paramInt2 != 0) {
        Toast.makeText(this, getString(2131166319), 0).show();
      }
      finish();
      return;
    }
    if (paramInt2 == -1)
    {
      paramIntent = paramIntent.getData();
      if (paramIntent != null)
      {
        paramIntent = getContentResolver().query(paramIntent, new String[] { "_data" }, null, null, null);
        if ((paramIntent != null) && (paramIntent.moveToFirst()))
        {
          String str = paramIntent.getString(paramIntent.getColumnIndex("_data"));
          if (!TextUtils.isEmpty(str)) {
            com.jiubang.goweather.e.a.a(new File(str), this.h, Boolean.valueOf(true));
          }
          if (paramIntent != null) {
            paramIntent.close();
          }
        }
      }
    }
    if (this.h.exists())
    {
      b();
      return;
    }
    if (paramInt2 != 0) {
      Toast.makeText(this, getString(2131166319), 0).show();
    }
    finish();
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
      return;
      if (paramView.equals(this.b))
      {
        k();
        return;
      }
      if (paramView.equals(this.c))
      {
        i();
        return;
      }
    } while (!paramView.equals(this.d));
    f();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.gtp.a.a.b.c.a("EditPhotoActivity", "onCreate" + hashCode());
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    com.gtp.a.a.b.c.a("EditPhotoActivity", "onDestroy" + hashCode());
    FilterService.destroy();
    if (this.l != null) {
      this.l.c();
    }
    if (this.m != null) {
      this.m.a();
    }
    l.b(this.x);
  }
  
  public void onGlobalLayout()
  {
    if (this.o == -1) {
      l();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    com.gtp.a.a.b.c.a("EditPhotoActivity", "onPause" + hashCode());
    if (isFinishing()) {
      l.b(this.x);
    }
  }
  
  protected void onRestart()
  {
    super.onRestart();
    com.gtp.a.a.b.c.a("EditPhotoActivity", "onRestart" + hashCode());
  }
  
  protected void onResume()
  {
    super.onResume();
    com.gtp.a.a.b.c.a("EditPhotoActivity", "onResume" + hashCode());
  }
  
  protected void onStart()
  {
    super.onStart();
    com.gtp.a.a.b.c.a("EditPhotoActivity", "onStart" + hashCode());
  }
  
  protected void onStop()
  {
    super.onStop();
    com.gtp.a.a.b.c.a("EditPhotoActivity", "onStop" + hashCode());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/EditPhotoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */