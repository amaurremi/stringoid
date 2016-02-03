package com.magmamobile.game.engine;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceView;

public final class GameView00
  extends SurfaceView
{
  public GameView00(Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (Game.hideActionBar) {
      Game.setFullScreen();
    }
    if (Game._touchmode == 2)
    {
      IGameStage localIGameStage = StageManager._currentStage;
      if ((localIGameStage != null) && (localIGameStage.isActive())) {
        return localIGameStage.onTouchEvent(paramMotionEvent);
      }
      return true;
    }
    return TouchScreen.ev(paramMotionEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/GameView00.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */