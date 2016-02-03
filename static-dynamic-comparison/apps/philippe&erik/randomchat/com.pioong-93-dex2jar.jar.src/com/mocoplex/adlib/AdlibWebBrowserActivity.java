package com.mocoplex.adlib;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.Locale;
import org.json.JSONObject;

public class AdlibWebBrowserActivity
  extends Activity
{
  FrameLayout a;
  LinearLayout b;
  LinearLayout c;
  AdlibNoZoomWebView d;
  WebView e;
  ProgressBar f;
  String g;
  Button h;
  Button i;
  String j;
  String k;
  String l;
  int m;
  String n;
  String o;
  boolean p = false;
  AnimationSet q;
  
  private void b()
  {
    this.b = new LinearLayout(this);
    Object localObject = new LinearLayout.LayoutParams(-1, -1);
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.b.setOrientation(1);
    this.d = new AdlibNoZoomWebView(this);
    this.d.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
    this.d.getSettings().setJavaScriptEnabled(true);
    this.d.getSettings().setLoadWithOverviewMode(true);
    this.d.getSettings().setUseWideViewPort(true);
    this.d.setInitialScale(1);
    this.d.setScrollBarStyle(33554432);
    this.d.setWebViewClient(new e((byte)0));
    this.d.setWebChromeClient(new b((byte)0));
    this.d.loadUrl(this.g);
    localObject = new View(this);
    ((View)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, a(1), 0.0F));
    ((View)localObject).setBackgroundColor(-12303292);
    this.c = new LinearLayout(this);
    this.c.setLayoutParams(new LinearLayout.LayoutParams(-1, a(40), 0.0F));
    this.c.setBackgroundColor(-14932432);
    this.c.setGravity(16);
    View localView = new View(this);
    localView.setLayoutParams(new LinearLayout.LayoutParams(a(1), -1, 0.0F));
    localView.setBackgroundColor(-12303292);
    this.i = new Button(this);
    this.i.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 2.0F));
    if (this.j.equals("ko")) {
      this.i.setText("닫기");
    }
    for (;;)
    {
      this.i.setTextColor(-1);
      this.i.setBackgroundColor(16777215);
      this.i.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AdlibWebBrowserActivity.this.finish();
        }
      });
      this.c.addView(this.h);
      this.c.addView(localView);
      this.c.addView(this.i);
      this.b.addView(this.d);
      this.b.addView((View)localObject);
      this.b.addView(this.c);
      this.a.addView(this.b);
      this.a.addView(this.f);
      setContentView(this.a);
      return;
      this.i.setText("close");
    }
  }
  
  protected final int a(int paramInt)
  {
    return (int)(paramInt * getResources().getDisplayMetrics().density + 0.5F);
  }
  
  protected final void a()
  {
    this.l = this.d.getUrl();
    this.d.goBack();
  }
  
  /* Error */
  public final void a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: new 242	java/net/URL
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 244	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 248	java/net/URL:openStream	()Ljava/io/InputStream;
    //   11: astore_2
    //   12: new 250	java/util/ArrayList
    //   15: dup
    //   16: invokespecial 251	java/util/ArrayList:<init>	()V
    //   19: astore 4
    //   21: aload 4
    //   23: new 253	org/apache/http/message/BasicNameValuePair
    //   26: dup
    //   27: ldc -1
    //   29: aload_0
    //   30: getfield 257	com/mocoplex/adlib/AdlibWebBrowserActivity:n	Ljava/lang/String;
    //   33: invokespecial 260	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: invokeinterface 265 2 0
    //   41: pop
    //   42: aload 4
    //   44: new 253	org/apache/http/message/BasicNameValuePair
    //   47: dup
    //   48: ldc_w 267
    //   51: aload_0
    //   52: invokestatic 272	com/mocoplex/adlib/f:a	(Landroid/content/Context;)Lcom/mocoplex/adlib/f;
    //   55: invokevirtual 274	com/mocoplex/adlib/f:a	()Ljava/lang/String;
    //   58: invokespecial 260	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: invokeinterface 265 2 0
    //   66: pop
    //   67: aload 4
    //   69: new 253	org/apache/http/message/BasicNameValuePair
    //   72: dup
    //   73: ldc_w 276
    //   76: aload_0
    //   77: getfield 278	com/mocoplex/adlib/AdlibWebBrowserActivity:k	Ljava/lang/String;
    //   80: invokespecial 260	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: invokeinterface 265 2 0
    //   88: pop
    //   89: new 280	org/apache/http/client/entity/UrlEncodedFormEntity
    //   92: dup
    //   93: aload 4
    //   95: ldc_w 282
    //   98: invokespecial 285	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   101: astore 4
    //   103: new 287	com/mocoplex/adlib/d
    //   106: dup
    //   107: new 12	com/mocoplex/adlib/AdlibWebBrowserActivity$4
    //   110: dup
    //   111: aload_0
    //   112: invokespecial 288	com/mocoplex/adlib/AdlibWebBrowserActivity$4:<init>	(Lcom/mocoplex/adlib/AdlibWebBrowserActivity;)V
    //   115: invokespecial 291	com/mocoplex/adlib/d:<init>	(Landroid/os/Handler;)V
    //   118: ldc_w 293
    //   121: aload 4
    //   123: invokevirtual 296	com/mocoplex/adlib/d:a	(Ljava/lang/String;Lorg/apache/http/client/entity/UrlEncodedFormEntity;)V
    //   126: new 35	com/mocoplex/adlib/AdlibWebBrowserActivity$c
    //   129: dup
    //   130: aload_2
    //   131: invokespecial 299	com/mocoplex/adlib/AdlibWebBrowserActivity$c:<init>	(Ljava/io/InputStream;)V
    //   134: invokestatic 305	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   137: astore 4
    //   139: new 307	android/content/Intent
    //   142: dup
    //   143: invokespecial 308	android/content/Intent:<init>	()V
    //   146: astore 5
    //   148: aload 5
    //   150: ldc_w 310
    //   153: invokevirtual 314	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   156: pop
    //   157: aload 5
    //   159: ldc_w 316
    //   162: invokevirtual 319	android/content/Intent:addCategory	(Ljava/lang/String;)Landroid/content/Intent;
    //   165: pop
    //   166: aload 5
    //   168: aload_3
    //   169: invokestatic 325	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   172: invokevirtual 329	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   175: pop
    //   176: aload_0
    //   177: invokevirtual 333	com/mocoplex/adlib/AdlibWebBrowserActivity:getPackageManager	()Landroid/content/pm/PackageManager;
    //   180: aload 5
    //   182: iconst_0
    //   183: invokevirtual 339	android/content/pm/PackageManager:queryIntentActivities	(Landroid/content/Intent;I)Ljava/util/List;
    //   186: astore_2
    //   187: aload_2
    //   188: invokeinterface 343 1 0
    //   193: ifle +95 -> 288
    //   196: aload_2
    //   197: new 29	com/mocoplex/adlib/AdlibWebBrowserActivity$a
    //   200: dup
    //   201: aload_0
    //   202: invokespecial 344	com/mocoplex/adlib/AdlibWebBrowserActivity$a:<init>	(Lcom/mocoplex/adlib/AdlibWebBrowserActivity;)V
    //   205: invokestatic 350	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   208: aload_2
    //   209: invokeinterface 354 1 0
    //   214: astore_2
    //   215: aload_2
    //   216: invokeinterface 360 1 0
    //   221: ifne +102 -> 323
    //   224: aconst_null
    //   225: astore_2
    //   226: new 307	android/content/Intent
    //   229: dup
    //   230: invokespecial 308	android/content/Intent:<init>	()V
    //   233: astore_3
    //   234: aload_2
    //   235: ifnull +206 -> 441
    //   238: aload_3
    //   239: ldc_w 362
    //   242: aload_2
    //   243: invokevirtual 366	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   246: pop
    //   247: aload_3
    //   248: ldc_w 368
    //   251: aload_1
    //   252: invokevirtual 371	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   255: pop
    //   256: aload_3
    //   257: ldc_w 373
    //   260: aload 4
    //   262: invokevirtual 366	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   265: pop
    //   266: aload_3
    //   267: ldc_w 375
    //   270: iconst_0
    //   271: invokevirtual 378	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   274: pop
    //   275: aload_3
    //   276: ldc_w 380
    //   279: invokevirtual 314	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   282: pop
    //   283: aload_0
    //   284: aload_3
    //   285: invokevirtual 384	com/mocoplex/adlib/AdlibWebBrowserActivity:sendBroadcast	(Landroid/content/Intent;)V
    //   288: return
    //   289: astore_1
    //   290: aload_0
    //   291: getfield 167	com/mocoplex/adlib/AdlibWebBrowserActivity:j	Ljava/lang/String;
    //   294: ldc -87
    //   296: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   299: ifeq +17 -> 316
    //   302: ldc_w 386
    //   305: astore_1
    //   306: aload_0
    //   307: aload_1
    //   308: iconst_0
    //   309: invokestatic 392	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   312: invokevirtual 395	android/widget/Toast:show	()V
    //   315: return
    //   316: ldc_w 397
    //   319: astore_1
    //   320: goto -14 -> 306
    //   323: aload_2
    //   324: invokeinterface 401 1 0
    //   329: checkcast 403	android/content/pm/ResolveInfo
    //   332: getfield 407	android/content/pm/ResolveInfo:activityInfo	Landroid/content/pm/ActivityInfo;
    //   335: getfield 413	android/content/pm/ActivityInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   338: getfield 418	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   341: astore 6
    //   343: aload 6
    //   345: ldc_w 420
    //   348: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   351: ifeq +41 -> 392
    //   354: aload_0
    //   355: invokevirtual 333	com/mocoplex/adlib/AdlibWebBrowserActivity:getPackageManager	()Landroid/content/pm/PackageManager;
    //   358: aload 6
    //   360: invokevirtual 423	android/content/pm/PackageManager:getLaunchIntentForPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   363: astore_2
    //   364: aload_2
    //   365: ldc_w 310
    //   368: invokevirtual 314	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   371: pop
    //   372: aload_2
    //   373: ldc_w 316
    //   376: invokevirtual 319	android/content/Intent:addCategory	(Ljava/lang/String;)Landroid/content/Intent;
    //   379: pop
    //   380: aload_2
    //   381: aload_3
    //   382: invokestatic 325	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   385: invokevirtual 329	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   388: pop
    //   389: goto -163 -> 226
    //   392: aload 6
    //   394: ldc_w 425
    //   397: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   400: ifeq -185 -> 215
    //   403: aload_0
    //   404: invokevirtual 333	com/mocoplex/adlib/AdlibWebBrowserActivity:getPackageManager	()Landroid/content/pm/PackageManager;
    //   407: aload 6
    //   409: invokevirtual 423	android/content/pm/PackageManager:getLaunchIntentForPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   412: astore_2
    //   413: aload_2
    //   414: ldc_w 310
    //   417: invokevirtual 314	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   420: pop
    //   421: aload_2
    //   422: ldc_w 316
    //   425: invokevirtual 319	android/content/Intent:addCategory	(Ljava/lang/String;)Landroid/content/Intent;
    //   428: pop
    //   429: aload_2
    //   430: aload_3
    //   431: invokestatic 325	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   434: invokevirtual 329	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   437: pop
    //   438: goto -212 -> 226
    //   441: aload_3
    //   442: ldc_w 362
    //   445: aload 5
    //   447: invokevirtual 366	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   450: pop
    //   451: goto -204 -> 247
    //   454: astore_1
    //   455: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	456	0	this	AdlibWebBrowserActivity
    //   0	456	1	paramString1	String
    //   0	456	2	paramString2	String
    //   0	456	3	paramString3	String
    //   19	242	4	localObject	Object
    //   146	300	5	localIntent	Intent
    //   341	67	6	str	String
    // Exception table:
    //   from	to	target	type
    //   0	12	289	java/lang/Exception
    //   89	103	454	java/lang/Exception
  }
  
  public void onBackPressed()
  {
    if (this.d.canGoBack())
    {
      a();
      return;
    }
    finish();
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return super.onContextItemSelected(paramMenuItem);
      a();
      continue;
      this.d.goForward();
      continue;
      this.d.reload();
      continue;
      try
      {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.d.getUrl())));
      }
      catch (Exception localException) {}
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    this.j = getResources().getConfiguration().locale.getLanguage();
    this.a = new FrameLayout(this);
    paramBundle = new LinearLayout.LayoutParams(-1, -1, 1.0F);
    this.a.setLayoutParams(paramBundle);
    this.g = getIntent().getStringExtra("url");
    this.n = getIntent().getStringExtra("id");
    this.o = getIntent().getStringExtra("param");
    this.m = getIntent().getIntExtra("type", 1);
    this.f = new ProgressBar(this, null, 16842872);
    paramBundle = new LinearLayout.LayoutParams(-1, a(5));
    this.f.setLayoutParams(paramBundle);
    this.f.setMax(100);
    this.f.setVisibility(8);
    this.h = new Button(this);
    this.h.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
    if (this.j.equals("ko"))
    {
      this.h.setText("메뉴");
      this.h.setTextColor(-1);
      this.h.setBackgroundColor(16777215);
      registerForContextMenu(this.h);
      this.h.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AdlibWebBrowserActivity.this.openContextMenu(AdlibWebBrowserActivity.this.h);
        }
      });
      this.h.setLongClickable(false);
      this.l = "";
      if (this.m != 1) {
        break label304;
      }
      b();
    }
    for (;;)
    {
      return;
      this.h.setText("menu");
      break;
      label304:
      if (this.m == 2)
      {
        this.h.setVisibility(8);
        this.b = new LinearLayout(this);
        paramBundle = new LinearLayout.LayoutParams(-1, -1);
        this.b.setLayoutParams(paramBundle);
        this.b.setGravity(17);
        this.b.setOrientation(1);
        this.b.setBackgroundColor(-3223858);
        this.d = new AdlibNoZoomWebView(this);
        this.d.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.d.getSettings().setJavaScriptEnabled(true);
        this.d.getSettings().setLoadWithOverviewMode(true);
        this.d.getSettings().setUseWideViewPort(true);
        this.d.setInitialScale(1);
        this.d.setScrollBarStyle(33554432);
        this.d.setWebViewClient(new e((byte)0));
        this.d.setWebChromeClient(new b((byte)0));
        this.d.addJavascriptInterface(new JavascriptInterface(), "gotoAds");
        this.k = this.d.getSettings().getUserAgentString();
        paramBundle = new AlphaAnimation(0.7F, 1.0F);
        paramBundle.setDuration(80L);
        this.q = new AnimationSet(false);
        this.q.addAnimation(paramBundle);
        this.b.addView(this.h);
        setContentView(this.b);
        Handler local3 = new Handler()
        {
          public final void handleMessage(Message paramAnonymousMessage)
          {
            try
            {
              int i = paramAnonymousMessage.what;
              switch (i)
              {
              default: 
                return;
              case 10: 
                try
                {
                  paramAnonymousMessage = (String)paramAnonymousMessage.obj;
                  AdlibWebBrowserActivity.this.d.loadUrl(paramAnonymousMessage);
                  AdlibWebBrowserActivity.this.g = paramAnonymousMessage;
                  AdlibWebBrowserActivity.this.a.addView(AdlibWebBrowserActivity.this.d);
                  AdlibWebBrowserActivity.this.a.addView(AdlibWebBrowserActivity.this.f);
                  AdlibWebBrowserActivity.this.b.addView(AdlibWebBrowserActivity.this.a);
                  return;
                }
                catch (Exception paramAnonymousMessage)
                {
                  return;
                }
              case 20: 
                try
                {
                  Object localObject = (AdlibWebBrowserActivity.d)paramAnonymousMessage.obj;
                  i = ((AdlibWebBrowserActivity.d)localObject).a;
                  paramAnonymousMessage = ((AdlibWebBrowserActivity.d)localObject).b;
                  localObject = ((AdlibWebBrowserActivity.d)localObject).c;
                  AdlibWebBrowserActivity.this.e = new WebView(AdlibWebBrowserActivity.this);
                  AdlibWebBrowserActivity.this.e.setLayoutParams(new LinearLayout.LayoutParams(-1, AdlibWebBrowserActivity.this.a(i)));
                  AdlibWebBrowserActivity.this.e.getSettings().setJavaScriptEnabled(true);
                  AdlibWebBrowserActivity.this.e.getSettings().setLoadWithOverviewMode(true);
                  AdlibWebBrowserActivity.this.e.getSettings().setUseWideViewPort(true);
                  AdlibWebBrowserActivity.this.e.setInitialScale(1);
                  AdlibWebBrowserActivity.this.e.setScrollBarStyle(33554432);
                  AdlibWebBrowserActivity.this.e.loadUrl(paramAnonymousMessage);
                  AdlibWebBrowserActivity.this.e.addJavascriptInterface(new AdlibWebBrowserActivity.JavascriptInterface(AdlibWebBrowserActivity.this), "gotoAds");
                  AdlibWebBrowserActivity.this.d.loadUrl((String)localObject);
                  AdlibWebBrowserActivity.this.g = ((String)localObject);
                  AdlibWebBrowserActivity.this.a.addView(AdlibWebBrowserActivity.this.d);
                  AdlibWebBrowserActivity.this.a.addView(AdlibWebBrowserActivity.this.f);
                  AdlibWebBrowserActivity.this.b.addView(AdlibWebBrowserActivity.this.e);
                  AdlibWebBrowserActivity.this.b.addView(AdlibWebBrowserActivity.this.a);
                  return;
                }
                catch (Exception paramAnonymousMessage)
                {
                  return;
                }
              case 30: 
                paramAnonymousMessage = new Intent("android.intent.action.VIEW", Uri.parse((String)paramAnonymousMessage.obj));
                try
                {
                  AdlibWebBrowserActivity.this.startActivity(paramAnonymousMessage);
                  AdlibWebBrowserActivity.this.finish();
                  return;
                }
                catch (Exception paramAnonymousMessage)
                {
                  return;
                }
              }
              AdlibWebBrowserActivity.this.finish();
              return;
            }
            catch (Exception paramAnonymousMessage) {}
          }
        };
        paramBundle = this.o;
        if (paramBundle == null) {
          try
          {
            throw new Exception();
          }
          catch (Exception paramBundle)
          {
            local3.sendEmptyMessage(40);
            return;
          }
        }
        paramBundle = new JSONObject(paramBundle);
        String str1 = paramBundle.getString("landing");
        try
        {
          String str2 = paramBundle.getString("ty");
          if (str2.equals("www")) {}
          for (paramBundle = Message.obtain(local3, 10, str1); paramBundle != null; paramBundle = Message.obtain(local3, 20, new d(paramBundle.getInt("h"), str2, str1)))
          {
            local3.sendMessage(paramBundle);
            return;
            if (!str2.equals("www2")) {
              break label717;
            }
            str2 = paramBundle.getString("header");
          }
          label717:
          throw new Exception();
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            paramBundle = Message.obtain(local3, 30, str1);
          }
        }
      }
    }
    this.m = 1;
    b();
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    if (this.j.equals("ko"))
    {
      if (this.d.canGoBack())
      {
        paramContextMenu.add(0, 1, 1, "<< 뒤로").setEnabled(true);
        if (!this.d.canGoForward()) {
          break label126;
        }
        paramContextMenu.add(0, 2, 2, ">> 앞으로").setEnabled(true);
      }
      for (;;)
      {
        paramContextMenu.add(0, 3, 3, "새로고침");
        paramContextMenu.add(0, 4, 4, "브라우저로 열기");
        super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
        return;
        paramContextMenu.add(0, 1, 1, "<< 뒤로").setEnabled(false);
        break;
        label126:
        paramContextMenu.add(0, 2, 2, ">> 앞으로").setEnabled(false);
      }
    }
    if (this.d.canGoBack())
    {
      paramContextMenu.add(0, 1, 1, "<< Back").setEnabled(true);
      label177:
      if (!this.d.canGoForward()) {
        break label257;
      }
      paramContextMenu.add(0, 2, 2, ">> Forward").setEnabled(true);
    }
    for (;;)
    {
      paramContextMenu.add(0, 3, 3, "Refresh");
      paramContextMenu.add(0, 4, 4, "Open with browser");
      break;
      paramContextMenu.add(0, 1, 1, "<< Back").setEnabled(false);
      break label177;
      label257:
      paramContextMenu.add(0, 2, 2, ">> Forward").setEnabled(false);
    }
  }
  
  protected void onDestroy()
  {
    if (this.d != null)
    {
      if (this.m != 1) {
        break label38;
      }
      this.b.removeView(this.d);
    }
    for (;;)
    {
      this.d.destroy();
      super.onDestroy();
      return;
      label38:
      this.b.removeAllViews();
      this.a.removeView(this.d);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 82) {
      openContextMenu(this.h);
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public class JavascriptInterface
  {
    private final Handler b = new Handler();
    
    JavascriptInterface() {}
    
    public void back()
    {
      this.b.post(new Runnable()
      {
        public final void run()
        {
          if (AdlibWebBrowserActivity.this.d.canGoBack())
          {
            AdlibWebBrowserActivity.this.a();
            return;
          }
          AdlibWebBrowserActivity.this.finish();
        }
      });
    }
    
    public void close()
    {
      this.b.post(new Runnable()
      {
        public final void run()
        {
          AdlibWebBrowserActivity.this.finish();
        }
      });
    }
    
    public void createShortcut(final String paramString1, final String paramString2, final String paramString3)
    {
      this.b.post(new Runnable()
      {
        public final void run()
        {
          AdlibWebBrowserActivity.this.a(paramString1, paramString2, paramString3);
        }
      });
    }
    
    public boolean hb()
    {
      return true;
    }
    
    public void loadBody(final String paramString)
    {
      this.b.post(new Runnable()
      {
        public final void run()
        {
          try
          {
            AdlibWebBrowserActivity.this.d.loadUrl(paramString);
            return;
          }
          catch (Exception localException) {}
        }
      });
    }
    
    public void loadHeader(final String paramString)
    {
      this.b.post(new Runnable()
      {
        public final void run()
        {
          try
          {
            AdlibWebBrowserActivity.this.e.loadUrl(paramString);
            return;
          }
          catch (Exception localException) {}
        }
      });
    }
    
    public void popup(final String paramString)
    {
      this.b.post(new Runnable()
      {
        public final void run()
        {
          Bundle localBundle = new Bundle();
          localBundle.putString("id", AdlibWebBrowserActivity.this.n);
          localBundle.putString("param", paramString);
          localBundle.putInt("type", 2);
          Intent localIntent = new Intent(AdlibWebBrowserActivity.this, AdlibWebBrowserActivity.class);
          localIntent.putExtras(localBundle);
          try
          {
            AdlibWebBrowserActivity.this.startActivity(localIntent);
            return;
          }
          catch (Exception localException) {}
        }
      });
    }
  }
  
  final class a
    implements Comparator<ResolveInfo>
  {
    a() {}
  }
  
  final class b
    extends WebChromeClient
  {
    private b() {}
    
    public final void onProgressChanged(WebView paramWebView, int paramInt)
    {
      AdlibWebBrowserActivity.this.f.setProgress(paramInt);
    }
  }
  
  static final class c
    extends FilterInputStream
  {
    public c(InputStream paramInputStream)
    {
      super();
    }
    
    public final long skip(long paramLong)
      throws IOException
    {
      long l2;
      for (long l1 = 0L;; l1 = l2 + l1)
      {
        if (l1 >= paramLong) {}
        do
        {
          return l1;
          long l3 = this.in.skip(paramLong - l1);
          l2 = l3;
          if (l3 != 0L) {
            break;
          }
        } while (read() < 0);
        l2 = 1L;
      }
    }
  }
  
  public final class d
  {
    public int a;
    public String b;
    public String c;
    
    d(int paramInt, String paramString1, String paramString2)
    {
      this.a = paramInt;
      this.b = paramString1;
      this.c = paramString2;
    }
  }
  
  final class e
    extends WebViewClient
  {
    private e() {}
    
    public final void onFormResubmission(WebView paramWebView, Message paramMessage1, Message paramMessage2)
    {
      paramMessage2.sendToTarget();
    }
    
    public final void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      AdlibWebBrowserActivity.this.f.setVisibility(4);
    }
    
    public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      AdlibWebBrowserActivity.this.f.setVisibility(0);
    }
    
    public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      if ((paramString.startsWith("http:")) || (paramString.startsWith("https:")))
      {
        if ((!AdlibWebBrowserActivity.this.l.equals("")) && (AdlibWebBrowserActivity.this.l.equals(paramString)))
        {
          AdlibWebBrowserActivity.this.l = "";
          paramWebView.goBack();
          return true;
        }
        paramWebView.loadUrl(paramString);
        return true;
      }
      try
      {
        paramWebView = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        AdlibWebBrowserActivity.this.startActivity(paramWebView);
        AdlibWebBrowserActivity.this.finish();
        return true;
      }
      catch (Exception paramWebView) {}
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mocoplex/adlib/AdlibWebBrowserActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */