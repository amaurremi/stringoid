package com.magmamobile.game.engine;

import java.util.ArrayList;

public final class StageManager
{
  private static boolean _clear;
  public static IGameStage _currentStage;
  private static int _index;
  private static boolean _loaded;
  private static boolean _once;
  private static ArrayList<GameStage> _stages;
  
  public static GameStage addStage(GameStage paramGameStage)
  {
    if (_once) {
      return paramGameStage;
    }
    reloadIfNull();
    paramGameStage.setId(_stages.size());
    _stages.add(paramGameStage);
    return paramGameStage;
  }
  
  public static void addStage(Class<? extends GameStage> paramClass)
  {
    if (_once) {
      return;
    }
    reloadIfNull();
    paramClass = createStage(paramClass);
    paramClass.setId(_stages.size());
    _stages.add(paramClass);
  }
  
  private static void clear()
  {
    if (_clear) {
      clearNow();
    }
  }
  
  public static void clearNow()
  {
    _once = false;
    _clear = false;
    _loaded = false;
    _currentStage = null;
    _stages = null;
    _index = 0;
  }
  
  public static void clearStage()
  {
    if (_stages != null)
    {
      clearNow();
      initializeStages();
    }
  }
  
  private static GameStage createStage(Class<? extends GameStage> paramClass)
  {
    try
    {
      paramClass = (GameStage)paramClass.newInstance();
      return paramClass;
    }
    catch (Exception paramClass)
    {
      throw new RuntimeException(paramClass);
    }
  }
  
  public static void free()
  {
    _clear = true;
  }
  
  public static IGameStage getCurrentStage()
  {
    return _currentStage;
  }
  
  public static int getStage()
  {
    return _index;
  }
  
  public static GameStage getStage(int paramInt)
  {
    return (GameStage)_stages.get(paramInt);
  }
  
  public static int getStageCount()
  {
    if (_stages == null) {
      return 0;
    }
    return _stages.size();
  }
  
  public static void initializeStages()
  {
    
    int j;
    int i;
    if (!_once)
    {
      _once = true;
      j = _stages.size();
      if (j > 0) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i >= j)
      {
        _loaded = true;
        _currentStage = null;
        i = _index;
        _index = -1;
        setStage(i);
        return;
      }
      ((GameStage)_stages.get(i)).onInitialize();
      i += 1;
    }
  }
  
  public static boolean isQuit()
  {
    return _index == -1;
  }
  
  public static void onTerminate()
  {
    if (_currentStage != null) {
      _currentStage.onLeave();
    }
    terminateStages();
  }
  
  private static void reloadIfNull()
  {
    if (_stages == null)
    {
      _loaded = false;
      _currentStage = null;
      _index = 0;
      _stages = new ArrayList();
    }
  }
  
  public static final void reset()
  {
    if (_stages == null) {
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i >= _stages.size())
      {
        if (_currentStage == null) {
          break;
        }
        _currentStage.onEnter();
        return;
      }
      ((GameStage)_stages.get(i)).onInitialize();
      i += 1;
    }
  }
  
  public static void setFirstStage(int paramInt)
  {
    if (!_once)
    {
      setStage(paramInt);
      return;
    }
    Game.invalidate();
  }
  
  public static void setStage(int paramInt)
  {
    if (!_loaded) {
      _index = paramInt;
    }
    while (_index == paramInt) {
      return;
    }
    if (_currentStage != null)
    {
      _currentStage.onLeave();
      _currentStage.setActive(false);
    }
    _index = paramInt;
    if (_index != -1)
    {
      if (_index <= 0) {
        if ((_stages != null) && (_stages.size() > 0)) {
          _index = 1;
        }
      }
      for (_currentStage = (IGameStage)_stages.get(_index - 1);; _currentStage = (IGameStage)_stages.get(_index - 1))
      {
        _currentStage.onEnter();
        _currentStage.setActive(true);
        return;
        throw new RuntimeException("Invalid Stage Index");
      }
    }
    _clear = true;
    _currentStage = null;
    Game.running = false;
  }
  
  public static void terminateStages()
  {
    int j;
    int i;
    if (_stages != null)
    {
      j = _stages.size();
      if (j <= 0) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i >= j)
      {
        clear();
        return;
      }
      ((GameStage)_stages.get(i)).onTerminate();
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/StageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */