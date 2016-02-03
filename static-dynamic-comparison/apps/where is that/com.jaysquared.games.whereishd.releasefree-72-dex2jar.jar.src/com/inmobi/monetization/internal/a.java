package com.inmobi.monetization.internal;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.inmobi.commons.internal.Log;
import java.util.ArrayList;

class a
  extends WebViewClient
{
  a(TrackerView paramTrackerView) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    Log.internal("[InMobi]-[Monetization]", "Native ad context code loaded");
    TrackerView.a(this.a, true);
    if ((TrackerView.a(this.a) != null) && (!TrackerView.a(this.a).isEmpty()))
    {
      int i = 0;
      while (i < TrackerView.a(this.a).size())
      {
        this.a.injectJavaScript((String)TrackerView.a(this.a).get(i));
        i += 1;
      }
      TrackerView.a(this.a).clear();
      TrackerView.a(this.a, null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/monetization/internal/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */