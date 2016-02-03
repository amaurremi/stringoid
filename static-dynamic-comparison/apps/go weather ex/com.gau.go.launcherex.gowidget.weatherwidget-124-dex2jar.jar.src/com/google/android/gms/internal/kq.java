package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class kq<M extends kp<M>, T>
{
  protected final Class<T> adV;
  protected final boolean adW;
  protected final int tag;
  protected final int type;
  
  private kq(int paramInt1, Class<T> paramClass, int paramInt2, boolean paramBoolean)
  {
    this.type = paramInt1;
    this.adV = paramClass;
    this.tag = paramInt2;
    this.adW = paramBoolean;
  }
  
  public static <M extends kp<M>, T extends kt> kq<M, T> a(int paramInt1, Class<T> paramClass, int paramInt2)
  {
    return new kq(paramInt1, paramClass, paramInt2, false);
  }
  
  protected void a(kv paramkv, List<Object> paramList)
  {
    paramList.add(o(kn.n(paramkv.adZ)));
  }
  
  protected boolean dd(int paramInt)
  {
    return paramInt == this.tag;
  }
  
  final T f(List<kv> paramList)
  {
    int j = 0;
    if (paramList == null)
    {
      paramList = null;
      return paramList;
    }
    Object localObject2;
    if (this.adW)
    {
      localObject2 = new ArrayList();
      i = 0;
      while (i < paramList.size())
      {
        localObject1 = (kv)paramList.get(i);
        if ((dd(((kv)localObject1).tag)) && (((kv)localObject1).adZ.length != 0)) {
          a((kv)localObject1, (List)localObject2);
        }
        i += 1;
      }
      int k = ((List)localObject2).size();
      if (k == 0) {
        return null;
      }
      localObject1 = this.adV.cast(Array.newInstance(this.adV.getComponentType(), k));
      i = j;
      for (;;)
      {
        paramList = (List<kv>)localObject1;
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
      localObject2 = (kv)paramList.get(i);
      if ((!dd(((kv)localObject2).tag)) || (((kv)localObject2).adZ.length == 0)) {
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
      return (T)this.adV.cast(o(kn.n(((kv)localObject1).adZ)));
    }
  }
  
  protected Object o(kn paramkn)
  {
    Class localClass;
    if (this.adW) {
      localClass = this.adV.getComponentType();
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
      catch (InstantiationException paramkn)
      {
        throw new IllegalArgumentException("Error creating instance of class " + localClass, paramkn);
        localClass = this.adV;
        continue;
        kt localkt = (kt)localClass.newInstance();
        paramkn.a(localkt, kw.df(this.tag));
        return localkt;
        localkt = (kt)localClass.newInstance();
        paramkn.a(localkt);
        return localkt;
      }
      catch (IllegalAccessException paramkn)
      {
        throw new IllegalArgumentException("Error creating instance of class " + localClass, paramkn);
      }
      catch (IOException paramkn)
      {
        throw new IllegalArgumentException("Error reading extension field", paramkn);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/kq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */