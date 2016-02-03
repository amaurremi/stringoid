package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class w
  extends dg
{
  private static final String ID = a.ah.toString();
  private static final String VALUE = b.ff.toString();
  private static final String aoP = b.bS.toString();
  private final DataLayer anS;
  
  public w(DataLayer paramDataLayer)
  {
    super(ID, new String[] { VALUE });
    this.anS = paramDataLayer;
  }
  
  private void a(d.a parama)
  {
    if ((parama == null) || (parama == di.pC())) {}
    do
    {
      return;
      parama = di.j(parama);
    } while (parama == di.pH());
    this.anS.cs(parama);
  }
  
  private void b(d.a parama)
  {
    if ((parama == null) || (parama == di.pC())) {}
    for (;;)
    {
      return;
      parama = di.o(parama);
      if ((parama instanceof List))
      {
        parama = ((List)parama).iterator();
        while (parama.hasNext())
        {
          Object localObject = parama.next();
          if ((localObject instanceof Map))
          {
            localObject = (Map)localObject;
            this.anS.push((Map)localObject);
          }
        }
      }
    }
  }
  
  public void E(Map<String, d.a> paramMap)
  {
    b((d.a)paramMap.get(VALUE));
    a((d.a)paramMap.get(aoP));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */