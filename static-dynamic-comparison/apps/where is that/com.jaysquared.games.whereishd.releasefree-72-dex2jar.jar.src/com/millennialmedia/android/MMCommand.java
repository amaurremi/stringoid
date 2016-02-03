package com.millennialmedia.android;

import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

class MMCommand
  implements Runnable
{
  private Map<String, String> arguments;
  private String callback;
  private Class cls;
  private Method method;
  private WeakReference<MMWebView> webViewRef;
  
  MMCommand(MMWebView paramMMWebView, String paramString)
  {
    this.webViewRef = new WeakReference(paramMMWebView);
    for (;;)
    {
      int i;
      try
      {
        Object localObject = Uri.parse(paramString).getHost().split("\\.");
        if (localObject.length < 2) {
          return;
        }
        paramMMWebView = localObject[(localObject.length - 2)];
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
          this.cls = Class.forName("com.millennialmedia.android.Bridge" + paramMMWebView);
          this.method = this.cls.getMethod((String)localObject, new Class[] { this.arguments.getClass() });
          return;
        }
      }
      catch (Exception paramMMWebView)
      {
        MMSDK.Log.e("Exception while executing javascript call %s %s", new Object[] { paramString, paramMMWebView.getMessage() });
        paramMMWebView.printStackTrace();
        return;
      }
      i += 1;
    }
  }
  
  private String getBridgeStrippedClassName()
  {
    return this.cls.getSimpleName().replaceFirst("Bridge", "");
  }
  
  boolean isResizeCommand()
  {
    if (this.method != null) {
      return "resize".equals(this.method.getName());
    }
    return false;
  }
  
  public void run()
  {
    if ((this.cls != null) && (this.method != null)) {
      try
      {
        final Object localObject1 = (MMWebView)this.webViewRef.get();
        if (localObject1 == null) {
          return;
        }
        Object localObject4 = (MMJSObject)this.cls.newInstance();
        ((MMJSObject)localObject4).setContext(((MMWebView)localObject1).getContext());
        ((MMJSObject)localObject4).setMMWebView((MMWebView)localObject1);
        ((MMWebView)localObject1).updateArgumentsWithSettings(this.arguments);
        try
        {
          localObject1 = (MMJSResponse)this.method.invoke(localObject4, new Object[] { this.arguments });
          if ((this.callback == null) || (this.callback.length() <= 0)) {
            return;
          }
          final MMWebView localMMWebView = (MMWebView)this.webViewRef.get();
          if (localMMWebView == null) {
            return;
          }
          localObject4 = localObject1;
          if (localObject1 == null) {
            localObject4 = MMJSResponse.responseWithError(this.method.getName());
          }
          if (((MMJSResponse)localObject4).methodName == null) {
            ((MMJSResponse)localObject4).methodName = this.method.getName();
          }
          if (((MMJSResponse)localObject4).className == null) {
            ((MMJSResponse)localObject4).className = getBridgeStrippedClassName();
          }
          localObject1 = String.format("javascript:%s(%s);", new Object[] { this.callback, ((MMJSResponse)localObject4).toJSONString() });
          MMSDK.Log.v("Executing JS bridge callback: " + (String)localObject1);
          MMSDK.runOnUiThread(new Runnable()
          {
            public void run()
            {
              if (MMCommand.this.method.getName().equals("expandWithProperties")) {
                localMMWebView.isExpanding = true;
              }
              localMMWebView.loadUrl(localObject1);
            }
          });
          return;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          for (;;)
          {
            Object localObject2 = localInvocationTargetException.getCause();
            if ((localObject2 != null) && (localObject2.getClass() == ActivityNotFoundException.class)) {
              localObject2 = MMJSResponse.responseWithError("Activity not found");
            } else {
              localObject2 = MMJSResponse.responseWithError();
            }
          }
        }
        if (TextUtils.isEmpty(this.callback)) {
          return;
        }
      }
      catch (Exception localException)
      {
        MMSDK.Log.e("Exception while executing javascript call %s %s", new Object[] { this.method.toString(), localException.getMessage() });
        localException.printStackTrace();
        return;
      }
    }
    final Object localObject3 = MMJSResponse.responseWithError("No class or method found");
    localObject3 = String.format("javascript:%s(%s);", new Object[] { this.callback, ((MMJSResponse)localObject3).toJSONString() });
    MMSDK.Log.v("Executing JS bridge failed callback: " + (String)localObject3);
    MMSDK.runOnUiThread(new Runnable()
    {
      public void run()
      {
        this.val$webViewCallback.loadUrl(localObject3);
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/millennialmedia/android/MMCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */