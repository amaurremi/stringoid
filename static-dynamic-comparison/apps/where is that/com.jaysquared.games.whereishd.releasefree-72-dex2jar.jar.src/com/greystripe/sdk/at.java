package com.greystripe.sdk;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;

final class at
  extends w
  implements MediaPlayer.OnErrorListener
{
  private Activity b;
  private FrameLayout c;
  private View d;
  private boolean e = false;
  
  public at(c paramc)
  {
    super(paramc);
  }
  
  protected final void a()
  {
    onVideoExit();
    removeVideoView();
  }
  
  public final void clearReferences()
  {
    this.a.b(this);
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
  }
  
  public final void onCompletion()
  {
    super.onCompletion();
    bm.a(new ax(this));
  }
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    bd.b("Video cannot be played.", new Object[0]);
    a();
    return true;
  }
  
  @JavascriptInterface
  public final void play(String paramString)
  {
    bm.a(new aw(this, paramString));
  }
  
  public final void removeVideoView()
  {
    if (this.e)
    {
      this.a.stopPlayback();
      this.e = false;
      this.c.removeAllViews();
      this.c.addView(this.d);
    }
  }
  
  public final void setActivity(Activity paramActivity)
  {
    this.b = paramActivity;
    this.a = new y(paramActivity);
    this.a.a(this);
  }
  
  public final void setRootLayout(FrameLayout paramFrameLayout)
  {
    this.c = paramFrameLayout;
    this.d = this.c.getChildAt(0);
  }
  
  @JavascriptInterface
  public final boolean videoStarted()
  {
    return this.e;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */