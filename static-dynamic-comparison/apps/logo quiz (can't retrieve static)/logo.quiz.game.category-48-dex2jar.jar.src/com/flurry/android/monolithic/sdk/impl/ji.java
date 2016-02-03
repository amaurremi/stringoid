package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class ji
{
  static final op a = new op();
  static final rk b = new rk(a);
  static final Map<String, kj> e;
  private static final Set<String> g;
  private static final Set<String> h;
  private static final ThreadLocal<Set> i;
  private static final ThreadLocal<Map> j;
  private static ThreadLocal<Boolean> k = new jl();
  kf c = new kf(g);
  int d = Integer.MIN_VALUE;
  private final kj f;
  
  static
  {
    a.a(ox.b);
    a.a(b);
    g = new HashSet();
    Collections.addAll(g, new String[] { "doc", "fields", "items", "name", "namespace", "size", "symbols", "values", "type" });
    h = new HashSet();
    Collections.addAll(h, new String[] { "default", "doc", "name", "order", "type" });
    i = new jj();
    j = new jk();
    e = new HashMap();
    e.put("string", kj.g);
    e.put("bytes", kj.h);
    e.put("int", kj.i);
    e.put("long", kj.j);
    e.put("float", kj.k);
    e.put("double", kj.l);
    e.put("boolean", kj.m);
    e.put("null", kj.n);
  }
  
  ji(kj paramkj)
  {
    this.f = paramkj;
  }
  
  public static ji a(ji paramji)
  {
    return new jn(paramji);
  }
  
  public static ji a(ji paramji1, ji paramji2)
  {
    if (paramji1 == paramji2) {}
    IdentityHashMap localIdentityHashMap;
    HashMap localHashMap1;
    HashMap localHashMap2;
    do
    {
      return paramji1;
      localIdentityHashMap = new IdentityHashMap(1);
      localHashMap1 = new HashMap(1);
      localHashMap2 = new HashMap(1);
      b(paramji2, localIdentityHashMap, localHashMap1, localHashMap2);
    } while ((localHashMap1.size() == 0) && (localHashMap2.size() == 0));
    localIdentityHashMap.clear();
    return a(paramji1, localIdentityHashMap, localHashMap1, localHashMap2);
  }
  
  private static ji a(ji paramji, Map<ji, ji> paramMap, Map<ka, ka> paramMap1, Map<ka, Map<String, String>> paramMap2)
  {
    if ((paramji instanceof kb)) {}
    for (Object localObject1 = ((kb)paramji).f;; localObject1 = null) {
      switch (jm.a[paramji.a().ordinal()])
      {
      default: 
        paramMap = paramji;
        label66:
        if (paramMap != paramji) {
          paramMap.c.putAll(paramji.c);
        }
        return paramMap;
      }
    }
    if (paramMap.containsKey(paramji)) {
      return (ji)paramMap.get(paramji);
    }
    if (paramMap1.containsKey(localObject1)) {
      localObject1 = (ka)paramMap1.get(localObject1);
    }
    for (;;)
    {
      Object localObject2 = a(ka.a((ka)localObject1), paramji.e(), null, paramji.h());
      paramMap.put(paramji, localObject2);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramji.b().iterator();
      while (localIterator.hasNext())
      {
        js localjs = (js)localIterator.next();
        Object localObject3 = a(js.d(localjs), paramMap, paramMap1, paramMap2);
        localObject3 = new js(a((ka)localObject1, js.e(localjs), paramMap2), (ji)localObject3, js.f(localjs), js.g(localjs), js.h(localjs));
        js.c((js)localObject3).putAll(js.c(localjs));
        localArrayList.add(localObject3);
      }
      ((ji)localObject2).b(localArrayList);
      paramMap = (Map<ji, ji>)localObject2;
      break label66;
      if (!paramMap1.containsKey(localObject1)) {
        break;
      }
      paramMap = a(ka.a((ka)paramMap1.get(localObject1)), paramji.e(), null, paramji.c());
      break label66;
      paramMap = a(paramji.i(), paramMap, paramMap1, paramMap2);
      if (paramMap == paramji.i()) {
        break;
      }
      paramMap = a(paramMap);
      break label66;
      paramMap = a(paramji.j(), paramMap, paramMap1, paramMap2);
      if (paramMap == paramji.j()) {
        break;
      }
      paramMap = b(paramMap);
      break label66;
      localObject1 = new ArrayList();
      localObject2 = paramji.k().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add(a((ji)((Iterator)localObject2).next(), paramMap, paramMap1, paramMap2));
      }
      paramMap = a((List)localObject1);
      break label66;
      if (!paramMap1.containsKey(localObject1)) {
        break;
      }
      paramMap = a(ka.a((ka)paramMap1.get(localObject1)), paramji.e(), null, paramji.l());
      break label66;
    }
  }
  
  public static ji a(kj paramkj)
  {
    switch (jm.a[paramkj.ordinal()])
    {
    default: 
      throw new jg("Can't create a: " + paramkj);
    case 1: 
      return new ki();
    case 2: 
      return new jp();
    case 3: 
      return new jw();
    case 4: 
      return new jy();
    case 5: 
      return new jv();
    case 6: 
      return new jq();
    case 7: 
      return new jo();
    }
    return new kd();
  }
  
  static ji a(ou paramou, kc paramkc)
  {
    Object localObject3 = null;
    Object localObject1;
    Object localObject5;
    Object localObject2;
    Object localObject4;
    if (paramou.e())
    {
      localObject1 = paramkc.a(paramou.h());
      paramkc = (kc)localObject1;
      if (localObject1 == null) {
        throw new kl("Undefined name: " + paramou);
      }
    }
    else if (paramou.b())
    {
      localObject5 = a(paramou, "type", "No type");
      if ((!((String)localObject5).equals("record")) && (!((String)localObject5).equals("error")) && (!((String)localObject5).equals("enum")) && (!((String)localObject5).equals("fixed"))) {
        break label1357;
      }
      localObject3 = a(paramou, "namespace");
      localObject1 = a(paramou, "doc");
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = paramkc.a();
      }
      localObject2 = new ka(a(paramou, "name", "No name in schema"), (String)localObject2);
      if (ka.c((ka)localObject2) == null) {
        break label1343;
      }
      localObject4 = paramkc.a();
      paramkc.a(ka.c((ka)localObject2));
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject4;
    }
    for (;;)
    {
      if (e.containsKey(localObject5)) {
        localObject1 = a((kj)e.get(localObject5));
      }
      for (;;)
      {
        localObject3 = paramou.q();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          localObject5 = paramou.a((String)localObject4).h();
          if ((!g.contains(localObject4)) && (localObject5 != null)) {
            ((ji)localObject1).a((String)localObject4, (String)localObject5);
          }
        }
        if ((((String)localObject5).equals("record")) || (((String)localObject5).equals("error")))
        {
          ArrayList localArrayList = new ArrayList();
          localObject4 = new kg((ka)localObject1, (String)localObject3, ((String)localObject5).equals("error"));
          if (localObject1 != null) {
            paramkc.a((ji)localObject4);
          }
          localObject1 = paramou.a("fields");
          if ((localObject1 == null) || (!((ou)localObject1).a())) {
            throw new kl("Record has no fields: " + paramou);
          }
          Iterator localIterator = ((ou)localObject1).iterator();
          while (localIterator.hasNext())
          {
            ou localou = (ou)localIterator.next();
            String str1 = a(localou, "name", "No field name");
            String str2 = a(localou, "doc");
            localObject1 = localou.a("type");
            if (localObject1 == null) {
              throw new kl("No field type: " + localou);
            }
            if ((((ou)localObject1).e()) && (paramkc.a(((ou)localObject1).h()) == null)) {
              throw new kl(localObject1 + " is not a defined name." + " The type of the \"" + str1 + "\" field must be" + " a defined name or a {\"type\": ...} expression.");
            }
            ji localji = a((ou)localObject1, paramkc);
            localObject1 = jt.a;
            localObject3 = localou.a("order");
            if (localObject3 != null) {
              localObject1 = jt.valueOf(((ou)localObject3).h().toUpperCase());
            }
            localObject5 = localou.a("default");
            localObject3 = localObject5;
            if (localObject5 != null) {
              if (!kj.k.equals(localji.a()))
              {
                localObject3 = localObject5;
                if (!kj.l.equals(localji.a())) {}
              }
              else
              {
                localObject3 = localObject5;
                if (((ou)localObject5).e()) {
                  localObject3 = new aex(Double.valueOf(((ou)localObject5).h()).doubleValue());
                }
              }
            }
            localObject1 = new js(str1, localji, str2, (ou)localObject3, (jt)localObject1);
            localObject3 = localou.q();
            while (((Iterator)localObject3).hasNext())
            {
              localObject5 = (String)((Iterator)localObject3).next();
              str1 = localou.a((String)localObject5).h();
              if ((!h.contains(localObject5)) && (str1 != null)) {
                ((js)localObject1).a((String)localObject5, str1);
              }
            }
            js.a((js)localObject1, a(localou));
            localArrayList.add(localObject1);
          }
          ((ji)localObject4).b(localArrayList);
          localObject1 = localObject4;
        }
        else if (((String)localObject5).equals("enum"))
        {
          localObject5 = paramou.a("symbols");
          if ((localObject5 == null) || (!((ou)localObject5).a())) {
            throw new kl("Enum has no symbols: " + paramou);
          }
          localObject4 = new jx();
          localObject5 = ((ou)localObject5).iterator();
          while (((Iterator)localObject5).hasNext()) {
            ((jx)localObject4).add(((ou)((Iterator)localObject5).next()).h());
          }
          localObject3 = new jr((ka)localObject1, (String)localObject3, (jx)localObject4);
          if (localObject1 != null) {
            paramkc.a((ji)localObject3);
          }
          localObject1 = localObject3;
        }
        else if (((String)localObject5).equals("array"))
        {
          localObject1 = paramou.a("items");
          if (localObject1 == null) {
            throw new kl("Array has no items type: " + paramou);
          }
          localObject1 = new jn(a((ou)localObject1, paramkc));
        }
        else if (((String)localObject5).equals("map"))
        {
          localObject1 = paramou.a("values");
          if (localObject1 == null) {
            throw new kl("Map has no values type: " + paramou);
          }
          localObject1 = new jz(a((ou)localObject1, paramkc));
        }
        else
        {
          if (!((String)localObject5).equals("fixed")) {
            break;
          }
          localObject4 = paramou.a("size");
          if ((localObject4 == null) || (!((ou)localObject4).d())) {
            throw new kl("Invalid or no size: " + paramou);
          }
          localObject3 = new ju((ka)localObject1, (String)localObject3, ((ou)localObject4).j());
          if (localObject1 != null) {
            paramkc.a((ji)localObject3);
          }
          localObject1 = localObject3;
        }
      }
      throw new kl("Type not supported: " + (String)localObject5);
      if (localObject2 != null) {
        paramkc.a((String)localObject2);
      }
      paramkc = (kc)localObject1;
      if ((localObject1 instanceof kb))
      {
        paramou = a(paramou);
        paramkc = (kc)localObject1;
        if (paramou != null)
        {
          paramou = paramou.iterator();
          for (;;)
          {
            paramkc = (kc)localObject1;
            if (!paramou.hasNext()) {
              break;
            }
            ((ji)localObject1).d((String)paramou.next());
          }
          if (!paramou.a()) {
            break label1315;
          }
          localObject1 = new jx(paramou.o());
          paramou = paramou.iterator();
          while (paramou.hasNext()) {
            ((jx)localObject1).add(a((ou)paramou.next(), paramkc));
          }
          paramkc = new kk((jx)localObject1);
        }
      }
      return paramkc;
      label1315:
      throw new kl("Schema not yet supported: " + paramou);
      label1343:
      localObject4 = null;
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject4;
      continue;
      label1357:
      localObject2 = null;
      localObject1 = null;
    }
  }
  
  public static ji a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    return new ju(new ka(paramString1, paramString3), paramString2, paramInt);
  }
  
  public static ji a(String paramString1, String paramString2, String paramString3, List<String> paramList)
  {
    return new jr(new ka(paramString1, paramString3), paramString2, new jx(paramList));
  }
  
  public static ji a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    return new kg(new ka(paramString1, paramString3), paramString2, paramBoolean);
  }
  
  public static ji a(List<ji> paramList)
  {
    return new kk(new jx(paramList));
  }
  
  private static String a(ka paramka, String paramString, Map<ka, Map<String, String>> paramMap)
  {
    paramka = (Map)paramMap.get(paramka);
    if (paramka == null) {}
    do
    {
      return paramString;
      paramka = (String)paramka.get(paramString);
    } while (paramka == null);
    return paramka;
  }
  
  private static String a(ou paramou, String paramString)
  {
    paramou = paramou.a(paramString);
    if (paramou != null) {
      return paramou.h();
    }
    return null;
  }
  
  private static String a(ou paramou, String paramString1, String paramString2)
  {
    paramString1 = a(paramou, paramString1);
    if (paramString1 == null) {
      throw new kl(paramString2 + ": " + paramou);
    }
    return paramString1;
  }
  
  private static Set<String> a(ou paramou)
  {
    Object localObject = paramou.a("aliases");
    if (localObject == null) {
      return null;
    }
    if (!((ou)localObject).a()) {
      throw new kl("aliases not an array: " + paramou);
    }
    paramou = new LinkedHashSet();
    localObject = ((ou)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ou localou = (ou)((Iterator)localObject).next();
      if (!localou.e()) {
        throw new kl("alias not a string: " + localou);
      }
      paramou.add(localou.h());
    }
    return paramou;
  }
  
  public static ji b(ji paramji)
  {
    return new jz(paramji);
  }
  
  private static void b(ji paramji, Map<ji, ji> paramMap, Map<ka, ka> paramMap1, Map<ka, Map<String, String>> paramMap2)
  {
    Object localObject1;
    Object localObject2;
    if ((paramji instanceof kb))
    {
      localObject1 = (kb)paramji;
      if (((kb)localObject1).h != null)
      {
        localObject2 = ((kb)localObject1).h.iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramMap1.put((ka)((Iterator)localObject2).next(), ((kb)localObject1).f);
        }
      }
    }
    switch (jm.a[paramji.a().ordinal()])
    {
    }
    for (;;)
    {
      return;
      if (!paramMap.containsKey(paramji))
      {
        paramMap.put(paramji, paramji);
        localObject2 = (kg)paramji;
        Iterator localIterator1 = paramji.b().iterator();
        while (localIterator1.hasNext())
        {
          js localjs = (js)localIterator1.next();
          if (js.b(localjs) != null)
          {
            Iterator localIterator2 = js.b(localjs).iterator();
            while (localIterator2.hasNext())
            {
              String str = (String)localIterator2.next();
              localObject1 = (Map)paramMap2.get(((kg)localObject2).f);
              paramji = (ji)localObject1;
              if (localObject1 == null)
              {
                localObject1 = ((kg)localObject2).f;
                paramji = new HashMap();
                paramMap2.put(localObject1, paramji);
              }
              paramji.put(str, js.e(localjs));
            }
          }
          b(js.d(localjs), paramMap, paramMap1, paramMap2);
        }
        if ((((kg)localObject2).h != null) && (paramMap2.containsKey(((kg)localObject2).f)))
        {
          paramji = ((kg)localObject2).h.iterator();
          while (paramji.hasNext()) {
            paramMap2.put((ka)paramji.next(), paramMap2.get(((kg)localObject2).f));
          }
          continue;
          b(paramji.i(), paramMap, paramMap1, paramMap2);
          return;
          b(paramji.j(), paramMap, paramMap1, paramMap2);
          return;
          paramji = paramji.k().iterator();
          while (paramji.hasNext()) {
            b((ji)paramji.next(), paramMap, paramMap1, paramMap2);
          }
        }
      }
    }
  }
  
  public static ji f(String paramString)
  {
    return new ke().a(paramString);
  }
  
  private static String h(String paramString)
  {
    if (!((Boolean)k.get()).booleanValue()) {}
    for (;;)
    {
      return paramString;
      int n = paramString.length();
      if (n == 0) {
        throw new kl("Empty name");
      }
      char c1 = paramString.charAt(0);
      if ((!Character.isLetter(c1)) && (c1 != '_')) {
        throw new kl("Illegal initial character: " + paramString);
      }
      int m = 1;
      while (m < n)
      {
        c1 = paramString.charAt(m);
        if ((!Character.isLetterOrDigit(c1)) && (c1 != '_')) {
          throw new kl("Illegal character in: " + paramString);
        }
        m += 1;
      }
    }
  }
  
  public kj a()
  {
    return this.f;
  }
  
  public String a(String paramString)
  {
    try
    {
      paramString = (String)this.c.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public String a(boolean paramBoolean)
  {
    try
    {
      Object localObject = new StringWriter();
      or localor = a.a((Writer)localObject);
      if (paramBoolean) {
        localor.a();
      }
      a(new kc(), localor);
      localor.g();
      localObject = ((StringWriter)localObject).toString();
      return (String)localObject;
    }
    catch (IOException localIOException)
    {
      throw new jg(localIOException);
    }
  }
  
  void a(kc paramkc, or paramor)
    throws IOException
  {
    if (this.c.size() == 0)
    {
      paramor.b(d());
      return;
    }
    paramor.d();
    paramor.a("type", d());
    this.c.a(paramor);
    paramor.e();
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      this.c.a(paramString1, paramString2);
      this.d = Integer.MIN_VALUE;
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public js b(String paramString)
  {
    throw new jg("Not a record: " + this);
  }
  
  public List<js> b()
  {
    throw new jg("Not a record: " + this);
  }
  
  void b(kc paramkc, or paramor)
    throws IOException
  {
    throw new jg("Not a record: " + this);
  }
  
  public void b(List<js> paramList)
  {
    throw new jg("Not a record: " + this);
  }
  
  public int c(String paramString)
  {
    throw new jg("Not an enum: " + this);
  }
  
  public List<String> c()
  {
    throw new jg("Not an enum: " + this);
  }
  
  final boolean c(ji paramji)
  {
    return (this.d == paramji.d) || (this.d == Integer.MIN_VALUE) || (paramji.d == Integer.MIN_VALUE);
  }
  
  public String d()
  {
    return kj.a(this.f);
  }
  
  public void d(String paramString)
  {
    throw new jg("Not a named type: " + this);
  }
  
  public Integer e(String paramString)
  {
    throw new jg("Not a union: " + this);
  }
  
  public String e()
  {
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof ji)) {
        return false;
      }
      paramObject = (ji)paramObject;
      if (this.f != ((ji)paramObject).f) {
        return false;
      }
    } while ((c((ji)paramObject)) && (this.c.equals(((ji)paramObject).c)));
    return false;
  }
  
  public String f()
  {
    throw new jg("Not a named type: " + this);
  }
  
  public String g()
  {
    return d();
  }
  
  public boolean h()
  {
    throw new jg("Not a record: " + this);
  }
  
  public final int hashCode()
  {
    if (this.d == Integer.MIN_VALUE) {
      this.d = m();
    }
    return this.d;
  }
  
  public ji i()
  {
    throw new jg("Not an array: " + this);
  }
  
  public ji j()
  {
    throw new jg("Not a map: " + this);
  }
  
  public List<ji> k()
  {
    throw new jg("Not a union: " + this);
  }
  
  public int l()
  {
    throw new jg("Not fixed: " + this);
  }
  
  int m()
  {
    return a().hashCode() + this.c.hashCode();
  }
  
  public String toString()
  {
    return a(false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */