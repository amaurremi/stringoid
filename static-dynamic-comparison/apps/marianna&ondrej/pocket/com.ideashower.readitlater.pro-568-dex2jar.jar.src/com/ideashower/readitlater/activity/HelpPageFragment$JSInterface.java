package com.ideashower.readitlater.activity;

import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.util.NoObfuscation;
import com.ideashower.readitlater.util.a;
import com.ideashower.readitlater.util.j;

public class HelpPageFragment$JSInterface
  implements NoObfuscation
{
  public HelpPageFragment$JSInterface(HelpPageFragment paramHelpPageFragment) {}
  
  @JavascriptInterface
  public void onReady()
  {
    HelpPageFragment.a(this.a).post(new Runnable()
    {
      public void run()
      {
        HelpPageFragment.a(HelpPageFragment.JSInterface.this.a).loadUrl("javascript: show(" + j.c() + ", " + a.p() + ", " + m.b(HelpPageFragment.JSInterface.this.a.m()) + ", " + j.a(true) + ", " + j.i() + ");");
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/HelpPageFragment$JSInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */