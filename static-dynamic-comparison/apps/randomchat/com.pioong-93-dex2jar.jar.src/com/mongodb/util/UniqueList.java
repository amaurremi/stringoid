package com.mongodb.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class UniqueList<T>
  extends ArrayList<T>
{
  private static final long serialVersionUID = -4415279469780082174L;
  
  public boolean add(T paramT)
  {
    if (contains(paramT)) {
      return false;
    }
    return super.add(paramT);
  }
  
  public boolean addAll(Collection<? extends T> paramCollection)
  {
    boolean bool = false;
    paramCollection = paramCollection.iterator();
    if (paramCollection.hasNext())
    {
      Object localObject = paramCollection.next();
      if ((bool) || (add(localObject))) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    return bool;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/util/UniqueList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */