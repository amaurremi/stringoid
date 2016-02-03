package com.vungle.publisher.display.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.vungle.publisher.aw;
import com.vungle.publisher.aw.a;

abstract class WebViewFragment
  extends AdFragment
{
  protected WebView a;
  private final aw.a b;
  private final String c;
  
  protected WebViewFragment(String paramString, aw.a parama)
  {
    this.c = paramString;
    this.b = parama;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = getActivity();
    paramLayoutInflater = new WebView(paramViewGroup);
    this.a = paramLayoutInflater;
    paramLayoutInflater.setWebViewClient(new aw(this.b));
    paramBundle = paramLayoutInflater.getSettings();
    paramBundle.setBuiltInZoomControls(false);
    paramBundle.setJavaScriptEnabled(true);
    paramBundle.setLoadsImagesAutomatically(true);
    paramBundle.setLoadWithOverviewMode(true);
    paramBundle.setSavePassword(true);
    paramBundle.setSaveFormData(true);
    paramBundle.setUseWideViewPort(false);
    paramLayoutInflater.setBackgroundColor(0);
    paramLayoutInflater.setBackgroundResource(0);
    paramLayoutInflater.loadUrl(this.c);
    paramViewGroup = new FrameLayout(paramViewGroup);
    paramViewGroup.addView(paramLayoutInflater);
    paramLayoutInflater = paramLayoutInflater.getLayoutParams();
    paramLayoutInflater.width = -1;
    paramLayoutInflater.height = -1;
    return paramViewGroup;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/display/view/WebViewFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */