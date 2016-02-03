package com.jirbo.adcolony;

import java.util.ArrayList;

class ah
{
  d a;
  boolean b = false;
  ArrayList<ag> c = new ArrayList();
  
  ah(d paramd)
  {
    this.a = paramd;
  }
  
  ag a(int paramInt)
  {
    return (ag)this.c.get(paramInt);
  }
  
  ag a(String paramString)
  {
    int j = this.c.size();
    int i = 0;
    while (i < j)
    {
      ag localag = (ag)this.c.get(i);
      if (localag.a.equals(paramString)) {
        return localag;
      }
      i += 1;
    }
    this.b = true;
    paramString = new ag(paramString);
    this.c.add(paramString);
    return paramString;
  }
  
  void a()
  {
    int j = 0;
    Object localObject = k.c(new f("zone_state.txt"));
    if (localObject != null)
    {
      this.c.clear();
      i = 0;
      while (i < ((ADCData.c)localObject).i())
      {
        ADCData.g localg = ((ADCData.c)localObject).b(i);
        ag localag = new ag();
        if (localag.a(localg)) {
          this.c.add(localag);
        }
        i += 1;
      }
    }
    localObject = this.a.a.k;
    int k = localObject.length;
    int i = j;
    while (i < k)
    {
      a(localObject[i]);
      i += 1;
    }
  }
  
  void b()
  {
    int i = 0;
    l.a.b("Saving zone state...");
    this.b = false;
    ADCData.c localc = new ADCData.c();
    String[] arrayOfString = this.a.a.k;
    int j = arrayOfString.length;
    while (i < j)
    {
      localc.a(a(arrayOfString[i]).a());
      i += 1;
    }
    k.a(new f("zone_state.txt"), localc);
    l.a.b("Saved zone state");
  }
  
  int c()
  {
    return this.c.size();
  }
  
  void d()
  {
    if (this.b) {
      b();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */