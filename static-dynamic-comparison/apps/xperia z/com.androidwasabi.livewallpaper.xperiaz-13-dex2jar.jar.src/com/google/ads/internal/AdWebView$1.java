package com.google.ads.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;

class AdWebView$1
  implements DownloadListener
{
  AdWebView$1(AdWebView paramAdWebView) {}
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    try
    {
      paramString2 = new Intent("android.intent.action.VIEW");
      paramString2.setDataAndType(Uri.parse(paramString1), paramString4);
      paramString3 = this.a.i();
      if ((paramString3 != null) && (AdUtil.a(paramString2, paramString3))) {
        paramString3.startActivity(paramString2);
      }
      return;
    }
    catch (ActivityNotFoundException paramString2)
    {
      b.a("Couldn't find an Activity to view url/mimetype: " + paramString1 + " / " + paramString4);
      return;
    }
    catch (Throwable paramString2)
    {
      b.b("Unknown error trying to start activity to view URL: " + paramString1, paramString2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/google/ads/internal/AdWebView$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */