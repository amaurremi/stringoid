package com.pocket.webkit;

import android.annotation.TargetApi;
import android.os.Handler;
import android.webkit.WebView;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.a.m;
import com.ideashower.readitlater.util.NoObfuscation;
import com.ideashower.readitlater.util.a;
import com.ideashower.readitlater.util.e;
import com.pocket.p.z;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class JsInterface
  implements NoObfuscation
{
  private final WebView a;
  private final String b;
  private boolean c = false;
  private Map d;
  
  public JsInterface(WebView paramWebView, String paramString)
  {
    this.a = paramWebView;
    this.b = paramString;
  }
  
  public static Map getJavascriptInterfaces(WebView paramWebView)
  {
    Object localObject1;
    if (a.k())
    {
      localObject1 = WebView.class.getDeclaredField("mProvider");
      ((Field)localObject1).setAccessible(true);
      paramWebView = ((Field)localObject1).get(paramWebView);
      localObject1 = paramWebView.getClass().getDeclaredField("mWebViewCore");
    }
    for (;;)
    {
      ((Field)localObject1).setAccessible(true);
      Object localObject2 = ((Field)localObject1).get(paramWebView);
      Field localField2 = localObject2.getClass().getDeclaredField("mBrowserFrame");
      localField2.setAccessible(true);
      paramWebView = null;
      try
      {
        localObject1 = localField2.get(localObject2);
        paramWebView = (WebView)localObject1;
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          int i;
        }
      }
      if (paramWebView == null)
      {
        paramWebView = localObject2.getClass().getDeclaredField("sWebCoreHandler");
        paramWebView.setAccessible(true);
        paramWebView = (Handler)paramWebView.get(localObject2);
        localObject1 = new CountDownLatch(1);
        paramWebView.post(new Runnable()
        {
          public void run()
          {
            JsInterface.this.countDown();
          }
        });
        try
        {
          if (!((CountDownLatch)localObject1).await(2L, TimeUnit.SECONDS))
          {
            i = 1;
            if (i != 0) {
              throw new RuntimeException("blocked too long");
            }
          }
        }
        catch (Throwable paramWebView)
        {
          g.s().b(paramWebView);
          paramWebView = localField2.get(localObject2);
        }
        try
        {
          localObject1 = paramWebView.getClass().getDeclaredField("mJSInterfaceMap");
          ((Field)localObject1).setAccessible(true);
          return (Map)((Field)localObject1).get(paramWebView);
          localObject1 = WebView.class.getDeclaredField("mWebViewCore");
          continue;
          i = 0;
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          for (;;)
          {
            Field localField1 = paramWebView.getClass().getDeclaredField("mJavaScriptObjects");
          }
        }
      }
    }
  }
  
  private boolean removeCompat()
  {
    if (a.e()) {
      return removeHoneycomb();
    }
    return removePreHoneycomb();
  }
  
  @TargetApi(11)
  private boolean removeHoneycomb()
  {
    this.a.removeJavascriptInterface(this.b);
    return true;
  }
  
  private boolean removePreHoneycomb()
  {
    if (this.d == null) {}
    try
    {
      this.d = getJavascriptInterfaces(this.a);
      if (this.d != null)
      {
        this.d.remove(this.b);
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        e.a(localThrowable, true, "jsreflection");
      }
    }
    return false;
  }
  
  public static void removeSearchBoxInterface(WebView paramWebView)
  {
    if ((a.h()) || (a.n())) {
      return;
    }
    z.a(paramWebView, "searchBoxJavaBridge_");
  }
  
  public boolean isEnabled()
  {
    return this.c;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (this.c == paramBoolean) {}
    do
    {
      return;
      if (paramBoolean)
      {
        this.a.addJavascriptInterface(this, this.b);
        this.c = true;
        return;
      }
    } while (!removeCompat());
    this.c = false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/webkit/JsInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */