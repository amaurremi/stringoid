package com.jtpgodorncrqoeurl;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

final class q
  implements MediaPlayer.OnCompletionListener
{
  q(AdController paramAdController) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AdController.B(this.a).setStreamVolume(3, AdController.A(this.a), 8);
    if (AdController.C(this.a) != null) {
      AdController.C(this.a).release();
    }
    if (AdController.z(this.a) != null) {
      AdController.z(this.a).onAdFinished();
    }
    AdController.a(this.a, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */