package com.jirbo.adcolony;

import java.util.ArrayList;

class n$ab
{
  ArrayList<n.y> a;
  
  int a()
  {
    return this.a.size();
  }
  
  n.y a(int paramInt)
  {
    return (n.y)this.a.get(paramInt);
  }
  
  n.y a(String paramString)
  {
    int i = 0;
    while (i < this.a.size())
    {
      n.y localy = (n.y)this.a.get(i);
      if (localy.a.equals(paramString)) {
        return localy;
      }
      i += 1;
    }
    l.a.a("No such zone: ").b(paramString);
    return null;
  }
  
  boolean a(ADCData.c paramc)
  {
    this.a = new ArrayList();
    if (paramc == null) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramc.i()) {
        break label63;
      }
      n.y localy = new n.y();
      if (!localy.a(paramc.b(i))) {
        break;
      }
      this.a.add(localy);
      i += 1;
    }
    label63:
    return true;
  }
  
  n.y b()
  {
    return (n.y)this.a.get(0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/n$ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */