package com.magmamobile.game.engine.features;

import android.content.Context;
import android.content.pm.PackageManager;
import android.view.SurfaceView;
import android.view.View;
import com.magmamobile.game.engine.Game;
import com.magmamobile.game.engine.GameApplication;
import com.magmamobile.game.engine.GameView11;

public final class FeatureWrapper11
  extends FeatureWrapper
{
  public SurfaceView createGameView(Context paramContext)
  {
    return new GameView11(paramContext);
  }
  
  public boolean isGoogleTV()
  {
    return Game.getApplication().getPackageManager().hasSystemFeature("com.google.android.tv");
  }
  
  public boolean isOrientationInverted()
  {
    return true;
  }
  
  public void setLayerTypeSofware(View paramView)
  {
    if (paramView != null) {
      paramView.setLayerType(1, null);
    }
  }
  
  public void setSystemUiVisibility(View paramView, int paramInt)
  {
    if (paramView != null) {
      paramView.setSystemUiVisibility(paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/features/FeatureWrapper11.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */