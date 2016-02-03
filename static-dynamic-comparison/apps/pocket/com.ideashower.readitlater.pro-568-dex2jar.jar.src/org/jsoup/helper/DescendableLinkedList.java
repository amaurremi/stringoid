package org.jsoup.helper;

import java.util.Iterator;
import java.util.LinkedList;

public class DescendableLinkedList
  extends LinkedList
{
  public Iterator descendingIterator()
  {
    return new DescendableLinkedList.DescendingIterator(this, size(), null);
  }
  
  public Object peekLast()
  {
    if (size() == 0) {
      return null;
    }
    return getLast();
  }
  
  public Object pollLast()
  {
    if (size() == 0) {
      return null;
    }
    return removeLast();
  }
  
  public void push(Object paramObject)
  {
    addFirst(paramObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/helper/DescendableLinkedList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */