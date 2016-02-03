package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.b;
import com.google.android.gms.internal.c.b;
import com.google.android.gms.internal.c.e;
import com.google.android.gms.internal.c.f;
import com.google.android.gms.internal.c.g;
import com.google.android.gms.internal.c.h;
import com.google.android.gms.internal.d.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class cq
{
  private static d.a a(int paramInt, c.f paramf, d.a[] paramArrayOfa, Set<Integer> paramSet)
    throws cq.g
  {
    int k = 0;
    int m = 0;
    int j = 0;
    if (paramSet.contains(Integer.valueOf(paramInt))) {
      cd("Value cycle detected.  Current value reference: " + paramInt + "." + "  Previous value references: " + paramSet + ".");
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
        cd("Invalid value: " + locala1);
      }
      paramArrayOfa[paramInt] = localObject;
      paramSet.remove(Integer.valueOf(paramInt));
      return (d.a)localObject;
      localObject = h(locala1);
      d.a locala2 = g(locala1);
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
      locala2 = g(locala1);
      localObject = h(locala1);
      if (((c.h)localObject).fA.length != ((c.h)localObject).fB.length) {
        cd("Uneven map keys (" + ((c.h)localObject).fA.length + ") and map values (" + ((c.h)localObject).fB.length + ")");
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
      localObject = g(locala1);
      ((d.a)localObject).fR = dh.j(a(h(locala1).fE, paramf, paramArrayOfa, paramSet));
      continue;
      locala2 = g(locala1);
      localObject = h(locala1);
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
  
  private static a a(c.b paramb, c.f paramf, d.a[] paramArrayOfa, int paramInt)
    throws cq.g
  {
    b localb = a.mi();
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
    return localb.ml();
  }
  
  private static e a(c.g paramg, List<a> paramList1, List<a> paramList2, List<a> paramList3, c.f paramf)
  {
    f localf = e.mq();
    int[] arrayOfInt = paramg.fn;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localf.b((a)paramList3.get(Integer.valueOf(arrayOfInt[i]).intValue()));
      i += 1;
    }
    arrayOfInt = paramg.fo;
    j = arrayOfInt.length;
    i = 0;
    while (i < j)
    {
      localf.c((a)paramList3.get(Integer.valueOf(arrayOfInt[i]).intValue()));
      i += 1;
    }
    paramList3 = paramg.fp;
    j = paramList3.length;
    i = 0;
    while (i < j)
    {
      localf.d((a)paramList1.get(Integer.valueOf(paramList3[i]).intValue()));
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
      localf.e((a)paramList1.get(Integer.valueOf(paramList3[i]).intValue()));
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
      localf.f((a)paramList2.get(Integer.valueOf(paramList1[i]).intValue()));
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
      localf.g((a)paramList2.get(Integer.valueOf(paramList1[i]).intValue()));
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
    return localf.mB();
  }
  
  private static <T> T a(T[] paramArrayOfT, int paramInt, String paramString)
    throws cq.g
  {
    if ((paramInt < 0) || (paramInt >= paramArrayOfT.length)) {
      cd("Index out of bounds detected: " + paramInt + " in " + paramString);
    }
    return paramArrayOfT[paramInt];
  }
  
  public static c b(c.f paramf)
    throws cq.g
  {
    int j = 0;
    Object localObject = new d.a[paramf.eX.length];
    int i = 0;
    while (i < paramf.eX.length)
    {
      a(i, paramf, (d.a[])localObject, new HashSet(0));
      i += 1;
    }
    d locald = c.mm();
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
      a locala = a(paramf.eZ[i], paramf, (d.a[])localObject, i);
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
    return locald.mp();
  }
  
  public static void b(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
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
  
  private static void cd(String paramString)
    throws cq.g
  {
    bh.A(paramString);
    throw new g(paramString);
  }
  
  public static d.a g(d.a parama)
  {
    d.a locala = new d.a();
    locala.type = parama.type;
    locala.fW = ((int[])parama.fW.clone());
    if (parama.fX) {
      locala.fX = parama.fX;
    }
    return locala;
  }
  
  private static c.h h(d.a parama)
    throws cq.g
  {
    if ((c.h)parama.a(c.h.fx) == null) {
      cd("Expected a ServingValue and didn't get one. Value is: " + parama);
    }
    return (c.h)parama.a(c.h.fx);
  }
  
  public static class a
  {
    private final Map<String, d.a> agU;
    private final d.a agV;
    
    private a(Map<String, d.a> paramMap, d.a parama)
    {
      this.agU = paramMap;
      this.agV = parama;
    }
    
    public static cq.b mi()
    {
      return new cq.b(null);
    }
    
    public void a(String paramString, d.a parama)
    {
      this.agU.put(paramString, parama);
    }
    
    public Map<String, d.a> mj()
    {
      return Collections.unmodifiableMap(this.agU);
    }
    
    public d.a mk()
    {
      return this.agV;
    }
    
    public String toString()
    {
      return "Properties: " + mj() + " pushAfterEvaluate: " + this.agV;
    }
  }
  
  public static class b
  {
    private final Map<String, d.a> agU = new HashMap();
    private d.a agV;
    
    public b b(String paramString, d.a parama)
    {
      this.agU.put(paramString, parama);
      return this;
    }
    
    public b i(d.a parama)
    {
      this.agV = parama;
      return this;
    }
    
    public cq.a ml()
    {
      return new cq.a(this.agU, this.agV, null);
    }
  }
  
  public static class c
  {
    private final String aeR;
    private final List<cq.e> agW;
    private final Map<String, List<cq.a>> agX;
    private final int agY;
    
    private c(List<cq.e> paramList, Map<String, List<cq.a>> paramMap, String paramString, int paramInt)
    {
      this.agW = Collections.unmodifiableList(paramList);
      this.agX = Collections.unmodifiableMap(paramMap);
      this.aeR = paramString;
      this.agY = paramInt;
    }
    
    public static cq.d mm()
    {
      return new cq.d(null);
    }
    
    public String getVersion()
    {
      return this.aeR;
    }
    
    public List<cq.e> mn()
    {
      return this.agW;
    }
    
    public Map<String, List<cq.a>> mo()
    {
      return this.agX;
    }
    
    public String toString()
    {
      return "Rules: " + mn() + "  Macros: " + this.agX;
    }
  }
  
  public static class d
  {
    private String aeR = "";
    private final List<cq.e> agW = new ArrayList();
    private final Map<String, List<cq.a>> agX = new HashMap();
    private int agY = 0;
    
    public d a(cq.a parama)
    {
      String str = dh.j((d.a)parama.mj().get(b.cI.toString()));
      List localList = (List)this.agX.get(str);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.agX.put(str, localObject);
      }
      ((List)localObject).add(parama);
      return this;
    }
    
    public d a(cq.e parame)
    {
      this.agW.add(parame);
      return this;
    }
    
    public d ce(String paramString)
    {
      this.aeR = paramString;
      return this;
    }
    
    public d du(int paramInt)
    {
      this.agY = paramInt;
      return this;
    }
    
    public cq.c mp()
    {
      return new cq.c(this.agW, this.agX, this.aeR, this.agY, null);
    }
  }
  
  public static class e
  {
    private final List<cq.a> agZ;
    private final List<cq.a> aha;
    private final List<cq.a> ahb;
    private final List<cq.a> ahc;
    private final List<cq.a> ahd;
    private final List<cq.a> ahe;
    private final List<String> ahf;
    private final List<String> ahg;
    private final List<String> ahh;
    private final List<String> ahi;
    
    private e(List<cq.a> paramList1, List<cq.a> paramList2, List<cq.a> paramList3, List<cq.a> paramList4, List<cq.a> paramList5, List<cq.a> paramList6, List<String> paramList7, List<String> paramList8, List<String> paramList9, List<String> paramList10)
    {
      this.agZ = Collections.unmodifiableList(paramList1);
      this.aha = Collections.unmodifiableList(paramList2);
      this.ahb = Collections.unmodifiableList(paramList3);
      this.ahc = Collections.unmodifiableList(paramList4);
      this.ahd = Collections.unmodifiableList(paramList5);
      this.ahe = Collections.unmodifiableList(paramList6);
      this.ahf = Collections.unmodifiableList(paramList7);
      this.ahg = Collections.unmodifiableList(paramList8);
      this.ahh = Collections.unmodifiableList(paramList9);
      this.ahi = Collections.unmodifiableList(paramList10);
    }
    
    public static cq.f mq()
    {
      return new cq.f(null);
    }
    
    public List<cq.a> mA()
    {
      return this.ahe;
    }
    
    public List<cq.a> mr()
    {
      return this.agZ;
    }
    
    public List<cq.a> ms()
    {
      return this.aha;
    }
    
    public List<cq.a> mt()
    {
      return this.ahb;
    }
    
    public List<cq.a> mu()
    {
      return this.ahc;
    }
    
    public List<cq.a> mv()
    {
      return this.ahd;
    }
    
    public List<String> mw()
    {
      return this.ahf;
    }
    
    public List<String> mx()
    {
      return this.ahg;
    }
    
    public List<String> my()
    {
      return this.ahh;
    }
    
    public List<String> mz()
    {
      return this.ahi;
    }
    
    public String toString()
    {
      return "Positive predicates: " + mr() + "  Negative predicates: " + ms() + "  Add tags: " + mt() + "  Remove tags: " + mu() + "  Add macros: " + mv() + "  Remove macros: " + mA();
    }
  }
  
  public static class f
  {
    private final List<cq.a> agZ = new ArrayList();
    private final List<cq.a> aha = new ArrayList();
    private final List<cq.a> ahb = new ArrayList();
    private final List<cq.a> ahc = new ArrayList();
    private final List<cq.a> ahd = new ArrayList();
    private final List<cq.a> ahe = new ArrayList();
    private final List<String> ahf = new ArrayList();
    private final List<String> ahg = new ArrayList();
    private final List<String> ahh = new ArrayList();
    private final List<String> ahi = new ArrayList();
    
    public f b(cq.a parama)
    {
      this.agZ.add(parama);
      return this;
    }
    
    public f c(cq.a parama)
    {
      this.aha.add(parama);
      return this;
    }
    
    public f cf(String paramString)
    {
      this.ahh.add(paramString);
      return this;
    }
    
    public f cg(String paramString)
    {
      this.ahi.add(paramString);
      return this;
    }
    
    public f ch(String paramString)
    {
      this.ahf.add(paramString);
      return this;
    }
    
    public f ci(String paramString)
    {
      this.ahg.add(paramString);
      return this;
    }
    
    public f d(cq.a parama)
    {
      this.ahb.add(parama);
      return this;
    }
    
    public f e(cq.a parama)
    {
      this.ahc.add(parama);
      return this;
    }
    
    public f f(cq.a parama)
    {
      this.ahd.add(parama);
      return this;
    }
    
    public f g(cq.a parama)
    {
      this.ahe.add(parama);
      return this;
    }
    
    public cq.e mB()
    {
      return new cq.e(this.agZ, this.aha, this.ahb, this.ahc, this.ahd, this.ahe, this.ahf, this.ahg, this.ahh, this.ahi, null);
    }
  }
  
  public static class g
    extends Exception
  {
    public g(String paramString)
    {
      super();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */