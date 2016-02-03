package com.magmamobile.game.engine;

import android.media.SoundPool;

public final class Sound
{
  protected int _soundID;
  protected int _streamID;
  
  protected Sound(int paramInt)
  {
    this._soundID = paramInt;
  }
  
  public void pause()
  {
    if ((!Game.opSound) || (Game.soundPool == null)) {}
    while (this._streamID == 0) {
      return;
    }
    Game.soundPool.pause(this._streamID);
  }
  
  public void play()
  {
    if ((!Game.opSound) || (Game.soundPool == null)) {
      return;
    }
    if (this._streamID != 0)
    {
      Game.soundPool.stop(this._streamID);
      this._streamID = 0;
    }
    this._streamID = Game.soundPool.play(this._soundID, 1.0F, 1.0F, 0, 0, 1.0F);
  }
  
  public void playMulti()
  {
    if ((!Game.opSound) || (Game.soundPool == null)) {
      return;
    }
    this._streamID = Game.soundPool.play(this._soundID, 1.0F, 1.0F, 0, 0, 1.0F);
  }
  
  public void resume()
  {
    if ((!Game.opSound) || (Game.soundPool == null)) {}
    while (this._streamID == 0) {
      return;
    }
    Game.soundPool.resume(this._streamID);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/Sound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */