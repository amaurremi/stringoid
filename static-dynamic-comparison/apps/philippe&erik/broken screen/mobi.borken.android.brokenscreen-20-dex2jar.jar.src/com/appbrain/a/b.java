package com.appbrain.a;

import android.content.Context;
import com.appbrain.b.m.a;
import com.appbrain.e.h.a;
import com.appbrain.e.j.f.a;
import com.appbrain.e.j.k.a;
import com.appbrain.e.j.m.a;

public final class b
  extends cl
{
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void a(m.a parama, h.a parama1)
  {
    if ((parama instanceof j.m.a))
    {
      ((j.m.a)parama).a(parama1);
      return;
    }
    if ((parama instanceof j.k.a))
    {
      ((j.k.a)parama).a(parama1);
      return;
    }
    if ((parama instanceof j.f.a))
    {
      ((j.f.a)parama).a(parama1);
      return;
    }
    throw new IllegalArgumentException("Unknown builder type.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */