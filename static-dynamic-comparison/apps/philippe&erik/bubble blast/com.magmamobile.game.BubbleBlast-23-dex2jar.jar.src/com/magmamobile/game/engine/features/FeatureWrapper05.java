package com.magmamobile.game.engine.features;

import android.content.pm.PackageManager;
import com.magmamobile.game.engine.Game;
import com.magmamobile.game.engine.GameApplication;

public final class FeatureWrapper05
  extends FeatureWrapper
{
  public boolean isGoogleTV()
  {
    return Game.getApplication().getPackageManager().hasSystemFeature("com.google.android.tv");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/features/FeatureWrapper05.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */