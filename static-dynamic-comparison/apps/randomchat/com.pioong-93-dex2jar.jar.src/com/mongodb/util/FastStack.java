package com.mongodb.util;

import java.util.ArrayList;
import java.util.List;

public class FastStack<T>
{
  private final List<T> _data = new ArrayList();
  
  public void clear()
  {
    this._data.clear();
  }
  
  public T get(int paramInt)
  {
    return (T)this._data.get(paramInt);
  }
  
  public T peek()
  {
    return (T)this._data.get(this._data.size() - 1);
  }
  
  public T pop()
  {
    return (T)this._data.remove(this._data.size() - 1);
  }
  
  public void push(T paramT)
  {
    this._data.add(paramT);
  }
  
  public int size()
  {
    return this._data.size();
  }
  
  public String toString()
  {
    return this._data.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/util/FastStack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */