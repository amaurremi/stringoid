package com.jirbo.adcolony;

import java.util.ArrayList;
import java.util.Iterator;

class aa
{
  static String a = new String("mutex");
  static ArrayList<aa.a> b = new ArrayList();
  static ArrayList<aa.a> c = new ArrayList();
  static ArrayList<Runnable> d = new ArrayList();
  static ArrayList<Runnable> e = new ArrayList();
  static volatile boolean f;
  
  static void a()
  {
    
    synchronized (a)
    {
      d.clear();
      b();
      return;
    }
  }
  
  static void a(Runnable paramRunnable)
  {
    for (;;)
    {
      synchronized (a)
      {
        if (f)
        {
          d.add(paramRunnable);
          return;
        }
        int i = b.size();
        if (i <= 0) {
          break label116;
        }
        ??? = (aa.a)b.remove(i - 1);
        if (??? != null) {
          break label97;
        }
        ??? = new aa.a();
      }
      synchronized (a)
      {
        c.add(???);
        ((aa.a)???).a = paramRunnable;
        ((aa.a)???).start();
        return;
        paramRunnable = finally;
        throw paramRunnable;
      }
      try
      {
        label97:
        ((aa.a)???).a = paramRunnable;
        ???.notify();
        return;
      }
      finally {}
      label116:
      ??? = null;
    }
  }
  
  static void b()
  {
    synchronized (a)
    {
      f = false;
      e.clear();
      e.addAll(d);
      d.clear();
      c.clear();
      ??? = e.iterator();
      if (((Iterator)???).hasNext()) {
        a((Runnable)((Iterator)???).next());
      }
    }
  }
  
  static void c()
  {
    synchronized (a)
    {
      f = true;
      Iterator localIterator = b.iterator();
      while (localIterator.hasNext()) {
        synchronized ((aa.a)localIterator.next())
        {
          ???.notify();
        }
      }
    }
    synchronized (a)
    {
      b.clear();
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */