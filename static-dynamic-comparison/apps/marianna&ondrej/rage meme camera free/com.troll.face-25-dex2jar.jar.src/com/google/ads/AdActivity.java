package com.google.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AdActivity
  extends Activity
  implements View.OnClickListener
{
  public static final String BASE_URL_PARAM = "baseurl";
  public static final String COMPONENT_NAME_PARAM = "c";
  public static final String CUSTOM_CLOSE_PARAM = "custom_close";
  public static final String HTML_PARAM = "html";
  public static final String INTENT_ACTION_PARAM = "i";
  public static final String INTENT_EXTRAS_PARAM = "e";
  public static final String INTENT_FLAGS_PARAM = "f";
  public static final String ORIENTATION_PARAM = "o";
  public static final String PACKAGE_NAME_PARAM = "p";
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
  
  private void e()
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
          this.h.g();
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
          if (this.h == d.l()) {
            d.a();
          }
          this.h.stopLoading();
        }
        if (this == e)
        {
          e = null;
          if (d != null)
          {
            d.u();
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
          this.h.h();
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
  
  public static void launchAdActivity(d paramd, com.google.ads.internal.e parame)
  {
    g.launchAdActivity(paramd, parame);
  }
  
  public static boolean leftApplication()
  {
    return g.leftApplication();
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
      if (paramAdWebView.i() == null) {
        break label134;
      }
      a("Interstitial created with an AdWebView that is already in use by another AdActivity.");
      return;
      label105:
      b.a("Disabling hardware acceleration on the AdActivity WebView.");
      paramAdWebView.g();
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
        paramd.w();
      }
      return;
    }
  }
  
  protected void a(HashMap<String, String> paramHashMap, d paramd)
  {
    int i3 = 0;
    if (paramHashMap == null)
    {
      a("Could not get the paramMap in launchIntent()");
      return;
    }
    Intent localIntent = new Intent();
    Object localObject3 = (String)paramHashMap.get("u");
    Object localObject4 = (String)paramHashMap.get("m");
    String str1 = (String)paramHashMap.get("i");
    String str2 = (String)paramHashMap.get("p");
    Object localObject2 = (String)paramHashMap.get("c");
    Object localObject1 = (String)paramHashMap.get("f");
    paramHashMap = (String)paramHashMap.get("e");
    int i1;
    if (!TextUtils.isEmpty((CharSequence)localObject3)) {
      i1 = 1;
    }
    for (;;)
    {
      int i2;
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        i2 = 1;
        label121:
        if ((i1 == 0) || (i2 == 0)) {
          break label423;
        }
        localIntent.setDataAndType(Uri.parse((String)localObject3), (String)localObject4);
        label143:
        if (TextUtils.isEmpty(str1)) {
          break label457;
        }
        localIntent.setAction(str1);
        label159:
        if ((!TextUtils.isEmpty(str2)) && (AdUtil.a >= 4)) {
          com.google.ads.util.e.a(localIntent, str2);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject3 = ((String)localObject2).split("/");
          if (localObject3.length < 2) {
            b.e("Warning: Could not parse component name from open GMSG: " + (String)localObject2);
          }
          localIntent.setClassName(localObject3[0], localObject3[1]);
        }
        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      }
      try
      {
        i1 = Integer.parseInt((String)localObject1);
        localIntent.addFlags(i1);
        if (!TextUtils.isEmpty(paramHashMap))
        {
          try
          {
            localObject1 = new JSONObject(paramHashMap);
            localObject2 = ((JSONObject)localObject1).names();
            i1 = i3;
            while (i1 < ((JSONArray)localObject2).length())
            {
              localObject3 = ((JSONArray)localObject2).getString(i1);
              localObject4 = ((JSONObject)localObject1).getJSONObject((String)localObject3);
              i2 = ((JSONObject)localObject4).getInt("t");
              switch (i2)
              {
              case 1: 
                b.e("Warning: Unknown type in extras from open GMSG: " + (String)localObject3 + " (type: " + i2 + ")");
                i1 += 1;
              }
            }
            i1 = 0;
          }
          catch (JSONException localJSONException)
          {
            label423:
            label457:
            b.e("Warning: Could not parse extras from open GMSG: " + paramHashMap);
          }
          i2 = 0;
          break label121;
          if (i1 != 0)
          {
            localIntent.setData(Uri.parse((String)localObject3));
            break label143;
          }
          if (i2 == 0) {
            break label143;
          }
          localIntent.setType((String)localObject4);
          break label143;
          if (i1 == 0) {
            break label159;
          }
          localIntent.setAction("android.intent.action.VIEW");
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          b.e("Warning: Could not parse flags from open GMSG: " + (String)localObject1);
          i1 = 0;
          continue;
          localIntent.putExtra((String)localObject3, ((JSONObject)localObject4).getBoolean("v"));
          continue;
          if (localIntent.filterEquals(new Intent()))
          {
            a("Tried to launch empty intent.");
            return;
            localIntent.putExtra((String)localObject3, ((JSONObject)localObject4).getDouble("v"));
            continue;
            localIntent.putExtra((String)localObject3, ((JSONObject)localObject4).getInt("v"));
            continue;
            localIntent.putExtra((String)localObject3, ((JSONObject)localObject4).getLong("v"));
            continue;
            localIntent.putExtra((String)localObject3, ((JSONObject)localObject4).getString("v"));
          }
          else
          {
            try
            {
              b.a("Launching an intent from AdActivity: " + localIntent);
              startActivity(localIntent);
              a(paramd);
              return;
            }
            catch (ActivityNotFoundException paramHashMap)
            {
              a(paramHashMap.getMessage(), paramHashMap);
              return;
            }
          }
        }
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
    AdWebView localAdWebView = d.l();
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
        d.m().b(false);
        return;
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
            paramBundle.v();
          }
          if ((this.o == null) && (f != null)) {
            this.o = f;
          }
          f = this;
          if (((paramBundle.i().a()) && (e == this)) || ((paramBundle.i().b()) && (this.o == e))) {
            paramBundle.x();
          }
          bool3 = paramBundle.r();
          localObject2 = (m.a)((m)paramBundle.i().d.a()).b.a();
          if (AdUtil.a >= ((Integer)((m.a)localObject2).b.a()).intValue())
          {
            bool1 = true;
            this.s = bool1;
            if (AdUtil.a < ((Integer)((m.a)localObject2).d.a()).intValue()) {
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
    ??? = new com.google.ads.internal.e((Bundle)???);
    Object localObject2 = ((com.google.ads.internal.e)???).b();
    ??? = ((com.google.ads.internal.e)???).c();
    if (((String)localObject2).equals("intent"))
    {
      a((HashMap)???, paramBundle);
      return;
    }
    this.n = new RelativeLayout(getApplicationContext());
    label453:
    int i1;
    if (((String)localObject2).equals("webapp"))
    {
      this.h = new AdWebView(paramBundle.i(), null);
      localObject2 = a.d;
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
          break label523;
        }
        this.h.loadUrl((String)localObject2);
        localObject2 = (String)((HashMap)???).get("o");
        if (!"p".equals(localObject2)) {
          break label557;
        }
        i1 = AdUtil.b();
        label479:
        paramBundle = this.h;
        if ((??? == null) || (!"1".equals(((HashMap)???).get("custom_close")))) {
          break label595;
        }
      }
      label523:
      label557:
      label595:
      for (bool1 = true;; bool1 = false)
      {
        a(paramBundle, false, i1, bool3, bool1);
        return;
        bool1 = false;
        break;
        if (str2 != null)
        {
          this.h.loadDataWithBaseURL(str1, str2, "text/html", "utf-8", null);
          break label453;
        }
        a("Could not get the URL or HTML parameter to show a web app.");
        return;
        if ("l".equals(localObject2))
        {
          i1 = AdUtil.a();
          break label479;
        }
        if (this == e)
        {
          i1 = paramBundle.o();
          break label479;
        }
        i1 = -1;
        break label479;
      }
    }
    if ((((String)localObject2).equals("interstitial")) || (((String)localObject2).equals("expand")))
    {
      this.h = paramBundle.l();
      i1 = paramBundle.o();
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
          break label772;
        }
        b.a("Re-enabling hardware acceleration on expanding MRAID WebView.");
        this.h.h();
      }
    }
    label772:
    for (;;)
    {
      a(this.h, true, i1, bool3, bool1);
      return;
      bool1 = this.h.j();
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
      e();
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
      e();
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
    
    public void launchAdActivity(d paramd, com.google.ads.internal.e parame)
    {
      synchronized ()
      {
        if (AdActivity.d() == null) {
          AdActivity.b(paramd);
        }
        while (AdActivity.d() == paramd)
        {
          paramd = (Activity)paramd.i().c.a();
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
    
    public boolean leftApplication()
    {
      for (;;)
      {
        synchronized ()
        {
          if (AdActivity.c() != null)
          {
            bool = true;
            return bool;
          }
        }
        boolean bool = false;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/google/ads/AdActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */