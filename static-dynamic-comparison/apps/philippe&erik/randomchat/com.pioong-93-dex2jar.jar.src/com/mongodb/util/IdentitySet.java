package com.mongodb.util;

import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Set;

public class IdentitySet<T>
  implements Iterable<T>
{
  final IdentityHashMap<T, String> _map = new IdentityHashMap();
  
  public IdentitySet() {}
  
  public IdentitySet(Iterable<T> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      add(paramIterable.next());
    }
  }
  
  public boolean add(T paramT)
  {
    return this._map.put(paramT, "a") == null;
  }
  
  public void addAll(IdentitySet<T> paramIdentitySet)
  {
    paramIdentitySet = paramIdentitySet.iterator();
    while (paramIdentitySet.hasNext()) {
      add(paramIdentitySet.next());
    }
  }
  
  public void addAll(Collection<T> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      add(paramCollection.next());
    }
  }
  
  public void clear()
  {
    this._map.clear();
  }
  
  public boolean contains(T paramT)
  {
    return this._map.containsKey(paramT);
  }
  
  public Iterator<T> iterator()
  {
    return this._map.keySet().iterator();
  }
  
  public void remove(T paramT)
  {
    this._map.remove(paramT);
  }
  
  public void removeAll(Iterable<T> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      remove(paramIterable.next());
    }
  }
  
  public void removeall(Iterable<T> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      this._map.remove(localObject);
    }
  }
  
  public int size()
  {
    return this._map.size();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/util/IdentitySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */