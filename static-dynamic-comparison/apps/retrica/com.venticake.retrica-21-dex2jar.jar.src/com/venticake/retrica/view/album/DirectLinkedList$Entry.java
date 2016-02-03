package com.venticake.retrica.view.album;

public final class DirectLinkedList$Entry<E>
{
  public boolean inserted = false;
  public Entry<E> next = null;
  public Entry<E> previous = null;
  public final E value;
  
  DirectLinkedList$Entry(E paramE)
  {
    this.value = paramE;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/DirectLinkedList$Entry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */