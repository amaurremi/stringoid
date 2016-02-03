package com.ideashower.readitlater.e;

import android.util.SparseArray;
import com.ideashower.readitlater.a.ag;
import com.ideashower.readitlater.h.a;
import com.ideashower.readitlater.h.h;
import com.ideashower.readitlater.h.i;
import java.util.ArrayList;
import java.util.Iterator;
import org.codehaus.jackson.node.ObjectNode;

public class k
{
  private static final k a = new k();
  private final Object b = new Object();
  private SparseArray c;
  private ObjectNode d = i.a(a.ce, null);
  
  private k()
  {
    if (this.d != null) {
      a(b(this.d));
    }
  }
  
  public static k a()
  {
    return a;
  }
  
  private void a(SparseArray paramSparseArray)
  {
    synchronized (this.b)
    {
      this.c = paramSparseArray;
      return;
    }
  }
  
  private void a(ObjectNode paramObjectNode)
  {
    Object localObject2 = null;
    for (;;)
    {
      synchronized (this.b)
      {
        this.d = paramObjectNode;
        if (paramObjectNode != null)
        {
          localObject1 = b(paramObjectNode);
          a((SparseArray)localObject1);
          com.ideashower.readitlater.h.l locall = i.b();
          h localh = a.ce;
          localObject1 = localObject2;
          if (paramObjectNode != null) {
            localObject1 = paramObjectNode.toString();
          }
          locall.a(localh, (String)localObject1).a();
          return;
        }
      }
      Object localObject1 = null;
    }
  }
  
  private static SparseArray b(ObjectNode paramObjectNode)
  {
    SparseArray localSparseArray = new SparseArray();
    paramObjectNode = paramObjectNode.getElements();
    while (paramObjectNode.hasNext())
    {
      g localg = new g((ObjectNode)paramObjectNode.next());
      localSparseArray.put(localg.a(), localg);
      localg.a(com.ideashower.readitlater.a.g.c());
    }
    return localSparseArray;
  }
  
  public static ag d()
  {
    new ag()
    {
      public void a() {}
      
      public void b()
      {
        k.a(k.a(), null);
      }
      
      public void c() {}
    };
  }
  
  public g a(int paramInt)
  {
    synchronized (this.b)
    {
      g localg = (g)this.c.get(paramInt);
      return localg;
    }
  }
  
  public ArrayList b()
  {
    for (;;)
    {
      int i;
      synchronized (this.b)
      {
        if (this.c == null) {
          return null;
        }
        int j = this.c.size();
        ArrayList localArrayList = new ArrayList(j);
        i = 0;
        if (i < j)
        {
          g localg = (g)this.c.valueAt(i);
          if (localg != null) {
            localArrayList.add(localg);
          }
        }
        else
        {
          return localArrayList;
        }
      }
      i += 1;
    }
  }
  
  public l c()
  {
    return new l(this, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/e/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */