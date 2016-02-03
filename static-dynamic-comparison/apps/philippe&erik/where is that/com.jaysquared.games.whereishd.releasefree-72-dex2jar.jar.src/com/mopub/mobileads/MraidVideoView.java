package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;

class MraidVideoView
  extends BaseVideoView
{
  public MraidVideoView(Context paramContext, Intent paramIntent, final BaseVideoView.BaseVideoViewListener paramBaseVideoViewListener)
  {
    super(paramContext);
    setOnCompletionListener(new MediaPlayer.OnCompletionListener()
    {
      public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        if (paramBaseVideoViewListener != null) {
          paramBaseVideoViewListener.videoCompleted(true);
        }
      }
    });
    setOnErrorListener(new MediaPlayer.OnErrorListener()
    {
      public boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if (paramBaseVideoViewListener != null) {
          paramBaseVideoViewListener.videoError(false);
        }
        return false;
      }
    });
    setVideoPath(paramIntent.getStringExtra("video_url"));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/MraidVideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */