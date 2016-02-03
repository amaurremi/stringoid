package com.appfireworks.android.advert;

import android.app.Activity;
import android.content.Context;
import android.webkit.JavascriptInterface;
import com.appfireworks.android.module.AppModuleController;

public class AppJSInterface
{
  private Context activity;
  private AppModuleController controller;
  
  public AppJSInterface(Context paramContext, AppModuleController paramAppModuleController)
  {
    this.activity = paramContext;
    this.controller = paramAppModuleController;
  }
  
  @JavascriptInterface
  private void closeAd()
    throws Exception
  {
    ((Activity)this.activity).runOnUiThread(new Runnable()
    {
      public void run()
      {
        AppJSInterface.this.controller.setLoading(false);
        AppJSInterface.this.controller.onCloseClick();
      }
    });
  }
  
  @JavascriptInterface
  public void close()
  {
    try
    {
      closeAd();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/appfireworks/android/advert/AppJSInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */