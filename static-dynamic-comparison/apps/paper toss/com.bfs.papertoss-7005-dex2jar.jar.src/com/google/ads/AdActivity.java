package com.google.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.ads.internal.AdVideoView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.a;
import com.google.ads.internal.d;
import com.google.ads.internal.e;
import com.google.ads.internal.i;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import com.google.ads.util.f;
import com.google.ads.util.g;
import com.google.ads.util.i.b;
import com.google.ads.util.i.c;
import com.google.ads.util.i.d;
import java.util.HashMap;
import java.util.Map;

public class AdActivity
  extends Activity
  implements View.OnClickListener
{
  public static final String BASE_URL_PARAM = "baseurl";
  public static final String CUSTOM_CLOSE_PARAM = "custom_close";
  public static final String HTML_PARAM = "html";
  public static final String INTENT_ACTION_PARAM = "i";
  public static final String ORIENTATION_PARAM = "o";
  public static final String TYPE_PARAM = "m";
  public static final String URL_PARAM = "u";
  private static final a a = (a)a.a.b();
  private static final Object b = new Object();
  private static AdActivity c = null;
  private static d d = null;
  private static AdActivity e = null;
  private static AdActivity f = null;
  private static final StaticMethodWrapper g = new StaticMethodWrapper();
  private AdWebView h;
  private FrameLayout i;
  private int j;
  private ViewGroup k = null;
  private boolean l;
  private long m;
  private RelativeLayout n;
  private AdActivity o = null;
  private boolean p;
  private boolean q;
  private boolean r;
  private boolean s;
  private AdVideoView t;
  
  private RelativeLayout.LayoutParams a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt3, paramInt4);
    localLayoutParams.setMargins(paramInt1, paramInt2, 0, 0);
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(9);
    return localLayoutParams;
  }
  
  private void a(String paramString)
  {
    b.b(paramString);
    finish();
  }
  
  private void a(String paramString, Throwable paramThrowable)
  {
    b.b(paramString, paramThrowable);
    finish();
  }
  
  private void d()
  {
    if (!this.l) {
      if (this.h != null)
      {
        a.b(this.h);
        this.h.setAdActivity(null);
        this.h.setIsExpandedMraid(false);
        if ((!this.q) && (this.n != null) && (this.k != null))
        {
          if ((!this.r) || (this.s)) {
            break label238;
          }
          b.a("Disabling hardware acceleration on collapsing MRAID WebView.");
          this.h.b();
        }
      }
    }
    for (;;)
    {
      this.n.removeView(this.h);
      this.k.addView(this.h);
      if (this.t != null)
      {
        this.t.e();
        this.t = null;
      }
      if (this == c) {
        c = null;
      }
      f = this.o;
      synchronized (b)
      {
        if ((d != null) && (this.q) && (this.h != null))
        {
          if (this.h == d.k()) {
            d.a();
          }
          this.h.stopLoading();
        }
        if (this == e)
        {
          e = null;
          if (d != null)
          {
            d.t();
            d = null;
          }
        }
        else
        {
          this.l = true;
          b.a("AdActivity is closing.");
          return;
          label238:
          if ((this.r) || (!this.s)) {
            continue;
          }
          b.a("Re-enabling hardware acceleration on collapsing MRAID WebView.");
          this.h.c();
          continue;
        }
        b.e("currentAdManager is null while trying to destroy AdActivity.");
      }
    }
  }
  
  public static boolean isShowing()
  {
    return g.isShowing();
  }
  
  public static void launchAdActivity(d paramd, e parame)
  {
    g.launchAdActivity(paramd, parame);
  }
  
  protected View a(int paramInt, boolean paramBoolean)
  {
    this.j = ((int)TypedValue.applyDimension(1, paramInt, getResources().getDisplayMetrics()));
    this.i = new FrameLayout(getApplicationContext());
    this.i.setMinimumWidth(this.j);
    this.i.setMinimumHeight(this.j);
    this.i.setOnClickListener(this);
    setCustomClose(paramBoolean);
    return this.i;
  }
  
  protected AdVideoView a(Activity paramActivity)
  {
    return new AdVideoView(paramActivity, this.h);
  }
  
  protected void a(AdWebView paramAdWebView, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    requestWindowFeature(1);
    Object localObject = getWindow();
    ((Window)localObject).setFlags(1024, 1024);
    if (AdUtil.a >= 11)
    {
      if (!this.r) {
        break label105;
      }
      b.a("Enabling hardware acceleration on the AdActivity window.");
      g.a((Window)localObject);
    }
    for (;;)
    {
      localObject = paramAdWebView.getParent();
      if (localObject != null)
      {
        if (!paramBoolean2) {
          break label126;
        }
        if (!(localObject instanceof ViewGroup)) {
          break;
        }
        this.k = ((ViewGroup)localObject);
        this.k.removeView(paramAdWebView);
      }
      if (paramAdWebView.d() == null) {
        break label134;
      }
      a("Interstitial created with an AdWebView that is already in use by another AdActivity.");
      return;
      label105:
      b.a("Disabling hardware acceleration on the AdActivity WebView.");
      paramAdWebView.b();
    }
    a("MRAID banner was not a child of a ViewGroup.");
    return;
    label126:
    a("Interstitial created with an AdWebView that has a parent.");
    return;
    label134:
    setRequestedOrientation(paramInt);
    paramAdWebView.setAdActivity(this);
    label152:
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean2)
    {
      paramInt = 50;
      localObject = a(paramInt, paramBoolean3);
      this.n.addView(paramAdWebView, -1, -1);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      if (!paramBoolean2) {
        break label261;
      }
      localLayoutParams.addRule(10);
      localLayoutParams.addRule(11);
    }
    for (;;)
    {
      this.n.addView((View)localObject, localLayoutParams);
      this.n.setKeepScreenOn(true);
      setContentView(this.n);
      this.n.getRootView().setBackgroundColor(-16777216);
      if (!paramBoolean1) {
        break;
      }
      a.a(paramAdWebView);
      return;
      paramInt = 32;
      break label152;
      label261:
      localLayoutParams.addRule(10);
      localLayoutParams.addRule(9);
    }
  }
  
  protected void a(d paramd)
  {
    this.h = null;
    this.m = SystemClock.elapsedRealtime();
    this.p = true;
    synchronized (b)
    {
      if (c == null)
      {
        c = this;
        paramd.v();
      }
      return;
    }
  }
  
  protected void a(HashMap<String, String> paramHashMap, d paramd)
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName("com.google.android.apps.plus", "com.google.android.apps.circles.platform.PlusOneActivity"));
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.putExtras(getIntent().getExtras());
    localIntent.putExtra("com.google.circles.platform.intent.extra.ENTITY", (String)paramHashMap.get("u"));
    localIntent.putExtra("com.google.circles.platform.intent.extra.ENTITY_TYPE", ai.b.a.c);
    localIntent.putExtra("com.google.circles.platform.intent.extra.ACTION", (String)paramHashMap.get("a"));
    a(paramd);
    try
    {
      b.a("Launching Google+ intent from AdActivity.");
      startActivityForResult(localIntent, 0);
      return;
    }
    catch (ActivityNotFoundException paramHashMap)
    {
      a(paramHashMap.getMessage(), paramHashMap);
    }
  }
  
  protected void b(HashMap<String, String> paramHashMap, d paramd)
  {
    if (paramHashMap == null)
    {
      a("Could not get the paramMap in launchIntent()");
      return;
    }
    Object localObject = (String)paramHashMap.get("u");
    if (localObject == null)
    {
      a("Could not get the URL parameter in launchIntent().");
      return;
    }
    String str2 = (String)paramHashMap.get("i");
    String str1 = (String)paramHashMap.get("m");
    localObject = Uri.parse((String)localObject);
    if (str2 == null) {}
    for (paramHashMap = new Intent("android.intent.action.VIEW", (Uri)localObject);; paramHashMap = new Intent(str2, (Uri)localObject))
    {
      if (str1 != null) {
        paramHashMap.setDataAndType((Uri)localObject, str1);
      }
      a(paramd);
      try
      {
        b.a("Launching an intent from AdActivity: " + paramHashMap.getAction() + " - " + localObject);
        startActivity(paramHashMap);
        return;
      }
      catch (ActivityNotFoundException paramHashMap)
      {
        a(paramHashMap.getMessage(), paramHashMap);
        return;
      }
    }
  }
  
  public AdVideoView getAdVideoView()
  {
    return this.t;
  }
  
  public AdWebView getOpeningAdWebView()
  {
    if (this.o != null) {
      return this.o.h;
    }
    synchronized (b)
    {
      if (d == null)
      {
        b.e("currentAdManager was null while trying to get the opening AdWebView.");
        return null;
      }
    }
    AdWebView localAdWebView = d.k();
    if (localAdWebView != this.h) {
      return localAdWebView;
    }
    return null;
  }
  
  public void moveAdVideoView(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.t != null)
    {
      this.t.setLayoutParams(a(paramInt1, paramInt2, paramInt3, paramInt4));
      this.t.requestLayout();
    }
  }
  
  public void newAdVideoView(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.t == null)
    {
      this.t = a(this);
      this.n.addView(this.t, 0, a(paramInt1, paramInt2, paramInt3, paramInt4));
      synchronized (b)
      {
        if (d == null)
        {
          b.e("currentAdManager was null while trying to get the opening AdWebView.");
          return;
        }
        d.l().b(false);
        return;
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((getOpeningAdWebView() != null) && (paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getExtras().getString("com.google.circles.platform.result.extra.CONFIRMATION") != null) && (paramIntent.getExtras().getString("com.google.circles.platform.result.extra.ACTION") != null))
    {
      String str = paramIntent.getExtras().getString("com.google.circles.platform.result.extra.CONFIRMATION");
      paramIntent = paramIntent.getExtras().getString("com.google.circles.platform.result.extra.ACTION");
      if (str.equals("yes"))
      {
        if (!paramIntent.equals("insert")) {
          break label108;
        }
        ag.a(getOpeningAdWebView(), true);
      }
    }
    for (;;)
    {
      finish();
      return;
      label108:
      if (paramIntent.equals("delete")) {
        ag.a(getOpeningAdWebView(), false);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = false;
    super.onCreate(paramBundle);
    this.l = false;
    boolean bool3;
    boolean bool1;
    for (;;)
    {
      synchronized (b)
      {
        if (d != null)
        {
          paramBundle = d;
          if (e == null)
          {
            e = this;
            paramBundle.u();
          }
          if ((this.o == null) && (f != null)) {
            this.o = f;
          }
          f = this;
          if (((paramBundle.h().a()) && (e == this)) || ((paramBundle.h().b()) && (this.o == e))) {
            paramBundle.w();
          }
          bool3 = paramBundle.q();
          localObject2 = (l.a)((l)paramBundle.h().a.a()).a.a();
          if (AdUtil.a >= ((Integer)((l.a)localObject2).a.a()).intValue())
          {
            bool1 = true;
            this.s = bool1;
            if (AdUtil.a < ((Integer)((l.a)localObject2).b.a()).intValue()) {
              break label264;
            }
            bool1 = true;
            this.r = bool1;
            this.n = null;
            this.p = false;
            this.q = true;
            this.t = null;
            ??? = getIntent().getBundleExtra("com.google.ads.AdOpener");
            if (??? != null) {
              break;
            }
            a("Could not get the Bundle used to create AdActivity.");
          }
        }
        else
        {
          a("Could not get currentAdManager.");
          return;
        }
      }
      bool1 = false;
      continue;
      label264:
      bool1 = false;
    }
    ??? = new e((Bundle)???);
    Object localObject2 = ((e)???).b();
    ??? = ((e)???).c();
    if (((String)localObject2).equals("plusone"))
    {
      a((HashMap)???, paramBundle);
      return;
    }
    if (((String)localObject2).equals("intent"))
    {
      b((HashMap)???, paramBundle);
      return;
    }
    this.n = new RelativeLayout(getApplicationContext());
    label472:
    int i1;
    if (((String)localObject2).equals("webapp"))
    {
      this.h = new AdWebView(paramBundle.h(), null);
      localObject2 = a.c;
      String str1;
      String str2;
      if (!bool3)
      {
        bool1 = true;
        localObject2 = i.a(paramBundle, (Map)localObject2, true, bool1);
        ((i)localObject2).d(true);
        if (bool3) {
          ((i)localObject2).a(true);
        }
        this.h.setWebViewClient((WebViewClient)localObject2);
        localObject2 = (String)((HashMap)???).get("u");
        str1 = (String)((HashMap)???).get("baseurl");
        str2 = (String)((HashMap)???).get("html");
        if (localObject2 == null) {
          break label543;
        }
        this.h.loadUrl((String)localObject2);
        localObject2 = (String)((HashMap)???).get("o");
        if (!"p".equals(localObject2)) {
          break label577;
        }
        i1 = AdUtil.b();
        label499:
        paramBundle = this.h;
        if ((??? == null) || (!"1".equals(((HashMap)???).get("custom_close")))) {
          break label615;
        }
      }
      label543:
      label577:
      label615:
      for (bool1 = true;; bool1 = false)
      {
        a(paramBundle, false, i1, bool3, bool1);
        return;
        bool1 = false;
        break;
        if (str2 != null)
        {
          this.h.loadDataWithBaseURL(str1, str2, "text/html", "utf-8", null);
          break label472;
        }
        a("Could not get the URL or HTML parameter to show a web app.");
        return;
        if ("l".equals(localObject2))
        {
          i1 = AdUtil.a();
          break label499;
        }
        if (this == e)
        {
          i1 = paramBundle.n();
          break label499;
        }
        i1 = -1;
        break label499;
      }
    }
    if ((((String)localObject2).equals("interstitial")) || (((String)localObject2).equals("expand")))
    {
      this.h = paramBundle.k();
      i1 = paramBundle.n();
      if (((String)localObject2).equals("expand"))
      {
        this.h.setIsExpandedMraid(true);
        this.q = false;
        bool1 = bool2;
        if (??? != null)
        {
          bool1 = bool2;
          if ("1".equals(((HashMap)???).get("custom_close"))) {
            bool1 = true;
          }
        }
        if ((!this.r) || (this.s)) {
          break label792;
        }
        b.a("Re-enabling hardware acceleration on expanding MRAID WebView.");
        this.h.c();
      }
    }
    label792:
    for (;;)
    {
      a(this.h, true, i1, bool3, bool1);
      return;
      bool1 = this.h.e();
      continue;
      a("Unknown AdOpener, <action: " + (String)localObject2 + ">");
      return;
    }
  }
  
  public void onDestroy()
  {
    if (this.n != null) {
      this.n.removeAllViews();
    }
    if (isFinishing())
    {
      d();
      if ((this.q) && (this.h != null))
      {
        this.h.stopLoading();
        this.h.destroy();
        this.h = null;
      }
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    if (isFinishing()) {
      d();
    }
    super.onPause();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if ((this.p) && (paramBoolean) && (SystemClock.elapsedRealtime() - this.m > 250L))
    {
      b.d("Launcher AdActivity got focus and is closing.");
      finish();
    }
    super.onWindowFocusChanged(paramBoolean);
  }
  
  public void setCustomClose(boolean paramBoolean)
  {
    if (this.i != null)
    {
      this.i.removeAllViews();
      if (!paramBoolean)
      {
        ImageButton localImageButton = new ImageButton(this);
        localImageButton.setImageResource(17301527);
        localImageButton.setBackgroundColor(0);
        localImageButton.setOnClickListener(this);
        localImageButton.setPadding(0, 0, 0, 0);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.j, this.j, 17);
        this.i.addView(localImageButton, localLayoutParams);
      }
    }
  }
  
  public static class StaticMethodWrapper
  {
    public boolean isShowing()
    {
      for (;;)
      {
        synchronized ()
        {
          if (AdActivity.b() != null)
          {
            bool = true;
            return bool;
          }
        }
        boolean bool = false;
      }
    }
    
    public void launchAdActivity(d paramd, e parame)
    {
      synchronized ()
      {
        if (AdActivity.c() == null) {
          AdActivity.b(paramd);
        }
        while (AdActivity.c() == paramd)
        {
          paramd = (Activity)paramd.h().e.a();
          if (paramd != null) {
            break;
          }
          b.e("activity was null while launching an AdActivity.");
          return;
        }
        b.b("Tried to launch a new AdActivity with a different AdManager.");
        return;
      }
      ??? = new Intent(paramd.getApplicationContext(), AdActivity.class);
      ((Intent)???).putExtra("com.google.ads.AdOpener", parame.a());
      try
      {
        b.a("Launching AdActivity.");
        paramd.startActivity((Intent)???);
        return;
      }
      catch (ActivityNotFoundException paramd)
      {
        b.b("Activity not found.", paramd);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/google/ads/AdActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */