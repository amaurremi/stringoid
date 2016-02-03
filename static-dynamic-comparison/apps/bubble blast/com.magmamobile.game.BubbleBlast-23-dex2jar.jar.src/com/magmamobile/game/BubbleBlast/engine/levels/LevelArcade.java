package com.magmamobile.game.BubbleBlast.engine.levels;

import com.magmamobile.game.BubbleBlast.engine.BubbleUtils;
import com.magmamobile.game.BubbleBlast.engine.Enums.enumBubbleState;
import com.magmamobile.game.BubbleBlast.engine.items.Bubble;
import com.magmamobile.game.BubbleBlast.modCommon;
import com.magmamobile.game.BubbleBlast.stages.StageGame;
import com.magmamobile.game.engine.GameArray;

public class LevelArcade
{
  private String BubbleTable = "";
  
  public String getLastTableStr()
  {
    return this.BubbleTable;
  }
  
  public void nextLevel()
  {
    this.BubbleTable = "";
    StageGame.bubblesMini.clear();
    StageGame.bubblesMini.onAction();
    StageGame.selectedBackground = StageGame.randBackground();
    StageGame.setBackground();
    if (StageGame.bubbles.total > 0) {
      return;
    }
    int i = 0;
    int j;
    for (;;)
    {
      if (i >= 6)
      {
        modCommon.Log_d(this.BubbleTable);
        return;
      }
      j = 0;
      if (j < 5) {
        break;
      }
      i += 1;
    }
    switch ((int)(Math.random() * 5.0D))
    {
    }
    for (;;)
    {
      j += 1;
      break;
      this.BubbleTable += "0,";
      continue;
      this.BubbleTable += "1,";
      Bubble localBubble = (Bubble)StageGame.bubbles.allocate();
      localBubble.x = (j * 64 + 24 + 8);
      localBubble.y = (i * 64 + 24 + 50);
      localBubble.state = Enums.enumBubbleState.micro;
      localBubble.animIndex = BubbleUtils.setBitmapAnim(localBubble, localBubble.state, localBubble.animIndex);
      localBubble.setBubbleZoom();
      continue;
      this.BubbleTable += "2,";
      localBubble = (Bubble)StageGame.bubbles.allocate();
      localBubble.x = (j * 64 + 24 + 8);
      localBubble.y = (i * 64 + 24 + 50);
      localBubble.state = Enums.enumBubbleState.mini;
      localBubble.animIndex = BubbleUtils.setBitmapAnim(localBubble, localBubble.state, localBubble.animIndex);
      localBubble.setBubbleZoom();
      continue;
      this.BubbleTable += "3,";
      localBubble = (Bubble)StageGame.bubbles.allocate();
      localBubble.x = (j * 64 + 24 + 8);
      localBubble.y = (i * 64 + 24 + 50);
      localBubble.state = Enums.enumBubbleState.medium;
      localBubble.animIndex = BubbleUtils.setBitmapAnim(localBubble, localBubble.state, localBubble.animIndex);
      localBubble.setBubbleZoom();
      continue;
      this.BubbleTable += "4,";
      localBubble = (Bubble)StageGame.bubbles.allocate();
      localBubble.x = (j * 64 + 24 + 8);
      localBubble.y = (i * 64 + 24 + 50);
      localBubble.state = Enums.enumBubbleState.big;
      localBubble.animIndex = BubbleUtils.setBitmapAnim(localBubble, localBubble.state, localBubble.animIndex);
      localBubble.setBubbleZoom();
    }
  }
  
  public void setupApp() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/engine/levels/LevelArcade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */