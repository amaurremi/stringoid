package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class ef
  extends dc
{
  private static final String a = a.af.toString();
  private static final String b = b.ew.toString();
  private static final String c = b.bD.toString();
  private final DataLayer d;
  
  public ef(DataLayer paramDataLayer)
  {
    super(a, new String[] { b });
    this.d = paramDataLayer;
  }
  
  private void a(d.a parama)
  {
    if ((parama == null) || (parama == de.a())) {}
    do
    {
      return;
      parama = de.a(parama);
    } while (parama == de.f());
    this.d.bN(parama);
  }
  
  private void b(d.a parama)
  {
    if ((parama == null) || (parama == de.a())) {}
    for (;;)
    {
      return;
      parama = de.f(parama);
      if ((parama instanceof List))
      {
        parama = ((List)parama).iterator();
        while (parama.hasNext())
        {
          Object localObject = parama.next();
          if ((localObject instanceof Map))
          {
            localObject = (Map)localObject;
            this.d.push((Map)localObject);
          }
        }
      }
    }
  }
  
  public void b(Map<String, d.a> paramMap)
  {
    b((d.a)paramMap.get(b));
    a((d.a)paramMap.get(c));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/ef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */