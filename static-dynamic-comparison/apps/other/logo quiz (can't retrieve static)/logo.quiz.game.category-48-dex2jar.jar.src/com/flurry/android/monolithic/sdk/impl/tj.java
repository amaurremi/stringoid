package com.flurry.android.monolithic.sdk.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class tj
{
  private final tk[] a;
  private final int b;
  private final int c;
  
  public tj(Collection<sw> paramCollection)
  {
    this.c = paramCollection.size();
    int i = a(this.c);
    this.b = (i - 1);
    tk[] arrayOftk = new tk[i];
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      sw localsw = (sw)paramCollection.next();
      String str = localsw.c();
      i = str.hashCode() & this.b;
      arrayOftk[i] = new tk(arrayOftk[i], str, localsw);
    }
    this.a = arrayOftk;
  }
  
  private static final int a(int paramInt)
  {
    if (paramInt <= 32) {
      paramInt += paramInt;
    }
    int i;
    for (;;)
    {
      i = 2;
      while (i < paramInt) {
        i += i;
      }
      paramInt = (paramInt >> 2) + paramInt;
    }
    return i;
  }
  
  private sw a(String paramString, int paramInt)
  {
    for (tk localtk = this.a[paramInt]; localtk != null; localtk = localtk.a) {
      if (paramString.equals(localtk.b)) {
        return localtk.c;
      }
    }
    return null;
  }
  
  public sw a(String paramString)
  {
    int i = paramString.hashCode();
    i = this.b & i;
    tk localtk2 = this.a[i];
    if (localtk2 == null) {
      return null;
    }
    tk localtk1 = localtk2;
    if (localtk2.b == paramString) {
      return localtk2.c;
    }
    do
    {
      localtk2 = localtk1.a;
      if (localtk2 == null) {
        break;
      }
      localtk1 = localtk2;
    } while (localtk2.b != paramString);
    return localtk2.c;
    return a(paramString, i);
  }
  
  public void a()
  {
    tk[] arrayOftk = this.a;
    int k = arrayOftk.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      tk localtk = arrayOftk[i];
      while (localtk != null)
      {
        localtk.c.a(j);
        localtk = localtk.a;
        j += 1;
      }
      i += 1;
    }
  }
  
  public void a(sw paramsw)
  {
    String str = paramsw.c();
    int j = str.hashCode() & this.a.length - 1;
    tk localtk1 = this.a[j];
    int i = 0;
    tk localtk2 = null;
    if (localtk1 != null)
    {
      if ((i == 0) && (localtk1.b.equals(str))) {
        i = 1;
      }
      for (;;)
      {
        localtk1 = localtk1.a;
        break;
        localtk2 = new tk(localtk2, localtk1.b, localtk1.c);
      }
    }
    if (i == 0) {
      throw new NoSuchElementException("No entry '" + paramsw + "' found, can't replace");
    }
    this.a[j] = new tk(localtk2, str, paramsw);
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void b(sw paramsw)
  {
    String str = paramsw.c();
    int j = str.hashCode() & this.a.length - 1;
    tk localtk1 = this.a[j];
    int i = 0;
    tk localtk2 = null;
    if (localtk1 != null)
    {
      if ((i == 0) && (localtk1.b.equals(str))) {
        i = 1;
      }
      for (;;)
      {
        localtk1 = localtk1.a;
        break;
        localtk2 = new tk(localtk2, localtk1.b, localtk1.c);
      }
    }
    if (i == 0) {
      throw new NoSuchElementException("No entry '" + paramsw + "' found, can't remove");
    }
    this.a[j] = localtk2;
  }
  
  public Iterator<sw> c()
  {
    return new tl(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/tj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */