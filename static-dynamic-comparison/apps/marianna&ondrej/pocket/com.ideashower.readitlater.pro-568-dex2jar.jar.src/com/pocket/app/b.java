package com.pocket.app;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.j;
import android.support.v4.app.n;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.a.m;
import com.ideashower.readitlater.activity.a;
import com.ideashower.readitlater.util.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
  extends j
  implements android.support.v4.app.k
{
  private final j a;
  private final a b;
  private final ArrayList c = new ArrayList();
  private int d = 0;
  
  public b(j paramj, a parama)
  {
    this.b = parama;
    this.a = paramj;
    this.c.add(new c(this, null));
    paramj.a(this);
  }
  
  private static void a(List paramList1, List paramList2, int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    if (i < j)
    {
      int k = paramArrayOfInt[i];
      if (k < 0) {
        e.a("fragment not found, unexpected");
      }
      for (;;)
      {
        i += 1;
        break;
        paramList2.add(paramList1.get(k));
      }
    }
  }
  
  private boolean a(Fragment paramFragment)
  {
    return ((c)this.c.get(0)).a.contains(paramFragment);
  }
  
  private static int[] a(List paramList1, List paramList2)
  {
    int[] arrayOfInt = new int[paramList2.size()];
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = paramList1.indexOf(paramList2.get(i));
      i += 1;
    }
    return arrayOfInt;
  }
  
  private c k()
  {
    return (c)this.c.get(this.c.size() - 1);
  }
  
  public Fragment a(String paramString)
  {
    return this.a.a(paramString);
  }
  
  @SuppressLint({"CommitTransaction"})
  public n a()
  {
    return new d(this.a.a(), this);
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = k().a.iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment instanceof com.ideashower.readitlater.activity.f)) {
        ((com.ideashower.readitlater.activity.f)localFragment).b(paramInt);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.a(paramInt1, paramInt2);
  }
  
  public void a(Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    int j = this.c.size();
    localBundle.putInt("backStackEntryCount", this.c.size());
    List localList = this.a.d();
    int i = 0;
    while (i < j)
    {
      c localc = (c)this.c.get(i);
      localBundle.putIntArray("backStackEntryAdds" + i, a(localList, localc.a));
      localBundle.putIntArray("backStackEntryVisibles" + i, a(localList, localc.b));
      i += 1;
    }
    paramBundle.putBundle("PocketFragmentManagerState", localBundle);
  }
  
  public void a(Fragment paramFragment, android.support.v4.app.f paramf)
  {
    if (((paramFragment instanceof android.support.v4.app.d)) && (((android.support.v4.app.d)paramFragment).e()))
    {
      ((android.support.v4.app.d)paramFragment).c().dismiss();
      return;
    }
    if (a(paramFragment))
    {
      paramf.finish();
      return;
    }
    com.pocket.p.k.a(paramFragment, paramf);
  }
  
  public void a(android.support.v4.app.k paramk)
  {
    this.a.a(paramk);
  }
  
  public void a(ArrayList paramArrayList1, ArrayList paramArrayList2, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(f());
    localArrayList.removeAll(paramArrayList2);
    localArrayList.addAll(paramArrayList1);
    if (paramBoolean)
    {
      paramArrayList2 = k();
      if (paramArrayList2.b.size() == 0) {
        this.b.A();
      }
      paramArrayList2 = paramArrayList2.a.iterator();
      while (paramArrayList2.hasNext())
      {
        localObject = (Fragment)paramArrayList2.next();
        if ((localObject instanceof com.ideashower.readitlater.activity.f)) {
          ((com.ideashower.readitlater.activity.f)localObject).N();
        }
      }
      paramArrayList2 = new c(this, null);
      paramArrayList2.a.addAll(paramArrayList1);
      paramArrayList2.b.clear();
      paramArrayList2.b.addAll(localArrayList);
      this.c.add(paramArrayList2);
      return;
    }
    Object localObject = k();
    ((c)localObject).a.addAll(paramArrayList1);
    ((c)localObject).a.removeAll(paramArrayList2);
    ((c)localObject).b.clear();
    ((c)localObject).b.addAll(localArrayList);
  }
  
  public void b(Bundle paramBundle)
  {
    paramBundle = paramBundle.getBundle("PocketFragmentManagerState");
    int j = paramBundle.getInt("backStackEntryCount");
    if (j <= 0) {
      return;
    }
    List localList = this.a.d();
    int i = 0;
    while (i < j)
    {
      if (i > 0) {
        this.c.add(new c(this, null));
      }
      c localc = (c)this.c.get(i);
      a(localList, localc.a, paramBundle.getIntArray("backStackEntryAdds" + i));
      a(localList, localc.b, paramBundle.getIntArray("backStackEntryVisibles" + i));
      i += 1;
    }
    this.d = j;
  }
  
  public boolean b()
  {
    return this.a.b();
  }
  
  public int c()
  {
    return this.a.c();
  }
  
  public List d()
  {
    return this.a.d();
  }
  
  public void e()
  {
    int j = this.a.c();
    if (j < this.d)
    {
      int k = this.d;
      int i = 0;
      while (i < k - j)
      {
        this.c.remove(this.c.size() - 1);
        i += 1;
      }
      if (this.c.isEmpty()) {
        this.c.add(new c(this, null));
      }
      for (;;)
      {
        try
        {
          if (g.n() == null) {
            break label208;
          }
          String str = g.n().toString();
          throw new RuntimeException("empty back stack at " + str);
        }
        catch (RuntimeException localRuntimeException)
        {
          g.s().b(localRuntimeException);
        }
        Object localObject = k();
        if (((c)localObject).b.size() == 0) {
          this.b.B();
        }
        localObject = ((c)localObject).a.iterator();
        while (((Iterator)localObject).hasNext())
        {
          Fragment localFragment = (Fragment)((Iterator)localObject).next();
          if ((localFragment instanceof com.ideashower.readitlater.activity.f)) {
            ((com.ideashower.readitlater.activity.f)localFragment).M();
          }
        }
        label208:
        localObject = "";
      }
    }
    this.d = j;
  }
  
  public ArrayList f()
  {
    return k().b;
  }
  
  public ArrayList g()
  {
    return k().a;
  }
  
  public boolean h()
  {
    ArrayList localArrayList = k().a;
    int i = localArrayList.size() - 1;
    while (i >= 0)
    {
      Fragment localFragment = (Fragment)localArrayList.get(i);
      if (((localFragment instanceof com.ideashower.readitlater.activity.f)) && (((com.ideashower.readitlater.activity.f)localFragment).W())) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  public void i()
  {
    Iterator localIterator = k().a.iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment instanceof com.ideashower.readitlater.activity.f)) {
        ((com.ideashower.readitlater.activity.f)localFragment).L();
      }
    }
  }
  
  public void j()
  {
    Object localObject = this.a.d();
    n localn = a();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Fragment localFragment = (Fragment)((Iterator)localObject).next();
      if (localFragment.t()) {
        localn.a(localFragment);
      }
    }
    localn.a();
    b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/app/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */