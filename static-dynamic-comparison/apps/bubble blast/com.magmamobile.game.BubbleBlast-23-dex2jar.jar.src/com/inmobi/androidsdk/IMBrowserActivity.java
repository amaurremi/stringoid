package com.inmobi.androidsdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
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
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.inmobi.androidsdk.ai.container.IMCustomView;
import com.inmobi.androidsdk.ai.container.IMCustomView.SwitchIconType;
import com.inmobi.androidsdk.ai.container.IMWebView;
import com.inmobi.androidsdk.ai.container.IMWebView.IMWebViewListener;
import com.inmobi.androidsdk.ai.container.IMWrapperFunctions;
import com.inmobi.commons.internal.IMLog;

public class IMBrowserActivity
  extends Activity
{
  public static final String EXTRA_BROWSER_ACTIVITY_TYPE = "extra_browser_type";
  public static final int EXTRA_BROWSER_STATUS_BAR = 101;
  public static final String EXTRA_URL = "extra_url";
  private static IMWebView.IMWebViewListener b;
  private static Message c;
  private IMWebView a;
  private RelativeLayout d;
  private float e;
  private Boolean f;
  private IMCustomView g;
  private WebViewClient h = new WebViewClient()
  {
    public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
      if (IMBrowserActivity.a(IMBrowserActivity.this) != null)
      {
        if (!paramAnonymousWebView.canGoForward()) {
          break label53;
        }
        IMBrowserActivity.a(IMBrowserActivity.this).setSwitchInt(IMCustomView.SwitchIconType.FORWARD_ACTIVE);
        IMBrowserActivity.a(IMBrowserActivity.this).invalidate();
      }
      for (;;)
      {
        CookieSyncManager.getInstance().sync();
        return;
        label53:
        IMBrowserActivity.a(IMBrowserActivity.this).setSwitchInt(IMCustomView.SwitchIconType.FORWARD_INACTIVE);
        IMBrowserActivity.a(IMBrowserActivity.this).invalidate();
      }
    }
    
    public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
    {
      super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
      if (IMBrowserActivity.a(IMBrowserActivity.this) != null)
      {
        IMBrowserActivity.a(IMBrowserActivity.this).setSwitchInt(IMCustomView.SwitchIconType.FORWARD_INACTIVE);
        IMBrowserActivity.a(IMBrowserActivity.this).invalidate();
      }
    }
  };
  
  private void a(ViewGroup paramViewGroup)
  {
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(0);
    localLinearLayout.setId(100);
    localLinearLayout.setWeightSum(100.0F);
    localLinearLayout.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    localLinearLayout.setBackgroundResource(17301658);
    localLinearLayout.setBackgroundColor(-7829368);
    Object localObject = new RelativeLayout.LayoutParams(IMWrapperFunctions.getParamFillParent(), (int)(44.0F * this.e));
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    paramViewGroup.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject);
    paramViewGroup = new LinearLayout.LayoutParams(IMWrapperFunctions.getParamFillParent(), IMWrapperFunctions.getParamFillParent());
    paramViewGroup.weight = 25.0F;
    localObject = new IMCustomView(this, this.e, IMCustomView.SwitchIconType.CLOSE_ICON);
    localLinearLayout.addView((View)localObject, paramViewGroup);
    ((IMCustomView)localObject).setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          paramAnonymousView.setBackgroundColor(-7829368);
          IMBrowserActivity.this.finish();
        }
        while (paramAnonymousMotionEvent.getAction() != 0) {
          return true;
        }
        paramAnonymousView.setBackgroundColor(-16711681);
        return true;
      }
    });
    localObject = new IMCustomView(this, this.e, IMCustomView.SwitchIconType.REFRESH);
    localLinearLayout.addView((View)localObject, paramViewGroup);
    ((IMCustomView)localObject).setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          paramAnonymousView.setBackgroundColor(-7829368);
          IMBrowserActivity.b(IMBrowserActivity.this).doHidePlayers();
          IMBrowserActivity.b(IMBrowserActivity.this).reload();
        }
        while (paramAnonymousMotionEvent.getAction() != 0) {
          return true;
        }
        paramAnonymousView.setBackgroundColor(-16711681);
        return true;
      }
    });
    localObject = new IMCustomView(this, this.e, IMCustomView.SwitchIconType.BACK);
    localLinearLayout.addView((View)localObject, paramViewGroup);
    ((IMCustomView)localObject).setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          paramAnonymousView.setBackgroundColor(-7829368);
          if (IMBrowserActivity.b(IMBrowserActivity.this).canGoBack()) {
            IMBrowserActivity.b(IMBrowserActivity.this).goBack();
          }
        }
        while (paramAnonymousMotionEvent.getAction() != 0)
        {
          return true;
          IMBrowserActivity.this.finish();
          return true;
        }
        paramAnonymousView.setBackgroundColor(-16711681);
        return true;
      }
    });
    this.g = new IMCustomView(this, this.e, IMCustomView.SwitchIconType.FORWARD_INACTIVE);
    localLinearLayout.addView(this.g, paramViewGroup);
    this.g.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          paramAnonymousView.setBackgroundColor(-7829368);
          if (IMBrowserActivity.b(IMBrowserActivity.this).canGoForward()) {
            IMBrowserActivity.b(IMBrowserActivity.this).goForward();
          }
        }
        while (paramAnonymousMotionEvent.getAction() != 0) {
          return true;
        }
        paramAnonymousView.setBackgroundColor(-16711681);
        return true;
      }
    });
  }
  
  public static void requestOnAdDismiss(Message paramMessage)
  {
    c = paramMessage;
  }
  
  public static void setWebViewListener(IMWebView.IMWebViewListener paramIMWebViewListener)
  {
    b = paramIMWebViewListener;
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
    this.e = getResources().getDisplayMetrics().density;
    localObject = getIntent();
    paramBundle = ((Intent)localObject).getStringExtra("extra_url");
    this.f = Boolean.valueOf(((Intent)localObject).getBooleanExtra("FIRST_INSTANCE", false));
    IMLog.debug("InMobiAndroidSDK_3.6.1", "IMBrowserActivity-> onCreate");
    if (paramBundle != null)
    {
      this.d = new RelativeLayout(this);
      this.a = new IMWebView(this, b, true, true);
      localObject = new RelativeLayout.LayoutParams(IMWrapperFunctions.getParamFillParent(), IMWrapperFunctions.getParamFillParent());
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 100);
      this.d.setBackgroundColor(-1);
      this.d.addView(this.a, (ViewGroup.LayoutParams)localObject);
      a(this.d);
      this.a.getSettings().setJavaScriptEnabled(true);
      this.a.setExternalWebViewClient(this.h);
      this.a.getSettings().setLoadWithOverviewMode(true);
      this.a.getSettings().setUseWideViewPort(true);
      this.a.loadUrl(paramBundle);
      CookieSyncManager.createInstance(this);
      CookieSyncManager.getInstance().startSync();
      setContentView(this.d);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      if (this.a != null) {
        this.a.releaseAllPlayers();
      }
      if ((c != null) && (this.f.booleanValue())) {
        c.sendToTarget();
      }
      return;
    }
    catch (Exception localException)
    {
      IMLog.debug("InMobiAndroidSDK_3.6.1", "Exception in onDestroy ", localException);
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/androidsdk/IMBrowserActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */