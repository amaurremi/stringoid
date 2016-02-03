package com.venticake.retrica.view.album;

public final class DirectLinkedList<E>
{
  private DirectLinkedList.Entry<E> mHead;
  private int mSize = 0;
  private DirectLinkedList.Entry<E> mTail;
  
  public void add(DirectLinkedList.Entry<E> paramEntry)
  {
    DirectLinkedList.Entry localEntry = this.mTail;
    if (localEntry != null)
    {
      localEntry.next = paramEntry;
      paramEntry.previous = localEntry;
    }
    for (;;)
    {
      this.mTail = paramEntry;
      paramEntry.inserted = true;
      this.mSize += 1;
      return;
      this.mHead = paramEntry;
    }
  }
  
  public void clear()
  {
    this.mHead = null;
    this.mTail = null;
    this.mSize = 0;
  }
  
  public DirectLinkedList.Entry<E> getHead()
  {
    return this.mHead;
  }
  
  public DirectLinkedList.Entry<E> getTail()
  {
    return this.mTail;
  }
  
  public boolean isEmpty()
  {
    return this.mSize == 0;
  }
  
  public DirectLinkedList.Entry<E> remove(DirectLinkedList.Entry<E> paramEntry)
  {
    DirectLinkedList.Entry localEntry1 = paramEntry.previous;
    DirectLinkedList.Entry localEntry2 = paramEntry.next;
    if (localEntry2 != null)
    {
      localEntry2.previous = localEntry1;
      paramEntry.next = null;
      if (localEntry1 == null) {
        break label75;
      }
      localEntry1.next = localEntry2;
      paramEntry.previous = null;
    }
    for (;;)
    {
      paramEntry.inserted = false;
      this.mSize -= 1;
      if (this.mSize < 0) {
        this.mSize = 0;
      }
      return localEntry2;
      this.mTail = localEntry1;
      break;
      label75:
      this.mHead = localEntry2;
    }
  }
  
  public int size()
  {
    return this.mSize;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/DirectLinkedList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */