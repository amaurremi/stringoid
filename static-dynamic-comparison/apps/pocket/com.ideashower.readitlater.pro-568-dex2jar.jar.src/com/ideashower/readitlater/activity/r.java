package com.ideashower.readitlater.activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.ideashower.readitlater.a.ax;
import com.ideashower.readitlater.util.e;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;
import com.pocket.p.z;
import com.pocket.webkit.JsInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

public class r
  extends f
{
  private WebView Y;
  
  protected static r Y()
  {
    return new r();
  }
  
  private String a(String paramString)
  {
    try
    {
      paramString = Uri.parse(paramString).getEncodedFragment();
      Object localObject = new ArrayList();
      URLEncodedUtils.parse((List)localObject, new Scanner(paramString), "UTF-8");
      paramString = ((ArrayList)localObject).iterator();
      while (paramString.hasNext())
      {
        localObject = (NameValuePair)paramString.next();
        if (((NameValuePair)localObject).getName().equals("access_token"))
        {
          paramString = ((NameValuePair)localObject).getValue();
          return paramString;
        }
      }
    }
    catch (Exception paramString)
    {
      e.a(paramString);
    }
    return null;
  }
  
  public String K()
  {
    return "facebook_login";
  }
  
  public void a(Activity paramActivity)
  {
    if (!(paramActivity instanceof FacebookAuthActivity)) {
      e.a("The FacebookAuthFragment must be used within a FacebookAuthActivity in order to work. You attempted to use it with a " + paramActivity.getClass().getName());
    }
    super.a(paramActivity);
  }
  
  protected View c(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903069, paramViewGroup, false);
  }
  
  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    paramBundle = (StyledToolbar)c(2131230742);
    paramBundle.setTitle(2131493506);
    paramBundle.a(true, this);
    this.Y = ((WebView)c(2131230730));
    this.Y.setWebViewClient(new s(this, null));
    paramBundle = this.Y.getSettings();
    z.a(paramBundle, true);
    paramBundle.setJavaScriptEnabled(true);
    paramBundle.setBuiltInZoomControls(true);
    paramBundle.setLoadWithOverviewMode(true);
    paramBundle.setSaveFormData(false);
    paramBundle.setSavePassword(false);
    paramBundle.setUseWideViewPort(true);
    paramBundle.setUserAgentString(ax.a(false));
    JsInterface.removeSearchBoxInterface(this.Y);
    this.Y.setScrollBarStyle(0);
    this.Y.setBackgroundColor(0);
    this.Y.loadUrl("https://www.facebook.com/dialog/oauth/?client_id=131450656879143&redirect_uri=http://readitlaterlist.com/oauthcallback&state=1&display=touch&response_type=token");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */