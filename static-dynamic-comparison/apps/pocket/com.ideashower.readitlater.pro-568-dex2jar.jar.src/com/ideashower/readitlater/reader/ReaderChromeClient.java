package com.ideashower.readitlater.reader;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Build.VERSION;
import android.support.v4.app.f;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.VideoView;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.activity.ReaderFragment;
import com.ideashower.readitlater.util.NoObfuscation;
import com.ideashower.readitlater.util.e;
import com.pocket.m.a;

public class ReaderChromeClient
  extends WebChromeClient
  implements NoObfuscation
{
  protected static final FrameLayout.LayoutParams a = new FrameLayout.LayoutParams(-1, -1);
  protected static final FrameLayout.LayoutParams b = new FrameLayout.LayoutParams(-1, -1, 17);
  protected FrameLayout c;
  protected ViewGroup d;
  protected View e;
  protected WebChromeClient.CustomViewCallback f;
  protected final ReaderFragment g;
  private LinearLayout h = null;
  private VideoView i = null;
  
  protected ReaderChromeClient(ReaderFragment paramReaderFragment, ViewGroup paramViewGroup)
  {
    this.g = paramReaderFragment;
    this.d = paramViewGroup;
  }
  
  public static ReaderChromeClient getNew(ReaderFragment paramReaderFragment, ViewGroup paramViewGroup)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return new ReaderChromeClient14(paramReaderFragment, paramViewGroup);
    }
    if (Build.VERSION.SDK_INT >= 11) {
      return new ReaderChromeClient11(paramReaderFragment, paramViewGroup);
    }
    return new ReaderChromeClient(paramReaderFragment, paramViewGroup);
  }
  
  private void stopVideo()
  {
    onHideCustomView();
  }
  
  protected Activity getActivity()
  {
    return this.g.m();
  }
  
  public View getVideoLoadingProgressView()
  {
    if (this.h == null)
    {
      this.h = ((LinearLayout)LayoutInflater.from(getActivity()).inflate(2130903115, null));
      this.h.setVisibility(0);
    }
    return this.h;
  }
  
  public boolean onBackPressed()
  {
    if (this.e != null)
    {
      onHideCustomView();
      return true;
    }
    return false;
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    return true;
  }
  
  public void onHideCustomView()
  {
    if (this.e == null) {
      return;
    }
    if (this.i != null)
    {
      this.i.stopPlayback();
      this.i = null;
    }
    setFullscreen(false);
    final FrameLayout localFrameLayout = (FrameLayout)this.g.m().getWindow().getDecorView();
    if (g.q()) {
      localFrameLayout.removeView(this.c);
    }
    for (;;)
    {
      this.c = null;
      this.e = null;
      if (this.f != null) {
        this.f.onCustomViewHidden();
      }
      a.a(4);
      return;
      e.a("onHideCustomView occured off the main thread.");
      this.c.setVisibility(8);
      g.a(new Runnable()
      {
        public void run()
        {
          localFrameLayout.removeView(this.b);
        }
      });
    }
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return this.g.a(paramString2, paramJsResult);
  }
  
  public boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return this.g.a(paramString2, paramJsResult);
  }
  
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    return this.g.a(paramString2, paramJsPromptResult);
  }
  
  public boolean onJsTimeout()
  {
    return true;
  }
  
  public void onPause(boolean paramBoolean)
  {
    if (this.e != null)
    {
      if (!paramBoolean) {
        break label16;
      }
      onHideCustomView();
    }
    label16:
    while (this.i == null) {
      return;
    }
    this.i.pause();
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    this.g.f(paramInt);
  }
  
  public void onResume()
  {
    if (this.i != null) {
      this.i.resume();
    }
  }
  
  public void onSelectionDone(WebView paramWebView)
  {
    ((ReaderWebView)paramWebView).setIsSelectingText(false);
  }
  
  public void onSelectionStart(WebView paramWebView)
  {
    ((ReaderWebView)paramWebView).setIsSelectingText(true);
  }
  
  public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (this.e != null) {
      if (paramCustomViewCallback != null) {
        paramCustomViewCallback.onCustomViewHidden();
      }
    }
    do
    {
      return;
      this.i = null;
      if ((paramView instanceof FrameLayout))
      {
        localFrameLayout = (FrameLayout)paramView;
        if ((localFrameLayout.getFocusedChild() instanceof VideoView))
        {
          this.i = ((VideoView)localFrameLayout.getFocusedChild());
          this.i.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
          {
            public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
            {
              ReaderChromeClient.this.stopVideo();
            }
          });
          this.i.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
          {
            public void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
            {
              ReaderChromeClient.this.h.setVisibility(8);
            }
          });
          this.i.setOnErrorListener(new MediaPlayer.OnErrorListener()
          {
            public boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
            {
              switch (paramAnonymousInt1)
              {
              }
              for (paramAnonymousMediaPlayer = "There was an error playing this video.";; paramAnonymousMediaPlayer = "There was an error playing this video. Connection lost or could not be made")
              {
                paramAnonymousMediaPlayer = new AlertDialog.Builder(ReaderChromeClient.this.getActivity()).setTitle(g.a(2131493182)).setMessage(paramAnonymousMediaPlayer).setNeutralButton(2131492924, new DialogInterface.OnClickListener()
                {
                  public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    ReaderChromeClient.this.stopVideo();
                  }
                }).setOnCancelListener(new DialogInterface.OnCancelListener()
                {
                  public void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    ReaderChromeClient.this.stopVideo();
                  }
                }).create();
                paramAnonymousMediaPlayer.setCanceledOnTouchOutside(true);
                paramAnonymousMediaPlayer.show();
                return true;
              }
            }
          });
        }
      }
      FrameLayout localFrameLayout = (FrameLayout)this.g.m().getWindow().getDecorView();
      this.c = new m(this.g.m());
      this.c.addView(paramView, a);
      localFrameLayout.addView(this.c, a);
      this.e = paramView;
      setFullscreen(true);
      this.f = paramCustomViewCallback;
    } while (this.i == null);
    this.i.start();
  }
  
  public void setFullscreen(boolean paramBoolean)
  {
    Window localWindow = this.g.m().getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    if (paramBoolean) {}
    for (localLayoutParams.flags |= 0x400;; localLayoutParams.flags &= 0xFBFF)
    {
      localWindow.setAttributes(localLayoutParams);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/reader/ReaderChromeClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */