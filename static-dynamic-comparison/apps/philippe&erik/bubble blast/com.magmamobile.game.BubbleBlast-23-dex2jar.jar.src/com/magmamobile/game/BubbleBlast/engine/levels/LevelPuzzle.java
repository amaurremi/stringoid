package com.magmamobile.game.BubbleBlast.engine.levels;

import com.magmamobile.game.BubbleBlast.engine.BubbleUtils;
import com.magmamobile.game.BubbleBlast.engine.Enums.enumBackground;
import com.magmamobile.game.BubbleBlast.engine.Enums.enumBubbleState;
import com.magmamobile.game.BubbleBlast.engine.items.Bubble;
import com.magmamobile.game.BubbleBlast.stages.StageGame;
import com.magmamobile.game.BubbleBlast.utils.json.JSonLevel;
import com.magmamobile.game.engine.GameArray;
import org.json.JSONException;

public final class LevelPuzzle
{
  public static LevelInfo[] lvlNfo;
  private Enums.enumBackground _background;
  private int _levelPack;
  
  public LevelPuzzle(Enums.enumBackground paramenumBackground, int paramInt)
  {
    this._background = paramenumBackground;
    this._levelPack = paramInt;
    for (lvlNfo = null;; lvlNfo = JSonLevel.loadItems(58))
    {
      try
      {
        paramInt = this._levelPack;
        switch (paramInt)
        {
        }
      }
      catch (JSONException paramenumBackground)
      {
        for (;;)
        {
          paramenumBackground.printStackTrace();
          continue;
          lvlNfo = JSonLevel.loadItems(59);
          continue;
          lvlNfo = JSonLevel.loadItems(60);
          continue;
          lvlNfo = JSonLevel.loadItems(61);
          continue;
          lvlNfo = JSonLevel.loadItems(62);
          continue;
          lvlNfo = JSonLevel.loadItems(63);
          continue;
          lvlNfo = JSonLevel.loadItems(64);
          continue;
          lvlNfo = JSonLevel.loadItems(65);
          continue;
          lvlNfo = JSonLevel.loadItems(66);
          continue;
          lvlNfo = JSonLevel.loadItems(67);
          continue;
          lvlNfo = JSonLevel.loadItems(68);
          continue;
          lvlNfo = JSonLevel.loadItems(69);
          continue;
          lvlNfo = JSonLevel.loadItems(70);
          continue;
          lvlNfo = JSonLevel.loadItems(71);
          continue;
          lvlNfo = JSonLevel.loadItems(72);
          continue;
          lvlNfo = JSonLevel.loadItems(73);
          continue;
          lvlNfo = JSonLevel.loadItems(74);
          continue;
          lvlNfo = JSonLevel.loadItems(75);
          continue;
          lvlNfo = JSonLevel.loadItems(76);
          continue;
          lvlNfo = JSonLevel.loadItems(77);
          continue;
          lvlNfo = JSonLevel.loadItems(78);
          continue;
          lvlNfo = JSonLevel.loadItems(79);
        }
      }
      nextLevel(StageGame.CurrentLevelPuzzleIndex);
      return;
    }
  }
  
  public void nextLevel(int paramInt)
  {
    if (paramInt > 4) {
      this._background = StageGame.randBackground();
    }
    StageGame.bubblesMini.clear();
    StageGame.bubblesMini.onAction();
    StageGame.selectedBackground = this._background;
    StageGame.setBackground();
    if (StageGame.bubbles.total > 0) {
      StageGame.bubbles.clear();
    }
    if (paramInt >= lvlNfo.length) {}
    LevelInfo localLevelInfo;
    int i;
    for (;;)
    {
      return;
      localLevelInfo = lvlNfo[paramInt];
      StageGame.touchLeftCount = localLevelInfo.toucheMax;
      StageGame.touchPossibleCount = localLevelInfo.toucheMax;
      paramInt = 0;
      while (paramInt < 5)
      {
        i = 0;
        if (i < 6) {
          break label100;
        }
        paramInt += 1;
      }
    }
    label100:
    switch (localLevelInfo.items[(paramInt + i * 5)])
    {
    }
    for (;;)
    {
      i += 1;
      break;
      Bubble localBubble = (Bubble)StageGame.bubbles.allocate();
      localBubble.x = (paramInt * 64 + 24 + 8);
      localBubble.y = (i * 64 + 24 + 50);
      localBubble.setPosition(paramInt + 1, i + 1);
      localBubble.state = Enums.enumBubbleState.micro;
      localBubble.animIndex = BubbleUtils.setBitmapAnim(localBubble, localBubble.state, localBubble.animIndex);
      localBubble.setBubbleZoom();
      continue;
      localBubble = (Bubble)StageGame.bubbles.allocate();
      localBubble.x = (paramInt * 64 + 24 + 8);
      localBubble.y = (i * 64 + 24 + 50);
      localBubble.setPosition(paramInt + 1, i + 1);
      localBubble.state = Enums.enumBubbleState.mini;
      localBubble.animIndex = BubbleUtils.setBitmapAnim(localBubble, localBubble.state, localBubble.animIndex);
      localBubble.setBubbleZoom();
      continue;
      localBubble = (Bubble)StageGame.bubbles.allocate();
      localBubble.x = (paramInt * 64 + 24 + 8);
      localBubble.y = (i * 64 + 24 + 50);
      localBubble.setPosition(paramInt + 1, i + 1);
      localBubble.state = Enums.enumBubbleState.medium;
      localBubble.animIndex = BubbleUtils.setBitmapAnim(localBubble, localBubble.state, localBubble.animIndex);
      localBubble.setBubbleZoom();
      continue;
      localBubble = (Bubble)StageGame.bubbles.allocate();
      localBubble.x = (paramInt * 64 + 24 + 8);
      localBubble.y = (i * 64 + 24 + 50);
      localBubble.setPosition(paramInt + 1, i + 1);
      localBubble.state = Enums.enumBubbleState.big;
      localBubble.animIndex = BubbleUtils.setBitmapAnim(localBubble, localBubble.state, localBubble.animIndex);
      localBubble.setBubbleZoom();
    }
  }
  
  public void setupApp() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/engine/levels/LevelPuzzle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */