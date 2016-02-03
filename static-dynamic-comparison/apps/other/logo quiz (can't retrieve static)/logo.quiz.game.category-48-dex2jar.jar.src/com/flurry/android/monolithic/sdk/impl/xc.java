package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

@rz
public class xc
  extends vo<Object>
{
  private static final Object[] a = new Object[0];
  
  public xc()
  {
    super(Object.class);
  }
  
  public Object a(ow paramow, qm paramqm)
    throws IOException, oz
  {
    switch (xd.a[paramow.e().ordinal()])
    {
    case 2: 
    case 4: 
    default: 
      throw paramqm.b(Object.class);
    case 1: 
      return c(paramow, paramqm);
    case 3: 
      return b(paramow, paramqm);
    case 5: 
      return c(paramow, paramqm);
    case 6: 
      return paramow.z();
    case 7: 
      return paramow.k();
    case 8: 
      if (paramqm.a(ql.h)) {
        return paramow.v();
      }
      return paramow.p();
    case 9: 
      if (paramqm.a(ql.g)) {
        return paramow.y();
      }
      return Double.valueOf(paramow.x());
    case 10: 
      return Boolean.TRUE;
    case 11: 
      return Boolean.FALSE;
    }
    return null;
  }
  
  public Object a(ow paramow, qm paramqm, rw paramrw)
    throws IOException, oz
  {
    pb localpb = paramow.e();
    switch (xd.a[localpb.ordinal()])
    {
    case 2: 
    case 4: 
    default: 
      throw paramqm.b(Object.class);
    case 1: 
    case 3: 
    case 5: 
      return paramrw.d(paramow, paramqm);
    case 7: 
      return paramow.k();
    case 8: 
      if (paramqm.a(ql.h)) {
        return paramow.v();
      }
      return Integer.valueOf(paramow.t());
    case 9: 
      if (paramqm.a(ql.g)) {
        return paramow.y();
      }
      return Double.valueOf(paramow.x());
    case 10: 
      return Boolean.TRUE;
    case 11: 
      return Boolean.FALSE;
    case 6: 
      return paramow.z();
    }
    return null;
  }
  
  protected Object b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if (paramqm.a(ql.i)) {
      return d(paramow, paramqm);
    }
    if (paramow.b() == pb.e) {
      return new ArrayList(4);
    }
    aeh localaeh = paramqm.g();
    Object localObject2 = localaeh.a();
    int i = 0;
    int j = 0;
    Object localObject3 = a(paramow, paramqm);
    int k = j + 1;
    Object localObject1;
    if (i >= localObject2.length)
    {
      localObject1 = localaeh.a((Object[])localObject2);
      i = 0;
    }
    for (;;)
    {
      int m = i + 1;
      localObject1[i] = localObject3;
      j = k;
      i = m;
      localObject2 = localObject1;
      if (paramow.b() != pb.e) {
        break;
      }
      paramow = new ArrayList(k + (k >> 3) + 1);
      localaeh.a((Object[])localObject1, m, paramow);
      return paramow;
      localObject1 = localObject2;
    }
  }
  
  protected Object c(ow paramow, qm paramqm)
    throws IOException, oz
  {
    Object localObject2 = paramow.e();
    Object localObject1 = localObject2;
    if (localObject2 == pb.b) {
      localObject1 = paramow.b();
    }
    if (localObject1 != pb.f) {
      return new LinkedHashMap(4);
    }
    localObject1 = paramow.k();
    paramow.b();
    localObject2 = a(paramow, paramqm);
    if (paramow.b() != pb.f)
    {
      paramow = new LinkedHashMap(4);
      paramow.put(localObject1, localObject2);
      return paramow;
    }
    String str = paramow.k();
    paramow.b();
    Object localObject3 = a(paramow, paramqm);
    if (paramow.b() != pb.f)
    {
      paramow = new LinkedHashMap(4);
      paramow.put(localObject1, localObject2);
      paramow.put(str, localObject3);
      return paramow;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put(localObject1, localObject2);
    localLinkedHashMap.put(str, localObject3);
    do
    {
      localObject1 = paramow.k();
      paramow.b();
      localLinkedHashMap.put(localObject1, a(paramow, paramqm));
    } while (paramow.b() != pb.c);
    return localLinkedHashMap;
  }
  
  protected Object[] d(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if (paramow.b() == pb.e) {
      return a;
    }
    aeh localaeh = paramqm.g();
    Object localObject1 = localaeh.a();
    int i = 0;
    Object localObject3 = a(paramow, paramqm);
    Object localObject2;
    if (i >= localObject1.length)
    {
      localObject2 = localaeh.a((Object[])localObject1);
      i = 0;
    }
    for (;;)
    {
      int j = i + 1;
      localObject2[i] = localObject3;
      i = j;
      localObject1 = localObject2;
      if (paramow.b() != pb.e) {
        break;
      }
      return localaeh.a((Object[])localObject2, j);
      localObject2 = localObject1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/xc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */