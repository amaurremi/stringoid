package org.vinuxproject.sonic;

import android.media.AudioTrack;
import mobi.beyondpod.rsscore.helpers.CoreHelper;

public class AndroidAudioDevice
{
  private static final String TAG = "AndroidAudioDevice";
  int mChannels = -1;
  int mSampleRate = -1;
  AudioTrack mTrack;
  
  public AndroidAudioDevice(int paramInt1, int paramInt2)
  {
    createIntrnal(paramInt1, paramInt2);
  }
  
  private static int findFormatFromChannels(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return 4;
    }
    return 12;
  }
  
  public void createIntrnal(int paramInt1, int paramInt2)
  {
    if ((this.mSampleRate == paramInt1) && (this.mChannels == paramInt2)) {
      return;
    }
    if (this.mTrack != null) {
      release();
    }
    int i;
    StringBuilder localStringBuilder;
    if (this.mSampleRate < 0)
    {
      i = 1;
      this.mSampleRate = paramInt1;
      this.mChannels = paramInt2;
      paramInt1 = findFormatFromChannels(this.mChannels);
      paramInt2 = AudioTrack.getMinBufferSize(this.mSampleRate, paramInt1, 2);
      this.mTrack = new AudioTrack(3, this.mSampleRate, paramInt1, 2, paramInt2 * 4, 1);
      this.mTrack.setPlaybackRate(this.mSampleRate);
      localStringBuilder = new StringBuilder("Media format");
      if (i == 0) {
        break label163;
      }
    }
    label163:
    for (String str = ":";; str = " updated:")
    {
      CoreHelper.WriteTraceEntry("AndroidAudioDevice", str + " Rate: " + this.mSampleRate + ", Channels: " + this.mChannels);
      return;
      i = 0;
      break;
    }
  }
  
  public void flush()
  {
    this.mTrack.stop();
    this.mTrack.flush();
  }
  
  public int getHeadPosition()
  {
    return this.mTrack.getPlaybackHeadPosition();
  }
  
  public boolean isPlaying()
  {
    return this.mTrack.getPlayState() == 3;
  }
  
  public void pause()
  {
    this.mTrack.pause();
  }
  
  public void play()
  {
    this.mTrack.play();
  }
  
  public void release()
  {
    flush();
    this.mTrack.release();
  }
  
  public void setAudioStreamType(int paramInt) {}
  
  public void setRateAndChannels(int paramInt1, int paramInt2)
  {
    boolean bool = isPlaying();
    createIntrnal(paramInt1, paramInt2);
    if (bool) {
      play();
    }
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    this.mTrack.setStereoVolume(paramFloat1, paramFloat2);
  }
  
  public void stop()
  {
    flush();
  }
  
  public void writeSamples(byte[] paramArrayOfByte, int paramInt)
  {
    this.mTrack.write(paramArrayOfByte, 0, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/org/vinuxproject/sonic/AndroidAudioDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */