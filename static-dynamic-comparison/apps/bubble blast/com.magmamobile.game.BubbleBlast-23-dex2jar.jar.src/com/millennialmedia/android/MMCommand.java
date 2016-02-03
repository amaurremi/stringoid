package com.millennialmedia.android;

import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.webkit.WebView;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

class MMCommand
  implements Runnable
{
  private HashMap<String, String> arguments;
  private String callback;
  private Class cls;
  private Method method;
  OverlaySettings settings;
  private WeakReference<WebView> webViewRef;
  
  MMCommand(WebView paramWebView, String paramString)
  {
    this.webViewRef = new WeakReference(paramWebView);
    for (;;)
    {
      int i;
      try
      {
        Object localObject = Uri.parse(paramString).getHost().split("\\.");
        if (localObject.length < 2) {
          return;
        }
        paramWebView = localObject[(localObject.length - 2)];
        localObject = localObject[(localObject.length - 1)];
        this.arguments = new HashMap();
        String[] arrayOfString1 = paramString.substring(paramString.indexOf('?') + 1).split("&");
        int j = arrayOfString1.length;
        i = 0;
        if (i < j)
        {
          String[] arrayOfString2 = arrayOfString1[i].split("=");
          if (arrayOfString2.length >= 2)
          {
            this.arguments.put(Uri.decode(arrayOfString2[0]), Uri.decode(arrayOfString2[1]));
            if (arrayOfString2[0].equalsIgnoreCase("callback")) {
              this.callback = Uri.decode(arrayOfString2[1]);
            }
          }
        }
        else
        {
          this.cls = Class.forName("com.millennialmedia.android." + paramWebView);
          this.method = this.cls.getMethod((String)localObject, new Class[] { this.arguments.getClass() });
          return;
        }
      }
      catch (Exception paramWebView)
      {
        MMAdViewSDK.Log.e("Exception while executing javascript call %s %s", new Object[] { paramString, paramWebView.getMessage() });
        paramWebView.printStackTrace();
        return;
      }
      i += 1;
    }
  }
  
  public void run()
  {
    if ((this.cls != null) && (this.method != null)) {}
    for (;;)
    {
      try
      {
        final Object localObject1 = (WebView)this.webViewRef.get();
        if (localObject1 != null)
        {
          Object localObject3 = (MMJSObject)this.cls.newInstance();
          ((MMJSObject)localObject3).setContext(((WebView)localObject1).getContext());
          final Object localObject4;
          if (this.settings != null)
          {
            localObject4 = this.arguments;
            if (this.settings.isBannerAd)
            {
              localObject1 = "true";
              ((HashMap)localObject4).put("OVERLAY_type", localObject1);
              this.arguments.put("OVERLAY_state", this.settings.state);
              this.arguments.put("OVERLAY_adurl", this.settings.adUrl);
            }
          }
          else
          {
            try
            {
              localObject1 = (MMJSResponse)this.method.invoke(localObject3, new Object[] { this.arguments });
              if ((this.callback != null) && (this.callback.length() > 0))
              {
                localObject4 = (WebView)this.webViewRef.get();
                if (localObject4 != null)
                {
                  localObject3 = localObject1;
                  if (localObject1 == null) {
                    localObject3 = MMJSResponse.responseWithError(this.method.getName());
                  }
                  if (((MMJSResponse)localObject3).methodName == null) {
                    ((MMJSResponse)localObject3).methodName = this.method.getName();
                  }
                  if (((MMJSResponse)localObject3).className == null) {
                    ((MMJSResponse)localObject3).className = this.cls.getSimpleName();
                  }
                  localObject1 = String.format("javascript:%s(%s);", new Object[] { this.callback, ((MMJSResponse)localObject3).toJSONString() });
                  MMAdViewSDK.Log.v("Executing JS bridge callback: " + (String)localObject1);
                  MMAdViewSDK.runOnUiThread(new Runnable()
                  {
                    public void run()
                    {
                      localObject4.loadUrl(localObject1);
                    }
                  });
                  return;
                }
              }
            }
            catch (InvocationTargetException localInvocationTargetException)
            {
              Object localObject2 = localInvocationTargetException.getCause();
              if ((localObject2 != null) && (localObject2.getClass() == ActivityNotFoundException.class))
              {
                localObject2 = MMJSResponse.responseWithError("Activity not found");
                continue;
              }
              localObject2 = MMJSResponse.responseWithError();
              continue;
            }
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception localException)
      {
        MMAdViewSDK.Log.e("Exception while executing javascript call %s %s", new Object[] { this.method.toString(), localException.getMessage() });
        localException.printStackTrace();
      }
      String str = "false";
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/millennialmedia/android/MMCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */