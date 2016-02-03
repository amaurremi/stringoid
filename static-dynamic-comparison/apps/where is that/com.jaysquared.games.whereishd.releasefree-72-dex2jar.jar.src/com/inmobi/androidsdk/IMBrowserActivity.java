package com.inmobi.androidsdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.provider.MediaStore.Images.Media;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import com.inmobi.re.container.CustomView;
import com.inmobi.re.container.CustomView.SwitchIconType;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.IMWebView.IMWebViewListener;
import com.inmobi.re.container.mraidimpl.MRAIDAudioVideoController;
import com.inmobi.re.controller.util.StartActivityForResultCallback;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
public class IMBrowserActivity
  extends Activity
{
  public static final String EXTRA_BROWSER_ACTIVITY_TYPE = "extra_browser_type";
  public static final int EXTRA_BROWSER_STATUS_BAR = 101;
  public static final String EXTRA_URL = "extra_url";
  public static final int GET_IMAGE = 101;
  private static IMWebView.IMWebViewListener b;
  private static Message c;
  private static Map<Integer, StartActivityForResultCallback> h = new HashMap();
  private static int i = 0;
  private IMWebView a;
  private RelativeLayout d;
  private float e;
  private Boolean f;
  private CustomView g;
  private WebViewClient j = new g(this);
  
  private void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    String str1;
    switch (paramInt1)
    {
    default: 
      str1 = null;
    }
    String str2;
    for (;;)
    {
      str2 = paramString1 + " " + paramString2 + " " + paramString3;
      Intent localIntent = new Intent();
      localIntent.setType("text/plain");
      localIntent.setPackage(str1);
      localIntent.putExtra("android.intent.extra.TEXT", str2);
      try
      {
        startActivityForResult(localIntent, paramInt2);
        return;
      }
      catch (Exception localException)
      {
        switch (paramInt1)
        {
        }
        for (;;)
        {
          paramString1 = null;
          while (paramString1 != null)
          {
            paramString2 = new Intent("android.intent.action.VIEW");
            paramString2.setData(Uri.parse(paramString1));
            try
            {
              startActivityForResult(paramString2, paramInt2);
              return;
            }
            catch (Exception paramString1)
            {
              onActivityResult(paramInt2, 0, null);
              return;
            }
            try
            {
              paramString1 = "https://www.facebook.com/dialog/feed?app_id=181821551957328&link=" + URLEncoder.encode(paramString2, "UTF-8") + "&picture=" + URLEncoder.encode(paramString3, "UTF-8") + "&name=&description=" + URLEncoder.encode(paramString1, "UTF-8") + "&redirect_uri=" + URLEncoder.encode(paramString2, "UTF-8");
            }
            catch (UnsupportedEncodingException paramString1)
            {
              Log.internal("[InMobi]-[RE]-4.1.1", "UTF-8 encoding not supported? What sorcery is this?", paramString1);
            }
            paramString1 = "https://m.google.com/app/plus/x/?v=compose&content=" + URLEncoder.encode(str2, "UTF-8");
            continue;
            paramString1 = "http://twitter.com/home?status=" + URLEncoder.encode(str2, "UTF-8");
          }
        }
        paramString1 = new Intent();
        paramString1.setType("text/plain");
        paramString1.putExtra("android.intent.extra.TEXT", str2);
        try
        {
          startActivityForResult(paramString1, paramInt2);
          return;
        }
        catch (Exception paramString1)
        {
          onActivityResult(paramInt2, 0, null);
        }
      }
      str1 = "";
      continue;
      str1 = "com.google.android.apps.plus";
      continue;
      str1 = "com.twitter.android";
    }
  }
  
  private void a(long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent("android.intent.action.EDIT");
    localIntent.setType("vnd.android.cursor.item/event");
    localIntent.putExtra("beginTime", paramLong1);
    localIntent.putExtra("allDay", true);
    localIntent.putExtra("endTime", paramLong2);
    localIntent.putExtra("title", paramString1);
    localIntent.putExtra("eventLocation", paramString2);
    try
    {
      startActivityForResult(localIntent, paramInt);
      return;
    }
    catch (Exception paramString1)
    {
      onActivityResult(paramInt, 0, null);
    }
  }
  
  private void a(Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("action");
    int k = paramIntent.getIntExtra("id", 0);
    if (((String)localObject).equals("takeCameraPicture"))
    {
      paramIntent = (Uri)paramIntent.getExtras().get("URI");
      localObject = new Intent("android.media.action.IMAGE_CAPTURE");
      ((Intent)localObject).putExtra("output", paramIntent);
    }
    do
    {
      try
      {
        startActivityForResult((Intent)localObject, k);
        return;
      }
      catch (Exception paramIntent)
      {
        onActivityResult(k, 0, null);
        return;
      }
      if (((String)localObject).equals("getGalleryImage"))
      {
        paramIntent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        try
        {
          startActivityForResult(paramIntent, k);
          return;
        }
        catch (Exception paramIntent)
        {
          onActivityResult(k, 0, null);
          return;
        }
      }
      if (((String)localObject).equals("postToSocial"))
      {
        a(paramIntent.getIntExtra("socialType", 0), paramIntent.getStringExtra("text"), paramIntent.getStringExtra("link"), paramIntent.getStringExtra("image"), k);
        return;
      }
    } while (!((String)localObject).equals("createCalendarEvent"));
    a(paramIntent.getLongExtra("start", 0L), paramIntent.getLongExtra("end", 0L), paramIntent.getStringExtra("description"), paramIntent.getStringExtra("location"), k);
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(0);
    localLinearLayout.setId(100);
    localLinearLayout.setWeightSum(100.0F);
    localLinearLayout.setOnTouchListener(new e());
    localLinearLayout.setBackgroundResource(17301658);
    localLinearLayout.setBackgroundColor(-7829368);
    Object localObject = new RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), (int)(44.0F * this.e));
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    paramViewGroup.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject);
    paramViewGroup = new LinearLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
    paramViewGroup.weight = 25.0F;
    localObject = new CustomView(this, this.e, CustomView.SwitchIconType.CLOSE_ICON);
    localLinearLayout.addView((View)localObject, paramViewGroup);
    ((CustomView)localObject).setOnTouchListener(new c());
    localObject = new CustomView(this, this.e, CustomView.SwitchIconType.REFRESH);
    localLinearLayout.addView((View)localObject, paramViewGroup);
    ((CustomView)localObject).setOnTouchListener(new d());
    localObject = new CustomView(this, this.e, CustomView.SwitchIconType.BACK);
    localLinearLayout.addView((View)localObject, paramViewGroup);
    ((CustomView)localObject).setOnTouchListener(new a());
    this.g = new CustomView(this, this.e, CustomView.SwitchIconType.FORWARD_INACTIVE);
    localLinearLayout.addView(this.g, paramViewGroup);
    this.g.setOnTouchListener(new b());
  }
  
  public static int generateId(StartActivityForResultCallback paramStartActivityForResultCallback)
  {
    i += 1;
    h.put(Integer.valueOf(i), paramStartActivityForResultCallback);
    return i;
  }
  
  public static void requestOnAdDismiss(Message paramMessage)
  {
    c = paramMessage;
  }
  
  public static void setWebViewListener(IMWebView.IMWebViewListener paramIMWebViewListener)
  {
    b = paramIMWebViewListener;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    try
    {
      ((StartActivityForResultCallback)h.get(Integer.valueOf(paramInt1))).onActivityResult(paramInt2, paramIntent);
      h.remove(Integer.valueOf(paramInt2));
      finish();
      return;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        Log.internal("[InMobi]-[RE]-4.1.1", "onActivityResult failed", paramIntent);
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.a != null) {
      this.a.onOrientationEventChange();
    }
    super.onConfigurationChanged(paramConfiguration);
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    if ((Build.VERSION.SDK_INT < 9) || (Build.VERSION.SDK_INT >= 11)) {
      getWindow().setFlags(1024, 1024);
    }
    paramBundle = (WindowManager)getSystemService("window");
    Object localObject = new DisplayMetrics();
    paramBundle.getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    paramBundle = getIntent();
    if (paramBundle.getStringExtra("action") != null) {
      a(paramBundle);
    }
    this.e = getResources().getDisplayMetrics().density;
    localObject = paramBundle.getStringExtra("extra_url");
    this.f = Boolean.valueOf(paramBundle.getBooleanExtra("FIRST_INSTANCE", false));
    Log.debug("[InMobi]-[RE]-4.1.1", "IMBrowserActivity-> onCreate");
    CookieSyncManager.createInstance(this);
    CookieSyncManager.getInstance().startSync();
    if (localObject != null)
    {
      boolean bool = paramBundle.getBooleanExtra("QAMODE", false);
      paramBundle = null;
      this.d = new RelativeLayout(this);
      this.a = new IMWebView(this, b, true, true);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
      localLayoutParams.addRule(10);
      localLayoutParams.addRule(2, 100);
      this.d.setBackgroundColor(-1);
      this.d.addView(this.a, localLayoutParams);
      a(this.d);
      this.a.getSettings().setJavaScriptEnabled(true);
      this.a.setExternalWebViewClient(this.j);
      this.a.getSettings().setLoadWithOverviewMode(true);
      this.a.getSettings().setUseWideViewPort(true);
      if (bool)
      {
        paramBundle = new HashMap();
        paramBundle.put("mk-carrier", "117.97.87.6");
        paramBundle.put("x-real-ip", "117.97.87.6");
      }
      if (Build.VERSION.SDK_INT < 8) {
        break label350;
      }
      this.a.loadUrl((String)localObject, paramBundle);
    }
    for (;;)
    {
      setContentView(this.d);
      return;
      label350:
      this.a.loadUrl((String)localObject);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      b = null;
      if (this.a != null) {
        this.a.mAudioVideoController.releaseAllPlayers();
      }
      if ((c != null) && (this.f.booleanValue()))
      {
        c.sendToTarget();
        c = null;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.debug("[InMobi]-[RE]-4.1.1", "Exception in onDestroy ", localException);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    CookieSyncManager.getInstance().stopSync();
  }
  
  protected void onResume()
  {
    super.onResume();
    CookieSyncManager.getInstance().startSync();
  }
  
  class a
    implements View.OnTouchListener
  {
    a() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      if (paramMotionEvent.getAction() == 1)
      {
        paramView.setBackgroundColor(-7829368);
        if (IMBrowserActivity.a(IMBrowserActivity.this).canGoBack()) {
          IMBrowserActivity.a(IMBrowserActivity.this).goBack();
        }
      }
      while (paramMotionEvent.getAction() != 0)
      {
        return true;
        IMBrowserActivity.this.finish();
        return true;
      }
      paramView.setBackgroundColor(-16711681);
      return true;
    }
  }
  
  class b
    implements View.OnTouchListener
  {
    b() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      if (paramMotionEvent.getAction() == 1)
      {
        paramView.setBackgroundColor(-7829368);
        if (IMBrowserActivity.a(IMBrowserActivity.this).canGoForward()) {
          IMBrowserActivity.a(IMBrowserActivity.this).goForward();
        }
      }
      while (paramMotionEvent.getAction() != 0) {
        return true;
      }
      paramView.setBackgroundColor(-16711681);
      return true;
    }
  }
  
  class c
    implements View.OnTouchListener
  {
    c() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      if (paramMotionEvent.getAction() == 1)
      {
        paramView.setBackgroundColor(-7829368);
        IMBrowserActivity.this.finish();
      }
      while (paramMotionEvent.getAction() != 0) {
        return true;
      }
      paramView.setBackgroundColor(-16711681);
      return true;
    }
  }
  
  class d
    implements View.OnTouchListener
  {
    d() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      if (paramMotionEvent.getAction() == 1)
      {
        paramView.setBackgroundColor(-7829368);
        IMBrowserActivity.a(IMBrowserActivity.this).doHidePlayers();
        IMBrowserActivity.a(IMBrowserActivity.this).reload();
      }
      while (paramMotionEvent.getAction() != 0) {
        return true;
      }
      paramView.setBackgroundColor(-16711681);
      return true;
    }
  }
  
  class e
    implements View.OnTouchListener
  {
    e() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/androidsdk/IMBrowserActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */