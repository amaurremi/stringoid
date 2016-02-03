package com.bfs.papertoss.vector;

public class v2i
{
  public int x;
  public int y;
  
  public v2i()
  {
    this.x = 0;
    this.y = 0;
  }
  
  public v2i(int paramInt1, int paramInt2)
  {
    this.x = paramInt1;
    this.y = paramInt2;
  }
  
  public boolean equals(v2i paramv2i)
  {
    return (this.x == paramv2i.x) && (this.y == paramv2i.y);
  }
  
  public boolean equalsZero()
  {
    return (this.x == 0) && (this.y == 0);
  }
  
  public v2i minus(v2i paramv2i)
  {
    return new v2i(this.x - paramv2i.x, this.y - paramv2i.y);
  }
  
  public v2i plus(v2i paramv2i)
  {
    return new v2i(this.x + paramv2i.x, this.y + paramv2i.y);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/bfs/papertoss/vector/v2i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */