package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.b;
import com.google.android.gms.internal.c.b;
import com.google.android.gms.internal.c.e;
import com.google.android.gms.internal.c.f;
import com.google.android.gms.internal.c.g;
import com.google.android.gms.internal.c.h;
import com.google.android.gms.internal.d.a;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class cq
{
  private static d.a a(int paramInt, c.f paramf, d.a[] paramArrayOfa, Set<Integer> paramSet)
  {
    int k = 0;
    int m = 0;
    int j = 0;
    if (paramSet.contains(Integer.valueOf(paramInt))) {
      a("Value cycle detected.  Current value reference: " + paramInt + "." + "  Previous value references: " + paramSet + ".");
    }
    d.a locala1 = (d.a)a(paramf.eX, paramInt, "values");
    if (paramArrayOfa[paramInt] != null) {
      return paramArrayOfa[paramInt];
    }
    Object localObject = null;
    paramSet.add(Integer.valueOf(paramInt));
    switch (locala1.type)
    {
    }
    for (;;)
    {
      if (localObject == null) {
        a("Invalid value: " + locala1);
      }
      paramArrayOfa[paramInt] = localObject;
      paramSet.remove(Integer.valueOf(paramInt));
      return (d.a)localObject;
      localObject = b(locala1);
      d.a locala2 = a(locala1);
      locala2.fO = new d.a[((c.h)localObject).fz.length];
      int[] arrayOfInt = ((c.h)localObject).fz;
      k = arrayOfInt.length;
      int i = 0;
      for (;;)
      {
        localObject = locala2;
        if (j >= k) {
          break;
        }
        m = arrayOfInt[j];
        locala2.fO[i] = a(m, paramf, paramArrayOfa, paramSet);
        j += 1;
        i += 1;
      }
      locala2 = a(locala1);
      localObject = b(locala1);
      if (((c.h)localObject).fA.length != ((c.h)localObject).fB.length) {
        a("Uneven map keys (" + ((c.h)localObject).fA.length + ") and map values (" + ((c.h)localObject).fB.length + ")");
      }
      locala2.fP = new d.a[((c.h)localObject).fA.length];
      locala2.fQ = new d.a[((c.h)localObject).fA.length];
      arrayOfInt = ((c.h)localObject).fA;
      m = arrayOfInt.length;
      j = 0;
      i = 0;
      while (j < m)
      {
        int n = arrayOfInt[j];
        locala2.fP[i] = a(n, paramf, paramArrayOfa, paramSet);
        j += 1;
        i += 1;
      }
      arrayOfInt = ((c.h)localObject).fB;
      m = arrayOfInt.length;
      i = 0;
      j = k;
      for (;;)
      {
        localObject = locala2;
        if (j >= m) {
          break;
        }
        k = arrayOfInt[j];
        locala2.fQ[i] = a(k, paramf, paramArrayOfa, paramSet);
        j += 1;
        i += 1;
      }
      localObject = a(locala1);
      ((d.a)localObject).fR = de.a(a(b(locala1).fE, paramf, paramArrayOfa, paramSet));
      continue;
      locala2 = a(locala1);
      localObject = b(locala1);
      locala2.fV = new d.a[((c.h)localObject).fD.length];
      arrayOfInt = ((c.h)localObject).fD;
      k = arrayOfInt.length;
      i = 0;
      j = m;
      for (;;)
      {
        localObject = locala2;
        if (j >= k) {
          break;
        }
        m = arrayOfInt[j];
        locala2.fV[i] = a(m, paramf, paramArrayOfa, paramSet);
        j += 1;
        i += 1;
      }
      localObject = locala1;
    }
  }
  
  public static d.a a(d.a parama)
  {
    d.a locala = new d.a();
    locala.type = parama.type;
    locala.fW = ((int[])parama.fW.clone());
    if (parama.fX) {
      locala.fX = parama.fX;
    }
    return locala;
  }
  
  private static cq.a a(c.b paramb, c.f paramf, d.a[] paramArrayOfa, int paramInt)
  {
    cq.b localb = cq.a.mn();
    paramb = paramb.eH;
    int i = paramb.length;
    paramInt = 0;
    if (paramInt < i)
    {
      int j = paramb[paramInt];
      Object localObject = (c.e)a(paramf.eY, Integer.valueOf(j).intValue(), "properties");
      String str = (String)a(paramf.eW, ((c.e)localObject).key, "keys");
      localObject = (d.a)a(paramArrayOfa, ((c.e)localObject).value, "values");
      if (b.dB.toString().equals(str)) {
        localb.i((d.a)localObject);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        localb.b(str, (d.a)localObject);
      }
    }
    return localb.mq();
  }
  
  public static cq.c a(c.f paramf)
  {
    int j = 0;
    Object localObject = new d.a[paramf.eX.length];
    int i = 0;
    while (i < paramf.eX.length)
    {
      a(i, paramf, (d.a[])localObject, new HashSet(0));
      i += 1;
    }
    cq.d locald = cq.c.mr();
    ArrayList localArrayList1 = new ArrayList();
    i = 0;
    while (i < paramf.fa.length)
    {
      localArrayList1.add(a(paramf.fa[i], paramf, (d.a[])localObject, i));
      i += 1;
    }
    ArrayList localArrayList2 = new ArrayList();
    i = 0;
    while (i < paramf.fb.length)
    {
      localArrayList2.add(a(paramf.fb[i], paramf, (d.a[])localObject, i));
      i += 1;
    }
    ArrayList localArrayList3 = new ArrayList();
    i = 0;
    while (i < paramf.eZ.length)
    {
      cq.a locala = a(paramf.eZ[i], paramf, (d.a[])localObject, i);
      locald.a(locala);
      localArrayList3.add(locala);
      i += 1;
    }
    localObject = paramf.fc;
    int k = localObject.length;
    i = j;
    while (i < k)
    {
      locald.a(a(localObject[i], localArrayList1, localArrayList3, localArrayList2, paramf));
      i += 1;
    }
    locald.ce(paramf.fg);
    locald.du(paramf.fl);
    return locald.mu();
  }
  
  private static cq.e a(c.g paramg, List<cq.a> paramList1, List<cq.a> paramList2, List<cq.a> paramList3, c.f paramf)
  {
    cq.f localf = cq.e.mv();
    int[] arrayOfInt = paramg.fn;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localf.b((cq.a)paramList3.get(Integer.valueOf(arrayOfInt[i]).intValue()));
      i += 1;
    }
    arrayOfInt = paramg.fo;
    j = arrayOfInt.length;
    i = 0;
    while (i < j)
    {
      localf.c((cq.a)paramList3.get(Integer.valueOf(arrayOfInt[i]).intValue()));
      i += 1;
    }
    paramList3 = paramg.fp;
    j = paramList3.length;
    i = 0;
    while (i < j)
    {
      localf.d((cq.a)paramList1.get(Integer.valueOf(paramList3[i]).intValue()));
      i += 1;
    }
    paramList3 = paramg.fr;
    j = paramList3.length;
    i = 0;
    int k;
    while (i < j)
    {
      k = paramList3[i];
      localf.cf(paramf.eX[Integer.valueOf(k).intValue()].fN);
      i += 1;
    }
    paramList3 = paramg.fq;
    j = paramList3.length;
    i = 0;
    while (i < j)
    {
      localf.e((cq.a)paramList1.get(Integer.valueOf(paramList3[i]).intValue()));
      i += 1;
    }
    paramList1 = paramg.fs;
    j = paramList1.length;
    i = 0;
    while (i < j)
    {
      k = paramList1[i];
      localf.cg(paramf.eX[Integer.valueOf(k).intValue()].fN);
      i += 1;
    }
    paramList1 = paramg.ft;
    j = paramList1.length;
    i = 0;
    while (i < j)
    {
      localf.f((cq.a)paramList2.get(Integer.valueOf(paramList1[i]).intValue()));
      i += 1;
    }
    paramList1 = paramg.fv;
    j = paramList1.length;
    i = 0;
    while (i < j)
    {
      k = paramList1[i];
      localf.ch(paramf.eX[Integer.valueOf(k).intValue()].fN);
      i += 1;
    }
    paramList1 = paramg.fu;
    j = paramList1.length;
    i = 0;
    while (i < j)
    {
      localf.g((cq.a)paramList2.get(Integer.valueOf(paramList1[i]).intValue()));
      i += 1;
    }
    paramg = paramg.fw;
    j = paramg.length;
    i = 0;
    while (i < j)
    {
      k = paramg[i];
      localf.ci(paramf.eX[Integer.valueOf(k).intValue()].fN);
      i += 1;
    }
    return localf.mG();
  }
  
  private static <T> T a(T[] paramArrayOfT, int paramInt, String paramString)
  {
    if ((paramInt < 0) || (paramInt >= paramArrayOfT.length)) {
      a("Index out of bounds detected: " + paramInt + " in " + paramString);
    }
    return paramArrayOfT[paramInt];
  }
  
  public static void a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        return;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  private static void a(String paramString)
  {
    as.a(paramString);
    throw new cq.g(paramString);
  }
  
  private static c.h b(d.a parama)
  {
    if ((c.h)parama.a(c.h.fx) == null) {
      a("Expected a ServingValue and didn't get one. Value is: " + parama);
    }
    return (c.h)parama.a(c.h.fx);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */