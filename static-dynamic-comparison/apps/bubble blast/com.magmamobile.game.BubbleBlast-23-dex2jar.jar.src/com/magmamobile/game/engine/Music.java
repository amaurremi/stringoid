package com.magmamobile.game.engine;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;

public final class Music
{
  private boolean _continuous;
  private MediaPlayer _mediaPlayer;
  private int _res;
  private float _volume;
  
  @Deprecated
  public Music() {}
  
  public Music(int paramInt)
  {
    this._continuous = true;
    this._res = paramInt;
    this._volume = 2.0F;
  }
  
  public boolean getContinuous()
  {
    return this._continuous;
  }
  
  public float getVolume()
  {
    return this._volume;
  }
  
  @Deprecated
  public void initialize(Context paramContext) {}
  
  public boolean isPlaying()
  {
    if (this._mediaPlayer == null) {
      return false;
    }
    try
    {
      boolean bool = this._mediaPlayer.isPlaying();
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public void pause()
  {
    if (this._mediaPlayer == null) {}
    for (;;)
    {
      return;
      try
      {
        if (this._mediaPlayer.isPlaying())
        {
          this._mediaPlayer.pause();
          return;
        }
      }
      catch (Exception localException) {}
    }
  }
  
  public void play()
  {
    if (!Game.opMusic) {}
    for (;;)
    {
      return;
      if (this._mediaPlayer != null) {
        terminate();
      }
      try
      {
        if (!isPlaying())
        {
          AssetFileDescriptor localAssetFileDescriptor = Game.getContext().getAssets().openFd(GamePak.getAssetName(this._res));
          this._mediaPlayer = new MediaPlayer();
          this._mediaPlayer.setDataSource(localAssetFileDescriptor.getFileDescriptor(), localAssetFileDescriptor.getStartOffset() + GamePak.getOffset(this._res), GamePak.getSize(this._res));
          this._mediaPlayer.setAudioStreamType(3);
          this._mediaPlayer.setVolume(this._volume, this._volume);
          this._mediaPlayer.setLooping(this._continuous);
          this._mediaPlayer.prepare();
          this._mediaPlayer.start();
          return;
        }
      }
      catch (Exception localException) {}
    }
  }
  
  @Deprecated
  public void play(int paramInt)
  {
    this._res = paramInt;
    play();
  }
  
  public void restart()
  {
    if (this._mediaPlayer == null) {
      return;
    }
    try
    {
      this._mediaPlayer.seekTo(0);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void resume()
  {
    if (!Game.opMusic) {}
    while (this._mediaPlayer == null) {
      return;
    }
    try
    {
      this._mediaPlayer.start();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void seek(int paramInt)
  {
    if (this._mediaPlayer == null) {
      return;
    }
    try
    {
      this._mediaPlayer.seekTo(paramInt);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void setContinuous(boolean paramBoolean)
  {
    this._continuous = paramBoolean;
    if (this._mediaPlayer == null) {
      return;
    }
    try
    {
      this._mediaPlayer.setLooping(this._continuous);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void setVolume(float paramFloat)
  {
    this._volume = paramFloat;
    if (this._mediaPlayer == null) {
      return;
    }
    try
    {
      this._mediaPlayer.setVolume(this._volume, this._volume);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void stop()
  {
    if (this._mediaPlayer == null) {
      return;
    }
    try
    {
      this._mediaPlayer.stop();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void terminate()
  {
    if (this._mediaPlayer == null) {
      return;
    }
    try
    {
      if (this._mediaPlayer.isPlaying()) {
        this._mediaPlayer.stop();
      }
      this._mediaPlayer.release();
      this._mediaPlayer = null;
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/Music.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */