package com.pocket.p;

class g
  implements Comparable
{
  private final int b;
  private final float c;
  
  private g(f paramf, int paramInt, float paramFloat)
  {
    this.b = paramInt;
    this.c = paramFloat;
  }
  
  public int a(g paramg)
  {
    if (paramg.c == this.c) {
      return 0;
    }
    if (paramg.c < this.c) {
      return 1;
    }
    return -1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/p/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */