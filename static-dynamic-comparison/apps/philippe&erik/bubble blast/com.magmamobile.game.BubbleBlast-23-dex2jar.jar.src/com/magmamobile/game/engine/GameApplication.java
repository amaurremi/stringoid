package com.magmamobile.game.engine;

import android.app.Application;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.View;

public abstract class GameApplication
  extends Application
{
  public GameStage addStage(GameStage paramGameStage)
  {
    return StageManager.addStage(paramGameStage);
  }
  
  public void addStage(Class<? extends GameStage> paramClass)
  {
    StageManager.addStage(paramClass);
  }
  
  public void clearStages() {}
  
  public IGameStage getCurrentStage()
  {
    return StageManager.getCurrentStage();
  }
  
  public GameStage getStage(int paramInt)
  {
    return StageManager.getStage(paramInt);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    Game.onApplicationConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate()
  {
    super.onCreate();
    Game.onApplicationCreate(this);
  }
  
  public AdLayout onCreateAdBanner()
  {
    return null;
  }
  
  public AdLayout onCreateAdSquare()
  {
    return null;
  }
  
  public AppParameters onCreateParameters()
  {
    return new AppParameters();
  }
  
  public View onCreateView()
  {
    return null;
  }
  
  public void onEngineInitialize() {}
  
  public void onEngineLanguageChanged(String paramString1, String paramString2) {}
  
  public void onEngineTerminate() {}
  
  public void onFirstUse() {}
  
  public void onLowMemory()
  {
    super.onLowMemory();
    Game.onApplicationLowMemory();
  }
  
  public boolean onReceiveDebugMessage(Intent paramIntent)
  {
    return false;
  }
  
  public void onTerminate()
  {
    super.onTerminate();
    Game.onApplicationTerminate();
  }
  
  public void setFirstStage(int paramInt)
  {
    StageManager.setFirstStage(paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/GameApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */