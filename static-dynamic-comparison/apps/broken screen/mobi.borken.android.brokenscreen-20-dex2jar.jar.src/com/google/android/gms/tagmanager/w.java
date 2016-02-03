package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class w
  extends df
{
  private static final String ID = a.af.toString();
  private static final String VALUE = b.ew.toString();
  private static final String afq = b.bD.toString();
  private final DataLayer aer;
  
  public w(DataLayer paramDataLayer)
  {
    super(ID, new String[] { VALUE });
    this.aer = paramDataLayer;
  }
  
  private void a(d.a parama)
  {
    if ((parama == null) || (parama == dh.mS())) {}
    do
    {
      return;
      parama = dh.j(parama);
    } while (parama == dh.mX());
    this.aer.bN(parama);
  }
  
  private void b(d.a parama)
  {
    if ((parama == null) || (parama == dh.mS())) {}
    for (;;)
    {
      return;
      parama = dh.o(parama);
      if ((parama instanceof List))
      {
        parama = ((List)parama).iterator();
        while (parama.hasNext())
        {
          Object localObject = parama.next();
          if ((localObject instanceof Map))
          {
            localObject = (Map)localObject;
            this.aer.push((Map)localObject);
          }
        }
      }
    }
  }
  
  public void y(Map<String, d.a> paramMap)
  {
    b((d.a)paramMap.get(VALUE));
    a((d.a)paramMap.get(afq));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */