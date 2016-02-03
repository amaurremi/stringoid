package com.mocoplex.adlib;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class AdlibAndroidBridge
{
  private final Handler a = new Handler();
  private Context b;
  
  public AdlibAndroidBridge(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public void callAndroid(final String paramString)
  {
    this.a.post(new Runnable()
    {
      public final void run()
      {
        Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        try
        {
          AdlibAndroidBridge.this.b.startActivity(localIntent);
          return;
        }
        catch (Exception localException) {}
      }
    });
  }
  
  public void go(final String paramString)
  {
    this.a.post(new Runnable()
    {
      public final void run()
      {
        Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        try
        {
          AdlibAndroidBridge.this.b.startActivity(localIntent);
          return;
        }
        catch (Exception localException) {}
      }
    });
  }
  
  public void go2(final String paramString1, final String paramString2, final String paramString3)
  {
    this.a.post(new Runnable()
    {
      public final void run()
      {
        if ((paramString1 != null) && (!paramString1.equals(""))) {
          new d(new Handler()
          {
            public final void handleMessage(Message paramAnonymous2Message)
            {
              int i = paramAnonymous2Message.what;
            }
          }).a(paramString1, null);
        }
        Intent localIntent;
        if (paramString3.equals("www"))
        {
          localObject = new Bundle();
          ((Bundle)localObject).putString("url", paramString2);
          ((Bundle)localObject).putInt("type", 1);
          localIntent = new Intent(AdlibAndroidBridge.this.b, AdlibWebBrowserActivity.class);
          localIntent.putExtras((Bundle)localObject);
        }
        try
        {
          AdlibAndroidBridge.this.b.startActivity(localIntent);
          return;
        }
        catch (Exception localException2) {}
        Object localObject = new Intent("android.intent.action.VIEW", Uri.parse(paramString2));
        try
        {
          AdlibAndroidBridge.this.b.startActivity((Intent)localObject);
          return;
        }
        catch (Exception localException1) {}
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mocoplex/adlib/AdlibAndroidBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */