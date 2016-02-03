package org.jsoup.helper;

import java.util.Iterator;
import java.util.ListIterator;

class DescendableLinkedList$DescendingIterator
  implements Iterator
{
  private final ListIterator iter;
  
  private DescendableLinkedList$DescendingIterator(DescendableLinkedList paramDescendableLinkedList, int paramInt)
  {
    this.iter = paramDescendableLinkedList.listIterator(paramInt);
  }
  
  public boolean hasNext()
  {
    return this.iter.hasPrevious();
  }
  
  public Object next()
  {
    return this.iter.previous();
  }
  
  public void remove()
  {
    this.iter.remove();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/helper/DescendableLinkedList$DescendingIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */