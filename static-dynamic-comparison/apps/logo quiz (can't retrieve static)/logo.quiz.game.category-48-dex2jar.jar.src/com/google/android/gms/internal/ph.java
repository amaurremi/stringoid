package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ph<M extends pg<M>, T>
{
  protected final boolean awA;
  protected final Class<T> awz;
  protected final int tag;
  protected final int type;
  
  private ph(int paramInt1, Class<T> paramClass, int paramInt2, boolean paramBoolean)
  {
    this.type = paramInt1;
    this.awz = paramClass;
    this.tag = paramInt2;
    this.awA = paramBoolean;
  }
  
  public static <M extends pg<M>, T extends pm> ph<M, T> a(int paramInt1, Class<T> paramClass, int paramInt2)
  {
    return new ph(paramInt1, paramClass, paramInt2, false);
  }
  
  private T m(List<po> paramList)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      localObject = (po)paramList.get(i);
      if (((po)localObject).awK.length != 0) {
        a((po)localObject, localArrayList);
      }
      i += 1;
    }
    int k = localArrayList.size();
    if (k == 0)
    {
      paramList = null;
      return paramList;
    }
    Object localObject = this.awz.cast(Array.newInstance(this.awz.getComponentType(), k));
    i = j;
    for (;;)
    {
      paramList = (List<po>)localObject;
      if (i >= k) {
        break;
      }
      Array.set(localObject, i, localArrayList.get(i));
      i += 1;
    }
  }
  
  private T n(List<po> paramList)
  {
    if (paramList.isEmpty()) {
      return null;
    }
    paramList = (po)paramList.get(paramList.size() - 1);
    return (T)this.awz.cast(u(pe.p(paramList.awK)));
  }
  
  int A(Object paramObject)
  {
    if (this.awA) {
      return B(paramObject);
    }
    return C(paramObject);
  }
  
  protected int B(Object paramObject)
  {
    int j = 0;
    int m = Array.getLength(paramObject);
    int i = 0;
    while (i < m)
    {
      int k = j;
      if (Array.get(paramObject, i) != null) {
        k = j + C(Array.get(paramObject, i));
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  protected int C(Object paramObject)
  {
    int i = pp.gH(this.tag);
    switch (this.type)
    {
    default: 
      throw new IllegalArgumentException("Unknown type " + this.type);
    case 10: 
      return pf.b(i, (pm)paramObject);
    }
    return pf.c(i, (pm)paramObject);
  }
  
  protected void a(po parampo, List<Object> paramList)
  {
    paramList.add(u(pe.p(parampo.awK)));
  }
  
  void a(Object paramObject, pf parampf)
    throws IOException
  {
    if (this.awA)
    {
      c(paramObject, parampf);
      return;
    }
    b(paramObject, parampf);
  }
  
  protected void b(Object paramObject, pf parampf)
  {
    for (;;)
    {
      try
      {
        parampf.gz(this.tag);
        switch (this.type)
        {
        case 10: 
          throw new IllegalArgumentException("Unknown type " + this.type);
        }
      }
      catch (IOException paramObject)
      {
        throw new IllegalStateException((Throwable)paramObject);
      }
      paramObject = (pm)paramObject;
      int i = pp.gH(this.tag);
      parampf.b((pm)paramObject);
      parampf.w(i, 4);
      return;
      parampf.c((pm)paramObject);
      return;
    }
  }
  
  protected void c(Object paramObject, pf parampf)
  {
    int j = Array.getLength(paramObject);
    int i = 0;
    while (i < j)
    {
      Object localObject = Array.get(paramObject, i);
      if (localObject != null) {
        b(localObject, parampf);
      }
      i += 1;
    }
  }
  
  final T l(List<po> paramList)
  {
    if (paramList == null) {
      return null;
    }
    if (this.awA) {
      return (T)m(paramList);
    }
    return (T)n(paramList);
  }
  
  protected Object u(pe parampe)
  {
    Class localClass;
    if (this.awA) {
      localClass = this.awz.getComponentType();
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
      catch (InstantiationException parampe)
      {
        throw new IllegalArgumentException("Error creating instance of class " + localClass, parampe);
        localClass = this.awz;
        continue;
        pm localpm = (pm)localClass.newInstance();
        parampe.a(localpm, pp.gH(this.tag));
        return localpm;
        localpm = (pm)localClass.newInstance();
        parampe.a(localpm);
        return localpm;
      }
      catch (IllegalAccessException parampe)
      {
        throw new IllegalArgumentException("Error creating instance of class " + localClass, parampe);
      }
      catch (IOException parampe)
      {
        throw new IllegalArgumentException("Error reading extension field", parampe);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/ph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */