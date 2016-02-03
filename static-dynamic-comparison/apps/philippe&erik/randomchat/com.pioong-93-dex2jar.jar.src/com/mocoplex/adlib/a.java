package com.mocoplex.adlib;

import java.util.ArrayList;

public final class a
{
  private static a c;
  ArrayList<Runnable> a = new ArrayList();
  private ArrayList<Runnable> b = new ArrayList();
  
  public static a a()
  {
    if (c == null) {
      c = new a();
    }
    return c;
  }
  
  public final void a(Runnable paramRunnable)
  {
    this.b.add(paramRunnable);
    if (this.a.size() < 5) {
      b();
    }
  }
  
  final void b()
  {
    try
    {
      synchronized (this.b)
      {
        if (!this.b.isEmpty())
        {
          Runnable localRunnable = (Runnable)this.b.get(0);
          this.b.remove(0);
          this.a.add(localRunnable);
          new Thread(localRunnable).start();
        }
        return;
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mocoplex/adlib/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */