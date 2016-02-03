package com.magmamobile.game.engine;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;

public final class GameSurfaceCallback
  implements SurfaceHolder.Callback
{
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    Game.onSurfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    Game.onSurfaceCreated(paramSurfaceHolder);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    Game.onSurfaceDestroyed(paramSurfaceHolder);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/GameSurfaceCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */