package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class cq$d
{
  private String aeU = "";
  private final List<cq.e> agZ = new ArrayList();
  private final Map<String, List<cq.a>> aha = new HashMap();
  private int ahb = 0;
  
  public d a(cq.a parama)
  {
    String str = de.a((d.a)parama.mo().get(b.cI.toString()));
    List localList = (List)this.aha.get(str);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.aha.put(str, localObject);
    }
    ((List)localObject).add(parama);
    return this;
  }
  
  public d a(cq.e parame)
  {
    this.agZ.add(parame);
    return this;
  }
  
  public d ce(String paramString)
  {
    this.aeU = paramString;
    return this;
  }
  
  public d du(int paramInt)
  {
    this.ahb = paramInt;
    return this;
  }
  
  public cq.c mu()
  {
    return new cq.c(this.agZ, this.aha, this.aeU, this.ahb, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/cq$d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */