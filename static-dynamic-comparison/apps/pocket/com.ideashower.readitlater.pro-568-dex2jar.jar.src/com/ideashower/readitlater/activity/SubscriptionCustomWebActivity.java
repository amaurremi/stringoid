package com.ideashower.readitlater.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.ideashower.readitlater.a.ax;
import com.ideashower.readitlater.h.i;
import com.ideashower.readitlater.h.l;
import com.ideashower.readitlater.views.BaseWebView;
import com.ideashower.readitlater.views.RilButton;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.pocket.p.z;
import com.pocket.stats.f;
import com.pocket.webkit.JsInterface;

@SuppressLint({"SetJavaScriptEnabled"})
public class SubscriptionCustomWebActivity
  extends a
{
  private BaseWebView A = null;
  private com.ideashower.readitlater.g.g B;
  private ProgressDialog C = null;
  private RilButton z = null;
  
  public String f()
  {
    return "subscription_custom_login_web";
  }
  
  protected b l()
  {
    return b.a;
  }
  
  protected Drawable m()
  {
    return d(false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903068);
    paramBundle = getIntent().getStringExtra("RILextraDomain");
    if (paramBundle == null)
    {
      finish();
      return;
    }
    ((StyledToolbar)findViewById(2131230742)).a(getString(2131493501), false);
    this.z = ((RilButton)findViewById(2131230863));
    this.z.setText(2131492891);
    this.A = ((BaseWebView)findViewById(2131230730));
    this.A.setProgressBarVisibility(true);
    this.A.setWebViewClient(new bc(this, null));
    WebSettings localWebSettings = this.A.getSettings();
    z.a(localWebSettings, true);
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setSaveFormData(false);
    localWebSettings.setSavePassword(false);
    localWebSettings.setUserAgentString(ax.a(true));
    this.A.setScrollBarStyle(0);
    JsInterface.removeSearchBoxInterface(this.A);
    this.A.setWebChromeClient(new WebChromeClient()
    {
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        SubscriptionCustomWebActivity.a(SubscriptionCustomWebActivity.this).setProgress(paramAnonymousInt);
        if (paramAnonymousInt == 100) {
          SubscriptionCustomWebActivity.a(SubscriptionCustomWebActivity.this).setProgressBarVisibility(false);
        }
      }
    });
    this.A.loadUrl(paramBundle);
    this.z.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (SubscriptionCustomWebActivity.b(SubscriptionCustomWebActivity.this) != null) {
          return;
        }
        SubscriptionCustomWebActivity.this.showDialog(23);
        CookieSyncManager.getInstance().sync();
        SubscriptionCustomWebActivity.a(SubscriptionCustomWebActivity.this, new bd(SubscriptionCustomWebActivity.this, SubscriptionCustomWebActivity.a(SubscriptionCustomWebActivity.this).getUrl()).h());
      }
    });
    showDialog(21);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    case 21: 
      new AlertDialog.Builder(this).setTitle(2131493077).setMessage(2131493076).setNeutralButton(2131492924, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      }).create();
    case 23: 
      this.C = new ProgressDialog(this);
      this.C.setMessage(getString(2131493142));
      this.C.setIndeterminate(true);
      this.C.setCancelable(true);
      this.C.setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          SubscriptionCustomWebActivity.a(SubscriptionCustomWebActivity.this, null);
          SubscriptionCustomWebActivity.a(SubscriptionCustomWebActivity.this, null);
          SubscriptionCustomWebActivity.this.removeDialog(23);
        }
      });
      return this.C;
    }
    String str = com.ideashower.readitlater.util.g.a(this.A.getUrl());
    f.a(1, str);
    new AlertDialog.Builder(this).setTitle(2131493073).setMessage(String.format(getString(2131493072), new Object[] { str })).setNeutralButton(2131492924, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        i.b().a(com.ideashower.readitlater.h.a.aF, SubscriptionCustomWebActivity.this.getIntent().getStringExtra("RILextraDomain")).a();
        SubscriptionCustomWebActivity.this.finish();
      }
    }).create();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/SubscriptionCustomWebActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */