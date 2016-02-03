package com.pocket.list.adapter.a;

import android.util.SparseIntArray;

public class c
{
  public int a;
  public int b;
  public int c;
  private SparseIntArray d = new SparseIntArray();
  
  public c(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
  }
  
  public int a(int paramInt)
  {
    this.b += 1;
    this.d.put(this.b, b(this.b - 1) + paramInt);
    this.c -= paramInt;
    return this.c;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.b = 0;
    this.d.clear();
    this.d.put(0, 0);
    this.c = paramInt1;
    this.a = paramInt2;
  }
  
  public int b(int paramInt)
  {
    return this.d.get(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    int j = paramInt1 - this.a;
    if (j == 0)
    {
      a(paramInt2, paramInt1);
      return;
    }
    int i = this.b;
    paramInt1 = j + 1;
    while (paramInt1 <= i)
    {
      this.b -= 1;
      this.d.delete(paramInt1);
      paramInt1 += 1;
    }
    this.c = (paramInt2 - this.d.get(this.b));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/list/adapter/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */