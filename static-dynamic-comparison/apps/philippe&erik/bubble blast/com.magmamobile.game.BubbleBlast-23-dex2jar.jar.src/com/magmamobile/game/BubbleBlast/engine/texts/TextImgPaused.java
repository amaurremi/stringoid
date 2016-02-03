package com.magmamobile.game.BubbleBlast.engine.texts;

import com.magmamobile.game.engine.Game;
import com.magmamobile.game.engine.Sprite;

public class TextImgPaused
  extends Sprite
{
  public TextImgPaused()
  {
    show();
    this.x = Game.mBufferCW;
    this.y = Game.mBufferCH;
    setBitmap(Game.getBitmap(52));
  }
  
  public void onAction()
  {
    if (!this.enabled) {}
  }
  
  public void onReset()
  {
    show();
    this.x = Game.mBufferCW;
    this.y = Game.mBufferCH;
    setBitmap(Game.getBitmap(52));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/engine/texts/TextImgPaused.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */