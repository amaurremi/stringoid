package com.jiubang.playsdk.a;

import com.android.a.p;
import java.util.Iterator;
import java.util.LinkedList;

class h
{
  private final p b;
  private final LinkedList c = new LinkedList();
  
  public h(d paramd, p paramp, l paraml)
  {
    this.b = paramp;
    this.c.add(paraml);
  }
  
  private boolean b(l paraml)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      if (((l)localIterator.next()).a == paraml.a) {
        return true;
      }
    }
    return false;
  }
  
  public String a()
  {
    return this.b.b().toString();
  }
  
  public void a(l paraml)
  {
    if (!b(paraml)) {
      this.c.add(paraml);
    }
  }
  
  public boolean a(Object paramObject)
  {
    if (paramObject.equals(this.b.b()))
    {
      this.b.g();
      return true;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */