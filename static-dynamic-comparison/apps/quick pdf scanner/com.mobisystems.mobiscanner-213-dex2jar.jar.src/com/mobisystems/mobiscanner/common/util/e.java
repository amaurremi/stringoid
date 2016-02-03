package com.mobisystems.mobiscanner.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class e
{
  Map<String, j> axo = new HashMap();
  Map<String, g> axp = new HashMap();
  
  void a(j paramj)
  {
    this.axo.put(paramj.DY(), paramj);
  }
  
  void b(g paramg)
  {
    this.axp.put(paramg.DY(), paramg);
  }
  
  public g dw(String paramString)
  {
    return (g)this.axp.get(paramString);
  }
  
  List<String> dx(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.axp.values().iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      if (localg.DW().equals(paramString)) {
        localArrayList.add(localg.DY());
      }
    }
    return localArrayList;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/common/util/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */