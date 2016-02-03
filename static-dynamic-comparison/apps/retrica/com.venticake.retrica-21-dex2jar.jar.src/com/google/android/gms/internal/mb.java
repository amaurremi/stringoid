package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class mb<M extends ma<M>, T>
{
  protected final Class<T> amY;
  protected final boolean amZ;
  protected final int tag;
  protected final int type;
  
  private mb(int paramInt1, Class<T> paramClass, int paramInt2, boolean paramBoolean)
  {
    this.type = paramInt1;
    this.amY = paramClass;
    this.tag = paramInt2;
    this.amZ = paramBoolean;
  }
  
  public static <M extends ma<M>, T extends me> mb<M, T> a(int paramInt1, Class<T> paramClass, int paramInt2)
  {
    return new mb(paramInt1, paramClass, paramInt2, false);
  }
  
  protected void a(mg parammg, List<Object> paramList)
  {
    paramList.add(u(ly.p(parammg.anc)));
  }
  
  protected boolean eM(int paramInt)
  {
    return paramInt == this.tag;
  }
  
  final T i(List<mg> paramList)
  {
    int j = 0;
    if (paramList == null)
    {
      paramList = null;
      return paramList;
    }
    Object localObject2;
    if (this.amZ)
    {
      localObject2 = new ArrayList();
      i = 0;
      while (i < paramList.size())
      {
        localObject1 = (mg)paramList.get(i);
        if ((eM(((mg)localObject1).tag)) && (((mg)localObject1).anc.length != 0)) {
          a((mg)localObject1, (List)localObject2);
        }
        i += 1;
      }
      int k = ((List)localObject2).size();
      if (k == 0) {
        return null;
      }
      localObject1 = this.amY.cast(Array.newInstance(this.amY.getComponentType(), k));
      i = j;
      for (;;)
      {
        paramList = (List<mg>)localObject1;
        if (i >= k) {
          break;
        }
        Array.set(localObject1, i, ((List)localObject2).get(i));
        i += 1;
      }
    }
    int i = paramList.size() - 1;
    Object localObject1 = null;
    if ((localObject1 == null) && (i >= 0))
    {
      localObject2 = (mg)paramList.get(i);
      if ((!eM(((mg)localObject2).tag)) || (((mg)localObject2).anc.length == 0)) {
        break label247;
      }
      localObject1 = localObject2;
    }
    label247:
    for (;;)
    {
      i -= 1;
      break;
      if (localObject1 == null) {
        return null;
      }
      return (T)this.amY.cast(u(ly.p(((mg)localObject1).anc)));
    }
  }
  
  protected Object u(ly paramly)
  {
    Class localClass;
    if (this.amZ) {
      localClass = this.amY.getComponentType();
    }
    for (;;)
    {
      try
      {
        switch (this.type)
        {
        case 10: 
          throw new IllegalArgumentException("Unknown type " + this.type);
        }
      }
      catch (InstantiationException paramly)
      {
        throw new IllegalArgumentException("Error creating instance of class " + localClass, paramly);
        localClass = this.amY;
        continue;
        me localme = (me)localClass.newInstance();
        paramly.a(localme, mh.eO(this.tag));
        return localme;
        localme = (me)localClass.newInstance();
        paramly.a(localme);
        return localme;
      }
      catch (IllegalAccessException paramly)
      {
        throw new IllegalArgumentException("Error creating instance of class " + localClass, paramly);
      }
      catch (IOException paramly)
      {
        throw new IllegalArgumentException("Error reading extension field", paramly);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/mb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */