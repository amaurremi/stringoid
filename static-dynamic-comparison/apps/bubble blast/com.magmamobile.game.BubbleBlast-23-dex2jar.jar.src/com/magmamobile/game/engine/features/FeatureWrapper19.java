package com.magmamobile.game.engine.features;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.view.Display;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import com.magmamobile.game.engine.Game;
import com.magmamobile.game.engine.GameApplication;
import com.magmamobile.game.engine.GameView11;

public final class FeatureWrapper19
  extends FeatureWrapper
{
  public SurfaceView createGameView(Context paramContext)
  {
    return new GameView11(paramContext);
  }
  
  public Point getRealSize(Display paramDisplay)
  {
    Point localPoint = new Point();
    paramDisplay.getRealSize(localPoint);
    return localPoint;
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
  
  public void setOnSystemUiVisibilityChangeListener(final View paramView)
  {
    paramView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
    {
      public void onSystemUiVisibilityChange(int paramAnonymousInt)
      {
        Game.OnSystemUiVisibility(paramView, paramAnonymousInt);
      }
    });
  }
  
  public void setSystemUiVisibility(View paramView, int paramInt)
  {
    if (paramView != null) {
      paramView.setSystemUiVisibility(paramInt);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/features/FeatureWrapper19.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */