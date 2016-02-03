package com.greystripe.sdk;

import android.net.Uri;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;

final class aw
  implements Runnable
{
  aw(at paramat, String paramString) {}
  
  public final void run()
  {
    at.a(this.b).removeAllViews();
    this.b.a.setOnErrorListener(this.b);
    at.a(this.b).addView(this.b.a, new FrameLayout.LayoutParams(-1, -1, 17));
    at.b(this.b);
    MediaController localMediaController = new MediaController(at.c(this.b));
    this.b.a.setMediaController(localMediaController);
    this.b.a.setVideoURI(Uri.parse(this.a));
    if (bd.b()) {
      bd.b("videoView: getCurrentTime:" + this.b.getCurrentTime() + " canPause:" + this.b.canPause() + " canSeekBackward:" + this.b.canSeekBackward() + " canSeekForward:" + this.b.canSeekForward() + " getBufferPercentage:" + this.b.getBufferPercentage() + " isPlaying:" + this.b.isPlaying() + " getDuration:" + this.b.getDuration(), new Object[0]);
    }
    this.b.a.requestFocus();
    this.b.a.start();
    at.d(this.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */