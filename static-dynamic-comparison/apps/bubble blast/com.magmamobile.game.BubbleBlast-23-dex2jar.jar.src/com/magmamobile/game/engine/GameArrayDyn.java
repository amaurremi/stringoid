package com.magmamobile.game.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public abstract class GameArrayDyn<T extends GameObject>
  implements IGameEvents
{
  private ArrayList<T> ar = new ArrayList();
  private GameArrayDyn<T>.ZComparator zcomparator = new ZComparator(null);
  
  public final T allocate()
  {
    GameObject localGameObject = createObject();
    this.ar.add(localGameObject);
    localGameObject.onReset();
    return localGameObject;
  }
  
  public final boolean canAllocate()
  {
    return true;
  }
  
  public final void clear()
  {
    this.ar.clear();
  }
  
  public abstract T createObject();
  
  public final T get(int paramInt)
  {
    return (GameObject)this.ar.get(paramInt);
  }
  
  public final int getSize()
  {
    return this.ar.size();
  }
  
  public final void onAction()
  {
    int i = 0;
    int j = this.ar.size();
    if (i >= j) {
      i = this.ar.size() - 1;
    }
    for (;;)
    {
      if (i < 0)
      {
        return;
        GameObject localGameObject = (GameObject)this.ar.get(i);
        if (localGameObject.enabled) {
          localGameObject.onAction();
        }
        i += 1;
        break;
      }
      if (!((GameObject)this.ar.get(i)).enabled) {
        this.ar.remove(i);
      }
      i -= 1;
    }
  }
  
  public final void onPause()
  {
    int i = 0;
    int j = this.ar.size();
    for (;;)
    {
      if (i >= j) {
        return;
      }
      GameObject localGameObject = (GameObject)this.ar.get(i);
      if (localGameObject.enabled) {
        localGameObject.onPause();
      }
      i += 1;
    }
  }
  
  public final void onRender()
  {
    int i = 0;
    int j = this.ar.size();
    for (;;)
    {
      if (i >= j) {
        return;
      }
      GameObject localGameObject = (GameObject)this.ar.get(i);
      if ((localGameObject.visible) && (localGameObject.enabled)) {
        localGameObject.onRender();
      }
      i += 1;
    }
  }
  
  public final void onResume()
  {
    int i = 0;
    int j = this.ar.size();
    for (;;)
    {
      if (i >= j) {
        return;
      }
      GameObject localGameObject = (GameObject)this.ar.get(i);
      if (localGameObject.enabled) {
        localGameObject.onResume();
      }
      i += 1;
    }
  }
  
  public final void sortByZ()
  {
    Collections.sort(this.ar, this.zcomparator);
  }
  
  private class ZComparator
    implements Comparator<GameObject>
  {
    private ZComparator() {}
    
    public int compare(GameObject paramGameObject1, GameObject paramGameObject2)
    {
      if (paramGameObject1.z > paramGameObject2.z) {
        return 1;
      }
      return -1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/GameArrayDyn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */