package com.magmamobile.game.BubbleBlast.activities;

import android.view.Menu;
import android.view.MenuItem;
import com.magmamobile.game.BubbleBlast.modCommon;
import com.magmamobile.game.BubbleBlast.stages.StageGame;

public final class GameActivity
  extends com.magmamobile.game.engine.GameActivity
{
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    paramMenu.add(0, 0, 0, 2131034178).setIcon(17301580);
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 0) {
      finish();
    }
    return true;
  }
  
  protected void onPause()
  {
    modCommon.Log_d("GameActivity : onPause");
    StageGame.onGamePause();
    super.onPause();
  }
  
  protected void onResume()
  {
    modCommon.Log_d("GameActivity : onResume");
    StageGame.onGameResume();
    super.onResume();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/activities/GameActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */