package com.magmamobile.game.BubbleBlast.engine.items;

import com.magmamobile.game.engine.Game;
import com.magmamobile.game.engine.MathUtils;
import com.magmamobile.game.engine.Sprite;

public class BubbleBackground
  extends Sprite
{
  private float angle;
  private long gameTick;
  private int speed;
  private float xOrig;
  
  public void onAction()
  {
    if (Game.tick - this.gameTick > this.speed)
    {
      this.gameTick = Game.tick;
      this.angle = ((this.angle + 10.0F) % 360.0F);
      this.y -= 1.0F;
      this.x = (this.xOrig + (float)Math.cos(MathUtils.toRadian(this.angle)) * (30 / (this.speed + 1)));
    }
    if (this.y <= 0.0F) {
      onReset();
    }
  }
  
  public void onReset()
  {
    show();
    setSize(32, 32);
    switch ((int)(Math.random() * 3.0D))
    {
    }
    for (;;)
    {
      setAlpha(150);
      this.x = ((float)(Math.random() * Game.mBufferWidth));
      this.y = Game.mBufferHeight;
      this.xOrig = this.x;
      this.speed = ((int)(Math.random() * 5.0D));
      return;
      setBitmap(Game.getBitmap(25));
      continue;
      setBitmap(Game.getBitmap(24));
      continue;
      setBitmap(Game.getBitmap(23));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/engine/items/BubbleBackground.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */