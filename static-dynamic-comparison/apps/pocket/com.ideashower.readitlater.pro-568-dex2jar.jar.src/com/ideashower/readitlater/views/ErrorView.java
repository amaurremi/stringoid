package com.ideashower.readitlater.views;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ideashower.readitlater.a.j;
import com.ideashower.readitlater.c.a;

public class ErrorView
  extends BaseWebView
{
  private String a;
  private m b;
  private boolean i = false;
  private String j;
  
  public ErrorView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ErrorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ErrorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void d()
  {
    setWebChromeClient(new a(this));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, m paramm, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b = paramm;
    paramString2 = new StringBuilder().append("set(").append(c(paramString1)).append(", ").append(c(paramString2)).append(", ").append(c(paramString3));
    if (paramBoolean2) {}
    for (paramString1 = "," + c("night");; paramString1 = "")
    {
      paramString1 = paramString1 + ");";
      if (!this.i) {
        break;
      }
      a(paramString1);
      this.j = null;
      return;
    }
    this.j = paramString1;
  }
  
  protected void b()
  {
    super.b();
    d();
    setWebViewClient(new WebViewClient()
    {
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if ((paramAnonymousString.toUpperCase().equals("ISRIL:BUTTONTAPPED")) && (ErrorView.a(ErrorView.this) != null)) {
          ErrorView.a(ErrorView.this).a();
        }
        return true;
      }
    });
    this.a = (j.a(true, true) + "error.html");
    addJavascriptInterface(new ErrorView.JSInterface(this), "Pocket");
    loadUrl(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/ErrorView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */