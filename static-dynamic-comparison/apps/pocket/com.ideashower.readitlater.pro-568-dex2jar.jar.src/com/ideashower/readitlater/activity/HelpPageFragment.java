package com.ideashower.readitlater.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.pocket.p.l;
import com.pocket.p.z;

public class HelpPageFragment
  extends f
{
  private String Y;
  private String Z;
  private WebView aa = null;
  
  public static l Y()
  {
    if (com.ideashower.readitlater.util.j.g()) {
      return l.a;
    }
    return l.b;
  }
  
  public static HelpPageFragment a(int paramInt, String paramString)
  {
    HelpPageFragment localHelpPageFragment = new HelpPageFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("title", paramInt);
    localBundle.putString("config_file", paramString);
    localHelpPageFragment.g(localBundle);
    return localHelpPageFragment;
  }
  
  public static void a(android.support.v4.app.f paramf, int paramInt, String paramString)
  {
    if (Y() == l.a)
    {
      com.pocket.p.k.a(a(paramInt, paramString), paramf);
      return;
    }
    HelpPageActivity.a(paramf, paramInt, paramString);
  }
  
  public String K()
  {
    return "help_" + org.apache.a.c.k.c(this.Z);
  }
  
  protected View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903069, paramViewGroup, false);
  }
  
  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    paramBundle = a(2131493242);
    this.Y = com.ideashower.readitlater.a.j.a(true, l().getString("config_file").replace(".html", paramBundle + ".html"));
    paramBundle = (StyledToolbar)c(2131230742);
    paramBundle.a(a(l().getInt("title")), false);
    paramBundle.a(true, this);
    this.aa = ((WebView)c(2131230730));
    this.aa.setWebViewClient(new y(this, null));
    paramBundle = this.aa.getSettings();
    z.a(paramBundle, true);
    paramBundle.setJavaScriptEnabled(true);
    paramBundle.setBuiltInZoomControls(true);
    paramBundle.setLoadWithOverviewMode(true);
    paramBundle.setSaveFormData(false);
    paramBundle.setSavePassword(false);
    if (this.Y.startsWith("file:")) {}
    for (boolean bool = false;; bool = true)
    {
      paramBundle.setUseWideViewPort(bool);
      this.aa.addJavascriptInterface(new HelpPageFragment.JSInterface(this), "Pocket");
      this.aa.setScrollBarStyle(0);
      this.aa.setBackgroundColor(0);
      this.aa.loadUrl(this.Y);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/HelpPageFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */