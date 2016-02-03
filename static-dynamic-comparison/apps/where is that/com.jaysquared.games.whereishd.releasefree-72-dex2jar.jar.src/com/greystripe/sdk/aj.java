package com.greystripe.sdk;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.view.View;
import android.webkit.JavascriptInterface;

final class aj
  extends w
  implements MediaPlayer.OnErrorListener
{
  private am b;
  private View c;
  
  public aj(c paramc)
  {
    super(paramc);
  }
  
  private void a()
  {
    if (this.b != null)
    {
      this.b.removeAllViews();
      this.b.addView(this.c);
    }
    if (this.a != null) {
      this.a.b(this);
    }
  }
  
  @JavascriptInterface
  public final void onCompletion()
  {
    super.onCompletion();
    bm.a(new al(this));
  }
  
  @JavascriptInterface
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    bd.b("Video cannot be played.", new Object[0]);
    a();
    return true;
  }
  
  @JavascriptInterface
  public final void play(String paramString)
  {
    if (this.b == null)
    {
      bd.b("Banner view was not set", new Object[0]);
      return;
    }
    this.c = this.b.getChildAt(0);
    bm.a(new ak(this, paramString));
  }
  
  public final void setBannerView(am paramam)
  {
    this.b = paramam;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */