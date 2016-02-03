package com.magmamobile.game.BubbleBlast.engine.items.layouts;

import com.magmamobile.game.BubbleBlast.modCommon;
import com.magmamobile.game.BubbleBlast.stages.StageGame;
import com.magmamobile.game.engine.Button;
import com.magmamobile.game.engine.Game;
import com.magmamobile.game.engine.GameObject;

public class CongratsPuzzleEndLayout
  extends GameObject
{
  Button btnRateInMarket;
  Button btnScores;
  
  public CongratsPuzzleEndLayout()
  {
    show();
    Game.showBanner();
    if (StageGame.langString.equals("fr"))
    {
      this.btnScores = new Button(10, 365, 109, 43, false, "", Game.getBitmap(45), null, null, null, 0);
      this.btnRateInMarket = new Button(130, 365, 171, 43, false, "", Game.getBitmap(42), null, null, null, 0);
      return;
    }
    this.btnScores = new Button(10, 365, 109, 43, false, "", Game.getBitmap(45), null, null, null, 0);
    this.btnRateInMarket = new Button(130, 365, 171, 43, false, "", Game.getBitmap(41), null, null, null, 0);
  }
  
  public void onAction()
  {
    this.btnRateInMarket.onAction();
    if (this.btnRateInMarket.onClick)
    {
      modCommon.Log_d("Btn rate market !");
      modCommon.openMarket(Game.getContext(), "com.magmamobile.game.BubbleBlast");
      Game.Quit();
      StageGame.quit();
      this.enabled = false;
    }
    this.btnScores.onAction();
    if (this.btnScores.onClick)
    {
      modCommon.Log_d("Btn Puzzle Scores");
      StageGame.launchPuzzleGameFinished();
      Game.Quit();
      StageGame.quit();
      this.enabled = false;
    }
  }
  
  public void onRender()
  {
    if (!this.enabled) {
      return;
    }
    Game.drawBitmapCentered(Game.getBitmap(33), StageGame.GameBasePaint);
    if (StageGame.langString.equals("fr"))
    {
      Game.drawBitmap(Game.getBitmap(48), 23, 100, StageGame.GameBasePaint);
      Game.setBmpTextBitmap(Game.getBitmap(49));
      Game.setBmpTextSize(16, 16, 16, 16);
      if (!StageGame.langString.equals("fr")) {
        break label873;
      }
      Game.drawBmpText(5, 162, "VOUS AVEZ FINI", StageGame.GameBasePaint);
      Game.drawBmpText(5, 178, "TOUS LES PUZZLES !", StageGame.GameBasePaint);
      Game.drawBmpText(5, 194, "NOUS AJOUTERONS DES", StageGame.GameBasePaint);
      Game.drawBmpText(5, 210, "NIVEAUX DANS LES MAJ", StageGame.GameBasePaint);
      Game.drawBmpText(5, 226, "POUR INFO:", StageGame.GameBasePaint);
      Game.drawBmpText(5, 242, "UN BON COMMENTAIRE", StageGame.GameBasePaint);
      Game.drawBmpText(5, 258, "DANS LE MARKET", StageGame.GameBasePaint);
      Game.drawBmpText(5, 274, "NOUS ENCOURAGERA A", StageGame.GameBasePaint);
      Game.drawBmpText(5, 290, "AJOUTER DES PUZZLES !", StageGame.GameBasePaint);
      if (StageGame.levelPackPuzzle != 1) {
        break label247;
      }
      Game.drawBmpText(5, 316, "PACK DE NIVEAUX 2", StageGame.GameBasePaint);
      Game.drawBmpText(5, 332, "DEBLOQUE !", StageGame.GameBasePaint);
    }
    for (;;)
    {
      this.btnRateInMarket.onRender();
      this.btnScores.onRender();
      return;
      Game.drawBitmap(Game.getBitmap(47), 23, 100, StageGame.GameBasePaint);
      break;
      label247:
      if (StageGame.levelPackPuzzle == 2)
      {
        Game.drawBmpText(5, 316, "PACK DE NIVEAUX 3", StageGame.GameBasePaint);
        Game.drawBmpText(5, 332, "DEBLOQUE !", StageGame.GameBasePaint);
      }
      else if (StageGame.levelPackPuzzle == 3)
      {
        Game.drawBmpText(5, 316, "PACK DE NIVEAUX 4", StageGame.GameBasePaint);
        Game.drawBmpText(5, 332, "DEBLOQUE !", StageGame.GameBasePaint);
      }
      else if (StageGame.levelPackPuzzle == 4)
      {
        Game.drawBmpText(5, 316, "PACK DE NIVEAUX 5", StageGame.GameBasePaint);
        Game.drawBmpText(5, 332, "DEBLOQUE !", StageGame.GameBasePaint);
      }
      else if (StageGame.levelPackPuzzle == 5)
      {
        Game.drawBmpText(5, 316, "PACK DE NIVEAUX 6", StageGame.GameBasePaint);
        Game.drawBmpText(5, 332, "DEBLOQUE !", StageGame.GameBasePaint);
      }
      else if (StageGame.levelPackPuzzle == 6)
      {
        Game.drawBmpText(5, 316, "PACK DE NIVEAUX 7", StageGame.GameBasePaint);
        Game.drawBmpText(5, 332, "DEBLOQUE !", StageGame.GameBasePaint);
      }
      else if (StageGame.levelPackPuzzle == 7)
      {
        Game.drawBmpText(5, 316, "PACK DE NIVEAUX 8", StageGame.GameBasePaint);
        Game.drawBmpText(5, 332, "DEBLOQUE !", StageGame.GameBasePaint);
      }
      else if (StageGame.levelPackPuzzle == 8)
      {
        Game.drawBmpText(5, 316, "PACK DE NIVEAUX 9", StageGame.GameBasePaint);
        Game.drawBmpText(5, 332, "DEBLOQUE !", StageGame.GameBasePaint);
      }
      else if (StageGame.levelPackPuzzle == 9)
      {
        Game.drawBmpText(5, 316, "PACK DE NIVEAUX 10", StageGame.GameBasePaint);
        Game.drawBmpText(5, 332, "DEBLOQUE !", StageGame.GameBasePaint);
      }
      else if (StageGame.levelPackPuzzle == 10)
      {
        Game.drawBmpText(5, 316, "PACK DE NIVEAUX 11", StageGame.GameBasePaint);
        Game.drawBmpText(5, 332, "DEBLOQUE !", StageGame.GameBasePaint);
      }
      else if (StageGame.levelPackPuzzle == 11)
      {
        Game.drawBmpText(5, 316, "PACK DE NIVEAUX 12", StageGame.GameBasePaint);
        Game.drawBmpText(5, 332, "DEBLOQUE !", StageGame.GameBasePaint);
      }
      else if (StageGame.levelPackPuzzle == 12)
      {
        Game.drawBmpText(5, 316, "PACK DE NIVEAUX 13", StageGame.GameBasePaint);
        Game.drawBmpText(5, 332, "DEBLOQUE !", StageGame.GameBasePaint);
      }
      else if (StageGame.levelPackPuzzle == 13)
      {
        Game.drawBmpText(5, 316, "PACK DE NIVEAUX 14", StageGame.GameBasePaint);
        Game.drawBmpText(5, 332, "DEBLOQUE !", StageGame.GameBasePaint);
      }
      else if (StageGame.levelPackPuzzle == 14)
      {
        Game.drawBmpText(5, 316, "PACK DE NIVEAUX 15", StageGame.GameBasePaint);
        Game.drawBmpText(5, 332, "DEBLOQUE !", StageGame.GameBasePaint);
      }
      else if (StageGame.levelPackPuzzle == 15)
      {
        Game.drawBmpText(5, 316, "PACK DE NIVEAUX 16", StageGame.GameBasePaint);
        Game.drawBmpText(5, 332, "DEBLOQUE !", StageGame.GameBasePaint);
      }
      else if (StageGame.levelPackPuzzle == 16)
      {
        Game.drawBmpText(5, 316, "PACK DE NIVEAUX 17", StageGame.GameBasePaint);
        Game.drawBmpText(5, 332, "DEBLOQUE !", StageGame.GameBasePaint);
      }
      else if (StageGame.levelPackPuzzle == 17)
      {
        Game.drawBmpText(5, 316, "PACK DE NIVEAUX 18", StageGame.GameBasePaint);
        Game.drawBmpText(5, 332, "DEBLOQUE !", StageGame.GameBasePaint);
      }
      else if (StageGame.levelPackPuzzle == 18)
      {
        Game.drawBmpText(5, 316, "PACK DE NIVEAUX 19", StageGame.GameBasePaint);
        Game.drawBmpText(5, 332, "DEBLOQUE !", StageGame.GameBasePaint);
      }
      else if (StageGame.levelPackPuzzle == 19)
      {
        Game.drawBmpText(5, 316, "PACK DE NIVEAUX 20", StageGame.GameBasePaint);
        Game.drawBmpText(5, 332, "DEBLOQUE !", StageGame.GameBasePaint);
        continue;
        label873:
        Game.drawBmpText(5, 162, "YOU FINISHED ALL", StageGame.GameBasePaint);
        Game.drawBmpText(5, 178, "BUBBLE BLAST PUZZLES !", StageGame.GameBasePaint);
        Game.drawBmpText(5, 194, "WE'LL ADD PUZZLES", StageGame.GameBasePaint);
        Game.drawBmpText(5, 210, "IN A NEXT UPDATE", StageGame.GameBasePaint);
        Game.drawBmpText(5, 226, "REMEMBER:", StageGame.GameBasePaint);
        Game.drawBmpText(5, 242, "FAVORABLE RATINGS", StageGame.GameBasePaint);
        Game.drawBmpText(5, 258, "IN THE MARKET", StageGame.GameBasePaint);
        Game.drawBmpText(5, 274, "WILL ENCOURAGE US TO", StageGame.GameBasePaint);
        Game.drawBmpText(5, 290, "ADD MORE PUZZLES !", StageGame.GameBasePaint);
        if (StageGame.levelPackPuzzle == 1)
        {
          Game.drawBmpText(5, 316, "LEVEL PACK 2", StageGame.GameBasePaint);
          Game.drawBmpText(5, 332, "UNLOCKED !", StageGame.GameBasePaint);
        }
        else if (StageGame.levelPackPuzzle == 2)
        {
          Game.drawBmpText(5, 316, "LEVEL PACK 3", StageGame.GameBasePaint);
          Game.drawBmpText(5, 332, "UNLOCKED !", StageGame.GameBasePaint);
        }
        else if (StageGame.levelPackPuzzle == 3)
        {
          Game.drawBmpText(5, 316, "LEVEL PACK 4", StageGame.GameBasePaint);
          Game.drawBmpText(5, 332, "UNLOCKED !", StageGame.GameBasePaint);
        }
        else if (StageGame.levelPackPuzzle == 4)
        {
          Game.drawBmpText(5, 316, "LEVEL PACK 5", StageGame.GameBasePaint);
          Game.drawBmpText(5, 332, "UNLOCKED !", StageGame.GameBasePaint);
        }
        else if (StageGame.levelPackPuzzle == 5)
        {
          Game.drawBmpText(5, 316, "LEVEL PACK 6", StageGame.GameBasePaint);
          Game.drawBmpText(5, 332, "UNLOCKED !", StageGame.GameBasePaint);
        }
        else if (StageGame.levelPackPuzzle == 6)
        {
          Game.drawBmpText(5, 316, "LEVEL PACK 7", StageGame.GameBasePaint);
          Game.drawBmpText(5, 332, "UNLOCKED !", StageGame.GameBasePaint);
        }
        else if (StageGame.levelPackPuzzle == 7)
        {
          Game.drawBmpText(5, 316, "LEVEL PACK 8", StageGame.GameBasePaint);
          Game.drawBmpText(5, 332, "UNLOCKED !", StageGame.GameBasePaint);
        }
        else if (StageGame.levelPackPuzzle == 8)
        {
          Game.drawBmpText(5, 316, "LEVEL PACK 9", StageGame.GameBasePaint);
          Game.drawBmpText(5, 332, "UNLOCKED !", StageGame.GameBasePaint);
        }
        else if (StageGame.levelPackPuzzle == 9)
        {
          Game.drawBmpText(5, 316, "LEVEL PACK 10", StageGame.GameBasePaint);
          Game.drawBmpText(5, 332, "UNLOCKED !", StageGame.GameBasePaint);
        }
        else if (StageGame.levelPackPuzzle == 10)
        {
          Game.drawBmpText(5, 316, "LEVEL PACK 11", StageGame.GameBasePaint);
          Game.drawBmpText(5, 332, "UNLOCKED !", StageGame.GameBasePaint);
        }
        else if (StageGame.levelPackPuzzle == 11)
        {
          Game.drawBmpText(5, 316, "LEVEL PACK 12", StageGame.GameBasePaint);
          Game.drawBmpText(5, 332, "UNLOCKED !", StageGame.GameBasePaint);
        }
        else if (StageGame.levelPackPuzzle == 12)
        {
          Game.drawBmpText(5, 316, "LEVEL PACK 13", StageGame.GameBasePaint);
          Game.drawBmpText(5, 332, "UNLOCKED !", StageGame.GameBasePaint);
        }
        else if (StageGame.levelPackPuzzle == 13)
        {
          Game.drawBmpText(5, 316, "LEVEL PACK 14", StageGame.GameBasePaint);
          Game.drawBmpText(5, 332, "UNLOCKED !", StageGame.GameBasePaint);
        }
        else if (StageGame.levelPackPuzzle == 14)
        {
          Game.drawBmpText(5, 316, "LEVEL PACK 15", StageGame.GameBasePaint);
          Game.drawBmpText(5, 332, "UNLOCKED !", StageGame.GameBasePaint);
        }
        else if (StageGame.levelPackPuzzle == 15)
        {
          Game.drawBmpText(5, 316, "LEVEL PACK 16", StageGame.GameBasePaint);
          Game.drawBmpText(5, 332, "UNLOCKED !", StageGame.GameBasePaint);
        }
        else if (StageGame.levelPackPuzzle == 16)
        {
          Game.drawBmpText(5, 316, "LEVEL PACK 17", StageGame.GameBasePaint);
          Game.drawBmpText(5, 332, "UNLOCKED !", StageGame.GameBasePaint);
        }
        else if (StageGame.levelPackPuzzle == 17)
        {
          Game.drawBmpText(5, 316, "LEVEL PACK 18", StageGame.GameBasePaint);
          Game.drawBmpText(5, 332, "UNLOCKED !", StageGame.GameBasePaint);
        }
        else if (StageGame.levelPackPuzzle == 18)
        {
          Game.drawBmpText(5, 316, "LEVEL PACK 19", StageGame.GameBasePaint);
          Game.drawBmpText(5, 332, "UNLOCKED !", StageGame.GameBasePaint);
        }
        else if (StageGame.levelPackPuzzle == 19)
        {
          Game.drawBmpText(5, 316, "LEVEL PACK 20", StageGame.GameBasePaint);
          Game.drawBmpText(5, 332, "UNLOCKED !", StageGame.GameBasePaint);
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/engine/items/layouts/CongratsPuzzleEndLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */