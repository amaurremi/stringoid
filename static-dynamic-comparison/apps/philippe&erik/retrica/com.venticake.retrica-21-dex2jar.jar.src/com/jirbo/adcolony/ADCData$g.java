package com.jirbo.adcolony;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

class ADCData$g
  extends ADCData.i
  implements Serializable
{
  HashMap<String, ADCData.i> a = new HashMap();
  ArrayList<String> b = new ArrayList();
  
  double a(String paramString, double paramDouble)
  {
    paramString = (ADCData.i)this.a.get(paramString);
    double d = paramDouble;
    if (paramString != null)
    {
      d = paramDouble;
      if (paramString.p()) {
        d = paramString.d();
      }
    }
    return d;
  }
  
  int a(String paramString, int paramInt)
  {
    paramString = (ADCData.i)this.a.get(paramString);
    int i = paramInt;
    if (paramString != null)
    {
      i = paramInt;
      if (paramString.p()) {
        i = paramString.e();
      }
    }
    return i;
  }
  
  ADCData.c a(String paramString, ADCData.c paramc)
  {
    ADCData.i locali = (ADCData.i)this.a.get(paramString);
    paramString = paramc;
    if (locali != null)
    {
      paramString = paramc;
      if (locali.f()) {
        paramString = locali.h();
      }
    }
    return paramString;
  }
  
  g a(String paramString, g paramg)
  {
    ADCData.i locali = (ADCData.i)this.a.get(paramString);
    paramString = paramg;
    if (locali != null)
    {
      paramString = paramg;
      if (locali.m()) {
        paramString = locali.n();
      }
    }
    return paramString;
  }
  
  String a(int paramInt)
  {
    return (String)this.b.get(paramInt);
  }
  
  String a(String paramString1, String paramString2)
  {
    ADCData.i locali = (ADCData.i)this.a.get(paramString1);
    paramString1 = paramString2;
    if (locali != null)
    {
      paramString1 = paramString2;
      if (locali.k()) {
        paramString1 = locali.b();
      }
    }
    return paramString1;
  }
  
  ArrayList<String> a(String paramString, ArrayList<String> paramArrayList)
  {
    ADCData.c localc = c(paramString);
    if (localc == null) {
      return paramArrayList;
    }
    paramString = new ArrayList();
    int i = 0;
    for (;;)
    {
      paramArrayList = paramString;
      if (i >= localc.i()) {
        break;
      }
      paramArrayList = localc.d(i);
      if (paramArrayList != null) {
        paramString.add(paramArrayList);
      }
      i += 1;
    }
  }
  
  void a(af paramaf)
  {
    int k = this.b.size();
    if (k == 0)
    {
      paramaf.a("{}");
      return;
    }
    String str;
    ADCData.i locali;
    if ((k == 1) && (((ADCData.i)this.a.get(this.b.get(0))).g()))
    {
      paramaf.a("{");
      str = (String)this.b.get(0);
      locali = (ADCData.i)this.a.get(str);
      a(paramaf, str);
      paramaf.b(':');
      locali.a(paramaf);
      paramaf.a("}");
      return;
    }
    paramaf.b("{");
    paramaf.i += 2;
    int j = 0;
    int i = 1;
    if (j < k)
    {
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        str = (String)this.b.get(j);
        locali = (ADCData.i)this.a.get(str);
        a(paramaf, str);
        paramaf.b(':');
        if (!locali.g()) {
          paramaf.d();
        }
        locali.a(paramaf);
        j += 1;
        break;
        paramaf.c(',');
      }
    }
    paramaf.d();
    paramaf.i -= 2;
    paramaf.a("}");
  }
  
  void a(String paramString, ADCData.i parami)
  {
    if (!this.a.containsKey(paramString)) {
      this.b.add(paramString);
    }
    this.a.put(paramString, parami);
  }
  
  boolean a(String paramString)
  {
    return this.a.containsKey(paramString);
  }
  
  boolean a(String paramString, boolean paramBoolean)
  {
    paramString = (ADCData.i)this.a.get(paramString);
    boolean bool = paramBoolean;
    if (paramString != null) {
      if (!paramString.a())
      {
        bool = paramBoolean;
        if (!paramString.k()) {}
      }
      else
      {
        bool = paramString.l();
      }
    }
    return bool;
  }
  
  g b(String paramString)
  {
    paramString = a(paramString, null);
    if (paramString != null) {
      return paramString;
    }
    return new g();
  }
  
  void b(String paramString, double paramDouble)
  {
    a(paramString, new ADCData.e(paramDouble));
  }
  
  void b(String paramString, int paramInt)
  {
    a(paramString, new ADCData.b(paramInt));
  }
  
  void b(String paramString1, String paramString2)
  {
    a(paramString1, new ADCData.f(paramString2));
  }
  
  void b(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (ADCData.i locali = ADCData.a;; locali = ADCData.b)
    {
      a(paramString, locali);
      return;
    }
  }
  
  ADCData.c c(String paramString)
  {
    paramString = a(paramString, null);
    if (paramString != null) {
      return paramString;
    }
    return new ADCData.c();
  }
  
  ArrayList<String> d(String paramString)
  {
    ArrayList localArrayList = a(paramString, null);
    paramString = localArrayList;
    if (localArrayList == null) {
      paramString = new ArrayList();
    }
    return paramString;
  }
  
  String e(String paramString)
  {
    return a(paramString, "");
  }
  
  double f(String paramString)
  {
    return a(paramString, 0.0D);
  }
  
  int g(String paramString)
  {
    return a(paramString, 0);
  }
  
  boolean g()
  {
    return (this.a.size() < 0) || ((this.a.size() == 1) && (((ADCData.i)this.a.get(this.b.get(0))).g()));
  }
  
  boolean h(String paramString)
  {
    return a(paramString, false);
  }
  
  boolean m()
  {
    return true;
  }
  
  g n()
  {
    return this;
  }
  
  int o()
  {
    return this.b.size();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/ADCData$g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */