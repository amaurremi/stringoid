package com.jirbo.adcolony;

import java.util.ArrayList;
import java.util.HashMap;

class n$u
{
  ArrayList<String> a = new ArrayList();
  ArrayList<String> b = new ArrayList();
  ArrayList<String> c = new ArrayList();
  HashMap<String, ArrayList<String>> d = new HashMap();
  
  boolean a(ADCData.g paramg)
  {
    if (paramg == null) {}
    do
    {
      ArrayList localArrayList;
      do
      {
        do
        {
          return false;
          localArrayList = paramg.d("update");
          this.a = localArrayList;
        } while (localArrayList == null);
        localArrayList = paramg.d("install");
        this.b = localArrayList;
      } while (localArrayList == null);
      paramg = paramg.d("session_start");
      this.c = paramg;
    } while (paramg == null);
    paramg = new ArrayList();
    paramg.add(this.a);
    paramg.add(this.b);
    paramg.add(this.c);
    int i = 0;
    while (i < paramg.size())
    {
      int j = 0;
      while (j < ((ArrayList)paramg.get(i)).size())
      {
        a.V.add(((ArrayList)paramg.get(i)).get(j));
        j += 1;
      }
      i += 1;
    }
    this.d.put("update", this.a);
    this.d.put("install", this.b);
    this.d.put("session_start", this.c);
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/n$u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */