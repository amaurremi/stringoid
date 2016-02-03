package com.magmamobile.game.engine.ex;

import java.util.ArrayList;

public class BaseArray<T extends BaseObject>
  extends BaseObject
{
  protected ArrayList<T> array = new ArrayList();
  protected Class<T> type;
  
  public BaseArray(Class<T> paramClass)
  {
    this.visible = true;
    this.enabled = true;
    this.type = paramClass;
  }
  
  public T allocate()
  {
    try
    {
      BaseObject localBaseObject = (BaseObject)this.type.newInstance();
      this.array.add(localBaseObject);
      return localBaseObject;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }
  
  public void clear()
  {
    this.array.clear();
  }
  
  public T get(int paramInt)
  {
    return (BaseObject)this.array.get(paramInt);
  }
  
  public int getSize()
  {
    return this.array.size();
  }
  
  public Class<T> getType()
  {
    return this.type;
  }
  
  public void onAction()
  {
    if (!this.enabled) {
      return;
    }
    for (;;)
    {
      int i;
      synchronized (this.array)
      {
        int j = this.array.size();
        i = 0;
        if (i >= j) {
          synchronized (this.array)
          {
            i = this.array.size() - 1;
            if (i >= 0) {
              break label99;
            }
            return;
          }
        }
        BaseObject localBaseObject = (BaseObject)this.array.get(i);
        if (!localBaseObject.enabled) {
          break label132;
        }
        localBaseObject.onAction();
      }
      label99:
      if (!((BaseObject)this.array.get(i)).enabled) {
        this.array.remove(i);
      }
      i -= 1;
      continue;
      label132:
      i += 1;
    }
  }
  
  public void onRender()
  {
    if (!this.visible) {
      return;
    }
    for (;;)
    {
      int i;
      synchronized (this.array)
      {
        int j = this.array.size();
        i = 0;
        if (i >= j) {
          return;
        }
      }
      BaseObject localBaseObject = (BaseObject)this.array.get(i);
      if (localBaseObject.visible) {
        localBaseObject.onRender();
      }
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/ex/BaseArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */