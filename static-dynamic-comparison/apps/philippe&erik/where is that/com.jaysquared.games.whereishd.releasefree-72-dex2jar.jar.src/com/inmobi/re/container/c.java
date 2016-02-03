package com.inmobi.re.container;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.widget.FrameLayout;
import com.inmobi.commons.internal.Log;

class c
  implements MediaPlayer.OnCompletionListener
{
  c(IMWebView paramIMWebView) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    try
    {
      paramMediaPlayer.stop();
      IMWebView.i(this.a).setVisibility(8);
      IMWebView.l(this.a);
      IMWebView.h(this.a).setContentView(IMWebView.m(this.a));
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      Log.internal("[InMobi]-[RE]-4.1.1", "Media Player onCompletion", paramMediaPlayer);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/re/container/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */