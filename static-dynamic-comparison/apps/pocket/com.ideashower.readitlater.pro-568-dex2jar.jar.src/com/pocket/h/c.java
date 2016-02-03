package com.pocket.h;

import android.content.Context;
import com.android.a.b;
import com.android.ex.chips.aa;
import com.android.ex.chips.n;
import com.ideashower.readitlater.a.o;
import com.ideashower.readitlater.db.operation.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class c
  extends b
{
  private n a;
  
  public c(Context paramContext, n paramn)
  {
    super(paramContext);
    this.a = paramn;
  }
  
  public void a(CharSequence paramCharSequence, LinkedHashMap paramLinkedHashMap, List paramList, Set paramSet)
  {
    paramList = o.c().e();
    paramCharSequence = o.c().a(paramCharSequence);
    Object localObject = this.a.getEntries();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        f localf = ((aa)((Iterator)localObject).next()).i();
        if (localf != null) {
          paramCharSequence.remove(localf);
        }
      }
    }
    Collections.sort(paramCharSequence, o.a);
    paramCharSequence = paramCharSequence.iterator();
    while (paramCharSequence.hasNext())
    {
      localObject = (f)paramCharSequence.next();
      if ((localObject != paramList) && (((f)localObject).b() != 796)) {
        a((f)localObject, paramLinkedHashMap, paramSet);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/h/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */