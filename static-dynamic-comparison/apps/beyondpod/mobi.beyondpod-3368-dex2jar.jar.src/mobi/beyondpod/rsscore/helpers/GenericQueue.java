package mobi.beyondpod.rsscore.helpers;

import java.util.LinkedList;

public class GenericQueue<E>
{
  private LinkedList<E> list = new LinkedList();
  
  public void addItems(GenericQueue<? extends E> paramGenericQueue)
  {
    for (;;)
    {
      if (!paramGenericQueue.hasItems()) {
        return;
      }
      this.list.addLast(paramGenericQueue.dequeue());
    }
  }
  
  public void clear()
  {
    this.list.clear();
  }
  
  public boolean contains(E paramE)
  {
    return this.list.contains(paramE);
  }
  
  public E dequeue()
  {
    return (E)this.list.poll();
  }
  
  public void enqueue(E paramE)
  {
    this.list.addLast(paramE);
  }
  
  public E get(int paramInt)
  {
    return (E)this.list.get(paramInt);
  }
  
  public boolean hasItems()
  {
    return !this.list.isEmpty();
  }
  
  public E peek()
  {
    return (E)this.list.getFirst();
  }
  
  public void remove(E paramE)
  {
    this.list.remove(paramE);
  }
  
  public int size()
  {
    return this.list.size();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/helpers/GenericQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */