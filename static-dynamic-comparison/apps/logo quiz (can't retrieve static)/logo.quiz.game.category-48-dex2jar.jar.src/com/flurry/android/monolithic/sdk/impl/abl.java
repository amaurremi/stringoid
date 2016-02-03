package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@rz
public class abl
  extends abc<Map<?, ?>>
  implements rp
{
  protected static final afm a = ;
  protected final qc b;
  protected final HashSet<String> c;
  protected final boolean d;
  protected final afm e;
  protected final afm f;
  protected ra<Object> g;
  protected ra<Object> h;
  protected final rx i;
  protected aal j;
  
  protected abl()
  {
    this((HashSet)null, null, null, false, null, null, null, null);
  }
  
  protected abl(HashSet<String> paramHashSet, afm paramafm1, afm paramafm2, boolean paramBoolean, rx paramrx, ra<Object> paramra1, ra<Object> paramra2, qc paramqc)
  {
    super(Map.class, false);
    this.b = paramqc;
    this.c = paramHashSet;
    this.e = paramafm1;
    this.f = paramafm2;
    this.d = paramBoolean;
    this.i = paramrx;
    this.g = paramra1;
    this.h = paramra2;
    this.j = aal.a();
  }
  
  public static abl a(String[] paramArrayOfString, afm paramafm, boolean paramBoolean, rx paramrx, qc paramqc, ra<Object> paramra1, ra<Object> paramra2)
  {
    HashSet localHashSet = a(paramArrayOfString);
    if (paramafm == null)
    {
      paramArrayOfString = a;
      paramafm = paramArrayOfString;
      if (paramBoolean) {
        break label71;
      }
      if ((paramafm == null) || (!paramafm.u())) {
        break label66;
      }
      paramBoolean = true;
    }
    label66:
    label71:
    for (;;)
    {
      return new abl(localHashSet, paramArrayOfString, paramafm, paramBoolean, paramrx, paramra1, paramra2, paramqc);
      paramArrayOfString = paramafm.k();
      paramafm = paramafm.g();
      break;
      paramBoolean = false;
    }
  }
  
  private static HashSet<String> a(String[] paramArrayOfString)
  {
    Object localObject;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      localObject = null;
      return (HashSet<String>)localObject;
    }
    HashSet localHashSet = new HashSet(paramArrayOfString.length);
    int m = paramArrayOfString.length;
    int k = 0;
    for (;;)
    {
      localObject = localHashSet;
      if (k >= m) {
        break;
      }
      localHashSet.add(paramArrayOfString[k]);
      k += 1;
    }
  }
  
  public abc<?> a(rx paramrx)
  {
    paramrx = new abl(this.c, this.e, this.f, this.d, paramrx, this.g, this.h, this.b);
    if (this.h != null) {
      paramrx.h = this.h;
    }
    return paramrx;
  }
  
  protected final ra<Object> a(aal paramaal, afm paramafm, ru paramru)
    throws qw
  {
    paramafm = paramaal.a(paramafm, paramru, this.b);
    if (paramaal != paramafm.b) {
      this.j = paramafm.b;
    }
    return paramafm.a;
  }
  
  protected final ra<Object> a(aal paramaal, Class<?> paramClass, ru paramru)
    throws qw
  {
    paramClass = paramaal.a(paramClass, paramru, this.b);
    if (paramaal != paramClass.b) {
      this.j = paramClass.b;
    }
    return paramClass.a;
  }
  
  public void a(ru paramru)
    throws qw
  {
    if ((this.d) && (this.h == null)) {
      this.h = paramru.a(this.f, this.b);
    }
    if (this.g == null) {
      this.g = paramru.b(this.e, this.b);
    }
  }
  
  public void a(Map<?, ?> paramMap, or paramor, ru paramru)
    throws IOException, oq
  {
    paramor.d();
    if (!paramMap.isEmpty())
    {
      if (this.h == null) {
        break label36;
      }
      a(paramMap, paramor, paramru, this.h);
    }
    for (;;)
    {
      paramor.e();
      return;
      label36:
      b(paramMap, paramor, paramru);
    }
  }
  
  protected void a(Map<?, ?> paramMap, or paramor, ru paramru, ra<Object> paramra)
    throws IOException, oq
  {
    ra localra = this.g;
    HashSet localHashSet = this.c;
    rx localrx = this.i;
    int k;
    Iterator localIterator;
    if (!paramru.a(rr.v))
    {
      k = 1;
      localIterator = paramMap.entrySet().iterator();
    }
    for (;;)
    {
      label44:
      if (!localIterator.hasNext()) {
        return;
      }
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = ((Map.Entry)localObject2).getValue();
      localObject2 = ((Map.Entry)localObject2).getKey();
      if (localObject2 == null) {
        paramru.c().a(null, paramor, paramru);
      }
      for (;;)
      {
        if (localObject1 != null) {
          break label155;
        }
        paramru.a(paramor);
        break label44;
        k = 0;
        break;
        if (((k != 0) && (localObject1 == null)) || ((localHashSet != null) && (localHashSet.contains(localObject2)))) {
          break label44;
        }
        localra.a(localObject2, paramor, paramru);
      }
      label155:
      if (localrx == null) {
        try
        {
          paramra.a(localObject1, paramor, paramru);
        }
        catch (Exception localException)
        {
          a(paramru, localException, paramMap, "" + localObject2);
        }
      } else {
        paramra.a(localException, paramor, paramru, localrx);
      }
    }
  }
  
  public void a(Map<?, ?> paramMap, or paramor, ru paramru, rx paramrx)
    throws IOException, oq
  {
    paramrx.b(paramMap, paramor);
    if (!paramMap.isEmpty())
    {
      if (this.h == null) {
        break label42;
      }
      a(paramMap, paramor, paramru, this.h);
    }
    for (;;)
    {
      paramrx.e(paramMap, paramor);
      return;
      label42:
      b(paramMap, paramor, paramru);
    }
  }
  
  public void b(Map<?, ?> paramMap, or paramor, ru paramru)
    throws IOException, oq
  {
    label14:
    ra localra;
    HashSet localHashSet;
    int k;
    label40:
    Object localObject1;
    Iterator localIterator;
    if (this.i != null)
    {
      c(paramMap, paramor, paramru);
      return;
    }
    else
    {
      localra = this.g;
      localHashSet = this.c;
      if (paramru.a(rr.v)) {
        break label127;
      }
      k = 1;
      localObject1 = this.j;
      localIterator = paramMap.entrySet().iterator();
    }
    label59:
    Object localObject4;
    Object localObject5;
    if (localIterator.hasNext())
    {
      localObject2 = (Map.Entry)localIterator.next();
      localObject4 = ((Map.Entry)localObject2).getValue();
      localObject5 = ((Map.Entry)localObject2).getKey();
      if (localObject5 != null) {
        break label133;
      }
      paramru.c().a(null, paramor, paramru);
    }
    for (;;)
    {
      if (localObject4 != null) {
        break label170;
      }
      paramru.a(paramor);
      break label59;
      break label14;
      label127:
      k = 0;
      break label40;
      label133:
      if (((k != 0) && (localObject4 == null)) || ((localHashSet != null) && (localHashSet.contains(localObject5)))) {
        break;
      }
      localra.a(localObject5, paramor, paramru);
    }
    label170:
    Object localObject3 = localObject4.getClass();
    Object localObject2 = ((aal)localObject1).a((Class)localObject3);
    if (localObject2 == null) {
      if (this.f.e())
      {
        localObject1 = a((aal)localObject1, paramru.a(this.f, (Class)localObject3), paramru);
        label220:
        localObject3 = this.j;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      try
      {
        ((ra)localObject2).a(localObject4, paramor, paramru);
      }
      catch (Exception localException)
      {
        a(paramru, localException, paramMap, "" + localObject5);
      }
      break;
      localObject1 = a((aal)localObject1, (Class)localObject3, paramru);
      break label220;
    }
  }
  
  protected void c(Map<?, ?> paramMap, or paramor, ru paramru)
    throws IOException, oq
  {
    ra localra2 = this.g;
    HashSet localHashSet = this.c;
    int k;
    Object localObject2;
    Object localObject1;
    label44:
    Object localObject3;
    Object localObject5;
    Object localObject6;
    if (!paramru.a(rr.v))
    {
      k = 1;
      Iterator localIterator = paramMap.entrySet().iterator();
      localObject2 = null;
      localObject1 = null;
      if (!localIterator.hasNext()) {
        return;
      }
      localObject3 = (Map.Entry)localIterator.next();
      localObject5 = ((Map.Entry)localObject3).getValue();
      localObject6 = ((Map.Entry)localObject3).getKey();
      if (localObject6 != null) {
        break label118;
      }
      paramru.c().a(null, paramor, paramru);
    }
    for (;;)
    {
      if (localObject5 != null) {
        break label155;
      }
      paramru.a(paramor);
      break label44;
      k = 0;
      break;
      label118:
      if (((k != 0) && (localObject5 == null)) || ((localHashSet != null) && (localHashSet.contains(localObject6)))) {
        break label44;
      }
      localra2.a(localObject6, paramor, paramru);
    }
    label155:
    Object localObject4 = localObject5.getClass();
    if (localObject4 == localObject2)
    {
      localObject4 = localObject1;
      localObject3 = localObject1;
      localObject1 = localObject4;
    }
    for (;;)
    {
      try
      {
        ((ra)localObject3).a(localObject5, paramor, paramru, this.i);
      }
      catch (Exception localException)
      {
        a(paramru, localException, paramMap, "" + localObject6);
      }
      break;
      ra localra1 = paramru.a((Class)localObject4, this.b);
      localObject1 = localra1;
      localObject2 = localObject4;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/abl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */