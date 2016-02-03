package com.jirbo.adcolony;

import java.util.ArrayList;

class n$d
{
  ArrayList<n.a> a = new ArrayList();
  
  int a()
  {
    return this.a.size();
  }
  
  n.a a(int paramInt)
  {
    return (n.a)this.a.get(paramInt);
  }
  
  n.a a(String paramString)
  {
    int i = 0;
    while (i < this.a.size())
    {
      n.a locala = (n.a)this.a.get(i);
      if (locala.a.equals(paramString)) {
        return locala;
      }
      i += 1;
    }
    return null;
  }
  
  void a(n.a parama)
  {
    this.a.add(parama);
  }
  
  boolean a(ADCData.c paramc)
  {
    if (paramc == null) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramc.i()) {
        break label52;
      }
      n.a locala = new n.a();
      if (!locala.a(paramc.b(i))) {
        break;
      }
      this.a.add(locala);
      i += 1;
    }
    label52:
    return true;
  }
  
  n.a b()
  {
    return (n.a)this.a.get(0);
  }
  
  n.a b(int paramInt)
  {
    Object localObject;
    while (paramInt < this.a.size())
    {
      localObject = (n.a)this.a.get(paramInt);
      if (((n.a)localObject).w.a) {
        return (n.a)localObject;
      }
      paramInt += 1;
    }
    paramInt = 0;
    for (;;)
    {
      if (paramInt >= this.a.size()) {
        break label86;
      }
      n.a locala = (n.a)this.a.get(paramInt);
      localObject = locala;
      if (locala.w.a) {
        break;
      }
      paramInt += 1;
    }
    label86:
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/n$d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */