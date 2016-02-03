package com.admob.android.ads.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Parcelable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.admob.android.ads.d;
import com.admob.android.ads.r;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class AdMobWebView
  extends WebView
{
  String a;
  public String b;
  boolean c;
  private RelativeLayout d;
  private d e;
  
  public AdMobWebView(Context paramContext, RelativeLayout paramRelativeLayout, String paramString, d paramd)
  {
    super(paramContext);
    this.e = paramd;
    this.d = paramRelativeLayout;
    paramContext = getSettings();
    paramContext.setLoadsImagesAutomatically(true);
    paramContext.setPluginsEnabled(true);
    paramContext.setJavaScriptEnabled(true);
    paramContext.setJavaScriptCanOpenWindowsAutomatically(true);
    paramContext.setSaveFormData(false);
    paramContext.setSavePassword(false);
    paramContext.setUserAgentString(r.c());
    setWebViewClient(new a(this));
    this.c = true;
    this.a = paramString;
  }
  
  public final void a()
  {
    if (this.e != null) {
      this.e.b(this.d);
    }
    ((WindowManager)getContext().getSystemService("window")).removeView(this.d);
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    Log.d("AdMobSDK", "onFocusChanged(" + paramBoolean + ")");
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      a();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Log.d("AdMobSDK", "onSaveInstanceState()");
    return super.onSaveInstanceState();
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    Log.d("AdMobSDK", "onWindowVisibilityChanged(" + paramInt + ")");
    super.onWindowVisibilityChanged(paramInt);
  }
  
  private final class a
    extends WebViewClient
  {
    private AdMobWebView a;
    
    public a(AdMobWebView paramAdMobWebView)
    {
      this.a = paramAdMobWebView;
    }
    
    private static Hashtable<String, String> a(String paramString)
    {
      Object localObject1 = null;
      if (paramString != null)
      {
        Hashtable localHashtable = new Hashtable();
        paramString = new StringTokenizer(paramString, "&");
        for (;;)
        {
          localObject1 = localHashtable;
          if (!paramString.hasMoreTokens()) {
            break;
          }
          Object localObject2 = new StringTokenizer(paramString.nextToken(), "=");
          if (((StringTokenizer)localObject2).hasMoreTokens())
          {
            localObject1 = ((StringTokenizer)localObject2).nextToken();
            if (((StringTokenizer)localObject2).hasMoreTokens())
            {
              localObject2 = ((StringTokenizer)localObject2).nextToken();
              if ((localObject1 != null) && (localObject2 != null)) {
                localHashtable.put(localObject1, localObject2);
              }
            }
          }
        }
      }
      return (Hashtable<String, String>)localObject1;
    }
    
    public final void onPageFinished(WebView paramWebView, String paramString)
    {
      if (("http://mm.admob.com/static/android/canvas.html".equals(paramString)) && (this.a.c))
      {
        paramWebView = new StringBuilder();
        paramWebView.append("javascript:cb('");
        paramWebView.append(AdMobWebView.this.b);
        paramWebView.append("','");
        paramWebView.append(AdMobWebView.this.a);
        paramWebView.append("')");
        this.a.c = false;
        this.a.loadUrl(paramWebView.toString());
      }
    }
    
    public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      try
      {
        paramString = new URI(paramString);
        if ("admob".equals(paramString.getScheme()))
        {
          String str = paramString.getHost();
          if ("launch".equals(str))
          {
            paramWebView = paramString.getQuery();
            if (paramWebView != null)
            {
              paramWebView = a(paramWebView);
              if (paramWebView != null)
              {
                paramWebView = (String)paramWebView.get("url");
                if (paramWebView != null)
                {
                  AdMobWebView.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramWebView)));
                  this.a.a();
                  return true;
                }
              }
            }
          }
          else if (("closecanvas".equals(str)) && (paramWebView == this.a))
          {
            this.a.a();
            return true;
          }
        }
      }
      catch (URISyntaxException paramWebView)
      {
        Log.w("AdMobSDK", "Bad link URL in AdMob web view.", paramWebView);
      }
      return false;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/hangman/com.games.HangManGame-14-dex2jar.jar!/com/admob/android/ads/view/AdMobWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */