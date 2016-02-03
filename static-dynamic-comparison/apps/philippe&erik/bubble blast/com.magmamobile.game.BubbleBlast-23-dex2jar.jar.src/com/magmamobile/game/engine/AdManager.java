package com.magmamobile.game.engine;

import java.util.ArrayList;

public final class AdManager
{
  protected static ArrayList<AdLayout> ads;
  protected static GameLayout container;
  
  public static AdLayout add(AdLayout paramAdLayout)
  {
    if (paramAdLayout == null) {
      return null;
    }
    if (ads == null) {
      return null;
    }
    ads.add(paramAdLayout);
    Game.postRunnable(new Runnable()
    {
      public void run()
      {
        AdManager.appendAdView(AdManager.this);
      }
    });
    return paramAdLayout;
  }
  
  private static void appendAdView(AdLayout paramAdLayout)
  {
    GameLayout.LayoutParams localLayoutParams;
    int[] arrayOfInt;
    if ((container != null) && (!paramAdLayout.hooked))
    {
      localLayoutParams = createLayoutParamsWW(paramAdLayout);
      paramAdLayout.hooked = true;
      paramAdLayout.lParams = localLayoutParams;
      arrayOfInt = paramAdLayout.getRules();
      i = 0;
      if (i < arrayOfInt.length) {
        break label64;
      }
      if (!paramAdLayout.visible) {
        break label82;
      }
    }
    label64:
    label82:
    for (int i = 0;; i = 8)
    {
      paramAdLayout.setVisibility(i);
      container.addView(paramAdLayout, localLayoutParams);
      return;
      if (arrayOfInt[i] != 0) {
        localLayoutParams.addRule(i);
      }
      i += 1;
      break;
    }
  }
  
  private static final GameLayout.LayoutParams createLayoutParamsWW(AdLayout paramAdLayout)
  {
    GameLayout.LayoutParams localLayoutParams = new GameLayout.LayoutParams(0, 0);
    localLayoutParams.width = ((int)(paramAdLayout.theoricalWidth * Game.density));
    localLayoutParams.height = ((int)(paramAdLayout.theoricalHeight * Game.density));
    localLayoutParams.setLeft(paramAdLayout.getMarginLeft());
    localLayoutParams.setTop(paramAdLayout.getMarginTop());
    return localLayoutParams;
  }
  
  public static AdLayout get(int paramInt)
  {
    if (ads == null) {
      return null;
    }
    return (AdLayout)ads.get(paramInt);
  }
  
  protected static void onCreate(GameLayout paramGameLayout)
  {
    container = paramGameLayout;
    if (ads == null) {
      return;
    }
    int j = ads.size();
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        Game.postRunnable(new Runnable()
        {
          public void run()
          {
            int j = AdManager.ads.size();
            int i = 0;
            for (;;)
            {
              if (i >= j) {
                return;
              }
              AdManager.appendAdView((AdLayout)AdManager.ads.get(i));
              i += 1;
            }
          }
        });
        return;
      }
      ((AdLayout)ads.get(i)).onCreate();
      i += 1;
    }
  }
  
  protected static void onDestroy()
  {
    if (container != null) {
      container = null;
    }
    if (ads == null) {
      return;
    }
    int j = ads.size();
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        ads.clear();
        return;
      }
      ((AdLayout)ads.get(i)).onDestroy();
      i += 1;
    }
  }
  
  protected static void onInitialize()
  {
    if (ads == null)
    {
      ads = new ArrayList();
      return;
    }
    ads.clear();
  }
  
  protected static void onPause()
  {
    if (ads == null) {}
    for (;;)
    {
      return;
      int j = ads.size();
      int i = 0;
      while (i < j)
      {
        ((AdLayout)ads.get(i)).onPause();
        i += 1;
      }
    }
  }
  
  protected static void onResume()
  {
    if (ads == null) {}
    for (;;)
    {
      return;
      int j = ads.size();
      int i = 0;
      while (i < j)
      {
        ((AdLayout)ads.get(i)).onResume();
        i += 1;
      }
    }
  }
  
  protected static void onStart()
  {
    if (ads == null) {}
    for (;;)
    {
      return;
      int j = ads.size();
      int i = 0;
      while (i < j)
      {
        ((AdLayout)ads.get(i)).onStart();
        i += 1;
      }
    }
  }
  
  protected static void onStop()
  {
    if (ads == null) {}
    for (;;)
    {
      return;
      int j = ads.size();
      int i = 0;
      while (i < j)
      {
        ((AdLayout)ads.get(i)).onStop();
        i += 1;
      }
    }
  }
  
  protected static void onTerminate()
  {
    if (ads != null)
    {
      ads.clear();
      ads = null;
    }
  }
  
  public static void remove(AdLayout paramAdLayout)
  {
    if (paramAdLayout == null) {}
    while (ads == null) {
      return;
    }
    if (ads.contains(paramAdLayout)) {
      ads.remove(paramAdLayout);
    }
    Game.postRunnable(new Runnable()
    {
      public void run()
      {
        AdManager.removeAdView(AdManager.this);
      }
    });
  }
  
  private static void removeAdView(AdLayout paramAdLayout)
  {
    if (container != null)
    {
      container.removeView(paramAdLayout);
      paramAdLayout.hooked = false;
    }
  }
  
  public static int size()
  {
    if (ads == null) {
      return 0;
    }
    return ads.size();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/AdManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */