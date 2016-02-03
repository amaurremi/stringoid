package com.venticake.retrica.view.album;

public final class Pool<E>
{
  private final E[] mFreeList;
  private int mFreeListIndex;
  
  public Pool(E[] paramArrayOfE)
  {
    this.mFreeList = paramArrayOfE;
    this.mFreeListIndex = paramArrayOfE.length;
  }
  
  public E create()
  {
    int i = this.mFreeListIndex - 1;
    this.mFreeListIndex = i;
    if ((i >= 0) && (i < this.mFreeList.length))
    {
      Object localObject = this.mFreeList[i];
      this.mFreeList[i] = null;
      return (E)localObject;
    }
    return null;
  }
  
  public void delete(E paramE)
  {
    int i = this.mFreeListIndex;
    if ((i >= 0) && (i < this.mFreeList.length))
    {
      this.mFreeList[i] = paramE;
      this.mFreeListIndex += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/Pool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */