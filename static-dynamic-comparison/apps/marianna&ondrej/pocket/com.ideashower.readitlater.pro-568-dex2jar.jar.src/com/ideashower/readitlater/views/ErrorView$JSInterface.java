package com.ideashower.readitlater.views;

import android.webkit.JavascriptInterface;
import com.ideashower.readitlater.util.NoObfuscation;

public class ErrorView$JSInterface
  implements NoObfuscation
{
  public ErrorView$JSInterface(ErrorView paramErrorView) {}
  
  @JavascriptInterface
  public void onReady()
  {
    ErrorView.a(this.a, true);
    if (ErrorView.b(this.a) != null)
    {
      this.a.a(ErrorView.b(this.a));
      ErrorView.a(this.a, null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/ErrorView$JSInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */