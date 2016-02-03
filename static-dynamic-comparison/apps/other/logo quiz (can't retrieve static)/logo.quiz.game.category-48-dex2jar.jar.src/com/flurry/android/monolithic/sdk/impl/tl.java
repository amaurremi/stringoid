package com.flurry.android.monolithic.sdk.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class tl
  implements Iterator<sw>
{
  private final tk[] a;
  private tk b;
  private int c;
  
  public tl(tk[] paramArrayOftk)
  {
    this.a = paramArrayOftk;
    int i = 0;
    int k = this.a.length;
    int j;
    if (i < k)
    {
      paramArrayOftk = this.a;
      j = i + 1;
      paramArrayOftk = paramArrayOftk[i];
      if (paramArrayOftk != null) {
        this.b = paramArrayOftk;
      }
    }
    for (;;)
    {
      this.c = j;
      return;
      i = j;
      break;
      j = i;
    }
  }
  
  public sw a()
  {
    tk localtk = this.b;
    if (localtk == null) {
      throw new NoSuchElementException();
    }
    int i;
    for (Object localObject = localtk.a; (localObject == null) && (this.c < this.a.length); localObject = localObject[i])
    {
      localObject = this.a;
      i = this.c;
      this.c = (i + 1);
    }
    this.b = ((tk)localObject);
    return localtk.c;
  }
  
  public boolean hasNext()
  {
    return this.b != null;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/tl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */