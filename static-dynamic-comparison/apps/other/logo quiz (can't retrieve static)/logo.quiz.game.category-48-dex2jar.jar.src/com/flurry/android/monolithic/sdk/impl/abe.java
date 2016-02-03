package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

@rz
public class abe
  extends abc<EnumMap<? extends Enum<?>, ?>>
  implements rp
{
  protected final boolean a;
  protected final aee b;
  protected final afm c;
  protected final qc d;
  protected ra<Object> e;
  protected final rx f;
  
  public abe(afm paramafm, boolean paramBoolean, aee paramaee, rx paramrx, qc paramqc, ra<Object> paramra)
  {
    super(EnumMap.class, false);
    if (!paramBoolean)
    {
      paramBoolean = bool;
      if (paramafm != null)
      {
        paramBoolean = bool;
        if (!paramafm.u()) {}
      }
    }
    else
    {
      paramBoolean = true;
    }
    this.a = paramBoolean;
    this.c = paramafm;
    this.b = paramaee;
    this.f = paramrx;
    this.d = paramqc;
    this.e = paramra;
  }
  
  public abc<?> a(rx paramrx)
  {
    return new abe(this.c, this.a, this.b, paramrx, this.d, this.e);
  }
  
  public void a(ru paramru)
    throws qw
  {
    if ((this.a) && (this.e == null)) {
      this.e = paramru.a(this.c, this.d);
    }
  }
  
  public void a(EnumMap<? extends Enum<?>, ?> paramEnumMap, or paramor, ru paramru)
    throws IOException, oq
  {
    paramor.d();
    if (!paramEnumMap.isEmpty()) {
      b(paramEnumMap, paramor, paramru);
    }
    paramor.e();
  }
  
  protected void a(EnumMap<? extends Enum<?>, ?> paramEnumMap, or paramor, ru paramru, ra<Object> paramra)
    throws IOException, oq
  {
    Object localObject2 = this.b;
    Iterator localIterator = paramEnumMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Enum localEnum = (Enum)localEntry.getKey();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = ((abf)paramru.a(localEnum.getDeclaringClass(), this.d)).d();
      }
      paramor.a(((aee)localObject1).a(localEnum));
      localObject2 = localEntry.getValue();
      if (localObject2 == null)
      {
        paramru.a(paramor);
        localObject2 = localObject1;
      }
      else
      {
        try
        {
          paramra.a(localObject2, paramor, paramru);
          localObject2 = localObject1;
        }
        catch (Exception localException)
        {
          a(paramru, localException, paramEnumMap, ((Enum)localEntry.getKey()).name());
          Object localObject3 = localObject1;
        }
      }
    }
  }
  
  public void a(EnumMap<? extends Enum<?>, ?> paramEnumMap, or paramor, ru paramru, rx paramrx)
    throws IOException, oq
  {
    paramrx.b(paramEnumMap, paramor);
    if (!paramEnumMap.isEmpty()) {
      b(paramEnumMap, paramor, paramru);
    }
    paramrx.e(paramEnumMap, paramor);
  }
  
  protected void b(EnumMap<? extends Enum<?>, ?> paramEnumMap, or paramor, ru paramru)
    throws IOException, oq
  {
    Object localObject2 = null;
    if (this.e != null)
    {
      a(paramEnumMap, paramor, paramru, this.e);
      return;
    }
    aee localaee = this.b;
    Iterator localIterator = paramEnumMap.entrySet().iterator();
    Object localObject1 = null;
    label42:
    Map.Entry localEntry;
    Object localObject3;
    if (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      localObject3 = (Enum)localEntry.getKey();
      if (localaee != null) {
        break label273;
      }
      localaee = ((abf)paramru.a(((Enum)localObject3).getDeclaringClass(), this.d)).d();
    }
    label273:
    for (;;)
    {
      paramor.a(localaee.a((Enum)localObject3));
      Object localObject6 = localEntry.getValue();
      if (localObject6 == null)
      {
        paramru.a(paramor);
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      for (;;)
      {
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break label42;
        break;
        Object localObject5 = localObject6.getClass();
        if (localObject5 == localObject2)
        {
          localObject5 = localObject1;
          localObject3 = localObject1;
          localObject1 = localObject5;
        }
        for (;;)
        {
          try
          {
            ((ra)localObject3).a(localObject6, paramor, paramru);
            localObject3 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject3;
          }
          catch (Exception localException)
          {
            a(paramru, localException, paramEnumMap, ((Enum)localEntry.getKey()).name());
            Object localObject4 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject4;
          }
          localObject3 = paramru.a((Class)localObject5, this.d);
          localObject1 = localObject3;
          localObject2 = localObject5;
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/abe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */