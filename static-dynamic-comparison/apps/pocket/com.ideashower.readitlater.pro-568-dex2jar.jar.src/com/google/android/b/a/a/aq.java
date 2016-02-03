package com.google.android.b.a.a;

import java.util.ArrayList;

public abstract class aq
{
  private Object b;
  
  public aq(ao paramao, Object arg2)
  {
    this.b = ???;
    synchronized (ao.c(paramao))
    {
      ao.c(paramao).add(this);
      return;
    }
  }
  
  public final void a()
  {
    try
    {
      Object localObject1 = this.b;
      a(localObject1);
      return;
    }
    finally {}
  }
  
  protected abstract void a(Object paramObject);
  
  public final void b()
  {
    try
    {
      this.b = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/b/a/a/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */