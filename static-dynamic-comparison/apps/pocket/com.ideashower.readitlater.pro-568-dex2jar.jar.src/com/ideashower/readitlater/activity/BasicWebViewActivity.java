package com.ideashower.readitlater.activity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.pocket.p.z;
import com.pocket.webkit.JsInterface;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class BasicWebViewActivity
  extends a
{
  private WebView z = null;
  
  protected int C()
  {
    return 2130903044;
  }
  
  protected int D()
  {
    return 2131230755;
  }
  
  public String f()
  {
    return getClass().getName();
  }
  
  protected b l()
  {
    return b.d;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.t = true;
    super.onCreate(paramBundle);
    setContentView(C());
    Object localObject = getIntent();
    paramBundle = ((Intent)localObject).getStringExtra("pathToLoad");
    boolean bool2 = ((Intent)localObject).getBooleanExtra("postAccount", false);
    if (paramBundle == null)
    {
      q();
      return;
    }
    this.z = ((WebView)findViewById(D()));
    this.z.setWebViewClient(new l(this, null));
    localObject = this.z.getSettings();
    z.a((WebSettings)localObject, true);
    JsInterface.removeSearchBoxInterface(this.z);
    ((WebSettings)localObject).setJavaScriptEnabled(true);
    ((WebSettings)localObject).setBuiltInZoomControls(true);
    ((WebSettings)localObject).setLoadWithOverviewMode(true);
    ((WebSettings)localObject).setSaveFormData(false);
    ((WebSettings)localObject).setSavePassword(false);
    if (paramBundle.startsWith("file")) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      ((WebSettings)localObject).setUseWideViewPort(bool1);
      this.z.setScrollBarStyle(0);
      this.z.setBackgroundColor(0);
      if (bool2) {
        break;
      }
      localObject = new HashMap();
      String str1 = Locale.getDefault().getLanguage();
      String str2 = Locale.getDefault().getCountry();
      ((Map)localObject).put("Accept-Language", str1 + "-" + str2);
      this.z.loadUrl(paramBundle, (Map)localObject);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/BasicWebViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */