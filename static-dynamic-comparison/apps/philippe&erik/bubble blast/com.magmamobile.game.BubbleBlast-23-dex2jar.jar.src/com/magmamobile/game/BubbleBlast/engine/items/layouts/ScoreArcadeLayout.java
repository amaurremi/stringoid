package com.magmamobile.game.BubbleBlast.engine.items.layouts;

import com.magmamobile.game.BubbleBlast.modCommon;
import com.magmamobile.game.BubbleBlast.stages.StageGame;
import com.magmamobile.game.engine.Button;
import com.magmamobile.game.engine.Game;
import com.magmamobile.game.engine.GameObject;

public class ScoreArcadeLayout
  extends GameObject
{
  Button btnNext;
  
  public ScoreArcadeLayout()
  {
    show();
    Game.showBanner();
    if (StageGame.langString.equals("fr"))
    {
      this.btnNext = new Button(130, 365, 171, 43, false, "", Game.getBitmap(40), null, null, null, 0);
      return;
    }
    this.btnNext = new Button(130, 365, 171, 43, false, "", Game.getBitmap(39), null, null, null, 0);
  }
  
  public void onAction()
  {
    this.btnNext.onAction();
    if (this.btnNext.onClick)
    {
      modCommon.Log_d("Btn next level");
      StageGame.launchNextLevel();
      this.enabled = false;
    }
  }
  
  public void onRender()
  {
    if (!this.enabled) {
      return;
    }
    Game.drawBitmapCentered(Game.getBitmap(33), StageGame.GameBasePaint);
    Game.setBmpTextBitmap(Game.getBitmap(46));
    Game.setBmpTextSize(24, 24, 24, 24);
    Game.drawBmpText(46, 162, "LEVEL:" + (StageGame.CurrentLevelArcadeIndex + 1), StageGame.GameBasePaint);
    Game.drawBmpText(46, 196, "SCORE:" + StageGame.ScoreTotal, StageGame.GameBasePaint);
    Game.drawBmpText(46, 230, "TOUCH:" + StageGame.itemTouchedCount, StageGame.GameBasePaint);
    this.btnNext.onRender();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/engine/items/layouts/ScoreArcadeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */