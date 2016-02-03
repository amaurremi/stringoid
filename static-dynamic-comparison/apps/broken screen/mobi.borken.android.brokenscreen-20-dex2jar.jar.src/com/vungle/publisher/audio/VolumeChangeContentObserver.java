package com.vungle.publisher.audio;

import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import com.vungle.publisher.log.Logger;
import javax.inject.Inject;
import javax.inject.Singleton;

public final class VolumeChangeContentObserver
  extends ContentObserver
{
  private final AudioManager a;
  private final Handler b;
  private volatile int c;
  
  public VolumeChangeContentObserver(AudioManager paramAudioManager, Handler paramHandler)
  {
    super(paramHandler);
    this.a = paramAudioManager;
    this.b = paramHandler;
    this.c = paramAudioManager.getStreamVolume(3);
  }
  
  public final void onChange(boolean paramBoolean)
  {
    try
    {
      super.onChange(paramBoolean);
      int i = this.c;
      int j = this.a.getStreamVolume(3);
      this.c = j;
      if (j != i)
      {
        Logger.v("VungleDevice", "volume changed " + i + " --> " + j);
        Message localMessage = new Message();
        localMessage.arg1 = i;
        localMessage.arg2 = j;
        this.b.sendMessage(localMessage);
      }
      return;
    }
    catch (Exception localException)
    {
      Logger.e("VungleDevice", localException);
    }
  }
  
  @Singleton
  public static class Factory
  {
    @Inject
    public AudioManager a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/audio/VolumeChangeContentObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */