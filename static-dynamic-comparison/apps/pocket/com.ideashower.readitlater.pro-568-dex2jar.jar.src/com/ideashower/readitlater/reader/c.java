package com.ideashower.readitlater.reader;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.a.k;
import com.ideashower.readitlater.h.a;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.util.e;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.util.q;
import java.util.ArrayList;
import java.util.Iterator;

public class c
{
  private static final int a = g.b(2131361793);
  private static final int b = g.b(2131361794);
  private static final int[] c = g.c().getResources().getIntArray(2131099648);
  private static final com.ideashower.readitlater.objects.i d = new com.ideashower.readitlater.objects.i(c[0], c[(c.length - 1)]);
  private static final ArrayList e = new ArrayList();
  
  public static int a()
  {
    return com.ideashower.readitlater.h.i.a(a.ap);
  }
  
  public static int a(Activity paramActivity)
  {
    int i = q.b(paramActivity).b(false);
    if (j.f()) {
      return i;
    }
    return i - j.a(b * 2);
  }
  
  public static int a(ReaderWebView paramReaderWebView)
  {
    if (j.f()) {
      return b;
    }
    float f = a();
    f = (j.a(paramReaderWebView.getWidth()) - 32.0F * f) / 2.0F;
    return (int)com.ideashower.readitlater.objects.i.a(b, a, f);
  }
  
  public static void a(float paramFloat1, float paramFloat2)
  {
    if (k.a() == paramFloat1) {}
    for (;;)
    {
      return;
      k.a(paramFloat1);
      Iterator localIterator = e.iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).b(paramFloat1);
      }
    }
  }
  
  public static void a(int paramInt)
  {
    if (m.a() == paramInt) {}
    for (;;)
    {
      return;
      m.b(paramInt);
      paramInt = m.a();
      Iterator localIterator = e.iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).b(paramInt);
      }
    }
  }
  
  public static void a(d paramd)
  {
    if (!e.contains(paramd))
    {
      e.add(paramd);
      return;
    }
    e.b("warning: duplicate listener added");
  }
  
  public static void a(d paramd, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (paramBoolean1) {
      paramd.i(b());
    }
    if (paramBoolean2) {
      paramd.a(a(), e(), d());
    }
    if (paramBoolean3) {
      paramd.j(c());
    }
    if (paramBoolean4) {
      paramd.b(f());
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean == b()) {}
    for (;;)
    {
      return;
      com.ideashower.readitlater.h.i.a(a.aq, paramBoolean);
      Iterator localIterator = e.iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).i(paramBoolean);
      }
    }
  }
  
  private static void b(int paramInt)
  {
    if (paramInt == a()) {}
    for (;;)
    {
      return;
      com.ideashower.readitlater.h.i.b(a.ap, paramInt);
      Iterator localIterator = e.iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).a(paramInt, e(), d());
      }
    }
  }
  
  public static void b(d paramd)
  {
    e.remove(paramd);
  }
  
  public static boolean b()
  {
    return com.ideashower.readitlater.h.i.a(a.aq);
  }
  
  public static boolean c()
  {
    return com.ideashower.readitlater.h.i.a(a.ar);
  }
  
  public static boolean d()
  {
    return a() >= d.b;
  }
  
  public static boolean e()
  {
    return a() <= d.a;
  }
  
  public static int f()
  {
    return m.a();
  }
  
  public static boolean g()
  {
    int j = com.ideashower.readitlater.h.i.a(a.ap);
    if (j == d.b) {
      return false;
    }
    int[] arrayOfInt = c;
    int m = arrayOfInt.length;
    int i = 0;
    int k;
    if (i < m)
    {
      k = arrayOfInt[i];
      if (k <= j) {}
    }
    for (i = k;; i = j)
    {
      i = d.a(i);
      if (i == j)
      {
        return false;
        i += 1;
        break;
      }
      b(i);
      return true;
    }
  }
  
  public static boolean h()
  {
    int j = com.ideashower.readitlater.h.i.a(a.ap);
    if (j == d.a) {
      return false;
    }
    int i = c.length - 1;
    int k;
    if (i >= 0)
    {
      k = c[i];
      if (k >= j) {}
    }
    for (i = k;; i = j)
    {
      i = d.a(i);
      if (i == j)
      {
        return false;
        i -= 1;
        break;
      }
      b(i);
      return true;
    }
  }
  
  public static void i()
  {
    Iterator localIterator = e.iterator();
    while (localIterator.hasNext()) {
      ((d)localIterator.next()).j(c());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/reader/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */