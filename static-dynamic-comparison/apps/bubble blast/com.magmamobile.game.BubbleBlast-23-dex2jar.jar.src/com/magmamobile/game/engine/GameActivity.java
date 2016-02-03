package com.magmamobile.game.engine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;

public abstract class GameActivity
  extends Activity
{
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Game.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Game.onActivityCreate(this);
  }
  
  protected void onCreateViews(ViewGroup paramViewGroup) {}
  
  protected void onDestroy()
  {
    super.onDestroy();
    Game.onActivityDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (Game.onActivityKeyDown(paramInt, paramKeyEvent)) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (Game.onActivityKeyUp(paramInt, paramKeyEvent)) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    Game.onActivityPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    Game.onActivityResume();
  }
  
  protected void onStart()
  {
    super.onStart();
    Game.onActivityStart();
  }
  
  protected void onStop()
  {
    super.onStop();
    Game.onActivityStop();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/GameActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */