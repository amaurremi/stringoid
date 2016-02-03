package com.venticake.retrica.view.album;

public final class IndexRange
{
  public int begin;
  public int end;
  
  public IndexRange()
  {
    this.begin = 0;
    this.end = 0;
  }
  
  public IndexRange(int paramInt1, int paramInt2)
  {
    this.begin = paramInt1;
    this.end = paramInt2;
  }
  
  public boolean isEmpty()
  {
    return this.begin == this.end;
  }
  
  public void set(int paramInt1, int paramInt2)
  {
    this.begin = paramInt1;
    this.end = paramInt2;
  }
  
  public int size()
  {
    return this.end - this.begin;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/IndexRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */