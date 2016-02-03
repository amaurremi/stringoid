package com.mobisystems.list;

import java.io.Serializable;

public class IntArrayList
  implements Serializable
{
  private static final long serialVersionUID = -5436321439824279811L;
  protected int _count;
  protected int[] _data;
  
  static
  {
    if (!IntArrayList.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public IntArrayList()
  {
    this(10);
  }
  
  public IntArrayList(int paramInt)
  {
    this._data = new int[paramInt];
  }
  
  public void ensureCapacity(int paramInt)
  {
    int i;
    if (paramInt > this._data.length)
    {
      i = this._data.length * 3 / 2 + 1;
      if (i >= paramInt) {
        break label50;
      }
    }
    for (;;)
    {
      int[] arrayOfInt = new int[paramInt];
      System.arraycopy(this._data, 0, arrayOfInt, 0, this._count);
      this._data = arrayOfInt;
      return;
      label50:
      paramInt = i;
    }
  }
  
  public void fN(int paramInt)
  {
    int i = this._count + 1;
    ensureCapacity(i);
    this._data[this._count] = paramInt;
    this._count = i;
  }
  
  public int get(int paramInt)
  {
    assert ((paramInt >= 0) && (paramInt < this._count));
    return this._data[paramInt];
  }
  
  public int size()
  {
    return this._count;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/list/IntArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */