package com.gtp.go.weather.sharephoto;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListView;
import android.widget.TextSwitcher;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;
import com.gtp.go.weather.sharephoto.photo.ad;
import com.gtp.go.weather.sharephoto.takephoto.ab;
import java.io.File;
import uk.co.senab.photoview.PhotoView;

public class PhotoDetailActivity
  extends GoWeatherEXActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, CompoundButton.OnCheckedChangeListener
{
  private static final String M = com.gtp.a.a.c.c.a() + "/share/photo_for_share.jpg";
  private int A = -1;
  private Dialog B;
  private String C;
  private TranslateAnimation D;
  private TranslateAnimation E;
  private TranslateAnimation F;
  private TranslateAnimation G;
  private TranslateAnimation H;
  private com.gtp.go.weather.sharephoto.d.c I;
  private boolean J;
  private boolean K;
  private Runnable L = new e(this);
  private int a = 1;
  private PhotoView b;
  private uk.co.senab.photoview.b c;
  private ImageView d;
  private ImageView e;
  private View f;
  private View g;
  private TextSwitcher h;
  private View i;
  private ImageView j;
  private View k;
  private CheckBox l;
  private View m;
  private com.gau.go.launcherex.gowidget.weather.globalview.s n;
  private ad o;
  private ViewGroup p;
  private com.gtp.go.weather.sharephoto.d.p q;
  private long r = -1L;
  private boolean s;
  private boolean t = true;
  private boolean u = false;
  private t v;
  private Bitmap w;
  private Bitmap x;
  private int y;
  private com.gau.go.launcherex.gowidget.weather.globaltheme.d z;
  
  private void a(long paramLong)
  {
    this.o.a(this.r, new r(this));
  }
  
  private void a(View paramView)
  {
    if (paramView.getVisibility() != 0) {
      paramView.setVisibility(0);
    }
  }
  
  private void a(File paramFile)
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType("image/*");
    localIntent.putExtra("android.intent.extra.SUBJECT", getString(2131166363));
    localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(paramFile));
    localIntent.putExtra("android.intent.extra.TEXT", getString(2131166364, new Object[] { this.C }));
    try
    {
      startActivity(Intent.createChooser(localIntent, getString(2131165347)));
      return;
    }
    catch (ActivityNotFoundException paramFile)
    {
      Toast.makeText(getApplicationContext(), 2131165348, 0).show();
    }
  }
  
  private void a(String paramString)
  {
    if (Looper.getMainLooper().getThread() != Thread.currentThread())
    {
      runOnUiThread(new h(this, paramString));
      return;
    }
    Toast.makeText(this, paramString, 0).show();
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (this.s) {
      this.e.setSelected(true);
    }
    Object localObject = ab.a(this.r).getAbsolutePath() + File.separator + "photo_thumbnail_temporary.png";
    DisplayMetrics localDisplayMetrics = e().getDisplayMetrics();
    localObject = ab.a((String)localObject, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    if (localObject != null)
    {
      this.d.setVisibility(8);
      this.b.setImageBitmap((Bitmap)localObject);
    }
    new d(this, paramString1, paramString2).execute(new Void[0]);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    if (this.s) {
      this.e.setSelected(true);
    }
    paramString3 = com.gtp.go.weather.sharephoto.d.h.a(this, com.gtp.go.weather.sharephoto.d.j.a, paramString3);
    if (paramString3 != null)
    {
      this.d.setVisibility(8);
      this.b.setImageBitmap(paramString3);
    }
    paramString3 = new com.gtp.go.weather.sharephoto.d.b(this);
    this.I.a(com.gtp.go.weather.sharephoto.d.j.b, paramString1, paramString3, new s(this));
    if (!TextUtils.isEmpty(paramString2))
    {
      this.I.a(com.gtp.go.weather.sharephoto.d.j.c, paramString2, paramString3, new b(this));
      return;
    }
    this.K = true;
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    a(paramString, paramBoolean, true);
  }
  
  private void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.n == null)
    {
      this.n = new com.gau.go.launcherex.gowidget.weather.globalview.s(this);
      this.n.setCanceledOnTouchOutside(false);
      this.n.a(false);
      this.n.a(2130838478);
      this.n.setOnCancelListener(new g(this));
    }
    this.n.setCancelable(paramBoolean2);
    this.n.a(paramString);
    if ((paramBoolean1) && (!this.n.isShowing()) && (!isFinishing())) {
      this.n.show();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    switch (this.a)
    {
    default: 
      return;
    case 1: 
      i();
      c(paramBoolean);
      return;
    }
    i();
    b(paramBoolean);
  }
  
  private Bitmap b(View paramView)
  {
    if (!paramView.isDrawingCacheEnabled()) {
      paramView.setDrawingCacheEnabled(true);
    }
    try
    {
      paramView.buildDrawingCache();
      paramView = paramView.getDrawingCache();
      return paramView;
    }
    catch (OutOfMemoryError paramView)
    {
      paramView.printStackTrace();
    }
    return null;
  }
  
  private void b()
  {
    this.D = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    this.D.setDuration(this.y);
    this.D.setAnimationListener(new o(this));
    this.H = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    this.H.setDuration(this.y);
    this.H.setStartOffset(100L);
    this.H.setAnimationListener(new p(this));
    this.E = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    this.E.setDuration(this.y);
    this.F = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
    this.F.setDuration(this.y);
    this.F.setAnimationListener(new q(this));
    this.G = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
    this.G.setDuration(this.y);
  }
  
  private void b(long paramLong)
  {
    new c(this, paramLong).execute(new Long[] { Long.valueOf(paramLong) });
  }
  
  private void b(boolean paramBoolean)
  {
    this.c.a(ImageView.ScaleType.CENTER_CROP);
    this.c.f();
    e(paramBoolean);
  }
  
  private void c(long paramLong)
  {
    com.gtp.go.weather.sharephoto.c.d.a(getApplicationContext()).a(paramLong);
  }
  
  private void c(View paramView)
  {
    paramView.destroyDrawingCache();
    paramView.setDrawingCacheEnabled(false);
  }
  
  private void c(boolean paramBoolean)
  {
    this.c.a(ImageView.ScaleType.FIT_CENTER);
    this.c.f();
    d(paramBoolean);
    if (this.l.isChecked()) {
      this.l.setChecked(false);
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.h.setText(getString(2131166355));
      this.q.d();
      a(this.m);
      this.m.clearAnimation();
      this.m.startAnimation(this.H);
    }
    for (;;)
    {
      this.j.setImageResource(2130837749);
      return;
      this.h.setCurrentText(getString(2131166355));
      if (this.u) {
        this.e.setVisibility(0);
      }
      this.f.setVisibility(0);
      this.m.setVisibility(8);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.h.setText(getString(2131166375));
      this.q.c();
      a(this.m);
      this.m.clearAnimation();
      this.m.startAnimation(this.E);
    }
    for (;;)
    {
      this.j.setImageResource(2130838434);
      return;
      this.h.setCurrentText(getString(2131166375));
      this.e.setVisibility(8);
      this.f.setVisibility(8);
      this.m.setVisibility(0);
    }
  }
  
  private LayerDrawable f(boolean paramBoolean)
  {
    Object localObject = null;
    if (this.w != null)
    {
      localObject = new Drawable[2];
      localObject[0] = new BitmapDrawable(e(), this.w);
      if ((!paramBoolean) || (this.x == null)) {
        break label102;
      }
      localObject[1] = new BitmapDrawable(e(), this.x);
      localObject[1].setBounds(localObject[0].getBounds());
    }
    for (;;)
    {
      localObject = new LayerDrawable((Drawable[])localObject);
      ((LayerDrawable)localObject).setLayerInset(0, 0, 0, 0, 0);
      ((LayerDrawable)localObject).setLayerInset(1, 0, 0, 0, 0);
      return (LayerDrawable)localObject;
      label102:
      localObject[1] = new ColorDrawable(0);
    }
  }
  
  private void f()
  {
    this.e.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.f.setOnClickListener(this);
  }
  
  private void g()
  {
    if (this.t)
    {
      a(this.r);
      return;
    }
    b(this.r);
  }
  
  private void g(boolean paramBoolean)
  {
    if (this.B == null) {
      p();
    }
    boolean bool;
    if (!isFinishing())
    {
      bool = this.B.isShowing();
      if ((!paramBoolean) || (bool)) {
        break label42;
      }
      this.B.show();
    }
    label42:
    while ((paramBoolean) || (!bool)) {
      return;
    }
    this.B.dismiss();
  }
  
  private void h()
  {
    if ((this.J) && (this.K))
    {
      o();
      j();
      i();
    }
  }
  
  private void i()
  {
    if (this.a == 1) {}
    for (LayerDrawable localLayerDrawable = f(true);; localLayerDrawable = f(false))
    {
      if (localLayerDrawable != null)
      {
        this.b.setImageDrawable(localLayerDrawable);
        this.c.f();
      }
      return;
    }
  }
  
  private void j()
  {
    if (this.w == null)
    {
      Toast.makeText(this, 2131166359, 0).show();
      this.d.setVisibility(0);
    }
    do
    {
      try
      {
        this.d.setImageResource(2130838392);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
        return;
      }
      this.c.a(true);
      if (this.d.getVisibility() == 0) {
        this.d.setVisibility(4);
      }
    } while (this.a != 1);
    this.q.a(3000);
  }
  
  private boolean k()
  {
    if (this.w == null)
    {
      Toast.makeText(this, 2131166360, 0).show();
      return false;
    }
    return true;
  }
  
  private void l()
  {
    Bitmap localBitmap = b(this.b);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      new f(this).execute(new Bitmap[] { localBitmap });
      return;
    }
    a(getString(2131166378));
  }
  
  private void m()
  {
    if (this.z == null) {
      this.z = new com.gau.go.launcherex.gowidget.weather.globaltheme.d(getApplicationContext());
    }
    this.z.a(1, com.gau.go.launcherex.gowidget.weather.globaltheme.c.d.a(this));
  }
  
  private void n()
  {
    int i1 = this.A;
    this.a = i1;
    if (i1 != -1)
    {
      this.A = -1;
      a(true);
      return;
    }
    super.onBackPressed();
  }
  
  private void o()
  {
    if ((this.n != null) && (this.n.isShowing()) && (!isFinishing())) {
      this.n.dismiss();
    }
  }
  
  private void p()
  {
    com.gau.go.launcherex.gowidget.language.b localb = e();
    this.B = new Dialog(this, 2131492884);
    Object localObject = new ListView(this);
    ((ListView)localObject).setCacheColorHint(0);
    ((ListView)localObject).setBackgroundResource(2130838146);
    ((ListView)localObject).setDivider(localb.getDrawable(2130838147));
    ((ListView)localObject).setAdapter(new ArrayAdapter(this, 2130903297, com.gau.go.launcherex.gowidget.weather.util.c.i(this)));
    ((ListView)localObject).setOnItemClickListener(this);
    this.B.setContentView((View)localObject);
    localObject = this.B.getWindow();
    ((Window)localObject).clearFlags(134217728);
    ((Window)localObject).setGravity(53);
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
    localLayoutParams.x = 0;
    float f1 = localb.getDisplayMetrics().density;
    localLayoutParams.y = ((int)(localb.getDimension(2131427682) - f1 * 3.0F));
    localLayoutParams.width = ((int)localb.getDimension(2131427706));
    localLayoutParams.height = -2;
    ((Window)localObject).setAttributes(localLayoutParams);
    ((Window)localObject).setWindowAnimations(2131492876);
    this.B.setCanceledOnTouchOutside(true);
    this.B.setOnShowListener(new i(this));
    this.B.setOnDismissListener(new j(this));
  }
  
  private void q()
  {
    if (!k()) {
      return;
    }
    Bitmap localBitmap = null;
    if (this.x == null) {
      localBitmap = this.w;
    }
    while ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      new k(this).execute(new Bitmap[] { localBitmap });
      return;
      LayerDrawable localLayerDrawable = f(true);
      if (localLayerDrawable != null) {
        localBitmap = com.gtp.go.weather.sharephoto.d.h.a(localLayerDrawable);
      }
    }
    Toast.makeText(getApplicationContext(), 2131166366, 0).show();
  }
  
  private void r()
  {
    if (this.v != null)
    {
      unregisterReceiver(this.v);
      this.v = null;
    }
  }
  
  public void onBackPressed()
  {
    n();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.equals(this.l))
    {
      if (paramBoolean) {
        this.k.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.k.setVisibility(4);
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramView.equals(this.f)) {
      if (k())
      {
        this.A = 1;
        this.a = 2;
        a(true);
      }
    }
    label170:
    do
    {
      return;
      if (paramView.equals(this.e))
      {
        if (!this.e.isSelected())
        {
          this.s = bool1;
          this.e.setSelected(this.s);
          paramView = new com.gau.go.launcherex.gowidget.statistics.a.a(117);
          paramView.a(String.valueOf(this.r));
          if (!this.s) {
            break label170;
          }
          paramView.b("fs_exellent_add");
          com.gtp.go.weather.sharephoto.view.e.a(this, this.p);
          com.gau.go.launcherex.gowidget.statistics.r.a(getApplicationContext()).a(paramView);
        }
        for (;;)
        {
          paramView = new com.gtp.go.weather.sharephoto.b.g();
          paramView.a(this.r);
          paramView.a(this.s);
          com.gtp.go.weather.sharephoto.c.d.a(getApplicationContext()).a(paramView);
          return;
          bool1 = false;
          break;
          paramView.b("fs_exellent_minus");
          com.gtp.go.weather.sharephoto.view.e.b(this, this.p);
          com.gau.go.launcherex.gowidget.statistics.r.a(getApplicationContext()).a(paramView);
        }
      }
      if (paramView.equals(this.j))
      {
        this.j.removeCallbacks(this.L);
        this.j.postDelayed(this.L, 50L);
        return;
      }
      if (paramView.equals(this.i))
      {
        n();
        return;
      }
    } while (!paramView.equals(this.m));
    paramView = this.l;
    if (!this.l.isChecked()) {}
    for (bool1 = bool2;; bool1 = false)
    {
      paramView.setChecked(bool1);
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.p = ((ViewGroup)getLayoutInflater().inflate(2130903043, null));
    setContentView(this.p);
    getWindow().clearFlags(134217728);
    this.I = new com.gtp.go.weather.sharephoto.d.c(this);
    this.b = ((PhotoView)findViewById(2131230800));
    this.d = ((ImageView)findViewById(2131230799));
    this.e = ((ImageView)findViewById(2131230803));
    this.g = findViewById(2131230801);
    this.h = ((TextSwitcher)findViewById(2131230797));
    this.h.setFactory(new a(this));
    this.h.setInAnimation(this, 2130968614);
    this.h.setOutAnimation(this, 2130968615);
    this.i = findViewById(2131230796);
    this.j = ((ImageView)findViewById(2131230802));
    this.k = findViewById(2131230804);
    this.l = ((CheckBox)findViewById(2131230807));
    this.l.setClickable(false);
    this.m = findViewById(2131230806);
    this.l.setOnCheckedChangeListener(this);
    this.f = findViewById(2131230805);
    f();
    this.o = new ad(this);
    this.y = e().getInteger(17694720);
    this.c = new uk.co.senab.photoview.b(this.b);
    this.c.a(false);
    this.c.a(new l(this));
    this.u = com.gtp.go.weather.sharephoto.d.n.a(getApplicationContext());
    if (!this.u)
    {
      this.e.setVisibility(8);
      paramBundle = new IntentFilter("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_CHANGE_USER_DATA");
      this.v = new t(this);
      registerReceiver(this.v, paramBundle);
    }
    paramBundle = new m(this);
    this.e.setOnTouchListener(paramBundle);
    this.f.setOnTouchListener(paramBundle);
    this.q = new com.gtp.go.weather.sharephoto.d.p(this);
    this.q.a();
    this.q.a(new n(this));
    b();
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      long l1 = paramBundle.getLongExtra("extra_photo_id", -1L);
      this.r = l1;
      if (l1 != -1L)
      {
        this.t = paramBundle.getBooleanExtra("extra_photo_isuploaded", true);
        this.a = paramBundle.getIntExtra("extra_enter_type", 1);
        a(false);
        g();
        return;
      }
    }
    finish();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    r();
    this.I.a();
    if ((this.x != null) && (!this.x.isRecycled()))
    {
      this.x.recycle();
      this.x = null;
    }
    if ((this.w != null) && (!this.w.isRecycled()))
    {
      this.w.recycle();
      this.w = null;
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt == 0) {
      q();
    }
    for (;;)
    {
      g(false);
      return;
      if (paramInt == 1)
      {
        paramAdapterView = new Intent(this, PhotoReportActivity.class);
        paramAdapterView.putExtra("photo_id", this.r);
        startActivity(paramAdapterView);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/PhotoDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */