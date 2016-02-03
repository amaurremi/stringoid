package com.ideashower.readitlater.activity;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.h.a;
import com.ideashower.readitlater.h.i;
import com.pocket.p.k;
import com.pocket.p.l;
import com.pocket.tts.m;

class y
  extends WebViewClient
{
  private y(HelpPageFragment paramHelpPageFragment) {}
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ("pocket:tts_settings".equals(paramString)) {
      m.a(this.a.m());
    }
    if ("pocket:open_gsf_demos".equals(paramString))
    {
      if (!i.a(a.bE)) {
        break label75;
      }
      if (v.Y() != l.a) {
        break label61;
      }
      k.a(v.Z(), this.a.m());
    }
    for (;;)
    {
      return true;
      label61:
      GsfActivity.a(this.a.m(), 3);
      continue;
      label75:
      g.a(this.a.m(), "http://readitlaterlist.com/abm");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */