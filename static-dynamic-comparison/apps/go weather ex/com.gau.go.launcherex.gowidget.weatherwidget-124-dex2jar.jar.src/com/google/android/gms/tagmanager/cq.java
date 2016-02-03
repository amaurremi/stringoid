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
      bL("Value cycle detected.  Current value reference: " + paramInt + "." + "  Previous value references: " + paramSet + ".");
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
        bL("Invalid value: " + locala1);
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
        bL("Uneven map keys (" + ((c.h)localObject).fA.length + ") and map values (" + ((c.h)localObject).fB.length + ")");
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
    b localb = a.ld();
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
    return localb.lg();
  }
  
  private static e a(c.g paramg, List<a> paramList1, List<a> paramList2, List<a> paramList3, c.f paramf)
  {
    f localf = e.ll();
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
      localf.bN(paramf.eX[Integer.valueOf(k).intValue()].fN);
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
      localf.bO(paramf.eX[Integer.valueOf(k).intValue()].fN);
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
      localf.bP(paramf.eX[Integer.valueOf(k).intValue()].fN);
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
      localf.bQ(paramf.eX[Integer.valueOf(k).intValue()].fN);
      i += 1;
    }
    return localf.lw();
  }
  
  private static <T> T a(T[] paramArrayOfT, int paramInt, String paramString)
    throws cq.g
  {
    if ((paramInt < 0) || (paramInt >= paramArrayOfT.length)) {
      bL("Index out of bounds detected: " + paramInt + " in " + paramString);
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
    d locald = c.lh();
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
    locald.bM(paramf.fg);
    locald.ch(paramf.fl);
    return locald.lk();
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
  
  private static void bL(String paramString)
    throws cq.g
  {
    bh.w(paramString);
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
      bL("Expected a ServingValue and didn't get one. Value is: " + parama);
    }
    return (c.h)parama.a(c.h.fx);
  }
  
  public static class a
  {
    private final Map<String, d.a> Zp;
    private final d.a Zq;
    
    private a(Map<String, d.a> paramMap, d.a parama)
    {
      this.Zp = paramMap;
      this.Zq = parama;
    }
    
    public static cq.b ld()
    {
      return new cq.b(null);
    }
    
    public void a(String paramString, d.a parama)
    {
      this.Zp.put(paramString, parama);
    }
    
    public Map<String, d.a> le()
    {
      return Collections.unmodifiableMap(this.Zp);
    }
    
    public d.a lf()
    {
      return this.Zq;
    }
    
    public String toString()
    {
      return "Properties: " + le() + " pushAfterEvaluate: " + this.Zq;
    }
  }
  
  public static class b
  {
    private final Map<String, d.a> Zp = new HashMap();
    private d.a Zq;
    
    public b b(String paramString, d.a parama)
    {
      this.Zp.put(paramString, parama);
      return this;
    }
    
    public b i(d.a parama)
    {
      this.Zq = parama;
      return this;
    }
    
    public cq.a lg()
    {
      return new cq.a(this.Zp, this.Zq, null);
    }
  }
  
  public static class c
  {
    private final String Xl;
    private final List<cq.e> Zr;
    private final Map<String, List<cq.a>> Zs;
    private final int Zt;
    
    private c(List<cq.e> paramList, Map<String, List<cq.a>> paramMap, String paramString, int paramInt)
    {
      this.Zr = Collections.unmodifiableList(paramList);
      this.Zs = Collections.unmodifiableMap(paramMap);
      this.Xl = paramString;
      this.Zt = paramInt;
    }
    
    public static cq.d lh()
    {
      return new cq.d(null);
    }
    
    public String getVersion()
    {
      return this.Xl;
    }
    
    public List<cq.e> li()
    {
      return this.Zr;
    }
    
    public Map<String, List<cq.a>> lj()
    {
      return this.Zs;
    }
    
    public String toString()
    {
      return "Rules: " + li() + "  Macros: " + this.Zs;
    }
  }
  
  public static class d
  {
    private String Xl = "";
    private final List<cq.e> Zr = new ArrayList();
    private final Map<String, List<cq.a>> Zs = new HashMap();
    private int Zt = 0;
    
    public d a(cq.a parama)
    {
      String str = dh.j((d.a)parama.le().get(b.cI.toString()));
      List localList = (List)this.Zs.get(str);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.Zs.put(str, localObject);
      }
      ((List)localObject).add(parama);
      return this;
    }
    
    public d a(cq.e parame)
    {
      this.Zr.add(parame);
      return this;
    }
    
    public d bM(String paramString)
    {
      this.Xl = paramString;
      return this;
    }
    
    public d ch(int paramInt)
    {
      this.Zt = paramInt;
      return this;
    }
    
    public cq.c lk()
    {
      return new cq.c(this.Zr, this.Zs, this.Xl, this.Zt, null);
    }
  }
  
  public static class e
  {
    private final List<String> ZA;
    private final List<String> ZB;
    private final List<String> ZC;
    private final List<String> ZD;
    private final List<cq.a> Zu;
    private final List<cq.a> Zv;
    private final List<cq.a> Zw;
    private final List<cq.a> Zx;
    private final List<cq.a> Zy;
    private final List<cq.a> Zz;
    
    private e(List<cq.a> paramList1, List<cq.a> paramList2, List<cq.a> paramList3, List<cq.a> paramList4, List<cq.a> paramList5, List<cq.a> paramList6, List<String> paramList7, List<String> paramList8, List<String> paramList9, List<String> paramList10)
    {
      this.Zu = Collections.unmodifiableList(paramList1);
      this.Zv = Collections.unmodifiableList(paramList2);
      this.Zw = Collections.unmodifiableList(paramList3);
      this.Zx = Collections.unmodifiableList(paramList4);
      this.Zy = Collections.unmodifiableList(paramList5);
      this.Zz = Collections.unmodifiableList(paramList6);
      this.ZA = Collections.unmodifiableList(paramList7);
      this.ZB = Collections.unmodifiableList(paramList8);
      this.ZC = Collections.unmodifiableList(paramList9);
      this.ZD = Collections.unmodifiableList(paramList10);
    }
    
    public static cq.f ll()
    {
      return new cq.f(null);
    }
    
    public List<cq.a> lm()
    {
      return this.Zu;
    }
    
    public List<cq.a> ln()
    {
      return this.Zv;
    }
    
    public List<cq.a> lo()
    {
      return this.Zw;
    }
    
    public List<cq.a> lp()
    {
      return this.Zx;
    }
    
    public List<cq.a> lq()
    {
      return this.Zy;
    }
    
    public List<String> lr()
    {
      return this.ZA;
    }
    
    public List<String> ls()
    {
      return this.ZB;
    }
    
    public List<String> lt()
    {
      return this.ZC;
    }
    
    public List<String> lu()
    {
      return this.ZD;
    }
    
    public List<cq.a> lv()
    {
      return this.Zz;
    }
    
    public String toString()
    {
      return "Positive predicates: " + lm() + "  Negative predicates: " + ln() + "  Add tags: " + lo() + "  Remove tags: " + lp() + "  Add macros: " + lq() + "  Remove macros: " + lv();
    }
  }
  
  public static class f
  {
    private final List<String> ZA = new ArrayList();
    private final List<String> ZB = new ArrayList();
    private final List<String> ZC = new ArrayList();
    private final List<String> ZD = new ArrayList();
    private final List<cq.a> Zu = new ArrayList();
    private final List<cq.a> Zv = new ArrayList();
    private final List<cq.a> Zw = new ArrayList();
    private final List<cq.a> Zx = new ArrayList();
    private final List<cq.a> Zy = new ArrayList();
    private final List<cq.a> Zz = new ArrayList();
    
    public f b(cq.a parama)
    {
      this.Zu.add(parama);
      return this;
    }
    
    public f bN(String paramString)
    {
      this.ZC.add(paramString);
      return this;
    }
    
    public f bO(String paramString)
    {
      this.ZD.add(paramString);
      return this;
    }
    
    public f bP(String paramString)
    {
      this.ZA.add(paramString);
      return this;
    }
    
    public f bQ(String paramString)
    {
      this.ZB.add(paramString);
      return this;
    }
    
    public f c(cq.a parama)
    {
      this.Zv.add(parama);
      return this;
    }
    
    public f d(cq.a parama)
    {
      this.Zw.add(parama);
      return this;
    }
    
    public f e(cq.a parama)
    {
      this.Zx.add(parama);
      return this;
    }
    
    public f f(cq.a parama)
    {
      this.Zy.add(parama);
      return this;
    }
    
    public f g(cq.a parama)
    {
      this.Zz.add(parama);
      return this;
    }
    
    public cq.e lw()
    {
      return new cq.e(this.Zu, this.Zv, this.Zw, this.Zx, this.Zy, this.Zz, this.ZA, this.ZB, this.ZC, this.ZD, null);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/tagmanager/cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */