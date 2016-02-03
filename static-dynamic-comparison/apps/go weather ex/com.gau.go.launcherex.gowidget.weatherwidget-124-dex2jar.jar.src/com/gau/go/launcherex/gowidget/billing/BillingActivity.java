package com.gau.go.launcherex.gowidget.billing;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.a.l;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.googleplay.IabHelper;
import com.gau.go.launcherex.gowidget.googleplay.IabHelper.OnIabPurchaseFinishedListener;
import com.gau.go.launcherex.gowidget.googleplay.IabResult;
import com.gau.go.launcherex.gowidget.googleplay.Purchase;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;
import com.gau.go.launcherex.gowidget.messagecenter.util.aj;
import com.gau.go.launcherex.gowidget.messagecenter.util.ak;
import com.gau.go.launcherex.gowidget.weather.scroller.AnimViewScrollGroup;
import com.gau.go.launcherex.gowidget.weather.view.AgreementActivity;
import com.gau.go.launcherex.gowidget.weather.view.Indicator;
import com.gau.go.launcherex.gowidget.weather.view.ViewPage;
import com.gau.go.launcherex.gowidget.weather.view.WeatherDetailActivity;
import com.gau.go.launcherex.gowidget.weather.view.al;
import com.gau.go.launcherex.gowidget.weather.view.bb;
import com.getjar.sdk.GetjarClient;
import com.getjar.sdk.GetjarLicense.Scope;
import com.getjar.sdk.GetjarLicense.State;
import com.google.analytics.tracking.android.EasyTracker;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

public class BillingActivity
  extends GoWeatherEXActivity
  implements DialogInterface.OnDismissListener, View.OnClickListener, AdapterView.OnItemClickListener, t, IabHelper.OnIabPurchaseFinishedListener, ak, com.gau.go.launcherex.gowidget.weather.scroller.a
{
  private boolean A = false;
  private String B = "";
  private aj C;
  private Dialog D;
  private int E = -1;
  private boolean F;
  private u G;
  private boolean H;
  private View I;
  private bb J;
  private View K;
  private ImageButton L;
  private Animation M;
  private Animation N;
  private int O;
  private ListView P;
  private Dialog Q = null;
  private View R;
  private LinearLayout S;
  private View T;
  private ViewStub U;
  private ViewStub V;
  private al W;
  private com.gau.go.launcherex.gowidget.a.g X;
  private boolean Y;
  private Runnable Z = new c(this);
  private r a;
  private l aa = new h(this);
  private com.gau.go.launcherex.gowidget.a.i ab = new i(this);
  private com.gau.go.launcherex.gowidget.a.k ac = new j(this);
  private com.gau.go.launcherex.gowidget.a.j ad = new b(this);
  private View b;
  private View c;
  private View d;
  private Indicator e;
  private TextView f;
  private LayoutInflater g;
  private int h;
  private int i;
  private Handler j;
  private n k;
  private Dialog l;
  private p m;
  private SharedPreferences n = null;
  private volatile Map o;
  private int p = 75;
  private boolean q = false;
  private Intent r = null;
  private boolean s = false;
  private ConcurrentLinkedQueue t = new ConcurrentLinkedQueue();
  private com.gau.go.launcherex.gowidget.statistics.p u;
  private int v;
  private int w;
  private AnimViewScrollGroup x;
  private GetjarClient y;
  private com.gau.go.launcherex.gowidget.weather.d.f z;
  
  private String a(com.gau.go.launcherex.gowidget.messagecenter.a.f paramf)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    long l1 = paramf.a();
    long l2 = paramf.b();
    Object localObject = new SimpleDateFormat("yyyy/MM/dd", Locale.US);
    paramf = ((SimpleDateFormat)localObject).format(new Date(l1));
    localObject = ((SimpleDateFormat)localObject).format(new Date(l2));
    localStringBuffer.append(paramf).append(" - ").append((String)localObject);
    return localStringBuffer.toString();
  }
  
  private void a(Intent paramIntent)
  {
    boolean bool = this.z.b();
    if (paramIntent != null)
    {
      this.H = paramIntent.getBooleanExtra("extra_goto_main_activity", false);
      this.E = paramIntent.getIntExtra("recommend_type", -1);
      this.v = paramIntent.getIntExtra("recommend_enterance", -1);
      if ((this.v != -1) && (!bool)) {
        this.u.a(new com.gau.go.launcherex.gowidget.statistics.o(this.v, 1, 0, 0, 0, 0));
      }
    }
  }
  
  private void a(ViewPage paramViewPage)
  {
    if (paramViewPage.d() == 7)
    {
      this.x.addView(paramViewPage, 0);
      return;
    }
    this.x.addView(paramViewPage);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (this.m == null)
    {
      Object localObject = this.g.inflate(2130903251, null);
      this.m = new p(this, null);
      this.m.a = ((TextView)((View)localObject).findViewById(2131230797));
      this.m.b = ((TextView)((View)localObject).findViewById(2131231796));
      this.l = new Dialog(this, 2131492872);
      this.l.setOnDismissListener(this);
      this.l.setContentView((View)localObject);
      localObject = this.l.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).height = -1;
      ((WindowManager.LayoutParams)localObject).width = -1;
    }
    if (!TextUtils.isEmpty(paramString1)) {
      this.m.a.setText(paramString1);
    }
    this.m.b.setText(paramString2);
    if ((!isFinishing()) && (!this.l.isShowing())) {
      this.l.show();
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("developer_product_id"))) {
      this.X.a();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.Q == null) {
        m();
      }
      if (!this.Q.isShowing()) {
        this.Q.show();
      }
    }
    while ((this.Q == null) || (!this.Q.isShowing())) {
      return;
    }
    this.Q.dismiss();
  }
  
  private void b(String paramString1, String paramString2)
  {
    if (Looper.getMainLooper().getThread() != Thread.currentThread())
    {
      runOnUiThread(new f(this, paramString1, paramString2));
      return;
    }
    a(paramString1, paramString2);
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.U != null)
      {
        this.I = this.U.inflate();
        this.U = null;
        f();
      }
      this.I.setVisibility(0);
      this.I.startAnimation(this.M);
      if (this.K != null)
      {
        this.K.setVisibility(8);
        this.K.startAnimation(this.N);
      }
      return;
    }
    if ((this.V != null) && (this.V.getParent() != null))
    {
      this.K = this.V.inflate();
      this.V = null;
      this.J = new bb(this, this.K);
      this.J.a(this);
      this.J.a(this.A);
      this.J.a(this.z.c(), this.z.b());
    }
    if (this.I != null)
    {
      this.I.setVisibility(8);
      this.I.startAnimation(this.N);
    }
    this.K.setVisibility(0);
    this.K.startAnimation(this.M);
  }
  
  private boolean b(ArrayList paramArrayList)
  {
    String str = "";
    if (paramArrayList.contains("go_weather_ex_premium_pack_vip")) {
      str = "go_weather_ex_premium_pack_vip";
    }
    while (!"".equals(str))
    {
      if (this.z.a(str, true)) {
        this.z.b(str);
      }
      return true;
      if (paramArrayList.contains("go_weather_ex_premium_pack_vip_promo")) {
        str = "go_weather_ex_premium_pack_vip_promo";
      }
    }
    return false;
  }
  
  private boolean b(JSONObject paramJSONObject)
  {
    boolean bool = GetjarLicense.State.ACQUIRED.name().equals(paramJSONObject.getString("license_state"));
    paramJSONObject = paramJSONObject.getString("developer_product_id");
    if (paramJSONObject == null) {}
    while ((!paramJSONObject.equals("goweatherex_getjar_id")) || (!bool)) {
      return false;
    }
    return true;
  }
  
  private boolean c(ArrayList paramArrayList)
  {
    String str = "";
    if (paramArrayList.contains("go_weather_ex_premium_pack_theme_vip")) {
      str = "go_weather_ex_premium_pack_theme_vip";
    }
    while (!"".equals(str))
    {
      if (this.z.a(str, true)) {
        this.z.b(str);
      }
      return true;
      if (paramArrayList.contains("go_weather_ex_premium_pack_theme_vip_promo")) {
        str = "go_weather_ex_premium_pack_theme_vip_promo";
      }
    }
    return false;
  }
  
  private int d(int paramInt)
  {
    int i1 = i(paramInt);
    int i2 = this.x.getChildCount();
    paramInt = 0;
    while (paramInt < i2)
    {
      if (((ViewPage)this.x.getChildAt(paramInt)).d() == i1) {
        return paramInt;
      }
      paramInt += 1;
    }
    return 0;
  }
  
  private boolean d(ArrayList paramArrayList)
  {
    String str = "";
    if (paramArrayList.contains("com.gau.go.launcherex.gowidget.weatherwidge.billingpay1")) {
      str = "com.gau.go.launcherex.gowidget.weatherwidge.billingpay1";
    }
    while (!"".equals(str))
    {
      if (this.z.a(str, true))
      {
        this.z.b(str);
        g();
      }
      return true;
      if (paramArrayList.contains("go_weather_ex_premium_pack_promotions")) {
        str = "go_weather_ex_premium_pack_promotions";
      }
    }
    return false;
  }
  
  private void e(int paramInt)
  {
    if (!this.F)
    {
      this.F = true;
      this.O = 1;
      this.w = paramInt;
      this.u.a(new com.gau.go.launcherex.gowidget.statistics.o(this.v, 0, 0, this.w, 1, 0));
      j();
    }
  }
  
  private void f()
  {
    this.b = findViewById(2131230817);
    this.c = findViewById(2131230818);
    this.d = findViewById(2131230821);
    this.I = findViewById(2131231678);
    this.L = ((ImageButton)findViewById(2131230815));
    this.T = findViewById(2131230820);
    if (this.G.b())
    {
      this.L.setVisibility(0);
      if (!this.z.b()) {
        break label506;
      }
      this.b.setVisibility(8);
      label106:
      this.e = ((Indicator)findViewById(2131230816));
      this.f = ((TextView)findViewById(2131230813));
      this.f.getPaint().setFlags(8);
      this.x = ((AnimViewScrollGroup)findViewById(2131230814));
      this.x.a(true);
      this.e = ((Indicator)findViewById(2131230816));
      this.e.a(2130837545, 2130837544);
      this.c.setOnClickListener(this);
      this.d.setOnClickListener(this);
      this.L.setOnClickListener(this);
      this.f.setOnClickListener(this);
      com.gau.go.launcherex.gowidget.weather.view.k localk = new com.gau.go.launcherex.gowidget.weather.view.k(this);
      if ((this.A) && (!this.z.b()))
      {
        ViewPage localViewPage = localk.a(7);
        localViewPage.a(this.B);
        a(localViewPage);
      }
      if (!this.z.a(8)) {
        a(localk.a(0));
      }
      if ((GoWidgetApplication.a) && (com.gau.go.launcherex.gowidget.weather.util.f.a(getApplicationContext()).j())) {
        a(localk.a(8));
      }
      a(localk.a(2));
      a(localk.a(1));
      a(localk.a(4));
      a(localk.a(3));
      a(localk.a(5));
      a(localk.a(6));
      this.x.a();
      this.x.a(this);
      this.e.a(this.x.getChildCount());
      this.e.c((int)(10.0F * e().getDisplayMetrics().density));
      this.e.b(0);
      if (this.E == -1) {
        break label565;
      }
    }
    label506:
    label553:
    label565:
    for (this.i = d(this.E);; this.i = 0)
    {
      ((ViewPage)this.x.getChildAt(this.i)).a();
      this.h = this.i;
      this.x.a(this.i);
      return;
      this.L.setVisibility(8);
      break;
      if (this.A) {
        this.T.setVisibility(0);
      }
      for (;;)
      {
        if (!this.G.a()) {
          break label553;
        }
        this.d.setVisibility(0);
        break;
        this.T.setVisibility(4);
      }
      this.d.setVisibility(8);
      break label106;
    }
  }
  
  private void f(int paramInt)
  {
    if (!this.F)
    {
      this.F = true;
      this.O = 2;
      this.w = paramInt;
      this.u.a(new com.gau.go.launcherex.gowidget.statistics.o(this.v, 0, 0, this.w, 1, 0));
      j();
    }
  }
  
  private void g()
  {
    if (this.D == null)
    {
      View localView = this.g.inflate(2130903078, null);
      Button localButton = (Button)localView.findViewById(2131231078);
      this.D = new Dialog(this, 2131492872);
      this.D.setContentView(localView);
      localButton.setOnClickListener(new d(this));
      this.D.setOnKeyListener(new e(this));
    }
    if ((!isFinishing()) && (!this.D.isShowing())) {
      this.D.show();
    }
  }
  
  private void g(int paramInt)
  {
    if (!this.F)
    {
      this.F = true;
      this.O = 3;
      this.w = paramInt;
      this.u.a(new com.gau.go.launcherex.gowidget.statistics.o(this.v, 0, 0, this.w, 1, 0));
      j();
    }
  }
  
  private void h()
  {
    this.w = 1;
    this.u.a(new com.gau.go.launcherex.gowidget.statistics.o(this.v, 0, 0, this.w, 1, 0));
    if (!this.q)
    {
      b(getString(2131166028), getString(2131166054));
      this.j.sendEmptyMessageDelayed(1, 1000L);
    }
  }
  
  private void h(int paramInt)
  {
    startActivityForResult(this.y.getPurchaseIntent("goweatherex_getjar_id", getString(2131165319), getString(2131166032), paramInt, GetjarLicense.Scope.USER), 908);
  }
  
  private int i(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 1;
    case 4: 
      return 5;
    case 3: 
      return 4;
    case 2: 
      return 3;
    }
    return 8;
  }
  
  private void i()
  {
    if ((this.l != null) && (this.l.isShowing()) && (!isFinishing()))
    {
      if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
        break label49;
      }
      runOnUiThread(new g(this));
    }
    label49:
    while (isFinishing()) {
      return;
    }
    this.l.dismiss();
  }
  
  private void j()
  {
    b(getString(2131166029), getString(2131166054));
    this.a.a(this);
  }
  
  private String k()
  {
    switch (this.O)
    {
    default: 
      return "";
    case 1: 
      if (this.A) {
        return "go_weather_ex_premium_pack_promotions";
      }
      return "com.gau.go.launcherex.gowidget.weatherwidge.billingpay1";
    case 3: 
      if (this.A) {
        return "go_weather_ex_premium_pack_theme_vip_promo";
      }
      return "go_weather_ex_premium_pack_theme_vip";
    }
    if (this.A) {
      return "go_weather_ex_premium_pack_vip_promo";
    }
    return "go_weather_ex_premium_pack_vip";
  }
  
  private void l()
  {
    Intent localIntent = getIntent();
    localIntent.setClass(this, WeatherDetailActivity.class);
    startActivity(localIntent);
    finish();
  }
  
  private void m()
  {
    this.R = this.g.inflate(2130903320, null);
    this.S = ((LinearLayout)this.R.findViewById(2131231975));
    if (this.G.a()) {
      this.S.setBackgroundResource(2130838928);
    }
    Window localWindow;
    for (;;)
    {
      this.P = ((ListView)this.R.findViewById(2131231976));
      this.P.setOnItemClickListener(this);
      this.P.setAdapter(new o(this));
      this.Q = new Dialog(this, 2131492884);
      this.Q.setContentView(this.R);
      this.Q.setCanceledOnTouchOutside(true);
      localWindow = this.Q.getWindow();
      localWindow.clearFlags(134217728);
      localWindow.setGravity(49);
      DisplayMetrics localDisplayMetrics = e().getDisplayMetrics();
      float f1 = localDisplayMetrics.density;
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.x = 0;
      localLayoutParams.y = (Math.max(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) - (int)(f1 * 361.0F));
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      if (!this.G.a()) {
        break;
      }
      localWindow.setWindowAnimations(2131492877);
      return;
      this.S.setBackgroundResource(2130838929);
    }
    localWindow.setWindowAnimations(2131492878);
  }
  
  public void a()
  {
    i();
    r.a(this, getString(2131166043));
    this.F = false;
  }
  
  public void a(int paramInt)
  {
    this.j.removeCallbacks(this.Z);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.e.b(paramInt1);
  }
  
  public void a(ArrayList paramArrayList)
  {
    int i2 = 1;
    int i1;
    if (b(paramArrayList))
    {
      this.F = false;
      i1 = 0;
      if (i1 == 0) {
        break label131;
      }
      paramArrayList = k();
      if ("".equals(paramArrayList)) {
        break label123;
      }
      this.a.a().launchPurchaseFlow(this, paramArrayList, 100, this);
    }
    for (;;)
    {
      i();
      return;
      i1 = i2;
      switch (this.O)
      {
      case 2: 
      default: 
        i1 = 0;
        break;
      case 1: 
        i1 = i2;
        if (!d(paramArrayList)) {
          break;
        }
        i1 = 0;
        break;
      case 3: 
        i1 = i2;
        if (!c(paramArrayList)) {
          break;
        }
        i1 = 0;
        break;
        label123:
        this.F = false;
        continue;
        label131:
        this.F = false;
      }
    }
  }
  
  public void a(List paramList)
  {
    if ((this.W.isShowing()) && (!this.Y)) {
      this.W.dismiss();
    }
    if (!paramList.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      this.A = bool;
      if (this.A) {
        this.B = a((com.gau.go.launcherex.gowidget.messagecenter.a.f)paramList.get(0));
      }
      if (this.E != 6) {
        break;
      }
      b(false);
      return;
    }
    b(true);
  }
  
  public void b()
  {
    this.y.connect();
  }
  
  public void b(int paramInt)
  {
    if (this.h != paramInt) {
      ((ViewPage)this.x.getChildAt(this.h)).b();
    }
    ViewPage localViewPage = (ViewPage)this.x.getChildAt(paramInt);
    if (this.i != paramInt)
    {
      this.i = paramInt;
      this.h = paramInt;
      localViewPage.a();
    }
    this.j.postDelayed(this.Z, localViewPage.c());
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.w == 1) {
      switch (paramInt1)
      {
      }
    }
    IabHelper localIabHelper;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramInt2 != -1);
        b(null, getString(2131166055));
        this.y.connect();
        return;
      } while (paramInt2 != -1);
      this.X.a(paramIntent);
      return;
      localIabHelper = this.a.a();
    } while ((localIabHelper == null) || (localIabHelper.handleActivityResult(paramInt1, paramInt2, paramIntent)));
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.c)) {
      if ((this.G.b()) && (!this.z.c()) && (!this.z.d()))
      {
        this.u.a(new com.gau.go.launcherex.gowidget.statistics.o(this.v, 0, 0, 5, 1, 0));
        a(true);
      }
    }
    do
    {
      do
      {
        return;
        e(2);
        return;
        if (paramView.equals(this.d))
        {
          if (com.gau.go.launcherex.gowidget.weather.util.r.c(this))
          {
            this.s = true;
            h();
            return;
          }
          Toast.makeText(this, 2131165748, 0).show();
          return;
        }
        if (paramView.equals(this.f))
        {
          startActivity(new Intent(this, AgreementActivity.class));
          return;
        }
        if (paramView.equals(this.L))
        {
          b(false);
          return;
        }
      } while (this.J == null);
      if (paramView.equals(this.J.a))
      {
        b(true);
        return;
      }
      if ((paramView.equals(this.J.b)) || (paramView.equals(this.J.d)))
      {
        g(3);
        return;
      }
    } while (!paramView.equals(this.J.c));
    f(4);
  }
  
  @SuppressLint({"HandlerLeak"})
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903213);
    this.X = com.gau.go.launcherex.gowidget.a.g.a(this);
    this.y = this.X.c();
    this.X.a(getIntent());
    this.X.a(this.ab);
    this.X.a(this.aa);
    this.X.a(this.ac);
    this.X.a(this.ad);
    this.U = ((ViewStub)findViewById(2131231677));
    this.V = ((ViewStub)findViewById(2131231679));
    getWindow().clearFlags(134217728);
    getWindow().setFormat(-3);
    this.g = getLayoutInflater();
    this.z = com.gau.go.launcherex.gowidget.weather.c.c.a(getApplicationContext()).e();
    this.a = new r(getApplicationContext());
    this.G = new u(this);
    this.n = GoWidgetApplication.c(getApplicationContext()).a();
    this.u = new com.gau.go.launcherex.gowidget.statistics.p(getApplicationContext());
    this.C = new aj(this);
    this.M = new AlphaAnimation(0.0F, 1.0F);
    this.M.setDuration(250L);
    this.N = new AlphaAnimation(1.0F, 0.0F);
    this.N.setDuration(250L);
    this.k = new n(this, null);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.gau.go.launcherex.gowidget.weatherwidget.PURCHASE_CHANGE");
    paramBundle.addAction("com.gau.go.launcherex.gowidget.weatherwidget.PRODUCT_THEME_VIP_PURCHASE_STATE_CHANGE_ACTION");
    registerReceiver(this.k, paramBundle);
    a(getIntent());
    this.C.a(this);
    this.W = al.a(this);
    this.W.setCancelable(false);
    this.W.a("");
    this.W.a(2130837725);
    this.W.show();
    this.j = new a(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.Y = true;
    this.X.b(this.ab);
    this.X.b(this.aa);
    this.X.b(this.ac);
    this.X.b(this.ad);
    this.j.removeCallbacks(this.Z);
    unregisterReceiver(this.k);
    this.a.b();
    if (this.J != null) {
      this.J.a();
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((paramDialogInterface.equals(this.l)) && (this.m.b.getText().toString().equals(getString(2131166054)))) {
      this.j.removeMessages(1);
    }
  }
  
  public void onIabPurchaseFinished(IabResult paramIabResult, Purchase paramPurchase)
  {
    IabHelper localIabHelper = this.a.a();
    if (paramIabResult.isFailure())
    {
      localIabHelper.logDebug("Error onIabPurchaseFinished: " + paramIabResult);
      localIabHelper.logDebug("purchase failture");
    }
    for (;;)
    {
      i();
      this.F = false;
      return;
      if (this.a.a(paramPurchase.getSku()))
      {
        localIabHelper.logDebug("Success purchasing: " + paramIabResult);
        localIabHelper.logDebug("purchase success");
        paramIabResult = paramPurchase.getSku();
        this.z.a(paramIabResult, true);
        this.z.b(paramIabResult);
      }
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.Q.isShowing()) {
      this.Q.dismiss();
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      e(50);
      return;
    case 1: 
      g(51);
      return;
    }
    f(52);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.H)) {
      l();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    this.X.a(paramIntent);
    a(paramIntent);
  }
  
  protected void onPause()
  {
    if (this.y != null)
    {
      this.X.b(this.ab);
      this.X.b(this.aa);
    }
    super.onPause();
    this.j.removeCallbacks(this.Z);
  }
  
  protected void onResume()
  {
    if (this.y != null)
    {
      this.X.b(this.ab);
      this.X.a(this.ab);
      this.X.b(this.aa);
      this.X.a(this.aa);
    }
    super.onResume();
    i();
    this.j.removeCallbacks(this.Z);
    if ((this.i != -1) && (this.x != null))
    {
      ViewPage localViewPage = (ViewPage)this.x.getChildAt(this.i);
      if (localViewPage != null) {
        this.j.postDelayed(this.Z, localViewPage.c());
      }
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    EasyTracker.getInstance().activityStart(this);
  }
  
  protected void onStop()
  {
    super.onStop();
    EasyTracker.getInstance().activityStop(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/billing/BillingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */