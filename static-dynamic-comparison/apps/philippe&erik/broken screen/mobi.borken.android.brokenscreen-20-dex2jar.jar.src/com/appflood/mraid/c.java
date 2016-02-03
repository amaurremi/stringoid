package com.appflood.mraid;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.appflood.AFListActivity.1;
import com.appflood.e.j;
import java.net.URLDecoder;

public final class c
  extends b
{
  public c(AFBannerWebView paramAFBannerWebView)
  {
    super(paramAFBannerWebView);
  }
  
  protected final void a(String paramString)
  {
    new StringBuilder("Opening in-app browser: ").append(paramString).toString();
    j.a();
    super.a().i();
    Context localContext = super.a().getContext();
    String str2 = Uri.parse(paramString).getScheme();
    if ("tel".equals(str2))
    {
      AFListActivity.1.a(localContext, paramString.substring(str2.length() + 1, paramString.length()));
      return;
    }
    if ("sms".equals(str2))
    {
      String str1 = URLDecoder.decode(paramString);
      localObject = "";
      paramString = str1;
      if (str1.contains("?body="))
      {
        localObject = str1.split("body=");
        paramString = localObject[0].substring(0, localObject[0].length() - 1);
        localObject = localObject[1];
      }
      AFListActivity.1.a(localContext, paramString.substring(str2.length() + 3, paramString.length()), (String)localObject);
      return;
    }
    Object localObject = new Intent(localContext, MraidBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramString);
    localContext.startActivity((Intent)localObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/mraid/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */