package com.magmamobile.game.engine.tmp;

import android.graphics.Bitmap;
import com.magmamobile.game.engine.Game;
import com.magmamobile.game.engine.MathUtils;

public class BitmapAnimation
{
  private Bitmap _bitmap;
  private int _frame;
  private AnimBag _frames;
  private int _id;
  private boolean _loop;
  private AnimPackage _package;
  private boolean _playing;
  private long _tick;
  
  public BitmapAnimation(AnimPackage paramAnimPackage)
  {
    this._package = paramAnimPackage;
  }
  
  public void dephase()
  {
    this._frame = MathUtils.randomi(this._frames.frames.length);
    this._tick = (this._frames.frames[this._frame].time + Game.tick);
    this._bitmap = this._frames.frames[this._frame].image;
  }
  
  public Bitmap getBitmap()
  {
    return this._bitmap;
  }
  
  public int getCurrentFrame()
  {
    return this._frame;
  }
  
  public int getSize()
  {
    return this._frames.frames.length;
  }
  
  public boolean isLoop()
  {
    return this._loop;
  }
  
  public boolean isPlaying()
  {
    return this._playing;
  }
  
  public void onAction()
  {
    if ((this._playing) && (this._tick <= Game.tick))
    {
      this._frame += 1;
      if (this._frame >= this._frames.frames.length)
      {
        if (!this._loop) {
          break label99;
        }
        this._frame = 0;
      }
    }
    for (;;)
    {
      this._tick = (this._frames.frames[this._frame].time + Game.tick);
      this._bitmap = this._frames.frames[this._frame].image;
      return;
      label99:
      this._frame = (this._frames.frames.length - 1);
      this._playing = false;
    }
  }
  
  public void play(String paramString)
  {
    this._frame = 0;
    this._loop = true;
    this._playing = true;
    this._id = this._package.getIndexOf(paramString);
    this._frames = this._package.get(this._id);
    this._tick = (this._frames.frames[this._frame].time + Game.tick);
    this._bitmap = this._frames.frames[this._frame].image;
  }
  
  public void playNoStop(String paramString)
  {
    if (!this._playing)
    {
      this._frame = 0;
      this._loop = true;
      this._playing = true;
    }
    int i = this._package.getIndexOf(paramString);
    if (this._id != i)
    {
      this._id = i;
      this._frames = this._package.get(this._id);
      if (this._frame >= this._frames.frames.length) {
        this._frame = 0;
      }
      this._tick = (this._frames.frames[this._frame].time + Game.tick);
      this._bitmap = this._frames.frames[this._frame].image;
    }
  }
  
  public void playOnce(String paramString)
  {
    this._frame = 0;
    this._loop = false;
    this._playing = true;
    this._id = this._package.getIndexOf(paramString);
    this._frames = this._package.get(this._id);
    this._tick = (this._frames.frames[this._frame].time + Game.tick);
    this._bitmap = this._frames.frames[this._frame].image;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this._loop = paramBoolean;
  }
  
  public void stop()
  {
    this._frame = 0;
    this._playing = false;
    this._bitmap = this._frames.frames[0].image;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/tmp/BitmapAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */