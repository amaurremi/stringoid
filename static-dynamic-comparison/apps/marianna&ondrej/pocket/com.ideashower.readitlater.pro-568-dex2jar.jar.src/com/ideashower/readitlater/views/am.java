package com.ideashower.readitlater.views;

import com.ideashower.readitlater.a.g;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.apache.a.c.k;

public class am
  extends BaseWebView
{
  private int a;
  private com.ideashower.readitlater.a.a.e b;
  private String i;
  private String j;
  private String k;
  private CountDownLatch l;
  private boolean m;
  
  private void e()
  {
    this.a = 1;
    loadUrl(this.k);
  }
  
  private void setSuccess(boolean paramBoolean)
  {
    this.m = paramBoolean;
    if (this.l != null) {
      this.l.countDown();
    }
  }
  
  public boolean a(final String paramString1, final String paramString2)
  {
    this.l = new CountDownLatch(1);
    g.a(new Runnable()
    {
      public void run()
      {
        am.this.b(paramString1, paramString2);
      }
    });
    try
    {
      this.l.await(60L, TimeUnit.SECONDS);
      return this.m;
    }
    catch (InterruptedException paramString1)
    {
      for (;;)
      {
        com.ideashower.readitlater.util.e.a(paramString1);
      }
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    String str = (String)k.e(paramString1, "");
    paramString2 = (String)k.e(paramString2, "");
    this.i = str;
    this.j = paramString2;
    if (this.a != 2) {
      return;
    }
    this.a = 3;
    paramString1 = this.b.g();
    StringBuilder localStringBuilder = new StringBuilder().append(" $('").append(this.b.e()).append("').val(username); ").append(" $('").append(this.b.f()).append("').val(password); ");
    if (paramString1 != null) {}
    for (paramString1 = " $('" + paramString1 + "').prop(\"checked\", true); ";; paramString1 = " ")
    {
      paramString1 = paramString1 + " $('" + this.b.h() + "').click(); ";
      a("var pocketCustomLoginToolFunction = function (username, password) { " + paramString1 + "}; " + "var pocketCustomLoginToolJQuery = document.createElement(\"script\");" + "pocketCustomLoginToolJQuery.type = \"text/javascript\";" + "pocketCustomLoginToolJQuery.onload = function () {" + "pocketCustomLoginToolFunction(" + c(str) + ", " + c(paramString2) + ");" + "};" + "pocketCustomLoginToolJQuery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js';" + "document.getElementsByTagName(\"head\")[0].appendChild(pocketCustomLoginToolJQuery);");
      return;
    }
  }
  
  public void d()
  {
    this.i = null;
    this.j = null;
    this.a = 0;
    loadUrl("about:blank");
  }
  
  public void setTemplate(com.ideashower.readitlater.a.a.e parame)
  {
    d();
    this.b = parame;
    this.k = parame.c();
    e();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */