package com.jaysquared.games.whereishd;

import com.jaysquared.games.whereishd.utils.PersistantSettings;
import com.jaysquared.games.whereishd.utils.SLog;

public class ApplicationManager
{
  private static final String APPLICATION_NOT_BEEN_INITIALIZED_MESSAGE = "Application has not been initialized";
  private static final String LOG_TAG = ApplicationManager.class.getSimpleName();
  private GameManager gameManager = null;
  private boolean isInitialized = false;
  private PersistantSettings settings = null;
  
  public static ApplicationManager getInstance()
  {
    return SingletonHolder.INSTANCE;
  }
  
  public GameManager getGameManager()
  {
    if (!isInitialized()) {
      SLog.e(LOG_TAG, "Application has not been initialized");
    }
    return this.gameManager;
  }
  
  public PersistantSettings getSettings()
  {
    if (!isInitialized()) {
      SLog.e(LOG_TAG, "Application has not been initialized");
    }
    return this.settings;
  }
  
  public void initialize(GameManager paramGameManager, PersistantSettings paramPersistantSettings)
  {
    this.gameManager = paramGameManager;
    this.settings = paramPersistantSettings;
    this.isInitialized = true;
  }
  
  public boolean isInitialized()
  {
    return this.isInitialized;
  }
  
  private static class SingletonHolder
  {
    private static final ApplicationManager INSTANCE = new ApplicationManager(null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/ApplicationManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */