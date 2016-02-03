package com.magmamobile.game.BubbleBlast.engine.texts;

import com.magmamobile.game.engine.Game;
import com.magmamobile.game.engine.GameObject;

public class TextImgGameOver
  extends GameObject
{
  private long gameTick;
  
  public TextImgGameOver()
  {
    show();
    this.gameTick = Game.tick;
  }
  
  public void onAction()
  {
    if (Game.tick - this.gameTick > 15L) {
      if (!this.visible) {
        break label37;
      }
    }
    label37:
    for (boolean bool = false;; bool = true)
    {
      this.visible = bool;
      this.gameTick = Game.tick;
      return;
    }
  }
  
  public void onRender()
  {
    if (!this.visible) {
      return;
    }
    Game.drawBitmapCentered(Game.getBitmap(50), Integer.MIN_VALUE, Integer.MIN_VALUE, null);
  }
  
  public void onReset()
  {
    this.gameTick = Game.tick;
    this.visible = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/engine/texts/TextImgGameOver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */