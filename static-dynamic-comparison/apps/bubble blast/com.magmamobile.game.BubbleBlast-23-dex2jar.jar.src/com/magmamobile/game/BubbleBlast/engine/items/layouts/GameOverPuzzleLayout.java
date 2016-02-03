package com.magmamobile.game.BubbleBlast.engine.items.layouts;

import com.magmamobile.game.BubbleBlast.modCommon;
import com.magmamobile.game.BubbleBlast.stages.StageGame;
import com.magmamobile.game.engine.Button;
import com.magmamobile.game.engine.Game;
import com.magmamobile.game.engine.GameObject;

public class GameOverPuzzleLayout
  extends GameObject
{
  Button btnHint;
  Button btnRetry;
  
  public GameOverPuzzleLayout()
  {
    show();
    Game.showBanner();
    if (StageGame.langString.equals("fr"))
    {
      this.btnRetry = new Button(100, 365, 109, 43, false, "", Game.getBitmap(44), null, null, null, 0);
      this.btnHint = new Button(210, 60, 102, 33, false, "", Game.getBitmap(38), null, null, null, 0);
      return;
    }
    this.btnRetry = new Button(100, 365, 109, 43, false, "", Game.getBitmap(43), null, null, null, 0);
    this.btnHint = new Button(210, 60, 102, 33, false, "", Game.getBitmap(37), null, null, null, 0);
  }
  
  public void onAction()
  {
    this.btnRetry.onAction();
    if (this.btnRetry.onClick)
    {
      modCommon.Log_d("Btn Retry");
      StageGame.CurrentLevelPuzzleIndex -= 1;
      StageGame.launchNextLevel();
      StageGame.isGameOver = false;
      this.enabled = false;
    }
    this.btnHint.onAction();
    if (this.btnHint.onClick)
    {
      modCommon.Log_d("Btn Hint");
      StageGame.askHint();
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
      if (!StageGame.langString.equals("fr")) {
        break label181;
      }
      Game.drawBmpText(75, 250, "PLUS DE", StageGame.GameBasePaint);
      Game.drawBmpText(99, 274, "TOUCH", StageGame.GameBasePaint);
      Game.drawBmpText(35, 298, "POSSIBLE EN", StageGame.GameBasePaint);
    }
    for (;;)
    {
      Game.drawBmpText(87, 322, StageGame.touchPossibleCount + "TOUCH", StageGame.GameBasePaint);
      this.btnRetry.onRender();
      this.btnHint.onRender();
      return;
      Game.drawBitmap(Game.getBitmap(50), 23, 180, StageGame.GameBasePaint);
      break;
      label181:
      Game.drawBmpText(75, 250, "NO MORE", StageGame.GameBasePaint);
      Game.drawBmpText(99, 274, "TOUCH", StageGame.GameBasePaint);
      Game.drawBmpText(35, 298, "POSSIBLE IN", StageGame.GameBasePaint);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/engine/items/layouts/GameOverPuzzleLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */