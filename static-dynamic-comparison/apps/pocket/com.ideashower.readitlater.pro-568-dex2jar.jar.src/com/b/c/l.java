package com.b.c;

import java.util.ArrayList;

class l
{
  int a;
  ArrayList b;
  
  l(int paramInt, ArrayList paramArrayList)
  {
    this.a = paramInt;
    this.b = paramArrayList;
  }
  
  boolean a(int paramInt)
  {
    if (((this.a & paramInt) != 0) && (this.b != null))
    {
      int j = this.b.size();
      int i = 0;
      while (i < j)
      {
        if (((k)this.b.get(i)).a == paramInt)
        {
          this.b.remove(i);
          this.a &= (paramInt ^ 0xFFFFFFFF);
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/b/c/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */