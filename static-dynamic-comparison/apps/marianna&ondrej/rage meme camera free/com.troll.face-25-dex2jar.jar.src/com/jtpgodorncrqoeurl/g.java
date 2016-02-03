package com.jtpgodorncrqoeurl;

import android.app.Activity;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.Toast;

final class g
  extends WebViewClient
{
  g(AdBrowser paramAdBrowser) {}
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    paramString = (ImageButton)this.a.findViewById(102);
    if (paramWebView.canGoForward())
    {
      paramString.setImageBitmap(this.a.bitmapFromJar("bitmaps/rightarrow.png"));
      return;
    }
    paramString.setImageBitmap(this.a.bitmapFromJar("bitmaps/unrightarrow.png"));
  }
  
  public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    ((ImageButton)this.a.findViewById(102)).setImageBitmap(this.a.bitmapFromJar("bitmaps/unrightarrow.png"));
  }
  
  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    Toast.makeText((Activity)paramWebView.getContext(), "AdOrmma Error:" + paramString1, 0).show();
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    paramWebView.loadUrl(paramString);
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */