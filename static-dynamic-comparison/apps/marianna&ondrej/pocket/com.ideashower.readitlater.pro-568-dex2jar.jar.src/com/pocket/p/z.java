package com.pocket.p;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.ideashower.readitlater.util.a;
import com.ideashower.readitlater.util.e;
import com.pocket.webkit.JsInterface;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class z
{
  private static Method a;
  private static boolean b;
  
  /* Error */
  public static String a(WebView paramWebView)
  {
    // Byte code:
    //   0: invokestatic 17	com/ideashower/readitlater/util/a:m	()Z
    //   3: ifeq +21 -> 24
    //   6: aload_0
    //   7: invokestatic 19	com/pocket/p/z:b	(Landroid/webkit/WebView;)Ljava/lang/String;
    //   10: astore_0
    //   11: aload_0
    //   12: astore_1
    //   13: aload_0
    //   14: invokestatic 24	org/apache/a/c/k:a	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +5 -> 22
    //   20: aconst_null
    //   21: astore_1
    //   22: aload_1
    //   23: areturn
    //   24: invokestatic 27	com/ideashower/readitlater/util/a:q	()Z
    //   27: ifeq +11 -> 38
    //   30: aload_0
    //   31: invokestatic 30	com/pocket/p/z:c	(Landroid/webkit/WebView;)Ljava/lang/String;
    //   34: astore_0
    //   35: goto -24 -> 11
    //   38: aload_0
    //   39: invokestatic 33	com/pocket/p/z:d	(Landroid/webkit/WebView;)Ljava/lang/String;
    //   42: astore_0
    //   43: goto -32 -> 11
    //   46: astore_0
    //   47: new 35	com/pocket/p/aa
    //   50: dup
    //   51: aload_0
    //   52: invokespecial 39	com/pocket/p/aa:<init>	(Ljava/lang/Throwable;)V
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	paramWebView	WebView
    //   12	11	1	localWebView	WebView
    // Exception table:
    //   from	to	target	type
    //   0	11	46	java/lang/Throwable
    //   24	35	46	java/lang/Throwable
    //   38	43	46	java/lang/Throwable
  }
  
  public static void a(WebSettings paramWebSettings, boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT >= 19) || (b)) {}
    for (;;)
    {
      return;
      if (a == null) {}
      try
      {
        a = WebSettings.class.getMethod("setPluginsEnabled", new Class[] { Boolean.TYPE });
        if (a == null) {
          continue;
        }
        try
        {
          a.invoke(paramWebSettings, new Object[] { Boolean.valueOf(paramBoolean) });
          return;
        }
        catch (Throwable paramWebSettings)
        {
          e.a(paramWebSettings);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          b = true;
          e.a(localThrowable);
        }
      }
    }
  }
  
  public static void a(WebView paramWebView, String paramString)
  {
    if (a.e())
    {
      c(paramWebView, paramString);
      return;
    }
    b(paramWebView, paramString);
  }
  
  private static String b(WebView paramWebView)
  {
    Method localMethod = WebView.class.getDeclaredMethod("getSelection", new Class[0]);
    localMethod.setAccessible(true);
    return (String)localMethod.invoke(paramWebView, new Object[0]);
  }
  
  private static void b(WebView paramWebView, String paramString)
  {
    try
    {
      JsInterface.getJavascriptInterfaces(paramWebView).remove(paramString);
      return;
    }
    catch (Throwable paramWebView)
    {
      e.a(paramWebView, true);
    }
  }
  
  private static String c(WebView paramWebView)
  {
    Object localObject = WebView.class.getDeclaredField("mProvider");
    ((Field)localObject).setAccessible(true);
    paramWebView = ((Field)localObject).get(paramWebView);
    localObject = paramWebView.getClass().getDeclaredMethod("getSelection", new Class[0]);
    ((Method)localObject).setAccessible(true);
    return (String)((Method)localObject).invoke(paramWebView, new Object[0]);
  }
  
  @TargetApi(11)
  private static void c(WebView paramWebView, String paramString)
  {
    paramWebView.removeJavascriptInterface(paramString);
  }
  
  private static String d(WebView paramWebView)
  {
    Object localObject = WebView.class.getDeclaredField("mProvider");
    ((Field)localObject).setAccessible(true);
    paramWebView = ((Field)localObject).get(paramWebView);
    localObject = paramWebView.getClass().getDeclaredField("mAwContents");
    ((Field)localObject).setAccessible(true);
    paramWebView = ((Field)localObject).get(paramWebView);
    localObject = paramWebView.getClass().getDeclaredField("mContentViewCore");
    ((Field)localObject).setAccessible(true);
    paramWebView = ((Field)localObject).get(paramWebView);
    localObject = paramWebView.getClass().getDeclaredMethod("getSelectedText", new Class[0]);
    ((Method)localObject).setAccessible(true);
    return (String)((Method)localObject).invoke(paramWebView, new Object[0]);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/p/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */