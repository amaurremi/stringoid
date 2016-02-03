package com.appbrain.b;

import java.util.Collection;
import java.util.Iterator;

public abstract class b
  implements u
{
  private static void a(Iterable paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      if (paramIterable.next() == null) {
        throw new NullPointerException();
      }
    }
  }
  
  protected static void a(Iterable paramIterable, Collection paramCollection)
  {
    if ((paramIterable instanceof q))
    {
      a(((q)paramIterable).a());
      if (!(paramIterable instanceof Collection)) {
        break label45;
      }
      paramCollection.addAll((Collection)paramIterable);
    }
    for (;;)
    {
      return;
      a(paramIterable);
      break;
      label45:
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        paramCollection.add(paramIterable.next());
      }
    }
  }
  
  public abstract b a();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */