package com.magmamobile.game.engine;

public abstract class GameArray<T extends GameObject>
  implements IGameEvents
{
  public T[] array;
  private int size;
  public int total = 0;
  
  public GameArray(int paramInt)
  {
    this.size = paramInt;
    this.array = createArray(paramInt);
    int i = 0;
    for (;;)
    {
      if (i >= paramInt) {
        return;
      }
      this.array[i] = createObject();
      i += 1;
    }
  }
  
  public final T allocate()
  {
    if (this.total < this.size)
    {
      GameObject localGameObject = this.array[this.total];
      localGameObject.index = this.total;
      localGameObject.selected = false;
      localGameObject.visible = true;
      localGameObject.enabled = true;
      localGameObject.onReset();
      this.total += 1;
      return localGameObject;
    }
    return null;
  }
  
  public final boolean canAllocate()
  {
    return this.total < this.size;
  }
  
  public final void clear()
  {
    int i = 0;
    for (;;)
    {
      if (i >= this.total)
      {
        this.total = 0;
        return;
      }
      this.array[i].enabled = false;
      i += 1;
    }
  }
  
  public abstract T[] createArray(int paramInt);
  
  public abstract T createObject();
  
  public final int getSize()
  {
    return this.size;
  }
  
  public final boolean isFull()
  {
    return this.total == this.size;
  }
  
  public final void onAction()
  {
    int i = 0;
    if (i >= this.total) {
      i = this.total - 1;
    }
    for (;;)
    {
      if (i < 0)
      {
        return;
        localGameObject = this.array[i];
        if (localGameObject.enabled) {
          localGameObject.onAction();
        }
        i += 1;
        break;
      }
      GameObject localGameObject = this.array[i];
      if (!localGameObject.enabled)
      {
        this.total -= 1;
        this.array[i] = this.array[this.total];
        this.array[this.total] = localGameObject;
      }
      i -= 1;
    }
  }
  
  public final void onPause()
  {
    int i = 0;
    for (;;)
    {
      if (i >= this.total) {
        return;
      }
      GameObject localGameObject = this.array[i];
      if (localGameObject.enabled) {
        localGameObject.onPause();
      }
      i += 1;
    }
  }
  
  public final void onRender()
  {
    int i = 0;
    for (;;)
    {
      if (i >= this.total) {
        return;
      }
      GameObject localGameObject = this.array[i];
      if ((localGameObject.visible) && (localGameObject.enabled)) {
        localGameObject.onRender();
      }
      i += 1;
    }
  }
  
  public final void onResume()
  {
    int i = 0;
    for (;;)
    {
      if (i >= this.total) {
        return;
      }
      GameObject localGameObject = this.array[i];
      if (localGameObject.enabled) {
        localGameObject.onResume();
      }
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/GameArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */