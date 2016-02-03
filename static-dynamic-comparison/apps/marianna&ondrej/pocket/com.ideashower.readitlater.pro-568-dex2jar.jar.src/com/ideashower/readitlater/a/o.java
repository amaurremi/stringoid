package com.ideashower.readitlater.a;

import android.text.TextUtils;
import android.util.SparseArray;
import com.ideashower.readitlater.db.operation.f;
import com.ideashower.readitlater.e.x;
import com.ideashower.readitlater.util.e;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import org.apache.a.c.k;

public class o
{
  public static final Comparator a = new Comparator()
  {
    public int a(f paramAnonymousf1, f paramAnonymousf2)
    {
      return Long.signum(paramAnonymousf2.l() - paramAnonymousf1.l());
    }
  };
  public static o b;
  private SparseArray c;
  private SparseArray d;
  private HashMap e;
  private boolean f = false;
  private final Object g = new Object();
  private final Object h = new Object();
  private CountDownLatch i;
  
  private static o a(boolean paramBoolean)
  {
    if (paramBoolean) {
      b.b(true);
    }
    return b;
  }
  
  public static void a()
  {
    b = new o();
  }
  
  public static void a(SparseArray paramSparseArray1, SparseArray paramSparseArray2, HashMap paramHashMap)
  {
    a(false).b(paramSparseArray1, paramSparseArray2, paramHashMap);
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    if (k.c(paramString2)) {
      return false;
    }
    paramString2 = paramString2.toLowerCase();
    if (paramString1.length() > 2) {
      return paramString2.contains(paramString1);
    }
    return paramString2.startsWith(paramString1);
  }
  
  public static void b()
  {
    a(false).b(false);
  }
  
  private void b(boolean paramBoolean)
  {
    CountDownLatch localCountDownLatch = null;
    synchronized (this.g)
    {
      if (!this.f)
      {
        if (this.i == null)
        {
          this.i = new CountDownLatch(1);
          new p(this, null).f();
        }
        localCountDownLatch = this.i;
      }
      if ((!paramBoolean) || (localCountDownLatch == null)) {}
    }
    try
    {
      localCountDownLatch.await();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      e.a(localInterruptedException);
    }
    localObject1 = finally;
    throw ((Throwable)localObject1);
  }
  
  public static o c()
  {
    return a(true);
  }
  
  public static ag f()
  {
    new ag()
    {
      public void a() {}
      
      public void b() {}
      
      public void c()
      {
        o.a();
        o.b();
      }
    };
  }
  
  public f a(int paramInt)
  {
    synchronized (this.h)
    {
      f localf = (f)this.c.get(paramInt);
      return localf;
    }
  }
  
  public f a(x paramx)
  {
    synchronized (this.h)
    {
      paramx = a(paramx.c());
      return paramx;
    }
  }
  
  public f a(String paramString)
  {
    if (k.c(paramString)) {
      return null;
    }
    synchronized (this.h)
    {
      paramString = (Integer)this.e.get(paramString.toLowerCase());
      if (paramString == null) {
        return null;
      }
      paramString = (f)this.d.get(paramString.intValue());
      return paramString;
    }
  }
  
  public ArrayList a(CharSequence arg1)
  {
    if (TextUtils.isEmpty(???)) {
      return d();
    }
    ArrayList localArrayList1 = new ArrayList();
    String str = ???.toString().toLowerCase();
    for (;;)
    {
      int j;
      int k;
      synchronized (this.h)
      {
        int m = this.d.size();
        j = 0;
        if (j < m)
        {
          f localf = (f)this.d.valueAt(j);
          boolean bool2 = a(str, localf.c());
          boolean bool1 = bool2;
          if (!bool2) {
            bool1 = a(str, localf.d());
          }
          if (!bool1)
          {
            ArrayList localArrayList2 = localf.i();
            if (localArrayList2 != null)
            {
              int n = localArrayList2.size();
              k = 0;
              if (k < n)
              {
                if (!a(str, (String)localArrayList2.get(k))) {
                  break label190;
                }
                bool1 = true;
                if (!bool1) {
                  break label183;
                }
                localArrayList1.add(localf);
                break label183;
              }
            }
          }
        }
        else
        {
          return localArrayList1;
        }
      }
      continue;
      label183:
      j += 1;
      continue;
      label190:
      k += 1;
    }
  }
  
  public f b(int paramInt)
  {
    synchronized (this.h)
    {
      f localf = (f)this.d.get(paramInt);
      return localf;
    }
  }
  
  public f b(String paramString)
  {
    if (k.c(paramString)) {
      return null;
    }
    for (;;)
    {
      int j;
      synchronized (this.h)
      {
        int k = this.c.size();
        j = 0;
        if (j >= k) {
          break;
        }
        f localf = (f)this.c.valueAt(j);
        if (k.b(localf.d(), paramString)) {
          return localf;
        }
      }
      j += 1;
    }
    return null;
  }
  
  public void b(SparseArray arg1, SparseArray paramSparseArray2, HashMap paramHashMap)
  {
    synchronized (this.h)
    {
      this.c = ???;
      this.d = paramSparseArray2;
      this.e = paramHashMap;
      synchronized (this.g)
      {
        if ((!this.f) && (this.i != null))
        {
          this.f = true;
          this.i.countDown();
          this.i = null;
        }
        return;
      }
    }
  }
  
  public ArrayList d()
  {
    synchronized (this.h)
    {
      int k = this.d.size();
      ArrayList localArrayList = new ArrayList(k);
      int j = 0;
      while (j < k)
      {
        localArrayList.add(this.d.valueAt(j));
        j += 1;
      }
      return localArrayList;
    }
  }
  
  public f e()
  {
    int j = as.q();
    if (j == 0) {
      return null;
    }
    return a(j);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */