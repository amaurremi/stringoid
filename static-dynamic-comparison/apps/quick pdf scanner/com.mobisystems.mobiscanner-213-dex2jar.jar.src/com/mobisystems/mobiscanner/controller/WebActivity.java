package com.mobisystems.mobiscanner.controller;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.google.analytics.tracking.android.l;
import com.mobisystems.mobiscanner.common.CommonPreferences.Keys;
import com.mobisystems.mobiscanner.common.c;
import com.mobisystems.mobiscanner.error.a;

public class WebActivity
  extends SherlockFragmentActivity
{
  private MenuItem aGQ;
  private MenuItem aGR;
  private boolean aGS = false;
  private boolean aGT = false;
  private String axF = "";
  private final c mLog = new c(this);
  
  private void Ef()
  {
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }
  
  private void Er()
  {
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.setTitle(this.axF);
    }
  }
  
  public WebViewClient HQ()
  {
    return new a(null);
  }
  
  public void HR()
  {
    int i = getResources().getInteger(2131492870);
    int j = getResources().getInteger(2131492871);
    if (this.aGQ != null)
    {
      if (!this.aGS) {
        break label97;
      }
      this.aGQ.setEnabled(true);
      this.aGQ.getIcon().setAlpha(i);
    }
    for (;;)
    {
      if (this.aGR != null)
      {
        if (!this.aGT) {
          break;
        }
        this.aGR.setEnabled(true);
        this.aGR.getIcon().setAlpha(i);
      }
      return;
      label97:
      this.aGQ.setEnabled(false);
      this.aGQ.getIcon().setAlpha(j);
    }
    this.aGR.setEnabled(false);
    this.aGR.getIcon().setAlpha(j);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.mLog.dl("onConfigurationChanged called");
    super.onConfigurationChanged(paramConfiguration);
    Er();
    HR();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    a.ay(getApplicationContext());
    this.mLog.dl("OnCreate called");
    super.onCreate(paramBundle);
    setContentView(2130903077);
    Ef();
    paramBundle = (WebFragment)getSupportFragmentManager().findFragmentById(2131165360);
    if (paramBundle != null)
    {
      String str = getIntent().getStringExtra("WEB_ACTIVITY_HOME_LINK");
      if (str != null) {
        paramBundle.dK(str);
      }
    }
    else
    {
      return;
    }
    paramBundle.dL(getIntent().getStringExtra("WEB_ACTIVITY_HOME_DATA"));
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    this.mLog.dl("onCreateOptionsMenu called");
    getSupportMenuInflater().inflate(2131689477, paramMenu);
    this.aGQ = paramMenu.findItem(2131165592);
    this.aGR = paramMenu.findItem(2131165593);
    HR();
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    case 16908332: 
      finish();
      return true;
    case 2131165592: 
      paramMenuItem = (WebFragment)getSupportFragmentManager().findFragmentById(2131165360);
      if (paramMenuItem != null) {
        paramMenuItem.goBack();
      }
      return true;
    case 2131165593: 
      paramMenuItem = (WebFragment)getSupportFragmentManager().findFragmentById(2131165360);
      if (paramMenuItem != null) {
        paramMenuItem.goForward();
      }
      return true;
    case 2131165594: 
      HelpAboutHelper.a(this, HelpAboutHelper.HelpTopic.aCY);
      return true;
    }
    HelpAboutHelper.showAbout(this);
    return true;
  }
  
  public void onStart()
  {
    this.mLog.dl("onStart called");
    super.onStart();
    if (CommonPreferences.Keys.apu.Dm()) {
      getWindow().clearFlags(1024);
    }
    for (;;)
    {
      l.e(this).a(this);
      return;
      getWindow().addFlags(1024);
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    l.e(this).b(this);
  }
  
  private class a
    extends WebViewClient
  {
    private a() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      WebActivity.a(WebActivity.this, paramWebView.canGoBack());
      WebActivity.b(WebActivity.this, paramWebView.canGoForward());
      WebActivity.a(WebActivity.this, paramWebView.getTitle());
      WebActivity.a(WebActivity.this);
      WebActivity.this.HR();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/WebActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */