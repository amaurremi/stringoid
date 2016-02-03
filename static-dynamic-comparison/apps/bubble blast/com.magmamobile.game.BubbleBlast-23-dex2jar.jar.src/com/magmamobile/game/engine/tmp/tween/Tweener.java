package com.magmamobile.game.engine.tmp.tween;

public class Tweener
{
  protected float factor;
  protected boolean playing;
  protected float speed;
  
  public Tweener()
  {
    this.playing = false;
    this.speed = 0.1F;
    this.factor = 0.0F;
  }
  
  public Tweener(float paramFloat)
  {
    this.speed = paramFloat;
  }
  
  public float getFactor()
  {
    return this.factor;
  }
  
  public float getSpeed()
  {
    return this.speed;
  }
  
  public boolean isPlaying()
  {
    return this.playing;
  }
  
  public void setSpeed(float paramFloat)
  {
    this.speed = paramFloat;
  }
  
  public void start()
  {
    this.factor = 0.0F;
    this.playing = true;
  }
  
  public void stop()
  {
    this.factor = 0.0F;
    this.playing = false;
  }
  
  public boolean update()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.playing)
    {
      if (this.factor != 1.0F) {
        break label29;
      }
      this.playing = false;
      bool1 = true;
    }
    label29:
    do
    {
      return bool1;
      this.factor += this.speed;
      bool1 = bool2;
    } while (this.factor < 1.0F);
    this.factor = 1.0F;
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/tmp/tween/Tweener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */