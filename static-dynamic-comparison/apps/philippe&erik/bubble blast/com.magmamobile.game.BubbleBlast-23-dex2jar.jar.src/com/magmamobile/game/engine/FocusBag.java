package com.magmamobile.game.engine;

import java.util.ArrayList;

public class FocusBag
{
  private int _index;
  private ArrayList<GameObject> _table;
  
  public FocusBag()
  {
    clear();
  }
  
  public void addObject(GameObject paramGameObject)
  {
    this._table.add(paramGameObject);
  }
  
  public void clear()
  {
    this._table = new ArrayList();
    this._index = -1;
  }
  
  public GameObject getFocus()
  {
    if ((this._table != null) && (this._index >= 0) && (this._index < this._table.size())) {
      return (GameObject)this._table.get(this._index);
    }
    return null;
  }
  
  public void goFirst()
  {
    this._index = 0;
    if ((this._index >= 0) && (this._index < this._table.size())) {
      ((GameObject)this._table.get(this._index)).selected = true;
    }
  }
  
  public void goNext()
  {
    if ((this._index >= 0) && (this._index < this._table.size())) {
      ((GameObject)this._table.get(this._index)).selected = false;
    }
    this._index += 1;
    if (this._index >= this._table.size()) {
      this._index = 0;
    }
    if ((this._index >= 0) && (this._index < this._table.size())) {
      ((GameObject)this._table.get(this._index)).selected = true;
    }
  }
  
  public void goPrevious()
  {
    if ((this._index >= 0) && (this._index < this._table.size())) {
      ((GameObject)this._table.get(this._index)).selected = false;
    }
    this._index -= 1;
    if (this._index < 0) {
      this._index = (this._table.size() - 1);
    }
    if ((this._index >= 0) && (this._index < this._table.size())) {
      ((GameObject)this._table.get(this._index)).selected = true;
    }
  }
  
  public void removeObject(GameObject paramGameObject)
  {
    this._table.remove(paramGameObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/FocusBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */