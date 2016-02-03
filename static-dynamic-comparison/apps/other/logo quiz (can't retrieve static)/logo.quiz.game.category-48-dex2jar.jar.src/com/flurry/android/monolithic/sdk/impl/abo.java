package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@rz
public class abo
  extends abw<Object[]>
  implements rp
{
  protected final boolean a;
  protected final afm b;
  protected ra<Object> c;
  protected aal d;
  
  public abo(afm paramafm, boolean paramBoolean, rx paramrx, qc paramqc, ra<Object> paramra)
  {
    super(Object[].class, paramrx, paramqc);
    this.b = paramafm;
    this.a = paramBoolean;
    this.d = aal.a();
    this.c = paramra;
  }
  
  public abc<?> a(rx paramrx)
  {
    return new abo(this.b, this.a, paramrx, this.f, this.c);
  }
  
  protected final ra<Object> a(aal paramaal, afm paramafm, ru paramru)
    throws qw
  {
    paramafm = paramaal.a(paramafm, paramru, this.f);
    if (paramaal != paramafm.b) {
      this.d = paramafm.b;
    }
    return paramafm.a;
  }
  
  protected final ra<Object> a(aal paramaal, Class<?> paramClass, ru paramru)
    throws qw
  {
    paramClass = paramaal.a(paramClass, paramru, this.f);
    if (paramaal != paramClass.b) {
      this.d = paramClass.b;
    }
    return paramClass.a;
  }
  
  public void a(ru paramru)
    throws qw
  {
    if ((this.a) && (this.c == null)) {
      this.c = paramru.a(this.b, this.f);
    }
  }
  
  public void a(Object[] paramArrayOfObject, or paramor, ru paramru)
    throws IOException, oq
  {
    int k = paramArrayOfObject.length;
    if (k == 0) {
      return;
    }
    if (this.c != null)
    {
      a(paramArrayOfObject, paramor, paramru, this.c);
      return;
    }
    if (this.e != null)
    {
      b(paramArrayOfObject, paramor, paramru);
      return;
    }
    int j = 0;
    int i = 0;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localaal = this.d;
        if (i >= k) {
          break;
        }
        localObject2 = paramArrayOfObject[i];
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          j = i;
          paramru.a(paramor);
          break label271;
        }
        localObject1 = localObject2;
        j = i;
        localClass = localObject2.getClass();
        localObject1 = localObject2;
        j = i;
        ra localra2 = localaal.a(localClass);
        localra1 = localra2;
        if (localra2 == null)
        {
          localObject1 = localObject2;
          j = i;
          if (!this.b.e()) {
            continue;
          }
          localObject1 = localObject2;
          j = i;
          localra1 = a(localaal, paramru.a(this.b, localClass), paramru);
        }
      }
      catch (IOException paramArrayOfObject)
      {
        aal localaal;
        Object localObject2;
        Class localClass;
        throw paramArrayOfObject;
        localObject1 = localObject2;
        j = i;
        ra localra1 = a(localaal, localClass, paramru);
        continue;
        if ((!(paramArrayOfObject instanceof InvocationTargetException)) || (paramArrayOfObject.getCause() == null)) {
          continue;
        }
        paramArrayOfObject = paramArrayOfObject.getCause();
        continue;
        if (!(paramArrayOfObject instanceof Error)) {
          continue;
        }
        throw ((Error)paramArrayOfObject);
        throw qw.a(paramArrayOfObject, localObject1, j);
      }
      catch (Exception paramArrayOfObject)
      {
        continue;
      }
      localObject1 = localObject2;
      j = i;
      localra1.a(localObject2, paramor, paramru);
      label271:
      i += 1;
    }
  }
  
  public void a(Object[] paramArrayOfObject, or paramor, ru paramru, ra<Object> paramra)
    throws IOException, oq
  {
    int j = paramArrayOfObject.length;
    rx localrx = this.e;
    int i = 0;
    for (;;)
    {
      Object localObject;
      if (i < j)
      {
        localObject = paramArrayOfObject[i];
        if (localObject == null) {}
        try
        {
          paramru.a(paramor);
        }
        catch (IOException paramArrayOfObject)
        {
          throw paramArrayOfObject;
          paramra.a(localObject, paramor, paramru, localrx);
        }
        catch (Exception paramArrayOfObject)
        {
          while (((paramArrayOfObject instanceof InvocationTargetException)) && (paramArrayOfObject.getCause() != null)) {
            paramArrayOfObject = paramArrayOfObject.getCause();
          }
          if (!(paramArrayOfObject instanceof Error)) {
            break label108;
          }
          throw ((Error)paramArrayOfObject);
          throw qw.a(paramArrayOfObject, localObject, i);
        }
        if (localrx == null)
        {
          paramra.a(localObject, paramor, paramru);
          break label118;
        }
      }
      label108:
      return;
      label118:
      i += 1;
    }
  }
  
  public void b(Object[] paramArrayOfObject, or paramor, ru paramru)
    throws IOException, oq
  {
    int k = paramArrayOfObject.length;
    rx localrx = this.e;
    int j = 0;
    int i = 0;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        aal localaal = this.d;
        if (i < k)
        {
          Object localObject2 = paramArrayOfObject[i];
          if (localObject2 == null)
          {
            localObject1 = localObject2;
            j = i;
            paramru.a(paramor);
          }
          else
          {
            localObject1 = localObject2;
            j = i;
            Class localClass = localObject2.getClass();
            localObject1 = localObject2;
            j = i;
            ra localra2 = localaal.a(localClass);
            ra localra1 = localra2;
            if (localra2 == null)
            {
              localObject1 = localObject2;
              j = i;
              localra1 = a(localaal, localClass, paramru);
            }
            localObject1 = localObject2;
            j = i;
            localra1.a(localObject2, paramor, paramru, localrx);
          }
        }
      }
      catch (IOException paramArrayOfObject)
      {
        throw paramArrayOfObject;
        if (((paramArrayOfObject instanceof InvocationTargetException)) && (paramArrayOfObject.getCause() != null))
        {
          paramArrayOfObject = paramArrayOfObject.getCause();
          continue;
        }
        if ((paramArrayOfObject instanceof Error)) {
          throw ((Error)paramArrayOfObject);
        }
        throw qw.a(paramArrayOfObject, localObject1, j);
        return;
      }
      catch (Exception paramArrayOfObject)
      {
        continue;
      }
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/abo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */