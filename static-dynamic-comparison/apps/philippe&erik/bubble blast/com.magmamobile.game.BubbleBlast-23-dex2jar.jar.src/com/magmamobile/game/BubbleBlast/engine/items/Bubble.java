package com.magmamobile.game.BubbleBlast.engine.items;

import com.magmamobile.game.BubbleBlast.App;
import com.magmamobile.game.BubbleBlast.engine.BubbleUtils;
import com.magmamobile.game.BubbleBlast.engine.Enums.enumBubbleState;
import com.magmamobile.game.BubbleBlast.engine.Enums.enumDirection;
import com.magmamobile.game.BubbleBlast.stages.StageGame;
import com.magmamobile.game.engine.Game;
import com.magmamobile.game.engine.GameArray;
import com.magmamobile.game.engine.Sound;
import com.magmamobile.game.engine.Sprite;
import com.magmamobile.game.engine.TouchScreen;

public final class Bubble
  extends Sprite
{
  public int animIndex;
  private long gameTick;
  private int positionX = 0;
  private int positionY = 0;
  public Enums.enumBubbleState state = Enums.enumBubbleState.micro;
  
  public Bubble()
  {
    show();
    this.x = Game.mBufferCW;
    this.y = Game.mBufferCH;
    setSize(48, 48);
    this.animIndex = 0;
    this.animIndex = BubbleUtils.setBitmapAnim(this, this.state, this.animIndex);
  }
  
  public void BubbleTouched(boolean paramBoolean)
  {
    if (!this.enabled) {
      return;
    }
    switch (this.state)
    {
    }
    for (;;)
    {
      setBubbleZoom();
      return;
      this.state = Enums.enumBubbleState.mini;
      setBitmap(27);
      if (!App.SoundBubble001Playing)
      {
        App.SoundBubble001.play();
        App.SoundBubble001Playing = true;
        continue;
        this.state = Enums.enumBubbleState.medium;
        setBitmap(11);
        if (!App.SoundBubble001Playing)
        {
          App.SoundBubble001.play();
          App.SoundBubble001Playing = true;
          continue;
          this.state = Enums.enumBubbleState.big;
          setBitmap(17);
          if (!App.SoundBubble001Playing)
          {
            App.SoundBubble001.play();
            App.SoundBubble001Playing = true;
            continue;
            StageGame.addScore(10);
            if (!paramBoolean) {
              sendBubblesMini();
            }
            if (!App.SoundPop004Playing)
            {
              App.SoundPop004.play();
              App.SoundPop004Playing = true;
            }
            this.enabled = false;
            if (paramBoolean) {
              switch (StageGame.gameMode)
              {
              }
            }
          }
        }
      }
    }
  }
  
  public void onAction()
  {
    if (!StageGame.started) {}
    do
    {
      return;
      if (Game.tick - this.gameTick > 1L)
      {
        this.gameTick = Game.tick;
        this.animIndex = BubbleUtils.setBitmapAnim(this, this.state, this.animIndex);
      }
    } while ((!TouchScreen.eventDown) || (StageGame.touchLeftCount <= 0) || (!hit(TouchScreen.x, TouchScreen.y)));
    if (StageGame.puzzleSolution.length() > 0) {
      StageGame.puzzleSolution += ",";
    }
    StageGame.puzzleSolution = StageGame.puzzleSolution + this.positionX + "-" + this.positionY;
    sendBubblesMini();
    StageGame.ItemTouched();
    BubbleTouched(true);
  }
  
  public void onReset()
  {
    show();
    this.animIndex = ((int)(Math.random() * 10.0D));
    setSize(48, 48);
    this.animIndex = BubbleUtils.setBitmapAnim(this, this.state, this.animIndex);
    setAlpha(220);
  }
  
  public void sendBubblesMini()
  {
    if (this.state == Enums.enumBubbleState.big)
    {
      BubbleMini localBubbleMini = (BubbleMini)StageGame.bubblesMini.allocate();
      localBubbleMini.x = this.x;
      localBubbleMini.y = (this.y + localBubbleMini.speed);
      localBubbleMini.direction = Enums.enumDirection.top;
      localBubbleMini.state = this.state;
      localBubbleMini = (BubbleMini)StageGame.bubblesMini.allocate();
      localBubbleMini.x = (this.x + localBubbleMini.speed);
      localBubbleMini.y = this.y;
      localBubbleMini.direction = Enums.enumDirection.left;
      localBubbleMini.state = this.state;
      localBubbleMini = (BubbleMini)StageGame.bubblesMini.allocate();
      localBubbleMini.x = this.x;
      localBubbleMini.y = (this.y - localBubbleMini.speed);
      localBubbleMini.direction = Enums.enumDirection.bottom;
      localBubbleMini.state = this.state;
      localBubbleMini = (BubbleMini)StageGame.bubblesMini.allocate();
      localBubbleMini.x = (this.x - localBubbleMini.speed);
      localBubbleMini.y = this.y;
      localBubbleMini.direction = Enums.enumDirection.right;
      localBubbleMini.state = this.state;
    }
  }
  
  public void setBubbleZoom() {}
  
  public void setPosition(int paramInt1, int paramInt2)
  {
    this.positionX = paramInt1;
    this.positionY = paramInt2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/engine/items/Bubble.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */