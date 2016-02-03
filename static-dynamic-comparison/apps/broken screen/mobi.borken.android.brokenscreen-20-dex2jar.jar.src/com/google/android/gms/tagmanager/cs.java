package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.c.i;
import com.google.android.gms.internal.d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class cs
{
  private static final by<d.a> ahj = new by(dh.mY(), true);
  private final DataLayer aer;
  private final cq.c ahk;
  private final ag ahl;
  private final Map<String, aj> ahm;
  private final Map<String, aj> ahn;
  private final Map<String, aj> aho;
  private final k<cq.a, by<d.a>> ahp;
  private final k<String, b> ahq;
  private final Set<cq.e> ahr;
  private final Map<String, c> ahs;
  private volatile String aht;
  private int ahu;
  
  public cs(Context paramContext, cq.c paramc, DataLayer paramDataLayer, s.a parama1, s.a parama2, ag paramag)
  {
    if (paramc == null) {
      throw new NullPointerException("resource cannot be null");
    }
    this.ahk = paramc;
    this.ahr = new HashSet(paramc.mn());
    this.aer = paramDataLayer;
    this.ahl = paramag;
    paramc = new l.a()
    {
      public int a(cq.a paramAnonymousa, by<d.a> paramAnonymousby)
      {
        return ((d.a)paramAnonymousby.getObject()).nU();
      }
    };
    this.ahp = new l().a(1048576, paramc);
    paramc = new l.a()
    {
      public int a(String paramAnonymousString, cs.b paramAnonymousb)
      {
        return paramAnonymousString.length() + paramAnonymousb.getSize();
      }
    };
    this.ahq = new l().a(1048576, paramc);
    this.ahm = new HashMap();
    b(new i(paramContext));
    b(new s(parama2));
    b(new w(paramDataLayer));
    b(new di(paramContext, paramDataLayer));
    this.ahn = new HashMap();
    c(new q());
    c(new ad());
    c(new ae());
    c(new al());
    c(new am());
    c(new bd());
    c(new be());
    c(new ch());
    c(new db());
    this.aho = new HashMap();
    a(new b(paramContext));
    a(new c(paramContext));
    a(new e(paramContext));
    a(new f(paramContext));
    a(new g(paramContext));
    a(new h(paramContext));
    a(new m());
    a(new p(this.ahk.getVersion()));
    a(new s(parama1));
    a(new u(paramDataLayer));
    a(new z(paramContext));
    a(new aa());
    a(new ac());
    a(new ah(this));
    a(new an());
    a(new ao());
    a(new ax(paramContext));
    a(new az());
    a(new bc());
    a(new bk(paramContext));
    a(new bz());
    a(new cb());
    a(new ce());
    a(new cg());
    a(new ci(paramContext));
    a(new ct());
    a(new cu());
    a(new dd());
    this.ahs = new HashMap();
    paramDataLayer = this.ahr.iterator();
    while (paramDataLayer.hasNext())
    {
      parama1 = (cq.e)paramDataLayer.next();
      if (paramag.lF())
      {
        a(parama1.mv(), parama1.mw(), "add macro");
        a(parama1.mA(), parama1.mx(), "remove macro");
        a(parama1.mt(), parama1.my(), "add tag");
        a(parama1.mu(), parama1.mz(), "remove tag");
      }
      int i = 0;
      while (i < parama1.mv().size())
      {
        parama2 = (cq.a)parama1.mv().get(i);
        paramc = "Unknown";
        paramContext = paramc;
        if (paramag.lF())
        {
          paramContext = paramc;
          if (i < parama1.mw().size()) {
            paramContext = (String)parama1.mw().get(i);
          }
        }
        paramc = d(this.ahs, h(parama2));
        paramc.b(parama1);
        paramc.a(parama1, parama2);
        paramc.a(parama1, paramContext);
        i += 1;
      }
      i = 0;
      while (i < parama1.mA().size())
      {
        parama2 = (cq.a)parama1.mA().get(i);
        paramc = "Unknown";
        paramContext = paramc;
        if (paramag.lF())
        {
          paramContext = paramc;
          if (i < parama1.mx().size()) {
            paramContext = (String)parama1.mx().get(i);
          }
        }
        paramc = d(this.ahs, h(parama2));
        paramc.b(parama1);
        paramc.b(parama1, parama2);
        paramc.b(parama1, paramContext);
        i += 1;
      }
    }
    paramContext = this.ahk.mo().entrySet().iterator();
    while (paramContext.hasNext())
    {
      paramc = (Map.Entry)paramContext.next();
      paramDataLayer = ((List)paramc.getValue()).iterator();
      while (paramDataLayer.hasNext())
      {
        parama1 = (cq.a)paramDataLayer.next();
        if (!dh.n((d.a)parama1.mj().get(com.google.android.gms.internal.b.dh.toString())).booleanValue()) {
          d(this.ahs, (String)paramc.getKey()).i(parama1);
        }
      }
    }
  }
  
  private by<d.a> a(d.a parama, Set<String> paramSet, dj paramdj)
  {
    if (!parama.fX) {
      return new by(parama, true);
    }
    by localby1;
    switch (parama.type)
    {
    case 5: 
    case 6: 
    default: 
      bh.A("Unknown type: " + parama.type);
      return ahj;
    case 2: 
      locala = cq.g(parama);
      locala.fO = new d.a[parama.fO.length];
      i = 0;
      while (i < parama.fO.length)
      {
        localby1 = a(parama.fO[i], paramSet, paramdj.dq(i));
        if (localby1 == ahj) {
          return ahj;
        }
        locala.fO[i] = ((d.a)localby1.getObject());
        i += 1;
      }
      return new by(locala, false);
    case 3: 
      locala = cq.g(parama);
      if (parama.fP.length != parama.fQ.length)
      {
        bh.A("Invalid serving value: " + parama.toString());
        return ahj;
      }
      locala.fP = new d.a[parama.fP.length];
      locala.fQ = new d.a[parama.fP.length];
      i = 0;
      while (i < parama.fP.length)
      {
        localby1 = a(parama.fP[i], paramSet, paramdj.dr(i));
        by localby2 = a(parama.fQ[i], paramSet, paramdj.ds(i));
        if ((localby1 == ahj) || (localby2 == ahj)) {
          return ahj;
        }
        locala.fP[i] = ((d.a)localby1.getObject());
        locala.fQ[i] = ((d.a)localby2.getObject());
        i += 1;
      }
      return new by(locala, false);
    case 4: 
      if (paramSet.contains(parama.fR))
      {
        bh.A("Macro cycle detected.  Current macro reference: " + parama.fR + "." + "  Previous macro references: " + paramSet.toString() + ".");
        return ahj;
      }
      paramSet.add(parama.fR);
      paramdj = dk.a(a(parama.fR, paramSet, paramdj.lU()), parama.fW);
      paramSet.remove(parama.fR);
      return paramdj;
    }
    d.a locala = cq.g(parama);
    locala.fV = new d.a[parama.fV.length];
    int i = 0;
    while (i < parama.fV.length)
    {
      localby1 = a(parama.fV[i], paramSet, paramdj.dt(i));
      if (localby1 == ahj) {
        return ahj;
      }
      locala.fV[i] = ((d.a)localby1.getObject());
      i += 1;
    }
    return new by(locala, false);
  }
  
  private by<d.a> a(String paramString, Set<String> paramSet, bj parambj)
  {
    this.ahu += 1;
    Object localObject = (b)this.ahq.get(paramString);
    if ((localObject != null) && (!this.ahl.lF()))
    {
      a(((b)localObject).mk(), paramSet);
      this.ahu -= 1;
      return ((b)localObject).mE();
    }
    localObject = (c)this.ahs.get(paramString);
    if (localObject == null)
    {
      bh.A(mD() + "Invalid macro: " + paramString);
      this.ahu -= 1;
      return ahj;
    }
    by localby = a(paramString, ((c)localObject).mF(), ((c)localObject).mG(), ((c)localObject).mH(), ((c)localObject).mJ(), ((c)localObject).mI(), paramSet, parambj.lw());
    if (((Set)localby.getObject()).isEmpty()) {}
    for (localObject = ((c)localObject).mK(); localObject == null; localObject = (cq.a)((Set)localby.getObject()).iterator().next())
    {
      this.ahu -= 1;
      return ahj;
      if (((Set)localby.getObject()).size() > 1) {
        bh.D(mD() + "Multiple macros active for macroName " + paramString);
      }
    }
    parambj = a(this.aho, (cq.a)localObject, paramSet, parambj.lL());
    boolean bool;
    if ((localby.lV()) && (parambj.lV()))
    {
      bool = true;
      if (parambj != ahj) {
        break label392;
      }
    }
    label392:
    for (parambj = ahj;; parambj = new by(parambj.getObject(), bool))
    {
      localObject = ((cq.a)localObject).mk();
      if (parambj.lV()) {
        this.ahq.e(paramString, new b(parambj, (d.a)localObject));
      }
      a((d.a)localObject, paramSet);
      this.ahu -= 1;
      return parambj;
      bool = false;
      break;
    }
  }
  
  private by<d.a> a(Map<String, aj> paramMap, cq.a parama, Set<String> paramSet, cj paramcj)
  {
    boolean bool = true;
    Object localObject1 = (d.a)parama.mj().get(com.google.android.gms.internal.b.cx.toString());
    if (localObject1 == null)
    {
      bh.A("No function id in properties");
      paramMap = ahj;
    }
    aj localaj;
    do
    {
      return paramMap;
      localObject1 = ((d.a)localObject1).fS;
      localaj = (aj)paramMap.get(localObject1);
      if (localaj == null)
      {
        bh.A((String)localObject1 + " has no backing implementation.");
        return ahj;
      }
      paramMap = (by)this.ahp.get(parama);
    } while ((paramMap != null) && (!this.ahl.lF()));
    paramMap = new HashMap();
    Iterator localIterator = parama.mj().entrySet().iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject2 = paramcj.bZ((String)localEntry.getKey());
      localObject2 = a((d.a)localEntry.getValue(), paramSet, ((cl)localObject2).e((d.a)localEntry.getValue()));
      if (localObject2 == ahj) {
        return ahj;
      }
      if (((by)localObject2).lV()) {
        parama.a((String)localEntry.getKey(), (d.a)((by)localObject2).getObject());
      }
      for (;;)
      {
        paramMap.put(localEntry.getKey(), ((by)localObject2).getObject());
        break;
        i = 0;
      }
    }
    if (!localaj.a(paramMap.keySet()))
    {
      bh.A("Incorrect keys for function " + (String)localObject1 + " required " + localaj.lH() + " had " + paramMap.keySet());
      return ahj;
    }
    if ((i != 0) && (localaj.lc())) {}
    for (;;)
    {
      paramMap = new by(localaj.w(paramMap), bool);
      if (bool) {
        this.ahp.e(parama, paramMap);
      }
      paramcj.d((d.a)paramMap.getObject());
      return paramMap;
      bool = false;
    }
  }
  
  private by<Set<cq.a>> a(Set<cq.e> paramSet, Set<String> paramSet1, a parama, cr paramcr)
  {
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    paramSet = paramSet.iterator();
    boolean bool = true;
    if (paramSet.hasNext())
    {
      cq.e locale = (cq.e)paramSet.next();
      cm localcm = paramcr.lT();
      by localby = a(locale, paramSet1, localcm);
      if (((Boolean)localby.getObject()).booleanValue()) {
        parama.a(locale, localHashSet1, localHashSet2, localcm);
      }
      if ((bool) && (localby.lV())) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    localHashSet1.removeAll(localHashSet2);
    paramcr.b(localHashSet1);
    return new by(localHashSet1, bool);
  }
  
  private void a(d.a parama, Set<String> paramSet)
  {
    if (parama == null) {}
    for (;;)
    {
      return;
      parama = a(parama, paramSet, new bw());
      if (parama != ahj)
      {
        parama = dh.o((d.a)parama.getObject());
        if ((parama instanceof Map))
        {
          parama = (Map)parama;
          this.aer.push(parama);
          return;
        }
        if (!(parama instanceof List)) {
          break;
        }
        parama = ((List)parama).iterator();
        while (parama.hasNext())
        {
          paramSet = parama.next();
          if ((paramSet instanceof Map))
          {
            paramSet = (Map)paramSet;
            this.aer.push(paramSet);
          }
          else
          {
            bh.D("pushAfterEvaluate: value not a Map");
          }
        }
      }
    }
    bh.D("pushAfterEvaluate: value not a Map or List");
  }
  
  private static void a(List<cq.a> paramList, List<String> paramList1, String paramString)
  {
    if (paramList.size() != paramList1.size()) {
      bh.B("Invalid resource: imbalance of rule names of functions for " + paramString + " operation. Using default rule name instead");
    }
  }
  
  private static void a(Map<String, aj> paramMap, aj paramaj)
  {
    if (paramMap.containsKey(paramaj.lG())) {
      throw new IllegalArgumentException("Duplicate function type name: " + paramaj.lG());
    }
    paramMap.put(paramaj.lG(), paramaj);
  }
  
  private static c d(Map<String, c> paramMap, String paramString)
  {
    c localc2 = (c)paramMap.get(paramString);
    c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new c();
      paramMap.put(paramString, localc1);
    }
    return localc1;
  }
  
  private static String h(cq.a parama)
  {
    return dh.j((d.a)parama.mj().get(com.google.android.gms.internal.b.cI.toString()));
  }
  
  private String mD()
  {
    if (this.ahu <= 1) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Integer.toString(this.ahu));
    int i = 2;
    while (i < this.ahu)
    {
      localStringBuilder.append(' ');
      i += 1;
    }
    localStringBuilder.append(": ");
    return localStringBuilder.toString();
  }
  
  by<Boolean> a(cq.a parama, Set<String> paramSet, cj paramcj)
  {
    parama = a(this.ahn, parama, paramSet, paramcj);
    paramSet = dh.n((d.a)parama.getObject());
    paramcj.d(dh.r(paramSet));
    return new by(paramSet, parama.lV());
  }
  
  by<Boolean> a(cq.e parame, Set<String> paramSet, cm paramcm)
  {
    Object localObject = parame.ms().iterator();
    boolean bool = true;
    if (((Iterator)localObject).hasNext())
    {
      by localby = a((cq.a)((Iterator)localObject).next(), paramSet, paramcm.lN());
      if (((Boolean)localby.getObject()).booleanValue())
      {
        paramcm.f(dh.r(Boolean.valueOf(false)));
        return new by(Boolean.valueOf(false), localby.lV());
      }
      if ((bool) && (localby.lV())) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    parame = parame.mr().iterator();
    while (parame.hasNext())
    {
      localObject = a((cq.a)parame.next(), paramSet, paramcm.lO());
      if (!((Boolean)((by)localObject).getObject()).booleanValue())
      {
        paramcm.f(dh.r(Boolean.valueOf(false)));
        return new by(Boolean.valueOf(false), ((by)localObject).lV());
      }
      if ((bool) && (((by)localObject).lV())) {
        bool = true;
      } else {
        bool = false;
      }
    }
    paramcm.f(dh.r(Boolean.valueOf(true)));
    return new by(Boolean.valueOf(true), bool);
  }
  
  by<Set<cq.a>> a(String paramString, Set<cq.e> paramSet, final Map<cq.e, List<cq.a>> paramMap1, final Map<cq.e, List<String>> paramMap2, final Map<cq.e, List<cq.a>> paramMap3, final Map<cq.e, List<String>> paramMap4, Set<String> paramSet1, cr paramcr)
  {
    a(paramSet, paramSet1, new a()
    {
      public void a(cq.e paramAnonymouse, Set<cq.a> paramAnonymousSet1, Set<cq.a> paramAnonymousSet2, cm paramAnonymouscm)
      {
        List localList1 = (List)paramMap1.get(paramAnonymouse);
        List localList2 = (List)paramMap2.get(paramAnonymouse);
        if (localList1 != null)
        {
          paramAnonymousSet1.addAll(localList1);
          paramAnonymouscm.lP().b(localList1, localList2);
        }
        paramAnonymousSet1 = (List)paramMap3.get(paramAnonymouse);
        paramAnonymouse = (List)paramMap4.get(paramAnonymouse);
        if (paramAnonymousSet1 != null)
        {
          paramAnonymousSet2.addAll(paramAnonymousSet1);
          paramAnonymouscm.lQ().b(paramAnonymousSet1, paramAnonymouse);
        }
      }
    }, paramcr);
  }
  
  by<Set<cq.a>> a(Set<cq.e> paramSet, cr paramcr)
  {
    a(paramSet, new HashSet(), new a()
    {
      public void a(cq.e paramAnonymouse, Set<cq.a> paramAnonymousSet1, Set<cq.a> paramAnonymousSet2, cm paramAnonymouscm)
      {
        paramAnonymousSet1.addAll(paramAnonymouse.mt());
        paramAnonymousSet2.addAll(paramAnonymouse.mu());
        paramAnonymouscm.lR().b(paramAnonymouse.mt(), paramAnonymouse.my());
        paramAnonymouscm.lS().b(paramAnonymouse.mu(), paramAnonymouse.mz());
      }
    }, paramcr);
  }
  
  void a(aj paramaj)
  {
    a(this.aho, paramaj);
  }
  
  void b(aj paramaj)
  {
    a(this.ahm, paramaj);
  }
  
  public void bH(String paramString)
  {
    try
    {
      ck(paramString);
      paramString = this.ahl.bT(paramString);
      t localt = paramString.lD();
      Iterator localIterator = ((Set)a(this.ahr, localt.lw()).getObject()).iterator();
      while (localIterator.hasNext())
      {
        cq.a locala = (cq.a)localIterator.next();
        a(this.ahm, locala, new HashSet(), localt.lv());
      }
      paramString.lE();
    }
    finally {}
    ck(null);
  }
  
  void c(aj paramaj)
  {
    a(this.ahn, paramaj);
  }
  
  public by<d.a> cj(String paramString)
  {
    this.ahu = 0;
    af localaf = this.ahl.bS(paramString);
    paramString = a(paramString, new HashSet(), localaf.lC());
    localaf.lE();
    return paramString;
  }
  
  void ck(String paramString)
  {
    try
    {
      this.aht = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void h(List<c.i> paramList)
  {
    for (;;)
    {
      try
      {
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        c.i locali = (c.i)paramList.next();
        if ((locali.name == null) || (!locali.name.startsWith("gaExperiment:"))) {
          bh.C("Ignored supplemental: " + locali);
        } else {
          ai.a(this.aer, locali);
        }
      }
      finally {}
    }
  }
  
  String mC()
  {
    try
    {
      String str = this.aht;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  static abstract interface a
  {
    public abstract void a(cq.e parame, Set<cq.a> paramSet1, Set<cq.a> paramSet2, cm paramcm);
  }
  
  private static class b
  {
    private d.a agV;
    private by<d.a> ahA;
    
    public b(by<d.a> paramby, d.a parama)
    {
      this.ahA = paramby;
      this.agV = parama;
    }
    
    public int getSize()
    {
      int j = ((d.a)this.ahA.getObject()).nU();
      if (this.agV == null) {}
      for (int i = 0;; i = this.agV.nU()) {
        return i + j;
      }
    }
    
    public by<d.a> mE()
    {
      return this.ahA;
    }
    
    public d.a mk()
    {
      return this.agV;
    }
  }
  
  private static class c
  {
    private final Map<cq.e, List<cq.a>> ahB = new HashMap();
    private final Map<cq.e, List<cq.a>> ahC = new HashMap();
    private final Map<cq.e, List<String>> ahD = new HashMap();
    private final Map<cq.e, List<String>> ahE = new HashMap();
    private cq.a ahF;
    private final Set<cq.e> ahr = new HashSet();
    
    public void a(cq.e parame, cq.a parama)
    {
      List localList = (List)this.ahB.get(parame);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.ahB.put(parame, localObject);
      }
      ((List)localObject).add(parama);
    }
    
    public void a(cq.e parame, String paramString)
    {
      List localList = (List)this.ahD.get(parame);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.ahD.put(parame, localObject);
      }
      ((List)localObject).add(paramString);
    }
    
    public void b(cq.e parame)
    {
      this.ahr.add(parame);
    }
    
    public void b(cq.e parame, cq.a parama)
    {
      List localList = (List)this.ahC.get(parame);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.ahC.put(parame, localObject);
      }
      ((List)localObject).add(parama);
    }
    
    public void b(cq.e parame, String paramString)
    {
      List localList = (List)this.ahE.get(parame);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.ahE.put(parame, localObject);
      }
      ((List)localObject).add(paramString);
    }
    
    public void i(cq.a parama)
    {
      this.ahF = parama;
    }
    
    public Set<cq.e> mF()
    {
      return this.ahr;
    }
    
    public Map<cq.e, List<cq.a>> mG()
    {
      return this.ahB;
    }
    
    public Map<cq.e, List<String>> mH()
    {
      return this.ahD;
    }
    
    public Map<cq.e, List<String>> mI()
    {
      return this.ahE;
    }
    
    public Map<cq.e, List<cq.a>> mJ()
    {
      return this.ahC;
    }
    
    public cq.a mK()
    {
      return this.ahF;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */