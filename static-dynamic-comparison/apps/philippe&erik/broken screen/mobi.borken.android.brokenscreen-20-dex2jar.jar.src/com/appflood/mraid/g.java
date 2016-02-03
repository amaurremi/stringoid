package com.appflood.mraid;

import java.util.Map;

final class g
  extends d
{
  g(Map<String, String> paramMap, AFBannerWebView paramAFBannerWebView)
  {
    super(paramMap, paramAFBannerWebView);
  }
  
  public final void a()
  {
    int j = a("w");
    int k = a("h");
    String str = b("url");
    boolean bool1 = c("shouldUseCustomClose");
    boolean bool2 = c("lockOrientation");
    int i = j;
    if (j <= 0) {
      i = this.b.d().e;
    }
    j = k;
    if (k <= 0) {
      j = this.b.d().f;
    }
    this.b.d().a(str, i, j, bool1, bool2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/mraid/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */