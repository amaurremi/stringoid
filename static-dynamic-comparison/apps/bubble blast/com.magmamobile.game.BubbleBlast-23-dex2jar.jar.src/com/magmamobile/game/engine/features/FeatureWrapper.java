package com.magmamobile.game.engine.features;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.SurfaceView;
import android.view.View;
import com.magmamobile.game.engine.GameView00;

public abstract class FeatureWrapper
{
  public SurfaceView createGameView(Context paramContext)
  {
    return new GameView00(paramContext);
  }
  
  public Point getRealSize(Display paramDisplay)
  {
    return null;
  }
  
  public boolean isGoogleTV()
  {
    return false;
  }
  
  public boolean isOrientationInverted()
  {
    return false;
  }
  
  public void setLayerTypeSofware(View paramView) {}
  
  public void setOnSystemUiVisibilityChangeListener(View paramView) {}
  
  public void setSystemUiVisibility(View paramView, int paramInt) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/features/FeatureWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */