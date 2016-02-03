package com.mobisystems.mobiscanner.controller;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.actionbarsherlock.app.SherlockFragment;
import com.mobisystems.mobiscanner.common.c;

public class WebFragment
  extends SherlockFragment
{
  private WebView aGV;
  private String aGW;
  private String aGX;
  private WebViewClient aGY = null;
  private final c mLog = new c(this);
  
  private void HS()
  {
    if (this.aGV != null)
    {
      if (this.aGW == null) {
        break label55;
      }
      this.mLog.dl("Show link: " + this.aGW);
      this.aGV.loadUrl(this.aGW);
    }
    label55:
    while (this.aGX == null) {
      return;
    }
    this.mLog.dl("Show data");
    this.aGV.loadData(this.aGX, "text/html", null);
  }
  
  public void dK(String paramString)
  {
    this.mLog.dl("setHomeLink called: " + paramString);
    this.aGW = paramString;
    this.aGX = null;
    HS();
  }
  
  public void dL(String paramString)
  {
    this.mLog.dl("setHomeData called");
    this.aGW = null;
    this.aGX = paramString;
    HS();
  }
  
  public void goBack()
  {
    this.aGV.goBack();
  }
  
  public void goForward()
  {
    this.aGV.goForward();
  }
  
  public void onAttach(Activity paramActivity)
  {
    this.mLog.dl("onAttach called");
    super.onAttach(paramActivity);
    if (WebActivity.class.isInstance(paramActivity)) {
      this.aGY = ((WebActivity)paramActivity).HQ();
    }
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mLog.dl("onCreateView called");
    paramLayoutInflater = (ViewGroup)paramLayoutInflater.inflate(2130903116, paramViewGroup, false);
    this.aGV = ((WebView)paramLayoutInflater.findViewById(2131165464));
    this.aGV.setWebViewClient(this.aGY);
    this.aGV.getSettings().setJavaScriptEnabled(true);
    return paramLayoutInflater;
  }
  
  public void onDetach()
  {
    this.mLog.dl("onDetach called");
    super.onDetach();
    this.aGY = null;
    this.aGV.setWebViewClient(this.aGY);
  }
  
  public void onStart()
  {
    this.mLog.dl("onStart called");
    super.onStart();
    HS();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/WebFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */