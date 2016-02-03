package com.appflood.mraid;

import java.util.Map;

final class j
  extends d
{
  j(Map<String, String> paramMap, AFBannerWebView paramAFBannerWebView)
  {
    super(paramMap, paramAFBannerWebView);
  }
  
  public final void a()
  {
    new StringBuilder(" execute ").append(this.a).append("  this ").append(this).toString();
    com.appflood.e.j.a();
    int j = a("w");
    int k = a("h");
    int m = a("x");
    int n = a("y");
    boolean bool = c("allowOffscreen");
    int i = j;
    if (j <= 0) {
      i = this.b.d().e;
    }
    j = k;
    if (k <= 0) {
      j = this.b.d().f;
    }
    this.b.d().a(i, j, m, n, bool);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/mraid/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */