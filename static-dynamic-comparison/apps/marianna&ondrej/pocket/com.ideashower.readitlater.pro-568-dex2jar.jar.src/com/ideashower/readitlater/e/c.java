package com.ideashower.readitlater.e;

import java.util.Comparator;

public abstract class c
{
  public static final Comparator a = new Comparator()
  {
    public int a(c paramAnonymousc1, c paramAnonymousc2)
    {
      if (((paramAnonymousc1 instanceof y)) && (!(paramAnonymousc2 instanceof y))) {
        return 1000;
      }
      if ((!(paramAnonymousc1 instanceof y)) && ((paramAnonymousc2 instanceof y))) {
        return 64536;
      }
      if (((paramAnonymousc1 instanceof y)) && ((paramAnonymousc2 instanceof y))) {
        return Long.signum(((y)paramAnonymousc2).e() - ((y)paramAnonymousc1).e());
      }
      return Long.signum(((x)paramAnonymousc2).f() - ((x)paramAnonymousc1).f());
    }
  };
  public static final Comparator b = new Comparator()
  {
    public int a(c paramAnonymousc1, c paramAnonymousc2)
    {
      if (((paramAnonymousc1 instanceof y)) && (!(paramAnonymousc2 instanceof y))) {
        return 64536;
      }
      if ((!(paramAnonymousc1 instanceof y)) && ((paramAnonymousc2 instanceof y))) {
        return 1000;
      }
      if (((paramAnonymousc1 instanceof y)) && ((paramAnonymousc2 instanceof y))) {
        return Long.signum(((y)paramAnonymousc1).e() - ((y)paramAnonymousc2).e());
      }
      return Long.signum(((x)paramAnonymousc1).f() - ((x)paramAnonymousc2).f());
    }
  };
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */