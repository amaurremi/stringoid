package com.flurry.android.monolithic.sdk.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ml
  extends nk
{
  private static md a = new md().a(32);
  
  private static mq a(List<String> paramList1, List<String> paramList2)
  {
    Object[] arrayOfObject = new Object[paramList1.size()];
    int i = 0;
    if (i < arrayOfObject.length)
    {
      int j = paramList2.indexOf(paramList1.get(i));
      if (j == -1) {}
      for (Object localObject = "No match for " + (String)paramList1.get(i);; localObject = new Integer(j))
      {
        arrayOfObject[i] = localObject;
        i += 1;
        break;
      }
    }
    return new mu(paramList2.size(), arrayOfObject);
  }
  
  public static void a(mc parammc, ji paramji, ou paramou)
    throws IOException
  {
    Object localObject2;
    Object localObject1;
    int i;
    switch (mm.a[paramji.a().ordinal()])
    {
    default: 
      return;
    case 13: 
      localObject2 = paramji.b().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        js localjs = (js)((Iterator)localObject2).next();
        String str = localjs.a();
        localObject1 = paramou.a(str);
        paramji = (ji)localObject1;
        if (localObject1 == null) {
          paramji = localjs.e();
        }
        if (paramji == null) {
          throw new jh("No default value for: " + str);
        }
        a(parammc, localjs.c(), paramji);
      }
    case 10: 
      parammc.a(paramji.c(paramou.h()));
      return;
    case 11: 
      parammc.b();
      parammc.a(paramou.o());
      paramji = paramji.i();
      paramou = paramou.iterator();
      while (paramou.hasNext())
      {
        localObject1 = (ou)paramou.next();
        parammc.c();
        a(parammc, paramji, (ou)localObject1);
      }
      parammc.d();
      return;
    case 12: 
      parammc.e();
      parammc.a(paramou.o());
      paramji = paramji.j();
      localObject1 = paramou.q();
      while (((Iterator)localObject1).hasNext())
      {
        parammc.c();
        localObject2 = (String)((Iterator)localObject1).next();
        parammc.a((String)localObject2);
        a(parammc, paramji, paramou.a((String)localObject2));
      }
      parammc.f();
      return;
    case 14: 
      parammc.b(0);
      a(parammc, (ji)paramji.k().get(0), paramou);
      return;
    case 9: 
      if (!paramou.e()) {
        throw new jh("Non-string default value for fixed: " + paramou);
      }
      paramou = paramou.h().getBytes("ISO-8859-1");
      if (paramou.length != paramji.l())
      {
        localObject1 = new byte[paramji.l()];
        if (paramji.l() > paramou.length)
        {
          i = paramou.length;
          System.arraycopy(paramou, 0, localObject1, 0, i);
        }
      }
      break;
    }
    for (paramji = (ji)localObject1;; paramji = paramou)
    {
      parammc.b(paramji);
      return;
      i = paramji.l();
      break;
      if (!paramou.e()) {
        throw new jh("Non-string default value for string: " + paramou);
      }
      parammc.a(paramou.h());
      return;
      if (!paramou.e()) {
        throw new jh("Non-string default value for bytes: " + paramou);
      }
      parammc.a(paramou.h().getBytes("ISO-8859-1"));
      return;
      if (!paramou.c()) {
        throw new jh("Non-numeric default value for int: " + paramou);
      }
      parammc.c(paramou.j());
      return;
      if (!paramou.c()) {
        throw new jh("Non-numeric default value for long: " + paramou);
      }
      parammc.b(paramou.k());
      return;
      if (!paramou.c()) {
        throw new jh("Non-numeric default value for float: " + paramou);
      }
      parammc.a((float)paramou.l());
      return;
      if (!paramou.c()) {
        throw new jh("Non-numeric default value for double: " + paramou);
      }
      parammc.a(paramou.l());
      return;
      if (!paramou.f()) {
        throw new jh("Non-boolean default for boolean: " + paramou);
      }
      parammc.a(paramou.i());
      return;
      if (!paramou.g()) {
        throw new jh("Non-null default value for null type: " + paramou);
      }
      parammc.a();
      return;
    }
  }
  
  private static byte[] a(ji paramji, ou paramou)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    lr locallr = a.a(localByteArrayOutputStream, null);
    a(locallr, paramji, paramou);
    locallr.flush();
    return localByteArrayOutputStream.toByteArray();
  }
  
  private static int b(ji paramji1, ji paramji2)
  {
    int j = 0;
    kj localkj = paramji2.a();
    Iterator localIterator = paramji1.k().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (ji)localIterator.next();
      if (localkj == ((ji)localObject).a()) {
        if ((localkj == kj.a) || (localkj == kj.b) || (localkj == kj.f))
        {
          String str = paramji2.g();
          localObject = ((ji)localObject).g();
          if (((str == null) || (!str.equals(localObject))) && ((str != localObject) || (localkj != kj.a))) {}
        }
        else
        {
          return i;
        }
      }
      i += 1;
    }
    paramji1 = paramji1.k().iterator();
    i = j;
    if (paramji1.hasNext())
    {
      paramji2 = (ji)paramji1.next();
      switch (mm.a[localkj.ordinal()])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        switch (mm.a[paramji2.a().ordinal()])
        {
        case 5: 
        default: 
          break;
        case 4: 
        case 6: 
          return i;
          switch (mm.a[paramji2.a().ordinal()])
          {
          }
          break;
        }
      }
      return i;
    }
    return -1;
  }
  
  private mq b(ji paramji1, ji paramji2, Map<nm, mq> paramMap)
    throws IOException
  {
    Object localObject = paramji1.k();
    int i = ((List)localObject).size();
    paramji1 = new mq[i];
    String[] arrayOfString = new String[i];
    localObject = ((List)localObject).iterator();
    i = 0;
    while (((Iterator)localObject).hasNext())
    {
      ji localji = (ji)((Iterator)localObject).next();
      paramji1[i] = a(localji, paramji2, paramMap);
      arrayOfString[i] = localji.g();
      i += 1;
    }
    return mq.b(new mq[] { mq.a(paramji1, arrayOfString), new nj() });
  }
  
  private mq c(ji paramji1, ji paramji2, Map<nm, mq> paramMap)
    throws IOException
  {
    Object localObject3 = new mn(paramji1, paramji2);
    Object localObject2 = (mq)paramMap.get(localObject3);
    Object localObject1 = localObject2;
    Object localObject5;
    Object localObject4;
    int k;
    int i;
    js localjs;
    int j;
    if (localObject2 == null)
    {
      localObject5 = paramji1.b();
      localObject1 = paramji2.b();
      localObject4 = new js[((List)localObject1).size()];
      k = ((List)localObject5).size();
      localObject2 = ((List)localObject5).iterator();
      i = 0;
      if (((Iterator)localObject2).hasNext())
      {
        localjs = paramji2.b(((js)((Iterator)localObject2).next()).a());
        if (localjs == null) {
          break label577;
        }
        j = i + 1;
        localObject4[i] = localjs;
        i = j;
      }
    }
    label562:
    label577:
    for (;;)
    {
      break;
      localObject2 = ((List)localObject1).iterator();
      j = k + 1;
      if (((Iterator)localObject2).hasNext())
      {
        localjs = (js)((Iterator)localObject2).next();
        if (paramji1.b(localjs.a()) != null) {
          break label562;
        }
        if (localjs.e() == null)
        {
          localObject1 = mq.a("Found " + paramji1.a(true) + ", expecting " + paramji2.a(true));
          paramMap.put(localObject3, localObject1);
          return (mq)localObject1;
        }
        localObject4[i] = localjs;
        k = j + 3;
        j = i + 1;
        i = k;
      }
      for (;;)
      {
        k = j;
        j = i;
        i = k;
        break;
        localObject2 = new mq[j];
        i = j - 1;
        localObject2[i] = new mw((js[])localObject4);
        localObject4 = mq.b((mq[])localObject2);
        paramMap.put(localObject3, localObject4);
        localObject3 = ((List)localObject5).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject5 = (js)((Iterator)localObject3).next();
          localjs = paramji2.b(((js)localObject5).a());
          if (localjs == null)
          {
            i -= 1;
            localObject2[i] = new ng(a(((js)localObject5).c(), ((js)localObject5).c(), paramMap));
          }
          for (;;)
          {
            break;
            i -= 1;
            localObject2[i] = a(((js)localObject5).c(), localjs.c(), paramMap);
          }
        }
        paramji2 = ((List)localObject1).iterator();
        while (paramji2.hasNext())
        {
          localObject1 = (js)paramji2.next();
          if (paramji1.b(((js)localObject1).a()) == null)
          {
            localObject3 = a(((js)localObject1).c(), ((js)localObject1).e());
            i -= 1;
            localObject2[i] = new mt((byte[])localObject3);
            i -= 1;
            localObject2[i] = a(((js)localObject1).c(), ((js)localObject1).c(), paramMap);
            i -= 1;
            localObject2[i] = mq.x;
          }
        }
        return (mq)localObject4;
        k = i;
        i = j;
        j = k;
      }
    }
  }
  
  public final mq a(ji paramji1, ji paramji2)
    throws IOException
  {
    return mq.a(new mq[] { a(paramji1, paramji2, new HashMap()) });
  }
  
  public mq a(ji paramji1, ji paramji2, Map<nm, mq> paramMap)
    throws IOException
  {
    kj localkj1 = paramji1.a();
    kj localkj2 = paramji2.a();
    if (localkj1 == localkj2)
    {
      switch (mm.a[localkj1.ordinal()])
      {
      default: 
        throw new jh("Unkown type for schema: " + localkj1);
      case 1: 
        return mq.c;
      case 2: 
        return mq.d;
      case 3: 
        return mq.e;
      case 4: 
        return mq.f;
      case 5: 
        return mq.g;
      case 6: 
        return mq.h;
      case 7: 
        return mq.i;
      case 8: 
        return mq.j;
      case 9: 
        if ((!paramji1.g().equals(paramji2.g())) || (paramji1.l() != paramji2.l())) {
          break;
        }
        return mq.b(new mq[] { new mz(paramji1.l()), mq.k });
      case 10: 
        if ((paramji1.g() != null) && (!paramji1.g().equals(paramji2.g()))) {
          break;
        }
        return mq.b(new mq[] { a(paramji1.c(), paramji2.c()), mq.l });
      case 11: 
        return mq.b(new mq[] { mq.a(mq.o, new mq[] { a(paramji1.i(), paramji2.i(), paramMap) }), mq.n });
      case 12: 
        return mq.b(new mq[] { mq.a(mq.q, new mq[] { a(paramji1.j(), paramji2.j(), paramMap), mq.i }), mq.p });
      case 13: 
        return c(paramji1, paramji2, paramMap);
      case 14: 
        return b(paramji1, paramji2, paramMap);
      }
    }
    else
    {
      if (localkj1 == kj.e) {
        return b(paramji1, paramji2, paramMap);
      }
      switch (mm.a[localkj2.ordinal()])
      {
      case 9: 
      default: 
        throw new RuntimeException("Unexpected schema type: " + localkj2);
      case 4: 
        switch (mm.a[localkj1.ordinal()])
        {
        }
        break;
      }
    }
    int i;
    do
    {
      for (;;)
      {
        return mq.a("Found " + paramji1.a(true) + ", expecting " + paramji2.a(true));
        return mq.a(super.a(paramji1, paramMap), mq.f);
        switch (mm.a[localkj1.ordinal()])
        {
        default: 
          break;
        case 3: 
        case 4: 
          return mq.a(super.a(paramji1, paramMap), mq.g);
          switch (mm.a[localkj1.ordinal()])
          {
          }
          break;
        }
      }
      return mq.a(super.a(paramji1, paramMap), mq.h);
      i = b(paramji2, paramji1);
    } while (i < 0);
    return mq.b(new mq[] { new ni(i, a(paramji1, (ji)paramji2.k().get(i), paramMap)), mq.m });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ml.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */