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

class ct
{
  private static final bz<d.a> aqH = new bz(di.pI(), true);
  private final DataLayer anS;
  private final cr.c aqI;
  private final ag aqJ;
  private final Map<String, aj> aqK;
  private final Map<String, aj> aqL;
  private final Map<String, aj> aqM;
  private final k<cr.a, bz<d.a>> aqN;
  private final k<String, b> aqO;
  private final Set<cr.e> aqP;
  private final Map<String, c> aqQ;
  private volatile String aqR;
  private int aqS;
  
  public ct(Context paramContext, cr.c paramc, DataLayer paramDataLayer, s.a parama1, s.a parama2, ag paramag)
  {
    if (paramc == null) {
      throw new NullPointerException("resource cannot be null");
    }
    this.aqI = paramc;
    this.aqP = new HashSet(paramc.oW());
    this.anS = paramDataLayer;
    this.aqJ = paramag;
    paramc = new l.a()
    {
      public int a(cr.a paramAnonymousa, bz<d.a> paramAnonymousbz)
      {
        return ((d.a)paramAnonymousbz.getObject()).qF();
      }
    };
    this.aqN = new l().a(1048576, paramc);
    paramc = new l.a()
    {
      public int a(String paramAnonymousString, ct.b paramAnonymousb)
      {
        return paramAnonymousString.length() + paramAnonymousb.getSize();
      }
    };
    this.aqO = new l().a(1048576, paramc);
    this.aqK = new HashMap();
    b(new i(paramContext));
    b(new s(parama2));
    b(new w(paramDataLayer));
    b(new dj(paramContext, paramDataLayer));
    this.aqL = new HashMap();
    c(new q());
    c(new ad());
    c(new ae());
    c(new al());
    c(new am());
    c(new bd());
    c(new be());
    c(new ci());
    c(new dc());
    this.aqM = new HashMap();
    a(new b(paramContext));
    a(new c(paramContext));
    a(new e(paramContext));
    a(new f(paramContext));
    a(new g(paramContext));
    a(new h(paramContext));
    a(new m());
    a(new p(this.aqI.getVersion()));
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
    a(new bj());
    a(new bl(paramContext));
    a(new ca());
    a(new cc());
    a(new cf());
    a(new ch());
    a(new cj(paramContext));
    a(new cu());
    a(new cv());
    a(new de());
    a(new dk());
    this.aqQ = new HashMap();
    paramDataLayer = this.aqP.iterator();
    while (paramDataLayer.hasNext())
    {
      parama1 = (cr.e)paramDataLayer.next();
      if (paramag.oo())
      {
        a(parama1.pe(), parama1.pf(), "add macro");
        a(parama1.pj(), parama1.pg(), "remove macro");
        a(parama1.pc(), parama1.ph(), "add tag");
        a(parama1.pd(), parama1.pi(), "remove tag");
      }
      int i = 0;
      while (i < parama1.pe().size())
      {
        parama2 = (cr.a)parama1.pe().get(i);
        paramc = "Unknown";
        paramContext = paramc;
        if (paramag.oo())
        {
          paramContext = paramc;
          if (i < parama1.pf().size()) {
            paramContext = (String)parama1.pf().get(i);
          }
        }
        paramc = e(this.aqQ, h(parama2));
        paramc.b(parama1);
        paramc.a(parama1, parama2);
        paramc.a(parama1, paramContext);
        i += 1;
      }
      i = 0;
      while (i < parama1.pj().size())
      {
        parama2 = (cr.a)parama1.pj().get(i);
        paramc = "Unknown";
        paramContext = paramc;
        if (paramag.oo())
        {
          paramContext = paramc;
          if (i < parama1.pg().size()) {
            paramContext = (String)parama1.pg().get(i);
          }
        }
        paramc = e(this.aqQ, h(parama2));
        paramc.b(parama1);
        paramc.b(parama1, parama2);
        paramc.b(parama1, paramContext);
        i += 1;
      }
    }
    paramContext = this.aqI.oX().entrySet().iterator();
    while (paramContext.hasNext())
    {
      paramc = (Map.Entry)paramContext.next();
      paramDataLayer = ((List)paramc.getValue()).iterator();
      while (paramDataLayer.hasNext())
      {
        parama1 = (cr.a)paramDataLayer.next();
        if (!di.n((d.a)parama1.oS().get(com.google.android.gms.internal.b.dG.toString())).booleanValue()) {
          e(this.aqQ, (String)paramc.getKey()).i(parama1);
        }
      }
    }
  }
  
  private bz<d.a> a(d.a parama, Set<String> paramSet, dl paramdl)
  {
    if (!parama.gF) {
      return new bz(parama, true);
    }
    bz localbz1;
    switch (parama.type)
    {
    case 5: 
    case 6: 
    default: 
      bh.T("Unknown type: " + parama.type);
      return aqH;
    case 2: 
      locala = cr.g(parama);
      locala.gw = new d.a[parama.gw.length];
      i = 0;
      while (i < parama.gw.length)
      {
        localbz1 = a(parama.gw[i], paramSet, paramdl.fh(i));
        if (localbz1 == aqH) {
          return aqH;
        }
        locala.gw[i] = ((d.a)localbz1.getObject());
        i += 1;
      }
      return new bz(locala, false);
    case 3: 
      locala = cr.g(parama);
      if (parama.gx.length != parama.gy.length)
      {
        bh.T("Invalid serving value: " + parama.toString());
        return aqH;
      }
      locala.gx = new d.a[parama.gx.length];
      locala.gy = new d.a[parama.gx.length];
      i = 0;
      while (i < parama.gx.length)
      {
        localbz1 = a(parama.gx[i], paramSet, paramdl.fi(i));
        bz localbz2 = a(parama.gy[i], paramSet, paramdl.fj(i));
        if ((localbz1 == aqH) || (localbz2 == aqH)) {
          return aqH;
        }
        locala.gx[i] = ((d.a)localbz1.getObject());
        locala.gy[i] = ((d.a)localbz2.getObject());
        i += 1;
      }
      return new bz(locala, false);
    case 4: 
      if (paramSet.contains(parama.gz))
      {
        bh.T("Macro cycle detected.  Current macro reference: " + parama.gz + "." + "  Previous macro references: " + paramSet.toString() + ".");
        return aqH;
      }
      paramSet.add(parama.gz);
      paramdl = dm.a(a(parama.gz, paramSet, paramdl.oD()), parama.gE);
      paramSet.remove(parama.gz);
      return paramdl;
    }
    d.a locala = cr.g(parama);
    locala.gD = new d.a[parama.gD.length];
    int i = 0;
    while (i < parama.gD.length)
    {
      localbz1 = a(parama.gD[i], paramSet, paramdl.fk(i));
      if (localbz1 == aqH) {
        return aqH;
      }
      locala.gD[i] = ((d.a)localbz1.getObject());
      i += 1;
    }
    return new bz(locala, false);
  }
  
  private bz<d.a> a(String paramString, Set<String> paramSet, bk parambk)
  {
    this.aqS += 1;
    Object localObject = (b)this.aqO.get(paramString);
    if ((localObject != null) && (!this.aqJ.oo()))
    {
      a(((b)localObject).oT(), paramSet);
      this.aqS -= 1;
      return ((b)localObject).pn();
    }
    localObject = (c)this.aqQ.get(paramString);
    if (localObject == null)
    {
      bh.T(pm() + "Invalid macro: " + paramString);
      this.aqS -= 1;
      return aqH;
    }
    bz localbz = a(paramString, ((c)localObject).po(), ((c)localObject).pp(), ((c)localObject).pq(), ((c)localObject).ps(), ((c)localObject).pr(), paramSet, parambk.of());
    if (((Set)localbz.getObject()).isEmpty()) {}
    for (localObject = ((c)localObject).pt(); localObject == null; localObject = (cr.a)((Set)localbz.getObject()).iterator().next())
    {
      this.aqS -= 1;
      return aqH;
      if (((Set)localbz.getObject()).size() > 1) {
        bh.W(pm() + "Multiple macros active for macroName " + paramString);
      }
    }
    parambk = a(this.aqM, (cr.a)localObject, paramSet, parambk.ou());
    boolean bool;
    if ((localbz.oE()) && (parambk.oE()))
    {
      bool = true;
      if (parambk != aqH) {
        break label392;
      }
    }
    label392:
    for (parambk = aqH;; parambk = new bz(parambk.getObject(), bool))
    {
      localObject = ((cr.a)localObject).oT();
      if (parambk.oE()) {
        this.aqO.e(paramString, new b(parambk, (d.a)localObject));
      }
      a((d.a)localObject, paramSet);
      this.aqS -= 1;
      return parambk;
      bool = false;
      break;
    }
  }
  
  private bz<d.a> a(Map<String, aj> paramMap, cr.a parama, Set<String> paramSet, ck paramck)
  {
    boolean bool = true;
    Object localObject1 = (d.a)parama.oS().get(com.google.android.gms.internal.b.cU.toString());
    if (localObject1 == null)
    {
      bh.T("No function id in properties");
      paramMap = aqH;
    }
    aj localaj;
    do
    {
      return paramMap;
      localObject1 = ((d.a)localObject1).gA;
      localaj = (aj)paramMap.get(localObject1);
      if (localaj == null)
      {
        bh.T((String)localObject1 + " has no backing implementation.");
        return aqH;
      }
      paramMap = (bz)this.aqN.get(parama);
    } while ((paramMap != null) && (!this.aqJ.oo()));
    paramMap = new HashMap();
    Iterator localIterator = parama.oS().entrySet().iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject2 = paramck.cE((String)localEntry.getKey());
      localObject2 = a((d.a)localEntry.getValue(), paramSet, ((cm)localObject2).e((d.a)localEntry.getValue()));
      if (localObject2 == aqH) {
        return aqH;
      }
      if (((bz)localObject2).oE()) {
        parama.a((String)localEntry.getKey(), (d.a)((bz)localObject2).getObject());
      }
      for (;;)
      {
        paramMap.put(localEntry.getKey(), ((bz)localObject2).getObject());
        break;
        i = 0;
      }
    }
    if (!localaj.a(paramMap.keySet()))
    {
      bh.T("Incorrect keys for function " + (String)localObject1 + " required " + localaj.oq() + " had " + paramMap.keySet());
      return aqH;
    }
    if ((i != 0) && (localaj.nL())) {}
    for (;;)
    {
      paramMap = new bz(localaj.C(paramMap), bool);
      if (bool) {
        this.aqN.e(parama, paramMap);
      }
      paramck.d((d.a)paramMap.getObject());
      return paramMap;
      bool = false;
    }
  }
  
  private bz<Set<cr.a>> a(Set<cr.e> paramSet, Set<String> paramSet1, a parama, cs paramcs)
  {
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    paramSet = paramSet.iterator();
    boolean bool = true;
    if (paramSet.hasNext())
    {
      cr.e locale = (cr.e)paramSet.next();
      cn localcn = paramcs.oC();
      bz localbz = a(locale, paramSet1, localcn);
      if (((Boolean)localbz.getObject()).booleanValue()) {
        parama.a(locale, localHashSet1, localHashSet2, localcn);
      }
      if ((bool) && (localbz.oE())) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    localHashSet1.removeAll(localHashSet2);
    paramcs.b(localHashSet1);
    return new bz(localHashSet1, bool);
  }
  
  private void a(d.a parama, Set<String> paramSet)
  {
    if (parama == null) {}
    for (;;)
    {
      return;
      parama = a(parama, paramSet, new bx());
      if (parama != aqH)
      {
        parama = di.o((d.a)parama.getObject());
        if ((parama instanceof Map))
        {
          parama = (Map)parama;
          this.anS.push(parama);
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
            this.anS.push(paramSet);
          }
          else
          {
            bh.W("pushAfterEvaluate: value not a Map");
          }
        }
      }
    }
    bh.W("pushAfterEvaluate: value not a Map or List");
  }
  
  private static void a(List<cr.a> paramList, List<String> paramList1, String paramString)
  {
    if (paramList.size() != paramList1.size()) {
      bh.U("Invalid resource: imbalance of rule names of functions for " + paramString + " operation. Using default rule name instead");
    }
  }
  
  private static void a(Map<String, aj> paramMap, aj paramaj)
  {
    if (paramMap.containsKey(paramaj.op())) {
      throw new IllegalArgumentException("Duplicate function type name: " + paramaj.op());
    }
    paramMap.put(paramaj.op(), paramaj);
  }
  
  private static c e(Map<String, c> paramMap, String paramString)
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
  
  private static String h(cr.a parama)
  {
    return di.j((d.a)parama.oS().get(com.google.android.gms.internal.b.df.toString()));
  }
  
  private String pm()
  {
    if (this.aqS <= 1) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Integer.toString(this.aqS));
    int i = 2;
    while (i < this.aqS)
    {
      localStringBuilder.append(' ');
      i += 1;
    }
    localStringBuilder.append(": ");
    return localStringBuilder.toString();
  }
  
  bz<Boolean> a(cr.a parama, Set<String> paramSet, ck paramck)
  {
    parama = a(this.aqL, parama, paramSet, paramck);
    paramSet = di.n((d.a)parama.getObject());
    paramck.d(di.u(paramSet));
    return new bz(paramSet, parama.oE());
  }
  
  bz<Boolean> a(cr.e parame, Set<String> paramSet, cn paramcn)
  {
    Object localObject = parame.pb().iterator();
    boolean bool = true;
    if (((Iterator)localObject).hasNext())
    {
      bz localbz = a((cr.a)((Iterator)localObject).next(), paramSet, paramcn.ow());
      if (((Boolean)localbz.getObject()).booleanValue())
      {
        paramcn.f(di.u(Boolean.valueOf(false)));
        return new bz(Boolean.valueOf(false), localbz.oE());
      }
      if ((bool) && (localbz.oE())) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    parame = parame.pa().iterator();
    while (parame.hasNext())
    {
      localObject = a((cr.a)parame.next(), paramSet, paramcn.ox());
      if (!((Boolean)((bz)localObject).getObject()).booleanValue())
      {
        paramcn.f(di.u(Boolean.valueOf(false)));
        return new bz(Boolean.valueOf(false), ((bz)localObject).oE());
      }
      if ((bool) && (((bz)localObject).oE())) {
        bool = true;
      } else {
        bool = false;
      }
    }
    paramcn.f(di.u(Boolean.valueOf(true)));
    return new bz(Boolean.valueOf(true), bool);
  }
  
  bz<Set<cr.a>> a(String paramString, Set<cr.e> paramSet, final Map<cr.e, List<cr.a>> paramMap1, final Map<cr.e, List<String>> paramMap2, final Map<cr.e, List<cr.a>> paramMap3, final Map<cr.e, List<String>> paramMap4, Set<String> paramSet1, cs paramcs)
  {
    a(paramSet, paramSet1, new a()
    {
      public void a(cr.e paramAnonymouse, Set<cr.a> paramAnonymousSet1, Set<cr.a> paramAnonymousSet2, cn paramAnonymouscn)
      {
        List localList1 = (List)paramMap1.get(paramAnonymouse);
        List localList2 = (List)paramMap2.get(paramAnonymouse);
        if (localList1 != null)
        {
          paramAnonymousSet1.addAll(localList1);
          paramAnonymouscn.oy().c(localList1, localList2);
        }
        paramAnonymousSet1 = (List)paramMap3.get(paramAnonymouse);
        paramAnonymouse = (List)paramMap4.get(paramAnonymouse);
        if (paramAnonymousSet1 != null)
        {
          paramAnonymousSet2.addAll(paramAnonymousSet1);
          paramAnonymouscn.oz().c(paramAnonymousSet1, paramAnonymouse);
        }
      }
    }, paramcs);
  }
  
  bz<Set<cr.a>> a(Set<cr.e> paramSet, cs paramcs)
  {
    a(paramSet, new HashSet(), new a()
    {
      public void a(cr.e paramAnonymouse, Set<cr.a> paramAnonymousSet1, Set<cr.a> paramAnonymousSet2, cn paramAnonymouscn)
      {
        paramAnonymousSet1.addAll(paramAnonymouse.pc());
        paramAnonymousSet2.addAll(paramAnonymouse.pd());
        paramAnonymouscn.oA().c(paramAnonymouse.pc(), paramAnonymouse.ph());
        paramAnonymouscn.oB().c(paramAnonymouse.pd(), paramAnonymouse.pi());
      }
    }, paramcs);
  }
  
  void a(aj paramaj)
  {
    a(this.aqM, paramaj);
  }
  
  void b(aj paramaj)
  {
    a(this.aqK, paramaj);
  }
  
  void c(aj paramaj)
  {
    a(this.aqL, paramaj);
  }
  
  public bz<d.a> cO(String paramString)
  {
    this.aqS = 0;
    af localaf = this.aqJ.cx(paramString);
    paramString = a(paramString, new HashSet(), localaf.ol());
    localaf.on();
    return paramString;
  }
  
  void cP(String paramString)
  {
    try
    {
      this.aqR = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void cm(String paramString)
  {
    try
    {
      cP(paramString);
      paramString = this.aqJ.cy(paramString);
      t localt = paramString.om();
      Iterator localIterator = ((Set)a(this.aqP, localt.of()).getObject()).iterator();
      while (localIterator.hasNext())
      {
        cr.a locala = (cr.a)localIterator.next();
        a(this.aqK, locala, new HashSet(), localt.oe());
      }
      paramString.on();
    }
    finally {}
    cP(null);
  }
  
  public void k(List<c.i> paramList)
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
          bh.V("Ignored supplemental: " + locali);
        } else {
          ai.a(this.anS, locali);
        }
      }
      finally {}
    }
  }
  
  String pl()
  {
    try
    {
      String str = this.aqR;
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
    public abstract void a(cr.e parame, Set<cr.a> paramSet1, Set<cr.a> paramSet2, cn paramcn);
  }
  
  private static class b
  {
    private bz<d.a> aqY;
    private d.a aqt;
    
    public b(bz<d.a> parambz, d.a parama)
    {
      this.aqY = parambz;
      this.aqt = parama;
    }
    
    public int getSize()
    {
      int j = ((d.a)this.aqY.getObject()).qF();
      if (this.aqt == null) {}
      for (int i = 0;; i = this.aqt.qF()) {
        return i + j;
      }
    }
    
    public d.a oT()
    {
      return this.aqt;
    }
    
    public bz<d.a> pn()
    {
      return this.aqY;
    }
  }
  
  private static class c
  {
    private final Set<cr.e> aqP = new HashSet();
    private final Map<cr.e, List<cr.a>> aqZ = new HashMap();
    private final Map<cr.e, List<cr.a>> ara = new HashMap();
    private final Map<cr.e, List<String>> arb = new HashMap();
    private final Map<cr.e, List<String>> arc = new HashMap();
    private cr.a ard;
    
    public void a(cr.e parame, cr.a parama)
    {
      List localList = (List)this.aqZ.get(parame);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.aqZ.put(parame, localObject);
      }
      ((List)localObject).add(parama);
    }
    
    public void a(cr.e parame, String paramString)
    {
      List localList = (List)this.arb.get(parame);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.arb.put(parame, localObject);
      }
      ((List)localObject).add(paramString);
    }
    
    public void b(cr.e parame)
    {
      this.aqP.add(parame);
    }
    
    public void b(cr.e parame, cr.a parama)
    {
      List localList = (List)this.ara.get(parame);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.ara.put(parame, localObject);
      }
      ((List)localObject).add(parama);
    }
    
    public void b(cr.e parame, String paramString)
    {
      List localList = (List)this.arc.get(parame);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.arc.put(parame, localObject);
      }
      ((List)localObject).add(paramString);
    }
    
    public void i(cr.a parama)
    {
      this.ard = parama;
    }
    
    public Set<cr.e> po()
    {
      return this.aqP;
    }
    
    public Map<cr.e, List<cr.a>> pp()
    {
      return this.aqZ;
    }
    
    public Map<cr.e, List<String>> pq()
    {
      return this.arb;
    }
    
    public Map<cr.e, List<String>> pr()
    {
      return this.arc;
    }
    
    public Map<cr.e, List<cr.a>> ps()
    {
      return this.ara;
    }
    
    public cr.a pt()
    {
      return this.ard;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */