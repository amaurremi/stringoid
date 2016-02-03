package com.atomic.apps.ringtone.cutter;

import android.media.MediaPlayer;
import android.os.Handler;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

final class x
  extends Thread
{
  x(RingtoneEditActivity paramRingtoneEditActivity) {}
  
  public final void run()
  {
    RingtoneEditActivity.b(this.a, Y.a(this.a.getPreferences(0)));
    System.out.println("Seek test done, creating media player.");
    try
    {
      MediaPlayer localMediaPlayer = new MediaPlayer();
      localMediaPlayer.setDataSource(RingtoneEditActivity.z(this.a).getAbsolutePath());
      localMediaPlayer.setAudioStreamType(3);
      localMediaPlayer.prepare();
      RingtoneEditActivity.a(this.a, localMediaPlayer);
      return;
    }
    catch (IOException localIOException)
    {
      y localy = new y(this, localIOException);
      RingtoneEditActivity.g(this.a).post(localy);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/atomic/apps/ringtone/cutter/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */