package com.magmamobile.game.BubbleBlast.engine.items;

import com.magmamobile.game.BubbleBlast.engine.BubbleUtils;
import com.magmamobile.game.BubbleBlast.engine.Enums.enumBubbleState;
import com.magmamobile.game.BubbleBlast.engine.Enums.enumDirection;
import com.magmamobile.game.BubbleBlast.stages.StageGame;
import com.magmamobile.game.engine.Game;
import com.magmamobile.game.engine.GameArray;
import com.magmamobile.game.engine.Sprite;

public class BubbleMini
  extends Sprite
{
  public int animIndex;
  public Enums.enumDirection direction;
  private long gameTick;
  public int speed = 8;
  public Enums.enumBubbleState state = Enums.enumBubbleState.micro;
  
  public BubbleMini()
  {
    show();
    this.x = Game.mBufferCW;
    this.y = Game.mBufferCH;
    setSize(48, 48);
    setBitmap(Game.getBitmap(5));
    this.speed = 8;
  }
  
  public void onAction()
  {
    if (!this.enabled) {
      return;
    }
    if (Game.tick - this.gameTick > 2L)
    {
      this.gameTick = Game.tick;
      this.animIndex = BubbleUtils.setBitmapAnim(this, this.state, this.animIndex);
    }
    label88:
    int i;
    switch (this.direction)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      if (i >= StageGame.bubbles.total)
      {
        if ((this.x <= Game.mBufferWidth) && (this.y <= Game.mBufferHeight) && (this.x >= 0.0F) && (this.y >= 0.0F)) {
          break;
        }
        this.enabled = false;
        return;
        this.y -= this.speed;
        break label88;
        this.x -= this.speed;
        break label88;
        this.y += this.speed;
        break label88;
        this.x += this.speed;
        break label88;
      }
      if ((((Bubble[])StageGame.bubbles.array)[i].enabled) && (this.x == ((Bubble[])StageGame.bubbles.array)[i].x) && (this.y == ((Bubble[])StageGame.bubbles.array)[i].y))
      {
        this.enabled = false;
        ((Bubble[])StageGame.bubbles.array)[i].BubbleTouched(false);
      }
      i += 1;
    }
  }
  
  public void onReset()
  {
    show();
    setZoom(0.5F);
    setAlpha(150);
    this.speed = 8;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/engine/items/BubbleMini.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */