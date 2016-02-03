package com.gau.go.launcherex.gowidget.d;

import android.os.Handler;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class c
  implements a
{
  private final SparseArray a = new SparseArray();
  private final Handler b = new Handler();
  private final SparseArray c = new SparseArray();
  
  private List b(int paramInt)
  {
    List localList = (List)this.a.get(paramInt);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.a.put(paramInt, localObject);
    }
    return (List)localObject;
  }
  
  private void c(int paramInt)
  {
    this.c.delete(paramInt);
  }
  
  private void d(int paramInt)
  {
    d locald = (d)this.c.get(paramInt);
    if (locald != null)
    {
      this.b.removeCallbacks(locald);
      this.c.delete(paramInt);
    }
  }
  
  public void a(int paramInt)
  {
    d(paramInt);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    b localb = new b();
    localb.a = paramInt;
    localb.b = paramObject;
    paramObject = (List)this.a.get(paramInt);
    if (paramObject != null)
    {
      paramObject = new ArrayList((Collection)paramObject).iterator();
      while (((Iterator)paramObject).hasNext()) {
        ((e)((Iterator)paramObject).next()).a(localb);
      }
    }
  }
  
  public void a(int paramInt, Object paramObject, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {
      a(paramInt);
    }
    if (paramLong > 0L)
    {
      paramObject = new d(this, paramInt, paramObject);
      this.c.put(paramInt, paramObject);
      this.b.postDelayed((Runnable)paramObject, paramLong);
      return;
    }
    a(paramInt, paramObject);
  }
  
  public void a(e parame)
  {
    int m = this.a.size();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      List localList = (List)this.a.valueAt(i);
      k = j;
      if (localList.remove(parame)) {
        k = j + 1;
      }
      if (localList.size() == 0) {
        localArrayList.add(Integer.valueOf(this.a.keyAt(i)));
      }
      i += 1;
    }
    if (j == 0) {
      throw new IllegalStateException("you have never register receiver here, do not call unregisterReceiver casually...");
    }
    parame = localArrayList.iterator();
    while (parame.hasNext())
    {
      i = ((Integer)parame.next()).intValue();
      this.a.remove(i);
    }
  }
  
  public void a(e parame, int... paramVarArgs)
  {
    if (paramVarArgs.length < 1) {
      throw new IllegalArgumentException("you must define the messages you want to receiver!");
    }
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      List localList = b(paramVarArgs[i]);
      if (localList.contains(parame)) {
        throw new IllegalStateException("receiver already exists, do you forget to unregister it?");
      }
      localList.add(parame);
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */