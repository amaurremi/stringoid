package com.venticake.retrica.view.album;

public final class Deque<E>
{
  private static final int DEFAULT_INITIAL_CAPACITY = 16;
  private E[] mArray;
  private int mHead = 0;
  private int mTail = 0;
  
  public Deque()
  {
    this.mArray = new Object[16];
  }
  
  public Deque(int paramInt)
  {
    this.mArray = new Object[paramInt];
  }
  
  private void expand()
  {
    Object[] arrayOfObject1 = this.mArray;
    int i = this.mHead;
    int j = arrayOfObject1.length;
    int k = j - i;
    Object[] arrayOfObject2 = new Object[j << 1];
    System.arraycopy(arrayOfObject1, i, arrayOfObject2, 0, k);
    System.arraycopy(arrayOfObject1, 0, arrayOfObject2, k, i);
    this.mArray = arrayOfObject2;
    this.mHead = 0;
    this.mTail = j;
  }
  
  public void addFirst(E paramE)
  {
    Object[] arrayOfObject = this.mArray;
    int i = this.mHead - 1 & arrayOfObject.length - 1;
    this.mHead = i;
    arrayOfObject[i] = paramE;
    if (i == this.mTail) {
      expand();
    }
  }
  
  public void addLast(E paramE)
  {
    Object[] arrayOfObject = this.mArray;
    int i = this.mTail;
    arrayOfObject[i] = paramE;
    i = arrayOfObject.length - 1 & i + 1;
    this.mTail = i;
    if (this.mHead == i) {
      expand();
    }
  }
  
  public void clear()
  {
    Object[] arrayOfObject = this.mArray;
    int i = this.mHead;
    int k = this.mTail;
    if (i != k)
    {
      int m = arrayOfObject.length;
      int j;
      do
      {
        arrayOfObject[i] = null;
        j = i + 1 & m - 1;
        i = j;
      } while (j != k);
      this.mHead = 0;
      this.mTail = 0;
    }
  }
  
  public E get(int paramInt)
  {
    Object[] arrayOfObject = this.mArray;
    if (paramInt >= size()) {
      throw new IndexOutOfBoundsException();
    }
    return (E)arrayOfObject[(this.mHead + paramInt & arrayOfObject.length - 1)];
  }
  
  public boolean isEmpty()
  {
    return this.mHead == this.mTail;
  }
  
  public E pollFirst()
  {
    Object[] arrayOfObject = this.mArray;
    int i = this.mHead;
    Object localObject = arrayOfObject[i];
    if (localObject == null) {
      return null;
    }
    arrayOfObject[i] = null;
    this.mHead = (i + 1 & arrayOfObject.length - 1);
    return (E)localObject;
  }
  
  public E pollLast()
  {
    Object[] arrayOfObject = this.mArray;
    int i = this.mTail;
    i = arrayOfObject.length - 1 & i - 1;
    Object localObject = arrayOfObject[i];
    if (localObject == null) {
      return null;
    }
    arrayOfObject[i] = null;
    this.mTail = i;
    return (E)localObject;
  }
  
  public int size()
  {
    return this.mTail - this.mHead & this.mArray.length - 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/Deque.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */