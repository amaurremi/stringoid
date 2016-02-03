package com.appflood.mraid;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.util.Map;

final class v
  extends d
{
  v(Map<String, String> paramMap, AFBannerWebView paramAFBannerWebView)
  {
    super(paramMap, paramAFBannerWebView);
  }
  
  public final void a()
  {
    String str2 = b("uri");
    Context localContext = this.b.getContext();
    Intent localIntent = new Intent("android.intent.action.VIEW");
    String str1 = "";
    if (str2.toLowerCase().endsWith(".mp4")) {
      str1 = "mp4";
    }
    for (;;)
    {
      localIntent.setDataAndType(Uri.parse(str2), "video/" + str1);
      localContext.startActivity(localIntent);
      return;
      if (str2.toLowerCase().endsWith(".3gp")) {
        str1 = "3gp";
      } else if (str2.toLowerCase().endsWith(".mov")) {
        str1 = "mov";
      } else if (str2.toLowerCase().endsWith(".wmv")) {
        str1 = "wmv";
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/mraid/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */