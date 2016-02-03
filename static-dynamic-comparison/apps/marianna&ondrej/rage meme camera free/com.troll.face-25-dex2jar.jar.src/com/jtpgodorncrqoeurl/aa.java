package com.jtpgodorncrqoeurl;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.VideoView;

final class aa
  extends WebChromeClient
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener
{
  private Context a;
  private RelativeLayout b;
  private FrameLayout c;
  private VideoView d;
  private WebChromeClient.CustomViewCallback e;
  
  public aa(AdWebView paramAdWebView, Context paramContext, RelativeLayout paramRelativeLayout)
  {
    this.a = paramContext;
    this.b = paramRelativeLayout;
  }
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.stop();
    this.c.setVisibility(8);
    onHideCustomView();
  }
  
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    AdLog.d("LBAdController", paramConsoleMessage.message() + " -- From line " + paramConsoleMessage.lineNumber() + " of " + paramConsoleMessage.sourceId());
    return true;
  }
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    ((Activity)this.a).setContentView(this.b);
    return true;
  }
  
  public final void onHideCustomView()
  {
    if (this.d != null)
    {
      this.d.setVisibility(8);
      this.c.removeView(this.d);
      this.d = null;
      this.c.setVisibility(8);
      this.e.onCustomViewHidden();
      ((Activity)this.a).setContentView(this.b);
    }
  }
  
  public final boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    new AlertDialog.Builder(this.a).setTitle("Alert").setMessage(paramString2).setPositiveButton(17039370, new ab(this, paramJsResult)).setCancelable(false).create().show();
    return true;
  }
  
  public final boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    new AlertDialog.Builder(this.a).setTitle("Confirm").setMessage(paramString2).setPositiveButton(17039370, new ad(this, paramJsResult)).setNegativeButton(17039360, new ac(this, paramJsResult)).create().show();
    return true;
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.e = paramCustomViewCallback;
    super.onShowCustomView(paramView, this.e);
    if ((paramView instanceof FrameLayout))
    {
      this.c = ((FrameLayout)paramView);
      if ((this.c.getFocusedChild() instanceof VideoView))
      {
        this.d = ((VideoView)this.c.getFocusedChild());
        this.c.removeView(this.d);
        ((Activity)this.a).setContentView(this.c);
        this.d.start();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */