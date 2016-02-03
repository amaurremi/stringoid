package com.scoreloop.client.android.core.ui;

import android.content.Context;
import android.view.KeyEvent;
import android.webkit.WebView;
import java.net.MalformedURLException;
import java.net.URL;

public class TwitterAuthDialog
  extends WebViewDialog
{
  private TwitterAuthViewController a;
  
  public TwitterAuthDialog(Context paramContext, int paramInt, TwitterAuthViewController paramTwitterAuthViewController)
  {
    super(paramContext, paramInt);
    this.a = paramTwitterAuthViewController;
  }
  
  private void c()
  {
    this.a.e().d();
    a();
    dismiss();
  }
  
  private void d()
  {
    this.a.e().a(new IllegalStateException("unparsable twitter response"));
    a();
    dismiss();
  }
  
  protected void a(WebView paramWebView, String paramString)
  {
    do
    {
      try
      {
        paramWebView = new URL(paramString);
        if ((paramWebView.getHost().equalsIgnoreCase("www.scoreloop.com")) && (paramWebView.getPath().equalsIgnoreCase("/twitter/oauth")))
        {
          paramString = paramWebView.getQuery().split("=");
          paramWebView = paramString[0];
          if (paramWebView.equalsIgnoreCase("done")) {
            c();
          }
        }
        else
        {
          return;
        }
      }
      catch (MalformedURLException paramWebView)
      {
        throw new IllegalStateException(paramWebView);
      }
      if (paramString.length != 2) {
        break;
      }
      paramString = paramString[1];
    } while (!paramWebView.equalsIgnoreCase("oauth_token"));
    if (paramString.equals(this.a.a()))
    {
      this.a.e().c();
      dismiss();
      return;
    }
    d();
    return;
    d();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      c();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/ui/TwitterAuthDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */