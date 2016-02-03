package com.gau.go.gostaticsdk;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class a
{
  private LinkedList a = new LinkedList();
  private Object b = new Object();
  
  private boolean b(com.gau.go.gostaticsdk.a.a parama)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.a.size()) {}
      try
      {
        long l1 = ((com.gau.go.gostaticsdk.a.a)this.a.get(i)).b;
        long l2 = parama.b;
        if (l1 == l2)
        {
          bool1 = true;
          return bool1;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        i += 1;
      }
    }
  }
  
  public com.gau.go.gostaticsdk.a.a a()
  {
    synchronized (this.b)
    {
      if (!this.a.isEmpty())
      {
        com.gau.go.gostaticsdk.a.a locala = (com.gau.go.gostaticsdk.a.a)this.a.removeFirst();
        return locala;
      }
      return null;
    }
  }
  
  public void a(com.gau.go.gostaticsdk.a.a parama)
  {
    synchronized (this.b)
    {
      this.a.addLast(parama);
      return;
    }
  }
  
  public void a(List paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        com.gau.go.gostaticsdk.a.a locala = (com.gau.go.gostaticsdk.a.a)paramList.next();
        if (!b(locala)) {
          a(locala);
        }
      }
    }
  }
  
  public void b()
  {
    this.a.clear();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/gostaticsdk/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */