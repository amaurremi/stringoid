package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.b;
import com.google.android.gms.internal.cc.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class y
{
  private static final s<cc.a> Xn = new s(ab.wx(), true);
  private final c WI;
  private final f Xo;
  private final Map<String, g> Xp;
  private final Map<String, g> Xq;
  private final Map<String, g> Xr;
  private final ae<cr.a, s<cc.a>> Xs;
  private final ae<String, b> Xt;
  private final Set<cr.b> Xu;
  private final Map<String, c> Xv;
  private volatile String Xw;
  private int Xx;
  
  private s<cc.a> a(cc.a parama, Set<String> paramSet, ac paramac)
  {
    if (!parama.FI) {
      return new s(parama, true);
    }
    s locals1;
    switch (parama.type)
    {
    case 5: 
    case 6: 
    default: 
      j.Z("Unknown type: " + parama.type);
      return Xn;
    case 2: 
      locala = cr.d(parama);
      locala.Fz = new cc.a[parama.Fz.length];
      i = 0;
      while (i < parama.Fz.length)
      {
        locals1 = a(parama.Fz[i], paramSet, paramac.ej(i));
        if (locals1 == Xn) {
          return Xn;
        }
        locala.Fz[i] = ((cc.a)locals1.getObject());
        i += 1;
      }
      return new s(locala, false);
    case 3: 
      locala = cr.d(parama);
      if (parama.FA.length != parama.FB.length)
      {
        j.Z("Invalid serving value: " + parama.toString());
        return Xn;
      }
      locala.FA = new cc.a[parama.FA.length];
      locala.FB = new cc.a[parama.FA.length];
      i = 0;
      while (i < parama.FA.length)
      {
        locals1 = a(parama.FA[i], paramSet, paramac.ek(i));
        s locals2 = a(parama.FB[i], paramSet, paramac.el(i));
        if ((locals1 == Xn) || (locals2 == Xn)) {
          return Xn;
        }
        locala.FA[i] = ((cc.a)locals1.getObject());
        locala.FB[i] = ((cc.a)locals2.getObject());
        i += 1;
      }
      return new s(locala, false);
    case 4: 
      if (paramSet.contains(parama.FC))
      {
        j.Z("Macro cycle detected.  Current macro reference: " + parama.FC + "." + "  Previous macro references: " + paramSet.toString() + ".");
        return Xn;
      }
      paramSet.add(parama.FC);
      paramac = ad.a(a(parama.FC, paramSet, paramac.vV()), parama.FH);
      paramSet.remove(parama.FC);
      return paramac;
    }
    cc.a locala = cr.d(parama);
    locala.FG = new cc.a[parama.FG.length];
    int i = 0;
    while (i < parama.FG.length)
    {
      locals1 = a(parama.FG[i], paramSet, paramac.em(i));
      if (locals1 == Xn) {
        return Xn;
      }
      locala.FG[i] = ((cc.a)locals1.getObject());
      i += 1;
    }
    return new s(locala, false);
  }
  
  private s<cc.a> a(String paramString, Set<String> paramSet, l paraml)
  {
    this.Xx += 1;
    Object localObject = (b)this.Xt.get(paramString);
    if ((localObject != null) && (!this.Xo.vJ()))
    {
      a(((b)localObject).wb(), paramSet);
      this.Xx -= 1;
      return ((b)localObject).wl();
    }
    localObject = (c)this.Xv.get(paramString);
    if (localObject == null)
    {
      j.Z(wk() + "Invalid macro: " + paramString);
      this.Xx -= 1;
      return Xn;
    }
    s locals = a(paramString, ((c)localObject).wm(), ((c)localObject).wn(), ((c)localObject).wo(), ((c)localObject).wq(), ((c)localObject).wp(), paramSet, paraml.vN());
    if (((Set)locals.getObject()).isEmpty()) {}
    for (localObject = ((c)localObject).wr(); localObject == null; localObject = (cr.a)((Set)locals.getObject()).iterator().next())
    {
      this.Xx -= 1;
      return Xn;
      if (((Set)locals.getObject()).size() > 1) {
        j.D(wk() + "Multiple macros active for macroName " + paramString);
      }
    }
    paraml = a(this.Xr, (cr.a)localObject, paramSet, paraml.vM());
    boolean bool;
    if ((locals.vW()) && (paraml.vW()))
    {
      bool = true;
      if (paraml != Xn) {
        break label390;
      }
    }
    label390:
    for (paraml = Xn;; paraml = new s(paraml.getObject(), bool))
    {
      localObject = ((cr.a)localObject).wb();
      if (paraml.vW()) {
        this.Xt.g(paramString, new b(paraml, (cc.a)localObject));
      }
      a((cc.a)localObject, paramSet);
      this.Xx -= 1;
      return paraml;
      bool = false;
      break;
    }
  }
  
  private s<cc.a> a(Map<String, g> paramMap, cr.a parama, Set<String> paramSet, t paramt)
  {
    boolean bool = true;
    Object localObject1 = (cc.a)parama.wa().get(b.zR.toString());
    if (localObject1 == null)
    {
      j.Z("No function id in properties");
      paramMap = Xn;
    }
    g localg;
    do
    {
      return paramMap;
      localObject1 = ((cc.a)localObject1).FD;
      localg = (g)paramMap.get(localObject1);
      if (localg == null)
      {
        j.Z((String)localObject1 + " has no backing implementation.");
        return Xn;
      }
      paramMap = (s)this.Xs.get(parama);
    } while ((paramMap != null) && (!this.Xo.vJ()));
    paramMap = new HashMap();
    Iterator localIterator = parama.wa().entrySet().iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject2 = paramt.bq((String)localEntry.getKey());
      localObject2 = a((cc.a)localEntry.getValue(), paramSet, ((v)localObject2).b((cc.a)localEntry.getValue()));
      if (localObject2 == Xn) {
        return Xn;
      }
      if (((s)localObject2).vW()) {
        parama.a((String)localEntry.getKey(), (cc.a)((s)localObject2).getObject());
      }
      for (;;)
      {
        paramMap.put(localEntry.getKey(), ((s)localObject2).getObject());
        break;
        i = 0;
      }
    }
    if (!localg.a(paramMap.keySet()))
    {
      j.Z("Incorrect keys for function " + (String)localObject1 + " required " + localg.vL() + " had " + paramMap.keySet());
      return Xn;
    }
    if ((i != 0) && (localg.vK())) {}
    for (;;)
    {
      paramMap = new s(localg.L(paramMap), bool);
      if (bool) {
        this.Xs.g(parama, paramMap);
      }
      paramt.a((cc.a)paramMap.getObject());
      return paramMap;
      bool = false;
    }
  }
  
  private s<Set<cr.a>> a(Set<cr.b> paramSet, Set<String> paramSet1, a parama, x paramx)
  {
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    paramSet = paramSet.iterator();
    boolean bool = true;
    if (paramSet.hasNext())
    {
      cr.b localb = (cr.b)paramSet.next();
      w localw = paramx.vU();
      s locals = a(localb, paramSet1, localw);
      if (((Boolean)locals.getObject()).booleanValue()) {
        parama.a(localb, localHashSet1, localHashSet2, localw);
      }
      if ((bool) && (locals.vW())) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    localHashSet1.removeAll(localHashSet2);
    paramx.b(localHashSet1);
    return new s(localHashSet1, bool);
  }
  
  private void a(cc.a parama, Set<String> paramSet)
  {
    if (parama == null) {}
    for (;;)
    {
      return;
      parama = a(parama, paramSet, new r());
      if (parama != Xn)
      {
        parama = ab.g((cc.a)parama.getObject());
        if ((parama instanceof Map))
        {
          parama = (Map)parama;
          this.WI.C(parama);
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
            this.WI.C(paramSet);
          }
          else
          {
            j.D("pushAfterEvaluate: value not a Map");
          }
        }
      }
    }
    j.D("pushAfterEvaluate: value not a Map or List");
  }
  
  private String wk()
  {
    if (this.Xx <= 1) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Integer.toString(this.Xx));
    int i = 2;
    while (i < this.Xx)
    {
      localStringBuilder.append(' ');
      i += 1;
    }
    localStringBuilder.append(": ");
    return localStringBuilder.toString();
  }
  
  s<Boolean> a(cr.a parama, Set<String> paramSet, t paramt)
  {
    parama = a(this.Xq, parama, paramSet, paramt);
    paramSet = ab.f((cc.a)parama.getObject());
    paramt.a(ab.R(paramSet));
    return new s(paramSet, parama.vW());
  }
  
  s<Boolean> a(cr.b paramb, Set<String> paramSet, w paramw)
  {
    Object localObject = paramb.wd().iterator();
    boolean bool = true;
    if (((Iterator)localObject).hasNext())
    {
      s locals = a((cr.a)((Iterator)localObject).next(), paramSet, paramw.vO());
      if (((Boolean)locals.getObject()).booleanValue())
      {
        paramw.c(ab.R(Boolean.valueOf(false)));
        return new s(Boolean.valueOf(false), locals.vW());
      }
      if ((bool) && (locals.vW())) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    paramb = paramb.wc().iterator();
    while (paramb.hasNext())
    {
      localObject = a((cr.a)paramb.next(), paramSet, paramw.vP());
      if (!((Boolean)((s)localObject).getObject()).booleanValue())
      {
        paramw.c(ab.R(Boolean.valueOf(false)));
        return new s(Boolean.valueOf(false), ((s)localObject).vW());
      }
      if ((bool) && (((s)localObject).vW())) {
        bool = true;
      } else {
        bool = false;
      }
    }
    paramw.c(ab.R(Boolean.valueOf(true)));
    return new s(Boolean.valueOf(true), bool);
  }
  
  s<Set<cr.a>> a(String paramString, Set<cr.b> paramSet, final Map<cr.b, List<cr.a>> paramMap1, final Map<cr.b, List<String>> paramMap2, final Map<cr.b, List<cr.a>> paramMap3, final Map<cr.b, List<String>> paramMap4, Set<String> paramSet1, x paramx)
  {
    a(paramSet, paramSet1, new a()
    {
      public void a(cr.b paramAnonymousb, Set<cr.a> paramAnonymousSet1, Set<cr.a> paramAnonymousSet2, w paramAnonymousw)
      {
        List localList1 = (List)paramMap1.get(paramAnonymousb);
        List localList2 = (List)paramMap2.get(paramAnonymousb);
        if (localList1 != null)
        {
          paramAnonymousSet1.addAll(localList1);
          paramAnonymousw.vQ().b(localList1, localList2);
        }
        paramAnonymousSet1 = (List)paramMap3.get(paramAnonymousb);
        paramAnonymousb = (List)paramMap4.get(paramAnonymousb);
        if (paramAnonymousSet1 != null)
        {
          paramAnonymousSet2.addAll(paramAnonymousSet1);
          paramAnonymousw.vR().b(paramAnonymousSet1, paramAnonymousb);
        }
      }
    }, paramx);
  }
  
  s<Set<cr.a>> a(Set<cr.b> paramSet, x paramx)
  {
    a(paramSet, new HashSet(), new a()
    {
      public void a(cr.b paramAnonymousb, Set<cr.a> paramAnonymousSet1, Set<cr.a> paramAnonymousSet2, w paramAnonymousw)
      {
        paramAnonymousSet1.addAll(paramAnonymousb.we());
        paramAnonymousSet2.addAll(paramAnonymousb.wf());
        paramAnonymousw.vS().b(paramAnonymousb.we(), paramAnonymousb.wh());
        paramAnonymousw.vT().b(paramAnonymousb.wf(), paramAnonymousb.wi());
      }
    }, paramx);
  }
  
  public void bl(String paramString)
  {
    try
    {
      bs(paramString);
      paramString = this.Xo.bo(paramString);
      ah localah = paramString.vH();
      Iterator localIterator = ((Set)a(this.Xu, localah.vN()).getObject()).iterator();
      while (localIterator.hasNext())
      {
        cr.a locala = (cr.a)localIterator.next();
        a(this.Xp, locala, new HashSet(), localah.wA());
      }
      paramString.vI();
    }
    finally {}
    bs(null);
  }
  
  void bs(String paramString)
  {
    try
    {
      this.Xw = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  static abstract interface a
  {
    public abstract void a(cr.b paramb, Set<cr.a> paramSet1, Set<cr.a> paramSet2, w paramw);
  }
  
  private static class b
  {
    private s<cc.a> XD;
    private cc.a Xe;
    
    public b(s<cc.a> params, cc.a parama)
    {
      this.XD = params;
      this.Xe = parama;
    }
    
    public cc.a wb()
    {
      return this.Xe;
    }
    
    public s<cc.a> wl()
    {
      return this.XD;
    }
  }
  
  private static class c
  {
    private final Map<cr.b, List<cr.a>> XE = new HashMap();
    private final Map<cr.b, List<cr.a>> XI = new HashMap();
    private final Map<cr.b, List<String>> XJ = new HashMap();
    private final Map<cr.b, List<String>> XK = new HashMap();
    private cr.a XL;
    private final Set<cr.b> Xu = new HashSet();
    
    public Set<cr.b> wm()
    {
      return this.Xu;
    }
    
    public Map<cr.b, List<cr.a>> wn()
    {
      return this.XE;
    }
    
    public Map<cr.b, List<String>> wo()
    {
      return this.XJ;
    }
    
    public Map<cr.b, List<String>> wp()
    {
      return this.XK;
    }
    
    public Map<cr.b, List<cr.a>> wq()
    {
      return this.XI;
    }
    
    public cr.a wr()
    {
      return this.XL;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/tagmanager/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */