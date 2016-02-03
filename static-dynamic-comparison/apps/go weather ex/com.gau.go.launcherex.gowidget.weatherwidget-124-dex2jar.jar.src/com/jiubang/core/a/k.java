package com.jiubang.core.a;

import java.util.ArrayList;

public class k
  extends j
{
  protected ArrayList m;
  protected ArrayList n;
  
  public k(int paramInt)
  {
    super(paramInt);
    this.i = true;
  }
  
  public void a(j paramj)
  {
    if (paramj == null) {
      try
      {
        throw new IllegalArgumentException("attachAnimator cannot be null");
      }
      finally {}
    }
    if (this.m == null) {
      this.m = new ArrayList();
    }
    int i = this.m.indexOf(paramj);
    if (i >= 0) {}
    for (;;)
    {
      return;
      this.m.add(paramj);
    }
  }
  
  protected boolean a(s params, l paraml, long paramLong, v paramv)
  {
    int i;
    boolean bool;
    if (this.m != null)
    {
      int j = this.m.size();
      i = 0;
      if (i < j) {
        if (!((j)this.m.get(i)).c()) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      if (!bool) {
        this.d = true;
      }
      return bool;
      if (!((j)this.m.get(i)).d())
      {
        bool = true;
      }
      else
      {
        i += 1;
        break;
        bool = false;
      }
    }
  }
  
  protected boolean c(s params, l paraml, long paramLong, v paramv)
  {
    if (a(params, paraml, paramLong, paramv)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      int j;
      j localj;
      if (this.m != null)
      {
        j = this.m.size();
        bool2 = bool1;
        if (j > 0)
        {
          localj = (j)this.m.get(0);
          if ((localj == null) || (!localj.e())) {
            break label155;
          }
          if (localj.b(params, paraml, paramLong, paramv))
          {
            bool2 = true;
            bool1 = bool2;
            if (localj.c())
            {
              bool1 = bool2;
              if (!localj.d())
              {
                this.m.remove(localj);
                bool1 = bool2;
              }
            }
          }
          bool2 = bool1;
          if (this.m.size() <= 0)
          {
            a(params, paraml, paramLong, paramv);
            bool2 = bool1;
          }
        }
      }
      return bool2;
      label155:
      int i = 0;
      bool2 = bool1;
      label162:
      if (i < j)
      {
        localj = (j)this.m.get(i);
        if ((localj == null) || (!localj.b(params, paraml, paramLong, paramv))) {
          break label356;
        }
        if ((localj.c()) && (!localj.d()))
        {
          if (this.n == null) {
            this.n = new ArrayList();
          }
          this.n.add(localj);
        }
      }
      label356:
      for (bool1 = true;; bool1 = bool2)
      {
        i += 1;
        bool2 = bool1;
        break label162;
        if (this.n != null)
        {
          j = this.n.size();
          i = 0;
          while (i < j)
          {
            this.m.remove(this.n.get(i));
            i += 1;
          }
          this.n.clear();
          this.n = null;
        }
        bool1 = bool2;
        if (this.m.size() > 0) {
          break;
        }
        a(params, paraml, paramLong, paramv);
        bool1 = bool2;
        break;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */