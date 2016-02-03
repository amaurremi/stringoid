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

class cr
{
  private static d.a a(int paramInt, c.f paramf, d.a[] paramArrayOfa, Set<Integer> paramSet)
    throws cr.g
  {
    int k = 0;
    int m = 0;
    int j = 0;
    if (paramSet.contains(Integer.valueOf(paramInt))) {
      cI("Value cycle detected.  Current value reference: " + paramInt + "." + "  Previous value references: " + paramSet + ".");
    }
    d.a locala1 = (d.a)a(paramf.fG, paramInt, "values");
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
        cI("Invalid value: " + locala1);
      }
      paramArrayOfa[paramInt] = localObject;
      paramSet.remove(Integer.valueOf(paramInt));
      return (d.a)localObject;
      localObject = h(locala1);
      d.a locala2 = g(locala1);
      locala2.gw = new d.a[((c.h)localObject).gh.length];
      int[] arrayOfInt = ((c.h)localObject).gh;
      k = arrayOfInt.length;
      int i = 0;
      for (;;)
      {
        localObject = locala2;
        if (j >= k) {
          break;
        }
        m = arrayOfInt[j];
        locala2.gw[i] = a(m, paramf, paramArrayOfa, paramSet);
        j += 1;
        i += 1;
      }
      locala2 = g(locala1);
      localObject = h(locala1);
      if (((c.h)localObject).gi.length != ((c.h)localObject).gj.length) {
        cI("Uneven map keys (" + ((c.h)localObject).gi.length + ") and map values (" + ((c.h)localObject).gj.length + ")");
      }
      locala2.gx = new d.a[((c.h)localObject).gi.length];
      locala2.gy = new d.a[((c.h)localObject).gi.length];
      arrayOfInt = ((c.h)localObject).gi;
      m = arrayOfInt.length;
      j = 0;
      i = 0;
      while (j < m)
      {
        int n = arrayOfInt[j];
        locala2.gx[i] = a(n, paramf, paramArrayOfa, paramSet);
        j += 1;
        i += 1;
      }
      arrayOfInt = ((c.h)localObject).gj;
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
        locala2.gy[i] = a(k, paramf, paramArrayOfa, paramSet);
        j += 1;
        i += 1;
      }
      localObject = g(locala1);
      ((d.a)localObject).gz = di.j(a(h(locala1).gm, paramf, paramArrayOfa, paramSet));
      continue;
      locala2 = g(locala1);
      localObject = h(locala1);
      locala2.gD = new d.a[((c.h)localObject).gl.length];
      arrayOfInt = ((c.h)localObject).gl;
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
        locala2.gD[i] = a(m, paramf, paramArrayOfa, paramSet);
        j += 1;
        i += 1;
      }
      localObject = locala1;
    }
  }
  
  private static a a(c.b paramb, c.f paramf, d.a[] paramArrayOfa, int paramInt)
    throws cr.g
  {
    b localb = a.oR();
    paramb = paramb.fq;
    int i = paramb.length;
    paramInt = 0;
    if (paramInt < i)
    {
      int j = paramb[paramInt];
      Object localObject = (c.e)a(paramf.fH, Integer.valueOf(j).intValue(), "properties");
      String str = (String)a(paramf.fF, ((c.e)localObject).key, "keys");
      localObject = (d.a)a(paramArrayOfa, ((c.e)localObject).value, "values");
      if (b.ec.toString().equals(str)) {
        localb.i((d.a)localObject);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        localb.b(str, (d.a)localObject);
      }
    }
    return localb.oU();
  }
  
  private static e a(c.g paramg, List<a> paramList1, List<a> paramList2, List<a> paramList3, c.f paramf)
  {
    f localf = e.oZ();
    int[] arrayOfInt = paramg.fV;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localf.b((a)paramList3.get(Integer.valueOf(arrayOfInt[i]).intValue()));
      i += 1;
    }
    arrayOfInt = paramg.fW;
    j = arrayOfInt.length;
    i = 0;
    while (i < j)
    {
      localf.c((a)paramList3.get(Integer.valueOf(arrayOfInt[i]).intValue()));
      i += 1;
    }
    paramList3 = paramg.fX;
    j = paramList3.length;
    i = 0;
    while (i < j)
    {
      localf.d((a)paramList1.get(Integer.valueOf(paramList3[i]).intValue()));
      i += 1;
    }
    paramList3 = paramg.fZ;
    j = paramList3.length;
    i = 0;
    int k;
    while (i < j)
    {
      k = paramList3[i];
      localf.cK(paramf.fG[Integer.valueOf(k).intValue()].gv);
      i += 1;
    }
    paramList3 = paramg.fY;
    j = paramList3.length;
    i = 0;
    while (i < j)
    {
      localf.e((a)paramList1.get(Integer.valueOf(paramList3[i]).intValue()));
      i += 1;
    }
    paramList1 = paramg.ga;
    j = paramList1.length;
    i = 0;
    while (i < j)
    {
      k = paramList1[i];
      localf.cL(paramf.fG[Integer.valueOf(k).intValue()].gv);
      i += 1;
    }
    paramList1 = paramg.gb;
    j = paramList1.length;
    i = 0;
    while (i < j)
    {
      localf.f((a)paramList2.get(Integer.valueOf(paramList1[i]).intValue()));
      i += 1;
    }
    paramList1 = paramg.gd;
    j = paramList1.length;
    i = 0;
    while (i < j)
    {
      k = paramList1[i];
      localf.cM(paramf.fG[Integer.valueOf(k).intValue()].gv);
      i += 1;
    }
    paramList1 = paramg.gc;
    j = paramList1.length;
    i = 0;
    while (i < j)
    {
      localf.g((a)paramList2.get(Integer.valueOf(paramList1[i]).intValue()));
      i += 1;
    }
    paramg = paramg.ge;
    j = paramg.length;
    i = 0;
    while (i < j)
    {
      k = paramg[i];
      localf.cN(paramf.fG[Integer.valueOf(k).intValue()].gv);
      i += 1;
    }
    return localf.pk();
  }
  
  private static <T> T a(T[] paramArrayOfT, int paramInt, String paramString)
    throws cr.g
  {
    if ((paramInt < 0) || (paramInt >= paramArrayOfT.length)) {
      cI("Index out of bounds detected: " + paramInt + " in " + paramString);
    }
    return paramArrayOfT[paramInt];
  }
  
  public static c b(c.f paramf)
    throws cr.g
  {
    int j = 0;
    Object localObject = new d.a[paramf.fG.length];
    int i = 0;
    while (i < paramf.fG.length)
    {
      a(i, paramf, (d.a[])localObject, new HashSet(0));
      i += 1;
    }
    d locald = c.oV();
    ArrayList localArrayList1 = new ArrayList();
    i = 0;
    while (i < paramf.fJ.length)
    {
      localArrayList1.add(a(paramf.fJ[i], paramf, (d.a[])localObject, i));
      i += 1;
    }
    ArrayList localArrayList2 = new ArrayList();
    i = 0;
    while (i < paramf.fK.length)
    {
      localArrayList2.add(a(paramf.fK[i], paramf, (d.a[])localObject, i));
      i += 1;
    }
    ArrayList localArrayList3 = new ArrayList();
    i = 0;
    while (i < paramf.fI.length)
    {
      a locala = a(paramf.fI[i], paramf, (d.a[])localObject, i);
      locald.a(locala);
      localArrayList3.add(locala);
      i += 1;
    }
    localObject = paramf.fL;
    int k = localObject.length;
    i = j;
    while (i < k)
    {
      locald.a(a(localObject[i], localArrayList1, localArrayList3, localArrayList2, paramf));
      i += 1;
    }
    locald.cJ(paramf.version);
    locald.fl(paramf.fT);
    return locald.oY();
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
  
  private static void cI(String paramString)
    throws cr.g
  {
    bh.T(paramString);
    throw new g(paramString);
  }
  
  public static d.a g(d.a parama)
  {
    d.a locala = new d.a();
    locala.type = parama.type;
    locala.gE = ((int[])parama.gE.clone());
    if (parama.gF) {
      locala.gF = parama.gF;
    }
    return locala;
  }
  
  private static c.h h(d.a parama)
    throws cr.g
  {
    if ((c.h)parama.a(c.h.gf) == null) {
      cI("Expected a ServingValue and didn't get one. Value is: " + parama);
    }
    return (c.h)parama.a(c.h.gf);
  }
  
  public static class a
  {
    private final Map<String, d.a> aqs;
    private final d.a aqt;
    
    private a(Map<String, d.a> paramMap, d.a parama)
    {
      this.aqs = paramMap;
      this.aqt = parama;
    }
    
    public static cr.b oR()
    {
      return new cr.b(null);
    }
    
    public void a(String paramString, d.a parama)
    {
      this.aqs.put(paramString, parama);
    }
    
    public Map<String, d.a> oS()
    {
      return Collections.unmodifiableMap(this.aqs);
    }
    
    public d.a oT()
    {
      return this.aqt;
    }
    
    public String toString()
    {
      return "Properties: " + oS() + " pushAfterEvaluate: " + this.aqt;
    }
  }
  
  public static class b
  {
    private final Map<String, d.a> aqs = new HashMap();
    private d.a aqt;
    
    public b b(String paramString, d.a parama)
    {
      this.aqs.put(paramString, parama);
      return this;
    }
    
    public b i(d.a parama)
    {
      this.aqt = parama;
      return this;
    }
    
    public cr.a oU()
    {
      return new cr.a(this.aqs, this.aqt, null);
    }
  }
  
  public static class c
  {
    private final String Sq;
    private final List<cr.e> aqu;
    private final Map<String, List<cr.a>> aqv;
    private final int aqw;
    
    private c(List<cr.e> paramList, Map<String, List<cr.a>> paramMap, String paramString, int paramInt)
    {
      this.aqu = Collections.unmodifiableList(paramList);
      this.aqv = Collections.unmodifiableMap(paramMap);
      this.Sq = paramString;
      this.aqw = paramInt;
    }
    
    public static cr.d oV()
    {
      return new cr.d(null);
    }
    
    public String getVersion()
    {
      return this.Sq;
    }
    
    public List<cr.e> oW()
    {
      return this.aqu;
    }
    
    public Map<String, List<cr.a>> oX()
    {
      return this.aqv;
    }
    
    public String toString()
    {
      return "Rules: " + oW() + "  Macros: " + this.aqv;
    }
  }
  
  public static class d
  {
    private String Sq = "";
    private final List<cr.e> aqu = new ArrayList();
    private final Map<String, List<cr.a>> aqv = new HashMap();
    private int aqw = 0;
    
    public d a(cr.a parama)
    {
      String str = di.j((d.a)parama.oS().get(b.df.toString()));
      List localList = (List)this.aqv.get(str);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.aqv.put(str, localObject);
      }
      ((List)localObject).add(parama);
      return this;
    }
    
    public d a(cr.e parame)
    {
      this.aqu.add(parame);
      return this;
    }
    
    public d cJ(String paramString)
    {
      this.Sq = paramString;
      return this;
    }
    
    public d fl(int paramInt)
    {
      this.aqw = paramInt;
      return this;
    }
    
    public cr.c oY()
    {
      return new cr.c(this.aqu, this.aqv, this.Sq, this.aqw, null);
    }
  }
  
  public static class e
  {
    private final List<cr.a> aqA;
    private final List<cr.a> aqB;
    private final List<cr.a> aqC;
    private final List<String> aqD;
    private final List<String> aqE;
    private final List<String> aqF;
    private final List<String> aqG;
    private final List<cr.a> aqx;
    private final List<cr.a> aqy;
    private final List<cr.a> aqz;
    
    private e(List<cr.a> paramList1, List<cr.a> paramList2, List<cr.a> paramList3, List<cr.a> paramList4, List<cr.a> paramList5, List<cr.a> paramList6, List<String> paramList7, List<String> paramList8, List<String> paramList9, List<String> paramList10)
    {
      this.aqx = Collections.unmodifiableList(paramList1);
      this.aqy = Collections.unmodifiableList(paramList2);
      this.aqz = Collections.unmodifiableList(paramList3);
      this.aqA = Collections.unmodifiableList(paramList4);
      this.aqB = Collections.unmodifiableList(paramList5);
      this.aqC = Collections.unmodifiableList(paramList6);
      this.aqD = Collections.unmodifiableList(paramList7);
      this.aqE = Collections.unmodifiableList(paramList8);
      this.aqF = Collections.unmodifiableList(paramList9);
      this.aqG = Collections.unmodifiableList(paramList10);
    }
    
    public static cr.f oZ()
    {
      return new cr.f(null);
    }
    
    public List<cr.a> pa()
    {
      return this.aqx;
    }
    
    public List<cr.a> pb()
    {
      return this.aqy;
    }
    
    public List<cr.a> pc()
    {
      return this.aqz;
    }
    
    public List<cr.a> pd()
    {
      return this.aqA;
    }
    
    public List<cr.a> pe()
    {
      return this.aqB;
    }
    
    public List<String> pf()
    {
      return this.aqD;
    }
    
    public List<String> pg()
    {
      return this.aqE;
    }
    
    public List<String> ph()
    {
      return this.aqF;
    }
    
    public List<String> pi()
    {
      return this.aqG;
    }
    
    public List<cr.a> pj()
    {
      return this.aqC;
    }
    
    public String toString()
    {
      return "Positive predicates: " + pa() + "  Negative predicates: " + pb() + "  Add tags: " + pc() + "  Remove tags: " + pd() + "  Add macros: " + pe() + "  Remove macros: " + pj();
    }
  }
  
  public static class f
  {
    private final List<cr.a> aqA = new ArrayList();
    private final List<cr.a> aqB = new ArrayList();
    private final List<cr.a> aqC = new ArrayList();
    private final List<String> aqD = new ArrayList();
    private final List<String> aqE = new ArrayList();
    private final List<String> aqF = new ArrayList();
    private final List<String> aqG = new ArrayList();
    private final List<cr.a> aqx = new ArrayList();
    private final List<cr.a> aqy = new ArrayList();
    private final List<cr.a> aqz = new ArrayList();
    
    public f b(cr.a parama)
    {
      this.aqx.add(parama);
      return this;
    }
    
    public f c(cr.a parama)
    {
      this.aqy.add(parama);
      return this;
    }
    
    public f cK(String paramString)
    {
      this.aqF.add(paramString);
      return this;
    }
    
    public f cL(String paramString)
    {
      this.aqG.add(paramString);
      return this;
    }
    
    public f cM(String paramString)
    {
      this.aqD.add(paramString);
      return this;
    }
    
    public f cN(String paramString)
    {
      this.aqE.add(paramString);
      return this;
    }
    
    public f d(cr.a parama)
    {
      this.aqz.add(parama);
      return this;
    }
    
    public f e(cr.a parama)
    {
      this.aqA.add(parama);
      return this;
    }
    
    public f f(cr.a parama)
    {
      this.aqB.add(parama);
      return this;
    }
    
    public f g(cr.a parama)
    {
      this.aqC.add(parama);
      return this;
    }
    
    public cr.e pk()
    {
      return new cr.e(this.aqx, this.aqy, this.aqz, this.aqA, this.aqB, this.aqC, this.aqD, this.aqE, this.aqF, this.aqG, null);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/cr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */