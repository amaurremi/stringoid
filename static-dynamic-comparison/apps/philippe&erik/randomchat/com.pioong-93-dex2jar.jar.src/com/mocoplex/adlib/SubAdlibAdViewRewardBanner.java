package com.mocoplex.adlib;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout.LayoutParams;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public class SubAdlibAdViewRewardBanner
  extends SubAdlibAdViewCore
{
  private static String t = "http://ad.adlibr.com/smartad/req_rb2.jsp";
  long c = 0L;
  int d = 0;
  int e = 0;
  AdlibManager f;
  String g = "";
  String h = "";
  boolean i = false;
  boolean j = false;
  String k;
  String l;
  String m;
  Location n;
  String o;
  String p;
  boolean q;
  String r;
  private WebView s;
  
  public SubAdlibAdViewRewardBanner(Context paramContext, AdlibManager paramAdlibManager)
  {
    this(paramContext, paramAdlibManager, (byte)0);
  }
  
  private SubAdlibAdViewRewardBanner(Context paramContext, AdlibManager paramAdlibManager, byte paramByte)
  {
    super(paramContext, null);
    this.f = paramAdlibManager;
    this.s = new WebView(paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, (int)(50.0F * getResources().getDisplayMetrics().density + 0.5F));
    this.s.setLayoutParams(paramContext);
    setVerticalScrollBarEnabled(false);
    setHorizontalScrollBarEnabled(false);
    this.s.setScrollBarStyle(33554432);
    this.s.setVerticalScrollBarEnabled(false);
    this.s.setHorizontalScrollBarEnabled(false);
    this.s.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return paramAnonymousMotionEvent.getAction() == 2;
      }
    });
    this.s.getSettings().setLoadWithOverviewMode(true);
    this.s.getSettings().setUseWideViewPort(true);
    this.s.getSettings().setJavaScriptEnabled(true);
    this.s.addJavascriptInterface(new AndroidBridge(), "gotoAds");
    this.s.setWebViewClient(new WebViewClient()
    {
      public final void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
        if (SubAdlibAdViewRewardBanner.this.i) {
          SubAdlibAdViewRewardBanner.this.a();
        }
      }
    });
    this.c = (new Date().getTime() + AdlibConfig.getInstance().c * 1000);
    this.r = this.s.getSettings().getUserAgentString();
    this.k = AdlibConfig.getInstance().c("api");
    this.l = getContext().getResources().getConfiguration().locale.getLanguage();
    this.m = f.a(getContext()).a();
    this.q = AdlibConfig.getInstance().k();
    if (this.q) {
      b();
    }
    paramContext = ((TelephonyManager)getContext().getSystemService("phone")).getNetworkOperatorName();
    paramAdlibManager = new JSONObject();
    try
    {
      paramAdlibManager.put("os", Build.VERSION.RELEASE);
      paramAdlibManager.put("tm", paramContext);
      paramAdlibManager.put("device", Build.MODEL);
      AdlibConfig.getInstance();
      paramAdlibManager.put("ver", AdlibConfig.h());
      this.h = paramAdlibManager.toString();
      addView(this.s);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
  
  private static void a(WebView paramWebView, String paramString)
  {
    try
    {
      WebView.class.getMethod(paramString, new Class[0]).invoke(paramWebView, new Object[0]);
      return;
    }
    catch (Exception paramWebView) {}
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    try
    {
      Class localClass = Class.forName("org.apache.commons.codec.binary.Base64");
      paramArrayOfByte = (byte[])localClass.getMethod("encodeBase64", new Class[] { byte[].class }).invoke(localClass, new Object[] { paramArrayOfByte });
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  private void b()
  {
    this.n = AdlibConfig.getInstance().i();
    this.q = AdlibConfig.getInstance().k();
    String str1;
    String str2;
    if (this.n != null)
    {
      str1 = Double.valueOf(this.n.getLatitude()).toString();
      str2 = Double.valueOf(this.n.getLongitude()).toString();
    }
    try
    {
      this.o = new String(a(str1.getBytes("UTF-8")));
      this.p = new String(a(str2.getBytes("UTF-8")));
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
  }
  
  protected final void a()
  {
    this.i = false;
    this.c = (new Date().getTime() + this.d * 1000);
    this.f.a(this.e);
    this.e = 0;
    gotAd();
  }
  
  public final void a(String paramString)
  {
    this.j = false;
    if (this.s != null) {
      this.s.loadUrl("file://" + AdlibConfig.getInstance().h(paramString));
    }
  }
  
  public final void b(String paramString)
  {
    this.j = false;
    if (this.s != null) {
      this.s.loadUrl(paramString);
    }
  }
  
  protected final void c(final String paramString)
  {
    new Thread(new Runnable()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        try
        {
          switch (paramAnonymousMessage.what)
          {
          case 1: 
            paramAnonymousMessage = (String)paramAnonymousMessage.obj;
            SubAdlibAdViewRewardBanner.this.i = true;
            SubAdlibAdViewRewardBanner.this.a(paramAnonymousMessage);
            return;
          case 2: 
            paramAnonymousMessage = (String)paramAnonymousMessage.obj;
            SubAdlibAdViewRewardBanner.this.i = true;
            SubAdlibAdViewRewardBanner.this.b(paramAnonymousMessage);
            return;
          case -1: 
            SubAdlibAdViewRewardBanner.this.failed();
            return;
          }
          return;
        }
        catch (Exception paramAnonymousMessage) {}
      }
    }
    {
      public final void run()
      {
        new JSONObject();
        String str3;
        try
        {
          Object localObject1 = new JSONObject(paramString);
          String str1 = ((JSONObject)localObject1).getString("res");
          SubAdlibAdViewRewardBanner.this.d = ((JSONObject)localObject1).getInt("rp");
          if (str1.equals("-1"))
          {
            long l = new Date().getTime();
            SubAdlibAdViewRewardBanner.this.c = (l + SubAdlibAdViewRewardBanner.this.d * 1000);
            this.c.sendEmptyMessage(-1);
            return;
          }
          str1 = (String)((JSONObject)localObject1).get("bid");
          String str2 = (String)((JSONObject)localObject1).get("cache");
          str3 = (String)((JSONObject)localObject1).get("url");
          SubAdlibAdViewRewardBanner.this.e = ((JSONObject)localObject1).getInt("vs");
          SubAdlibAdViewRewardBanner.this.g = ((JSONObject)localObject1).getString("param");
          localObject1 = SubAdlibAdViewRewardBanner.this;
          ((SubAdlibAdViewRewardBanner)localObject1).g = (((SubAdlibAdViewRewardBanner)localObject1).g + "&ext=" + URLEncoder.encode(SubAdlibAdViewRewardBanner.this.h, "utf-8"));
          if (!str2.equals("Y")) {
            break label282;
          }
          if (!AdlibConfig.getInstance().g(str1)) {
            AdlibConfig.getInstance().b(str3, str1);
          }
          if (AdlibConfig.getInstance().g(str1))
          {
            localObject1 = Message.obtain(this.c, 1, str1);
            this.c.sendMessage((Message)localObject1);
            return;
          }
        }
        catch (Exception localException)
        {
          this.c.sendEmptyMessage(-1);
          return;
        }
        this.c.sendEmptyMessage(-1);
        return;
        label282:
        if (str3 == null)
        {
          this.c.sendEmptyMessage(-1);
          return;
        }
        Object localObject2 = str3 + "?" + SubAdlibAdViewRewardBanner.this.g;
        localObject2 = Message.obtain(this.c, 2, localObject2);
        this.c.sendMessage((Message)localObject2);
      }
    }).start();
  }
  
  public void clearAdView()
  {
    super.clearAdView();
  }
  
  public void failed()
  {
    this.j = false;
    super.failed();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.s != null)
    {
      removeView(this.s);
      this.s.destroy();
      this.s = null;
    }
  }
  
  public void onPause()
  {
    if (this.s != null)
    {
      a(this.s, "onPause");
      this.s.getSettings().setJavaScriptEnabled(false);
    }
  }
  
  public void onResume()
  {
    if (this.s != null)
    {
      a(this.s, "onResume");
      this.s.getSettings().setJavaScriptEnabled(true);
      this.s.reload();
    }
  }
  
  public void query()
  {
    if (this.j) {
      return;
    }
    if (new Date().getTime() < this.c)
    {
      failed();
      return;
    }
    if (this.k.equals(""))
    {
      failed();
      return;
    }
    Object localObject = new ArrayList();
    ((List)localObject).add(new BasicNameValuePair("key", this.k));
    ((List)localObject).add(new BasicNameValuePair("cc", this.l));
    ((List)localObject).add(new BasicNameValuePair("udid", this.m));
    ((List)localObject).add(new BasicNameValuePair("ext", this.h));
    ((List)localObject).add(new BasicNameValuePair("agent", this.r));
    if (this.q)
    {
      if (this.n == null) {
        b();
      }
      if (this.n != null)
      {
        ((List)localObject).add(new BasicNameValuePair("lat", this.o));
        ((List)localObject).add(new BasicNameValuePair("lon", this.p));
      }
    }
    try
    {
      localObject = new UrlEncodedFormEntity((List)localObject, "UTF-8");
      new d(new Handler()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          try
          {
            switch (paramAnonymousMessage.what)
            {
            case 2: 
              paramAnonymousMessage = (String)paramAnonymousMessage.obj;
              SubAdlibAdViewRewardBanner.this.j = true;
              SubAdlibAdViewRewardBanner.this.c(paramAnonymousMessage);
              return;
            case 1: 
              SubAdlibAdViewRewardBanner.this.failed();
              return;
            }
            return;
          }
          catch (Exception paramAnonymousMessage) {}
        }
      }).a(t, (UrlEncodedFormEntity)localObject);
      return;
    }
    catch (Exception localException) {}
  }
  
  public class AndroidBridge
  {
    private final Handler b = new Handler();
    
    public AndroidBridge() {}
    
    public void go(final String paramString)
    {
      this.b.post(new Runnable()
      {
        public final void run()
        {
          Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString + SubAdlibAdViewRewardBanner.this.g));
          try
          {
            SubAdlibAdViewRewardBanner.this.getContext().startActivity(localIntent);
            SubAdlibAdViewRewardBanner.this.f.c();
            return;
          }
          catch (Exception localException) {}
        }
      });
    }
    
    public void go2(final String paramString1, final String paramString2, final String paramString3)
    {
      this.b.post(new Runnable()
      {
        public final void run()
        {
          Object localObject;
          if ((paramString1 != null) && (!paramString1.equals("")))
          {
            localObject = paramString1 + SubAdlibAdViewRewardBanner.this.g;
            new d(new Handler()
            {
              public final void handleMessage(Message paramAnonymous2Message)
              {
                int i = paramAnonymous2Message.what;
              }
            }).a((String)localObject, null);
          }
          try
          {
            if (paramString3.equals("www"))
            {
              localObject = new Bundle();
              ((Bundle)localObject).putString("url", paramString2);
              ((Bundle)localObject).putInt("type", 1);
              Intent localIntent = new Intent(SubAdlibAdViewRewardBanner.this.getContext(), AdlibWebBrowserActivity.class);
              localIntent.putExtras((Bundle)localObject);
              SubAdlibAdViewRewardBanner.this.getContext().startActivity(localIntent);
            }
            for (;;)
            {
              SubAdlibAdViewRewardBanner.this.f.c();
              return;
              localObject = new Intent("android.intent.action.VIEW", Uri.parse(paramString2));
              SubAdlibAdViewRewardBanner.this.getContext().startActivity((Intent)localObject);
            }
            return;
          }
          catch (Exception localException) {}
        }
      });
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mocoplex/adlib/SubAdlibAdViewRewardBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */