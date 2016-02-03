package com.appflood.mraid;

import java.util.Map;

public abstract class d
{
  protected Map<String, String> a;
  protected AFBannerWebView b;
  
  d(Map<String, String> paramMap, AFBannerWebView paramAFBannerWebView)
  {
    this.a = paramMap;
    this.b = paramAFBannerWebView;
  }
  
  protected final int a(String paramString)
  {
    paramString = (String)this.a.get(paramString);
    if (paramString == null) {
      return -1;
    }
    try
    {
      int i = Integer.parseInt(paramString, 10);
      return i;
    }
    catch (NumberFormatException paramString) {}
    return -1;
  }
  
  public abstract void a();
  
  protected final String b(String paramString)
  {
    return (String)this.a.get(paramString);
  }
  
  protected final boolean c(String paramString)
  {
    return "true".equals(this.a.get(paramString));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/mraid/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */