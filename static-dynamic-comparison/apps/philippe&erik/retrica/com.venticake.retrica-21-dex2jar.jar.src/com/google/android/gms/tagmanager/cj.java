package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.c.i;
import com.google.android.gms.internal.d.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class cj
{
  private static final bj<d.a> a = new bj(de.g(), true);
  private final cq.c b;
  private final p c;
  private final Map<String, t> d;
  private final Map<String, t> e;
  private final Map<String, t> f;
  private final dn<cq.a, bj<d.a>> g;
  private final dn<String, cl> h;
  private final Set<cq.e> i;
  private final DataLayer j;
  private final Map<String, cm> k;
  private volatile String l;
  private int m;
  
  public cj(Context paramContext, cq.c paramc, DataLayer paramDataLayer, s.a parama1, s.a parama2, p paramp)
  {
    if (paramc == null) {
      throw new NullPointerException("resource cannot be null");
    }
    this.b = paramc;
    this.i = new HashSet(paramc.ms());
    this.j = paramDataLayer;
    this.c = paramp;
    paramc = new l.a()
    {
      public int a(cq.a paramAnonymousa, bj<d.a> paramAnonymousbj)
      {
        return ((d.a)paramAnonymousbj.a()).nZ();
      }
    };
    this.g = new l().a(1048576, paramc);
    paramc = new l.a()
    {
      public int a(String paramAnonymousString, cl paramAnonymouscl)
      {
        return paramAnonymousString.length() + paramAnonymouscl.c();
      }
    };
    this.h = new l().a(1048576, paramc);
    this.d = new HashMap();
    b(new i(paramContext));
    b(new s(parama2));
    b(new ef(paramDataLayer));
    b(new df(paramContext, paramDataLayer));
    this.e = new HashMap();
    c(new dy());
    c(new k());
    c(new m());
    c(new v());
    c(new w());
    c(new ap());
    c(new aq());
    c(new bx());
    c(new cw());
    this.f = new HashMap();
    a(new al(paramContext));
    a(new bl(paramContext));
    a(new di(paramContext));
    a(new dj(paramContext));
    a(new dk(paramContext));
    a(new dl(paramContext));
    a(new do());
    a(new dx(this.b.getVersion()));
    a(new s(parama1));
    a(new eb(paramDataLayer));
    a(new ei(paramContext));
    a(new g());
    a(new j());
    a(new q(this));
    a(new x());
    a(new y());
    a(new ah(paramContext));
    a(new aj());
    a(new ao());
    a(new av(paramContext));
    a(new bk());
    a(new bp());
    a(new bt());
    a(new bw());
    a(new by(paramContext));
    a(new cn());
    a(new co());
    a(new cy());
    this.k = new HashMap();
    paramDataLayer = this.i.iterator();
    while (paramDataLayer.hasNext())
    {
      parama1 = (cq.e)paramDataLayer.next();
      if (paramp.a())
      {
        a(parama1.mA(), parama1.mB(), "add macro");
        a(parama1.mF(), parama1.mC(), "remove macro");
        a(parama1.my(), parama1.mD(), "add tag");
        a(parama1.mz(), parama1.mE(), "remove tag");
      }
      int n = 0;
      while (n < parama1.mA().size())
      {
        parama2 = (cq.a)parama1.mA().get(n);
        paramc = "Unknown";
        paramContext = paramc;
        if (paramp.a())
        {
          paramContext = paramc;
          if (n < parama1.mB().size()) {
            paramContext = (String)parama1.mB().get(n);
          }
        }
        paramc = a(this.k, a(parama2));
        paramc.a(parama1);
        paramc.a(parama1, parama2);
        paramc.a(parama1, paramContext);
        n += 1;
      }
      n = 0;
      while (n < parama1.mF().size())
      {
        parama2 = (cq.a)parama1.mF().get(n);
        paramc = "Unknown";
        paramContext = paramc;
        if (paramp.a())
        {
          paramContext = paramc;
          if (n < parama1.mC().size()) {
            paramContext = (String)parama1.mC().get(n);
          }
        }
        paramc = a(this.k, a(parama2));
        paramc.a(parama1);
        paramc.b(parama1, parama2);
        paramc.b(parama1, paramContext);
        n += 1;
      }
    }
    paramContext = this.b.mt().entrySet().iterator();
    while (paramContext.hasNext())
    {
      paramc = (Map.Entry)paramContext.next();
      paramDataLayer = ((List)paramc.getValue()).iterator();
      while (paramDataLayer.hasNext())
      {
        parama1 = (cq.a)paramDataLayer.next();
        if (!de.e((d.a)parama1.mo().get(b.dh.toString())).booleanValue()) {
          a(this.k, (String)paramc.getKey()).a(parama1);
        }
      }
    }
  }
  
  private bj<d.a> a(d.a parama, Set<String> paramSet, dg paramdg)
  {
    if (!parama.fX) {
      return new bj(parama, true);
    }
    bj localbj1;
    switch (parama.type)
    {
    case 5: 
    case 6: 
    default: 
      as.a("Unknown type: " + parama.type);
      return a;
    case 2: 
      locala = cq.a(parama);
      locala.fO = new d.a[parama.fO.length];
      n = 0;
      while (n < parama.fO.length)
      {
        localbj1 = a(parama.fO[n], paramSet, paramdg.a(n));
        if (localbj1 == a) {
          return a;
        }
        locala.fO[n] = ((d.a)localbj1.a());
        n += 1;
      }
      return new bj(locala, false);
    case 3: 
      locala = cq.a(parama);
      if (parama.fP.length != parama.fQ.length)
      {
        as.a("Invalid serving value: " + parama.toString());
        return a;
      }
      locala.fP = new d.a[parama.fP.length];
      locala.fQ = new d.a[parama.fP.length];
      n = 0;
      while (n < parama.fP.length)
      {
        localbj1 = a(parama.fP[n], paramSet, paramdg.b(n));
        bj localbj2 = a(parama.fQ[n], paramSet, paramdg.c(n));
        if ((localbj1 == a) || (localbj2 == a)) {
          return a;
        }
        locala.fP[n] = ((d.a)localbj1.a());
        locala.fQ[n] = ((d.a)localbj2.a());
        n += 1;
      }
      return new bj(locala, false);
    case 4: 
      if (paramSet.contains(parama.fR))
      {
        as.a("Macro cycle detected.  Current macro reference: " + parama.fR + "." + "  Previous macro references: " + paramSet.toString() + ".");
        return a;
      }
      paramSet.add(parama.fR);
      paramdg = dh.a(a(parama.fR, paramSet, paramdg.a()), parama.fW);
      paramSet.remove(parama.fR);
      return paramdg;
    }
    d.a locala = cq.a(parama);
    locala.fV = new d.a[parama.fV.length];
    int n = 0;
    while (n < parama.fV.length)
    {
      localbj1 = a(parama.fV[n], paramSet, paramdg.d(n));
      if (localbj1 == a) {
        return a;
      }
      locala.fV[n] = ((d.a)localbj1.a());
      n += 1;
    }
    return new bj(locala, false);
  }
  
  private bj<d.a> a(String paramString, Set<String> paramSet, au paramau)
  {
    this.m += 1;
    Object localObject = (cl)this.h.a(paramString);
    if ((localObject != null) && (!this.c.a()))
    {
      a(((cl)localObject).b(), paramSet);
      this.m -= 1;
      return ((cl)localObject).a();
    }
    localObject = (cm)this.k.get(paramString);
    if (localObject == null)
    {
      as.a(b() + "Invalid macro: " + paramString);
      this.m -= 1;
      return a;
    }
    bj localbj = a(paramString, ((cm)localObject).a(), ((cm)localObject).b(), ((cm)localObject).c(), ((cm)localObject).e(), ((cm)localObject).d(), paramSet, paramau.b());
    if (((Set)localbj.a()).isEmpty()) {}
    for (localObject = ((cm)localObject).f(); localObject == null; localObject = (cq.a)((Set)localbj.a()).iterator().next())
    {
      this.m -= 1;
      return a;
      if (((Set)localbj.a()).size() > 1) {
        as.b(b() + "Multiple macros active for macroName " + paramString);
      }
    }
    paramau = a(this.f, (cq.a)localObject, paramSet, paramau.a());
    boolean bool;
    if ((localbj.b()) && (paramau.b()))
    {
      bool = true;
      if (paramau != a) {
        break label392;
      }
    }
    label392:
    for (paramau = a;; paramau = new bj(paramau.a(), bool))
    {
      localObject = ((cq.a)localObject).mp();
      if (paramau.b()) {
        this.h.a(paramString, new cl(paramau, (d.a)localObject));
      }
      a((d.a)localObject, paramSet);
      this.m -= 1;
      return paramau;
      bool = false;
      break;
    }
  }
  
  private bj<d.a> a(Map<String, t> paramMap, cq.a parama, Set<String> paramSet, bz parambz)
  {
    boolean bool = true;
    Object localObject1 = (d.a)parama.mo().get(b.cx.toString());
    if (localObject1 == null)
    {
      as.a("No function id in properties");
      paramMap = a;
    }
    t localt;
    do
    {
      return paramMap;
      localObject1 = ((d.a)localObject1).fS;
      localt = (t)paramMap.get(localObject1);
      if (localt == null)
      {
        as.a((String)localObject1 + " has no backing implementation.");
        return a;
      }
      paramMap = (bj)this.g.a(parama);
    } while ((paramMap != null) && (!this.c.a()));
    paramMap = new HashMap();
    Iterator localIterator = parama.mo().entrySet().iterator();
    int n = 1;
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject2 = parambz.a((String)localEntry.getKey());
      localObject2 = a((d.a)localEntry.getValue(), paramSet, ((cb)localObject2).a((d.a)localEntry.getValue()));
      if (localObject2 == a) {
        return a;
      }
      if (((bj)localObject2).b()) {
        parama.a((String)localEntry.getKey(), (d.a)((bj)localObject2).a());
      }
      for (;;)
      {
        paramMap.put(localEntry.getKey(), ((bj)localObject2).a());
        break;
        n = 0;
      }
    }
    if (!localt.a(paramMap.keySet()))
    {
      as.a("Incorrect keys for function " + (String)localObject1 + " required " + localt.c() + " had " + paramMap.keySet());
      return a;
    }
    if ((n != 0) && (localt.a())) {}
    for (;;)
    {
      paramMap = new bj(localt.a(paramMap), bool);
      if (bool) {
        this.g.a(parama, paramMap);
      }
      parambz.a((d.a)paramMap.a());
      return paramMap;
      bool = false;
    }
  }
  
  private bj<Set<cq.a>> a(Set<cq.e> paramSet, Set<String> paramSet1, ck paramck, ci paramci)
  {
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    paramSet = paramSet.iterator();
    boolean bool = true;
    if (paramSet.hasNext())
    {
      cq.e locale = (cq.e)paramSet.next();
      cc localcc = paramci.a();
      bj localbj = a(locale, paramSet1, localcc);
      if (((Boolean)localbj.a()).booleanValue()) {
        paramck.a(locale, localHashSet1, localHashSet2, localcc);
      }
      if ((bool) && (localbj.b())) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    localHashSet1.removeAll(localHashSet2);
    paramci.a(localHashSet1);
    return new bj(localHashSet1, bool);
  }
  
  private static cm a(Map<String, cm> paramMap, String paramString)
  {
    cm localcm2 = (cm)paramMap.get(paramString);
    cm localcm1 = localcm2;
    if (localcm2 == null)
    {
      localcm1 = new cm();
      paramMap.put(paramString, localcm1);
    }
    return localcm1;
  }
  
  private static String a(cq.a parama)
  {
    return de.a((d.a)parama.mo().get(b.cI.toString()));
  }
  
  private void a(d.a parama, Set<String> paramSet)
  {
    if (parama == null) {}
    for (;;)
    {
      return;
      parama = a(parama, paramSet, new bh());
      if (parama != a)
      {
        parama = de.f((d.a)parama.a());
        if ((parama instanceof Map))
        {
          parama = (Map)parama;
          this.j.push(parama);
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
            this.j.push(paramSet);
          }
          else
          {
            as.b("pushAfterEvaluate: value not a Map");
          }
        }
      }
    }
    as.b("pushAfterEvaluate: value not a Map or List");
  }
  
  private static void a(List<cq.a> paramList, List<String> paramList1, String paramString)
  {
    if (paramList.size() != paramList1.size()) {
      as.c("Invalid resource: imbalance of rule names of functions for " + paramString + " operation. Using default rule name instead");
    }
  }
  
  private static void a(Map<String, t> paramMap, t paramt)
  {
    if (paramMap.containsKey(paramt.b())) {
      throw new IllegalArgumentException("Duplicate function type name: " + paramt.b());
    }
    paramMap.put(paramt.b(), paramt);
  }
  
  private String b()
  {
    if (this.m <= 1) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Integer.toString(this.m));
    int n = 2;
    while (n < this.m)
    {
      localStringBuilder.append(' ');
      n += 1;
    }
    localStringBuilder.append(": ");
    return localStringBuilder.toString();
  }
  
  bj<Boolean> a(cq.a parama, Set<String> paramSet, bz parambz)
  {
    parama = a(this.e, parama, paramSet, parambz);
    paramSet = de.e((d.a)parama.a());
    parambz.a(de.f(paramSet));
    return new bj(paramSet, parama.b());
  }
  
  bj<Boolean> a(cq.e parame, Set<String> paramSet, cc paramcc)
  {
    Object localObject = parame.mx().iterator();
    boolean bool = true;
    if (((Iterator)localObject).hasNext())
    {
      bj localbj = a((cq.a)((Iterator)localObject).next(), paramSet, paramcc.a());
      if (((Boolean)localbj.a()).booleanValue())
      {
        paramcc.a(de.f(Boolean.valueOf(false)));
        return new bj(Boolean.valueOf(false), localbj.b());
      }
      if ((bool) && (localbj.b())) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    parame = parame.mw().iterator();
    while (parame.hasNext())
    {
      localObject = a((cq.a)parame.next(), paramSet, paramcc.b());
      if (!((Boolean)((bj)localObject).a()).booleanValue())
      {
        paramcc.a(de.f(Boolean.valueOf(false)));
        return new bj(Boolean.valueOf(false), ((bj)localObject).b());
      }
      if ((bool) && (((bj)localObject).b())) {
        bool = true;
      } else {
        bool = false;
      }
    }
    paramcc.a(de.f(Boolean.valueOf(true)));
    return new bj(Boolean.valueOf(true), bool);
  }
  
  bj<Set<cq.a>> a(String paramString, Set<cq.e> paramSet, final Map<cq.e, List<cq.a>> paramMap1, final Map<cq.e, List<String>> paramMap2, final Map<cq.e, List<cq.a>> paramMap3, final Map<cq.e, List<String>> paramMap4, Set<String> paramSet1, ci paramci)
  {
    a(paramSet, paramSet1, new ck()
    {
      public void a(cq.e paramAnonymouse, Set<cq.a> paramAnonymousSet1, Set<cq.a> paramAnonymousSet2, cc paramAnonymouscc)
      {
        List localList1 = (List)paramMap1.get(paramAnonymouse);
        List localList2 = (List)paramMap2.get(paramAnonymouse);
        if (localList1 != null)
        {
          paramAnonymousSet1.addAll(localList1);
          paramAnonymouscc.c().b(localList1, localList2);
        }
        paramAnonymousSet1 = (List)paramMap3.get(paramAnonymouse);
        paramAnonymouse = (List)paramMap4.get(paramAnonymouse);
        if (paramAnonymousSet1 != null)
        {
          paramAnonymousSet2.addAll(paramAnonymousSet1);
          paramAnonymouscc.d().b(paramAnonymousSet1, paramAnonymouse);
        }
      }
    }, paramci);
  }
  
  bj<Set<cq.a>> a(Set<cq.e> paramSet, ci paramci)
  {
    a(paramSet, new HashSet(), new ck()
    {
      public void a(cq.e paramAnonymouse, Set<cq.a> paramAnonymousSet1, Set<cq.a> paramAnonymousSet2, cc paramAnonymouscc)
      {
        paramAnonymousSet1.addAll(paramAnonymouse.my());
        paramAnonymousSet2.addAll(paramAnonymouse.mz());
        paramAnonymouscc.e().b(paramAnonymouse.my(), paramAnonymouse.mD());
        paramAnonymouscc.f().b(paramAnonymouse.mz(), paramAnonymouse.mE());
      }
    }, paramci);
  }
  
  String a()
  {
    try
    {
      String str = this.l;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void a(t paramt)
  {
    a(this.f, paramt);
  }
  
  public void a(String paramString)
  {
    try
    {
      c(paramString);
      paramString = this.c.b(paramString);
      ea localea = paramString.b();
      Iterator localIterator = ((Set)a(this.i, localea.b()).a()).iterator();
      while (localIterator.hasNext())
      {
        cq.a locala = (cq.a)localIterator.next();
        a(this.d, locala, new HashSet(), localea.a());
      }
      paramString.c();
    }
    finally {}
    c(null);
  }
  
  public void a(List<c.i> paramList)
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
          as.e("Ignored supplemental: " + locali);
        } else {
          r.a(this.j, locali);
        }
      }
      finally {}
    }
  }
  
  public bj<d.a> b(String paramString)
  {
    this.m = 0;
    o localo = this.c.a(paramString);
    paramString = a(paramString, new HashSet(), localo.a());
    localo.c();
    return paramString;
  }
  
  void b(t paramt)
  {
    a(this.d, paramt);
  }
  
  void c(t paramt)
  {
    a(this.e, paramt);
  }
  
  void c(String paramString)
  {
    try
    {
      this.l = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */