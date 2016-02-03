package com.mongodb.util;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WeakBag<T>
  implements Iterable<T>
{
  private final List<WeakBag<T>.MyRef> _refs = new LinkedList();
  
  public void add(T paramT)
  {
    this._refs.add(new MyRef(paramT));
  }
  
  public void clean()
  {
    Iterator localIterator = this._refs.iterator();
    while (localIterator.hasNext()) {
      if (((MyRef)localIterator.next()).get() == null) {
        localIterator.remove();
      }
    }
  }
  
  public void clear()
  {
    this._refs.clear();
  }
  
  public boolean contains(T paramT)
  {
    Iterator localIterator = this._refs.iterator();
    while (localIterator.hasNext()) {
      if (((MyRef)localIterator.next()).get() == paramT) {
        return true;
      }
    }
    return false;
  }
  
  public List<T> getAll()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this._refs.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = ((MyRef)localIterator.next()).get();
      if (localObject == null) {
        localIterator.remove();
      } else {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  public Iterator<T> iterator()
  {
    return getAll().iterator();
  }
  
  public boolean remove(T paramT)
  {
    Iterator localIterator = this._refs.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (MyRef)localIterator.next();
      if (localObject != null)
      {
        localObject = ((MyRef)localObject).get();
        if (localObject == null)
        {
          localIterator.remove();
        }
        else if (localObject == paramT)
        {
          localIterator.remove();
          return true;
        }
      }
    }
    return false;
  }
  
  public int size()
  {
    clean();
    return this._refs.size();
  }
  
  class MyRef
    extends WeakReference<T>
  {
    MyRef()
    {
      super();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/util/WeakBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */