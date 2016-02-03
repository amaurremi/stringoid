package com.magmamobile.game.BubbleBlast.engine.items.layouts;

import com.magmamobile.game.BubbleBlast.modCommon;
import com.magmamobile.game.BubbleBlast.stages.StageGame;
import com.magmamobile.game.engine.Button;
import com.magmamobile.game.engine.Game;
import com.magmamobile.game.engine.GameObject;

public class GameOverArcadeLayout
  extends GameObject
{
  Button btnContinue;
  
  public GameOverArcadeLayout()
  {
    show();
    Game.showBanner();
    if (StageGame.langString.equals("fr"))
    {
      this.btnContinue = new Button(70, 365, 171, 43, false, "", Game.getBitmap(36), null, null, null, 0);
      return;
    }
    this.btnContinue = new Button(70, 365, 171, 43, false, "", Game.getBitmap(35), null, null, null, 0);
  }
  
  public void onAction()
  {
    this.btnContinue.onAction();
    if (this.btnContinue.onClick)
    {
      modCommon.Log_d("Btn Score");
      this.enabled = false;
      StageGame.launchArcadeGameFinished();
    }
  }
  
  public void onRender()
  {
    if (!this.enabled) {
      return;
    }
    Game.drawBitmapCentered(Game.getBitmap(34), StageGame.GameBasePaint);
    if (StageGame.langString.equals("fr"))
    {
      Game.drawBitmap(Game.getBitmap(51), 23, 180, StageGame.GameBasePaint);
      Game.setBmpTextBitmap(Game.getBitmap(46));
      Game.setBmpTextSize(24, 24, 24, 24);
      Game.drawBmpText(40, 250, "SCORE:" + (StageGame.ScoreTotal + StageGame.ScoreLevel), StageGame.GameBasePaint);
      if (!StageGame.langString.equals("fr")) {
        break label162;
      }
      Game.drawBmpText(75, 274, "PLUS DE", StageGame.GameBasePaint);
      Game.drawBmpText(99, 298, "TOUCH", StageGame.GameBasePaint);
    }
    for (;;)
    {
      this.btnContinue.onRender();
      return;
      Game.drawBitmap(Game.getBitmap(50), 23, 180, StageGame.GameBasePaint);
      break;
      label162:
      Game.drawBmpText(75, 274, "NO MORE", StageGame.GameBasePaint);
      Game.drawBmpText(99, 298, "TOUCH", StageGame.GameBasePaint);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/engine/items/layouts/GameOverArcadeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */