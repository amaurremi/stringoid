package com.a.c;

import java.util.ArrayList;

class h
{
  int a;
  ArrayList b;
  
  h(int paramInt, ArrayList paramArrayList)
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
        if (((g)this.b.get(i)).a == paramInt)
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/a/c/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */