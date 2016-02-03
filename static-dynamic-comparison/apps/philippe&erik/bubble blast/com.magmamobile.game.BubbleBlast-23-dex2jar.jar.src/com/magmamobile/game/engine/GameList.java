package com.magmamobile.game.engine;

import java.util.ArrayList;
import java.util.Collections;

public class GameList<T extends GameObject>
  extends ArrayList<T>
  implements IGameEvents
{
  public void clean()
  {
    int i = size() - 1;
    for (;;)
    {
      if (i < 0) {
        return;
      }
      if (!((GameObject)get(i)).enabled) {
        remove(i);
      }
      i -= 1;
    }
  }
  
  public void onAction()
  {
    int i = 0;
    int j = size();
    for (;;)
    {
      if (i >= j) {
        return;
      }
      ((GameObject)get(i)).onAction();
      i += 1;
    }
  }
  
  public void onActionEx()
  {
    onAction();
    clean();
  }
  
  public void onRender()
  {
    int i = 0;
    int j = size();
    for (;;)
    {
      if (i >= j) {
        return;
      }
      ((GameObject)get(i)).onRender();
      i += 1;
    }
  }
  
  public void onSort()
  {
    Collections.sort(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/GameList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */