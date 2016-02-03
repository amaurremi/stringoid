package com.ideashower.readitlater.activity;

import com.ideashower.readitlater.a.a.a;
import com.ideashower.readitlater.b.d;
import com.ideashower.readitlater.g.m;
import java.util.ArrayList;
import java.util.Iterator;

class bg
  extends m
{
  private final bh b;
  private ArrayList c = null;
  private int d;
  
  public bg(be parambe, bh parambh)
  {
    this.b = parambh;
  }
  
  protected void a()
  {
    a.c(be.a(this.a));
    if (be.c(this.a).i() != null) {}
    try
    {
      this.c = be.a(this.a, be.c(this.a));
      if (this.c == null) {}
      this.d = be.a(this.a, be.c(this.a), this.c, this.b);
      return;
    }
    catch (d locald)
    {
      com.ideashower.readitlater.util.e.a(locald);
      this.d = -2;
    }
  }
  
  protected void a(boolean paramBoolean, Throwable paramThrowable)
  {
    if (!be.a(this.a, this.b)) {
      return;
    }
    this.b.b(this.d);
    switch (this.d)
    {
    }
    do
    {
      for (;;)
      {
        be.b(this.a, this.b);
        return;
        this.b.a(false);
      }
      this.b.a(true);
      paramThrowable = be.c(this.a).k();
      if (paramThrowable != null)
      {
        paramThrowable = paramThrowable.iterator();
        while (paramThrowable.hasNext())
        {
          com.ideashower.readitlater.a.a.e locale = (com.ideashower.readitlater.a.a.e)paramThrowable.next();
          this.b.a(1);
          new bf(this.a, locale, this.c, this.b).h();
        }
      }
    } while (!this.b.d());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */