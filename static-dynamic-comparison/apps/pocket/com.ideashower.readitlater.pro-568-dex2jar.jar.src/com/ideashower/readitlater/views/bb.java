package com.ideashower.readitlater.views;

import android.webkit.WebView;
import com.ideashower.readitlater.util.e;
import java.lang.reflect.Method;

public class bb
  extends ba
{
  protected static Method b;
  
  public bb(BaseWebView paramBaseWebView)
  {
    super(paramBaseWebView);
  }
  
  public static void a(WebView paramWebView)
  {
    try
    {
      if (b == null) {
        b = WebView.class.getMethod("notifySelectDialogDismissed", new Class[0]);
      }
      b.invoke(paramWebView, (Object[])null);
      return;
    }
    catch (Exception paramWebView)
    {
      e.a(paramWebView, true);
    }
  }
  
  public void a()
  {
    try
    {
      a(this.a);
      return;
    }
    catch (Exception localException)
    {
      e.a(localException, true);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */